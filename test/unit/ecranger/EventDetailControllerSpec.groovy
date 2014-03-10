package ecranger



import grails.test.mixin.*
import spock.lang.*
import grails.transaction.Transactional


@TestFor(EventDetailController)
@Mock([EventDetail, User, Product, Part, Event, UserService])
class EventDetailControllerSpec extends Specification {

    @Transactional
    def setup() {
        User.metaClass.encodePassword = {
            password = 'password'
        }
        EventDetail.metaClass.updateHeadTotalPrice = {
            
        }        

        def product = new Product(name: "product", title: "product").save(flush: true)
        def user = new User(username: 'user', title: 'user', password:'pass'
            , enabled: true).save(flush: true)

        def event = new Event(name: "event", user: user, product: product, date: new Date()).save(flush: true)       
        def part = new Part(name: 'part', title: 'part').save(flush: true)       

        UserService.metaClass.currentUser = {
            user
        }

        UserService.metaClass.isLoggedIn = {
            true
        }
        UserService.metaClass.isOperator = {
            true
        }        
        UserService.metaClass.isAdmin = {
            false
        }
        UserService.metaClass.isManerger = {
            false
        }             
    }

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        params["name"] = 'eventDetail'
        params["part.id"] = Part.findByName("part").id
        params["head.id"] = Event.findByName("event").id

        println params
    }


    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            def eventDetail = new EventDetail()
            eventDetail.part = Part.findByName("part")
            controller.create(eventDetail)

        then:"The model is correctly created"
            model.eventDetailInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def eventDetail = new EventDetail()
            eventDetail.validate()
            controller.save(eventDetail)

        then:"The create view is rendered again with the correct model"
            flash.message == "無法新增維修項目"

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            eventDetail = new EventDetail(params)

            controller.save(eventDetail)

        then:"A redirect is issued to the show action"
            controller.flash.message != null
            EventDetail.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"redirect to /home/redirect"
            response.redirectedUrl == '/home/redirect'
            flash.message != null

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def eventDetail = new EventDetail(params)
            controller.show(eventDetail)

        then:"A model is populated containing the domain instance"
            model.eventDetailInstance == eventDetail
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"redirect to /home/redirect"
            response.redirectedUrl == '/home/redirect'
            flash.message != null

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def eventDetail = new EventDetail(params)
            controller.edit(eventDetail)

        then:"A model is populated containing the domain instance"
            model.eventDetailInstance == eventDetail
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"redirect to /home/redirect"
            response.redirectedUrl == '/home/redirect'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def eventDetail = new EventDetail()
            eventDetail.validate()
            controller.update(eventDetail)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.eventDetailInstance == eventDetail

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            eventDetail = new EventDetail(params).save(flush: true)
            controller.update(eventDetail)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/event/show/"+eventDetail.head.id
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"redirect to /home/redirect"
            response.redirectedUrl == '/home/redirect'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def eventDetail = new EventDetail(params).save(flush: true)

        then:"It exists"
            EventDetail.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(eventDetail)

        then:"The instance is deleted"
            EventDetail.count() == 0
            flash.message == 'default.deleted.message'
    }
}
