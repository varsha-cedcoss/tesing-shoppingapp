package Framework.GUI.commons.test;

import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import Framework.Custom.Config;
import Framework.Custom.DriverManager;
import Framework.Utils.CommonUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.*;
import java.awt.*;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.math.Rational;

public abstract class commonTest {
	
	 private static ExtentReports extent;
	 protected ExtentTest logger;
	 

	 static {	 
		 initdirectories();
		 final String extentReportName =   Config.EXTENT_REPORT_PATH 
	        		+ Config.EXTENT_REPORT_NAME + ".html";           
	        extent = new ExtentReports(extentReportName, true);        
	        extent
	        	.addSystemInfo("Browser", Config.BROWSER)
	        	.addSystemInfo("Headless", Config.HEADLESS.toString().toUpperCase());
	        extent.loadConfig(new File(System.getProperty("user.dir") + Config.EXTENT_CONFIG_PATH));
	 }
	
	
    @AfterSuite
    public void closeAllBrowsers() {
              DriverManager.closeDriverObjects();
              }

    @Parameters({"browser", "platform", "headless","portNO"})
    @BeforeSuite
    public void setBrowserBeforeSuite(@Optional("") String browser, @Optional("") String platform, @Optional("") String headless , @Optional("") String portNo) {
    //	Reporter.log(portNo);
    	initdirectories();
        setEnv(browser, platform, headless, portNo);
    }
    


    @Parameters({"browser", "platform", "headless","portNO"})
    @BeforeTest
    public void setBrowserBeforeTest(@Optional("") String browser, @Optional("") String platform, @Optional("") String headless , @Optional("") String portNo) {
        setEnv(browser, platform, headless,portNo);        
    }

    @Parameters({"browser", "platform", "headless","portNO"})
    @BeforeClass
    public void setBrowserBeforeClass(@Optional("") String browser, @Optional("") String platform, @Optional("") String headless, @Optional("") String portNo) {
   // 	setEnv(browser, platform, headless,portNo);
    }

    @Parameters({"browser", "platform", "headless","portNO"})
    @BeforeMethod
    public void setBrowserBeforeMethods(@Optional("") String browser, @Optional("") String platform, @Optional("") String headless, @Optional("") String portNo) {
   // 	setEnv(browser, platform, headless,portNo);    
    }
    
    @BeforeMethod
    public void setupExtentReport(Method method) {        
    	logger = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()), method.getName());
    	DriverManager.getDriver().get("https://apps.cedcommerce.com/admin-panel/app/auth/login");
    }


    @AfterMethod
    public void setScreenCaptureTrue() {
        DriverManager.setCaptureScreenShot(true);   
        DriverManager.getDriver().quit();
        
    }

   
    
    @AfterMethod
    public void addLogsIntoExtentReport(ITestResult result) {    	
    	for (String logs : Reporter.getOutput(result)) {
    		logger.log(LogStatus.INFO, logs);    		
    	}
    	
    }
    
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
//    	
    	if(result.getStatus() == ITestResult.SUCCESS){
    		logger.log(LogStatus.PASS, "Test Case Passed: "+result.getName());	
    		
    	}
    	else if(result.getStatus() == ITestResult.FAILURE){
    		logger.log(LogStatus.FAIL, "Test Case Failed: "+result.getName());
    		logger.log(LogStatus.FAIL, "Test Case Failed: "+result.getThrowable());    		
    		logger.log(LogStatus.FAIL, "Snapshot: "+logger.addScreenCapture(CommonUtils.createScreenshot(result)));
    		
    	}
    	else if(result.getStatus() == ITestResult.SKIP){
    		logger.log(LogStatus.SKIP, "Test Case Skipped: "+result.getName());
    		
    	}
    	extent.endTest(logger);
    	extent.flush();
    	
    }
    
    @AfterSuite
    public void endReport() {
    	extent.flush();
        extent.close();
    }
    

    protected static void setEnv(String browser, String platform, String headless , String portNo) {
        if(browser == null || browser.isEmpty()){
            DriverManager.setBrowserName(Config.BROWSER);            
        }else{
            DriverManager.setBrowserName(browser);            
        }
        
        if(portNo == null || portNo.isEmpty()){
            DriverManager.setPortNumber(Config.Port);            
        }else{
            DriverManager.setPortNumber(portNo);            
        }
        
        if(headless == null || headless.isEmpty()){       	
        	DriverManager.setHeadless(Config.HEADLESS);	
        }else{
        	DriverManager.setHeadless(headless);
        }

        if(platform == null || platform.isEmpty()){
            DriverManager.setPlatformName(Config.PLATFORM);
        }else{
            DriverManager.setPlatformName(platform);
        }
    }
    public static synchronized void initdirectories() {
    	try {
    	File reportDirectory = new File(Config.EXTENT_REPORT_PATH);
		FileUtils.forceMkdir(reportDirectory);
		FileUtils.cleanDirectory(reportDirectory);
		File screenshotsDirectory = new File(
				Config.EXTENT_REPORT_PATH + Config.FAILED_TESTCASE_SCREENSHOT_PATH);
		FileUtils.forceMkdir(screenshotsDirectory);
		FileUtils.cleanDirectory(screenshotsDirectory);
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    	
    }
    
}
