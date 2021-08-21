package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.TripInfoModule;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.Utils;

public class TripInfo extends BaseClass{
	
	

	
	@Test(description = "TS_01" ,groups = {"Connected_AVN","Connected_UVO"})
	public void tripInfoConnected(){
		
		Log.info("platform is :"+ Utils.getPlatform());
		 
		TripInfoModule.navigateToTripInfoPage(driver);
		TripInfoModule.tripConnected(driver);
		
		
	}
	
	
	
	@Test(description = "TS_02" ,groups = {"EV 2.0","JF PHEV","DE PHEV"})
	public void tripInfoEmbedded(){
		Log.info("platform is :"+ Utils.getPlatform());
		 
		TripInfoModule.navigateToTripInfoPage(driver);
		TripInfoModule.tripEmbedded(driver);
		
		
	}
	
	@Test(description = "TS_03" ,groups = {"JF PHEV"/*,"DE PHEV"*//*,"EV 2.0","K900",*/})
	public void MergeUnmergeTrips(){
		Log.info("platform is :"+ Utils.getPlatform());
		 
		TripInfoModule.navigateToTripInfoPage(driver);
		TripInfoModule.mergeUnmergeTrips(driver);
		
		
	}
	
	@Test(description = "TS_02" ,groups = {"JF PHEV","DE PHEV","EV 2.0","K900"})
	public void deleteTrip(){
		Log.info("platform is :"+ Utils.getPlatform());
		 
		TripInfoModule.navigateToTripInfoPage(driver);
		TripInfoModule.deleteTrip(driver);
		
		
	}
	
	
}