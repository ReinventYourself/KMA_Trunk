package com.rsi.kma.automation.testScripts.Regression;

import org.testng.annotations.Test;

import com.rsi.kma.automation.modules.AwardsModule;
import com.rsi.kma.automation.modules.WebDCSModule;
import com.rsi.kma.automation.utility.BaseClass;
import com.rsi.kma.automation.utility.Utils;

public class Awards extends BaseClass{




	@Test(description = "TC_01",groups ={ "New Vehicle"})
	public void GrowingGarageAward( )
	{
		AwardsModule.navigateToAwardsPage(driver);

		AwardsModule.GrowingGarage(driver);

		AwardsModule.checkAwardsWon(driver,  BaseClass.getTestMethodName());

	}


	@Test(description = "TC_02",groups ={ "New Vehicle"})
	public void PoweUserAward( )
	{
		AwardsModule.navigateToAwardsPage(driver);

		AwardsModule.PoweUserAward(driver);

		AwardsModule.checkAwardsWon(driver,  BaseClass.getTestMethodName());

	}
	@Test(description = "TC_03",groups ={ "New Vehicle"})
	public void GettingIntersetedAward( )
	{
		AwardsModule.navigateToAwardsPage(driver);

		AwardsModule.GettingIntersetedAward(driver);;

		AwardsModule.checkAwardsWon(driver,  BaseClass.getTestMethodName());

	}


	@Test(description = "TC_04",groups ={ "New Vehicle"})
	public void TravellerAward( )
	{
		AwardsModule.navigateToAwardsPage(driver);

		AwardsModule.TravellerAward(driver);;

		AwardsModule.checkAwardsWon(driver,  BaseClass.getTestMethodName());

	}

	@Test(description = "TC_05",groups ={ "New Vehicle"})
	public void checkAboutAwards( )
	{
		AwardsModule.navigateToAwardsPage(driver);

		AwardsModule.checkAwards(driver);;


	}

	@Test(description = "TC_01",groups ={ "New Vehicle"})
	public void SchedulerAward( )
	{

		AwardsModule.navigateToAwardsPage(driver);

		AwardsModule.schedulerAward(driver);

		WebDCSModule.checkMachineOS();

		WebDCSModule.webDCS( Utils.getUserName());

		AwardsModule.navigateToAwardsPage(driver);

		AwardsModule.checkAwardsWon(driver,  BaseClass.getTestMethodName());

	}
}
