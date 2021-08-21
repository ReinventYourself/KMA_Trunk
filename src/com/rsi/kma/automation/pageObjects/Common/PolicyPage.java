package com.rsi.kma.automation.pageObjects.Common;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;

public class PolicyPage {
    
   
    private static WebElement  webElement      = null;
    
    public static class Header {
        public static WebElement kiaLogo (WebDriver driver){
            
                webElement = FindWebElement.byCssSelector(driver,".kia-logo.img-responsive","kiaLogo","Policy page");
                
            return webElement;
        }
        
        public static WebElement uvoLogo(WebDriver driver){
          
                webElement = FindWebElement.byCssSelector(driver,".kia-logo.img-responsive","kiaLogo","Policy page");
                
            return webElement;
        }
        
        public static WebElement supportLink (WebDriver driver){
         
                webElement = FindWebElement.byXpath(driver,"//*/a[text()='Support']","kiaLogo","Policy page");
                
            return webElement;
        }
        
        public static WebElement registerLink (WebDriver driver){
            
                webElement = FindWebElement.byId(driver,"regLink","kiaLogo","Policy page");
                
            return webElement;
        }
        
        public static WebElement logOut (WebDriver driver){
            
                webElement = FindWebElement.byId(driver,"login","kiaLogo","Policy page");
                
            return webElement;
        }
    }
    
    public static class LeftMenu {
        public static WebElement news (WebDriver driver){
           
                webElement = FindWebElement.byXpath(driver,"//*/a[text()='News']","kiaLogo","Policy page");
               
            return webElement;
        }
        
        public static WebElement privacyPolicy (WebDriver driver){
           
                webElement = FindWebElement.byXpath(driver,"//*/a/p[text()='Privacy Policy']","kiaLogo","Policy page");
               
            return webElement;
        }
        
        public static WebElement termsOfService (WebDriver driver){
            
                webElement = FindWebElement.byXpath(driver,"//*/a/p[text()='Terms of Service']","kiaLogo","Policy page");
               
            return webElement;
        }
        
        public static WebElement disclaimer (WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//*/a/p[text()='Disclaimer']","kiaLogo","Policy page");
               
            return webElement;
        }
        
        public static WebElement backToHome (WebDriver driver){
            
                webElement = FindWebElement.byXpath(driver,"//*[@class='legal-back-home']/a","kiaLogo","Policy page");
               
            return webElement;
        }
    }
    
    public static WebElement pageHeading (WebDriver driver){
     
            webElement = FindWebElement.byCssSelector(driver,".clear","kiaLogo","Policy page");
            
        return webElement;
    }
}

