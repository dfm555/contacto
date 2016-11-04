package Interfaz;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.table.AbstractTableModel;

import comun.Contacto;
import comun.DirectorioContactos;


public class TablaModeloDirectorio extends AbstractTableModel {

  
    private String[] nombresColumnas;
    private DirectorioContactos directorio;

    public TablaModeloDirectorio(DirectorioContactos unDirectorio) {
        super();
        directorio = unDirectorio;
        String[] nombresColumnasAux = {"Nombre", "Telefono", "Postal", "Email"};
        nombresColumnas = nombresColumnasAux;
    }

    public int getRowCount() {
        return directorio.getDirectorio().size();
    }

    public int getColumnCount() {
        return nombresColumnas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object datoContacto = null;
        Object[] directorioContacto = directorio.getDirectorio().toArray();
        Contacto contacto = (Contacto) directorioContacto[rowIndex];

        if (columnIndex == -1) {
            datoContacto = contacto;
        } else if (columnIndex == 0) {
            datoContacto = contacto.getNombre();
        } else if (columnIndex == 1) {
            datoContacto = contacto.getTelefono();
        } else if (columnIndex == 2) {
            datoContacto = contacto.getDireccionPostal();
        }else if (columnIndex == 3) {
            datoContacto = (contacto.getEmail());
        }

        return datoContacto;
    }

   
    public String getColumnName(int col) {
        return nombresColumnas[col];
    }

    public boolean isCellEditable(int fila, int col) {
        return false;
    }


}
