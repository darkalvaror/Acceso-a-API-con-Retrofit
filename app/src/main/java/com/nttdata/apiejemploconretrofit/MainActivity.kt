package com.nttdata.apiejemploconretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nttdata.apiejemploconretrofit.Model.Interface.JsonPlaceHolderApi
import com.nttdata.apiejemploconretrofit.Model.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private var mJsonTxtView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se localiza el textView creado en el layout
        mJsonTxtView = findViewById(R.id.jsonText)

        //Se ejecuta la función getPost()
        getPost()
    }

        //Traer los datos
        private fun getPost() {

            //Clase retrofit
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")

                //Convertidor
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            //Llamada a la interfaz
            val jsonPlaceHolderApi: JsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
            val call: Call<List<Posts>> = jsonPlaceHolderApi.posts

            //Enqueue para cargar por detrás
            call.enqueue(object : Callback<List<Posts>> {

                //Operación si no ha habido ningún error
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {

                    //Si el response es correcto, ejecuta esto
                    if (!response.isSuccessful()) {
                        mJsonTxtView!!.text = "Codigo: " + response.code()
                        return
                    }

                    //Texto que va a mostrar en pantalla
                    val postsList: List<Posts?>? = response.body()

                    //foreach para recorre las listas
                    for (post in postsList!!) {
                        var content = ""
                        content += "userId: ${post?.userId.toString()}\n "
                        content += "id: ${post?.id.toString()}\n"
                        content += "title: ${post?.title.toString()}\n"
                        content += "body: ${post?.body.toString()}\n"
                        content += "\n\n"

                        mJsonTxtView!!.append(content)
                    }
                }

                //El response da algún error, ejecutará esto
                override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

                    //Muestra el mensaje
                    mJsonTxtView!!.text = t.message
                }
            })
        }
}
