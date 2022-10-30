package Test;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class sendMail {
	public static void send(String to,String msg){
		//Get properties object
		String username = "sendmail.fpttext@gmail.com";
		String password = "nssvfdmyyxroispc";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		//get Session
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,password);
					}
				});
		//compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject("Share Link");
			message.setText("day la limk phim nong 18+ : " + msg);
			//send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {throw new RuntimeException(e);}

	}

}
