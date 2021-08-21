package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.BatteryModule;
import com.rsi.kma.automation.modules.OverviewModule;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.Utils;

public class Battery extends BaseClass{
	
	
	@Test(description = "TC_01",groups ={ "EV 2.0","EV 2.0","DE PHEV"})
	public void StartStopCharge( )
	{
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.startStopCharge(driver);
		
	}


	@Test(description = "TC_02",groups ={"EV 1.0"})
	public void StartStopChargeEV1( )
	{
		
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.startStopChargeEV1(driver);
		
	}
	@Test(description = "TC_03",groups ={ "JF PHEV" })
	public void ChargingSchedule( )
	{
	
		Log.info("platform is :"+ Utils.getPlatform());
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.chargingSchedule(driver);
		
		
	}

	@Test(description = "TC_04",groups ={ "EV 1.0"})
	public void ChargingScheduleEV1( )
	{
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.chargingScheduleIEV1(driver);
		
	}

	@Test(description = "TC_05",groups ={ "EV 1.0"})
	public void ChargingSchedule2EV1( )
	{
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.chargingScheduleIIEV1(driver);
	}
	
	@Test(description = "TC_06",groups ={ "DE PHEV"})
	public void ChargingSchedule1DE( )
	{

		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.chargingScheduleIDE(driver);
	}
	
	
	@Test(description = "TC_03",groups ={ "JF PHEV","EV 2.0" })
	public void CheckNoDays( )
	{
		
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.checkDays(driver);
		
	}

	@Test(description = "TC_08",groups ={ "DE PHEV"})
	public void ChargingSchedule2DE( )
	{
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.chargingScheduleIIDE(driver);
		
	}
	
	
	@Test(description = "TC_09",groups ={ "EV 1.0"})
	public void CheckNoDaysSameDaysEV1( )
	{
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.checkDaysIEV1(driver);
	}
	
	@Test(description = "TC_10",groups ={ "DE PHEV"})
	public void CheckNoDaysSameDaysDE( )
	{
		
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.checkDaysDE(driver);
	}
	
	@Test(description = "TC_11",groups ={ "EV 2.0" ,"JF PHEV","DE PHEV"})
	public void CheckAboutYourBattery( )
	{
		
		BatteryModule.NavigateToBatterypage(driver);
		BatteryModule.aboutBatttery(driver);
		
	}
	
}

