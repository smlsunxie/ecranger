package ecranger

import grails.plugin.springsecurity.annotation.Secured

class PostController {

	static layout="bootstrap"
    def messageSource
    def tagQueryService
    def userService




    /**
     * 直接建立內容後回到瀏覽頁面
     */
    @Secured(['ROLE_ADMIN'])
    def create(){
        def post = new Post(params)
        post.name = "post-${new Date().format('yyyy')}-${new Date().format('MMddHHmmss')}"

        post.type = PostType.NEWS

        // def products=Product.executeQuery(
        //    'from Product p where p not in ' +
        //        '(:products)',
        //    [products: Post.list()*.product])


        // def tagStr=""

        // post.tags.each() {

        //     if(tagStr!='')tagStr+=","
        //     tagStr+= it

        // };

        [ 
            post: post
        ]
    }
    @Secured(['ROLE_ADMIN'])
    def save(){
      
        def post = new Post(params)


        //set current user as creator
        post.creator = userService.currentUser().username

        if (!post.validate()) {
            if(post.hasErrors())
                post.errors?.allErrors?.each{ 
                    flash.message=  messageSource.getMessage(it, null)
                };
            render(view: "create", model: [post: post])
            return
        }
        
        post.save(flush: true)

        if(params.tags instanceof String)
            post.tags=[params.tags];
        else post.tags = params.tags

        flash.message = message(code: 'default.created.message', args: [message(code: 'post.label', default: 'Post'), post.id])


        redirect(action: "show", id: post.id)
    }



    @Secured(['ROLE_ADMIN'])
    def edit(){
        def post = Post.get(params.id)


        [ 
            post: post
        ]
    }
    @Secured(['ROLE_ADMIN'])
    def delete(){ 
        def post = Post.findByIdOrName(params.id, params.name)
        post.delete(flush: true)

        flash.message = message(code: 'default.deleted.message', args: [message(code: 'post.label', default: 'post'), params.id])

        redirect(action: "list")
    }

    def show(){ 
        def post = Post.findByIdOrName(params.id, params.name)
        

        if (post) {
            //點擊次數 +1
            post.hits ++;
            post.save(flush: true)
        }
        
        if (!post) {
            post = new Post(params)
        }

        def recentPosts  = Post.findAll(max: 4, sort: 'dateCreated', order: 'desc') {
            // type == PostType.DEMO
            id != post.id
        }

        ProductController productController = new ProductController()



        def productShow=(post?.product?.id ? productController.show(post.product.id):null)


        
    	[
            productShow:productShow,
            post: post,
            recentPosts:recentPosts
        ]
    }

    def portfolio(){
        def type = PostType.NEWS
        def posts

        switch (params.type) {
            case 'DEMO':
                type = PostType.DEMO
            break
            case 'NEWS':
                type = PostType.NEWS
            break
            case 'SALE':
                type = PostType.SALE
            break
        }


        posts=Post.findAllByType(type)

        // def tags=[]
        // if(posts){
        //     posts.tags.each{ //i ->
        //         tags.addAll(it) 
        //     }

        // }

        [
            type: type,
            posts: posts,
            tags: tagQueryService.getUniTagByList(posts)
        ]

    }

    def list(){
        [
            posts: Post.list()
        ]
    }

    @Secured(['ROLE_ADMIN'])
    def update(){ 


        def post = Post.findByIdOrName(params.id,params.name)



        if(params.tags instanceof String)
            post.tags=[params.tags];
        else post.tags = params.tags



        if(!params.mainImage)params.mainImage="";

        
        if (!post) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), id])
            redirect(action: "list")
            return
        }

        if (params.version != null) {  



            if (post.version > (params.version as Long)) {
                post.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'post.label', default: 'Post')] as Object[],
                          "Another user has updated this User while you were editing")

                flash.message = message(code: "Another user has updated this User while you were editing")
                render(view: "edit", model: [post: post])
                return
            }
        }

        post.properties = params

        if (!post.save(flush: true)) {
            post.errors?.allErrors?.each{ 
                flash.message=  messageSource.getMessage(it, null)
            };
            render(view: "edit", model: [post: post])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'post.label', default: 'Post'), post.id])
        redirect(action: "show", id: post.id)
    }





}
