package Controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ControllerEmail {

    // Funções que envia um email personalizado ao utilizador

    public void enviarEmail(String username, String password) {
        String from = "engenheirosemcurso@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("engenheirosemcurso@gmail.com", "fhhjuclsiiqefslx");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(username));
            message.setSubject("Credenciais de acesso Biblioteca Santa Maria da Feira!");

            // Corpo do email em HTML com tabela
            String htmlContent = "<html><body style='font-family: Arial, sans-serif;'>" +
                    "<div style='background-color: #f2f2f2; padding: 20px;'>" +
                    "<h1 style='color: #333333;'>Credenciais de acesso à Biblioteca Santa Maria da Feira</h1>" +
                    "<h2 style='color: #666666;'>Bem-vindo(a) à Biblioteca de Santa Maria da Feira</h2>" +
                    "</div>" +
                    "<table style='border-collapse: collapse; margin-top: 20px;'>" +
                    "<tr style='background-color: #f2f2f2;'>" +
                    "<th style='border: 1px solid black; padding: 8px;'>Informação</th>" +
                    "<th style='border: 1px solid black; padding: 8px;'>Detalhes</th>" +
                    "</tr>" +
                    "<tr>" +
                    "<td style='border: 1px solid black; padding: 8px;'><strong>Email</strong></td>" +
                    "<td style='border: 1px solid black; padding: 8px;'>" + username + "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td style='border: 1px solid black; padding: 8px;'><strong>Password</strong></td>" +
                    "<td style='border: 1px solid black; padding: 8px;'>" + password + "</td>" +
                    "</tr>" +
                    "</table>" +
                    "</body></html>";

            message.setContent(htmlContent, "text/html");

            Transport.send(message);
            System.out.println("Mensagem enviada com sucesso");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }


    }
}