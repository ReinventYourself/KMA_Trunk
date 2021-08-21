package com.rsi.kma.automation.pageObjects.Common;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;




public class OverviewPage {


	private static WebElement webElement = null;    

	
	public static WebElement close(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'close()')] | //*[contains(text(),'Congrats on your new Vehicle!')]/img |//*[@class='actions']//*[starts-with(@class,'highlighted')] | //*[contains(@ng-click,'confirm')] | //*[starts-with(text(),'CONFIRM')] | //*[contains(@class,'modal simplify-enroll') and not(contains(@class,'hide'))]//p[@class='title']/img","close","OverviewPage");

		return webElement;
	}
	
	
	public static class VehicleSelector {

		public static WebElement image(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".nav-vehicle-selector>img","image","OverviewPage");

			return webElement;
		}

		public static WebElement nicknameOfVehicle(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'nav-vehicle-selector')]//*[starts-with(@class,'title Switchwrap')]","nicknameOfVehicle","OverviewPage");

			return webElement;
		}

		public static WebElement vehicleDropdown(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".nav-vehicle-selector>.arrow","vehicleDropdown","OverviewPage");

			return webElement;
		}

		public static WebElement vehicleRadioButton(WebDriver driver,
				String nickname) {


			webElement = FindWebElement.byXpath(driver,"//*[@id='vehicle-switcher']//li//*[starts-with(@class,'title')][text()='"
					+ nickname
					+ "']/../preceding-sibling::div[@class='marker']/div","vehicleRadioButton","OverviewPage");

			return webElement;
		}

		public static WebElement viewAllVehicles(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//span[text()='VIEW ALL VEHICLES']","viewAllVehicles","OverviewPage");

			return webElement;
		}
		
		public static WebElement loader(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='loader-custom ng-scope']","loader","OverviewPage");

			return webElement;
		}
		
		public static WebElement updatedTimestamp(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Last updated')]","updatedTimestamp","OverviewPage");

			return webElement;
		}
		
		
		
	}

	public static class DrivingActivity {

		public static WebElement drivingActivityLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='title']/a[contains(text(),'DRIVING ACTIVITY')]","drivingActivityLink","OverviewPage");

			return webElement;
		}

		public static WebElement mileage(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@id='currMileage'] | //*[@class='mileage']/span ","mileage","OverviewPage");

			return webElement;
		}

		public static WebElement drivingScore(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-bind,'efficientScore')] | //*[@class='safety-score']//*[@class='chart1']/span[@class='good good1 ng-binding']","drivingScore","OverviewPage");

			return webElement;
		}

		public static WebElement carImage(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".user-car>img","carImage","OverviewPage");

			return webElement;
		}
	}

	public static class Diagnostic {

		public static WebElement diagnosticLink(WebDriver driver) {

			webElement = FindWebElement.byLinktext(driver,"DIAGNOSTIC","diagnosticLink","OverviewPage");

			return webElement;
		}

		public static WebElement message(WebDriver driver, String message) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'diagnostic center')]//*[contains(text(),'"
					+ message + "')]","message","OverviewPage");

			return webElement;
		}
		
		public static WebElement diagnosticIssueText(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//label[contains(text(),'issue')]","issues","OverviewPage");

			return webElement;
		}
		
	}

	public static class Maintenance {

		public static WebElement maintenanceLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'title')]/a[text()='MAINTENANCE']","maintenanceLink","OverviewPage");

			return webElement;
		}

		
		public static WebElement milesNextService(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='next-service ng-scope']//span[@class='amount ng-binding ng-scope']","miles untill next service","OverviewPage");

			return webElement;
		}
		
	}

	public static class MyPOIs {

		public static WebElement myPoiLink(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,"#overview-v3 > div > div:nth-child(2) > div:nth-child(3) >a ","myPoiLink","OverviewPage");

			return webElement;
		}
		
		public static WebElement myPoiLinkDE(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='title-arrow' and text()='MY POIs']","myPoiLink","OverviewPage");

			return webElement;
		}
		
		
		public static WebElement myPoiLinkConnected(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[@class='title']//a[text()='MY POIs']","myPoiLink","OverviewPage");

			return webElement;
		}

		public static WebElement myPoiImage(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".widget-box.my-POIs.border.center.hover-on .POI-icon.w-img>img","myPoiImage","OverviewPage");

			return webElement;
		}
	}

	public static class Awards {

		public static WebElement awardsLink(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,"a[href='/ccw/awards'] > div > div:nth-child(1)","awardsLink","OverviewPage");

			return webElement;
		}
		public static WebElement awardsLinkConnected(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[@class='title']/a[text()='AWARDS']","awardsLink","OverviewPage");

			return webElement;
		}
		public static WebElement lastAwardWon(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'awards')]//*[contains(@class,'lastAwardReceived')]","lastAwardWon","OverviewPage");

			return webElement;
		}

		public static WebElement totalAwardsEarned(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'awards')]//*[contains(@class,'awards-earned')]/strong[position()=1]","totalAwardsEarned","OverviewPage");

			return webElement;
		}
	}

	public static class sessionTimeOut {

		public static WebElement sessionTimeOutMessage(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'sessionTimerWrap')]/div[@id='errorMessage']","sessionTimeOutMessage","OverviewPage");

			return webElement;
		}

		public static WebElement keepMeSignedIn_button(WebDriver driver) {

			webElement = FindWebElement.byId(driver,"keepAlive","keepMeSignedIn_button","OverviewPage");

			return webElement;
		}

		public static WebElement logout_button(WebDriver driver) {

			webElement = FindWebElement.byId(driver,"logMeOut","logout_button","OverviewPage");

			return webElement;
		}
	}

	public static class K900_Overview {

		public static class State_of_Vehicle {

			public static WebElement weatherImage(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[contains(@style,'background-image')]","State_of_Vehicle","OverviewPage");

				return webElement;
			}

			public static WebElement weather(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='weather']/span","weather","OverviewPage");

				return webElement;
			}

			public static WebElement locked(WebDriver driver) {


				webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'lock')]/span[text()='LOCKED']","locked","OverviewPage");

				return webElement;
			}
			public static WebElement climate(WebDriver driver) {


				webElement = FindWebElement.byXpath(driver,"//*[@id='outside-temp'] | //*[@id='inside-temp']","climate","OverviewPage");

				return webElement;
			}
			

			public static WebElement unlocked(WebDriver driver) {


				webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'unlock')]/span[text()='UNLOCKED']","unlocked","OverviewPage");

				return webElement;
			}

			public static WebElement insideTemperature(WebDriver driver) {


				webElement = FindWebElement.byId(driver,"inside-temp","insideTemperature","OverviewPage");

				return webElement;
			}

			public static WebElement outsideTemperature(WebDriver driver) {

				webElement = FindWebElement.byId(driver,"outside-temp","outsideTemperature","OverviewPage");                                

				return webElement;
			}

			public static WebElement find_My_Car(WebDriver driver) {

				webElement = FindWebElement.byId(driver,"fmc","find_My_Car","OverviewPage");

				return webElement;
			}
			
			
			
			public static WebElement currentCarStatus(WebDriver driver) {


				webElement = FindWebElement.byXpath(driver,"//*[@id='door-lock']//div[contains(@ng-if,'latestVehicleStatus')]/span","status","OverviewPage");

				return webElement;
			}
			public static WebElement lockUnlockIcon(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='door-lock']//div[contains(@ng-if,'latestVehicleStatus')]","lockUnlockIcon","OverviewPage");

				return webElement;
			}
			
		}

		public static class Maintenance {

			public static WebElement maintenance_link(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='title-arrow' and text()='Maintenance']","maintenance_link","OverviewPage");

				return webElement;
			}

			public static WebElement miles_Until_Next_Service(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'miles')]","miles_Until_Next_Service","OverviewPage");

				return webElement;
			}
		}

		public static class Awards {

			public static WebElement awards_link(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[@class='title-arrow' and text()='Awards']","awards_link","OverviewPage");

				return webElement;
			}

			public static WebElement lastAwardWon(WebDriver driver) {


				webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'awards')]//div[@class='ng-binding']","lastAwardWon","OverviewPage");

				return webElement;
			}

			public static WebElement totalAwardsEarned(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'awards')]//strong[@class='ng-binding']","totalAwardsEarned","OverviewPage");

				return webElement;
			}
		}

		public static class Diagnostics {

			public static WebElement diagonsticLink(WebDriver driver) {


				webElement = FindWebElement.byXpath(driver,"//*[@class='diagnostic uvo-box border hover-on']/div[@class='title-arrow']","diagonsticLink","OverviewPage");

				return webElement;
			}
			

			public static WebElement no_Issues_Found(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='no-issues']/img","no_Issues_Found","OverviewPage");

				return webElement;
			}

			public static WebElement diagnostic_Issues_Found(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='has-issues']/p","diagnostic_Issues_Found","OverviewPage");

				return webElement;
			}
		}

		public static class Driving_Activity {

			public static WebElement drivingActivity_Link(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='title-arrow' and text()='Driving Activity']","drivingActivity_Link","OverviewPage");

				return webElement;
			}

			public static WebElement current_Mileage(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='mileage']/div","current_Mileage","OverviewPage");

				return webElement;
			}

			public static WebElement driving_Score(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'driving-activity')]//*[contains(@class,'value')]","driving_Score","OverviewPage");

				return webElement;
			}
		}
	}

	public static class ECO {

		public static class State_of_Vehicle {

			public static WebElement background_Pic(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[contains(@style,'background-image')]","background_Pic","OverviewPage");

				return webElement;
			}

			public static WebElement climate(WebDriver driver) {

				webElement = FindWebElement.byCssSelector(driver,".alignbutton > a[href*='climate'] >img","climate","OverviewPage");

				return webElement;
			}

			public static WebElement locked(WebDriver driver) {


				webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'lock')]/span[text()='LOCKED']","locked","OverviewPage");

				return webElement;
			}

			public static WebElement unlocked(WebDriver driver) {               


				webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'unlock')]/span[text()='UNLOCKED']","unlocked","OverviewPage");

				return webElement;
			}            

			public static WebElement outsideTemperature(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@ng-bind='vm.temperature']","outsideTemperature","OverviewPage");

				return webElement;
			}

			
			public static WebElement outsideTemperatureDE(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='overview-diagram-wrapper']/div[3]//*[contains(@href,'climate')]","outsideTemperature","OverviewPage");

				return webElement;
			}
			public static WebElement find_My_CarEV1(WebDriver driver) {


				webElement = FindWebElement.byCssSelector(driver,".btn.fndMyCar","find_My_Car","OverviewPage");

				return webElement;
			}

			
			public static WebElement find_My_Car(WebDriver driver) {


				webElement = FindWebElement.byCssSelector(driver,"#fmc > a > div","find_My_Car","OverviewPage");

				return webElement;
			}

			public static WebElement batteryPlugIn_Status (WebDriver driver) {

				webElement = FindWebElement.byCssSelector(driver,".overview-diagram-wrapper>div:nth-child(2) div[class='ev-battery'] > span, .overview-diagram-wrapper>div:nth-child(2) a[href*='battery'] span","batteryPlugIn_Status","OverviewPage");

				return webElement;
			}
			
			public static WebElement batteryPlugIn_StatusDE (WebDriver driver) {

				webElement = FindWebElement.byCssSelector(driver,".overview-diagram-wrapper>div:nth-child(3) div > span[class='spantxt ng-binding']","batteryPlugIn_Status","OverviewPage");

				return webElement;
			}
			
			public static WebElement chargingTimes (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'LEVEL 1')]/parent::div/following-sibling::div/span/strong","batteryPlugIn_Status","OverviewPage");

				return webElement;
			}
			
			
			public static WebElement refreshIcon (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//img[contains(@src,'refresh.png')]","refreshIcon","OverviewPage");

				return webElement;
			}
			
			public static WebElement batteryRange (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@knob-status,'batteryStatus')]","battery Range","OverviewPage");

				return webElement;
			}
			
			public static WebElement lockunlockstatus (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'latestVehicleStatus')]/span | //*[contains(@ng-bind,'doorLockStatus')]","lockUnlock status","OverviewPage");

				return webElement;
			}
			
			public static WebElement drivingRangeEV2 (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='overview-diagram-wrapper']/div[@id='ev-temperature']//*[@class='drivingRange ng-binding']","lockUnlock status","OverviewPage");

				return webElement;
			}
			
			public static WebElement drivingRangeDE(WebDriver driver) {

				webElement = FindWebElement.byCssSelector(driver,".overview-diagram-wrapper>div:nth-child(3) div[class='combined'] > span:nth-child(2)","Driving range","OverviewPage");

				return webElement;
			}
			
			
			
			public static WebElement lockunlockStatusEV2 (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-if,'vehicleStatus')]/span","lockUnlock status","OverviewPage");

				return webElement;
			}
			
			public static WebElement batteryStatusEV2 (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='overview-diagram-wrapper']/div[@id='ev-temperature']//*[@class='ev-battery']/span","lockUnlock status","OverviewPage");

				return webElement;
			}
			
			
			public static WebElement batteryPercentage (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//label[@ng-bind='vmStatus']","batteryPercentage","OverviewPage");

				return webElement;
			}
			public static WebElement viewBattery (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[text()='VIEW BATTERY']","viewBattery","OverviewPage");

				return webElement;
			}
			
			
			
		}                                        

		public static class Maintenance {

			public static WebElement maintenanceLink(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[@class='title-arrow' and text()='Maintenance']","maintenanceLink","OverviewPage");

				return webElement;
			}

			public static WebElement mileage(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'miles')]","mileage","OverviewPage");

				return webElement;
			}
		}

		public static class Awards {

			public static WebElement awardsLink(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='title-arrow' and text()='Awards']","awardsLink","OverviewPage");

				return webElement;
			}

			public static WebElement awardName(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'awards')]//div[@class='ng-binding']","awardName","OverviewPage");

				return webElement;
			}

			public static WebElement numberOfAwardsWon(WebDriver driver) {


				webElement = FindWebElement.byXpath(driver,"//div[@class='bottom-text']/strong[node()-1]","numberOfAwardsWon","OverviewPage");

				return webElement;
			}
		}

		public static class Diagnostic {

			public static WebElement diagnosticsLink(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'title')]/span[text()='DIAGNOSTICS']","diagnosticsLink","OverviewPage");

				return webElement;
			}

			public static WebElement noDiagnoticIssue (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//img[contains(@src,'noIssues')]","noDiagnoticIssue","OverviewPage");

				return webElement;
			}

			public static WebElement diagnoticIssue (WebDriver driver) {

				webElement = FindWebElement.byId(driver,"issue","diagnoticIssue","OverviewPage");

				return webElement;
			}
		}

		public static class ChargingStations {

			public static WebElement chargingStationsLinkEV1(WebDriver driver) {

				webElement = FindWebElement.byCssSelector(driver,".btn.charging","chargingStationsLink","OverviewPage");

				return webElement;
			}
			
			public static WebElement chargingStationsLink(WebDriver driver) {

				webElement = FindWebElement.byCssSelector(driver,"#fmc1 >a","chargingStationsLink","OverviewPage");

				return webElement;
			}
			
			public static WebElement chargingStationsLinkDE(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='title-arrow' and text()='CHARGING STATIONS']","chargingStationsLink","OverviewPage");

				return webElement;
			}
			
			
		}

		     

		public static class TimeToFullCharge {

			public static WebElement startCharging (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[@class='title-arrow'][text()='TIME TO FULL CHARGE']","startCharging","OverviewPage");                                                                

				return webElement;
			}
		}

		public static class DrivingActivity {                    

			public static WebElement drivingActivityLink(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[@class='title-arrow' and text()='Driving Activity']","drivingActivityLink","OverviewPage");

				return webElement;
			}

			public static WebElement mileage(WebDriver driver) {

				webElement = FindWebElement.byId(driver,"currMileage","mileage","OverviewPage");

				return webElement;
			}

			public static WebElement drivingScore(WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[@class='doughnut-score']/div[starts-with(@class,'value')]","drivingScore","OverviewPage");

				return webElement;
			}            
		}
	}
}
