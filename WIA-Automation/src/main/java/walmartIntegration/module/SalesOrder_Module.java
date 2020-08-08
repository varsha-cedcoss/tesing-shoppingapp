package walmartIntegration.module;

import walmartIntegration.pages.SalesOrder_Page;

public class SalesOrder_Module {
	SalesOrder_Page SalesP;
		
	public SalesOrder_Module() {
		SalesP=new SalesOrder_Page();
	}
	
	
	public void gotoSalesOrder() {
		SalesP.gotoSalesOrder();
	}
	
	public void updatingBulkOrderStatus() {
		SalesP.updatingBulkOrderStatus();
	}
	
	public void updatingBulkShipment() {
		SalesP.updatingBulkShipment();
	}
	
	public void fetchingOrders() throws InterruptedException {
		SalesP.fetchingOrders();
	}
	
	public void updatingOrderStatus() throws InterruptedException {
		SalesP.updatingOrderStatus();	
	}
	
	public void syncShipment() throws InterruptedException {
		SalesP.syncShipment();
	}
	
	
}
