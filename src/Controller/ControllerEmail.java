package Controller;

import Model.SocioUtilizador;
import Model.Utilizador;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import Model.Utilizador;
public class ControllerEmail {

    public void enviarEmail(String destinatario, String assunto, String conteudo) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("engenheirosemcurso@gmail.com", "engenheirosemcurso*lp2");
            }
        });

        try {
            // Enviar o e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("engenheirosemcurso@gmail.com")); // substitua pelo seu e-mail
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(conteudo);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}