package ar.edu.davinci.excusas.model;

import java.util.ArrayList;
import java.util.List;

public class CEO extends ResponsableSector implements ObservadorProntuario {

    private final List<Prontuario> prontuariosRecibidos = new ArrayList<>();

    public CEO(String nombre, String email, int legajo,
               EnviadorEmail emailSender, String emailCTO) {
        super(nombre, email, legajo, emailSender, emailCTO);
    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return excusa.esInverosimil();
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        excusa.aceptar();
    }

    @Override
    public void notificarNuevoProntuario(Prontuario prontuario) {
        prontuariosRecibidos.add(prontuario);
    }

    public List<Prontuario> obtenerProntuariosRecibidos() {
        return prontuariosRecibidos;
    }
}
