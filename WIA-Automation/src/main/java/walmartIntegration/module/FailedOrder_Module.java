package walmartIntegration.module;

import walmartIntegration.pages.FailedOrder_Page;

public class FailedOrder_Module {
	FailedOrder_Page failedP;
		
	public FailedOrder_Module() {
		failedP=new FailedOrder_Page();
	}
	
	public void gotoFailedOrder() {
		failedP.gotoFailedOrder();
	}
}
