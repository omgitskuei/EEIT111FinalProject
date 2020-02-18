package util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUsers {
	// Local fields
	private String fromEmail = "farmvilletaiwan@gmail.com";
	private String fromEmailPwd = "Qq12345!";
	private String fromEmailHostName = "smtp.googlemail.com";
	private int fromEmailPort = 465;

	// Constructors
	public EmailUsers() {
		System.out.println("BEGIN: util.EmailUsers()");
	}

	// Executable
	public static void main(String[] args) {
		EmailUsers thisClass = new EmailUsers();
//		thisClass.sendWelcomeEmail(thisClass.toEmail, "Bob");
//		thisClass.sendChangePwdEmail("farmvilletaiwan@gmail.com", "Joe");
//		thisClass.sendReceiptEmail("farmvilletaiwan@gmail.com", "Bob", 122031, "2020/2/18", "1200.00", "F3, #12, 292 Minsheng Rd, Taipei, Taiwan");
	}

	// Methods
	public void sendForgotPwdEmail(String userEmail, String userName, String code) {
		// String userName can be a user's Display name, Email, or Full name
		System.out.println("BEGIN: util.EmailUsers.sendForgotPwdEmail(String, String, String)");
		// Local Variables
		String toEmail = userEmail;
		try {
			// Instantiate SimpleEmail object
			Email email = new SimpleEmail();
			// Email sending settings
			email.setHostName(this.fromEmailHostName);
			email.setSmtpPort(this.fromEmailPort);
			// Email sender's credentials
			email.setAuthenticator(new DefaultAuthenticator(this.fromEmail, this.fromEmailPwd));
			email.setSSLOnConnect(true);
			// Email TO / FROM
			email.setFrom(this.fromEmail);
			email.addTo(toEmail);
			// Email body
			email.setSubject("FarmVille Account Support: Resetting your password");
			email.setMsg("Hi " + userName + "," + " \r\n"
					+ " \r\n" 
					+ "Your code for resetting your password: " + code + "\r\n" 
					+ " \r\n" 
					+ "If you did not forget your password and request a reset, \r\n contact support at farmvilletaiwan@gmail.com immediately." + "\r\n"
					+ " \r\n"
					+ "Thanks," + "\r\n" 
					+ "The FarmVille Support Team");
			// Send
			email.send();
			System.out.println("Email to [" + toEmail + "] from [" + this.fromEmail + "] sent!");
		} catch (EmailException e) {
			e.printStackTrace();
			System.out.println("ERROR: TestUtil Email Exception");
		}
		System.out.println("FINISH: util.EmailUsers.sendForgotPwdEmail(String, String)");
	}

	public void sendVerifyEmail(String userEmail, String userName, String code) {
		// String userName can be a user's Display name, Email, or Full name
		System.out.println("BEGIN: util.EmailUsers.sendVerifyEmail(String, String, String)");
		// Local Variables
		String toEmail = userEmail;
		try {
			// Instantiate SimpleEmail object
			Email email = new SimpleEmail();
			// Email sending settings
			email.setHostName(this.fromEmailHostName);
			email.setSmtpPort(this.fromEmailPort);
			// Email sender's credentials
			email.setAuthenticator(new DefaultAuthenticator(this.fromEmail, this.fromEmailPwd));
			email.setSSLOnConnect(true);
			// Email TO / FROM
			email.setFrom(this.fromEmail);
			email.addTo(toEmail);
			// Email body
			email.setSubject("FarmVille Account Support: Email Verification");
			email.setMsg("Hi " + userName + "," + " \r\n"
					+ " \r\n"
					+ "Thank you for signing up for a Farmville account. \r\n" 
					+ "To complete and confirm your registration, you’ll need to verify your email address. \r\n"
					+ "To do so, please enter the security code below on the confirmation page:"+ "\r\n" 
					+ "\r\n" 
					+ code + "\r\n" 
					+ " \r\n" 
					+ "Thanks," + "\r\n" 
					+ "The FarmVille Support Team");
			// Send
			email.send();
			System.out.println("Email to [" + toEmail + "] from [" + this.fromEmail + "] sent!");
		} catch (EmailException e) {
			e.printStackTrace();
			System.out.println("ERROR: TestUtil Email Exception");
		}
		System.out.println("FINISH: util.EmailUsers.sendVerifyEmail(String, String)");
	}

	public void sendChangePwdEmail(String userEmail, String userName) {
		// String userName can be a user's Display name, Email, or Full name
		System.out.println("BEGIN: util.EmailUsers.sendChangePwdEmail(String, String)");
		// Local Variables
		String toEmail = userEmail;
		try {
			// Instantiate SimpleEmail object
			Email email = new SimpleEmail();
			// Email sending settings
			email.setHostName(this.fromEmailHostName);
			email.setSmtpPort(this.fromEmailPort);
			// Email sender's credentials
			email.setAuthenticator(new DefaultAuthenticator(this.fromEmail, this.fromEmailPwd));
			email.setSSLOnConnect(true);
			// Email TO / FROM
			email.setFrom(this.fromEmail);
			email.addTo(toEmail);
			// Email body
			email.setSubject("FarmVille Account Support: Your password changed");
			email.setMsg("Hi " + userName + "," + " \r\n" + " \r\n" + "Your password has been successfully changed. "
					+ "\r\n" + " \r\n"
					+ "If you didn’t change your password, contact our support email right away at farmvilletaiwan@gmail.com"
					+ "\r\n" + " \r\n" + "Just a reminder:" + "\r\n"
					+ "- Never share your password or security questions with anyone." + "\r\n"
					+ "- Create passwords that are hard to guess and don’t use personal information. Be sure to include uppercase and lowercase letters, numbers, and symbols."
					+ "\r\n" + "- Use different passwords for each of your online accounts." + "\r\n" + " \r\n"
					+ "Thanks," + "\r\n" + "The FarmVille Support Team");
			// Send
			email.send();
			System.out.println("Email to [" + toEmail + "] from [" + this.fromEmail + "] sent!");
		} catch (EmailException e) {
			e.printStackTrace();
			System.out.println("ERROR: TestUtil Email Exception");
		}
		System.out.println("FINISH: util.EmailUsers.sendChangePwdEmail(String, String)");
	}

	public void sendReceiptEmail(String userEmail, String userName, int orderID, String orderTimestamp,
			String orderTotal, String profileAddress) {
		// String userName can be a user's Display name, Email, or Full name
		System.out.println("BEGIN: util.EmailUsers.sendReceiptEmail(String, String, int, String, String, String");
		// Local Variables
		String fromEmail = "farmvilletaiwan@gmail.com";
		String toEmail = userEmail;

		String bodyPart1 = "Hi " + userName + ",\r\n" + "\r\n"
				+ "Thank you for your recent transaction on Farmville, Taiwan.\r\n"
				+ "This email message will serve as your receipt.\r\n"
				+ "You can also view your Purchase History at any time.\r\n" + "\r\n";
		String bodyPart2 = "Receipt from Farmville, Taiwan\r\n" + "Receipt #:\r\n" + orderID + "\r\n" + "\r\n"
				+ "Account name:\r\n" + userEmail + "\r\n" + "\r\n" + "Date issued:\r\n" + orderTimestamp + "\r\n"
				+ "\r\n" + "Total:\r\n" + "NT$ " + orderTotal + "\r\n" + "\r\n" + "Billing address:\r\n"
				+ profileAddress + "\r\n" + "\r\n";
		String bodyPart3 = "If you have any questions, contact us at farmvilletaiwan@gmail.com.\r\n" + "\r\n"
				+ "Thanks,\r\n" + "The FarmVille Support Team";
		String emailBody = bodyPart1 + bodyPart2 + bodyPart3;
		try {
			// Instantiate SimpleEmail object
			Email email = new SimpleEmail();
			// Email sending settings
			email.setHostName(this.fromEmailHostName);
			email.setSmtpPort(this.fromEmailPort);
			// Email sender's credentials
			email.setAuthenticator(new DefaultAuthenticator(this.fromEmail, this.fromEmailPwd));
			email.setSSLOnConnect(true);
			// Email TO / FROM
			email.setFrom(this.fromEmail);
			email.addTo(toEmail);
			// Email body
			email.setSubject("Your FarmVille receipt [#" + orderID + "]");
			email.setMsg(emailBody);
			// Send
			email.send();
			System.out.println("Email to [" + toEmail + "] from [" + fromEmail + "] sent!");
		} catch (EmailException e) {
			e.printStackTrace();
			System.out.println("ERROR: sendReceiptEmail Email Exception");
		}
		System.out.println("FINISH: util.EmailUsers.sendReceiptEmail");
	}

	public void sendWelcomeEmail(String userEmail, String userName) {
		// String userName can be a user's Display name, Email, or Full name
		System.out.println("BEGIN: util.EmailUsers.sendWelcomeEmail");
		// Local variables
		String fromEmail = "farmvilletaiwan@gmail.com";
		String toEmail = userEmail;

		try {
			// Instantiate SimpleEmail object
			Email email = new SimpleEmail();
			// Email sending settings;
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			// Email (from)'s login credentials
			email.setAuthenticator(new DefaultAuthenticator("farmvilletaiwan@gmail.com", "Qq12345!"));
			email.setSSLOnConnect(true);
			// FROM / TO
			email.setFrom(fromEmail);
			email.addTo(toEmail);
			// Email body
			email.setSubject("Welcome to Farmville, Taiwan");
			email.setMsg("Hi " + userName + "," + " \r\n" + "\r\n"
					+ "Great to have you with us. Farmville is here to make a difference in groceries shopping."
					+ "\r\n"
					+ "Our website will continuously stock the best locally-sourced, GMO-free, and organic produce available."
					+ "\r\n"
					+ "Here at Farmville, we take our 'We are what we eat' philosphy very seriously and will always put customers first!"
					+ "\r\n" + "\r\n"
					+ "This is the e-mail address you registered on Farmville, Taiwan. Use it and your password to log into your online account."
					+ "\r\n"
					+ "For your 1st time sign-in, we recommend taking a moment and going over your account profile and settings."
					+ "\r\n" + "\r\n" + "Thanks," + "\r\n" + "The FarmVille Support Team");
			// Send
			email.send();
			System.out.println("Email to [" + toEmail + "] from [" + fromEmail + "] sent!");
		} catch (EmailException e) {
			e.printStackTrace();
			System.out.println("ERROR: sendWelcomeEmail Email Exception");
		}
		System.out.println("FINISH: util.EmailUsers.sendWelcomeEmail");
	}

	public void sendMyselfTestEmail(String emailBody) throws Exception {
		System.out.println("BEGIN: util.EmailUsers.emailSelf");
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("farmvilletaiwan@gmail.com", "Qq12345!"));
			email.setSSLOnConnect(true);
			email.setFrom("farmvilletaiwan@gmail.com");
			email.setSubject("TestMail");
			email.setMsg(emailBody);
			email.addTo("farmvilletaiwan@gmail.com");
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
		System.out.println("FINISH: util.EmailUsers.............................................");
	}
}
