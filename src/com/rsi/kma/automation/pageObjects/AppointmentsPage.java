package com.rsi.kma.automation.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;

public class AppointmentsPage {
	
	private static WebElement webElement = null;    
	
	public static class RequestAppointmentSoul {

		public static WebElement changeDealer(WebDriver driver) {
			           
				webElement = FindWebElement.byXpath(driver,"//*[@class='cta secondary change-dealer-ev']","changeDealer","AppointmentsPage");
				
			return webElement;
		}					

		public static WebElement changeDealerDealerTypeDropdown(WebDriver driver) {
			
				webElement = FindWebElement.byId(driver,"selectVehicleType","changeDealerDealerTypeDropdown","AppointmentsPage");
				
			return webElement;
		}

		public static WebElement changeDealerRedStar(WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//*[@class='distance']","changeDealerRedStar","AppointmentsPage");
				
			return webElement;
		}	
	
		public static WebElement changeDealerActual(WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//li[@class='inactive CA204']//div[@class='name']","changeDealerActual","AppointmentsPage");
				
			return webElement;
		}
		
		public static WebElement changeDealerExpected (WebDriver driver) {
			
				webElement =  FindWebElement.byXpath(driver,"//div[contains(@class,'col1')]//div[contains(text(),'The Kia Depot')]","changeDealerExpected","AppointmentsPage");
				
			return webElement;
		}

		public static WebElement RequestAppointmentButton(WebDriver driver) {
			
				webElement = FindWebElement.byId(driver,"request-appt-ev","RequestAppointmentButton","AppointmentsPage");
				
			return webElement;
		}
	}
}







