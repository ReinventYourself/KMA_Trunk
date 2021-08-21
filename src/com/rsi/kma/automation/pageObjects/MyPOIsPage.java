package com.rsi.kma.automation.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Log;

public class MyPOIsPage {


	private static WebElement webElement = null;    



	public static WebElement addPOI(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']","addPOI","MyPOIsPage");

		return webElement;
	}
	
	public static WebElement manage(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='button manage-button']","manage","MyPOIsPage");

		return webElement;
	}

	public static WebElement getPOIList(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='poi-row ng-scope']//*[@class='poi-name ng-binding']","getPOIList","MyPOIsPage");

		return webElement;
	}
	
	public static WebElement waitForChanges(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='Please wait. Changes are being sent to the vehicle.']","waitForChanges","MyPOIsPage");

		return webElement;
	}
	


	public static WebElement poiListCityName(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//p[@class='ng-binding'][position()=2]","poiListCityName","MyPOIsPage");

		return webElement;
	}

	public static WebElement POIListBox(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[@class='poi-container actions']","POIListBox","MyPOIsPage");

		return webElement;
	}

	public static WebElement googleMap(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//img[@src='https://maps.gstatic.com/mapfiles/api-3/images/google4.png']","googleMap","MyPOIsPage");

		return webElement;
	}

	public static WebElement totalPOIsValue(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,".//*[@class='alert-msj']/strong","totalPOIsValue","MyPOIsPage");

		return webElement;
	}

	public static WebElement myPOIOnlySupports25POIs(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='My POI only supports 25 POIs.']","myPOIOnlySupports25POIs","MyPOIsPage");

		return webElement;
	}

	public static WebElement myPOIOnlySupports25POIsOKButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='button button-center']","myPOIOnlySupports25POIsOKButton","MyPOIsPage");

		return webElement;
	}

	public static WebElement manageButton(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[@class='button manage-button']","manageButton","MyPOIsPage");

		return webElement;
	}

	public static WebElement newestButton(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'dropdown button') and contains(text(),'NEWEST')]","newestButton","MyPOIsPage");

		return webElement;
	}

	public static WebElement hideButton(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button nav-hide')]//span[contains(text(),'HIDE')]","hideButton","MyPOIsPage");

		return webElement;
	}

	public static WebElement showButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button nav-hide')]//span[contains(text(),'SHOW')]","showButton","MyPOIsPage");

		return webElement;
	}

	public static WebElement selectPoi(WebDriver driver, String poiName) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='poi-list']//div[text()='" + poiName
				+ "']","selectPoi","MyPOIsPage");

		return webElement;
	}

	public static WebElement PoiName(WebDriver driver, String poiName) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'poi-more-info')]//*[starts-with(@class,'poi-name') and contains(text(),'" + poiName + "')]","PoiName","MyPOIsPage");

		return webElement;
	}

	public static WebElement trashcanIcon(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@alt='Delete POI']","trashcanIcon","MyPOIsPage");

		return webElement;
	}

	public static WebElement magnifyingGlass(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@title='View POI on map']","magnifyingGlass","MyPOIsPage");

		return webElement;
	}

	public static WebElement editButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@alt='Edit POI' and@title='Edit POI']","editButton","MyPOIsPage");

		return webElement;
	}

	public static WebElement editNotesField(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'poi-description text-area')]","editNotesField","MyPOIsPage");

		return webElement;
	}

	public static WebElement poiDetail(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'poi-more-info')]","poiDetail","MyPOIsPage");

		return webElement;
	}

	public static WebElement trashcanIconConfirmButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button')]/span[contains(text(),'CONFIRM')]","trashcanIconConfirmButton","MyPOIsPage");

		return webElement;
	}

	public static WebElement trashcanIconCancelButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button')]//*[contains(text(),'CANCEL')]","trashcanIconCancelButton","MyPOIsPage");

		return webElement;
	}

	public static WebElement resend_Error_Message(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='kh-button kh-button-error' and text()='Resend']","resend_Error_Message","MyPOIsPage");

		return webElement;
	}

	public static class Manage {
		public static WebElement deleteSelectedButton(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".button.delete-selected","deleteSelectedButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement confirmButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'CONFIRM')]","confirmButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement cancelButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='button cancel']/span","cancelButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement deletAllButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//span[contains(@class,'button delete-all')]","deletAllButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement deletAllConfirmButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'CONFIRM')]","deletAllConfirmButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement deletAllCancelButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='button cancel']/span","deletAllCancelButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement doneButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='button active']","doneButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement radioButton(WebDriver driver, String poiName) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='poi-list']//div[text()='"
					+ poiName + "']/../div/label","radioButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement findRadioButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='poi-list']//div/label[@class='poi-selected-label active']","findRadioButton","MyPOIsPage");

			return webElement;
		}
	}

	public static class Newest {

		public static WebElement newestLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'manage-buttons actions')]//*[@class='dropdown-sort-menu']/li[text()='NEWEST']","newestLink","MyPOIsPage");

			return webElement;
		}

		public static WebElement oldestLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='manage-buttons actions']//*[contains(text(),'OLDEST')]","image","MyPOIsPage");

			return webElement;
		}

		public static WebElement cityLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='manage-buttons actions']//*[contains(text(),'CITY')]","oldestLink","MyPOIsPage");

			return webElement;
		}

		public static WebElement stateLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='manage-buttons actions']//*[contains(text(),'STATE')]","stateLink","MyPOIsPage");

			return webElement;
		}

		public static WebElement nameOfLocationLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='manage-buttons actions']//*[contains(text(),'NAME OF LOCATION')]","nameOfLocationLink","MyPOIsPage");

			return webElement;
		}
	}

	public static class AddPOIs {

		public static WebElement searchTextField(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'mypoi-search text-box')]","searchTextField","MyPOIsPage");

			return webElement;
		}

		public static WebElement search(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='control-wrapper']//*[contains(@ng-click,'searchPoi')]","search","MyPOIsPage");

			return webElement;
		}

		public static WebElement POIs_Close_Button(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='close']","POIs_Close_Button","MyPOIsPage");

			return webElement;
		}

		public static WebElement addButton(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[@class='button add dark']","addButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement nameTextField(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".text-input.poi-name","nameTextField","MyPOIsPage");

			return webElement;
		}

		public static WebElement addressValue(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".poi-dialog>p","addressValue","MyPOIsPage");

			return webElement;
		}

		public static WebElement phoneNumberField(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'text-input text-box-shadow phone')]","phoneNumberField","MyPOIsPage");

			return webElement;
		}

		public static WebElement notesField(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//textarea[starts-with(@class,'poi-description text-area')]","notesField","MyPOIsPage");

			return webElement;
		}

		public static WebElement done(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='actions dialog-control']/span[text()='DONE']","done","MyPOIsPage");

			return webElement;
		}

		public static WebElement cancel(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='cancel button']","cancel","MyPOIsPage");

			return webElement;
		}

		public static WebElement invalidPhoneNumber(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='validation']","invalidPhoneNumber","MyPOIsPage");

			return webElement;
		}

		public static WebElement radioButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'poi-selected-label')]","radioButton","MyPOIsPage");

			return webElement;
		}

		public static WebElement poiGoogleImage(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//img[@src='https://maps.gstatic.com/mapfiles/api-3/images/google4.png']","poiGoogleImage","MyPOIsPage");

			return webElement;
		}
	}
	
	public static class EditPOI
	{
		
		public static WebElement editButton(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'poi-more-info')][1]//img[@title='Edit POI']","poiGoogleImage","MyPOIsPage");

			return webElement;
		}
		
		public static WebElement poiName(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'poi-more-info')][1]/p[1]","poiName","MyPOIsPage");

			return webElement;
		}
		
		
		public static WebElement stateName(WebDriver driver,int i) {
			Log.info("which element :" +i);

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'poi-more-info')]["+i+"]/p[3]","poiName","MyPOIsPage");

			return webElement;
		}
		
		
		
		public static WebElement phoneNo(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'poi-more-info')][1]/p[4]","phoneNo","MyPOIsPage");

			return webElement;
		}
		
		public static WebElement notes(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'poi-more-info')][1]/p[5]","notes","MyPOIsPage");

			return webElement;
		}
		
		public static WebElement editPoiName(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'poi-dialog')]/input[@name='name']","editPoiName","MyPOIsPage");

			return webElement;
		}
		
		public static WebElement editPhone(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'poi-dialog')]/input[@name='phone']","editPhone","MyPOIsPage");

			return webElement;
		}
		public static WebElement editNotes(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'poi-dialog')]/textarea","editNotes","MyPOIsPage");

			return webElement;
		}
		public static WebElement done(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'savePoi')]","done","MyPOIsPage");

			return webElement;
		}
		
		public static WebElement closeEditPOi(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,"//.poi-modal-content >header>a","done","MyPOIsPage");

			return webElement;
		}
		
		
		
		
		
		
		
	}
}

