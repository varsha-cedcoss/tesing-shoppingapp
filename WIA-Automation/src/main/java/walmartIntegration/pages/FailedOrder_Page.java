package walmartIntegration.pages;

import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import walmartIntegration.utilities.ReadXML;

public class FailedOrder_Page extends commonPage{
	private Link Order;
	private Link FailedOrder;
	
	
	
	
	public FailedOrder_Page() {
	
		super(FailedOrder_Page.class.getSimpleName());
		

		Order= new Link(ReadXML.getElementLocator("FailedOrder_Page", "Order"),
				"FailedOrder_Page", "Order");
		FailedOrder= new Link(ReadXML.getElementLocator("FailedOrder_Page", "FailedOrder"),
				"FailedOrder_Page", "FailedOrder");
		
		
	}
	
	
	public void gotoFailedOrder() {
		Order.click();
		FailedOrder.click();
	}
}
