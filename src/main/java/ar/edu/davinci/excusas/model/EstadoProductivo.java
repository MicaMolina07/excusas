package ar.edu.davinci.excusas.model;

public class EstadoProductivo implements EstadoDesempenio {

    private final EnviadorEmail emailSender;
    private final String emailCTO;

    public EstadoProductivo(EnviadorEmail emailSender, String emailCTO) {
        this.emailSender = emailSender;
        this.emailCTO = emailCTO;
    }

    @Override
    public void procesarExcusa(Excusa excusa, ResponsableSector responsable) {
        if (responsable.puedeManejar(excusa)) {
            responsable.procesarExcusa(excusa);
            responsable.incrementarExcusasProcesadas();
            responsable.transicionarSegunContador();
        } else {
            notificarCTO(excusa);
            responsable.derivarAlSiguiente(excusa);
        }
    }

    @Override
    public void tomarCafe(ResponsableSector responsable) {
        responsable.setEstado(new EstadoProductivo(emailSender, emailCTO));
    }

    @Override
    public void tomarBreak(int minutos, ResponsableSector responsable) {
        if (minutos >= 10 && minutos <= 15) {
            responsable.setEstado(new EstadoNormal());
        }
    }

    @Override
    public void volverAlTrabajo(ResponsableSector responsable) {}

    private void notificarCTO(Excusa excusa) {
        emailSender.enviarEmail(
                emailCTO,
                "sistema@excusassa.com",
                "Excusa derivada",
                "Excusa del empleado " + excusa.obtenerEmpleado().obtenerNombre() + " derivada al siguiente nivel."
        );
    }
}
