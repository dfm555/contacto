package comun;

import arboles.NodoBinario;
import java.util.ArrayList;
import java.util.Map;

public class Directorio {

    private ArrayList directorio;
    private arboles.DirectorioContactos directorioABB;

    public Directorio() {
        directorio = new ArrayList();
        directorioABB = new arboles.DirectorioContactos();
    }

    //metodo para agregar un nuevo contacto
    public void adicionarContactoDirectorio(Contacto nuevoContacto) {
        Contacto contacto = buscarContacto(nuevoContacto.getNombre());
        if (contacto == null) {
            directorio.add(nuevoContacto); //agrega contacto al arraylist de contactos
            directorioABB.add(nuevoContacto); //agrega al arbol de directorio abb
        }
    }

    //metodo para mostrar los contactos orden alfabetico
    public void ordenAlfabetico() {
        directorio = directorioABB.ordenAlfabetico();
    }

    //metodo para mostrar la estructura jerarquica de un arbol
    public String jerarquia() {
        return directorioABB.jerarquia();
    }

    //Metodo Para buscar un contacto por el nombre
    public String buscarPorNombre(String nombre) {
        Contacto contacto = directorioABB.buscarPorNombre(nombre);
        if (contacto != null) {
            return contacto.toString();
        }
        return "No existe el contacto con el nombre indicado";
    }
    //eliminar un contacto
    public boolean remove(String nombre) {
        boolean eliminar = directorioABB.remove(nombre);
        if (eliminar) {
                directorio.remove(buscarContacto(nombre));
                return eliminar;
        }
        return eliminar;
    }
    public String esCompleto(){
        boolean res = directorioABB.esCompleto();
        if(res)
            return "El árbol es completo";
        return "El árbol es incompleto";
    }
    //obtener el numero de nodos por nivel
    public String obtenerNodosPorNivel(){
        Map<Integer, Integer> niveles = directorioABB.obtenerNodosPorNivel();
        String nodos = "";
        for (int i = 0; i < niveles.size(); i++) {
            nodos+="En el nivel " + i + " hay : " + niveles.get(i) + " nodos.\n";
        }
        return nodos;
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
    public String buscarPorEmail(String email){
        NodoBinario contacto = directorioABB.buscarPorEmail(email);
        if (contacto != null) {
            return contacto.getItem().toString();
        }
        return "No existe un contacto con email indicado";
    }

}
