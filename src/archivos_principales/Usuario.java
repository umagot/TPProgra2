package archivos_principales;

public class Usuario {
    int id;
    String nombre;
    String especialidad;
    String mail;
    String habilidades;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esIgual(Usuario otro) {
        if (otro == null) {
            return false;
        }
        return this.nombre.equals(otro.getNombre());
    }

    public String toString() {
        return "@" + nombre;
    }
}