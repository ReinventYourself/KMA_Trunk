package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.MyPoiModule;
import com.rsi.kma.automation.utility.BaseClass;

public class MyPois extends BaseClass {

	

	@Test(description = "TC_01",groups ={"JF PHEV" /* ,"DE PHEV","K900"    ,"Connected_AVN","Connected_UVO" ,"EV 2.0"*/})
	public void checkPoiValue( )
	{
		
		MyPoiModule.NavigateToPOipage(driver);
		MyPoiModule.checkPOI(driver);
		
		
		
	}
	
	@Test(description = "TC_01",groups ={"JF PHEV"  ,"DE PHEV",  "K900","Connected_AVN","Connected_UVO" ,"EV 2.0"})
	public void add26Poi( )
	{
		
		MyPoiModule.NavigateToPOipage(driver);
		MyPoiModule.addPoi(driver);
		
		
		
	}
	
	@Test(description = "TC_01",groups ={"JF PHEV"  ,"DE PHEV"  ,"K900"    ,"Connected_AVN","Connected_UVO" ,"EV 2.0"})
	public void delete( )
	{
		
		MyPoiModule.NavigateToPOipage(driver);
		MyPoiModule.deletePoi(driver);
		
		
		
	}
	@Test(description = "TC_01",groups ={"JF PHEV"  ,"DE PHEV"  ,"K900"    ,"Connected_AVN","Connected_UVO" ,"EV 2.0"})
	public void deleteAll( )
	{
		
		MyPoiModule.NavigateToPOipage(driver);
		MyPoiModule.deleteALLPoi(driver);
		
		
		
	}
	
	@Test(description = "TC_01",groups ={"JF PHEV"  ,"DE PHEV"  ,"K900"    ,"Connected_AVN","Connected_UVO" ,"EV 2.0"})
	public void sortByNewest( )
	{
		
		MyPoiModule.NavigateToPOipage(driver);
		MyPoiModule.sortByNewest(driver);
		
		
		
	}
	
	@Test(description = "TC_01",groups ={"JF PHEV"  ,"DE PHEV"  ,"K900"    ,"Connected_AVN","Connected_UVO" ,"EV 2.0"})
	public void sortByOldest( )
	{
		
		MyPoiModule.NavigateToPOipage(driver);
		MyPoiModule.sortByOldest(driver);
		
		
		
	}
	
	@Test(description = "TC_01",groups ={"JF PHEV"  ,"DE PHEV"  ,"K900"    ,"Connected_AVN","Connected_UVO" ,"EV 2.0"})
	public void sortByCity( )
	{
		
		MyPoiModule.NavigateToPOipage(driver);
		MyPoiModule.sortByCity(driver);
		
		
		
	}
	

	@Test(description = "TC_01",groups ={/*"JF PHEV"  ,*/"DE PHEV"  /*,"K900"    ,"Connected_AVN","Connected_UVO","EV 2.0"*/})
	public void sortByState( )
	{
		
		MyPoiModule.NavigateToPOipage(driver);
		MyPoiModule.sortByState(driver);
	
		
	}
	
	@Test(description = "TC_01",groups ={"JF PHEV"  ,"DE PHEV"  ,"K900"    ,"Connected_AVN","Connected_UVO" ,"EV 2.0"})
	public void editPoi( )
	{
		
		MyPoiModule.NavigateToPOipage(driver);
		MyPoiModule.editPois(driver);
	
		
	}
}
