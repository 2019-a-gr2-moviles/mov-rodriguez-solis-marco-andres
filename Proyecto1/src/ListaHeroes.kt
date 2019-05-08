import java.io.Serializable

class ListaHeroes():Serializable {
    private var heroes: ArrayList<Heroe>

    init {
        heroes = LeerEscribirArchivos.leerArchivoHeroe()
        if (heroes == null) {
            heroes = ArrayList<Heroe>()
        }
    }

    fun obtenerHeroes(): ArrayList<Heroe> {
        return heroes
    }

    fun actualizarHeroe(
        idHeroe: String,
        nombre: String,
        tipo: String,
        rolPrincipal: String,
        habilidadFinal: String
    ) {
        println("$idHeroe, $nombre, $tipo, $rolPrincipal, $habilidadFinal")
        heroes.map { nuevoHeroe: Heroe ->
            if (nuevoHeroe.getIdHeroe() == idHeroe) {
                nuevoHeroe.setNombre(nombre)
                nuevoHeroe.setTipo(tipo)
                nuevoHeroe.setRolPrincipal(rolPrincipal)
                nuevoHeroe.setHabilidadFinal(habilidadFinal)

            }
        }
        guardarLista()
    }

    fun existe(nombre: String): Boolean {
        return heroes.any { heroe: Heroe ->
            heroe.getNombre().equals(nombre)
        }
    }

    fun eliminarHeroe(nombre: String) {

        val heroesAux = heroes.filter { nuevoHeroe: Heroe ->
            nuevoHeroe.getNombre() != nombre
        }
        igualarLista(heroesAux as ArrayList<Heroe>)
        guardarLista()
    }

    fun insertarHeroe(
        idHeroe: String,
        nombre: String,
        tipo: String,
        rolPrincipal: String,
        habilidadFinal: String
    ) {
        heroes.add(Heroe(idHeroe, nombre, tipo, rolPrincipal, habilidadFinal))
        guardarLista()
    }

    private fun guardarLista() {
        LeerEscribirArchivos.escribirArchivoHeroe(heroes)
    }

    private fun igualarLista(heroesAux: ArrayList<Heroe>) {
        this.heroes = heroesAux
    }

    fun obtenerHeroe(nombre: String): String {
        if (existe(nombre)) {
            return heroes.filter { heroesAux: Heroe -> heroesAux.getNombre() == nombre }.toString()
        }
        return ""
    }

    fun actualizarHeroeBoton(id: String, nombre: String, tipo: String, rol: String, habilidad:String, anterior: String){
        eliminarHeroe(anterior)
        insertarHeroe(id, nombre, tipo, rol, habilidad)
    }
}