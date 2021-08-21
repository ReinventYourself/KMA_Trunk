package com.rsi.kma.automation.pageObjects.Common;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;


public class RegisterPage {


	public  static WebElement webElement = null;            

	/**
	 * Class: PersonalInfoPage
	 * This class captures following objects- Email address ,Password, Confirm password
	 * Mobile no, I Agree Checkbox, Terms of Service, Privacy policy, Error message 
	 * and Next button
	 * */

	public static class AccountBasics {


		public static WebElement uvoLogo (WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//div[@class='logo-wrap']//img[contains(@src,'uvo-logo')]","alert_Header","RegisterPage");

			return webElement;
		}
		public static WebElement emailAddress(WebDriver driver) {

			webElement = FindWebElement.byId(driver,"emailAddress","emailAddress","RegisterPage");

			return webElement;
		}

		public static WebElement password (WebDriver driver){

			webElement = FindWebElement.byId(driver,"password","password","RegisterPage");

			return webElement;
		}

		public static WebElement confirmPassword (WebDriver driver){

			webElement = FindWebElement.byId(driver,"confirmPassword","confirmPassword","RegisterPage");

			return webElement;
		}

		public static WebElement mobileNo (WebDriver driver){

			webElement = FindWebElement.byId(driver,"mobilePhone","mobileNo","RegisterPage");

			return webElement;
		}

		public static WebElement iAgreeCheckbox (WebDriver driver){

			webElement = FindWebElement.byId(driver,"iAgree","iAgreeCheckbox","RegisterPage");

			return webElement;
		}

		public static class alert_CheckboxNotSelected {

			public static WebElement alert_Header (WebDriver driver){

				webElement = FindWebElement.byXpath(driver,"//*[@id='alertPopup' and contains(@style,'display: block')]//*[@class='popH1']","alert_Header","RegisterPage");

				return webElement;
			}

			public static WebElement alert_Message (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='alertPopup' and contains(@style,'display: block')]//*[@class='txtPop01']","alert_Message","RegisterPage");

				return webElement;
			}

			public static WebElement alert_AcceptButton (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='alertPopup' and contains(@style,'display: block')]//*[@class='butDefault']","alert_AcceptButton","RegisterPage");

				return webElement;
			}
		}                

		public static WebElement termsOfService  (WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//a[text()='UVO eServices Terms of Service']","termsOfService","RegisterPage");

			return webElement;
		}

		public static WebElement privacyPolicy (WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//a[text()='UVO eServices Privacy Policy']","privacyPolicy","RegisterPage");

			return webElement;
		}


		public static WebElement backToHome (WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//*[text()='back to uvo home']","backToHome","RegisterPage");

			return webElement;
		}

		public static WebElement createMyAccount(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,".//*[@class='reg-next dtmConfirmRegInfo']","createMyAccount","RegisterPage");

			return webElement;
		}

		public static WebElement errorMessageBlankField(WebDriver driver){

			FindWebElement.byXpath(driver,"//*[@id='emailIncorrect']","errorMessageBlankField","RegisterPage");

			return webElement;
		}

		public static WebElement errorMessageRegisteredEmail(WebDriver driver){

			FindWebElement.byXpath(driver,"//*[@id='emailExisted']","errorMessageRegisteredEmail","RegisterPage");

			return webElement;
		}
		
		public static WebElement invalidPasword(WebDriver driver){

			FindWebElement.byXpath(driver,"//*[@id='passwordLong' and contains(text(),'a number and cannot contain [^, &, *, (')]","invalidPasword","RegisterPage");

			return webElement;
		}
		
		
		public static WebElement passwordNotMatch(WebDriver driver){

			FindWebElement.byXpath(driver,"//*[@id='passwordNotMatch' and contains(text(),'Passwords do not match')]","passwordNotMatch","RegisterPage");

			return webElement;
		}
		
		public static WebElement phoneNotMatch(WebDriver driver){

			FindWebElement.byXpath(driver,"//*[@id='invalidPhoneNum' and contains(text(),'The phone number is invalid')]","passwordNotMatch","RegisterPage");

			return webElement;
		}
		
	
	}



	/**
	 * Class: AccountCreated
	 * This class captures following objects- Account created heading, Apple app store image, 
	 * Google play store image and login to UVO button.
	 * */

	public static class AccCreated{

		public static WebElement accountCreationSuccess_Heading(WebDriver driver){

			webElement = FindWebElement.byCssSelector(driver,".main-content.app-wrapper>h4","accountCreationSuccess_Heading","RegisterPage");

			return webElement;
		}

		public static WebElement appleAppStore_Image (WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'modal simplify-enroll dark-bg enabled') and not(contains(@class,'hide'))]//img[contains(@src,'appstore.png')]","appleAppStore_Image","RegisterPage");

			return webElement;
		}

		public static WebElement googleAppStore_Image (WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'modal simplify-enroll dark-bg enabled') and not(contains(@class,'hide'))]//img[contains(@src,'googleplay.png')]","googleAppStore_Image","RegisterPage");

			return webElement;
		}

		public static WebElement GoToKiaOwnerPortal(WebDriver driver){

			FindWebElement.byXpath(driver,"//*[text()='Go to Kia Owners Portal']/following-sibling::div/div[@class='arrow-right']","GoToKiaOwnerPortal","RegisterPage");

			return webElement;
		}

		public static WebElement mailVerifyRadioButton(WebDriver driver){

			FindWebElement.byXpath(driver,"//*[contains(@class,'radio') and @value='email']","mailVerifyRadioButton","RegisterPage");

			return webElement;
		}

		public static WebElement send(WebDriver driver){

			FindWebElement.byXpath(driver,"//*[contains(@ng-click,'sendSimplifyOption')]","send","RegisterPage");

			return webElement;
		}




	}



}