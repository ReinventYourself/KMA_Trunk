package com.rsi.kma.automation.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.rsi.kma.automation.utility.FindWebElement;



public class MaintenancePage {
    private static WebElement webElement = null;    

    public static class ServiceSchedule {

        public static WebElement currentMileage(WebDriver driver) {


            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'mileage')]/strong","currentMileage","MaintenancePage");

            return webElement;
        }

        public static WebElement currentMilestoneMilesValue(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'dashboard hidden-xs')]//*[@id='displayedInterval']","currentMilestoneMilesValue","MaintenancePage");

            return webElement;
        }

        public static WebElement milesUntilNextService(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@class='the-value']/strong","milesUntilNextService","MaintenancePage");

            return webElement;
        }

        public static WebElement milestoneRightArrowButton(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//div[@class='dashboard hidden-xs']/div[starts-with(@class,'nav right')]","milestoneRightArrowButton","MaintenancePage");

            return webElement;
        }

        public static WebElement milestoneLeftArrowButton(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//div[@class='dashboard hidden-xs']/div[starts-with(@class,'nav left')]","milestoneLeftArrowButton","MaintenancePage");

            return webElement;
        }

        public static WebElement popupCancelButton(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button')]//*[contains(text(),'CANCEL')]","popupCancelButton","MaintenancePage");

            return webElement;
        }

        public static WebElement popupConfirmButton(WebDriver driver) {


            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button')]//*[contains(text(),'CONFIRM')]","popupConfirmButton","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadIcon(WebDriver driver) {

            webElement = FindWebElement.byCssSelector(driver,"div.box.notePen","notePadIcon","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadDateTextField(WebDriver driver) {


            webElement = FindWebElement.byXpath(driver,"//*[@class='inside-validation'][position()=1]","notePadDateTextField","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadCalendarMonthRightArrow(WebDriver driver) {


            webElement = FindWebElement.byXpath(driver,"//*[@class='btn btn-default btn-sm pull-right']","notePadCalendarMonthRightArrow","MaintenancePage");


            return webElement;
        }

        public static WebElement month(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@id,'datepicker')]//strong[@class='ng-binding']","month","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadCalendarMonthLeftArrow(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@class='btn btn-default btn-sm pull-left']","notePadCalendarMonthLeftArrow","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadCalendarDateButtons(WebDriver driver, int date) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@id,'datepicker')]/..//span[@class='ng-binding' and contains(text(),'" + date + "')]","notePadCalendarDateButtons","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadLocationTextField(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"plOfWk","notePadLocationTextField","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadMileageTextField(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"insMilg","notePadMileageTextField","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadNotesTextField(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"enterNotes","notePadNotesTextField","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadx(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'maintNote hidden')]//img[@src='images/maint/icon-close.jpg']","notePadx","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadPopupDeletButton(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"deleteNotes","notePadPopupDeletButton","MaintenancePage");

            return webElement;
        }

        public static WebElement notePadPopupCompleteButton(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"saveNotes","notePadPopupCompleteButton","MaintenancePage");

            return webElement;
        }

        public static WebElement ignoredButton(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'box actions')]/div[starts-with(@class,'ignore')]","ignoredButton","MaintenancePage");

            return webElement;
        }
        
        public static WebElement ignoredButtonInactive(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'box actions')]/div[@class='ignore inactive']","ignoredButton inactive","MaintenancePage");

            return webElement;
        }
        
        public static WebElement completedButton(WebDriver driver) {


            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'box actions')]/div[starts-with(@class,'complete')]","completedButton","MaintenancePage");

            return webElement;
        }
       
        public static WebElement editButton(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//div[@class='content']/div[contains(@class,'notePen')]","editButton","MaintenancePage");

            return webElement;
        }
        
        public static WebElement notesDate(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"insDt","notes date field","MaintenancePage");

            return webElement;
        }
        
        public static WebElement notesDateValue(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[contains(@id,'datepicker')]/button[contains(@class,'active')]","notesDateValue","MaintenancePage");

            return webElement;
        }
        
        public static WebElement notesServiceLocation(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"plOfWk","notes service field","MaintenancePage");

            return webElement;
        }
        
        public static WebElement notesMileage(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"insMilg","notes Mileage field","MaintenancePage");

            return webElement;
        }
        
        public static WebElement notesAddNote(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"enterNotes","notes add a note field","MaintenancePage");

            return webElement;
        }
        
        public static WebElement editBoxDeleteButton(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"deleteNotes","delete notes Button","MaintenancePage");

            return webElement;
        }
        
        public static WebElement editBoxCompleteButton(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='saveNotes']/span[text()='COMPLETE']","editBoxCompleteButton","MaintenancePage");

            return webElement;
        }

        public static WebElement detailsButton(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"details","detailsButton","MaintenancePage");

            return webElement;
        }
        
        public static WebElement milesOilChangeSchedule(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'until next oil change')]/preceding-sibling::div[contains(@class,'miles')]","milesOilChangeSchedule","MaintenancePage");

            return webElement;
        }
        
        public static WebElement milesRestartButton(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'restart-btn')]","milesRestartButton","MaintenancePage");

            return webElement;
        }
        
        public static WebElement displayedIntervalMiles(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"displayedInterval","displayedInterval","MaintenancePage");

            return webElement;
        }
        
        public static WebElement oilChangeDropdown(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//div[starts-with(@class,'restart-btn')]/following-sibling::select[starts-with(@class,'oil-change-intervals')]","oilChangeDropdown","MaintenancePage");

            return webElement;
        }

        public static WebElement recommendedService(WebDriver driver) {

            webElement = FindWebElement.byClassName(driver,"title","recommendedService","MaintenancePage");

            return webElement;
        }

        public static WebElement recommendedService_On_Details(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@class='column']","recommendedService_On_Details","MaintenancePage");

            return webElement;
        }
        
        public static WebElement detailsExpanded(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'details expanded')]","detailsExpanded box","MaintenancePage");

            return webElement;
        }
        
        public static WebElement detailsXButton(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'details expanded')]//img[@src='images/maint/icon-close.jpg']","detailsXButton","MaintenancePage");

            return webElement;
        }

        public static WebElement maintenaceVehicleNotDispaly(WebDriver driver) {

            webElement = FindWebElement.byClassName(driver,"noInterval","maintenaceVehicleNotDispaly","MaintenancePage");

            return webElement;
        }
    }

    public static class DiagnosticIssues {

        public static WebElement diagnosticIssuesBox(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='diagNoIssue']","diagnosticIssuesBox","MaintenancePage");

            return webElement;
        }

        public static WebElement noDiagnosticIssues(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='diagNoIssue']//*[@class='info']/strong","noDiagnosticIssues","MaintenancePage");

            return webElement;
        }

        public static WebElement numberOfIssues(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,".//*[@id='diagNoIssue']//strong","numberOfIssues","MaintenancePage");

            return webElement;
        }

        public static WebElement powertrainIssue(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='diagNoIssue']/..//ul/li[@id='powertrainDetail']","powertrainIssue","MaintenancePage");

            return webElement;
        }

        public static WebElement powertrainIssueText(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='powertrainDetail']//div[@class='title']/following-sibling::div","powertrainIssueText","MaintenancePage");

            return webElement;
        }

        public static WebElement safetyIssue(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='diagNoIssue']/..//ul/li[@id='safetyDetail']","safetyIssue","MaintenancePage");

            return webElement;
        }

        public static WebElement safetyIssueText(WebDriver driver) {


            webElement = FindWebElement.byXpath(driver,"//*[@id='safetyDetail']//*[@class='title']/following-sibling::div","safetyIssueText","MaintenancePage");

            return webElement;
        }

        public static WebElement chasisIssue(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='diagNoIssue']/..//ul/li[@id='']","chasisIssue","MaintenancePage");

            return webElement;
        }

        public static WebElement chasisIssueText(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='chassisDetail']//*[@class='title']/following-sibling::div","chasisIssueText","MaintenancePage");

            return webElement;
        }
    }

    public static class RequestAppointment {

    	
    	public static WebElement RequestAppointmentButton(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//a[@id='request-appt']","RequestAppointmentButton","MaintenancePage");

            return webElement;
        }
        public static WebElement changeDealer(WebDriver driver) {          

            webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'selectNearbyDealer')]","changeDealer","MaintenancePage");
            return webElement;
        }
        
        public static WebElement changeDealerButton(WebDriver driver) {          

            webElement = FindWebElement.byXpath(driver,"//span[text()='Change Dealer']","changeDealerButton","MaintenancePage");
            return webElement;
        }
        
        public static WebElement currentDealerName(WebDriver driver) {          

            webElement = FindWebElement.byXpath(driver,"//div[@id='dealerContact']/preceding-sibling::div[contains(@class,'name')]","currentDealerName","MaintenancePage");
            return webElement;
        }
        
        public static WebElement zipCodeField(WebDriver driver) {          

            webElement = FindWebElement.byId(driver,"zipcode","zipCodeField","MaintenancePage");
            return webElement;
        }
        
        public static WebElement zipCodeFieldError(WebDriver driver) {          

            webElement = FindWebElement.byId(driver,"dealerZipError","zipCodeFieldError","MaintenancePage");
            return webElement;
        }
        
        public static WebElement selectDealerBoxClose(WebDriver driver) {          

            webElement = FindWebElement.byXpath(driver,"//a[contains(@class,'close')]","selectDealerBoxClose","MaintenancePage");
            return webElement;
        }
        
        public static WebElement getDealerButton(WebDriver driver) {          

            webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'vm.getDealers')]","getDealerButton","MaintenancePage");
            return webElement;
        }
        
        public static WebElement clickDealerLoadMoreButton(WebDriver driver) {          

            webElement = FindWebElement.byXpath(driver,"//a[text()='Load More']","clickDealerLoadMoreButton","MaintenancePage");
            return webElement;
        }
        
        public static WebElement selectDealerValue(WebDriver driver, String dealerName) {          

            webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'" + dealerName + "')]/../preceding-sibling::div[contains(@class,'distance ')]","selectDealerValue","MaintenancePage");
            return webElement;
        }
        
        public static WebElement selectedDealerValue(WebDriver driver, String dealerName) {          

            webElement = FindWebElement.byXpath(driver,"//div[contains(text(),'" + dealerName + "')]/../preceding-sibling::div[contains(@class,'distance ')]/parent::li[contains(@class,'active')]","selectedDealerValue","MaintenancePage");
            return webElement;
        }
        
        

        public static WebElement selectedDealer(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@class='confDealer']/div[contains(@class,'name')]","selectedDealer","MaintenancePage");

            return webElement;
        }

        public static WebElement selectDealer(WebDriver driver, String dealerName) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='dealerSearchScroller']/..//div/div[text()='" + dealerName + "']/ancestor::li/div[@class='distance']","selectDealer","MaintenancePage");

            return webElement;
        }

        public static WebElement currentDealer(WebDriver driver) {

            webElement = FindWebElement.byCssSelector(driver,".name","currentDealer","MaintenancePage");

            return webElement;
        }

        public static WebElement activeDealer(WebDriver driver, String dealer, String currentDealer) {

            webElement = FindWebElement.byXpath(driver,String.format("//*[@id='dealerSearchScroller']/..//div/div[text()='" + dealer + "']/ancestor::li", currentDealer),"activeDealer","MaintenancePage");

            return webElement;
        }

        public static WebElement changeDealerX(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@class='close clickable']","changeDealerX","MaintenancePage");

            return webElement;
        }

        public static WebElement changeDealerZipCodeTextField(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"zipcode","changeDealerZipCodeTextField","MaintenancePage");

            return webElement;
        }

        public static WebElement changeDealerSearchButton(WebDriver driver) {


            webElement = FindWebElement.byClassName(driver,"select","changeDealerSearchButton","MaintenancePage");

            return webElement;
        }

        public static WebElement changeDealerDealerTypeDropdown(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"selectVehicleType","changeDealerDealerTypeDropdown","MaintenancePage");

            return webElement;
        }

        public static WebElement validZipCodeErrorMessage(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='dealerZipError","validZipCodeErrorMessage","MaintenancePage");

            return webElement;
        }


        public static WebElement changeDealerRedStar(WebDriver driver) {

            webElement = FindWebElement.byClassName(driver,"distance","changeDealerRedStar","MaintenancePage");

            return webElement;
        }

        public static WebElement closeConfirmDealer(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"closeConfirmDealer","closeConfirmDealer","MaintenancePage");

            return webElement;
        }

        public static WebElement requestIssuetxt(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[@id='confIssue']/div[@class='detail']","requestIssuetxt","MaintenancePage");                

            return webElement;
        }

        public static WebElement confirmDealerRequest(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"confirm-appt","confirmDealerRequest","MaintenancePage");

            return webElement;
        }

        public static WebElement dealerConfirm(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"appointmentClose","dealerConfirm","MaintenancePage");

            return webElement;
        }

        public static WebElement confirmationMesssage(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver," //*[text()='Dealer will contact you to discuss appointment time and details.']","confirmationMesssage","MaintenancePage");                

            return webElement;
        }

        
     
        public static WebElement request_Appointment_Ok_Button(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button button')]","request_Appointment_Ok_Button","MaintenancePage");

            return webElement;
        }
        
        
        
        //verify appointment 
        

        public static WebElement currentAppointment(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'APPOINTMENT')]","currentAppointment","MaintenancePage");

            return webElement;
        }
        

        public static WebElement dealer(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'CURRENT APPOINTMENT')]/parent::div//div[contains(@class,'event')]","dealer","MaintenancePage");

            return webElement;
        }
        

        public static WebElement timeAndDate(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'CURRENT APPOINTMENT')]/parent::div//div[contains(@class,'event')]/strong","timeAndDate","MaintenancePage");

            return webElement;
        }
        

        public static WebElement type(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'CURRENT APPOINTMENT')]/parent::div//div[contains(@class,'type')]","type","MaintenancePage");

            return webElement;
        }
        
        
        
        
        
        
    }

    public static class SelectIssue {

        public static WebElement VehicleRepair(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"veh-repair","VehicleRepair","MaintenancePage");

            return webElement;
        }

        public static WebElement Maintenance(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"veh-maint","Maintenance","MaintenancePage");

            return webElement;
        }

        public static WebElement Other(WebDriver driver) {

            webElement = FindWebElement.byId(driver,"other","Other","MaintenancePage");

            return webElement;
        }

        

        public static WebElement maintenanceMilestxt(WebDriver driver) {

            webElement = FindWebElement.byXpath(driver,"//li[@id='veh-maint']/div[starts-with(@class,'detail')]","maintenanceMilestxt","MaintenancePage");

            return webElement;
        }
    }

    public static WebElement vehicleDropdown(WebDriver driver) {
       
            webElement = FindWebElement.byCssSelector(driver,".nav-vehicle-selector>.arrow","vehicleDropdown","MaintenancePage");
            
        return webElement;
    }

    public static class KH_Maintenance {

        public static WebElement oilChangeScheduleBox(WebDriver driver) {
          
                    webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'blade')]/div/following-sibling::div[@class='col-2']","oilChangeScheduleBox","MaintenancePage");
                    
            return webElement;
        }

        public static WebElement oilChangeMiles(WebDriver driver) {
           
                    webElement = FindWebElement.byXpath(driver,"//*[@class='widget-box border monthly-diagnostic oil-change-schedule']/div[@class='title']/following-sibling::div/div[@class='miles ng-binding']","oilChangeMiles","MaintenancePage");
                    
            return webElement;
        }

        public static WebElement oilChangeRestartButton(WebDriver driver) {
           
                    webElement = FindWebElement.byClassName(driver,"restart-btn","oilChangeRestartButton","MaintenancePage");
                    
            return webElement;
        }

        public static boolean oilChangeintervals(WebDriver driver, String miles) {
            boolean oilChangeMiles = false; 

           
                    webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'oil-change-schedule')][not (contains(@mobile,'true'))]//select[contains(@class,'oil-change')]","oilChangeintervals","MaintenancePage");
                    Select oilChange = new Select(webElement);
                    oilChange.selectByVisibleText(miles);
                    oilChangeMiles = true;
               
            return oilChangeMiles;
        }

        public static WebElement dealer_Type_Dropdown(WebDriver driver) {
           
                
                    webElement = FindWebElement.byXpath(driver,"//*[@id='dealerSearchScroller']","dealer_Type_Dropdown","MaintenancePage");
                    
            return webElement;
        }

        public static WebElement popup_Confirm(WebDriver driver) {
           
                    webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'button')]//*[contains(text(),'CONFIRM')]","popup_Confirm","MaintenancePage");
                   
            return webElement;
        }
    }
}
