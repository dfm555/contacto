package Interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import comun.Contacto;
import comun.Directorio;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class InterfazDirectorioContactos extends JFrame {

    private final PanelDirectorioContactos panelDirectorio;
    private final PanelResultado panelResultado;
    private DialogoBuscarContacto dialogoBuscar;
    private Contacto contactos;
    private final Directorio directorio;
    private final panelOperaciones panelOperaciones;
    private final panelDatos panelDatos;
    public InterfazDirectorioContactos() {

        directorio = new Directorio();

        JPanel panelSuperior = new JPanel(new BorderLayout());
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelDirectorio = new PanelDirectorioContactos(this, directorio);
        panelDatos = new panelDatos(this);
        panelResultado = new PanelResultado(this);
        panelOperaciones = new panelOperaciones(this);
        panelSuperior.add(panelDatos, BorderLayout.NORTH);
        panelSuperior.add(panelDirectorio, BorderLayout.CENTER);
        panelCentral.add(panelResultado, BorderLayout.CENTER);
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(panelOperaciones, BorderLayout.CENTER);
        dialogoBuscar = new DialogoBuscarContacto(this );
        setPreferredSize(new Dimension(700, 500));

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        setTitle("Directorio de Contactos");
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
        });
    }
    //dialogo para busca contacto
    public void abrirDialogoBuscarContacto() {
        dialogoBuscar.setLocation(calculaPosicionCentral(this, dialogoBuscar));
        dialogoBuscar.setVisible(true);
        dialogoBuscar.setModal(true);
    }
     public void eliminarContacto() {
         try {
               
                int filaSeleccionada = panelDirectorio.getTablaDirectorio().getSelectedRow();

                if (filaSeleccionada == -1) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar primero un contacto en el directorio para borrarlo", "Directorio de Contactos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Contacto contacto = (Contacto) panelDirectorio.getTablaDirectorio().getValueAt(filaSeleccionada, -1);

                boolean res = directorio.remove(contacto.getNombre());
                if(res){
                    panelDirectorio.actualizarDirectorio();
                    panelResultado.mostrarResultado("El contacto se eliminó sastisfactoriamente");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar primero un contacto en el directorio para borrarlo", "Directorio de Contactos", JOptionPane.WARNING_MESSAGE);
                return;
            }
    }
    public void adicionarContactoDirectorio() {
        String nombre, telefono, postal, email;
        nombre = panelDatos.getTxtNombre();
        telefono = panelDatos.getTxtTelefono();
        postal = panelDatos.getTxtPostal();
        email = panelDatos.getTxtEmail();

        if (nombre == null || nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "El nombre no puede ser vacío", "Adicionar un Contacto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (telefono == null || telefono.equals("")) {
            JOptionPane.showMessageDialog(this, "El teléfono no puede ser vacío", "Adicionar un Contacto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (postal == null || postal.equals("")) {
            JOptionPane.showMessageDialog(this, "La dirección postal no puede ser vacía", "Adicionar un Contacto", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (email == null || email.equals("")) {
            JOptionPane.showMessageDialog(this, "El Email no puede ser vacío", "Adicionar un Contacto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (existeContacto(nombre)) {
            JOptionPane.showMessageDialog(this, "Ya existe un contacto con el mismo Nombre", "Adicionar un Contacto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        Contacto nuevoContacto = new Contacto(nombre, telefono, postal, email);
        directorio.adicionarContactoDirectorio(nuevoContacto);
        panelDirectorio.actualizarDirectorio();
        panelDatos.setTxtNombre("");
        panelDatos.setTxtTelefono("");
        panelDatos.setTxtPostal("");
        panelDatos.setTxtEmail("");

    }

    public void mostrarContactosAlfabeticamente() {
        directorio.ordenAlfabetico();
        panelDirectorio.actualizarDirectorio();
    }

    public void mostrarJerarquiaArbol() {
        String resultado = directorio.jerarquia();
        panelResultado.mostrarResultado(resultado);
    }

    public void buscarContactoPorNombre(String nombre) {
        String resultado = directorio.buscarPorNombre(nombre);
        panelResultado.mostrarResultado(resultado);
    }

    public boolean existeContacto(String nombre) {
        boolean esta = false;
        Contacto contactoObtenido = directorio.buscarContacto(nombre);
        if (null != contactoObtenido) {
            esta = true;
        }
        return esta;
    }

    public void eliminarContactoDirectorio(String nombre) {
        boolean resultado = directorio.remove(nombre);
        if(resultado){
            panelResultado.mostrarResultado("El contacto se eliminó sastisfactoriamente");
            panelDirectorio.actualizarDirectorio();
        }
        else{
            panelResultado.mostrarResultado("El contacto no existe");
        }
        
       
        
    }
    public void elArbolEsCompleto(){
        String resultado = directorio.esCompleto();
        panelResultado.mostrarResultado(resultado);
    }
    public void obtenerElNumeroDeNodosPorNivel(){
        String resultado = directorio.obtenerNodosPorNivel();
        panelResultado.mostrarResultado(resultado);
    }
    private Point calculaPosicionCentral(Component componentePadre, Component componenteHijo) {
        Dimension tamanoPantalla, tamanoPadre, tamanoHijo;
        Point localizacionPadre;

        // Centra la ventana y verifica que no sea mayor que la resoluci�n
        // actual
        tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int max_y = tamanoPantalla.height;
        int min_y = 0;

        // Tama�o de la resoluci�n de la pantalla
        tamanoPadre = componentePadre.getSize();
        localizacionPadre = componentePadre.getLocation();
        tamanoHijo = componenteHijo.getSize();
        int x = (tamanoPadre.width - tamanoHijo.width) / 2 + localizacionPadre.x;
        int y = (tamanoPadre.height - tamanoHijo.height) / 2 + localizacionPadre.y;

        // Ajuste para abajo
        if (y + tamanoHijo.height > max_y) {
            y = max_y - tamanoHijo.height;
        }

        // Ajuste para arriba
        if (y < min_y) {
            y = 0;
        }
        return new Point(x, y);
    }

    public void cerrarVentana() {
        int response = JOptionPane.showOptionDialog(this, "Desea cerrar la ventana",
                "Cerrar Ventana",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new String[]{"Si", "No"}, "Default");

        if (response == JOptionPane.OK_OPTION) {
            dispose();
        }
    }

    public static void main(String[] args) {
        try {
            InterfazDirectorioContactos gui = new InterfazDirectorioContactos();
            gui.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
