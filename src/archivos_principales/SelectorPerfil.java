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
                System.out.println("Opcion invalida. Debe estar entre " + minimo + " y " + maximo + ".");
            }

        } while (numero < minimo || numero > maximo);

        return numero;
    }

    public static Especialidad elegirEspecialidad(java.util.Scanner scanner) {
        Especialidad[] especialidades = Especialidad.values();

        System.out.println("\nSeleccione una especialidad:");

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

        System.out.println("\nSeleccione una subespecialidad para " + especialidad + ":");

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

        System.out.println("-1. Finalizar carga de habilidades");

        Habilidades[] seleccionadasTemporal = new Habilidades[cantidadDisponibles];
        int cantidadSeleccionadas = 0;

        int opcion;

        do {
            opcion = leerEnteroEnRango(
                    scanner,
                    "Seleccione una habilidad o -1 para finalizar: ",
                    -1,
                    cantidadDisponibles
            );

            if (opcion != -1) {
                Habilidades habilidadElegida = disponibles[opcion - 1];

                if (yaFueElegida(seleccionadasTemporal, cantidadSeleccionadas, habilidadElegida)) {
                    System.out.println("Esa habilidad ya fue seleccionada.");
                } else {
                    seleccionadasTemporal[cantidadSeleccionadas] = habilidadElegida;
                    cantidadSeleccionadas++;
                    System.out.println("Habilidad agregada: " + habilidadElegida);
                }
            }

        } while (opcion != -1 && cantidadSeleccionadas < cantidadDisponibles);

        Habilidades[] habilidadesElegidas = new Habilidades[cantidadSeleccionadas];

        for (int i = 0; i < cantidadSeleccionadas; i++) {
            habilidadesElegidas[i] = seleccionadasTemporal[i];
        }

        return habilidadesElegidas;
    }

    private static boolean yaFueElegida(
            Habilidades[] seleccionadas,
            int cantidadSeleccionadas,
            Habilidades habilidad
    ) {
        for (int i = 0; i < cantidadSeleccionadas; i++) {
            if (seleccionadas[i] == habilidad) {
                return true;
            }
        }

        return false;
    }

    public static Perfil cargarPerfil(java.util.Scanner scanner) {
        Especialidad especialidad = elegirEspecialidad(scanner);
        Subespecialidad subespecialidad = elegirSubespecialidad(scanner, especialidad);
        Habilidades[] habilidades = elegirHabilidades(scanner, subespecialidad);

        return new Perfil(especialidad, subespecialidad, habilidades);
    }

    public static Perfil[] cargarPerfiles(java.util.Scanner scanner) {
        int cantidad = leerEnteroEnRango(
                scanner,
                "\nCuantos perfiles desea cargar?: ",
                1,
                10
        );

        Perfil[] perfiles = new Perfil[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nCarga del perfil " + (i + 1) + ":");
            perfiles[i] = cargarPerfil(scanner);
        }

        return perfiles;
    }
}