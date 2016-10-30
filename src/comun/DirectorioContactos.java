package comun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class DirectorioContactos {
   
    private ArrayList directorio;

    public DirectorioContactos() {
        directorio = new ArrayList();
    }

    public void adicionarContactoDirectorio(Contacto nuevoContacto) {
        
    }
    public void eliminarContactoDirectorio(Contacto contacto){
    
    }
    public ArrayList getDirectorio() {
        return directorio;
    }

    public Contacto buscarContacto(Contacto contacto) {
        int indice = 0;
        int totalContactos = directorio.size();
        Contacto contactoEncontrado = null;
        boolean encontrado = false;
        while (indice < totalContactos && !encontrado) {
            contactoEncontrado = (Contacto) directorio.get(indice);
            if (contactoEncontrado.compareTo(contacto)==0) {
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
