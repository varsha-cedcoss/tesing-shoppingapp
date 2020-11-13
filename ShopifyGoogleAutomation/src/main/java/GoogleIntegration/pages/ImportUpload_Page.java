package GoogleIntegration.pages;

import org.openqa.selenium.support.ui.Select;

import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import GoogleIntegration.utilities.ReadXML;

public class ImportUpload_Page extends commonPage{
	private Link ImportUpload;
	private Link ImportProduct;
	private Link Proceed;
	private Link UploadProduct;
	private Link UploadProductButton;
	private Link SelectProfile;
	
	
	public ImportUpload_Page() {
		super(ImportUpload_Page.class.getSimpleName());
		
		ImportUpload= new Link(ReadXML.getElementLocator("ImportUpload_Page", "ImportUpload"),
				"ImportUpload_Page", "ImportUpload");
		ImportProduct= new Link(ReadXML.getElementLocator("ImportUpload_Page", "ImportProduct"),
				"ImportUpload_Page", "ImportProduct");
		Proceed= new Link(ReadXML.getElementLocator("ImportUpload_Page", "Proceed"),
				"ImportUpload_Page", "Proceed");
		UploadProduct= new Link(ReadXML.getElementLocator("ImportUpload_Page", "UploadProduct"),
				"ImportUpload_Page", "UploadProduct");
		UploadProductButton= new Link(ReadXML.getElementLocator("ImportUpload_Page", "UploadProductButton"),
				"ImportUpload_Page", "UploadProductButton");
		SelectProfile= new Link(ReadXML.getElementLocator("ImportUpload_Page", "SelectProfile"),
				"ImportUpload_Page", "SelectProfile");
	}
	
	public void goToImportUploadSection(){
		ImportUpload.click();
	}
	
	public void importingProductFromDefaultProfile(){
		ImportProduct.click();
		waitFor(3);
		Proceed.click();
	}
	
	public void waitFor(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void uploadingDefaultProfileProductFromAppToGoogle() {
		UploadProduct.click();
		waitFor(3);
		UploadProductButton.click();
	}

	public void uploadingCustomProfileProduct(String profileName) {
		UploadProduct.click();
		waitFor(3);
		Select select=new Select(SelectProfile);
		select.selectByVisibleText(profileName);
		UploadProductButton.click();
	}

}
