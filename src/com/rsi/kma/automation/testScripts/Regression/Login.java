package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.ForgotPasswordModule;
import com.rsi.kma.automation.utility.BaseClass;

public class Login extends BaseClass{

	
	@Test(description = "TC_01",groups ={ "NoLogin"})
	public void ForgotPasswordEmail( )
	{
		
		ForgotPasswordModule.checkByEmail(driver);
		
	}
	
	
	
	@Test(description = "TC_02",groups ={ "NoLogin"})
	public void AnswerSecurityQuestions( )
	{
		
		ForgotPasswordModule.checkBySecurityQues(driver);;
		
		
	}
	
	@Test(description = "TC_03",groups ={ "NoLogin"})
	public void InvalidEmailforForgotPassword( )
	{
		
		ForgotPasswordModule.checkEmail(driver);
	}
	
	@Test(description = "TC_04",groups ={ "JF PHEV","DE PHEV","K900","Connected_AVN","Connected_UVO","EV 2.0","EV 1.0"})
	public void checkSuccessfulLogin( )
	{
		
		ForgotPasswordModule.checkValidlogin(driver);
		
	}

	
	@Test(description = "TC_05",groups ={"NoLogin"})
	public void checkInValidLogin( )
	{
		
		ForgotPasswordModule.checkInValidlogin(driver);
		
	}
	
	}
