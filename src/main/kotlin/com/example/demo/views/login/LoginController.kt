package no.tornado.fxsample.login

import com.example.demo.views.HomeWorkspace
import com.example.demo.views.login.LoginView
import com.example.demo.views.login.RegisterView
import javafx.application.Platform
import tornadofx.*

class LoginController : Controller() {
    val loginScreen: LoginView by inject()
    val home: HomeWorkspace by inject()
    val registerView: RegisterView by inject()

    fun init() {
        with (config) {
            if (containsKey(USERNAME) && containsKey(PASSWORD)) {
                tryLogin(string(USERNAME), string(PASSWORD), true)
            }else {
                showLoginScreen("Please log in")
            }
        }
    }

    fun showLoginScreen(message: String, shake: Boolean = false) {
        if (FX.primaryStage.scene.root != loginScreen.root) {
            FX.primaryStage.scene.root = loginScreen.root
            FX.primaryStage.sizeToScene()
            FX.primaryStage.centerOnScreen()
        }

        loginScreen.title = message

        Platform.runLater {
            loginScreen.username.requestFocus()
            if (shake) loginScreen.shakeStage()
        }
    }

    fun showWorkbench() {
        if (FX.primaryStage.scene.root != home.root) {
            FX.primaryStage.scene.root = home.root
            FX.primaryStage.sizeToScene()
            FX.primaryStage.centerOnScreen()
        }
    }

    fun showRegister(){

        //registerView.root.show()
        FX.primaryStage.scene.root = registerView.root
        FX.primaryStage.sizeToScene()
        FX.primaryStage.centerOnScreen()
    }

    fun showForgotPassword(){

    }

    fun tryLogin(username: String, password: String, remember: Boolean) {
        println("---1---")
        runAsync {
            username == "admin" && password == "admin"
        } ui { successfulLogin ->

            if (successfulLogin) {
                loginScreen.clear()
                println("---2---")
                if (remember) {
                    with (config) {
                        set(USERNAME to username)
                        set(PASSWORD to password)
                        save()
                    }
                }
                showWorkbench()
            } else {
                println("---3---")
                showLoginScreen("Login failed. Please try again.", true)
            }
        }
    }

    fun logout() {
        with (config) {
            remove(USERNAME)
            remove(PASSWORD)
            save()
        }

        showLoginScreen("Log in as another user")
    }

    companion object {
        val USERNAME = "username"
        val PASSWORD = "password"
    }

}

class LoginControllerModel : ItemViewModel<LoginController>() {}
