def __bundleName = 'motoranger'

modules = {

    overrides {

        modernizr {
            defaultBundle __bundleName
        }

        "jquery-ui" {
            defaultBundle __bundleName
        }


    }
    
    'jquery-plugins' {
        dependsOn 'jquery'
        defaultBundle __bundleName
        
        resource url: 'jquery-plugins/jquery.migrate.min.js'
        resource url: 'jquery-plugins/jquery.textarea.js'
        resource url: 'jquery-plugins/jquery.jfontsize.js'
        resource url: 'jquery-plugins/jquery.cookie.js'
        resource url: 'jquery-plugins/jquery.masonry.js'
        resource url: 'jquery-plugins/jquery.lazyload.min.js'
    }

    pagedown {
        dependsOn 'jquery'
        defaultBundle __bundleName

        resource url: 'pagedown/pagedown.css'
        
        resource url: 'pagedown/Markdown.Converter.js'
        resource url: 'pagedown/Markdown.Sanitizer.js'
        resource url: 'pagedown/Markdown.Editor.js'
    }

    bizstrap {   
        dependsOn 'jquery, tagit'   
        defaultBundle __bundleName

        resource url: 'bizstrap/rs-plugin/css/settings.css', attrs: [media: 'screen']
        resource url: 'bizstrap/css/rs-responsive.css', attrs: [media: 'screen']
        resource url: 'bizstrap/css/bootstrap.css'        
        resource url: 'bizstrap/css/custom.css'
        resource url: 'bizstrap/css/isotope.css'

        // resource url: 'bizstrap/css/styler.css'
        // resource url: 'bizstrap/css/color_scheme.css'

        resource url: 'bizstrap/css/flexslider.css'
        resource url: 'bizstrap/css/jquery.fancybox.css?v=2.1.0', attrs: [media: 'screen']

        resource url: 'bizstrap/js/style-switcher.js'


        resource url: 'bizstrap/js/bootstrap.js'  
        resource url: 'bizstrap/js/jquery.flexslider-min.js'
        resource url: 'bizstrap/js/jquery.isotope.js'
        resource url: 'bizstrap/js/jquery.fancybox.pack.js?v=2.1.0' 
   
        resource url: 'bizstrap/rs-plugin/js/jquery.themepunch.plugins.min.js'       
        resource url: 'bizstrap/rs-plugin/js/jquery.themepunch.revolution.js'    
        resource url: 'bizstrap/js/revolution.custom.js'            
        resource url: 'bizstrap/js/custom.js'

    }

    'bootstrap-ext' {
        dependsOn 'bizstrap'
        defaultBundle __bundleName

        resource url: 'bootstrap-ext/bootbox/bootbox.min.js'

        resource url: 'bootstrap-ext/datepicker/css/datepicker.css'
        resource url: 'bootstrap-ext/datepicker/js/bootstrap-datepicker.js'
        resource url: 'bootstrap-ext/datepicker/js/locales/bootstrap-datepicker.zh-TW.js'

        
    }
    
    'font-awesome' {
        dependsOn 'bizstrap'
        defaultBundle __bundleName
        
        resource url: 'css/font-awesome.css'
        resource url: 'css/font-awesome-ie7.css',
            wrapper: { s -> "<!--[if lte IE 7]>$s<![endif]-->" }
    }
    
    tagit {
        dependsOn 'jquery, jquery-ui'
        defaultBundle __bundleName

        resource url: 'tagit/css/jquery.tagit.css'
        resource url: 'tagit/css/tagit.ui-zendesk.css'

        resource url: 'tagit/js/tag-it.js'
    }

    compass {
        dependsOn 'bizstrap, tagit, fileuploader'
        defaultBundle __bundleName

        resource url: 'css/screen.css'
    }



    common {
        dependsOn 'jquery, jquery-ui, jquery-plugins, pagedown'
        defaultBundle __bundleName

        resource url: 'js/common.js'
    }

    application {
        dependsOn 'common'
        defaultBundle __bundleName

        resource url: 'js/application.js'
    }

    ie6 {
        resource url: 'universal-ie6-css/ie6.1.0.css',
            wrapper: { s -> "<!--[if IE 6]>$s<![endif]-->" }
    }
}
