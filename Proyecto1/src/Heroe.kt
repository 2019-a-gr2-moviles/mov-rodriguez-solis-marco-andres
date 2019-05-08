import java.io.Serializable


class Heroe: Serializable {
    private var idHeroe: String = "";
    private var nombre:String = ""
    private var tipo:String = ""
    private var rolPrincipal:String = ""
    private var habilidadFinal: String = ""

    constructor(idHeroe: String, nombre:String, tipo:String, rolPrincipal:String, habilidadFinal:String ){
        this.idHeroe = idHeroe
        this.nombre = nombre
        this.tipo = tipo
        this.rolPrincipal = rolPrincipal
        this.habilidadFinal = habilidadFinal
    }
    fun getIdHeroe(): String {
        return idHeroe
    }

    fun setIdHeroe(idHeroe: String) {
        this.idHeroe = idHeroe
    }

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun getTipo(): String {
        return tipo
    }

    fun setTipo(tipo: String) {
        this.tipo = tipo
    }

    fun getRolPrincipal(): String {
        return rolPrincipal
    }

    fun setRolPrincipal(rolPrincipal: String) {
        this.rolPrincipal = rolPrincipal
    }
    fun getHabilidadFinal(): String {
        return habilidadFinal
    }

    fun setHabilidadFinal(habilidadFinal: String) {
        this.habilidadFinal = habilidadFinal
    }
    override fun toString(): String {
        return this.idHeroe.toString()
    }
}