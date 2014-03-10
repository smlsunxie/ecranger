package ecranger

import org.jets3t.service.*
import org.jets3t.service.model.*
import org.jets3t.service.security.*
import org.jets3t.service.impl.rest.httpclient.*

class S3Service {

    def grailsApplication
    
    static _s3Service = null

    def getAwsCredentials() {

        log.info grailsApplication.config.grails.config.locations
        log.info grailsApplication.config.aws.accessKey
        log.info grailsApplication.config.aws.secretKey
        new AWSCredentials(
            grailsApplication.config.aws.accessKey,
            grailsApplication.config.aws.secretKey
        )
    }

    def getService() {
        _s3Service = _s3Service?_s3Service:(_s3Service=new RestS3Service(getAwsCredentials()))
    }

    def getBucket() {
        getService().getOrCreateBucket(grailsApplication.config.aws.bucketName)
    }

    def getBucketName() {
        grailsApplication.config.aws.bucketName
    }

    def getObject(path) {
        getService().getObject(getBucket(), path)
    }
    
    /**
     * 取得檔案列表
     */
    def getObjectList(prefix) {
        def results = []
        getService().listObjects(getBucket(), prefix, null).each {
            object->
            results << [name:object.key.split('/').toList().last(), path:object.key, type:object.contentType, size:object.contentLength]
        }
        results
    }

    def createSignedGetUrl(path, minutes) {
        def cal = Calendar.instance
        cal.add(Calendar.MINUTE, minutes)
        def expiryDate = cal.time

        getService().createSignedGetUrl(getBucketName(), path, getAwsCredentials(), expiryDate, false)
    }
    
    /**
     * 將檔案串流儲存到 S3 Object
     */
    def saveObject(String path
        // , String type
        , InputStream stream
        // , long size
        ) {
        def object = new S3Object(path)
        object.dataInputStream = stream
        // object.contentLength = size
        // object.contentType = type
        
        getService().putObject(getBucket(), object)
        
        log.info "Save S3Object ${path}"
    }
    
    /**
     * 移除檔案
     */
    def deleteObject(String path) {
        getService().deleteObject(getBucket(), path)
        
        log.info "Delete S3Object ${path}"
    }
}
