package GoogleIntegration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import GoogleIntegration.utilities.ReadXML;

public class Products_Page extends commonPage{
	private Link Products;
	private Link SelectProcess;
	private Link YesButton;
	private Link BulkActions;
	private Link SyncWithShopify;
	
	public Products_Page() {
		super(Products_Page.class.getSimpleName());
		Products= new Link(ReadXML.getElementLocator("Products_Page", "Products"),
				"Products_Page", "Products");
		SelectProcess= new Link(ReadXML.getElementLocator("Products_Page", "SelectProcess"),
				"Products_Page", "SelectProcess");
		YesButton= new Link(ReadXML.getElementLocator("Products_Page", "YesButton"),
				"Products_Page", "YesButton");
		BulkActions= new Link(ReadXML.getElementLocator("Products_Page", "BulkActions"),
				"Products_Page", "BulkActions");
		SyncWithShopify= new Link(ReadXML.getElementLocator("Products_Page", "SyncWithShopify"),
				"Products_Page", "SyncWithShopify");
	}
	
	public void goToProductsTab(){
		Products.click();
	}
	
	public void selectProduct(String variantId) {
		String xpath="//input[@id='";
		xpath=xpath.concat(variantId);
		xpath=xpath.concat("']/parent::span");
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void unpublishFromGoogle() {
		Select select=new Select(SelectProcess);
		select.selectByVisibleText("Unpublish from Google");
		YesButton.click();
	}
	
	public void syncWithShopify() {
		BulkActions.click();
		SyncWithShopify.click();
	}

}
