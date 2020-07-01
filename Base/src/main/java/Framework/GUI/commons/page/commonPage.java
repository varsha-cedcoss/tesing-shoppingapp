package Framework.GUI.commons.page;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import Framework.Custom.DriverManager;

public abstract class commonPage {
	
	 protected String pageName;
	    protected String pageURL;
	    
	    public commonPage(String pageName) {
	        this.pageName = pageName;
	    }

	    /**
	     * This method is used to set the page URL.
	     *
	     * @return Page URL
	     */
	    public String getPageURL() {
	        return this.pageURL;
	    }

	    /**
	     * This method is used to get the page name.
	     *
	     * @return Page name
	     */
	    public String getPageName() {
	        return this.pageName;
	    }

	    /**
	     * This method is used to set the page name.
	     *
	     * @param Page name
	     */
	    public void setPageName(String pageName) {
	        this.pageName = pageName;
	    }  

	    /**
	     * This method is used to launch the web driver on current page.
	     *
	     */
	    public void launch(){
	    	System.out.println("Launching");
	    	Reporter.log("In launch : "+this.pageURL);
	        Reporter.log("<br>Launch URL [" + pageURL + "]");
	        DriverManager.getDriver().get(this.pageURL);
	    }
	    
	    public void openNewTab()
	    {
	        Reporter.log("<br>Opening new tab [" + pageName + "]");
	    }
	    
	    public void navigate(String url){
	        Reporter.log("<br>Launch URL [" + url + "]");
	        DriverManager.getDriver().get(url);
	    }

	    public static synchronized void takeScreenshot() {
	        final DateFormat timeFormat = new SimpleDateFormat("MM.dd.yyyy HH-mm-ss");
	        final String fileName = Reporter.getCurrentTestResult().getMethod().getMethodName() + "_" + timeFormat.format(new Date()) + ".png";
	        final WebDriver driver = DriverManager.getCurrentWebDriver();

	        if (driver != null) {
	            try {
	                File scrFile;

	                if (driver.getClass().equals(RemoteWebDriver.class)) {
	                    scrFile = ((TakesScreenshot) new Augmenter().augment(driver))
	                            .getScreenshotAs(OutputType.FILE);
	                } else {
	                    scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	                }

	                String outputDir = Reporter.getCurrentTestResult().getTestContext().getOutputDirectory();
	                outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separator)) + "/html";
	                final File saved = new File(outputDir, fileName);
	                FileUtils.copyFile(scrFile, saved);
	                Reporter.log("<br><a href=\"" + fileName + "\" target=\"_blank\"><b>Screenshot</b></a>");
	            } catch (IOException e) {
	                //TODO
	            }
	        } else {
	            Reporter.log("<br>Couldn't capture screen-shot as WebDriver is null");
	        }
	    }
	    
}
