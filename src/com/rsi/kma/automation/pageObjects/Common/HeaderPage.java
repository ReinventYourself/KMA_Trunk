package com.rsi.kma.automation.pageObjects.Common;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;



public class HeaderPage {

   
    private static WebElement webElement = null;    

    public static WebElement kiaUVOLogo (WebDriver driver){
        
                webElement = FindWebElement.byXpath(driver,"//*[@title='MyUVO']","kiaUvoLogo","Header page");
            
           
        return webElement;
    }

    public static WebElement myVehiclesLink(WebDriver driver){
       
                webElement = FindWebElement.byXpath(driver,"//*[@class='top-nav']//*[text()='MY VEHICLES']","myVehiclesLink","Header page");
                
        return webElement;
    }

    public static WebElement supportLink(WebDriver driver){
      
                webElement = FindWebElement.byXpath(driver,"//*[@class='top-nav']//*[text()='SUPPORT']","supportLink","Header page");
                
        return webElement;
    }            

    public static WebElement settingsLink(WebDriver driver){
       
    	 webElement = FindWebElement.byXpath(driver,"//*[@class='top-nav']//a[@id='drop1' and contains(text(),'SETTINGS')]","settingsLink","Header page");;
        return webElement;
    }

    public static WebElement personalLink(WebDriver driver){
      
                webElement = FindWebElement.byXpath(driver,"//*[@class='top-nav']//*[text()='Personal']","personalLink","Header page");
                
        return webElement;
    }

    public static WebElement alertsLink(WebDriver driver){
      
                webElement = FindWebElement.byXpath(driver,"//*[@class='top-nav']//*[text()='Alerts']","alertsLink","Header page");
                
        return webElement;
    }

    public static WebElement securityLink(WebDriver driver){
       
                webElement = FindWebElement.byXpath(driver,"//*[@class='top-nav']//*[text()='Security']","securityLink","Header page");
               
        return webElement;
    }

    public static WebElement commandLogLink(WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'commandLog')]","commandLogLink","Header page");
            
        return webElement;
    }
    
    
    public static WebElement batteryCommandLog(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//*[@class='alerts']/div[2]//div[contains(text(),'Charg')]","batteryCommandLog","Header page");
        
    return webElement;
    }

    public static WebElement batteryCommandLogTimestamp(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//*[@class='alerts']/div[2]//div[contains(text(),'Charge')]/following-sibling::div","batteryCommandLog","Header page");
        
    return webElement;
    }
    
    public static WebElement doorCommandLog(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//*[@class='alerts']/div[2]//div[contains(text(),'REMOTE DOOR')]","doorCommandLog","Header page");
        
    return webElement;
    }
    
    public static WebElement climateStartCommandLog(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//*[@class='alerts']/div[2]//div[contains(text(),'REMOTE START (WITH CLIMATE)')]","climateStartCommandLog","Header page");
        
    return webElement;
    }
    
    public static WebElement climateStopCommandLog(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//*[@class='alerts']/div[2]//div[contains(text(),'REMOTE CONTROL STOP')]","climateStopCommandLog","Header page");
        
    return webElement;
    }
  
    
    public static WebElement batteryStopCommandLogTimestamp(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//*[@class='alerts']/div[2]//div[contains(@class,'content')]/div[2]","batteryCommandLog","Header page");
        
    return webElement;
    }
  
    public static WebElement awardsLink(WebDriver driver){
       
                webElement = FindWebElement.byXpath(driver,"//*[@class='top-nav']//*[text()='AWARDS']","awardsLink","Header page");
                
        return webElement;
    }

    public static WebElement notification_Count (WebDriver driver){        
       
                webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'notification')]/span","notification_Count","Header page");
           
        return webElement;
    }      

    public static WebElement notifications_Link (WebDriver driver){
       
                webElement = FindWebElement.byXpath(driver,"//a[contains(text(),'NOTIFICATIONS')]","notifications_Link","Header page");
           
        return webElement;
    }

    public static WebElement notifications (WebDriver driver, String notification_Text){
       
                webElement = FindWebElement.byXpath(driver,"//ul[@class='dropdown-menu']//div[contains(text(),'" + notification_Text + "')]","notifications","Header page");
          return  webElement;
    }  

    public static WebElement myAccountLinkOnSupportPage(WebDriver driver){
       
            webElement = FindWebElement.byLinktext(driver,"My Account","myAccountLinkOnSupportPage","Header page");
           
        return webElement ;
    }

    public static WebElement logOutLink(WebDriver driver){
      
                webElement = FindWebElement.byXpath(driver,"//*[@class='nav-utility ng-scope']//a[text()='LOGOUT'] | //*[@class='nav-utility ng-scope']//a[text()='LOG OUT'] | //*[contains(@href,'logOut')] |//*[@class='login hidden-xs logout-show']/a[text()='Log Out']","logOutLink","Header page");
               
        return webElement;
    }

    public static WebElement refresh_Button (WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//img[contains(@src,'refresh')]","refresh_Button","Header page");
           
        return webElement;
    }
    
    public static WebElement refresh_Indicator (WebDriver driver){
        
            webElement = FindWebElement.byXpath(driver,"//body[@class='processing']","refresh_Indicator","Header page");
           
        return webElement;
    }    

    public static WebElement last_Update_Message (WebDriver driver){
     
            webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'vehicleStatus-date') and not (contains(@class,'hide'))]","last_Update_Message","Header page");
           
        return webElement;
    }
    
    public static WebElement menu (WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'navbar-toggle')]","menu","Header page");
            
        return webElement;
    }
    
    public static WebElement closeMenu (WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//span[text()='x']","closeMenu","Header page");
            
        return webElement;
    }
    
    public static WebElement backButton (WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//span[text()='BACK']","backButton","Header page");
            
        return webElement;
    }
}
