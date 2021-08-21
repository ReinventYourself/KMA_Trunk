package com.rsi.kma.automation.modules;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.rsi.kma.automation.pageObjects.FindMyCarPage;
import com.rsi.kma.automation.pageObjects.RemotePage;
import com.rsi.kma.automation.pageObjects.WebDCSPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.Utils;

public class FindMyCarModule {



	private static Logger    Log = Logger.getLogger(FindMyCarModule.class.getName());


	public static void navigateToFindMYCarPage(WebDriver driver)
	{
		LoginModule.login(driver);	
		Utils.sleep(driver, 2000);
		if(!Utils.getPlatform().equalsIgnoreCase("EV 1.0"))
		{
			ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "MyCarLeftMenu");

			ActionModule.click(driver,MyCarLeftMenu.Remote_Link(driver), "Remote_Link", "MyCarLeftMenu");


			Utils.waitForElementToBeClickable(driver,RemotePage.Find_My_Car.find_My_Car_Tab(driver));

			Utils.waitForElementToBeClickable(driver,RemotePage.Lock_Unlock.lock_Unlock_Tab(driver));

			Utils.sleep(driver, 5000);

			ActionModule.click(driver, RemotePage.Find_My_Car.find_My_Car_Tab(driver), "find my car tab", "Remote page");
		}
		else
		{

			ActionModule.click(driver,MyCarLeftMenu.connect_Link(driver), "connect link", "MyCarLeftMenu");

			ActionModule.click(driver,MyCarLeftMenu.findMycarLink(driver), "connect link", "MyCarLeftMenu");

		}
		Utils.sleep(driver, 5000);
		// Wait for progress bar to be invisible
		Utils.waitForProgressbarInvisible(driver);


		Utils.waitForElementToBeClickable(driver, FindMyCarPage.getDirection(driver));

		Utils.waitForElementToBeVisible(driver, FindMyCarPage.timestamp(driver));

		Log.info("Successfully navigated to find my car page");



	}



	public static void getLocation(WebDriver driver)
	{

		Utils.waitForElementToBeClickable(driver, FindMyCarPage.updateLocationAndMore(driver));

		Utils.waitForElementToBeClickable(driver, FindMyCarPage.getDirection(driver));

		Utils.waitForElementToBeVisible(driver, FindMyCarPage.timestamp(driver));

		String location=ActionModule.getText(driver,FindMyCarPage.location(driver), "location", "FindMyCarPage");

		//Getting city and timeStamp
		String city=ActionModule.getText(driver,FindMyCarPage.city(driver), "city", "FindMyCarPage");

		Log.info("Car is at: "+ location +" "+ city);


		String timestamp=ActionModule.getText(driver,FindMyCarPage.timestamp(driver), "timestamp", "FindMyCarPage");

		Log.info("timestamp is : "+ timestamp);
		
		Utils.sleep(driver, 4000);
		String winHandleBefore = driver.getWindowHandle();
		
		ActionModule.click(driver,FindMyCarPage.getDirection(driver), "get direction", "Find my car page");



		// Perform the click operation that opens new window

		// Switch to new window opened
		if(BaseClass.getBrowser().equalsIgnoreCase("ie"))
		{
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

	
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		
		}
		
		else
		{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		//Switch to new window
		driver.switchTo().window(tabs.get(1));

		Utils.sleep(driver, 3000);
		driver.close();//closing recent opened tab

		//Switch to parent window
		driver.switchTo().window(tabs.get(0));
		driver.getTitle();

		}
		Utils.waitForElementToBeClickable(driver,FindMyCarPage.updateLocationAndMore(driver));

		ActionModule.click(driver,FindMyCarPage.updateLocationAndMore(driver), "updateLocationAndMore", "Find my car page");

		Utils.waitForElementToBeInvisible(driver, FindMyCarPage.updating(driver));

		Utils.waitForElementToBeInvisible(driver, FindMyCarPage.loaderwait(driver));

		Utils.waitForElementToBeVisible(driver, FindMyCarPage.timestamp(driver));

		Utils.waitForElementToBeClickable(driver, FindMyCarPage.getDirection(driver));

		String timestampNew=ActionModule.getText(driver,FindMyCarPage.timestamp(driver), "timestamp", "FindMyCarPage");

		Log.info("New timestamp is : "+ timestampNew);

		if(!timestamp.equalsIgnoreCase(timestampNew))
		{
			Log.info("Timestamp updated");
		}
		else
		{
			Log.error("Timestamp not updated");
			Assert.fail("Timestamp not updated");
		}



}







}
