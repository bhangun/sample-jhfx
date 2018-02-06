package com.example.demo.views.login


import com.example.demo.views.login.Styles.Companion.loginScreen
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import tornadofx.*

class RegisterView : View() {
    override val root = GridPane()
   // val registerController: RegisterController by inject()

    var username: TextField by singleAssign()
    var password: PasswordField by singleAssign()


    init {
        title = "Please log in"

        with (root) {
            addClass(loginScreen)

            row("Username") {
                username = textfield()
            }
            row("Email") {
                username = textfield()
            }

            row("Password") {
                password = passwordfield()
            }

            row("Confirm Password") {
                password = passwordfield()
            }

            row {
                button("Submit") {
                    isDefaultButton = true

                    setOnAction {


                    }
                }
            }

        }
    }

    fun clear() {
        username.clear()
        password.clear()
    }


}
