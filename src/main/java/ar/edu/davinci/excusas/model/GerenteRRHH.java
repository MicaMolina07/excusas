package ar.edu.davinci.excusas.model;

public class GerenteRRHH extends ResponsableSector {

    public GerenteRRHH(String nombre, String email, int legajo,
                       EnviadorEmail emailSender, String emailCTO) {
        super(nombre, email, legajo, emailSender, emailCTO);
    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return excusa.esCompleja();
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        excusa.aceptar();
    }
}
