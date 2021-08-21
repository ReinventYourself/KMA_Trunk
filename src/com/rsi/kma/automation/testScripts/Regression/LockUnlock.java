package com.rsi.kma.automation.testScripts.Regression;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.LockUnlockModule;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.Utils;

/**
 * The LockUnclok class will verify all the links, functionalities of the
 * Lock Unlock page.
 *
 *
 * @version 1.0 02/02/18
 * @author Aditya Narayan 
 */

public class LockUnlock extends BaseClass{

	@Test(description = "TS_01a" ,groups = {"EV 1.0"})
	public void unlockDoorsEV1(){
		
		Log.info("platform is :"+ Utils.getPlatform());
		
		
		// Navigate to Lock Unlock page
		LockUnlockModule.NavigateToLockUnlockPage(driver);
		
		// Validate the unlock vehicle functionality for EV1 and email verification for remote command
		assertTrue(LockUnlockModule.checkUnlockEV1(driver), "Remote command didn't work properly");

	}
	
	@Test(description = "TS_02a" ,groups = {"EV 1.0"})
	public void lockDoorsEV1(){
		
		Log.info("platform is :"+ Utils.getPlatform());
		
		
		// Navigate to Lock Unlock page
		LockUnlockModule.NavigateToLockUnlockPage(driver);
		
		// Validate the lock vehicle functionality for EV1 and email verification for remote command 
		assertTrue(LockUnlockModule.checkLockEV1(driver), "Remote command didn't work properly");

	}
	
	@Test(description = "TS_01" ,groups = {"JF PHEV","K900","EV 2.0"})
	public void unlockDoors(){
		
		Log.info("platform is :"+ Utils.getPlatform());
		
		
		// Navigate to Lock Unlock page
		LockUnlockModule.NavigateToLockUnlockPage(driver);
		
		// Validate the unlock vehicle functionality and email verification for remote command
		assertTrue(LockUnlockModule.unlockVehicle(driver), "Remote command didn't work properly");
		
		// Verifies the status of the remote command in the notifications and command log
		assertTrue(LockUnlockModule.checkNotificationAndCommandLogForRemoteCommand(driver, "Unlocked"), "The notification or command log shows error");
	}
	
	@Test(description = "TS_02" ,groups = {"JF PHEV","DE PHEV","K900","EV 2.0"})
	public void lockDoors(){
		
		Log.info("platform is :"+ Utils.getPlatform());
		
		
		// Navigate to Lock Unlock page
		LockUnlockModule.NavigateToLockUnlockPage(driver);
		
		// Validate the lock vehicle functionality and email verification for remote command
		assertTrue(LockUnlockModule.lockVehicle(driver), "Remote command didn't work properly");
		
		// Verifies the status of the remote command in the notifications and command log
		assertTrue(LockUnlockModule.checkNotificationAndCommandLogForRemoteCommand(driver, "Locked"), "The notification or command log shows error");
	}
	
}
