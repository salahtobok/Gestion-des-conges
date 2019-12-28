package Http.Controller.SMTP; /**
 * Created by salahtobok on 16-05-2017.
 */


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMailSSL {
    public static boolean SendMailSSL_Simple(String user_name,String pass_word,String mail_smtp_host,String mail_smtp_socketFactory_port
    ,String mail_smtp_socketFactory_class,String mail_smtp_auth,String mail_smtp_port,String sender_amail,String receiver_amail
    ,String subject,String content) {

        final String username = user_name;
        final String password = pass_word;
        Properties props = new Properties();

        //01
        props.put("mail.smtp.host", mail_smtp_host);
        //02
        props.put("mail.smtp.socketFactory.port", mail_smtp_socketFactory_port);
        //03
        props.put("mail.smtp.socketFactory.class",mail_smtp_socketFactory_class);
        //04
        props.put("mail.smtp.auth", mail_smtp_auth);
        //05
        props.put("mail.smtp.port", mail_smtp_port);

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender_amail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver_amail));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            return true;
           // System.out.println("Done");

        } catch (MessagingException e) {

            return false;

        }


    }


    public static boolean SendMailSSL_Html(String user_name,String pass_word,String mail_smtp_host,String mail_smtp_socketFactory_port
            ,String mail_smtp_socketFactory_class,String mail_smtp_auth,String mail_smtp_port,String sender_amail,String receiver_amail
            ,String subject,String content) {

        //final String username = "s.tobok@esi-sba.dz";
        //final String password = "tobok75601995123654";
        final String username = user_name;
        final String password = pass_word;
        Properties props = new Properties();
        //props.put("mail.smtp.host", "smtp.gmail.com");
        //props.put("mail.smtp.socketFactory.port", "465");
        //props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        //props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.port", "465");

        props.put("mail.smtp.host", mail_smtp_host);
        props.put("mail.smtp.socketFactory.port", mail_smtp_socketFactory_port);
        props.put("mail.smtp.socketFactory.class",mail_smtp_socketFactory_class);
        props.put("mail.smtp.auth", mail_smtp_auth);
        props.put("mail.smtp.port", mail_smtp_port);

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender_amail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver_amail));
            message.setSubject(subject);
            System.out.println(content);
            message.setContent( content, "text/html");
            Transport.send(message);

return true;
        } catch (MessagingException e) {

return false;
        }
    }
}