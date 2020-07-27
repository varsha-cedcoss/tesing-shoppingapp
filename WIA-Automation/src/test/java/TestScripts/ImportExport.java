package TestScripts;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.ImportExport_Module;
import walmartIntegration.module.ManageProducts_Module;


public class ImportExport extends commonTest{
	private ImportExport_Module impExp;
	
	

	@BeforeMethod
	private void BeforeMethod() throws InterruptedException {
		impExp=new ImportExport_Module();
		impExp.LoggingInAccount();
	}
	
	@DataProviderParams({ "fileName=InputData.csv", "tableName=UpdatingCsvForAttributes" })
    @Test( description = "Verifying exporting and updating csv and also comparing if the changes are reflecting", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
	public void exportingCsvandUpdating(String shopName,String attribute,String attributeSelectingColumn) throws InterruptedException, IOException {
		impExp=new ImportExport_Module();
//		impExp.selectingAShop("automationtesting");
//		Reporter.log("Here exporting file on the basis of updating the     "+attribute+"    attribute");
//		impExp.exportingProductCsvBasedOnAparticularAttribute(attributeSelectingColumn);
//		Thread.sleep(10000);
//		
//		impExp.updatingCSV("/home/cedcoss/Downloads/CedcossAutomation/WIA/WIA-Automation/Downloads/TemporaryDownloads/product.csv",attribute);
		
		
		//here again exporting the file after updating it and importing.
		Reporter.log("We are again exporting the updated file and checking if the updation is correct or not");
		impExp.selectingAShop("automationtesting");
		Reporter.log("Here exporting file on the basis of updating the     "+attributeSelectingColumn+"    attribute");
		impExp.exportingProductCsvBasedOnAparticularAttribute(attributeSelectingColumn);
		Thread.sleep(10000);
		
	HashMap<String,String> map1=impExp.readingCsv("/home/cedcoss/Downloads/CedcossAutomation/WIA/WIA-Automation/Downloads/TemporaryDownloads/product.csv");
	
	HashMap<String,String> map2=impExp.readingCsv("/home/cedcoss/Downloads/CedcossAutomation/WIA/WIA-Automation/Downloads/TemporaryDownloads/product (1).csv");
	Reporter.log("The Original values are:        "+map1);
	Reporter.log("The second time exporting csv values are:        "+map2);
	Boolean bool=impExp.comparingIfDataUpdatedInCsv(map1, map2);
	Reporter.log(""+bool);
	
	}
	
	
	
	
	
	
}
