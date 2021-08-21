package com.rsi.kma.automation.modules;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;

import com.rsi.kma.automation.pageObjects.WebDCSPage;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.Constants;
import com.rsi.kma.automation.utility.Utils;



public class WebDCSModule {

	private static Logger Log = Logger.getLogger(WebDCSModule.class
			.getName());	
	
	public static String time=null;
	
	public static String getTime() {
		return time;
	}


	public static void setTime(String time) {
		WebDCSModule.time = time;
	}

	public static String newDate=null;

	public static String getNewDate() {
		return newDate;
	}


	public static void setNewDate(String newDate) {
		WebDCSModule.newDate = newDate;
	}


	public static void webDCS ( String kiaUserName) {

		String webID=Utils.getParameterValueFromCsvFile("webID");
		String webPassword=Utils.getParameterValueFromCsvFile("webPassword");

		String parentWindow= null;
		WebDriver driverWebDCS = setUpWebDCS();        

		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 7);

		boolean executionCompletionFlag= false;
    
		/*Login to Webdcs*/	

		try
		{


			ActionModule.sendKeys(driverWebDCS, WebDCSPage.userID(driverWebDCS), webID, "Value","WebDCS page");
			ActionModule.sendKeys(driverWebDCS, WebDCSPage.passsword(driverWebDCS), webPassword, "passsword","WebDCS page");
			Utils.sleep(driverWebDCS, 4000);
			
			ActionModule.clickByJavascriptId(driverWebDCS, "SignInCtl_Login", "imgDealerSearch");
			
			Utils.waitForElementToBeInvisible(driverWebDCS, WebDCSPage.userID(driverWebDCS));

			Utils.waitForElementToBeInvisible(driverWebDCS, WebDCSPage.passsword(driverWebDCS));
			Utils.waitForElementToBeInvisible(driverWebDCS, WebDCSPage.userID(driverWebDCS));
			Utils.waitForElementToBeInvisible(driverWebDCS, WebDCSPage.loginButton(driverWebDCS));

			parentWindow = driverWebDCS.getWindowHandle(); 

			Utils.sleep(driverWebDCS, 5000);
			driverWebDCS.switchTo().frame("TopFrame");
			Log.info("Sucessfully switched to 'TopFrame' frame");

			Utils.sleep(driverWebDCS, 5000);
			JavascriptExecutor executor = (JavascriptExecutor)driverWebDCS;

			Utils.waitForElementToBeClickable(driverWebDCS, WebDCSPage.dealerSearch(driverWebDCS));

			ActionModule.clickByJavascriptId(driverWebDCS, "imgDealerSearch", "imgDealerSearch");
			
			
			Utils.sleep(driverWebDCS, 6000);
			for(String childWindow : driverWebDCS.getWindowHandles()){
				driverWebDCS.switchTo().window(childWindow);
				Log.info("Window title is "+driverWebDCS.getTitle());
			}

			Utils.sleep(driverWebDCS, 6000);

			
			Utils.sleep(driverWebDCS, 2000);

			ActionModule.sendKeys(driverWebDCS, WebDCSPage.dealerCode(driverWebDCS), "CA273", "Value","WebDCS Page");       
			Utils.sleep(driverWebDCS, 4000);
			ActionModule.clickByJavascriptId(driverWebDCS, "ibtnSearch", "imgDealerSearch");


			Utils.sleep(driverWebDCS, 3000);

			driverWebDCS.switchTo().window(parentWindow);  	
			driverWebDCS.switchTo().frame(0);

			
			executor.executeScript("arguments[0].click();", WebDCSPage.topMenu(driverWebDCS));


			Utils.sleep(driverWebDCS, 3000); 

			driverWebDCS.switchTo().parentFrame();
			Utils.sleep(driverWebDCS, 8000);
			Log.info("Sucessfully switched to parent frame");

			driverWebDCS.switchTo().frame("ConFrame");
			Log.info("Sucessfully switched to 'ConFrame' frame");

			driverWebDCS.switchTo().frame("Left");
			Log.info("Sucessfully switched to 'Left' frame");

			driverWebDCS.switchTo().frame("LeftMenu");
			Log.info("Sucessfully switched to 'LeftMenu' frame");

			ActionModule.clickByJavascriptId(driverWebDCS, "a_9", "UVO & Other Alerts link clicked");
			Log.info("Sucessfully clicked on 'UVO & Other Alerts link clicked'");

			ActionModule.clickByJavascriptId(driverWebDCS, "scn_15", "Outstanding Alerts link clicked");
			Log.info("Sucessfully clicked on 'Outstanding Alerts link clicked'"); 
			Utils.sleep(driverWebDCS, 4000);

			try {
				driverWebDCS.switchTo().defaultContent();
				System.out.println("Navigated back to webpage from frame");
			} catch (Exception e) {
				System.out
				.println("unable to navigate back to main webpage from frame"
						+ e.getStackTrace());
			}


			driverWebDCS.switchTo().parentFrame();        
			Utils.sleep(driverWebDCS, 6000);
			Log.info("Sucessfully switched to parent window");

			driverWebDCS.switchTo().frame("ConFrame");
			Log.info("Sucessfully switched to 'ConFrame'");

			driverWebDCS.switchTo().frame("view"); 
			Log.info("Sucessfully switched to 'view frame'");
			Utils.sleep(driverWebDCS, 7000);

			ActionModule.sendKeys(driverWebDCS, WebDCSPage.eMail(driverWebDCS),Utils.getUserName(), "", "");

			executor.executeScript("arguments[0].click();", WebDCSPage.appoinmentSearch(driverWebDCS));
			
			Utils.sleep(driverWebDCS, 5000);
			List<WebElement> list = driverWebDCS.findElements(By.xpath("//span[@id='PgNav']//td/a[starts-with(@href,'javascript:__doPostBack')]"));
			List<WebElement> list1 = driverWebDCS.findElements(By.xpath("//*[@id='PgNav']/table/tbody/tr/td[2]/a"));
			System.out.println(list1.size());
			System.out.println(list.size());

			for (int page=1; page <= list.size(); page++){

				WebElement ClikOnPage= driverWebDCS.findElement(By.xpath("//span[@id='PgNav']//td/a[starts-with(@href,'javascript:__doPostBack')][position()="+page+"]"));

				executor.executeScript("arguments[0].click();", ClikOnPage);

				Utils.sleep(driverWebDCS, 6000);
				WebElement table = driverWebDCS.findElement(By.id("gvAlerts"));           
				List<WebElement> rowCount= table.findElements(By.tagName("tr"));
				System.out.println(rowCount);

				
				for(int rowNum=2; rowNum<=rowCount.size();rowNum++ )
				{                  


					if(!Utils.waitForElementToBeVisible(driverWebDCS, WebDCSPage.statusClicked(driverWebDCS, 2)))
					{
						Log.error("Element isn't visible");
						Reporter.log("Element isn't visible");
					}

					WebElement status =WebDCSPage.statusClicked(driverWebDCS, rowNum);  
					executor.executeScript("arguments[0].click();", status);

					Utils.sleep(driverWebDCS, 10000);                    
					/*Navigate on child window*/                        
					for(String chekNewWindow : driverWebDCS.getWindowHandles())
					{
						driverWebDCS.switchTo().window(chekNewWindow);
					}

					Utils.sleep(driverWebDCS, 10000);



					Select sel = new Select(WebDCSPage.statusSelected(driverWebDCS));
					sel.selectByValue("4");
					Utils.sleep(driverWebDCS, 10000);

					if(!Utils.waitForElementToBeVisible(driverWebDCS, WebDCSPage.timeHour(driverWebDCS)))
					{
						Log.error("Element isn't visible");
						Reporter.log("Element isn't visible");
					}


					//Testing date
					Date date = new Date();
					SimpleDateFormat simpDate;

					simpDate = new SimpleDateFormat("hh:mm a");
					String currentdate=simpDate.format(date);

					String hour=currentdate.substring(0, currentdate.lastIndexOf(":"));
					int newHour=Integer.parseInt(hour);
					

					String min=currentdate.substring(currentdate.lastIndexOf(":")+1, (currentdate.lastIndexOf(":"))+3);
					int newMin=(Integer.parseInt(min))+3;

					if(newMin>60)
					{
						newMin=newMin%60;
						newHour=newHour+1;
						if(newHour>12)
						{
							newHour=newHour%12;

						}

					}
					
					String minutes=Integer.toString(newMin);
					if(minutes.length()==1)
					{
						minutes="0"+minutes;
					}
					
					String AMPM=currentdate.substring(currentdate.length()-3, currentdate.length()).trim();


					WebElement timeHour = WebDCSPage.timeHour(driverWebDCS);
					((JavascriptExecutor) driverWebDCS).executeScript("arguments[0].setAttribute('value','" + newHour +"')", timeHour);

					WebElement timeMinutes = WebDCSPage.timeMinute(driverWebDCS);
					((JavascriptExecutor) driverWebDCS).executeScript("arguments[0].setAttribute('value', '" + minutes +"')", timeMinutes);

					Select elm = new Select(driverWebDCS.findElement(By.id("ddlApptAmPm")));
					elm.selectByVisibleText(AMPM);


					setTime(hour+":"+minutes+" "+AMPM);
					Log.info(getTime());
					
					
					WebElement commentBox = WebDCSPage.commentsBox(driverWebDCS);
					((JavascriptExecutor) driverWebDCS).executeScript("arguments[0].setAttribute('value', 'Test Please ignore Test Please ignoreTest Please ignore')", commentBox);


					Format formatter = new SimpleDateFormat("MMM-yyyy");
					String s = formatter.format(new Date());

					Format formatter2 = new SimpleDateFormat("dd");
					String s2 = formatter2.format(new Date());

					//changing date in a specific format
					 newDate=s.replace("-"," "+s2+","+" ");
					setNewDate(newDate);
					Log.info(getNewDate());

					WebElement dateBox = WebDCSPage.dateBox(driverWebDCS);
					((JavascriptExecutor) driverWebDCS).executeScript("arguments[0].setAttribute('value', '" + newDate +"')", dateBox);

					Utils.sleep(driverWebDCS, 3000);

					ActionModule.clickByJavascriptId(driverWebDCS, "btnSubmit", "imgDealerSearch");
					// ActionModule.click(driverWebDCS, WebDCSPage.submitButton(driverWebDCS), "Submit button"," clicked successfully");
					Utils.sleep(driverWebDCS, 5000); 

					Log.info("Appoinment Scheduled .waiting for the time");
					Utils.sleep(driverWebDCS,90000);
					
					
 					driverWebDCS.switchTo().window(parentWindow);
					executionCompletionFlag=true;

					break;      
				} 


				if(executionCompletionFlag)
				{

					
					teardownWebDCS(driverWebDCS);
					break;
				}
			}
		}
		catch(Exception e)
		{
			
			
			teardownWebDCS(driverWebDCS);

		}



	}


	public static WebDriver setUpWebDCS() {

		WebDriver driverWebDCS=null;        
		String OS = System.getProperty("os.name");      
		try {

			if (OS.startsWith("Windows")){
				System.setProperty("webdriver.ie.driver", Constants.iePath);
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability("nativeEvents", false);
				caps.setCapability("unexpectedAlertBehaviour", "accept");
				caps.setCapability("ignoreProtectedModeSettings", true);
				caps.setCapability("disable-popup-blocking", false);
				caps.setCapability("enablePersistentHover", true);
				caps.setCapability("ignoreZoomSetting", true);
				driverWebDCS = new InternetExplorerDriver(caps);              
				Log.info("Internet Explorer browser launched");
			}
			else {
				Log.error("Internet Explorer is not supported in " + OS);
				Reporter.log("Internet Explorer is not supported in " + OS);
				throw new Exception("Safari is not supported in " + OS);
			}
			driverWebDCS.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Log.info("Implicit wait applied on the driver for 60 seconds");
			driverWebDCS.manage().window().maximize();
			Log.info("Browser window is maximized");

			String webdcsURL=Utils.getParameterValueFromCsvFile("webdcsURL");
			driverWebDCS.get(webdcsURL);            
			Log.info("setUp() method for WebDCS has executed successfully");         
		} catch (Exception e) {
			Log.error("setUp() method has not executed successfully for WebDCS");
			Log.debug("setUp() method has not executed successfully for WebDCS  | "
					+ new Object() {
					}.getClass().toString() + " | method " + new Object() {
					}.getClass().getEnclosingMethod().getName());
			Reporter.log("setUp() method has not executed successfully for WebDCS");
			try{
				teardownWebDCS(driverWebDCS);
			}catch(Exception ex)
			{
				Reporter.log("Test cases isn't executed sucessfully");
				Assert.fail("Test cases isn't executed sucessfully");

			}
			Assert.fail(e.getMessage());
		}
		Utils.sleep(driverWebDCS, 10000);
		return driverWebDCS;
	}

	/* @AfterMethod (alwaysRun=true)*/
	public static void teardownWebDCS(WebDriver driver) {
		try{
			driver.quit();
			Log.info("Browser window is closed");          
		} catch (UnreachableBrowserException e){
			Log.error("Browser not found. Probably its force closed");
			Log.debug(e.getStackTrace());
			Reporter.log("Browser not found. Probably its force closed"); 
			throw new SkipException("Browser not found. Probably its force closed");
		} catch (Exception e1){
			Log.error("Error in closing the browser." + e1.getMessage());
			Log.debug(e1.getStackTrace());
			Reporter.log("Error in closing the browser." + e1.getMessage());
			Assert.fail("Error in closing the browser." + e1.getMessage());
		}
		Log.info("tearDown has executed successfully");
		Log.info("Browser window is closed");
	}

	public static void checkMachineOS()
	{
		String OS = System.getProperty("os.name");
		Log.info("Currently the running OS is: "+ OS);                
		if(OS.startsWith("Mac"))
		{
			throw new SkipException("Skipped: 'Internet Explorer'(IE) isn't available on Mac Machine");
		}
	}
}
