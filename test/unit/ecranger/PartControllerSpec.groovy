package ecranger



import grails.test.mixin.*
import spock.lang.*
import grails.transaction.Transactional

@TestFor(PartController)
@Mock([Part, User, EventDetail, TagQueryService, UserService])
class PartControllerSpec extends Specification {

    @Transactional
    def setup() {
        TagQueryService.metaClass.getRecentPartIds = {
            Part.list()
        }
        TagQueryService.metaClass.getUniTag = {
            []
        }
        Part.metaClass.tags = []
        
        UserService.metaClass.currentUser = {
            new User(username: 'userA', title: 'userA', password:'pass'
            , enabled: true)
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
        params["name"] = 'part'
        params["title"] = 'part'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.partInstanceList
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.partInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def part = new Part()
            part.validate()
            controller.save(part)

        then:"The create view is rendered again with the correct model"
            model.partInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            part = new Part(params)

            controller.save(part)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/part/show/1'
            controller.flash.message != null
            Part.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"redirect to /home/redirect"
            response.redirectedUrl == '/home/redirect'
            flash.message != null

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def part = new Part(params)
            controller.show(part)

        then:"A model is populated containing the domain instance"
            model.partInstance == part
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"redirect to /home/redirect"
            response.redirectedUrl == '/home/redirect'
            flash.message != null

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def part = new Part(params)
            controller.edit(part)

        then:"A model is populated containing the domain instance"
            model.partInstance == part
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"redirect to /home/redirect"
            response.redirectedUrl == '/home/redirect'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def part = new Part()
            part.validate()
            controller.update(part)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.partInstance == part

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            part = new Part(params).save(flush: true)
            controller.update(part)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/part/show/$part.id"
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
            def part = new Part(params).save(flush: true)

        then:"It exists"
            Part.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(part)

        then:"The instance is deleted"
            Part.count() == 0
            response.redirectedUrl == '/part/index'
            flash.message != null
    }
}
