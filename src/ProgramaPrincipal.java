import Interfaces.*;
import Implementaciones.*;
import archivos_principales.*;

import java.util.Scanner;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Categoria catalogoGeneral = inicializarCatalogo();

        DiccionarioUsuarios plataforma = new DiccionarioUsuarios(100);
        GestorPerfil gestorPerfil = new GestorPerfil(10, catalogoGeneral);
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
            System.out.println("8. Gestion de postulaciones");
            System.out.println("0. Salir");

            opcion = SelectorPerfil.leerEnteroEnRango(scanner, "\nSeleccione una opcion: ", 0, 8);

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
                    System.out.println("\n--- EDITAR USUARIO ---");
                    int idEditar = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del usuario a editar: ");
                    Usuario usuarioAEditar = plataforma.buscar(idEditar);

                    if (usuarioAEditar != null) {
                        gestorPerfil.editarUsuario(scanner, usuarioAEditar);
                    } else {
                        System.out.println("\n-> Error: No existe ningun usuario con el ID " + idEditar);
                    }

                    break;

                case 4:
                    System.out.println("\n--- DESHACER CAMBIOS ---");
                    int idDeshacer = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del usuario: ");
                    Usuario usuarioADeshacer = plataforma.buscar(idDeshacer);

                    if (usuarioADeshacer != null) {
                        gestorPerfil.deshacerCambio(usuarioADeshacer);
                    } else {
                        System.out.println("\n-> Error: No existe ningun usuario con el ID " + idDeshacer);
                    }

                    break;

                case 5:
                    System.out.println("\n--- ELIMINAR USUARIO ---");
                    int idEliminar = SelectorPerfil.leerEntero(scanner, "Ingrese el ID del usuario a eliminar: ");

                    Usuario usuarioAEliminar = plataforma.buscar(idEliminar);
                    if (usuarioAEliminar != null) {
                        plataforma.eliminar(idEliminar);
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
                case 8:
                    GestorPostulaciones gestor = new GestorPostulaciones(5);

                    gestor.recibirSolicitud(new SolicitudEmpleo("Carlos Pérez", Postulacion.DEV_FULLSTACK));
                    gestor.recibirSolicitud(new SolicitudEmpleo("Ana Gómez", Postulacion.UX_UI_DESIGNER));
                    gestor.recibirSolicitud(new SolicitudEmpleo("Juan López", Postulacion.DATA_ENGINEER));

                    System.out.println("\n--- Estado de la revisión ---");
                    gestor.verProximaSolicitud();

                    gestor.procesarSiguienteSolicitud();
                    gestor.procesarSiguienteSolicitud();
                    gestor.recibirSolicitud(new SolicitudEmpleo("María Rodríguez", Postulacion.PROJECT_MANAGER));
                    gestor.verProximaSolicitud();
                    break;
                case 0:
                    System.out.println("\nSaliendo del sistema... ¡Hasta luego!");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
    private static Categoria inicializarCatalogo() {
        Categoria raiz = new Categoria("Catalogo de Especialidades");

        // ==========================================
        // 0. DEFINIMOS LAS HABILIDADES BLANDAS (Una sola vez)
        // ==========================================
        Habilidad[] habilidadesBlandas = {
                new Habilidad("Comunicacion", true),
                new Habilidad("Trabajo en equipo", true),
                new Habilidad("Liderazgo", true),
                new Habilidad("Responsabilidad", true),
                new Habilidad("Organizacion", true),
                new Habilidad("Resolucion de problemas", true),
                new Habilidad("Pensamiento critico", true),
                new Habilidad("Adaptabilidad", true),
                new Habilidad("Creatividad", true),
                new Habilidad("Empatia", true),
                new Habilidad("Negociacion", true),
                new Habilidad("Manejo del tiempo", true),
                new Habilidad("Proactividad", true),
                new Habilidad("Autonomia", true),
                new Habilidad("Atencion al detalle", true)
        };

        // ==========================================
        // 1. TECNOLOGIA
        // ==========================================
        Categoria tecnologia = new Categoria("Tecnologia");

        Categoria tecDesarrollo = new Categoria("Desarrollo");
        tecDesarrollo.agregar(new Habilidad("Java", false));
        tecDesarrollo.agregar(new Habilidad("Python", false));
        tecDesarrollo.agregar(new Habilidad("HTML", false));
        tecDesarrollo.agregar(new Habilidad("CSS", false));
        tecDesarrollo.agregar(new Habilidad("JavaScript", false));
        tecDesarrollo.agregar(new Habilidad("PHP", false));
        tecDesarrollo.agregar(new Habilidad("C#", false));
        tecDesarrollo.agregar(new Habilidad("C++", false));
        tecDesarrollo.agregar(new Habilidad("React", false));
        tecDesarrollo.agregar(new Habilidad("Node.js", false));

        Categoria tecBaseDatos = new Categoria("Base de datos");
        tecBaseDatos.agregar(new Habilidad("SQL", false));
        tecBaseDatos.agregar(new Habilidad("MySQL", false));
        tecBaseDatos.agregar(new Habilidad("Oracle", false));
        tecBaseDatos.agregar(new Habilidad("PostgreSQL", false));
        tecBaseDatos.agregar(new Habilidad("SQL Server", false));
        tecBaseDatos.agregar(new Habilidad("Modelado de datos", false));

        Categoria tecRedes = new Categoria("Redes");
        tecRedes.agregar(new Habilidad("TCP/IP", false));
        tecRedes.agregar(new Habilidad("Cisco", false));
        tecRedes.agregar(new Habilidad("Routing", false));
        tecRedes.agregar(new Habilidad("Switching", false));
        tecRedes.agregar(new Habilidad("Administracion de redes", false));

        Categoria tecCiberseguridad = new Categoria("Ciberseguridad");
        tecCiberseguridad.agregar(new Habilidad("Seguridad informatica", false));
        tecCiberseguridad.agregar(new Habilidad("Analisis de vulnerabilidades", false));
        tecCiberseguridad.agregar(new Habilidad("Pentesting", false));
        tecCiberseguridad.agregar(new Habilidad("Firewalls", false));

        Categoria tecSoporte = new Categoria("Soporte tecnico");
        tecSoporte.agregar(new Habilidad("Soporte a usuario", false));
        tecSoporte.agregar(new Habilidad("Windows", false));
        tecSoporte.agregar(new Habilidad("Linux", false));
        tecSoporte.agregar(new Habilidad("Hardware", false));
        tecSoporte.agregar(new Habilidad("Mesa de ayuda", false));

        Categoria tecIA = new Categoria("Inteligencia artificial");
        tecIA.agregar(new Habilidad("Machine learning", false));
        tecIA.agregar(new Habilidad("Deep learning", false));
        tecIA.agregar(new Habilidad("Procesamiento de lenguaje natural", false));
        tecIA.agregar(new Habilidad("Analisis de datos", false));

        tecnologia.agregar(tecDesarrollo);
        tecnologia.agregar(tecBaseDatos);
        tecnologia.agregar(tecRedes);
        tecnologia.agregar(tecCiberseguridad);
        tecnologia.agregar(tecSoporte);
        tecnologia.agregar(tecIA);
        raiz.agregar(tecnologia);

        // ==========================================
        // 2. MARKETING
        // ==========================================
        Categoria marketing = new Categoria("Marketing");

        Categoria mktDigital = new Categoria("Marketing digital");
        mktDigital.agregar(new Habilidad("Google Ads", false));
        mktDigital.agregar(new Habilidad("Meta Ads", false));
        mktDigital.agregar(new Habilidad("Email marketing", false));

        Categoria mktPublicidad = new Categoria("Publicidad");
        mktPublicidad.agregar(new Habilidad("Copywriting", false));

        Categoria mktSeo = new Categoria("SEO");
        mktSeo.agregar(new Habilidad("SEO tecnico", false));

        Categoria mktRedes = new Categoria("Redes sociales");
        mktRedes.agregar(new Habilidad("Community management", false));

        Categoria mktBranding = new Categoria("Branding");
        mktBranding.agregar(new Habilidad("Branding personal", false));

        marketing.agregar(mktDigital);
        marketing.agregar(mktPublicidad);
        marketing.agregar(mktSeo);
        marketing.agregar(mktRedes);
        marketing.agregar(mktBranding);
        raiz.agregar(marketing);

        // ==========================================
        // 3. DISENO
        // ==========================================
        Categoria diseno = new Categoria("Diseno");

        Categoria disGrafico = new Categoria("Diseno grafico");
        disGrafico.agregar(new Habilidad("Photoshop", false));
        disGrafico.agregar(new Habilidad("Illustrator", false));

        Categoria disUxUi = new Categoria("UX/UI");
        disUxUi.agregar(new Habilidad("Figma", false));
        disUxUi.agregar(new Habilidad("Prototipado", false));

        Categoria disWeb = new Categoria("Diseno web");
        disWeb.agregar(new Habilidad("Diseno responsive", false));

        Categoria disIlustracion = new Categoria("Ilustracion");
        disIlustracion.agregar(new Habilidad("Ilustracion digital", false));

        Categoria disAnimacion = new Categoria("Animacion");
        disAnimacion.agregar(new Habilidad("Animacion 2D", false));

        diseno.agregar(disGrafico);
        diseno.agregar(disUxUi);
        diseno.agregar(disWeb);
        diseno.agregar(disIlustracion);
        diseno.agregar(disAnimacion);
        raiz.agregar(diseno);

        // ==========================================
        // 4. NEGOCIOS
        // ==========================================
        Categoria negocios = new Categoria("Negocios");

        Categoria negAdmin = new Categoria("Administracion");
        negAdmin.agregar(new Habilidad("Gestion administrativa", false));

        Categoria negFinanzas = new Categoria("Finanzas");
        negFinanzas.agregar(new Habilidad("Analisis financiero", false));

        Categoria negContabilidad = new Categoria("Contabilidad");
        negContabilidad.agregar(new Habilidad("Contabilidad general", false));

        Categoria negProject = new Categoria("Project management");
        negProject.agregar(new Habilidad("Scrum", false));
        negProject.agregar(new Habilidad("Kanban", false));
        negProject.agregar(new Habilidad("Planificacion de proyectos", false));

        Categoria negRRHH = new Categoria("Recursos humanos");
        negRRHH.agregar(new Habilidad("Seleccion de personal", false));

        Categoria negEmprendimiento = new Categoria("Emprendimiento");
        negEmprendimiento.agregar(new Habilidad("Plan de negocios", false));

        negocios.agregar(negAdmin);
        negocios.agregar(negFinanzas);
        negocios.agregar(negContabilidad);
        negocios.agregar(negProject);
        negocios.agregar(negRRHH);
        negocios.agregar(negEmprendimiento);
        raiz.agregar(negocios);

        // ==========================================
        // 5. CIENCIAS JURIDICAS
        // ==========================================
        Categoria juridicas = new Categoria("Ciencias Juridicas");

        Categoria jurCivil = new Categoria("Derecho civil");
        jurCivil.agregar(new Habilidad("Contratos", false));
        jurCivil.agregar(new Habilidad("Derecho de familia", false));

        Categoria jurPenal = new Categoria("Derecho penal");
        jurPenal.agregar(new Habilidad("Defensa penal", false));

        Categoria jurLaboral = new Categoria("Derecho laboral");
        jurLaboral.agregar(new Habilidad("Liquidaciones laborales", false));

        Categoria jurComercial = new Categoria("Derecho comercial");
        jurComercial.agregar(new Habilidad("Sociedades comerciales", false));

        Categoria jurInformatico = new Categoria("Derecho informatico");
        jurInformatico.agregar(new Habilidad("Proteccion de datos", false));

        juridicas.agregar(jurCivil);
        juridicas.agregar(jurPenal);
        juridicas.agregar(jurLaboral);
        juridicas.agregar(jurComercial);
        juridicas.agregar(jurInformatico);
        raiz.agregar(juridicas);

        // ==========================================
        // 6. COMUNICACION
        // ==========================================
        Categoria comunicacion = new Categoria("Comunicacion");

        Categoria comPeriodismo = new Categoria("Periodismo");
        comPeriodismo.agregar(new Habilidad("Redaccion periodistica", false));

        Categoria comInstitucional = new Categoria("Comunicacion institucional");
        comInstitucional.agregar(new Habilidad("Comunicados institucionales", false));

        Categoria comRedaccion = new Categoria("Redaccion");
        comRedaccion.agregar(new Habilidad("Redaccion creativa", false));

        Categoria comAudiovisual = new Categoria("Produccion audiovisual");
        comAudiovisual.agregar(new Habilidad("Edicion de video", false));

        Categoria comRRPr = new Categoria("Relaciones publicas");
        comRRPr.agregar(new Habilidad("Prensa", false));

        comunicacion.agregar(comPeriodismo);
        comunicacion.agregar(comInstitucional);
        comunicacion.agregar(comRedaccion);
        comunicacion.agregar(comAudiovisual);
        comunicacion.agregar(comRRPr);
        raiz.agregar(comunicacion);

        // ==========================================
        // 7. SALUD
        // ==========================================
        Categoria salud = new Categoria("Salud");

        Categoria salMedicina = new Categoria("Medicina");
        salMedicina.agregar(new Habilidad("Atencion clinica", false));

        Categoria salPsicologia = new Categoria("Psicologia");
        salPsicologia.agregar(new Habilidad("Terapia individual", false));

        Categoria salNutricion = new Categoria("Nutricion");
        salNutricion.agregar(new Habilidad("Plan nutricional", false));

        Categoria salEnfermeria = new Categoria("Enfermeria");
        salEnfermeria.agregar(new Habilidad("Cuidados de enfermeria", false));

        Categoria salKinesiologia = new Categoria("Kinesiologia");
        salKinesiologia.agregar(new Habilidad("Rehabilitacion", false));

        salud.agregar(salMedicina);
        salud.agregar(salPsicologia);
        salud.agregar(salNutricion);
        salud.agregar(salEnfermeria);
        salud.agregar(salKinesiologia);
        raiz.agregar(salud);

        // ==========================================
        // 8. ENTRETENIMIENTO
        // ==========================================
        Categoria entretenimiento = new Categoria("Entretenimiento");

        Categoria entMusica = new Categoria("Musica");
        entMusica.agregar(new Habilidad("Canto", false));

        Categoria entCine = new Categoria("Cine");
        entCine.agregar(new Habilidad("Guion", false));

        Categoria entTeatro = new Categoria("Teatro");
        entTeatro.agregar(new Habilidad("Actuacion", false));

        Categoria entVideojuegos = new Categoria("Videojuegos");
        entVideojuegos.agregar(new Habilidad("Game design", false));

        Categoria entStreaming = new Categoria("Streaming");
        entStreaming.agregar(new Habilidad("Produccion de streaming", false));

        entretenimiento.agregar(entMusica);
        entretenimiento.agregar(entCine);
        entretenimiento.agregar(entTeatro);
        entretenimiento.agregar(entVideojuegos);
        entretenimiento.agregar(entStreaming);
        raiz.agregar(entretenimiento);

        // ==========================================
        // 9. TURISMO
        // ==========================================
        Categoria turismo = new Categoria("Turismo");

        Categoria turHoteleria = new Categoria("Hoteleria");
        turHoteleria.agregar(new Habilidad("Recepcion hotelera", false));

        Categoria turGuia = new Categoria("Guia turistico");
        turGuia.agregar(new Habilidad("Guia de turismo", false));

        Categoria turAgencia = new Categoria("Agencia de viajes");
        turAgencia.agregar(new Habilidad("Armado de paquetes", false));

        Categoria turGastronomia = new Categoria("Gastronomia");
        turGastronomia.agregar(new Habilidad("Cocina", false));

        Categoria turEventos = new Categoria("Eventos");
        turEventos.agregar(new Habilidad("Organizacion de eventos", false));

        turismo.agregar(turHoteleria);
        turismo.agregar(turGuia);
        turismo.agregar(turAgencia);
        turismo.agregar(turGastronomia);
        turismo.agregar(turEventos);
        raiz.agregar(turismo);

        // ==========================================
        // 10. OTROS
        // ==========================================
        Categoria otros = new Categoria("Otros");

        Categoria otrSub = new Categoria("Otros");
        otrSub.agregar(new Habilidad("Oficios", false));
        otrSub.agregar(new Habilidad("Capacitacion", false));

        otros.agregar(otrSub);
        raiz.agregar(otros);

        // ==========================================
        // INYECCIÓN AUTOMÁTICA DE HABILIDADES BLANDAS
        // ==========================================
        // Recorremos el árbol: Raiz -> Especialidades -> Subespecialidades
        Componente[] especialidades = raiz.getHijos();

        for (int i = 0; i < especialidades.length; i++) {
            Categoria especialidad = (Categoria) especialidades[i];
            Componente[] subespecialidades = especialidad.getHijos();

            for (int j = 0; j < subespecialidades.length; j++) {
                Categoria sub = (Categoria) subespecialidades[j];

                // Le agregamos a cada subespecialidad todas las habilidades blandas
                for (int k = 0; k < habilidadesBlandas.length; k++) {
                    sub.agregar(habilidadesBlandas[k]);
                }
            }
        }

        return raiz;
    }
}
