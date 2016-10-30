/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author estudiante
 */
public class panelDatos extends JPanel {

    private JLabel lblnombre,lbltelefono,lblpostal,lblemail;
    private JTextField txtnombre,txttelefono,txtpostal,txtemail;

    public panelDatos() {

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
