package Interfaz;

import comun.DirectorioContactos;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class panelDatos extends JPanel {

    private JLabel lblnombre,lbltelefono,lblpostal,lblemail;
    private JTextField txtnombre,txttelefono,txtpostal,txtemail;
    private InterfazDirectorioContactos ventanaPrincipal;

    public panelDatos(InterfazDirectorioContactos interfaz) {

        ventanaPrincipal=interfaz;
        lblnombre = new JLabel("Nombre del Contacto:", SwingConstants.LEFT);
        txtnombre = new JTextField();
        lbltelefono = new JLabel("Teléfono del Contacto:", SwingConstants.LEFT);
        txttelefono = new JTextField();
        lblpostal = new JLabel("Dirección Postal:", SwingConstants.LEFT);
        txtpostal = new JTextField();
        lblemail = new JLabel("Correo Electrónico:", SwingConstants.LEFT);
        txtemail = new JTextField();

        setLayout(new GridLayout(4, 1));
        setBorder(BorderFactory.createTitledBorder("Datos Contacto"));

        add(lblnombre);
        add(txtnombre);
        add(lbltelefono);
        add(txttelefono);
        add(lblpostal);
        add(txtpostal);
        add(lblemail);
        add(txtemail);

    }
   
}
