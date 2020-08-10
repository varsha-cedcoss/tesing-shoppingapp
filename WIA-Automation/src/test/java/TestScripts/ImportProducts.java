package TestScripts;

import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.ImportProducts_Module;
import walmartIntegration.module.WebHook_Module;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ImportProducts extends commonTest {
	private	ImportProducts_Module impProdM;
	private WebHook_Module webM;
	
	@BeforeMethod
	public void loggingInAccount() throws InterruptedException {
		webM=new WebHook_Module();
		 webM.LogginginShopify();
	}
	
	@Test
	public void ImportingAllProducts() throws InterruptedException {
		impProdM=new ImportProducts_Module();
		webM=new WebHook_Module();
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		Thread.sleep(1000);
		impProdM.gotoImportProductsTab();
		impProdM.importingAllProducts();
		Thread.sleep(15000);
	}
	
	
}
