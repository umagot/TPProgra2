package archivos_principales;

public class Usuario implements Comparable<Usuario> {

    int id;
    String nombre;
    String mail;
    Perfil[] perfiles;

    public Usuario(String nombre, int id, String mail, Perfil[] perfiles) {
        this.nombre = nombre;
        this.id = id;
        this.mail = mail;
        this.perfiles = copiarPerfiles(perfiles);
    }

    // Constructor copia para guardar historial en la pila
    public Usuario(Usuario otro) {
        this.nombre = otro.nombre;
        this.id = otro.id;
        this.mail = otro.mail;
        this.perfiles = copiarPerfiles(otro.perfiles);
    }
    // constructor 2
    public Usuario(String nombre, int id, String mail) {
        this.nombre = nombre;
        this.id = id;
        this.mail = mail;
        this.perfiles = null;
    }

    private Perfil[] copiarPerfiles(Perfil[] origen) {
        if (origen == null) {
            return null;
        }

        Perfil[] copia = new Perfil[origen.length];

        for (int i = 0; i < origen.length; i++) {
            copia[i] = new Perfil(origen[i]);
        }

        return copia;
    }

    private String perfilesComoTexto() {
        if (perfiles == null || perfiles.length == 0) {
            return "Sin perfiles";
        }

        String texto = "";

        for (int i = 0; i < perfiles.length; i++) {
            texto = texto + perfiles[i];

            if (i < perfiles.length - 1) {
                texto = texto + " | ";
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

    public Perfil[] getPerfiles() {
        return copiarPerfiles(perfiles);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPerfiles(Perfil[] perfiles) {
        this.perfiles = copiarPerfiles(perfiles);
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
                " | Mail: " + mail +
                " | Perfiles: " + perfilesComoTexto();
    }
}