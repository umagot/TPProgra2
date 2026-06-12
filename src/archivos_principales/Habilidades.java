package archivos_principales;

public enum Habilidades {

    // TECNOLOGIA - DESARROLLO
    JAVA("Java", Subespecialidad.DESARROLLO, false),
    PYTHON("Python", Subespecialidad.DESARROLLO, false),
    HTML("HTML", Subespecialidad.DESARROLLO, false),
    CSS("CSS", Subespecialidad.DESARROLLO, false),
    JAVASCRIPT("JavaScript", Subespecialidad.DESARROLLO, false),
    PHP("PHP", Subespecialidad.DESARROLLO, false),
    C_SHARP("C#", Subespecialidad.DESARROLLO, false),
    C_PLUS_PLUS("C++", Subespecialidad.DESARROLLO, false),
    REACT("React", Subespecialidad.DESARROLLO, false),
    NODE_JS("Node.js", Subespecialidad.DESARROLLO, false),

    // TECNOLOGIA - BASE DE DATOS
    SQL("SQL", Subespecialidad.BASE_DE_DATOS, false),
    MYSQL("MySQL", Subespecialidad.BASE_DE_DATOS, false),
    ORACLE("Oracle", Subespecialidad.BASE_DE_DATOS, false),
    POSTGRESQL("PostgreSQL", Subespecialidad.BASE_DE_DATOS, false),
    SQL_SERVER("SQL Server", Subespecialidad.BASE_DE_DATOS, false),
    MODELADO_DE_DATOS("Modelado de datos", Subespecialidad.BASE_DE_DATOS, false),

    // TECNOLOGIA - REDES
    TCP_IP("TCP/IP", Subespecialidad.REDES, false),
    CISCO("Cisco", Subespecialidad.REDES, false),
    ROUTING("Routing", Subespecialidad.REDES, false),
    SWITCHING("Switching", Subespecialidad.REDES, false),
    ADMINISTRACION_DE_REDES("Administracion de redes", Subespecialidad.REDES, false),

    // TECNOLOGIA - CIBERSEGURIDAD
    SEGURIDAD_INFORMATICA("Seguridad informatica", Subespecialidad.CIBERSEGURIDAD, false),
    ANALISIS_DE_VULNERABILIDADES("Analisis de vulnerabilidades", Subespecialidad.CIBERSEGURIDAD, false),
    PENTESTING("Pentesting", Subespecialidad.CIBERSEGURIDAD, false),
    FIREWALLS("Firewalls", Subespecialidad.CIBERSEGURIDAD, false),

    // TECNOLOGIA - SOPORTE TECNICO
    SOPORTE_USUARIO("Soporte a usuario", Subespecialidad.SOPORTE_TECNICO, false),
    WINDOWS("Windows", Subespecialidad.SOPORTE_TECNICO, false),
    LINUX("Linux", Subespecialidad.SOPORTE_TECNICO, false),
    HARDWARE("Hardware", Subespecialidad.SOPORTE_TECNICO, false),
    MESA_DE_AYUDA("Mesa de ayuda", Subespecialidad.SOPORTE_TECNICO, false),

    // TECNOLOGIA - INTELIGENCIA ARTIFICIAL
    MACHINE_LEARNING("Machine learning", Subespecialidad.INTELIGENCIA_ARTIFICIAL, false),
    DEEP_LEARNING("Deep learning", Subespecialidad.INTELIGENCIA_ARTIFICIAL, false),
    PROCESAMIENTO_LENGUAJE_NATURAL("Procesamiento de lenguaje natural", Subespecialidad.INTELIGENCIA_ARTIFICIAL, false),
    ANALISIS_DE_DATOS("Analisis de datos", Subespecialidad.INTELIGENCIA_ARTIFICIAL, false),

    // MARKETING
    GOOGLE_ADS("Google Ads", Subespecialidad.MARKETING_DIGITAL, false),
    META_ADS("Meta Ads", Subespecialidad.MARKETING_DIGITAL, false),
    EMAIL_MARKETING("Email marketing", Subespecialidad.MARKETING_DIGITAL, false),
    SEO_TECNICO("SEO tecnico", Subespecialidad.SEO, false),
    COPYWRITING("Copywriting", Subespecialidad.PUBLICIDAD, false),
    COMMUNITY_MANAGEMENT("Community management", Subespecialidad.REDES_SOCIALES, false),
    BRANDING_PERSONAL("Branding personal", Subespecialidad.BRANDING, false),

    // DISENO
    PHOTOSHOP("Photoshop", Subespecialidad.DISENO_GRAFICO, false),
    ILLUSTRATOR("Illustrator", Subespecialidad.DISENO_GRAFICO, false),
    FIGMA("Figma", Subespecialidad.UX_UI, false),
    PROTOTIPADO("Prototipado", Subespecialidad.UX_UI, false),
    DISENO_RESPONSIVE("Diseno responsive", Subespecialidad.DISENO_WEB, false),
    ILUSTRACION_DIGITAL("Ilustracion digital", Subespecialidad.ILUSTRACION, false),
    ANIMACION_2D("Animacion 2D", Subespecialidad.ANIMACION, false),

