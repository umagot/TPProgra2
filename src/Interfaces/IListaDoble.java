package Interfaces;

public interface IListaDoble {
    boolean estaVacia();
    int tamanio();
    void insertarInicio(int dato);
    void insertarFinal(int dato);
    boolean insertarPosicion(int posicion, int dato);
    boolean eliminarInicio();
    boolean eliminarFinal();
    boolean eliminarDato(int dato);
    boolean buscar(int dato);
    boolean modificar (int posicion, int dato);
    void mostrarAdelante();
    void mostrarAtras();
    int obtener(int posicion);
}

