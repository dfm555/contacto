package Interfaz;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class PanelResultado extends JPanel {

    private JTextArea jTextPaneResult;
    private InterfazDirectorioContactos ventanaprincipal;
    public PanelResultado(InterfazDirectorioContactos interfaz) {
        
        ventanaprincipal=interfaz;
        jTextPaneResult = new JTextArea(7, 60);
        JScrollPane scroll = new JScrollPane (jTextPaneResult,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Resultados"));
        add(scroll);
        jTextPaneResult.setEditable(false);
    }

    public void mostrarResultado(String results) {
        jTextPaneResult.setText(results);
    }
}
