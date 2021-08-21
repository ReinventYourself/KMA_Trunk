package com.rsi.kma.automation.testScripts.Regression;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.ChargingStationModule;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.Utils;
/**
 * The ChargingStations class will verify all the links, functionalities of the
 * ChargingStations page.
 *
 *
 * @version 1.0 15/01/18
 * @author Aditya Narayan 
 */
public class ChargingStations extends BaseClass{
	
	

	
	@Test(description = "TS_01" ,groups = {"JF PHEV","DE PHEV","EV 2.0"})
	public void checkFilter(){
		
		
		Reporter.log("Platform selected is"+Utils.getPlatform());
		Log.info("platform is :"+ Utils.getPlatform());
		
		// Navigate to Charging station page
		ChargingStationModule.navigateToChargingStationPage(driver);
		
		// Validate Search and filter functionality for charging stations
		assertTrue(ChargingStationModule.checkSearchAndFilterFunctionality(driver, "zipcode"), "Initial charging station count is less then after applying filter");
		
		// Validate the charging station on map
		assertTrue(ChargingStationModule.validateChargingStationOnMap(driver), "The charging station in the list doesn't match with the details on Map");
	}
	
	@Test(description = "TS_02",groups = {"JF PHEV","DE PHEV","EV 2.0"})
	public void checkZipAndCity(){
		
		
		Reporter.log("Platform selected is"+Utils.getPlatform());
		Log.info("platform is :"+ Utils.getPlatform());
		
		// Navigate to Charging station page
		ChargingStationModule.navigateToChargingStationPage(driver);
		
		// Check the filter functionality for ZIP and City values
		assertTrue(ChargingStationModule.checkZipAndCityFunctionality(driver, "zipcode", "city"), "The search box out result is same for Zip and City");
		
		// Validate the charging station on map
		assertTrue(ChargingStationModule.validateChargingStationOnMap(driver), "The charging station in the list doesn't match with the details on Map");
	}

}
