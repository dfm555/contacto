package Interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class DialogoBuscarContactoPorCadena extends JDialog  implements ActionListener{
    private final JLabel lblcadena;
    private final JTextField txtcadena;
    private final JButton btnaceptar;
    private final InterfazDirectorioContactos ventanaPrincipal;

    public DialogoBuscarContactoPorCadena (InterfazDirectorioContactos interfaz) {
        ventanaPrincipal = interfaz;

        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(300, 50));

        lblcadena = new JLabel("Cadena ");
        txtcadena = new JTextField();
        btnaceptar = new JButton("Buscar");
        btnaceptar.setActionCommand("BUSCAR");
        btnaceptar.addActionListener(this);

        add(lblcadena);
        add(txtcadena);
        add(btnaceptar);


        setTitle("Buscar Contacto por el cadena");
        pack();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void accionAlBuscar() {
       String cadena = txtcadena.getText();
      
        if (cadena == null || cadena.equals("")) {
            JOptionPane.showMessageDialog(this, "El cadena no puede ser vacío", "Buscar un Contacto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ventanaPrincipal.buscarContactoPorCadena(cadena);
        txtcadena.setText("");
        dispose();

    }
 
    public void actionPerformed(ActionEvent evento) {
        String actionCommand = evento.getActionCommand();

        // Boton buscar
        if (actionCommand.equals("BUSCAR")) {
            accionAlBuscar();
        }
    }
}
