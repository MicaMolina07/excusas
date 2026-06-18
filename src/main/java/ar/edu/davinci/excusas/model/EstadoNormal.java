package ar.edu.davinci.excusas.model;

public class EstadoNormal implements EstadoDesempenio {

    @Override
    public void procesarExcusa(Excusa excusa, ResponsableSector responsable) {
        if (responsable.puedeManejar(excusa)) {
            responsable.procesarExcusa(excusa);
            responsable.incrementarExcusasProcesadas();
            responsable.transicionarSegunContador();
        } else {
            responsable.derivarAlSiguiente(excusa);
        }
    }

    @Override
    public void tomarCafe(ResponsableSector responsable) {
        responsable.setEstado(new EstadoProductivo(responsable.obtenerEnviadorEmail(), responsable.obtenerEmailCTO()));
    }

    @Override
    public void tomarBreak(int minutos, ResponsableSector responsable) {
        if (minutos >= 10 && minutos <= 15) {
            responsable.setEstado(new EstadoNormal());
        }
    }

    @Override
    public void volverAlTrabajo(ResponsableSector responsable) {}
}
