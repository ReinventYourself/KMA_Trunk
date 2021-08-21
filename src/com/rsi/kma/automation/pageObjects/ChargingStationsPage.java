package com.rsi.kma.automation.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;



public class ChargingStationsPage {

    
    private static WebElement webElement = null;
    
  
    public static WebElement search_Box(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'red-btn')]/following-sibling::input","search_Box","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement current_Location_Button(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@title,'Use current location')]","current_Location_Button","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement search_Button(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//*[@ng-click='vm.searchByInputValue()']","search_Button","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement hide_Arrow(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'red-arrow left')]/img","hide_Arrow","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement show_Arrow(WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'red-arrow right')]/img","show_Arrow","ChargingStationsPage");

        return webElement;
    }

    public static WebElement list_Result_Box(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//*[@class='list_results']","list_Result_Box","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement station_Mark(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'marker_distance')]","station_Mark","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement filter_Button(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//*[@class='filter']/a/img","filter_Button","ChargingStationsPage");           
           
        return webElement;
    }

    public static WebElement done_Button(WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'btn-done')]/a/img","done_Button","ChargingStationsPage");                      
           
        return webElement;
    }

    public static WebElement clear_Button(WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'btn-clear')]/a","clear_Button","ChargingStationsPage");

        return webElement;
    }

    public static WebElement allBrands_Checkbox(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//label[contains(.,'All')]/input","allBrands_Checkbox","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement allBrands_Checkbox_Checked(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"ng-pristine ng-untouched ng-valid","allBrands_Checkbox_Checked","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement chargePointNetwork_Checkbox(WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//label[contains(.,'Charge Point Network')]/input","chargePointNetwork_Checkbox","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement opConnect_Checkbox(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//label[contains(.,'OpConnect')]/input","opConnect_Checkbox","ChargingStationsPage");

        return webElement;
    }

    public static WebElement semaChargeNetwork_Checkbox(WebDriver driver) {
        
           webElement = FindWebElement.byXpath(driver,"//label[contains(.,'Sema Charge Network')]/input","semaChargeNetwork_Checkbox","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement aeroVironmentNetwork_Checkbox(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//label[contains(.,'AeroVironment Network')]/input","aeroVironmentNetwork_Checkbox","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement blink_Checkbox(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//label[contains(.,'Blink')]/input","blink_Checkbox","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement eVgoNetwork_Checkbox(WebDriver driver) {
     
          
            webElement = FindWebElement.byXpath(driver,"//label[contains(.,'eVgo Network')]/input","eVgoNetwork_Checkbox","ChargingStationsPage");

        return webElement;
    }

    public static WebElement shorepower_Checkbox(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//label[contains(.,'Shorepower')]/input","shorepower_Checkbox","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement electricVehicle_Checkbox(WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//label[contains(.,'Electric Vehicle')]/input","electricVehicle_Checkbox","ChargingStationsPage");
          
        return webElement;
    }

    public static WebElement loading_Charging_Station_Popup(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//*[@class='statusMsg ng-binding' and contains(text(),'Locating charging stations')]","loading_Charging_Station_Popup","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement dismiss_Button(WebDriver driver) {
       
            webElement = FindWebElement.byId(driver,"dismissButton","dismiss_Button","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement invalid_ZIPCode_ErrorMessage(WebDriver driver) {
       
            webElement = FindWebElement.byXpath(driver,"//*[@class='message ng-binding' and contains(text(),'Enter a valid ZIP code.')]","invalid_ZIPCode_ErrorMessage","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement no_Search_Result_Message(WebDriver driver) {
     
            webElement = FindWebElement.byXpath(driver,"//*[@class='noresults']","no_Search_Result_Message","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement scroll_Panel_Of_Searched_Result(WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//*[@class='scroll-panel']/div","scroll_Panel_Of_Searched_Result","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement search_Result_Box(WebDriver driver) {
       
            webElement = FindWebElement.byId(driver,"leftboxredId","search_Result_Box","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement charging_Station_address(WebDriver driver) {
        

            webElement = FindWebElement.byXpath(driver,"//*[@class='scroll-panel']//*[@class='upper-padding ng-scope'][position()=1]//*[starts-with(@class,'addr')]","charging_Station_address","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement five_MilesAway(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//*[@ng-click='vm.location(5)']","five_MilesAway","ChargingStationsPage");            
            
        return webElement;
    }

    public static WebElement ten_MilesAway(WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//*[@ng-click='vm.location(10)']","ten_MilesAway","ChargingStationsPage");

        return webElement;
    }

    public static WebElement twenty_Five_MilesAway(WebDriver driver) {
          
            webElement = FindWebElement.byXpath(driver,"//*[@ng-click='vm.location(25)']","twenty_Five_MilesAway","ChargingStationsPage");
            
        return webElement;
    }

    public static WebElement twenty_Five_MilesAway_Checked(WebDriver driver) {
                
            webElement = FindWebElement.byXpath(driver,"//*[@class='on' and @ng-click='vm.location(25)']","twenty_Five_MilesAway_Checked","ChargingStationsPage");
          
        return webElement;
    }

    public static WebElement leve1All_Charging(WebDriver driver) {
     
            
            webElement = FindWebElement.byXpath(driver,"//*[@ng-click='vm.chargeType(0)']","leve1All_Charging","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement leve11_Charging_On_Filter(WebDriver driver) {
       
            
            webElement = FindWebElement.byXpath(driver,"//*[@ng-click='vm.chargeType(1)']","leve11_Charging_On_Filter","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement leve12_Charging_On_Filter(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//*[@ng-click='vm.chargeType(2)']","leve12_Charging_On_Filter","ChargingStationsPage");
          
        return webElement;
    }

    public static WebElement leve1All_Charging_Selected(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//*[@class='on' and @ng-click='vm.chargeType(0)']","leve1All_Charging_Selected","ChargingStationsPage");
           
        return webElement;
    }

    public static WebElement mobile_Filter_Arrow(WebDriver driver) {
      
            webElement = FindWebElement.byXpath(driver,"//*[@class='title' and @ng-click='vm.toggleFilter()']","mobile_Filter_Arrow","ChargingStationsPage");
           
        return webElement;
    }
    
    public static WebElement chargingStations_Clear_All_Brands(
            WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//a[contains(text(),'CLEAR ALL')]","chargingStations_Clear_All_Brands","ChargingStationsPage");
           
        return webElement;
    }
    
    public static WebElement chargingStations_Brands_Checkbox_Checked(
            WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//input[contains(@class,'ng-valid-parse')]","chargingStations_Brands_Checkbox_Checked","ChargingStationsPage");
           
        return webElement;
    }
    
    public static WebElement chargingStations_Brands_Checkbox_Unchecked(
            WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//input[not(contains(@class,'ng-valid-parse'))][@type='checkbox']","chargingStations_Brands_Checkbox_Unchecked","ChargingStationsPage");
           
        return webElement;
    }
    
    public static WebElement chargingStations_Select_Atleast_One_Brand_Error_message(
            WebDriver driver) {
        
            webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Please select at least one brand to filter the search.')][contains(@class,'hidden-xs')]","chargingStations_Select_Atleast_One_Brand_Error_message","ChargingStationsPage");
           
        return webElement;
    }
    
    public static WebElement chargingStations_Brands_Checkbox(
            WebDriver driver, String brandName) {
        
            webElement = FindWebElement.byXpath(driver,"//label[contains(text(),'"+brandName+"')]/input", "chargingStations_Brands_Checkbox", "ChargingStationsPage");
           
        return webElement;
    }
    
    public static WebElement loading_charging_stations_text(WebDriver driver) {
        
        webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'Locating charging stations')]","loading charging stations","ChargingStationsPage");
       
    return webElement;
    }
    
    public static WebElement first_charging_station(WebDriver driver) {
        
        webElement = FindWebElement.byXpath(driver,"//div[@class='scroll-panel']/div[1]/div[@class='addr ng-binding']","loading charging stations","ChargingStationsPage");
       
    return webElement;
    }
    
    public static WebElement charging_station_info_box(WebDriver driver) {
        
        webElement = FindWebElement.byXpath(driver,"//div[@class='infobox-dark-big']","Charging Station info box","ChargingStationsPage");
       
    return webElement;
    }
    
    public static WebElement charging_station_info_box_name(WebDriver driver) {
        
        webElement = FindWebElement.byXpath(driver,"//div[@class='infobox-dark-big']/div/div/div[contains(@class,'uvo-ib-title')]","Charging Station info box","ChargingStationsPage");
       
    return webElement;
    }
    
    public static class Charging_Point_Popup {

        public static WebElement brand_Logo(WebDriver driver) {
            

                webElement = FindWebElement.byXpath(driver,"//*[@class='uvo-ib-content']/img","brand_Logo","ChargingStationsPage");
                
            return webElement;
        }

        public static WebElement distance(WebDriver driver) {
           
                webElement = FindWebElement.byXpath(driver,"//*[@class='infobox-dark-big']//*[@class='distance hidden-xs ng-binding']","distance","ChargingStationsPage");
               return webElement;
        }

        public static WebElement google_Image(WebDriver driver) {
            
                webElement = FindWebElement.byId(driver,"pano","google_Image","ChargingStationsPage");
                
            return webElement;
        }

        public static WebElement popup_Close(WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//*[@class='infobox-dark-big']/img","popup_Close","ChargingStationsPage");                
               
            return webElement;
        }

        public static WebElement chargingStations_Address(WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//*[@class='uvo-ib-title ng-binding']","chargingStations_Address","ChargingStationsPage");
               
            return webElement;
        }

        public static WebElement getDirection_Arrow(WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//*[@class='infobox-dark-big']//*[@class='boxGetDirection']","getDirection_Arrow","ChargingStationsPage");

                
            return webElement;
        }

        public static WebElement leve11_Charging(WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'infobox-dark-big')]//*[starts-with(@class,'col-xs-3 ng-binding') and contains(text(),'Level1:')]","leve11_Charging","ChargingStationsPage");
                
            return webElement;
        }

        public static WebElement leve12_Charging1(WebDriver driver) {
          
                webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'infobox-dark-big')]//*[starts-with(@class,'col-xs-3 ng-binding') and contains(text(),'Level2:')]","leve12_Charging1","ChargingStationsPage");
               
            return webElement;
        }

        public static WebElement DC_Charging(WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'infobox-dark-big')]//*[starts-with(@class,'col-xs-6 ng-binding') and contains(text(),'Level3:')]","DC_Charging","ChargingStationsPage");
                
            return webElement;
        }

        public static WebElement charging_Station_Popup(WebDriver driver) {
            

                webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'infobox-dark-big')]//*[@class='uvo-ib-content']","charging_Station_Popup","ChargingStationsPage");

                
            return webElement;
        }

        public static WebElement chargingStations_Address_On_Popup(
                WebDriver driver) {
            

                webElement = FindWebElement.byXpath(driver,"//*[@class='infobox-dark-big']//*[@class='uvo-ib-title ng-binding']","chargingStations_Address_On_Popup","ChargingStationsPage");
                
            return webElement;
        }

        public static WebElement chargingStations_Address_Line1_On_Popup(
                WebDriver driver) {
          
                webElement = FindWebElement.byXpath(driver,"//*[@class='infobox-dark-big']//*[@class='ng-binding'][position()=1]","chargingStations_Address_Line1_On_Popup","ChargingStationsPage");
                
            return webElement;
        }

        public static WebElement chargingStations_Address_Line2_On_Popup(
                WebDriver driver) {
            
                webElement = FindWebElement.byXpath(driver,"//*[@class='infobox-dark-big']//*[@class='ng-binding'][position()=2]","chargingStations_Address_Line2_On_Popup","ChargingStationsPage");
               
            return webElement;
        }         
    }
}
