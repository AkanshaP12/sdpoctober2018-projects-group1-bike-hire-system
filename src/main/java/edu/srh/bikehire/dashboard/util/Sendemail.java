package edu.srh.bikehire.dashboard.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sendemail {
	
	public void sendEmail(List<String> pListOfTo,String pEmailSubject, String pEmailBodyText){ 
		
		final String username = "bikehiresystem@gmail.com";
		final String password = "bikehire123";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
	      // Recipient's email ID 
	      String to = "akanshanhce@gmail.com";

	      // Sender's email ID 
	      String from = "bikehiresystem@gmail.com";

	      // Get the default Session object.
	      Session session = Session.getInstance(props,
	    		  new javax.mail.Authenticator() {
	    			protected PasswordAuthentication getPasswordAuthentication() {
	    				return new PasswordAuthentication(username, password);
	    			}
	    		  });
	      

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         List<Address> llistOfTo = new ArrayList<Address>();
	         
	         for(String lToEmailAddress: pListOfTo)
	         {
	        	 llistOfTo.add(new InternetAddress(lToEmailAddress));
	         }
	         
	         Address[] lAddress = null; 
	         llistOfTo.toArray(lAddress);
	         // Set To: header field of the header.
	         message.addRecipients(Message.RecipientType.TO, lAddress);

	         // Set Subject: header field
	         message.setSubject(pEmailSubject);

	         // Now set the actual message
	         message.setText(pEmailBodyText);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	}