import ecranger.*

class BootStrap {

    def init = { servletContext ->

        //基本權限
        environments {

            def ruleAdmain = Role.findOrSaveByAuthority('ROLE_ADMIN')
            def ruleManager = Role.findOrSaveByAuthority('ROLE_MANERGER')
            def ruleOper = Role.findOrSaveByAuthority('ROLE_OPERATOR')
            def ruleCus = Role.findOrSaveByAuthority('ROLE_CUSTOMER')

            def admin = User.findByUsername('admin')

            if (!admin) {
                admin = new User(username: 'admin', password: 'admin', title:'系統管理員',mobile:'0911111111', enabled: true, works: true).save(failOnError: true, flush: true)
                //join roles
                UserRole.create(admin, ruleAdmain)

            }

            production {

            }
            
            development {
                createTestUser()
                setUpTestData()
            }

            test {
                createTestUser()
            }

        }
    }

    def destroy = {
    }

    private createTestUser(){
        def customer = User.findByUsername('customer')
        def operator = User.findByUsername('operator')
        def manerger = User.findByUsername('manerger')

        def ruleManager = Role.findByAuthority('ROLE_MANERGER')
        def ruleOper = Role.findByAuthority('ROLE_OPERATOR')
        def ruleCus = Role.findByAuthority('ROLE_CUSTOMER')        

        if(!customer){
            customer = new User(username: 'customer', password: 'customer', title:'customer', enabled: true).save(failOnError: true, flush: true)
            UserRole.create(customer, ruleCus)
        }
        if(!operator){
            operator = new User(username: 'operator', password: 'operator', title:'operator', enabled: true).save(failOnError: true, flush: true)
            UserRole.create(operator, ruleOper)
        }
        if(!manerger){
            manerger = new User(username: 'manerger', password: 'manerger', title:'manerger', enabled: true).save(failOnError: true, flush: true)
            UserRole.create(manerger, ruleManager)
            UserRole.create(manerger, ruleOper)
        }        
    }

    private setUpTestData(){


        def productBook1 = new Product(type: ecranger.ProductType.BOOK, name: "productBook1", title: "Jeremy Lin  林書豪的故事").save(failOnError: true, flush: true)
        def productBook2 = new Product(type: ecranger.ProductType.BOOK, name: "productBook2", title: "同湖異舟-與身心障礙人士其家庭同行").save(failOnError: true, flush: true)
        def productBook3 = new Product(type: ecranger.ProductType.BOOK, name: "productBook3", title: "40天重新尋得生命泉源").save(failOnError: true, flush: true)
        def productBook4 = new Product(type: ecranger.ProductType.BOOK, name: "productBook4", title: "王者尊榮-榮耀大顯現").save(failOnError: true, flush: true)

        def productMusic1 = new Product(type: ecranger.ProductType.MUSIC, name: "productMusic1", title: "蓋瑟音樂使命團 年度詩歌精選CD").save(failOnError: true, flush: true)
        def productMusic2 = new Product(type: ecranger.ProductType.MUSIC, name: "productMusic2", title: "娜塔莉 葛蘭/颶風").save(failOnError: true, flush: true)
        def productMusic3 = new Product(type: ecranger.ProductType.MUSIC, name: "productMusic3", title: "動物園道64號").save(failOnError: true, flush: true)
        def productMusic4 = new Product(type: ecranger.ProductType.MUSIC, name: "productMusic4", title: "繁茂復活的春天").save(failOnError: true, flush: true)


    }
}
