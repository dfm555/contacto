/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author estudiante
 */
public class PanelResultado extends JPanel {

    private JLabel lblresultado;

    public PanelResultado() {

        lblresultado = new JLabel("", SwingConstants.CENTER);

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Resultados"));
        add(lblresultado);
    }

    public void mostrarResultado(String results) {
        lblresultado.setText(results);
    }
}
