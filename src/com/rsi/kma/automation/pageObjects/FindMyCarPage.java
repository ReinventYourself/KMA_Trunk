package com.rsi.kma.automation.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.FindWebElement;



public class FindMyCarPage {


	private static WebElement webElement = null;


	public static WebElement updateLocationAndMore (WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'infobox-dark vehicle')]//a[contains(@ng-click,'updateLocationAndMore')]/span[@class='getDirTxt']","updateLocationAndMore","FindMyCarPage");

		return webElement;
	}
	
	
	public static WebElement getDirection (WebDriver driver) {


		
		/*if(BaseClass.getBrowser().equalsIgnoreCase("ie"))
		{
			
			webElement = FindWebElement.byCssSelector(driver,".infobox-dark.vehicle.ib0 >div > div >div >span:nth-child(2) >a:nth-child(2) >span >span","getDirection","FindMyCarPage");

		}
		
		else
		{*/
			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'infobox-dark')]//span[@class='getDirTxt' and contains(text(),'Get Directions')]","getDirection","FindMyCarPage");
		/*}*/
		return webElement;
	}
	
	public static WebElement location (WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'infobox-dark')]//div[@class='location']/p[1]","location","FindMyCarPage");

		return webElement;
	}
	
	public static WebElement city (WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'infobox-dark')]//div[@class='location']/p[2]","city","FindMyCarPage");

		return webElement;
	}
	public static WebElement timestamp (WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'infobox-dark')]//div[@class='location']/following-sibling::p/span","timestamp","FindMyCarPage");

		return webElement;
	}
	
	public static WebElement updating (WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='UPDATING..']","updating","FindMyCarPage");

		return webElement;
	}
	public static WebElement loaderwait (WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'Please allow 2-3 minutes.')]","updating","FindMyCarPage");

		return webElement;
	}

	
	

}
