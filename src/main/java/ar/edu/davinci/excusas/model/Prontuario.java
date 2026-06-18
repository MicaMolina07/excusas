package ar.edu.davinci.excusas.model;

import java.time.LocalDate;

public class Prontuario {

    private Excusa excusa;
    private LocalDate fecha;

    public Prontuario(Excusa excusa, LocalDate fecha) {
        this.excusa = excusa;
        this.fecha = fecha;
    }

    public Excusa obtenerExcusa() { return excusa; }
    public LocalDate obtenerFecha() { return fecha; }
}
