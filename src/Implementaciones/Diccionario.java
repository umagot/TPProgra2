package Implementaciones;

import Interfaces.IDiccionario;

public class Diccionario<K extends Comparable<K>, V extends Comparable<V>> implements IDiccionario<K, V> {

    // Clase interna para manejar los pares clave-valor
    private static class dato<K, V> {
        K clave;
        V valor;
        public dato(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    private dato<K, V>[] dic;
    private int cantidad = 0;

    @SuppressWarnings("unchecked")
    public Diccionario(int tamanio) {
        this.dic = new dato[tamanio];
    }

    @Override
    public boolean EsVacio() {
        return cantidad == 0;
    }

    @Override
    public void insertar(K clave, V valor) {
        if (cantidad == dic.length) {
            System.out.println("diccionario lleno");
        } else {
            for (int i = 0; i < cantidad; i++){
                // Usamos compareTo() == 0 en lugar de == para objetos comparables
                if (dic[i].clave.compareTo(clave) == 0){
                    System.out.println("Ya hay un valor asociado a esa clave");
                    return;
                }
            }
            dato<K, V> d = new dato<>(clave, valor);
            dic[cantidad] = d;
            this.cantidad++;
        }
    }

    @Override
    public void eliminar(K clave) {
        if (cantidad == 0) {
            System.out.println("diccionario vacio");
        } else {
            for (int i = 0; i < cantidad; i++) {
                if (dic[i].clave.compareTo(clave) == 0) {
                    cantidad--;
                    dic[i] = dic[cantidad];
                    dic[cantidad] = null;
                    System.out.println("Elemento eliminado");
                    return;
                }
            }
            System.out.println("La clave ingresada no existe");
        }
    }

    @Override
    public V valor(K clave) {
        if (cantidad == 0) {
            System.out.println("diccionario vacio");
            return null;
        } else {
            for (int i = 0; i < cantidad; i++) {
                if (dic[i].clave.compareTo(clave) == 0) {
                    return dic[i].valor;
                }
            }
        }
        System.out.println("clave inexistente");
        return null;
    }

    @Override
    public boolean pertenece(K clave) {
        if (cantidad == 0) {
            return false;
        } else {
            for (int i = 0; i < cantidad; i++) {
                if (dic[i].clave.compareTo(clave) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void modificar(K clave, V nuevoValor) {
        if (cantidad == 0) {
            System.out.println("diccionario vacio");
        } else {
            for (int i = 0; i < cantidad; i++) {
                if (dic[i].clave.compareTo(clave) == 0) {
                    dic[i].valor = nuevoValor;
                    return;
                }
            }
            System.out.println("No existe la clave ingresada");
        }
    }

    @Override
    public int tamanio() {
        return this.cantidad;
    }

    @SuppressWarnings("unchecked")
    @Override
    public K[] listarClaves() {
        if (cantidad == 0) {
            System.out.println("diccionario vacio");
            return (K[]) new Comparable[0];
        } else {
            K[] claves = (K[]) new Comparable[cantidad];
            for (int i = 0; i < cantidad; i++) {
                claves[i] = dic[i].clave;
            }
            return claves;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V[] listarValores() {
        if (cantidad == 0) {
            System.out.println("diccionario vacio");
            return (V[]) new Comparable[0];
        } else {
            V[] valores = (V[]) new Comparable[cantidad];
            for (int i = 0; i < cantidad; i++) {
                valores[i] = dic[i].valor;
            }
            return valores;
        }
    }
}
