package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.FindMyCarModule;
import com.rsi.kma.automation.utility.BaseClass;

public class FindMyCar extends BaseClass{

	
	@Test(description = "TC_01",groups ={"JF PHEV","DE PHEV","EV 1.0","EV 2.0"})
	public void FindMyCarTest( )
	{
	
		FindMyCarModule.navigateToFindMYCarPage(driver);
		
		FindMyCarModule.getLocation(driver);;
		
		
		
	}
	
	@Test(description = "TC_01",groups ={"EV 1.0"})
	public void FindMyCarTestEV1( )
	{
		
		FindMyCarModule.navigateToFindMYCarPage(driver);
		
		FindMyCarModule.getLocation(driver);;
		
		
		
	}
	
	
}
