package walmartIntegration.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.TextBox;
import walmartIntegration.automation.LocalConfig;
import walmartIntegration.utilities.ReadXML;

public class DashboardPage extends commonPage {
	
	private Link Product_Module;
	private TextBox ShopifyUrlTextbox;
	private TextBox ShopifyLogin;
	private Link NextButton;
	private TextBox ShopifyPassword;
	private Link Dashboard;
	private Link Product_ManageProducts;
	private Link Product_CategoryMapping;
	private Link Product_AttributeMapping;
	private Link Product_ProductTaxcode;
	private Link Product_Repricing;
	private Link Product_LagTime;
	private Link Product_ShareProduct;
	private Link Product_NotInAppProducts;
	private Link ImportProducts;
	private Link WalmartFeeds;
	private Link Order;
	private Link Order_SalesOrder;
	private Link Order_FailedOrder;
	private Link ImportExport;
	private Link ImportExport_ProductUpdate;
	private Link ImportExport_RetireProduct;
	private Link ImportExport_UploadProduct;
	private Link ImportExport_AdvancedAttributes;
	private Link ImportExport_ShippingExceptions;
	private Link Promotion;
	private Link Promotion_ManagePromotion;
	private Link Promotion_PromotionFeed;
	private Link Help;
	private Link Help_KnowledgeBase;
	private Link Help_Documentation;
	private Link Help_WalmartBlog;
	private Link Settings;
	private Link PricingPlan;
	private Link RightContent;
	private TextBox AdminUsername;
	private TextBox AdminPassword;
	private Link WalmartDropdown;
	private Link WalmartShopDetails;
	private TextBox ShopNameTextBox;
	private Link LoginAsButton;
	private Link Product_ManageProduct;
	private Link FirstCheckbox;
	private Link Pagination;
	private Link SelectAllItems;
	private Link Okbutton;
	private Link BulkActionDropdown;
	private Link SyncwithShopifyinDropdown;
	private Link ActionButton;
	private Link SyncButton;
	private Link UpdateInventory;
	private Link ErrorMessage;
	private Link BacktoPreviousButton;
	
	
	
	
	
