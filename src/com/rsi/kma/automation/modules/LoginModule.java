package com.rsi.kma.automation.modules;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.LoginFormPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.pageObjects.Common.MyVehiclesPage;
import com.rsi.kma.automation.pageObjects.Common.OverviewPage;
import com.rsi.kma.automation.utility.Utils;


public class LoginModule {

	private static Logger    Log = Logger.getLogger(LoginModule.class.getName());

	public static void login(WebDriver driver)
	{
		
		WebElement logOut=HeaderPage.logOutLink(driver);
		if(logOut!=null && Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver)))
		{
			ActionModule.click(driver, HeaderPage.logOutLink(driver), "logout Button", "Login Page");
		}
		Utils.waitForElementToBeVisible(driver, LoginFormPage.usernameField(driver));
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
				Log.info("User successfully lands to My vehicles page");
				
				Utils.sleep(driver, 8000);
				choosevehicle(driver);
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

	public static void choosevehicle(WebDriver driver)
	{
		Utils.sleep(driver, 12000);
		if(Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//*[starts-with(@class,'nickname')][text()='"+ Utils.getCarName() +"']")))
		{
			Utils.sleep(driver, 3000);
			Log.info("car Name is :"+ Utils.getCarName() +" and platform name is:"+ Utils.getPlatform() );
			Reporter.log("Platform selected is: "+Utils.getPlatform());
			ActionModule.click(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()), "CarName", "VehiclePage");
			Utils.waitForElementToBeClickable(driver,OverviewPage.VehicleSelector.image(driver));
			Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.nicknameOfVehicle(driver));
			
			Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.tripInformationLink(driver));
		}
		else
		{
			Log.error(Utils.getCarName() +"is not found on my vehicle page");
			Reporter.log(Utils.getCarName() +"is not found on my vehicle page");
			Assert.fail(Utils.getCarName() +"is not found on my vehicle page");
		}

	}
}
