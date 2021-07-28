package com.serasa.primeiroprojetoandroid.classeFormulario

class Formulario(
    var nome: String?,
    var email: String?,
    var celular: String?
) {
    constructor(): this(null,null,null)
}