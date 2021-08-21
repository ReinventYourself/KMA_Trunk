package com.rsi.kma.automation.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FromStringTerm;
import javax.mail.search.SubjectTerm;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;

public class EMail {

	private static Logger Log = Logger.getLogger(EMail.class.getName());
	private static Store store;
	private static Folder inbox;
	private static Message[] messages = null;
	private static Message mailFromKIA = null;
	private static boolean isMailFound = false;
	public static String passwordResetLink;	

	public static boolean execute(String subject, String kiaUsername,
			String emailPassword, boolean newMail) {

		Properties props = System.getProperties();
		Log.info("Properties object created");

		Session session = Session.getDefaultInstance(props, null);
		Log.info("Session object created");

		/**
		 * For Gmail account
		 */
		if (kiaUsername.contains("gmail")) {
			try {
				props.setProperty("mail.store.protocol", "imaps");

				store = session.getStore(props
						.getProperty("mail.store.protocol"));
				Log.info("Message store is created");

				store.connect("imap.gmail.com", kiaUsername, emailPassword);
				Log.info("Connected with message store");

			} catch (NoSuchProviderException e) {
				Log.error("Message store not created");
				Log.debug(e.getLocalizedMessage());
				Reporter.log("Message store not created");
				Assert.fail("Error in opening inbox " + kiaUsername);
			} catch (MessagingException e) {
				Log.error("Unable to connect with message store");				
				Log.debug(e.getLocalizedMessage());
				Reporter.log("Unable to connect with message store");
				Assert.fail("Error in opening inbox " + kiaUsername);
			}
		}

		/**
		 * For Yahoo account 
		 */
		else if (kiaUsername.contains("yahoo")) {			
			try {
			    props.setProperty("mail.store.protocol", "imaps");
			    
                store = session.getStore(props.getProperty("mail.store.protocol"));
                Log.info("Message store is created");
                
                store.connect("imap.mail.yahoo.com", kiaUsername, emailPassword);
                Log.info("Connected with message store");
            } catch (NoSuchProviderException e) {
                Log.error("Message store not created");
                Log.debug(e.getLocalizedMessage());
                Reporter.log("Message store not created");
                Assert.fail("Error in opening inbox " + kiaUsername);
            } catch (MessagingException e) {
                Log.error("Unable to connect with message store");                
                Log.debug(e.getLocalizedMessage());
                Reporter.log("Unable to connect with message store");
                Assert.fail("Error in opening inbox " + kiaUsername);
            }			
		}
		else {
		    Log.error("Only, gmail or yahoo mail can be accessed.");
		    Reporter.log("Only, gmail or yahoo mail can be accessed.");
		    throw new SkipException("Only, gmail or yahoo mail can be accessed.");
		}

		try {
            inbox = store.getFolder("INBOX");            
            Log.info("Getting inbox folder");
            
            inbox.open(Folder.READ_WRITE);              
            Log.info("Opening inbox");
            
            Log.info("Total Message:" + inbox.getMessageCount());       
            Log.info("Unread Message:" + inbox.getUnreadMessageCount());
            
         // Search for mail from UVO
            messages = inbox.search(new SubjectTerm(subject), inbox.getMessages());
            if (messages.length != 0) {
                Log.info("Message(s) with Subject: '" + subject + "' found");
                messages = inbox.search(new FromStringTerm("reset@notifications.myuvo.com"), messages);
                if (messages.length != 0){
                    Log.info("Message(s) from MyUVO with '" + subject +  "' subject found");
                }
                else
                    Log.info("Message(s) from MyUVO with '" + subject +  "' not subject found");
            }
            else
                Log.info("Message(s) with Subject: '" + subject + "' not found");
            
            
            /*
             * Search for unread mail from UVO This is to avoid using the mails
             * which have been read and registration has been done
             */
            for (Message mail : messages) {
                if (newMail && (! mail.isSet(Flags.Flag.SEEN))) {               
                    mailFromKIA = mail;             
                    Log.info("Message read count is: "
                            + mailFromKIA.getMessageNumber());
                    isMailFound = true;
                }
                
                else if ((! newMail) &&  mail.isSet(Flags.Flag.SEEN)){              
                    mailFromKIA = mail;             
                    Log.info("Message un-read count is: "
                            + mailFromKIA.getMessageNumber());
                    isMailFound = true;
                }
            }
        } catch (MessagingException e1) {
            Log.error("Unable to connect with message store");                
            Log.debug(e1.getLocalizedMessage());
            Reporter.log("Unable to connect with message store");
            Assert.fail("Error in opening inbox " + kiaUsername);
        }																			

		if (isMailFound) {
			String line;
			StringBuffer buffer = new StringBuffer();
			BufferedReader reader;

			try {
				reader = new BufferedReader(new InputStreamReader(
						mailFromKIA.getInputStream()));

				while ((line = reader.readLine()) != null) {
					buffer.append(line);
					
					CharSequence text = line;
					String pattern = "href=[\"](.*)[\"]( style=)(.*)(RESET YOUR PASSWORD)</font>";
					Pattern r = Pattern.compile(pattern);
					Matcher m = r.matcher(text);
					if (m.find()) {
						passwordResetLink = m.group(1);
						Log.info("Password RESET URL -- " + m.group(1));
					} // Code ends
				}
				Log.info("Mail is read");
			} catch (IOException | MessagingException e) {
				Log.error("Error in reading mail from MyUVO");
				Log.debug(e.getLocalizedMessage());
				Reporter.log("Error in reading mail from MyUVO");
				Assert.fail("Error in reading mail from MyUVO");
			}			
		}
		
		Log.info("E-mail found: " + isMailFound);
		return isMailFound;
	}
}
