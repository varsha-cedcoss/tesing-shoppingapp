package TestScripts;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
	
	@Test
	public void ManageProduct() throws InterruptedException, IOException {
		manProdM=new ManageProducts_Module();
		manProdM.VerifyingSyncWithShopify();
		

	}
}
