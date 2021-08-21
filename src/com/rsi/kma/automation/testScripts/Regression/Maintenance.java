package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.MaintenanceModule;
import com.rsi.kma.automation.modules.WebDCSModule;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.Utils;

public class Maintenance extends BaseClass{



	@Test(description = "TS_01",groups = {"JF PHEV","DE PHEV","EV 1.0","Connected_AVN","Connected_UVO","K900","EV 2.0"})
	public void IgnoreCompleteInterval(){
		Log.info("platform is :"+ Utils.getPlatform());
		MaintenanceModule.NavigateToMaintenancePage(driver);
		MaintenanceModule.verifyDetailsCompletedAndIgnoredButton(driver);
	}

	@Test(description = "TS_02",groups = {"JF PHEV","DE PHEV","EV 1.0","Connected_AVN","Connected_UVO","K900","EV 2.0"})
	public void CheckInterval(){

		Log.info("platform is :"+ Utils.getPlatform());
		MaintenanceModule.NavigateToMaintenancePage(driver);
		MaintenanceModule.goToMileAndCheckDetails(driver);
	}

	@Test(description = "TS_03",groups ={"JF PHEV","DE PHEV","EV 1.0","Connected_AVN","Connected_UVO","K900","EV 2.0"})
	public void OilChangeInterval(){

		Log.info("platform is :"+ Utils.getPlatform());
		MaintenanceModule.NavigateToMaintenancePage(driver);
		MaintenanceModule.verifyOilChangeInterval(driver);
	}

	@Test(description = "TS_04",groups = {"JF PHEV","DE PHEV","EV 1.0","Connected_AVN","Connected_UVO","K900","EV 2.0"})
	public void ChangeDealership(){

		Log.info("platform is :"+ Utils.getPlatform());
		MaintenanceModule.NavigateToMaintenancePage(driver);
		MaintenanceModule.changeDealershipValues(driver);
	}

	@Test(description = "TS_05",groups = {"EV 1.0","Connected_UVO","JF PHEV","DE PHEV","Connected_AVN","K900","EV 2.0"})
	public void RequestAppointment(){

		Log.info("platform is :"+ Utils.getPlatform());
		MaintenanceModule.NavigateToMaintenancePage(driver);
		MaintenanceModule.checkRequestAppointment(driver);
		WebDCSModule.checkMachineOS();
		WebDCSModule.webDCS( Utils.getUserName());
		MaintenanceModule.NavigateToMaintenancePage(driver);
		MaintenanceModule.verifyAppointment(driver);


	}



}
