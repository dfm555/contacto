package arboles;

import comun.Contacto;

import java.util.Map;

/**
 * Created by Developer on 10/30/16.
 */
public class Pruebas {

    public static void main(String[] args) {
        DirectorioDeContactos<Contacto> directorio = new DirectorioDeContactos<Contacto>();
        directorio.add(new Contacto("Carlos", "3017517366", "Carrera 66", "carlosrestrepo.315@gmail.com"));
        directorio.add(new Contacto("Andres", "3005683327", "Carrera 66", "carlosrestrepo.315@gmail.com"));
        directorio.add(new Contacto("Maria", "3017654567", "Carrera 66", "carlosrestrepo.315@gmail.com"));
        directorio.add(new Contacto("Isabel", "3126577562", "Carrera 66", "carlosrestrepo.315@gmail.com"));
        directorio.add(new Contacto("Duber", "3186490021", "Carrera 66", "carlosrestrepo.315@gmail.com"));
        directorio.add(new Contacto("Yording", "3009893618", "Carrera 66", "carlosrestrepo.315@gmail.com"));
        directorio.add(new Contacto("Oscar", "3197354837", "Carrera 66", "carlosrestrepo.315@gmail.com"));

        Contacto contacto = directorio.buscarPorNombre("xx");
        System.out.println(contacto != null ? contacto.toString() : "Contacto no encontrado.");

        String isa = "Isabel";
        String maria = "Maria";

        System.out.println(isa.compareTo(maria));

        Contacto cIsa = new Contacto("Isabel", "3126577562", "Carrera 66", "carlosrestrepo.315@gmail.com");
        Contacto cMaria = new Contacto("Maria", "3017654567", "Carrera 66", "carlosrestrepo.315@gmail.com");
        System.out.println(cIsa.compareTo(cMaria));

        Map<Integer, Integer> niveles = directorio.obtenerNodosPorNivel();
        for (int i = 0; i < niveles.size(); i++) {
            System.out.println("En el nivel " + i + " hay : " + niveles.get(i) + " nodos.");
        }
    }
}
