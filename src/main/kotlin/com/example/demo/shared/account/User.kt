package com.example.demo.account

import javafx.beans.property.*
import tornadofx.*
import java.time.Instant
import java.time.LocalDate
import javax.json.JsonObject

class User(): JsonModel {

    var id by property<String>()
    fun idProperty() = getProperty(User::id)
    var login by property<String>()
    fun loginProperty() = getProperty(User::login)
    var firstName by property<String>()
    fun firstNameProperty() = getProperty(User::firstName)
    var lastName by property<String>()
    fun lastNameProperty() = getProperty(User::lastName)
    var email by property<String>()
    fun emailProperty() = getProperty(User::email)
    var imageUrl by property<String>()
    fun imageUrlProperty() = getProperty(User::imageUrl)
    var activated by property<Boolean>()
    fun activatedProperty() = getProperty(User::activated)
    var langKey by property<String>()
    fun langKeyProperty() = getProperty(User::langKey)
    var createdBy by property<String>()
    fun createdByProperty() = getProperty(User::createdBy)
    var createdDate by property<Instant>()
    fun createdDateProperty() = getProperty(User::createdDate)
    var lastModifiedBy by property<String>()
    fun lastModifiedByProperty() = getProperty(User::lastModifiedBy)
    var lastModifiedDate by property<Instant>()
    fun lastModifiedDateProperty() = getProperty(User::lastModifiedDate)
    var authorities by property<String>()
    fun authoritiesProperty() = getProperty(User::authorities)
    var password by property<String>()
    fun passwordProperty() = getProperty(User::password)

    //override fun toString() = login

    override fun updateModel(json: JsonObject) {
        with(json) {
            id =  int("id").toString()
            login = string("login")
            firstName = string("firstName")
            lastName = string("lastName")
            email= string("email")
            imageUrl = string("imageUrl")
            activated = boolean("activated")
            langKey = string("langKey")
            authorities = jsonArray("authorities").toString()
            createdBy = string("createdBy")
            createdDate = Instant.parse(string("createdDate").toString())
            lastModifiedBy = string("lastModifiedBy")
           // lastModifiedDate = Instant.parse((string("lastModifiedDate")
            val l=if (string("lastModifiedDate")!=null) Instant.parse(string("lastModifiedDate")) else Instant.now()
            lastModifiedDate = l//.filter { x->x.equals(null)}?.toString())
        }
    }

    override fun toJSON(json: JsonBuilder) {
        with(json) {
            add("id",id)
            add("login",login)
            add("firstName",firstName)
            add("lastName",lastName)
            add("email",email)
            add("imageUrl",imageUrl)
            add("activated",activated)
            add("langKey",langKey)
            add("authorities",authorities)
            add("createdBy",createdBy)
            add("createdDate",createdDate.toString())
            add("lastModifiedBy",lastModifiedBy)
            add("lastModifiedDate",lastModifiedDate.toString())
        }
    }
}

class UserModel : ItemViewModel<User>(User()) {
    var id : StringProperty = bind { item?.idProperty() }
    var login : StringProperty = bind { item?.loginProperty() }
    var firstName : StringProperty = bind { item?.firstNameProperty() }
    var lastName : StringProperty = bind { item?.lastNameProperty() }
    val email: StringProperty = bind { item?.emailProperty() }
    var imageUrl : StringProperty = bind { item?.imageUrlProperty() }
    var activated : BooleanProperty = bind { item?.activatedProperty() }
    var langKey : StringProperty = bind { item?.langKeyProperty() }
    var authorities : StringProperty = bind { item?.authoritiesProperty() }
    var createdBy : StringProperty = bind { item?.createdByProperty() }
    var createdDate : Property<Instant> = bind { item?.createdDateProperty() }
    var lastModifiedBy : StringProperty = bind { item?.lastModifiedByProperty() }
    var lastModifiedDate : Property<Instant> = bind { item?.lastModifiedDateProperty() }
    val password: StringProperty = bind { item?.passwordProperty() }
}


/*
class Role(): JsonModel{
    */
