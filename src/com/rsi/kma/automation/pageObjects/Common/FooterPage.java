package com.rsi.kma.automation.pageObjects.Common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;

public class FooterPage {

    
    private static WebElement webElement = null;

    public static WebElement kiaHomepageLink(WebDriver driver) {
        
            webElement = FindWebElement.byLinktext(driver,"Kia Homepage","kiaHomepageLink","Footer");
            
        return webElement;
    }

    public static WebElement privacyPolicyLink(WebDriver driver) {
        
            webElement = FindWebElement.byLinktext(driver,"Privacy Policy","privacyPolicyLink","Footer");
           
        return webElement;
    }

    public static WebElement termsOfServiceLink(WebDriver driver) {
       
            webElement = FindWebElement.byLinktext(driver,"Terms of Service","termsOfServiceLink","Footer");
           
        return webElement;
    }

    public static WebElement disclaimerLink(WebDriver driver) {
        
            webElement = FindWebElement.byLinktext(driver,"Disclaimer","disclaimerLink","Footer");
           
        return webElement;
    }

    public static WebElement contactUsLink(WebDriver driver) {
     
            webElement = FindWebElement.byLinktext(driver,"Contact Us","contactUsLink","Footer");
            
        return webElement;
    }

    public static WebElement footerBuildInfo(WebDriver driver) {
       
            webElement = FindWebElement.byCssSelector(driver,"span#footer-build-information","FooterBuild Info","Footer");
           
        return webElement;
    }

    public static WebElement adChoices(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//*[contains(@class, 'ac-link')]","adchoices","Footer");

           
        return webElement;
    }
}

