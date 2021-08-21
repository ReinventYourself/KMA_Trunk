package com.rsi.kma.automation.modules;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.SkipException;

import com.rsi.kma.automation.pageObjects.LockUnlockPage;
import com.rsi.kma.automation.pageObjects.RemotePage;
import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.EMail;
import com.rsi.kma.automation.utility.Utils;

public class LockUnlockModule {

	private static Logger    Log = Logger.getLogger(LockUnlockModule.class.getName());

	
	/**
     * Navigate to the Lock unlock page for EV1 and other vehicles
     * 
     * @param driver WebDriver
     * 
     */
	public static void NavigateToLockUnlockPage(WebDriver driver)
	{
		
		// Navigate to overview page
		OverviewModule.NavigateToOverviewPage(driver);
		
		// In the case of EV 1 vehicle directly navigate to the lock unlock tab
		if(Utils.getPlatform().equalsIgnoreCase("EV 1.0"))
			
			// Click on the lock unlock tab link
			ActionModule.click(driver,MyCarLeftMenu.lockUnlock_Link(driver), "lock unlock link", "Vehicle page");

		else{
			Utils.sleep(driver, 5000);
			// Wait for progress bar to be invisible
			Utils.waitForProgressbarInvisible(driver);
			
			// Navigate to remote page
			ActionModule.click(driver,MyCarLeftMenu.Remote_Link(driver), "Remote link", "Vehicle page");
			// Wait for progress bar to be invisible
			Utils.waitForProgressbarInvisible(driver);
			Utils.sleep(driver, 7000);
			
			// Navigate to lock unlock tab
			ActionModule.click(driver,RemotePage.Lock_Unlock.lock_Unlock_Tab(driver), "Lock Unlock link", "Remote page");
			Utils.sleep(driver, 5000);
		}
		Log.info("Succesfully navigated to Lock/Unlock Page");

	}
	
	/**
     * Gets the status of the lock unlock remote command
     * 
     * @param driver WebDriver
     * @return status status of the lock unlock remote command
     * 
     */
	public static String lockUnlockStatus(WebDriver driver){
		String status = null;
		if(Utils.waitForElementToBeVisible(driver, LockUnlockPage.statusLock(driver)))
		{
			Log.info("Vehicle is currently locked");
			status = "Locked";
		}
		else if(Utils.waitForElementToBeVisible(driver, LockUnlockPage.statusUnlock(driver))){
			Log.info("Vehicle is currently Unlocked");
			status = "Unlocked";
		}
		else{
			Log.info("Vehicle status is currently undefined");
			status = "Undefined";
		}
		return status;	
	}
	
	/**
     * Gets the status of the lock unlock remote command for EV 1.0 vehicle
     * 
     * @param driver WebDriver
     * @return status status of the lock unlock remote command for EV 1.0 vehicle
     * 
     */
	public static String lockUnlockStatusEV1(WebDriver driver){
		String status = null;
		if(Utils.waitForElementToBeVisible(driver, LockUnlockPage.statusLockEV1(driver)))
		{
			Log.info("Vehicle is currently locked");
			status = "Locked";
		}
		else if(Utils.waitForElementToBeVisible(driver, LockUnlockPage.statusUnlockEV1(driver))){
			Log.info("Vehicle is currently Unlocked");
			status = "Unlocked";
		}
		else{
			Log.info("Vehicle status is currently undefined");
			status = "Undefined";
		}
		return status;	
	}
	
	/**
     * Gets the sync time of the vehicle after the lock unlock remote command.
     * 
     * @param driver WebDriver
     * @return syncTime sync time for the vehicle after the lock unlock remote command.
     * 
     */
	public static String getSyncTime(WebDriver driver){
		
		// Get the sync time of the remote vehicle
		String syncTime = ActionModule.getText(driver, LockUnlockPage.syncedTime(driver), "Sync time value", "Vehicle page");
	    Log.info("Sync time value is : "+syncTime);		
		return syncTime;
		
	}
	
