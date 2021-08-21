package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.OverviewModule;
import com.rsi.kma.automation.utility.BaseClass;

public class Overview extends BaseClass {

	
	
	@Test(description = "TC_01",groups ={ "EV 1.0"})
	public void OverviewEV1( )
	{
		//To navigate to Overview Page 
		OverviewModule.NavigateToOverviewPage(driver);
		
		//To Compare values on different pages
		OverviewModule.OverviewEV1(driver);
		
		//To verify various links on Overview page
		OverviewModule.checkLinksEV1(driver);
		
	}
	
	@Test(description = "TC_02",groups = { "EV 2.0" })
	public void OverviewEV2( )
	{
		//To navigate to Overview Page 
		OverviewModule.NavigateToOverviewPage(driver);
		
		//To Compare values on different pages
		OverviewModule.OverviewEV2(driver);
		
		//To verify various links on Overview page
		OverviewModule.checkLinksEV2(driver);
		
	}
	
	@Test(description = "TC_03",groups = { "JF PHEV","DE PHEV"})
	public void OverviewPHEV( )
	{
		//To navigate to Overview Page 
		OverviewModule.NavigateToOverviewPage(driver);
		
		//To Compare values on different pages
		OverviewModule.OverviewDEJF(driver);
		
		//To verify various links on Overview page
		OverviewModule.checkLinksDEJF(driver);
		
		
		
	}
	
	@Test(description = "TC_04",groups = { "K900"})
	public void OverviewKH( )
	{
		//To navigate to Overview Page 
		OverviewModule.NavigateToOverviewPage(driver);
		
		//To Compare values on different pages
		OverviewModule.OverviewK900(driver);
		
		//To verify various links on Overview page
		OverviewModule.checkLinkK900(driver);
		
	}
	
	
	@Test(description = "TC_05",groups = { "Connected_AVN","Connected_UVO"})
	public void OverviewConnected( )
	{
		//To navigate to Overview Page 
		OverviewModule.NavigateToOverviewPage(driver);
		
		//To Compare values on different pages
		OverviewModule.OverviewConnected(driver);
		
		//To verify various links on Overview page
		OverviewModule.checkLinksConnected(driver);
		
	}
	
}
