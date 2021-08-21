package com.rsi.kma.automation.modules;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;

import com.rsi.kma.automation.pageObjects.MyPOIsPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.pageObjects.Common.MyVehiclesPage;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Utils;

public class MyPoiModule {

	private static Logger    Log = Logger.getLogger(MyPoiModule.class.getName());
	static List <WebElement> pois=null;

	static String[] zipcode = new String[] {"92606", "92120"};

	static String[] city = new String[] {"Irvine", "silicon valley","Los angeles"};

	static String[] state = new String[] {"atlanta", "austin","irvine","Cape Coral"};

	public static void NavigateToPOipage(WebDriver driver)
	{

		OverviewModule.NavigateToOverviewPage(driver);
		Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.myPOILink(driver));
		ActionModule.click(driver,MyCarLeftMenu.myPOILink(driver), "myPOILink", "Overview page");
		Utils.waitForElementToBeClickable(driver,MyPOIsPage.addPOI(driver));
		Log.info("Succesfully navigated to My Pois Page");

	}


	public static void checkPOI(WebDriver driver)
	{


		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));

		String pois=ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage");
		Log.info("Total POis are:"+pois);
	}


	public static void addPoi(WebDriver driver)
	{
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));
		int pois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+pois);

		if(pois<25)
		{
			Log.info("Pois are less than 25");	
			int ToBeadded=25-pois;
			addPOIbefore(driver,ToBeadded);

		}

		pois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+pois);

		if(pois==25)
		{
			Log.info("25 pois added");
			ActionModule.click(driver, MyPOIsPage.addPOI(driver), "addPOI", "MyPOIsPage");
			Utils.waitForElementToBeClickable(driver, MyPOIsPage.myPOIOnlySupports25POIs(driver));

			ActionModule.isDisplayed(driver, MyPOIsPage.myPOIOnlySupports25POIs(driver), "myPOIOnlySupports25POIs", "MyPOIsPage");
			ActionModule.click(driver, MyPOIsPage.myPOIOnlySupports25POIsOKButton(driver), "myPOIOnlySupports25POIsOKButton", "MyPOIsPage");


		}
	}



	public static void addPOIbefore(WebDriver driver,int ToBeAdded)
	{
		for(int i=0;i<ToBeAdded-1;i++)
		{

			Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));



			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
			Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));
			ActionModule.click(driver, MyPOIsPage.addPOI(driver), "addPOI", "MyPOIsPage");

			Utils.sleep(driver, 8000);

			Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));
			Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[@class='title' and contains(text(),'ADD POI')]"));
			Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//*[contains(@class,'mypoi-search text-box')]"));
			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.searchTextField(driver), "92606", "searchTextField", "MyPOIsPage");

			Utils.sleep(driver, 5000);


			Utils.waitForElementToBeClickable(driver, MyPOIsPage.AddPOIs.search(driver));
			ActionModule.click(driver, MyPOIsPage.AddPOIs.search(driver), "search", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.addButton(driver), "addButton", "MyPOIsPage");

			Utils.waitForElementToBeClickable(driver,MyPOIsPage.AddPOIs.done(driver));

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "POIs_Close_Button", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));

			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));

		}
	}


	public static void deletePoi(WebDriver driver)
	{
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
		Utils.sleep(driver, 6000);

		Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));

		int noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);

		if(noOfPois<3)
		{
			addPOIbefore(driver,3);
		}

		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));

		Utils.sleep(driver, 4000);

		noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);



		Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));

		if(noOfPois>2)
		{
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
			ActionModule.click(driver,  MyPOIsPage.manage(driver), "manage", "MyPOIsPage");

			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//div[contains(@class,'poi-row')]//div[contains(@class,'poi-selected-container')]/label"));
			pois=FindWebElement.findElementListByXpath(driver, "//div[contains(@class,'poi-row')]//div[contains(@class,'poi-selected-container')]/label", "radio button", "");


			ActionModule.click(driver, pois.get(0), "first poi", "Poi page");
			ActionModule.click(driver, pois.get(1), "first poi", "Poi page");

			Utils.sleep(driver, 3000);
			ActionModule.click(driver, MyPOIsPage.Manage.deleteSelectedButton(driver), "deleteSelectedButton", "Poi page");

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.Manage.cancelButton(driver));

			ActionModule.click(driver, MyPOIsPage.Manage.cancelButton(driver), "cancelButton", "Poi page");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.Manage.deleteSelectedButton(driver), "deleteSelectedButton", "Poi page");

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.Manage.cancelButton(driver));

			ActionModule.click(driver, MyPOIsPage.Manage.confirmButton(driver), "deleteSelectedButton", "Poi page");

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));
			Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));
			Utils.sleep(driver, 3000);
			int afterDelete=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
			Log.info("Total POis after delete:"+afterDelete);

			if(afterDelete!=noOfPois)
			{
				Log.info("Deleted successfully");
			}
			else
			{
				Log.error("pOis could not be deleted");
				Assert.fail("pOis could not be deleted");
			}
		}

		else
		{
			Log.error("Not enough pois to delete");
			throw new SkipException("Not enough pois to delete");
		}


	}


	public static void deleteALLPoi(WebDriver driver)
	{

		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));
		Utils.sleep(driver, 4000);

		int noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);

		if(noOfPois<3)
		{
			addPOIbefore(driver,3);
		}

		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));

		Utils.sleep(driver, 4000);

		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));

		noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);
		if(noOfPois>2)
		{

			deleteAll(driver);
			int afterDelete=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
			Log.info("Total POis after delete:"+afterDelete);

			if(afterDelete==0)
			{
				Log.info("Deleted successfully");
			}
			else
			{
				Log.error("pOis could not be deleted");
				Assert.fail("pOis could not be deleted");
			}
		}


		else
		{
			Log.error("Not enough pois to delete");
			throw new SkipException("Not enough pois to delete");
		}
	}

	/**
	 * Delete all POis 
	 * @param driver
	 */
	public static void deleteAll(WebDriver driver)
	{
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));

		ActionModule.click(driver,  MyPOIsPage.manage(driver), "manage", "MyPOIsPage");

		Utils.waitForElementToBeClickable(driver, MyPOIsPage.Manage.deleteSelectedButton(driver));

		ActionModule.click(driver, MyPOIsPage.Manage.deletAllButton(driver), "deleteSelectedButton", "Poi page");

		Utils.waitForElementToBeClickable(driver, MyPOIsPage.Manage.deletAllCancelButton(driver));

		ActionModule.click(driver, MyPOIsPage.Manage.deletAllCancelButton(driver), "cancelButton", "Poi page");

		ActionModule.click(driver, MyPOIsPage.Manage.deletAllButton(driver), "deleteSelectedButton", "Poi page");

		Utils.waitForElementToBeClickable(driver, MyPOIsPage.Manage.deletAllConfirmButton(driver));

		ActionModule.click(driver, MyPOIsPage.Manage.confirmButton(driver), "deleteSelectedButton", "Poi page");

		Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));

		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));

		Utils.sleep(driver, 3000);

	}




	/**
	 * add POi by Zipcode
	 * @param driver
	 */

	public static void addPOIZipcode(WebDriver driver)
	{

		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));

		for(int i=0;i<2;i++)
		{
			Utils.sleep(driver, 3000);

			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));
			Utils.sleep(driver, 5000);

			ActionModule.click(driver, MyPOIsPage.addPOI(driver), "addPOI", "MyPOIsPage");

			Utils.sleep(driver, 3000);
			Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//*[contains(@class,'mypoi-search text-box')]"));
			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.searchTextField(driver), zipcode[i], "searchTextField ", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.search(driver), "search", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));
			ActionModule.click(driver, MyPOIsPage.AddPOIs.addButton(driver), "addButton", "MyPOIsPage");

			Utils.waitForElementToBeClickable(driver,MyPOIsPage.AddPOIs.done(driver));

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "done", "MyPOIsPage");

			Utils.sleep(driver, 5000);

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.addPOI(driver));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));

		}
	}
	/**
	 * Adding Pois by city name
	 * @param driver
	 */

	public static void addPOICity(WebDriver driver)
	{

		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));

		//		Utils.waitForElementToBeClickable(driver,  MyPOIsPage.addPOI(driver));
		//
		//		Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));

		for(int i=0;i<city.length;i++)
		{
			Utils.sleep(driver, 5000);

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));

			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));

			Utils.sleep(driver, 5000);
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));

			ActionModule.click(driver, MyPOIsPage.addPOI(driver), "addPOI", "MyPOIsPage");
			Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//*[contains(@class,'mypoi-search text-box')]"));
			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.searchTextField(driver), city[i], "searchTextField ", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.search(driver), "search", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.addButton(driver), "addButton", "MyPOIsPage");

			Utils.waitForElementToBeClickable(driver,MyPOIsPage.AddPOIs.done(driver));

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "done", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.addPOI(driver));

		}
	}

	/**
	 * Adding Pois by state
	 * @param driver
	 */
	public static void addPOIState(WebDriver driver)
	{

		
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));
		for(int i=0;i<state.length;i++)
		{
			Utils.sleep(driver, 3000);

			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));

			ActionModule.click(driver, MyPOIsPage.addPOI(driver), "addPOI", "MyPOIsPage");
			Utils.sleep(driver, 3000);
			Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[@class='title' and contains(text(),'ADD POI')]"));
			Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//*[contains(@class,'mypoi-search text-box')]"));
			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.searchTextField(driver), state[i], "searchTextField ", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.search(driver), "search", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.addButton(driver), "addButton", "MyPOIsPage");

			Utils.waitForElementToBeClickable(driver,MyPOIsPage.AddPOIs.done(driver));

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "done", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.addPOI(driver));
			
			Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));
			Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));
			

		}
	}


	public static void sortByNewest(WebDriver driver)
	{
		Utils.sleep(driver, 4000);

		int noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);


		if(noOfPois>0)
		{

			deleteAll(driver);
		}
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));

		addPOIZipcode(driver);
		Utils.sleep(driver, 20000);
		pois = null;
		pois=FindWebElement.findElementListByXpath(driver, "//*[@class='poi-list']/div[contains(@class,'poi-row')]/div[contains(@class,'poi-name')]", "Poi name ", "My pOi page");
		Log.info("POS size is : " + pois.size());
		String[] Newzipcode = new String[zipcode.length];
		Log.info("Array length: " + Newzipcode.length);

		for(int i=0;i<zipcode.length;i++)
		{		

			try {
				Log.info("POI Value: " + ActionModule.getText(driver,pois.get(1-i) , "", ""));
				Newzipcode[i]=ActionModule.getText(driver,pois.get(1-i) , "", "");
			}
			catch(IndexOutOfBoundsException ex) {
				ex.printStackTrace();

			}
		}


		for(int i=0;i< zipcode.length ;i++)
		{
			Log.info("after sort by zipcode newest: "+zipcode[i]);

		}
		for(int i=0;i< zipcode.length;i++)
		{
			if(Newzipcode[i].equals(zipcode[i]))
			{
				Log.info("zipcode sorted by newest");
			}
			else
			{
				Log.error("Could not be sorted");
				Assert.fail("Could not be sorted");
			}
		}

	}


	public static void sortByOldest(WebDriver driver)
	{

		Utils.sleep(driver, 3000);

		int noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);
		Utils.sleep(driver, 4000);
		if(noOfPois>0)
		{


			deleteAll(driver);
		}
		Utils.sleep(driver, 3000);

		addPOIZipcode(driver);

		ActionModule.click(driver,MyPOIsPage.newestButton(driver) , "newestButton", "MyPOIsPage");

		ActionModule.click(driver, MyPOIsPage.Newest.oldestLink(driver), "oldestLink", "oldestLink");

		Utils.sleep(driver, 2000);
		pois=FindWebElement.findElementListByXpath(driver, "//*[@class='poi-list']/div[contains(@class,'poi-row')]/div[contains(@class,'poi-name')]", "Poi name ", "My pOi page");
		String[] Newzipcode = new String[zipcode.length];

		for(int i=0;i< zipcode.length ;i++)
		{
			Newzipcode[i]=ActionModule.getText(driver,pois.get(i) , "", "");

		}
		for(int i=0;i< zipcode.length;i++)
		{
			if(Newzipcode[i].equals(zipcode[i]))
			{
				Log.info("zipcode sorted by oldest");
			}
			else
			{
				Log.error("Could not be sorted");
			}
		}

	}


	public static void sortByCity(WebDriver driver)
	{


		Utils.sleep(driver, 3000);

		int noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);

		Utils.sleep(driver, 4000);
		if(noOfPois>0)
		{

			Log.info("Deleting already added Pois ");
			deleteAll(driver);
		}

		Utils.sleep(driver, 3000);

		addPOICity(driver);

		Arrays.sort(city);

		ActionModule.click(driver,MyPOIsPage.newestButton(driver) , "newestButton", "MyPOIsPage");

		ActionModule.click(driver, MyPOIsPage.Newest.cityLink(driver), "cityLink", "oldestLink");

		Utils.sleep(driver, 3000);

		String[] Newcity = new String[city.length];

		pois=FindWebElement.findElementListByXpath(driver, "//*[@class='poi-list']/div[contains(@class,'poi-row')]/div[contains(@class,'poi-name')]", "Poi name ", "My pOi page");


		for(int i=0;i< city.length ;i++)
		{
			Newcity[i]=ActionModule.getText(driver,pois.get(i) , "", "");

		}
		for(int i=0;i< city.length;i++)
		{
			if(Newcity[i].equals(city[i]))
			{
				Log.info("city sorted by oldest");
			}
			else
			{
				Log.error("Could not be sorted");
			}
		}


	}


	public static void sortByState(WebDriver driver)
	{
		Utils.sleep(driver, 3000);
		int noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);

		Utils.sleep(driver, 4000);
		if(noOfPois>0)
		{

			deleteAll(driver);
		}
		Utils.sleep(driver, 3000);

		addPOIState(driver);



		//Testing 
		Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));
		Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));
		noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);

		if(noOfPois==4)
		{
			Log.info("successfully addded poi");
		}
		else
		{
			Log.error("pois could not be added successfully");
			Assert.fail("pois could not be added successfully");
		}
		

		pois=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'poi-row ng-scope')]", "Poi name ", "My pOi page");
		Utils.waitForElementToBeClickable(driver, pois.get(0));

		String[] NewState = new String[state.length];
		for(int i=0;i<pois.size();i++)
		{
			
			WebElement el=pois.get(i);
			if(BaseClass.getBrowser().equalsIgnoreCase("ie"))
					{
				Actions act = new Actions(driver);
				act.click(pois.get(i)).build().perform();
				Utils.sleep(driver, 1000);
					}
			else
			{
			ActionModule.click(driver,pois.get(i) , "pois", "MyPOIsPage");
			
			}

			String stateName=ActionModule.getText(driver, MyPOIsPage.EditPOI.stateName(driver, (i+1)), "stateName", "stateName");

			state[i]=stateName.substring(stateName.indexOf(",")+1, stateName.length()).trim();


		}

		Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));

		Utils.waitForElementToBeClickable(driver, MyPOIsPage.addPOI(driver));
		Arrays.sort(state);
		for(int i=0;i< state.length ;i++)
		{
			Log.info("after sort: "+state[i]);

		}



		ActionModule.click(driver,MyPOIsPage.newestButton(driver) , "newestButton", "MyPOIsPage");

		ActionModule.click(driver, MyPOIsPage.Newest.stateLink(driver), "cityLink", "oldestLink");




		Utils.sleep(driver, 2000);
		pois=FindWebElement.findElementListByXpath(driver, "//*[@class='poi-list']/div[contains(@class,'poi-row')]/div[contains(@class,'poi-name')]", "Poi name ", "My pOi page");

		Utils.sleep(driver, 3000);
		for(int i=0;i< state.length;i++)
		{

			ActionModule.click(driver,pois.get(i) , "pois", "MyPOIsPage");

			String stateName=ActionModule.getText(driver, MyPOIsPage.EditPOI.stateName(driver, (i+1)), "stateName", "stateName");

			NewState[i]=stateName.substring(stateName.indexOf(",")+1, stateName.length()).trim();


		}
		for(int i=0;i< state.length;i++)
		{
			if(NewState[i].equals(state[i]))
			{
				Log.info("poi sorted by state");
			}
			else
			{
				Log.error("Could not be sorted");
				Assert.fail("Could not be sorted");
			}
		}

	}


	public static void editPois(WebDriver driver)
	{

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
		//		Utils.waitForElementToBeClickable(driver, MyPOIsPage.manageButton(driver));
		Utils.sleep(driver, 4000);

		addPOIbefore(driver,2);

		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));

		int noOfPois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+noOfPois);
		Utils.sleep(driver, 4000);
		if(noOfPois>0)
		{
			pois=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'poi-row ng-scope')]", "Poi name ", "My pOi page");
			Utils.waitForElementToBeClickable(driver, pois.get(0));
			ActionModule.click(driver, pois.get(0), "first Poi", "MyPois");
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));
			Utils.sleep(driver, 3000);
			String poiName=ActionModule.getText(driver, MyPOIsPage.EditPOI.poiName(driver), "poiName","MyPOIsPage");
			Log.info("poi is:"+poiName);
			String phoneNo=ActionModule.getText(driver, MyPOIsPage.EditPOI.phoneNo(driver), "poiName","MyPOIsPage");
			Log.info("phoneNo is:"+phoneNo);
			//If contact no is not added before
			if(phoneNo.length()<1)
			{
				phoneNo="98763212";
			}
			else
			{
				phoneNo=phoneNo.substring(2,5);
			}
			String notes=ActionModule.getText(driver, MyPOIsPage.EditPOI.notes(driver), "poiName","MyPOIsPage");
			Log.info("notes is:"+notes);
			if(notes.length()<1)
			{
				notes="KMA Test EDIT POi";
			}
			Utils.sleep(driver, 10000);
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[contains(@class,'poi-more-info')][1]//img[@title='Edit POI']"));
			ActionModule.click(driver, MyPOIsPage.EditPOI.editButton(driver), "editButton", "MyPOIsPage");

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.EditPOI.done(driver));

			String randomNo = new SimpleDateFormat("ddHHmmss").format(new Date());
			String newPoi=poiName.replaceAll("[\\d.]", "").concat(randomNo);
			String newNotes="notes"+randomNo;

			String newPhoneNo=phoneNo.substring(0,6).trim();
			Log.info("phone no1:"+newPhoneNo);
			newPhoneNo=newPhoneNo.concat(randomNo);
			Log.info("phone no2:"+newPhoneNo);
			newPhoneNo=newPhoneNo.substring(0, 10);
			Log.info("phone no3:"+newPhoneNo);

			ActionModule.sendKeys(driver, MyPOIsPage.EditPOI.editPoiName(driver), newPoi, "poi name", "My pois name");
			ActionModule.sendKeys(driver, MyPOIsPage.EditPOI.editPhone(driver), newPhoneNo, "poi name", "My pois name");
			ActionModule.sendKeys(driver, MyPOIsPage.EditPOI.editNotes(driver), newNotes, "poi name", "My pois name");

			ActionModule.click(driver, MyPOIsPage.EditPOI.done(driver), "done", "MyPOIsPage");

			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button-container actions']//*[contains(@ng-click,'openPoiModal') and text()='+ ADD POI']"));

			Utils.sleep(driver, 20000);
			pois=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'poi-row ng-scope')]", "Poi name ", "My pOi page");
			ActionModule.click(driver, pois.get(0), "first Poi", "MyPois");

			Utils.sleep(driver, 2000);
			String EditedPoiName=ActionModule.getText(driver, MyPOIsPage.EditPOI.poiName(driver), "poiName","MyPOIsPage");
			Log.info("after edit poi is:"+EditedPoiName);

			String EditedPhoneNo=ActionModule.getText(driver, MyPOIsPage.EditPOI.phoneNo(driver), "poiName","MyPOIsPage");
			Log.info("after edit phoneNo is:"+EditedPhoneNo);

			String Editednotes=ActionModule.getText(driver, MyPOIsPage.EditPOI.notes(driver), "poiName","MyPOIsPage");
			Log.info("after edit notes is:"+Editednotes);



			if(!poiName.equals(EditedPoiName))
			{
				Log.info("poi name edited successfully ");			
			}
			else
			{
				Log.error("poi name edited successfully ");
				Assert.fail("poi name edited successfully ");
			}
			if(!phoneNo.equals(EditedPhoneNo))
			{
				Log.info("phoneNo edited successfully ");			
			}
			else
			{
				Log.error("phoneNo edited successfully ");
				Assert.fail("phoneNo edited successfully ");
			}
			if(!notes.equals(Editednotes))
			{
				Log.info("notes edited successfully ");			
			}
			else
			{
				Log.error("notes edited successfully ");
				Assert.fail("notes edited successfully ");
			}

		}
		else
		{
			Log.info("no poi found for edit");
		}
	}

	/*	public static void verifyPOIFormForStarbucks(WebDriver driver)
	{


			Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));

			Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));

			Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));
			ActionModule.click(driver, MyPOIsPage.addPOI(driver), "addPOI", "MyPOIsPage");

			Utils.sleep(driver, 3000);


			Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));

			Utils.sleep(driver, 5000);

			Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));
			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.searchTextField(driver), "Starbucks", "searchTextField", "MyPOIsPage");

			Utils.sleep(driver, 5000);


			Utils.waitForElementToBeClickable(driver, MyPOIsPage.AddPOIs.search(driver));
			ActionModule.click(driver, MyPOIsPage.AddPOIs.search(driver), "search", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.addButton(driver), "addButton", "MyPOIsPage");
			Utils.sleep(driver, 3000);
			String poiName = MyPOIsPage.AddPOIs.poiNameField(driver).getAttribute("value");

			Log.info("POI name on the filed is " + poiName);
			assertTrue(poiName.equalsIgnoreCase("Starbucks"), "Starbucks is not found on the name field");

			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.poiNameField(driver), "starbucks@", "searchTextField", "MyPOIsPage");

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "POIs_Close_Button", "MyPOIsPage");

			assertTrue(Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[contains(text(),'Special characters not allowed')]")), "Name warning is not present");

			Utils.waitForElementToBeVisible(driver, MyPOIsPage.AddPOIs.addressField(driver));

			MyPOIsPage.AddPOIs.poiNumberField(driver).sendKeys(Keys.BACK_SPACE);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "POIs_Close_Button", "MyPOIsPage");

			assertTrue(Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[contains(text(),'Enter a valid 10 digit phone number')]")), "Number warning is not present");

			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.poiNumberField(driver), "Wrong number", "Number Field", "MyPOIsPage");

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "POIs_Close_Button", "MyPOIsPage");

			assertTrue(Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[contains(text(),'Enter a valid 10 digit phone number')]")), "Number warning is not present");
			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "POIs_Close_Button", "MyPOIsPage");

			Utils.waitForElementToBeVisible(driver, MyPOIsPage.AddPOIs.notesField(driver));

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.cancel(driver), "POIs_Cancel_Button", "MyPOIsPage");

			assertTrue(Utils.waitForElementToBeVisibleByLocator(driver, By.id("addPoiScroller")), "Search result page is not opened");

			if(Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//header/a[@class='close']"))) {
				ActionModule.click(driver, MyPOIsPage.AddPOIs.searchCloseButton(driver), "alert close button", "MyPOIsPage");

			}
	}	

	public static void deletePreviousCreatedPOIs(WebDriver driver, int poiValue) {

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));
		int pois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are:"+pois);

		if(pois>poiValue)
		{
			Log.info("Pois are present, deleting POIs");	
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//span[contains(@class,'manage-button')]"));
			ActionModule.click(driver, MyPOIsPage.manage(driver), "Manage Button", "MyPOIsPage");

			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//span[contains(@class,'delete-all')]"));
			ActionModule.click(driver, MyPOIsPage.AddPOIs.deleteAllButton(driver), "Delete All Button", "MyPOIsPage");

			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//div[contains(@class,'confirm')]/span[text()='CONFIRM']"));
			ActionModule.click(driver, MyPOIsPage.AddPOIs.deleteAllConfirmButton(driver), "Delete All Confirm Button", "MyPOIsPage");

		}
	}
	public static void addPOIForStarbucks(WebDriver driver, String poiName)
	{

			Utils.sleep(driver, 10000);
			Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@class='button manage-button']"));
//			Utils.waitForElementToBeClickable(driver, MyPOIsPage.manage(driver));
			Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//div[contains(@class,'actions')]/span[@class='add button']"));
			ActionModule.click(driver, MyPOIsPage.addPOI(driver), "addPOI", "MyPOIsPage");

//			Utils.sleep(driver, 3000);




			Utils.sleep(driver, 8000);

			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.searchTextField(driver), "StarBucks", "searchTextField", "MyPOIsPage");

			Utils.sleep(driver, 5000);


			Utils.waitForElementToBeClickable(driver, MyPOIsPage.AddPOIs.search(driver));
			ActionModule.click(driver, MyPOIsPage.AddPOIs.search(driver), "search", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.addButton(driver), "addButton", "MyPOIsPage");
			Utils.sleep(driver, 3000);

			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.poiNameField(driver), poiName, "searchTextField", "MyPOIsPage");

			Utils.waitForElementToBeVisible(driver, MyPOIsPage.AddPOIs.notesField(driver));

			ActionModule.sendKeys(driver, MyPOIsPage.AddPOIs.notesField(driver), "Saving POI through Automation", "Notes field", "MyPOIsPage");

			Utils.sleep(driver, 3000);

			ActionModule.click(driver, MyPOIsPage.AddPOIs.done(driver), "POIs_Close_Button", "MyPOIsPage");


	}	

	public static void addThreePoisForStarbucks(WebDriver driver) {


		addPOIForStarbucks(driver, "Starbucks1");
		addPOIForStarbucks(driver, "Starbucks2");
		addPOIForStarbucks(driver, "Starbucks3");
		Utils.waitForElementToBeInvisible(driver, MyPOIsPage.waitForChanges(driver));
		Utils.sleep(driver, 5000);
		assertTrue(checkSpecificPoiInList(driver, "Starbucks"));
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver, MyPOIsPage.totalPOIsValue(driver));
		int pois=Integer.parseInt(ActionModule.getText(driver, MyPOIsPage.totalPOIsValue(driver), "totalPOIsValue", "MyPOIsPage").trim());
		Log.info("Total POis are: "+ pois);

		if(pois==3)
		{
			Log.info("Pois are present. The total POI value is matches with the expected. The value is validated with StarBucks name");	
		}
		else {
			Log.info("The Pois are not present in the list");
		}
		Utils.waitForElementToBeVisible(driver, MyPOIsPage.manage(driver));
		Log.info("Manage button is present on the page");
		Utils.waitForElementToBeVisibleByLocator(driver, By.id("dropdown-value"));
		Log.info("Manage button is present on the page");
		Utils.waitForElementToBeVisible(driver, MyPOIsPage.AddPOIs.poiHideButton(driver));
		Log.info("POI hide button is present on the page");

		for(int i= 0; i<=2; i++) {
		ActionModule.click(driver, MyPOIsPage.AddPOIs.poiHideButton(driver), "Poi hide button", "MyPOIsPage");
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeInvisible(driver, MyPOIsPage.AddPOIs.openedPoiList(driver));
		Log.info("POI list is hidden");
		Utils.sleep(driver, 3000);
		ActionModule.click(driver, MyPOIsPage.AddPOIs.poiShowButton(driver), "Poi show button", "MyPOIsPage");
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver, MyPOIsPage.AddPOIs.openedPoiList(driver));
		Utils.sleep(driver, 3000);
		}
	}

	public static boolean checkSpecificPoiInList(WebDriver driver, String poiName) {
		boolean poiValuePresent = false;
		if(Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[contains(@class,'poi-row')]/div[contains(@class,'poi-name') and contains(text(),'"+ poiName + "')]"))) {
			poiValuePresent = true;
		}
		return poiValuePresent;
	}*/


}

