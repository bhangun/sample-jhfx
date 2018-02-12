package com.example.demo.account

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon.HOME
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon.USER
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import org.controlsfx.control.Notifications
import tornadofx.*

class UserForm : View("Register User") {
    val model : UserModel by inject()

    override val root = form {
        fieldset("Personal Information", FontAwesomeIconView(USER)) {
            field("Name") {
                textfield(model.username).required()
            }

            field("Birthday") {
                passwordfield(model.password)
            }
        }

        fieldset("Address", FontAwesomeIconView(HOME)) {
            field("Street") {
                textfield(model.email).required()
            }

        }

        button("Save") {
            action {
                model.commit {
                    val user = model.item
                    Notifications.create()
                            .title("Customer saved!")
                            .text("${user.username} and ${user.email}")
                            .owner(this)
                            .showInformation()
                }
            }

            enableWhen(model.valid)
        }
    }

}

