package com.rsi.kma.automation.pageObjects.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;

public class LoginFormPage {

	private static WebElement webElement = null;    

	public static WebElement usernameField (WebDriver driver){

		webElement = FindWebElement.byId(driver, "emlAdr", "Username", "login form ");
		return webElement;
	}

	public static WebElement passwordField(WebDriver driver){

		webElement = FindWebElement.byId(driver, "csmrPw", "passwordField", "login form ");


		return webElement;
	}

	public static WebElement loginButton(WebDriver driver){

		webElement = FindWebElement.byId(driver, "btnValidate2", "loginButton", "Login Form ");

		return webElement;
	}


	public static WebElement invalidEmailAndPassword(WebDriver driver){

		webElement = FindWebElement.byXpath(driver, "//*[@id='emailError3']/p", "invalidEmailAndPassword", "Login Form ");

		return webElement;
	}

	public static WebElement emptyEmailOrPassword(WebDriver driver){

		webElement = FindWebElement.byCssSelector(driver, "#emailError2>p", "emptyEmailOrPassword", "Login Form ");

		return webElement;
	}
	public static WebElement accountLockedMsg(WebDriver driver){

		webElement = FindWebElement.byXpath(driver, "//*[@id='exceededLimit']/p", "accountLockedMsg", "Login Form ");

		return webElement;
	}

	public static WebElement register(WebDriver driver){

		webElement = FindWebElement.byXpath(driver, "//*[@id='registerLink']/div/span[text()='Register']", "register", "Login Form ");

		return webElement;
	}
}
