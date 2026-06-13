package archivos_principales;

public class SelectorPerfil {

    public static String leerTexto(java.util.Scanner scanner, String mensaje) {
        String texto;

        do {
            System.out.print(mensaje);
            texto = scanner.nextLine();

            if (texto == null || texto.length() == 0) {
                System.out.println("El valor no puede estar vacio.");
            }

        } while (texto == null || texto.length() == 0);

        return texto;
    }

    public static int leerEntero(java.util.Scanner scanner, String mensaje) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }

        return numero;
    }

    public static int leerEnteroEnRango(java.util.Scanner scanner, String mensaje, int minimo, int maximo) {
        int numero;

        do {
            numero = leerEntero(scanner, mensaje);

            if (numero < minimo || numero > maximo) {
                System.out.println("Opcion invalida.");
            }

        } while (numero < minimo || numero > maximo);

        return numero;
    }

    public static Especialidad elegirEspecialidad(java.util.Scanner scanner) {
        Especialidad[] especialidades = Especialidad.values();

        System.out.println("\nSeleccione especialidad:");

        for (int i = 0; i < especialidades.length; i++) {
            System.out.println((i + 1) + ". " + especialidades[i]);
        }

        int opcion = leerEnteroEnRango(scanner, "Opcion: ", 1, especialidades.length);

        return especialidades[opcion - 1];
    }

    public static Subespecialidad elegirSubespecialidad(java.util.Scanner scanner, Especialidad especialidad) {
        Subespecialidad[] todas = Subespecialidad.values();
        Subespecialidad[] filtradas = new Subespecialidad[todas.length];

        int cantidad = 0;

        for (int i = 0; i < todas.length; i++) {
            if (todas[i].getEspecialidad() == especialidad) {
                filtradas[cantidad] = todas[i];
                cantidad++;
            }
        }

        System.out.println("\nSeleccione subespecialidad para " + especialidad + ":");

        for (int i = 0; i < cantidad; i++) {
            System.out.println((i + 1) + ". " + filtradas[i]);
        }

        int opcion = leerEnteroEnRango(scanner, "Opcion: ", 1, cantidad);

        return filtradas[opcion - 1];
    }

    public static Habilidades[] elegirHabilidades(java.util.Scanner scanner, Subespecialidad subespecialidad) {
        Habilidades[] todas = Habilidades.values();
        Habilidades[] disponibles = new Habilidades[todas.length];

        int cantidadDisponibles = 0;

        for (int i = 0; i < todas.length; i++) {
            if (todas[i].perteneceA(subespecialidad)) {
                disponibles[cantidadDisponibles] = todas[i];
                cantidadDisponibles++;
            }
        }

        System.out.println("\nHabilidades disponibles para " + subespecialidad + ":");

        for (int i = 0; i < cantidadDisponibles; i++) {
            System.out.println((i + 1) + ". " + disponibles[i]);
        }

        int cantidadElegidas = leerEnteroEnRango(
                scanner,
                "Cuantas habilidades desea elegir?: ",
                1,
                cantidadDisponibles
        );

        Habilidades[] elegidas = new Habilidades[cantidadElegidas];

        for (int i = 0; i < cantidadElegidas; i++) {
            int opcion = leerEnteroEnRango(
                    scanner,
                    "Seleccione habilidad " + (i + 1) + ": ",
                    1,
                    cantidadDisponibles
            );

            elegidas[i] = disponibles[opcion - 1];
        }

        return elegidas;
    }

    public static Perfil cargarPerfil(java.util.Scanner scanner) {
        Especialidad especialidad = elegirEspecialidad(scanner);
        Subespecialidad subespecialidad = elegirSubespecialidad(scanner, especialidad);
        Habilidades[] habilidades = elegirHabilidades(scanner, subespecialidad);

        return new Perfil(especialidad, subespecialidad, habilidades);
    }

//    public static Perfil[] cargarPerfiles(java.util.Scanner scanner) {
//        int cantidad = leerEnteroEnRango(scanner, "\nCuantos perfiles desea cargar?: ", 1, 10);
//
//        Perfil[] perfiles = new Perfil[cantidad];
//
//        for (int i = 0; i < cantidad; i++) {
//            System.out.println("\nCarga del perfil " + (i + 1));
//            perfiles[i] = cargarPerfil(scanner);
//        }
//
//        return perfiles;
//    }
}