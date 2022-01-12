package com.nttdata.apiejemploconretrofit.Model

class Posts {

    //Atributos del archivo Json
    private var id = 0
    private var title: String? = null
    private var body: String? = null
    private var userId = 0

    //Generación de getters y setters
    fun getUserId(): Int {
        return userId
    }

    fun setUserId(userId: Int) {
        this.userId = userId
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getBody(): String? {
        return body
    }

    fun setBody(body: String?) {
        this.body = body
    }


}