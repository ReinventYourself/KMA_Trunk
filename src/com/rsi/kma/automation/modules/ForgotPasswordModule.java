package com.rsi.kma.automation.modules;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.rsi.kma.automation.pageObjects.ForgotPasswordPage;
import com.rsi.kma.automation.pageObjects.WebDCSPage;
import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.HomePage;
import com.rsi.kma.automation.pageObjects.Common.LoginFormPage;
import com.rsi.kma.automation.pageObjects.Common.MyVehiclesPage;
import com.rsi.kma.automation.pageObjects.Common.RegisterPage;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.EMail;
import com.rsi.kma.automation.utility.Utils;

public class ForgotPasswordModule {


	private static Logger    Log = Logger.getLogger(ForgotPasswordModule.class.getName());

	/**
	 * To verify Forgot password using email.
	 * @param driver
	 */
	public static void checkByEmail(WebDriver driver)
	{
		
		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}

		
		try
		{
			String email = null,emailPassword=null;

			ActionModule.click(driver, HomePage.forgotPasswordButton(driver), "Forgot password", "Forgot password");

			Utils.waitForElementToBeVisible(driver, ForgotPasswordPage.byEmail(driver));

			ActionModule.click(driver, ForgotPasswordPage.byEmail(driver), "byEmail", "Forgot password");


			email=Utils.getParameterValueFromCsvFile("email");
			emailPassword=Utils.getParameterValueFromCsvFile("emailPassword");

			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), email,"emailAddressField", "Forgot password");

			ActionModule.click(driver, ForgotPasswordPage.cancelButton(driver), "cancelButton", "HomePage");

			Utils.waitForElementToBeVisible(driver, HomePage.forgotPasswordButton(driver));

			ActionModule.click(driver, HomePage.forgotPasswordButton(driver), "Forgot password", "Forgot password");

			ActionModule.click(driver, ForgotPasswordPage.byEmail(driver), "byEmail", "HomePage");

			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), email,"emailAddressField", "Forgot password");

			ActionModule.click(driver, ForgotPasswordPage.resendPassword(driver), "resendPassword", "Forgot password");

			Utils.sleep(driver, 3000);
			if (EMail.execute("Password Reset", email, emailPassword,
					true)) {
				Log.info("Successful Password Reset has been received by user at "
						+ email);
			}
			else {
				Log.error("Successful Password Reset has not been received by user at "
						+ email);            
				Reporter.log("Successful Password Reset has not been received by user at "
						+ email);
				Assert.fail("Successful Password Reset has not been received by user at "
						+ email);
			}


			Utils.waitForElementToBeVisible(driver,ForgotPasswordPage.emailSentConfirm(driver));
			Utils.waitForElementToBeVisible(driver,ForgotPasswordPage.beSureToCheckYourSpamFolder(driver));

			ActionModule.click(driver, ForgotPasswordPage.returnToLogin(driver),"returnToLogin", "Forgot password");
		}
		catch(Exception e)
		{
			Utils.waitForElementToBeClickable(driver, ForgotPasswordPage.kiaLogo(driver));
			ActionModule.click(driver, ForgotPasswordPage.kiaLogo(driver), "kiaLogo", "Forgot password");
		}

	}

	/**
	 * To Check forgot Password By using security Questions
	 * @param driver
	 */
	public static void checkBySecurityQues(WebDriver driver)
	{
		
		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}
		

		try{
			String email = null;
			String[] answers = new String[3];
			ActionModule.click(driver, HomePage.forgotPasswordButton(driver), "Forgot password", "Forgot password");

			Utils.waitForElementToBeVisible(driver, ForgotPasswordPage.bySecurityQuestions(driver));
			
			Utils.sleep(driver, 5000);
			
			
			ActionModule.click(driver, ForgotPasswordPage.bySecurityQuestions(driver), "bySecurityQuestions", "ForgotPassword");

			
			email=Utils.getParameterValueFromCsvFile("email");

			answers[0]=Utils.getParameterValueFromCsvFile("Answer1");
			answers[1]=Utils.getParameterValueFromCsvFile("Answer2");
			answers[2]=Utils.getParameterValueFromCsvFile("Answer3");

			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), email,"emailAddressField", "HomePage");

			ActionModule.click(driver, ForgotPasswordPage.cancelButton(driver), "cancelButton", "HomePage");

			Utils.waitForElementToBeVisible(driver, HomePage.forgotPasswordButton(driver));

			ActionModule.click(driver, HomePage.forgotPasswordButton(driver), "Forgot password", "Forgot password");

			Utils.waitForElementToBeVisible(driver, ForgotPasswordPage.bySecurityQuestions(driver));

			ActionModule.click(driver, ForgotPasswordPage.bySecurityQuestions(driver), "bySecurityQuestions", "ForgotPassword");

			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), email,"emailAddressField", "HomePage");

			ActionModule.click(driver, ForgotPasswordPage.answerSecurityQues(driver), "Answer SecurityQuestions", "ForgotPassword");


			for (int i=0; i<3;i++)
			{
				Utils.waitForElementToBeClickable(driver, ForgotPasswordPage.myAnswer(driver));
				Utils.sleep(driver,3000);
				ActionModule.sendKeys(driver, ForgotPasswordPage.myAnswer(driver), answers[i],"answer", "HomePage");

				ActionModule.click(driver, ForgotPasswordPage.nextButtonSecurityQuestions(driver), "Answer SecurityQuestions", "ForgotPassword");

			}


			Utils.sleep(driver, 2000);

			ActionModule.sendKeys(driver, ForgotPasswordPage.newPassword(driver), "Password$", "new password", "forgot password");

			ActionModule.sendKeys(driver, ForgotPasswordPage.confirmNewPassword(driver), "Password$", "confirm new password", "forgot password");
			ActionModule.click(driver, ForgotPasswordPage.changeAndLoginButton(driver), "change and login", "ForgotPassword");

			ActionModule.isDisplayed(driver, ForgotPasswordPage.errorMessage(driver), "errorMessage", "forgot password");

			//It will pick a random no from 1 to 20 and then concatenate it with "Password" 
			//to make it unique everytime.

			int maximum=20,minimum=1;
			Random rn = new Random();
			int range = maximum - minimum + 1;
			int randomNum =  rn.nextInt(range) + minimum;
			String newPassword="Password"+Integer.toString(randomNum);

			ActionModule.sendKeys(driver, ForgotPasswordPage.newPassword(driver), newPassword, "new password", "forgot password");

			ActionModule.sendKeys(driver, ForgotPasswordPage.confirmNewPassword(driver), newPassword, "confirm new password", "forgot password");

			ActionModule.click(driver, ForgotPasswordPage.changeAndLoginButton(driver), "change and login", "ForgotPassword");
			Utils.sleep(driver, 3000);

			ActionModule.isDisplayed(driver, ForgotPasswordPage.alertPopUp(driver), "success message", "ForgotPassword");


			ActionModule.isDisplayed(driver, ForgotPasswordPage.popUpPasswordUpdatedText(driver), "success message", "ForgotPassword");

			ActionModule.click(driver, ForgotPasswordPage.alertOkButton(driver), "change and login", "ForgotPassword");

			if(Utils.waitForElementToBeClickable(driver, ForgotPasswordPage.returnToLogin(driver)))
				ActionModule.click(driver, ForgotPasswordPage.returnToLogin(driver),"returnToLogin", "Forgot password");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.usernameField(driver));

			email=Utils.getParameterValueFromCsvFile("email");
			ActionModule.sendKeys(driver, LoginFormPage.usernameField(driver), email, "email", "Login page");
			ActionModule.sendKeys(driver, LoginFormPage.passwordField(driver), newPassword, "passwordField", "Login page");
			ActionModule.click(driver, LoginFormPage.loginButton(driver), "Login Button", "LoginFormPage");

			Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver));
			ActionModule.domProcessing(driver);
			Utils.waitForTitleToVisible(driver);
			if(Utils.waitForElementToBeVisible(driver, MyVehiclesPage.addVehicle(driver)))
			{
				Log.info("User successfully lands to My vehicles page");
			}
			else
			{
				Log.error("Request timeout.Login failed.User could not land on My Vehicle page");
				Reporter.log("Request timeout.Login failed.User could not land on My Vehicle page");
				Assert.fail("Request timeout.Login failed.User could not land on My Vehicle page");
			}


		}
		catch(Exception e)
		{
			Utils.waitForElementToBeClickable(driver, ForgotPasswordPage.kiaLogo(driver));
			ActionModule.click(driver, ForgotPasswordPage.kiaLogo(driver), "kiaLogo", "Forgot password");
		}


	}