/*val idProperty = SimpleStringProperty()
    var id by idProperty

    override fun updateModel(json: JsonObject) {
        with(json) {
            id = getString()
        }
    }*//*

}
*/
/*
class UserJson(): JsonModel{

    var id : String =""
    var login : String =""
    var  firstName : String =""
    var  lastName : String =""
    var  email: String =""
    var  imageUrl : String =""
    var   activated : String =""
    var   langKey : String =""
    var  authorities : String =""
    var  createdBy : String =""
    var   createdDate : String =""
    var   lastModifiedBy : String =""
    var   lastModifiedDate : String =""
    init{
        log.info("masuuuuuuuuuuuuuk")
    }
*//*


class UserJson(id: Int,login: String,firstName:String, lastName:String,email: String
           ,imageUrl: String,activated: Boolean,langKey: String,createdBy: String,createdDate: String
           ,lastModifiedBy: String,lastModifiedDate: String,authorities: List<String>): JsonModel {

    val idProperty = SimpleIntegerProperty(id)
    var id by idProperty

    val loginProperty = SimpleStringProperty(login)
    var login by loginProperty

    val firstNameProperty = SimpleStringProperty(firstName)
    var firstName by firstNameProperty

    val lastNameProperty = SimpleStringProperty(lastName)
    var lastName by lastNameProperty

    val emailProperty = SimpleStringProperty(email)
    var email by emailProperty

    val imageUrlProperty = SimpleStringProperty(imageUrl)
    var imageUrl by imageUrlProperty

    val activatedProperty = SimpleBooleanProperty(activated)
    var activated by activatedProperty

    val langKeyProperty = SimpleStringProperty(langKey)
    var langKey by langKeyProperty

    val createdByProperty = SimpleStringProperty(createdBy)
    var createdBy by createdByProperty

    val createdDateProperty = SimpleStringProperty(createdDate)
    var createdDate by createdDateProperty

    val lastModifiedByProperty = SimpleStringProperty(lastModifiedBy)
    var lastModifiedBy by lastModifiedByProperty

    val lastModifiedDateProperty = SimpleStringProperty(lastModifiedDate)
    var lastModifiedDate by lastModifiedDateProperty

    val authoritiesProperty = SimpleStringProperty()
    var authorities by authoritiesProperty
   //var authorities = JsonArray
  // var authorities = FXCollections.observableArrayList<Role>()
    //override fun toString() = login

*/
/*class UserJson: JsonModel{
   // var id : String =""
    val idProperty = SimpleIntegerProperty()
    var id by idProperty

    var login : String =""
    var  firstName : String =""
    var  lastName : String =""
    var  email: String =""
    var  imageUrl : String =""
    var   activated : String =""
    var   langKey : String =""
    var  authorities : String =""
    var  createdBy : String =""
    var   createdDate : String =""
    var   lastModifiedBy : String =""
    var   lastModifiedDate : String =""*//*


    override fun updateModel(json: JsonObject) {
        with(json) {
             id =  int("id")
             login = string("login")
             firstName = string("firstName")
             lastName = string("lastName")
             email= string("email")
             imageUrl = string("imageUrl")
             activated = boolean("activated")
             langKey = string("langKey")
             authorities = jsonArray("authorities").toString()
             createdBy = string("createdBy")
             createdDate = string("createdDate")
             lastModifiedBy = string("lastModifiedBy")
             lastModifiedDate = string("lastModifiedDate")
        }
    }

    override fun toJSON(json: JsonBuilder) {
        */
/*with(json) {
            add("id",id)
            add("login",login)
            add("firstName",firstName)
            add("lastName",lastName)
            add("email",email)
            add("imageUrl",imageUrl)
            add("activated",activated)
            add("langKey",langKey)
            //add("authorities",authorities)
            add("createdBy",createdBy)
            add("createdDate",createdDate)
            add("lastModifiedBy",lastModifiedBy)
            add("lastModifiedDate",lastModifiedDate)
        }*//*

    }

    */
/*
     {login='user',
 firstName='User',
 lastName='User',
 email='user@localhost',
 imageUrl='',
 activated=true, langKey='en',
 createdBy=system,
 createdDate=2018-02-13T09:53:57.745Z,
 lastModifiedBy='system',
 lastModifiedDate=null,
 authorities=[ROLE_USER]
 }
     *//*

}
*/


/*
with(json) {
    id =  int("id")
    login = string("login")
    firstName = string("firstName").toString()
    lastName = string("lastName").toString()
    email= string("email").toString()
    imageUrl = string("imageUrl").toString()
    activated = boolean("activated").toString()
    langKey = string("langKey").toString()
    authorities = jsonArray("authorities").toString()
    createdBy = string("createdBy").toString()
    createdDate = string("createdDate").toString()
    lastModifiedBy = string("lastModifiedBy").toString()
    lastModifiedDate = string("lastModifiedDate").toString()
}
*/


