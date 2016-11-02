package arboles;

import comun.Contacto;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duber on 30/10/16.
 */
public class Directorio<E extends Comparable<E>> {

    private NodoBinario<E> raiz;

    public Directorio() {
        raiz = null;
    }

    public void add(E item) {
        if (raiz != null) {
            add(raiz, item);
        } else {
            raiz = new NodoBinario<E>(item);
        }
    }

    private void add(NodoBinario<E> r, E item) {
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

    public String ordenAlfabetico() {
        return ordenAlfabetico(raiz);
    }

    /**
     * Método que retorne la información de los contactos en orden alfabético.
     *
     * @param r
     * @return
     */
    private String ordenAlfabetico(NodoBinario<E> r) {
        String resultado = "";

        if (r != null) {
            resultado += ordenAlfabetico(r.getHijoIzquierdo());
            resultado += r.getItem() + " \n";
            resultado += ordenAlfabetico(r.getHijoDerecho());
        }

        return resultado;
    }

    public void jerarquia() {
        jerarquia(raiz, "");
    }

    /**
     * Mostrar la estructura jerárquica del árbol
     *
     * @param r
     * @param espacio
     */
    private void jerarquia(NodoBinario<E> r, String espacio) {
        if (r != null) {
            jerarquia(r.getHijoDerecho(), espacio + "    ");
            System.out.println(espacio + r.getItem());
            jerarquia(r.getHijoIzquierdo(), espacio + "    ");
        }
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

    /**
     * Punto 2-c. Defina un método que reciba el nombre de un contacto y lo elimine del directorio.
     * @param contacto
     * @return boolean
     */
    public boolean remove(E contacto) {  /** Falta revisar nueva asignación de nodos después de eliminar */
        NodoBinario<E> aux = raiz;
        NodoBinario<E> nodoPadre = aux;
        while (aux != null) {
            int diferencia = ((Contacto) contacto).compareTo((Contacto) aux.getItem());
            if (diferencia < 0) {
                nodoPadre = aux;
                aux = aux.getHijoIzquierdo();
            } else if (diferencia > 0) {
                nodoPadre = aux;
                aux = aux.getHijoDerecho();
            } else {
                if (nodoPadre.getItem().compareTo(aux.getItem()) < 0) {
                    nodoPadre.setHijoDerecho(null);
                } else {
                    nodoPadre.setHijoIzquierdo(null);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Punto 2-d. Defina un método que retorne un arreglo de tipo entero con el número de nodos que hay por nivel.
     * @return
     */
    public Map<Integer, Integer> obtenerNodosPorNivel() {
        return obtenerNodosPorNivel(raiz, 0, new HashMap<Integer, Integer>());
    }

    private Map<Integer, Integer> obtenerNodosPorNivel(NodoBinario<E> nodo, int nivel, Map<Integer, Integer> niveles) {
        if (nodo != null) {
            niveles.put(nivel, niveles.get(nivel) != null ? niveles.get(nivel) + 1 : 1);
            obtenerNodosPorNivel(nodo.getHijoIzquierdo(), nivel + 1, niveles);
            obtenerNodosPorNivel(nodo.getHijoDerecho(), nivel + 1, niveles);
        }
        return niveles;
    }
    
    
}
