package com.rsi.kma.automation.modules;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.rsi.kma.automation.pageObjects.MaintenancePage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.Utils;

public class MaintenanceModule {

	private static Logger    Log = Logger.getLogger(LockUnlockModule.class.getName());

	public static void NavigateToMaintenancePage(WebDriver driver)
	{

		// Navigate to overview page
		OverviewModule.NavigateToOverviewPage(driver);

		// In the case of EV 1 vehicle directly navigate to the Climate control tab
		if(Utils.getPlatform().equalsIgnoreCase("EV 1.0"))

			// Click on the climate tab link
			ActionModule.click(driver,MyCarLeftMenu.appointments_Link(driver), "appointments link", "Maintenance Page");

		else{
			Utils.sleep(driver, 5000);
			// Wait for progress bar to be invisible
			Utils.waitForProgressbarInvisible(driver);

			// Navigate to remote page
			ActionModule.click(driver,MyCarLeftMenu.Maintenance_Link(driver), "Maintenance link", "Maintenance Page");
			// Wait for progress bar to be invisible
			Utils.waitForProgressbarInvisible(driver);
		}
		Log.info("Succesfully navigated to Maintenance Page");
	}

	public static void checkIgnoredButtonfunctionality(WebDriver driver){
		Utils.sleep(driver, 10000);
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.ignoredButton(driver));
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.ignoredButton(driver), "Ignored button clicked", "Maintenance Page"); 
		String color = MaintenancePage.ServiceSchedule.ignoredButton(driver).getCssValue("background-color");
		Log.info("The background color of Ignored Button: " + color);
		assertTrue(color.contains("rgba"), "The color of the ignored button is not Red");
		Utils.sleep(driver, 5000);
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.editButton(driver), "Edit button clicked", "Maintenance Page");
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.editBoxDeleteButton(driver));
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.editBoxDeleteButton(driver), "edit box delete button clicked", "Maintenance Page");
		if(Utils.waitForElementToBeVisible(driver, MaintenancePage.ServiceSchedule.ignoredButtonInactive(driver))){
			Log.info("The ignored button is deactivated");
		}
		else{
			Log.error("The ignored button is not deactivated");
			Reporter.log("The ignored button is not deactivated");
			Assert.fail("The ignored button is not deactivated");
		}

	}

	public static void checkDetailsButton(WebDriver driver){
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.detailsButton(driver));
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.detailsButton(driver), "detailsButton clicked", "Maintenance Page");
		if(Utils.waitForElementToBeVisible(driver, MaintenancePage.ServiceSchedule.detailsExpanded(driver))){
			Log.info("The details box is expanded");
		}
		else{
			Log.error("The details box is not expanded");
			Reporter.log("The details box is not expanded");
			Assert.fail("The details box is not expanded");
		}

		ActionModule.click(driver, MaintenancePage.ServiceSchedule.detailsButton(driver), "detailsButton clicked", "Maintenance Page");

		if(Utils.waitForElementToBeInvisible(driver, MaintenancePage.ServiceSchedule.detailsExpanded(driver))){
			Log.info("The details box is closed");
		}

		else{
			Log.error("The details box is not closed");
			Reporter.log("The details box is not closed");
			Assert.fail("The details box is not closed");
		}
	}

	//	public static void checkIgnoreCompleteIntervalFunctionality(WebDriver driver){
	//		checkIgnoredButtonfunctionality(driver);
	//		checkDetailsButton(driver);
	//	}

	public static void editMaintenanceDetails(WebDriver driver){
		String serviceLocation = null;
		String mileage = null;
		String note = null;
		// Get values from the master parameter list
		serviceLocation = Utils.getParameterValueFromCsvFile("maintenanceLocation");
		mileage = Utils.getParameterValueFromCsvFile("maintenanceMileage");
		note = Utils.getParameterValueFromCsvFile("maintenanceNote");
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.editButton(driver), "Edit button clicked", "Maintenance Page");
		Utils.sleep(driver, 2000);
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.notesDate(driver), "Notes date", "Maintenance Page");
		Utils.sleep(driver, 2000);
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.notesDateValue(driver));
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.notesDateValue(driver), "Current day selected as date", "Maintenance Page");

		// Enter service location value in the location field
		ActionModule.sendKeys(driver, MaintenancePage.ServiceSchedule.notesServiceLocation(driver), serviceLocation, "serviceLocation", "Maintenance Page");

		// Enter notes Mileage value in the mileage field
		ActionModule.sendKeys(driver, MaintenancePage.ServiceSchedule.notesMileage(driver), mileage, "notesMileage", "Maintenance Page");

		// Enter notes note value in the note field
		ActionModule.sendKeys(driver, MaintenancePage.ServiceSchedule.notesAddNote(driver), note, "Note", "Maintenance Page");
		Utils.sleep(driver, 2000);
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.editBoxCompleteButton(driver));
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.editBoxCompleteButton(driver), "Notes value saved", "Maintenance Page");
		Utils.sleep(driver, 2000);
		String color = MaintenancePage.ServiceSchedule.completedButton(driver).getCssValue("background-color");
		Log.info("The background color of Completed Button: " + color);
		assertTrue(color.contains("rgba"), "The color of the Completed button is not Red");
		Utils.sleep(driver, 5000);

	}

	public static void verifyDetailsCompletedAndIgnoredButton(WebDriver driver){
		checkIgnoredButtonfunctionality(driver);
		checkDetailsButton(driver);
		editMaintenanceDetails(driver);

	}

	public static void goToMileAndCheckDetails(WebDriver driver){
		Utils.sleep(driver, 10000);
		while (!MaintenancePage.ServiceSchedule.displayedIntervalMiles(driver).getText().contains("7,500")) {
			Log.info("Miles are not 7,500");
			Log.info("Miles value is: " + MaintenancePage.ServiceSchedule.displayedIntervalMiles(driver).getText());
			Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.milestoneLeftArrowButton(driver));
			ActionModule.click(driver, MaintenancePage.ServiceSchedule.milestoneLeftArrowButton(driver), "Successfully clicked on decrease miles button", "Maintenance Page");                
		}
		Log.info("Miles are now 7500");
		while (!MaintenancePage.ServiceSchedule.displayedIntervalMiles(driver).getText().contains("75,000")) {
			Log.info("Miles are not 75,000");
			Utils.sleep(driver, 10000);
			ActionModule.click(driver, MaintenancePage.ServiceSchedule.milestoneRightArrowButton(driver), "Successfully clicked on increase miles button", "Maintenance Page");
			Utils.sleep(driver, 2000);
			// Check details button functionality
			checkDetailsButton(driver);
		}
	}

	public static void verifyOilChangeInterval(WebDriver driver){
		Select oilChange = new Select(MaintenancePage.ServiceSchedule.oilChangeDropdown(driver));
		oilChange.selectByVisibleText("3000");
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.milesRestartButton(driver));
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.milesRestartButton(driver), "Successfully clicked on miles restart button", "Maintenance Page");
		Utils.sleep(driver, 2000);
		verifyOilChangeMiles(driver, "3,000");
		oilChange.selectByVisibleText("5000");
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.milesRestartButton(driver));
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.milesRestartButton(driver), "Successfully clicked on miles restart button", "Maintenance Page");
		Utils.sleep(driver, 2000);
		verifyOilChangeMiles(driver, "5,000");
		oilChange.selectByVisibleText("7000");
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.milesRestartButton(driver));
		ActionModule.click(driver, MaintenancePage.ServiceSchedule.milesRestartButton(driver), "Successfully clicked on miles restart button", "Maintenance Page");
		Utils.sleep(driver, 2000);
		verifyOilChangeMiles(driver, "7,000");

	}

	public static void verifyOilChangeMiles(WebDriver driver, String miles){
		Log.info(MaintenancePage.ServiceSchedule.milesOilChangeSchedule(driver).getText());
		if(MaintenancePage.ServiceSchedule.milesOilChangeSchedule(driver).getText().contains(miles)){
			Log.info("The miles for oil change matches with the expected: " + miles);
		}

		else{
			Log.error("The miles for oil change didn't matches with the expected: " + miles);
			Reporter.log("The miles for oil change didn't matches with the expected: " + miles);
			Assert.fail("The miles for oil change didn't matches with the expected: " + miles);
		}
	}

	public static void changeDealershipValues(WebDriver driver){

		String zipCode = null;
		String newDealerName = null;
		Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.changeDealerButton(driver));
		ActionModule.click(driver, MaintenancePage.RequestAppointment.changeDealerButton(driver), "Successfully clicked on change dealer button", "Maintenance Page");
		// Enter ZIP code 
		ActionModule.sendKeys(driver, MaintenancePage.RequestAppointment.zipCodeField(driver), "00000", "Zip code", "Maintenance Page");
		Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.getDealerButton(driver));
		ActionModule.click(driver, MaintenancePage.RequestAppointment.getDealerButton(driver), "Successfully clicked on get dealer button", "Maintenance Page");
		if(Utils.waitForElementToBeVisible(driver, MaintenancePage.RequestAppointment.zipCodeFieldError(driver))){
			Log.info("The Zip code error is present");
		}
		else{
			Log.error("The Zip code error is present");
			Reporter.log("The Zip code error is present");
			Assert.fail("The Zip code error is present");
		}
		ActionModule.click(driver, MaintenancePage.RequestAppointment.selectDealerBoxClose(driver), "Successfully closed select dealer box", "Maintenance Page");
		// Changing dealer for valid ZIP code
		Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.changeDealerButton(driver));
		ActionModule.click(driver, MaintenancePage.RequestAppointment.changeDealerButton(driver), "Successfully clicked on change dealer button", "Maintenance Page");
		zipCode = Utils.getParameterValueFromCsvFile("maintenanceZip");
		newDealerName = Utils.getParameterValueFromCsvFile("changedDealerName");
		// Enter ZIP code 
		ActionModule.sendKeys(driver, MaintenancePage.RequestAppointment.zipCodeField(driver), zipCode, "Zip code", "Maintenance Page");
		Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.getDealerButton(driver));
		ActionModule.click(driver, MaintenancePage.RequestAppointment.getDealerButton(driver), "Successfully clicked on get dealer button", "Maintenance Page");
		if(Utils.waitForElementToBeVisible(driver, MaintenancePage.RequestAppointment.selectedDealerValue(driver, newDealerName))){
			Log.info("The Dealer: " + newDealerName + " is already selected");
			ActionModule.click(driver, MaintenancePage.RequestAppointment.selectDealerBoxClose(driver), "Successfully closed select dealer box", "Maintenance Page");
		}
		else if(Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.selectDealerValue(driver, newDealerName))){
			Log.info("The Dealer: " + newDealerName + " is present");
			ActionModule.click(driver, MaintenancePage.RequestAppointment.selectDealerValue(driver, newDealerName), "Successfully selected new dealer", "Maintenance Page");
		}
		else{
			Log.info("The Dealer: " + newDealerName + " is not present");
			ActionModule.click(driver, MaintenancePage.RequestAppointment.clickDealerLoadMoreButton(driver), "Loaded more dealers", "Maintenance Page");
			if(Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.selectDealerValue(driver, newDealerName))){
				Log.info("The Dealer: " + newDealerName + " is present");
				ActionModule.click(driver, MaintenancePage.RequestAppointment.selectDealerValue(driver, newDealerName), "Successfully selected new dealer", "Maintenance Page");
			}
			else{
				Log.error("The Dealer: " + newDealerName + " is not present");
				Reporter.log("The Dealer: " + newDealerName + " is not present");
				Assert.fail("The Dealer: " + newDealerName + " is not present");
			}
		}
		Utils.waitForElementToBeInvisible(driver, MaintenancePage.RequestAppointment.selectDealerBoxClose(driver));
		Utils.sleep(driver, 5000);
		Utils.waitForElementToBeVisible(driver, MaintenancePage.ServiceSchedule.milesRestartButton(driver));
		Log.info(MaintenancePage.RequestAppointment.currentDealerName(driver).getText());
		assertTrue(MaintenancePage.RequestAppointment.currentDealerName(driver).getText().equalsIgnoreCase(newDealerName), "The dealer name is not updated");        
	}

	public static void checkRequestAppointment(WebDriver driver){

		Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.RequestAppointmentButton(driver));

		Utils.scrolDownForElement(driver, MaintenancePage.RequestAppointment.RequestAppointmentButton(driver));


		Utils.sleep(driver, 4000);

		if(MaintenancePage.RequestAppointment.currentDealerName(driver).getText().equalsIgnoreCase("kia of irvine"))
		{
			Log.info("dealer is kia of irvine");



		}
		else
		{
			Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.changeDealerButton(driver));
			ActionModule.click(driver, MaintenancePage.RequestAppointment.changeDealerButton(driver), "Successfully clicked on change dealer button", "Maintenance Page");
			String zipCode = "92618";
			String newDealerName = "Kia Of Irvine";
			// Enter ZIP code 
			ActionModule.sendKeys(driver, MaintenancePage.RequestAppointment.zipCodeField(driver), zipCode, "Zip code", "Maintenance Page");
			Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.getDealerButton(driver));
			ActionModule.click(driver, MaintenancePage.RequestAppointment.getDealerButton(driver), "Successfully clicked on get dealer button", "Maintenance Page");
			if(Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.selectDealerValue(driver, newDealerName))){
				Log.info("The Dealer: " + newDealerName + " is present");
				ActionModule.click(driver, MaintenancePage.RequestAppointment.selectDealerValue(driver, newDealerName), "Successfully selected new dealer", "Maintenance Page");
			}
			else{
				Log.info("The Dealer: " + newDealerName + " is not present");
				ActionModule.click(driver, MaintenancePage.RequestAppointment.clickDealerLoadMoreButton(driver), "Loaded more dealers", "Maintenance Page");
				if(Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.selectDealerValue(driver, newDealerName))){
					Log.info("The Dealer: " + newDealerName + " is present");
					ActionModule.click(driver, MaintenancePage.RequestAppointment.selectDealerValue(driver, newDealerName), "Successfully selected new dealer", "Maintenance Page");
				}
				else{
					Log.error("The Dealer: " + newDealerName + " is not present");
					Reporter.log("The Dealer: " + newDealerName + " is not present");
					Assert.fail("The Dealer: " + newDealerName + " is not present");
				}
			}
			Utils.waitForElementToBeInvisible(driver, MaintenancePage.RequestAppointment.selectDealerBoxClose(driver));
			Utils.sleep(driver, 5000);
			Utils.waitForElementToBeVisible(driver, MaintenancePage.ServiceSchedule.milesRestartButton(driver));
			Log.info(MaintenancePage.RequestAppointment.currentDealerName(driver).getText());
			assertTrue(MaintenancePage.RequestAppointment.currentDealerName(driver).getText().equalsIgnoreCase(newDealerName), "The dealer name is not updated");

		}

		Utils.waitForElementToBeClickable(driver,MaintenancePage.RequestAppointment.RequestAppointmentButton(driver) );

		ActionModule.click(driver,MaintenancePage.RequestAppointment.RequestAppointmentButton(driver), "selectDealer", "MyVehiclesPage");

		Utils.waitForElementToBeClickable(driver,MaintenancePage.RequestAppointment.confirmDealerRequest(driver) );

		ActionModule.click(driver,MaintenancePage.RequestAppointment.confirmDealerRequest(driver), "selectDealer", "MyVehiclesPage");	

		Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.confirmationMesssage(driver));

		Utils.waitForElementToBeClickable(driver, MaintenancePage.RequestAppointment.request_Appointment_Ok_Button(driver));

		ActionModule.isDisplayed(driver,MaintenancePage.RequestAppointment.confirmationMesssage(driver), "selectDealer", "MyVehiclesPage");	

		ActionModule.click(driver, MaintenancePage.RequestAppointment.request_Appointment_Ok_Button(driver), "selectDealer", "MyVehiclesPage");
	}

	public static void verifyAppointment(WebDriver driver) {




		Log.info("waiting for appoinment");
		Utils.sleep(driver, 120000);
		String DateToBeMatced=WebDCSModule.getNewDate().trim();

		String timeToBeMatced=WebDCSModule.getTime().trim();


		Utils.scrolDownForElement(driver,MaintenancePage.RequestAppointment.currentAppointment(driver));

		ActionModule.isDisplayed(driver, MaintenancePage.RequestAppointment.currentAppointment(driver), "current appointment", "MaintenancePage");

		String type=ActionModule.getText(driver, MaintenancePage.RequestAppointment.type(driver), "type", "").trim();
		Log.info(type);

		String dealer=ActionModule.getText(driver, MaintenancePage.RequestAppointment.dealer(driver), "dealer", "").trim();
		Log.info(dealer);

		String timeDate=ActionModule.getText(driver, MaintenancePage.RequestAppointment.timeAndDate(driver), "timeAndDate", "").trim();
		Log.info(timeDate);
		if(timeDate.contains(DateToBeMatced))
		{
			Log.info("date matched");
		}
		else
		{
			Log.error("Date  could not be matched");
			Assert.fail("Date could not be matched");
		}

		if(timeDate.contains(timeToBeMatced))
		{
			Log.info("Time matched");
		}
		else
		{
			Log.error("Time could not be matched");
			Assert.fail("Time could not be matched");
		}

		if(dealer.toLowerCase().contains("kia of irvine"))  
		{
			Log.info("Dealer matched");
		}
		else
		{
			Log.error("Dealer could not be matched");
			Assert.fail("Dealer could not be matched");
		}
		if(type.contains("repair"))
		{
			Log.info("Type matched");
		}
		else
		{
			Log.error("Type could not be matched");
			Assert.fail("Type could not be matched");
		}

	}

}
