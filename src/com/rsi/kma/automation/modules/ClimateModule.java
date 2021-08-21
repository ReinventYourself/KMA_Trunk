package com.rsi.kma.automation.modules;


import java.util.List;

import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.rsi.kma.automation.pageObjects.ClimateControlPage;
import com.rsi.kma.automation.pageObjects.RemotePage;
import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Utils;

public class ClimateModule extends BaseClass{
	
private static Logger    Log = Logger.getLogger(LockUnlockModule.class.getName());

	
	/**
     * Navigate to the Climate page for EV1 and other vehicles
     * 
     * @param driver WebDriver
     * 
     */
	public static void NavigateToClimatePage(WebDriver driver)
	{
		
		// Navigate to overview page
		OverviewModule.NavigateToOverviewPage(driver);
		
		// In the case of EV 1 vehicle directly navigate to the Climate control tab
		if(Utils.getPlatform().equalsIgnoreCase("EV 1.0"))
			
			// Click on the climate tab link
			ActionModule.click(driver,MyCarLeftMenu.climateControl_Link(driver), "climateControl link", "Vehicle page");

		else{
			Utils.sleep(driver, 5000);
			// Wait for progress bar to be invisible
			Utils.waitForProgressbarInvisible(driver);
			
			// Navigate to remote page
			ActionModule.click(driver,MyCarLeftMenu.Remote_Link(driver), "Remote link", "Vehicle page");
			// Wait for progress bar to be invisible
			Utils.waitForProgressbarInvisible(driver);
		}
		Log.info("Succesfully navigated to Climate control Page");
	}
	
