package arboles;

import comun.Contacto;

import java.util.*;

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

    private void addAll(NodoBinario<E> r, NodoBinario<E> nuevoNodo) {
        if (nuevoNodo.getItem().compareTo(r.getItem()) < 0) {
            if (r.getHijoIzquierdo() == null) {
                r.setHijoIzquierdo(nuevoNodo);
            } else {
                addAll(r.getHijoIzquierdo(), nuevoNodo);
            }
        } else if (nuevoNodo.getItem().compareTo(r.getItem()) > 0) {
            if (r.getHijoDerecho() == null) {
                r.setHijoDerecho(nuevoNodo);
            } else {
                addAll(r.getHijoDerecho(), nuevoNodo);
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
                } else if (contacto.compareTo((Contacto) nodoPadre.getItem()) > 0) {
                    nodoPadre.setHijoDerecho(null);
                } else if (contacto.compareTo((Contacto) raiz.getItem()) == 0) {
                    if (aux.getHijoDerecho() != null) {
                        raiz = aux.getHijoDerecho();
                        nodoPadre = raiz;
                    } else if (aux.getHijoIzquierdo() != null) {
                        raiz = aux.getHijoIzquierdo();
                        nodoPadre = raiz;
                    }
                }
                // Se vuelven a agregar los nodos que eran hijos del nodo eliminado
                if (aux.getHijoIzquierdo() != null) {
                    addAll(nodoPadre, aux.getHijoIzquierdo());
                }
                if (aux.getHijoDerecho() != null) {
                    addAll(nodoPadre, aux.getHijoDerecho());
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
     * Este método recorre el árbol por nivel y retorna el nodo en caso de que encuentre un email al comparar sin importar mayúsculas y minúsculas.
     * @param email
     * @return NodoBinario<E>
     */
    public NodoBinario<E> buscarPorEmail(String email) {
        if (email != null && !email.isEmpty() && raiz != null) {

            Queue<NodoBinario<E>> cola = new LinkedList<NodoBinario<E>>();
            Queue<NodoBinario<E>> colaAux = new LinkedList<NodoBinario<E>>();
            NodoBinario<E> aux;

            cola.add(raiz);
            while (!cola.isEmpty()) {
                colaAux.add(aux = cola.poll());

                Contacto contactoNodo = (Contacto) aux.getItem();
                String emailNodo = contactoNodo.getEmail();

                if (emailNodo != null && emailNodo.equalsIgnoreCase(email)) {
                    return aux;
                } else {
                    if (aux.getHijoIzquierdo() != null) {
                        cola.add(aux.getHijoIzquierdo());
                    }
                    if (aux.getHijoDerecho() != null) {
                        cola.add(aux.getHijoDerecho());
                    }
                }
            }
        }
        return null;
    }

    /**
     * Punto 2-f. Defina un método que reciba una cadena de búsqueda y retorne el primer nodo que contenga esa cadena en nombre, mail o dirección.
     * En caso de no encontrar ningún nodo con esa condición, debe retornar null.
     * @param cadena
     * @return NodoBinario<E>
     */
    public NodoBinario<E> buscarPorCadena(String cadena) {
        if (cadena != null && !cadena.isEmpty() && raiz != null) {

            Queue<NodoBinario<E>> cola = new LinkedList<NodoBinario<E>>();
            Queue<NodoBinario<E>> colaAux = new LinkedList<NodoBinario<E>>();
            NodoBinario<E> aux;

            cola.add(raiz);
            while (!cola.isEmpty()) {
                colaAux.add(aux = cola.poll());

                Contacto contactoNodo = (Contacto) aux.getItem();
                String nombreNodo = contactoNodo.getNombre();
                String emailNodo = contactoNodo.getEmail();
                String direccionNodo = contactoNodo.getDireccionPostal();

                if (nombreNodo != null && !nombreNodo.isEmpty() && nombreNodo.contains(cadena)) {
                    return aux;
                } else if (emailNodo != null && !emailNodo.isEmpty() && emailNodo.contains(cadena)) {
                    return aux;
                } else if (direccionNodo != null && !direccionNodo.isEmpty() && direccionNodo.contains(cadena)) {
                    return aux;
                } else {
                    if (aux.getHijoIzquierdo() != null) {
                        cola.add(aux.getHijoIzquierdo());
                    }
                    if (aux.getHijoDerecho() != null) {
                        cola.add(aux.getHijoDerecho());
                    }
                }
            }
        }
        return null;
    }

    /**
     * Punto 2-g. Defina un método que retorne un mensaje indicando los contactos con mail inválido (sin @ o que no terminen en .com o .edu.co)
     * @return String Contactos con email inválido
     */
    public String contactosConEmailInvalido() {
        return contactosConEmailInvalido(raiz, new StringBuilder());
    }

    private String contactosConEmailInvalido(NodoBinario<E> nodo, StringBuilder mensaje) {
        if (nodo != null) {
            Contacto contactoNodo = (Contacto) nodo.getItem();
            String emailNodo = contactoNodo.getEmail();
            if (emailNodo == null || emailNodo.isEmpty() || !emailNodo.contains("@") || !(emailNodo.endsWith(".com") || emailNodo.endsWith(".edu.co"))) {
                mensaje.append("El contacto " + contactoNodo.getNombre() + " tiene email inválido: " + emailNodo + "\n");
            }
            contactosConEmailInvalido(nodo.getHijoIzquierdo(), mensaje);
            contactosConEmailInvalido(nodo.getHijoDerecho(), mensaje);
        }
        return mensaje.toString();
    }
}
