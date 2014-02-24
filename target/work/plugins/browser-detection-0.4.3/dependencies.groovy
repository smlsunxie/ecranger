grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"

grails.project.dependency.resolution = {

    inherits("global") {
    }

	log "warn"

	repositories {
		grailsCentral()
    }

    dependencies {
    }

	plugins {
		build(":tomcat:$grailsVersion",
				":release:2.2.0") {
			export = false
		}
	}

}