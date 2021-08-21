package com.rsi.kma.automation.testScripts.Regression;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.ActionModule;
import com.rsi.kma.automation.modules.ClimateModule;
import com.rsi.kma.automation.modules.OverviewModule;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.Utils;

public class Climate extends BaseClass{

	private static Logger    Log = Logger.getLogger(Battery.class.getName());
	@Test(description = "TS_01",groups = {"JF PHEV","DE PHEV","EV 1.0","EV 2.0"})
	public void startStopClimate(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.increaseClimateTemperature(driver);
		ClimateModule.decreaseClimateTemperature(driver);
		assertTrue(ClimateModule.startClimate(driver),"The climate has not started");
		ClimateModule.checkNotificationAndCommandLogForRemoteCommand(driver, "Climate ON");
		Utils.sleep(driver, 5000);
		ActionModule.click(driver,MyCarLeftMenu.Remote_Link(driver), "Remote link", "Vehicle page");
		// Wait for progress bar to be invisible
		Utils.waitForProgressbarInvisible(driver);
		Utils.sleep(driver, 5000);
		ClimateModule.stopClimate(driver);
		ClimateModule.checkNotificationAndCommandLogForRemoteCommand(driver, "Climate OFF");
		Utils.sleep(driver, 5000);
	}
	
	@Test(description = "TS_02a",groups = { "EV 1.0"})
	public void startStopClimateEV1(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.increaseClimateTemperature(driver);
		ClimateModule.decreaseClimateTemperature(driver);
		assertTrue(ClimateModule.startClimate(driver),"The climate has not started");
		ClimateModule.stopClimate(driver);
		Utils.sleep(driver, 5000);
	}

	
	@Test(description = "TS_02",groups = {"JF PHEV","DE PHEV","EV 1.0","EV 2.0"})
	public void startStopDefroster(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.increaseClimateTemperature(driver);
		ClimateModule.decreaseClimateTemperature(driver);
		ClimateModule.defrosterON(driver);
		assertTrue(ClimateModule.startClimate(driver),"The climate has not started");
		ClimateModule.checkNotificationAndCommandLogForRemoteCommand(driver, "Climate ON");
		Utils.sleep(driver, 5000);
		ActionModule.click(driver,MyCarLeftMenu.Remote_Link(driver), "Remote link", "Vehicle page");
		// Wait for progress bar to be invisible
		Utils.waitForProgressbarInvisible(driver);
		Utils.sleep(driver, 5000);
		ClimateModule.stopClimate(driver);
		ClimateModule.checkNotificationAndCommandLogForRemoteCommand(driver, "Climate OFF");
		Utils.sleep(driver, 5000);
	}
	
	
	@Test(description = "TS_02a",groups = { "EV 1.0"})
	public void startStopDefrosterEV1(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.increaseClimateTemperature(driver);
		ClimateModule.decreaseClimateTemperature(driver);
		ClimateModule.defrosterON(driver);
		assertTrue(ClimateModule.startClimate(driver),"The climate has not started");
		Utils.sleep(driver, 5000);
		ClimateModule.stopClimate(driver);
		Utils.sleep(driver, 5000);
	}
	

	
	@Test(description = "TS_03",groups = { "K900"})
	public void ClimateSchedule1(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.setSchedule1AndCancel(driver);
		ClimateModule.setSchedule1(driver);	
	}

	@Test(description = "TS_03a",groups = { "EV 1.0"})
	public void ClimateSchedule1EV1(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.setSchedule1AndCancel(driver);
		ClimateModule.setSchedule1(driver);	
	}
	
	@Test(description = "TS_04",groups = { "K900"})
	public void ClimateSchedule2(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.setSchedule2AndCancel(driver);
		ClimateModule.setSchedule2(driver);	
	}

	@Test(description = "TS_04a",groups = { "EV 1.0"})
	public void ClimateSchedule2EV1(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.setSchedule2AndCancel(driver);
		ClimateModule.setSchedule2(driver);	
	}
	
	
	@Test(description = "TS_05",groups = { "K900"})
	public void CheckNoDaysSameDays(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.checkSameSchedule("12", "20", "AM", "MON");
		
	}

	@Test(description = "TS_5a",groups = { "EV 1.0"})
	public void CheckNoDaysSameDaysEV1(){
	
		Log.info("platform is :"+ Utils.getPlatform());
		ClimateModule.NavigateToClimatePage(driver);
		ClimateModule.checkSameSchedule("12", "20", "AM", "MON");
		
	}

}
