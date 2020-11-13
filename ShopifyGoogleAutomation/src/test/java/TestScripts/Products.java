package TestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import GoogleIntegration.module.Orders_Module;
import GoogleIntegration.module.Products_Module;

public class Products extends commonTest{
	Orders_Module orderM;
	Products_Module proM;
	
	@BeforeMethod
	public void loggingInAdminPanel() {
		orderM=new Orders_Module();
		orderM.loggingInAccount();
	}
	
	@DataProviderParams({ "fileName=InputData1.csv", "tableName=syncShopify" })
	@Test( description = "Verifying new product is created in Google", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
	public void syncWithShopify(String merchId) {
		orderM=new Orders_Module();
		proM=new Products_Module();
		orderM.waitFor(3);
		orderM.selectingShopBasedOnUserId(merchId);
		orderM.switchingToTabs(1);
		orderM.waitFor(15);
		proM.goToProductsTab();
		proM.syncWithShopify();
		orderM.waitFor(15);
	}
	
	
	
	
//	@Test
//	public void unPublishFromGoogle() {
//		orderM=new Orders_Module();
//		proM=new Products_Module();
//		orderM.waitFor(3);
//		orderM.selectingShopBasedOnUserId("13323");
//		orderM.switchingToTabs(1);
//		orderM.waitFor(15);
//		proM.goToProductsTab();
//		proM.selectProduct("36718468923555");
//		proM.unpublishFromGoogle();
//		orderM.waitFor(15);
//	}
	
	
	
	
	
	
	
}
