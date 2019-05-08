import java.io.*

class LeerEscribirArchivos {
    companion object {
        var ruta: String = "src${File.separatorChar}archivos${File.separatorChar}"
        var nombreArchivo: String = "heroe.txt"


        fun leerArchivoHeroe(): ArrayList<Heroe> {

            var arregloHeroe: ArrayList<Heroe> = ArrayList<Heroe>()
            try {
                var lectorArchivo = ObjectInputStream(FileInputStream(ruta + nombreArchivo))
                arregloHeroe = lectorArchivo.readObject() as ArrayList<Heroe>
            } catch (fnfex: FileNotFoundException) {
            } catch (ioex: IOException) {
            } catch (cnfex: ClassNotFoundException) {
            }
            return arregloHeroe
        }

        fun escribirArchivoHeroe(listaZapatos: ArrayList<Heroe>) {
            try {
                val escritorArchivo = ObjectOutputStream(FileOutputStream(ruta + nombreArchivo))
                escritorArchivo.writeObject(listaZapatos as Serializable)
            } catch (fnfex: FileNotFoundException) {
                fnfex.printStackTrace()
            } catch (ioex: IOException) {
                ioex.printStackTrace()
            }
        }
    }
}