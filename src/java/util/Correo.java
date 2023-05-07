/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author A-170
 */
public class Correo {

    public Correo(String correoUsuaro, String servicio, String fechaAgenda) throws AddressException, MessagingException {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "biovetweb@gmail.com";
        String contrasena = "Dios2020--";
        String receptor = correoUsuaro;
        String asunto = servicio;
        String mensaje = "Su cita para el servicio de " + servicio + " quedo asignada para la siguiente fecha: " + fechaAgenda;

        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);

            try (Transport transportar = sesion.getTransport("smtp")) {
                transportar.connect(correoEnvia, contrasena);
                transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
                transportar.close();
            }

        } catch (AddressException ex) {
            System.out.println(ex.getMessage());
        } catch (MessagingException ex) {
            System.out.println(ex.getMessage());
        }

    }
//    public static void main(String[] args) throws MessagingException {
//    Correo c = new Correo("easgaitan@gmail.com", "guarderia", "Algundia");
//    }

}
