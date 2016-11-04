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


public class DialogoEliminarContacto extends JDialog  implements ActionListener{
    private final JLabel lblnombre;
    private final JTextField txtnombre;
    private final JButton btneliminar;
    private final InterfazDirectorioContactos ventanaPrincipal;

    public DialogoEliminarContacto(InterfazDirectorioContactos interfaz) {
        ventanaPrincipal = interfaz;

        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(300, 50));

        lblnombre = new JLabel("Nombre ");
        txtnombre = new JTextField();
        btneliminar = new JButton("Eliminar");
        btneliminar.setActionCommand("ELIMINAR");
        btneliminar.addActionListener(this);
        add(lblnombre);
        add(txtnombre);
        add(btneliminar);

        setTitle("Buscar Contacto por el Nombre");
        pack();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

     public void accionAlEliminar() {
       String nombre = txtnombre.getText();
      
        if (nombre == null || nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "El nombre no puede ser vacío", "Buscar un Contacto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ventanaPrincipal.eliminarContactoDirectorio(nombre);
        txtnombre.setText("");
        dispose();

    }
    public void actionPerformed(ActionEvent evento) {
        String actionCommand = evento.getActionCommand();

         // Bot�n Eliminar
        if (actionCommand.equals("ELIMINAR")) {
            accionAlEliminar();
        }
    }
}
