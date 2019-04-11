fun main(args: Array<String>){

    /**
    *comentario
    **/

    // Variables
    // que es mutar? cambiar?
    //Mutables

    var nombre = "Adrian"
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
        println("Verdadero")
    }else{
        println("Falso")
    }

    val tieneNombreyApellido = if (apellido!=null && nombre!=null) "ok" else "no"
    println(tieneNombreyApellido)


    estaJalado(1.0)
    estaJalado(8.0)
    estaJalado(0.0)
    estaJalado(7.0)
    estaJalado(10.0)
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