package com.rsi.kma.automation.modules;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.pageObjects.ChargingStationsPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Utils;

public class ChargingStationModule {



	private static Logger    Log = Logger.getLogger(ChargingStationModule.class.getName());
	
	/**
     * Navigate to the charging stations page
     * 
     * @param driver WebDriver
     */
	public static void navigateToChargingStationPage(WebDriver driver)
	{
		// Navigate to overview Page
		OverviewModule.NavigateToOverviewPage(driver);
		
		// Navigate to Charging stations page
		ActionModule.click(driver,MyCarLeftMenu.chargingStations_Link(driver), "Overview link", "Vehicle page");
		
		// Wait for progress bar to be invisible
		Utils.waitForProgressbarInvisible(driver);
		Log.info("Succesfully navigated to charging station  Page");    
	}
	
	/**
     * Enter the ZIP code in the search box for Charging stations
     * 
     * @param driver WebDriver
     */
	
	public static void enterZipcode(WebDriver driver)
	{
		String zipcode=null;
		List<WebElement> webElements= null;
		
		// Wait for the search box on the charging stations page to be visible
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.search_Box(driver));
		
		// Get ZIP code value from the master parameter list
		zipcode = Utils.getParameterValueFromCsvFile("zipcode");
		// Enter ZIP code value in the search box
		ActionModule.sendKeys(driver, ChargingStationsPage.search_Box(driver), zipcode, "Zipcode", "Charging Stations");
		
		// Click search button on the charging stations page
		ActionModule.click(driver,ChargingStationsPage.search_Button(driver), "Search box", "Charging Station");
		
		// Wait for progress bar to be invisible
		Utils.waitForProgressbarInvisible(driver);
		Utils.sleep(driver, 7000);
		
