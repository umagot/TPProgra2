package archivos_principales;

public enum Subespecialidad {

    // TECNOLOGIA
    DESARROLLO("Desarrollo", Especialidad.TECNOLOGIA),
    BASE_DE_DATOS("Base de datos", Especialidad.TECNOLOGIA),
    REDES("Redes", Especialidad.TECNOLOGIA),
    CIBERSEGURIDAD("Ciberseguridad", Especialidad.TECNOLOGIA),
    SOPORTE_TECNICO("Soporte tecnico", Especialidad.TECNOLOGIA),
    INTELIGENCIA_ARTIFICIAL("Inteligencia artificial", Especialidad.TECNOLOGIA),

    // MARKETING
    MARKETING_DIGITAL("Marketing digital", Especialidad.MARKETING),
    PUBLICIDAD("Publicidad", Especialidad.MARKETING),
    SEO("SEO", Especialidad.MARKETING),
    REDES_SOCIALES("Redes sociales", Especialidad.MARKETING),
    BRANDING("Branding", Especialidad.MARKETING),

    // DISENO
    DISENO_GRAFICO("Diseno grafico", Especialidad.DISENO),
    UX_UI("UX/UI", Especialidad.DISENO),
    DISENO_WEB("Diseno web", Especialidad.DISENO),
    ILUSTRACION("Ilustracion", Especialidad.DISENO),
    ANIMACION("Animacion", Especialidad.DISENO),

    // NEGOCIOS
    ADMINISTRACION("Administracion", Especialidad.NEGOCIOS),
    FINANZAS("Finanzas", Especialidad.NEGOCIOS),
    CONTABILIDAD("Contabilidad", Especialidad.NEGOCIOS),
    PROJECT_MANAGEMENT("Project management", Especialidad.NEGOCIOS),
    RECURSOS_HUMANOS("Recursos humanos", Especialidad.NEGOCIOS),
    EMPRENDIMIENTO("Emprendimiento", Especialidad.NEGOCIOS),

    // CIENCIAS JURIDICAS
    DERECHO_CIVIL("Derecho civil", Especialidad.CIENCIAS_JURIDICAS),
    DERECHO_PENAL("Derecho penal", Especialidad.CIENCIAS_JURIDICAS),
    DERECHO_LABORAL("Derecho laboral", Especialidad.CIENCIAS_JURIDICAS),
    DERECHO_COMERCIAL("Derecho comercial", Especialidad.CIENCIAS_JURIDICAS),
    DERECHO_INFORMATICO("Derecho informatico", Especialidad.CIENCIAS_JURIDICAS),

    // COMUNICACION
    PERIODISMO("Periodismo", Especialidad.COMUNICACION),
    COMUNICACION_INSTITUCIONAL("Comunicacion institucional", Especialidad.COMUNICACION),
    REDACCION("Redaccion", Especialidad.COMUNICACION),
    PRODUCCION_AUDIOVISUAL("Produccion audiovisual", Especialidad.COMUNICACION),
    RELACIONES_PUBLICAS("Relaciones publicas", Especialidad.COMUNICACION),

    // SALUD
    MEDICINA("Medicina", Especialidad.SALUD),
    PSICOLOGIA("Psicologia", Especialidad.SALUD),
    NUTRICION("Nutricion", Especialidad.SALUD),
    ENFERMERIA("Enfermeria", Especialidad.SALUD),
    KINESIOLOGIA("Kinesiologia", Especialidad.SALUD),

    // ENTRETENIMIENTO
    MUSICA("Musica", Especialidad.ENTRETENIMIENTO),
    CINE("Cine", Especialidad.ENTRETENIMIENTO),
    TEATRO("Teatro", Especialidad.ENTRETENIMIENTO),
    VIDEOJUEGOS("Videojuegos", Especialidad.ENTRETENIMIENTO),
    STREAMING("Streaming", Especialidad.ENTRETENIMIENTO),

    // TURISMO
    HOTELERIA("Hoteleria", Especialidad.TURISMO),
    GUIA_TURISTICO("Guia turistico", Especialidad.TURISMO),
    AGENCIA_DE_VIAJES("Agencia de viajes", Especialidad.TURISMO),
    GASTRONOMIA("Gastronomia", Especialidad.TURISMO),
    EVENTOS("Eventos", Especialidad.TURISMO),

    // OTROS
    OTROS("Otros", Especialidad.OTROS);

    private String descripcion;
    private Especialidad especialidad;

    Subespecialidad(String descripcion, Especialidad especialidad) {
        this.descripcion = descripcion;
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public String toString() {
        return descripcion;
    }
}