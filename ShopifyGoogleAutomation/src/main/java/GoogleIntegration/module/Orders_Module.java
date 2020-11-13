package GoogleIntegration.module;

import GoogleIntegration.pages.Orders_Page;

public class Orders_Module {
	Orders_Page orderP;
	
	public Orders_Module() {
		orderP=new Orders_Page();
	}
	
	public void loggingInAccount() {
		orderP.loggingInAccount();
	}
	
	public void selectingShopBasedOnUserId(String userId) {
		orderP.selectingShopBasedOnUserId(userId);
	}
	
	public void waitFor(int sec) {
		orderP.waitFor(sec);
	}
	
	public void switchingToTabs(int tabnum) {
		orderP.switchingToTabs(tabnum);	
	}
	
	public void syncingOrders() {
		orderP.syncingOrders();
	}
	
}