	public static void increaseClimateTemperature(WebDriver driver)
	{

            while (!RemotePage.Engine_And_Climate.Adjust_Temperature
                    .temperature(driver).getText().contains("89")) {
                Log.info("Temperature is not 89 degrees");

                ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.increase_Temp(driver), "Successfully clicked on Increase temperature button", "Climate Page");                
            }
            Log.info("Temperature now is 89 degrees");

            ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.increase_Temp(driver), "Successfully clicked on Increase temperature button", "Climate Page");            

            Assert.assertEquals(RemotePage.Engine_And_Climate.Adjust_Temperature
                    .temperature(driver).getText().toString(), "High");        
            Log.info("Highest temperature is HIGH");
	}

	
	public static void increaseScheduler1Temperature(WebDriver driver)
	{

            while (!RemotePage.Engine_And_Climate.Adjust_Temperature
                    .slide1_Temperature(driver).getText().contains("89")) {
                Log.info("Temperature is not 89 degrees");

                ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.increase_Schedule1_Temp(driver), "Successfully clicked on Increase temperature button", "Climate Page");                
            }
            Log.info("Temperature now is 89 degrees");

            ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.increase_Schedule1_Temp(driver), "Successfully clicked on Increase temperature button", "Climate Page");            

            Assert.assertEquals(RemotePage.Engine_And_Climate.Adjust_Temperature
                    .slide1_Temperature(driver).getText().toString(), "High");        
            Log.info("Highest temperature is HIGH");
	}
	
	public static void increaseScheduler2Temperature(WebDriver driver)
	{

            while (!RemotePage.Engine_And_Climate.Adjust_Temperature
                    .slide2_Temperature(driver).getText().contains("89")) {
                Log.info("Temperature is not 89 degrees");

                ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.increase_Schedule2_Temp(driver), "Successfully clicked on Increase temperature button", "Climate Page");                
            }
            Log.info("Temperature now is 89 degrees");

            ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.increase_Schedule2_Temp(driver), "Successfully clicked on Increase temperature button", "Climate Page");            

            Assert.assertEquals(RemotePage.Engine_And_Climate.Adjust_Temperature
                    .slide2_Temperature(driver).getText().toString(), "High");        
            Log.info("Highest temperature is HIGH");
	}
	
	public static void decreaseClimateTemperature(WebDriver driver)
	{

            while (!RemotePage.Engine_And_Climate.Adjust_Temperature
                    .temperature(driver).getText().contains("63")) {
                Log.info("Temperature is not 89 degrees");

                ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.decrease_Temp(driver), "Successfully clicked on decrease temperature button", "Climate Page");                
            }
            Log.info("Temperature now is 63 degrees");

            ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.decrease_Temp(driver), "Successfully clicked on decrease temperature button", "Climate Page");            

            Assert.assertEquals(RemotePage.Engine_And_Climate.Adjust_Temperature
                    .temperature(driver).getText().toString(), "Low");        
            Log.info("Lowest temperature is Low");
	}
	
	public static void decreaseScheduler1Temperature(WebDriver driver)
	{

            while (!RemotePage.Engine_And_Climate.Adjust_Temperature
                    .slide1_Temperature(driver).getText().contains("63")) {
                Log.info("Temperature is not 89 degrees");

                ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.decrease_Schedule1_Temp(driver), "Successfully clicked on decrease temperature button", "Climate Page");                
            }
            Log.info("Temperature now is 63 degrees");

            ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.decrease_Schedule1_Temp(driver), "Successfully clicked on decrease temperature button", "Climate Page");            

            Assert.assertEquals(RemotePage.Engine_And_Climate.Adjust_Temperature
                    .slide1_Temperature(driver).getText().toString(), "Low");        
            Log.info("Lowest temperature is Low");
	}
	
	public static void decreaseScheduler2Temperature(WebDriver driver)
	{

            while (!RemotePage.Engine_And_Climate.Adjust_Temperature
                    .slide2_Temperature(driver).getText().contains("63")) {
                Log.info("Temperature is not 89 degrees");

                ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.decrease_Schedule2_Temp(driver), "Successfully clicked on decrease temperature button", "Climate Page");                
            }
            Log.info("Temperature now is 63 degrees");

            ActionModule.click(driver, RemotePage.Engine_And_Climate.Adjust_Temperature.decrease_Schedule2_Temp(driver), "Successfully clicked on decrease temperature button", "Climate Page");            

            Assert.assertEquals(RemotePage.Engine_And_Climate.Adjust_Temperature
                    .slide2_Temperature(driver).getText().toString(), "Low");        
            Log.info("Lowest temperature is Low");
	}
	
	public static boolean startClimate(WebDriver driver){
		boolean climateControlStarted = false;
		
		// Click on the start climate button
		ActionModule.click(driver,ClimateControlPage.TemperatureGauge.startClimateButton(driver), "start climate button", "Climate control page");
		Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.ventilationWarning(driver));
		if(Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.cancelWarning(driver))){
			ActionModule.click(driver,ClimateControlPage.TemperatureGauge.cancelWarning(driver), "cancel warning button", "Climate control page");
			ActionModule.click(driver,ClimateControlPage.TemperatureGauge.startClimateButton(driver), "start climate button", "Climate control page");
			Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.ventilationWarning(driver));
			climateControlStarted = true;
		}
		if(Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.confirmWarning(driver))){
		ActionModule.click(driver,ClimateControlPage.TemperatureGauge.confirmWarning(driver), "confirm warning button", "Climate control page");
		}
		if(Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.defrosterOff(driver))){
			Log.info("Defroster is OFF and climate control started");			
		}
		else if(Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.defrosterOn(driver))){
			Log.info("Defroster is ON and climate control started");
		}
		Utils.waitForElementToBeInvisible(driver,ClimateControlPage.TemperatureGauge.settingClimateText(driver));
		Utils.waitForElementToBeInvisible(driver, ClimateControlPage.TemperatureGauge.startingClimateText(driver));
		Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.climateOnText(driver));
		Utils.sleep(driver, 120000);
		return climateControlStarted;
	}
	
	public static void defrosterON(WebDriver driver){

		if(Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.defrosterOff(driver))){
			ActionModule.click(driver,ClimateControlPage.TemperatureGauge.defrosterOff(driver), "Defroster Off/On button", "Climate control page");
		}
		
	}
	
	public static boolean checkNotificationAndCommandLogForRemoteCommand(WebDriver driver, String remoteCommand){
		
		//String vehicleStatus = lockUnlockStatus(driver);
		boolean notificationAndCommandStatus = false;
		String statusCommand = null;
		
		// Navigate to the notifications tab
		ActionModule.click(driver, HeaderPage.notifications_Link(driver), "notifications_Link", "HeaderPage");
		Utils.sleep(driver, 2000);
		
		if(remoteCommand == "Climate ON"){
			// Verify the notification is present for the remote command
			ActionModule.isDisplayed(driver,ClimateControlPage.TemperatureGauge.vehicleRemoteNotificationClimateStart(driver), "vehicleNotification", "Climate control page");
			Utils.sleep(driver, 2000);
		}
		else if(remoteCommand == "Climate OFF"){
			// Verify the notification is present for the remote command
			ActionModule.isDisplayed(driver,ClimateControlPage.TemperatureGauge.vehicleRemoteNotificationClimateStop(driver), "vehicleNotification", "Climate control page");
			Utils.sleep(driver, 2000);
		} 	
		
		// Navigate to settings tab
		ActionModule.click(driver, HeaderPage.settingsLink(driver), "settingsLink", "HeaderPage");
		Utils.sleep(driver, 2000);
		
		// Go to command log link
		ActionModule.click(driver, HeaderPage.commandLogLink(driver), "commandLogLink", "HeaderPage");
		Utils.sleep(driver, 5000);
		if(remoteCommand == "Climate ON"){
		// Check the remote command
			ActionModule.isDisplayed(driver, HeaderPage.climateStartCommandLog(driver), "remoteCommandLog", "HeaderPage");
			statusCommand=HeaderPage.climateStartCommandLog(driver).getAttribute("class");
		}
		else if(remoteCommand == "Climate OFF"){
			// Check the remote command
			ActionModule.isDisplayed(driver, HeaderPage.climateStopCommandLog(driver), "remoteCommandLog", "HeaderPage");
			statusCommand=HeaderPage.climateStopCommandLog(driver).getAttribute("class");
		}
		// Verify the status of the remote command in command log
//		String statusCommand=HeaderPage.doorCommandLog(driver).getAttribute("class");
		if(statusCommand.contains("green"))
		{
			Log.info("Remote command found for Climate");
			notificationAndCommandStatus = true;
		}
		else
		{	
			Log.error("Command not found or command failed ");
			Assert.fail("Command not found or command failed ");
		}
		
			
		return notificationAndCommandStatus;
		
	}
	
	public static void stopClimate(WebDriver driver){
		
		// Click on the start climate button
		ActionModule.click(driver,ClimateControlPage.TemperatureGauge.stopClimateButton(driver), "stop climate button", "Climate control page");
		Utils.waitForElementToBeInvisible(driver,ClimateControlPage.TemperatureGauge.settingClimateText(driver));
		Utils.waitForElementToBeInvisible(driver, ClimateControlPage.TemperatureGauge.startingClimateText(driver));
		Utils.waitForElementToBeInvisible(driver,ClimateControlPage.TemperatureGauge.settingClimateText(driver));
		Utils.waitForElementToBeInvisible(driver, ClimateControlPage.TemperatureGauge.stoppingClimateText(driver));
		Utils.sleep(driver, 120000);
	}
	
	// Setting the schedule 1 and cancel
	public static void setSchedule1AndCancel(WebDriver driver){
		Utils.sleep(driver, 10000);
		Utils.waitForElementToBeClickable(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
                .expand_Schedule(driver));
		ActionModule.click(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
                .expand_Schedule(driver), "First climate schedule is expanded", "Climate control page");  
		
		String scheduleStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_On_Off_Button(driver), "schedule1_On_Off_Button", "Climate control page");
		if(scheduleStatus.equalsIgnoreCase("off")){
			Log.info("Schedule Status is off switching it on");
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_On_Off_Button(driver), "Schedule button is ON", "Climate control page");  
		}
		else if(scheduleStatus.equalsIgnoreCase("on")){
			Log.info("Schedule Status is off switching it off");
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_On_Off_Button(driver), "Schedule button is OFF", "Climate control page");  
		}
		String defrosterStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster1_Button(driver), "defroster_On_Off_Button", "Climate control page");
		if(defrosterStatus.equalsIgnoreCase("off")){
			Log.info("Defroster is OFF switching it on");
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster1_Button(driver), "defroster button is ON", "Climate control page");  
		}
		else if(defrosterStatus.equalsIgnoreCase("on")){
			Log.info("Defroster is On switching it off");
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster1_Button(driver), "defroster button is off", "Climate control page");  
		}
		
		String initialTemperature = RemotePage.Engine_And_Climate.Adjust_Temperature.slide1_Temperature(driver).getText();
		Log.info("The initial temperature value is : " + initialTemperature);
		increaseScheduler1Temperature(driver);
		decreaseScheduler1Temperature(driver);
		String scheduleHours = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_hour_value(driver), "schedule1_hour_value", "Climate control page");
		String scheduleMinutes = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_minute_value(driver), "schedule1_minute_value", "Climate control page");
		String scheduleAmPm = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
		String incrementedHourValue = hourSelection(driver, scheduleHours);
		Log.info("The value of incremented hours is : " + incrementedHourValue);
		String incremetedMinuteValue = minSelection(driver, scheduleMinutes);
		Log.info("The value of incremented minute is : " + incremetedMinuteValue);
		
		ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_hour_value(driver), "schedule1_hour_value", "Climate control page");
		ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newHourScheduleI(driver, incrementedHourValue), "newHourScheduleI", "Climate control page");
		
		
		Utils.sleep(driver, 2000);
		ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_minute_value(driver), "minScheduleI", "Climate control page");
		Utils.sleep(driver, 2000);
		ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newMinScheduleI(driver, incremetedMinuteValue), "new mins schedule", "Climate control page");
		if(scheduleAmPm.equalsIgnoreCase("AM")){
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newScheduleI_am_pm_value(driver, "PM"), "newScheduleI_am_pm_value", "Climate control page");
		}
		else if(scheduleAmPm.equalsIgnoreCase("PM")){
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newScheduleI_am_pm_value(driver, "AM"), "newScheduleI_am_pm_value", "Climate control page");
		}
		enableDisableDaysAndDisableEnableDays(driver, "//*[@id='climateScheduleI']/div[@class='calendar']/div[@class='weekDays']/div");
		ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_cancel_button(driver), "Cancelling schedule", "Climate control page");
		Utils.sleep(driver, 20000);
		Utils.waitForElementToBeClickable(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
                .expand_Schedule(driver));
		ActionModule.click(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
                .expand_Schedule(driver), "First climate schedule is expanded", "Climate control page");
		Utils.sleep(driver, 2000);
		String updatedScheduleStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_On_Off_Button(driver), "schedule1_On_Off_Button", "Climate control page");
		Log.info("The updated schedule status value is: " + updatedScheduleStatus);
		Log.info("The schedule status value is: " + scheduleStatus);
		String updatedDefrosterStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster1_Button(driver), "defroster_On_Off_Button", "Climate control page");
		Log.info("The updated Defroster status value is: " + updatedDefrosterStatus);
		Log.info("The Defroster status value is: " + defrosterStatus);
		String updatedScheduleHours = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_hour_value(driver), "schedule1_hour_value", "Climate control page");
		Log.info("The updated Schedule Hours value is: " + updatedScheduleHours);
		Log.info("The Schedule Hours value is: " + scheduleHours);
		String updatedScheduleMinutes = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_minute_value(driver), "schedule1_minute_value", "Climate control page");
		Log.info("The updated Schedule minutes value is: " + updatedScheduleMinutes);
		Log.info("The Schedule minutes value is: " + scheduleMinutes);
		String updatedScheduleAmPm = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
		Log.info("The updated Schedule am pm value is: " + updatedScheduleAmPm);
		Log.info("The Schedule am pm value is: " + scheduleAmPm);
		String updatedTemperature = RemotePage.Engine_And_Climate.Adjust_Temperature.slide1_Temperature(driver).getText();
		Log.info("The updated temperature value is: " + updatedTemperature);
		Log.info("The temperature value is: " + initialTemperature);
		assertEquals(updatedScheduleStatus, scheduleStatus, "schedule status didn't match");
		assertEquals(updatedDefrosterStatus, defrosterStatus, "defroster status didn't match");
		assertEquals(updatedScheduleHours, scheduleHours, "schedule hours didn't match");
		assertEquals(updatedScheduleMinutes, scheduleMinutes, "schedule minutes didn't match");
		assertEquals(updatedScheduleAmPm, scheduleAmPm, "schedule Am PM value didn't match");
		assertEquals(initialTemperature, updatedTemperature, "Temperature didn't match");
		
	}
	
	// Setting the schedule 2 and cancel
		public static void setSchedule2AndCancel(WebDriver driver){
			Utils.sleep(driver, 10000);
			Utils.waitForElementToBeClickable(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	                .expand_Schedule2(driver));
			ActionModule.click(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	                .expand_Schedule2(driver), "Second climate schedule is expanded", "Climate control page");  
			
			String scheduleStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_On_Off_Button(driver), "schedule1_On_Off_Button", "Climate control page");
			if(scheduleStatus.equalsIgnoreCase("off")){
				Log.info("Schedule Status is off switching it on");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_On_Off_Button(driver), "Schedule button is ON", "Climate control page");  
			}
			else if(scheduleStatus.equalsIgnoreCase("on")){
				Log.info("Schedule Status is off switching it off");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_On_Off_Button(driver), "Schedule button is OFF", "Climate control page");  
			}
			String defrosterStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster2_Button(driver), "defroster_On_Off_Button", "Climate control page");
			if(defrosterStatus.equalsIgnoreCase("off")){
				Log.info("Defroster is OFF switching it on");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster2_Button(driver), "defroster button is ON", "Climate control page");  
			}
			else if(defrosterStatus.equalsIgnoreCase("on")){
				Log.info("Defroster is On switching it off");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster2_Button(driver), "defroster button is off", "Climate control page");  
			}
			
			String initialTemperature = RemotePage.Engine_And_Climate.Adjust_Temperature.slide2_Temperature(driver).getText();
			Log.info("The initial temperature value is : " + initialTemperature);
			increaseScheduler2Temperature(driver);
			decreaseScheduler2Temperature(driver);
			String scheduleHours = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_hour_value(driver), "schedule2_hour_value", "Climate control page");
			String scheduleMinutes = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_minute_value(driver), "schedule2_minute_value", "Climate control page");
			String scheduleAmPm = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_am_pm_value(driver), "schedule2_am_pm_value", "Climate control page");
			String incrementedHourValue = hourSelection(driver, scheduleHours);
			Log.info("The value of incremented hours is : " + incrementedHourValue);
			String incremetedMinuteValue = minSelection(driver, scheduleMinutes);
			Log.info("The value of incremented minute is : " + incremetedMinuteValue);
			
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_hour_value(driver), "schedule1_hour_value", "Climate control page");
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newHourScheduleII(driver, incrementedHourValue), "newHourScheduleII", "Climate control page");
			
			
			Utils.sleep(driver, 2000);
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_minute_value(driver), "minScheduleII", "Climate control page");
			Utils.sleep(driver, 2000);
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newMinScheduleII(driver, incremetedMinuteValue), "new mins schedule", "Climate control page");
			if(scheduleAmPm.equalsIgnoreCase("AM")){
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_am_pm_value(driver), "schedule2_am_pm_value", "Climate control page");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newScheduleII_am_pm_value(driver, "PM"), "newScheduleI_am_pm_value", "Climate control page");
			}
			else if(scheduleAmPm.equalsIgnoreCase("PM")){
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newScheduleII_am_pm_value(driver, "AM"), "newScheduleI_am_pm_value", "Climate control page");
			}
			enableDisableDaysAndDisableEnableDays(driver, "//*[@id='climateScheduleII']/div[@class='calendar']/div[@class='weekDays']/div");
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_cancel_button(driver), "Cancelling schedule", "Climate control page");
			Utils.sleep(driver, 20000);
			Utils.waitForElementToBeClickable(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	                .expand_Schedule2(driver));
			ActionModule.click(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	                .expand_Schedule2(driver), "Second climate schedule is expanded", "Climate control page");
			Utils.sleep(driver, 2000);
			String updatedScheduleStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_On_Off_Button(driver), "schedule1_On_Off_Button", "Climate control page");
			Log.info("The updated schedule status value is: " + updatedScheduleStatus);
			Log.info("The schedule status value is: " + scheduleStatus);
			String updatedDefrosterStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster2_Button(driver), "defroster_On_Off_Button", "Climate control page");
			Log.info("The updated Defroster status value is: " + updatedDefrosterStatus);
			Log.info("The Defroster status value is: " + defrosterStatus);
			String updatedScheduleHours = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_hour_value(driver), "schedule1_hour_value", "Climate control page");
			Log.info("The updated Schedule Hours value is: " + updatedScheduleHours);
			Log.info("The Schedule Hours value is: " + scheduleHours);
			String updatedScheduleMinutes = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_minute_value(driver), "schedule1_minute_value", "Climate control page");
			Log.info("The updated Schedule minutes value is: " + updatedScheduleMinutes);
			Log.info("The Schedule minutes value is: " + scheduleMinutes);
			String updatedScheduleAmPm = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
			Log.info("The updated Schedule am pm value is: " + updatedScheduleAmPm);
			Log.info("The Schedule am pm value is: " + scheduleAmPm);
			String updatedTemperature = RemotePage.Engine_And_Climate.Adjust_Temperature.slide2_Temperature(driver).getText();
			Log.info("The updated temperature value is: " + updatedTemperature);
			Log.info("The temperature value is: " + initialTemperature);
			assertEquals(updatedScheduleStatus, scheduleStatus, "schedule status didn't match");
			assertEquals(updatedDefrosterStatus, defrosterStatus, "defroster status didn't match");
			assertEquals(updatedScheduleHours, scheduleHours, "schedule hours didn't match");
			assertEquals(updatedScheduleMinutes, scheduleMinutes, "schedule minutes didn't match");
			assertEquals(updatedScheduleAmPm, scheduleAmPm, "schedule Am PM value didn't match");
			assertEquals(initialTemperature, updatedTemperature, "Temperature didn't match");
			
		}
		
		
		// Setting the schedule 2
				public static void setSchedule2(WebDriver driver){
					Utils.sleep(driver, 10000);
//					Utils.waitForElementToBeClickable(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
//			                .expand_Schedule2(driver));
//					ActionModule.click(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
//			                .expand_Schedule2(driver), "Second climate schedule is expanded", "Climate control page");  
					
					String scheduleStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_On_Off_Button(driver), "schedule1_On_Off_Button", "Climate control page");
					if(scheduleStatus.equalsIgnoreCase("off")){
						Log.info("Schedule Status is off switching it on");
						ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_On_Off_Button(driver), "Schedule button is ON", "Climate control page");  
					}
					else if(scheduleStatus.equalsIgnoreCase("on")){
						Log.info("Schedule Status is off switching it off");
						ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_On_Off_Button(driver), "Schedule button is OFF", "Climate control page");  
					}
					String defrosterStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster2_Button(driver), "defroster_On_Off_Button", "Climate control page");
					if(defrosterStatus.equalsIgnoreCase("off")){
						Log.info("Defroster is OFF switching it on");
						ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster2_Button(driver), "defroster button is ON", "Climate control page");  
					}
					else if(defrosterStatus.equalsIgnoreCase("on")){
						Log.info("Defroster is On switching it off");
						ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster2_Button(driver), "defroster button is off", "Climate control page");  
					}
					
					String initialTemperature = RemotePage.Engine_And_Climate.Adjust_Temperature.slide2_Temperature(driver).getText();
					Log.info("The initial temperature value is : " + initialTemperature);
					increaseScheduler2Temperature(driver);
					decreaseScheduler2Temperature(driver);
					String scheduleHours = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_hour_value(driver), "schedule2_hour_value", "Climate control page");
					String scheduleMinutes = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_minute_value(driver), "schedule2_minute_value", "Climate control page");
					String scheduleAmPm = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_am_pm_value(driver), "schedule2_am_pm_value", "Climate control page");
					String incrementedHourValue = hourSelection(driver, scheduleHours);
					Log.info("The value of incremented hours is : " + incrementedHourValue);
					String incremetedMinuteValue = minSelection(driver, scheduleMinutes);
					Log.info("The value of incremented minute is : " + incremetedMinuteValue);
					
					ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_hour_value(driver), "schedule1_hour_value", "Climate control page");
					ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newHourScheduleII(driver, incrementedHourValue), "newHourScheduleII", "Climate control page");
					
					
					Utils.sleep(driver, 2000);
					ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_minute_value(driver), "minScheduleII", "Climate control page");
					Utils.sleep(driver, 2000);
					ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newMinScheduleII(driver, incremetedMinuteValue), "new mins schedule", "Climate control page");
					if(scheduleAmPm.equalsIgnoreCase("AM")){
						ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_am_pm_value(driver), "schedule2_am_pm_value", "Climate control page");
						ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newScheduleII_am_pm_value(driver, "PM"), "newScheduleI_am_pm_value", "Climate control page");
					}
					else if(scheduleAmPm.equalsIgnoreCase("PM")){
						ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
						ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newScheduleII_am_pm_value(driver, "AM"), "newScheduleI_am_pm_value", "Climate control page");
					}
					enableDisableDaysAndDisableEnableDaysSchedule2(driver, "//*[@id='climateScheduleII']/div[@class='calendar']/div[@class='weekDays']/div");
					// Setting the schedule
					ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_setSchedule_button(driver), "Setting schedule", "Climate control page");
					if(Utils.waitForElementToBeVisible(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule_confirm_alert_button(driver))){
						ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule_confirm_alert_button(driver), "Confirming schedule", "Climate control page");
					}
					Utils.waitForElementToBeVisible(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_success_button(driver));
					Utils.sleep(driver, 20000);
