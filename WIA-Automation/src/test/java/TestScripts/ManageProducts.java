package TestScripts;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.DashboardModule;
import walmartIntegration.module.ManageProducts_Module;

public class ManageProducts extends commonTest{
	private	ManageProducts_Module manProdM;
	
	
	@BeforeMethod
	private void BeforeMethod() throws InterruptedException {
		manProdM=new ManageProducts_Module();
		manProdM.LoggingInAccount();
	}
	
	@DataProviderParams({ "fileName=InputData.csv", "tableName=ManageProd_ShopNames" })
    @Test( description = "Verifying sync with shopify", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=19)
	public void verifyingSyncwithShopify(String shopName) throws InterruptedException, IOException {
		manProdM=new ManageProducts_Module();
		manProdM.selectingAShop(shopName);
		manProdM.VerifyingSyncWithShopify();
		
}
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=ManageProd_ShopNames" })
//    @Test( description = "Verifying updating Price", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=19)
//	public void verifyingUpdatingPrice(String shopName) throws InterruptedException, IOException {	
//		manProdM=new ManageProducts_Module();
//		manProdM.selectingAShop(shopName);
//		manProdM.updatingprice();
//	}
	

//	@DataProviderParams({ "fileName=InputData.csv", "tableName=ManageProd_ShopNames" })
//    @Test( description = "Verifying updating Inventory", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=19)
//	public void verifyingUpdatingInventory(String shopName) throws InterruptedException, IOException {
//		manProdM=new ManageProducts_Module();
//		manProdM.selectingAShop(shopName);	
//		manProdM.updatingInventory();
//	}
//	
}
