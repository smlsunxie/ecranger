package ecranger

import groovy.transform.EqualsAndHashCode

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, excludes = 'dateCreated,lastUpdated,metaClass')
@EqualsAndHashCode
class SecurityMap {

   String url
   String configAttribute

   static mapping = {
      cache true
   }

   static constraints = {
      url blank: false, unique: true
      configAttribute blank: false
   }

}