package ecranger


import uk.co.desirableobjects.ajaxuploader.exception.FileUploadException
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import common.*

class AttachmentController {

    def s3Service
    def imageModiService
    def grailsApplication


    def SaveBlob(){

        byte[] imageBytes=params.image.decodeBase64()

        def s3Location="${grailsApplication.config.grails.aws.root}/${params.name}/${params.name}.jpg";

        s3Service.saveObject s3Location, new ByteArrayInputStream(imageBytes)

        return render(text: [success:true] as JSON, contentType:'text/json')


    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER', 'ROLE_ADMIN'])
    def save(){


        def result = [:]
        try {
            InputStream inputStream = (InputStream)request.inputStream
            
            ByteArrayOutputStream byteArrayOutputStream

            if(params?.domainName == "post")
                byteArrayOutputStream = imageModiService.sizeNormal(inputStream)
            else byteArrayOutputStream = imageModiService.sizeThumbnail(inputStream)

            def s3Location="${grailsApplication.config.grails.aws.root}/${params.name}/${params.qqfile}";
            ByteArrayInputStream inputStreamScaled = new ByteArrayInputStream(byteArrayOutputStream.toByteArray())
            
            s3Service.saveObject s3Location, inputStreamScaled
            result.success = true
            return render(text: [success:true] as JSON, contentType:'text/json')

        } catch (FileUploadException e) {

            log.error("Failed to upload file.", e)
            return render(text: [success:false] as JSON, contentType:'text/json')

        }




    }


    /**
     * 附件上傳及清單（顯示在 iframe 頁框內）
     */
    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER', 'ROLE_ADMIN'])
    def list(){
        // File dir = new File("${fileLocation}/${params.name}");

        render (template:"list", model: [
            name: params.name,
            mainImage: params.mainImage,
            // files: dir.listFiles()
            files: s3Service.getObjectList("${grailsApplication.config.grails.aws.root}/${params.name}")
        ])

        // [
        //     content: content,
        //     files: s3Service.getObjectList("attachment/${content.lesson?.course?.id}/${content.lesson?.id}/${content.id}")
        // ]
        
    }

    /**
     * 讀取附件
     */
    def show(){

        def file = params.file

        // 將已編碼 URL 還原
        file = URLDecoder.decode(file)

        try {

            // File object = new File("${fileLocation}/${post.name}/${file}")

            def object = s3Service.getObject("${grailsApplication.config.grails.aws.root}/${params.name}/${file}")
            response.contentType = "image/jpeg"
            response.outputStream << object.dataInputStream
        }
        catch (e) {
            
            log.error "Could not read ${file}"
            def notFindImg = new FileInputStream(grailsAttributes.getApplicationContext().getResource('/images/notFind.jpg').getFile())
            response.outputStream << notFindImg
            // response.sendError 404
        }
    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_OPERATOR', 'ROLE_MANERGER', 'ROLE_ADMIN'])
    def delete(){

        // def file = new File(params.file);
        try {
            // file.delete();

            s3Service.deleteObject "${params.file}"

            return render(text: [success:true] as JSON, contentType:'text/json')
        }
        catch (e) {
            log.error "Could not read ${file}"
            e.printStackTrace()
            return render(text: [success:false] as JSON, contentType:'text/json')
        }
        
        
    }

}
