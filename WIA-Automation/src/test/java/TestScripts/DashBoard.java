package TestScripts;

import org.apache.xpath.functions.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;
import walmartIntegration.module.DashboardModule;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DashBoard extends commonTest{
	 WebDriver driver;
//	ElementPath elementpath;
//	String ShopifyloginMail="shantanu.cedcoss@gmail.com";
//	String ShopifyLoginPassword="dracarys";
//	String Elements=null;
	private DashboardModule dashM;

@BeforeMethod
	private void BeforeMethod() throws InterruptedException {
	dashM=new DashboardModule();
	dashM.LoggingInAccount();
	}
		
//@Test(priority=1)
//	public void clickingAllOptions() {
//		dashM=new DashboardModule();
//		dashM.ClickingAllOptions();
//	
//	}
//@Test(priority=2)
//public void clickingAllLinks() {
//	dashM=new DashboardModule();
//	dashM.ClickingAllLinks();
//}
@Test
public void ManageProduct() throws InterruptedException, IOException {
	dashM=new DashboardModule();
	dashM.VerifyingSyncWithShopify();
	

}



}
