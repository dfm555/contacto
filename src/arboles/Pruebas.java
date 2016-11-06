package arboles;

import comun.Contacto;

import java.util.Map;

/**
 * Created by Developer on 10/30/16.
 */
public class Pruebas {

    public static void main(String[] args) {
        DirectorioContactos<Contacto> directorio = new DirectorioContactos<Contacto>();
        directorio.add(new Contacto("Carlos", "3017517366", "Carrera 66", "carlosrestrepo.315@gmail.edu.c"));
        directorio.add(new Contacto("Andres", "3005683327", "Calle 234", "andres@gmail.co"));
        directorio.add(new Contacto("Maria", "3017654567", "Avenida 33", null));
        directorio.add(new Contacto("Isabel", "3126577562", "Calle 10", "isabel@gmail.com"));
        directorio.add(new Contacto("Duber", "3186490021", "Esquina 15", "duber@gmail.com"));
        directorio.add(new Contacto("Yording", "3009893618", "El callejón", "yording@gmail.com"));
        directorio.add(new Contacto("Oscar", "3197354837", "Transversal superior", "OSCAR@gmail.com"));

        System.out.println("Prueba - Buscar por nombre:");
        Contacto contacto = directorio.buscarPorNombre("Duber");
        System.out.println(contacto != null ? contacto.toString() : "Contacto no encontrado - " + contacto);

        //String isa = "Isabel";
        //String maria = "isabel";

        //System.out.println(isa.compareTo(maria));

        //Contacto cIsa = new Contacto("Isabel", "3126577562", "Carrera 66", "carlosrestrepo.315@gmail.com");
        //Contacto cMaria = new Contacto("Maria", "3017654567", "Carrera 66", "carlosrestrepo.315@gmail.com");
        //System.out.println(cIsa.compareTo(cMaria));

        System.out.println("\nPrueba - Nodos por nivel:");
        Map<Integer, Integer> niveles = directorio.obtenerNodosPorNivel();
        for (int i = 0; i < niveles.size(); i++) {
            System.out.println("En el nivel " + i + " hay : " + niveles.get(i) + " nodos.");
        }

        //System.out.println("\nPrueba - Orden alfabético:");
        //System.out.println(directorio.ordenAlfabetico());

        System.out.println("Prueba - Jerarquia:");
        System.out.println(directorio.jerarquia());

        //System.out.println("\nPrueba - Eliminar nodo:");
        //boolean eliminado = directorio.remove("Isabel");
        /*if (eliminado) {
            System.out.println(directorio.ordenAlfabetico());
        }*/

        System.out.println("\nPrueba - El árbol es completo ?:");
        boolean esCompleto = directorio.esCompleto();
        System.out.println(esCompleto ? "El árbol es completo." : "El árbol no es completo.");

        System.out.println("\nPrueba - Buscar por email:");
        NodoBinario<Contacto> contactoPorEmail = directorio.buscarPorEmail("OScAR@gmail.com");
        System.out.println(contactoPorEmail != null ? contactoPorEmail.getItem().toString() : "Contacto no encontrado - " + contactoPorEmail);

        System.out.println("\nPrueba - Nodos por cadena:");
        NodoBinario<Contacto> contactoPorCadena = directorio.buscarPorCadena("CAR");
        System.out.println(contactoPorCadena != null ? contactoPorCadena.getItem().toString() : "Contacto no encontrado - " + contactoPorCadena);

        System.out.println("\nPrueba - Contactos con email inválido:");
        System.out.println(directorio.contactosConEmailInvalido());
    }
}
