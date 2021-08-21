package com.rsi.kma.automation.modules;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.rsi.kma.automation.pageObjects.DrivingActivityPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.Utils;

public class DrivingActivityModule {

	private static Logger    Log = Logger.getLogger(DrivingActivityModule.class.getName());
	
	public static void NavigateToDrivingactivityPage(WebDriver driver)
	{
		
		OverviewModule.NavigateToOverviewPage(driver);

		ActionModule.click(driver,MyCarLeftMenu.drivingActivityLink(driver), "drivingActivity Link", "Vehicle page");

		Log.info("Succesfully navigated to driving activity page Page");

	
	}
	public static void drivingActivityCheck(WebDriver driver)
	{
		
		Utils.waitForElementToBeInvisible(driver,  DrivingActivityPage.DrivingActivityElements.hoursDrivenValue(driver));
		String drivingScore=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.drivingScoreValue(driver), "drivingScoreValue", "Driving Activity");
	    Log.info("Driving score is : "+drivingScore);
	
	    if(!Utils.getPlatform().contains("Connected"))
	    {
	    ActionModule.isDisplayed(driver, DrivingActivityPage.DrivingActivityElements.peakDrivingHoursBox(driver), "peakDrivingHoursBox", "Driving Activity");
	    String peakhours=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.peakHoursValue(driver), "peakHoursValue", "Driving Activity");
	    Log.info("Peak hours are : "+peakhours);
	    
	    }
	    String hoursDriven=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.hoursDrivenValue(driver), "hoursDrivenValue", "Driving Activity");
	    Log.info("Peak hours are : "+hoursDriven);
	    
	    String mileage=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.mileageValue(driver), "mileageValue", "Driving Activity");
	    Log.info("mileage : "+mileage);
	    
	    if(!Utils.getPlatform().contains("EV 2.0"))
	    {
	    String idleTime=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.idleTimeValue(driver), "idleTimeValue", "Driving Activity");
	    Log.info("idleTime : "+idleTime);
	    
	    }
	    
	    String averageSpeed=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.averageSpeedValue(driver), "averageSpeedValue", "Driving Activity");
	    Log.info("averageSpeed : "+averageSpeed);
	    
	    
	    String awards=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.noOfAwards(driver), "noOfAwards", "Driving Activity");
	    Log.info("YOU HAVE WON "+awards +" AWARDS");
	    
	}
	
	
}
