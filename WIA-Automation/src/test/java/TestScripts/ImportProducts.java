package TestScripts;

import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.ImportProducts_Module;
import walmartIntegration.module.WebHook_Module;

import org.testng.annotations.BeforeMethod;


public class ImportProducts extends commonTest {
	private	ImportProducts_Module impProdM;
	private WebHook_Module webM;
	
	@BeforeMethod
	public void loggingInAccount() throws InterruptedException {
		webM=new WebHook_Module();
		 webM.LogginginShopify();
	}
	
	@Test
	public void 
	
	
}
