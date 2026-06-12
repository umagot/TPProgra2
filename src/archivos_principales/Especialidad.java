package archivos_principales;
    public enum Especialidad {

        TECNOLOGIA("Tecnologia"),
        MARKETING("Marketing"),
        DISENO("Diseno"),
        NEGOCIOS("Negocios"),
        CIENCIAS_JURIDICAS ("Ciencias Juridicas"),
        COMUNICACION ("Comunicacion"),
        SALUD ("Salud"),
        ENTRETENIMIENTO ("Entretenimiento"),
        TURISMO ("Turismo"),
        OTROS ("otros");

        private String descripcion;

        Especialidad(String descripcion) {
            this.descripcion = descripcion;
        }

        public String toString() {
            return descripcion;
        }
    }

