package archivos_principales;

import java.time.LocalDateTime;

public class SolicitudEmpleo implements Comparable<SolicitudEmpleo> {
    private static int contadorId = 1;

    private final int idSolicitud;
    private String nombrePostulante;
    private Postulacion puesto;
    private LocalDateTime fechaLlegada;

    public SolicitudEmpleo(String nombrePostulante, Postulacion puesto) {
        this.idSolicitud = contadorId++;
        this.nombrePostulante = nombrePostulante;
        this.puesto = puesto;
        this.fechaLlegada = LocalDateTime.now();
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public String getNombrePostulante() {
        return nombrePostulante;
    }

    public Postulacion getPuesto() {
        return puesto;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }


    @Override
    public int compareTo(SolicitudEmpleo otra) {
        return Integer.compare(this.idSolicitud, otra.idSolicitud);
    }

    @Override
    public String toString() {
        return "[Solicitud #" + idSolicitud + "] " + nombrePostulante + " -> " + puesto.getNombrePuesto() + " en " + puesto.getEmpresa();
    }
}