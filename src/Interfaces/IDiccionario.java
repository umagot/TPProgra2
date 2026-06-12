package Interfaces;

public interface IDiccionario<ID extends Comparable<ID>, Nombre extends Comparable<Nombre>> {
    boolean EsVacio();
    void insertar(ID id, Nombre nombre);
    void eliminar(ID id);
    Nombre nombre(ID id);
    ID id(Nombre nombre);
    boolean perteneceId(ID id);
    boolean perteneceNombre(Nombre nombre);
    void modificar(ID id, Nombre nuevoNombre);
    int tamanio();
    ID[] listarIds();
    Nombre[] listarNombres();
}