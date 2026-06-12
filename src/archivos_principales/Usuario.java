package archivos_principales;

public class Usuario implements Comparable<Usuario> {

    int id;
    String nombre;
    Especialidad especialidad;
    Subespecialidad subespecialidad;
    String mail;
    Habilidades [] habilidades;

    //Agrego este constructor para las pruebas en main con solo los 3 parametros que usamos por ahora
    public Usuario(String nombre, int id, String mail) {
        this.nombre = nombre;
        this.id = id;
        this.mail = mail;
        this.especialidad = null;
        this.subespecialidad = null;
        this.habilidades = null;
    }

    public Usuario(String nombre, int id, String mail, Especialidad  especialidad, Subespecialidad  subespecialidad, Habilidades [] habilidades) {
        this.nombre = nombre;
        this.id = id;
        this.mail = mail;
        this.especialidad = especialidad;
        this.subespecialidad = subespecialidad;
        this.habilidades = copiarHabilidades(habilidades);
    }

    // Constructor copia para guardar historial en la pila
    public Usuario(Usuario otro) {
        this.nombre = otro.nombre;
        this.id = otro.id;
        this.mail = otro.mail;
        this.especialidad = otro.especialidad;
        this.subespecialidad = otro.subespecialidad;
        this.habilidades = copiarHabilidades(otro.habilidades);
    }

    private Habilidades[] copiarHabilidades(Habilidades[] origen) {
        if (origen == null) {
            return null;
        }

        Habilidades[] copia = new Habilidades[origen.length];

        for (int i = 0; i < origen.length; i++) {
            copia[i] = origen[i];
        }

        return copia;
    }

    private String habilidadesComoTexto() {
        if (habilidades == null || habilidades.length == 0) {
            return "Sin habilidades";
        }

        String texto = "";

        for (int i = 0; i < habilidades.length; i++) {
            texto = texto + habilidades[i];

            if (i < habilidades.length - 1) {
                texto = texto + ", ";
            }
        }

        return texto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Subespecialidad getSubespecialidad() {
        return subespecialidad;
    }

    public Habilidades[] getHabilidades() {
        return copiarHabilidades(habilidades);
    }

    public boolean esIgual(Usuario otro) {
        if (otro == null) {
            return false;
        }

        return this.id == otro.getId();
    }

    @Override
    public int compareTo(Usuario otro) {
        if (this.id < otro.id) {
            return -1;
        } else if (this.id > otro.id) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "@" + nombre +
                " | " + especialidad +
                " > " + subespecialidad +
                " > " + habilidadesComoTexto();
    }
}