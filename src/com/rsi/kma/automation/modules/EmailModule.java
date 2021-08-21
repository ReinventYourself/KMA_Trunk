package com.rsi.kma.automation.modules;

	import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.rsi.kma.automation.utility.Constants;
import com.rsi.kma.automation.utility.Log;
import com.rsi.kma.automation.utility.Utils;

	public class EmailModule {

	  public static void execute(String reportFileName) throws Exception {

	  String username = Constants.reportsUsername;
	  String password = Constants.reportsPassword;
	  String filename = Constants.reportDirectory;
	  filename=filename.concat(reportFileName);


	   Properties props = new Properties();
	  props.put("mail.smtp.starttls.enable", "true");
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.smtp.host", "smtp.gmail.com");
	  props.put("mail.smtp.port", "587");

	   Session session = Session.getInstance(props,
	    new javax.mail.Authenticator() {
	     protected PasswordAuthentication getPasswordAuthentication() {
	      return new PasswordAuthentication(username, password);
	     }
	    });

	   try {

	    Message message = new MimeMessage(session);
	   message.setFrom(new InternetAddress(username));
	   String userNameList = (Utils.getParameterValueFromCsvFile("reportsEmailList")).replaceAll("\\s", ",");
	   //Log.info(userNameList);
	   //Log.info(Utils.getParameterValueFromCsvFile("reportsEmailList"));
	   message.setRecipients(Message.RecipientType.TO,
	     InternetAddress.parse(userNameList));
	   message.setSubject("Reports available!");
	   message.setText("Dear Mail,"
	     + "\n\n No spam to my email, please!");

	   
	   
	   //Testing preview
	   StringBuilder htmlStreamBuilder = new StringBuilder();// read html file into a string so that we can preview html in mail.......
       htmlStreamBuilder.append("<h2 style="+"font-family:Verdana;>"+"Test Suite run of MyUVO has been completed sucessfully.</h2>");
       htmlStreamBuilder.append("<br>");
       htmlStreamBuilder.append("<h3 style="+"font-family:Verdana;>"+"Please find attachment for report sent from location:<div style="+"color:#696969;>"+filename+"</div></h3>");
	   
	   
       
       htmlStreamBuilder.append("<br>");
       htmlStreamBuilder.append("<h2 style="+"font-family:Verdana;>"+"Preview of attached report:</h2>");
       htmlStreamBuilder.append("<br>");
       try {
           BufferedReader in = new BufferedReader(new FileReader(filename));
           String str;
           while ((str = in.readLine()) != null) {
               htmlStreamBuilder.append(str);
           }
           in.close();
       } catch (IOException e) {
       }
	   
       
     

       //MimeBodyPart textPart = new MimeBodyPart();
      
        
	   
	    MimeBodyPart messageBodyPart = new MimeBodyPart();
	    Multipart multipart = new MimeMultipart();
	    MimeBodyPart htmlPart = new MimeBodyPart();
	    String htmlStream = htmlStreamBuilder.toString();

	    
	   String file = Constants.reportDirectory;
	   String fileName = reportFileName;
	   DataSource source = new FileDataSource(file + fileName);
	   messageBodyPart.setDataHandler(new DataHandler(source));
	   messageBodyPart.setFileName(fileName);
	   multipart.addBodyPart(messageBodyPart);
	   message.setContent(message, "text/html");
	   htmlPart.setContent(htmlStream, "text/html; charset=utf-8");

       //multipart.addBodyPart(textPart);
       multipart.addBodyPart(htmlPart);
	    message.setContent(multipart);
	   System.out.println("Sending");
	   Transport.send(message);
	   System.out.println("Done");
	  } catch (MessagingException e) {
	   throw new RuntimeException(e);
	  }
	 }
	  
		}


