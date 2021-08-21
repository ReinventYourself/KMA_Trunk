package com.rsi.kma.automation.modules;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.LoginFormPage;
import com.rsi.kma.automation.pageObjects.Common.MyVehiclesPage;
import com.rsi.kma.automation.utility.Utils;

public class MyVehicleModule {

	private static Logger    Log = Logger.getLogger(MyVehicleModule.class.getName());

	public static void NavigateToVehiclePage(WebDriver driver)
	{
		WebElement logOut=HeaderPage.logOutLink(driver);
		if(logOut!=null && Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver)))
		{
			ActionModule.click(driver, HeaderPage.logOutLink(driver), "logout Button", "Login Page");
		}
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver, LoginFormPage.usernameField(driver));
		ActionModule.sendKeys(driver, LoginFormPage.usernameField(driver), Utils.getUserName(), "Username","Login Page");

		Utils.waitForElementToBeVisible(driver, LoginFormPage.passwordField(driver));
		ActionModule.sendKeys(driver, LoginFormPage.passwordField(driver), Utils.getPassword(), "password","Login Page");

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




	public static String addDeleteVin(WebDriver driver)
	{
		//Fetching VIN No from Master parameter list
		String VIN = null;
		VIN = Utils.getParameterValueFromCsvFile("VINADD");
		Log.info("VIN is : "+VIN);

		//Fetching nickname from Master parameter list
		String nickName = null;
		nickName = Utils.getParameterValueFromCsvFile("Nickname");
		Log.info("nickName is : "+nickName);

		if(!Utils.waitForElementToBeClickable(driver, MyVehiclesPage.AddVehicle.addVehicleArrow(driver)))
		{
			ActionModule.click(driver, MyVehiclesPage.addVehicle(driver), "addVehicle", "Login Page");
		}


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

		ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");

		Utils.waitForElementToBeClickable(driver, MyVehiclesPage.addVehicle(driver));
		Utils.waitForElementToBeInvisible(driver, MyVehiclesPage.AddVehicle.closePopup(driver));

		ActionModule.isDisplayed(driver, MyVehiclesPage.AddVehicle.nicknameAddVehicle(driver, nicknameAdded), "nicknameAddVehicle", "My vehicle Page");

		Utils.waitForProgressbarInvisible(driver);
		Utils.sleep(driver,5000);

		//Fetching vehicle Nick Name using name that is extracted above
		String vehicleName=ActionModule.getText(driver, MyVehiclesPage.AddVehicle.nickname(driver, nicknameAdded), "nicknameAddVehicle", "My vehicle Page");
		Log.info("vehicle name returned is:"+vehicleName);


		if(vehicleName.equals(nickName))
		{
			Log.info("Vehicle added successfully");
		}
		else
		{
			Log.error("Vehicle could not be added sucessfully");
			Assert.fail("Vehicle could not be added sucessfully");
		}


		Utils.waitForElementToBeClickable(driver, MyVehiclesPage.manageButton(driver, vehicleName));

		ActionModule.click(driver, MyVehiclesPage.manageButton(driver, vehicleName), "manageButton", "vehicle Box");

		return vehicleName;

	}

	public static String changeNickname(WebDriver driver,String oldVehicleName)
	{

		String newNickname = null;

		newNickname = Utils.getParameterValueFromCsvFile("OtherNickName");

		Log.info("NickName choosen is : "+newNickname);

		Utils.sleep(driver, 3000);

		ActionModule.click(driver, HeaderPage.myVehiclesLink(driver), "displayed", "vehicle Box");

		Utils.sleep(driver, 5000);

		Utils.waitForElementToBeClickable(driver,  MyVehiclesPage.manageDoneButton(driver));

		ActionModule.sendKeys(driver, MyVehiclesPage.manageButtonNickName(driver), newNickname,"vin text box", "My vehicle Page");

		ActionModule.click(driver, MyVehiclesPage.Manage.popUpCloseButton(driver), "nickName", "Vehicle page");

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.nickname(driver, oldVehicleName));

		ActionModule.click(driver, MyVehiclesPage.manageButton(driver, oldVehicleName), "manage", "vehicle Box");

		ActionModule.sendKeys(driver, MyVehiclesPage.manageButtonNickName(driver), newNickname,"vin text box", "My vehicle Page");

		Utils.waitForElementToBeClickable(driver,MyVehiclesPage.manageDoneButton(driver));
		Utils.sleep(driver, 3000);

		ActionModule.click(driver,MyVehiclesPage.manageDoneButton(driver) , "Done button", "vehicle page");

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.nickname(driver, newNickname));

		ActionModule.isDisplayed(driver, MyVehiclesPage.nickname(driver, newNickname), "New NickName", "My Vehicle");

		return newNickname;
	}


	public static void deleteVehicle(WebDriver driver,String newNickname)
	{
		ActionModule.click(driver, MyVehiclesPage.manageButton(driver, newNickname), "manage", "vehicle Box");

		Utils.waitForElementToBeClickable(driver,  MyVehiclesPage.manageDoneButton(driver));

		ActionModule.click(driver, MyVehiclesPage.Manage.deleteVehicleButton(driver), "deleteVehicleButton", "vehicle Box");

		Utils.sleep(driver, 3000);

		ActionModule.click(driver, MyVehiclesPage.Manage.cancelDeleteVehicle(driver), "cancelDeleteVehicle", "vehicle Box");

		ActionModule.click(driver, MyVehiclesPage.Manage.popUpCloseButton(driver), "popUpCloseButton", "vehicle Box");

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.nickname(driver, newNickname));

		ActionModule.click(driver, MyVehiclesPage.manageButton(driver, newNickname), "manage", "vehicle Box");

		Utils.waitForElementToBeClickable(driver,  MyVehiclesPage.manageDoneButton(driver));

		ActionModule.click(driver, MyVehiclesPage.Manage.deleteVehicleButton(driver), "deleteVehicle", "vehicle Box");

		Utils.sleep(driver, 2000);

		ActionModule.click(driver, MyVehiclesPage.Manage.confirmDeleteVehicle(driver), "deleteVehicle", "vehicle Box");

		Utils.sleep(driver, 2000);
		Utils.waitForProgressbarInvisible(driver);
		Utils.waitForElementToBeClickable(driver, MyVehiclesPage.addVehicle(driver));
		Utils.sleep(driver, 4000);
		Utils.waitForElementToBeInvisible(driver, MyVehiclesPage.nickname(driver, newNickname));

		if(!Utils.waitForElementToBeVisible(driver, MyVehiclesPage.nickname(driver, newNickname)))
		{
			Log.info("vehicle deleted successfully ");
		}
		else
		{
			Log.error("Vehicle could not be deleted successfully");
			Assert.fail("Vehicle could not be deleted successfully");
		}

	}
}
