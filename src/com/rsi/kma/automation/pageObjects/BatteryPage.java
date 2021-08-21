package com.rsi.kma.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;


public class BatteryPage {


	private static WebElement webElement = null;

	public static WebElement batteryStatus(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@battery-status,'batteryStatus')]/following-sibling::p","batteryStatus","BatteryPage");

		return webElement;      
	}
	
	public static WebElement chargingTime(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'level 1')]/preceding-sibling::span","chargingTime","BatteryPage");

		return webElement;      
	}
	

	public static WebElement batteryPluggedEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//img[contains(@src,'battery-plugged')]","batteryPluggedEV1","BatteryPage");

		return webElement;      
	}
	public static WebElement batteryPercentage(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'svgBattery')]//*[name()='svg']/*[name()='text']","batteryPercentage","BatteryPage");

		return webElement;      
	}

	public static WebElement pluggedInBox(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'panel-2')]//*[starts-with(@class,'top')]","pluggedInBox","BatteryPage");

		return webElement;      
	}

	public static WebElement startChargingButton(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'startBtn')]","startChargingButton","BatteryPage");

		return webElement;      
	}

	public static WebElement startChargingButtonEV1(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//*[contains(@ng-click,'startCharging')]","startChargingButtonEV1","BatteryPage");

		return webElement;      
	}


	public static WebElement stopChargingButtonEV1(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//*[contains(@ng-click,'stopCharging')]","stopChargingButtonEV1","BatteryPage");

		return webElement;      
	}



	public static WebElement batteryIsChargingTextEV1(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//img[contains(@src,'battery-charging')]","bateryIsChargingTextEV1","BatteryPage");

		return webElement;      
	}
	public static WebElement batteryChargingError(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//*[contains(text(),'try again')] | //div[contains(text(),'Your previous request did not complete')]","battery error","BatteryPage");

		return webElement;      
	}
	

	public static WebElement sendingChargeRequest(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//*[text()='Sending charge request. Please allow 2-3 minutes.']","sendingChargeRequest","BatteryPage");

		return webElement;      
	}
	
	public static WebElement vehicleChargeNotification(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//div[contains(@ng-click,'notificationsGo')]//div[contains(text(),'CHARGE WAS STARTED')]","vehicleChargeNotification","BatteryPage");

		return webElement;      
	}
	public static WebElement vehicleStopChargeNotification(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//div[contains(@ng-click,'notificationsGo')]//div[contains(text(),'CHARGE WAS STOPPED')]","vehicle stop ChargeNotification","BatteryPage");

		return webElement;      
	}
	
	
	
	public static WebElement stopChargingButton(WebDriver driver){

		webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'stopBtn')]","stopChargingButton","BatteryPage");

		return webElement;  
	}      

	public static WebElement startChargingButtonDisable(WebDriver driver) {

		webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'startBtn ng-binding disable')]","startChargingButtonDisable","BatteryPage");

		return webElement;      
	}

	public static WebElement stopChargingButtonDisable(WebDriver driver){

		webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'stopBtn ng-binding disable')]","stopChargingButtonDisable","BatteryPage");

		return webElement;  
	}      

	public static WebElement chargingStationBox(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'panel-2')]//*[@class='row']//*[starts-with(@class,'bottom')]","chargingStationBox","BatteryPage");

		return webElement;      
	}

	public static WebElement findChargingStationButton(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'panel-2')]//*[@class='row']//*[starts-with(@class,'bottom')]/a[contains(text(),'FIND CHARGING STATIONS')]","findChargingStationButton","BatteryPage");

		return webElement;      
	}

	public static WebElement level1(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'panel-2')]//*[@class='bottom']//*[@class='left']/span[text()='LEVEL 1 (120V)']","level1","BatteryPage");

		return webElement;      
	}

	public static WebElement level2(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'panel-2')]//*[@class='bottom']//*[@class='left']/span[text()='LEVEL 2 (240V)']","level2","BatteryPage");

		return webElement;      
	}

	public static WebElement level1OverviewPage(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@ui-sref='jf.battery']//div[@class='left']/span[text()='LEVEL 1 (120V)']","level1OverviewPage","BatteryPage");

		return webElement;      
	}

	public static WebElement level2OverviewPage(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@ui-sref='jf.battery']//div[@class='left']/span[text()='LEVEL 2 (240V)']","level2OverviewPage","BatteryPage");

		return webElement;      
	}

	public static WebElement OnOffToggle(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleOnOff')]","OnOffToggle","BatteryPage");

		return webElement;      
	}  

	public static WebElement setScheduleButton(WebDriver driver){

		webElement = FindWebElement.byXpath(driver,"//*[text()='SET SCHEDULE']","setScheduleButton","BatteryPage");

		return webElement;
	}

	public static WebElement cancelChangesButton(WebDriver driver){

		webElement = FindWebElement.byXpath(driver,"//*[text()='CANCEL']","cancelChangesButton","BatteryPage");

		return webElement;
	}

	public static WebElement refreshCompleteText(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Last updated as of')]","refreshCompleteText","BatteryPage");

		return webElement;
	}

	public static WebElement stopDisabled(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'stopBtn ng-binding disable')]","stopDisabled","BatteryPage");

		return webElement;
	}

	public static WebElement startDisabled(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'startBtn ng-binding disable')]","startDisabled","BatteryPage");

		return webElement;
	}

	public static WebElement batteryScheduleIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleSchedule') and not(contains(@ng-click,'scheduleII'))]","batteryScheduleIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement batteryScheduleIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleSchedule') and contains(@ng-click,'scheduleII')]","batteryScheduleIIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement scheduleItoggleEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleOnOffI()')]","scheduleItoggleEV1","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleIItoggleEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleOnOffII()')]","scheduleIItoggleEV1","BatteryPage");

		return webElement;
	}




	public static WebElement scheduleOff(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[@class='toggle-section']//div[starts-with(@class,'on offRed')]","scheduleOff","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleOn(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[@class='toggle-section']//div[@class='on']","scheduleOn","BatteryPage");

		return webElement;
	}

	public static WebElement StartSchedulehour(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//div[@class='hour']/div[starts-with(@class,'hour-wrap')]","StartSchedulehour","BatteryPage");

		return webElement;
	}

	public static WebElement StartScheduleNewhour(WebDriver driver,String hour) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newHourJF') and text()='"+hour+"']","StartScheduleNewhour","BatteryPage");

		return webElement;
	}

	public static WebElement minSchedule(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'minute') and contains(@ng-class,'displayMinute')]","Mins Schedule","BatteryPage");

		return webElement;
	}
	public static WebElement newMinSchedule(WebDriver driver,String min) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newMinute') and  text()='"+min+"']","new min schedule","BatteryPage");

		return webElement;
	}

	public static WebElement startAMPM(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Start Scheduled Charge')]/following-sibling::div[@class='row']//div[contains(@ng-click,'toggleShowSection')]","startAMPM","BatteryPage");

		return webElement;
	}
	public static WebElement startNewAMPM(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//ul[@class='am-pm-list am-pm-list1']/li[text()='AM']","startAMPM","BatteryPage");

		return webElement;
	}

	public static WebElement notSelectedDay(WebDriver driver, String day) {

		webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'calendar')]//div[@class='weekDays']//div[@class='date-box ng-binding ng-scope' and contains(text(),'" + day + "')]","notSelectedDay","BatteryPage");

		return webElement;
	} 

	public static WebElement selectedDay(WebDriver driver, String day) {

		webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'calendar')]//div[@class='weekDays']//div[contains (@class,'selected') and contains(text(),'" + day + "')]","selectedDay","BatteryPage");

		return webElement;
	} 

	public static WebElement scheduleButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'btnSchedule')]","scheduleButton","BatteryPage");

		return webElement;
	}

	public static WebElement selectedHour(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[@class='hour']/div[starts-with(@class,'hour-wrap') and contains(text(),'02')]","selectedHour","BatteryPage");

		return webElement;
	}

	public static WebElement sunday(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='SUN']","sunday ","BatteryPage");

		return webElement;
	}

	public static WebElement monday(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='MON']","monday ","BatteryPage");

		return webElement;
	}
	public static WebElement tuesday(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='TUE']","tuesday ","BatteryPage");

		return webElement;
	}

	public static WebElement wednesday(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='WED']","wednesday ","BatteryPage");

		return webElement;
	}
	public static WebElement thursday(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='THU']","thursday ","BatteryPage");

		return webElement;
	}
	public static WebElement friday(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='FRI']","friday ","BatteryPage");

		return webElement;
	}
	public static WebElement saturday(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='SAT']","saturday ","BatteryPage");

		return webElement;
	}


	public static WebElement setEndTimeHour(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleShowStopHour')]","setEndTimeHour ","BatteryPage");

		return webElement;
	}
	public static WebElement setNewEndTimeHour(WebDriver driver,String hour) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newStopHour') and text()='"+hour+"']","setNewEndTimeHour ","BatteryPage");

		return webElement;
	}


	public static WebElement setEndTimeMin(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleShowStopMinute')]","setEndTimeMin ","BatteryPage");

		return webElement;
	}
	public static WebElement setNewEndTimeMin(WebDriver driver,String min) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newStopMinute') and text()='"+min+"']","setNewEndTimeMin ","BatteryPage");

		return webElement;
	}


	//set schedule charge at 100% or at time:

	public static WebElement setTimeToggleON(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'row time-stop')]//div[@class='on']","setTimeToggleON ","BatteryPage");

		return webElement;
	}


	public static WebElement setTimeToggleOFF(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'row time-stop')]//div[@class='on off']","setTimeToggleOFF ","BatteryPage");

		return webElement;
	}



	public static WebElement stopScheduleToggleON(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'row charge-stop-option')]//li[@class='on']","stopScheduleToggleON ","BatteryPage");

		return webElement;
	}


	public static WebElement stopScheduleToggleOFF(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'row charge-stop-option')]//li[@class='on off']","stopScheduleToggleOFF ","BatteryPage");

		return webElement;
	}


	public static WebElement setStopChargeTimeHour(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleShowStopHour')]","setStopChargeTimeHour ","BatteryPage");

		return webElement;
	}

	public static WebElement setStopChargeTimeNewHour(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newStopHour') and text()='04']","setStopChargeTimeNewHour ","BatteryPage");

		return webElement;
	}

	public static WebElement setStopChargeTimeMin(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleShowStopMinute')]","setStopChargeTimeMin ","BatteryPage");

		return webElement;
	}

	public static WebElement setStopChargeTimeNewMin(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newStopMinute') and text()='20']","setStopChargeTimeNewMin ","BatteryPage");

		return webElement;
	}

	public static WebElement setStopChargeTimeAMPM(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Set End Time')]/following-sibling::div[@class='row time-stop']//div[contains(@ng-click,'toggleShowSection')]","setStopChargeTimeAMPM ","BatteryPage");

		return webElement;
	}
	public static WebElement setStopChargeTimeNewAMPM(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//ul[@class='am-pm-list am-pm-lists']/li[text()='PM']","setStopChargeTimeNewAMPM ","BatteryPage");

		return webElement;
	}
	//page objects for EV1

	public static WebElement scheduleIhourEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'toggleShowHourI()')]","scheduleIhourEV1 ","BatteryPage");

		return webElement;
	}
	public static WebElement scheduleIminEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'toggleShowMinuteI()')]","scheduleIminEV1 ","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleISetNewHourEV1(WebDriver driver,String hour) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newHourI(') and text()='"+hour+"'] ","scheduleISetNewHourEV1 ","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleISetNewMinEV1(WebDriver driver,String min) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newMinuteI(') and text()='"+min+"'] ","scheduleISetNewMinEV1 ","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleITime(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='SCHEDULE I']/following-sibling::div[@class='txt02 ng-binding']","scheduleITime ","BatteryPage");

		return webElement;
	}
	public static WebElement scheduleIAMPM(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleShowSectionI()')]","scheduleIAMPM ","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleINewAMPM(WebDriver driver,String AMPM) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newSecI(') and text()='"+AMPM+"']","scheduleINewAMPM ","BatteryPage");

		return webElement;
	}



	//second schedule EV1

	public static WebElement scheduleIITime(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='SCHEDULE II']/following-sibling::div[@class='txt02 ng-binding']","scheduleIITime ","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleIIhourEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'toggleShowHourII()')]","scheduleIIhourEV1 ","BatteryPage");

		return webElement;
	}
	public static WebElement scheduleIIminEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'toggleShowMinuteII()')]","scheduleIIminEV1 ","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleIISetNewHourEV1(WebDriver driver,String hour) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newHourII') and text()='"+hour+"'] ","scheduleIISetNewHourEV1 ","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleIISetNewMinEV1(WebDriver driver,String min) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newMinuteII(') and text()='"+min+"'] ","scheduleIISetNewMinEV1 ","BatteryPage");

		return webElement;
	}


	public static WebElement scheduleIIAMPM(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'toggleShowSectionII')]","scheduleIIAMPM ","BatteryPage");

		return webElement;
	}


	public static WebElement scheduleIINewAMPM(WebDriver driver,String AMPM) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'newSecII(') and text()='"+AMPM+"']","scheduleIINewAMPM ","BatteryPage");

		return webElement;
	}



	public static WebElement eightyPercentageChargeOn(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[@class='radioBtn_eighty selected']","eightyPercentageCharge on ","BatteryPage");

		return webElement;
	}


	public static WebElement hundredPercentageCharge(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'vm.percentChange(0,100)')]","hundredPercentageCharge ","BatteryPage");

		return webElement;
	}



	public static WebElement eightyPercentageChargeOFF(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[@class='radioBtn_eighty' and contains(@ng-click,'percentChange(0,80)')]","eightyPercentageCharge off ","BatteryPage");

		return webElement;
	}



	public static WebElement sunIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='SUN' and contains(@ng-click,'toggleDateSelectI(')]","sunIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement monIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='MON' and contains(@ng-click,'toggleDateSelectI(')]","monIEV1","BatteryPage");

		return webElement;
	}
	public static WebElement tuesIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='TUE' and contains(@ng-click,'toggleDateSelectI(')]","tuesIEV1","BatteryPage");

		return webElement;
	}
	public static WebElement wedIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='WED' and contains(@ng-click,'toggleDateSelectI(')]","wedIEV1","BatteryPage");

		return webElement;
	}
	public static WebElement thursIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='THU' and contains(@ng-click,'toggleDateSelectI(')]","thursIEV1","BatteryPage");

		return webElement;
	}
	public static WebElement friIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='FRI' and contains(@ng-click,'toggleDateSelectI(')]","friIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement satIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='SAT' and contains(@ng-click,'toggleDateSelectI(')]","satIEV1","BatteryPage");

		return webElement;
	}

	public static WebElement cancelScheduleIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'addScheI()')]/following-sibling::div[text()='CANCEL']","cancelScheduleIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement setScheduleIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'addScheI()') and text()='SET SCHEDULE']","setScheduleIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement errormsgSameDays(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-bind,'errorSchMsg') and contains(text(),'Please allow at least 20 minutes between')]","errormsgSameDays","BatteryPage");

		return webElement;
	}
	public static WebElement noDaysMessage(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-bind,'errorSchMsg')]","noDaysMessage","BatteryPage");

		return webElement;
	}





	//2nd schedule EV1
	public static WebElement sunIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='SUN' and contains(@ng-click,'toggleDateSelectII(')]","sunIIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement monIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='MON' and contains(@ng-click,'toggleDateSelectII(')]","monIIEV1","BatteryPage");

		return webElement;
	}
	public static WebElement tuesIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='TUE' and contains(@ng-click,'toggleDateSelectII(')]","tuesIIEV1","BatteryPage");

		return webElement;
	}
	public static WebElement wedIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='WED' and contains(@ng-click,'toggleDateSelectII(')]","wedIIEV1","BatteryPage");

		return webElement;
	}
	public static WebElement thursIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='THU' and contains(@ng-click,'toggleDateSelectII(')]","thursIIEV1","BatteryPage");

		return webElement;
	}
	public static WebElement friIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='FRI' and contains(@ng-click,'toggleDateSelectII(')]","friIIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement satIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='SAT' and contains(@ng-click,'toggleDateSelectII(')]","satIIEV1","BatteryPage");

		return webElement;
	}

	public static WebElement cancelScheduleIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'addScheII()')]/following-sibling::div[text()='CANCEL']","cancelScheduleIIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement setScheduleIIEV1(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'addScheII()') and text()='SET SCHEDULE']","setScheduleIIEV1","BatteryPage");

		return webElement;
	}


	public static WebElement hundredPercentageChargeII(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'vm.percentChange(1,100)')]","hundredPercentageChargeII ","BatteryPage");

		return webElement;
	}



	public static WebElement eightyPercentageChargeOFFII(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[@class='radioBtn_eighty' and contains(@ng-click,'percentChange(1,80)')]","eightyPercentageChargeOFFII off ","BatteryPage");

		return webElement;
	}


	//page objects for DE PHEV
	public static class DEPHEV {


		public static WebElement scheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'1. Start Driving')]","scheduleI","BatteryPage");

			return webElement;
		}

		public static WebElement scheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='2. Start Driving']","scheduleII","BatteryPage");

			return webElement;
		}
		
		public static WebElement ToggleDE(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'onOffDE()')]","ToggleDE","BatteryPage");

			return webElement;
		}
		
		public static WebElement ToggleDEScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='First Schedule']/following-sibling::div","ToggleDEScheduleI","BatteryPage");

			return webElement;
		}
		
		
		public static WebElement hourScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Departure Time']/following-sibling::div[contains(@ng-click,'depart-hour-one')]","hourScheduleI","BatteryPage");

			return webElement;
		}


		public static WebElement newHourScheduleI(WebDriver driver,String hour) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displayFirstDepartHourDE')]//li[text()='"+hour+"']","newHourScheduleI","BatteryPage");

			return webElement;
		}

		public static WebElement minScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Departure Time']/following-sibling::div[contains(@ng-click,'depart-minute-one')]","minScheduleI","BatteryPage");

			return webElement;
		}
		

		public static WebElement newMinScheduleI(WebDriver driver,String min) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displayFirstDepartMinuteDE')]//li[text()='"+min+"']","newMinScheduleI off ","BatteryPage");

			return webElement;
		}

		public static WebElement AMPMScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Departure Time']/following-sibling::div[contains(@ng-click,'depart-time-section-one')]","AMPMScheduleI","BatteryPage");

			return webElement;
		}

		
		public static WebElement newAMPMScheduleI(WebDriver driver,String AMPM) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displayFirstDepartTimeSectionDE')]//li[text()='"+AMPM+"']","newAMPMScheduleI","BatteryPage");

			return webElement;
		}
		
		public static WebElement sunScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='SUN' and contains(@ng-click,'first')]","sunScheduleI","BatteryPage");

			return webElement;
		}
		
		public static WebElement monScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='MON' and contains(@ng-click,'first')]","monScheduleI","BatteryPage");

			return webElement;
		}
		public static WebElement tuesScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='TUE' and contains(@ng-click,'first')]","tuesScheduleI","BatteryPage");

			return webElement;
		}
		
		public static WebElement wedScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='WED' and contains(@ng-click,'first')]","wedScheduleI","BatteryPage");

			return webElement;
		}
		
		public static WebElement thursScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='THU' and contains(@ng-click,'first')]","thursScheduleI","BatteryPage");

			return webElement;
		}
		
		public static WebElement friScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='FRI' and contains(@ng-click,'first')]","friScheduleI","BatteryPage");

			return webElement;
		}
		
		public static WebElement satScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='SAT' and contains(@ng-click,'first')]","satScheduleI","BatteryPage");

			return webElement;
		}
		public static WebElement cancelScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='CANCEL' and contains(@class,'btnCancel dtm')]","cancelScheduleI","BatteryPage");

			return webElement;
		}
		
		public static WebElement updateScheduleI(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='UPDATE SCHEDULE' and contains(@class,'btnSchedule dtm')]","updateScheduleI","BatteryPage");

			return webElement;
		}
		
		
		public static WebElement updatedScheduleMsg(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Updated schedule successfully!']","updatedScheduleMsg","BatteryPage");

			return webElement;
		}
		public static WebElement noDaysDEMsg(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Please select a time and at least one day.']","noDaysDEMsg","BatteryPage");

			return webElement;
		}
		
		
		
		
		//same date time for Schedule II
		
		
		
		public static WebElement ToggleDEScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Second Schedule']/following-sibling::div","ToggleDEScheduleII","BatteryPage");

			return webElement;
		}
		
		
		public static WebElement hourScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Departure Time']/following-sibling::div[contains(@ng-click,'depart-hour-two')]","hourScheduleII","BatteryPage");

			return webElement;
		}


		public static WebElement newHourScheduleII(WebDriver driver,String hour) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displaySecondDepartHourDE')]//li[text()='"+hour+"']","newHourScheduleII","BatteryPage");

			return webElement;
		}

		public static WebElement minScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Departure Time']/following-sibling::div[contains(@ng-click,'depart-minute-two')]","minScheduleII","BatteryPage");

			return webElement;
		}
		

		public static WebElement newMinScheduleII(WebDriver driver,String min) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displaySecondDepartMinuteDE')]//li[text()='"+min+"']","newMinScheduleII","BatteryPage");

			return webElement;
		}

		public static WebElement AMPMScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Departure Time']/following-sibling::div[contains(@ng-click,'depart-time-section-two')]","AMPMScheduleII","BatteryPage");

			return webElement;
		}

		
		public static WebElement newAMPMScheduleII(WebDriver driver,String AMPM) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displaySecondDepartTimeSectionDE')]//li[text()='"+AMPM+"']","newAMPMScheduleII","BatteryPage");

			return webElement;
		}
		
		public static WebElement sunScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='SUN' and contains(@ng-click,'second')]","sunScheduleII","BatteryPage");

			return webElement;
		}
		
		public static WebElement monScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='MON' and contains(@ng-click,'second')]","monScheduleII","BatteryPage");

			return webElement;
		}
		public static WebElement tuesScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='TUE' and contains(@ng-click,'second')]","tuesScheduleII","BatteryPage");

			return webElement;
		}
		
		public static WebElement wedScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='WED' and contains(@ng-click,'second')]","wedScheduleII","BatteryPage");

			return webElement;
		}
		
		public static WebElement thursScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='THU' and contains(@ng-click,'second')]","thursScheduleII","BatteryPage");

			return webElement;
		}
		
		public static WebElement friScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='FRI' and contains(@ng-click,'second')]","friScheduleII","BatteryPage");

			return webElement;
		}
		
		public static WebElement satScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='SAT' and contains(@ng-click,'second')]","satScheduleII","BatteryPage");

			return webElement;
		}
		public static WebElement cancelScheduleII(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='CANCEL' and contains(@class,'btnCancel dtm')]","sunScheduleI","BatteryPage");

			return webElement;
		}
		
		
		
		
		//time weekday
		
		public static WebElement startHourWeekDays(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Start Time']/following-sibling::div[contains(@ng-click,'wkday-start-hour')]","satScheduleII","BatteryPage");

			return webElement;
		}
		
		public static WebElement startNewHourWeekDays(WebDriver driver,String hour) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displayWeekdaysStartHourDE')]/li[text()='"+hour+"']","startNewHourWeekDays","BatteryPage");

			return webElement;
		}
		
		public static WebElement startMinWeekDays(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Start Time']/following-sibling::div[contains(@ng-click,'wkday-start-minute')]","startMinWeekDays","BatteryPage");

			return webElement;
		}
	
		
		public static WebElement startNewMinWeekDays(WebDriver driver,String min) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkday-start-minute') and text()='"+min+"']","startNewMinWeekDays","BatteryPage");

			return webElement;
		}
	
	
		public static WebElement startAMPMWeekday(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkday-start-time-section')]","startAMPMWeekday","BatteryPage");

			return webElement;
		}
		
		public static WebElement startNewAMPMWeekday(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkday-start-time-section') and text()='PM']","startNewAMPMWeekday","BatteryPage");

			return webElement;
		}
		
		
		
		public static WebElement endHourWeekDays(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='End Time']/following-sibling::div[contains(@ng-click,'wkday-end-hour')]","endHourWeekDays","BatteryPage");

			return webElement;
		}
		
		public static WebElement endNewHourWeekDays(WebDriver driver,String hour) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displayWeekdaysEndHourDE')]/li[text()='"+hour+"']","endNewHourWeekDays","BatteryPage");

			return webElement;
		}
		
		public static WebElement endMinWeekDays(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='End Time']/following-sibling::div[contains(@ng-click,'wkday-end-min')]","endMinWeekDays","BatteryPage");

			return webElement;
		}
	
		public static WebElement endNewMinWeekDays(WebDriver driver,String min) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displayWeekdaysEndMinuteDE')]//li[text()='"+min+"']","endNewMinWeekDays","BatteryPage");

			return webElement;
		}

		public static WebElement endAMPMWeekday(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkday-end-time-section')]","endAMPMWeekday","BatteryPage");

			return webElement;
		}
		
		public static WebElement endNewAMPMWeekday(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkday-end-time-section') and text()='PM']","endNewAMPMWeekday","BatteryPage");

			return webElement;
		}
		
		
		//time weekday
		
		
		public static WebElement startHourWeekend(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Start Time']/following-sibling::div[contains(@ng-click,'wkend-start-hour')]","startHourWeekend","BatteryPage");

			return webElement;
		}
		
		public static WebElement startNewHourWeekend(WebDriver driver,String hour) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displayWeekendStartHourDE')]/li[text()='"+hour+"']","startNewHourWeekend","BatteryPage");

			return webElement;
		}
		
		public static WebElement startMinWeekend(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='Start Time']/following-sibling::div[contains(@ng-click,'wkend-start-minute')]","startMinWeekend","BatteryPage");

			return webElement;
		}
	
		
		public static WebElement startNewMinWeekend(WebDriver driver,String min) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkend-start-minute') and text()='"+min+"']","startNewMinWeekend","BatteryPage");

			return webElement;
		}
		
		
		public static WebElement startAMPMWeekend(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkend-start-time-section')]","startAMPMWeekend","BatteryPage");

			return webElement;
		}
		
		public static WebElement startNewAMPMWeekend(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkend-start-time-section') and text()='PM']","startNewAMPMWeekend","BatteryPage");

			return webElement;
		}
		
		
	
		
		public static WebElement endHourWeekend(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='End Time']/following-sibling::div[contains(@ng-click,'wkend-end-hour')]","endHourWeekDays","BatteryPage");

			return webElement;
		}
		
		public static WebElement endNewHourWeekend(WebDriver driver,String hour) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displayWeekendEndHourDE')]/li[text()='"+hour+"']","endNewHourWeekend","BatteryPage");

			return webElement;
		}
		
		public static WebElement endMinWeekend(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[text()='End Time']/following-sibling::div[contains(@ng-click,'wkend-end-min')]","endMinWeekend","BatteryPage");

			return webElement;
		}
	
		
		public static WebElement endNewMinWeekend(WebDriver driver,String min) {

			webElement = FindWebElement.byXpath(driver,"//ul[contains(@ng-show,'displayWeekendEndMinuteDE')]//li[text()='"+min+"']","endNewMinWeekend","BatteryPage");

			return webElement;
		}
		
		
		public static WebElement endAMPMWeekend(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkend-end-time-section')]","endNewMinWeekend","BatteryPage");

			return webElement;
		}
		
		public static WebElement endNewAMPMWeekend(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'wkend-end-time-section') and text()='PM']","endNewAMPMWeekend","BatteryPage");

			return webElement;
		}
		public static WebElement peakOffSelected(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'offpeakOnly selected')]","peakOffMax","BatteryPage");

			return webElement;
		}
		
		public static WebElement peakOff(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'offpeakOnly')]","peakOffMax","BatteryPage");

			return webElement;
		}
		public static WebElement ignorePeakOFF(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'offpeakIgnore')]","ignorePeakOFF","BatteryPage");

			return webElement;
		}
		public static WebElement peakMax(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'offpeakMax')]","ignorePeakMax","BatteryPage");

			return webElement;
		}
		
	}
		
		
	//COMMON

	public static WebElement requestPending(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='Your request is pending...']","requestPending","BatteryPage");

		return webElement;
	}
	public static WebElement systemError(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'system error has occurred')]","scheduleRequestLoader ","BatteryPage");

		return webElement;
	}

	public static WebElement scheduleRequestLoader(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='Requesting charge schedule. Please allow 2-3 minutes.'] | //*[text()='Updating charge schedule. Please allow 2-3 minutes.']","scheduleRequestLoader ","BatteryPage");

		return webElement;
	}

	public static WebElement requestingVehicleStatus(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='Requesting vehicle status. Please allow 2-3 minutes.']","requestingVehicleStatus ","BatteryPage");

		return webElement;
	}


	public static WebElement daysError(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='show-schedule']/div[contains(@class,'txt-set')]/span","daysError ","BatteryPage");

		return webElement;
	}
	public static WebElement infoButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//img[@class='about_your_battery']","infoButton ","BatteryPage");

		return webElement;
	}
	public static WebElement level1Info(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//span[text()='Level 1']","level1Info ","BatteryPage");

		return webElement;
	}
	public static WebElement level2Info(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//span[text()='Level 2']","level2Info ","BatteryPage");

		return webElement;
	}
	public static WebElement dcfastInfo(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//span[text()='DC Fast Charge']","dcfastInfo ","BatteryPage");

		return webElement;
	}

	public static WebElement aboutYourBattery(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[text()='About Your Battery ']","aboutYourBattery ","BatteryPage");

		return webElement;
	}
	public static WebElement closeAboutBattery(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'close()')]"," close icon  ","BatteryPage");

		return webElement;
	}
	public static WebElement pointsInAboutbattery(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='content-care-tip']/ul/li"," pointsInAboutbattery   ","BatteryPage");

		return webElement;
	}

}