//					Utils.waitForElementToBeClickable(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
//			                .expand_Schedule2(driver));
//					ActionModule.click(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
//			                .expand_Schedule2(driver), "Second climate schedule is expanded", "Climate control page");
					Utils.sleep(driver, 2000);
					String updatedScheduleStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_On_Off_Button(driver), "schedule1_On_Off_Button", "Climate control page");
					Log.info("The updated schedule status value is: " + updatedScheduleStatus);
					Log.info("The schedule status value is: " + scheduleStatus);
					String updatedDefrosterStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster2_Button(driver), "defroster_On_Off_Button", "Climate control page");
					Log.info("The updated Defroster status value is: " + updatedDefrosterStatus);
					Log.info("The Defroster status value is: " + defrosterStatus);
					String updatedScheduleHours = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_hour_value(driver), "schedule1_hour_value", "Climate control page");
					Log.info("The updated Schedule Hours value is: " + updatedScheduleHours);
					Log.info("The Schedule Hours value is: " + scheduleHours);
					String updatedScheduleMinutes = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_minute_value(driver), "schedule1_minute_value", "Climate control page");
					Log.info("The updated Schedule minutes value is: " + updatedScheduleMinutes);
					Log.info("The Schedule minutes value is: " + scheduleMinutes);
					String updatedScheduleAmPm = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
					Log.info("The updated Schedule am pm value is: " + updatedScheduleAmPm);
					Log.info("The Schedule am pm value is: " + scheduleAmPm);
					String updatedTemperature = RemotePage.Engine_And_Climate.Adjust_Temperature.slide2_Temperature(driver).getText();
					Log.info("The updated temperature value is: " + updatedTemperature);
					Log.info("The temperature value is: " + initialTemperature);
					assertNotEquals(updatedScheduleStatus, scheduleStatus, "schedule status match");
					assertNotEquals(updatedDefrosterStatus, defrosterStatus, "defroster status match");
					assertNotEquals(updatedScheduleHours, scheduleHours, "schedule hours match");
					assertNotEquals(updatedScheduleMinutes, scheduleMinutes, "schedule minutes match");
					assertNotEquals(updatedScheduleAmPm, scheduleAmPm, "schedule Am PM value match");
					if(initialTemperature.equalsIgnoreCase("Low")){
						assertEquals(initialTemperature, updatedTemperature, "Temperature match");
					}
					else{
						assertNotEquals(initialTemperature, updatedTemperature, "Temperature match");
					}
					Utils.sleep(driver, 120000);
				}
	
	
	// Setting the schedule 1
		public static void setSchedule1(WebDriver driver){
			Utils.sleep(driver, 10000);
			Utils.waitForElementToBeClickable(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	                .expand_Schedule(driver));
			ActionModule.click(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	                .expand_Schedule(driver), "First climate schedule is expanded", "Climate control page");  
			
			String scheduleStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_On_Off_Button(driver), "schedule1_On_Off_Button", "Climate control page");
			if(scheduleStatus.equalsIgnoreCase("off")){
				Log.info("Schedule Status is off switching it on");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_On_Off_Button(driver), "Schedule button is ON", "Climate control page");  
			}
			else if(scheduleStatus.equalsIgnoreCase("on")){
				Log.info("Schedule Status is off switching it off");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_On_Off_Button(driver), "Schedule button is OFF", "Climate control page");  
			}
			String defrosterStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster1_Button(driver), "defroster_On_Off_Button", "Climate control page");
			if(defrosterStatus.equalsIgnoreCase("off")){
				Log.info("Defroster is OFF switching it on");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster1_Button(driver), "defroster button is ON", "Climate control page");  
			}
			else if(defrosterStatus.equalsIgnoreCase("on")){
				Log.info("Defroster is On switching it off");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster1_Button(driver), "defroster button is off", "Climate control page");  
			}
			
			String initialTemperature = RemotePage.Engine_And_Climate.Adjust_Temperature.slide1_Temperature(driver).getText();
			Log.info("The initial temperature value is : " + initialTemperature);
			increaseScheduler1Temperature(driver);
			decreaseScheduler1Temperature(driver);
			String scheduleHours = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_hour_value(driver), "schedule1_hour_value", "Climate control page");
			String scheduleMinutes = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_minute_value(driver), "schedule1_minute_value", "Climate control page");
			String scheduleAmPm = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
			String incrementedHourValue = hourSelection(driver, scheduleHours);
			Log.info("The value of incremented hours is : " + incrementedHourValue);
			String incremetedMinuteValue = minSelection(driver, scheduleMinutes);
			Log.info("The value of incremented minute is : " + incremetedMinuteValue);
			
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_hour_value(driver), "schedule1_hour_value", "Climate control page");
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newHourScheduleI(driver, incrementedHourValue), "newHourScheduleI", "Climate control page");
			
			
			Utils.sleep(driver, 2000);
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_minute_value(driver), "minScheduleI", "Climate control page");
			Utils.sleep(driver, 2000);
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newMinScheduleI(driver, incremetedMinuteValue), "new mins schedule", "Climate control page");
			if(scheduleAmPm.equalsIgnoreCase("AM")){
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newScheduleI_am_pm_value(driver, "PM"), "newScheduleI_am_pm_value", "Climate control page");
			}
			else if(scheduleAmPm.equalsIgnoreCase("PM")){
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.newScheduleI_am_pm_value(driver, "AM"), "newScheduleI_am_pm_value", "Climate control page");
			}
			enableDisableDaysAndDisableEnableDaysSchedule2(driver, "//*[@id='climateScheduleI']/div[@class='calendar']/div[@class='weekDays']/div");
			
			// Setting the schedule
			ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_setSchedule_button(driver), "Setting schedule", "Climate control page");
			if(Utils.waitForElementToBeVisible(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule_confirm_alert_button(driver))){
				ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule_confirm_alert_button(driver), "Confirming schedule", "Climate control page");
			}
			Utils.waitForElementToBeVisible(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_success_button(driver));
			Utils.sleep(driver, 20000);