/**
 * To check Valid login 
 * @param driver
 */
	public static void checkValidlogin(WebDriver driver)
	{
		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}
		
		Utils.waitForElementToBeClickable(driver, LoginFormPage.usernameField(driver));
		Utils.sleep(driver, 2000);

		ActionModule.sendKeys(driver, LoginFormPage.usernameField(driver), Utils.getUserName(), "Username","Login Page");
		Utils.waitForElementToBeVisible(driver, LoginFormPage.passwordField(driver));
		ActionModule.sendKeys(driver, LoginFormPage.passwordField(driver), Utils.getPassword(), "password","Login Page");
		Utils.waitForElementToBeClickable(driver, LoginFormPage.loginButton(driver));
		ActionModule.click(driver, LoginFormPage.loginButton(driver), "Login Button", "Login Page");

		if(ActionModule.domProcessing(driver))
		{
			Utils.waitForTitleToVisible(driver);
			if(Utils.waitForElementToBeVisible(driver, MyVehiclesPage.addVehicle(driver)))
			{
				Utils.waitForElementToBeVisible(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()));
				Log.info("User successfully lands to My vehicles page");

			}
			else
			{
				Log.error("Request timeout.Login failed.User could not land on My Vehicle page");
				Reporter.log("Request timeout.Login failed.User could not land on My Vehicle page");
				Assert.fail("Request timeout.Login failed.User could not land on My Vehicle page");
			}
		}
		else
		{
			Log.error("Login failed.User could not land on My Vehicle page.Please check screenshots");
			Reporter.log("Login failed.User could not land on My Vehicle page.Please check screenshots");
			Assert.fail("Login failed.User could not land on My Vehicle page.Please check screenshots");

		}

	}
