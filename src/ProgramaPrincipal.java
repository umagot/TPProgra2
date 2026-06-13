import Interfaces.*;
import Implementaciones.*;
import archivos_principales.*;

import java.util.Scanner;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializamos las estructuras principales
        // Capacidad para 100 usuarios
        DiccionarioUsuarios plataforma = new DiccionarioUsuarios(100);

        // Tamaño de historial 10 (guarda los últimos 10 cambios por usuario)
        GestorPerfil gestorPerfil = new GestorPerfil(10);

        int opcion;

        System.out.println("=============================================");
        System.out.println("   ECOSISTEMA DE RED SOCIAL PROFESIONAL      ");
        System.out.println("=============================================");

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Crear nuevo usuario");
            System.out.println("2. Buscar usuario por ID (Identificacion Inmediata)");
            System.out.println("3. Editar usuario existente");
            System.out.println("4. Deshacer ultimo cambio (Historial de Cambios)");
            System.out.println("5. Eliminar usuario de la plataforma");
            System.out.println("0. Salir");

            opcion = SelectorPerfil.leerEnteroEnRango(scanner, "\nSeleccione una opcion: ", 0, 5);

            switch (opcion) {
                case 1:
                    // Ahora le pasamos la 'plataforma' para que valide el ID en vivo
                    Usuario nuevoUsuario = gestorPerfil.completarUsuario(scanner, plataforma);

                    // Lo insertamos (sabemos que va a dar true porque ya lo validamos,
                    // pero mantenemos la buena práctica de chequear)
                    boolean exito = plataforma.insertar(nuevoUsuario);

                    if (exito) {
                        System.out.println("-> Usuario guardado exitosamente en la plataforma.");
                    } else {
                        System.out.println("-> ERROR inesperado al guardar el usuario.");
                    }
                    break;

                case 2:
                    // Demuestra el O(1): Busca sin iterar
                    System.out.println("\n--- BUSCAR USUARIO ---");
                    int idBuscar = SelectorPerfil.leerEntero(scanner, "Ingrese el ID a buscar: ");
                    Usuario encontrado = plataforma.buscar(idBuscar);

                    if (encontrado != null) {
                        System.out.println("\nUSUARIO ENCONTRADO:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("\n-> Error: No existe ningun usuario con el ID " + idBuscar);
                    }
                    break;

                case 3:
                    // Busca el usuario primero, si existe, abre el submenú de edición del GestorPerfil
                    System.out.println("\n--- EDITAR USUARIO ---");
                    int idEditar = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del usuario a editar: ");
                    Usuario usuarioAEditar = plataforma.buscar(idEditar);

                    if (usuarioAEditar != null) {
                        gestorPerfil.editarUsuario(scanner, usuarioAEditar);
                    } else {
                        System.out.println("\n-> Error: No se puede editar, el usuario no existe.");
                    }
                    break;

                case 4:
                    // Busca el usuario y le aplica la función de deshacer
                    System.out.println("\n--- DESHACER CAMBIOS ---");
                    int idDeshacer = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del usuario: ");
                    Usuario usuarioADeshacer = plataforma.buscar(idDeshacer);

                    if (usuarioADeshacer != null) {
                        gestorPerfil.deshacerCambio(usuarioADeshacer);
                    } else {
                        System.out.println("\n-> Error: Usuario no encontrado.");
                    }
                    break;

                case 5:
                    // Elimina usando la lógica de la Tabla Hash
                    System.out.println("\n--- ELIMINAR USUARIO ---");
                    int idEliminar = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del usuario a eliminar: ");
                    boolean eliminado = plataforma.eliminar(idEliminar);

                    if (eliminado) {
                        System.out.println("\n-> Usuario eliminado con exito.");
                    } else {
                        System.out.println("\n-> Error: No se encontro un usuario con ese ID para eliminar.");
                    }
                    break;

                case 0:
                    System.out.println("\nSaliendo del sistema... ¡Hasta luego!");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}
