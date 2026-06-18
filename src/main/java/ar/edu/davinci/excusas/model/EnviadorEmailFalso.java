package ar.edu.davinci.excusas.model;

public class EnviadorEmailFalso implements EnviadorEmail {

    @Override
    public void enviarEmail(String destino, String origen, String asunto, String cuerpo) {
        System.out.printf("[EMAIL] Para: %s | De: %s | Asunto: %s | Cuerpo: %s%n",
                destino, origen, asunto, cuerpo);
    }
}
