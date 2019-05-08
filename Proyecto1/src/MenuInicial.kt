import java.awt.*
import javax.swing.*
import javax.swing.table.DefaultTableModel

fun main(args: Array<String>) {


    val frame: MenuPrincipal = MenuPrincipal("DOTA 2")
    frame.showEventDemo()
    frame.show()

    //val frame = JFrame("DOTA 2")

   /* frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.preferredSize = Dimension(300, 300)
    frame.pack()
    frame.setLocationRelativeTo(null)
    frame.isVisible = true

    var btnInsertar = JButton("Insertar")
    var btnVer = JButton("Visualizar")
    var btnActualizar = JButton("Actualizar")
    var btnEliminar = JButton("Eliminar")

    frame.contentPane.add(btnInsertar)
    frame.getContentPane().add(btnVer)
    frame.getContentPane().add(btnActualizar)
    frame.getContentPane().add(btnEliminar)*/
}

class MenuPrincipal(title: String) : JFrame() {

    private val botonVer: JButton = JButton("Ver")
    private val botonActualizar: JButton = JButton("Actualizar")
    private val botonEliminar: JButton = JButton("Eliminar")
    private val botonInsertar: JButton = JButton("Insertar")
    val labelImagen: JLabel = JLabel("")
    val iconLogo: ImageIcon  =  ImageIcon("src/imagen/descarga.png")
    private val panel: JPanel = JPanel()
    private val listaHeroes: ListaHeroes = ListaHeroes()


    init {
        labelImagen.icon = iconLogo
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

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

        botonVer.apply {
            addActionListener {
                BuscarHeroes("Heroes", listaHeroes).show()
            }
        }
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
    }
}

class insertarHeroe(title: String, listaHeroes: ListaHeroes) : JFrame(){
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
    val boton: JButton = JButton("Ingresar")
    var listaHeroes: ListaHeroes

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

        boton.setBounds(90, 170, 130, 30)
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

        panel.add(boton)

        this.add(panel)
        setSize(340, 250)
        setLocationRelativeTo(null)
    }

    internal fun showEventDemo() {

        val botonBuscar = boton.apply {
            addActionListener {
                if (txtIdHeroe.text != "") {
                    val codigoHeroe = txtIdHeroe.text
                    val existe = listaHeroes.existe(codigoHeroe)
                    if (!existe) {

                        val nombre = txtNombre.text
                        val tipo = txtTipo.text
                        val rolPrincipal = txtRolPrincipal.text
                        val habilidadFinal = txtHabilidadFinal.text

                        listaHeroes.insertarHeroe(
                            codigoHeroe, nombre, tipo, rolPrincipal, habilidadFinal
                        )

                        JOptionPane.showConfirmDialog(null, "Está seguro de agregar al Heroe")
                        this.show(false)
                    } else {
                        JOptionPane.showMessageDialog(null, "ID ya existente")
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Llenar campos")
                }
            }
        }
    }
}

class BuscarHeroes(title: String, listaHeroes: ListaHeroes): JFrame() {
    val JPanel = JPanel()
    val tabla: JTable = JTable()
    val listaHeroes: ListaHeroes


