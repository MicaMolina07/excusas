package ar.edu.davinci.excusas.model;

public interface EstadoDesempenio {
    void procesarExcusa(Excusa excusa, ResponsableSector responsable);
    void tomarCafe(ResponsableSector responsable);
    void tomarBreak(int minutos, ResponsableSector responsable);
    void volverAlTrabajo(ResponsableSector responsable);
}
