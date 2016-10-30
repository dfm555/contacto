
import Interfaz.interfaz;
import arboles.DirectorioDeContactos;
import comun.Contacto;

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
        DirectorioDeContactos<Contacto> directorio = new DirectorioDeContactos<>();
        directorio.add(new Contacto("Andres","","",""));
        directorio.add(new Contacto("Bernardo","","",""));
        directorio.add(new Contacto("Camilo","","",""));
        directorio.add(new Contacto("Duber","","",""));
        directorio.add(new Contacto("Eduard","","",""));
        directorio.add(new Contacto("Fernando","","",""));
        directorio.add(new Contacto("Gabriela","","",""));
        directorio.add(new Contacto("Alberto","","",""));
        directorio.add(new Contacto("Ana","","",""));
        directorio.add(new Contacto("Bibiana","","",""));


        System.out.println(directorio.ordenAlfabetico());
        directorio.jerarquia();
    }

}
