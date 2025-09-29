import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailNotifier {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Erro: Forneça Assunto e Corpo do e-mail como argumentos.");
            System.exit(1);
        }
        String subject = args[0];
        String body = args[1];

        final String username = System.getenv("MAIL_USERNAME");
        final String password = System.getenv("MAIL_PASSWORD");
        final String recipient = System.getenv("MAIL_TO");

        if (username == null || password == null || recipient == null) {
            System.err.println("Erro: Variáveis de ambiente MAIL_USERNAME, MAIL_PASSWORD e MAIL_TO devem ser definidas.");
            System.exit(1);
        }

        // Propriedades para o servidor SMTP do Gmail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Porta TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Habilita STARTTLS

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() { // Correção aqui
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message); // Correção aqui
            System.out.println("E-mail de notificação enviado com sucesso!");
        } catch (MessagingException e) { // Correção aqui
            System.err.println("Erro ao enviar o e-mail: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}