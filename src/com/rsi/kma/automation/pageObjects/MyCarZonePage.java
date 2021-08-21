package com.rsi.kma.automation.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;



public class MyCarZonePage {

	
	private static WebElement webElement = null;

	
	public static WebElement manageButton(WebDriver driver) {

		webElement= FindWebElement.byId(driver,"manage_button","manageButtonAlerts","MyCarZonePage");        

		return webElement;
	}
	
	
	public static WebElement hideMap(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//*[text()='Hide Map']","manageButtonAlerts","MyCarZonePage");        

		return webElement;
	}
	
	public static WebElement requestIsInProgress(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//*[text()='Request in Progress']","manageButtonAlerts","MyCarZonePage");        

		return webElement;
	}
	
	public static WebElement noAlert(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//*[contains(text(),'You have no alerts at this time.')]","noAlert","MyCarZonePage");        

		return webElement;
	}

	public static WebElement loadMore(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'loadmore')]","loadMore","MyCarZonePage");

		return webElement;
	}
	public static WebElement errorWrongFormat(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'can only contain letters, numbers and cannot be blank')]","errorWrongFormat","MyCarZonePage");

		return webElement;
	}
	public static WebElement selectDaysError(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='Please select day(s).']","selectDaysError","MyCarZonePage");

		return webElement;
	}
	
	public static WebElement serviceError(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='500: The service is currently not available']","serviceError","MyCarZonePage");

		return webElement;
	}
	
	
	public static class SpeedAlerts {
		
		public static WebElement speedLink(WebDriver driver) {

			webElement = FindWebElement.byLinktext(driver,"SPEED","speedLink","MyCarZonePage");

			return webElement;
		}

		public static WebElement totalAlerts(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='carzone-alerts']/div[contains(text(),'Speed Limit')]","totalAlerts","MyCarZonePage");

			return webElement;
		}
		
		
	}
	
	
public static class ValetAlerts {
		
		public static WebElement valetLink(WebDriver driver) {

			webElement = FindWebElement.byLinktext(driver,"VALET","speedLink","MyCarZonePage");

			return webElement;
		}

		public static WebElement totalAlerts(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='carzone-alerts']//div[contains(text(),'Valet Alert')]","totalAlerts","MyCarZonePage");