	String Elements= null;
	WebDriver driver;
	String original=null;
	
	
	public DashboardPage() {
		super(DashboardPage.class.getSimpleName());
		this.pageURL= LocalConfig.WIA_URL;
		
		Product_Module= new Link(ReadXML.getElementLocator("DashboardPage", "Product_Module"),
				"DashboardPage", "Product_Module");
		ShopifyUrlTextbox= new TextBox(ReadXML.getElementLocator("DashboardPage", "ShopifyUrlTextbox"),
				"DashboardPage", "ShopifyUrlTextbox");
		ShopifyLogin= new TextBox(ReadXML.getElementLocator("DashboardPage", "ShopifyLogin"),
				"DashboardPage", "ShopifyLogin");
		NextButton= new Link(ReadXML.getElementLocator("DashboardPage", "NextButton"),
				"DashboardPage", "NextButton");
		ShopifyPassword= new TextBox(ReadXML.getElementLocator("DashboardPage", "ShopifyPassword"),
				"DashboardPage", "ShopifyPassword");
		Dashboard= new Link(ReadXML.getElementLocator("DashboardPage", "Dashboard"),
				"DashboardPage", "Dashboard");
		Product_ManageProducts= new Link(ReadXML.getElementLocator("DashboardPage", "Product_ManageProducts"),
				"DashboardPage", "Product_ManageProducts");
		Product_CategoryMapping= new Link(ReadXML.getElementLocator("DashboardPage", "Product_CategoryMapping"),
				"DashboardPage", "Product_CategoryMapping");
		Product_AttributeMapping= new Link(ReadXML.getElementLocator("DashboardPage", "Product_AttributeMapping"),
				"DashboardPage", "Product_AttributeMapping");
		Product_ProductTaxcode= new Link(ReadXML.getElementLocator("DashboardPage", "Product_ProductTaxcode"),
				"DashboardPage", "Product_ProductTaxcode");
		Product_Repricing= new Link(ReadXML.getElementLocator("DashboardPage", "Product_Repricing"),
				"DashboardPage", "Product_Repricing");
		Product_LagTime= new Link(ReadXML.getElementLocator("DashboardPage", "Product_LagTime"),
				"DashboardPage", "Product_LagTime");
		Product_ShareProduct= new Link(ReadXML.getElementLocator("DashboardPage", "Product_ShareProduct"),
				"DashboardPage", "Product_ShareProduct");
		Product_NotInAppProducts= new Link(ReadXML.getElementLocator("DashboardPage", "Product_NotInAppProducts"),
				"DashboardPage", "Product_NotInAppProducts");
		ImportProducts= new Link(ReadXML.getElementLocator("DashboardPage", "ImportProducts"),
				"DashboardPage", "ImportProducts");
		WalmartFeeds= new Link(ReadXML.getElementLocator("DashboardPage", "WalmartFeeds"),
				"DashboardPage", "WalmartFeeds");
		Order= new Link(ReadXML.getElementLocator("DashboardPage", "Order"),
				"DashboardPage", "Order");
		Order_SalesOrder= new Link(ReadXML.getElementLocator("DashboardPage", "Order_SalesOrder"),
				"DashboardPage", "Order_SalesOrder");
		Order_FailedOrder= new Link(ReadXML.getElementLocator("DashboardPage", "Order_FailedOrder"),
				"DashboardPage", "Order_FailedOrder");
		ImportExport= new Link(ReadXML.getElementLocator("DashboardPage", "ImportExport"),
				"DashboardPage", "ImportExport");
		ImportExport_ProductUpdate= new Link(ReadXML.getElementLocator("DashboardPage", "ImportExport_ProductUpdate"),
				"DashboardPage", "ImportExport_ProductUpdate");
		ImportExport_RetireProduct= new Link(ReadXML.getElementLocator("DashboardPage", "ImportExport_RetireProduct"),
				"DashboardPage", "ImportExport_RetireProduct");
		ImportExport_UploadProduct= new Link(ReadXML.getElementLocator("DashboardPage", "ImportExport_UploadProduct"),
				"DashboardPage", "ImportExport_UploadProduct");
		ImportExport_AdvancedAttributes= new Link(ReadXML.getElementLocator("DashboardPage", "ImportExport_AdvancedAttributes"),
				"DashboardPage", "ImportExport_AdvancedAttributes");
		ImportExport_ShippingExceptions= new Link(ReadXML.getElementLocator("DashboardPage", "ImportExport_ShippingExceptions"),
				"DashboardPage", "ImportExport_ShippingExceptions");
		Promotion= new Link(ReadXML.getElementLocator("DashboardPage", "Promotion"),
				"DashboardPage", "Promotion");
		Promotion_ManagePromotion= new Link(ReadXML.getElementLocator("DashboardPage", "Promotion_ManagePromotion"),
				"DashboardPage", "Promotion_ManagePromotion");
		Promotion_PromotionFeed= new Link(ReadXML.getElementLocator("DashboardPage", "Promotion_PromotionFeed"),
				"DashboardPage", "Promotion_PromotionFeed");
		Help= new Link(ReadXML.getElementLocator("DashboardPage", "Help"),
				"DashboardPage", "Help");
		Help_KnowledgeBase= new Link(ReadXML.getElementLocator("DashboardPage", "Help_KnowledgeBase"),
				"DashboardPage", "Help_KnowledgeBase");
		Help_Documentation= new Link(ReadXML.getElementLocator("DashboardPage", "Help_Documentation"),
				"DashboardPage", "Help_Documentation");
		Help_WalmartBlog= new Link(ReadXML.getElementLocator("DashboardPage", "Help_WalmartBlog"),
				"DashboardPage", "Help_WalmartBlog");
		Settings= new Link(ReadXML.getElementLocator("DashboardPage", "Settings"),
				"DashboardPage", "Settings");
		PricingPlan= new Link(ReadXML.getElementLocator("DashboardPage", "PricingPlan"),
				"DashboardPage", "PricingPlan");
		RightContent= new Link(ReadXML.getElementLocator("DashboardPage", "RightContent"),
				"DashboardPage", "RightContent");
		AdminUsername= new TextBox(ReadXML.getElementLocator("DashboardPage", "AdminUsername"),
				"DashboardPage", "AdminUsername");
		AdminPassword= new TextBox(ReadXML.getElementLocator("DashboardPage", "AdminPassword"),
				"DashboardPage", "AdminPassword");
		WalmartDropdown= new Link(ReadXML.getElementLocator("DashboardPage", "WalmartDropdown"),
				"DashboardPage", "WalmartDropdown");
		WalmartShopDetails= new Link(ReadXML.getElementLocator("DashboardPage", "WalmartShopDetails"),
				"DashboardPage", "WalmartShopDetails");
		ShopNameTextBox= new TextBox(ReadXML.getElementLocator("DashboardPage", "ShopNameTextBox"),
				"DashboardPage", "ShopNameTextBox");
		LoginAsButton= new Link(ReadXML.getElementLocator("DashboardPage", "LoginAsButton"),
				"DashboardPage", "LoginAsButton");
		
		Product_ManageProduct= new Link(ReadXML.getElementLocator("DashboardPage", "Product_ManageProduct"),
				"DashboardPage", "Product_ManageProduct");
		FirstCheckbox= new Link(ReadXML.getElementLocator("DashboardPage", "FirstCheckbox"),
				"DashboardPage", "FirstCheckbox");
		Pagination= new Link(ReadXML.getElementLocator("DashboardPage", "Pagination"),
				"DashboardPage", "Pagination");
		SelectAllItems= new Link(ReadXML.getElementLocator("DashboardPage", "SelectAllItems"),
				"DashboardPage", "SelectAllItems");
		Okbutton= new Link(ReadXML.getElementLocator("DashboardPage", "Okbutton"),
				"DashboardPage", "Okbutton");
		BulkActionDropdown= new Link(ReadXML.getElementLocator("DashboardPage", "BulkActionDropdown"),
				"DashboardPage", "BulkActionDropdown");
		SyncwithShopifyinDropdown= new Link(ReadXML.getElementLocator("DashboardPage", "SyncwithShopifyinDropdown"),
				"DashboardPage", "SyncwithShopifyinDropdown");
		ActionButton= new Link(ReadXML.getElementLocator("DashboardPage", "ActionButton"),
				"DashboardPage", "ActionButton");
		SyncButton= new Link(ReadXML.getElementLocator("DashboardPage", "SyncButton"),
				"DashboardPage", "SyncButton");
		UpdateInventory= new Link(ReadXML.getElementLocator("DashboardPage", "UpdateInventory"),
				"DashboardPage", "UpdateInventory");
		ErrorMessage= new Link(ReadXML.getElementLocator("DashboardPage", "ErrorMessage"),
				"DashboardPage", "ErrorMessage");
		BacktoPreviousButton= new Link(ReadXML.getElementLocator("DashboardPage", "BacktoPreviousButton"),
				"DashboardPage", "BacktoPreviousButton");
		
		
		
	}

	    

	
	
	
	public void LoggingInAccount() throws InterruptedException {
//		ShopifyUrlTextbox.sendKeys("petvetget.myshopify.com");
//		ShopifyUrlTextbox.sendKeys(Keys.ENTER);
//		ShopifyLogin.sendKeys("shantanu.cedcoss@gmail.com");
//		Thread.sleep(2000);
//		NextButton.click();
//		ShopifyPassword.sendKeys("dracarys");
//		Thread.sleep(2000);
//		ShopifyPassword.sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
		AdminUsername.sendKeys("automated_script");
		AdminPassword.sendKeys("Z3E&=_4a;g%k");
		AdminPassword.sendKeys(Keys.ENTER);
		Thread.sleep(3000);		
		WalmartDropdown.click();
		WalmartShopDetails.click();
		ShopNameTextBox.sendKeys("ceddev");
		ShopNameTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		LoginAsButton.click();
		Thread.sleep(20000);
	}
	
