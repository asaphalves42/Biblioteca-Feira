package Controller;

import Model.SocioUtilizador;
import Model.Utilizador;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class ControllerEmail {
    public void enviarEmail(String username, String password) {
        String to = username;
        String from = "engenheirosemcurso@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("engenheirosemcurso@gmail.com", "lswpbtasoilawqkn");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Isto é o assunto");

            // Corpo do email em HTML com tabela
            String htmlContent = "<html><body>" +
                    "<table style='border-collapse: collapse;'>" +
                    "<tr>" +
                    "<th style='border: 1px solid black; padding: 8px;'>********</th>" +
                    "<th style='border: 1px solid black; padding: 8px;'>********</th>" +
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