	/**
     * Gets the sync time of the vehicle after the lock unlock remote command for EV 1.0 vehicle
     * 
     * @param driver WebDriver
     * @return syncTime sync time for the vehicle after the lock unlock remote command for EV 1.0 vehicle
     * 
     */
	public static String getSyncTimeEV1(WebDriver driver){
		
		// Get the sync time of the remote vehicle EV 1.0
		String syncTime = ActionModule.getText(driver, LockUnlockPage.vehicleSyncStatusEV1(driver), "Sync time value", "Vehicle page");
	    Log.info("Sync time value is : "+syncTime);		
		return syncTime;
		
	}
	
	/**
     * Unlock the vehicle and verify the email after the remote command
     * 
     * @param driver WebDriver
     */
	public static boolean unlockVehicle(WebDriver driver) {
		String email=Utils.getUserName();
		String emailPassword=Utils.getGmailPassword();
		boolean checkCommandStatusAndSyncTime = false;
		String vehicleStatus = lockUnlockStatus(driver);
		String syncTimeBeforeRemoteCommand = getSyncTime(driver);
		if(vehicleStatus == "Locked"){
			
			// Unlock the vehicle if that is locked
			ActionModule.click(driver,LockUnlockPage.unlockButton(driver), "Unlock button", "Lock unlock page");
			
			// Wait for pending unlock status to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingUnlockStatus(driver));
			Utils.sleep(driver, 20000);
		}
		else{
			Log.info("Precondition Not met and vehicle is already in Unlocked state");
			// Lock the vehicle if that is unlocked
			ActionModule.click(driver,LockUnlockPage.lockButton(driver), "lock button", "Lock unlock page");
						
			// Wait for pending lock status to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingLockStatus(driver));
			Utils.sleep(driver, 20000);
			String updatedVehicleStatus = lockUnlockStatus(driver);
			if(updatedVehicleStatus == "Locked"){
				// Unlock the vehicle if that is locked
				ActionModule.click(driver,LockUnlockPage.unlockButton(driver), "Unlock button", "Lock unlock page");
				
				// Wait for pending unlock status to be invisible
				Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingUnlockStatus(driver));
				Utils.sleep(driver, 20000);
			}
		}
		// Get the sync time after the remote command execution
		String syncTimeAfterRemoteCommand = getSyncTime(driver);
		String updatedVehicleStatus = lockUnlockStatus(driver);
		// Validate the remote command status and sync time difference
		if(updatedVehicleStatus == "Unlocked" && syncTimeBeforeRemoteCommand !=syncTimeAfterRemoteCommand){
		Log.info("Remote command execute fine current status of vehicle is : "+ updatedVehicleStatus + " and Current Sync time is : "+ syncTimeAfterRemoteCommand);
		checkCommandStatusAndSyncTime = true;
		}
		else{
		Log.info("Remote command is not working current status of vehicle is : "+ updatedVehicleStatus);
		}
		
