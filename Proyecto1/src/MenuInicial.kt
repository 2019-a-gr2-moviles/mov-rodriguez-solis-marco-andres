import java.awt.*
import javax.swing.*
import javax.swing.table.DefaultTableModel

fun main(args: Array<String>) {
    val pantallaInicial: MenuPrincipal = MenuPrincipal()
    pantallaInicial.showEventDemo()
    pantallaInicial.show()
}

class MenuPrincipal: JFrame() {

    private val botonVer: JButton = JButton("Ver")
    private val botonActualizar: JButton = JButton("Actualizar")
    private val botonEliminar: JButton = JButton("Eliminar")
    private val botonInsertar: JButton = JButton("Insertar")
    private val panel: JPanel = JPanel()
    private val listaHeroes: Lista = Lista()
    val labelImagen: JLabel = JLabel("")
    val iconLogo: ImageIcon  =  ImageIcon("src/imagen/descarga.png")

    init {
        labelImagen.icon = iconLogo
        createUI()
    }

    private fun createUI() {

        panel.setLayout(null)
        panel.add(botonVer)
        botonVer.setBounds(65, 10, 150, 40)
        panel.add(botonActualizar)
        botonActualizar.setBounds(65, 60, 150, 40)
        panel.add(botonEliminar)
        botonEliminar.setBounds(65, 110, 150, 40)
        panel.add(botonInsertar)
        botonInsertar.setBounds(65, 160, 150, 40)
        panel.add(labelImagen)
        labelImagen.setBounds(30, 210, 250, 250 )

        this.add(panel)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 500)
        setLocationRelativeTo(null)
    }

    internal fun showEventDemo() {

        botonActualizar.apply {
            addActionListener {
                val frameActualizar = ActualizarHeroe("Actualizar Heroe", listaHeroes)
                frameActualizar.showEventDemo()
                frameActualizar.show()
            }
        }
        botonEliminar.apply {
            addActionListener {
                val frameEliminar = EliminarHeroe("Eliminar Heroe", listaHeroes)
                frameEliminar.showEventDemo()
                frameEliminar.show()

            }
        }

        botonInsertar.apply {
            addActionListener {
                val frameInsertar = insertarHeroe("Ingresar Heroes", listaHeroes)
                frameInsertar.showEventDemo()
                frameInsertar.show()
            }
        }

        botonVer.apply {
            addActionListener {
                VerHeroes("Ver Heroe", listaHeroes).show()

            }
        }
    }
}

class insertarHeroe(title: String, listaHeroes: Lista) : JFrame(){
    val panel: JPanel = JPanel()
    val labelIdHeroe: JLabel = JLabel("idHeroe")
    val labelNombre: JLabel = JLabel("Nombre")
    val labelTipo: JLabel = JLabel("Tipo")
    val labelRolPrincipal: JLabel = JLabel("Rol Principal")
    val labelHabilidadFinal: JLabel = JLabel("Habilidad Final")
    val txtIdHeroe: JTextField = JTextField()
    val txtNombre: JTextField = JTextField()
    val txtTipo: JTextField = JTextField()
    val txtRolPrincipal: JTextField = JTextField()
    val txtHabilidadFinal: JTextField = JTextField()
    val botonInsertar: JButton = JButton("Insertar")
    var listaHeroes: Lista

    init {
        this.listaHeroes = listaHeroes
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        panel.layout = null

        labelIdHeroe.setBounds(5, 5, 150, 25)
        txtIdHeroe.setBounds(160, 5, 150, 25)

        labelNombre.setBounds(5, 35, 150, 25)
        txtNombre.setBounds(160, 35, 150, 25)

        labelTipo.setBounds(5, 65, 150, 25)
        txtTipo.setBounds(160, 65, 150, 25)

        labelRolPrincipal.setBounds(5, 95, 150, 25)
        txtRolPrincipal.setBounds(160, 95, 150, 25)

        labelHabilidadFinal.setBounds(5, 125, 150, 25)
        txtHabilidadFinal.setBounds(160, 125, 150, 25)

        botonInsertar.setBounds(90, 170, 130, 30)
        panel.layout = null
        panel.add(labelIdHeroe)
        panel.add(txtIdHeroe)

        panel.add(txtNombre)
        panel.add(labelNombre)

        panel.add(labelTipo)
        panel.add(txtTipo)

        panel.add(labelRolPrincipal)
        panel.add(txtRolPrincipal)

        panel.add(labelHabilidadFinal)
        panel.add(txtHabilidadFinal)

        panel.add(botonInsertar)

        this.add(panel)
        setSize(340, 250)
        setLocationRelativeTo(null)
    }

    internal fun showEventDemo() {

        botonInsertar.apply {
            addActionListener {
                if (txtIdHeroe.text != "") {
                    val idHeroe = txtIdHeroe.text
                        val nombre = txtNombre.text
                        val tipo = txtTipo.text
                        val rolPrincipal = txtRolPrincipal.text
                        val habilidadFinal = txtHabilidadFinal.text

                        listaHeroes.insertarHeroe(
                            idHeroe, nombre, tipo, rolPrincipal, habilidadFinal
                        )
                        JOptionPane.showMessageDialog(null, "Se ingreso correctamente")
                    } else {
                        JOptionPane.showMessageDialog(null, "ID ya existente")
                    }
                }
            }
        }
    }


