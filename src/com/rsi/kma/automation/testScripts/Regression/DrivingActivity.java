package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.DrivingActivityModule;
import com.rsi.kma.automation.utility.BaseClass;

public class DrivingActivity extends BaseClass{
	
	
	
	@Test(description = "TS_01",groups = { "JF PHEV","DE PHEV","Connected_AVN","Connected_UVO","EV 2.0"})
	public void DrivingActivityTest(){
	
		
		DrivingActivityModule.NavigateToDrivingactivityPage(driver);
		
		DrivingActivityModule.drivingActivityCheck(driver);
	}
		
}
