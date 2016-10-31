package arboles;

import comun.Contacto;

/**
 * Created by duber on 30/10/16.
 */
public class DirectorioDeContactos <E extends Comparable<E>> {

    private NodoBinario<E> raiz;

    public DirectorioDeContactos(){
        raiz = null;
    }

    public void add(E item){
        if (raiz != null){
            add(raiz, item);
        }else{
            raiz = new NodoBinario<E>(item);
        }
    }

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

    /**
     * Punto 2-a. Defina un método que retorne un contacto dado su nombre.
     * En caso de no encontrarlo debe retornar null.
     * @param nombre
     * @return Contacto
     */
    public Contacto buscarPorNombre(String nombre) {
        return buscarPorNombre(nombre, raiz);
    }

    private Contacto buscarPorNombre(String nombre, NodoBinario<E> nodo) {
        if (nodo != null && nombre != null) {
            Contacto temp = new Contacto();
            temp.setNombre(nombre);
            int diferencia = temp.compareTo((Contacto) nodo.getItem());
            if (diferencia < 0) {
                if (nodo.getHijoIzquierdo() != null) {
                    return buscarPorNombre(nombre, nodo.getHijoIzquierdo());
                }
            } else if (diferencia > 0) {
                if (nodo.getHijoDerecho() != null) {
                    return buscarPorNombre(nombre, nodo.getHijoDerecho());
                }
            } else {
                return (Contacto) nodo.getItem();
            }
        }
        return null;
    }
}
