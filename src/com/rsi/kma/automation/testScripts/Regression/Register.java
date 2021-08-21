package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.RegisterModule;
import com.rsi.kma.automation.utility.BaseClass;

public class Register extends BaseClass{

	
	
	
	@Test(description = "TC_01",groups ={ "NoLogin"})
	public void checkBlankFields( )
	{
		
		RegisterModule.blankFieldMessage(driver);
	}
	
	
	
	@Test(description = "TC_02",groups ={ "NoLogin"})
	public void checkInvalidEmail( )
	{
		
		RegisterModule.invalidEmailFormat(driver);
		
		
	}
	
	
	@Test(description = "TC_03",groups ={ "NoLogin"})
	public void checkInvalidPassword( )
	{
		
		RegisterModule.invalidPassswordFormat(driver);
		
		
	}
	
	@Test(description = "TC_04",groups ={ "NoLogin"})
	public void checkInvalidMobileNo( )
	{
		
		RegisterModule.invalidPhoneNo(driver);;
		
		
	}
	@Test(description = "TC_04",groups ={ "NoLogin"})
	public void checkLinks( )
	{
		RegisterModule.checkTermsOfServiceLink(driver);
		RegisterModule.checkPrivacyPolicyLink(driver);
		
		
	}
	
	@Test(description = "TC_05",groups ={ "NoLogin"})
	public void accountCreation( )
	{
		RegisterModule.accountCreation(driver);
		
		
		
	}
	@Test(description = "TC_05",groups ={ "NoLogin"})
	public void successfullLogin( )
	{
		RegisterModule.newAccount(driver);
		
		
		
	}
	
}