    init {
        this.listaHeroes = listaHeroes
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        val layout = BorderLayout()
        JPanel.layout = layout
        tabla.model = llenarTabla()
        JPanel.add(tabla, BorderLayout.NORTH)
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

class ActualizarHeroe(title: String, listaHeroes: ListaHeroes): JFrame() {

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
    val listaHeroes: ListaHeroes


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

    internal fun showEventDemo() {

        val botonBuscar = botonEditar.apply {
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
    /* ventanaactualizar.add(panel, BorderLayout.NORTH);

    ventanaactualizar.getContentPane().add(panelBoton, BorderLayout.CENTER);
    ventanaactualizar.getContentPane().add(panelCampos, BorderLayout.SOUTH);

    //Instancio la tabla
    var dtm=llenarTabla();
    var tabla = JTable(dtm);
    tabla.dragEnabled = false;

    //Creo el scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    panelTabla.add(jsp);

    var botonEscojer = JButton("Editar");
    panelBoton.add(botonEscojer);


    var label1 = JLabel("Tipo:", 10)

    var textTipo = JTextField("", 10)

    var label2 = JLabel("Descripcion:", 10)
    var textDescripcion = JTextField("", 10)

    var label3 = JLabel("Marca:", 10)
    var textMarca = JTextField("", 10)

    var label4 = JLabel("Precio:", 10)
    var textPrecio = JTextField("", 10)

    var boton = JButton("Confirmar actualización");
    var botonvoler = JButton("VOLVER");


    val experimentLayout = GridLayout(5, 2, 20, 20)
    panelCampos.setLayout(experimentLayout);

    panelCampos.add(label1);
    panelCampos.add(textTipo);
    panelCampos.add(label2);
    panelCampos.add(textDescripcion);
    panelCampos.add(label3);
    panelCampos.add(textMarca);
    panelCampos.add(label4);
    panelCampos.add(textPrecio);
    panelCampos.add(botonvoler);
    panelCampos.add(boton);



    ventanaactualizar.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanaactualizar.pack()
    ventanaactualizar.setLocationRelativeTo(null)
    ventanaactualizar.isVisible = true

    botonvoler.addActionListener {
        llamarVentanaInicial();
        ventanaactualizar.dispose();
    }

    var id = -1;
    botonEscojer.addActionListener {
        var i = tabla.getSelectedRow();
        if(i!=-1){
            id = dtm.getValueAt(i, 0).toString().toInt();
            var tipoaux = dtm.getValueAt(i, 1);
            var descaux = dtm.getValueAt(i, 2);
            var marcaaux = dtm.getValueAt(i, 3);
            var precioaux = dtm.getValueAt(i, 4);

            textTipo.text = tipoaux.toString();
            textDescripcion.text = descaux.toString();
            textMarca.text = marcaaux.toString();
            textPrecio.text = precioaux.toString();
        }else{
            JOptionPane.showMessageDialog(null,"Escoja un registro para actualizar!");
        }

    }

    boton.addActionListener {

        if (id != -1 && !textTipo.getText().isEmpty() && !textDescripcion.getText().isEmpty() &&
            !textMarca.getText().isEmpty() && !textPrecio.getText().isEmpty()
        ) {
            actualizarTupla(
                id,
                textTipo.getText(),
                textDescripcion.getText(),
                textMarca.getText(),
                textPrecio.getText().toDouble()
            );

        }


    }
}*/
/*class ModificarZapatos(title: String, listaZapatos: ListaHeroes) : JFrame() {
    private val panel: JPanel = JPanel()
    private val boton: JButton = JButton("Buscar Heroe")
    private val comboCodigos: JComboBox<String> = JComboBox()
    private var listaZapatos: ListaHeroes
    private val listaMarcas = arrayListOf<String>("Adidas", "Puma", "Nike", "Reebook", "Umbro", "Lotto")
    private val listaTipos = arrayListOf<String>("Hombre", "Mujer")
    private val comboMarca: JComboBox<String> = JComboBox()
    private val comboTipo: JComboBox<String> = JComboBox()
    private val comboTalla: JComboBox<String> = JComboBox()


    init {
        listaMarcas.forEach { marca: String ->
            comboMarca.addItem(marca)
        }

        listaTipos.forEach { tipo: String ->
            comboTipo.addItem(tipo)
        }

        this.listaZapatos = listaZapatos


        listaZapatos.obtenerHeroes().forEach { t: Heroe ->
            comboCodigos.addItem(t.getIdHeroe())
        }
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)

        panel.layout = GridLayout()
        //txtCodigo.setSize(200, 100)
        //boton.setSize(100, 100)
        panel.add(comboCodigos)
        panel.add(boton)
        this.add(panel)
        //defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 100)
        setLocationRelativeTo(null)
    }

    internal fun showEventDemo() {

        val botonBuscar = boton.apply {
            //ctionCommand = "Buscar"
            addActionListener {
                if (comboCodigos.selectedIndex > -1) {
                    val codigoZapato = comboCodigos.selectedItem.toString()
                    val existe = listaZapatos.existe(codigoZapato)
                    if (existe) {
                        val color = JOptionPane.showInputDialog("Ingrese el color")
                        val talla = JOptionPane.showInputDialog(
                            "Ingrese la talla: ${comboTalla.getItemAt(0)} - " +
                                    "${comboTalla.getItemAt((comboTalla.itemCount - 1))}"
                        )
                        var mensajeTipo = "Ingrese el tipo: "
                        listaMarcas.forEach { s: String ->
                            mensajeTipo += (", $s")
                        }

                        var mensajeMarca = "Ingrese la marca: "
                        listaMarcas.forEach { s: String ->
                            mensajeMarca += (", $s")
                        }

                        val tipo = JOptionPane.showInputDialog(mensajeTipo)
                        val marca = JOptionPane.showInputDialog(mensajeMarca)
                        val cantidad = JOptionPane.showInputDialog("Ingrese la cantidad")
                        val precio = JOptionPane.showInputDialog("Ingrese el precio")

                        if ((listaMarcas.any { s ->
                                String
                                s.equals(marca)
                            }) &&
                            (listaTipos.any { s: String ->
                                s.equals(tipo)
                            }) &&
                            ((talla.toInt() in 30..42))) {
                            listaZapatos.actualizarHeroe(
                                color,
                                tipo,
                                talla.toInt(),
                                codigoZapato,
                                marca,
                                cantidad.toInt(),
                                precio.toDouble()
                            )

                            JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO SATISFACTORIAMENTE")
                            this.show(false)
                        } else {
                            JOptionPane.showMessageDialog(null, "VALORES DE MARCA, TIPO O TALLA INCORRECTOS")
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "REGISTRO NO EXISTENTE")
                    }

                }
            }
        }
    }
*/

    class EliminarHeroe(title: String, listaHeroes: ListaHeroes) : JFrame() {
        val panel: JPanel = JPanel()
        val boton: JButton = JButton("Buscar")
        val txtNombre: JTextField = JTextField()
        var listaHeroes: ListaHeroes

        init {
            this.listaHeroes = listaHeroes
            createUI(title)
        }

        private fun createUI(title: String) {
            setTitle(title)
            //panel.layout = GridLayout()
            panel.layout = null
            txtNombre.setBounds(10, 10, 100, 30)
            boton.setBounds(150, 10, 100, 30)
            panel.add(txtNombre)
            panel.add(boton)
            this.add(panel)

            setSize(300, 110)
            setLocationRelativeTo(null)
        }

        internal fun showEventDemo() {

            val botonBuscar = boton.apply {
                addActionListener {
                    if (txtNombre.text != "") {
                        val codigoHeroe = txtNombre.text
                        val existe = listaHeroes.existe(codigoHeroe)
                        if (existe) {
                            val mensaje: String = "Está seguro de eliminar el héroe: \n " /*+
                                    "${listaHeroes.obtenerHeroe(codigoHeroe)}"*/
                            if (JOptionPane.showConfirmDialog(null, mensaje) == 0) {
                                listaHeroes.eliminarHeroe(codigoHeroe)
                                this.show(false)

                            } else {
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "REGISTRO NO EXISTENTE")
                        }
                    }

                }
            }
        }
    }


