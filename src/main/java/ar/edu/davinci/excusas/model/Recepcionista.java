package ar.edu.davinci.excusas.model;

public class Recepcionista extends ResponsableSector {

    public Recepcionista(String nombre, String email, int legajo,
                         EnviadorEmail emailSender, String emailCTO) {
        super(nombre, email, legajo, emailSender, emailCTO);
    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return excusa.esTrivial();
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        excusa.aceptar();
        obtenerEnviadorEmail().enviarEmail(
                excusa.obtenerEmpleado().obtenerEmail(),
                obtenerEmail(),
                "Excusa aceptada",
                "Tu excusa fue aceptada por " + obtenerNombre()
        );
    }
}
