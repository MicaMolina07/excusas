package ar.edu.davinci.excusas.model;

public class ExcusaCompleja extends Excusa {

    public ExcusaCompleja(Empleado empleado) {
        super(empleado);
    }

    @Override
    public boolean esCompleja() { return true; }
}
