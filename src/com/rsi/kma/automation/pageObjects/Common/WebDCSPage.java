package com.rsi.kma.automation.pageObjects.Common;


import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.rsi.kma.automation.utility.FindWebElement;


public class WebDCSPage {

	 private static Logger Log = Logger.getLogger(SettingsPage.class.getName());
	public  static WebElement webElement = null;    
	public  static Alert      alert      = null;

	public static WebElement userID (WebDriver driver){
		
			webElement = FindWebElement.byId(driver,"SignInCtl_UserName","userID","WebDCSPage");
			
		return webElement;
	}

	public static WebElement passsword (WebDriver driver){
		
			webElement = FindWebElement.byId(driver,"SignInCtl_Password","passsword","WebDCSPage");
			
		return webElement;
	}

	public static WebElement loginButton (WebDriver driver){
		
			webElement = FindWebElement.byId(driver,"SignInCtl_Login","loginButton","WebDCSPage");
			
		return webElement;
	}
	public static WebElement dealerSearch (WebDriver driver){
		
			webElement = FindWebElement.byId(driver,"imgDealerSearch","dealerSearch","WebDCSPage");
			
		return webElement;
	}
	public static WebElement dealerCode (WebDriver driver){
		
			webElement = FindWebElement.byId(driver,"txtDealerCode","dealerCode","WebDCSPage");
			
		return webElement;
	}
	public static WebElement searchButton (WebDriver driver){
		
			webElement = FindWebElement.byId(driver,"ibtnSearch","searchButton","WebDCSPage");
			
		return webElement;
	}
	public static WebElement closeButton (WebDriver driver){
		
			WebElement we = FindWebElement.byXpath(driver,"//*[@id='lblSalesAlerts']/div/div[3]/img","closeButton","WebDCSPage");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", we);
			
		return webElement;
	}
	public static WebElement buttonDate (WebDriver driver){
		
			webElement = FindWebElement.byId(driver,"btnApptDate","buttonDate","WebDCSPage");
			
		return webElement;
	}
	public static WebElement textDate (WebDriver driver){
		
			webElement = FindWebElement.byId(driver,"txtApptDate","textDate","WebDCSPage");
			
		return webElement;
	}
	public static WebElement timeHour (WebDriver driver){
		
			webElement = FindWebElement.byXpath(driver,"//*[@id='txtApptHr']","timeHour","WebDCSPage");
			
		return webElement;
	}
	public static WebElement timeMinute (WebDriver driver){
		
			webElement = FindWebElement.byXpath(driver,"//*[@id='txtApptMin']","timeMinute","WebDCSPage");
			
		return webElement;
	}
	public static WebElement commentsBox (WebDriver driver){
		
			webElement = FindWebElement.byXpath(driver,"//*[@id='txtComments']","commentsBox","WebDCSPage");
			
		return webElement;
	}
	
	public static WebElement dateBox (WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//*[@id='txtApptDate']","dateBox","WebDCSPage");
            
        return webElement;
    }
	public static WebElement submitButton (WebDriver driver){
		
			webElement = FindWebElement.byId(driver,"btnSubmit","submitButton","WebDCSPage");
			
		return webElement;
	}
	public static WebElement userLabel (WebDriver driver){
		
			webElement = FindWebElement.byXpath(driver,"//*[@id='lblUserName']","userLabel","WebDCSPage");
			
		return webElement;
	}

	public static WebElement topMenu (WebDriver driver){
		
			
			webElement = FindWebElement.byXpath(driver,"//*[@id='trTopMenu']/td[contains(text(),'Service')]","topMenu","WebDCSPage"); 
			
			
		return webElement;
	}

	public static WebElement uvoCustomerAlert (WebDriver driver){
		try{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById('a_9').click();");
			// webElement = FindWebElement.byId(driver,"a_9","userID","WebDCSPage");
			Log.info("UVO & other Customer Alerts is found on the WebDCS page");
		}catch(Exception e){
			webElement = null;
			Log.error("UVO & other Customer Alerts  is not found on the WebDCS page ");
			Log.debug(e.getLocalizedMessage());
			Reporter.log("UVO & other Customer Alerts  is not found on the WebDCS page | ");
		}
		return webElement;
	}

	public static WebElement outstandingAlerts (WebDriver driver){
		try{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById('scn_14').click();");
			
			Log.info("Outstanding Alerts is found on the WebDCS page");
		}catch(Exception e){
			webElement = null;
			Log.error("Outstanding Alerts  is not found on the WebDCS page ");
			Log.debug(e.getLocalizedMessage());
			Reporter.log("Outstanding Alerts  is not found on the WebDCS page | ");
		}
		return webElement;
	}

	public static WebElement arrowDoubleClicked (WebDriver driver){
		try{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement element=FindWebElement.byId(driver,"imgLeftFold","arrowDoubleClicked","WebDCSPage");
			jse.executeScript("arguments[0].click();", element);
			Log.info("Arrow is found on the WebDCS page");
		}catch(Exception e){
			webElement = null;
			Log.error("Arrow is not found on the WebDCS page ");
			Log.debug(e.getLocalizedMessage());
			Reporter.log("Arrow is not found on the WebDCS page | ");
		}
		return webElement;
	}
	
	
	public static WebElement eMail (WebDriver driver, int rowNum){
		
			webElement=FindWebElement.byXpath(driver,"//*[@id='gvAlerts']//tr["+rowNum+"]//td[8]","eMail","WebDCSPage");
			
		return webElement;
	}
	
	public static WebElement vinValue (WebDriver driver, int rowNum){
		
			webElement=FindWebElement.byXpath(driver,"//*[@id='gvAlerts']//tr["+rowNum+"]//td[3]","vinValue","WebDCSPage");
			
		return webElement;
	}
	
	public static WebElement statusClicked (WebDriver driver, int rowNum){
		
			webElement=FindWebElement.byXpath(driver,"//*[@id='gvAlerts']//tr["+rowNum+"]//td[9]//span[starts-with(@id,'gvAlerts_c')]","statusClicked","WebDCSPage");
			
		return webElement;
	}
	
	public static WebElement statusSelected (WebDriver driver){
		
			webElement=FindWebElement.byId(driver,"ddlDlrStatus","statusSelected","WebDCSPage");
			
		return webElement;
	}
	
	
}