package no.tornado.fxsample.login

import com.example.demo.shared.BaseController
import com.example.demo.shared.home.HomeWorkspace
import com.example.demo.shared.login.LoginView
import com.example.demo.shared.login.RegisterView
import javafx.application.Platform
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class LoginController : Controller() {
    val base: BaseController by inject()
    val loginScreen: LoginView by inject()
    val home: HomeWorkspace by inject()
    val registerView: RegisterView by inject()
    val api: Rest by inject()

    fun init() {
        api.baseURI = "http://localhost:8080/api/"
        with (config) {
            if (containsKey(USERNAME) && containsKey(PASSWORD)) {
                tryLogin(string(USERNAME), string(PASSWORD), true)
            }else {
                showLogin("Please log in")
            }
        }
    }

    fun showLogin(message: String, shake: Boolean = false) {
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

    fun authenticate(username: String, password: String, remember: Boolean): String{
        return base.api.post("authenticate", LoginVM(username,password,remember).toJSON()).one().getJsonString("id_token").string
    }

    fun tryLogin(username: String, password: String, remember: Boolean) {
        var token=""
        runAsync {
             token=authenticate(username,password,remember)
        } ui { successfulLogin ->
            if (successfulLogin!=null) {
                loginScreen.clear()
                if (remember) {
                    with (config) {
                        set(TOKEN to token)
                        save()
                    }
                }
                showWorkbench()
            } else {
                showLogin("Login failed. Please try again.", true)
            }
        } fail {
            showLogin("Login failed. Please try again.", true)
        }
    }

    fun logout() {
        with (config) {
            remove(USERNAME)
            remove(PASSWORD)
            save()
        }
        showLogin("Log in as another user")
    }

    companion object {
        val USERNAME = "username"
        val PASSWORD = "password"
        val TOKEN = "idtoken"
    }
}

class LoginControllerModel : ItemViewModel<LoginController>() {}

class JWTToken: JsonModel {
    val idtokenProperty = SimpleStringProperty()
    var idtoken by idtokenProperty
}

class LoginVM(username: String, password: String, rememberMe: Boolean) : JsonModel{
    val usernameProperty = SimpleStringProperty(username)
    var username by usernameProperty

    val passwordProperty = SimpleStringProperty(password)
    var password by passwordProperty

    val rememberMeProperty = SimpleBooleanProperty(rememberMe)
    var rememberMe by rememberMeProperty


    override fun updateModel(json: JsonObject) {
        with(json) {
            username = string("username")
            password = string("password")
            rememberMe = true
        }
    }

    override fun toJSON(json: JsonBuilder) {
        with(json) {
            add("username", username)
            add("password", password)
            add("rememberMe",rememberMe)
        }
    }
}
