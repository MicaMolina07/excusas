package ar.edu.davinci.excusas.model;

public class RechazadorPorDefecto implements ManejadorExcusa {

    public static final String MENSAJE_RECHAZO = "Excusa rechazada: necesitamos pruebas contundentes";

    @Override
    public void manejar(Excusa excusa) {
        excusa.rechazar(MENSAJE_RECHAZO);
    }

    @Override
    public void establecerSiguiente(ManejadorExcusa siguiente) {}
}
