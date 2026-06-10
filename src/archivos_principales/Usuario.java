package archivos_principales;

public class Usuario {
    int id;
    String nombre;
    String especialidad;
    String mail;
    String habilidades;

    public Usuario(String nombre, int id, String mail) {
        this.nombre = nombre;
        this.id = id;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }


    public boolean esIgual(Usuario otro) {
        if (otro == null) {
            return false;
        }
        return this.id == otro.getId();
    }

    public String toString() {
        return "@" + nombre;
    }
}