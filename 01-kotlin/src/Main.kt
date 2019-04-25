import java.util.*
import java.util.zip.DataFormatException
import kotlin.collections.ArrayList

fun main(args: Array<String>){

    /**
    *comentario
    **/

    // Variables
    // que es mutar? cambiar?
    //Mutables

    var nombre = "Marco"
    nombre = "Marco"

    //Inmutables
    //todo lo inmutable es bueno
    val nombreI = "Marco"
    // nombreI = "Andrés"

    //Tipos de datos

    //val apellido = "Rodríguez"
    val apellido: String = "Rodríguez"
    val edad: Int = 22
    val sueldo: Double = 1.21
    val casado: Boolean = false
    val profesor: Boolean = true
    val hijos = null

    // duck typing
    // si parece un pato
    // si camina como pato
    // si suena como pato
    // si vuela como pato
    // Pato

    //Condicionales

    if(apellido == "Rodríguez" && nombre == "Marco"){
        //println("Verdadero")
    }else{
        //println("Falso")
    }

    val tieneNombreyApellido = if (apellido!=null && nombre!=null) "ok" else "no"
    //println(tieneNombreyApellido)


    estaJalado(1.0)
    estaJalado(8.0)
    estaJalado(0.0)
    estaJalado(7.0)
    estaJalado(10.0)
    //println("------------")
    holaMundo("Marco")
    holaMundoAvanzado(2)
    val total = sumarDosNumeros(1,3)
    //println(total)
    //Importante: numUno y numDos los pone el editor de texto

    val arregloCumpleanos: Array<Int> = arrayOf(1,2,3,4)

    var arregloTodo: Array<Any> = arrayOf(1,"asd",10.2,true)

    arregloCumpleanos[0] = 5
    arregloCumpleanos.set(0,5)

    arregloTodo = arrayOf(5,2,3,4)

    //val notas:ArrayList<Int> = arrayListOf<Int>(1,2,3,4,5,6)

    val notas = arrayListOf<Int>(1,2,3,4,5,6)

    //Map itera y modifica el arreglo
    //Impares + 1 Pares + 2
    val notasDos = notas.map { nota ->
        when(nota%2) {
            1 -> {
                nota + 1
            }
            else -> {
                nota + 2
            }

        }

    }

    notasDos.forEach{
        //println("Notas 2: $it")
    }

    //println("----------------")

    //ForEach -> Itera el arreglo
    notas.forEachIndexed { indice, nota ->
        //println("Indice: $indice")
        //println("Nota: $nota")

        //return Unit
    }

    //println("-------------------")

    val respuestaFilter = notas.filter {//filtra el arreglo
        it in 3..4
        //it > 2 && it < 5
    }.map { //mutar o cambiar el arreglo
        it * 2
    }

    respuestaFilter.forEach{ println(it)}


    val novias = arrayListOf(1,2,2,3,4,5)

    val respuestaNovia: Boolean = novias.any{
        it == 3
    }

    //println(respuestaNovia) //true

    val tazos = arrayListOf(1,2,3,4,5,6,7)

    val respuestaTazos = tazos.all {
        it > 1
    }

    //println(respuestaTazos) //false

    val totalTazos = tazos.reduce { valorAcumulado, tazo ->
        valorAcumulado + tazo
    }

    //println(totalTazos)


    //val fecha = Date()
    //fecha.time = 11231231
    //fecha.year = 2000
    //fecha = Date(1989,6,10)

    val numerito = Numero(1.toString())

}

fun holaMundo(mensaje:String):Unit{
    println("Mensaje: $mensaje.")
}

fun holaMundoAvanzado(mensaje:Any):Unit{
    println("Mensaje: $mensaje.")
}

fun sumarDosNumeros(numUno: Int, numDos: Int):Int{

    return numUno + numDos
}

fun estaJalado(nota: Double): Double {
    when (nota) {
        7.0 ->{
            println("Pasaste con las justas")
        }
        10.0 ->{
            println("Genial :D felicitaciones")
        }
        0.0 ->{
            println("Dios mio que vago")
        }
        else -> {
            println("Tu nota es: $nota")
            //println("Tu nota es: ${nota}")
        }
    }
    return nota
}

//NUEVO TEMA

class Usuario(val cedula:String){

    public var nombre:String = ""
    public var apellido:String = "";

    constructor(cedula: String, apellido:String):this(cedula) {
        this.apellido = apellido
    }
}

class Numero(var numero:Int){
    constructor(numeroString:String):this(numeroString.toInt()){
        println("Constructor")
    }

    init {
        println("INIT")
    }
}



class UsuarioKT(public var nombre:String, public var apellido:String,
                private var id:Int, protected var id_:Int){

    init {

    }

    public fun hola():String{
        return this.apellido
    }
    private fun hola2(){

    }
    protected fun hola3(){

    }

    companion object {
        val gravedad = 10.5
        fun correr(){
            println("Estoy corriendo en $gravedad")
        }
    }
}

class BaseDeDatos{
    companion object {
        val usuarios = arrayListOf(1,2,3)
        fun agregarUsuario(usuario:Int){
            this.usuarios.add(usuario)
        }
    }
}

fun aa(){
    UsuarioKT.gravedad //propiedad
    UsuarioKT.correr() //metodo
}

open class Numeros(var numeroUno:Int, var numeroDos:Int){

}
class Suma(numeroUnos:Int,numeroDoss:Int):Numeros(numeroUnos,numeroDoss){

}

fun cc(){
    val a = Suma(1,2)
}

fun a(){
    var marco = UsuarioKT("a","b",1,2)
}

//Int? a veces va a ser nuelo

fun presley(requerido:Int, opcional:Int = 1, nulo:UsuarioKT?){
    if(nulo !=  null){
        nulo.nombre
    }
    val nombresito:String? = nulo?.nombre.toString()
    nulo!!.nombre
}
 fun cd(){
     presley(requerido = 1, nulo = null) //Named Parameters
     presley(1,1,null)
     presley(1,1,null)
 }



