package com.rsi.kma.automation.utility;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.rsi.kma.automation.modules.ActionModule;
import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.HomePage;
import com.rsi.kma.automation.pageObjects.Common.LoginFormPage;
import com.rsi.kma.automation.pageObjects.Common.MyVehiclesPage;




public class Utils extends Log {

	private static Logger Log = Logger.getLogger(Utils.class.getName());
	public static WebDriver driver;

	public static String UserName;
	public static String Password;
	public static String CarName;
	public static String Platform;
	public static String GmailPassword;

	public static String getGmailPassword() {
		return GmailPassword;
	}

	public static void setGmailPassword(String gmailPassword) {
		GmailPassword = gmailPassword;
	}

	public static String getUserName() {
		return UserName;
	}
	public static String platform=null;


	public static String getPlatform() {
		return platform;
	}

	public static void setPlatform(String platform) {
		Utils.platform = platform;
	}

	public static void setUserName(String userName) {
		UserName = userName;
	}


	public static String getPassword() {
		return Password;
	}


	public static void setPassword(String password) {
		Password = password;
	}


	public static String getCarName() {
		return CarName;
	}


	public static void setCarName(String carName) {
		CarName = carName;
	}

	public static FluentWait<WebDriver> wait;
	/**	
	 * Initializing log4j for logging purpose and get the readable logs
	 */
	public static void initializeLog4j() {

		DOMConfigurator.configure("log4j.xml");
		Log.info("Initializing log4j");
	}

	/**
	 * 
	 * @param browser, URL 
	 * @return driver
	 * @throws Exception
	 * Set up class configures logs and other basics set up related activities
	 */

	public static WebDriver setUp(String browser,String url) throws Exception {

		String OS = System.getProperty("os.name");
		
		com.rsi.kma.automation.utility.Log.startTestCase(browser.toUpperCase() + " at " + OS);

		/*Setup for firefox*/
		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",Constants.geckoPath);
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("acceptInsecureCerts",true);
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("dom.disable_beforeunload", true);
			profile.setPreference("browser.tabs.remote.autostart", false);
			profile.setPreference("browser.tabs.remote.autostart.1", false);
			profile.setPreference("browser.tabs.remote.autostart.2", false);

			profile.setPreference("plugin.state.flash", 0);
			profile.setPreference("browser.startup.homepage","about:blank");


			caps.setCapability(FirefoxDriver.PROFILE, profile);

			driver = new FirefoxDriver(caps);
			Log.info("Firefox browser launched");
			Log.info("Firefox browser launched");
		} 

		/*Setup for Chrome*/
		else if (browser.equalsIgnoreCase("chrome")) {
			if (OS.startsWith("Windows")) {
				System.out.println("path is :"+Constants.chromePath);
				String chromePath=Constants.chromePath;

				System.setProperty("webdriver.chrome.driver",chromePath);
				driver = new ChromeDriver();
				Log.info("Chrome browser launched");
			} 
		} 

