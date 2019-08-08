package md.snowtoslow.notificationservice.helper;

import md.snowtoslow.notificationservice.controller.EmailRequest;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Component
public class EmailHelper {

    public Message createMessage(EmailRequest emailRequest, Session session) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailRequest.getFrom()));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(emailRequest.getTo()));
        message.setSubject(emailRequest.getSubject());


        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(emailRequest.getSubject(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        return message;
    }

    public Session createSession(Properties prop) {
        //Session session = Session.getInstance(prop, new Authenticator() {
        //  @Override
        //protected PasswordAuthentication getPasswordAuthentication() {
        //  return new PasswordAuthentication(username, password);
        //}
        //});
        return Session.getInstance(prop);

    }



}
