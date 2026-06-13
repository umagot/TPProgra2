import Interfaces.*;
import Implementaciones.*;
import archivos_principales.*;

import java.util.Scanner;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DiccionarioUsuarios plataforma = new DiccionarioUsuarios(100);
        GestorPerfil gestorPerfil = new GestorPerfil(10);

        // 1. INSTANCIAMOS EL GRAFO (Capacidad 100, dirigido = false porque la amistad es mutua)
        GrafoMatrizAdyacencia redSocial = new GrafoMatrizAdyacencia(100, false);

        int opcion;

        System.out.println("=============================================");
        System.out.println("   ECOSISTEMA DE RED SOCIAL PROFESIONAL      ");
        System.out.println("=============================================");

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Crear nuevo usuario");
            System.out.println("2. Buscar usuario por ID");
            System.out.println("3. Editar usuario existente");
            System.out.println("4. Deshacer ultimo cambio");
            System.out.println("5. Eliminar usuario de la plataforma");
            System.out.println("6. Conectar dos usuarios (Agregar Amistad)");
            System.out.println("7. Ver recomendaciones y red de un usuario");
            System.out.println("0. Salir");

            opcion = SelectorPerfil.leerEnteroEnRango(scanner, "\nSeleccione una opcion: ", 0, 7);

            switch (opcion) {
                case 1:
                    Usuario nuevoUsuario = gestorPerfil.completarUsuario(scanner, plataforma);
                    boolean exito = plataforma.insertar(nuevoUsuario);
                    if (exito) {
                        // 2. LO AGREGAMOS AL GRAFO TAMBIÉN
                        redSocial.insertarVertice(nuevoUsuario);
                        System.out.println("-> Usuario guardado exitosamente en la plataforma y en la red.");
                    } else {
                        System.out.println("-> ERROR inesperado al guardar el usuario.");
                    }
                    break;

                // ... (Los casos 2, 3 y 4 quedan exactamente igual que antes) ...

                case 5:
                    System.out.println("\n--- ELIMINAR USUARIO ---");
                    int idEliminar = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del usuario a eliminar: ");

                    Usuario usuarioAEliminar = plataforma.buscar(idEliminar);
                    if (usuarioAEliminar != null) {
                        plataforma.eliminar(idEliminar);
                        // 3. LO ELIMINAMOS DEL GRAFO TAMBIÉN
                        redSocial.eliminarVertice(usuarioAEliminar);
                        System.out.println("\n-> Usuario eliminado con exito de la plataforma y sus conexiones.");
                    } else {
                        System.out.println("\n-> Error: No se encontro un usuario con ese ID.");
                    }
                    break;

                case 6:
                    System.out.println("\n--- CONECTAR USUARIOS ---");
                    int id1 = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del primer usuario: ");
                    int id2 = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del segundo usuario: ");

                    Usuario u1 = plataforma.buscar(id1);
                    Usuario u2 = plataforma.buscar(id2);

                    if (u1 != null && u2 != null) {
                        redSocial.insertarArista(u1, u2);
                        System.out.println("-> ¡" + u1.getNombre() + " y " + u2.getNombre() + " ahora estan conectados!");
                    } else {
                        System.out.println("-> Error: Uno o ambos IDs no existen en la plataforma.");
                    }
                    break;

                case 7:
                    System.out.println("\n--- MI RED Y RECOMENDACIONES ---");
                    int idRed = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del usuario: ");
                    Usuario uRed = plataforma.buscar(idRed);

                    if (uRed != null) {
                        System.out.println();
                        redSocial.bfsNiveles(uRed); // Muestra los niveles de separación
                        System.out.println();
                        redSocial.recomendarAmigos(uRed); // Sugiere los de nivel 2
                    } else {
                        System.out.println("-> Error: Usuario no encontrado.");
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