    // NEGOCIOS
    GESTION_ADMINISTRATIVA("Gestion administrativa", Subespecialidad.ADMINISTRACION, false),
    ANALISIS_FINANCIERO("Analisis financiero", Subespecialidad.FINANZAS, false),
    CONTABILIDAD_GENERAL("Contabilidad general", Subespecialidad.CONTABILIDAD, false),
    SCRUM("Scrum", Subespecialidad.PROJECT_MANAGEMENT, false),
    KANBAN("Kanban", Subespecialidad.PROJECT_MANAGEMENT, false),
    PLANIFICACION_DE_PROYECTOS("Planificacion de proyectos", Subespecialidad.PROJECT_MANAGEMENT, false),
    SELECCION_DE_PERSONAL("Seleccion de personal", Subespecialidad.RECURSOS_HUMANOS, false),
    PLAN_DE_NEGOCIOS("Plan de negocios", Subespecialidad.EMPRENDIMIENTO, false),

    // CIENCIAS JURIDICAS
    CONTRATOS("Contratos", Subespecialidad.DERECHO_CIVIL, false),
    DERECHO_DE_FAMILIA("Derecho de familia", Subespecialidad.DERECHO_CIVIL, false),
    DEFENSA_PENAL("Defensa penal", Subespecialidad.DERECHO_PENAL, false),
    LIQUIDACIONES_LABORALES("Liquidaciones laborales", Subespecialidad.DERECHO_LABORAL, false),
    SOCIEDADES_COMERCIALES("Sociedades comerciales", Subespecialidad.DERECHO_COMERCIAL, false),
    PROTECCION_DE_DATOS("Proteccion de datos", Subespecialidad.DERECHO_INFORMATICO, false),

    // COMUNICACION
    REDACCION_PERIODISTICA("Redaccion periodistica", Subespecialidad.PERIODISMO, false),
    COMUNICADOS_INSTITUCIONALES("Comunicados institucionales", Subespecialidad.COMUNICACION_INSTITUCIONAL, false),
    REDACCION_CREATIVA("Redaccion creativa", Subespecialidad.REDACCION, false),
    EDICION_DE_VIDEO("Edicion de video", Subespecialidad.PRODUCCION_AUDIOVISUAL, false),
    PRENSA("Prensa", Subespecialidad.RELACIONES_PUBLICAS, false),

    // SALUD
    ATENCION_CLINICA("Atencion clinica", Subespecialidad.MEDICINA, false),
    TERAPIA_INDIVIDUAL("Terapia individual", Subespecialidad.PSICOLOGIA, false),
    PLAN_NUTRICIONAL("Plan nutricional", Subespecialidad.NUTRICION, false),
    CUIDADOS_DE_ENFERMERIA("Cuidados de enfermeria", Subespecialidad.ENFERMERIA, false),
    REHABILITACION("Rehabilitacion", Subespecialidad.KINESIOLOGIA, false),

    // ENTRETENIMIENTO
    CANTO("Canto", Subespecialidad.MUSICA, false),
    GUION("Guion", Subespecialidad.CINE, false),
    ACTUACION("Actuacion", Subespecialidad.TEATRO, false),
    GAME_DESIGN("Game design", Subespecialidad.VIDEOJUEGOS, false),
    PRODUCCION_DE_STREAMING("Produccion de streaming", Subespecialidad.STREAMING, false),

    // TURISMO
    RECEPCION_HOTELERA("Recepcion hotelera", Subespecialidad.HOTELERIA, false),
    GUIA_DE_TURISMO("Guia de turismo", Subespecialidad.GUIA_TURISTICO, false),
    ARMADO_DE_PAQUETES("Armado de paquetes", Subespecialidad.AGENCIA_DE_VIAJES, false),
    COCINA("Cocina", Subespecialidad.GASTRONOMIA, false),
    ORGANIZACION_DE_EVENTOS("Organizacion de eventos", Subespecialidad.EVENTOS, false),

    // OTROS
    OFICIOS("Oficios", Subespecialidad.OTROS, false),
    CAPACITACION("Capacitacion", Subespecialidad.OTROS, false),

    // HABILIDADES BLANDAS - APLICAN A CUALQUIER SUBESPECIALIDAD
    COMUNICACION("Comunicacion", null, true),
    TRABAJO_EN_EQUIPO("Trabajo en equipo", null, true),
    LIDERAZGO("Liderazgo", null, true),
    RESPONSABILIDAD("Responsabilidad", null, true),
    ORGANIZACION("Organizacion", null, true),
    RESOLUCION_DE_PROBLEMAS("Resolucion de problemas", null, true),
    PENSAMIENTO_CRITICO("Pensamiento critico", null, true),
    ADAPTABILIDAD("Adaptabilidad", null, true),
    CREATIVIDAD("Creatividad", null, true),
    EMPATIA("Empatia", null, true),
    NEGOCIACION("Negociacion", null, true),
    MANEJO_DEL_TIEMPO("Manejo del tiempo", null, true),
    PROACTIVIDAD("Proactividad", null, true),
    AUTONOMIA("Autonomia", null, true),
    ATENCION_AL_DETALLE("Atencion al detalle", null, true);

    private String descripcion;
    private Subespecialidad subespecialidad;
    private boolean blanda;

    Habilidades(String descripcion, Subespecialidad subespecialidad, boolean blanda) {
        this.descripcion = descripcion;
        this.subespecialidad = subespecialidad;
        this.blanda = blanda;
    }

    public Subespecialidad getSubespecialidad() {
        return subespecialidad;
    }

    public boolean esBlanda() {
        return blanda;
    }

    public boolean esTecnica() {
        return !blanda;
    }

    public boolean perteneceA(Subespecialidad subespecialidad) {
        if (this.blanda) {
            return true;
        }

        return this.subespecialidad == subespecialidad;
    }

    public String toString() {
        return descripcion;
    }
}