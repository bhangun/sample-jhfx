package com.example.demo.account

import com.example.demo.shared.BaseController
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.*
import javax.json.JsonObject

class UserFragment : Fragment("Entity View") {
    val user : UserView by inject()
    val base: BaseController by inject()
    override val root = borderpane()
    init{
        log.info("new entity fragment")
        with(root) {
            center = user.root
        }
    }
}

class UserFragmentModel : ItemViewModel<UserFragment>() {
    val root = bind(UserFragment::root)
}


class UserView : View() {
    val base: BaseController by inject()
    var test = FXCollections.observableArrayList<String>()
    fun getUsers(): String{//: ObservableList<UserJson> {
        var re = base.api.get(base.API_USERS).list()//.toModel()

        var rr:ObservableList<UserJson> = base.api.get(base.API_USERS).list().toModel()

        return re.toString() +"\n\n --------------------------- ${rr.get(1).authorities}"
       // return re
    }

    init{
        var xx=base.api.get(base.API_USERS).list().toString()
       log.info("============="+xx)
        log.info(")))))))))))))))))) "+getUsers().toString())
    }

    override val root = pane {
        /*tableview(test) {
            column("ID", UserJson::idProperty)
            column("Username", UserJson::loginProperty)
            column("First Name", UserJson::firstNameProperty)
            column("Last Name", UserJson::lastNameProperty)
            column("Email", UserJson::emailProperty)
            column("Activated", UserJson::activatedProperty)
            column("Authorities", UserJson::authoritiesProperty)
        }*/
    }
}


class Orang(): JsonModel{
/*
    var id : String
    var login = string("login")
    var  firstName = string("firstName")
    var  lastName = string("lastName")
    var  email= string("email")
    var  imageUrl = string("imageUrl")
    var   activated = string("activated")
    var   langKey = string("langKey")
    var  jsonArray("authorities")//.toModel()//.toString()
    var  createdBy = string("createdBy")
    var   createdDate = string("createdDate")
    var   lastModifiedBy = string("lastModifiedBy")
    var   lastModifiedDate = string("lastModifiedDate")*/

    override fun updateModel(json: JsonObject) {
        with(json) {
            int("id")
           string("login")
           string("firstName")
            string("lastName")
           string("email")
             string("imageUrl")
           boolean("activated")
            string("langKey")
            jsonArray("authorities")//.toModel()//.toString()
            string("createdBy")
             string("createdDate")
             string("lastModifiedBy")
           string("lastModifiedDate")
        }
    }
}