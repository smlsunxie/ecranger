import motoranger.*
import org.grails.taggable.Tag

class BootStrap {

    def init = { servletContext ->

        //基本權限
        environments {

            def ruleAdmain = Role.findOrSaveByAuthority('ROLE_ADMIN')
            def ruleManager = Role.findOrSaveByAuthority('ROLE_MANERGER')
            def ruleOper = Role.findOrSaveByAuthority('ROLE_OPERATOR')
            def ruleCus = Role.findOrSaveByAuthority('ROLE_CUSTOMER')

            def admin = User.findByUsername('admin')


            // 動態定義 securityConfig by map in db 
            // new SecurityMap(url: '/securityInfo/config',
            //    configAttribute: 'ROLE_ADMIN').save(failOnError: true, flush: true)


            if (!admin) {
                admin = new User(username: 'admin', password: 'admin', title:'系統管理員',mobile:'0911111111', enabled: true, works: true).save(failOnError: true, flush: true)
                //join roles
                UserRole.create(admin, ruleAdmain)

            }

            production {

            }
            
            development {
                createTestUser()
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
        def userAdmin = User.findByUsername('admin')
        def ruleAdmain = Role.findByAuthority('ROLE_ADMIN')
        def ruleManager = Role.findByAuthority('ROLE_MANERGER')
        def ruleOper = Role.findByAuthority('ROLE_OPERATOR')
        def ruleCus = Role.findByAuthority('ROLE_CUSTOMER')        

        def storeDef=new Store(title:'範例機車行店家', name:'store-default-motocycle').save(flush:true, failOnError:true)
        def storedemo=new Store(title:'勝祥機車行', name:'PaulStore', address:'台北市汀州路一段 354 號', telphone:'0223033926').save(flush:true, failOnError:true)

        userAdmin.store=storedemo
        userAdmin.save(flush:true, failOnError:true)

        def smlsun = new User(username: 'smlsun', password: 'smlsun', title:'宗穎', enabled: true, store:storedemo).save(failOnError: true, flush: true)
        UserRole.create(smlsun, ruleAdmain)
        UserRole.create(smlsun, ruleOper)

        def fat = new User(username: 'fat', password: 'fat', title: "小胖", enabled: true, store:storedemo).save(failOnError: true, flush: true)
        UserRole.create(fat, ruleOper)


        def bro = new User(username: 'bro', password: 'bro', title: "小弟", enabled: true, store:storedemo).save(failOnError: true, flush: true)
        UserRole.create(bro, ruleOper)

        def tin = new User(username: 'tin', password: 'tin', title: "宗庭", enabled: true, store:storedemo).save(failOnError: true, flush: true)
        UserRole.create(tin, ruleOper)

        def paul = new User(username: 'paul', password: 'paul', title: "保羅", enabled: true, store:storedemo).save(failOnError: true, flush: true)
        UserRole.create(paul, ruleManager)

        def cus = new User(username: 'cus', password: 'cus', title: "客戶", enabled: true).save(failOnError: true, flush: true)
        UserRole.create(cus, ruleCus)


        def p1 = new Product(name:'P12345',title:'P12345', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p2 = new Product(name:'P22345',title:'P22345', user:cus, years:new Date()).save(failOnError: true, flush: true)

        def p3 = new Product(name:'P1',title:'P1', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p4 = new Product(name:'P2',title:'P2', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p5 = new Product(name:'P3',title:'P3', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p6 = new Product(name:'P4',title:'P4', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p7 = new Product(name:'P5',title:'P5', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p8 = new Product(name:'P6',title:'P6', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p9 = new Product(name:'P7',title:'P7', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p10 = new Product(name:'P8',title:'P8', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p11 = new Product(name:'P9',title:'P9', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p12 = new Product(name:'P10',title:'P10', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        def p13 = new Product(name:'P11',title:'P11', user:cus, years:new Date(), mileage:1234L).save(failOnError: true, flush: true)
        
        
        def brand1 = new Brand(name:'YAMAHA',title:'山葉').save(failOnError: true, flush: true)
        def brand2 = new Brand(name:'SUZUKI',title:'台鈴').save(failOnError: true, flush: true)


        def part1 = new Part(name:'part1', title:'part1', price:100L).save(failOnError: true, flush: true)
        part1.addTag("標準維修")

        def part2 = new Part(name:'part2', title:'part2', price:200L).save(failOnError: true, flush: true)
        part2.addTag("標準維修")

        def event1 = new Event(name:'event1', user:bro, product:p1, totalPrice:100L, date:new Date(), store:storeDef).save(failOnError: true, flush: true)
        def eventDetail1= new EventDetail(name:'eventDetail1',part:part1, head:event1).save(failOnError: true, flush: true)

        def event2 = new Event(name:'event2', user:bro, product:p2, date:new Date(), status:motoranger.ProductStatus.END, store:storedemo).save(failOnError: true, flush: true)
        def eventDetail2= new EventDetail(name:'eventDetail2',part:part2, head:event1).save(failOnError: true, flush: true)




        def post = new Post(name:'post1', title:'post1', product:p1).save(failOnError: true, flush: true)


    }
}
