// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

grails.config.locations = [ "classpath:${appName}-config.properties",
                            "classpath:${appName}-config.groovy",
                            "file:${userHome}/.grails/${appName}-config.properties",
                            "file:${userHome}/.grails/${appName}-config.groovy"]

if (System.properties["${appName}.config.location"]) {
   grails.config.locations << "file:" + System.properties["${appName}.config.location"]
}


grails.app.context = '/'
grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
 
grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {

    dbToUpdate {
        grails.plugin.databasemigration.changelogFileName = "upgradeChangelog.groovy"
    }
    
    development {
        grails.serverURL = "http://localhost:8080"
        grails.indexPath = "/development/app.html"
        grails.logging.jul.usebridge = true
        grails.resources.debug=true
        grails.converters.default.pretty.print = true

        grails.aws.root = 'test'
        google.analytics.enabled = false

        log4j = {
            appenders {
                file name: 'grailsfile', file: 'target/grails.log'
                file name: 'rootlog', file: 'target/root.log'
                file name: 'devfile', file: 'target/development.log'

                layout: pattern(conversionPattern: "[%d{HH:mm:ss:SSS}] %-5p %c{2} %m%n")
            }
            root { 
                error 'stdout', 'rootlog' 
            }
            info additivity: false, grailsfile: 'org.codehaus.groovy.grails.commons'
            all additivity: false, devfile: [
                'grails.app.controllers',
                'grails.app.domain',
                'grails.app.services',
                'grails.app.taglib',
                'grails.app.conf',
                'grails.app.filters',
                'grails.app.jobs'
            ]
        }
    }
 
    test {

        grails.serverURL = "http://localhost:8080"
        grails.indexPath = "/test/app.html"
        grails.logging.jul.usebridge = true
        grails.resources.debug=true
        grails.converters.default.pretty.print = true

        grails.foodpaint.service.server.url = "http://localhost:8180"
        grails.foodpaint.service.api.url = "http://localhost:8180/api"
        grails.aws.root = 'test'

        log4j = {
            appenders {
                file name: 'grailsfile', file: 'target/grails.log'
                file name: 'rootlog', file: 'target/root.log'
                file name: 'testfile', file: 'target/test.log'
                
                layout: pattern(conversionPattern: "[%d{HH:mm:ss:SSS}] %-5p %c{2} %m%n")
            }
            root { error 'stdout', 'rootlog' }
            info additivity: false, grailsfile: 'org.codehaus.groovy.grails.commons'
            all additivity: false, testfile: [
                'grails.app.controllers',
                'grails.app.domain',
                'grails.app.services',
                'grails.app.taglib',
                'grails.app.conf',
                'grails.app.filters'
            ]
     
        }
    }
    production {
        grails.logging.jul.usebridge = false
        grails.serverURL = "http://ecranger.net"
        //grails.serverURL = "http://dev.codecanaan.com:8080"

        // Using baseurl feature to enable CDN deployment
        grails.resources.mappers.baseurl.enabled = true
        grails.resources.mappers.baseurl.default = "http://cdn.ecranger.net/static"

        grails.aws.root = 'attachment'
        google.analytics.enabled = true


        log4j = {
            root { 
                error()
            }
        }
    }
}

// Analytics
google.analytics.webPropertyID = "UA-39903264-1"



// disqus
grails.plugins.disqus.shortname = "ecranger"


grails.taggable.preserve.case = true
grails.taggable.tag.autoImport=true
grails.taggable.tagLink.autoImport=true

aws.domain = ''
aws.accessKey = ''
aws.secretKey = ''
aws.bucketName = ''


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'ecranger.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'ecranger.UserRole'
grails.plugin.springsecurity.authority.className = 'ecranger.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
    '/j_spring_security_switch_user': ['ROLE_OPERATOR', 'ROLE_MANERGER', 'ROLE_ADMIN'],
    '/':                              ['permitAll'],
    '/index':                         ['permitAll'],
    '/index.gsp':                     ['permitAll'],
    '/**/**/**':                      ['permitAll'],
    // '/**/js/**':                      ['permitAll'],
    // '/**/css/**':                     ['permitAll'],
    // '/**/images/**':                  ['permitAll'],
    // '/**/pagedown/**':                ['permitAll'],
    // '/**/jquery-plugins/**':          ['permitAll'],
    // '/**/stylesheets/**':             ['permitAll'],
    // '/**/favicon.ico':                ['permitAll']
]


grails.plugin.springsecurity.useSwitchUserFilter = true
grails.plugin.springsecurity.rememberMe.alwaysRemember = true
grails.plugin.springsecurity.rememberMe.persistent = true
grails.plugin.springsecurity.rememberMe.persistentToken.domainClassName = 'ecranger.PersistentLogin'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/login/success'

