package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.MyCarZoneModule;
import com.rsi.kma.automation.utility.BaseClass;

public class MyCarZone extends BaseClass{



	@Test(description = "TS_01" ,groups = {"JF PHEV","DE PHEV","Connected_AVN","Connected_UVO","EV 2.0"})
	public void curfewAlerts(){

		
		MyCarZoneModule.NavigateToMyCarZonePage(driver);
		
		int alertsDisplayed=MyCarZoneModule.curfewAlerts(driver);
		
		MyCarZoneModule.checkTriggeredCurfewAlerts(driver,alertsDisplayed);
		
		MyCarZoneModule.deleteAlert(driver, BaseClass.getTestMethodName());
		
	}
	
	@Test(description = "TS_02" ,groups = {"JF PHEV","DE PHEV","Connected_AVN","Connected_UVO","K900","EV 2.0"})
	public void speedAlerts(){


		Log.info("method:"+BaseClass.getTestMethodName());
		MyCarZoneModule.NavigateToMyCarZonePage(driver);
		
		int alertsDisplayed=MyCarZoneModule.speedAlerts(driver);
		
		MyCarZoneModule.checkTriggeredSpeedAlerts(driver, alertsDisplayed);
		
		MyCarZoneModule.deleteAlert(driver,BaseClass.getTestMethodName());
		
	}
	
	
	@Test(description = "TS_03" ,groups = {"JF PHEV","DE PHEV","Connected_AVN","K900","EV 2.0"})
	public void geofenceAlerts(){


		Log.info("method:"+BaseClass.getTestMethodName());
		MyCarZoneModule.NavigateToMyCarZonePage(driver);
		
		int alertsDisplayed=MyCarZoneModule.geoFenceAlerts(driver);
		
		MyCarZoneModule.checkTriggeredGeoFenceAlerts(driver, alertsDisplayed);
		
		MyCarZoneModule.deleteAlert(driver,BaseClass.getTestMethodName());
		
	}

	
	@Test(description = "TS_04" ,groups ={"DE PHEV"})
	public void ValetAlerts(){


		Log.info("method:"+BaseClass.getTestMethodName());
		MyCarZoneModule.NavigateToMyCarZonePage(driver);
		
		int alertsDisplayed=MyCarZoneModule.valetAlerts(driver);
		
		MyCarZoneModule.checkTriggeredValetAlerts(driver, alertsDisplayed);
		
		MyCarZoneModule.deleteAlert(driver,BaseClass.getTestMethodName());
		
	}
	
	
	
	@Test(description = "TS_04" ,groups = {"JF PHEV","DE PHEV","K900","EV 2.0"})
	public void curfewSettingAlert(){


		
		MyCarZoneModule.NavigateToMyCarZonePage(driver);
		
		MyCarZoneModule.modifyCurfewAlert(driver);
		
		
		
	}
	
	@Test(description = "TS_05" ,groups = {"JF PHEV","DE PHEV","K900","EV 2.0"})
	public void addDeleCurfewAlert(){


		MyCarZoneModule.NavigateToMyCarZonePage(driver);
		MyCarZoneModule.addDeleteCurfew(driver);
		
		
		
	}
	
	
	@Test(description = "TS_05" ,groups = {"JF PHEV","DE PHEV","K900","EV 2.0"})
	public void modifySpeedAlert(){


		MyCarZoneModule.NavigateToMyCarZonePage(driver);
		MyCarZoneModule.modifySpeedAlert(driver);
		
		
		
		
	}
	
	
	@Test(description = "TS_05" ,groups = {"JF PHEV","DE PHEV","K900","EV 2.0"})
	public void modifyGeoFenceAlert(){


		MyCarZoneModule.NavigateToMyCarZonePage(driver);
		MyCarZoneModule.modifyGeoFenceAlert(driver);
		String location="Irvine";
		MyCarZoneModule.captureAlerts(driver,location);
		 location="Long Beach";
		MyCarZoneModule.captureAlerts(driver,location);
		
		
	}
	
	
	@Test(description = "TS_05" ,groups = {"JF PHEV","DE PHEV","K900","EV 2.0"})
	public void addDeleteGeofence(){


		MyCarZoneModule.NavigateToMyCarZonePage(driver);
		MyCarZoneModule.addDeleteGeoFenceSetting(driver);
		
		
		
	}
	
}
	
	