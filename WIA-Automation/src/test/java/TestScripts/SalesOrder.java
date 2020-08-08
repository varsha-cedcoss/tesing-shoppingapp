package TestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.ManageProducts_Module;
import walmartIntegration.module.SalesOrder_Module;

public class SalesOrder extends commonTest{
	private	SalesOrder_Module SalesM;
	private ManageProducts_Module manProdM;
	
	@BeforeMethod
	public void LoggingInShopify() throws InterruptedException {
		SalesM=new SalesOrder_Module();
		manProdM=new ManageProducts_Module();
		manProdM.LoggingInAccount();
	}
	
//	@Test
//	public void UpdatingBulkOrderStatus() throws InterruptedException {
//		SalesM=new SalesOrder_Module();
//		manProdM=new ManageProducts_Module();
//		manProdM.selectAShopUsingMerchantId("1582");
//		SalesM.gotoSalesOrder();
//		SalesM.updatingBulkOrderStatus();
//		Thread.sleep(10000);
//	}
//	
//	@Test
//	public void UpdatingBulkSyncShipment() throws InterruptedException {
//		SalesM=new SalesOrder_Module();
//		manProdM=new ManageProducts_Module();
//		manProdM.selectAShopUsingMerchantId("1582");
//		SalesM.gotoSalesOrder();
//		SalesM.updatingBulkShipment();
//		Thread.sleep(10000);
//	}
	
	@DataProviderParams({ "fileName=InputData.csv", "tableName=SalesOrder_MerchantId" })
    @Test( description = "Updating Order Status", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
	public void updatingOrderStatusThroughLink () throws InterruptedException {
		SalesM=new SalesOrder_Module();
		manProdM=new ManageProducts_Module();
		manProdM.selectAShopUsingMerchantId("1582");
		SalesM.gotoSalesOrder();
		SalesM.updatingOrderStatus();
		Thread.sleep(10000);
	}
	
	@DataProviderParams({ "fileName=InputData.csv", "tableName=SalesOrder_MerchantId" })
    @Test( description = "Fetching Orders", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
	public void fetchingOrders () throws InterruptedException {
		SalesM=new SalesOrder_Module();
		manProdM=new ManageProducts_Module();
		manProdM.selectAShopUsingMerchantId("1582");
		SalesM.gotoSalesOrder();
		SalesM.fetchingOrders();
		Thread.sleep(10000);
	}
	
	@DataProviderParams({ "fileName=InputData.csv", "tableName=SalesOrder_MerchantId" })
    @Test( description = "Syncing Shipment", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
	public void syncShipment () throws InterruptedException {
		SalesM=new SalesOrder_Module();
		manProdM=new ManageProducts_Module();
		manProdM.selectAShopUsingMerchantId("1582");
		SalesM.gotoSalesOrder();
		SalesM.syncShipment();
		Thread.sleep(10000);
	}
	
}
