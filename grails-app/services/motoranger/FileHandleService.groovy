package motoranger

class FileHandleService {

    def checkAndCreate(File storagePathDirectory) {
      if (!storagePathDirectory.exists()) {
        if (storagePathDirectory.mkdirs()) {
          println "SUCCESS"
        } else {
          println "FAILED"
        }
      }
    }
}
