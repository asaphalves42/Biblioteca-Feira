package Controller;

import Model.Email;
import Model.Utilizador; // Importe a classe Utilizador

import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class ControllerEmail {
    private Email modelo;

    public ControllerEmail(Email modelo) {
        this.modelo = modelo;
    }

    public void gerarCodigo(Utilizador utilizador) {
        // Gera um código aleatório
        Random rand = new Random();
        int codigoInt = rand.nextInt(10000);
        String codigo = String.format("%04d", codigoInt);
        modelo.setCodigo(codigo);


        enviarEmail(utilizador.getEmail(), codigo);

    }

    public boolean verificarCodigo(String codigoInserido) {
        // Verifica se o código inserido é igual ao código gerado
        return codigoInserido.equals(modelo.getCodigo());
    }



    private void enviarEmail(String destinatario, String codigo) {
        // Configurações para envio de e-mail usando o JavaMail
        String remetente = "engenheirossemcurso@gmail.com";
        String senha = "ESCS3MCURS0";

        String assunto = "Código de verificação";
        String mensagem = "Seu código de verificação é: " + codigo;

        // Configura as propriedades do servidor de e-mail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Cria uma sessão de e-mail autenticada
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });

        try {
            // Cria a mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(mensagem);

            // Envia o e-mail
            Transport.send(message);

            System.out.println("E-mail enviado para: " + destinatario);
        } catch (MessagingException e) {
            System.out.println("Erro ao enviar o e-mail: " + e.getMessage());
        }
    }
}
