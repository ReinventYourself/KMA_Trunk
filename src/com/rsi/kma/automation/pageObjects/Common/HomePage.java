package com.rsi.kma.automation.pageObjects.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;

public class HomePage {


	private static WebElement webElement = null;    

	public static class Header {
		public static WebElement kiaLogo (WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//*[@class='kia-logo']","kiaLogo","HomePage");                

			return webElement;
		}


		public static WebElement uvoLogo (WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//*[@class='uvo-logo']","uvoLogo","HomePage");                                    

			return webElement;
		}

		public static WebElement supportLink (WebDriver driver){

			webElement = FindWebElement.byLinktext(driver,"Support","supportLink","HomePage");

			return webElement;
		}

		public static WebElement registerLink (WebDriver driver){

			webElement = FindWebElement.byLinktext(driver,"Register","registerLink","HomePage");

			return webElement;
		}
	}


	public static WebElement forgotPasswordButton(WebDriver driver){

		webElement = FindWebElement.byXpath(driver,"//*[@class='login-container']//span[text()='Forgot Password']","forgotPasswordButton","LoginForm");

		return webElement;
	}
	
}
