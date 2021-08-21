package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.MyVehicleModule;
import com.rsi.kma.automation.utility.BaseClass;

public class MyVehicles extends BaseClass{
	
	@Test(description = "TC_01",groups ={"JF PHEV","DE PHEV","K900","EV 2.0","Connected_AVN","Connected_UVO","EV 1.0"})
	public void addDeleteVin( )
	{
		
		
		MyVehicleModule.NavigateToVehiclePage(driver);
		
		//Adding New vehicle by VIN No.
		String olVehicleName=MyVehicleModule.addDeleteVin(driver);
		
		//Modifying nickname of the vehicle added
		String newNickname=MyVehicleModule.changeNickname(driver,olVehicleName);
		
		//Deleting added vehicle
		MyVehicleModule.deleteVehicle(driver, newNickname);
		
	}
	
	
	
	
}
