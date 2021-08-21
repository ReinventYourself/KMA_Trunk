package com.rsi.kma.automation.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.rsi.kma.automation.utility.FindWebElement;


public class RemotePage {

	private static WebElement webElement = null;    

	public static class Engine_And_Climate {  

		public static WebElement engine_And_Climate_Tab(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//a[text()='Climate']","engine_And_Climate_Tab","RemotePage");

			return webElement;
		}

		public static class Engine {

			public static WebElement engine_Image_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='engine-img kh_engine-img']","engine_Image_OFF","RemotePage");

				return webElement;
			}

			public static WebElement engine_Image_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='engine-img kh_engine-img active']","engine_Image_ON","RemotePage");

				return webElement;
			}

			public static WebElement engine_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'box-engine')]/*[contains(@class,'switch') and contains (@class,'off')]","engine_OFF","RemotePage");

				return webElement;
			}

			public static WebElement engine_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'box-engine')]/*[contains(@class,'switch') and contains (@class,'on')]","engine_ON","RemotePage");                  

				return webElement;
			}
		}

		public static class Climate {

			public static WebElement climate_Image_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[@class='climate-img kh_climate-img']","climate_Image_OFF","RemotePage");                            

				return webElement;
			}

			public static WebElement climate_Image_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'kh_climate-img active')]","climate_Image_ON","RemotePage");                    

				return webElement;
			}

			public static WebElement climate_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[@class='climate-box box-climate']/div[@class='switch mL40 mT10 ng-binding off']","climate_OFF","RemotePage");                  

				return webElement;
			}

			public static WebElement climate_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[@class='climate-box box-climate']/div[@class='switch mL40 mT10 ng-binding on']","climate_ON","RemotePage");                  

				return webElement;
			}
		}

		public static class Defroster {

			public static WebElement defroster_Image_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='defrost-img']","defroster_Image_OFF","RemotePage");

				return webElement;
			}

			public static WebElement defroster_Image_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@class='defrost-img active']","defroster_Image_ON","RemotePage");

				return webElement;
			}

			public static WebElement defroster_OFF (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'box-defrost-kh')]//div[@class='switch mL40 mT10 ng-binding off']","defroster_OFF","RemotePage");

				return webElement;
			}

			public static WebElement defroster_ON (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'box-defrost-kh')]//div[@class='switch mL40 mT10 ng-binding on']","defroster_ON","RemotePage");

				return webElement;
			}
		}

		public static WebElement outside_Temperature (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'temp outside')]","outside_Temperature","RemotePage");

			return webElement;
		}

		public static WebElement inside_Temperature (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'temp inside')]","inside_Temperature","RemotePage");

			return webElement;
		}

		public static WebElement submit_Request (WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[@class='kh-button kh-button-submit']","submit_Request","RemotePage");

			return webElement;
		}

		public static WebElement request_In_Progress (WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[@class='kh-button kh-button-pending']","request_In_Progress","RemotePage");

			return webElement;
		}

		public static WebElement submit_Request_Diabled (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='kh-button kh-button-submit disabled']","submit_Request_Diabled","RemotePage");

			return webElement;
		}

		public static WebElement refresh_Vehicle (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='kh-button vehicle-refresh']","refresh_Vehicle","RemotePage");

			return webElement;
		}

		public static WebElement try_Again (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='kh-button kh-button-error']","try_Again","RemotePage");

			return webElement;
		}

		public static WebElement retry_List (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='retry-list']//li[contains(text(),'Turn engine')]/span","retry_List","RemotePage");

			return webElement;
		}

		public static WebElement pending_EngineRequests (WebDriver driver, String text) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='pending-list']//li[contains(text(),'Turn engine')]/span[text()='" +  text.toLowerCase() + "']","pending_EngineRequests","RemotePage");

			return webElement;
		}

		public static WebElement pending_ClimateRequests (WebDriver driver, String text) {


			webElement = FindWebElement.byXpath(driver,"//*[@class='pending-list']//li[contains(text(),'Turn climate')]/span[text()='" +  text.toLowerCase() + "']","pending_ClimateRequests","RemotePage");

			return webElement;
		}

		public static WebElement pending_DefrosterRequests (WebDriver driver, String text) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='pending-list']//li[contains(text(),'Turn defroster')]/span[text()='" +  text.toLowerCase() + "']","pending_DefrosterRequests","RemotePage");

			return webElement;
		}

		public static WebElement pending_ChangeClimate (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[@class='pending-list']//li[contains(text(),'Change climate')]","pending_ChangeClimate","RemotePage");

			return webElement;
		}

		public static WebElement viewPending (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'viewPending-mob')]","viewPending","RemotePage");

			return webElement;
		}

		public static WebElement cancelPending (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//button[starts-with(@class,'cancel-pending')]","cancelPending","RemotePage");

			return webElement;
		}

		public static WebElement closePending (WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//button[starts-with(@class,'close-mob')]","closePending","RemotePage");

			return webElement;
		}

		public static class Adjust_Temperature {

			public static WebElement decrease_Temp (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button minus')]","decrease_Temp","RemotePage");

				return webElement;
			}
			
			public static WebElement decrease_Schedule1_Temp (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'vm.decrease(1)')]","decrease_Schedule1_Temp","RemotePage");

				return webElement;
			}
			
			public static WebElement decrease_Schedule2_Temp (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'vm.decrease(2)')]","decrease_Schedule2_Temp","RemotePage");

				return webElement;
			}

			public static WebElement increase_Temp (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'button plus')]","increase_Temp","RemotePage");

				return webElement;
			}
			
			public static WebElement increase_Schedule1_Temp (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'vm.increase(1)')]","increase_Schedule1_Temp","RemotePage");

				return webElement;
			}
			
			public static WebElement increase_Schedule2_Temp (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'vm.increase(2)')]","increase_Schedule2_Temp","RemotePage");

				return webElement;
			}

			public static WebElement temperature (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//span[@ng-bind='vm.knobdata.value']","temperature","RemotePage");

				return webElement;
			}

			public static WebElement slide1_Temperature (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleI']/div[contains(@class,'climate')]/div/div[@class='slidergrade']/span[contains(@class,'temp-value')]","slide_Temperature","RemotePage");

				return webElement;
			}
			public static WebElement slide2_Temperature (WebDriver driver) {

				webElement = FindWebElement.byXpath(driver,"//*[@id='climateScheduleII']/div[contains(@class,'climate')]/div/div[@class='slidergrade']/span[contains(@class,'temp-value')]","slide_Temperature","RemotePage");

				return webElement;
			}
		}

		public static class Engine_And_Climate_Schedules {

			public static class First_Schedule {

				public static WebElement expand_Schedule (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[contains(@class,'arrow-btn down')]","expand_Schedule","RemotePage");

					return webElement;
				}
				
				public static WebElement expand_Schedule2 (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='arrow-btn down']","expand_Schedule 2","RemotePage");

					return webElement;
				}

				public static WebElement collapse_Schedule (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='arrow-btn up']","collapse_Schedule","RemotePage");

					return webElement;
				}

				public static WebElement schedule_ON (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='hvac-set on']","schedule_ON","RemotePage");

					return webElement;
				}

				public static WebElement schedule_OFF (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='hvac-set off']","schedule_OFF","RemotePage");

					return webElement;
				}

				public static WebElement temperature_Selected (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[starts-with(@class,'txt01 schedule-temp')]","temperature_Selected","RemotePage");

					return webElement;
				}

				public static WebElement time_Selected (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[starts-with(@class,'txt02 time-hvac')]/span","time_Selected","RemotePage");

					return webElement;
				}

				public static WebElement am_pm_Selected (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[contains(@class,'txt02 time-hvac')]","am_pm_Selected","RemotePage");

					return webElement;
				}

				public static WebElement days_Selected (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='txt03 date-hvac']","days_Selected","RemotePage");

					return webElement;
				}

				public static WebElement decrease_Temp_Button (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='control-battery climate slider-f']//*[@class='red-bar']/button","decrease_Temp_Button","RemotePage");

					return webElement;
				}

				public static WebElement increase_Temp_Button (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='control-battery climate slider-f']//*[@class='blue-bar']/button","increase_Temp_Button","RemotePage");

					return webElement;
				}

				public static WebElement temperature_Slider (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='control-battery climate slider-f']//a","temperature_Slider","RemotePage");

					return webElement;
				}

				public static WebElement temperature_Set (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//div[@class='slidergrade']/span[contains(@class,'temp-value')]","temperature_Set","RemotePage");

					return webElement;
				}

				public static WebElement defrost_OFF (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='defrost-set off']","defrost_OFF","RemotePage");

					return webElement;
				}

				public static WebElement defrost_ON (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='defrost-set on']","defrost_ON","RemotePage");

					return webElement;
				}

				public static class Calendar {                    

					public static boolean hour (WebDriver driver, String hour) {
						boolean selected = false;
						Actions action = new Actions(driver);

						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='calendar']//*[contains(@class,'time-hvac-hour hour-wrap')]","hour","RemotePage");

						WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@class='hour-list']/li[text()='" + hour + "']","hour","RemotePage");                            
						action.click(webElement).click(hour_To_Be_Selected).build().perform();                          
						selected = true;
						return selected;
					}

					public static boolean minute (WebDriver driver, String minutes) {
						boolean selected = false;
						Actions action = new Actions(driver);

						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='calendar']//div[starts-with(@class,'time-hvac-minute minute-wrap')]","minute","RemotePage");

						WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@class='minute-list']/li[text()='" + minutes + "']","minute","RemotePage");                            
						action.click(webElement).click(hour_To_Be_Selected).build().perform();                          
						selected = true;

						return selected;
					}

					public static boolean am_pm (WebDriver driver, String am_pm) {
						boolean selected = false;
						Actions action = new Actions(driver);

						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='calendar']//*[contains(@class,'time-hvac-section am-pm-wrap')]","am_pm","RemotePage");

						WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@class='am-pm-list']/li[text()='" + am_pm + "']","am_pm","RemotePage");                            
						action.click(webElement).click(hour_To_Be_Selected).build().perform();                           selected = true;

						return selected;
					}

					public static WebElement deselect_Day (WebDriver driver, String day) {

						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='weekDays']/div[contains(@class,'selected') and text()='"
								+ day.toUpperCase() + "']","deselect_Day","RemotePage");                                                                                        

						return webElement;
					}

					public static WebElement select_Day (WebDriver driver, String day) {

						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='weekDays']/div[text()='"
								+ day.toUpperCase()
								+ "' and not(contains(@class,'selected'))]","select_Day","RemotePage");                                    

						return webElement;
					}
				}

				public static WebElement cancel_Button (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='btnCancel']/button","cancel_Button","RemotePage");

					return webElement;
				}

				public static WebElement schedule_Button (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='btnSchedule']/button","schedule_Button","RemotePage");

					return webElement;
				}

				public static WebElement success_Button (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='btnSchedule']/div[text()='SUCCESS']","success_Button","RemotePage");                                

					return webElement;
				}

				public static WebElement same_Schedule_Error (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='conflictError error']","same_Schedule_Error","RemotePage");                                

					return webElement;
				}

				public static WebElement same_Schedule_Message (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-one toggle-up open']//*[@class='validSchedule error']","same_Schedule_Message","RemotePage");                                

					return webElement;
				}
			}

			public static class Second_Schedule {

				public static WebElement expand_Schedule (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='arrow-btn down']","expand_Schedule","RemotePage");

					return webElement;
				}

				public static WebElement collapse_Schedule (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='arrow-btn up']","collapse_Schedule","RemotePage");

					return webElement;
				}

				public static WebElement schedule_ON (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='hvac-set on']","schedule_ON","RemotePage");

					return webElement;
				}

				public static WebElement schedule_OFF (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='hvac-set off']","schedule_OFF","RemotePage");

					return webElement;
				}

				public static WebElement temperature_Selected (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[contains(@class,'txt01 schedule-temp')]","temperature_Selected","RemotePage");

					return webElement;
				}

				public static WebElement time_Selected (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[contains(@class,'txt02 time-hvac')]/span","time_Selected","RemotePage");

					return webElement;
				}

				public static WebElement am_pm_Selected (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[contains(@class,'txt02 time-hvac')]","am_pm_Selected","RemotePage");

					return webElement;
				}

				public static WebElement days_Selected (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='txt03 date-hvac']","days_Selected","RemotePage");

					return webElement;
				}

				public static WebElement decrease_Temp_Button (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='control-battery climate slider-f']//*[@class='red-bar']/button","decrease_Temp_Button","RemotePage");

					return webElement;
				}

				public static WebElement increase_Temp_Button (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='control-battery climate slider-f']//*[@class='blue-bar']/button","increase_Temp_Button","RemotePage");

					return webElement;
				}

				public static WebElement temperature_Slider (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='control-battery climate slider-f']//a","temperature_Slider","RemotePage");

					return webElement;
				}

				public static WebElement defrost_OFF (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='defrost-set off']","defrost_OFF","RemotePage");

					return webElement;
				}

				public static WebElement defrost_ON (WebDriver driver) {

					webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='defrost-set on']","defrost_ON","RemotePage");

					return webElement;
				}

				public static class Calendar {                    

					public static boolean hour (WebDriver driver, String hour) {
						boolean selected = false;
						Actions action = new Actions(driver);

						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='calendar']//*[contains(@class,'time-hvac-hour hour-wrap2')]","hour","RemotePage");
						WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@class='hour-list2']/li[text()='" + hour + "']","hour","RemotePage");                            
						action.click(webElement).click(hour_To_Be_Selected).build().perform();                          
						selected = true;
						return selected;
					}

					public static boolean minute (WebDriver driver, String minutes) {
						boolean selected = false;
						Actions action = new Actions(driver);
							webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='calendar']//*[contains(@class,'time-hvac-minute minute-wrap2')]","engine_And_Climate_Tab","RemotePage");
							WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@class='minute-list2']/li[text()='" + minutes + "']","minute","RemotePage");                            
							action.click(webElement).click(hour_To_Be_Selected).build().perform();  			
							selected = true;
						
						return selected;
					}

					public static boolean am_pm (WebDriver driver, String am_pm) {
						boolean selected = false;
						Actions action = new Actions(driver);
						
							webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='calendar']//*[contains(@class,'time-hvac-section am-pm-wrap2')]","engine_And_Climate_Tab","RemotePage");
							WebElement hour_To_Be_Selected = FindWebElement.byXpath(driver,"//*[@class='am-pm-list2']/li[text()='" + am_pm + "']","am_pm","RemotePage");                            
							action.click(webElement).click(hour_To_Be_Selected).build().perform();		
							selected = true;
						
						return selected;
					}

					public static WebElement deselect_Day (WebDriver driver, String day) {
						
							webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='weekDays']/div[contains(@class,'selected') and text()='"
													+ day.toUpperCase() + "']","deselect_Day","RemotePage");                                                                                        
							
						return webElement;
					}

					public static WebElement select_Day (WebDriver driver, String day) {
						
							webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='weekDays']/div[text()='"
													+ day.toUpperCase()
													+ "' and not(contains(@class,'selected'))]","select_Day","RemotePage");                                    			
						return webElement;
					}
				}

				public static WebElement cancel_Button (WebDriver driver) {
					
						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='btnCancel']/button","cancel_Button","RemotePage");
						
					return webElement;
				}

				public static WebElement schedule_Button (WebDriver driver) {
					
						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='btnSchedule']/button","schedule_Button","RemotePage");
						
					return webElement;
				}

				public static WebElement success_Button (WebDriver driver) {
					
						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='btnSchedule']/div[text()='SUCCESS']","success_Button","RemotePage");                                
						
					return webElement;
				}

				public static WebElement same_Schedule_Error (WebDriver driver) {
					
						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='conflictError error']","same_Schedule_Error","RemotePage");                                
						
					return webElement;
				}

				public static WebElement same_Schedule_Message (WebDriver driver) {
				
						webElement = FindWebElement.byXpath(driver,"//*[@class='schedule-two toggle-up open']//*[@class='validSchedule error']","same_Schedule_Message","RemotePage");                                
						
					return webElement;
				}
			}
		}
	}

	public static class Lock_Unlock {

		public static WebElement lock_Unlock_Tab (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//a[text()='Lock / Unlock']","lock_Unlock_Tab","RemotePage");
				
			return webElement;
		}

		public static WebElement hood_Locked (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//*[@class='door p6 locked with-hood']","hood_Locked","RemotePage");
				
			return webElement;
		}

		public static WebElement lock_Unlock_Status (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'control')]/div[contains(@class,'title') and not (contains(@class,'hide'))]","lock_Unlock_Status","RemotePage");
				
			return webElement;
		}

		public static WebElement doors_UnlockIcon (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//a[contains(@class,'unlock button')][contains(text(),'Unlock')]","doors_UnlockIcon","RemotePage");
				
			return webElement;
		}

		public static WebElement doors_LockIcon (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//a[starts-with(@class,'lock button')][contains(text(),'Lock')]","doors_LockIcon","RemotePage");
				
			return webElement;
		}

		public static WebElement doors_Unlocking (WebDriver driver){
			
				webElement = FindWebElement.byXpath(driver,"//*[@class='button pending' and contains(text(),'Unlocking')]","doors_Unlocking","RemotePage");
				
			return webElement;            
		}

		public static WebElement doors_Locking (WebDriver driver){
			
				webElement = FindWebElement.byXpath(driver,"//*[@class='button pending' and contains(text(),'locking')]","doors_Locking","RemotePage");
				
			return webElement;            
		}

		public static WebElement retry_Button (WebDriver driver){
			
				webElement = FindWebElement.byXpath(driver,"//*[@class='button error' and contains(text(),'Retry')]","retry_Button","RemotePage");
				
			return webElement;            
		}

		public static WebElement refresh_VehicleStatus (WebDriver driver){
			
				webElement = FindWebElement.byXpath(driver,"//*[@class='button vehicle-refresh']","refresh_VehicleStatus","RemotePage");
				
			return webElement;            
		}

		public static WebElement refreshing_VehicleStatus (WebDriver driver){
			
				webElement = FindWebElement.byXpath(driver,"//*[text()='Refreshing vehicle status...']","refreshing_VehicleStatus","RemotePage");
				
			return webElement;            
		}
	}

	public static class Find_My_Car {

		public static WebElement find_My_Car_Tab (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//a[text()='Find My Car']","find_My_Car_Tab","RemotePage");
				
			return webElement;
		}

		public static WebElement proceed_Button (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//div[text()='Proceed']","proceed_Button","RemotePage");
				
			return webElement;
		}

		public static WebElement proceed_Message (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//h2[contains(text(),'You are about')]","proceed_Message","RemotePage");
				
			return webElement;
		}

		public static WebElement pending_Message (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'pending')]//h2[contains(text(),'Your request')]","pending_Message","RemotePage");
				
			return webElement;
		}                

		public static WebElement close_Button (WebDriver driver) {
			
				webElement = FindWebElement.byXpath(driver,"//img[contains(@src,'close-popup')]","close_Button","RemotePage");                        
				
			return webElement;
		}
	}
}    

