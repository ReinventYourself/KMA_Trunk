package com.rsi.kma.automation.modules;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;

import com.rsi.kma.automation.pageObjects.MyCarZonePage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Utils;

public class MyCarZoneModule {

	private static Logger    Log = Logger.getLogger(MyCarZoneModule.class.getName());

	static List <WebElement> mapsLogo=null;
	static List <WebElement> days=null;
	static List <WebElement> radioButton=null;
	static List <WebElement> totalSettings=null;
	static int alerts=0;
	static int count=0;

	static int speedCaptured=0;

	static String speed=null;
	public static void NavigateToMyCarZonePage(WebDriver driver)
	{
		LoginModule.login(driver);	

		Utils.sleep(driver, 2000);

		ActionModule.click(driver,MyCarLeftMenu.myCarZoneLink(driver), "myCarZoneLink", "MyCarZone Page");

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.CurfewAlerts.curfewLink(driver));

		Log.info("Successsfully Navigate to My CarZone Page");

	}

	/**
	 * To Check Curfew Alerts 
	 * @param driver
	 * @return No of alerts present 
	 */
	public static int curfewAlerts(WebDriver driver)
	{

		ActionModule.click(driver,MyCarZonePage.CurfewAlerts.curfewLink(driver), "curfewLink", "MyCarZone Page");

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.CurfewAlerts.totalAlerts(driver));

		if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.noAlert(driver)))
		{
			Log.info("No Curfew Alerts found on My car page");
			throw new SkipException("No Curfew Alerts found on My car page");

		}

		String totalAlerts=ActionModule.getText(driver,MyCarZonePage.CurfewAlerts.totalAlerts(driver), "totalAlerts", "MyCarZone Page").substring(0,3).replaceAll("[a-zA-Z]", "").trim();

		int alertsDisplayed=Integer.parseInt(totalAlerts);


		if(alertsDisplayed>5)
		{
			Log.info("More than 5 alerts found");
			Utils.scrolDownForElement(driver, MyCarZonePage.loadMore(driver));
			ActionModule.click(driver,  MyCarZonePage.loadMore(driver), "loadMore", "loadMore");

		}

		else
		{
			Log.info("Alerts are less than or equal to 5");
		}


		return alertsDisplayed;


	}

	/**
	 * To Change Time from 24 hour format to 12 hour Format
	 * @param driver
	 * @param time
	 * @return
	 */
	public static String convertTime(WebDriver driver,String time)
	{
		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
		Date date = null;
		try {
			date = parseFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String convertedTime=displayFormat.format(date);
		return convertedTime;
	}


	/**
	 * To check whether the alert is triggered in the alert range
	 * @param driver
	 * @param alertsDisplayed
	 */
	public static void checkTriggeredCurfewAlerts(WebDriver driver,int alertsDisplayed)
	{

		int max=0;
		Utils.scrolDownForElement(driver, MyCarZonePage.CurfewAlerts.curfewLink(driver));
		Utils.sleep(driver, 2000);

		mapsLogo=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'option map')]/span[text()='View Map']", "map logo", "my car zone");
		alerts=mapsLogo.size();

		if(alerts==alertsDisplayed)
		{
			Log.info("equal alerts displayed");
		}
		else
		{
			Log.info("alerts not matched");
		}

		if(alertsDisplayed>3)
		{
			max=3;
		}
		else
		{
			max=2;	
		}
		for(int i=1;i<= max;i++)
		{
			WebElement firstAlert=mapsLogo.get(i-1);
			ActionModule.click(driver,firstAlert, "first Alert", "My Car zone page");



			WebElement time=FindWebElement.byXpath(driver, 
					"//*[contains(@class,'alerts col')]/div["+i+"]//div[contains(@class,'content col')]/div[contains(@class,'indicator ')]/strong", "time","My car zone");


			WebElement AMPM=FindWebElement.byXpath(driver, 
					"//*[contains(@class,'alerts col')]/div["+i+"]//div[contains(@class,'content col')]/div[contains(@class,'indicator ')]/b", "time","My car zone");

			String alertTime=ActionModule.getText(driver, time, "time", "MyCarZone").concat(" ").concat(ActionModule.getText(driver, AMPM, "AMPM", "MyCarZone"));
			Log.info("alert time is :"+alertTime);

			alertTime=convertTime(driver,alertTime);

			WebElement range=FindWebElement.byXpath(driver, 
					"//*[contains(@class,'alerts col')]/div["+i+"]//div[contains(@class,'content col')]/div[contains(@class,'row link')]", "range","My car zone");


			String range1=ActionModule.getText(driver, range, "range", "MyCarZone").substring(9,17).trim();
			range1=convertTime(driver,range1);


			String range2=ActionModule.getText(driver, range, "range", "MyCarZone");
			range2=range2.substring(range2.length()-8).trim();


			range2=convertTime(driver,range2);

			checkTimeRange(alertTime,range1,range2);


		}

		if(Utils.waitForElementToBeClickable(driver, MyCarZonePage.hideMap(driver)))
		{
			ActionModule.click(driver, MyCarZonePage.hideMap(driver), "hideMap", "MyCarZonePage");
		}
		//Check various combination for days filter
		checkDropDownValues(driver);


	}

	/**
	 * Module to shuffle days value in drop down 
	 * @param driver
	 */
	private static void checkDropDownValues(WebDriver driver) {


		ActionModule.click(driver,  MyCarZonePage.alertsDropDown.daysDropDown(driver), "daysDropDown", "alertsDropDown");
		ActionModule.click(driver,  MyCarZonePage.alertsDropDown.valueinDropDown7Days(driver), "valueinDropDown7Days", "loadMore");
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[contains(@class,'option map')]/span[text()='View Map']"));

		mapsLogo=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'option map')]/span[text()='View Map']", "map logo", "my car zone");

		if(mapsLogo==null)
		{
			Log.info("No Alerts Found");
		}
		else
		{
			alerts=mapsLogo.size();
			Log.info("alerts after 7 days filter are : "+ alerts);
		}


		ActionModule.click(driver,  MyCarZonePage.alertsDropDown.daysDropDown(driver), "daysDropDown", "alertsDropDown");
		ActionModule.click(driver,  MyCarZonePage.alertsDropDown.valueinDropDown5Days(driver), "valueinDropDown5Days", "loadMore");
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[contains(@class,'option map')]/span[text()='View Map']"));

		mapsLogo=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'option map')]/span[text()='View Map']", "map logo", "my car zone");
		if(mapsLogo==null)
		{
			Log.info("No Alerts Found");
		}
		else
		{
			Log.info("alerts after 5 days filter are : "+ alerts);
		}
		ActionModule.click(driver,  MyCarZonePage.alertsDropDown.daysDropDown(driver), "daysDropDown", "alertsDropDown");
		ActionModule.click(driver,  MyCarZonePage.alertsDropDown.valueinDropDown3Days(driver), "valueinDropDown3Days", "loadMore");
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[contains(@class,'option map')]/span[text()='View Map']"));
		mapsLogo=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'option map')]/span[text()='View Map']", "map logo", "my car zone");
		if(mapsLogo==null)
		{
			Log.info("No Alerts Found");
		}
		else
		{
			alerts=mapsLogo.size();

			Log.info("alerts after 3 days filter are : "+ alerts);
		}



	}

	/**
	 * To verify whether alert time is in the specified alert range
	 * @param alertTime
	 * @param range1
	 * @param range2
	 */
	private static void checkTimeRange(String alertTime, String range1, String range2) {

		try {

			Date time1 = new SimpleDateFormat("HH:mm").parse(range1);
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(time1);

			Date time2 = new SimpleDateFormat("HH:mm").parse(range2);
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(time2);
			calendar2.add(Calendar.DATE, 1);


			Date d = new SimpleDateFormat("HH:mm").parse(alertTime);
			Calendar calendar3 = Calendar.getInstance();
			calendar3.setTime(d);
			calendar3.add(Calendar.DATE, 1);

			Date x = calendar3.getTime();
			if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
				Log.info("Alert is triggered within the curfew time range  ");

			}
			else
			{
				Log.info("Alert is not triggered within the curfew time range  ");
			}
		} catch (ParseException e) {
			e.printStackTrace();

		}

	}
	/**
	 * Delete alerts and check whether the alert is deleted or not.
	 * @param driver
	 * @param methodName
	 */
	public static void deleteAlert(WebDriver driver,String methodName)
	{
		WebElement element=null;

		ActionModule.click(driver,  MyCarZonePage.alertsDropDown.daysDropDown(driver), "daysDropDown", "alertsDropDown");
		ActionModule.click(driver,  MyCarZonePage.alertsDropDown.valueinDropDown30Days(driver), "valueinDropDown30Days", "MyCarZonePage");



		if(methodName.toLowerCase().contains("curfew"))
		{
			element=MyCarZonePage.CurfewAlerts.totalAlerts(driver);
		}
		else if(methodName.toLowerCase().contains("speed"))
		{
			element=MyCarZonePage.SpeedAlerts.totalAlerts(driver);
		}
		else if(methodName.toLowerCase().contains("geofence"))
		{
			element=MyCarZonePage.GeoFenceAlerts.totalAlerts(driver);
		}
		else if(methodName.toLowerCase().contains("valet"))
		{
			element=MyCarZonePage.ValetAlerts.totalAlerts(driver);
		}
		else
		{
			Log.info("Not applicable for test case");
		}

		Utils.waitForElementToBeClickable(driver, element);
		Utils.sleep(driver, 2000);


		String totalAlerts=ActionModule.getText(driver,element, "totalAlerts", "MyCarZone Page").substring(0,3).replaceAll("[a-zA-Z]", "").trim();

		int alertsDisplayed=Integer.parseInt(totalAlerts);

		if(alertsDisplayed>5)
		{
			Log.info("More than 5 alerts found");
			Utils.scrolDownForElement(driver, MyCarZonePage.loadMore(driver));
			if(Utils.waitForElementToBeClickable(driver,MyCarZonePage.loadMore(driver) ))
				ActionModule.click(driver,  MyCarZonePage.loadMore(driver), "loadMore", "loadMore");

		}

		else
		{
			Log.info("Alerts are less than or equal to 5");
		}

		deleteLastAlert(driver,alertsDisplayed,methodName);



	}

	/**
	 * To delete last alert from the list
	 * @param driver
	 * @param alertsDisplayed
	 * @param methodName
	 */
	public static void deleteLastAlert(WebDriver driver,int alertsDisplayed,String methodName)
	{
		Utils.scrolDownForElement(driver,MyCarZonePage.manageButton(driver) );

		ActionModule.click(driver,  MyCarZonePage.manageButton(driver), "manageButton", "MyCarZonePage");

		Utils.scrolDownForElement(driver, MyCarZonePage.loadMore(driver));


		while((Utils.waitForElementToBeClickable(driver,MyCarZonePage.loadMore(driver))))
			ActionModule.click(driver,  MyCarZonePage.loadMore(driver), "loadMore", "loadMore");

		radioButton=FindWebElement.findElementListByXpath(driver, "//div[contains(@class,'option select')]/p", "radio button", "My car zone");

		Log.info("total radio buttons:"+radioButton.size());

		Log.info("total alerts are:"+alertsDisplayed);
		Utils.scrolDownForElement(driver, radioButton.get(alertsDisplayed-1));

		ActionModule.click(driver, radioButton.get(alertsDisplayed-1) , "daysDropDown", "alertsDropDown");

		Utils.sleep(driver, 2000);
		Utils.scrolDownForElement(driver, MyCarZonePage.manageButton(driver));

		Utils.scrolDownForElement(driver, MyCarZonePage.delete(driver));

		Log.info("before cancel delete :"+alertsDisplayed );
		ActionModule.click(driver,  MyCarZonePage.delete(driver), "delete", "MyCarZonePage");

		ActionModule.isDisplayed(driver, MyCarZonePage.confirmDelete(driver), "", "");


		cancelDelete(driver,alertsDisplayed,methodName);



		Log.info("before confirm delete :"+alertsDisplayed );
		ActionModule.click(driver,  MyCarZonePage.delete(driver), "delete", "MyCarZonePage");
		Utils.waitForElementToBeClickable(driver, MyCarZonePage.confirmDelete(driver));

		ActionModule.isDisplayed(driver, MyCarZonePage.confirmDelete(driver), "", "");

		confirmDelete(driver,alertsDisplayed,methodName);


	}


	/**
	 * To cancel the delete command 
	 * @param driver
	 * @param alertsDisplayed
	 * @param methodName
	 */

	public static void cancelDelete(WebDriver driver,int alertsDisplayed,String methodName)
	{

		ActionModule.click(driver,  MyCarZonePage.cancelDelete(driver), "cancelDelete", "MyCarZonePage");

		WebElement element=null;
		if(methodName.toLowerCase().contains("curfew"))
		{
			element=MyCarZonePage.CurfewAlerts.totalAlerts(driver);
		}
		else if(methodName.toLowerCase().contains("speed"))
		{
			element=MyCarZonePage.SpeedAlerts.totalAlerts(driver);
		}
		else if(methodName.toLowerCase().contains("geofence"))
		{
			element=MyCarZonePage.GeoFenceAlerts.totalAlerts(driver);
		}
		else if(methodName.toLowerCase().contains("valet"))
		{
			element=MyCarZonePage.ValetAlerts.totalAlerts(driver);
		}
		else
		{
			Log.info("Not applicable for test case");
		}

		String totalAlerts=ActionModule.getText(driver,element, "totalAlerts", "MyCarZone Page").substring(0,3).replaceAll("[a-zA-Z]", "").trim();

		int alerts=Integer.parseInt(totalAlerts);
		Log.info("after cancel alerts are:"+alerts);
		if(alertsDisplayed==alerts)
		{
			Log.info("No alerts deleted");
		}
		else
		{
			Log.error("Alerts deleted");
			Assert.fail("Alerts deleted");
		}

	}


	/**
	 * To confirm the delete command 
	 * @param driver
	 * @param alertsDisplayed
	 * @param methodName
	 */

	public static void confirmDelete(WebDriver driver,int alertsDisplayed,String methodName)
	{

		ActionModule.click(driver,  MyCarZonePage.confirmDelete(driver), "confirmDelete", "MyCarZonePage");

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.manageButton(driver));

		Utils.sleep(driver, 5000);

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.SpeedAlerts.speedLink(driver));

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.viewMapAll(driver));

		WebElement element=null;
		if(methodName.toLowerCase().contains("curfew"))
		{
			element=MyCarZonePage.CurfewAlerts.totalAlerts(driver);
		}
		else if(methodName.toLowerCase().contains("speed"))
		{
			element=MyCarZonePage.SpeedAlerts.totalAlerts(driver);
		}
		else if(methodName.toLowerCase().contains("geofence"))
		{
			element=MyCarZonePage.GeoFenceAlerts.totalAlerts(driver);
		}
		else if(methodName.toLowerCase().contains("valet"))
		{
			element=MyCarZonePage.ValetAlerts.totalAlerts(driver);
		}
		else
		{
			Log.info("Not applicable for test case");
		}


		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, MyCarZonePage.manageButton(driver));

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));
		String totalAlerts=ActionModule.getText(driver,element, "totalAlerts", "MyCarZone Page").substring(0,3).replaceAll("[a-zA-Z]", "").trim();

		int alerts=Integer.parseInt(totalAlerts);


		Log.info("after confirm alerts are:"+alerts);
		if(alertsDisplayed!= alerts)
		{
			Log.info("alerts deleted");
		}
		else
		{
			Log.error("No Alerts deleted");
			Assert.fail("No Alerts deleted");
		}

	}
	/**
	 * To verify speed alerts 
	 * @param driver
	 * @return
	 */

	public static int speedAlerts(WebDriver driver)
	{

		ActionModule.click(driver,MyCarZonePage.SpeedAlerts.speedLink(driver), "curfewLink", "MyCarZone Page");

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.SpeedAlerts.totalAlerts(driver));

		if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.noAlert(driver)))
		{
			Log.info("No Speed Alerts found on My car page");
			throw new SkipException("No Speed Alerts found on My car page");

		}
		Utils.waitForElementToBeClickable(driver, MyCarZonePage.manageButton(driver));

		String totalAlerts=ActionModule.getText(driver,MyCarZonePage.SpeedAlerts.totalAlerts(driver), "totalAlerts", "MyCarZone Page").substring(0,3).replaceAll("[a-zA-Z]", "").trim();

		int alertsDisplayed=Integer.parseInt(totalAlerts);


		if(alertsDisplayed>5)
		{
			Log.info("More than 5 alerts found");
			Utils.scrolDownForElement(driver, MyCarZonePage.loadMore(driver));
			ActionModule.click(driver,  MyCarZonePage.loadMore(driver), "loadMore", "loadMore");

		}

		else
		{
			Log.info("Alerts are less than or equal to 5");
		}


		return alertsDisplayed;


	}

	/**
	 * To cancel whether the speed alert is triggered or not
	 * @param driver
	 * @param alertsDisplayed
	 * @param methodName
	 */

	public static void checkTriggeredSpeedAlerts(WebDriver driver,int alertsDisplayed)
	{


		int max=0;
		Utils.waitForElementToBeClickable(driver, MyCarZonePage.CurfewAlerts.curfewLink(driver));
		Utils.sleep(driver, 2000);

		mapsLogo=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'option map')]/span[text()='View Map']", "map logo", "my car zone");
		alerts=mapsLogo.size();

		if(alerts==alertsDisplayed)
		{
			Log.info("equal alerts displayed");
		}
		else
		{
			Log.info("alerts not matched");
		}

		if(alertsDisplayed>=3)
		{
			max=3;
		}

		else if(alertsDisplayed==1)
		{
			max=1;
		}
		else
		{
			max=2;	
		}
		for(int i=1;i<= max;i++)
		{


			WebElement firstAlert=mapsLogo.get(i-1);
			ActionModule.click(driver,firstAlert, "first Alert", "My Car zone page");

			WebElement time=FindWebElement.byXpath(driver, 
					"//*[contains(@class,'alerts col')]/div["+i+"]//div[contains(@class,'content col')]/div[contains(@class,'indicator ')]/strong", "time","My car zone");

			int alertTime=Integer.parseInt(ActionModule.getText(driver, time, "range", "MyCarZone"));

			WebElement range=FindWebElement.byXpath(driver, 
					"//*[contains(@class,'alerts col')]/div["+i+"]//div[contains(@class,'content col')]/div[contains(@class,'row link')]", "range","My car zone");


			String  range1=ActionModule.getText(driver, range, "range", "MyCarZone");
			range1=range1.substring(range1.lastIndexOf(":") + 1,range1.lastIndexOf("MPH")).trim();
			int alertRange=Integer.parseInt(range1);

			if(alertRange < alertTime)
			{
				Log.info("Alerts is triggered within the speed alert range");
			}
			else
			{
				Log.info("Alerts is not triggered within the speed alert range");
			}

			if(Utils.waitForElementToBeClickable(driver, MyCarZonePage.hideMap(driver)))
			{
				ActionModule.click(driver, MyCarZonePage.hideMap(driver), "hideMap", "MyCarZonePage");
			}

		}

		checkDropDownValues(driver);

	}




	/**
	 * Verify Geofence  alerts 
	 * @param driver
	 * @return No of alerts present 
	 */

	public static int geoFenceAlerts(WebDriver driver)
	{

		ActionModule.click(driver,MyCarZonePage.GeoFenceAlerts.geofenceLink(driver), "geofenceLink", "MyCarZone Page");

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.GeoFenceAlerts.totalAlerts(driver));

		if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.noAlert(driver)))
		{
			Log.info("No geo fence Alerts found on My car page");
			throw new SkipException("No geo fence Alerts found on My car page");

		}

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.manageButton(driver));

		String totalAlerts=ActionModule.getText(driver,MyCarZonePage.GeoFenceAlerts.totalAlerts(driver), "totalAlerts", "MyCarZone Page").substring(0,3).replaceAll("[a-zA-Z]", "").trim();

		int alertsDisplayed=Integer.parseInt(totalAlerts);


		if(alertsDisplayed>5)
		{
			Log.info("More than 5 alerts found");
			Utils.scrolDownForElement(driver, MyCarZonePage.loadMore(driver));
			ActionModule.click(driver,  MyCarZonePage.loadMore(driver), "loadMore", "loadMore");

		}

		else
		{
			Log.info("Alerts are less than or equal to 5");
		}


		return alertsDisplayed;


	}

	/**
	 * to check whether the alert is triggered or not
	 * @param driver
	 * @param alertsDisplayed
	 */
	public static void checkTriggeredGeoFenceAlerts(WebDriver driver,int alertsDisplayed)
	{

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceAlerts.totalAlerts(driver));
		Utils.sleep(driver, 2000);

		mapsLogo=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'option map')]/span[text()='View Map']", "map logo", "my car zone");
		alerts=mapsLogo.size();

		if(alerts==alertsDisplayed)
		{
			Log.info("equal alerts displayed");
		}
		else
		{
			Log.info("alerts not matched");
		}



		checkDropDownValues(driver);

	}




	/**
	 * To verify valet alerts
	 * @param driver
	 * @return No of alerts present 
	 */
	public static int valetAlerts(WebDriver driver) {

		ActionModule.click(driver,MyCarZonePage.ValetAlerts.valetLink(driver), "valetLink", "MyCarZone Page");

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.ValetAlerts.totalAlerts(driver));

		if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.noAlert(driver)))
		{
			Log.info("No valet alerts found on My car page");
			throw new SkipException("No valet alerts found on My car page");

		}

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.manageButton(driver));
		String totalAlerts=ActionModule.getText(driver,MyCarZonePage.ValetAlerts.totalAlerts(driver), "totalAlerts", "MyCarZone Page").substring(0,3).replaceAll("[a-zA-Z]", "").trim();

		int alertsDisplayed=Integer.parseInt(totalAlerts);


		if(alertsDisplayed>5)
		{
			Log.info("More than 5 alerts found");
			Utils.scrolDownForElement(driver, MyCarZonePage.loadMore(driver));
			ActionModule.click(driver,  MyCarZonePage.loadMore(driver), "loadMore", "loadMore");

		}

		else
		{
			Log.info("Alerts are less than or equal to 5");
		}


		return alertsDisplayed;
	}

	/**
	 * To check whether the Valet alert is triggered or not
	 * @param driver
	 * @param alertsDisplayed
	 */
	public static void checkTriggeredValetAlerts(WebDriver driver, int alertsDisplayed) {


		Utils.waitForElementToBeClickable(driver, MyCarZonePage.ValetAlerts.valetLink(driver));
		Utils.sleep(driver, 2000);

		mapsLogo=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'option map')]/span[text()='View Map']", "map logo", "my car zone");
		alerts=mapsLogo.size();

		if(alerts==alertsDisplayed)
		{
			Log.info("equal alerts displayed");
		}
		else
		{
			Log.info("alerts not matched");
		}


		checkDropDownValues(driver);

	}



	/**
	 * To modify/edit geofence Alerts
	 * @param driver
	 */
	public static void modifyCurfewAlert(WebDriver driver) {



		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.settingsLink(driver), "settingsLink", "MyCarZone Page");

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.CurfewSettings.curfewBoxTitle(driver));

		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.curfewSettingsLink(driver), "curfewSettingsLink", "MyCarZone Page");


		String status=ActionModule.getText(driver,MyCarZonePage.CurfewSettings.buttonOffOn(driver), "buttonOffOn", "MyCarZone Page");


		//Clicking toggle for alert
		ActionModule.click(driver,MyCarZonePage.CurfewSettings.toggle(driver), "buttonOff", "MyCarZone Page");



		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequest(driver), "submitRequest", "MyCarZone Page");

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver, MyCarZonePage.requestIsInProgress(driver));

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.CurfewSettings.curfewBoxTitle(driver));

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.CurfewSettings.deleteCurfew(driver));

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.CurfewSettings.toggle(driver));

		Utils.sleep(driver, 5000);

		String statusChanged=ActionModule.getText(driver,MyCarZonePage.CurfewSettings.buttonOffOn(driver), "buttonOffOn", "MyCarZone Page");

		if(!statusChanged.contains(status))
		{
			Log.info("toggle turned "+statusChanged);
		}
		else
		{
			Log.error("toggle status could not be changed.");

		}

		//To make the toggle ON if it got turned off.
		if(statusChanged.contains("OFF"))
		{
			ActionModule.click(driver,MyCarZonePage.CurfewSettings.toggle(driver), "buttonOn", "MyCarZone Page");

			ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequest(driver), "submitRequest", "MyCarZone Page");

			Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

			Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

			Utils.waitForElementToBeVisible(driver, MyCarZonePage.CurfewSettings.curfewBoxTitle(driver));

			Utils.waitForElementToBeClickable(driver, MyCarZonePage.CurfewSettings.deleteCurfew(driver));

			Utils.sleep(driver, 3000);
			statusChanged=ActionModule.getText(driver,MyCarZonePage.CurfewSettings.buttonOffOn(driver), "buttonOffOn", "MyCarZone Page");

			if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.serviceError(driver)))
			{
				Log.error("Service Error found.Not able to submit request");
				Assert.fail("Service Error found.Not able to submit request");
			}

			if(statusChanged.contains("ON"))
			{
				Log.info("toggle turned ON");
			}
			else
			{
				Log.error("toggle status could not be changed.Please see the screenshots");
				Assert.fail("toggle status could not be changed.Please see the screenshots");

			}
		}


		else
		{
			Log.info("toggle is already ON");
		}


		//capture first setting
		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		int alertSetting=totalSettings.size();

		//Modifying alert settings
		if(alertSetting >= 1)
		{
			Log.info("More than 0 alerts found");
			modifyFirstAlert(driver,1);


		}

		//Adding alert settings
		else
		{
			Log.info("No alerts found");

			ActionModule.click(driver, MyCarZonePage.CurfewSettings.addNewCurfewLink(driver), "addNewCurfewLink", "MyCarZonePage");
			modifyFirstAlert(driver,1);

			if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.serviceError(driver)))
			{
				Log.error("Service Error found.Not able to submit request");
				Assert.fail("Service Error found.Not able to submit request");
			}

			if(Utils.waitForElementToBeClickable(driver, MyCarZonePage.CurfewSettings.expandCollapseArrow(driver)))
			{
				ActionModule.click(driver, MyCarZonePage.CurfewSettings.expandCollapseArrow(driver), "", "");

				String name=MyCarZonePage.CurfewSettings.curfewBoxTitle(driver).getText();
				Log.info("name is:"+name);
			}
		}



	}

	/**
	 * To Modify alert 
	 * @param driver
	 * @param value
	 */

	public static void modifyFirstAlert(WebDriver driver,int value)
	{

		ActionModule.click(driver,MyCarZonePage.CurfewSettings.expandCollapseArrow(driver), "expandCollapseArrow", "MyCarZone Page");

		//To reuse the code in add/Delete alert as disable days check is not required in that.
		if(value==1)
		{
			ActionModule.sendKeys(driver, MyCarZonePage.CurfewSettings.curfewBoxTitle(driver), "Curfew 123!@#$", "title", "My Car zone");

			ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequest(driver), "submitRequest", "MyCarZone Page");

			ActionModule.isDisplayed(driver,MyCarZonePage.errorWrongFormat(driver), "expandCollapseArrow", "MyCarZone Page");

			disableDays(driver,"//li[@class='config-list-item ng-scope selected']//day-picker[not(contains(@class,'hidden'))]//ul[@class='day-picker-list']/li");

			ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequest(driver), "submitRequest", "MyCarZone Page");

			ActionModule.isDisplayed(driver,MyCarZonePage.selectDaysError(driver), "selectDaysError", "MyCarZone Page");
		}

		ActionModule.sendKeys(driver, MyCarZonePage.CurfewSettings.curfewBoxTitle(driver), "Curfew123", "title", "My Car zone");

		//From Time
		ActionModule.click(driver, MyCarZonePage.CurfewSettings.fromHours(driver), "fromHours", "");

		//Choosing a random time 
		int i=chooseRandom(driver,1,12);
		Utils.sleep(driver, 2000);
		Log.info("from hour selected is:"+i);
		ActionModule.click(driver, MyCarZonePage.CurfewSettings.fromHourPick(driver, i), "fromHourPick", "");

		Utils.sleep(driver, 2000);

		ActionModule.click(driver, MyCarZonePage.CurfewSettings.fromMinutes(driver), "fromMinutes", "");



		Utils.sleep(driver, 3000);

		i=chooseRandom(driver,1,6); 
		Log.info("from in selected is:"+i);

		ActionModule.click(driver, MyCarZonePage.CurfewSettings.fromMinutePick(driver,i), "fromMinutePick", "");
		Utils.sleep(driver, 2000);

		ActionModule.click(driver, MyCarZonePage.CurfewSettings.timeAMFrom(driver), "timeAMFrom", "");

		//To Time
		ActionModule.click(driver, MyCarZonePage.CurfewSettings.toHours(driver), "toHours", "");


		i=chooseRandom(driver,1,12);
		Utils.sleep(driver, 2000);


		ActionModule.click(driver, MyCarZonePage.CurfewSettings.toHourPick(driver, i), "toHourPick", "");

		ActionModule.click(driver, MyCarZonePage.CurfewSettings.toMinutes(driver), "toMinutes", "");

		i=chooseRandom(driver,1,6); 
		Utils.sleep(driver, 2000);
		Log.info(" selected is:"+ i);
		ActionModule.click(driver, MyCarZonePage.CurfewSettings.toMinutePick(driver,i), "toMinutePick", "");

		ActionModule.click(driver, MyCarZonePage.CurfewSettings.timeAMTo(driver), "timeAMTo", "");



		days=FindWebElement.findElementListByXpath(driver, "//li[@class='config-list-item ng-scope selected']//day-picker[not(contains(@class,'hidden'))]//ul[@class='day-picker-list']/li", "map logo", "my car zone");

		WebElement element;
		for( i=1;i<days.size();i++ )
		{
			ActionModule.click(driver,days.get(0), "days", "MyCarZone Page");
			int count=chooseRandom(driver,0,2);
			element=days.get(i);

			if(count==0)
			{
				ActionModule.click(driver,element, "days", "MyCarZone Page");
			}
		}

		element =days.get(1);
		if(element.getAttribute("class").contains("selected"))
		{
			Log.info("atleast one day is enabled");
		}
		else
		{
			ActionModule.click(driver,element, "days", "MyCarZone Page");
		}



		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequest(driver), "submitRequest", "MyCarZone Page");

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.CurfewSettings.curfewBoxTitle(driver));
	}


	/**
	 * To Add and delete curfew alert
	 * @param driver
	 */
	public static void addDeleteCurfew(WebDriver driver)
	{

		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.settingsLink(driver), "settingsLink", "MyCarZone Page");

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.CurfewSettings.curfewBoxTitle(driver));


		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.curfewSettingsLink(driver), "curfewSettingsLink", "MyCarZone Page");


		String status=ActionModule.getText(driver,MyCarZonePage.CurfewSettings.buttonOffOn(driver), "buttonOffOn", "MyCarZone Page");


		if(status.contains("OFF"))
		{
			ActionModule.click(driver,MyCarZonePage.CurfewSettings.toggle(driver), "buttonOn", "MyCarZone Page");

			ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequest(driver), "submitRequest", "MyCarZone Page");

			Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

			Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

			Utils.waitForElementToBeVisible(driver, MyCarZonePage.CurfewSettings.curfewBoxTitle(driver));

			Utils.waitForElementToBeClickable(driver, MyCarZonePage.CurfewSettings.deleteCurfew(driver));

			Utils.sleep(driver, 3000);
			status=ActionModule.getText(driver,MyCarZonePage.CurfewSettings.buttonOffOn(driver), "buttonOffOn", "MyCarZone Page");

			if(status.contains("ON"))
			{
				Log.info("toggle turned ON");
			}
			else
			{
				Log.error("toggle status could not be changed.Please see the screenshots");
				Assert.fail("toggle status could not be changed.Please see the screenshots");

			}
		}



		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		int alertSetting=totalSettings.size();

		//Modifying alert settings
		if(alertSetting >= 3)
		{
			Log.info("More than 3 alerts found");
			ConfirmdeleteAlert(driver,alertSetting);




		}
		Utils.waitForElementToBeVisible(driver, MyCarZonePage.CurfewSettings.curfewBoxTitle(driver));

		ActionModule.click(driver,MyCarZonePage.CurfewSettings.addNewCurfewLink(driver), "settingsLink", "MyCarZone Page");
		modifyFirstAlert(driver,0);
		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		alertSetting=totalSettings.size();

		CanceldeleteAlert(driver,alertSetting);

		ConfirmdeleteAlert(driver,alertSetting);



	}



	/**
	 * To confirm the last delete command and delete the alert.
	 * @param driver
	 * @param alertSetting
	 */
	private static void ConfirmdeleteAlert(WebDriver driver,int alertSetting) {

		ActionModule.click(driver,MyCarZonePage.CurfewSettings.curfewDelete(driver), "curfewDelete", "MyCarZone Page");
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, MyCarZonePage.CurfewSettings.confirmCurfew(driver));
		ActionModule.click(driver,MyCarZonePage.CurfewSettings.confirmCurfew(driver), "confirmCurfew", "MyCarZone Page");

		Utils.waitForElementToBeClickable(driver,MyCarZonePage.CurfewSettings.curfewDelete(driver));

		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		int newAlertSetting=totalSettings.size();

		if(newAlertSetting!=alertSetting)
		{
			Log.info("alert setting deleted successfully");
		}

		else
		{
			Log.error("alert setting could not be dleted");
			Assert.fail("alert setting could not be dleted");
		}

	}


	/**
	 * To cancel the last delete command and make sure the alert will not get deleted.
	 * @param driver
	 * @param alertSetting
	 */
	private static void CanceldeleteAlert(WebDriver driver,int alertSetting) {

		ActionModule.click(driver,MyCarZonePage.CurfewSettings.curfewDelete(driver), "curfewDelete", "MyCarZone Page");
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, MyCarZonePage.CurfewSettings.confirmCurfew(driver));
		ActionModule.click(driver,MyCarZonePage.CurfewSettings.cancelCurfew(driver), "cancelCurfew", "MyCarZone Page");

		Utils.waitForElementToBeClickable(driver,MyCarZonePage.CurfewSettings.curfewDelete(driver));

		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		int newAlertSetting=totalSettings.size();

		if(newAlertSetting == alertSetting)
		{
			Log.info("alert setting not deleted ");
		}

		else
		{
			Log.error("alert setting  deleted");
			Assert.fail("alert setting deleted");
		}

	}


	/**
	 * 
	 * @param driver
	 * @param xpath
	 * Module to disable all days in schedule 
	 */
	public static void disableDays(WebDriver driver,String xpath)
	{

		Utils.sleep(driver, 3000);
		List<WebElement> webElements= null;
		webElements=FindWebElement.findElementListByXpath(driver, xpath, "weekDays", "charging schedule");
		for(int i =0;i < webElements.size();i++)
		{
			if(webElements.get(i).getAttribute("class").contains("selected"))
			{
				Utils.sleep(driver, 1000);
				webElements.get(i).click();
			}
			else
			{
				Log.info("Day is already deselected");
			}
		}

	}

	/**
	 * Choose a random no from a given range
	 * @param driver
	 * @param minimum
	 * @param maximum
	 * @return
	 */
	public static int chooseRandom(WebDriver driver,int minimum,int maximum)
	{
		int diff=maximum-minimum;
		Random rn = new Random();
		int i = rn.nextInt(diff+1);
		i+=minimum;
		return i;
	}


	/**
	 * To modify speed alert
	 * @param driver
	 */
	public static void modifySpeedAlert(WebDriver driver)
	{

		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.settingsLink(driver), "settingsLink", "MyCarZone Page");

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.SettingsAlerts.speedSettingsLink(driver));

		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.speedSettingsLink(driver), "curfewSettingsLink", "MyCarZone Page");


		String status=ActionModule.getText(driver,MyCarZonePage.SpeedSettings.buttonOffText(driver), "buttonOffOn", "MyCarZone Page");

		Utils.sleep(driver, 3000);

		ActionModule.click(driver,MyCarZonePage.SpeedSettings.buttonONOFF(driver), "buttonOff", "MyCarZone Page");


		Utils.waitForElementToBeClickable(driver, MyCarZonePage.SettingsAlerts.submitRequest(driver));
		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequest(driver), "submitRequest", "MyCarZone Page");

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver, MyCarZonePage.requestIsInProgress(driver));

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.SpeedSettings.speedSlider(driver));

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.SpeedSettings.speedPlus(driver));

		Utils.sleep(driver, 5000);

		String statusChanged=ActionModule.getText(driver,MyCarZonePage.SpeedSettings.buttonOffText(driver), "buttonOffOn", "MyCarZone Page");

		if(!statusChanged.contains(status))
		{
			Log.info("toggle turned "+statusChanged);
		}
		else
		{
			Log.error("toggle status could not be changed.");

		}

		if(statusChanged.contains("OFF"))
		{
			ActionModule.click(driver,MyCarZonePage.SpeedSettings.buttonONOFF(driver), "buttonOn", "MyCarZone Page");

			//to make the submit button clickable
			ActionModule.click(driver,MyCarZonePage.SpeedSettings.speedMinus(driver), "speedMinus", "MyCarZone Page");

			ActionModule.click(driver,MyCarZonePage.SpeedSettings.speedPlus(driver), "speedPlus", "MyCarZone Page");

			//click submit request
			ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequest(driver), "submitRequest", "MyCarZone Page");

			Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

			Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

			Utils.waitForElementToBeVisible(driver, MyCarZonePage.SpeedSettings.speedSlider(driver));

			Utils.waitForElementToBeClickable(driver, MyCarZonePage.SpeedSettings.speedPlus(driver));

			Utils.sleep(driver, 5000);

			statusChanged=ActionModule.getText(driver,MyCarZonePage.SpeedSettings.buttonOffText(driver), "buttonOffOn", "MyCarZone Page");

			if(statusChanged.contains("ON"))
			{
				Log.info("toggle turned ON");
			}
			else
			{
				Log.error("toggle status could not be changed.Please see the screenshots");
				Assert.fail("toggle status could not be changed.Please see the screenshots");

			}
		}


		else
		{
			Log.info("toggle is already ON");
		}



		String speed=ActionModule.getText(driver, MyCarZonePage.SpeedSettings.speedValue(driver), "speedValue", "MyCarZonePage").trim();
		Log.info("speed value is :"+speed);
		speedCaptured=Integer.parseInt(speed);

		String alertInterval=ActionModule.getText(driver, MyCarZonePage.SpeedSettings.alertSpeedDropDown(driver), "alertSpeedDropDown", "MyCarZonePage");
		Log.info("speed value is :"+alertInterval);

		int i=chooseRandom(driver,1,6);
		Log.info("alert value choosen is :"+i);


		ActionModule.click(driver,MyCarZonePage.SpeedSettings.alertSpeedDropDown(driver), "alert drop down", "MyCarZone Page");
		ActionModule.click(driver,MyCarZonePage.SpeedSettings.alertSpeedDropDownValue(driver, i), "alert drop down", "MyCarZone Page");


		if(speedCaptured >=45 || speedCaptured <=85)
		{
			Log.info("speed is in between 45-85");
		}
		else
		{
			Log.error("speed does not lie betwen 45-85");
		}
		i=chooseRandom(driver,45,85);
		Log.info("speed value choosen is :"+i);

		//Changing speed value based on the random value generated
		while(speedCaptured!=i)
		{
			speed=ActionModule.getText(driver, MyCarZonePage.SpeedSettings.speedValue(driver), "speedValue", "MyCarZonePage");
			speedCaptured=Integer.parseInt(speed);

			if(speedCaptured>i)
			{
				speed=ActionModule.getText(driver, MyCarZonePage.SpeedSettings.speedValue(driver), "speedValue", "speedValue");
				speedCaptured=Integer.parseInt(speed);

				ActionModule.click(driver,MyCarZonePage.SpeedSettings.speedMinus(driver), "speedMinus", "MyCarZone Page");
			}

			else if(speedCaptured<i)
			{
				speed=ActionModule.getText(driver, MyCarZonePage.SpeedSettings.speedValue(driver), "speedValue", "MyCarZonePage");
				speedCaptured=Integer.parseInt(speed);

				ActionModule.click(driver,MyCarZonePage.SpeedSettings.speedPlus(driver), "speedPlus", "MyCarZone Page");
			}
			else
			{
				Log.info("speed value is :"+speedCaptured);
			}

			if(speedCaptured==i)
			{
				Log.info("speeed matched");
				break;

			}


		}

		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequest(driver), "submitRequest", "MyCarZone Page");
		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.SpeedSettings.speedPlus(driver));

		speed=ActionModule.getText(driver, MyCarZonePage.SpeedSettings.speedValue(driver), "", "");
		speedCaptured=Integer.parseInt(speed);
		Log.info("speed value is :"+speedCaptured);

		if(speedCaptured==i)
		{
			Log.info("speed alert modified successfully");
		}
		else
		{
			Log.error("speed alert could not be modified.");
			Assert.fail("speed alert could not be modified.");
		}


	}




	/**
	 * To modify Geo fence alert 
	 * @param driver
	 */
	public static void modifyGeoFenceAlert(WebDriver driver) {


		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.settingsLink(driver), "settingsLink", "MyCarZone Page");

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.GeoFenceSettings.geoHeading(driver));

		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.geofenceSettingsLink(driver), "curfewSettingsLink", "MyCarZone Page");


		Utils.sleep(driver, 5000);

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver));

		Utils.waitForElementToBeInvisible(driver, MyCarZonePage.requestIsInProgress(driver));

		String status=ActionModule.getText(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFFText(driver), "buttonOffOn", "MyCarZone Page");


		ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver), "buttonOff", "MyCarZone Page");


		submitLoaderwait(driver);

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.onExit(driver));


		Utils.sleep(driver, 5000);

		String statusChanged=ActionModule.getText(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFFText(driver), "buttonOffOn", "MyCarZone Page");

		if(!statusChanged.contains(status))
		{
			Log.info("toggle turned "+statusChanged);
		}
		else
		{
			Log.error("toggle status could not be changed.");

		}

		if(statusChanged.contains("OFF"))
		{
			Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver));

			Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver));

			ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver), "buttonOn", "MyCarZone Page");

			submitLoaderwait(driver);

			statusChanged=ActionModule.getText(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver), "buttonOffOn", "MyCarZone Page");

			if(statusChanged.contains("ON"))
			{
				Log.info("toggle turned ON");
			}
			else
			{
				Log.error("toggle status could not be changed.Please see the screenshots");
				Assert.fail("toggle status could not be changed.Please see the screenshots");

			}
		}


		else
		{
			Log.info("toggle is already ON");
		}





	}




	public static void captureAlerts(WebDriver driver,String location)
	{
		//capture first setting
		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		int alertSetting=totalSettings.size();

		//Modifying alert settings
		if(alertSetting >= 1)
		{
			Log.info("More than 0 alerts found");
			ActionModule.click(driver, MyCarZonePage.GeoFenceSettings.expandCollapseArrow(driver), "expandCollapseArrow", "MyCarZonePage");
			modifyFirstGeoFenceAlert(driver,1,location);
			if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.serviceError(driver)))
			{
				Log.error("Service Error found.Not able to submit request");
				Assert.fail("Service Error found.Not able to submit request");
			}

		}

		//Adding alert settings
		else
		{
			Log.info("No alerts found");

			ActionModule.click(driver, MyCarZonePage.GeoFenceSettings.addNewGeoFence(driver), "addNewCurfewLink", "MyCarZonePage");
			Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.geoFenceBoxTitle(driver));
			modifyFirstGeoFenceAlert(driver,1,location);

			if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.serviceError(driver)))
			{
				Log.error("Service Error found.Not able to submit request");
				Assert.fail("Service Error found.Not able to submit request");
			}


		}
		if(count==1)
		{
			ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onExit(driver), "onExit", "MyCarZone Page");
		}

	}
	private static void modifyFirstGeoFenceAlert(WebDriver driver, int value,String Location)
	{

		Utils.sleep(driver, 3000);
		count=count+1;

		if(value==1)
		{

			if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.GeoFenceSettings.circle(driver)))
			{
				Log.info("Alerts is already expanded");
			}
			else
			{
				ActionModule.click(driver, MyCarZonePage.GeoFenceSettings.expandCollapseArrow(driver), "expandCollapseArrow", "MyCarZonePage");
			}

			ActionModule.sendKeys(driver, MyCarZonePage.GeoFenceSettings.geoFenceBoxTitle(driver), "GeoFence 123!@#$", "title", "My Car zone");


			//To check whether it is running for On-entry or On-Exit
			if(count==1)
			{
				ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onEntry(driver), "onEntry", "MyCarZone Page");
			}
			else
			{
				ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onExit(driver), "onExit", "MyCarZone Page");


			}

			Utils.sleep(driver, 5000);


			//To check wrong format for alert name
			Utils.waitForElementToBeClickable(driver, MyCarZonePage.SettingsAlerts.submitRequestGeoFence(driver));
			ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequestGeoFence(driver), "submitRequest", "MyCarZone Page");

			Utils.sleep(driver, 3000);
			ActionModule.isDisplayed(driver,MyCarZonePage.errorWrongFormat(driver), "errorWrongFormat", "MyCarZone Page");


		}


		ActionModule.sendKeys(driver, MyCarZonePage.GeoFenceSettings.geoFenceBoxTitle(driver), "GeoFence123", "title", "My Car zone");

		//To check whether it is running for On-entry or On-Exit
		if(count==1)
		{
			ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onEntry(driver), "onEntry", "MyCarZone Page");
		}
		else
		{
			ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onExit(driver), "onExit", "MyCarZone Page");


		}

		//Changing location icon.If circle it will change to square and vice versa.
		if(MyCarZonePage.GeoFenceSettings.rectangle(driver).getAttribute("class").contains("selected"))
		{

			ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.circle(driver), "circle", "MyCarZone Page");

		}

		else
		{
			ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.rectangle(driver), "rectangle", "MyCarZone Page");

		}


		ActionModule.sendKeys(driver, MyCarZonePage.GeoFenceSettings.locationTextBox(driver), Location, "locationTextBox", "My Car zone");

		if(Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.locationOption(driver)))
		{

			ActionModule.click(driver, MyCarZonePage.GeoFenceSettings.locationOption(driver), "locationOption", "MyCarZonePage");

		}

		//Clicking submit request and wait for the command to process
		submitLoaderwait(driver);



	}

	public static void addDeleteGeoFenceSetting(WebDriver driver)
	{

		int alertSettingNew = 0;

		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.settingsLink(driver), "settingsLink", "MyCarZone Page");

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.GeoFenceSettings.geoHeading(driver));

		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.geofenceSettingsLink(driver), "curfewSettingsLink", "MyCarZone Page");


		Utils.sleep(driver, 5000);


		String status=ActionModule.getText(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFFText(driver), "buttonOffOn", "MyCarZone Page");


		if(status.contains("OFF"))
		{
			Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver));

			ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver), "buttonOn", "MyCarZone Page");

			submitLoaderwait(driver);

			status=ActionModule.getText(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver), "buttonOffOn", "MyCarZone Page");

			if(status.contains("ON"))
			{
				Log.info("toggle turned ON");
			}
			else
			{
				Log.error("toggle status could not be changed.Please see the screenshots");
				Assert.fail("toggle status could not be changed.Please see the screenshots");

			}
		}


		else
		{
			Log.info("toggle is already ON");
		}



		//capture alert setting
		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		int alertSetting=totalSettings.size();


		if(alertSetting==5)		
		{
			ActionModule.click(driver, MyCarZonePage.GeoFenceSettings.deleteFirst(driver), "deleteFirst", "MyCarZonePage");
			Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.confirmDelete(driver));
			ActionModule.click(driver, MyCarZonePage.GeoFenceSettings.confirmDelete(driver), "deleteFirst", "MyCarZonePage");


			Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.addNewGeoFence(driver));
			totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
			alertSettingNew=totalSettings.size();
			if(alertSettingNew==(alertSetting-1))
			{
				Log.info("alerts deleted");
				alertSetting=alertSettingNew;
			}
			else
			{
				Log.error("Alerts could not be deleted");
				Assert.fail("Alerts could not be deleted");
			}

		}

		//adding new alerts On Entry

		ActionModule.click(driver, MyCarZonePage.GeoFenceSettings.addNewGeoFence(driver), "addNewCurfewLink", "MyCarZonePage");

		Utils.sleep(driver, 4000);
		submitLoaderwait(driver);
		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		alertSettingNew=totalSettings.size();
		if(alertSettingNew==(alertSetting+1))
		{
			Log.info("alerts added");
			alertSetting=alertSettingNew;
		}
		else
		{
			Log.error("Alerts could not be added");
			Assert.fail("Alerts could not be added");
		}


		Utils.sleep(driver, 3000);
		if(Utils.waitForElementToBeVisible(driver, MyCarZonePage.serviceError(driver)))
		{
			Log.error("Service Error found.Not able to submit request");
			Assert.fail("Service Error found.Not able to submit request");
		}



		ActionModule.click(driver, MyCarZonePage.GeoFenceSettings.expandCollapseArrow(driver), "expandCollapseArrow", "MyCarZonePage");

		ActionModule.sendKeys(driver, MyCarZonePage.GeoFenceSettings.geoFenceBoxTitle(driver), "New Geo Fence On-Entry", "title", "My Car zone");

		ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onEntry(driver), "onEntry", "MyCarZone Page");

		submitLoaderwait(driver);

		//deleting cancel on entry

		List <WebElement> delete=null;
		delete=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-click,'openDeleteModal')]", "total alertsetting", "");
		WebElement element=delete.get(alertSettingNew-1);
		ActionModule.click(driver,element, "submitRequest", "MyCarZone Page");

		cancelDeleteGeoFenceAlerts(driver, alertSetting);


		delete=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-click,'openDeleteModal')]", "total alertsetting", "");
		element=delete.get(alertSettingNew-1);
		ActionModule.click(driver,element, "submitRequest", "MyCarZone Page");


		confirmDeleteGeoFenceAlerts(driver, alertSetting);

		//adding on exit

		ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onExit(driver), "onExit", "MyCarZone Page");

		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		alertSettingNew=totalSettings.size();
		if(alertSettingNew==0)
		{
			Log.info("No geofence alert setting for on exit");
			//adding new setting


		}
		else
		{
			delete=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-click,'openDeleteModal')]", "total alertsetting", "");

			element=delete.get(alertSettingNew-1);
			ActionModule.click(driver,element, "submitRequest", "MyCarZone Page");

			confirmDeleteGeoFenceAlerts(driver, alertSetting);

		}




		ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onExit(driver), "onExit", "MyCarZone Page");

		Utils.sleep(driver, 3000);

		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		alertSetting=totalSettings.size();

		//adding new alert
		ActionModule.click(driver, MyCarZonePage.GeoFenceSettings.addNewGeoFence(driver), "addNewCurfewLink", "MyCarZonePage");

		ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onExit(driver), "onExit", "MyCarZone Page");
		Utils.sleep(driver, 4000);
		submitLoaderwait(driver);
		
		ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.onExit(driver), "onExit", "MyCarZone Page");
		Utils.sleep(driver, 3000);
		
		totalSettings=FindWebElement.findElementListByXpath(driver, "//li//*[@class='title-input']", "total alertsetting", "");
		alertSettingNew=totalSettings.size();
		if(alertSettingNew==(alertSetting+1))
		{
			Log.info("alerts added");
			//alertSetting=alertSettingNew;
		}
		else
		{
			Log.error("Alerts could not be added");
			Assert.fail("Alerts could not be added");
		}



	}


	/**
	 * Clicking Submit request and wait for the command to process
	 * @param driver
	 */
	public static void submitLoaderwait(WebDriver driver)
	{

		Utils.sleep(driver, 3000);

		ActionModule.click(driver,MyCarZonePage.SettingsAlerts.submitRequestGeoFence(driver), "submitRequest", "MyCarZone Page");

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver,MyCarZonePage.requestPending(driver));

		Utils.waitForElementToBeInvisible(driver, MyCarZonePage.requestIsInProgress(driver));

		Utils.waitForElementToBeVisible(driver, MyCarZonePage.GeoFenceSettings.onEntry(driver));

		Utils.waitForElementToBeClickable(driver, MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver));
	}



	public static void cancelDeleteGeoFenceAlerts(WebDriver driver,int alertSetting)
	{
		Utils.sleep(driver, 3000);

		ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.cancelDelete(driver), "cancelCurfew", "MyCarZone Page");

		Utils.waitForElementToBeClickable(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver));

		totalSettings=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-click,'openDeleteModal')]", "total alertsetting", "");
		int newAlertSetting=totalSettings.size();

		if(newAlertSetting == alertSetting)
		{
			Log.info("alert setting not deleted ");
		}

		else
		{
			Log.error("alert setting  could not be deleted");
			Assert.fail("alert setting  could not be deleted");
		}

	}

	public static void confirmDeleteGeoFenceAlerts(WebDriver driver,int alertSetting)
	{
		Utils.sleep(driver, 3000);

		ActionModule.click(driver,MyCarZonePage.GeoFenceSettings.confirmDelete(driver), "cancelCurfew", "MyCarZone Page");

		Utils.waitForElementToBeClickable(driver,MyCarZonePage.GeoFenceSettings.geoButtonOnOFF(driver));

		submitLoaderwait(driver);

		totalSettings=FindWebElement.findElementListByXpath(driver, "//*[contains(@ng-click,'openDeleteModal')]", "total alertsetting", "");
		int newAlertSetting=totalSettings.size();

		if(newAlertSetting != alertSetting)
		{
			Log.info("alert setting  deleted ");
		}

		else
		{
			Log.error("alert setting  deleted");
			Assert.fail("alert setting  deleted");
		}

	}

}
