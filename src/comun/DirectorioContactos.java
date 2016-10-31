package comun;

import arboles.Directorio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class DirectorioContactos {
   
    private ArrayList directorio;
    private Directorio directorioABB;
    public DirectorioContactos() {
        directorio = new ArrayList();
        directorioABB=new Directorio();
    }

    public void adicionarContactoDirectorio(Contacto nuevoContacto) {
        Contacto contacto = buscarContacto(nuevoContacto.getNombre());
        System.out.println(nuevoContacto);
        if (contacto == null) {
            directorio.add(nuevoContacto); //agrega contacto al arraylist de contactos
            directorioABB.add(nuevoContacto); //agrega al arbol de directorio abb
        }
    }
    public String ordenAlfabetico(){
        return directorioABB.ordenAlfabetico();
    }
    public void eliminarContactoDirectorio(Contacto contacto){
    
    }
    public ArrayList getDirectorio() {
        return directorio;
    }

    public Contacto buscarContacto(String nombre) {
        int indice = 0;
        int totalContactos = directorio.size();
        Contacto contactoEncontrado = null;
        boolean encontrado = false;
        while (indice < totalContactos && !encontrado) {
            contactoEncontrado = (Contacto) directorio.get(indice);
            if (contactoEncontrado.igualContacto(nombre)) {
                encontrado = true;
            }
            indice++;
        }
        if (encontrado) {
            return contactoEncontrado;
        } else {
            return null;
        }
    }
  

}