	public void serverLogin() {
		try{
			String userName="cedcoss";
			String password="cedcoss007";
		       Screen screen=new Screen();
		       Pattern  image1=new Pattern("/home/cedcoss/Pictures/Username.png");
		       Pattern  image2=new Pattern("/home/cedcoss/Pictures/Password.png");
		       Pattern  image3=new Pattern("/home/cedcoss/Pictures/SignIn.png");

		    screen.wait(image1,10);
		    screen.type(image1,userName);
		    screen.type(image2,password);
		    screen.click(image3);
		       }
		       catch(Exception e){
		           System.out.println("There is no alert");
		       }
	}
	
	public void ClickingAllLinks() {
		
		
		ArrayList<String> url=new ArrayList<String>();
		ArrayList<WebElement> ele=new ArrayList<WebElement>();
		ArrayList<WebElement> list=new ArrayList<WebElement>(DriverManager.getDriver().findElements(By.xpath("//div[@class='Polaris-Page Polaris-Page--fullWidth']/descendant::a")));
		
		System.out.println(list.size());
		System.out.println(list);
		for(int i=1;i<=list.size();i++) {
			String s=String.valueOf(i);
			WebElement elem=something(s);
			System.out.println("xpath  from function something is :    "+elem);
			try {
				Reporter.log("Elements text from something is:     "+elem.getText());
				if (elem.isEnabled() || elem.isDisplayed()) {
					((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",elem );
					((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", elem);
					Reporter.log("The element clicked is:    "+elem.getText());}
				else {
					Reporter.log("element is not visible");
				}
				Reporter.log("Clicking This: The elements link from function something is:    "+elem.getAttribute("href"));
				url.add(switchingTabstoVerifyUrl());
			}
			catch(StaleElementReferenceException e){
				if(ele.contains(elem)) {
					ele.remove(elem);
				}
				else {
					ele.add(elem);
				}
			}
			catch(NoSuchElementException e) {
				if(ele.contains(elem)) {
					ele.remove(elem);
				}
				else {
					ele.add(elem);
				}
			}
			catch(ElementNotInteractableException e) {
				if(ele.contains(elem)) {
					ele.remove(elem);
				}
				else {
					ele.add(elem);
				}
				}
			Dashboard.click();
		}
		Reporter.log("Size of failed elements:   "+ele.size());
		Reporter.log("Failed elements are :   "+ele);
		Reporter.log("Size of passed elements:   "+url.size());
		Reporter.log("Passed Elements are :  "+url);
		DriverManager.getDriver().quit();
		
	}
	
	
	public WebElement something(String index) {
		Elements="(//div[@class='Polaris-Page Polaris-Page--fullWidth']/descendant::a)[";
		Elements=Elements.concat(index);
		Elements=Elements.concat("]");
		WebElement element=DriverManager.getDriver().findElement(By.xpath(Elements));
		return element;
	}
	
	public String switchingTabstoVerifyUrl() {
		ArrayList<String> tabs= new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
		Reporter.log("Total no of tabs open are:   "+tabs.size());
		String actual;
		if(tabs.size()==2) {
			DriverManager.getDriver().switchTo().window(tabs.get(1));
			actual=DriverManager.getDriver().getCurrentUrl();
			Reporter.log("Current Url is: "+actual);
			DriverManager.getDriver().close();
			DriverManager.getDriver().switchTo().window(tabs.get(0));
		}
			else {
			actual=DriverManager.getDriver().getCurrentUrl();
			System.out.println("Current Url is: "+actual);
		}

		return actual;
	}
	
	public void ClickingAllOptions() throws InterruptedException {
		WebElement[] elements= {Dashboard,Product_Module,Product_CategoryMapping,Product_AttributeMapping,Product_ProductTaxcode,Product_Repricing,Product_LagTime,Product_ShareProduct,Product_NotInAppProducts,ImportProducts,WalmartFeeds,Order,Order_SalesOrder,Order_FailedOrder,
				ImportExport,ImportExport_ProductUpdate,ImportExport_RetireProduct,ImportExport_UploadProduct,ImportExport_AdvancedAttributes,
				ImportExport_ShippingExceptions,Promotion,Promotion_ManagePromotion,Promotion_PromotionFeed,Help,Help_KnowledgeBase,Help_Documentation,
				Help_WalmartBlog,Settings,PricingPlan};
		
		for(int i=0;i<elements.length;i++) {
			if(elements[i].isDisplayed() || elements[i].isEnabled()) {
				if(!elements[i].equals(Help_Documentation)) {
				elements[i].click();
				Thread.sleep(1000);}
				else {
//					String original=driver.getCurrentUrl();
//					elements[i].click();
//					Thread.sleep(2000);
//					driver.navigate().to(original);
//					Thread.sleep(2000);
//					Help.click();
				}
			}
			else {
				Reporter.log(elements[i].getText()+"   is not clickable");
			}
		}
		
		DriverManager.getDriver().quit();
	}
	
	public void ErrorChecking() {
		boolean error=false;
		String text="Something Went Wrong . We will back soon";
		if(RightContent.getText().equals(text)) {
			error=true;
			System.out.println(error);
		}
		else {
			System.out.println(error);
		}
	}
	public void VerifyingSyncWithShopify() throws InterruptedException, IOException {
	
	  Product_Module.click();
      Product_ManageProduct.click();
     paginationMethod();
      BulkActionDropdown.click();
      SyncwithShopifyinDropdown.click();
      ActionButton.click();
      DriverManager.getDriver().switchTo().activeElement();
     new WebDriverWait(DriverManager.getDriver(), 20).until(ExpectedConditions.elementToBeClickable( SyncButton));
      SyncButton.click();
     Thread.sleep(10000);
     paginationMethod();
      BulkActionDropdown.click();
      UpdateInventory.click();
      ActionButton.click();
     //Thread.sleep(10000);
     ErrorMessageHandling();
     
     
	
	}
	 public void paginationMethod() {
		 new WebDriverWait(DriverManager.getDriver(), 20).until(ExpectedConditions.elementToBeClickable( FirstCheckbox));
	         FirstCheckbox.click();
	        if ( Pagination.isEnabled()) {
	             SelectAllItems.click();
	             Okbutton.click();
	        } else {
	        }
	    }
	 public void ErrorMessageHandling() throws InterruptedException, IOException {
	        if ( ErrorMessage.getText().contentEquals("Something went wrong, please try after sometime") ||  ErrorMessage.getText().contains("item(s) failed during processing.")) {
       
	             BacktoPreviousButton.click();
	            Thread.sleep(5000);}
	 }
	
}
