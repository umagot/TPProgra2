package Implementaciones;
import Interfaces.IListaDoble;

public class ListaDoble implements IListaDoble {
    private int cantidad = 0;
    private Nodo cabeza = null;
    private Nodo fin = null;

    @Override
    public boolean estaVacia() {
        return cantidad == 0;
    }

    @Override
    public int tamanio() {
        return cantidad;
    }

    @Override
    public void insertarInicio(int dato) {
        Nodo n = new Nodo(dato);

        if (estaVacia()) {
            cabeza = n;
            fin = n;
        } else {
            n.siguiente = this.cabeza;
            this.cabeza.anterior = n;
            this.cabeza = n;
        }
        cantidad++;
    }

    @Override
    public void insertarFinal(int dato) {
        Nodo n = new Nodo(dato);

        if (estaVacia()) {
            cabeza = n;
            fin = n;
        } else {
            n.anterior = this.fin;
            this.fin.siguiente = n;
            this.fin = n;
        }
        cantidad++;
    }

    @Override
    public boolean insertarPosicion(int posicion, int dato) {
        if (posicion < 0 || cantidad < posicion) {
            return false;
        } else if (posicion == 0) {
            insertarInicio(dato);
        } else if (posicion == cantidad) {
            insertarFinal(dato);
        } else {
            Nodo n = new Nodo(dato);
            Nodo m = this.cabeza;
            for (int i = 1; i < posicion; i++) {
                m = m.siguiente;
            }
            n.anterior = m;
            n.siguiente = m.siguiente;
            m.siguiente.anterior = n;
            m.siguiente = n;
            cantidad++;
        }
        return true;
    }

    @Override
    public boolean eliminarInicio() {
        if (cantidad == 0) {
            return false;
        } else if (cantidad == 1) {
            cabeza = null;
            fin = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
        cantidad--;
        return true;
    }

    @Override
    public boolean eliminarFinal() {
        if (cantidad == 0) {
            return false;
        } else if (cantidad == 1) {
            cabeza = null;
            fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        cantidad--;
        return true;
    }

    @Override
    public boolean eliminarDato(int dato) {
        if (cantidad == 0) {
            return false;
        } else if (cantidad == 1 && cabeza.dato == dato) {
            cabeza = null;
            fin = null;
            cantidad--;
            return true;
        } else if (cabeza.dato == dato) {
            eliminarInicio();
            return true;
        } else if (fin.dato == dato) {
            eliminarFinal();
            return true;
        } else {
            Nodo n = this.cabeza;
            while (n != null && n.dato != dato) {
                n = n.siguiente;
            }
            if (n != null) {
                n.anterior.siguiente = n.siguiente;
                n.siguiente.anterior = n.anterior;
                cantidad--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean buscar(int dato) {

        Nodo n = cabeza;
        while (n != null) {
            if (n.dato == dato) {
                return true;
            }
            n = n.siguiente;
        }

        return false;
    }

    @Override
    public boolean modificar(int posicion, int dato) {
        if (cantidad == 0) {
            return false;
        } else if (posicion == 0){
            cabeza.dato = dato;
            return true;
        }else if (posicion > 0 && posicion < cantidad) {
            Nodo n = cabeza;
            for (int i = 0; i < cantidad; i++) {
                if (i == posicion){
                    n.dato = dato;
                    return true;
                }
                n = n.siguiente;
            }
        }

        return false;
    }

    @Override
    public void mostrarAdelante() {
        if (cantidad == 0) {
            System.out.println("Lista vacia");
            return;
        }
        System.out.print("Lista de adelante hacia atras: ");
        Nodo n = this.cabeza;
        while (n != null) {
            System.out.print(n.dato + "  ");
            n = n.siguiente;
        }
        System.out.println();
    }

    @Override
    public void mostrarAtras() {
        if (cantidad == 0) {
            System.out.println("Lista vacia");
            return;
        }
        System.out.print("Lista de atras hacia adelante: ");
        Nodo n = this.fin;
        while (n != null) {
            System.out.print(n.dato + "  ");
            n = n.anterior;
        }
        System.out.println();
    }

    @Override
    public int obtener(int posicion) {
        if (cantidad == 0) {
            return -1;
        } else if (posicion == 0){
            return cabeza.dato;
        }else if (posicion > 0 && posicion < cantidad) {
                Nodo n = cabeza;
                for (int i = 0; i < cantidad; i++) {
                    if (i == posicion){
                        return n.dato;
                    }
                    n = n.siguiente;
                }
            }

            return -1;
        }
    }