/**
 * To check Login invalid combination for username and password
 * @param driver
 */
	public static void checkInValidlogin(WebDriver driver)
	{

		String username=Utils.getParameterValueFromCsvFile("emailBlockedAccount");
		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}
		
		Utils.waitForElementToBeClickable(driver, LoginFormPage.usernameField(driver));
		Utils.sleep(driver, 2000);

		/**
		 * checking empty login credentials message 
		 */
		ActionModule.sendKeys(driver, LoginFormPage.usernameField(driver),"", "Username","Login Page");

		Utils.waitForElementToBeVisible(driver, LoginFormPage.passwordField(driver));
		ActionModule.sendKeys(driver, LoginFormPage.passwordField(driver), "", "password","Login Page");

		Utils.waitForElementToBeClickable(driver, LoginFormPage.loginButton(driver));
		ActionModule.click(driver, LoginFormPage.loginButton(driver), "Login Button", "Login Page");


		Utils.waitForElementToBeVisible(driver, LoginFormPage.emptyEmailOrPassword(driver));
		ActionModule.isDisplayed(driver, LoginFormPage.emptyEmailOrPassword(driver), "emptyEmailOrPassword", "Login Page");

		/**
		 * checking invalid login credentials message 
		 */

		String invalidEmail=username.substring(0, username.length()-4);
		Utils.waitForElementToBeVisible(driver, LoginFormPage.usernameField(driver));
		ActionModule.sendKeys(driver, LoginFormPage.usernameField(driver),invalidEmail, "Username","Login Page");

		Utils.waitForElementToBeVisible(driver, LoginFormPage.passwordField(driver));
		ActionModule.sendKeys(driver, LoginFormPage.passwordField(driver), "Password1", "password","Login Page");

		Utils.waitForElementToBeClickable(driver, LoginFormPage.loginButton(driver));
		ActionModule.click(driver, LoginFormPage.loginButton(driver), "Login Button", "Login Page");


		Utils.waitForElementToBeVisible(driver, LoginFormPage.invalidEmailAndPassword(driver));
		ActionModule.isDisplayed(driver, LoginFormPage.invalidEmailAndPassword(driver), " Invalid EmailOrPassword", "Login Page");


		/**
		 * checking account locked message 
		 */
		for(int i=0;i <5;i++){
			Log.info(i+"time executed ");
			Utils.waitForElementToBeVisible(driver, LoginFormPage.usernameField(driver));
			ActionModule.sendKeys(driver, LoginFormPage.usernameField(driver),username, "Username","Login Page");

			Utils.waitForElementToBeVisible(driver, LoginFormPage.passwordField(driver));
			ActionModule.sendKeys(driver, LoginFormPage.passwordField(driver), "Pass#", "password","Login Page");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.loginButton(driver));
			ActionModule.click(driver, LoginFormPage.loginButton(driver), "Login Button", "Login Page");

			Utils.waitForElementToBeVisible(driver, LoginFormPage.invalidEmailAndPassword(driver));
			ActionModule.isDisplayed(driver, LoginFormPage.invalidEmailAndPassword(driver), " Invalid EmailOrPassword", "Login Page");
		}

		ActionModule.click(driver, LoginFormPage.loginButton(driver), "Login Button", "Login Page");
		Utils.waitForElementToBeVisible(driver, LoginFormPage.accountLockedMsg(driver));
		ActionModule.isDisplayed(driver, LoginFormPage.accountLockedMsg(driver), " accountLockedMsg", "Login Page");
	}
