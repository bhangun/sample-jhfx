package com.example.demo.shared

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.*
import kotlin.text.Charsets.UTF_8
import tornadofx.getValue
import tornadofx.setValue
import javax.json.JsonObject

class BaseController : Controller() {
    val api: Rest by inject()

    var url= "http://localhost:8080"


    init {
        api.baseURI = url+"/api"


        //Authentication Basic Auth
        api.setBasicAuth("username", "password")

        //Authentication using Header
        /*val requestInterceptor = { request ->
            val b64 = Base64.getEncoder().encodeToString("username:password".toByteArray(UTF_8))
            request.addHeader("Authorization", "Basic $b64")
        }*/

        //Intercepting calls
        //You can for example show a login screen if an HTTP call fails with statusCode 401
        /*api.engine.responseInterceptor = { response ->
            if (response.statusCode == 401)
                //....
        }*/


        //Basic operations
        //fun loadCustomers() = api.get("customers").list().toModel<Customer>()
        //fun loadCustomers(): ObservableList<Customer> = api.get("customers").list().toModel()


        //This is what happens when you call Rest.useApacheHttpClient
        //Rest.engineProvider = { api -> HttpClientEngine(api) }

        //A proxy can be configured either by implementing an interceptor that augments each call, or, preferably once per Rest client instance:
        //api.proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.0.1", 8080))

        //Setting timeouts
        api.engine.requestInterceptor = {
            (it as HttpURLRequest).connection.readTimeout = 5000
        }

    }

    //The following example updates a customer object.
    //fun updateCustomer(customer: Customer) = api.put("customers/${customer.id}", customer)

    //If the api endpoint returns the customer object to us after save, we would fetch a JsonObject by calling one() and then toModel() to convert it back into our model object.
   // fun updateCustomer(customer: Customer) = api.put("customers/${customer.id}", customer).one().toModel<Customer>()


    //Query parameters needs to be URL encoded. The Map.queryString extension value will turn any map into a properly URL encoded query string:
    //val params = mapOf("id" to 1)
    //api.put("customers${params.queryString}", customer).one().toModel<Customer>()

    //Error Handling
    /*fun getCustomer(id: Int): Customer {
        val response = api.get("some/action")

        try {
            if (response.ok())
                return response.one().toModel()
            else if (response.statusCode == 404)
                throw CustomerNotFound()
            else
                throw MyException("getCustomer returned ${response.statusCode} ${response.reason}")
        } finally {
            response.consume()
        }
    }*/
}



