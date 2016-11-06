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


public class DialogoBuscarContactoPorEmail extends JDialog  implements ActionListener{
    private final JLabel lblemail;
    private final JTextField txtemail;
    private final JButton btnaceptar;
    private final InterfazDirectorioContactos ventanaPrincipal;

    public DialogoBuscarContactoPorEmail (InterfazDirectorioContactos interfaz) {
        ventanaPrincipal = interfaz;

        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(300, 50));

        lblemail = new JLabel("Email ");
        txtemail = new JTextField();
        btnaceptar = new JButton("Buscar");
        btnaceptar.setActionCommand("BUSCAR");
        btnaceptar.addActionListener(this);

        add(lblemail);
        add(txtemail);
        add(btnaceptar);


        setTitle("Buscar Contacto por el email");
        pack();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void accionAlBuscar() {
       String email = txtemail.getText();
      
        if (email == null || email.equals("")) {
            JOptionPane.showMessageDialog(this, "El email no puede ser vacío", "Buscar un Contacto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ventanaPrincipal.buscarContactoPorEmail(email);
        txtemail.setText("");
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
