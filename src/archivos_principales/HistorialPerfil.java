package archivos_principales;

public class HistorialPerfil {

    private Implementaciones.Pila<Usuario> historial;

    public HistorialPerfil(int tamanoMaximo) {
        historial = new Implementaciones.Pila<Usuario>(tamanoMaximo);
    }

    public boolean guardarEstado(Usuario usuario) {
        if (usuario == null) {
            System.out.println("No hay usuario para guardar en historial.");
            return false;
        }

        if (historial.estaLlena()) {
            System.out.println("Historial lleno. No se puede guardar el cambio.");
            return false;
        }

        historial.apilar(new Usuario(usuario));
        return true;
    }

    public boolean puedeDeshacer() {
        return !historial.estaVacia();
    }

    public void deshacer(Usuario usuario) {
        if (usuario == null) {
            System.out.println("No hay usuario para restaurar.");
            return;
        }

        if (historial.estaVacia()) {
            System.out.println("No hay cambios para deshacer.");
            return;
        }

        Usuario anterior = historial.desapilar();

        usuario.setNombre(anterior.getNombre());
        usuario.setMail(anterior.getMail());
        usuario.setPerfiles(anterior.getPerfiles());

        System.out.println("Se restauro el cambio anterior.");
    }
}