		// Verify the email is present for the successful remote command.
		if (EMail.execute("Vehicle Unlocked!", email, emailPassword, true)) {
			Log.info("Successful Vehicle unlock mail has been received by user at "
					+ email);
		}
		else {
			Log.error("Successful Vehicle unlock has not been received by user at "
					+ email);            
			Reporter.log("Successful Vehicle unlock has not been received by user at "
					+ email);
			Assert.fail("Successful Vehicle unlock has not been received by user at "
					+ email);
		}
		Utils.sleep(driver, 120000);
		return checkCommandStatusAndSyncTime;
	}
	
	/**
     * Lock the vehicle and verify the email after the remote command
     * 
     * @param driver WebDriver
     */
	public static boolean lockVehicle(WebDriver driver) {
		String email=Utils.getUserName();
		String emailPassword=Utils.getGmailPassword();
		boolean checkCommandStatusAndSyncTime = false;
		String vehicleStatus = lockUnlockStatus(driver);
		String syncTimeBeforeRemoteCommand = getSyncTime(driver);
		if(vehicleStatus == "Unlocked"){
			
			// Lock the vehicle if that is unlocked
			ActionModule.click(driver,LockUnlockPage.lockButton(driver), "lock button", "Lock unlock page");
			
			// Wait for pending lock status to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingLockStatus(driver));
			Utils.sleep(driver, 20000);
		}
		else{
				Log.info("Precondition Not met and vehicle is already in Locked state");
				// Unlock the vehicle if that is locked
				ActionModule.click(driver,LockUnlockPage.unlockButton(driver), "Unlock button", "Lock unlock page");
				
				// Wait for pending unlock status to be invisible
				Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingUnlockStatus(driver));
				Utils.sleep(driver, 20000);
				String updatedVehicleStatus = lockUnlockStatus(driver);
				if(updatedVehicleStatus == "Unlocked"){
					// Lock the vehicle if that is unlocked
					ActionModule.click(driver,LockUnlockPage.lockButton(driver), "lock button", "Lock unlock page");
					
					// Wait for pending lock status to be invisible
					Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingLockStatus(driver));
					Utils.sleep(driver, 20000);
				}
		}
		// Get the sync time after the remote command execution
		String syncTimeAfterRemoteCommand = getSyncTime(driver);
		String updatedVehicleStatus = lockUnlockStatus(driver);
		// Validate the remote command status and sync time difference
		if(updatedVehicleStatus == "Locked" && syncTimeBeforeRemoteCommand !=syncTimeAfterRemoteCommand){
			Log.info("Remote command executed fine current status of vehicle is : "+ updatedVehicleStatus + " and Current Sync time is : "+ syncTimeAfterRemoteCommand);
			checkCommandStatusAndSyncTime = true;
		}
		else{
			Log.info("Remote command is not working current status of vehicle is : "+ updatedVehicleStatus);
		}

		
		// Verify the email is present for the successful remote command.
		if (EMail.execute("Vehicle Unlocked!", email, emailPassword, true)) {
			Log.info("Successful Vehicle unlock mail has been received by user at "
					+ email);
		}
		else {
			Log.error("Successful Vehicle unlock has not been received by user at "
					+ email);            
			Reporter.log("Successful Vehicle unlock has not been received by user at "
					+ email);
			Assert.fail("Successful Vehicle unlock has not been received by user at "
					+ email);
		}
		Utils.sleep(driver, 120000);
		return checkCommandStatusAndSyncTime;
	}
	
	/**
     * Validates the notification and command log after the remote command
     * 
     * @param driver WebDriver
     * @return notificationAndCommandStatus return true in the case of notification and command found in command log
     * 
     */
	public static boolean checkNotificationAndCommandLogForRemoteCommand(WebDriver driver, String remoteCommand){
		
		String vehicleStatus = lockUnlockStatus(driver);
		boolean notificationAndCommandStatus = false;
		if(vehicleStatus == remoteCommand){
		
		// Navigate to the notifications tab
		ActionModule.click(driver, HeaderPage.notifications_Link(driver), "notifications_Link", "HeaderPage");
		Utils.sleep(driver, 2000);
		
		// Verify the notification is present for the remote command
		ActionModule.isDisplayed(driver,LockUnlockPage.vehicleRemoteNotification(driver), "vehicleNotification", "Lock unlock page");
		Utils.sleep(driver, 2000);
		
		// Navigate to settings tab
		ActionModule.click(driver, HeaderPage.settingsLink(driver), "settingsLink", "HeaderPage");
		Utils.sleep(driver, 2000);
		
		// Go to command log link
		ActionModule.click(driver, HeaderPage.commandLogLink(driver), "commandLogLink", "HeaderPage");
		
		// Check the remote command
		ActionModule.isDisplayed(driver, HeaderPage.doorCommandLog(driver), "remoteCommandLog", "HeaderPage");
		
		// Verify the status of the remote command in command log
		String statusCommand=HeaderPage.doorCommandLog(driver).getAttribute("class");
		if(statusCommand.contains("green"))
		{
			Log.info("Remote command found for Door");
			notificationAndCommandStatus = true;
		}
		else
		{	
			Log.error("Command not found or command failed ");
			Assert.fail("Command not found or command failed ");
		}
		}
		else{
			Log.info("The Door is already in " + remoteCommand + "state");
		}		
		return notificationAndCommandStatus;
		
	}
	
	/**
     * Unlock the vehicle and verify the status
     * 
     * @param driver WebDriver
     * @return checkCommandStatusAndSyncTime return true in the case of Unlock the vehicle command works fine 
     */
	public static boolean checkUnlockEV1(WebDriver driver){
		String email=Utils.getUserName();
		String emailPassword=Utils.getGmailPassword();
		boolean checkCommandStatusAndSyncTime = false;
		Utils.sleep(driver, 2000);
		
		// Get the vehicle lock unlock status 
		String vehicleStatus = lockUnlockStatusEV1(driver);
		Log.info("Vehicle status is : "+ vehicleStatus);
		
		// Get the sync time before the remote command execution
		String syncTimeBeforeRemoteCommand = getSyncTimeEV1(driver);
		if(vehicleStatus == "Locked"){
			
			// Unlock the vehicle if that is in the locked state
			ActionModule.click(driver,LockUnlockPage.unlockButtonEV1(driver), "Unlock buttonEV1", "Lock unlock page");
			
			// Wait for pending unlock status to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingUnlockStatusEV1(driver));
			
			// Wait for vehicle status bar message to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.unlockingVehicleStatusBarMessageEV1(driver));
			Utils.sleep(driver, 20000);
		}
		
		else {
			Log.info("Precondition Not met ");
			// Lock the vehicle if that is in the unlocked state
			ActionModule.click(driver,LockUnlockPage.lockButtonEV1(driver), "Lock buttonEV1", "Lock unlock page");
						
			// Wait for pending unlock status to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingLockStatusEV1(driver));
						
			// Wait for vehicle status bar message to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.lockingVehicleStatusBarMessageEV1(driver));
			Utils.sleep(driver, 20000);
			String updatedVehicleStatus = lockUnlockStatusEV1(driver);
			if(updatedVehicleStatus == "Locked"){
				
				// Unlock the vehicle if that is in the locked state
				ActionModule.click(driver,LockUnlockPage.unlockButtonEV1(driver), "Unlock buttonEV1", "Lock unlock page");
				
				// Wait for pending unlock status to be invisible
				Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingUnlockStatusEV1(driver));
				
				// Wait for vehicle status bar message to be invisible
				Utils.waitForElementToBeInvisible(driver, LockUnlockPage.unlockingVehicleStatusBarMessageEV1(driver));
				Utils.sleep(driver, 20000);
			}
		}
		
		// Get the sync time after the remote command execution
		String syncTimeAfterRemoteCommand = getSyncTimeEV1(driver);
		String updatedVehicleStatus = lockUnlockStatusEV1(driver);
		// Validate the vehicle lock unlock status after the remote command execution and sync time difference
		if(updatedVehicleStatus == "Unlocked" && syncTimeBeforeRemoteCommand !=syncTimeAfterRemoteCommand){
			Log.info("Remote command execute fine current status of vehicle is : "+ updatedVehicleStatus + " and Current Sync time is : "+ syncTimeAfterRemoteCommand);
			checkCommandStatusAndSyncTime = true;
		}
		else{
			Log.info("Remote command is not working current status of vehicle is : "+ updatedVehicleStatus);
		}
		
		// Verify the email is present for the successful remote command.
		if (EMail.execute("Vehicle Unlocked!", email, emailPassword, true)) {
			Log.info("Successful Vehicle unlock mail has been received by user at "
					+ email);
		}
		else {
			Log.error("Successful Vehicle unlock has not been received by user at "
					+ email);            
			Reporter.log("Successful Vehicle unlock has not been received by user at "
					+ email);
			Assert.fail("Successful Vehicle unlock has not been received by user at "
					+ email);
		}
		Utils.sleep(driver, 120000);
		return checkCommandStatusAndSyncTime;
	}
	
	/**
     * Lock the vehicle and verify the status
     * 
     * @param driver WebDriver
     * @return checkCommandStatusAndSyncTime return true in the case of Lock the vehicle command works fine 
     */
	public static boolean checkLockEV1(WebDriver driver){
		String email=Utils.getUserName();
		String emailPassword=Utils.getGmailPassword();
		boolean checkCommandStatusAndSyncTime = false;
		Utils.sleep(driver, 2000);
		
		// Get the vehicle lock unlock status 
		String vehicleStatus = lockUnlockStatusEV1(driver);
		Log.info("Vehicle status is : "+ vehicleStatus);
		
		// Get the sync time before the remote command execution
		String syncTimeBeforeRemoteCommand = getSyncTimeEV1(driver);
		if(vehicleStatus == "Unlocked"){
			
			// Lock the vehicle if that is in the unlocked state
			ActionModule.click(driver,LockUnlockPage.lockButtonEV1(driver), "Lock buttonEV1", "Lock unlock page");
			
			// Wait for pending unlock status to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingLockStatusEV1(driver));
			
			// Wait for vehicle status bar message to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.lockingVehicleStatusBarMessageEV1(driver));
			Utils.sleep(driver, 20000);
		}		
		else {
			Log.info("Precondition Not met ");
			// Unlock the vehicle if that is in the locked state
			ActionModule.click(driver,LockUnlockPage.unlockButtonEV1(driver), "Unlock buttonEV1", "Lock unlock page");
						
			// Wait for pending unlock status to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingUnlockStatusEV1(driver));
						
			// Wait for vehicle status bar message to be invisible
			Utils.waitForElementToBeInvisible(driver, LockUnlockPage.unlockingVehicleStatusBarMessageEV1(driver));
			Utils.sleep(driver, 20000);
			String updatedVehicleStatus = lockUnlockStatusEV1(driver);
			if(updatedVehicleStatus == "Unlocked"){
				
				// Lock the vehicle if that is in the unlocked state
				ActionModule.click(driver,LockUnlockPage.lockButtonEV1(driver), "Lock buttonEV1", "Lock unlock page");
				
				// Wait for pending unlock status to be invisible
				Utils.waitForElementToBeInvisible(driver, LockUnlockPage.pendingLockStatusEV1(driver));
				
				// Wait for vehicle status bar message to be invisible
				Utils.waitForElementToBeInvisible(driver, LockUnlockPage.lockingVehicleStatusBarMessageEV1(driver));
				Utils.sleep(driver, 20000);
			}	
		}
		
		// Get the sync time after the remote command execution
		String syncTimeAfterRemoteCommand = getSyncTimeEV1(driver);
		String updatedVehicleStatus = lockUnlockStatusEV1(driver);
		// Validate the vehicle lock unlock status after the remote command execution and sync time difference
		if(updatedVehicleStatus == "Locked" && syncTimeBeforeRemoteCommand !=syncTimeAfterRemoteCommand){
			Log.info("Remote command execute fine current status of vehicle is : "+ updatedVehicleStatus + " and Current Sync time is : "+ syncTimeAfterRemoteCommand);
			checkCommandStatusAndSyncTime = true;
		}
		else{
			Log.info("Remote command is not working current status of vehicle is : "+ updatedVehicleStatus);
		}
		
		// Verify the email is present for the successful remote command.
		if (EMail.execute("Vehicle Locked!", email, emailPassword, true)) {
			Log.info("Successful Vehicle lock mail has been received by user at "
					+ email);
		}
		else {
			Log.error("Successful Vehicle lock has not been received by user at "
					+ email);            
			Reporter.log("Successful Vehicle lock has not been received by user at "
					+ email);
			Assert.fail("Successful Vehicle lock has not been received by user at "
					+ email);
		}
		Utils.sleep(driver, 120000);
		return checkCommandStatusAndSyncTime;
	}
	
}
