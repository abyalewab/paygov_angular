package com.mycompany.myapp.asynctest;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMail {

    private final Logger logger = LoggerFactory.getLogger(SendMail.class);

    public void sendMail(String recipientGmail, String paymentStatus, String name) {
        String to = recipientGmail;
        String from = "abyalewab@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(
            properties,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("abyalewab@gmail.com", "AB0932198133");
                }
            }
        );

        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("PayGov payment status notification");
            message.setText("Hi Mr/Mrs " + "'" + name + "'" + " your previous payment appeal is " + "'" + paymentStatus + "'");
            logger.info("Sending email started");

            Transport.send(message);
            logger.info("Sent message successfully !");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
