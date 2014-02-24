package motoranger

class GoogleTagLib {
    static namespace = "google"
    
    def analytics = { attr, body ->
        out << render(template: '/taglib/google/analytics')
    }
    
    def adsense = { attr, body ->
        out << render(template: '/taglib/google/adsense', model: [
            adClient: grailsApplication.config.google.adsense.adClient,
            width: attr.width?:125,
            height: attr.height?:125
        ])
    }
}
