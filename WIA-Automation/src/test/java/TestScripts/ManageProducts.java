package TestScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;

import Framework.Custom.DriverManager;
import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.DashboardModule;
import walmartIntegration.module.ManageProducts_Module;
import walmartIntegration.module.WebHook_Module;

public class ManageProducts extends commonTest{
	private	ManageProducts_Module manProdM;
	private WebHook_Module webM;
	
	
	@BeforeMethod
	private void BeforeMethod() throws InterruptedException {
		manProdM=new ManageProducts_Module();
		manProdM.LoggingInAccount();
	}
	
	@DataProviderParams({ "fileName=InputData.csv", "tableName=ManageProd_ShopNames" })
    @Test( description = "Verifying sync with shopify", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=19)
	public void verifyingSyncwithShopify(String shopUrl) throws InterruptedException, IOException {
		manProdM=new ManageProducts_Module();
		manProdM.selectingAShopUsingShopUrl(shopUrl);
		manProdM.VerifyingSyncWithShopify();
		
}
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=ManageProd_ShopNames" })
//    @Test( description = "Verifying updating Price", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=19)
//	public void verifyingUpdatingPrice(String shopUrl) throws InterruptedException, IOException {	
//		manProdM=new ManageProducts_Module();
//		manProdM.selectingAShopUsingShopUrl(shopUrl);
//		manProdM.updatingprice();
//	}
	

//	@DataProviderParams({ "fileName=InputData.csv", "tableName=ManageProd_ShopNames" })
//    @Test( description = "Verifying updating Inventory", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=19)
//	public void verifyingUpdatingInventory(String shopUrl) throws InterruptedException, IOException {
//		manProdM=new ManageProducts_Module();
//		manProdM.selectingAShopUsingShopUrl(shopUrl);	
//		manProdM.updatingInventory();
//	}
//	
	

//	@DataProviderParams({ "fileName=InputData.csv", "tableName=ManageProd_ShopNames" })
//    @Test( description = "Verifying sync with shopify", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=19)
//	public void verifyingUpdateStatus(String shopName) throws InterruptedException, IOException {
//		manProdM=new ManageProducts_Module();
//		webM=new WebHook_Module();
//		manProdM.selectingAShopUsingShopUrl("f-c-unlimited-supplies-llc.myshopify.com");
//		manProdM.updatingStatus();	
//		Boolean bool=manProdM.errorCheckingForUpdateStatus();
//		if(bool==true) {
//			Reporter.log("There is an error");
//			Assert.assertTrue(false);
//		}
//		else {
//			Reporter.log("Success");
//			Assert.assertTrue(true);
//		}
//	}
}
