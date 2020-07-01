package TestScripts;

import com.opencsv.CSVWriter;

import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Launch {
    static WebDriver driver;
    ElementPath elementpath;
    String[] mail_pass = {"shantanu.cedcoss@gmail.com_dracarys"};
    String[] mail_Pass = mail_pass[0].split("_");
    String ShopifyloginMail = mail_Pass[0];
    String ShopifyLoginPassword = mail_Pass[1];

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--test-type");
//        options.addArguments("--start-maximized");
//        options.addArguments("--version");
//        System.setProperty("webdriver.chrome.driver", "/home/cedcoss/Downloads/CedcossAutomation/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.navigate().to("https://apps.cedcommerce.com/integration/walmart");
//        driver.manage().window().maximize();
        elementpath = PageFactory.initElements(driver, ElementPath.class);
        elementpath.InstallAppButton.click();
        elementpath.AddAppButton.click();
       new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(elementpath.ShopifyUrlTextbox));
        elementpath.ShopifyUrlTextbox.click();
        elementpath.ShopifyUrlTextbox.sendKeys("https://petvetget.myshopify.com");
        elementpath.ShopifyUrlTextbox.sendKeys(Keys.ENTER);
       elementpath.ShopifyLoginMail.sendKeys(ShopifyloginMail);
        Thread.sleep(2000);
        elementpath.NextButton.click();
       elementpath.ShopifyPassword.click();
        elementpath.ShopifyPassword.sendKeys(ShopifyLoginPassword);
        Thread.sleep(2000);
        elementpath.ShopifyPassword.sendKeys(Keys.ENTER);

    }

    @Test(retryAnalyzer = RetryLogic.Retrylogic.class)
    public void Test1() throws InterruptedException, IOException {

        elementpath.Product_Module.click();
        elementpath.Product_ManageProduct.click();
        /*   paginationMethod();
        elementpath.BulkActionDropdown.click();
        elementpath.SyncwithShopify.click();
        elementpath.ActionButton.click();
        driver.switchTo().activeElement();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(elementpath.SyncButton));
        elementpath.SyncButton.click();
        Thread.sleep(10000);
        paginationMethod();
        elementpath.BulkActionDropdown.click();
        elementpath.UpdateInventory.click();
        elementpath.ActionButton.click();
        //Thread.sleep(10000);
        ErrorMessageHandling();
        paginationMethod();
        elementpath.BulkActionDropdown.click();
        elementpath.UpdatePrice.click();
        elementpath.ActionButton.click();
        Thread.sleep(10000);
        ErrorMessageHandling();
        elementpath.UpdateStatusButton.click();
        Thread.sleep(2000);
        String s = elementpath.ErrorMessageforUpdateStatus.getText();
        System.out.println(s);*/

    }/*
    @DataProviderParams({ "fileName=InputData.csv", "tableName=PresenceofElement" })
    @Test(retryAnalyzer = Retrylogic.class, description = "clicking all options", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider")
     public void clickingallOptions(String url, String shopifyUrl) throws InterruptedException {
    	 ChromeOptions options = new ChromeOptions();
         options.addArguments("--test-type");
         options.addArguments("--start-maximized");
         options.addArguments("--version");
         System.setProperty("webdriver.chrome.driver", "/home/cedcoss/Downloads/CedcossAutomation/WIA/chromedriver");
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.navigate().to(url);
         driver.manage().window().maximize();
         elementpath = PageFactory.initElements(driver, ElementPath.class);
         elementpath.InstallAppButton.click();
         elementpath.AddAppButton.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(elementpath.ShopifyUrlTextbox));
         elementpath.ShopifyUrlTextbox.click();
         elementpath.ShopifyUrlTextbox.sendKeys(shopifyUrl);
         elementpath.ShopifyUrlTextbox.sendKeys(Keys.ENTER);
        elementpath.ShopifyLoginMail.sendKeys(ShopifyloginMail);
         Thread.sleep(2000);
         elementpath.NextButton.click();
        elementpath.ShopifyPassword.click();
         elementpath.ShopifyPassword.sendKeys(ShopifyLoginPassword);
         Thread.sleep(2000);
         elementpath.ShopifyPassword.sendKeys(Keys.ENTER);

    	elementpath.Dashboard.click();
        Thread.sleep(2000);
        elementpath.Product_Module.click();
        elementpath.Product_CategoryMapping.click();
        Thread.sleep(4000);
        elementpath.Product_AttributeMapping.click();
        Thread.sleep(4000);
        elementpath.Product_ProductTaxcode.click();
        Thread.sleep(4000);
        elementpath.Product_Repricing.click();
        Thread.sleep(4000);
        elementpath.Product_LagTime.click();
        Thread.sleep(4000);
        elementpath.Product_ShareProduct.click();
        Thread.sleep(4000);
        elementpath.Product_NotInAppProducts.click();
        Thread.sleep(4000);
        elementpath.ImportProducts.click();
        Thread.sleep(4000);
        elementpath.WalmartFeeds.click();
        Thread.sleep(4000);
        elementpath.Order.click();
        Thread.sleep(4000);
        elementpath.Order_SalesOrder.click();
        Thread.sleep(4000);
        elementpath.Order_FailedOrder.click();
        Thread.sleep(4000);
        elementpath.ImportExport.click();
        elementpath.ImportExport_ProductUpdate.click();
        Thread.sleep(4000);
        elementpath.ImportExport_RetireProduct.click();
        Thread.sleep(4000);
        elementpath.ImportExport_UploadProduct.click();
        Thread.sleep(4000);
        elementpath.ImportExport_AdvancedAttributes.click();
        Thread.sleep(4000);
        elementpath.ImportExport_ShippingExceptions.click();
        Thread.sleep(4000);
        elementpath.Promotion.click();
        Thread.sleep(4000);
        elementpath.Promotion_ManagePromotion.click();
        Thread.sleep(4000);
        elementpath.Promotion_PromotionFeed.click();

    }

    public void paginationMethod() {
        elementpath.FirstCheckbox.click();
        if (elementpath.Pagination.isEnabled()) {
            elementpath.SelectAllItems.click();
            elementpath.Okbutton.click();
        } else {
        }
    }*/

    public void ErrorMessageHandling() throws InterruptedException, IOException {
        if (elementpath.ErrorMessage.getText().contentEquals("Something went wrong, please try after sometime") || elementpath.ErrorMessage.getText().contains("item(s) failed during processing.")) {
            System.out.println(ShopifyloginMail);
            System.out.println(ShopifyLoginPassword);
            elementpath.BacktoPreviousButton.click();
            Thread.sleep(5000);
            writeinCSV();
        }
    }

    public void writeinCSV() throws IOException {
        String csv = "I:\\java\\CedcossAutomation\\src\\test\\java\\output.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv, true), ',');
        File file = new File(csv);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] tempArr;

        while ((line = br.readLine()) != null) {
            tempArr = line.split(",");
            for (String tempStr : tempArr) {
                System.out.print(tempStr + " ");
                if (tempStr.equals(mail_pass))
                    fr.close();
                    else
                writer.writeNext(mail_pass);
                writer.close();
            }
        }
    }
//    @AfterMethod
//    public void AfterTest(){
//        driver.quit();
//    }
}
