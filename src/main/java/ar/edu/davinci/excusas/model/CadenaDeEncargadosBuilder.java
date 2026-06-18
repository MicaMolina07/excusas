package ar.edu.davinci.excusas.model;

import java.util.ArrayList;
import java.util.List;

public class CadenaDeEncargadosBuilder {

    private final List<ManejadorExcusa> eslabones = new ArrayList<>();
    private final EnviadorEmail emailSender;
    private final String emailCTO;

    public CadenaDeEncargadosBuilder(EnviadorEmail emailSender, String emailCTO) {
        this.emailSender = emailSender;
        this.emailCTO = emailCTO;
    }

    public CadenaDeEncargadosBuilder agregarRecepcionista(String nombre, String email, int legajo) {
        eslabones.add(new Recepcionista(nombre, email, legajo, emailSender, emailCTO));
        return this;
    }

    public CadenaDeEncargadosBuilder agregarSupervisor(String nombre, String email, int legajo) {
        eslabones.add(new SupervisoraDeArea(nombre, email, legajo, emailSender, emailCTO));
        return this;
    }

    public CadenaDeEncargadosBuilder agregarGerenteRRHH(String nombre, String email, int legajo) {
        eslabones.add(new GerenteRRHH(nombre, email, legajo, emailSender, emailCTO));
        return this;
    }

    public CadenaDeEncargadosBuilder agregarCEO(String nombre, String email, int legajo) {
        eslabones.add(new CEO(nombre, email, legajo, emailSender, emailCTO));
        return this;
    }

    public ManejadorExcusa construir() {
        List<ManejadorExcusa> cadena = new ArrayList<>(eslabones);
        cadena.add(new RechazadorPorDefecto());
        for (int i = 0; i < cadena.size() - 1; i++) {
            cadena.get(i).establecerSiguiente(cadena.get(i + 1));
        }
        return cadena.get(0);
    }
}
