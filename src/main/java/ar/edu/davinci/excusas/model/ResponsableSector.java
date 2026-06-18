package ar.edu.davinci.excusas.model;

public abstract class ResponsableSector extends Empleado implements ManejadorExcusa {

    private ManejadorExcusa siguiente;
    private int excusasProcesadas;
    private EstadoDesempenio estadoActual;
    private final EnviadorEmail emailSender;
    private final String emailCTO;

    public ResponsableSector(String nombre, String email, int legajo,
                              EnviadorEmail emailSender, String emailCTO) {
        super(nombre, email, legajo);
        this.emailSender = emailSender;
        this.emailCTO = emailCTO;
        this.excusasProcesadas = 0;
        this.estadoActual = new EstadoProductivo(emailSender, emailCTO);
    }

    @Override
    public void manejar(Excusa excusa) {
        estadoActual.procesarExcusa(excusa, this);
    }

    @Override
    public void establecerSiguiente(ManejadorExcusa siguiente) {
        this.siguiente = siguiente;
    }

    public void derivarAlSiguiente(Excusa excusa) {
        if (siguiente != null) siguiente.manejar(excusa);
    }

    public void incrementarExcusasProcesadas() { excusasProcesadas++; }

    public void transicionarSegunContador() {
        if (excusasProcesadas < 5) {
            setEstado(new EstadoProductivo(emailSender, emailCTO));
        } else if (excusasProcesadas <= 10) {
            setEstado(new EstadoNormal());
        } else {
            setEstado(new EstadoVago());
        }
    }

    public void setEstado(EstadoDesempenio estado) { this.estadoActual = estado; }
    public EnviadorEmail obtenerEnviadorEmail() { return emailSender; }
    public String obtenerEmailCTO() { return emailCTO; }

    public abstract boolean puedeManejar(Excusa excusa);
    public abstract void procesarExcusa(Excusa excusa);
}
