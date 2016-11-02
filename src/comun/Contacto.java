package comun;

/**
 * Created by duber on 30/10/16.
 */
public class Contacto implements Comparable<Contacto> {

    private String nombre;
    private String telefono;
    private String direccionPostal;
    private String email;

    public Contacto() {}

    public Contacto(String nombre, String telefono, String direccionPostal, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccionPostal = direccionPostal;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean igualContacto(String otroNombre) {
        boolean iguales = nombre.equals(otroNombre);
        return iguales;
    }
    @Override
    public int compareTo( Contacto contacto ){
        int cmp = this.nombre.compareTo(contacto.nombre);

        if (cmp < 0) {
            return -1;
        } else if (cmp == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Contacto { " +
                "nombre='" + nombre + "'" +
                ", telefono='" + telefono + "'" +
                ", direccionPostal='" + direccionPostal + "'" +
                ", email='" + email + "'" + '}';
    }
}
