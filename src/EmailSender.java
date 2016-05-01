import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailSender {
	
	public static boolean sendMail(String from, String password, String message, String to[]) {
		String host = "smtp.gmail.com";
		Properties props = System.getProperties();
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new GMailAuthenticator(from, password));
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			mimeMessage.setFrom(new InternetAddress(from));
			//get the address of recipients
			InternetAddress[] toAddress = new InternetAddress[to.length];
			for (int i=0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}
			for (int i = 0; i < toAddress.length; i++) {
				mimeMessage.addRecipient(RecipientType.TO, toAddress[i]);
			}
			//add subject
			mimeMessage.setSubject("Your New Password");
			//set message to mimeMessage
			mimeMessage.setText(message);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
			return true;
		} catch(MessagingException me) {
			me.printStackTrace();
		}
		return false;
	}
}