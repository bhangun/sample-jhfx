package com.example.demo.account

import com.example.demo.shared.BaseController
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.*

class UserFragment : Fragment("Entity View") {
    val person : UserView by inject()
    val base: BaseController by inject()
    override val root = borderpane()
    init{
        log.info("new entity fragment")
        with(root) {
            center = person.root
        }
    }
}

class UserFragmentModel : ItemViewModel<UserFragment>() {
    val root = bind(UserFragment::root)
}


class UserView : View() {
    val base: BaseController by inject()
    var test = FXCollections.observableArrayList<String>()
    fun getUsers(): ObservableList<UserJson> {
        var re:ObservableList<UserJson> = base.api.get(base.API_USERS).list().toModel()
        return re
    }

    init{
        var xx=base.api.get(base.API_USERS).list().toString()
       log.info("============="+xx)
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
