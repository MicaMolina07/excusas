package ar.edu.davinci.excusas.model;

import java.util.Random;

public class EstadoVago implements EstadoDesempenio {

    private final Random random;

    public EstadoVago() { this.random = new Random(); }
    public EstadoVago(Random random) { this.random = random; }

    @Override
    public void procesarExcusa(Excusa excusa, ResponsableSector responsable) {
        responsable.derivarAlSiguiente(excusa);
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
    public void volverAlTrabajo(ResponsableSector responsable) {
        if (random.nextBoolean()) {
            responsable.setEstado(new EstadoProductivo(responsable.obtenerEnviadorEmail(), responsable.obtenerEmailCTO()));
        } else {
            responsable.setEstado(new EstadoNormal());
        }
    }
}
