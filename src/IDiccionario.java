public interface IDiccionario {
    boolean estaVacio();
    boolean insertar(int clave, String valor);
    boolean eliminar(int clave);
    boolean modificar(int clave, String valor);
    String recuperarValor(int clave);
    int existe(int clave);
    int tamanio();
    void listarClaves();
    void listarValores();
    void mostrar();
}