		// Wait for the scroll panel of search results on the charging stations page to be visible
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.scroll_Panel_Of_Searched_Result(driver));
		
		// Find the count of the charging stations
		webElements=FindWebElement.findElementListByXpath(driver,"//*[@class='scroll-panel']/div" , "no of charging Station", "Charging station");
		Log.info(webElements.size() + " Station Found for zipcode "+zipcode);
	}
	
	/**
     * Get the parameter value from the master parameter sheet
     * 
     * @param parameter The parameter from the parameters file
     * @return {parameterValue Parameter Value from the CSV file}
     * 
     */
	
	public static String getDataParameterValueFromCsv(String parameter)
	{	
		String parameterValue = null;
		// Get parameter value from the master parameter list
		parameterValue = Utils.getParameterValueFromCsvFile(parameter);
	 return parameterValue;
	}
	
	/**
     * Get the charging stations count from the search results
     * 
     * @param driver WebDriver
     * @param parameter The parameter from the parameters file
     * @return {listSize Charging stations count after the search results}
     * 
     */
	
	public static Integer getChargingStationsCount(WebDriver driver, String parameter)
	{
		String inputValue=null;
		List<WebElement> webElements= null;
		
		// Wait for the search box on the charging stations page to be visible
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.search_Box(driver));
		
		// Get input value for search box from master parameter sheet
		inputValue = getDataParameterValueFromCsv(parameter);
		
		// Enter ZIP code value in the search box
		ActionModule.sendKeys(driver, ChargingStationsPage.search_Box(driver), inputValue, "Zipcode", "Sending zip code for the Charging stations");
		
		// Click search button on the charging stations page
		ActionModule.click(driver,ChargingStationsPage.search_Button(driver), "Search box", "Clicking search box");
		
		// Wait for progress bar to be invisible
		Utils.waitForProgressbarInvisible(driver);
		Utils.sleep(driver, 7000);
		
		// Wait for Loading charging stations text to be invisible
		Utils.waitForElementToBeInvisible(driver, ChargingStationsPage.loading_charging_stations_text(driver));
		
		// Wait for the scroll panel of search results on the charging stations page to be visible
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.scroll_Panel_Of_Searched_Result(driver));
		Utils.sleep(driver, 5000);
		
		// Get the charging station list and return total charging stations count
		webElements=FindWebElement.findElementListByXpath(driver,"//*[@class='scroll-panel']/div" , "no of charging Station", "Charging station");
		Log.info(webElements.size() + " Station Found for " + "parameter " +inputValue);
		return webElements.size();
	}
	
	/**
     * Check Brand selection , charge type and location functionality in the Charging station filter
     * 
     * @param driver WebDriver
     */
	public static void checkClearAllButtonFunctionality(WebDriver driver)
	{	
		// Click filter button on the charging stations page
		ActionModule.click(driver,ChargingStationsPage.filter_Button(driver), "Filter Button", "Charging Station");
		Utils.sleep(driver, 2000);
		
		// Selecting level 2 charge type button
		ActionModule.click(driver,ChargingStationsPage.leve12_Charging_On_Filter(driver), "Level 2 Charge type", "Charging Station");
		Utils.sleep(driver, 2000);
		
		// Selecting location for 10 miles away
		ActionModule.click(driver,ChargingStationsPage.ten_MilesAway(driver), "Filter Button", "Charging Station");
		Utils.sleep(driver, 2000);
				
		// Click Clear all button on the filter pop up to clear all the brands
		ActionModule.click(driver,ChargingStationsPage.chargingStations_Clear_All_Brands(driver), "Clear Button", "Clear Checkboxes");
		
		// Wait to check all the brands check boxes are unchecked
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.chargingStations_Brands_Checkbox_Unchecked(driver));
		Utils.sleep(driver, 4000);
		
		// Click All check box to select all the brands
		ActionModule.click(driver,ChargingStationsPage.allBrands_Checkbox(driver), "All Brands Button", "Select Checkboxes");
		
		// Wait to check all the brands check boxes are unchecked
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.chargingStations_Brands_Checkbox_Checked(driver));
		Utils.sleep(driver, 4000);
		
		// Click All check box to select all the brands
		ActionModule.click(driver,ChargingStationsPage.allBrands_Checkbox(driver), "All Brands Button", "Select Checkboxes");
		
		// Wait to check all the brands check boxes are unchecked
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.chargingStations_Brands_Checkbox_Unchecked(driver));
		
		// Click done button on the filter pop up
		ActionModule.click(driver,ChargingStationsPage.done_Button(driver), "Done Filter button", "Done filter task");
		
		// verify the error message to select at least one brand for charging station
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.chargingStations_Select_Atleast_One_Brand_Error_message(driver));
		
		// Select five brands in the charging station filter list
		ActionModule.click(driver,ChargingStationsPage.chargingStations_Brands_Checkbox(driver, "Public"), "Public brand checkbox", "Select Brand name public");
		ActionModule.click(driver,ChargingStationsPage.chargingStations_Brands_Checkbox(driver, "Charge Point Network"), "Charge Point Network brand checkbox", "Select Brand name Charge Point Network");
		ActionModule.click(driver,ChargingStationsPage.chargingStations_Brands_Checkbox(driver, "Blink"), "Blink brand checkbox", "Select Brand name Blink");
		ActionModule.click(driver,ChargingStationsPage.chargingStations_Brands_Checkbox(driver, "Sema Charge Network"), "Sema Charge Network brand checkbox", "Select Brand name Sema Charge Network");
		ActionModule.click(driver,ChargingStationsPage.chargingStations_Brands_Checkbox(driver, "Shorepower"), "Shorepower brand checkbox", "Select Brand name Shorepower");
		
		// Click done button on the filter pop up
		ActionModule.click(driver,ChargingStationsPage.done_Button(driver), "Done Filter button", "Done filter task");
		
		// Wait for Loading charging stations text to be invisible
		Utils.waitForElementToBeInvisible(driver, ChargingStationsPage.loading_charging_stations_text(driver));
	}
	
	/**
     * Validate the search and filter functionality for charging stations
     * 
     * @param driver WebDriver
     * @param parameter The parameter from the parameters file
     * @return {boolean validateChargingStations}
     * 
     */
	
	public static boolean checkSearchAndFilterFunctionality(WebDriver driver, String parameter){
		boolean validateChargingStations = false;
		List<WebElement> webElements= null;
		
		// Get the initial charging station count without applying filter
		Integer initialChargingStationCount = getChargingStationsCount(driver, parameter);
		
		// Verify clear all button functionality
		checkClearAllButtonFunctionality(driver);
		
		// Wait for the scroll panel of the charging stations list to be visible
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.scroll_Panel_Of_Searched_Result(driver));
		
		// Get the charging station list and return total charging stations count
		webElements=FindWebElement.findElementListByXpath(driver,"//*[@class='scroll-panel']/div" , "no of charging Station", "Charging station");
		Log.info(webElements.size() + " Station Found for zipcode ");
		Integer filteredChargingStationCount = webElements.size();
		
		// Validate the Charging stations count before applying the filter should be greater
		if (initialChargingStationCount>filteredChargingStationCount){
			Log.info(initialChargingStationCount + " charging stations are greater then charging stations after filter" + filteredChargingStationCount);
			validateChargingStations = true;
		}
		else{
			Log.info(initialChargingStationCount + " charging stations are lesser then charging stations after filter " + filteredChargingStationCount);
		}
		return validateChargingStations;
	}
	
	/**
     * Validates the charging station on Map
     * 
     * @param driver
     * @return {boolean validateChargingStationAddress}
     * 
     */
	
	public static boolean validateChargingStationOnMap(WebDriver driver){
		boolean validateChargingStationAddress = false;
		Utils.sleep(driver, 7000);
		
		// Get the charging station address from the charging stations list
		String chargingStationAddress = ChargingStationsPage.first_charging_station(driver).getText() + " Charging station address";
		
		// Select first charging station from the list
		ActionModule.click(driver,ChargingStationsPage.first_charging_station(driver), "first charging station", "Selecting first charging station");
		
		// Wait for scroll panel to be disappear after selecting the charging station
		Utils.waitForElementToBeInvisible(driver, ChargingStationsPage.scroll_Panel_Of_Searched_Result(driver));
		
		// Wait for charging station info box to be visible on the map
		Utils.waitForElementToBeVisible(driver, ChargingStationsPage.charging_station_info_box(driver));
		Log.info(ChargingStationsPage.charging_station_info_box_name(driver).getText() + " Charging station address");
		
		// Validate the charging station selected from the list is same as present on the map
		if(chargingStationAddress.contains(ChargingStationsPage.charging_station_info_box_name(driver).getText())){
			Log.info("Selected charging station from the list is opened on the Map");
			validateChargingStationAddress = true;
		}
		else{
			Log.info("Selected charging station from the list is not opened on the Map");
		}
		return validateChargingStationAddress;
	}
	
	/**
     * Validate the ZIP code and the City functionality for search box for charging stations
     * 
     * @param driver WebDriver
     * @param firstParameter The first parameter from the parameters file
     * @param secondParameter The second parameter from the parameters file 
     * @return {boolean validateChargingStations}
     * 
     */
	
	public static boolean checkZipAndCityFunctionality(WebDriver driver, String firstParameter, String secondParameter){
		boolean validateChargingStations = false;
		
		// Get charging stations count for first parameter
		Integer chargingStationCountForZip = getChargingStationsCount(driver, firstParameter);
		
		// Get charging stations count for second parameter
		Integer chargingStationCountForCity = getChargingStationsCount(driver, secondParameter);
		
		// Validate charging station count for ZIP code is not equal to charging station count for city
		if (chargingStationCountForZip!=chargingStationCountForCity){
			Log.info(chargingStationCountForZip + " charging stations count doesn't matches " + chargingStationCountForCity);
			validateChargingStations = true;
		}
		else{
			Log.info(chargingStationCountForZip + " charging stations count matches " + chargingStationCountForCity);
		}
		return validateChargingStations;
	}
	
	
	
}
