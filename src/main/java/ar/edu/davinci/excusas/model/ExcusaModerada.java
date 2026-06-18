package ar.edu.davinci.excusas.model;

public abstract class ExcusaModerada extends Excusa {

    public ExcusaModerada(Empleado empleado) {
        super(empleado);
    }

    @Override
    public boolean esModerada() { return true; }
}
