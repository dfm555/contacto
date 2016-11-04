package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import comun.Directorio;

public class PanelDirectorioContactos extends JPanel {

    private TablaModeloDirectorio directorio;
    private JTable tablaDirectorio;
    private JScrollPane desplazamientoPanel;
    private InterfazDirectorioContactos ventanaPrincipal;

    public PanelDirectorioContactos(InterfazDirectorioContactos interfaz, Directorio directorioContactos) {
        ventanaPrincipal = interfaz;

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(5, 1, 5, 1));
        setBorder(BorderFactory.createTitledBorder("Directorio Contactos"));

    
        directorio = new TablaModeloDirectorio(directorioContactos);
        tablaDirectorio = new JTable(directorio);
        tablaDirectorio.setPreferredScrollableViewportSize(new Dimension(480, 100));

        desplazamientoPanel = new JScrollPane(tablaDirectorio);
        add(desplazamientoPanel, BorderLayout.CENTER);

    }

    public void actualizarDirectorio() {
        directorio.fireTableDataChanged();
    }

}
