package archivos_principales;
public enum Postulacion {

    DEV_FULLSTACK("Desarrollador Fullstack Senior", "PixelForge Solutions", Especialidad.TECNOLOGIA),
    DATA_ENGINEER("Ingeniero de Datos Cloud", "DataStream Analytics", Especialidad.TECNOLOGIA),

    GROWTH_MARKETER("Growth Marketing Specialist", "LeadPulse Media", Especialidad.MARKETING),
    ANALISTA_SEO_SEM("Analista SEO/SEM Internacional", "RankUp Agency", Especialidad.MARKETING),


    UX_UI_DESIGNER("Product Designer (UX/UI)", "UserFirst Studio", Especialidad.DISENO),
    DISEÑADOR_GRAFICO("Diseñador Gráfico Creativo", "Kroma Concept", Especialidad.DISENO),


    ANALISTA_NEGOCIO("Analista de Negocios BI", "VentureScale Consulting", Especialidad.NEGOCIOS),
    PROJECT_MANAGER("Project Manager Agile", "SynergyOps", Especialidad.NEGOCIOS),


    ASESOR_LEGAL("Asesor Legal Corporativo", "LexShield Partners", Especialidad.CIENCIAS_JURIDICAS),
    CUMPLIMIENTO("Oficial de Cumplimiento Tech", "TrustArmor Legal", Especialidad.CIENCIAS_JURIDICAS),


    REDACTOR("Redactor Creativo & Copywriter", "WordCraft Agency", Especialidad.COMUNICACION),
    COMMUNITY_MANAGER("Social Media & Community Lead", "BuzzViral", Especialidad.COMUNICACION),

    DOCTOR_VIRTUAL("Médico de Telemedicina", "TeleSalud Global", Especialidad.SALUD),
    CONSULTOR_BIENESTAR("Consultor de Bienestar Corporativo", "VitalityCorp", Especialidad.SALUD),

    DISEÑADOR_VIDEOJUEGOS("Diseñador de Videojuegos Mobile", "NeonPlay Studios", Especialidad.ENTRETENIMIENTO),
    VIDEO_EDITOR("Editor de Video & Postproductor", "CutFrame Media", Especialidad.ENTRETENIMIENTO),

    COORDINADOR_VIAJE("Coordinador de Experiencias VIP", "WanderLust Travel", Especialidad.TURISMO),
    HOTEL_MANAGER("Gerente de Operaciones Hoteleras", "Zenith Resorts", Especialidad.TURISMO),

    ASISTENTE_VIRTUAL("Asistente Virtual Bilingüe", "RemoteTask", Especialidad.OTROS);

    private String nombrePuesto;
    private String empresa;
    private Especialidad especialidad;


    Postulacion(String nombrePuesto, String empresa, Especialidad especialidad) {
        this.nombrePuesto = nombrePuesto;
        this.empresa = empresa;
        this.especialidad = especialidad;
    }


    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return nombrePuesto + " en " + empresa + " (" + static_especialidad_string() + ")";
    }

    private String static_especialidad_string() {
        return especialidad.toString();
    }
}



