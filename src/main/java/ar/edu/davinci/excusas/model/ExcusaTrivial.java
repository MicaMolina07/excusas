package ar.edu.davinci.excusas.model;

public class ExcusaTrivial extends Excusa {

    public ExcusaTrivial(Empleado empleado) {
        super(empleado);
    }

    @Override
    public boolean esTrivial() { return true; }
}
