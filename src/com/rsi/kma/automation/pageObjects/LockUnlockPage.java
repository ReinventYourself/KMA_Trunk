package com.rsi.kma.automation.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;

public class LockUnlockPage {

   
    private static WebElement webElement = null;
    
  
        public static WebElement lockUnlockHeader(WebDriver driver) {
           
                webElement = FindWebElement.byId(driver,"locked-status-header","lockUnlockHeader","LockUnlockPage");                        
                
            return webElement;
        }   
       
        public static WebElement unlockButton(WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//a[contains(@ng-click,'lockVehicle') and text()='Unlock']","unlockButton","LockUnlockPage");                        
               
            return webElement;
        }   
        
        public static WebElement lockButton(WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//a[contains(@ng-click,'lockVehicle') and text()='Lock']","lockButton","LockUnlockPage");                        
                
            return webElement;
        }      
        
        public static WebElement carDoor(WebDriver driver) {
            
                webElement = FindWebElement.byId(driver,"d1","carDoor","LockUnlockPage");                        
              
            return webElement;
        }  
        
        public static WebElement statusLockUnlock(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'hidden-xs')]/h4[contains(text(),'YOUR VEHICLE IS') and not(contains(@class,'hide'))] | //*[contains(@ng-show,'vehicleStatus') and not(contains(@class,'hide'))] | //*[@class='top hidden-xs']//*[contains(@ng-show,'!vm.doorLockStatus') and contains(text(),'YOUR VEHICLE IS')]","statusLockUnlock","LockUnlockPage");                        
          
        return webElement;
        
        }
        public static WebElement statusLock(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[@class='title locked' and text()='Your Vehicle is Locked']","statusLock","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement statusUnlock(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[@class='title unlocked' and text()='Your Vehicle is unLocked']","statusUnlock","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement statusLockEV1(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'hidden-xs')]/h4[text()='YOUR VEHICLE IS LOCKED']","statusLockEV1","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement statusUnlockEV1(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'hidden-xs')]/h4[text()='YOUR VEHICLE IS UNLOCKED']","statusUnlockEV1","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement pendingUnlockStatus(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[@ng-show='pendingunlock']","pendingUnlockStatus","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement pendingUnlockStatusEV1(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//a/following-sibling::div[contains(text(),'Unlocking vehicle') and contains(@class,'pending')]","pendingUnlockStatusEV1","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement pendingLockStatus(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[@ng-show='pendinglock']","pendingLockStatus","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement pendingLockStatusEV1(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//a/following-sibling::div[contains(text(),'Locking vehicle') and contains(@class,'pending')]","pendingLockStatusEV1","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement syncedTime(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'Synced')]/span/strong","syncedTime","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement refreshVehicleStatusButton(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'vehicle-refresh')]","refreshVehicleStatusButton","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement vehicleSyncStatusEV1(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'vehicleStatus-date')]","vehicleStatusEV1","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement lockButtonEV1(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//a[text()='LOCK']","lockButtonEv1","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement unlockButtonEV1(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//a[text()='UNLOCK']","unlockButtonEv1","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement unlockingVehicleStatusBarMessageEV1(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Unlocking vehicle. Please allow 2-3 minutes.')]","unlockingVehicleStatusBarMessageEV1","LockUnlockPage");                        
          
        return webElement;
        }
    
        public static WebElement lockingVehicleStatusBarMessageEV1(WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Locking vehicle. Please allow 2-3 minutes')]","lockingVehicleStatusBarMessageEV1","LockUnlockPage");                        
          
        return webElement;
        }
        
        public static WebElement vehicleRemoteNotification(WebDriver driver) {

    		webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'info') and contains(text(),'YOUR VEHICLE WAS')]","vehicleChargeNotification","LockUnlockPage");

    		return webElement;      
    	}
                
        public static WebElement systemError(WebDriver driver) {

    		webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'system error has occurred')]","scheduleRequestLoader ","BatteryPage");

    		return webElement;
    	}
        

}

