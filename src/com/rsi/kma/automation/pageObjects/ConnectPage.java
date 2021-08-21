package com.rsi.kma.automation.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;



public class ConnectPage {

	
	private static WebElement webElement = null;
	

	public static WebElement viewBattery_Button(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class, 'btn') and text() = 'VIEW BATTERY']","viewBattery_Button","ConnectPage");

		return webElement;
	}

	public static WebElement chargingStations_Button(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class, 'btn') and text() = 'CHARGING STATIONS']","chargingStations_Button","ConnectPage");

		return webElement;
	}

	public static WebElement climateControl_Button(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class, 'btn') and text() = 'CLIMATE CONTROL']","climateControl_Button","ConnectPage");

		return webElement;
	}

	public static WebElement lock_Unlock_Button(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class, 'btn') and text() = 'LOCK/UNLOCK']","lock_Unlock_Button","ConnectPage");

		return webElement;
	}

	public static WebElement findMYCar_Button(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class, 'btn') and text() = 'FIND MY CAR']","findMYCar_Button","ConnectPage");

		return webElement;
	}

	public static WebElement unplugged_Battery_Image(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@id='battery-status-img' and @alt='Battery Unplugged']","unplugged_Battery_Image","ConnectPage");

		return webElement;
	}

	public static WebElement notPluggedIn_BatteryStatusHeader(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@id='battery-status-img' and @alt='Battery Unplugged']","notPluggedIn_BatteryStatusHeader","ConnectPage");

		return webElement;
	}

	public static WebElement pluggedIn_BatteryStatusHeader(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@id='battery-status-img' and @src='/ccw/img/battery/battery-plugged.png']","pluggedIn_BatteryStatusHeader","ConnectPage");

		return webElement;
	}

	public static WebElement batteryRange_In_Miles(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//input[contains(@knob-status,'batteryStatus') and not(contains(@class,'mobile'))]","batteryRange_In_Miles","ConnectPage");

		return webElement;
	}

	public static WebElement batteryPercent_Indicator(WebDriver driver) {

		webElement = FindWebElement.byId(driver,"percent-indicator","batteryPercent_Indicator","ConnectPage");


		return webElement;
	}

	public static WebElement outside_Temperature(WebDriver driver) {

		webElement = FindWebElement.byId(driver,"outside-temp'","outside_Temperature","ConnectPage");

		return webElement;
	}

	public static WebElement vehicle_Locked_Header_Text(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@id='lock-status' and text()= 'YOUR VEHICLE IS LOCKED']","vehicle_Locked_Header_Text","ConnectPage");

		return webElement;
	}

	public static WebElement vehicle_Unlocked_Header_Text(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@id='lock-status' and text()= 'YOUR VEHICLE IS UNLOCKED']","vehicle_Unlocked_Header_Text","ConnectPage");

		return webElement;
	}

	public static WebElement lower_Panel_Text(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[@class='lower-panel' and contains(text(),'Estimated range may vary depending on driving habits and situations.')]","lower_Panel_Text","ConnectPage");

		return webElement;
	}
	
	public static WebElement batteryPercentage(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'panel-1 col-sm-8 hidden-xs')]//*[@ng-bind='vmStatus']","battery percentage","ConnectPage");

		return webElement;
	}
	
	
}
