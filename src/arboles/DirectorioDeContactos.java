package arboles;

/**
 * Created by duber on 30/10/16.
 */
public class DirectorioDeContactos <E extends Comparable<E>> {

    private NodoBinario<E> raiz;

    public DirectorioDeContactos(){
        raiz = null;
    }

    /**
     * Metodo publico para agregar los elementos
     * @param item
     */

    public void add(E item){
        if (raiz != null){
            add(raiz, item);
        }else{
            raiz = new NodoBinario<E>(item);
        }
    }

    /**
     * Metodo privado recursivo que agrega los items al arbol
     * @param r
     * @param item
     */
    private void add(NodoBinario<E> r, E item){
        if (item.compareTo(r.getItem()) < 0) {
            if (r.getHijoIzquierdo() == null) {
                r.setHijoIzquierdo(new NodoBinario<>(item));
            } else {
                add(r.getHijoIzquierdo(), item);
            }
        } else if (item.compareTo(r.getItem()) > 0) {
            if (r.getHijoDerecho() == null) {
                r.setHijoDerecho(new NodoBinario<>(item));
            } else {
                add(r.getHijoDerecho(), item);
            }
        }
    }

    /**
     * Metodo para verificar si un contacto esta en el arbol
     * @param item
     * @return
     */
    public boolean contains(E item) {
        NodoBinario<E> auxiliar = raiz;

        while (auxiliar != null) {
            int comparar = item.compareTo(auxiliar.getItem());

            if (comparar == 0) {
                return true;
            } else if (comparar > 0) {
                auxiliar = auxiliar.getHijoDerecho();
            } else {
                auxiliar = auxiliar.getHijoIzquierdo();
            }
        }

        return false;
    }

    public String ordenAlfabetico(){
        return ordenAlfabetico(raiz);
    }

    /**
     * Método que retorne la información de los contactos en orden alfabético.
     * @param r
     * @return
     */
    private String ordenAlfabetico( NodoBinario<E> r) {
        String resultado = "";

        if (r != null) {
            resultado += ordenAlfabetico(r.getHijoIzquierdo());
            resultado += r.getItem() + " \n";
            resultado += ordenAlfabetico(r.getHijoDerecho());
        }

        return resultado;
    }

    public void jerarquia(){
        jerarquia(raiz, "");
    }

    /**
     * Mostrar la estructura jerárquica del árbol
     * @param r
     * @param espacio
     */
    private void jerarquia(NodoBinario<E> r, String espacio){
        if(r!=null){
            jerarquia(r.getHijoDerecho(), espacio + "    ");
            System.out.println(espacio + r.getItem());
            jerarquia(r.getHijoIzquierdo(), espacio + "    ");
        }
    }
}
