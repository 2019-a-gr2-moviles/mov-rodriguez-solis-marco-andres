import java.io.Serializable


class Heroe: Serializable {
    var idHeroe:Number = 0;
    var nombre:String = ""
    var tipo:String = ""
    var rolPrincipal:String = ""
    var habilidadFinal: String = ""

    constructor(idHeroe: Number, nombre:String, tipo:String, rolPrincipal:String, habilidadFinal:String ){
        this.idHeroe = idHeroe
        this.nombre = nombre
        this.tipo = tipo
        this.rolPrincipal = rolPrincipal
        this.habilidadFinal = habilidadFinal
    }

    override fun toString(): String {
        return this.idHeroe.toString()
    }
}