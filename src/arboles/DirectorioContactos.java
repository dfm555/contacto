package arboles;

import comun.Contacto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duber on 30/10/16.
 */
public class DirectorioContactos<E extends Comparable<E>> {

    private NodoBinario<E> raiz;

    public DirectorioContactos() {
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

    private void addAll(NodoBinario<E> r, E item) {
        if (item.compareTo(r.getItem()) < 0) {
            if (r.getHijoIzquierdo() == null) {
                r.setHijoIzquierdo(new NodoBinario<>(item));
            } else {
                add(r.getHijoIzquierdo(), item);
                if (r.getHijoIzquierdo() != null) {
                    add(r.getHijoIzquierdo().getItem());
                }
                if (r.getHijoDerecho() != null) {
                    add(r.getHijoDerecho().getItem());
                }
            }
        } else if (item.compareTo(r.getItem()) > 0) {
            if (r.getHijoDerecho() == null) {
                r.setHijoDerecho(new NodoBinario<>(item));
            } else {
                add(r.getHijoDerecho(), item);
                if (r.getHijoIzquierdo() != null) {
                    add(r.getHijoIzquierdo().getItem());
                }
                if (r.getHijoDerecho() != null) {
                    add(r.getHijoDerecho().getItem());
                }
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

    public ArrayList ordenAlfabetico() {

        ArrayList<E> alfabetico = new ArrayList<E>();
        return ordenAlfabetico(raiz, alfabetico);
    }

    /**
     * Punto 2-b. Defina un método que retorne la información de los contactos en orden
     * alfabético.
     *
     * @param r
     * @param list
     * @return
     */
    private ArrayList ordenAlfabetico(NodoBinario<E> r, ArrayList<E> list) {
        if (r != null) {
           ordenAlfabetico(r.getHijoIzquierdo(),list);
            list.add(r.getItem());
            ordenAlfabetico(r.getHijoDerecho(), list);
        }

        return list;
    }

    public String jerarquia(){
        return jerarquia(raiz, "");
    }

    /**
     * Punto 3-d Mostrar la estructura jerárquica del árbol
     *
     * @param node
     * @param specialChar
     * @return
     */

    private String jerarquia(NodoBinario<E> node, String specialChar){
        if(node != null){
            String nodeString = specialChar + node.getItem().toString() + "\n";
            specialChar = "\t" + specialChar;
            if(node.hasLeftChild()){
                nodeString += jerarquia(node.getHijoIzquierdo(), specialChar);
            }
            if(node.hasRightChild()){
                nodeString += jerarquia(node.getHijoDerecho(), specialChar);
            }
            return nodeString;
        }

        return "No existe el arbol";
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
        if (nodo != null && nombre != null && !nombre.isEmpty()) {
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
     * @param nombre
     * @return boolean
     */
    public boolean remove(String nombre) {  /** Falta revisar nueva asignación de nodos después de eliminar */
        NodoBinario<E> aux = raiz;
        NodoBinario<E> nodoPadre = aux;

        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        while (aux != null) {
            int diferencia = contacto.compareTo((Contacto) aux.getItem());
            if (diferencia < 0) {
                nodoPadre = aux;
                aux = aux.getHijoIzquierdo();
            } else if (diferencia > 0) {
                nodoPadre = aux;
                aux = aux.getHijoDerecho();
            } else {
                if (contacto.compareTo((Contacto) nodoPadre.getItem()) < 0) {
                    nodoPadre.setHijoIzquierdo(null);
                } else {
                    nodoPadre.setHijoDerecho(null);
                }
                // Se vuelven a agregar los nodos que eran hijos del nodo eliminado
                if (aux.getHijoIzquierdo() != null) {
                    addAll(nodoPadre, aux.getHijoIzquierdo().getItem());
                }
                if (aux.getHijoDerecho() != null) {
                    addAll(nodoPadre, aux.getHijoDerecho().getItem());
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

    /**
     * Punto 2-h. Defina un método que retorne true si el árbol es completo.
     * Un árbol es completo si todos sus niveles tienen el número máximo de elementos.
     * @return boolean
     */
    public boolean esCompleto() {
        Map<Integer, Integer> nodosPorNivel = this.obtenerNodosPorNivel();
        if (!nodosPorNivel.isEmpty()) {
            for (int i = 0; i < nodosPorNivel.size(); i++) {
                if (nodosPorNivel.get(i).doubleValue() != Math.pow(2, (long) i)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Punto 2-e. Defina un método que busque un nodo dado su mail y lo retorne.
     * En caso de no encontrarlo debe retornar null.
     * @param email
     * @return Contacto
     */
    public NodoBinario<E> buscarPorEmail(String email) {
        if (email != null && !email.isEmpty()) {
            NodoBinario<E> aux = raiz;
            NodoBinario<E> prev = aux;
            while (aux != null) {
                Contacto contactoNodo = (Contacto) aux.getItem();
                String emailNodo = contactoNodo.getEmail();
                if (emailNodo != null && !emailNodo.isEmpty() && emailNodo.equals(email)) {
                    return aux;
                } else {
                    if (aux.getHijoIzquierdo() == null) {
                        aux = aux.getHijoDerecho();
                    } else {
                        prev = aux.getHijoIzquierdo();
                        while (prev.getHijoDerecho() != null && prev.getHijoDerecho() != aux) {
                            prev = prev.getHijoDerecho();
                        }
                        if (prev.getHijoDerecho() == null) {
                            prev.setHijoDerecho(aux);
                            aux = aux.getHijoIzquierdo();
                        } else {
                            prev.setHijoDerecho(null);
                            aux = aux.getHijoDerecho();
                        }

                    }
                }
            }
        }
        return null;
    }
}
