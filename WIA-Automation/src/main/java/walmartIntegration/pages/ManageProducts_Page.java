package walmartIntegration.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public ManageProducts_Page() {
		super(ManageProducts_Page.class.getSimpleName());
		this.pageURL= LocalConfig.WIA_URL;
		
		
		Product_Module= new Link(ReadXML.getElementLocator("DashboardPage", "Product_Module"),
				"DashboardPage", "Product_Module");
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
	}
	
	public void LoggingInAccount() throws InterruptedException {

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
