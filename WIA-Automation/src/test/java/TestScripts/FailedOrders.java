package TestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.FailedOrder_Module;
import walmartIntegration.module.ManageProducts_Module;
import walmartIntegration.module.SalesOrder_Module;


public class FailedOrders extends commonTest {
private FailedOrder_Module failedM;
private ManageProducts_Module manProdM;
private	SalesOrder_Module SalesM;
	
	@BeforeMethod
	public void LoggingInShopify() throws InterruptedException {
		failedM=new FailedOrder_Module();
		manProdM=new ManageProducts_Module();
		manProdM.LoggingInAccount();
	}
	
	@Test
	public void updatingOrderStatus() throws InterruptedException {
		failedM=new FailedOrder_Module();
		SalesM=new SalesOrder_Module();
		manProdM=new ManageProducts_Module();
		manProdM.selectAShopUsingMerchantId("1582");
		failedM.gotoFailedOrder();
		SalesM.updatingBulkOrderStatus();
		Thread.sleep(10000);
	}
	
	
}
