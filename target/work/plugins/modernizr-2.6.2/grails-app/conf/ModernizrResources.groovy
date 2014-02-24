// Resource declarations for Resources plugin
def modernizrVersion = modernizr.ModernizrConfig.SHIPPED_VERSION
def dev = grails.util.GrailsUtil.isDevelopmentEnv()
def modernizrFile = "modernizr-${modernizrVersion}${dev?'':'.min'}.js"


modules = {
    'modernizr' {
        resource id:'js', url:[plugin: 'modernizr', dir:'js/modernizr', file:modernizrFile], 
            disposition:'head', nominify: !dev
    }
}