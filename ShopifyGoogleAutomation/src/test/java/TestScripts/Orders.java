package TestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.GUI.commons.test.commonTest;
import GoogleIntegration.module.Orders_Module;

public class Orders extends commonTest{
	Orders_Module orderM;
	
	@BeforeMethod
	public void loggingInAdminPanel() {
		orderM=new Orders_Module();
		orderM.loggingInAccount();
	}
	
	@Test
	public void syncOrders() {
		orderM=new Orders_Module();
		orderM.waitFor(3);
		orderM.selectingShopBasedOnUserId("13323");
		orderM.switchingToTabs(1);
		orderM.waitFor(15);
		orderM.syncingOrders();
	}
	
	
	
}
