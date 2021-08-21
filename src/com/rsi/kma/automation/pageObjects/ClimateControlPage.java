package com.rsi.kma.automation.pageObjects;





import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.rsi.kma.automation.utility.FindWebElement;


public class ClimateControlPage {

	private static Logger Log = Logger.getLogger(ClimateControlPage.class.getName());
	private static WebElement webElement = null;

	public static class TemperatureGauge {




		public static WebElement outsideTempText (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//p[text()='OUTSIDE TEMPERATURE ']","outsideTempText","ClimateControlPage");
			return webElement;

		}
//        public static WebElement temperature_Slider (WebDriver driver) {
//            
//                webElement = FindWebElement.byXpath(driver,"//*[@class='ui-draggable']","decrease_Temperature","ClimateControlPage");
//               
//            return webElement;
//        }
//        
//        public static WebElement ventilationWarning (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//h4[contains(text(),'Ventilation Warning')]","ventilationWarning","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement confirmWarning (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'startClimate') and contains(text(),'Confirm')]","confirmWarning","ClimateControlPage");
//           
//        return webElement;
//        }
//        
        public static WebElement confirmWarningSchedule (WebDriver driver) {
            
            webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'selectedModal') and contains(text(),'Confirm')]","confirmWarningSchedule","ClimateControlPage");
           
        return webElement;
        }
//        
//        public static WebElement cancelWarning (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'close') and contains(text(),'Cancel')]","confirmWarning","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement startClimateButton (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//button[contains(@ng-click,'openConfirmModal') and contains(text(),'START CLIMATE')]","startClimateButton","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement stopClimateButton (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//button[contains(@ng-click,'stopClimate') and contains(text(),'STOP CLIMATE')]","startClimateButton","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement defrosterOff (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-hide,'climateOn') and contains(text(),'off')]","defroster off","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement defrosterOn (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-hide,'climateOn') and contains(text(),'on')]","defroster off","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement startingClimateText (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'STARTING CLIMATE')]","startingClimateText","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement stoppingClimateText (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'STOPPING CLIMATE')]","stoppingClimateText","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement climateOnText (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'CLIMATE IS ON')]","climateOnText","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement settingClimateText (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Setting climate control')]","settingClimateText","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement vehicleRemoteNotificationClimateStart(WebDriver driver) {

        public static WebElement temperature_Slider (WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//*[@class='ui-draggable']","decrease_Temperature","ClimateControlPage");
               
            return webElement;
        }
        
//        public static WebElement ventilationWarning (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//h4[contains(text(),'Ventilation Warning')]","ventilationWarning","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement confirmWarning (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'startClimate') and contains(text(),'Confirm')]","confirmWarning","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement cancelWarning (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'close') and contains(text(),'Cancel')]","confirmWarning","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement startClimateButton (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//button[contains(@ng-click,'openConfirmModal') and contains(text(),'START CLIMATE')]","startClimateButton","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement stopClimateButton (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//button[contains(@ng-click,'stopClimate') and contains(text(),'STOP CLIMATE')]","startClimateButton","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement defrosterOff (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-hide,'climateOn') and contains(text(),'off')]","defroster off","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement defrosterOn (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-hide,'climateOn') and contains(text(),'on')]","defroster off","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement startingClimateText (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'STARTING CLIMATE')]","startingClimateText","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement stoppingClimateText (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'STOPPING CLIMATE')]","stoppingClimateText","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement climateOnText (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'CLIMATE IS ON')]","climateOnText","ClimateControlPage");
//           
//        return webElement;
//        }
//        
//        public static WebElement settingClimateText (WebDriver driver) {
//            
//            webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Setting climate control')]","settingClimateText","ClimateControlPage");
//           
//        return webElement;
//        }
        
        public static WebElement vehicleRemoteNotificationClimateStart(WebDriver driver) {
        	
        	webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'info') and contains(text(),'WAS STARTED')]","vehicleRemoteNotificationClimateStart","LockUnlockPage");
			return webElement;
		}



        	


