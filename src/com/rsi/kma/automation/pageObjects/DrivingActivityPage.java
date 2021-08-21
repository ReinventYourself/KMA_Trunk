package com.rsi.kma.automation.pageObjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;


public class DrivingActivityPage {

	private static Logger Log = Logger.getLogger(DrivingActivityPage.class
			.getName());
	private static WebElement webElement = null;

	public static class VehicleSelector {

		public static WebElement image(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".nav-vehicle-selector>img","image","Driving Activity");

			return webElement;
		}

		public static WebElement nicknameOfVehicle(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".nav-vehicle-selector>.title","nicknameOfVehicle","Driving Activity");

			return webElement;
		}

		public static WebElement vehicleDropdown(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".nav-vehicle-selector>.arrow","vehicleDropdown","Driving Activity");

			return webElement;
		}

		public static WebElement vehicleRadioButton(WebDriver driver,
				String nickname) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='info']/p[text()='" + nickname
					+ "']/../preceding-sibling::div/div","vehicleRadioButton","Driving Activity");

			return webElement;
		}

		public static WebElement viewAllVehicles(WebDriver driver) {

			webElement = FindWebElement.byCssSelector(driver,".show-all-vehicles>a","viewAllVehicles","Driving Activity");

			return webElement;
		}

		public static WebElement driving_Score_Box(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border driving-activity safe-driving-score']","driving_Score_Box","Driving Activity");


			return webElement;
		}

		public static WebElement pick_Driving_Hours_Box(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,".//*[@class='widget-box border peak-driving center']","pick_Driving_Hours_Box","Driving Activity");

			return webElement;
		}

		public static WebElement hours_Driven_Box(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,".//*[@class='widget-box hours-driving driving-activity border center']","hours_Driven_Box","Driving Activity");

			return webElement;
		}

		public static WebElement mileageBox(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,".//*[@class='widget-box mileage border center']","image","Driving Activity");

			return webElement;
		}

		public static WebElement IdleTimeBox(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,".//*[@class='widget-box idle-time last-sync border center']","mileageBox","Driving Activity");

			return webElement;
		}

		public static WebElement averageSpeedBox(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,".//*[@class='widget-box driving-activity average-speed border center']","averageSpeedBox","Driving Activity");

			return webElement;
		}

		public static WebElement awardsBox(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,".//*[@class='widget-box awards border center hover-on']","awardsBox","Driving Activity");

			return webElement;
		}

		public static WebElement footerText(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'disclaimer')]","footerText","Driving Activity");

			return webElement;
		}
	}

	public static class DrivingActivityElements {

		public static WebElement drivingScoreMonth(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border driving-score']//*[@class='milestone-container']//*[starts-with(@class,'milestone ')]/span[2]","drivingScoreMonth","Driving Activity");

			return webElement;
		}

		public static WebElement drivingScoreValue(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border driving-score']//*[@class='doughnut']//*[starts-with(@class,'good')]","drivingScoreValue","Driving Activity");

			return webElement;
		}


		public static WebElement drivingScoreFirstMonth(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border driving-activity safe-driving-score']/..//div[2][@class='milestone']","drivingScoreFirstMonth","Driving Activity");                        

			return webElement;
		}


		public static WebElement drivingScoreSecondMonth(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[@class='milestone ng-scope']","drivingScoreSecondMonth","Driving Activity");

			return webElement;
		}       

		public static WebElement hoursDrivenBox(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border hours-driven']","hoursDrivenBox","Driving Activity");

			return webElement;
		}             

		public static WebElement hoursDrivenValue(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='activity-meter']/span[1]","hoursDrivenValue","Driving Activity");

			return webElement;
		}

		public static WebElement hoursDrivenArrowLeft(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border hours-driven']//*[contains(@class,'left-arrow')]","hoursDrivenArrowLeft","Driving Activity");

			return webElement;
		}

		public static WebElement hoursDrivenArrowRight(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border hours-driven']//*[contains(@class,'left-arrow')]","hoursDrivenArrowRight","Driving Activity");

			return webElement;
		}

		public static WebElement averageSpeedBox(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//*[@class='widget-box border average-speed']","averageSpeedBox","Driving Activity");

			return webElement;
		}

		public static WebElement averageSpeedValue(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border average-speed']//*[starts-with(@class,'amount')]","averageSpeedValue","Driving Activity");

			return webElement;
		}


		public static WebElement averageSpeedLeftArrow(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//*[@class='widget-box border average-speed']/..//*[contains(@class,'left-arrow')]","averageSpeedLeftArrow","Driving Activity");

			return webElement;
		}

		/*TBD*/
		public static WebElement averageSpeedRightArrow(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//*[@class='widget-box border average-speed']/..//*[contains(@class,'right-arrow')]","averageSpeedRightArrow","Driving Activity");

			return webElement;
		}

		public static WebElement mileageBox(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border mileage']","mileageBox","Driving Activity");

			return webElement;
		}       

		public static WebElement mileageValue(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@id='currMileage'] | //*[@class='widget-box border mileage']//*[starts-with(@class,'amount')]","mileageValue","Driving Activity");

			return webElement;
		}

		public static WebElement mileageChart(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border mileage']//*[@class='mileage-chart']","mileageChart","Driving Activity");

			return webElement;
		}



		public static WebElement yearLinkMileage(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border mileage']//*[@class='years-list']/li[1]/span","image","Driving Activity");

			return webElement;
		}

		public static WebElement drivingYear(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//*[@class='widget-box border mileage']//*[@class='years-list']/li[1]/span","image","Driving Activity");              

			return webElement;
		}

		public static WebElement idleTimeBox(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//*[@class='widget-box border idle-time']","image","Driving Activity");

			return webElement;
		}

		public static WebElement idleTimeValue(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border idle-time']//*[starts-with(@class,'amount')]","image","Driving Activity");

			return webElement;
		}


		public static WebElement idleTimeLeftArrow(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border idle-time']/..//*[@class='date-link']//*[contains(@class,'left-arrow')]","image","Driving Activity");

			return webElement;
		}


		public static WebElement idleTimeRightArrow(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border idle-time']/..//*[@class='date-link']//*[contains(@class,'right-arrow')]","image","Driving Activity");

			return webElement;
		}


		public static WebElement peakDrivingHoursBox(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border peak-driving-hours']","peakDrivingHoursBox","Driving Activity");

			return webElement;
		}

		public static WebElement peakHoursValue(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border peak-driving-hours']//div[@class='peak-chart']","image","Driving Activity");

			return webElement;
		}

		public static WebElement awardsBox(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'widget-box border awards')]","image","Driving Activity");                

			return webElement;
		}

		public static WebElement overallLink(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border mileage']//*[@class='years-list']/li[2]/span","image","Driving Activity");

			return webElement;
		}

		public static WebElement noOfAwards(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='awards-meter']/span","noOfAwards","Driving Activity");

			return webElement;
		}
		


	}


	public static class ECO {

		public static WebElement drivingYear(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//section[contains(@class,'hours-driven')]//span[contains(@class,'month-year')][not(self::strong)]","image","Driving Activity");

			return webElement;
		}     

		public static WebElement awardsBoxECO(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box awards border center hover-on']","image","Driving Activity");

			return webElement;
		} 
	}
}
