package Interfaz;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelResultado extends JPanel {

    private JLabel lblresultado;
    private InterfazDirectorioContactos ventanaprincipal;
    public PanelResultado(InterfazDirectorioContactos interfaz) {
        
        ventanaprincipal=interfaz;
        lblresultado = new JLabel("", SwingConstants.CENTER);

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Resultados"));
        add(lblresultado);
    }

    public void mostrarResultado(String results) {
        lblresultado.setText(results);
    }
}
