package com.project.scientificrepository.camunda.delegate;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.project.scientificrepository.model.Thesis;

@Service
public class EmailService {
	
	private static String sentBy = "probator2000@gmail.com";
	private static String pass = "mojlazniaccount69";
	//private static String subject = "Agent registration";

	public void sendThesisSubmitetMail(String sendToAuthor, String sendToEditor, Thesis thesis) {
		System.out.println("EMAILOVI " + sendToAuthor + " " + sendToEditor);
		
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", sentBy);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.ssl.trust", "smtp.gmail.com");


		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(sentBy));

			InternetAddress toAddressAuthor = new InternetAddress(sendToAuthor);
			InternetAddress toAddressEditor = new InternetAddress(sendToEditor);
			
			message.addRecipient(Message.RecipientType.TO, toAddressAuthor);
			message.addRecipient(Message.RecipientType.TO, toAddressEditor);

			message.setSubject("Prilozen nov naucni rad");
			message.setText("Thesis: " + thesis.getTitle() + " has been submitted for review.");
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, sentBy, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}

}