class VerHeroes(title: String, listaHeroes: Lista): JFrame() {

    val frameRegresar: JFrame = JFrame()
    val JPanel = JPanel()
    val tabla: JTable = JTable()
    val listaHeroes: Lista
   // val botonBack: JButton = JButton("Regresar")

    init {
        this.listaHeroes = listaHeroes
        createUI(title)

    }

    private fun createUI(title: String) {
        frameRegresar.add(JPanel)
        setTitle(title)
        val layout = BorderLayout()
//        frameRegresar.add(JPanel)
        JPanel.layout = layout
        tabla.model = llenarTabla()
        JPanel.add(tabla, BorderLayout.NORTH)
      //  JPanel.add(botonBack)
        this.add(JPanel)
        setSize(600, 150)
        setLocationRelativeTo(null)
    }

    private fun llenarTabla(): DefaultTableModel {
        val tabla = DefaultTableModel()
        tabla.addColumn("idHeroes")
        tabla.addColumn("Nombre")
        tabla.addColumn("Tipo")
        tabla.addColumn("Rol Principal")
        tabla.addColumn("Habilidad Final")
        tabla.addRow(arrayOf("idHeroe", "Nombre", "Tipo", "Rol Principal", "Habilidad Final"))
        listaHeroes.obtenerHeroes().forEach { heroeActual: Heroe -> tabla.addRow(
                arrayOf(heroeActual.getIdHeroe(), heroeActual.getNombre(), heroeActual.getTipo(), heroeActual.getRolPrincipal(), heroeActual.getHabilidadFinal()
                )
            )
        }
        return tabla
    }

    /*internal fun showEventDemo() {

        botonBack.apply {
            addActionListener {
                println("Si entra")

                frameRegresar.dispose()
                frameRegresar.dispatchEvent(WindowEvent(frameRegresar, WindowEvent.WINDOW_CLOSING))
                /*val frameMenu: MenuPrincipal = MenuPrincipal("Dota2")
                frameMenu.showEventDemo()
                frameMenu.show()*/
            }
        }
    }*/
}

class ActualizarHeroe(title: String, listaHeroes: Lista): JFrame() {

    val labelIdHeroe: JLabel = JLabel("idHeroe")
    val labelNombre: JLabel = JLabel("Nombre")
    val labelTipo: JLabel = JLabel("Tipo")
    val labelRolPrincipal: JLabel = JLabel("Rol Principal")
    val labelHabilidadFinal: JLabel = JLabel("Habilidad Final")
    val txtIdHeroe: JTextField = JTextField()
    val txtNombre: JTextField = JTextField()
    val txtTipo: JTextField = JTextField()
    val txtRolPrincipal: JTextField = JTextField()
    val txtHabilidadFinal: JTextField = JTextField()
    val botonEditar: JButton = JButton("Editar")
    val botonActualizar: JButton = JButton("Actualizar")
    val JPanel = JPanel()
    val table: JTable = JTable()
    val listaHeroes: Lista


    init {
        this.listaHeroes = listaHeroes
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        JPanel.layout = null
        table.model = llenarTabla()

        table.setBounds(5,5,550,100)

        botonEditar.setBounds(220, 130, 100, 30)
        botonActualizar.setBounds(220, 345, 100, 30)

        labelIdHeroe.setBounds(100, 185, 150, 25)
        txtIdHeroe.setBounds(250, 185, 150, 25)

        labelNombre.setBounds(100, 215, 150, 25)
        txtNombre.setBounds(250, 215, 150, 25)

        labelTipo.setBounds(100, 245, 150, 25)
        txtTipo.setBounds(250, 245, 150, 25)

        labelRolPrincipal.setBounds(100, 275, 150, 25)
        txtRolPrincipal.setBounds(250, 275, 150, 25)

        labelHabilidadFinal.setBounds(100, 305, 150, 25)
        txtHabilidadFinal.setBounds(250, 305, 150, 25)

        JPanel.layout = null
        JPanel.add(labelIdHeroe)
        JPanel.add(txtIdHeroe)

        JPanel.add(txtNombre)
        JPanel.add(labelNombre)

        JPanel.add(labelTipo)
        JPanel.add(txtTipo)

        JPanel.add(labelRolPrincipal)
        JPanel.add(txtRolPrincipal)

        JPanel.add(labelHabilidadFinal)
        JPanel.add(txtHabilidadFinal)

        JPanel.add(table)
        JPanel.add(botonEditar)
        JPanel.add(botonActualizar)


        this.add(JPanel)
        //defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(580, 450)
        setLocationRelativeTo(null)
    }