			return webElement;
		}
		
	}

	public static class CurfewAlerts {

		public static WebElement curfewLink(WebDriver driver) {

			webElement = FindWebElement.byLinktext(driver,"CURFEW","curfewLink","MyCarZonePage");

			return webElement;
		}

		public static WebElement totalAlerts(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='carzone-alerts']/div[contains(text(),'Curfew Limit')]","totalAlerts","MyCarZonePage");

			return webElement;
		}

		
	}

	public static class GeoFenceAlerts {
		public static WebElement geofenceLink(WebDriver driver) {

			webElement = FindWebElement.byLinktext(driver,"GEO FENCE","geofenceLink","MyCarZonePage");

			return webElement;
		}

		public static WebElement totalAlerts(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='carzone-alerts']/div[contains(text(),'Geo Fence')]","totalAlerts","MyCarZonePage");

			return webElement;
		}

			
	}

	

	

	public static class alertsDropDown {
		public static WebElement daysDropDown(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'manage-buttons actions')]/span[starts-with(@class,'dropdown button')]","daysDropDown","MyCarZonePage");

			return webElement;
		}

		public static WebElement valueinDropDown30Days(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='dropdown-sort-menu']/li[text()='LAST 30 DAYS']","valueinDropDown30Days","MyCarZonePage");

			return webElement;
		}

		public static WebElement valueinDropDown7Days(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='dropdown-sort-menu']/li[text()='LAST 7 DAYS']","valueinDropDown7Days","MyCarZonePage");

			return webElement;
		}

		public static WebElement valueinDropDown5Days(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='dropdown-sort-menu']/li[text()='LAST 5 DAYS']","valueinDropDown5Days","MyCarZonePage");

			return webElement;
		}

		public static WebElement valueinDropDown3Days(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='dropdown-sort-menu']/li[text()='LAST 3 DAYS']","valueinDropDown3Days","MyCarZonePage");

			return webElement;
		}

		public static WebElement valueinDropDownToday(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='dropdown-sort-menu']/li[text()='TODAY']","valueinDropDownToday","MyCarZonePage");

			return webElement;
		}
	}

	

	
	public static WebElement delete(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//span[contains(@ng-click,'openConfirmDelete') and text()='DELETE']","delete","MyCarZonePage");

		return webElement;
	}


	public static WebElement deleteAll(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button delete-all')]","deleteAll","MyCarZonePage");            

		return webElement;
	}

	public static WebElement doneButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='button active']","doneButton","MyCarZonePage");

		return webElement;
	}

	public static WebElement confirmDelete(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='actions']//*[starts-with(@class,'highlighted')]","confirmDelete","MyCarZonePage");

		return webElement;
	}

	public static WebElement cancelDelete(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='actions']//*[@class='cancel']","cancelDelete","MyCarZonePage");          

		return webElement;
	}

	

	public static class SettingsAlerts {

		public static WebElement settingsLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"(//a[contains(text(),'SETTINGS')])[3]","settingsLink","MyCarZonePage");

			return webElement;
		}                

		public static WebElement curfewSettingsLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'mcz-navbar-settings-list')]//a[contains(@href,'settings/curfew')]","curfewSettingsLink","MyCarZonePage");

			return webElement;
		}

		public static WebElement speedSettingsLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'mcz-navbar-settings-list')]//a[contains(@href,'settings/speed')]","speedSettingsLink","MyCarZonePage");

			return webElement;
		}

		public static WebElement geofenceSettingsLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'mcz-navbar-settings-list')]//a[contains(@href,'settings/geofence')]","geofenceSettingsLink","MyCarZonePage");

			return webElement;
		}

		public static WebElement submitRequest(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//*[starts-with(@class, 'kh-button kh-button-submit')]","submitRequest","MyCarZonePage");

			return webElement;
		} 

		public static WebElement submitRequestGeoFence(WebDriver driver) {


			webElement= FindWebElement.byXpath(driver,"//button[starts-with(@class, 'submit-button')]","submitRequestGeoFence","MyCarZonePage");

			return webElement;
		} 

		public static WebElement mobileSubmitRequest(WebDriver driver) {


			webElement= FindWebElement.byXpath(driver,"//div[@class='button submit-button']","mobileSubmitRequest","MyCarZonePage");


			return webElement;
		}  
	}

	public static class CurfewSettings{
		public static WebElement curfewHeading(WebDriver driver) {


			webElement= FindWebElement.byXpath(driver,"//*[starts-with(@class, 'top-controls')]//*[@class='row on-off-row']/div[1]","curfewHeading","MyCarZonePage");

			return webElement;
		}

		public static WebElement curfewDelete(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//li[1]//*[contains(@ng-click,'openDeleteModal')]","curfewDelete","MyCarZonePage");

			return webElement;
		}

		public static WebElement buttonOffOn(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'top-controls')]//div[contains(@class,'switch-button')]/span","buttonOffOn","MyCarZonePage");

			return webElement;
		} 

		public static WebElement toggle(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'top-controls')]//div[contains(@class,'switch-button')]","buttonOff","MyCarZonePage");

			return webElement;
		}

		public static WebElement buttonOn(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//*[starts-with(@class, 'top-controls')]//*[@class='row on-off-row']//*[starts-with(@class, 'switch-button')]/span[text()='ON']","buttonOn","MyCarZonePage");

			return webElement;
		}  

		public static WebElement addNewCurfewOff(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[span[text()='Add New Curfew']]","addNewCurfewOff","MyCarZonePage");               

			return webElement;
		}  

		public static WebElement intervalDisabled(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'disableCustom')]//label[text()='ALERT INTERVAL']","intervalDisabled","MyCarZonePage");

			return webElement;
		}  

		public static WebElement intervalDropDown(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'row alert-interval-row visible')]//*[@class='uvo-dropdown']/div/span[contains(text(),'Mins')]","intervalDropDown","MyCarZonePage");

			return webElement;
		}  

		public static WebElement intervalDropDownValue(WebDriver driver, String value) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'row alert-interval-row visible')]//*[@class='uvo-dropdown']/ul//span[text()='" + value +"']","intervalDropDownValue","MyCarZonePage");

			return webElement;
		}

		public static WebElement addNewCurfewLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'addCurfew')]","addNewCurfewLink","MyCarZonePage");

			return webElement;
		} 

		/*First Delete Button*/
		public static WebElement deleteCurfew(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//li[1]//*[@class='head']//*[@class='delete']","deleteCurfew","MyCarZonePage");

			return webElement;
		}  

		public static WebElement deleteCurfewAll(WebDriver driver, int value) {


			webElement = FindWebElement.byXpath(driver,"//li[" + value + "]//*[@class='head']//*[@class='delete']","deleteCurfewAll","MyCarZonePage");

			return webElement;
		}  

		public static WebElement confirmCurfew(WebDriver driver) {

			webElement=FindWebElement.byXpath(driver,"//*[text()='CONFIRM']","confirmCurfew","MyCarZonePage");

			return webElement;
		}  

		public static WebElement cancelCurfew(WebDriver driver) {

			webElement=FindWebElement.byXpath(driver,"//*[text()='CANCEL']","cancelCurfew","MyCarZonePage");

			return webElement;
		}  

		public static WebElement viewPendingButton(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'row text-center')]//div[@class='button view-pending-button']/span","viewPendingButton","MyCarZonePage");

			return webElement;
		}

		public static WebElement changesPending(WebDriver driver, String alert){

			webElement= FindWebElement.byXpath(driver,"//*[starts-with(@class,'pending-list')]/h5","changesPending","MyCarZonePage");                   

			return webElement;
		}

		public static WebElement cancelChangesPending(WebDriver driver, String alert){

			if (alert == "speed" || alert == "curfew" ){
				webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'content pending-list')]//span[contains(text(),'CANCEL PENDING')]","cancelChangesPending","MyCarZonePage");
			} else if (alert == "geofence")
			{
				webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'mob-pending-list')]//span[contains(text(),'CANCEL PENDING')]","cancelChangesPending","MyCarZonePage");
			}                 

			return webElement;
		}

		public static WebElement closeChangesPending(WebDriver driver, String alert){

			if (alert == "speed" || alert == "curfew" ){
				webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'content pending-list')]//span[contains(text(),'CLOSE')]","closeChangesPending","MyCarZonePage");
			} else if (alert == "geofence")
			{
				webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'mob-pending-list')]//span[contains(text(),'CLOSE')]","closeChangesPending","MyCarZonePage");
			}
			return webElement;
		}

		/*First Curfew Title*/
		public static WebElement curfewBoxTitle(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//li[1]//*[@class='title-input']/input","curfewBoxTitle","MyCarZonePage");

			return webElement;
		}

		/*First Expand Collapse*/
		public static WebElement expandCollapseArrow(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//li[1]//*[@class='edit']","expandCollapseArrow","MyCarZonePage");

			return webElement;
		}

		/*From Hours for First Curfew*/
		public static WebElement fromHours(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//li[1]//*[@class='time-selector-wrapper']//*[@time-value='curfew.header.startHour']//*[starts-with(@class,'time-selector-display')]","fromHours","MyCarZonePage");

			return webElement;
		}

		/*From Minutes for First Curfew*/
		public static WebElement fromMinutes(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//li[1]//*[@time-value='curfew.header.startMinute']//*[starts-with(@class,'time-selector-display')]","fromMinutes","MyCarZonePage");

			return webElement;
		}

		public static WebElement fromAmPm(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//li[1]//*[starts-with(@class,'ampm-selector')][Position()=1]","fromAmPm","MyCarZonePage");

			return webElement;
		}      

		public static WebElement timePMFrom(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//li[1]//*[starts-with(@class,'ampm-selector')][position()=1]/div[1]","timePMFrom","MyCarZonePage");

			return webElement;
		}        

		public static WebElement timeAMFrom(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//li[1]//*[starts-with(@class,'ampm-selector')][position()=1]/div[2]","timeAMFrom","MyCarZonePage");

			return webElement;
		}     

		public static WebElement fromHourPick(WebDriver driver,int i){

			webElement= FindWebElement.byXpath(driver,"//li[1]//*[@class='time-selector-wrapper']//*[@time-value='curfew.header.startHour']//*[@class='time-selector-options time-selector-hour-options']//li["+i+"]","fromHourPick","MyCarZonePage");

			return webElement;
		}   

		public static WebElement fromMinutePick(WebDriver driver,int i){

			webElement= FindWebElement.byXpath(driver,"//li[contains(@class,'selected')]//*[@time-value='curfew.header.startMinute']//div[contains(@class,'time-selector-minute-options')]//li["+i+"]","fromMinutePickSame","MyCarZonePage");

			return webElement;
		} 
		/*First To Hours*/
		public static WebElement toHours(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//li[1]//*[@class='time-selector-wrapper']//*[starts-with(@class,'time-selector-hour-end')]//*[starts-with(@class,'time-selector-display')]","toHours","MyCarZonePage");

			return webElement;
		}
		 

		/*First To Minutes*/
		public static WebElement toMinutes(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//li[1]//*[@time-value='curfew.header.endMinute']//*[starts-with(@class,'time-selector-display')]","toMinutes","MyCarZonePage");

			return webElement;
		}
		

		public static WebElement toHourPick(WebDriver driver,int i){

			
			webElement=FindWebElement.byXpath(driver,"//li[1]//*[@class='time-selector-wrapper']//*[@time-value='curfew.header.endHour']//*[@class='time-selector-options time-selector-hour-options']//li["+i+"]","toHourPick","MyCarZonePage");

			return webElement;
		}   
		public static WebElement toMinutePick(WebDriver driver,int i){

			webElement= FindWebElement.byXpath(driver,"//li[1]//*[@time-value='curfew.header.endMinute']//*[@class='time-selector-options time-selector-minute-options']//li["+i+"]","toMinutePick","MyCarZonePage");                                

			return webElement;
		}       


		
		public static WebElement toAmPm(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//li[1]//*[starts-with(@class,'ampm-selector')][Position()=2]","toAmPm","MyCarZonePage");

			return webElement;
		}       

		public static WebElement timePMTo(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//li[1]//*[starts-with(@class,'ampm-selector')][position()=2]//*[starts-with(@class,'pm')]","timePMTo","MyCarZonePage");

			return webElement;
		}  

		public static WebElement timeAMTo(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//li[1]//*[starts-with(@class,'ampm-selector')][position()=2]//*[starts-with(@class,'am')]","timeAMTo","MyCarZonePage");

			return webElement;
		}  
		
		

		
		public static WebElement toHourPickSame(WebDriver driver,int i){

			webElement=FindWebElement.byXpath(driver,"//li[1]//*[@class='time-selector-wrapper']//*[@time-value='curfew.header.endHour']//*[@class='time-selector-options time-selector-hour-options']//li["+i+"]","toHourPickSame","MyCarZonePage");

			return webElement;
		}   

		public static WebElement toMinutePickSame(WebDriver driver,int i){

			webElement= FindWebElement.byXpath(driver,"//li[1]//*[@time-value='curfew.header.endMinute']//*[@class='time-selector-options time-selector-minute-options']//li["+i+"]","toMinutePickSame","MyCarZonePage");

			return webElement;
		}       

	
		public static WebElement weekDayThursday(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//*[@id='kh-curfew-settings']/..//*[@class='active open']//*[@class='head']//*[@class='days']/span[4]","weekDayThursday","MyCarZonePage");

			return webElement;
		}

		public static WebElement curfewTextBox(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//div[@class='title-input']","curfewTextBox","MyCarZonePage");

			return webElement;
		}

		public static WebElement onButtonCurfewListFirst(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,".//*[@class='alert-list']/li[1]//*[@class='alert-switch on']","onButtonCurfewListFirst","MyCarZonePage");

			return webElement;
		}

		public static WebElement onButtonCurfewListSecond(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//li[2]//*[starts-with(@class, 'config-list')]//*[starts-with(@class,'switch-button on')]/span","onButtonCurfewListSecond","MyCarZonePage");

			return webElement;         
		}

		public static WebElement onButtonCurfewList(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,".//*[@class='alert-list']/li[1]//*[@class='alert-switch on']","onButtonCurfewList","MyCarZonePage");

			return webElement;
		}

		public static WebElement curfewBody(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'main-content-area')]","curfewBody","MyCarZonePage");

			return webElement;         
		}

		public static WebElement curfewBodyErrorAlert(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//*[starts-with(@class,'container')]","curfewBodyErrorAlert","MyCarZonePage");

			return webElement;         
		}  

		public static WebElement disableCurfewOpen(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//li[1]//*[starts-with(@class,'config-list')]//*[@class='switch-button on']/span","disableCurfewOpen","MyCarZonePage");

			return webElement;
		}

		public static WebElement deselect_Day (WebDriver driver, String day) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='weekDays']/div[contains(@class,'selected') and text()='"
					+ day.toUpperCase() + "']","deselect_Day","MyCarZonePage");                                                                                        

			return webElement;
		}


		public static WebElement selectDay (WebDriver driver, String day) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='config-list-item ng-scope selected']//*[@class='body']//*[@class='day-picker-list']//*[@class='noselect ng-scope']/span[contains(text(),'" + day + "')]","selectDay","MyCarZonePage");

			return webElement;
		}



		public static WebElement selectDayCurfew (WebDriver driver, int num) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='active open']//*[@class='days']/span[" + num + "]","selectDayCurfew","MyCarZonePage");                                        

			return webElement;
		}
	}

	public static class SpeedSettings{

		public static WebElement buttonONOFF(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//*[starts-with(@class,'switch')]","buttonONOFF","MyCarZonePage");

			return webElement;
		}

		public static WebElement buttonOffText(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//*[starts-with(@class,'switch')]/span","buttonOff","MyCarZonePage");

			return webElement;
		}


		public static WebElement speedHeading(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class, 'speed-heading')]","speedHeading","MyCarZonePage");              

			return webElement;
		}
		public static WebElement speedSlider(WebDriver driver) {

			webElement = FindWebElement.byClassName(driver,"speed-slider","speedSlider","MyCarZonePage");

			return webElement;
		}

		public static WebElement speedPlus(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//*[@class='button plus']","speedPlus","MyCarZonePage");

			return webElement;         
		}

		public static WebElement speedMinus(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//*[@class='button minus']","speedMinus","MyCarZonePage");


			return webElement;         
		}

		public static WebElement alertSpeedDropDown(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'alert-info-wrap')]//div[@id='freq-drop' and @ng-show='isOn']//div[@class='uvo-dropdown']/div/span[contains(text(),'Minutes')]","alertSpeedDropDown","MyCarZonePage");                

			return webElement;         
		}

		public static WebElement alertSpeedDropDownValue(WebDriver driver,int i){            

			webElement= FindWebElement.byXpath(driver,"//*[starts-with(@class,'alert-info-wrap')]//*[@class='repeat actions col-sm-6 reg_view']//*[@class='uvo-dropdown']//li["+i+"]/span[1]","alertSpeedDropDown10","MyCarZonePage");

			return webElement;
		} 

		public static WebElement speedValue(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//*[@id='speed-slider']//a//div//span","speedValue","MyCarZonePage");

			return webElement;
		}        
	}

	public static class GeoFenceSettings{

		public static WebElement geoButtonOnOFF(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[@class='row on-off-row']//div[starts-with(@class,'switch-button')]","geoButtonOnOFF","MyCarZonePage");

			return webElement;
		}

		public static WebElement geoButtonOnOFFText(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[@class='row on-off-row']//div[starts-with(@class,'switch-button')]/span","geoButtonOnOFFText","MyCarZonePage");

			return webElement;
		}
		
		public static WebElement onEntryText(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='ON ENTRY FENCES']| //*[text()='ON EXIT FENCES'] ","onEntryText","MyCarZonePage");

			return webElement;
		}
		
		public static WebElement onExitText(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='ON EXIT FENCES']","onExitText","MyCarZonePage");

			return webElement;
		}
		
		public static WebElement expandCollapseArrow(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//li[1]//*[@class='edit']","expandCollapseArrow","MyCarZonePage");

			return webElement;
		}
		public static WebElement geoFenceBoxTitle(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//li[1]//*[@class='title-input']/input","geoFenceBoxTitle","MyCarZonePage");

			return webElement;
		}
		
		
		public static WebElement locationOption(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//*[@class='pac-container pac-logo']/div[1]","locationOption","MyCarZonePage");

			return webElement;
		}
		
		
		
		public static WebElement distance(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//li[1]//*[starts-with(@class,'distance')]","geoFenceBoxTitle","MyCarZonePage");

			return webElement;
		}
		
		public static WebElement rectangle(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//div[starts-with(@class,'hidden')]//div[starts-with(@class,'shape-toggle')]/div[starts-with(@class,'rectangle')]","rectangle","MyCarZonePage");

			return webElement;
		}
		
		public static WebElement circle(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//div[starts-with(@class,'hidden')]//div[starts-with(@class,'shape-toggle')]/div[starts-with(@class,'circle')]","circle","MyCarZonePage");

			return webElement;
		}
		
		
		public static WebElement geoHeading(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='row on-off-row']/div[1]/label","geoHeading","MyCarZonePage");

			return webElement;
		}

		public static WebElement onEntry(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//*[@id='fence-toggle']/span[contains(text(),'ON-ENTRY')]","onEntry","MyCarZonePage");

			return webElement;
		}

		public static WebElement onExit(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//*[@id='fence-toggle']/span[contains(text(),'ON-EXIT')]","onExit","MyCarZonePage");

			return webElement;
		}
		
		
		public static WebElement alertDropDown(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//*[@class='row alert-interval-row']//*[@class='uvo-dropdown']/div","alertDropDown","MyCarZonePage");

			return webElement;
		}
		
		public static WebElement alertDropDownValue(WebDriver driver,int i){

			webElement= FindWebElement.byXpath(driver,"//*[@class='row alert-interval-row']//*[@class='uvo-dropdown']//li["+i+"]/span[1]","alertDropDown","MyCarZonePage");

			return webElement;
		}

		public static WebElement addNewGeoFence(WebDriver driver){

			webElement=FindWebElement.byXpath(driver,"//*[starts-with(@class,'add-new noselect')]/span","addNewGeoFence","MyCarZonePage");

			return webElement;
		}

		public static WebElement addNewGeoFenceOnExit(WebDriver driver){

			webElement= FindWebElement.byCssSelector(driver,"div.add-new.on-entry > span","addNewGeoFenceOnExit","MyCarZonePage");

			return webElement;
		}

		public static WebElement locationTextBox(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//*[@events='map.events']//*[@class='geofence-search-input']","locationTextBox","MyCarZonePage");

			return webElement;
		}

		public static WebElement deleteGeoFence(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//*[@class='delete']","deleteGeoFence","MyCarZonePage");

			return webElement;
		}

		public static WebElement deleteFirst(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//li[1]//*[contains(@ng-click,'openDeleteModal')]","deleteX","MyCarZonePage");

			return webElement;
		}

		public static WebElement disableGeoFenceOpen(WebDriver driver){

			webElement= FindWebElement.byXpath(driver,"//li[1]//div[starts-with(@class,'config-list-container')]//div[starts-with(@class,'switch-button')]/span[contains(text(),'ON')]","disableGeoFenceOpen","MyCarZonePage");

			return webElement;
		}

		/*Cancel and Confirm buttons, same as Curfew*/
		public static WebElement cancelDelete(WebDriver driver){

		webElement = FindWebElement.byXpath(driver,"//*[@class='actions']//*[@class='cancel']| //*[contains(@ng-click,'cancel')]","cancelDelete","MyCarZonePage");

			return webElement;
		}

		public static WebElement confirmDelete(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//*[@class='actions']//*[starts-with(@class,'highlighted')] | //*[contains(@ng-click,'confirm')] | //*[starts-with(text(),'CONFIRM')]","confirmDelete","MyCarZonePage");

			return webElement;
		}   

		public static WebElement reqiredAlertMessage(WebDriver driver){

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'pending-msg require-one')]","reqiredAlertMessage","MyCarZonePage");

			return webElement;
		}  


		public static WebElement containerGeoFence(WebDriver driver)
		{

			webElement= FindWebElement.byXpath(driver,"//*[@id='kh-geofence-settings']/..//*[@class='wrap']","containerGeoFence","MyCarZonePage");               

			return webElement;
		}
	}

	public static WebElement viewMapGeneric(WebDriver driver)
	{

		webElement=FindWebElement.byXpath(driver,"//*[starts-with(@class,'item ')][position()=1]//*[starts-with(@class,'option map')]/span","viewMapGeneric","MyCarZonePage");

		return webElement;
	}

	public static WebElement viewMapAll(WebDriver driver)
	{

		webElement=FindWebElement.byXpath(driver,"//div[starts-with(@class,'option map')]","viewMapAll","MyCarZonePage");

		return webElement;
	}

	public static WebElement loadMore5(WebDriver driver)
	{

		webElement=FindWebElement.byXpath(driver,"//div[starts-with(@class,'option map')]","loadMore5","MyCarZonePage");

		return webElement;
	}

	public static WebElement loadMore10(WebDriver driver)
	{

		webElement=FindWebElement.byXpath(driver,"//div[starts-with(@class,'option map')]","loadMore10","MyCarZonePage");

		return webElement;
	}

	public static WebElement alertContainer(WebDriver driver)
	{

		webElement=FindWebElement.byXpath(driver,"//*[starts-with(@class,'container')]//*[starts-with(@class,'alerts')]","alertContainer","MyCarZonePage");

		return webElement;
	}

	public static WebElement dateCurfewSpeed(WebDriver driver)
	{

		webElement=FindWebElement.byXpath(driver,"//*[@class='row info']","dateCurfewSpeed","MyCarZonePage");

		return webElement;
	}

	public static WebElement dateGeoFence(WebDriver driver)
	{

		webElement=FindWebElement.byXpath(driver,"//*[@class='row link']","dateGeoFence","MyCarZonePage");

		return webElement;
	}

	public static WebElement alertMessage(WebDriver driver)
	{

		webElement=FindWebElement.byXpath(driver,"//*[@class='alert-msj']","alertMessage","MyCarZonePage");

		return webElement;  
	}

	public static WebElement requestPending (WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'request is in progress. Please allow 2-3 minutes.')]","requestPending","MyCarZonePage");

		return webElement;        
	}


	
	

}