		/*Setup for Internet Explorer*/ 
		else if (browser.equalsIgnoreCase("ie")) {
			if (OS.startsWith("Windows")) {
				System.setProperty("webdriver.ie.driver", Constants.iePath);
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();		
				
				caps.setCapability("ensureCleanSession", true);
				/*caps.setCapability("requireWindowFocus", true);*/
				caps.setCapability("ignoreZoomSetting", true);
				caps.setCapability("nativeEvents", false);
				caps.setCapability("unexpectedAlertBehaviour", "accept");
				caps.setCapability("ignoreProtectedModeSettings", true);
				caps.setCapability("disable-popup-blocking", true);
				caps.setCapability("enablePersistentHover", true);	
				driver = new InternetExplorerDriver(caps);
				Log.info("Internet Explorer browser launched");
			} else {
				Log.error("Internet Explorer is not supported in " + OS);
				Reporter.log("Internet Explorer is not supported in " + OS);
				throw new Exception("Safari is not supported in " + OS);
			}



		}  
		/*Setup for IE Edge*/ 
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",Constants.edgePath);
			driver = new EdgeDriver();

		}
		else {
			Log.error(browser + " browser is not valid");
			throw new Exception(browser + " browser is not valid");

		}
		driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 60 seconds");

		driver.manage().window().maximize();
		Log.info("Browser window is maximized");

		openURL(driver,url);

		return driver;
	}


	/**	
	 * This method will open the URL which has been passed by the User in xmls
	 */

	public static WebDriver openURL(WebDriver driver,String url ) throws Exception {
		try {
			driver.get(url);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension screenResolution = new Dimension((int) 
					toolkit.getScreenSize().getWidth(), (int) 
					toolkit.getScreenSize().getHeight());
			driver.manage().window().setSize(screenResolution);
			Log.info("Web application launched successfully");

		} catch (Exception e) {
			Log.error("Web application launch failure. Please check the URL");
			Reporter.log("Web application launch failure. Please check the URL");
			throw new Exception();
		}
		return driver;
	}


	/**	
	 * This method will choose a valid random platform(on which the test case is applicable)
	 *  from the platform credentials list(Excel file ).
	 **/

	public static void generateRandomPlatform( String platformvalue){

		boolean flag=false;

		InputStream ExcelFileToRead = null;
		setPlatform(platformvalue);
		XSSFWorkbook wb = null;
		try {
			ExcelFileToRead = new FileInputStream(Constants.platformCredentials);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(ExcelFileToRead);
		} catch (IOException e) {

			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheetAt(0);


		// Getting the UserName , Password and CarName from the platform
		// list depending on the randomly chosen platform.  

		for ( int RowNum=0; RowNum<=sheet.getLastRowNum();RowNum++){


			if(sheet.getRow(RowNum).getCell(3).toString().equalsIgnoreCase(platformvalue) && RowNum!=0)
			{

				UserName=sheet.getRow(RowNum).getCell(0).toString();
				setUserName(UserName);
				Password=sheet.getRow(RowNum).getCell(1).toString();
				setPassword(Password);
				CarName=sheet.getRow(RowNum).getCell(2).toString();
				setCarName(CarName);
				GmailPassword=sheet.getRow(RowNum).getCell(4).toString();
				setGmailPassword(GmailPassword);
				flag=true;
			}
		}
		if(flag==true)
		{

			//It will get executed when the login information is found for the randomly generated platform.

			Log.info("Login credentials found for "+ platformvalue);
		}
		else
		{

			//  It will get executed when there is no matching platform exist in the parameter list.

			Log.info(platformvalue+ " is not available in credentials list ");
			Reporter.log(platformvalue+ " is not available in credentials list ");
			throw new SkipException(platformvalue+ " is not available in credentials list ");
		}
	}


	/**	
	 * This method will fetch the parameter from the updated parameter list 
	 * @param paremter :parameter whose value is to be fetch from file 
	 **/
	public static String getParameterValueFromCsvFile(String parameter) 
	{

		String value = null;

		String cvsSplitBy = ",";
		String line = "";
		final File csvFile = new File(Constants.Parameters);

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] parameterList = line.split(cvsSplitBy);
				if(parameterList[0].equalsIgnoreCase(parameter))	
				{				
					Log.info("value of parameter is :"+ parameterList[1]);
					value=parameterList[1];
					break;	
				}
			}
		}
		catch (NumberFormatException nfe)
		{

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return value;
	}   

	
	
	
	
	
	
	
	
	
	
	
	public static boolean sleep(WebDriver driver, long timeUnitInMiliSeconds) {

		boolean sleep = true;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Log.info("Stopping the execution for " + timeUnitInMiliSeconds + " miliseconds");
			Thread.sleep(timeUnitInMiliSeconds);
		} catch (Exception e) {
			Log.error("Execution was not able to wait for " + timeUnitInMiliSeconds + " seconds");
			Reporter.log("Execution was not able to wait for " + timeUnitInMiliSeconds + " seconds");
			sleep = false;
			throw new SkipException("Execution was not able to wait for " + timeUnitInMiliSeconds + " seconds");
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}

		return sleep;
	}
	public static void tearDown(WebDriver driver2) {
		try {
			driver.quit();
			Log.info("Browser window is closed");
			Reporter.log("Browser window is closed");
		} catch (UnreachableBrowserException e) {
			Log.error("Browser not found. Probably its force closed");
			Log.error(e.getStackTrace());
			Reporter.log("Browser not found. Probably its force closed");
			throw new SkipException("Browser not found. Probably its force closed");
		} catch (Exception e1) {
			Log.error("Error in closing the browser." + e1.getMessage());
			Log.error(e1.getStackTrace());
			Reporter.log("Error in closing the browser." + e1.getMessage());
			Assert.fail("Error in closing the browser." + e1.getMessage());
		}
	}

	public static boolean isAlertPresent(WebDriver driver) {

	    boolean presentFlag = false;

	    try {

	        // Check the presence of alert
	        Alert alert = driver.switchTo().alert();
	        // Alert present; set the flag
	        presentFlag = true;
	        // if present consume the alert
	        alert.accept();
	        Log.info("Alert Found");
	        //( Now, click on ok or cancel button )

	    } catch (NoAlertPresentException ex) {
	        Log.info("No Alert Found");
	        
	    }

	    return presentFlag;
	}
	
	public static void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if(files!=null) { //some JVMs return null for empty dirs
			for(File f: files) {
				if(f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
		folder.delete();
	}


	public static String takeScreenshot(WebDriver driver, ITestResult result) {

		DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy, K.mm a");
		Date date = new Date();
		String current_Time = dateFormat.format(date);

		current_Time=current_Time.replace(" ", "_");

		/** This is name of test method, annotated with @Test */
		String testMethod = result.getName();

		/** This is name of test class, from which, test method has run */
		String qualifiedTestClassName = result.getTestClass().toString();

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Log.info("Screenshot captured");

			/**
			 * Split the qualified Test class name on dot
			 */
			String[] qualifiedTestClass = qualifiedTestClassName.split("\\.");

			/**
			 * Split the last index on ']' to get the Test class name
			 */
			String testClass[] = qualifiedTestClass[qualifiedTestClass.length - 1].split("]");

			/**
			 * Saving the screenshot as Test method name in folder with Test
			 * class name
			 */
			String screenshotName = null;

			screenshotName = Constants.Path_ScreenShot + testClass[0] + Constants.fileSeparator + testMethod + "."
					+ ".jpg";

			FileUtils.copyFile(scrFile, new File(screenshotName));
			Log.info("Screenshot saved to destination");

			Reporter.log("<br /><br />Screenshot<br /><img width=\"800\" height=\"800\" src=\"file:///" + screenshotName
					+ "\" alt=\"Screenshot\"/><br /><br />");

			return screenshotName;

		} catch (Exception e) {
			Log.error("Screenshot failed. " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			return null;
		}
	}


	public static void waitForElementToBeClickableByLocator(WebDriver driver, By locator) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			Log.info("Element is clickable");
		} catch (Exception e) {
			Log.error("Element is not clickable | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			
			
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
	}

	public static boolean waitForElementToBeClickable(WebDriver driver, WebElement element) {

		boolean webElement = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Log.info("Element is clickable");
			webElement = true;
		} catch (Exception e) {
			Log.error("Element is not clickable | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			webElement = false;
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
		return webElement;
	}

	public static void waitForTextToBePresent(WebDriver driver, WebElement element, String text) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			Log.info("'" + text + "' is found");
		} catch (Exception e) {
			Log.error(text + " is not found | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			Reporter.log("'" + text + "' is not found");
			Assert.fail(text + " is not found");
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
	}

	public static void waitForTextToNotBePresent(WebDriver driver, By locator, String text) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
			Log.info(text + " is not present");
		} catch (Exception e) {
			Log.error(text + " is present | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			Assert.fail(text + " present");
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
	}

	public static boolean waitForElementToBeVisibleByLocator(WebDriver driver, By locator) {

		boolean webElement = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Log.info(locator + " is visible");
			webElement = true;
		} catch (Exception e) {
			Log.error(locator + " is not visible | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			webElement = false;
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
		return webElement;
	}

	public static boolean waitForElementToBeVisible(WebDriver driver, WebElement element) {

		boolean webElement = false;
Log.info("inside wait for element");
		
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info("Element is visible");
			webElement = true;
		} catch (Exception e) {
			Log.error("Element is not visible | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			webElement = false;
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
		return webElement;
	}

	public static boolean waitForElementToBeVisible(WebDriver driver, WebElement element, long waitingTime) {

		boolean webElement = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, waitingTime)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info("Element is visible");
			webElement = true;
		} catch (Exception e) {
			Log.error("Element is not visible | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			webElement = false;
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
		return webElement;
	}

	public static boolean waitForElementToBeNotVisible(WebDriver driver, By locator) {

		boolean webElement = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			Log.info("Element is not visible");
			webElement = true;
		} catch (Exception e) {
			Log.error("Element is visible | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			webElement = false;
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
		return webElement;
	}

	public static boolean waitForElementToBeInvisible(WebDriver driver, WebElement element) {

		boolean webElement = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.invisibilityOf(element));
			Log.info("Element is not visible");
			webElement = true;
		} catch (Exception e) {
			Log.error("Element is visible | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			webElement = false;
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
		return webElement;
	}

	public static void logout(WebDriver driver) {

		if(Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver)) && LoginFormPage.usernameField(driver)==null )
		{
			ActionModule.click(driver, HeaderPage.logOutLink(driver),"Log out" , "Overview");
			Utils.waitForElementToBeVisible(driver, LoginFormPage.usernameField(driver));
		}

	}


	public static boolean waitForTitleToVisible(WebDriver driver) {

		boolean title = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.pollingEvery(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.titleContains("MyUVO - My Vehicles"));
			Log.info("Element is visible");
			title = true;
		} catch (Exception e) {
			Log.error("Element is not visible | " + new Object() {
			}.getClass().toString() + " | method " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			Log.error(e.getMessage());
			title = false;
		} finally {
			driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
		}
		return title;
	}

	
	
	

	public static boolean waitForProgressbarInvisible(WebDriver driver) {

		/** Wait for 60 second for progress bar is invisible */
		long startTime = Calendar.getInstance().getTime().getTime();
		long waitingTimeout = 60000;
		while (true) {
			if (driver.getPageSource().contains(
					"ae-lang-en ae-launcher processing")) {
				Log.info("Progress bar is shown on device screen waiting of 500 milisecond... ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				if ((Calendar.getInstance().getTime().getTime() - startTime) > waitingTimeout) {
					Log.info("Waiting timout 60 second progress is still visible");
					return false;
				}
			} else {
				Log.info("Progress bar is invisible ");
				return true;
			}
		}
	}
	
	
	
	
	public static void chooseDealer(WebDriver driver)
	{
		if(Utils.waitForElementToBeClickable(driver, MyVehiclesPage.zipcode(driver)))
		{

			ActionModule.sendKeys(driver, MyVehiclesPage.zipcode(driver),"92606", "zipcode", "MyVehiclesPage");

			ActionModule.click(driver, MyVehiclesPage.getDealer(driver), "getDealer", "MyVehiclesPage");
			
			
			Utils.waitForElementToBeClickable(driver, MyVehiclesPage.selectDealer(driver));
			Utils.sleep(driver, 6000);

			if(BaseClass.getBrowser().equalsIgnoreCase("ie"))
			{
			
			Actions act = new Actions(driver);
			act.click(MyVehiclesPage.selectDealer(driver)).build().perform();
			}
			
			else
			{
			ActionModule.click(driver, MyVehiclesPage.selectDealer(driver), "selectDealer", "MyVehiclesPage");	

			}
		
		    
		}
	}

	public static void scrolDownForElement(WebDriver driver,WebElement element) {

		try
		{
			((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		}
		catch(Exception e)
		{
			Log.error("Scroll function has not worked");
			Reporter.log("Scroll function has not worked");
			Assert.fail("Scroll function has not worked");

		}
	}
	public static void scrolUpForElement(WebDriver driver,WebElement element) {

		try
		{
			((JavascriptExecutor) driver).executeScript("scroll(0,-300)");
		}
		catch(Exception e)
		{
			Log.error("Scroll function has not worked");
			Reporter.log("Scroll function has not worked");
			Assert.fail("Scroll function has not worked");

		}
	}
	
	
static Hashtable<String,String> h=new Hashtable<String,String>();
	
	public static void add(String testName,String platform)
	{
		
		h.put(testName,platform);
		
		
		/*for(Entry<String, String> m:h.entrySet()){
			
			System.out.println("Hash is: "+m.getValue()+" "+m.getKey());
		}*/
	}
//	public static void switchTabs(WebDriver driver){
//		ArrayList<driver> tabs = new ArrayList<driver> (driver.getWindowHandles());
//		 
//		//Switch to new window
//		driver.switchTo().window(tabs.get(1));
//		driver.close();//do some action in new window(2nd tab)
//		 
//		//Switch to main/parent window
//		driver.switchTo().window(tabs.get(0));
//		driver.getTitle();//do some action in main window(1st tab)
//		
//	}

}
