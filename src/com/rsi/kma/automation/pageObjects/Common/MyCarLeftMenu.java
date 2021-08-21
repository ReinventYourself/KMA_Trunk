package com.rsi.kma.automation.pageObjects.Common;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;

public class MyCarLeftMenu {
    
   
    private static WebElement webElement = null;        

    public static WebElement overViewLink(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//h1[contains(@class,'ng-scope')]//a[contains(@href,'overview')]","overviewLink","CarLeftMenu");
            
        return webElement;
    }

    public static WebElement drivingActivityLink(WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//h1[contains(@ng-class,'drivingActivity')]/a","drivingActivityLink","CarLeftMenu");
           
        return webElement;
    }

    public static WebElement myCarZoneLink(WebDriver driver) {
                   
            webElement = FindWebElement.byXpath(driver,"//h1[@class='ng-scope']//a[contains(@href,'mycarzone')]","myCarZoneLink","CarLeftMenu");
           
        return webElement;
    }

    public static WebElement maintenanceLink(WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//h1[@class='ng-scope']//a[contains(@href,'maintenance')]","maintenanceLink","CarLeftMenu");
           
        return webElement;
    }

    public static WebElement tripInformationLink(WebDriver driver) {
                 
            webElement = FindWebElement.byXpath(driver,"//h1[contains(@class,'ng-scope')]//a[contains(@href,'tripInfo')]","tripInformationLink","CarLeftMenu");
            
        return webElement;
    }
    
    public static WebElement myPOILink(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//h1[contains(@ng-class,'poi')]/a","myPOILink","CarLeftMenu");
            
        return webElement;
    }
    
    public static WebElement Remote_Link(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//h1[contains(@class,'ng-scope')]//a[contains(@href,'climate')]","Remote_Link","CarLeftMenu");
            
        return webElement;
    }
    
    public static WebElement Maintenance_Link(WebDriver driver) {
        
        webElement = FindWebElement.byXpath(driver,"//h1[contains(@class,'ng-scope')]/a[text()='MAINTENANCE']","Maintenance_Link","CarLeftMenu");
        
    return webElement;
    }
    
    public static WebElement chargingStations_Link(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//h1[contains(@class,'ng-scope')]//a[contains(@href,'chargingStations')]","chargingStations_Link","CarLeftMenu");
            
        return webElement;
    }
    
    public static WebElement battery_Link(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//h1[contains(@ng-class,'battery')]/a","battery_Link","CarLeftMenu");
           
        return webElement;
    }
    public static WebElement connect_Link(WebDriver driver) {
        
        webElement = FindWebElement.byXpath(driver,"//h1[contains(@ng-class,'connect')]/a","connect_Link","CarLeftMenu");
       
    return webElement;
    }
    public static WebElement lockUnlock_Link(WebDriver driver) {
        
        webElement = FindWebElement.byXpath(driver,"//h1[contains(@ng-class,'doorStatus')]/a","lock_Unlock link","CarLeftMenu");
       
    return webElement;
    }
    
    public static WebElement climateControl_Link(WebDriver driver) {
        
        webElement = FindWebElement.byLinktext(driver,"Climate Control","Climate Control link","CarLeftMenu");
       
    return webElement;
    }
    
    public static WebElement appointments_Link(WebDriver driver) {
        
        webElement = FindWebElement.byLinktext(driver,"Appointments","Appointments link","CarLeftMenu");
       
    return webElement;
    }

    public static WebElement findMycarLink(WebDriver driver) {
    
    webElement = FindWebElement.byXpath(driver,"//h1[contains(@ng-class,'findMyCar')]/a","lock_Unlock link","CarLeftMenu");
   
return webElement;
}

  
}
