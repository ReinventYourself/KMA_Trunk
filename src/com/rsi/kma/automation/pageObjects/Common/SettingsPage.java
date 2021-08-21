package com.rsi.kma.automation.pageObjects.Common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;



public class SettingsPage {

   
    private static WebElement webElement = null;    

    public static class PersonalSettings {

        public static WebElement firstName(WebDriver driver) {
            
                
                    webElement = FindWebElement.byCssSelector(driver,"input[name=csmrFnm]","firstName","SettingsPage");
                    
            return webElement;
        }

        public static WebElement lastName(WebDriver driver) {
            
                    webElement = FindWebElement.byCssSelector(driver,"input[name=csmrLnm]","lastName","SettingsPage");
                   
            return webElement;
        }

        public static WebElement stateName(WebDriver driver,String stateName) {
           
               
                    webElement = FindWebElement.byXpath(driver,"//*[@id='stateCode']/option[contains(text(),'CA')]","stateName","SettingsPage");
                   
            return webElement;
        }

        public static WebElement address1(WebDriver driver) {
           
                    webElement = FindWebElement.byCssSelector(driver,"input[name=csmrAdr]","address1","SettingsPage");
                    
            return webElement;
        }

        public static WebElement address2(WebDriver driver) {
          
                    webElement = FindWebElement.byCssSelector(driver,"input[name=csmrAdr2]","address2","SettingsPage");
                    
            return webElement;
        }

        public static WebElement city(WebDriver driver) {
            
                    webElement = FindWebElement.byCssSelector(driver,"input[name=csmrAdrCity]","city","SettingsPage");
                    
            return webElement;
        }

        public static WebElement state(WebDriver driver) {
          
                    webElement = FindWebElement.byCssSelector(driver,"#stateCode","state","SettingsPage");
                    
            return webElement;
        }

        public static WebElement zipCode(WebDriver driver) {
            
                    webElement = FindWebElement.byCssSelector(driver,"input[name=zip]","zipCode","SettingsPage");
                    
            return webElement;
        }

        public static WebElement mobilePhoneNumber(WebDriver driver) {
           
                    webElement = FindWebElement.byCssSelector(driver,"input#txtPhoneNum","mobilePhoneNumber","SettingsPage");
                    
            return webElement;
        }

        public static WebElement password(WebDriver driver) {
           
                    webElement = FindWebElement.byCssSelector(driver,"input#newPW","password","SettingsPage");
                   
            return webElement;
        }

        public static WebElement confirmPassword(WebDriver driver) {
           
                    webElement = FindWebElement.byCssSelector(driver,"input#confirmNewPW","confirmPassword","SettingsPage");
                   
            return webElement;
        }

        public static WebElement saveButton(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"btnUpdate","saveButton","SettingsPage");
                    
            return webElement;
        }

        public static WebElement popupButton(WebDriver driver) {
            
                    webElement = FindWebElement.byCssSelector(driver,"input.butDefault","popupButton","SettingsPage");
                    
            return webElement;
        }

        public static WebElement label(WebDriver driver) {
          
                    webElement = FindWebElement.byXpath(driver,"//form[@name='PersonalForm'/fieldset/label/span[1]","label","SettingsPage");
                    
            return webElement;
        }

        public static WebElement popupAcceptButton(WebDriver driver) {
           
                    webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button button')]","popupAcceptButton","SettingsPage");
                   
            return webElement;
        }

        public static WebElement blankConfirmPasswordMessage(WebDriver driver) {
          
                    webElement = FindWebElement.byId(driver,"txtConfirmPW","blankConfirmPasswordMessage","SettingsPage");
                   
            return webElement;
        }

        public static WebElement blankPasswordMessage(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"txtPassword","blankPasswordMessage","SettingsPage");
                    
