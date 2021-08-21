package com.rsi.kma.automation.utility;



import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.ActionModule;
import com.rsi.kma.automation.pageObjects.Common.OverviewPage;



/**
 * The BaseClass is Parent class of Test classes. It has all the mandatory annotated methods
 */

public class BaseClass {

	public static Logger Log = Logger.getLogger(BaseClass.class.getName());
	public static WebDriver driver; 

	public static String TestMethodName=null;
	public static String getTestMethodName() {
		return TestMethodName;
	}


	public static void setTestMethodName(String testMethodName) {
		TestMethodName = testMethodName;
	}

	public static String browser=null;
	public static String URL=null;

	public static int RetryCount=0;

	public static int getRetryCount() {
		return RetryCount;
	}


	public static void setRetryCount(int retryCount) {
		RetryCount = retryCount;
	}




	public static String getURL() {
		return URL;
	}


	public static void setURL(String uRL) {
		URL = uRL;
	}


	public static String getBrowser() {
		return browser;
	}


	public static void setBrowser(String browser) {
		BaseClass.browser = browser;
	}


	/**
	 * This method runs after before each Test class. It instantiate the driver and then the browser.
	 * 
	 */
	@Parameters({ "browser","URL","RetryCount"})
	@BeforeSuite(alwaysRun=true)
	public void setUp(String browser,String URL,int RetryCount) {


		try {



			File screenShotFolder = new File(Constants.Path_ScreenShot);
			Utils.deleteFolder(screenShotFolder); 
			setURL(URL);
			
			setBrowser(browser);

			setRetryCount(RetryCount);


			DOMConfigurator.configure("log4j.xml");

           
		 
			

		} catch (Exception e) {
			Log.error("setUp() method has not executed successfully");            
			Reporter.log("setUp() method has not executed successfully");
			Assert.fail(e.getMessage());
		}

	}


	/**
	 * This method runs before each Test case/method.It will choose a random 
	 * platform from the valid platform group .All the valid platform will be taken 
	 * from the group annotations and then one platform will be randomly selected.
	 * @return 
	 * 
	 */
	@BeforeMethod(alwaysRun=true)
	public String chooseRandom(Method method){

		String TestMethodName=method.getName();
		setTestMethodName(TestMethodName);
		String platform=null;
		Log.info("Inside "+ TestMethodName);
		Boolean flag=true;
		Test testClass = method.getAnnotation(Test.class);
		ArrayList<String> numbers=new ArrayList<String>();


		for (int i = 0; i < testClass.groups().length; i++) {
			if(testClass.groups()[i].contains("NoLogin"))
				flag=false;
			else
				flag=true;
			numbers.add(testClass.groups()[i]);
		}
		if(flag==true)
		{
			Collections.shuffle(numbers);

			platform = numbers.get(0);

			Utils.generateRandomPlatform(platform);
		}
		else
		{
			platform=null;
			Log.info("No need to perform randomization");
		}

		return platform;
	}


	@BeforeClass(alwaysRun=true)
	public void driverInitialise()
	{

		try {
			driver = Utils.setUp(browser,URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.info("setUp() method has executed successfully");
	}


	@AfterClass (alwaysRun=true)
	public void driveClose()
	{
		Utils.tearDown(BaseClass.driver);
		Log.info("tearDown has executed successfully");
		Reporter.log("Browser window is closed");
	}


	/**
	 * log out will be executed after each Test case/method
	 */
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		Utils.isAlertPresent(driver);

		if(Utils.waitForElementToBeClickable(driver, OverviewPage.close(driver)))
		{
			ActionModule.click(driver,OverviewPage.close(driver) , "", "");
		}
		Utils.logout(driver);
		Utils.isAlertPresent(driver);
	}

	/**
	 * Browser session will be closed after each suite..
	 */
	@AfterSuite (alwaysRun=true)
	public void tearDown()
	{
		/*Utils.tearDown(BaseClass.driver);
		Log.info("tearDown has executed successfully");
		Reporter.log("Browser window is closed");*/
	}

}

