package ar.edu.davinci.excusas.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    private final List<ObservadorProntuario> observadores = new ArrayList<>();

    public void suscribir(ObservadorProntuario observador) {
        observadores.add(observador);
    }

    public void desuscribir(ObservadorProntuario observador) {
        observadores.remove(observador);
    }

    protected void notificarObservadores(Prontuario prontuario) {
        for (ObservadorProntuario observador : new ArrayList<>(observadores)) {
            observador.notificarNuevoProntuario(prontuario);
        }
    }
}
