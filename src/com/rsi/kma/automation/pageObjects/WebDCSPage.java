package com.rsi.kma.automation.pageObjects;

/** 
 * $Id $ 
 * © R Systems International 2015. 
 * All Rights Reserved. 
 * This software and documentation is the confidential and proprietary 
 * information of R Systems ("Confidential Information"). 
 * It is protected by copyright law and international treaties. 
 * You shall not disclose such Confidential Information and shall use 
 * it only in accordance with the terms of the license agreement you 
 * entered into with R Systems Corporation. 
 * Unauthorized reproduction or distribution of this Confidential 
 * Information, or any portion of it, may result in severe civil and criminal penalties. 
 * 
 * Developed by R Systems International Limited. 
 * C-40, Sector 59 
 * Noida, India 201307 
 */


import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.rsi.kma.automation.utility.FindWebElement;


public class WebDCSPage {

	private static Logger     Log        = Logger.getLogger(WebDCSPage.class.getName());
	public  static WebElement webElement = null;    
	public  static Alert      alert      = null;

	public static WebElement userID (WebDriver driver){
		
			webElement =FindWebElement.byId(driver,"SignInCtl_UserName","username","webDCs");
			
		return webElement;
	}

	public static WebElement passsword (WebDriver driver){
		
			webElement =FindWebElement.byId(driver,"SignInCtl_Password","passsword","webDCs");
			
		
		return webElement;
	}

	public static WebElement loginButton (WebDriver driver){
		
			webElement =FindWebElement.byCssSelector(driver,"#SignInCtl_Login","loginButton","webDCs");
			
		return webElement;
	}
	public static WebElement dealerSearch (WebDriver driver){
	
			
			webElement =FindWebElement.byXpath(driver,"//img[@id='imgDealerSearch']","dealerSearch","webDCs");
			
		return webElement;
	}
	public static WebElement dealerCode (WebDriver driver){
		
			webElement =FindWebElement.byId(driver,"txtDealerCode","dealerCode","webDCs");
			
		return webElement;
	}
	public static WebElement searchButton (WebDriver driver){
		
			
			webElement =FindWebElement.byXpath(driver,"//*[@id='ibtnSearch']","dealerCode","webDCs");
			
		
		return webElement;
	}
	
	public static WebElement topMenu (WebDriver driver){
		
			//webElement = FindElement.byXpath(driver,"//*[@id='trTopMenu']/td[2]"));
			webElement = FindWebElement.byXpath(driver,"//*[@id='trTopMenu']/td[3]","topMenu","webDCS");
			
		return webElement;
	}
	
	public static WebElement arrowDoubleClicked (WebDriver driver){
		
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement element=FindWebElement.byId(driver,"imgLeftFold","","");
			jse.executeScript("arguments[0].click();", element);
			Log.info("Arrow is found on the WebDCS page");
		
		return webElement;
	}
	
	public static WebElement eMail (WebDriver driver){
		
			webElement=FindWebElement.byId(driver,"txtEmail","topMenu","webDCS");
			
		return webElement;
	}
	
	public static WebElement appoinmentSearch (WebDriver driver){
		
			webElement=FindWebElement.byId(driver,"btnSearch","topMenu","webDCS");
			
		
		return webElement;
	}
	public static WebElement openAppointment (WebDriver driver){
		
		webElement=FindWebElement.byXpath(driver,"//*[contains(onclick,'OpenDetail')]","openAppointment","webDCS");
		
	
	return webElement;
}
	public static WebElement statusSelected (WebDriver driver){
		
			webElement=FindWebElement.byId(driver,"ddlDlrStatus","statusSelected","webDCS");
			
			
			
		return webElement;
	}
	
	public static WebElement buttonDate (WebDriver driver){
		
			webElement=FindWebElement.byId(driver,"btnApptDate","buttonDate","webDCS");
			
		return webElement;
	}
	public static WebElement textDate (WebDriver driver){
		
			webElement=FindWebElement.byId(driver,"txtApptDate","textDate","webDCS");
			
			
		return webElement;
	}
	public static WebElement timeHour (WebDriver driver){
		
			webElement=FindWebElement.byXpath(driver,"//*[@id='txtApptHr']","timeHour","webDCS");
			
		return webElement;
	}
	public static WebElement timeMinute (WebDriver driver){
		
			webElement=FindWebElement.byXpath(driver,"//*[@id='txtApptMin']","timeMinute","webDCS");
			
		return webElement;
	}
	public static WebElement commentsBox (WebDriver driver){
		
			webElement=FindWebElement.byXpath(driver,"//*[@id='txtComments']","commentsBox","webDCS");
			
		return webElement;
	}
	
	public static WebElement dateBox (WebDriver driver){
        
        	webElement=FindWebElement.byXpath(driver,"//*[@id='txtApptDate']","dateBox","webDCS");
            
        return webElement;
    }
	

	public static WebElement submitButton (WebDriver driver){
		
			webElement=FindWebElement.byId(driver,"btnSubmit","submitButton","webDCS");
            
			
		return webElement;
	}
	
	public static WebElement statusClicked (WebDriver driver, int rowNum){
		
			webElement=FindWebElement.byXpath(driver,"//*[@id='gvAlerts']//tr["+rowNum+"]//td[9]//span[starts-with(@id,'gvAlerts_c')]","status","WebDCs");
		
		return webElement;
	
	}
}