            return webElement;
        }

        public static WebElement shortPasswordMessage(WebDriver driver) {
          
               
                    webElement = FindWebElement.byId(driver,"passwordInvalid","shortPasswordMessage","SettingsPage");
                   
            return webElement;
        }

        public static WebElement longPasswordMessage(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"passwordLong","longPasswordMessage","SettingsPage");
                    
            return webElement;
        }

        public static WebElement comparePasswordMessage(WebDriver driver) {
            
                    webElement = FindWebElement.byId(driver,"txtComparePW","comparePasswordMessage","SettingsPage");
                    
            return webElement;
        }
    }

    public static class Alerts {
        public static WebElement maintenance500milesAlert(WebDriver driver) {
          
                    webElement = FindWebElement.byId(driver,"maint1-email","maintenance500milesAlert","SettingsPage");
                   return webElement;
        }

        public static WebElement maintenance1000milesAlert(WebDriver driver) {
            
                    webElement = FindWebElement.byId(driver,"maint2-email","maintenance1000milesAlert","SettingsPage");
                    
            return webElement;
        }

        public static WebElement maintenance1500milesAlert(WebDriver driver) {
            
                    webElement = FindWebElement.byId(driver,"maint3-email","maintenance1500milesAlert","SettingsPage");
                   
            return webElement;
        }

        public static WebElement maintenanceVehicleHealthReportAlert(
                WebDriver driver) {
            
                    webElement = FindWebElement.byId(driver,"vehicleReport-email","maintenanceVehicleHealthReportAlert","SettingsPage");
                   
            return webElement;
        }

        public static WebElement uvoAlerts(WebDriver driver) {
          
                    webElement = FindWebElement.byId(driver,"softwareUpdate-email","uvoAlerts","SettingsPage");
                    
            return webElement;
        }

        public static WebElement saveButton(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"btnUpdate","saveButton","SettingsPage");
                    
            return webElement;
        }
    }

    public static class Security {

        public static WebElement securityQuestion1(WebDriver driver) {
            
                    webElement = FindWebElement.byName(driver,"securityQuestionId","securityQuestion1","SettingsPage");
                    
            return webElement;
        }

        public static WebElement securityAnswer1(WebDriver driver) {
           
                    webElement = FindWebElement.byCssSelector(driver,"input[name=answer1]","securityAnswer1","SettingsPage");
                    
            return webElement;
        }

        public static WebElement securityQuestion2(WebDriver driver) {
           
                    webElement = FindWebElement.byName(driver,"securityQuestionId2","securityQuestion2","SettingsPage");
                    
            return webElement;
        }

        public static WebElement securityAnswer2(WebDriver driver) {
            
                    webElement = FindWebElement.byCssSelector(driver,"input[name=answer2]","securityAnswer2","SettingsPage");
                    
            return webElement;
        }

        public static WebElement securityQuestion3(WebDriver driver) {
            
                    webElement = FindWebElement.byName(driver,"securityQuestionId3","securityQuestion3","SettingsPage");
                    
            return webElement;
        }

        public static WebElement securityAnswer3(WebDriver driver) {
           
                    webElement = FindWebElement.byCssSelector(driver,"input[name=answer3]","securityAnswer3","SettingsPage");
                   
            return webElement;
        }

        public static WebElement saveButton(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"btnUpdate","saveButton","SettingsPage");
                   
            return webElement;
        }

        public static class popupSuccessful {
            public static WebElement popupHeader(WebDriver driver) {
               
                        webElement = FindWebElement.byClassName(driver,"popH1","popupHeader","SettingsPage");
                        
                return webElement;
            }

            public static WebElement popupText(WebDriver driver) {
               
                        webElement = FindWebElement.byClassName(driver,"success-body","popupText","SettingsPage");
                        
                return webElement;
            }

            public static WebElement popupAcceptButton(WebDriver driver) {
               
                  
                        webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button button')]","popupAcceptButton","SettingsPage");
                       
                return webElement;
            }
        }

        public static WebElement blankQAErrorMessage(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"txtAnswer1","blankQAErrorMessage","SettingsPage");
                  
            return webElement;
        }

        public static WebElement blankQErrorMessage(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"txtQuestion1","blankQErrorMessage","SettingsPage");
                   
            return webElement;
        }
    }

    public static class settingSideMenu {

        public static WebElement personalSideLink(WebDriver driver) {
            
                    webElement = FindWebElement.byLinktext(driver,"PERSONAL","personalSideLink","SettingsPage");
                    
            return webElement;
        }

        public static WebElement alertSideLink(WebDriver driver) {
           
                    webElement = FindWebElement.byLinktext(driver,"ALERTS","alertSideLink","SettingsPage");
                   
            return webElement;
        }

        public static WebElement securitySideLink(WebDriver driver) {
           
                    webElement = FindWebElement.byLinktext(driver,"SECURITY","securitySideLink","SettingsPage");
                    
            return webElement;
        }
    }

    public static class sessionTimeOut {
        public static WebElement sessionTimeOutMessage(WebDriver driver) {
         
                webElement = FindWebElement.byXpath(driver,"//*[@class='sessionTimerWrap']/div","sessionTimeOutMessage","SettingsPage");
                
            return webElement;
        }

        public static WebElement keepMeSignedIn_button(WebDriver driver) {
          
                webElement = FindWebElement.byId(driver,"keepAlive","keepMeSignedIn_button","SettingsPage");
               
            return webElement;
        }

        public static WebElement logout_button(WebDriver driver) {
        
                webElement = FindWebElement.byId(driver,"logMeOut","logout_button","SettingsPage");
                
            return webElement;
        }
    }

    public static class KH_Setting_Page {

        public static WebElement remoteDoorLockUnlockSms(WebDriver driver) {
          
              
                    webElement = FindWebElement.byId(driver,"remoteDoor-sms","remoteDoorLockUnlockSms","SettingsPage");
                   
            return webElement;
        }

        public static WebElement remoteDoorLockunlockPush(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"remoteDoor-push","remoteDoorLockunlockPush","SettingsPage");
                    
            return webElement;
        }

        public static WebElement remoteDoorLockunlockEmail(WebDriver driver) {
            
                    webElement = FindWebElement.byId(driver,"remoteDoor-email","remoteDoorLockunlockEmail","SettingsPage");
                    
            return webElement;
        }

        public static WebElement remoteStartStopSms(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"remoteStart-sms","remoteStartStopSms","SettingsPage");
                   
            return webElement;
        }

        public static WebElement remoteStartStopPush(WebDriver driver) {
          
             
                    webElement = FindWebElement.byId(driver,"remoteStart-push","remoteStartStopPush","SettingsPage");
                    
            return webElement;
        }

        public static WebElement remoteStartStopEmail(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"remoteStart-email","remoteStartStopEmail","SettingsPage");
                   
            return webElement;
        }

        public static WebElement curfewLimitAlertSms(WebDriver driver) {
          
              
                    webElement = FindWebElement.byId(driver,"curfew-sms","curfewLimitAlertSms","SettingsPage");
                   
            return webElement;
        }

        public static WebElement curfewLimitAlertPush(WebDriver driver) {
           
               
                    webElement = FindWebElement.byId(driver,"curfew-push","curfewLimitAlertPush","SettingsPage");
                    
            return webElement;
        }

        public static WebElement curfewLimitAlertEmail(WebDriver driver) {
            
                
                    webElement = FindWebElement.byId(driver,"curfew-email","curfewLimitAlertEmail","SettingsPage");
                    
            return webElement;
        }

        public static WebElement geoFenceAlertSms(WebDriver driver) {
            

                
                    webElement = FindWebElement.byId(driver,"geofence-sms","geoFenceAlertSms","SettingsPage");
                   
            return webElement;
        }

        public static WebElement geoFenceAlertPush(WebDriver driver) {
           
               
                    webElement = FindWebElement.byId(driver,"geofence-push","geoFenceAlertPush","SettingsPage");
                   
            return webElement;
        }

        public static WebElement geoFenceAlertEmail(WebDriver driver) {
          
                
                    webElement = FindWebElement.byId(driver,"geofence-email","geoFenceAlertEmail","SettingsPage");
                   
            return webElement;
        }

        public static WebElement speedAlertSms(WebDriver driver) {
          

              
                    webElement = FindWebElement.byId(driver,"speed-sms","speedAlertSms","SettingsPage");
                    
            return webElement;
        }

        public static WebElement speedAlertPush(WebDriver driver) {
           
                    webElement = FindWebElement.byId(driver,"speed-push","speedAlertPush","SettingsPage");
                    
            return webElement;
        }

        public static WebElement speedAlertEmail(WebDriver driver) {
           
               
                    webElement = FindWebElement.byId(driver,"speed-email","speedAlertEmail","SettingsPage");
                    
               
            return webElement;
        }

        public static WebElement oilChangeIntervalReachedSms(WebDriver driver) {
           

               
                    webElement = FindWebElement.byId(driver,"oilChange-sms","oilChangeIntervalReachedSms","SettingsPage");
                    
            return webElement;
        }

        public static WebElement oilChangeIntervalReachedPush(WebDriver driver) {
            
                    webElement = FindWebElement.byId(driver,"oilChange-push","oilChangeIntervalReachedPush","SettingsPage");
                    
            return webElement;
        }

        public static WebElement oilChangeIntervalReachedEmail(WebDriver driver) {
          
              
                    webElement = FindWebElement.byId(driver,"oilChange-email","oilChangeIntervalReachedEmail","SettingsPage");
                    
            return webElement;
        }

        public static WebElement personalSettingText(WebDriver driver) {
          
                    webElement = FindWebElement.byXpath(driver,"//h1[contains(text(),'PERSONAL SETTINGS')]","personalSettingText","SettingsPage");
                   
            return webElement;
        }

        public static WebElement maintenance_Diagnostics_Text(WebDriver driver) {
          
                    webElement = FindWebElement.byXpath(driver,"//h1[contains(text(),'MAINTENANCE & DIAGNOSTICS ALERTS')]","maintenance_Diagnostics_Text","SettingsPage");
                    
            return webElement;
        }
    }

    public static WebElement commandLog(WebDriver driver) {

       
                webElement = FindWebElement.byId(driver,"commandsContain","commandLog","SettingsPage");
               
        return webElement;
    }

    public static WebElement historyCommandLog(WebDriver driver) {
       
           
                webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'nav-secondary')]/h1/a","historyCommandLog","SettingsPage");
                
        return webElement;
    }
}
