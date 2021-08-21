package com.rsi.kma.automation.utility;

import java.io.File;

/**
 * The Constants class contains all the Relative paths which will be required for set up and reporting purpose
 */
public class Constants {
	
	public static long         implicitWaitTime = 5;
	public static String       basePath = new File("").getAbsolutePath();
	public static String       fileSeparator = System.getProperty("file.separator");
	public static final String ReportsPath=basePath + Constants.fileSeparator
            + "Screenshots" ;
	
	
	public static String       browser = null;
    public static final String Path_ScreenShot = getScreenShotPath();
	public static final String reportDirectory = basePath + Constants.fileSeparator
            + "test-output"+ Constants.fileSeparator;
	public final static String reportsUsername = "kma.reports@gmail.com";
	public final static String reportsPassword = "Kiatest1";
    
    
    /*Chrome Driver Path*/
    public static String chromePath = basePath + Constants.fileSeparator
            + "projectJARS" + Constants.fileSeparator + "browserDrivers"
                    + Constants.fileSeparator +
            "chromedriver.exe";

    /*Fire fox Driver Path*/
    public static String geckoPath = basePath + Constants.fileSeparator
            + "projectJARS" + Constants.fileSeparator + "browserDrivers"
            + Constants.fileSeparator + "geckodriver.exe";

    /*IE Driver Path*/
    public static String iePath = basePath + Constants.fileSeparator
            + "projectJARS" + Constants.fileSeparator + "browserDrivers"
            + Constants.fileSeparator + "IEDriverServer.exe";
    
    
    public static String edgePath = basePath + Constants.fileSeparator
            + "projectJARS" + Constants.fileSeparator + "browserDrivers"
                    + Constants.fileSeparator +
            "MicrosoftWebDriver.exe";
    
    public static String platformCredentials = basePath + Constants.fileSeparator
            + "Platform.xlsx";
    
    
    public static String Parameters = basePath + Constants.fileSeparator
            + "MasterParameter.csv";
    
    
    
    /*Screenshots Results path*/
    public static String getScreenShotPath()
    {
        String screenShotPath = null;
            screenShotPath  = ReportsPath+Constants.fileSeparator ;
            Log.info("Screenshot path for network-drive location " + screenShotPath);
        return screenShotPath;
    }

}
