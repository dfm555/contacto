/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author estudiante
 */
public class panelOperaciones extends JPanel implements ActionListener {

    private JButton btnagregarcontacto, btneliminarcontacto, btnmostrarcontactos, btnjerarquia,btnmostrarresultados2;
    private interfaz grafica;
    
    public panelOperaciones(interfaz grafica) {

        this.grafica = grafica;
        btnagregarcontacto = new JButton("Agr.Contacto");
        btneliminarcontacto = new JButton("Eli.Contacto");
        btnmostrarcontactos = new JButton("Mos.contactos");
        btnjerarquia = new JButton("Arb.Jerárquico");
        btnmostrarresultados2 = new JButton("Mos.Resultados-2");

        setLayout(new GridLayout(1, 4));
        setBorder(BorderFactory.createTitledBorder("Operaciones"));

        add(btnagregarcontacto);
        add(btneliminarcontacto);
        add(btnmostrarcontactos);
        add(btnjerarquia);
        add(btnmostrarresultados2);

    }
     @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
