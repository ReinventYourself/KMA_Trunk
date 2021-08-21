package com.rsi.kma.automation.pageObjects;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.FindWebElement;



public class AwardsPage {


	private static WebElement webElement = null;
	private static List<WebElement> webElements = null;    

	public static WebElement helpButton(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//a[contains(@ng-click,'open')]","helpButton","Awards Page");               

		return webElement;
	}

	public static WebElement efficientAwardTextHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Efficient Driver')]","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement efficientAwardHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Efficient Driver')]/following-sibling::p","helpButton","Awards Page");               

		return webElement;
	}
	public static WebElement SchedulerAwardHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Scheduler')]","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement SchedulerAwardTextHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Scheduler')]/following-sibling::p","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement efficiencyLeaderTextHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Efficiency Leader')]","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement efficiencyLeaderHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Efficiency Leader')]/following-sibling::p","helpButton","Awards Page");               

		return webElement;
	}

	
	public static WebElement gettingIneterestedTextHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Getting Interested')]","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement gettingIneterestedHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Getting Interested')]/following-sibling::p","helpButton","Awards Page");               

		return webElement;
	}

	public static WebElement efficiencyKingTextHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Efficiency King')]","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement efficiencykingHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Efficiency King')]/following-sibling::p","helpButton","Awards Page");               

		return webElement;
	}
	
	

	public static WebElement growingGarageTextHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Growing Garage')]","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement growingGarageHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Growing Garage')]/following-sibling::p","helpButton","Awards Page");               

		return webElement;
	}
	
	
	public static WebElement travellerTextHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Traveler')]","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement travellerHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Traveler')]/following-sibling::p","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement powerUserTextHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Power User')]","helpButton","Awards Page");               

		return webElement;
	}
	
	public static WebElement powerUserHelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[contains(@ng-repeat,'Help')]//*[starts-with(text(),'Power User')]/following-sibling::p","helpButton","Awards Page");               

		return webElement;
	}
	
	
	public static WebElement closehelp(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[contains(@ng-click,'close()')]","helpButton","Awards Page");               

		return webElement;
	}

	
	
	
	
		
	
	
	
	
	public static WebElement schedulerText(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[text()='Scheduler']","schedulerText","Awards Page");             


		return webElement;
	}


	public static WebElement schedulerAwards(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[text()='Scheduler']/following-sibling::p | //*[starts-with(text(),'Scheduler')]/parent::h3/following-sibling::p","schedulerText","Awards Page");             


		return webElement;
	}


	public static WebElement gettingInterestedText(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[starts-with(text(),'Getting Interested')]","GettingInterestedAward","CarLeft Menu");       


		return webElement;
	}
	public static WebElement gettingInterestedAward(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[starts-with(text(),'Getting Interested')]/following-sibling::p | //*[starts-with(text(),'Getting Interested')]/parent::h3/following-sibling::p","GettingInterestedAward","CarLeft Menu");       


		return webElement;
	}




	public static WebElement growingGarageText(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[starts-with(text(),'Growing Garage')]","growingGarageAward","Awards Page");


		return webElement;
	}


	public static WebElement growingGarageAward(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[text()='Growing Garage']/following-sibling::p | //*[starts-with(text(),'Growing Garage')]/parent::h3/following-sibling::p","growingGarageAward","Awards Page");


		return webElement;
	}


	public static WebElement travelerAward(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[starts-with(text(),'Traveler')]/following-sibling::p| //*[starts-with(text(),'Traveler')]/parent::h3/following-sibling::p","travelerAward","Awards Page");   


		return webElement;
	}


	public static WebElement travelerAwardText(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[starts-with(text(),'Traveler')]","travelerAwardText","Awards Page");   


		return webElement;
	}
	public static WebElement powerUserAwardText(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[starts-with(text(),'Power User')]","powerUserAward","Awards Page");   

		return webElement;
	}


	public static WebElement powerUserAward(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[starts-with(text(),'Power User')]/following-sibling::p | //*[starts-with(text(),'Power User')]/parent::h3/following-sibling::p","powerUserAward","Awards Page");   

		return webElement;
	}




	//You won this award

	public static WebElement efficientDriverAward(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//span[contains(text(),'Efficiency Driver')]/ancestor::div[@class='col-sm-3 ng-scope']","efficientDriverAward","Awards Page");   

		return webElement;
	}

	public static List<WebElement> no_Of_Awards_Won (WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[@data-from-now]","no_Of_Awards_Won","Awards Page");   


		return webElements;
	}

	public static List<WebElement> countActiveAwards (WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[@id='awards']/section//*[@class='award-description']/h3/span","countActiveAwards","Awards Page");   


		return webElements;
	}    

	public static WebElement awardsText(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//h2[text()='AWARDS']","AwardsText","Awards Page");   

		return webElement;
	}

	public static WebElement backButtton(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//*[@class='awardBackBtn']","backButtton","Awards Page");   

		return webElement;
	}



	public static WebElement countAwardsOverviewPageECO(WebDriver driver) {




		WebElement remote= MyCarLeftMenu.Remote_Link(driver);
		if (remote != null) {                

			webElement=FindWebElement.byXpath(driver,"//div[contains(text(),'ve earned')]/strong[1]","countAwardsOverviewPageECO","Awards Page");   


		} 

		return webElement;
	}

	public static WebElement countAwardsOverviewPage(WebDriver driver) {


		WebElement remote= MyCarLeftMenu.Remote_Link(driver);
		if (remote != null) {                

			webElement=FindWebElement.byXpath(driver,"//div[contains(text(),'ve earned')]/strong[1]","countAwardsOverviewPage","Awards Page");   

		}

		else if (remote == null) {
			/*For Connected*/
			webElement=FindWebElement.byXpath(driver,"//span[contains(@class,'awards')]//strong[1]","helpButton","Awards Page");   

		}    


		return webElement;
	}

	public static WebElement awardsOverviewPage(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//span[@class='award-details']","awardsOverviewPage","Awards Page");   
		return webElement;
	}

	public static WebElement roadSideAssistance(WebDriver driver) {

		webElement=FindWebElement.byXpath(driver,"//div[@id='hamburger-footer']//div[@class='phone-numbers']/h1","helpButton","Awards Page");   

		return webElement;
	}
}
