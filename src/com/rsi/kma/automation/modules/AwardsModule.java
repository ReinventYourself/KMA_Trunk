package com.rsi.kma.automation.modules;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;

import com.rsi.kma.automation.pageObjects.AwardsPage;
import com.rsi.kma.automation.pageObjects.MaintenancePage;
import com.rsi.kma.automation.pageObjects.MyCarZonePage;
import com.rsi.kma.automation.pageObjects.MyPOIsPage;
import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.pageObjects.Common.MyVehiclesPage;
import com.rsi.kma.automation.pageObjects.Common.OverviewPage;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Utils;

public class AwardsModule {

	private static Logger    Log = Logger.getLogger(AwardsModule.class.getName());
	static String awardsText=null;

	public static void navigateToAwardsPage(WebDriver driver) {

		MyVehicleModule.NavigateToVehiclePage(driver);

		Utils.waitForElementToBeClickable(driver, HeaderPage.awardsLink(driver));

		ActionModule.click(driver, HeaderPage.awardsLink(driver), "awardsLink", "HeaderPage");

		Utils.waitForElementToBeClickable(driver, AwardsPage.backButtton(driver));

		Utils.waitForElementToBeVisible(driver, AwardsPage.awardsText(driver));

		Log.info("Successfully navigated to awards Page");


	}


