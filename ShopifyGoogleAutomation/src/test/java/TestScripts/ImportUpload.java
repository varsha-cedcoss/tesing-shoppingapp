package TestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.GUI.commons.test.commonTest;
import GoogleIntegration.module.ImportUpload_Module;
import GoogleIntegration.module.Orders_Module;

public class ImportUpload extends commonTest{
	ImportUpload_Module impM;
	Orders_Module orderM;
	
	
	@BeforeMethod
	public void loginInAdminPanel() {
		orderM=new Orders_Module();
		orderM.loggingInAccount();
	}
	
//	@Test
//	public void importingProductsFromShopifyToApp() {
//		orderM=new Orders_Module();
//		impM=new ImportUpload_Module();
//		orderM.waitFor(3);
//		orderM.selectingShopBasedOnUserId("13323");
//		orderM.switchingToTabs(1);
//		orderM.waitFor(20);
//		impM.goToImportUploadSection();
//		orderM.waitFor(3);
//		impM.importingProductFromDefaultProfile();
//		orderM.waitFor(20);
//	}
	
//	@Test
//	public void uploadingDefaultProfileProductsFromAppToGoogle() {
//		orderM=new Orders_Module();
//		impM=new ImportUpload_Module();
//		orderM.waitFor(3);
//		orderM.selectingShopBasedOnUserId("13323");
//		orderM.switchingToTabs(1);
//		orderM.waitFor(20);
//		impM.goToImportUploadSection();
//		orderM.waitFor(3);
//		impM.uploadingDefaultProfileProductFromAppToGoogle();
//		orderM.waitFor(20);
//	}
	
	@Test
	public void uploadingCustomProfileProductsFromAppToGoogle() {
		orderM=new Orders_Module();
		impM=new ImportUpload_Module();
		orderM.waitFor(3);
		orderM.selectingShopBasedOnUserId("13323");
		orderM.switchingToTabs(1);
		orderM.waitFor(20);
		impM.goToImportUploadSection();
		orderM.waitFor(3);
		impM.uploadingCustomProfileProduct("Shan");
		orderM.waitFor(20);
	}
	
	
}
