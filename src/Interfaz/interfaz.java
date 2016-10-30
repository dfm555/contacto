/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author estudiante
 */
public class interfaz extends JFrame {

    private PanelResultado resultados;
    private panelOperaciones operaciones;
    private panelDatos datos;

    public interfaz() {

        super("Directorio");
        datos = new panelDatos();
        resultados = new PanelResultado();
        operaciones = new panelOperaciones(this);

        add(datos, BorderLayout.NORTH);
        add(resultados, BorderLayout.CENTER);
        add(operaciones, BorderLayout.SOUTH);

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
        });
    }

    public void cerrarVentana() {
        int response = JOptionPane.showOptionDialog(this, "Desea cerrar la ventana?",
                "Cerrar Ventana",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new String[]{"Si", "No"}, "Default");

        if (response == JOptionPane.OK_OPTION) {
            dispose();
        }
    }

}