	/**
	 * To check scheduler award 
	 * @param driver
	 */
	public static void schedulerAward(WebDriver driver)
	{


		ActionModule.isDisplayed(driver, AwardsPage.schedulerText(driver), "schedulerText", "AwardsPage");

		Utils.sleep(driver, 4000);

		awardsText=ActionModule.getText(driver, AwardsPage.schedulerAwards(driver), "schedulerAwards", "AwardsPage");


		if(awardsText.contains("Earn the Scheduler Award by scheduling a service appointment"))
		{
			Log.info("Schedule awards has not been awarded yet..");


			ActionModule.click(driver, AwardsPage.backButtton(driver), "backButtton", "AwardsPage");

			Utils.waitForElementToBeClickable(driver, MyVehiclesPage.addVehicle(driver));

			ActionModule.click(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()), "backButtton", "AwardsPage");

			//If the vehicle is not having any dealer assigned

			Utils.chooseDealer(driver);

			Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.nicknameOfVehicle(driver));

			Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.maintenanceLink(driver));

			ActionModule.click(driver, MyCarLeftMenu.maintenanceLink(driver), "maintenanceLink", "MyVehiclesPage");	

			Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.RequestAppointmentButton(driver));

			Utils.scrolDownForElement(driver, MaintenancePage.RequestAppointment.RequestAppointmentButton(driver));

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MaintenancePage.RequestAppointment.RequestAppointmentButton(driver), "RequestAppointmentButton", "MyVehiclesPage");

			Utils.sleep(driver, 3000);

			String dealer=ActionModule.getText(driver, MaintenancePage.RequestAppointment.selectedDealer(driver), "selectedDealer", "MaintenancePage");


			Utils.sleep(driver, 4000);


			if(dealer.toLowerCase().contains("kia of irvine"))
			{
				Log.info("dealer is kia of irvine");



			}
			else
			{
				Log.info("dealer needs to be changed");

				ActionModule.click(driver, MaintenancePage.RequestAppointment.changeDealer(driver), "selectDealer", "MyVehiclesPage");

				Utils.waitForElementToBeClickable(driver, MyVehiclesPage.zipcode(driver));

				ActionModule.sendKeys(driver, MyVehiclesPage.zipcode(driver),"92618", "zipcode", "MyVehiclesPage");

				ActionModule.click(driver, MyVehiclesPage.getDealer(driver), "getDealer", "MyVehiclesPage");

				Utils.waitForElementToBeClickable(driver, MyVehiclesPage.selectDealer(driver));
				Utils.sleep(driver, 6000);

				if(BaseClass.getBrowser().equalsIgnoreCase("ie"))
				{
				
				Actions act = new Actions(driver);
				act.click(MyVehiclesPage.selectDealer(driver)).build().perform();
				}
				
				else
				{
				ActionModule.click(driver, MyVehiclesPage.selectDealer(driver), "selectDealer", "MyVehiclesPage");	

				}



			}

			Utils.waitForElementToBeClickable(driver,MaintenancePage.RequestAppointment.confirmDealerRequest(driver) );

			ActionModule.click(driver,MaintenancePage.RequestAppointment.confirmDealerRequest(driver), "selectDealer", "MyVehiclesPage");	

			Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.confirmationMesssage(driver));

			Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.request_Appointment_Ok_Button(driver));

			ActionModule.isDisplayed(driver,MaintenancePage.RequestAppointment.confirmationMesssage(driver), "selectDealer", "MyVehiclesPage");	

			ActionModule.click(driver, MaintenancePage.RequestAppointment.request_Appointment_Ok_Button(driver), "selectDealer", "MyVehiclesPage");






		}
		else
		{
			Log.info("Scheduler award has already been awrded");
			throw new SkipException("Scheduler award has already been awrded");
		}


	}

	/**
	 * To check Growing garage award
	 * @param driver
	 */
	public static void GrowingGarage(WebDriver driver)
	{


		ActionModule.isDisplayed(driver, AwardsPage.growingGarageText(driver), "schedulerText", "AwardsPage");

		awardsText=ActionModule.getText(driver, AwardsPage.growingGarageAward(driver), "", "");


		if(awardsText.contains("Earn the Growing Garage Award"))
		{
			Log.info("GrowingGarage awards has not been awarded yet..");
			ActionModule.click(driver, AwardsPage.backButtton(driver), "backButtton", "AwardsPage");

			Utils.waitForElementToBeClickable(driver, MyVehiclesPage.addVehicle(driver));

			//Adding another vehicle 
			String VIN = null;
			VIN = Utils.getParameterValueFromCsvFile("AwardsVIN1");
			Log.info("VIN is : "+VIN);


			ActionModule.click(driver, MyVehiclesPage.addVehicle(driver), "addVehicle", "Login Page");


			Utils.waitForElementToBeVisible(driver, MyVehiclesPage.AddVehicle.vinTextBox(driver));

			ActionModule.sendKeys(driver, MyVehiclesPage.AddVehicle.vinTextBox(driver), VIN,"vin text box", "My vehicle Page");

			ActionModule.click(driver, MyVehiclesPage.AddVehicle.addVehicleArrow(driver), "addVehicleArrow", "My vehicle Page");

			Utils.waitForElementToBeVisible(driver, MyVehiclesPage.AddVehicle.vehicleName(driver));
			Utils.sleep(driver, 3000);

			//If the vehicle with same VIn is already added
			if(Utils.waitForElementToBeVisible(driver, MyVehiclesPage.AddVehicle.alreadyAddedVINMsg(driver)))
			{
				Log.error("vehicle with this VIN is aleady added.");
				ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");
				Assert.fail("vehicle with this VIN is aleady added.");


			}

			//Fetching Vehicle name which has added successfully
			String nicknameAdded=ActionModule.getText(driver, MyVehiclesPage.AddVehicle.vehicleName(driver), "vehicleName", "My vehicle Page");
			Log.info("vehicle name added:"+nicknameAdded);

			ActionModule.click(driver, MyVehiclesPage.AddVehicle.closePopup(driver), "closePopup", "My vehicle Page");

			Utils.waitForElementToBeClickable(driver, MyVehiclesPage.addVehicle(driver));
			Utils.waitForElementToBeInvisible(driver, MyVehiclesPage.AddVehicle.closePopup(driver));

			ActionModule.isDisplayed(driver, MyVehiclesPage.AddVehicle.nicknameAddVehicle(driver, nicknameAdded), "nicknameAddVehicle", "My vehicle Page");

			Utils.waitForProgressbarInvisible(driver);
			Utils.sleep(driver,5000);


			/**
			 *Element were not clickable after closing add vehicle pop up.
			This was the workaround to have the control back on the page as after first click page on any element page becomes responding.
			Now we are commenting it as its working fine.
			 */

			/*WebElement logOut=HeaderPage.logOutLink(driver);
			if(logOut!=null && Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver)))
			{
				ActionModule.click(driver, HeaderPage.logOutLink(driver), "logout Button", "Login Page");
			}*/

		}
		else
		{
			Log.info("GrowingGarage award has already been awrded");
			throw new SkipException("GrowingGarage award has already been awrded");

		}

	}
	/**
	 * To check whether the award is shown after performing required conditions
	 * @param driver
	 * @param methodName
	 */
	public static void checkAwardsWon(WebDriver driver,String methodName)
	{

		WebElement element=null;

		ActionModule.click(driver, HeaderPage.awardsLink(driver), "awardsLink", "HeaderPage");

		Utils.waitForElementToBeClickable(driver, AwardsPage.backButtton(driver));

		Utils.waitForElementToBeVisible(driver, AwardsPage.awardsText(driver));

		Utils.sleep(driver, 3000);

		Log.info("Successfully navigated to awards Page");

		//Fetching text based on method name/Award category
		if(methodName.contains("GettingIntersetedAward"))
		{
			element=AwardsPage.gettingInterestedAward(driver);
		}
		else if(methodName.contains("PoweUserAward"))
		{
			element=AwardsPage.powerUserAward(driver);
		}
		else if(methodName.contains("GrowingGarageAward"))
		{
			element=AwardsPage.growingGarageAward(driver);
		}
		else if(methodName.contains("TravellerAward"))
		{
			element=AwardsPage.travelerAward(driver);
		}
		else if(methodName.contains("SchedulerAward"))
		{
			element=AwardsPage.schedulerAwards(driver);
		}

		else
		{
			Log.info("Not applicable for test case");
		}

		ActionModule.isDisplayed(driver, element, "awards text", "AwardsPage");

		awardsText=ActionModule.getText(driver, element, "", "");

		if(awardsText.contains("You won this award"))
		{
			Log.info("awards won");
		}
		else
		{
			Log.error("Award could not be  won sccessfully ");

			ActionModule.click(driver,AwardsPage.backButtton(driver), "back button", "HeaderPage");

			Assert.fail("Award could not be  won sccessfully ");


		}

		ActionModule.click(driver,AwardsPage.backButtton(driver), "back button", "HeaderPage");
	}


	/**
	 * To check Power User award by login to the account 10 times
	 * @param driver
	 */
	public static void PoweUserAward(WebDriver driver) {


		ActionModule.isDisplayed(driver, AwardsPage.powerUserAwardText(driver), "power user", "AwardsPage");

		awardsText=ActionModule.getText(driver, AwardsPage.powerUserAward(driver), "powerUserAward", "AwardsPage");


		if(awardsText.contains("Earn the Power User Award"))
		{


			Log.info("Power User award has not been awarded yet..");

			ActionModule.click(driver, AwardsPage.backButtton(driver), "awardsLink", "HeaderPage");

			Utils.waitForElementToBeClickable(driver, MyVehiclesPage.addVehicle(driver));

			Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver));

			ActionModule.click(driver, HeaderPage.logOutLink(driver), "logOutLink", "OverviewPage");

			for(int i=0; i < 10; i++)
			{
				Log.info("Login attempt:"+ (i+2));

				MyVehicleModule.NavigateToVehiclePage(driver);
			}


		}

		else
		{
			Log.info("PoweUser award has already been awrded");
			throw new SkipException("PoweUser award has already been awrded");

		}

	}

	/**
	 * To check getting interested award by adding a POI.
	 * @param driver
	 */
	public static void GettingIntersetedAward(WebDriver driver)
	{


		ActionModule.isDisplayed(driver, AwardsPage.gettingInterestedText(driver), "schedulerText", "AwardsPage");

		awardsText=ActionModule.getText(driver, AwardsPage.gettingInterestedAward(driver), "", "");


		if(awardsText.contains("Earn the Getting Interested Award"))
		{
			ActionModule.click(driver, AwardsPage.backButtton(driver), "backButtton", "AwardsPage");

			Utils.waitForElementToBeClickable(driver, MyVehiclesPage.addVehicle(driver));

			Utils.waitForElementToBeClickable(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()));
			ActionModule.click(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()), "backButtton", "AwardsPage");


			Utils.chooseDealer(driver);

			Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.nicknameOfVehicle(driver));

			Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.myPOILink(driver));

			//adding POI
			ActionModule.click(driver,MyCarLeftMenu.myPOILink(driver) , "backButtton", "AwardsPage");

			Utils.waitForElementToBeClickable(driver,  MyPOIsPage.addPOI(driver));

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.addPOI(driver), "addPOI", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.searchTextField(driver), "92606", "add pois", "MyPOIsPage");


			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.search(driver), "search", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.addButton(driver), "addButton", "MyPOIsPage");

			Utils.waitForElementToBeClickable(driver,MyPOIsPage.AddPOIs.done(driver));

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "POIs_Close_Button", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.addPOI(driver));


		}

		else
		{
			Log.info("Getting Interested Award award has already been awrded");
			throw new SkipException("GrowingGarage award has already been awrded");

		}

	}

	/**
	 * To check Traveller award by adding 10 POI.
	 * @param driver
	 */
	public static void TravellerAward(WebDriver driver)
	{


		ActionModule.isDisplayed(driver, AwardsPage.travelerAward(driver), "travelerAward", "AwardsPage");

		awardsText=ActionModule.getText(driver, AwardsPage.travelerAward(driver), "travelerAward", "AwardsPage");


		if(awardsText.contains("Earn the Traveler Award"))
		{
			ActionModule.click(driver, AwardsPage.backButtton(driver), "backButtton", "AwardsPage");

			Utils.waitForElementToBeClickable(driver, MyVehiclesPage.addVehicle(driver));

			Utils.waitForElementToBeClickable(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()));
			ActionModule.click(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()), "nickname", "AwardsPage");

			Utils.chooseDealer(driver);

			Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.nicknameOfVehicle(driver));

			Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.myPOILink(driver));

			ActionModule.click(driver,MyCarLeftMenu.myPOILink(driver) , "myPOILink", "AwardsPage");

			Utils.waitForElementToBeClickable(driver,  MyPOIsPage.addPOI(driver));

			Utils.sleep(driver, 3000);

			//deleting already added POi

			List <WebElement> pois=null;
			pois=FindWebElement.findElementListByXpath(driver, "//div[contains(@ng-show,'showPoiList') and contains(@class,'poi-container')]//div[contains(@class,'poi-row')]", "added pois", "awards");

			int poiAdded=pois.size();

			if(poiAdded>0)
			{
				MyPoiModule.deleteAll(driver);
			}
			else
			{
				Log.info("no pois added");
			}


			Utils.sleep(driver, 4000);

			//looping to add 10 pois 
			for(int i=0;i < 10;i++)
			{

				ActionModule.click(driver, MyPOIsPage.addPOI(driver), "addPOI", "MyPOIsPage");

				Utils.sleep(driver, 3000);

				ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.searchTextField(driver), "92606", "add pois", "MyPOIsPage");


				Utils.sleep(driver, 3000);

				ActionModule.click(driver, MyPOIsPage.AddPOIs.search(driver), "search", "MyPOIsPage");

				Utils.sleep(driver, 3000);

				ActionModule.click(driver, MyPOIsPage.AddPOIs.addButton(driver), "addButton", "MyPOIsPage");

				Utils.waitForElementToBeClickable(driver,MyPOIsPage.AddPOIs.done(driver));

				Utils.sleep(driver, 3000);

				ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "POIs_Close_Button", "MyPOIsPage");

				Utils.sleep(driver, 3000);

				Utils.waitForElementToBeClickable(driver, MyPOIsPage.addPOI(driver));
			}
		}



		else
		{
			Log.info("Traveller award has already been awrded");
			throw new SkipException("Traveller award has already been awrded");

		}	
	}


	/**
	 * To check About Awards .It shows all the description related to awards.
	 * @param driver
	 */
	public static void checkAwards(WebDriver driver)
	{
		Utils.waitForElementToBeClickable(driver, AwardsPage.helpButton(driver));



		ActionModule.click(driver, AwardsPage.helpButton(driver), "helpButton", "MyPOIsPage");

		Utils.sleep(driver, 5000);

		Utils.waitForElementToBeClickable(driver, AwardsPage.SchedulerAwardHelp(driver));

		ActionModule.isDisplayed(driver,AwardsPage.efficientAwardHelp(driver) , "efficientAwardHelp", "");
		ActionModule.isDisplayed(driver,AwardsPage.efficientAwardTextHelp(driver) , "efficientAwardTextHelp", "");

		ActionModule.isDisplayed(driver,AwardsPage.SchedulerAwardHelp(driver) , "SchedulerAwardHelp", "");
		ActionModule.isDisplayed(driver,AwardsPage.SchedulerAwardTextHelp(driver) , "SchedulerAwardTextHelp", "");


		ActionModule.isDisplayed(driver,AwardsPage.travellerHelp(driver) , "travellerHelp", "");
		ActionModule.isDisplayed(driver,AwardsPage.travellerTextHelp(driver) , "travellerTextHelp", "");

		ActionModule.isDisplayed(driver,AwardsPage.powerUserHelp(driver) , "powerUserHelp", "");
		ActionModule.isDisplayed(driver,AwardsPage.powerUserTextHelp(driver) , "powerUserTextHelp", "");

		ActionModule.isDisplayed(driver,AwardsPage.gettingIneterestedHelp(driver) , "gettingIneterestedHelp", "");
		ActionModule.isDisplayed(driver,AwardsPage.gettingIneterestedTextHelp(driver) , "gettingIneterestedTextHelp", "");

		ActionModule.isDisplayed(driver,AwardsPage.growingGarageHelp(driver) , "growingGarageHelp", "");
		ActionModule.isDisplayed(driver,AwardsPage.growingGarageTextHelp(driver) , "growingGarageTextHelp", "");

		ActionModule.isDisplayed(driver,AwardsPage.efficiencyKingTextHelp(driver) , "efficiencyKingTextHelp", "");
		ActionModule.isDisplayed(driver,AwardsPage.efficiencykingHelp(driver)  , "efficiencykingHelp", "");

		ActionModule.isDisplayed(driver,AwardsPage.efficiencyLeaderHelp(driver), "efficiencyLeaderHelp", "");
		ActionModule.isDisplayed(driver,AwardsPage.efficiencyLeaderTextHelp(driver), "efficiencyLeaderTextHelp", "");

		ActionModule.click(driver, AwardsPage.closehelp(driver), "closehelp", "");

		Utils.waitForElementToBeInvisible(driver, AwardsPage.closehelp(driver));
		ActionModule.click(driver, AwardsPage.backButtton(driver), "backButtton", "MyPOIsPage");

	}



}
