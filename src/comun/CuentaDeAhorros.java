package comun;

/**
 *
 * @author Oscar Arenas
 */
public class CuentaDeAhorros implements Comparable<CuentaDeAhorros> {

    private int codigo; // Campo de clasificacion o clave
    private String nombre;
    private String apellido;
    private double saldo;

    public CuentaDeAhorros() {
        nombre = "";
        apellido = "";
    }

    public CuentaDeAhorros(int codigo, String nombre, String apellido, double saldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int compareTo(CuentaDeAhorros cuenta) {
        return this.codigo - cuenta.codigo;
        
//        if (this.codigo < cuenta.codigo) {
//            return -1;
//        } else if (this.codigo == cuenta.codigo) {
//            return 0;
//        } else {
//            return 1;
//        }
    }

    @Override
    public String toString() {
        return "" + codigo;
    }
}
