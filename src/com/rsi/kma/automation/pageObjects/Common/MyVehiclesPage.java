package com.rsi.kma.automation.pageObjects.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;


public class MyVehiclesPage {

	private static WebElement webElement = null;    

	public static WebElement nickname(WebDriver driver, String nickname) {


		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'nickname')][text()='"+ nickname +"']","nickname","MyVehiclesPage");

		return webElement;
	}
	public static WebElement zipcode(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[@id='zipcode']","zipcode","MyVehiclesPage");

		return webElement;
	}
	public static WebElement getDealer(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'getDealers')] | //*[@id='dealer-modal-content']//div[@class='box-3']/button","getDealer","MyVehiclesPage");

		return webElement;
	}
	public static WebElement selectDealer(WebDriver driver) {


		webElement = FindWebElement.byCssSelector(driver,".results > li:nth-child(1) >.distance","selectDealer","MyVehiclesPage");

		return webElement;
	}

	
	
	public static WebElement batteryStatus(WebDriver driver,String nickname){

		webElement= FindWebElement.byXpath(driver,"//*[starts-with(@class,'nickname')][text()='"+ nickname +"']/ancestor::div[@class='widget-box border hover-on vehicle-current']//div[contains(@ng-class,'Battery')]/div","batteryStatus","BatteryPage");

		return webElement;  
	} 

	public static WebElement batteryRange(WebDriver driver,String nickname){

		webElement= FindWebElement.byXpath(driver,"//*[starts-with(@class,'nickname')][text()='"+ nickname +"']/ancestor::div[@class='widget-box border hover-on vehicle-current']//div[contains(text(),'Range')]","batteryRange","BatteryPage");

		return webElement;  
	} 


	public static WebElement timestamp(WebDriver driver,String nickname){

		webElement= FindWebElement.byXpath(driver,
				"//*[starts-with(@class,'nickname')][text()='"+ nickname +"']/ancestor::div[@class='widget-box border hover-on vehicle-current']//div[contains(@class,'message received')]/div | //*[starts-with(@class,'nickname')][text()='"+ nickname +"']/ancestor::div[@class='widget-box border hover-on vehicle-current']//div[contains(@class,'message received')]/span","timestamp","BatteryPage");

		return webElement;  
	} 


	public static WebElement refreshButton(WebDriver driver,String nickname){

		webElement= FindWebElement.byXpath(driver,"//*[starts-with(@class,'nickname')][text()='"+ nickname +"']/ancestor::div[@class='widget-box border hover-on vehicle-current']//div[contains(@class,'refreshStatusButton')]","refreshButton","BatteryPage");

		return webElement;  
	} 

	public static WebElement requestingvehicleStatus(WebDriver driver){

		webElement= FindWebElement.byXpath(driver,"//div[@class='status']//*[text()='Refreshing status. Please allow 2-3 minutes.']","requestingvehicleStatus","BatteryPage");

		return webElement;  
	} 


	public static WebElement vehicleSelector(WebDriver driver)
	{
		webElement=FindWebElement.byClassName(driver,"//div[@class='nav-vehicle-selector']", "Vehicle selector ", "Vehicle Page");
		return webElement;

	}
	public static WebElement manageButton(WebDriver driver,String nickname)
	{

		webElement = FindWebElement.byXpath(driver,"//*[text()='"+nickname+"']/parent::*/parent::*//img[@class='hidden-xs ng-scope']","manage button","MyVehiclesPage");

		return webElement;

	}

	public static WebElement manageButtonNickName(WebDriver driver)
	{
		webElement=FindWebElement.byXpath(driver,"//*[@class='manage-card']//input[@name='vehNick']", " manageButtonNickName ", "Manage");
		return webElement;

	}
	public static WebElement manageDoneButton(WebDriver driver)
	{
		webElement=FindWebElement.byXpath(driver,"//*[@class='manage-card']//a[contains(@class,'done')]", " manageDoneButton ", "Manage");
		return webElement;

	}
	

	public static WebElement newName(WebDriver driver,String newName)
	{
		webElement=FindWebElement.byXpath(driver,"//*[text()='"+newName+"']", " newName ", " My vehicles");
		return webElement;

	}
	public static WebElement VIN(WebDriver driver,String vin)
	{
		webElement=FindWebElement.byXpath(driver,"//*[text()='"+vin+"']", " vin ", " My vehicles");
		return webElement;

	}


	public static WebElement yearAndModel(WebDriver driver, String nickname,
			String yearAndModel) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'nickname')][text()='" + nickname + "']/following-sibling::div[text()='" + yearAndModel + "']", " yearAndModel ", " My vehicles");                   

		return webElement;
	}

	public static WebElement addVehicle(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,".//*[@id='add-btn']", " addVehicle ", " My vehicles");

		return webElement;
	}

	public static WebElement notActiveVehicleMessage(WebDriver driver,
			String nickname) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'nickname')][text()='" + nickname + "']/parent::div/parent::div/parent::div/following-sibling::div[starts-with(@class,'messages inactive-vin')]//*[@class='message']",
				" notActiveVehicleMessage ", " My vehicles");                            

		return webElement;
	}

	public static WebElement noVehicleAddedMessage(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='messages no-active-vin']//div[@class='message']", " noVehicleAddedMessage ", " My vehicles");

		return webElement;
	}


	public static class Manage {

		public static WebElement nickname(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='manage-card']//input[@name='vehNick']", " nickname ", " My vehicles");

			return webElement;
		}

		public static WebElement vin(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='manage-card']//*[@class='content']//strong", " vin ", " My vehicles");

			return webElement;
		}

		public static WebElement deleteVehicleButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='manage-card']//a[@class='delete clickable']", " deleteVehicleButton ", " My vehicles");

			return webElement;
		}

		public static WebElement doneButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='manage-card']//a[contains(@class,'done')]", " doneButton ", " My vehicles");

			return webElement;
		}

		public static WebElement popUpDeleteButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'vehicle-delete')]//span[text()='Delete Vehicle']", " popUpDeleteButton ", " My vehicles");

			return webElement;
		}

		public static WebElement popUpCloseButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='manage-card']//img[contains(@src,'Close')]", " popUpCancelButton ", " My vehicles");

			return webElement;
		}
		public static WebElement cancelDeleteVehicle(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Cancel']", " cancel delete vehicle ", " My vehicles");

			return webElement;
		}
		
		public static WebElement confirmDeleteVehicle(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//span[text()='Delete Vehicle']", " cancel delete vehicle ", " My vehicles");

			return webElement;
		}
		
	}
	public static class AddVehicle {


		public static WebElement vinTextBox(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'addVehicleOption') and contains(@class,'input-textbox')]/input", " vinTextBox ", " My vehicles");

			return webElement;
		}

		public static WebElement addVehicleArrow(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'addVehicle')]", " addVehicleArrow ", " My vehicles");

			return webElement;
		}


		public static WebElement vehicleName(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'modal simplify-enroll') and not(contains(@class,'hide'))]//div[@class='vehImg']/following-sibling::p", " vehicleName ", " My vehicles");

			return webElement;
		}
		public static WebElement closePopup(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'modal simplify-enroll') and not(contains(@class,'hide'))]//p[@class='title']/img", " close pop up ", " My vehicles");

			return webElement;
		}
		
		public static WebElement nicknameAddVehicle(WebDriver driver,String vehicleName) {

			webElement = FindWebElement.byXpath(driver,"//div[text()='"+vehicleName+"']", " vehicle name  ", " My vehicles");

			return webElement;
		}
		
		public static WebElement nickname(WebDriver driver,String vehicleName) {

			webElement = FindWebElement.byXpath(driver,"//div[text()='"+vehicleName+"']/preceding-sibling::div", " vehicle name  ", " My vehicles");

			return webElement;
		}
		
		public static WebElement alreadyAddedVINMsg(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[text()='VIN is invalid or already associated with this account']", "alreadyAddedVINMsg", " My vehicles");

			return webElement;
		}
		
		public static WebElement lookMyKiaInstead(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'like to look up my Kia instead')]", "lookMyKiaInstead", " My vehicles");

			return webElement;
		}
		public static WebElement modelDropDown(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-model,'myModel')]", "modelDropDown", " My vehicles");

			return webElement;
		}
		
		public static WebElement yearDropDown(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@id='modelYear']", "yearDropDown", " My vehicles");

			return webElement;
		}
		
		//Cadenza
		
		//2014
	}

}


