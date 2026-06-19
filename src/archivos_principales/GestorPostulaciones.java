package archivos_principales;

import Implementaciones.Cola;

public class GestorPostulaciones {
    private Cola<SolicitudEmpleo> colaDeEspera;


    public GestorPostulaciones(int capacidadMaxima) {
        this.colaDeEspera = new Cola<>(capacidadMaxima);
    }


    public void recibirSolicitud(SolicitudEmpleo solicitud) {
        if (!colaDeEspera.estaLlena()) {
            colaDeEspera.encolar(solicitud);
            System.out.println("Solicitud registrada con éxito: " + solicitud);
        } else {
            System.out.println("No se pudo registrar la solicitud, intente nuevamente.");
        }
    }


    public void procesarSiguienteSolicitud() {
        if (!colaDeEspera.estaVacia()) {
            SolicitudEmpleo proxima = colaDeEspera.desencolar();
            System.out.println("\n Procesando " + proxima + "...");
            System.out.println("   [Resultado]: Perfil evaluado con éxito.");
        } else {
            System.out.println("\n No hay solicitudes pendientes de procesamiento.");
        }
    }


    public void verProximaSolicitud() {
        SolicitudEmpleo proxima = colaDeEspera.frente();
        if (proxima != null) {
            System.out.println(" Siguiente en la fila de espera: " + proxima);
        } else {
            System.out.println("La cola está vacía.");
        }
    }
}