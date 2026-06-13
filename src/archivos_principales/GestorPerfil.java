package archivos_principales;

public class GestorPerfil {

    private HistorialPerfil historialPerfil;

    public GestorPerfil(int tamanoHistorial) {
        historialPerfil = new HistorialPerfil(tamanoHistorial);
    }

    public Usuario completarUsuario(java.util.Scanner scanner) {
        System.out.println("\n--- COMPLETAR USUARIO ---");

        String nombre = SelectorPerfil.leerTexto(scanner, "Ingrese nombre: ");
        int id = SelectorPerfil.leerEntero(scanner, "Ingrese id: ");
        String mail = SelectorPerfil.leerTexto(scanner, "Ingrese mail: ");

        Perfil[] perfiles = SelectorPerfil.cargarPerfiles(scanner);

        Usuario usuario = new Usuario(nombre, id, mail, perfiles);

        System.out.println("\nUsuario creado correctamente.");
        return usuario;
    }

    public void editarUsuario(java.util.Scanner scanner, Usuario usuario) {
        if (usuario == null) {
            System.out.println("Primero debe completar un usuario.");
            return;
        }

        int opcion;

        do {
            System.out.println("\n--- EDITAR USUARIO ---");
            System.out.println("Usuario actual:");
            System.out.println(usuario);

            System.out.println("\n1. Editar nombre");
            System.out.println("2. Editar mail");
            System.out.println("3. Reemplazar todos los perfiles");
            System.out.println("4. Agregar un perfil");
            System.out.println("5. Eliminar un perfil");
            System.out.println("6. Editar todo");
            System.out.println("0. Salir");

            opcion = SelectorPerfil.leerEnteroEnRango(scanner, "Opcion: ", 0, 6);

            switch (opcion) {
                case 1:
                    editarNombre(scanner, usuario);
                    break;

                case 2:
                    editarMail(scanner, usuario);
                    break;

                case 3:
                    reemplazarPerfiles(scanner, usuario);
                    break;

                case 4:
                    agregarPerfil(scanner, usuario);
                    break;

                case 5:
                    eliminarPerfil(scanner, usuario);
                    break;

                case 6:
                    editarTodo(scanner, usuario);
                    break;

                case 0:
                    System.out.println("Edicion finalizada.");
                    break;
            }

        } while (opcion != 0);
    }

    private void editarNombre(java.util.Scanner scanner, Usuario usuario) {
        if (!historialPerfil.guardarEstado(usuario)) {
            return;
        }

        String nuevoNombre = SelectorPerfil.leerTexto(scanner, "Ingrese nuevo nombre: ");
        usuario.setNombre(nuevoNombre);

        System.out.println("Nombre actualizado.");
    }

    private void editarMail(java.util.Scanner scanner, Usuario usuario) {
        if (!historialPerfil.guardarEstado(usuario)) {
            return;
        }

        String nuevoMail = SelectorPerfil.leerTexto(scanner, "Ingrese nuevo mail: ");
        usuario.setMail(nuevoMail);

        System.out.println("Mail actualizado.");
    }

    private void reemplazarPerfiles(java.util.Scanner scanner, Usuario usuario) {
        if (!historialPerfil.guardarEstado(usuario)) {
            return;
        }

        Perfil[] nuevosPerfiles = SelectorPerfil.cargarPerfiles(scanner);
        usuario.setPerfiles(nuevosPerfiles);

        System.out.println("Perfiles reemplazados.");
    }

    private void agregarPerfil(java.util.Scanner scanner, Usuario usuario) {
        if (!historialPerfil.guardarEstado(usuario)) {
            return;
        }

        Perfil nuevoPerfil = SelectorPerfil.cargarPerfil(scanner);
        Perfil[] actuales = usuario.getPerfiles();

        int cantidadActual = 0;

        if (actuales != null) {
            cantidadActual = actuales.length;
        }

        Perfil[] nuevos = new Perfil[cantidadActual + 1];

        for (int i = 0; i < cantidadActual; i++) {
            nuevos[i] = actuales[i];
        }

        nuevos[cantidadActual] = nuevoPerfil;

        usuario.setPerfiles(nuevos);

        System.out.println("Perfil agregado.");
    }

    private void eliminarPerfil(java.util.Scanner scanner, Usuario usuario) {
        Perfil[] actuales = usuario.getPerfiles();

        if (actuales == null || actuales.length == 0) {
            System.out.println("El usuario no tiene perfiles para eliminar.");
            return;
        }

        System.out.println("\nPerfiles actuales:");

        for (int i = 0; i < actuales.length; i++) {
            System.out.println((i + 1) + ". " + actuales[i]);
        }

        int opcion = SelectorPerfil.leerEnteroEnRango(
                scanner,
                "Seleccione perfil a eliminar: ",
                1,
                actuales.length
        );

        if (!historialPerfil.guardarEstado(usuario)) {
            return;
        }

        Perfil[] nuevos = new Perfil[actuales.length - 1];

        int j = 0;

        for (int i = 0; i < actuales.length; i++) {
            if (i != opcion - 1) {
                nuevos[j] = actuales[i];
                j++;
            }
        }

        usuario.setPerfiles(nuevos);

        System.out.println("Perfil eliminado.");
    }

    private void editarTodo(java.util.Scanner scanner, Usuario usuario) {
        if (!historialPerfil.guardarEstado(usuario)) {
            return;
        }

        String nuevoNombre = SelectorPerfil.leerTexto(scanner, "Ingrese nuevo nombre: ");
        String nuevoMail = SelectorPerfil.leerTexto(scanner, "Ingrese nuevo mail: ");
        Perfil[] nuevosPerfiles = SelectorPerfil.cargarPerfiles(scanner);

        usuario.setNombre(nuevoNombre);
        usuario.setMail(nuevoMail);
        usuario.setPerfiles(nuevosPerfiles);

        System.out.println("Usuario actualizado completamente.");
    }

    public void deshacerCambio(Usuario usuario) {
        historialPerfil.deshacer(usuario);
    }

    public void completarPerfilExistente(java.util.Scanner scanner, Usuario usuario) {
        if (usuario == null) {
            System.out.println("No hay usuario para completar.");
            return;
        }

        if (!historialPerfil.guardarEstado(usuario)) {
            return;
        }

        Perfil[] perfiles = SelectorPerfil.cargarPerfiles(scanner);
        usuario.setPerfiles(perfiles);

        System.out.println("Perfil completado correctamente.");
    }
}