/**
 * To check Forgot Password By using invalid combination
 * @param driver
 */
	public static void checkEmail(WebDriver driver)
	{

		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}
		try
		{
			ActionModule.click(driver, HomePage.forgotPasswordButton(driver), "Forgot password", "Forgot password");

			Utils.waitForElementToBeVisible(driver, ForgotPasswordPage.byEmail(driver));

			ActionModule.click(driver, ForgotPasswordPage.byEmail(driver), "byEmail", "Forgot password");

			/**
			 * checking empty login credentials message 
			 */
			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), "","emailAddressField", "Forgot password");
			ActionModule.click(driver, ForgotPasswordPage.resendPassword(driver), "resendPassword", "Forgot password");

			Utils.sleep(driver, 2000);

			ActionModule.isDisplayed(driver, ForgotPasswordPage.emptyEmailMsg(driver), "emptyEmailMsg", "Forgot password");


			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), "mailkia@gmail.com","emailAddressField", "Forgot password");
			ActionModule.click(driver, ForgotPasswordPage.resendPassword(driver), "resendPassword", "Forgot password");

			Utils.sleep(driver, 3000);

			/**
			 * checking invalid login credentials message 
			 */
			ActionModule.isDisplayed(driver, ForgotPasswordPage.invalidEmailMsg(driver), "Invalid EmailMsg", "Forgot password");

			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), "mailkia@gmail","emailAddressField", "Forgot password");
			ActionModule.click(driver, ForgotPasswordPage.resendPassword(driver), "resendPassword", "Forgot password");

			Utils.sleep(driver, 2000);

			ActionModule.isDisplayed(driver, ForgotPasswordPage.incorrectEmailMsg(driver), "incorrect EmailMsg", "Forgot password");


			ActionModule.click(driver, ForgotPasswordPage.bySecurityQuestions(driver), "bySecurityQuestions", "ForgotPassword");


			/**
			 * checking empty login credentials message 
			 */
			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), "","emailAddressField", "Forgot password");
			ActionModule.click(driver, ForgotPasswordPage.answerSecurityQues(driver), "Answer SecurityQuestions", "ForgotPassword");

			Utils.sleep(driver, 2000);

			ActionModule.isDisplayed(driver, ForgotPasswordPage.emptyEmailMsg(driver), "emptyEmailMsg", "Forgot password");

			/**
			 * checking invalid login credentials message 
			 */

			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), "mailkia@gmail.com","emailAddressField", "Forgot password");
			ActionModule.click(driver, ForgotPasswordPage.answerSecurityQues(driver), "Answer SecurityQuestions", "ForgotPassword");

			Utils.sleep(driver, 3000);

			ActionModule.isDisplayed(driver, ForgotPasswordPage.invalidEmailMsg(driver), "Invalid EmailMsg", "Forgot password");

			ActionModule.sendKeys(driver, ForgotPasswordPage.emailAddressField(driver), "mailkia@gmail","emailAddressField", "Forgot password");
			ActionModule.click(driver, ForgotPasswordPage.answerSecurityQues(driver), "Answer SecurityQuestions", "ForgotPassword");

			Utils.sleep(driver, 2000);

			ActionModule.isDisplayed(driver, ForgotPasswordPage.incorrectEmailMsg(driver), "incorrect EmailMsg", "Forgot password");
			ActionModule.click(driver, ForgotPasswordPage.cancelButton(driver), "cancelButton", "HomePage");

		}
		catch(Exception e)
		{
			Utils.waitForElementToBeClickable(driver, ForgotPasswordPage.kiaLogo(driver));
			ActionModule.click(driver, ForgotPasswordPage.kiaLogo(driver), "kiaLogo", "Forgot password");
		}


	}




}
