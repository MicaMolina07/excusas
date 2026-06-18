package ar.edu.davinci.excusas.model;

public class ExcusaInverosimil extends Excusa {

    public ExcusaInverosimil(Empleado empleado) {
        super(empleado);
    }

    @Override
    public boolean esInverosimil() { return true; }
}
