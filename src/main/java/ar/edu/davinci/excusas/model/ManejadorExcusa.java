package ar.edu.davinci.excusas.model;

public interface ManejadorExcusa {
    void manejar(Excusa excusa);
    void establecerSiguiente(ManejadorExcusa siguiente);
}
