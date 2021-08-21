package com.rsi.kma.automation.modules;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.LoginFormPage;
import com.rsi.kma.automation.pageObjects.Common.MyVehiclesPage;
import com.rsi.kma.automation.pageObjects.Common.RegisterPage;
import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Utils;

public class RegisterModule {


	private static Logger    Log = Logger.getLogger(AwardsModule.class.getName());

	public static void blankFieldMessage(WebDriver driver)
	{


		if(Utils.waitForElementToBeClickable(driver,MyVehiclesPage.AddVehicle.closePopup(driver)))
		{
			ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");
		}


		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}

		ActionModule.click(driver, LoginFormPage.register(driver), "register", "RegisterPage");

		Utils.waitForElementToBeClickable(driver,LoginFormPage.register(driver));

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");

		Utils.sleep(driver, 3000);

		ActionModule.isDisplayed(driver, RegisterPage.AccountBasics.errorMessageBlankField(driver), "errorMessageBlankField", "RegisterPage");

		driver.navigate().back();

	}


	public static void invalidEmailFormat(WebDriver driver)
	{



		if(Utils.waitForElementToBeClickable(driver,MyVehiclesPage.AddVehicle.closePopup(driver)))
		{
			ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");
		}

		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}

		Utils.waitForElementToBeClickable(driver,LoginFormPage.register(driver));
		ActionModule.click(driver, LoginFormPage.register(driver), "register", "RegisterPage");


		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.emailAddress(driver), "test@@yopmail.com", "Email","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");
		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeVisible(driver, RegisterPage.AccountBasics.errorMessageBlankField(driver));
		ActionModule.isDisplayed(driver, RegisterPage.AccountBasics.errorMessageBlankField(driver), "errorMessageBlankField", "RegisterPage");


		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.emailAddress(driver), "test@yopmail.com", "Email","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");
		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeVisible(driver, RegisterPage.AccountBasics.errorMessageBlankField(driver));
		ActionModule.isDisplayed(driver, RegisterPage.AccountBasics.errorMessageBlankField(driver), "errorMessageBlankField", "RegisterPage");


		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.emailAddress(driver), "awards8@gmail.com", "Email","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");
		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeVisible(driver, RegisterPage.AccountBasics.errorMessageRegisteredEmail(driver));
		ActionModule.isDisplayed(driver, RegisterPage.AccountBasics.errorMessageRegisteredEmail(driver), "errorMessageBlankField", "RegisterPage");

		driver.navigate().back();

	}


	public static void invalidPassswordFormat(WebDriver driver) {



		if(Utils.waitForElementToBeClickable(driver,MyVehiclesPage.AddVehicle.closePopup(driver)))
		{
			ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");
		}

		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}

		Utils.waitForElementToBeClickable(driver,LoginFormPage.register(driver));

		ActionModule.click(driver, LoginFormPage.register(driver), "register", "RegisterPage");

		Utils.waitForElementToBeClickable(driver,  RegisterPage.AccountBasics.password(driver));

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.emailAddress(driver), "KMAMay2018@gmail.com", "password","Register");

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.password(driver), "Password$", "password","Register");
		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.confirmPassword(driver), "Password$", "confirmPassword","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");
		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeVisible(driver, RegisterPage.AccountBasics.invalidPasword(driver));
		ActionModule.isDisplayed(driver, RegisterPage.AccountBasics.invalidPasword(driver), "invalidPasword", "RegisterPage");


		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.password(driver), "Password!", "password","Register");
		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.confirmPassword(driver), "Password!", "confirmPassword","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");
		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeVisible(driver, RegisterPage.AccountBasics.invalidPasword(driver));
		ActionModule.isDisplayed(driver, RegisterPage.AccountBasics.invalidPasword(driver), "invalidPasword", "RegisterPage");


		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.password(driver), "Password$", "password","Register");
		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.confirmPassword(driver), "Password!", "confirmPassword","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");
		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeVisible(driver, RegisterPage.AccountBasics.passwordNotMatch(driver));
		ActionModule.isDisplayed(driver, RegisterPage.AccountBasics.passwordNotMatch(driver), "errorMessageBlankField", "RegisterPage");

		driver.navigate().back();

	}

	public static void invalidPhoneNo(WebDriver driver)
	{

		if(Utils.waitForElementToBeClickable(driver,MyVehiclesPage.AddVehicle.closePopup(driver)))
		{
			ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");
		}


		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}

		ActionModule.click(driver, LoginFormPage.register(driver), "register", "RegisterPage");

		Utils.waitForElementToBeClickable(driver,  RegisterPage.AccountBasics.password(driver));

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.emailAddress(driver), "KMAMay2018@gmail.com", "password","Register");

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.password(driver), "Password1", "password","Register");
		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.confirmPassword(driver), "Password1", "confirmPassword","Register");



		Utils.waitForElementToBeClickable(driver,RegisterPage.AccountBasics.mobileNo(driver));

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.mobileNo(driver), "987654323", "mobileNo","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");

		Utils.sleep(driver, 3000);

		ActionModule.isDisplayed(driver, RegisterPage.AccountBasics.phoneNotMatch(driver), "errorMessageBlankField", "RegisterPage");

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.mobileNo(driver), "987654321234", "mobileNo","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");

		Utils.sleep(driver, 3000);

		ActionModule.isDisplayed(driver, RegisterPage.AccountBasics.phoneNotMatch(driver), "errorMessageBlankField", "RegisterPage");
		
		
		
		driver.navigate().back();

	}


	public static void checkTermsOfServiceLink(WebDriver driver) {

		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}

		ActionModule.click(driver, LoginFormPage.register(driver), "register", "RegisterPage");

		Utils.waitForElementToBeClickable(driver,RegisterPage.AccountBasics.termsOfService(driver));

		ActionModule.click(driver, RegisterPage.AccountBasics.termsOfService(driver), "termsOfService", "RegisterPage");


		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		//Switch to new window
		driver.switchTo().window(tabs.get(1));

		Utils.sleep(driver, 3000);

		String Url=driver.getCurrentUrl();
		if(Url.contains("terms-of-service"))
		{
			Log.info("Successfully navigated to terms of service");

			Utils.waitForElementToBeClickable(driver,RegisterPage.AccountBasics.backToHome(driver));

			ActionModule.click(driver, RegisterPage.AccountBasics.backToHome(driver), "backToHome", "RegisterPage");
			driver.close();//do some action in new window(2nd tab)

			//Switch to main/parent window
			driver.switchTo().window(tabs.get(0));

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}


		else
		{

			Log.error("Could not be navigated to terms of service page.");
			Assert.fail("Could not be navigated to terms of service page.");
		}





	}


	public static void checkPrivacyPolicyLink(WebDriver driver) {



		Utils.waitForElementToBeClickable(driver,RegisterPage.AccountBasics.privacyPolicy(driver));

		ActionModule.click(driver, RegisterPage.AccountBasics.privacyPolicy(driver), "privacyPolicy", "RegisterPage");

		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		//Switch to new window
		driver.switchTo().window(tabs.get(1));

		Utils.sleep(driver, 3000);

		String Url=driver.getCurrentUrl();

		if(Url.contains("privacy-policy"))
		{
			Log.info("Successfully navigated to privacy-policy");

			Utils.waitForElementToBeClickable(driver,RegisterPage.AccountBasics.backToHome(driver));

			ActionModule.click(driver, RegisterPage.AccountBasics.backToHome(driver), "backToHome", "RegisterPage");
			driver.close();//do some action in new window(2nd tab)

			//Switch to main/parent window
			driver.switchTo().window(tabs.get(0));

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}


		else
		{

			Log.error("Could not be navigated to terms of service page.");
			Assert.fail("Could not be navigated to terms of service page.");
		}


	}


	public static void accountCreation(WebDriver driver) {


		String Username= newUser(driver);
		Log.info("Username created: "+Username);
		List <WebElement> model=FindWebElement.findElementListByXpath(driver, "//*[@id='modelName']/option", "model", "register") ;// 19-1
		int availableCar=model.size();
		Select modelDropdown= new Select(MyVehiclesPage.AddVehicle.modelDropDown(driver));

		modelDropdown.selectByIndex(1);
		Utils.sleep(driver, 2000);
		List <WebElement> year=FindWebElement.findElementListByXpath(driver, "//*[@id='modelYear']/option", "year", "register");
		int availableYear=year.size();
		Utils.sleep(driver, 3000);

		String[] account1 = new String[availableCar*availableYear];
		String[] account2 = new String[availableCar*availableYear];
		String[] account3 = new String[availableCar*availableYear];


		int count1 = 0,count2 = 0,count3=0;

		for(int i=1;i< availableCar;i++)
		{

			modelDropdown= new Select(MyVehiclesPage.AddVehicle.modelDropDown(driver));

			modelDropdown.selectByIndex(i);
			Utils.sleep(driver, 2000);


			year=FindWebElement.findElementListByXpath(driver, "//*[@id='modelYear']/option", "year", "register");
			availableYear=year.size();



			for(int j=1;j<availableYear;j++)
			{
				modelDropdown= new Select(MyVehiclesPage.AddVehicle.modelDropDown(driver));

				modelDropdown.selectByIndex(i);
				Log.info("*************value for i is:"+i+ "     "+ "value for j is :"+j);

				Utils.sleep(driver, 2000);
				Select yearDropdown= new Select(MyVehiclesPage.AddVehicle.yearDropDown(driver));
				yearDropdown.selectByIndex(j);

				Utils.sleep(driver, 3000);
				List <WebElement> headUnit=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-class,'twoHU') and contains(@ng-show,'addVehicleOption ')]/div[contains(@ng-repeat,'listHU')]/input", "model", "register") ;

				if(headUnit!=null && headUnit.size()==2)
				{
					int flag=MyCarZoneModule.chooseRandom(driver, 0, 1);
					Log.info("head unit selection is:"+ flag);
					ActionModule.click(driver, headUnit.get(flag), "headUnit", "Register page");
					account1[count1]=Username;
					count1++;


				}

				ActionModule.click(driver, MyVehiclesPage.AddVehicle.addVehicleArrow(driver),"addVehicleArrow","Register");

				if(Utils.waitForElementToBeClickable(driver,RegisterPage.AccCreated.GoToKiaOwnerPortal(driver) ))
				{
					Log.info("kia portal vehicle");
					account2[count2]=Username;
					count2++;
				}


				else if(Utils.waitForElementToBeClickable(driver, MyVehiclesPage.AddVehicle.vehicleName(driver)))
				{
					account3[count3]=Username;
					count3++;
					Utils.waitForElementToBeClickable(driver, MyVehiclesPage.AddVehicle.vehicleName(driver));

					String nicknameAdded=ActionModule.getText(driver, MyVehiclesPage.AddVehicle.vehicleName(driver), "vehicleName", "My vehicle Page");
					Log.info("vehicle name added:"+nicknameAdded);



				}

				else
				{


					Log.info("Mail Verification account found");
				}
				Utils.sleep(driver, 3000);
				ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");

				Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver));

				ActionModule.click(driver, HeaderPage.logOutLink(driver), "logOutLink", "HeaderPage");

				Utils.waitForElementToBeClickable(driver, LoginFormPage.usernameField(driver));

				Username= newUser(driver);
				Log.info("Username created: "+Username);





			}


		}
		for(int i=0;i<count1;i++)
		{
			Log.info("******************head unit selection Vehicle :*******************************");
			Log.info(account1[i]);
		}
		for(int i=0;i<count2;i++)
		{
			Log.info("******************kia owner portal Vehicle :*******************************");
			Log.info(account2[i]);
		}
		for(int i=0;i<count3;i++)
		{
			Log.info("******************kia Vehicle :*******************************");
			Log.info(account3[i]);
		}



		if(Utils.waitForElementToBeClickable(driver,MyVehiclesPage.AddVehicle.closePopup(driver)))
		{
			ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");
		}
	}



	public static String newUser(WebDriver driver)
	{


		if(Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver)))
		{
			ActionModule.click(driver, HeaderPage.logOutLink(driver), "logOutLink", "HeaderPage");
		}

		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}

		Utils.waitForElementToBeClickable(driver,LoginFormPage.register(driver));

		ActionModule.click(driver, LoginFormPage.register(driver), "register", "RegisterPage");

		String Username = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		Username=Username.concat("@gmail.com");

		Utils.waitForElementToBeClickable(driver,RegisterPage.AccountBasics.emailAddress(driver));

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.emailAddress(driver), Username, "Email","Register");

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.password(driver), "Password1","password","Register");

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.confirmPassword(driver), "Password1","password","Register");

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.mobileNo(driver), "9876543212","password","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.iAgreeCheckbox(driver),"password","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");

		Utils.sleep(driver, 5000);

		Utils.waitForElementToBeClickable(driver, MyVehiclesPage.AddVehicle.lookMyKiaInstead(driver));

		ActionModule.click(driver, MyVehiclesPage.AddVehicle.lookMyKiaInstead(driver), "createMyAccount", "RegisterPage");

		return Username;
	}



	public static void newAccount(WebDriver driver) {


		if(Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver)))
		{
			ActionModule.click(driver, HeaderPage.logOutLink(driver), "logOutLink", "HeaderPage");
		}

		if(Utils.waitForElementToBeClickable(driver, RegisterPage.AccountBasics.uvoLogo(driver)))
		{
			ActionModule.click(driver,  RegisterPage.AccountBasics.uvoLogo(driver), "UVO logo", "RegisterPage");

			Utils.waitForElementToBeClickable(driver, LoginFormPage.register(driver));
		}



		if(Utils.waitForElementToBeClickable(driver,RegisterPage.AccountBasics.emailAddress(driver)))

			Log.info("already on register page");
		else
		{
			Utils.waitForElementToBeClickable(driver,LoginFormPage.register(driver));
			ActionModule.click(driver, LoginFormPage.register(driver), "register", "RegisterPage");
		}

		String Username = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		Username=Username.concat("@gmail.com");
		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.emailAddress(driver), Username, "Email","Register");

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.password(driver), "Password1","password","Register");

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.confirmPassword(driver), "Password1","password","Register");

		ActionModule.sendKeys(driver, RegisterPage.AccountBasics.mobileNo(driver), "9876543212","password","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.iAgreeCheckbox(driver),"password","Register");

		ActionModule.click(driver, RegisterPage.AccountBasics.createMyAccount(driver), "createMyAccount", "RegisterPage");

		Utils.sleep(driver, 3000);
		String VIN = null;
		VIN = Utils.getParameterValueFromCsvFile("AwardsVIN1");

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.AddVehicle.vinTextBox(driver));

		ActionModule.sendKeys(driver, MyVehiclesPage.AddVehicle.vinTextBox(driver), VIN,"vin text box", "My vehicle Page");

		ActionModule.click(driver, MyVehiclesPage.AddVehicle.addVehicleArrow(driver), "addVehicleArrow", "My vehicle Page");

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.AddVehicle.vehicleName(driver));
		Utils.sleep(driver, 3000);


		if(Utils.waitForElementToBeVisible(driver, MyVehiclesPage.AddVehicle.alreadyAddedVINMsg(driver)))
		{
			Log.error("vehicle with this VIN is aleady added.");
			ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");
			Assert.fail("vehicle with this VIN is aleady added.");


		}

		//Fetching vehicle name which has added successfully
		String nicknameAdded=ActionModule.getText(driver, MyVehiclesPage.AddVehicle.vehicleName(driver), "vehicleName", "My vehicle Page");
		Log.info("vehicle name added:"+nicknameAdded);

		ActionModule.isDisplayed(driver, RegisterPage.AccCreated.googleAppStore_Image(driver), "googleAppStore_Image", "RegisterPage");
		ActionModule.click(driver, RegisterPage.AccCreated.googleAppStore_Image(driver), "googleAppStore_Image", "RegisterPage");

		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		//Switch to new window
		driver.switchTo().window(tabs.get(1));

		Utils.sleep(driver, 3000);

		String Url=driver.getCurrentUrl();


		driver.close();//do some action in new window(2nd tab)

		//Switch to main/parent window
		driver.switchTo().window(tabs.get(0));


		ActionModule.isDisplayed(driver, RegisterPage.AccCreated.appleAppStore_Image(driver), "appleAppStore_Image", "RegisterPage");
		ActionModule.click(driver, RegisterPage.AccCreated.appleAppStore_Image(driver), "appleAppStore_Image", "RegisterPage");


		tabs = new ArrayList<String> (driver.getWindowHandles());

		//Switch to new window
		driver.switchTo().window(tabs.get(1));

		Utils.sleep(driver, 3000);

		Url=driver.getCurrentUrl();


		driver.close();//do some action in new window(2nd tab)

		//Switch to main/parent window
		driver.switchTo().window(tabs.get(0));


		Utils.sleep(driver, 6000);
		ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");


		if(Utils.waitForElementToBeClickable(driver,MyVehiclesPage.AddVehicle.closePopup(driver)))
		{
			ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");
		}


		WebElement logOut=HeaderPage.logOutLink(driver);
		if(logOut!=null && Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver)))
		{
			ActionModule.click(driver, HeaderPage.logOutLink(driver), "logout Button", "Login Page");
		}
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver, LoginFormPage.usernameField(driver));
		ActionModule.sendKeys(driver, LoginFormPage.usernameField(driver),Username, "Username","Login Page");

		Utils.waitForElementToBeVisible(driver, LoginFormPage.passwordField(driver));
		ActionModule.sendKeys(driver, LoginFormPage.passwordField(driver),"Password1", "password","Login Page");

		Utils.waitForElementToBeClickable(driver, LoginFormPage.loginButton(driver));
		ActionModule.click(driver, LoginFormPage.loginButton(driver), "Login Button", "Login Page");

		if(ActionModule.domProcessing(driver))
		{
			Utils.waitForTitleToVisible(driver);
			Utils.waitForElementToBeVisible(driver, MyVehiclesPage.addVehicle(driver));
			Utils.sleep(driver, 3000);
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
		else
		{
			if(LoginFormPage.invalidEmailAndPassword(driver)!=null)
			{
				Log.error("Login failed.User could not land on My Vehicle page");
				Reporter.log("Login failed.User could not land on My Vehicle page");
				Assert.fail("Login failed.User could not land on My Vehicle page");
			}
			else
			{
				Log.error("User could not land on My vehicles page.Please check screenshots");
				Reporter.log("User could not land on My vehicles page.Please check screenshots");
				Assert.fail("User could not land on My vehicles page.Please check screenshots");
			}
		}

	}

}
