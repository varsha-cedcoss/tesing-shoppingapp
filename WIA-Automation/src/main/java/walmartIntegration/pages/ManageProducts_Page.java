package walmartIntegration.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.TextBox;
import walmartIntegration.automation.LocalConfig;
import walmartIntegration.utilities.ReadXML;

public class ManageProducts_Page extends commonPage{

	private Link Product_Module;
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
	private TextBox AdminUsername;
	private TextBox AdminPassword;
	private Link WalmartDropdown;
	private Link WalmartShopDetails;
	private TextBox ShopNameTextBox;
	private Link LoginAsButton;
	private Link UpdatePrice;
	
	public ManageProducts_Page() {
		super(ManageProducts_Page.class.getSimpleName());
		this.pageURL= LocalConfig.WIA_URL;
		
		
		Product_Module= new Link(ReadXML.getElementLocator("ManageProducts_Page", "Product_Module"),
				"ManageProducts_Page", "Product_Module");
		Product_ManageProduct= new Link(ReadXML.getElementLocator("ManageProducts_Page", "Product_ManageProduct"),
				"ManageProducts_Page", "Product_ManageProduct");
		FirstCheckbox= new Link(ReadXML.getElementLocator("ManageProducts_Page", "FirstCheckbox"),
				"ManageProducts_Page", "FirstCheckbox");
		Pagination= new Link(ReadXML.getElementLocator("ManageProducts_Page", "Pagination"),
				"ManageProducts_Page", "Pagination");
		SelectAllItems= new Link(ReadXML.getElementLocator("ManageProducts_Page", "SelectAllItems"),
				"ManageProducts_Page", "SelectAllItems");
		Okbutton= new Link(ReadXML.getElementLocator("ManageProducts_Page", "Okbutton"),
				"ManageProducts_Page", "Okbutton");
		BulkActionDropdown= new Link(ReadXML.getElementLocator("ManageProducts_Page", "BulkActionDropdown"),
				"ManageProducts_Page", "BulkActionDropdown");
		SyncwithShopifyinDropdown= new Link(ReadXML.getElementLocator("ManageProducts_Page", "SyncwithShopifyinDropdown"),
				"ManageProducts_Page", "SyncwithShopifyinDropdown");
		ActionButton= new Link(ReadXML.getElementLocator("ManageProducts_Page", "ActionButton"),
				"ManageProducts_Page", "ActionButton");
		SyncButton= new Link(ReadXML.getElementLocator("ManageProducts_Page", "SyncButton"),
				"ManageProducts_Page", "SyncButton");
		UpdateInventory= new Link(ReadXML.getElementLocator("ManageProducts_Page", "UpdateInventory"),
				"ManageProducts_Page", "UpdateInventory");
		ErrorMessage= new Link(ReadXML.getElementLocator("ManageProducts_Page", "ErrorMessage"),
				"ManageProducts_Page", "ErrorMessage");
		BacktoPreviousButton= new Link(ReadXML.getElementLocator("ManageProducts_Page", "BacktoPreviousButton"),
				"ManageProducts_Page", "BacktoPreviousButton");
		AdminUsername= new TextBox(ReadXML.getElementLocator("ManageProducts_Page", "AdminUsername"),
				"ManageProducts_Page", "AdminUsername");
		AdminPassword= new TextBox(ReadXML.getElementLocator("ManageProducts_Page", "AdminPassword"),
				"ManageProducts_Page", "AdminPassword");
		WalmartDropdown= new Link(ReadXML.getElementLocator("ManageProducts_Page", "WalmartDropdown"),
				"ManageProducts_Page", "WalmartDropdown");
		WalmartShopDetails= new Link(ReadXML.getElementLocator("ManageProducts_Page", "WalmartShopDetails"),
				"ManageProducts_Page", "WalmartShopDetails");
		ShopNameTextBox= new TextBox(ReadXML.getElementLocator("ManageProducts_Page", "ShopNameTextBox"),
				"ManageProducts_Page", "ShopNameTextBox");
		LoginAsButton= new Link(ReadXML.getElementLocator("ManageProducts_Page", "LoginAsButton"),
				"ManageProducts_Page", "LoginAsButton");
		UpdatePrice= new Link(ReadXML.getElementLocator("ManageProducts_Page", "UpdatePrice"),
				"ManageProducts_Page", "UpdatePrice");
	}
	
	public void LoggingInAccount() throws InterruptedException {

		AdminUsername.sendKeys("automated_script");
		AdminPassword.sendKeys("Z3E&=_4a;g%k");
		AdminPassword.sendKeys(Keys.ENTER);
		Thread.sleep(3000);		
		
	}
	
	public void selectingAShop(String shopName) throws InterruptedException {
		WalmartDropdown.click();
		WalmartShopDetails.click();
		ShopNameTextBox.sendKeys(shopName);
		ShopNameTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		LoginAsButton.click();
		Thread.sleep(5000);
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
	    //	      BulkActionDropdown.click();
//	      UpdateInventory.click();
//	      ActionButton.click();
	     //Thread.sleep(10000);
	     ErrorMessageHandling();
	     Reporter.log("Sync with shopify done");
		}
	
	public void updatingprice() throws InterruptedException, IOException {
		  Product_Module.click();
	      Product_ManageProduct.click();
	     paginationMethod();
		 BulkActionDropdown.click();
	     UpdatePrice.click();
	     ActionButton.click();
	     Thread.sleep(10000);
	     ErrorMessageHandling();
	     Reporter.log("Price has been updated");
	}
		 public void paginationMethod() {
			 new WebDriverWait(DriverManager.getDriver(), 20).until(ExpectedConditions.elementToBeClickable( FirstCheckbox));
		         FirstCheckbox.click();
		        if ( Pagination.isPresent()) {
		             SelectAllItems.click();
		             Okbutton.click();
		        } else {
		        }
		    }
		 public void ErrorMessageHandling() throws InterruptedException, IOException {
			 
			 if(ErrorMessage.isPresent()) {
		        if ( ErrorMessage.getText().contentEquals("Something went wrong, please try after sometime") ||  ErrorMessage.getText().contains("item(s) failed during processing.")) {
	       
		             BacktoPreviousButton.click();
		            Thread.sleep(5000);
		            }
			 }
			 else {
				 Reporter.log("No errror message present");
			 }
		 }
		 
		 public void updatingInventory() throws InterruptedException, IOException {
			 Product_Module.click();
		      Product_ManageProduct.click();
		     paginationMethod();
			 BulkActionDropdown.click();
			 UpdateInventory.click();
		      ActionButton.click();
		     Thread.sleep(10000);
		     ErrorMessageHandling();
		     Reporter.log("Inventory has been updated");
		 }
}
