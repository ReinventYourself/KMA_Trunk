package com.rsi.kma.automation.utility;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class FindWebElement {

    private static Logger    Log = Logger.getLogger(FindWebElement.class.getName());

    public static WebElement byXpath (WebDriver driver, String xPath, String webElementName, String activityName){
        WebElement webElement = null;
        try{
            webElement = driver.findElement(By.xpath(xPath));
            Log.info(webElementName + " is found on " + activityName + " activity");                     
        } catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElement;
        
    }

    public static WebElement byId (WebDriver driver, String id, String webElementName, String activityName){
        WebElement webElement = null;
        try{
            webElement = driver.findElement(By.id(id));
            Log.info(webElementName + " is found on " + activityName + " activity");                     
        } catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElement;
    }

    public static WebElement byName (WebDriver driver, String name, String webElementName, String activityName){
        WebElement webElement = null;
        try{
            webElement = driver.findElement(By.name(name));
            Log.info(webElementName + " is found on " + activityName + " activity");                     
        } catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElement;
    }

    public static WebElement byClassName (WebDriver driver, String className, String webElementName, String activityName){
        WebElement webElement = null;
        try{
            webElement = driver.findElement(By.className(className));
            Log.info(webElementName + " is found on " + activityName + " activity");                     
        } catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElement;
    }

    public static WebElement byCssSelector (WebDriver driver, String cssSelector, String webElementName, String activityName){
        WebElement webElement = null;
        try{
            webElement = driver.findElement(By.cssSelector(cssSelector));
            Log.info(webElementName + " is found on " + activityName + " activity");                     
        } catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElement;
    }
    
    
    
    public static WebElement byLinktext (WebDriver driver, String linkText, String webElementName, String activityName){
        WebElement webElement = null;
        try{
            webElement = driver.findElement(By.linkText(linkText));
            Log.info(webElementName + " is found on " + activityName + " activity");                     
        } catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElement;
    }
    public static List<WebElement> findElementListById (WebDriver driver, String Id ,String webElementName, String activityName )
    {   
        List<WebElement> webElements = null;
        try{ 
            webElements = driver.findElements(By.id(Id));
            Log.info(webElementName + " is found on " + activityName + " activity");
        }catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElements;
    }
    
    
    public static List<WebElement> findElementListByClassname (WebDriver driver, String Id ,String webElementName, String activityName )
    {   
        List<WebElement> webElements = null;
        try{ 
            webElements = driver.findElements(By.className(Id));
            Log.info(webElementName + " is found on " + activityName + " activity");
        }catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElements;
    }

    
    public static List<WebElement> findElementListByXpath (WebDriver driver, String Id ,String webElementName, String activityName )
    {   
        List<WebElement> webElements = null;
        try{ 
            webElements = driver.findElements(By.xpath(Id));
            Log.info(webElementName + " is found on " + activityName + " activity");
        }catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElements;
    }
    
    public static List<WebElement> findElementListByName (WebDriver driver, String Id ,String webElementName, String activityName )
    {   
        List<WebElement> webElements = null;
        try{ 
            webElements = driver.findElements(By.name(Id));
            Log.info(webElementName + " is found on " + activityName + " activity");
        }catch(Exception e){
            Log.error(webElementName + " is not found on " + activityName + " activity | " + new Object(){}.getClass().toString() + " | method " + new Object(){}.getClass().getEnclosingMethod().getName());
            Log.debug(e.getLocalizedMessage());
            Reporter.log(webElementName + " is not found on " + activityName + " activity");                
        }
        return webElements;
    }

    

   
}
