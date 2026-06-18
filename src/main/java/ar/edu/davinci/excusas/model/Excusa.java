package ar.edu.davinci.excusas.model;

public abstract class Excusa {

    private Empleado empleado;
    private boolean aceptada;
    private String mensajeRechazo;

    public Excusa(Empleado empleado) {
        this.empleado = empleado;
        this.aceptada = false;
    }

    public void aceptar() {
        this.aceptada = true;
    }

    public void rechazar(String mensaje) {
        this.aceptada = false;
        this.mensajeRechazo = mensaje;
    }

    public boolean esTrivial() { return false; }
    public boolean esModerada() { return false; }
    public boolean esCompleja() { return false; }
    public boolean esInverosimil() { return false; }

    public Empleado obtenerEmpleado() { return empleado; }
    public boolean fueAceptada() { return aceptada; }
    public String obtenerMensajeRechazo() { return mensajeRechazo; }
}
