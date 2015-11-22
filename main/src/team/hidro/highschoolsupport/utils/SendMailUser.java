
package team.hidro.highschoolsupport.utils;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUser {
	public final static String username = "hvthong57";
	public final static String password = "hong23091993";

	public static void main(String[] args) {

		String mailTo ="hongvt2309@gmail.com";
		String mailFrom = "hvthong57@gmail.com";
		String content = "Thông báo";
		String sms ="Test mail from JavaMail API ";
		SendMail(mailTo, mailFrom, content, sms);
	}

	public static void SendMail(String mailTo, String mailFrom, String content,
			String sms) {
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);

					}
				});
		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(mailFrom));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailTo));

			// Set Subject: header field
			message.setSubject(content);

			// Now set the actual message
			message.setText(sms);

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