    private fun llenarTabla(): DefaultTableModel {
        val tabla = DefaultTableModel()

        tabla.addColumn("idHeroes")
        tabla.addColumn("Nombre")
        tabla.addColumn("Tipo")
        tabla.addColumn("Rol Principal")
        tabla.addColumn("Habilidad Final")

        tabla.addRow(arrayOf("idHeroe", "Nombre", "Tipo", "Rol Principal", "Habilidad Final"))

        listaHeroes.obtenerHeroes().forEach { heroeActual: Heroe ->
            tabla.addRow(
                arrayOf(heroeActual.getIdHeroe(), heroeActual.getNombre(), heroeActual.getTipo(), heroeActual.getRolPrincipal(), heroeActual.getHabilidadFinal()
                )
            )
        }
        return tabla
    }

    internal fun showEventDemo() {

        botonEditar.apply {
            addActionListener {
                var i = table.getSelectedRow();
                if(i!=-1){
                    var idHeroe = table.getValueAt(i,0)
                    var nombre = table.getValueAt(i,1)
                    var tipo = table.getValueAt(i,2)
                    var rol = table.getValueAt(i,3)
                    var habilidad = table.getValueAt(i,4)

                    txtIdHeroe.text = idHeroe.toString()
                    txtNombre.text = nombre.toString()
                    txtTipo.text = tipo.toString()
                    txtRolPrincipal.text = rol.toString()
                    txtHabilidadFinal.text = habilidad.toString()

                }else{
                    JOptionPane.showMessageDialog(null,"Debe escoger un registro");
                }
            }
        }

        botonActualizar.apply {
            addActionListener {
                var i = table.getSelectedRow();
                listaHeroes.actualizarHeroeBoton(txtIdHeroe.text, txtNombre.text, txtTipo.text, txtRolPrincipal.text, txtHabilidadFinal.text,table.getValueAt(i,1).toString())
                table.model = llenarTabla()
            }
        }
    }
}



class Eliminar2(title: String, listaHeroes: Lista):JFrame(){
    val JPanel = JPanel()
    val table: JTable = JTable()
    val listaHeroes: Lista

    init {
        this.listaHeroes = listaHeroes
        createUI(title)
    }
    private fun createUI(title: String) {
        setTitle(title)
        val layout = BorderLayout()
        JPanel.layout = layout
        table.model = llenarTabla()
        JPanel.add(table, BorderLayout.NORTH)
        this.add(JPanel)
        //defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 150)
        setLocationRelativeTo(null)
    }

    private fun llenarTabla(): DefaultTableModel {
        val tabla = DefaultTableModel()

        tabla.addColumn("idHeroes")
        tabla.addColumn("Nombre")
        tabla.addColumn("Tipo")
        tabla.addColumn("Rol Principal")
        tabla.addColumn("Habilidad Final")


        tabla.addRow(arrayOf("idHeroe", "Nombre", "Tipo", "Rol Principal", "Habilidad Final"))

        listaHeroes.obtenerHeroes().forEach { heroeActual: Heroe ->
            tabla.addRow(
                arrayOf(
                    heroeActual.getIdHeroe(),
                    heroeActual.getNombre(),
                    heroeActual.getTipo(),
                    heroeActual.getRolPrincipal(),
                    heroeActual.getHabilidadFinal()
                )
            )

        }
        return tabla
    }
}

class EliminarHeroe(title: String, listaHeroes: Lista) : JFrame() {
        val panel: JPanel = JPanel()
        val boton: JButton = JButton("Eliminar")
        val txtNombre: JTextField = JTextField()
        val table: JTable = JTable()
        var listaHeroes: Lista

        init {
            this.listaHeroes = listaHeroes
            createUI(title)
        }

        private fun createUI(title: String) {
            setTitle(title)
            //panel.layout = GridLayout()
            panel.layout = null
            table.model = llenarTabla()
            table.setBounds(10, 50, 500, 100)
            txtNombre.setBounds(100, 10, 100, 30)
            boton.setBounds(270, 10, 100, 30)
            panel.add(txtNombre)
            panel.add(boton)
            panel.add(table)
            this.add(panel)

            setSize(550, 250)
            setLocationRelativeTo(null)
        }

    private fun llenarTabla(): DefaultTableModel {
        val tabla = DefaultTableModel()

        tabla.addColumn("idHeroes")
        tabla.addColumn("Nombre")
        tabla.addColumn("Tipo")
        tabla.addColumn("Rol Principal")
        tabla.addColumn("Habilidad Final")


        tabla.addRow(arrayOf("idHeroe", "Nombre", "Tipo", "Rol Principal", "Habilidad Final"))

        listaHeroes.obtenerHeroes().forEach { heroeActual: Heroe -> tabla.addRow(
                arrayOf(heroeActual.getIdHeroe(), heroeActual.getNombre(), heroeActual.getTipo(), heroeActual.getRolPrincipal(), heroeActual.getHabilidadFinal()
                )
            )

        }
        return tabla
    }

        internal fun showEventDemo() {
             boton.apply {
                addActionListener {
                        val codigoHeroe = txtNombre.text
                            val mensaje: String = "Está seguro de eliminar el héroe: \n "
                            if (JOptionPane.showConfirmDialog(null, mensaje) == 0) {
                                listaHeroes.eliminarHeroe(codigoHeroe)
                                table.show(false)
                            } else {
                            }
                        }
                    }
                }
            }




