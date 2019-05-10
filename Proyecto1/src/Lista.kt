import java.io.Serializable

class Lista(): Serializable {
    private var heroes: ArrayList<Heroe>

    init {
        heroes = Archivo.leerArchivoHeroe()
        if (heroes == null) {
            heroes = ArrayList<Heroe>()
        }
    }

    fun obtenerHeroes(): ArrayList<Heroe> {
        return heroes
    }

    fun insertarHeroe(idHeroe: String, nombre: String, tipo: String, rolPrincipal: String, habilidadFinal: String) {
        heroes.add(Heroe(idHeroe, nombre, tipo, rolPrincipal, habilidadFinal))
        escribirNuevaLista()
    }

    fun eliminarHeroe(nombre: String) {
        val heroesAux = heroes.filter { nuevoHeroe: Heroe -> nuevoHeroe.getNombre() != nombre }
        igualarLista(heroesAux as ArrayList<Heroe>)
        escribirNuevaLista()
    }


    fun actualizarHeroeBoton(id: String, nombre: String, tipo: String, rol: String, habilidad:String, anterior: String){
        eliminarHeroe(anterior)
        insertarHeroe(id, nombre, tipo, rol, habilidad)
    }

    private fun escribirNuevaLista() {
        Archivo.escribirArchivoHeroe(heroes)
    }










    private fun igualarLista(heroesAux: ArrayList<Heroe>) {
        this.heroes = heroesAux
    }

}