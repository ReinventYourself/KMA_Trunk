package com.rsi.kma.automation.modules;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;

import com.rsi.kma.automation.pageObjects.BatteryPage;
import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.pageObjects.Common.OverviewPage;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.EMail;
import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Utils;

public class BatteryModule {

	private static Logger    Log = Logger.getLogger(BatteryModule.class.getName());
	static int  selectedDays[]=new int[7];
	static int  selectedDaysII[]=new int[7];
	static String schedulestatus=null;
	static String status=null;

	public static void NavigateToBatterypage(WebDriver driver)
	{

		OverviewModule.NavigateToOverviewPage(driver);
		Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.battery_Link(driver));
		ActionModule.click(driver,MyCarLeftMenu.battery_Link(driver), "Battery link", "Overview page");

		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		
		ActionModule.click(driver, HeaderPage.refresh_Button(driver), "refresh_Button", "HeaderPage");

		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));
		
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));


		Utils.waitForElementToBeClickable(driver, BatteryPage.chargingStationBox(driver));
		
		Log.info("Succesfully navigated to Battery Page");

	}

	/**
	 * checking start stop charge JF PHEV/ DE PHEV/ EV 2.0
	 */
	public static void startStopCharge(WebDriver driver)
	{

		Utils.waitForElementToBeVisible(driver, BatteryPage.batteryStatus(driver));
		Utils.waitForProgressbarInvisible(driver);
		status=ActionModule.getText(driver,BatteryPage.batteryStatus(driver) , "battery status", "battery page");
		String percentage=ActionModule.getText(driver, BatteryPage.batteryPercentage(driver), "batteryPercentage", "BatteryPage");

		//checking whether the page is not showing any Error on the page.
		if(Utils.waitForElementToBeVisible(driver, BatteryPage.batteryChargingError(driver)))
		{
			Log.error("battery Commnads are not working");
			Assert.fail("battery Commnads are not working");
		}

		if(status.equalsIgnoreCase("Battery is unplugged"))
		{
			Log.info("Charging could not be started as the battery is Unplugged");
			throw new SkipException("Charging could not be started as the battery is Unplugged");
		}


		else if(status.equalsIgnoreCase("Battery is plugged in") && !percentage.contains("100"))
		{

			if(Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver)))
			{
				Utils.sleep(driver, 2000);

				startCharge(driver,status);
				
				Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.battery_Link(driver));
				
				ActionModule.click(driver,MyCarLeftMenu.battery_Link(driver), "battery_Link", "MyCarLeftMenu");
				
				ActionModule.click(driver, HeaderPage.refresh_Button(driver), "refresh_Button", "HeaderPage");

				Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));
				
				Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));

				Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));


				Log.info("waiting for 2 mins between Remote commands ");
				Utils.sleep(driver, 120000);

				stopCharge(driver);


			}
		}
		else
		{
			Log.info("Battery might be charged fully or the battery is already charging");
			throw new SkipException("Battery might be charged fully or the battery is already charging");
		}

	}



	/**
	 * To start charge and checking header notifications 
	 */
	public static void startCharge(WebDriver driver,String status)
	{
		ActionModule.click(driver, BatteryPage.startChargingButton(driver), "stop charge ", "battery page");
		Utils.waitForElementToBeInvisible(driver,BatteryPage.sendingChargeRequest(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		Utils.waitForElementToBeClickable(driver, BatteryPage.stopChargingButton(driver));
		Utils.sleep(driver, 2000);
		status=ActionModule.getText(driver,BatteryPage.batteryStatus(driver) , "battery status", "battery page");

		if(status.contains("Battery is charging"))
		{
			Log.info("battery is charging ");
			checkStartChargeNotifications(driver);

		}

		else
		{
			if(Utils.waitForElementToBeVisible(driver, BatteryPage.systemError(driver)))
			{
				Log.error("Battery Commands are not working ");
				Reporter.log("Battery Commands are not working ");
				Assert.fail("Battery Commands are not working ");
			}
			else
			{
				Log.error("Please refer Screeenshots ");
				Reporter.log("Please refer Screeenshots ");
				Assert.fail("Please refer Screeenshots ");
			}
		}


	}


	/**
	 * To check start charge header notifications 
	 */
	public static void checkStartChargeNotifications(WebDriver driver)
	{

		String timestamp=ActionModule.getText(driver,OverviewPage.VehicleSelector.updatedTimestamp(driver), "updatedTimestamp", "OverviewPage");
		timestamp=timestamp.substring(timestamp.length()-8, timestamp.length());
		Log.info("timestamp  is"+timestamp);
		Utils.sleep(driver, 3000);

		ActionModule.click(driver, HeaderPage.notifications_Link(driver), "notifications_Link", "HeaderPage");

		Utils.sleep(driver, 2000);
		ActionModule.isDisplayed(driver,BatteryPage.vehicleChargeNotification(driver), "vehicleChargeNotification", "BatteryPage");

		Utils.sleep(driver, 2000);
		ActionModule.click(driver, HeaderPage.settingsLink(driver), "settingsLink", "HeaderPage");

		Utils.sleep(driver, 2000);
		ActionModule.click(driver, HeaderPage.commandLogLink(driver), "commandLogLink", "HeaderPage");

		ActionModule.isDisplayed(driver, HeaderPage.batteryCommandLog(driver), "batteryCommandLog", "HeaderPage");

		String statusCommand=HeaderPage.batteryCommandLog(driver).getAttribute("class");
		if(statusCommand.contains("green"))
		{
			Log.info("commnad found for battery charge");
			String commandTme=ActionModule.getText(driver,HeaderPage.batteryCommandLogTimestamp(driver) , "batteryCommandLogTimestamp", "HeaderPage");
			commandTme=commandTme.substring(commandTme.length()-10, commandTme.length());
			Log.info("command time is"+commandTme);
			if(commandTme.contains(timestamp))
			{
				Log.info("Timestamp matches for command log");
			}
			else
			{
				Log.error("Timestamp not matched");

				Assert.fail("Timestamp not matched");
			}

		}
		else
		{
			Log.error("Command not found or commnad failed ");
			Assert.fail("Command not found or commnad failed ");
		}



	}

	/**
	 * To stop charge and checking header notifications 
	 */
	public static void stopCharge(WebDriver driver )
	{


		Utils.waitForElementToBeVisible(driver, BatteryPage.batteryStatus(driver));
		ActionModule.click(driver, BatteryPage.stopChargingButton(driver), "stop charge ", "battery page");
		Utils.waitForElementToBeInvisible(driver,BatteryPage.requestPending(driver));
		Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));


		status=ActionModule.getText(driver,BatteryPage.batteryStatus(driver) , "battery status", "battery page");

		if(status.contains("Battery is plugged in"))
		{
			Log.info("battery has stopped charging ");

			checkStopChargeNotifications(driver);

		}
		else
		{
			Log.error("Battery Commands are not working ");
			Assert.fail("Battery Commands are not working ");
		}
	}


	/**
	 * To check stop charge header notifications and mail verifications
	 */
	public static void checkStopChargeNotifications(WebDriver driver)
	{

		String email=Utils.getUserName();
		String emailPassword=Utils.getGmailPassword();

		String timestamp=ActionModule.getText(driver,OverviewPage.VehicleSelector.updatedTimestamp(driver), "updatedTimestamp", "OverviewPage");
		timestamp=timestamp.substring(timestamp.length()-8, timestamp.length());
		ActionModule.click(driver, HeaderPage.notifications_Link(driver), "notifications_Link", "HeaderPage");

		Utils.sleep(driver, 2000);
		ActionModule.isDisplayed(driver,BatteryPage.vehicleStopChargeNotification(driver), "vehicle stop ChargeNotification", "BatteryPage");

		Utils.sleep(driver, 2000);
		ActionModule.click(driver, HeaderPage.settingsLink(driver), "settingsLink", "HeaderPage");

		Utils.sleep(driver, 2000);
		ActionModule.click(driver, HeaderPage.commandLogLink(driver), "commandLogLink", "HeaderPage");

		Utils.sleep(driver, 2000);
		ActionModule.isDisplayed(driver, HeaderPage.batteryCommandLog(driver), "batteryCommandLog", "HeaderPage");

		String statusCommand=HeaderPage.batteryCommandLog(driver).getAttribute("class");
		//checking if command is successful or not
		if(statusCommand.contains("green"))
		{
			Log.info("commanad found for battery charge");
			Utils.sleep(driver, 5000);
			String commandTme=ActionModule.getText(driver,HeaderPage.batteryStopCommandLogTimestamp(driver) , "batteryCommandLogTimestamp", "HeaderPage");
			commandTme=commandTme.substring(commandTme.length()-8, commandTme.length());
			if(commandTme.equalsIgnoreCase(timestamp))
			{
				Log.info("Timestamp matches for command log");
			}
			else
			{
				Assert.fail("Timestamp not matched");
			}
			if (EMail.execute("Stop Charge Request!", email, emailPassword,
					true)) {
				Log.info("Successful stop charge mail has been received by user at "
						+ email);
			}
			else {
				Log.error("Stop Charge Request has not been received by user at "
						+ email);            
				Reporter.log("Stop Charge Request has not been received by user at "
						+ email);
				Assert.fail("Stop Charge Request has not been received by user at "
						+ email);
			}


		}
		else
		{
			Log.error("Command not found or commnad failed ");
			Assert.fail("Command not found or commnad failed ");
		}
	}


	/**
	 * checking start/stop charge EV 1.0
	 */
	public static void startStopChargeEV1(WebDriver driver)
	{


		String email=Utils.getUserName();
		String emailPassword=Utils.getGmailPassword();
		if(Utils.waitForElementToBeVisible(driver, BatteryPage.batteryPluggedEV1(driver)))
		{
			Log.info("Battery is plugged In");

			/**
			 * Starting battery charge 
			 */
			if(Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButtonEV1(driver)))
			{
			ActionModule.click(driver, BatteryPage.startChargingButtonEV1(driver), "start charging button", "battery page");
			Utils.waitForProgressbarInvisible(driver);
			Utils.waitForElementToBeInvisible(driver, BatteryPage.sendingChargeRequest(driver));
			Utils.waitForElementToBeClickable(driver, BatteryPage.stopChargingButtonEV1(driver));

			if(Utils.waitForElementToBeVisible(driver, BatteryPage.batteryChargingError(driver)))
			{
				Log.error("Command failed ");
				Assert.fail("Command failed ");
			}

			ActionModule.isDisplayed(driver, BatteryPage.batteryIsChargingTextEV1(driver), "bateryIsChargingTextEV1", "battery page");
			ActionModule.isDisplayed(driver, BatteryPage.stopChargingButtonEV1(driver), "stopChargingButtonEV1", "battery page");
			Log.info("Battery is charging Now.");


			/**
			 * Stopping battery charge 
			 */
			ActionModule.click(driver, BatteryPage.stopChargingButtonEV1(driver), "stop charging button", "battery page");

			Utils.waitForProgressbarInvisible(driver);
			Utils.waitForElementToBeInvisible(driver, BatteryPage.sendingChargeRequest(driver));
			Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButtonEV1(driver));

			ActionModule.isDisplayed(driver, BatteryPage.batteryPluggedEV1(driver), "batteryPluggedEV1", "battery page");
			ActionModule.isDisplayed(driver, BatteryPage.startChargingButtonEV1(driver), "start ChargingButtonEV1", "battery page");
			Log.info("Battery is Plugged in Now.");

			/**
			 * checking mails for battery commands 
			 */
			if (EMail.execute("Vehicle Stopped Charging!", email, emailPassword,
					true)) {
				Log.info("Vehicle Stopped Charging has been received by user at "
						+ email);
			}
			else {
				Log.error("Vehicle Stopped Charging has not been received by user at "
						+ email);            
				Reporter.log("Vehicle Stopped Charging has not been received by user at "
						+ email);
				Assert.fail("Vehicle Stopped Charging has not been received by user at "
						+ email);
			}

		}
		else
		{
			Log.info("Precondition Not met ");
			Reporter.log("Precondition Not met ");
			throw new SkipException("Precondition Not met ");
		}
		}
		
		else
		{

			Log.info("Precondition Not met.Battery is 100% charged ");
			Reporter.log("Precondition Not met.Battery is 100% charged ");
			throw new SkipException("Precondition Not met.Battery is 100% charged ");
		}
	}



	public static void chargingSchedule(WebDriver driver)
	{

		Utils.scrolDownForElement(driver, BatteryPage.OnOffToggle(driver));
		Utils.sleep(driver, 3000);
		String schedulestatus=ActionModule.getText(driver, BatteryPage.OnOffToggle(driver), "OnOffToggle", "Battery Page");

		/**
		 * changing schedule from On TO OFF 
		 */
		if(schedulestatus.contains("ON"))
		{

			changeScheduleOn(driver,schedulestatus);
		}

		/**
		 * changing schedule from OFF TO ON 
		 */
		else
		{
			Log.info("Charging schedule is OFF ");

			changeScheduleOff(driver,schedulestatus);
		}

	}


	public static void changeScheduleOn(WebDriver driver,String schedulestatus)
	{

		Log.info("Charging schedule is ON ");
		changeTime(driver,schedulestatus);
		Utils.scrolDownForElement(driver, BatteryPage.cancelChangesButton(driver));

		ActionModule.click(driver, BatteryPage.cancelChangesButton(driver), "cancel", "Battery Schedule");

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));
		Utils.sleep(driver, 3000);

		schedulestatus=ActionModule.getText(driver, BatteryPage.OnOffToggle(driver), "OnOffToggle", "Battery Page");
		if(schedulestatus.contains("ON"))
		{
			Log.info("Schedule is still ON ");
		}

		else
		{
			Log.error("Some error occured.");
			Reporter.log("Some error occured.");
			Assert.fail("Some error occured.");
		}
		changeTime(driver,schedulestatus);

		ActionModule.click(driver, BatteryPage.setScheduleButton(driver), "set schedule", "Battery Schedule");

		Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		Utils.sleep(driver, 3000);

		schedulestatus=ActionModule.getText(driver, BatteryPage.OnOffToggle(driver), "OnOffToggle", "Battery Page");

		if(schedulestatus.contains("OFF"))
		{
			Log.info("Now Schedule is OFF");
		}
		else
		{
			Log.error("Schedule status could not be changed");
			Reporter.log("Schedule status could not be changed");
			Assert.fail("Schedule status could not be changed");
		}

	}


	public static void changeScheduleOff(WebDriver driver,String schedulestatus)
	{
		changeTime(driver,schedulestatus);

		ActionModule.click(driver, BatteryPage.cancelChangesButton(driver), "cancel", "Battery Schedule");

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));

		changeTime(driver,schedulestatus);
		ActionModule.click(driver, BatteryPage.setScheduleButton(driver), "set schedule", "Battery Schedule");

		Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		Utils.sleep(driver, 3000);
		schedulestatus=ActionModule.getText(driver, BatteryPage.OnOffToggle(driver), "OnOffToggle", "Battery Page");

		if(schedulestatus.contains("ON"))
		{
			Log.info("Now Schedule is ON");
		}
		else
		{
			Log.error("Schedule status could not be changed");
			Reporter.log("Schedule status could not be changed");
			Assert.fail("Schedule status could not be changed");
		}
	}

	/**
	 * 
	 * @param driver
	 * @param status
	 * Module to change days and hour for schedule 
	 */
	public static void changeTime(WebDriver driver,String status)
	{
		String incrementedHour=null;
		String incrementedMin=null;

		Utils.scrolDownForElement(driver, BatteryPage.OnOffToggle(driver));
		ActionModule.click(driver, BatteryPage.OnOffToggle(driver), "Toggle ", "Battery schedule");
		if(status.equalsIgnoreCase("OFF"))
		{
			ActionModule.click(driver, BatteryPage.StartSchedulehour(driver), "Hours", "Battery Schedule");
			String hour=ActionModule.getText(driver, BatteryPage.StartSchedulehour(driver), "new hours schedule", "Battery Schedule");
			//Minimum value for Hour is 1
			int newhour=1;

			if(hour.contains("--"))
			{
				hour="01";
			}


			//Re-Assigning 1 as hour  if hour exceeds by 12 and also converting hour to 2-digit number by adding 0 .
			if(Integer.parseInt(hour)< 12)
			{
				newhour=Integer.parseInt(hour)+1;
				if(newhour<10)	
				{
					incrementedHour = "0"+Integer.toString(newhour);
				}
				else
				{
					incrementedHour=Integer.toString(newhour);
				}
			}
			else if(Integer.parseInt(hour)==  12)

			{
				incrementedHour="01";
			}
			else
			{
				Log.info("hour time exceeds the limit");
			}



			ActionModule.click(driver, BatteryPage.StartScheduleNewhour(driver, incrementedHour), "new hours schedule", "Battery Schedule");

			Utils.sleep(driver, 2000);
			ActionModule.click(driver, BatteryPage.minSchedule(driver), "min", "Battery Schedule");

			String min=ActionModule.getText(driver, BatteryPage.minSchedule(driver), "new hours schedule", "Battery Schedule");

			int newMin=0;

			if(min.contains("--"))
			{
				min="10";
			}

			//Re-Assigning 00 as minute , if min exceeds by 50 
			if(Integer.parseInt(min) <50)
			{
				newMin=Integer.parseInt(min)+10;
				incrementedMin = Integer.toString(newMin);

			}
			else if(Integer.parseInt(min)==  50)

			{

				incrementedMin="00";
			}
			else
			{
				Log.info("Min time exceeds the limit");
			}

			ActionModule.click(driver, BatteryPage.newMinSchedule(driver, incrementedMin), "new mins schedule", "Battery Schedule");	

			ActionModule.click(driver, BatteryPage.sunday(driver), "Sunday", "Battery Schedule");

			ActionModule.click(driver, BatteryPage.monday(driver), "Monday", "Battery Schedule");

			ActionModule.click(driver, BatteryPage.tuesday(driver), "Tuesday", "Battery Schedule");

			ActionModule.click(driver, BatteryPage.wednesday(driver), "Wednesday", "Battery Schedule");

			ActionModule.click(driver, BatteryPage.thursday(driver), "Thursday", "Battery Schedule");

			ActionModule.click(driver, BatteryPage.friday(driver), "Friday", "Battery Schedule");

			ActionModule.click(driver, BatteryPage.saturday(driver), "Saturday", "Battery Schedule");


			ActionModule.click(driver, BatteryPage.startAMPM(driver), "startAMPM", "Battery Schedule");	
			ActionModule.click(driver, BatteryPage.startNewAMPM(driver), "startNewAMPM", "Battery Schedule");	



			if(Utils.waitForElementToBeClickable(driver, BatteryPage.stopScheduleToggleON(driver)) && Utils.waitForElementToBeClickable(driver, BatteryPage.setTimeToggleOFF(driver)))
			{
				Log.info("at 100%");
				ActionModule.click(driver, BatteryPage.setTimeToggleOFF(driver), "setTimeToggleOFF", "Battery Schedule");

				ActionModule.click(driver, BatteryPage.setStopChargeTimeHour(driver), "setStopChargeTimeHour", "Battery Schedule");
				Utils.sleep(driver, 1000);
				ActionModule.click(driver, BatteryPage.setStopChargeTimeNewHour(driver), "setStopChargeTimeNewHour", "Battery Schedule");

				ActionModule.click(driver, BatteryPage.setStopChargeTimeMin(driver), "setStopChargeTimeMin", "Battery Schedule");
				Utils.sleep(driver, 1000);
				ActionModule.click(driver, BatteryPage.setStopChargeTimeNewMin(driver), "setStopChargeTimeNewMin", "Battery Schedule");

				ActionModule.click(driver, BatteryPage.setStopChargeTimeAMPM(driver), "setStopChargeTimeAMPM", "Battery Schedule");
				Utils.sleep(driver, 1000);
				ActionModule.click(driver, BatteryPage.setStopChargeTimeNewAMPM(driver), "setStopChargeTimeNewAMPM", "Battery Schedule");

			}
			else
			{
				Log.info("At set time");
				ActionModule.click(driver, BatteryPage.stopScheduleToggleOFF(driver), "setTimeToggleOFF", "Battery Schedule");
			}
		}

		else
		{
			Utils.sleep(driver, 3000);
			String schedulestatus=ActionModule.getText(driver, BatteryPage.OnOffToggle(driver), "OnOffToggle", "Battery Page");
			if(schedulestatus.contains("OFF"))
			{
				Log.info("charging schedule turning OFF");

			}
			else
			{
				Log.error("Charging schedule could not be Changed");
				Assert.fail("Charging schedule could not be Changed");
			}
		}

	}



	public static void chargingScheduleIEV1(WebDriver driver)
	{
		String email=Utils.getUserName();
		String emailPassword="Kiatest1";

		Utils.scrolDownForElement(driver, BatteryPage.batteryScheduleIEV1(driver));
		ActionModule.click(driver, BatteryPage.batteryScheduleIEV1(driver), "scheduleItoggleEV1", "Batterypage");
		Utils.sleep(driver, 3000);

		String schedulestatus=ActionModule.getText(driver, BatteryPage.scheduleItoggleEV1(driver), "OnOffToggle", "Battery Page");
		if(schedulestatus.equalsIgnoreCase("off"))
		{
			Log.info("Schedule Status is OFF.");

			/**
			 * To turn the schedule from OFF to ON 
			 */
			chargingScheduleIEV1ON(driver);

			schedulestatus=ActionModule.getText(driver, BatteryPage.scheduleItoggleEV1(driver), "OnOffToggle", "Battery Page");

			//verifying schedule status and mail 
			if(schedulestatus.contains("ON"))
			{
				Log.info("Now Schedule is ON");
				Utils.sleep(driver, 5000);
				if (EMail.execute("Charging Schedule Created!", email, emailPassword,
						true)) {
					Log.info("Charging Schedule Created! has been received by user at "
							+ email);
				}
				else {
					Log.error("Charging Schedule Created! has not been received by user at "
							+ email);            
					Reporter.log("Charging Schedule Created! has not been received by user at "
							+ email);
					Assert.fail("Charging Schedule Created! has not been received by user at "
							+ email);
				}

			}
			else
			{
				Log.error("Schedule status could not be changed");
				Reporter.log("Schedule status could not be changed");
				Assert.fail("Schedule status could not be changed");
			}


		}
		else
		{
			Log.info("Schedule Status is ON");

			chargingScheduleIEV1OFF(driver);

			schedulestatus=ActionModule.getText(driver, BatteryPage.scheduleItoggleEV1(driver), "OnOffToggle", "Battery Page");

			if(schedulestatus.contains("OFF"))
			{
				Log.info("Now Schedule is OFF");
				Utils.sleep(driver, 5000);
				if (EMail.execute("Charging Schedule Created!", email, emailPassword,
						true)) {
					Log.info("Charging Schedule Created! has been received by user at "
							+ email);
				}
				else {
					Log.error("Charging Schedule Created! has not been received by user at "
							+ email);            
					Reporter.log("Charging Schedule Created! has not been received by user at "
							+ email);
					Assert.fail("Charging Schedule Created! has not been received by user at "
							+ email);
				}

			}
			else
			{
				Log.error("Schedule status could not be changed");
				Reporter.log("Schedule status could not be changed");
				Assert.fail("Schedule status could not be changed");
			}
		}

	}

	/**
	 * To change schedule from OFF to ON 
	 * @param driver
	 */
	public static void chargingScheduleIEV1ON(WebDriver driver)
	{
		Utils.scrolDownForElement(driver, BatteryPage.sunIEV1(driver));
		changeTimeEV1(driver,schedulestatus);

		ActionModule.click(driver, BatteryPage.cancelScheduleIEV1(driver), "cancelScheduleIEV1", "Batterypage");
		Utils.sleep(driver, 6000);
		Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));
		Utils.sleep(driver, 3000);
		
		Utils.waitForElementToBeClickable(driver, BatteryPage.batteryScheduleIEV1(driver));
		Utils.waitForElementToBeClickable(driver, BatteryPage.batteryScheduleIEV1(driver));
		
		String newSchedulestatus=ActionModule.getText(driver,BatteryPage.scheduleItoggleEV1(driver), "OnOffToggle", "Battery Page");
		if(newSchedulestatus.equalsIgnoreCase("off"))
		{
			Log.info("schedule is still off ");
		}
		else
		{
			Log.error("Schedule status could not be changed");
			Assert.fail("Schedule status could not be changed");
		}

		ActionModule.click(driver, BatteryPage.batteryScheduleIEV1(driver), "scheduleItoggleEV1", "Batterypage");
		Utils.scrolDownForElement(driver, BatteryPage.sunIEV1(driver));
		changeTimeEV1(driver,schedulestatus);
		ActionModule.click(driver, BatteryPage.setScheduleIEV1(driver), "setScheduleIEV1", "Batterypage");

		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		Utils.waitForElementToBeVisible(driver, BatteryPage.scheduleITime(driver));
		Utils.sleep(driver, 3000);
	}

	/**
	 * 
	 * To change scheduleI from ON to OFF for EV1
	 * @param driver
	 */
	public static void chargingScheduleIEV1OFF(WebDriver driver)
	{
		
		Utils.waitForElementToBeClickable(driver, BatteryPage.scheduleItoggleEV1(driver));
		ActionModule.click(driver, BatteryPage.scheduleItoggleEV1(driver), "scheduleItoggleEV1","Battery Page");

		ActionModule.click(driver, BatteryPage.cancelScheduleIEV1(driver), "cancelScheduleIEV1", "Batterypage");
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));

		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeClickable(driver, BatteryPage.batteryScheduleIEV1(driver));
		Utils.waitForElementToBeClickable(driver, BatteryPage.batteryScheduleIEV1(driver));
		
		
		String newSchedulestatus=ActionModule.getText(driver,BatteryPage.scheduleItoggleEV1(driver), "OnOffToggle", "Battery Page");

		if(newSchedulestatus.equalsIgnoreCase("on"))
		{
			Log.info("schedule is still on ");
		}
		else
		{
			Log.error("Schedule status could not be changed");
			Assert.fail("Schedule status could not be changed");
		}


		ActionModule.click(driver, BatteryPage.batteryScheduleIEV1(driver), "scheduleItoggleEV1", "Batterypage");
		ActionModule.click(driver, BatteryPage.scheduleItoggleEV1(driver), "scheduleItoggleEV1","Battery Page");
		ActionModule.click(driver, BatteryPage.setScheduleIEV1(driver), "setScheduleIEV1", "Batterypage");

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		Utils.waitForElementToBeVisible(driver, BatteryPage.scheduleITime(driver));

		Utils.sleep(driver, 3000);	
	}


	public static void chargingScheduleIIEV1(WebDriver driver)
	{

		String email=Utils.getUserName();
		String emailPassword="Kiatest1";

		Utils.scrolDownForElement(driver, BatteryPage.batteryScheduleIIEV1(driver));
		ActionModule.click(driver, BatteryPage.batteryScheduleIIEV1(driver), "scheduleItoggleEV1", "Batterypage");

		Utils.sleep(driver, 3000);
		String schedulestatus=ActionModule.getText(driver, BatteryPage.scheduleIItoggleEV1(driver), "OnOffToggle", "Battery Page");

		if(schedulestatus.equalsIgnoreCase("off"))
		{
			Log.info("Schedule Status is OFF.");

			chargingScheduleIIEV1ON(driver);

			schedulestatus=ActionModule.getText(driver, BatteryPage.scheduleIItoggleEV1(driver), "OnOffToggle", "Battery Page");

			if(schedulestatus.contains("ON"))
			{
				Log.info("Now Schedule is ON");
				Utils.sleep(driver,5000);
				if (EMail.execute("Charging Schedule Created!", email, emailPassword,
						true)) {
					Log.info("Charging Schedule Created! has been received by user at "
							+ email);
				}
				else {
					Log.error("Charging Schedule Created! has not been received by user at "
							+ email);            
					Reporter.log("Charging Schedule Created! has not been received by user at "
							+ email);
					Assert.fail("Charging Schedule Created! has not been received by user at "
							+ email);
				}

			}
			else
			{
				Log.error("Schedule status could not be changed");
				Reporter.log("Schedule status could not be changed");
				Assert.fail("Schedule status could not be changed");
			}


		}
		else
		{
			Log.info("Schedule Status is ON");

			chargingScheduleIIEV1OFF(driver);

			schedulestatus=ActionModule.getText(driver, BatteryPage.scheduleIItoggleEV1(driver), "OnOffToggle", "Battery Page");

			if(schedulestatus.contains("OFF"))
			{
				Log.info("Now Schedule is OFF");
				Utils.sleep(driver,5000);
				if (EMail.execute("Charging Schedule Created!", email, emailPassword,
						true)) {
					Log.info("Charging Schedule Created! has been received by user at "
							+ email);
				}
				else {
					Log.error("Charging Schedule Created! has not been received by user at "
							+ email);            
					Reporter.log("Charging Schedule Created! has not been received by user at "
							+ email);
					Assert.fail("Charging Schedule Created! has not been received by user at "
							+ email);
				}


			}
			else
			{
				Log.error("Schedule status could not be changed");
				Reporter.log("Schedule status could not be changed");
				Assert.fail("Schedule status could not be changed");
			}
		}



	}


	/**
	 * 
	 * To change scheduleII from OFF to ON for EV1
	 * @param driver
	 */
	public static void chargingScheduleIIEV1ON(WebDriver driver)
	{
		Utils.scrolDownForElement(driver, BatteryPage.sunIIEV1(driver));
		changeTimeIIEV1(driver,schedulestatus);

		ActionModule.click(driver, BatteryPage.cancelScheduleIIEV1(driver), "cancelScheduleIEV1", "Batterypage");

		Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, BatteryPage.batteryScheduleIIEV1(driver));
		Utils.waitForElementToBeClickable(driver, BatteryPage.batteryScheduleIIEV1(driver));
		
		String newSchedulestatus=BatteryPage.scheduleIItoggleEV1(driver).getText();
		Log.info("status is :"+ newSchedulestatus);
		if(newSchedulestatus.contains("OFF"))
		{
			Log.info("schedule is still off ");
		}
		else
		{
			Log.error("Schedule status could not be changed");
			Assert.fail("Schedule status could not be changed");
		}

		ActionModule.click(driver, BatteryPage.batteryScheduleIIEV1(driver), "scheduleItoggleEV1", "Batterypage");
		Utils.scrolDownForElement(driver, BatteryPage.sunIIEV1(driver));
		changeTimeIIEV1(driver,schedulestatus);
		ActionModule.click(driver, BatteryPage.setScheduleIIEV1(driver), "setScheduleIEV1", "Batterypage");

		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		
		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		Utils.waitForElementToBeVisible(driver, BatteryPage.scheduleIITime(driver));
		Utils.sleep(driver, 3000);
	}


	/**
	 * To change scheduleI from ON to OFF for EV1
	 * @param driver
	 */
	public static void chargingScheduleIIEV1OFF(WebDriver driver)
	{
		Utils.sleep(driver, 3000);
		ActionModule.click(driver, BatteryPage.scheduleIItoggleEV1(driver), "scheduleItoggleEV1","Battery Page");

		ActionModule.click(driver, BatteryPage.cancelScheduleIIEV1(driver), "cancelScheduleIEV1", "Batterypage");

		Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, BatteryPage.batteryScheduleIIEV1(driver));
		Utils.waitForElementToBeClickable(driver, BatteryPage.batteryScheduleIIEV1(driver));
		
		String newSchedulestatus=BatteryPage.scheduleIItoggleEV1(driver).getText();
		Log.info("status is: "+newSchedulestatus);
		if(newSchedulestatus.equalsIgnoreCase("ON"))
		{
			Log.info("schedule is still on ");
		}
		else
		{
			Log.error("Schedule status could not be changed");
			Assert.fail("Schedule status could not be changed");
		}


		ActionModule.click(driver, BatteryPage.batteryScheduleIIEV1(driver), "scheduleItoggleEV1", "Batterypage");
		Utils.waitForElementToBeClickable(driver, BatteryPage.scheduleIItoggleEV1(driver));
		
		ActionModule.click(driver, BatteryPage.scheduleIItoggleEV1(driver), "scheduleItoggleEV1","Battery Page");
		ActionModule.click(driver, BatteryPage.setScheduleIIEV1(driver), "setScheduleIEV1", "Batterypage");

		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		Utils.waitForElementToBeVisible(driver, BatteryPage.scheduleIITime(driver));
		Utils.sleep(driver, 3000);
	}

	public static void changeTimeEV1(WebDriver driver,String scheduleStatus)
	{

		String incrementedHour=null;
		String incrementedMin=null;
		ActionModule.click(driver, BatteryPage.scheduleItoggleEV1(driver), "scheduleIItoggleEV1", "Batterypage");
		Utils.scrolDownForElement(driver, BatteryPage.scheduleItoggleEV1(driver));
		if(Utils.waitForElementToBeVisible(driver, BatteryPage.eightyPercentageChargeOFF(driver)))
		{
			ActionModule.click(driver, BatteryPage.eightyPercentageChargeOFF(driver), "eightyPercentageChargeOFFII ", "Batterypage");

		}
		else
		{
			ActionModule.click(driver, BatteryPage.hundredPercentageCharge(driver), "hundredPercentageChargeII", "Batterypage");
		}

		ActionModule.click(driver, BatteryPage.scheduleIhourEV1(driver), "scheduleIIhourEV1", "Batterypage");
		String hour=ActionModule.getText(driver, BatteryPage.scheduleIhourEV1(driver), "scheduleIIhourEV1", "Battery Schedule");
		if(hour.contains("--"))
		{
			hour="10";
		}

		int newhour=1;
		if(Integer.parseInt(hour)< 12)
		{
			newhour=Integer.parseInt(hour)+1;
			if(newhour<10)	
			{
				incrementedHour = "0"+Integer.toString(newhour);
			}
			else
			{
				incrementedHour=Integer.toString(newhour);
			}

		}
		else if(Integer.parseInt(hour)==  12)

		{
			incrementedHour="01";
		}
		else
		{
			Log.info("hour time exceeds the limit");
		}

		//Utils.waitForElementToBeClickable(driver, BatteryPage.scheduleIIhourEV1(driver));
		
		ActionModule.click(driver, BatteryPage.scheduleISetNewHourEV1(driver, incrementedHour), "scheduleIISetNewHourEV1", "Battery Schedule");


		Utils.sleep(driver, 2000);
		ActionModule.click(driver, BatteryPage.scheduleIminEV1(driver), "scheduleIIminEV1", "Battery Schedule");
		String min=ActionModule.getText(driver, BatteryPage.scheduleIminEV1(driver), "scheduleIIminEV1", "Battery Schedule");
		int newMin=0;
		if(min.contains("--"))
		{
			min="10";
		}

		if(Integer.parseInt(min) <50)
		{
			newMin=Integer.parseInt(min)+10;
			incrementedMin=Integer.toString(newMin);
		}
		else if(Integer.parseInt(min)==  50)

		{
			incrementedMin="00";
		}
		else
		{
			Log.info("Min time exceeds the limit");
		}
		
		Utils.waitForElementToBeClickable(driver,BatteryPage.scheduleISetNewMinEV1(driver, incrementedMin));
		ActionModule.click(driver, BatteryPage.scheduleISetNewMinEV1(driver, incrementedMin), "new mins schedule", "Battery Schedule");	


		ActionModule.click(driver, BatteryPage.sunIEV1(driver) ,"sunIIEV1", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.monIEV1(driver) ,"monIIEV1", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.tuesIEV1(driver) ,"tuesIIEV1", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.wedIEV1(driver) ,"wedIIEV1", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.thursIEV1(driver) ,"thur", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.friIEV1(driver) ,"fri", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.satIEV1(driver) ,"sat", "Battery Schedule");	
	}



	public static void changeTimeIIEV1(WebDriver driver,String scheduleStatus)
	{
		String incrementedHour=null;
		String incrementedMin=null;
		
		Utils.waitForElementToBeClickable(driver, BatteryPage.scheduleIItoggleEV1(driver));
		ActionModule.click(driver, BatteryPage.scheduleIItoggleEV1(driver), "scheduleIItoggleEV1", "Batterypage");
		Utils.scrolDownForElement(driver, BatteryPage.scheduleIItoggleEV1(driver));
		
		
		
		if(Utils.waitForElementToBeVisible(driver, BatteryPage.eightyPercentageChargeOFFII(driver)))
		{
			ActionModule.click(driver, BatteryPage.eightyPercentageChargeOFFII(driver), "eightyPercentageChargeOFFII ", "Batterypage");

		}
		else
		{
			ActionModule.click(driver, BatteryPage.hundredPercentageChargeII(driver), "hundredPercentageChargeII", "Batterypage");
		}
		Utils.waitForElementToBeClickable(driver, BatteryPage.scheduleIIhourEV1(driver));
		
		ActionModule.click(driver, BatteryPage.scheduleIIhourEV1(driver), "scheduleIIhourEV1", "Batterypage");
		String hour=ActionModule.getText(driver, BatteryPage.scheduleIIhourEV1(driver), "scheduleIIhourEV1", "Battery Schedule");

		if(hour.contains("--"))
		{
			hour="10";
		}

		int newhour=1;
		if(Integer.parseInt(hour)< 12)
		{
			newhour=Integer.parseInt(hour)+1;
			if(newhour<10)	
			{
				incrementedHour = "0"+Integer.toString(newhour);
			}
			else
			{
				incrementedHour=Integer.toString(newhour);
			}

		}
		else if(Integer.parseInt(hour)==  12)

		{
			incrementedHour="01";
		}
		else
		{
			Log.info("hour time exceeds the limit");
		}

		ActionModule.click(driver, BatteryPage.scheduleIISetNewHourEV1(driver, incrementedHour), "scheduleIISetNewHourEV1", "Battery Schedule");


		Utils.sleep(driver, 2000);
		ActionModule.click(driver, BatteryPage.scheduleIIminEV1(driver), "scheduleIIminEV1", "Battery Schedule");
		String min=ActionModule.getText(driver, BatteryPage.scheduleIIminEV1(driver), "scheduleIIminEV1", "Battery Schedule");
		int newMin=0;
		if(min.contains("--"))
		{
			min="10";
		}
		if(Integer.parseInt(min) <50)
		{
			newMin=Integer.parseInt(min)+10;
			incrementedMin=Integer.toString(newMin);
		}
		else if(Integer.parseInt(min)==  50)

		{
			incrementedMin="00";
		}
		else
		{
			Log.info("Min time exceeds the limit");
		}
		ActionModule.click(driver, BatteryPage.scheduleIISetNewMinEV1(driver, incrementedMin), "new mins schedule", "Battery Schedule");	


		ActionModule.click(driver, BatteryPage.sunIIEV1(driver) ,"sunIIEV1", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.monIIEV1(driver) ,"monIIEV1", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.tuesIIEV1(driver) ,"tuesIIEV1", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.wedIIEV1(driver) ,"wedIIEV1", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.thursIIEV1(driver) ,"thur", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.friIIEV1(driver) ,"fri", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.satIIEV1(driver) ,"sat", "Battery Schedule");	
	}


	public static void chargingScheduleIDE(WebDriver driver)
	{

		Utils.scrolDownForElement(driver, BatteryPage.DEPHEV.scheduleI(driver));

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, BatteryPage.DEPHEV.scheduleI(driver));
		String scheduleOn=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDE(driver), "scheduleIToggle", "Battery Page");
		if(scheduleOn.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			Utils.waitForElementToBeClickable(driver,  BatteryPage.DEPHEV.ToggleDE(driver));
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDE(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}


		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleI(driver), "ToggleDE", "Battery Page");
		Utils.sleep(driver, 3000);

		String schedulestatus=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "scheduleIToggle", "Battery Page");

		if(schedulestatus.equalsIgnoreCase("off"))
		{
			Log.info("Schedule Status is OFF.");

			chargingScheduleIDEON(driver);

			schedulestatus=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "OnOffToggle", "Battery Page");

			if(schedulestatus.contains("ON"))
			{
				Log.info("Now Schedule is ON");

			}
			else
			{
				Log.error("Schedule status could not be changed");
				Reporter.log("Schedule status could not be changed");
				Assert.fail("Schedule status could not be changed");
			}


		}
		else
		{
			Log.info("Schedule Status is ON");

			boolean status=chargingScheduleIDEOFF(driver);

			ActionModule.click(driver, BatteryPage.DEPHEV.scheduleI(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);

			schedulestatus=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "OnOffToggle", "Battery Page");

			if(status==true)
			{
				if(schedulestatus.contains("OFF"))
				{
					Log.info("Now Schedule is OFF");


				}
				else
				{
					Log.error("Schedule status could not be changed");
					Reporter.log("Schedule status could not be changed");
					Assert.fail("Schedule status could not be changed");
				}
			}
			else
			{
				Log.info("schedule II is off alreday off . ");

				//changes to be done

				String hour=ActionModule.getText(driver, BatteryPage.DEPHEV.hourScheduleI(driver), "scheduleIIhourEV1", "Battery Schedule");

				String incrementedHour;
				if(hour.contains("--"))
				{
					incrementedHour="12";
				}
				else
				{
					incrementedHour=hourSelection(driver,hour);
				}
				ActionModule.click(driver, BatteryPage.DEPHEV.hourScheduleI(driver), "scheduleIIhourEV1", "Battery Schedule");
				ActionModule.click(driver, BatteryPage.DEPHEV.newHourScheduleI(driver, incrementedHour), "newHourScheduleI", "Battery Schedule");

				Utils.sleep(driver, 2000);
				ActionModule.click(driver, BatteryPage.DEPHEV.minScheduleI(driver), "minScheduleI", "Battery Schedule");
				String min=ActionModule.getText(driver, BatteryPage.DEPHEV.minScheduleI(driver), "minScheduleI", "Battery Schedule");

				String incrementedMin;
				if(min.contains("--"))
				{
					incrementedMin="10";
				}
				else
				{
					incrementedMin=minSelection(driver,min);
				}
				ActionModule.click(driver, BatteryPage.DEPHEV.newMinScheduleI(driver, incrementedMin), "new mins schedule", "Battery Schedule");	

				updatePeakOFFTimeWeekday(driver);
				updatePeakOFFTimeWeekend(driver);


				ActionModule.click(driver, BatteryPage.DEPHEV.updateScheduleI(driver), "updateScheduleI", "Batterypage");

				Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
				Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));

				Utils.sleep(driver, 3000);

			}
		}

	}

	/**
	 * 
	 * To change scheduleI from OFF to ON for DE PHEV
	 * @param driver
	 */
	public static void chargingScheduleIDEON(WebDriver driver)
	{
		changeTimeDE(driver,schedulestatus);

		ActionModule.click(driver, BatteryPage.DEPHEV.cancelScheduleI(driver), "cancelScheduleIEV1", "Batterypage");

		Utils.sleep(driver, 6000);
		Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));

		Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));
		Utils.sleep(driver, 3000);

		String newSchedulestatus=ActionModule.getText(driver,BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "OnOffToggle", "Battery Page");

		if(newSchedulestatus.equalsIgnoreCase("off"))
		{
			Log.info("schedule is still off ");
		}
		else
		{
			Log.error("Schedule status could not be changed");
			Assert.fail("Schedule status could not be changed");
		}

		changeTimeDE(driver,schedulestatus);
		ActionModule.click(driver, BatteryPage.DEPHEV.updateScheduleI(driver), "setScheduleIEV1", "Batterypage");

		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));

		Utils.sleep(driver, 3000);
	}


	/**
	 * 
	 * To change scheduleI from ON to OFF for DE PHEV
	 * @param driver
	 */
	public static boolean chargingScheduleIDEOFF(WebDriver driver)
	{


		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "ToggleDE", "Battery Page");
		Utils.sleep(driver, 3000);

		String schedulestatus=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "scheduleIToggle", "Battery Page");
		if(schedulestatus.equalsIgnoreCase("off"))
		{
			Log.info("Schedule II Status is OFF.No Need");
			return false;

		}
		else
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.scheduleI(driver), "ToggleDE", "Battery Page");
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "scheduleIToggle","Battery Page");
			ActionModule.click(driver, BatteryPage.DEPHEV.cancelScheduleI(driver), "cancelScheduleIEV1", "Batterypage");

			Utils.sleep(driver, 3000);
			Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));

			Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));

			Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));

			Utils.sleep(driver, 3000);

			String newSchedulestatus=ActionModule.getText(driver,BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "OnOffToggle", "Battery Page");

			if(newSchedulestatus.equalsIgnoreCase("on"))
			{
				Log.info("schedule is still on ");
			}
			else
			{
				Log.error("Schedule status could not be changed");
				Assert.fail("Schedule status could not be changed");
			}


			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "scheduleIToggle","Battery Page");

			ActionModule.click(driver, BatteryPage.DEPHEV.updateScheduleI(driver), "scheduleItoggleEV1","Battery Page");

			Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
			Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));

			Utils.waitForElementToBeVisible(driver, BatteryPage.startChargingButton(driver));
			Utils.sleep(driver, 3000);
			return true;
		}
	}


	public static void changeTimeDE(WebDriver driver,String scheduleStatus)
	{

		String incrementedHour=null;
		String incrementedMin=null;

		Utils.waitForElementToBeClickable(driver, BatteryPage.DEPHEV.scheduleI(driver));
		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleI(driver), "scheduleI", "Batterypage");
		ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "scheduleIToggle", "Batterypage");

		String hour=ActionModule.getText(driver, BatteryPage.DEPHEV.hourScheduleI(driver), "scheduleIIhourEV1", "Battery Schedule");

		if(hour.contains("--"))
		{
			incrementedHour="12";
		}
		else
		{
			incrementedHour=hourSelection(driver,hour);
		}
		ActionModule.click(driver, BatteryPage.DEPHEV.hourScheduleI(driver), "scheduleIIhourEV1", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.newHourScheduleI(driver, incrementedHour), "newHourScheduleI", "Battery Schedule");

		Utils.sleep(driver, 2000);
		
		String min=ActionModule.getText(driver, BatteryPage.DEPHEV.minScheduleI(driver), "minScheduleI", "Battery Schedule");

		if(min.contains("--"))
		{
			incrementedMin="10";
		}
		else
		{
			incrementedMin=minSelection(driver,min);
		}

		ActionModule.click(driver, BatteryPage.DEPHEV.minScheduleI(driver), "minScheduleI", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.newMinScheduleI(driver, incrementedMin), "minScheduleI", "Battery Schedule");
		
		Utils.sleep(driver, 3000);
		
		
		ActionModule.click(driver, BatteryPage.DEPHEV.sunScheduleI(driver) ,"sun ScheduleI", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.DEPHEV.monScheduleI(driver) ,"mon ScheduleI", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.tuesScheduleI(driver) ,"tues ScheduleI", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.DEPHEV.wedScheduleI(driver) ,"wed ScheduleI", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.DEPHEV.thursScheduleI(driver) ,"thurs ScheduleI", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.DEPHEV.friScheduleI(driver) ,"fri ScheduleI", "Battery Schedule");	
		ActionModule.click(driver, BatteryPage.DEPHEV.satScheduleI(driver) ,"sat ScheduleI", "Battery Schedule");	

		updatePeakOFFTimeWeekday(driver);
		updatePeakOFFTimeWeekend(driver);


	}




	public static void chargingScheduleIIDE(WebDriver driver)
	{
		Utils.scrolDownForElement(driver, BatteryPage.DEPHEV.scheduleI(driver));

		Utils.sleep(driver, 3000);
		String scheduleOn=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDE(driver), "scheduleIToggle", "Battery Page");
		if(scheduleOn.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			Utils.waitForElementToBeClickable(driver, BatteryPage.DEPHEV.ToggleDE(driver));
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDE(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}

		
		Utils.waitForElementToBeClickable(driver, BatteryPage.DEPHEV.scheduleII(driver));
		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "ToggleDE", "Battery Page");
		Utils.sleep(driver, 3000);

		String schedulestatus=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "scheduleIToggle", "Battery Page");
		if(schedulestatus.equalsIgnoreCase("off"))
		{
			Log.info("Schedule Status is OFF.");

			chargingScheduleIIDEON(driver);

			if(schedulestatus.contains("ON"))
			{
				Log.info("Now Schedule is ON");

			}
			else
			{
				Log.error("Schedule status could not be changed");
				Reporter.log("Schedule status could not be changed");
				Assert.fail("Schedule status could not be changed");
			}


		}
		else
		{
			Log.info("Schedule Status is ON");

			boolean status=chargingScheduleIIDEOFF(driver);

			ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);

			schedulestatus=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "OnOffToggle", "Battery Page");

			if(status==true)
			{
				if(schedulestatus.contains("OFF"))
				{
					Log.info("Now Schedule is OFF");


				}
				else
				{
					Log.error("Schedule status could not be changed");
					Reporter.log("Schedule status could not be changed");
					Assert.fail("Schedule status could not be changed");
				}
			}
			else
			{
				Log.info("schedule I is off alreday off . ");

				//changes to be done

				String hour=ActionModule.getText(driver, BatteryPage.DEPHEV.hourScheduleII(driver), "scheduleIIhourEV1", "Battery Schedule");

				String incrementedHour;
				if(hour.contains("--"))
				{
					incrementedHour="12";
				}
				else
				{
					incrementedHour=hourSelection(driver,hour);
				}
				ActionModule.click(driver, BatteryPage.DEPHEV.hourScheduleII(driver), "scheduleIIhourEV1", "Battery Schedule");
				ActionModule.click(driver, BatteryPage.DEPHEV.newHourScheduleII(driver, incrementedHour), "newHourScheduleI", "Battery Schedule");

				Utils.sleep(driver, 2000);
				ActionModule.click(driver, BatteryPage.DEPHEV.minScheduleII(driver), "minScheduleI", "Battery Schedule");
				String min=ActionModule.getText(driver, BatteryPage.DEPHEV.minScheduleII(driver), "minScheduleI", "Battery Schedule");

				String incrementedMin;
				if(min.contains("--"))
				{
					incrementedMin="10";
				}
				else
				{
					incrementedMin=minSelection(driver,min);
				}
				ActionModule.click(driver, BatteryPage.DEPHEV.newMinScheduleII(driver, incrementedMin), "new mins schedule", "Battery Schedule");	

				updatePeakOFFTimeWeekday(driver);
				updatePeakOFFTimeWeekend(driver);


				ActionModule.click(driver, BatteryPage.DEPHEV.updateScheduleI(driver), "updateScheduleI", "Batterypage");

				Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
				Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));

				Utils.sleep(driver, 3000);

			}
		}

	}


	public static void chargingScheduleIIDEON(WebDriver driver)
	{
		changeTimeDEII(driver,schedulestatus);

		ActionModule.click(driver, BatteryPage.DEPHEV.cancelScheduleI(driver), "cancelScheduleIEV1", "Batterypage");
		Utils.sleep(driver, 6000);
		Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));
		Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));
		Utils.waitForElementToBeClickable(driver, BatteryPage.DEPHEV.scheduleII(driver));

		String scheduleOn=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDE(driver), "scheduleIToggle", "Battery Page");
		if(scheduleOn.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			Utils.waitForElementToBeClickable(driver, BatteryPage.DEPHEV.ToggleDE(driver));
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDE(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}


		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "ToggleDE", "Battery Page");

		Utils.sleep(driver, 3000);
		String newSchedulestatus=ActionModule.getText(driver,BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "OnOffToggle", "Battery Page");

		if(newSchedulestatus.equalsIgnoreCase("off"))
		{
			Log.info("schedule is still off ");
		}
		else
		{
			Log.error("Schedule status changed");
			Assert.fail("Schedule status changed");
		}

		scheduleOn=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDE(driver), "scheduleIToggle", "Battery Page");
		if(scheduleOn.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDE(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}

		changeTimeDEII(driver,schedulestatus);
		ActionModule.click(driver, BatteryPage.DEPHEV.updateScheduleI(driver), "setScheduleIEV1", "Batterypage");

		Utils.sleep(driver, 5000);
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
		Utils.scrolDownForElement(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));

		schedulestatus=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "OnOffToggle", "Battery Page");
		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "ToggleDE", "Battery Page");
		Utils.sleep(driver, 2000);
	}

	public static boolean chargingScheduleIIDEOFF(WebDriver driver)
	{

Utils.waitForElementToBeClickable(driver, BatteryPage.DEPHEV.scheduleI(driver));
		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleI(driver), "ToggleDE", "Battery Page");
		Utils.sleep(driver, 3000);

		String schedulestatus=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "scheduleIToggle", "Battery Page");
		if(schedulestatus.equalsIgnoreCase("off"))
		{
			Log.info("Schedule I Status is OFF.");
			return false;

		}
		else
		{

			Utils.waitForElementToBeClickable(driver, BatteryPage.DEPHEV.scheduleII(driver));
			ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "ToggleDE", "Battery Page");
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "scheduleIToggle","Battery Page");

			ActionModule.click(driver, BatteryPage.DEPHEV.cancelScheduleI(driver), "cancelScheduleIEV1", "Batterypage");
			Utils.sleep(driver, 3000);

			Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver));
			Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
			Utils.waitForElementToBeClickable(driver, BatteryPage.startChargingButton(driver));

			ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "ToggleDE", "Battery Page");

			Utils.sleep(driver, 3000);

			String newSchedulestatus=ActionModule.getText(driver,BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "OnOffToggle", "Battery Page");
			if(newSchedulestatus.equalsIgnoreCase("on"))
			{
				Log.info("schedule is still on ");
			}
			else
			{
				Log.error("Schedule status could not be changed");
				Assert.fail("Schedule status could not be changed");
			}


			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "scheduleIToggle","Battery Page");
			ActionModule.click(driver, BatteryPage.DEPHEV.updateScheduleI(driver), "scheduleItoggleEV1","Battery Page");

			Utils.sleep(driver, 5000);
			Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
			Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
			Utils.waitForElementToBeInvisible(driver, BatteryPage.scheduleRequestLoader(driver));
			Utils.scrolDownForElement(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));


			Utils.sleep(driver, 3000);
			ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}
		return true;

	}
	public static void changeTimeDEII(WebDriver driver,String scheduleStatus)
	{

		String incrementedHour=null;
		String incrementedMin=null;

		Utils.waitForElementToBeClickable(driver, BatteryPage.DEPHEV.scheduleII(driver));
		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "scheduleI", "Batterypage");
		ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "scheduleIToggle", "Batterypage");

		String hour=ActionModule.getText(driver, BatteryPage.DEPHEV.hourScheduleII(driver), "scheduleIIhourEV1", "Battery Schedule");
		if(hour.contains("--"))
		{
			incrementedHour="12";
		}
		else
		{
			incrementedHour=hourSelection(driver,hour);
		}



		ActionModule.click(driver, BatteryPage.DEPHEV.hourScheduleII(driver), "scheduleIIhourEV1", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.newHourScheduleII(driver, incrementedHour), "newHourScheduleI", "Battery Schedule");

		Utils.sleep(driver, 2000);
		ActionModule.click(driver, BatteryPage.DEPHEV.minScheduleII(driver), "minScheduleI", "Battery Schedule");

		String min=ActionModule.getText(driver, BatteryPage.DEPHEV.minScheduleII(driver), "minScheduleI", "Battery Schedule");
		if(min.contains("--"))
		{
			incrementedMin="10";
		}
		else
		{
			incrementedMin=minSelection(driver,min);
		}

		ActionModule.click(driver, BatteryPage.DEPHEV.newMinScheduleII(driver, incrementedMin), "new mins schedule", "Battery Schedule");	

		ActionModule.click(driver, BatteryPage.DEPHEV.sunScheduleII(driver) ,"sun", "Battery Schedule");	

		ActionModule.click(driver, BatteryPage.DEPHEV.monScheduleII(driver) ,"monScheduleI", "Battery Schedule");	

		ActionModule.click(driver, BatteryPage.DEPHEV.tuesScheduleII(driver) ,"tues ScheduleI", "Battery Schedule");	

		ActionModule.click(driver, BatteryPage.DEPHEV.wedScheduleII(driver) ,"wedScheduleI", "Battery Schedule");	

		ActionModule.click(driver, BatteryPage.DEPHEV.thursScheduleII(driver) ,"thursScheduleI", "Battery Schedule");	

		ActionModule.click(driver, BatteryPage.DEPHEV.friScheduleII(driver) ,"friScheduleI", "Battery Schedule");	

		ActionModule.click(driver, BatteryPage.DEPHEV.satScheduleII(driver) ,"satScheduleI", "Battery Schedule");	

		updatePeakOFFTimeWeekday(driver);
		updatePeakOFFTimeWeekend(driver);

	}

	public static void updatePeakOFFTimeWeekday(WebDriver driver)
	{


		String incrementedHour=null;
		String incrementedMin=null;

		if(!Utils.waitForElementToBeVisible(driver, BatteryPage.DEPHEV.peakOffSelected(driver)))
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.peakOff(driver) ,"peakOffMax", "Battery Schedule");
		}

		String peakhour=ActionModule.getText(driver, BatteryPage.DEPHEV.startHourWeekDays(driver), "scheduleIIhourEV1", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.startHourWeekDays(driver) ,"startHourWeekend", "Battery Schedule");
		if(peakhour.contains("--"))
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.startNewHourWeekDays(driver,"12") ,"startNewHourWeekend", "Battery Schedule");
		}
		else
		{
			incrementedHour=hourSelection(driver,peakhour);
			ActionModule.click(driver, BatteryPage.DEPHEV.startNewHourWeekDays(driver,incrementedHour) ,"startNewHourWeekend", "Battery Schedule");
		}


		String peakmin=ActionModule.getText(driver, BatteryPage.DEPHEV.startMinWeekDays(driver), "scheduleIIhourEV1", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.startMinWeekDays(driver) ,"start min", "Battery Schedule");
		if(peakmin.contains("--"))
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.startNewMinWeekDays(driver,"00") ,"startNewHourWeekend", "Battery Schedule");
		}
		else
		{
			incrementedMin=minSelection(driver,peakmin);
			ActionModule.click(driver, BatteryPage.DEPHEV.startNewMinWeekDays(driver,incrementedMin) ,"startNewHourWeekend", "Battery Schedule");
		}


		ActionModule.click(driver, BatteryPage.DEPHEV.startAMPMWeekday(driver) ,"startAMPMWeekend", "Battery Schedule");

		ActionModule.click(driver, BatteryPage.DEPHEV.startNewAMPMWeekday(driver) ,"startNewAMPMWeekend", "Battery Schedule");



		String peakEndhour=ActionModule.getText(driver, BatteryPage.DEPHEV.endHourWeekDays(driver), "endHourWeekDays", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.endHourWeekDays(driver) ,"startHourWeekend", "Battery Schedule");
		if(peakEndhour.contains("--"))
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.endNewHourWeekDays(driver,"01") ,"startNewHourWeekend", "Battery Schedule");
		}
		else
		{
			incrementedHour=hourSelection(driver,peakEndhour);
			ActionModule.click(driver, BatteryPage.DEPHEV.endNewHourWeekDays(driver,incrementedHour) ,"startNewHourWeekend", "Battery Schedule");
		}


		String peakEndmin=ActionModule.getText(driver, BatteryPage.DEPHEV.endMinWeekDays(driver), "endMinWeekDays", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.endMinWeekDays(driver) ,"endMinWeekDays", "Battery Schedule");
		if(peakEndmin.contains("--"))
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.endNewMinWeekDays(driver,"10") ,"startNewHourWeekend", "Battery Schedule");
		}
		else
		{
			incrementedMin=minSelection(driver,peakEndmin);
			ActionModule.click(driver, BatteryPage.DEPHEV.endNewMinWeekDays(driver,incrementedMin) ,"startNewHourWeekend", "Battery Schedule");
		}


		ActionModule.click(driver, BatteryPage.DEPHEV.endAMPMWeekday(driver) ,"endAMPMWeekday", "Battery Schedule");

		ActionModule.click(driver, BatteryPage.DEPHEV.endNewAMPMWeekday(driver) ,"endNewAMPMWeekday", "Battery Schedule");



	}





	public static void updatePeakOFFTimeWeekend(WebDriver driver)
	{


		String incrementedHour=null;
		String incrementedMin=null;


		String peakhour=ActionModule.getText(driver, BatteryPage.DEPHEV.startHourWeekend(driver), "startHourWeekend", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.startHourWeekend(driver) ,"startHourWeekend", "Battery Schedule");
		if(peakhour.contains("--"))
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.startNewHourWeekend(driver,"12") ,"startNewHourWeekend", "Battery Schedule");
		}
		else
		{
			incrementedHour=hourSelection(driver,peakhour);
			ActionModule.click(driver, BatteryPage.DEPHEV.startNewHourWeekend(driver,incrementedHour) ,"startNewHourWeekend", "Battery Schedule");
		}


		String peakmin=ActionModule.getText(driver, BatteryPage.DEPHEV.startMinWeekend(driver), "startMinWeekend", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.startMinWeekend(driver) ,"startMinWeekend", "Battery Schedule");
		if(peakmin.contains("--"))
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.startNewMinWeekend(driver,"00") ,"startNewMinWeekend", "Battery Schedule");
		}
		else
		{
			incrementedMin=minSelection(driver,peakmin);
			ActionModule.click(driver, BatteryPage.DEPHEV.startNewMinWeekend(driver,incrementedMin) ,"startNewMinWeekend", "Battery Schedule");
		}


		ActionModule.click(driver, BatteryPage.DEPHEV.startAMPMWeekend(driver) ,"startAMPMWeekend", "Battery Schedule");

		ActionModule.click(driver, BatteryPage.DEPHEV.startNewAMPMWeekend(driver) ,"startNewAMPMWeekend", "Battery Schedule");



		String peakEndhour=ActionModule.getText(driver, BatteryPage.DEPHEV.endHourWeekend(driver), "endHourWeekend", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.endHourWeekend(driver) ,"startHourWeekend", "Battery Schedule");
		if(peakEndhour.contains("--"))
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.endNewHourWeekend(driver,"01") ,"endNewHourWeekend", "Battery Schedule");
		}
		else
		{
			incrementedHour=hourSelection(driver,peakEndhour);
			ActionModule.click(driver, BatteryPage.DEPHEV.endNewHourWeekend(driver,incrementedHour) ,"endNewHourWeekend", "Battery Schedule");
		}


		String peakEndmin=ActionModule.getText(driver, BatteryPage.DEPHEV.endMinWeekend(driver), "endMinWeekend", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.endMinWeekend(driver) ,"endMinWeekend", "Battery Schedule");
		if(peakEndmin.contains("--"))
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.endNewMinWeekend(driver,"10") ,"endNewMinWeekend", "Battery Schedule");
		}
		else
		{
			incrementedMin=minSelection(driver,peakEndmin);
			ActionModule.click(driver, BatteryPage.DEPHEV.endNewMinWeekend(driver,incrementedMin) ,"endNewMinWeekDays", "Battery Schedule");
		}


		ActionModule.click(driver, BatteryPage.DEPHEV.endAMPMWeekend(driver) ,"endAMPMWeekend", "Battery Schedule");

		ActionModule.click(driver, BatteryPage.DEPHEV.endNewAMPMWeekend(driver) ,"endNewAMPMWeekend", "Battery Schedule");

		ActionModule.click(driver, BatteryPage.DEPHEV.peakMax(driver) ,"endNewAMPMWeekend", "Battery Schedule");
		Utils.sleep(driver, 2000);

		ActionModule.click(driver, BatteryPage.DEPHEV.ignorePeakOFF(driver) ,"endNewAMPMWeekend", "Battery Schedule");
	}


	public static void checkDays(WebDriver driver)
	{
		
		
		String incrementedHour=null;
		String incrementedMin=null;
		Utils.scrolDownForElement(driver, BatteryPage.OnOffToggle(driver));

		Utils.sleep(driver, 3000);

		String schedulestatus=ActionModule.getText(driver, BatteryPage.OnOffToggle(driver), "OnOffToggle", "Battery Page");
		Log.info("schedule status is: "+schedulestatus);

		if(schedulestatus.contains("OFF"))
		{
			ActionModule.click(driver, BatteryPage.OnOffToggle(driver), "Toggle ", "Battery schedule");
		}
		else
		{
			Log.info("Schedule is aleady ON");
		}

		Utils.sleep(driver, 2000);

		
		//page is showing -- in hour 
		ActionModule.click(driver, BatteryPage.StartSchedulehour(driver), "Hours", "Battery Schedule");
		String hour=ActionModule.getText(driver, BatteryPage.StartSchedulehour(driver), "new hours schedule", "Battery Schedule");
		//Minimum value for Hour is 1
		int newhour=1;

		if(hour.contains("--"))
		{
			hour="01";
		}


		//Re-Assigning 1 as hour  if hour exceeds by 12 and also converting hour to 2-digit number by adding 0 .
		if(Integer.parseInt(hour)< 12)
		{
			newhour=Integer.parseInt(hour)+1;
			if(newhour<10)	
			{
				incrementedHour = "0"+Integer.toString(newhour);
			}
			else
			{
				incrementedHour=Integer.toString(newhour);
			}
		}
		else if(Integer.parseInt(hour)==  12)

		{
			incrementedHour="01";
		}
		else
		{
			Log.info("hour time exceeds the limit");
		}



		ActionModule.click(driver, BatteryPage.StartScheduleNewhour(driver, incrementedHour), "new hours schedule", "Battery Schedule");

		Utils.sleep(driver, 2000);
		ActionModule.click(driver, BatteryPage.minSchedule(driver), "min", "Battery Schedule");

		String min=ActionModule.getText(driver, BatteryPage.minSchedule(driver), "new hours schedule", "Battery Schedule");

		int newMin=0;

		if(min.contains("--"))
		{
			min="10";
		}

		//Re-Assigning 00 as minute , if min exceeds by 50 
		if(Integer.parseInt(min) <50)
		{
			newMin=Integer.parseInt(min)+10;
			incrementedMin = Integer.toString(newMin);

		}
		else if(Integer.parseInt(min)==  50)

		{

			incrementedMin="00";
		}
		else
		{
			Log.info("Min time exceeds the limit");
		}
		
		
		ActionModule.click(driver, BatteryPage.newMinSchedule(driver, incrementedMin), "new mins schedule", "Battery Schedule");	
		
		disableDays(driver,"//*[@class='weekDays']/div");

		ActionModule.click(driver, BatteryPage.setScheduleButton(driver), "set schedule", "Battery Schedule");

		Utils.sleep(driver, 5000);
		Utils.waitForElementToBeClickable(driver, BatteryPage.setScheduleButton(driver));
		Utils.waitForElementToBeVisible(driver,BatteryPage.daysError(driver));

		String errorMsg=ActionModule.getText(driver, BatteryPage.daysError(driver), "days error", "Charging schedule");

		if(errorMsg.contains("Please select scheduled days"))
		{

			Log.info("Error msg found ");
		}
		else
		{
			Log.error("Error msg not found ");
			Reporter.log("Error msg not found ");
			Assert.fail("Error msg not found ");

		}

	}


	/**
	 * 
	 * @param driver
	 * @param xpath
	 * Module to disable all days in schedule 
	 */
	public static void disableDays(WebDriver driver,String xpath)
	{

		Utils.sleep(driver, 3000);
		List<WebElement> webElements= null;
		webElements=FindWebElement.findElementListByXpath(driver, xpath, "weekDays", "charging schedule");
		for(int i =0;i < webElements.size();i++)
		{
			if(webElements.get(i).getAttribute("class").contains("selected"))
			{
				Utils.sleep(driver, 1000);
				
					ActionModule.click(driver, webElements.get(i), "day", "battery page");
			}
			else
			{
				Log.info("Day is already deselected");
			}
		}

	}


	/**
	 * 
	 * @param driver
	 * checking same days/time error for both schedule 
	 */
	public static void checkDaysIEV1(WebDriver driver)
	{

		Utils.scrolDownForElement(driver, BatteryPage.OnOffToggle(driver));

		Utils.scrolDownForElement(driver,  BatteryPage.batteryScheduleIEV1(driver));


		//capturing schedule 2 details 
		ActionModule.click(driver, BatteryPage.batteryScheduleIIEV1(driver), "batteryScheduleIEV1", "BatteryPage");

		Utils.scrolDownForElement(driver,BatteryPage.scheduleIIminEV1(driver));
		Utils.sleep(driver, 3000);

		//capturing selected days for schedule 
		int[] selectedDays=matchDaysEV1(driver,"//*[contains(@ng-click,'toggleDateSelectII(')]");

		Utils.sleep(driver, 2000);

		String hour=ActionModule.getText(driver, BatteryPage.scheduleIIhourEV1(driver), "scheduleIIhourEV1", "BatteryPage");

		String min=ActionModule.getText(driver, BatteryPage.scheduleIIminEV1(driver), "scheduleIIhourEV1", "BatteryPage");

		String AMPM=ActionModule.getText(driver, BatteryPage.scheduleIIAMPM(driver), "scheduleIIAMPM", "BatteryPage");

		ActionModule.click(driver, BatteryPage.batteryScheduleIIEV1(driver), "batteryScheduleIIEV1", "BatteryPage");

		ActionModule.click(driver, BatteryPage.batteryScheduleIEV1(driver), "batteryScheduleIEV1", "BatteryPage");

		Utils.scrolDownForElement(driver,  BatteryPage.scheduleIminEV1(driver));

		disableDays(driver,"//*[contains(@ng-click,'toggleDateSelectI(')]");

		ActionModule.click(driver, BatteryPage.setScheduleIEV1(driver), "setScheduleIEV1", "Battery Schedule");

		Utils.waitForElementToBeVisible(driver,BatteryPage.noDaysMessage(driver) );

		String errorMsg=ActionModule.getText(driver, BatteryPage.noDaysMessage(driver), "days error", "Charging schedule");
		if(errorMsg.contains("Please select"))
		{

			Log.info("Error msg found ");
		}
		else
		{
			Log.error("Error msg not found ");
			Reporter.log("Error msg not found ");
			Assert.fail("Error msg not found ");

		}


		ActionModule.click(driver, BatteryPage.scheduleIhourEV1(driver), "scheduleIhourEV1", "Batterypage");

		ActionModule.click(driver, BatteryPage.scheduleISetNewHourEV1(driver, hour), "new hours schedule", "Battery Schedule");

		ActionModule.click(driver, BatteryPage.scheduleIminEV1(driver), "scheduleIhourEV1", "Batterypage");
		ActionModule.click(driver, BatteryPage.scheduleISetNewMinEV1(driver, min), "scheduleIhourEV1", "Batterypage");

		String schedule1AMPM=ActionModule.getText(driver, BatteryPage.scheduleIAMPM(driver), "AMPM", "BatteryPage");

		if(schedule1AMPM.equalsIgnoreCase(AMPM))
		{
			Log.info("Same as Schedule 2");
		}

		else
		{
			ActionModule.click(driver, BatteryPage.scheduleIAMPM(driver), "scheduleIhourEV1", "Batterypage");
			ActionModule.click(driver, BatteryPage.scheduleINewAMPM(driver, AMPM), "scheduleIhourEV1", "Batterypage");
		}
		List<WebElement> webElements= null;
		webElements=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-click,'toggleDateSelectI(')]", "weekDays", "charging schedule");

		for(int i=0;i<selectedDays.length;i++)
		{
			if(selectedDays[i]==1 && !(webElements.get(i).getAttribute("class").contains("selected")))	
			{
				Utils.sleep(driver, 1000);
				webElements.get(i).click();
			}
			else
			{
				Log.info("not selected in schedule 2");
			}
		}


		ActionModule.click(driver, BatteryPage.setScheduleIEV1(driver), "setScheduleIEV1", "Batterypage");
		Utils.sleep(driver, 3000);

		/**
		 * checking same day/hour message for schedule 1
		 */
		Utils.scrolDownForElement(driver, BatteryPage.errormsgSameDays(driver));
		ActionModule.isDisplayed(driver, BatteryPage.errormsgSameDays(driver), "errormsgDays", "Batterypage");

		Utils.scrolDownForElement(driver,HeaderPage.refresh_Button(driver));
		ActionModule.click(driver,HeaderPage.refresh_Button(driver), "refresh_Button", "Batterypage");
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));


		/**
		 *capturing schedule 1 details
		 */ 
		ActionModule.click(driver, BatteryPage.batteryScheduleIEV1(driver), "batteryScheduleIEV1", "BatteryPage");

		Utils.scrolDownForElement(driver,BatteryPage.scheduleIminEV1(driver));
		Utils.sleep(driver, 3000);

		int[] selectedDaysII=matchDaysEV1(driver,"//*[contains(@ng-click,'toggleDateSelectI(')]");
		Utils.sleep(driver, 2000);

		String hourII=ActionModule.getText(driver, BatteryPage.scheduleIhourEV1(driver), "scheduleIhourEV1", "BatteryPage");

		String minII=ActionModule.getText(driver, BatteryPage.scheduleIminEV1(driver), "scheduleIhourEV1", "BatteryPage");

		String AMPMII=ActionModule.getText(driver, BatteryPage.scheduleIAMPM(driver), "scheduleIAMPM", "BatteryPage");

		ActionModule.click(driver, BatteryPage.batteryScheduleIEV1(driver), "batteryScheduleIEV1", "BatteryPage");

		ActionModule.click(driver, BatteryPage.batteryScheduleIIEV1(driver), "batteryScheduleIEV1", "BatteryPage");


		Utils.scrolDownForElement(driver, BatteryPage.scheduleIIminEV1(driver));


		disableDays(driver,"//*[contains(@ng-click,'toggleDateSelectII(')]");

		ActionModule.click(driver, BatteryPage.setScheduleIIEV1(driver), "setScheduleIEV1", "Battery Schedule");
		Utils.sleep(driver, 2000);

		Utils.waitForElementToBeVisible(driver,BatteryPage.noDaysMessage(driver) );

		String errorMsgII=ActionModule.getText(driver, BatteryPage.noDaysMessage(driver), "days error", "Charging schedule");
		if(errorMsgII.contains("Please select"))
		{
			Utils.sleep(driver, 2000);
			Log.info("Error msg found ");
		}
		else
		{
			Log.error("Error msg not found ");
			Reporter.log("Error msg not found ");
			Assert.fail("Error msg not found ");

		}


		ActionModule.click(driver, BatteryPage.scheduleIIhourEV1(driver), "scheduleIIhourEV1", "Batterypage");
		
		Utils.sleep(driver, 3000);

		ActionModule.click(driver, BatteryPage.scheduleIISetNewHourEV1(driver, hourII), "scheduleIISetNewHourEV1", "Battery Schedule");

		ActionModule.click(driver, BatteryPage.scheduleIIminEV1(driver), "scheduleIIminEV1", "Batterypage");

		ActionModule.click(driver, BatteryPage.scheduleIISetNewMinEV1(driver, minII), "scheduleIISetNewMinEV1", "Batterypage");

		String schedule2AMPM=ActionModule.getText(driver, BatteryPage.scheduleIIAMPM(driver), "AMPM", "BatteryPage");

		if(schedule2AMPM.equalsIgnoreCase(AMPMII))
		{
			Log.info("Same as Schedule 2");
		}

		else
		{
			ActionModule.click(driver, BatteryPage.scheduleIIAMPM(driver), "scheduleIhourEV1", "Batterypage");
			ActionModule.click(driver, BatteryPage.scheduleIINewAMPM(driver, AMPMII), "scheduleIhourEV1", "Batterypage");
		}
		List<WebElement> webElementsII= null;
		webElementsII=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-click,'toggleDateSelectII(')]", "weekDays", "charging schedule");

		for(int i=0;i<selectedDaysII.length;i++)
		{
			if(selectedDaysII[i]==1 && !(webElementsII.get(i).getAttribute("class").contains("selected")))	
			{
				Utils.sleep(driver, 2000);
				webElementsII.get(i).click();
			}
			else
			{
				Log.info("not selected in schedule 1");
			}
		}


		ActionModule.click(driver, BatteryPage.setScheduleIIEV1(driver), "setScheduleIEV1", "Batterypage");

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, BatteryPage.setScheduleIIEV1(driver));

		/**
		 * checking same day/hour message for schedule 2
		 */
		ActionModule.isDisplayed(driver, BatteryPage.errormsgSameDays(driver), "errormsgDays", "Batterypage");


	}


	public static void checkDaysDE(WebDriver driver)
	{
		int count=0;

		Utils.scrolDownForElement(driver, BatteryPage.DEPHEV.scheduleI(driver));

		Utils.sleep(driver, 2000);
		String scheduleOn=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDE(driver), "scheduleIToggle", "Battery Page");
		if(scheduleOn.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDE(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}

		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "ToggleDE", "Battery Page");
		String scheduleII=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "scheduleII", "Battery Page");

		if(scheduleII.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}


		/**
		 * capturing schedule 2
		 */
		int[] selectedDaysII=matchDaysEV1(driver,"//*[contains(@ng-class,'dateSelectedDE2(')]");

		Utils.sleep(driver, 3000);
		String hourII=ActionModule.getText(driver, BatteryPage.DEPHEV.hourScheduleII(driver), "hourScheduleI", "Battery Page");
		String minII=ActionModule.getText(driver, BatteryPage.DEPHEV.minScheduleII(driver), "minScheduleI", "Battery Page");
		String AMPMII=ActionModule.getText(driver, BatteryPage.DEPHEV.AMPMScheduleII(driver), "AMPMScheduleI", "Battery Page");

		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleI(driver), "scheduleII", "Battery Page");


		String scheduleI=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "ToggleDEScheduleII", "Battery Page");
		if(scheduleI.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}

		disableDays(driver,"//*[contains(@ng-class,'dateSelectedDE1')]");

		ActionModule.click(driver, BatteryPage.DEPHEV.updateScheduleI(driver), "updateScheduleI", "Battery Schedule");
		Utils.sleep(driver, 2000);

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestPending(driver));
		
		Utils.waitForElementToBeVisible(driver,BatteryPage.DEPHEV.noDaysDEMsg(driver));

		String errorMsgII=ActionModule.getText(driver, BatteryPage.DEPHEV.noDaysDEMsg(driver), "days error", "Charging schedule");
		if(errorMsgII.contains("Please select"))
		{
			Utils.sleep(driver, 2000);
			Log.info("Error msg found ");
		}
		else
		{
			Log.error("Error msg not found ");
			Reporter.log("Error msg not found ");
			Assert.fail("Error msg not found ");

		}


		ActionModule.click(driver, BatteryPage.DEPHEV.hourScheduleI(driver), "scheduleIIhourEV1", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.newHourScheduleI(driver, hourII), "newHourScheduleI", "Battery Schedule");

		Utils.sleep(driver, 2000);
		ActionModule.click(driver, BatteryPage.DEPHEV.minScheduleI(driver), "minScheduleI", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.newMinScheduleI(driver, minII), "new mins schedule", "Battery Schedule");	

		ActionModule.click(driver, BatteryPage.DEPHEV.AMPMScheduleI(driver), "AMPMScheduleI", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.newAMPMScheduleI(driver, AMPMII), "newMinScheduleI", "Battery Schedule");	



		List<WebElement> webElementsII= null;
		webElementsII=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-class,'dateSelectedDE1(')]", "weekDays", "charging schedule");

		for(int i=0;i<selectedDaysII.length;i++)
		{
			if(selectedDaysII[i]==1 && !(webElementsII.get(i).getAttribute("class").contains("selected")))	
			{
				Utils.sleep(driver, 2000);

				if(Utils.waitForElementToBeVisible(driver, webElementsII.get(i)))
				{
					Log.info(webElementsII.get(i).getText()+ " is greyed out");
					count=1;
				}

			}
			else
			{
				Log.info("not selected in schedule 1");
			}
		}


		if(count==1)
		{
			Log.info("Time/date greyed out");
		}
		Utils.scrolDownForElement(driver,OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver) );
		ActionModule.click(driver, OverviewPage.ECO.State_of_Vehicle.refreshIcon(driver), "refreshIcon", "Battery Page");
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));
		Utils.waitForElementToBeInvisible(driver, BatteryPage.DEPHEV.updateScheduleI(driver));


		/**
		 * capturing schedule 1
		 */
		String scheduleIOn=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDE(driver), "scheduleIToggle", "Battery Page");
		if(scheduleIOn.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDE(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}

		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleI(driver), "ToggleDE", "Battery Page");
		scheduleI=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "scheduleI", "Battery Page");

		if(scheduleII.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleI(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}



		int[] selectedDaysI=matchDaysEV1(driver,"//*[contains(@ng-class,'dateSelectedDE1(')]");

		Utils.sleep(driver, 3000);
		String hourI=ActionModule.getText(driver, BatteryPage.DEPHEV.hourScheduleI(driver), "hourScheduleI", "Battery Page");
		String minI=ActionModule.getText(driver, BatteryPage.DEPHEV.minScheduleI(driver), "minScheduleI", "Battery Page");
		String AMPMI=ActionModule.getText(driver, BatteryPage.DEPHEV.AMPMScheduleI(driver), "AMPMScheduleI", "Battery Page");

		ActionModule.click(driver, BatteryPage.DEPHEV.scheduleII(driver), "scheduleII", "Battery Page");


		scheduleII=ActionModule.getText(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "ToggleDEScheduleII", "Battery Page");
		if(scheduleOn.equalsIgnoreCase("ON"))
		{
			Log.info("Schedule is ON");
		}
		else
		{
			ActionModule.click(driver, BatteryPage.DEPHEV.ToggleDEScheduleII(driver), "ToggleDE", "Battery Page");
			Utils.sleep(driver, 3000);
		}

		disableDays(driver,"//*[contains(@ng-class,'dateSelectedDE2')]");

		ActionModule.click(driver, BatteryPage.DEPHEV.updateScheduleI(driver), "updateScheduleI", "Battery Schedule");
		Utils.sleep(driver, 2000);

		Utils.waitForElementToBeVisible(driver,BatteryPage.DEPHEV.noDaysDEMsg(driver));

		errorMsgII=ActionModule.getText(driver, BatteryPage.DEPHEV.noDaysDEMsg(driver), "days error", "Charging schedule");
		if(errorMsgII.contains("Please select"))
		{
			Utils.sleep(driver, 2000);
			Log.info("Error msg found ");
		}
		else
		{
			Log.error("Error msg not found ");
			Reporter.log("Error msg not found ");
			Assert.fail("Error msg not found ");

		}


		ActionModule.click(driver, BatteryPage.DEPHEV.hourScheduleII(driver), "scheduleIIhourEV1", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.newHourScheduleII(driver, hourI), "newHourScheduleI", "Battery Schedule");

		Utils.sleep(driver, 2000);
		ActionModule.click(driver, BatteryPage.DEPHEV.minScheduleII(driver), "minScheduleI", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.newMinScheduleII(driver, minI), "new mins schedule", "Battery Schedule");	

		ActionModule.click(driver, BatteryPage.DEPHEV.AMPMScheduleII(driver), "AMPMScheduleI", "Battery Schedule");
		ActionModule.click(driver, BatteryPage.DEPHEV.newAMPMScheduleII(driver, AMPMI), "newMinScheduleI", "Battery Schedule");	



		List<WebElement> webElementsI= null;
		webElementsI=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-class,'dateSelectedDE2(')]", "weekDays", "charging schedule");

		for(int i=0;i<selectedDaysI.length;i++)
		{
			if(selectedDaysI[i]==1 && !(webElementsI.get(i).getAttribute("class").contains("selected")))	
			{
				Utils.sleep(driver, 2000);

				if(Utils.waitForElementToBeClickable(driver, webElementsI.get(i)))
				{
					Log.info(webElementsI.get(i).getText()+ " is greyed out");
					count=1;
				}
				else
				{
					webElementsI.get(i).click();
				}
			}
			else
			{
				Log.info("Not selected in schedule");
			}
		}

		/**
		 * checking if the selected days are greyed out or not.
		 */
		if(count==1)
		{
			Log.info("Time/date greyed out");
		}
		else
		{
			Log.error("Time/date has not greyed out");
			Assert.fail("Time/date has not greyed out");
		}


	}


	public static int[] matchDaysEV1(WebDriver driver,String xpath)
	{
		List<WebElement> webElements= null;

		webElements=FindWebElement.findElementListByXpath(driver, xpath, "weekDays", "charging schedule");
		for(int i =0;i < webElements.size();i++)
		{
			if(webElements.get(i).getAttribute("class").contains("selected"))
			{
				selectedDays[i]=1;
			}
			else
			{
				Log.info("Day is already deselected");
			}
		}

		return selectedDays;
	}

	public static void aboutBatttery(WebDriver driver)
	{
		Utils.waitForElementToBeClickable(driver, BatteryPage.infoButton(driver));
Utils.sleep(driver, 3000);
		
		ActionModule.click(driver, BatteryPage.infoButton(driver), "info button", "Battery page");
		Utils.sleep(driver, 2000);
		try
		{
			ActionModule.isDisplayed(driver,BatteryPage.level1Info(driver),"level1 Info ","BatteryPage");

			ActionModule.isDisplayed(driver,BatteryPage.level2Info(driver),"level2 Info ","BatteryPage");
			if(Utils.getPlatform().contains("2.0"))
			{
				ActionModule.isDisplayed(driver,BatteryPage.dcfastInfo(driver),"DC fast Charge ","BatteryPage");

			}


			List<WebElement> webElements= null;
			webElements=FindWebElement.findElementListByXpath(driver, "//*[@class='content-care-tip']/ul/li", "points ", "about Battery");
			Log.info(webElements.size()+" Points found on about battery");

			Utils.sleep(driver, 2000);

			ActionModule.isDisplayed(driver,BatteryPage.closeAboutBattery(driver),"closeAboutBattery ","BatteryPage");
			ActionModule.click(driver,BatteryPage.closeAboutBattery(driver),"closeAboutBattery ","BatteryPage");

			Utils.waitForElementToBeClickable(driver, BatteryPage.infoButton(driver));
		}
		catch(Exception e)
		{
			if(Utils.waitForElementToBeClickable(driver, BatteryPage.closeAboutBattery(driver)))
			{
				ActionModule.click(driver,BatteryPage.closeAboutBattery(driver),"closeAboutBattery ","BatteryPage");

			}
		}



	}
	public static String hourSelection(WebDriver driver,String hour)
	{
		int newhour=1;
		String incrementedHour=null;
		
			if(Integer.parseInt(hour)< 12)
			{
				newhour=Integer.parseInt(hour)+1;
				if(newhour<10)	
				{
					incrementedHour = "0"+Integer.toString(newhour);
				}
				else
				{
					incrementedHour=Integer.toString(newhour);
				}

			}
			else if(Integer.parseInt(hour)==  12)

			{
				incrementedHour="01";
			}
			else
			{
				Log.info("hour time exceeds the limit");
			}
		return incrementedHour;
	}



	public static String minSelection(WebDriver driver,String min)
	{
		int newMin=0;
		String incrementedMin=null;
		if(Integer.parseInt(min) <50)
		{
			newMin=Integer.parseInt(min)+10;
			incrementedMin=Integer.toString(newMin);
		}
		else if(Integer.parseInt(min)==  50)
		{
			incrementedMin="00";
		}
		else
		{
			Log.info("Min time exceeds the limit");
		}
		return incrementedMin;
	}
}
