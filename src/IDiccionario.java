public interface IDiccionario<K extends Comparable<K>, V extends Comparable<V>> {
    boolean EsVacio();
    void insertar(K clave, V valor);
    void eliminar(K clave);
    V valor(K clave); // Cambiado a devolver 'V' en vez de String
    boolean pertenece(K clave);
    void modificar(K clave, V nuevoValor);
    int tamanio();
    K[] listarClaves();
    V[] listarValores();
}