package arboles;

import comun.Contacto;

import java.util.Map;

/**
 * Created by Developer on 10/30/16.
 */
public class Pruebas {

    public static void main(String[] args) {
        DirectorioContactos<Contacto> directorio = new DirectorioContactos<Contacto>();
        directorio.add(new Contacto("Carlos", "3017517366", "Carrera 66", "carlosrestrepo.315@gmail.com"));
        directorio.add(new Contacto("Andres", "3005683327", "Carrera 66", "andres@gmail.com"));
        directorio.add(new Contacto("Maria", "3017654567", "Carrera 66", null));
        directorio.add(new Contacto("Isabel", "3126577562", "Carrera 66", "isabel@gmail.com"));
        directorio.add(new Contacto("Duber", "3186490021", "Carrera 66", "duber@gmail.com"));
        directorio.add(new Contacto("Yording", "3009893618", "Carrera 66", "yording@gmail.com"));
        directorio.add(new Contacto("Oscar", "3197354837", "Carrera 66", "OSCAR@gmail.com"));

        Contacto contacto = directorio.buscarPorNombre("Duber");
        System.out.println(contacto != null ? contacto.toString() : "Contacto no encontrado - " + contacto);

        String isa = "Isabel";
        String maria = "isabel";

        System.out.println(isa.compareTo(maria));

        Contacto cIsa = new Contacto("Isabel", "3126577562", "Carrera 66", "carlosrestrepo.315@gmail.com");
        Contacto cMaria = new Contacto("Maria", "3017654567", "Carrera 66", "carlosrestrepo.315@gmail.com");
        System.out.println(cIsa.compareTo(cMaria));

        Map<Integer, Integer> niveles = directorio.obtenerNodosPorNivel();
        for (int i = 0; i < niveles.size(); i++) {
            System.out.println("En el nivel " + i + " hay : " + niveles.get(i) + " nodos.");
        }

        System.out.println("Holi"+directorio.ordenAlfabetico());

        //boolean eliminado = directorio.remove("Isabel");
        /*if (eliminado) {
            System.out.println(directorio.ordenAlfabetico());
        }*/

        boolean esCompleto = directorio.esCompleto();
        System.out.println(esCompleto ? "El árbol es completo." : "El árbol no es completo.");

        NodoBinario<Contacto> contactoPorEmail = directorio.buscarPorEmail("OScAR@gmail.com");
        System.out.println(contactoPorEmail != null ? contactoPorEmail.getItem().toString() : "Contacto no encontrado - " + contactoPorEmail);
    }
}