//		public static WebElement temperature_Slider (WebDriver driver) {
//
//
//        	webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'info') and contains(text(),'WAS STOPPED')]","vehicleRemoteNotificationClimateStop","LockUnlockPage");
////||||||| .r9162
////        	webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'info') and contains(text(),'CLIMATE WAS STOPPED')]","vehicleRemoteNotificationClimateStop","LockUnlockPage");
////=======
////			webElement = FindWebElement.byXpath(driver,"//*[@class='ui-draggable']","decrease_Temperature","ClimateControlPage");
////>>>>>>> .r9168
//
//			return webElement;
//		}

		public static WebElement ventilationWarning (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//h4[contains(text(),'Ventilation Warning')]","ventilationWarning","ClimateControlPage");

			return webElement;
		}

		public static WebElement confirmWarning (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'startClimate') and contains(text(),'Confirm')]","confirmWarning","ClimateControlPage");

			return webElement;
		}

		public static WebElement cancelWarning (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'close') and contains(text(),'Cancel')]","confirmWarning","ClimateControlPage");

			return webElement;
		}

		public static WebElement startClimateButton (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//button[contains(@ng-click,'openConfirmModal') and contains(text(),'START CLIMATE')]","startClimateButton","ClimateControlPage");

			return webElement;
		}

		public static WebElement stopClimateButton (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//button[contains(@ng-click,'stopClimate') and contains(text(),'STOP CLIMATE')]","startClimateButton","ClimateControlPage");

			return webElement;
		}

		public static WebElement defrosterOff (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-hide,'climateOn') and contains(text(),'off')]","defroster off","ClimateControlPage");

			return webElement;
		}

		public static WebElement defrosterOn (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-hide,'climateOn') and contains(text(),'on')]","defroster off","ClimateControlPage");

			return webElement;
		}

		public static WebElement startingClimateText (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'STARTING CLIMATE')]","startingClimateText","ClimateControlPage");

			return webElement;
		}

		public static WebElement stoppingClimateText (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'STOPPING CLIMATE')]","stoppingClimateText","ClimateControlPage");

			return webElement;
		}

		public static WebElement climateOnText (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//p[contains(text(),'CLIMATE IS ON')]","climateOnText","ClimateControlPage");

			return webElement;
		}

		public static WebElement settingClimateText (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Setting climate control')]","settingClimateText","ClimateControlPage");

			return webElement;
		}

