
import Interfaz.interfaz;
import arboles.ABB;
import comun.CuentaDeAhorros;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author  Oscar Arenas
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        interfaz interfazContacto =new interfaz();
        interfazContacto.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
        interfazContacto.setSize( 900, 400 ); // establece el tama�o del marco
        interfazContacto.setVisible( true ); // muestra el marco
        interfazContacto.setResizable(false);
        interfazContacto.setLocationRelativeTo(null);

    }

}
