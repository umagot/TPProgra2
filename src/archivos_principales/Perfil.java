package archivos_principales;

public class Perfil {

    Especialidad especialidad;
    Subespecialidad subespecialidad;
    Habilidades[] habilidades;

    public Perfil(
            Especialidad especialidad,
            Subespecialidad subespecialidad,
            Habilidades[] habilidades
    ) {
        this.especialidad = especialidad;
        this.subespecialidad = subespecialidad;
        this.habilidades = copiarHabilidades (habilidades);
    }

    public Perfil(Perfil otro) {
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Subespecialidad getSubespecialidad() {
        return subespecialidad;
    }

    public Habilidades[] getHabilidades() {
        return copiarHabilidades(habilidades);
    }

    public String toString() {
        return especialidad + " > " + subespecialidad + " > " + habilidadesComoTexto();
    }
}