//		public static WebElement vehicleRemoteNotificationClimateStart(WebDriver driver) {
//
//			webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'info') and contains(text(),'CLIMATE WAS STARTED')]","vehicleRemoteNotificationClimateStart","LockUnlockPage");
//
//			return webElement;      
//		}

		public static WebElement vehicleRemoteNotificationClimateStop(WebDriver driver) {

			webElement= FindWebElement.byXpath(driver,"//div[contains(@class,'info') and contains(text(),'CLIMATE WAS STOPPED')]","vehicleRemoteNotificationClimateStop","LockUnlockPage");

			return webElement;      
		}
	}
	public static WebElement decrease_Temperature (WebDriver driver) {

		webElement = FindWebElement.byId(driver,"minus","decrease_Temperature","ClimateControlPage");

		return webElement;
	}

	public static WebElement increase_Temperature (WebDriver driver) {

		webElement = FindWebElement.byId(driver,"plus","decrease_Temperature","ClimateControlPage");

		return webElement;
	}

	public static WebElement send_Button (WebDriver driver) {

		webElement = FindWebElement.byId(driver,"send","decrease_Temperature","ClimateControlPage");

		return webElement;
	}

	public static WebElement temperature (WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@id='tempC']/span","decrease_Temperature","ClimateControlPage");

		return webElement;
	}

	public static WebElement temperature_Slider (WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='ui-draggable']","decrease_Temperature","ClimateControlPage");

		return webElement;
	}


	public static class TemperaturePanel {

		public static WebElement farenheit (WebDriver driver) {

			webElement = FindWebElement.byId(driver,"f","decrease_Temperature","ClimateControlPage");

			return webElement;
		}

		public static WebElement celcius (WebDriver driver) {

			webElement = FindWebElement.byId(driver,"c","decrease_Temperature","ClimateControlPage");

			return webElement;
		}

		public static WebElement outside_Temperature (WebDriver driver) {

			webElement = FindWebElement.byId(driver,"outside-temp","decrease_Temperature","ClimateControlPage");                        

			return webElement;
		}

		public static WebElement defroster_Disabled (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@id='disableDefrost']/a","decrease_Temperature","ClimateControlPage");                        

			return webElement;
		}

		public static WebElement defroster_Start (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@id='startDefrost']/a","decrease_Temperature","ClimateControlPage");                        

			return webElement;
		}

		public static WebElement defroster_Stop (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@id='stopDefrost']/a","decrease_Temperature","ClimateControlPage");                        

			return webElement;
		}
	}

	public static class ClimateSchedule {

		public static WebElement lastUpdatedAt (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='req-schedule']/p","decrease_Temperature","ClimateControlPage");                        

			return webElement;
		}

		public static WebElement requestSchedule_button (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='req-schedule']//img","decrease_Temperature","ClimateControlPage");                        

			return webElement;
		}

		public static class ScheduleI {

			public static WebElement expandSchedule (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='arrow-btn-two' and @class='down']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement collapseSchedule (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='arrow-btn-two' and @class='down up']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement schedule_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='hvac-set-two' and @class='off']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule1_On_Off_Button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-class,'climatestatus[1]')]","schedule1_On_Off_Button","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule2_On_Off_Button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-class,'climatestatus[2]')]","schedule2_On_Off_Button","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement schedule_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='hvac-set-two' and @class='off on']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement time_Selected (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='time-hvac-two']/span","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement am_pm_Selected (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='time-hvac-two']/node()[not(self::span)]","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement days_Selected (WebDriver driver) {

				webElement = FindWebElement.byId(driver,"date-hvac","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement defroster_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='defrost-set-one' and @class='off']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement defroster1_Button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-class,'defrosterstatus[1]')]","defroster1_Button","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule1_hour_value (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleI']/div[@class='calendar']/div/div[contains(@class,'time-hvac-hour')]","schedule1_hour_value","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement newHourScheduleI(WebDriver driver,String hour) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='hour-list']/li[text()='"+hour+"']","newHourScheduleI","ClimateControlPage");

				return webElement;
			}
			
			public static WebElement newHourScheduleII(WebDriver driver,String hour) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='hour-list2']/li[text()='"+hour+"']","newHourScheduleII","ClimateControlPage");

				return webElement;
			}
			
			public static WebElement schedule2_hour_value (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleII']/div[@class='calendar']/div/div[contains(@class,'time-hvac-hour')]","schedule2_hour_value","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule1_minute_value (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleI']/div[@class='calendar']/div/div[contains(@class,'time-hvac-minute')]","schedule1_minute_value","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement newMinScheduleI(WebDriver driver,String min) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='minute-list']/li[text()='"+min+"']","newMinScheduleI off ","ClimateControlPage");

				return webElement;
			}
			
			public static WebElement newMinScheduleII(WebDriver driver,String min) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='minute-list2']/li[text()='"+min+"']","newMinScheduleII off ","ClimateControlPage");

				return webElement;
			}
			
			public static WebElement schedule1_am_pm_value (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleI']/div[@class='calendar']/div/div[contains(@class,'time-hvac-section')]","schedule1_minute_value","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement newScheduleI_am_pm_value(WebDriver driver,String ampm) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='am-pm-list']/li[text()='"+ampm+"']", "newScheduleI_am_pm_value ","ClimateControlPage");

				return webElement;
			}
			
			public static WebElement newScheduleII_am_pm_value(WebDriver driver,String ampm) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='am-pm-list2']/li[text()='"+ampm+"']", "newScheduleI_am_pm_value ","ClimateControlPage");

				return webElement;
			}
			
			public static WebElement schedule2_am_pm_value (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleII']/div[@class='calendar']/div/div[contains(@class,'time-hvac-section')]","schedule1_minute_value","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule2_minute_value (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleII']/div[@class='calendar']/div/div[contains(@class,'time-hvac-minute')]","schedule2_minute_value","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule1_day_selected (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleI']/div[@class='calendar']/div/div[contains(@class,'selected')]","schedule1_day_selected","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule2_day_selected (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleII']/div[@class='calendar']/div/div[contains(@class,'selected')]","schedule2_day_selected","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule1_day_monday (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleI']/div[@class='calendar']/div/div[contains(text(),'MON')]","schedule1_day_monday","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule2_day_monday (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleII']/div[@class='calendar']/div/div[contains(text(),'MON')]","schedule2_day_monday","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule1_cancel_button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleI']/div[contains(@class,'scheduleBtnWrap')]/div[@class='btnCancel']/button","schedule1_cancel_button","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule2_cancel_button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleII']/div[contains(@class,'scheduleBtnWrap')]/div[@class='btnCancel']/button","schedule2_cancel_button","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule1_setSchedule_button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleI']/div[contains(@class,'scheduleBtnWrap')]/div[@class='btnSchedule']/button","schedule1_setSchedule_button","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule2_setSchedule_button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleII']/div[contains(@class,'scheduleBtnWrap')]/div[@class='btnSchedule']/button","schedule2_setSchedule_button","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule_confirm_alert_button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-click,'selectedModal') and contains(text(),'Confirm')]","schedule_confirm_alert_button","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule1_success_button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleI']/div/div[@class='btnSchedule']/div[@class='btnSuccess']","schedule1_success_button","ClimateControlPage");                        

				return webElement;
			}
			
			public static WebElement schedule2_success_button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleII']/div/div[@class='btnSchedule']/div[@class='btnSuccess']","schedule2_success_button","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement defroster2_Button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-class,'defrosterstatus[2]')]","defroster2_Button","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement defroster_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='defrost-set-one' and @class='off on']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement cancel_Button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climate-schedule-one']//img[@alt='btn Cancel']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement schedule_Button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climate-schedule-one']//img[@alt='btn Schedule']","decrease_Temperature","ClimateControlPage");                       

				return webElement;
			}

			public static class Temperature {

				public static WebElement temperature (WebDriver driver) {

					webElement = FindWebElement.byId(driver,"tempValueOneC","decrease_Temperature","ClimateControlPage");                       

					return webElement;
				}

				public static WebElement decrease_Temperature (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='sliderC']/div[@class='red-bar']//img","decrease_Temperature","ClimateControlPage");                       

					return webElement;
				}

				public static WebElement increase_Temperature (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='sliderC']/div[@class='blue-bar']//img","decrease_Temperature","ClimateControlPage");                       

					return webElement;
				}

				public static WebElement temperature_Slider (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='sliderOneC']/a","decrease_Temperature","ClimateControlPage");                       

					return webElement;
				}
			}

			public static class Calendar {

				public static boolean hour (WebDriver driver, String hour) {
					boolean selected = false;
					Actions action = new Actions(driver);


					webElement = FindWebElement.byId(driver,"time-hvacOne-hour","decrease_Temperature","ClimateControlPage");

					WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@id='time-hvacOne-hour']/following-sibling::div//ul[@class='hour-list']/li[text()='" + hour + "']","decrease_Temperature","ClimateControlPage");                            
					action.click(webElement).click(hour_To_Be_Selected).build().perform();                          

					selected = true;

					return selected;
				}

				public static boolean minute (WebDriver driver, String minutes) {
					boolean selected = false;
					Actions action = new Actions(driver);

					webElement = FindWebElement.byId(driver,"time-hvacOne-minute","decrease_Temperature","ClimateControlPage");
					WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@id='time-hvacOne-minute']//following-sibling::div//ul[@class='minute-list']/li[text()='" + minutes + "']","decrease_Temperature","ClimateControlPage");                            
					action.click(webElement).click(hour_To_Be_Selected).build().perform();                          

					selected = true;

					return selected;
				}

				public static boolean am_pm (WebDriver driver, String am_pm) {
					boolean selected = false;
					Actions action = new Actions(driver);

					webElement = FindWebElement.byId(driver,"time-hvacOne-section","decrease_Temperature","ClimateControlPage");
					WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@id='time-hvacOne-section']/following-sibling::div//ul/li[text()='" + am_pm + "']","decrease_Temperature","ClimateControlPage");                            
					action.click(webElement).click(hour_To_Be_Selected).build().perform();                          

					selected = true;

					return selected;
				}

				public static WebElement selected_Day (WebDriver driver, String day) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='weekDays-1']/*[@id='" + day + "' and contains(@class,'selected')]","decrease_Temperature","ClimateControlPage");                                                                                        

					return webElement;
				}

				public static WebElement notSelected_Day (WebDriver driver, String day) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='weekDays-1']/*[@id='" + day + "' and not(contains(@class,'selected'))]","decrease_Temperature","ClimateControlPage");                                    

					return webElement;
				}
			}
		}

		public static class ScheduleII {

			public static WebElement expandSchedule (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='arrow-btn-two' and @class='down']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement collapseSchedule (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='arrow-btn-two' and @class='down up']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement schedule_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='hvac-set-two' and @class='off']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement schedule_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='hvac-set-two' and @class='off on']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement time_Selected (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='time-hvac-two']/span","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement am_pm_Selected (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='time-hvac-two']/node()[not(self::span)]","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement days_Selected (WebDriver driver) {

				webElement = FindWebElement.byId(driver,"date-hvac-two","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement defroster_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='defrost-set-two' and @class='off']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement defroster_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='defrost-set-two' and @class='off on']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement cancel_Button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climate-schedule-two']//img[@alt='btn Cancel']","decrease_Temperature","ClimateControlPage");                        

				return webElement;
			}

			public static WebElement schedule_Button (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climate-schedule-two']//img[@alt='btn Schedule']","decrease_Temperature","ClimateControlPage");                       

				return webElement;
			}

			public static class Temperature {

				public static WebElement temperature (WebDriver driver) {

					webElement = FindWebElement.byId(driver,"tempValueTwoC","decrease_Temperature","ClimateControlPage");                       

					return webElement;
				}

				public static WebElement decrease_Temperature (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='sliderIIC']/div[@class='red-bar']//img","decrease_Temperature","ClimateControlPage");                       

					return webElement;
				}

				public static WebElement increase_Temperature (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='sliderIIC']/div[@class='blue-bar']//img","decrease_Temperature","ClimateControlPage");                       

					return webElement;
				}

				public static WebElement temperature_Slider (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='sliderTwoC']/a","decrease_Temperature","ClimateControlPage");                       

					return webElement;
				}
			}

			public static class Calendar {

				public static boolean hour (WebDriver driver, String hour) {
					boolean selected = false;
					Actions action = new Actions(driver);


					/**
					 * This is the web element of currently selected hour
					 */
					webElement = FindWebElement.byId(driver,"time-hvacTwo-hour","decrease_Temperature","ClimateControlPage");

					WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@id='time-hvacTwo-hour']/following-sibling::div//ul[@class='hour-list']/li[text()='" + hour + "']","decrease_Temperature","ClimateControlPage");                            
					action.click(webElement).click(hour_To_Be_Selected).build().perform();                          

					selected = true;

					return selected;
				}

				public static boolean minute (WebDriver driver, String minutes) {
					boolean selected = false;
					Actions action = new Actions(driver);

					webElement = FindWebElement.byId(driver,"time-hvacTwo-minute","decrease_Temperature","ClimateControlPage");

					WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@id='time-hvacTwo-minute']//following-sibling::div//ul[@class='minute-list']/li[text()='" + minutes + "']","decrease_Temperature","ClimateControlPage");                            
					action.click(webElement).click(hour_To_Be_Selected).build().perform();                          

					selected = true;

					return selected;
				}

				public static boolean am_pm (WebDriver driver, String am_pm) {
					boolean selected = false;
					Actions action = new Actions(driver);


					webElement = FindWebElement.byId(driver,"time-hvacTwo-section","decrease_Temperature","ClimateControlPage");

					WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@id='time-hvacTwo-section']/following-sibling::div//ul/li[text()='" + am_pm + "']","decrease_Temperature","ClimateControlPage");                            
					action.click(webElement).click(hour_To_Be_Selected).build().perform();                          

					selected = true;

					return selected;
				}

				public static WebElement selected_Day (WebDriver driver, String day) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='weekDays-2']/*[@id='" + day + "' and contains(@class,'selected')]","decrease_Temperature","ClimateControlPage");                                                                                        

					return webElement;
				}

				public static WebElement notSelected_Day (WebDriver driver, String day) {

					webElement = FindWebElement.byXpath(driver,"//*[@id='weekDays-2']/*[@id='" + day + "' and not(contains(@class,'selected'))]","decrease_Temperature","ClimateControlPage");                                    

					return webElement;
				}
			}
		}
	}
}
