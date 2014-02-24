#remote_addr=192.168.0.107
remote_addr=motoranger.net
remote_user=spooky


server:
#	export GRAILS_OPTS="-XX:MaxPermSize=1024m -Xmx1024M -server"
	grails run-app

clean:
	grails clean

test-app:
	grails test-app


war:
	grails war

submoduleInstall:
	git submodule init
	git submodule update

remote-init:
	ssh -t ${remote_user}@${remote_addr} 'sudo mkdir -p /usr/share/tomcat7/.grails \
	&& sudo mkdir -p /usr/share/tomcat7/.grails/projects/motoranger/searchable-index/production/index/product \
	&& sudo chgrp -R tomcat7 /usr/share/tomcat7 \
	&& sudo chmod -R 770 /usr/share/tomcat7'

deploy-Config:
	scp ~/.grails/motoranger-config.groovy ${remote_user}@${remote_addr}:~/
	ssh -t ${remote_user}@${remote_addr} \
	'sudo cp motoranger-config.groovy /usr/share/tomcat7/.grails/ \
	&& sudo service tomcat7 restart'

dbinit:
	CREATE DATABASE motoranger DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
	create user 'motoranger'@'localhost' identified by 'mvagusta';
	grant all on *.* to 'motoranger'@'localhost';


done:
	make clean test-app war deploy

done-quick:
	make clean war deploy


update:
	git pull

done-local:
	make update clean test-app war deploy-local

done-local-quick:
	make update clean war deploy-local

deploy:
	scp target/motoranger.war ${remote_user}@${remote_addr}:~/ROOT.war
	ssh -t ${remote_user}@${remote_addr} \
	'cd ~/ \
	&& sudo rm -rf /var/lib/tomcat7/webapps/ROOT \
	&& sudo cp ROOT.war /var/lib/tomcat7/webapps/ \
	&& sudo cp motoranger-config.groovy /usr/share/tomcat7/.grails/ \
	&& sudo service tomcat7 restart'

deploy-local:
	cp target/motoranger.war ~/ROOT.war
	sudo rm -rf /var/lib/tomcat7/webapps/ROOT \
	&& sudo cp ~/ROOT.war /var/lib/tomcat7/webapps/ \
	&& sudo service tomcat7 restart

log:
	ssh -t ${remote_user}@${remote_addr} 'sudo tail -f /var/lib/tomcat7/logs/catalina.out'




syncdb:
	ssh -t ${remote_user}@${remote_addr} 'mysqldump --user=root -p motoranger > ~/backup/motoranger.sql'

recoverdb:
	mysql -u root -p motoranger < motoranger.sql


loglink:
	- mkdir ~/Library/Logs/motoranger
	- touch target/development.log
	- touch target/test.log
	- touch target/grails.log
	- touch target/root.log
	- touch target/stacktrace.log
	- ln ~/projects/motoranger/target/development.log ~/Library/Logs/motoranger/development.log
	- ln ~/projects/motoranger/target/grails.log ~/Library/Logs/motoranger/grails.log
	- ln ~/projects/motoranger/target/root.log ~/Library/Logs/motoranger/root.log
	- ln ~/projects/motoranger/target/stacktrace.log ~/Library/Logs/motoranger/stacktrace.log
	- ln ~/projects/motoranger/target/test.log ~/Library/Logs/motoranger/test.log

#dbCreate = "create" 必須使用實體 db ex:mysql
db-changelog-init:
	grails -Dgrails.env=dbdiff dbm-generate-gorm-changelog changelog.groovy 
	

#remove dbCreate = "create"
db-changelog-sync:
	grails dbm-changelog-sync
db-update:
	grails dbm-update
db-diff:
	grails dbm-gorm-diff 1.1.1.groovy -add

db-rollback:
	grails dbm-rollback-count 1

olddb-diff:
	grails dbm-diff dbToUpdate upgradeChangelog.groovy

clear-checksums:
	grails dbm-clear-checksums


db-done:
	grails dbm-gorm-diff 1.1.2.groovy -add
	grails dbm-update

db-done-remote:
	grails -Dgrails.env=motorangerDbUpdate dbm-update