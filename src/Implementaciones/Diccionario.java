package Implementaciones;

import Interfaces.IDiccionario;

public class Diccionario<ID extends Comparable<ID>, Nombre extends Comparable<Nombre>>

implements IDiccionario<ID, Nombre> {

        private static class dato<ID, Nombre> {
            ID id;
            Nombre nombre;

            public dato(ID id, Nombre nombre) {
                this.id = id;
                this.nombre = nombre;
            }
        }

        private dato<ID, Nombre>[] dic;
        private int cantidad = 0;


        public Diccionario(int tamanio) {
            this.dic = new dato[tamanio];
        }

        @Override
        public boolean EsVacio() {
            return cantidad == 0;
        }

        @Override
        public void insertar(ID id, Nombre nombre) {
            if (cantidad == dic.length) {
                System.out.println("Diccionario lleno");
                return;
            }

            if (perteneceId(id)) {
                System.out.println("Ya existe un usuario con ese ID");
                return;
            }

            if (perteneceNombre(nombre)) {
                System.out.println("Ese nombre de usuario ya está en uso");
                return;
            }

            dic[cantidad] = new dato<>(id, nombre);
            cantidad++;
        }

        @Override
        public void eliminar(ID id) {
            if (cantidad == 0) {
                System.out.println("Diccionario vacío");
                return;
            }

            for (int i = 0; i < cantidad; i++) {
                if (dic[i].id.compareTo(id) == 0) {
                    cantidad--;
                    dic[i] = dic[cantidad];
                    dic[cantidad] = null;
                    return;
                }
            }

            System.out.println("El ID ingresado no existe");
        }

        @Override
        public Nombre nombre(ID id) {
            for (int i = 0; i < cantidad; i++) {
                if (dic[i].id.compareTo(id) == 0) {
                    return dic[i].nombre;
                }
            }
            return null;
        }

        @Override
        public ID id(Nombre nombre) {
            for (int i = 0; i < cantidad; i++) {
                if (dic[i].nombre.compareTo(nombre) == 0) {
                    return dic[i].id;
                }
            }
            return null;
        }

        @Override
        public boolean perteneceId(ID id) {
            for (int i = 0; i < cantidad; i++) {
                if (dic[i].id.compareTo(id) == 0) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean perteneceNombre(Nombre nombre) {
            for (int i = 0; i < cantidad; i++) {
                if (dic[i].nombre.compareTo(nombre) == 0) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public void modificar(ID id, Nombre nuevoNombre) {
            if (perteneceNombre(nuevoNombre)) {
                System.out.println("Ese nombre de usuario ya está en uso");
                return;
            }

            for (int i = 0; i < cantidad; i++) {
                if (dic[i].id.compareTo(id) == 0) {
                    dic[i].nombre = nuevoNombre;
                    return;
                }
            }

            System.out.println("El ID ingresado no existe");
        }

        @Override
        public int tamanio() {
            return cantidad;
        }

        @Override
        public ID[] listarIds() {
            ID[] ids = (ID[]) new Comparable[cantidad];

            for (int i = 0; i < cantidad; i++) {
                ids[i] = dic[i].id;
            }

            return ids;
        }

        @Override
        public Nombre[] listarNombres() {
            Nombre[] nombres = (Nombre[]) new Comparable[cantidad];

            for (int i = 0; i < cantidad; i++) {
                nombres[i] = dic[i].nombre;
            }

            return nombres;
        }
    }