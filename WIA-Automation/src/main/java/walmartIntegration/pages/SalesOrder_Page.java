package walmartIntegration.pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.TextBox;
import walmartIntegration.utilities.ReadXML;

public class SalesOrder_Page extends commonPage {
	
private Link Order;
private Link SalesOrder;
private Link UpdateOrderStatusLink;
private Link FetchOrdersButton;
private Link SyncShipmentButton;
private Link FirstCheckbox;
private Link Pagination;
private Link SelectAllItems;
private Link Okbutton;
private Link BulkActionDropdown;
private Link BulkUpdateOrderStatus;
private Link BulkSyncShipment;
private Link ErrorMessageForFetchOrder;
private Link SelectAllCheckBox;
private Link CompletedCheckBox;
private Link UpdateStatusButton;
private Link ErrorMessage;
private Link ActionButton;

	public SalesOrder_Page() {

		super(SalesOrder_Page.class.getSimpleName()) ;
	
		
		Order= new Link(ReadXML.getElementLocator("SalesOrder_Page", "Order"),
				"SalesOrder_Page", "Order");
		SalesOrder= new Link(ReadXML.getElementLocator("SalesOrder_Page", "SalesOrder"),
				"SalesOrder_Page", "SalesOrder");
		UpdateOrderStatusLink= new Link(ReadXML.getElementLocator("SalesOrder_Page", "UpdateOrderStatusLink"),
				"SalesOrder_Page", "UpdateOrderStatusLink");
		FetchOrdersButton= new Link(ReadXML.getElementLocator("SalesOrder_Page", "FetchOrdersButton"),
				"SalesOrder_Page", "FetchOrdersButton");
		SyncShipmentButton= new Link(ReadXML.getElementLocator("SalesOrder_Page", "SyncShipmentButton"),
				"SalesOrder_Page", "SyncShipmentButton");
		FirstCheckbox= new Link(ReadXML.getElementLocator("SalesOrder_Page", "FirstCheckbox"),
				"SalesOrder_Page", "FirstCheckbox");
		Pagination= new Link(ReadXML.getElementLocator("SalesOrder_Page", "Pagination"),
				"SalesOrder_Page", "Pagination");
		SelectAllItems= new Link(ReadXML.getElementLocator("SalesOrder_Page", "SelectAllItems"),
				"SalesOrder_Page", "SelectAllItems");
		Okbutton= new Link(ReadXML.getElementLocator("SalesOrder_Page", "Okbutton"),
				"SalesOrder_Page", "Okbutton");
		BulkActionDropdown= new Link(ReadXML.getElementLocator("SalesOrder_Page", "BulkActionDropdown"),
				"SalesOrder_Page", "BulkActionDropdown");
		BulkUpdateOrderStatus= new Link(ReadXML.getElementLocator("SalesOrder_Page", "BulkUpdateOrderStatus"),
				"SalesOrder_Page", "BulkUpdateOrderStatus");
		BulkSyncShipment= new Link(ReadXML.getElementLocator("SalesOrder_Page", "BulkSyncShipment"),
				"SalesOrder_Page", "BulkSyncShipment");
		ErrorMessageForFetchOrder= new Link(ReadXML.getElementLocator("SalesOrder_Page", "ErrorMessageForFetchOrder"),
				"SalesOrder_Page", "ErrorMessageForFetchOrder");
		SelectAllCheckBox= new Link(ReadXML.getElementLocator("SalesOrder_Page", "SelectAllCheckBox"),
				"SalesOrder_Page", "SelectAllCheckBox");
		CompletedCheckBox= new Link(ReadXML.getElementLocator("SalesOrder_Page", "CompletedCheckBox"),
				"SalesOrder_Page", "CompletedCheckBox");
		UpdateStatusButton= new Link(ReadXML.getElementLocator("SalesOrder_Page", "UpdateStatusButton"),
				"SalesOrder_Page", "UpdateStatusButton");
		ErrorMessage= new Link(ReadXML.getElementLocator("SalesOrder_Page", "ErrorMessage"),
				"SalesOrder_Page", "ErrorMessage");
		ActionButton= new Link(ReadXML.getElementLocator("SalesOrder_Page", "ActionButton"),
				"SalesOrder_Page", "ActionButton");
		
		
	}
	
	
		
	public void gotoSalesOrder() {
		Order.click();
		SalesOrder.click();
	}
	
	public void updatingBulkOrderStatus() {
		FirstCheckbox.click();
		if(Pagination.isPresent()) {
			SelectAllItems.click();
			Okbutton.click();
		}
		BulkActionDropdown.click();
		BulkUpdateOrderStatus.click();
		ActionButton.click();
	}
	
	public void updatingBulkShipment() {
		FirstCheckbox.click();
		if(Pagination.isPresent()) {
			SelectAllItems.click();
			Okbutton.click();
		}
		BulkActionDropdown.click();
		BulkSyncShipment.click();
		ActionButton.click();
	}
	
	public void fetchingOrders() throws InterruptedException {
		FetchOrdersButton.click();
		Thread.sleep(10000);
		if(ErrorMessageForFetchOrder.isDisplayed()) {
			Reporter.log("The Error Message is:  "+ErrorMessageForFetchOrder.getText());
			Assert.assertTrue(false);
		}
	}
	
	public void updatingOrderStatus() throws InterruptedException {
		UpdateOrderStatusLink.click();
		SelectAllCheckBox.click();
		CompletedCheckBox.click();
		UpdateStatusButton.click();
		Thread.sleep(5000);
	}
	
	public void syncShipment() throws InterruptedException {
		SyncShipmentButton.click();
		Thread.sleep(10000);
		if(ErrorMessage.isDisplayed()) {
			Reporter.log("The error message is:   "+ErrorMessage.getText());
			Assert.assertTrue(false);
		}
	}
	
	
	
}
