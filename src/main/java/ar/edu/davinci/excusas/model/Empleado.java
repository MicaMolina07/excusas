package ar.edu.davinci.excusas.model;

public class Empleado {

    private String nombre;
    private String email;
    private int legajo;

    public Empleado(String nombre, String email, int legajo) {
        this.nombre = nombre;
        this.email = email;
        this.legajo = legajo;
    }

    public String obtenerNombre() { return nombre; }
    public String obtenerEmail() { return email; }
    public int obtenerLegajo() { return legajo; }
}
