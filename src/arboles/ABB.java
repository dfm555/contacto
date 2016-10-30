
package arboles;

/**
 * @param <E>
 * @author Oscar Arenas
 */
public class ABB<E extends Comparable<E>> {

    private NodoBinario<E> raiz;

    public ABB() {
        raiz = null;
    }

    public void add(E item) {
        if (raiz != null) {
            add(raiz, item);
        } else {
            raiz = new NodoBinario<>(item);
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

    public int numberLeaves() {
        return numberLeaves(raiz);
    }

    private int numberLeaves(NodoBinario<E> r) {

        if (r != null) {
            if (!r.esHoja()) {
                return 1 + numberLeaves(r.getHijoIzquierdo()) + numberLeaves(r.getHijoDerecho());
            }
        }

        return 0;
    }

    public int size() {
        return size(raiz);
    }

    private int size(NodoBinario<E> r) {
        if (r != null) {
            return 1 + size(r.getHijoIzquierdo()) + size(r.getHijoDerecho());
        } else {
            return 0;
        }
    }

    public E myParent(E item) {
        NodoBinario<E> auxiliar = raiz;
        NodoBinario<E> parent = null;
        while (auxiliar != null) {
            int comparar = item.compareTo(auxiliar.getItem());
            if (comparar == 0) {
                if (null != parent) {
                    return parent.getItem();
                } else {
                    return null;
                }
            } else if (comparar > 0) {
                parent = auxiliar;
                auxiliar = auxiliar.getHijoDerecho();
            } else {
                parent = auxiliar;
                auxiliar = auxiliar.getHijoIzquierdo();
            }
        }

        return null;
    }


    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoBinario<E> r) {
        if (r != null) {
            return 1 + Math.max(altura(r.getHijoIzquierdo()), altura(r.getHijoDerecho()));
        }
        return 0;
    }

    public void nodosDelNivel(int num) {
        nodosDelNivel(num, raiz);
    }

    private void nodosDelNivel(int num, NodoBinario<E> r) {

        if (r != null) {
            if (num == 0) {
                System.out.println("El valor de los niveles es: " + r.getItem());
            } else {
                nodosDelNivel(num - 1, r.getHijoIzquierdo());
                nodosDelNivel(num - 1, r.getHijoDerecho());
            }
        }
    }

    public int numNodosDelNivel(int n) {
        return numNodosDelNivel(n, raiz);
    }

    private int numNodosDelNivel(int n, NodoBinario<E> r) {

        if (r != null) {

            if (n == 0) {
                return 1;
            } else {
                return numNodosDelNivel(n - 1, r.getHijoIzquierdo()) +
                        numNodosDelNivel(n - 1, r.getHijoDerecho());
            }
        }

        return 0;
    }

    public int calcularNivel(E target) {
        NodoBinario<E> r = raiz;
        int nivel = -1;

        while (r != null) {
            ++nivel;
            int comparador = target.compareTo(r.getItem());

            if (comparador == 0) {
                return nivel;
            } else if (comparador < 0) {
                r = r.getHijoIzquierdo();
            } else {
                r = r.getHijoDerecho();
            }
        }

        return -1;
    }

    public int numHojas(){
        return numHojas(raiz);
    }

    private int numHojas(NodoBinario<E> r){
        if(r != null ){
            if(r.esHoja()){
                return 1;
            }else{
                return numHojas(r.getHijoIzquierdo()) +
                numHojas(r.getHijoDerecho());
            }
        }
        return 0;
    }
}