//			Utils.waitForElementToBeClickable(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
//	                .expand_Schedule(driver));
//			ActionModule.click(driver, RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
//	                .expand_Schedule(driver), "First climate schedule is expanded", "Climate control page");
			Utils.sleep(driver, 2000);
			String updatedScheduleStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_On_Off_Button(driver), "schedule1_On_Off_Button", "Climate control page");
			Log.info("The updated schedule status value is: " + updatedScheduleStatus);
			Log.info("The schedule status value is: " + scheduleStatus);
			String updatedDefrosterStatus = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.defroster1_Button(driver), "defroster_On_Off_Button", "Climate control page");
			Log.info("The updated Defroster status value is: " + updatedDefrosterStatus);
			Log.info("The Defroster status value is: " + defrosterStatus);
			String updatedScheduleHours = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_hour_value(driver), "schedule1_hour_value", "Climate control page");
			Log.info("The updated Schedule Hours value is: " + updatedScheduleHours);
			Log.info("The Schedule Hours value is: " + scheduleHours);
			String updatedScheduleMinutes = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_minute_value(driver), "schedule1_minute_value", "Climate control page");
			Log.info("The updated Schedule minutes value is: " + updatedScheduleMinutes);
			Log.info("The Schedule minutes value is: " + scheduleMinutes);
			String updatedScheduleAmPm = ActionModule.getText(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_am_pm_value(driver), "schedule1_am_pm_value", "Climate control page");
			Log.info("The updated Schedule am pm value is: " + updatedScheduleAmPm);
			Log.info("The Schedule am pm value is: " + scheduleAmPm);
			String updatedTemperature = RemotePage.Engine_And_Climate.Adjust_Temperature.slide1_Temperature(driver).getText();
			Log.info("The updated temperature value is: " + updatedTemperature);
			Log.info("The temperature value is: " + initialTemperature);
			assertNotEquals(updatedScheduleStatus, scheduleStatus, "schedule status match");
			assertNotEquals(updatedDefrosterStatus, defrosterStatus, "defroster status match");
			assertNotEquals(updatedScheduleHours, scheduleHours, "schedule hours match");
			assertNotEquals(updatedScheduleMinutes, scheduleMinutes, "schedule minutes match");
			assertNotEquals(updatedScheduleAmPm, scheduleAmPm, "schedule Am PM value match");
			if(initialTemperature.equalsIgnoreCase("Low")){
				assertEquals(initialTemperature, updatedTemperature, "Temperature match");
			}
			else{
				assertNotEquals(initialTemperature, updatedTemperature, "Temperature match");
			}
			Utils.sleep(driver, 120000);
		}
	
	
	
	public static String hourSelection(WebDriver driver,String hour)
	{
		int newhour=1;
		String incrementedHour=null;
		if(hour.contains(""))
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
                        webElements.get(i).click();
                  }
                  else
                  {
                        Log.info("Day is already deselected");
                  }
           }

    }
	
	public static void enableDisableDaysAndDisableEnableDays(WebDriver driver,String xpath)
    {

           Utils.sleep(driver, 3000);
           List<WebElement> webElements= null;
           webElements=FindWebElement.findElementListByXpath(driver, xpath, "weekDays", "charging schedule");
           for(int i =0;i<webElements.size(); i++)
           {
        	   Utils.sleep(driver, 1000);
               webElements.get(i).click();
           }   	   
        	   if(!Utils.waitForElementToBeVisible(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_day_selected(driver)))
                {
                       Utils.sleep(driver, 1000);
                       ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule1_day_monday(driver), "schedule1_day_monday click", "Climate control page");
                 }
        	   else{
        		   Log.info("Days are already selected");
        	   }
    
    }
	
	public static void enableDisableDaysAndDisableEnableDaysSchedule2(WebDriver driver,String xpath)
    {

           Utils.sleep(driver, 3000);
           List<WebElement> webElements= null;
           webElements=FindWebElement.findElementListByXpath(driver, xpath, "weekDays", "charging schedule");
           for(int i =0;i<webElements.size(); i++)
           {
        	   Utils.sleep(driver, 1000);
               webElements.get(i).click();
           }   	   
        	   if(!Utils.waitForElementToBeVisible(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_day_selected(driver)))
                {
                       Utils.sleep(driver, 1000);
                       ActionModule.click(driver, ClimateControlPage.ClimateSchedule.ScheduleI.schedule2_day_monday(driver), "schedule2_day_monday click", "Climate control page");
                 }
        	   else{
        		   Log.info("Days are already selected");
        	   }
    
    }

	
	 
	
	public static void checkSameSchedule(String hour, String minutes, String am_pm, String day){
	      String[] days = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
	        boolean firstScheduleOFF = true, secondScheduleOFF = true;

	        
	        Log.info("navigate_To_Remote_Page has executed");

	        /************************* Setting time and day for First schedule **************************/

	        RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	        .expand_Schedule(driver).click();
	        Log.info("First climate schedule is expanded");

	        /**
	         * Toggling first schedule ON
	         */
	        if (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	                .schedule_OFF(driver) != null) {

	            RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	            .schedule_OFF(driver).click();
	            Log.info("First schedule is turned ON");
	            
	        }else {
	            firstScheduleOFF = false;
	        }

	        /**
	         * Selecting hour
	         */
	        if (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule.Calendar
	                .hour(driver, hour)) {
	            Log.info("Hour selection is successful");
	        } else {
	            Assert.fail(hour + " hour is not selected");
	        }

	        /**
	         * Selecting minute
	         */
	        if (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule.Calendar
	                .minute(driver, minutes)) {
	            Log.info("Minutes selection is successful");
	        } else {
	            Assert.fail(minutes + " minutes are not selected");
	        }

	        /**
	         * Selecting am/pm
	         */
	        if (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule.Calendar
	                .am_pm(driver, am_pm.toUpperCase())) {
	            Log.info("AM/PM selection is successful");
	        } else {
	            Assert.fail(am_pm.toUpperCase() + " is not selected");
	        }

	        /**
	         * Selecting 'day' and de-selecting all others
	         */
	        for (String deselect_Day : days) {
	            if (deselect_Day.equals(day)
	                    && RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule.Calendar
	                    .select_Day(driver, day) != null) {
	                RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule.Calendar
	                .select_Day(driver, day).click();
	                Log.info(day + "DAY is selected");
	            } else if (!deselect_Day.equals(day)
	                    && (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule.Calendar
	                            .deselect_Day(driver, deselect_Day) != null)) {

	                RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule.Calendar
	                .deselect_Day(driver, deselect_Day).click();
	                Log.info(deselect_Day + "DAY is de-selected");
	            }
	        }

	        RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	        .schedule_Button(driver).click();
	        if(Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.ventilationWarning(driver))){
	        	ActionModule.click(driver,ClimateControlPage.TemperatureGauge.confirmWarningSchedule(driver), "confirm warning button", "Climate control page");
	        }
	        Log.info("Successfully clicked on Schedule button");

	        Utils.waitForElementToBeVisible(
	                driver,
	                RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	                .success_Button(driver));
	        Log.info("Schedule is successfully set");

	        /************************* Setting time and day for Second schedule **************************/

	        RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule
	        .expand_Schedule(driver).click();
	        Log.info("Second climate schedule is expanded");

	        /**
	         * Toggling second schedule ON
	         */
	        if (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule
	                .schedule_OFF(driver) != null) {

	            RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule
	            .schedule_OFF(driver).click();
	            Log.info("Second schedule is turned ON");
	        }else {
	            secondScheduleOFF = true;
	        }

	        /**
	         * Selecting hour
	         */
	        if (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule.Calendar
	                .hour(driver, hour)) {
	            Log.info("Hour selection is successful");
	        } else {
	            Assert.fail(hour + " hour is not selected");
	        }

	        /**
	         * Selecting minute
	         */
	        if (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule.Calendar
	                .minute(driver, minutes)) {
	            Log.info("Minutes selection is successful");
	        } else {
	            Assert.fail(minutes + " minutes are not selected");
	        }

	        /**
	         * Selecting am/pm
	         */
	        if (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule.Calendar
	                .am_pm(driver, am_pm.toUpperCase())) {
	            Log.info("AM/PM selection is successful");
	        } else {
	            Assert.fail(am_pm.toUpperCase() + " is not selected");
	        }

	        /**
	         * Selecting 'day' and de-selecting all others
	         */
	        for (String deselect_Day : days) {
	            if (deselect_Day.equals(day)
	                    && RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule.Calendar
	                    .select_Day(driver, day) != null) {
	                RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule.Calendar
	                .select_Day(driver, day).click();
	                Log.info(day + "DAY is selected");
	            } else if (!deselect_Day.equals(day)
	                    && (RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule.Calendar
	                            .deselect_Day(driver, deselect_Day) != null)) {

	                RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule.Calendar
	                .deselect_Day(driver, deselect_Day).click();
	                Log.info(deselect_Day + "DAY is de-selected");
	            }
	        }

	        RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule
	        .schedule_Button(driver).click();
	        if(Utils.waitForElementToBeVisible(driver, ClimateControlPage.TemperatureGauge.ventilationWarning(driver))){
	        	ActionModule.click(driver,ClimateControlPage.TemperatureGauge.confirmWarningSchedule(driver), "confirm warning button", "Climate control page");
	        }
	        Log.info("Successfully clicked on Schedule button");

	        /**
	         * Checking if error is thrown for setting same schedule
	         */
	        try {
	            Utils.waitForElementToBeVisible(
	                    driver,
	                    RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule
	                    .same_Schedule_Error(driver));
	            Log.info("Same schedule error is found");

	            String error = RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule
	                    .same_Schedule_Error(driver).getText();
	            Log.info(error);
	            if (error.contains(day)) {                    
	                Log.info("Correct days are shown in the error");
	            } else {
	                Log.error("Correct days are not shown in the error");
	                Assert.fail("Correct days are not shown in the error");
	            }
	            Log.info(RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule
	                    .same_Schedule_Message(driver).getText());
	                          
	            
	        } catch (Exception e) {
	            Log.error("Same schedule error is not shown");
	            Reporter.log("Same schedule error is not shown");
	            Assert.fail("Same schedule error is not shown");
	        } finally {
	            /**
	             * Turning schedule ON/OFF whatever was default
	             */
	            try{
	                if (firstScheduleOFF)
	                    RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.First_Schedule
	                    .schedule_ON(driver).click();
	                
	                if (secondScheduleOFF)
	                    RemotePage.Engine_And_Climate.Engine_And_Climate_Schedules.Second_Schedule
	                    .schedule_ON(driver).click();                
	            } catch (Exception e){
	                
	            }
	        }   
	    }   
	}
	
	


