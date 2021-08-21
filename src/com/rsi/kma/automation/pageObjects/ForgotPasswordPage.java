package com.rsi.kma.automation.pageObjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;


public class ForgotPasswordPage {

	private static Logger Log = Logger.getLogger(ForgotPasswordPage.class.getName());
    public static WebElement webElement = null ;       
    
    public static WebElement kiaLogo(WebDriver driver){
        
            webElement = FindWebElement.byXpath(driver,"//img[contains(@src,'kia-logo')]","kiaLogo","Forgotpassword");
           
        
        return webElement;
    }
    
    public static WebElement uvoLogo(WebDriver driver){
        
            webElement = FindWebElement.byXpath(driver,"//*[@class='logo-wrap']//img[contains(@src,'uvo-logo-large')]","uvoLogo","Forgotpassword");
            
        return webElement;
    }
    
    public static WebElement byEmail(WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,".//*[text()='Receive email with instructions to reset password']","byEmail","Forgot password");
            
        return webElement;
    }
    
    public static WebElement bySecurityQuestions(WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//label[text()='Answer My Security Questions']","bySecurityQuestions","Forgot password");
           
        return webElement;
    }
    
    public static WebElement emailAddressField(WebDriver driver){
        
            webElement = FindWebElement.byId(driver,"emailAddress","emailAddressField","Forgot password");
            
        return webElement;
    }
    public static WebElement emptyEmailMsg(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//*[@id='fillOutEmail']","emptyEmailMsg","Forgot password");
        
    return webElement;
}
    public static WebElement invalidEmailMsg(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//*[@id='nonExistedEmail']","invalidEmailMsg","Forgot password");
        
    return webElement;
}
public static WebElement incorrectEmailMsg(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//*[@id='emailIncorrect']","incorrectEmailMsg","Forgot password");
        
    return webElement;
}
    
    
    public static WebElement answerSecurityQues(WebDriver driver){
        
        webElement = FindWebElement.byXpath(driver,"//div[text()='Answer My Security Questions']","emailAddressField","Forgot password");
        
    return webElement;
}
    
   
    public static WebElement nextButton(WebDriver driver){
                  
        	webElement = FindWebElement.byXpath(driver,"//*[@id='btnNext']/div[@class='reg-next']","nextButton","Forgotpassword");
        
        return webElement;
    }
    
    public static WebElement cancelButton(WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//*[@id='resetPass']/div/form//div[text()='Cancel']","cancelButton","Forgot password");
            Log.info("Cancel button on Forgot Password page is found");
        
        return webElement;
    }
    
    public static WebElement errorMessage(WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//form[@name='resetPasswordForm']//*[@class='errorMessage' and @style='display: block;']","errorMessage","Forgotpassword");
           
        return webElement;
    }
    
    public static WebElement returnToLogin(WebDriver driver){
        
            webElement = FindWebElement.byXpath(driver,"//*[text()='Return to Login']","returnToLogin","Forgotpassword");
            
        return webElement;
    }
  
    public static WebElement beSureToCheckYourSpamFolder (WebDriver driver){
        
            webElement = FindWebElement.byXpath(driver,"//*[@class='main-content']/div/div[contains(text(),'Be sure to check your spam folder.')]","beSureToCheckYourSpamFolder","Forgotpassword");
            
        return webElement;
    }
    
    public static WebElement resendPassword(WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//div[text()='Send Password Reset Email']","resendPassword","Forgotpassword");
            
        return webElement;
    }
    
    public static WebElement emailSentConfirm (WebDriver driver) {
    
    		webElement = FindWebElement.byXpath(driver,"//*[text()='Email Sent!']","emailSentConfirm","Forgot password");
    		
    	return webElement;
    }
    
    public static WebElement alertPopUp(WebDriver driver){
    	
         webElement = FindWebElement.byXpath(driver,"//*[@id='popWrap']","alertPopUp","Forgotpassword");
            
        return webElement;
    }
    
  
    public static WebElement alertOkButton(WebDriver driver){
    	
        webElement = FindWebElement.byXpath(driver,".//*[@value='OK']","alertOkButton","Forgotpassword");
           
       return webElement;
   }
    
    public static WebElement popUpPasswordUpdatedText (WebDriver driver) {
    	
		webElement = FindWebElement.byXpath(driver,"//*[text()='Password successfully updated.']","popUpPasswordUpdatedText","Forgot Password");
		
	return webElement;
}
   
 
    public static WebElement myAnswer(WebDriver driver){
       
            webElement = FindWebElement.byCssSelector(driver,"#myAnswer","myAnswer","Forgotpassword");
            
        return webElement;
    }
    
    public static WebElement nextButtonSecurityQuestions(WebDriver driver){
       
            webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Next')]","nextButtonSecurityQuestions","Forgotpassword");
           
        return webElement;
    }
    
    public static WebElement newPassword(WebDriver driver){
        
            webElement = FindWebElement.byXpath(driver,"//label[text()='Password']/following-sibling::div[1]/input","newPassword","Forgot password");
           
        return webElement;
    }
    
    public static WebElement confirmNewPassword(WebDriver driver){
        
            webElement = FindWebElement.byXpath(driver,"//label[text()='Confirm Password']/following-sibling::div[1]/input","confirmNewPassword","Forgot password");
          
        return webElement;
    }
    
    public static WebElement changeAndLoginButton(WebDriver driver){
     
            webElement = FindWebElement.byXpath(driver,"//div[text()='Change & Log In']","changeAndLoginButton","Forgotpassword");
            
        return webElement;
    }
    
   
    
    
    public static WebElement securityQuestionText (WebDriver driver){
    	
    		webElement = FindWebElement.byClassName(driver,"security-question","securityQuestionText","Forgot Password");
    		
    	return webElement;
    }
    
    
  
    

    
}
