package ar.edu.davinci.excusas.model;

public interface EnviadorEmail {
    void enviarEmail(String destino, String origen, String asunto, String cuerpo);
}
