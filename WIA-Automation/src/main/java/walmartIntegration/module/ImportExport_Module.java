package walmartIntegration.module;

import java.io.IOException;
import java.util.HashMap;

import walmartIntegration.pages.ImportExport_Page;

public class ImportExport_Module {
	ImportExport_Page impExpP;
	
	public ImportExport_Module() {
		impExpP=new ImportExport_Page();
	}
	
	public void LoggingInAccount() throws InterruptedException {
		impExpP.LoggingInAccount();
	}
	
	public void selectingAShop(String shopName) throws InterruptedException {
		impExpP.selectingAShop(shopName);
	}
	
	public void exportingProductCsvBasedOnAparticularAttribute(String attribute) {
		impExpP.exportingProductCsvBasedOnAparticularAttribute(attribute);
	}
	
	public  HashMap<String, String> readingCsv(String filePath) throws IOException {
			HashMap<String,String> map=	impExpP.readingCsv(filePath);
			return map;
	}
	
	public void updatingCSV(String fileToUpdate,String attribute) throws IOException {
		impExpP.updatingCSV(fileToUpdate,attribute);
	}
	
	public Boolean comparingIfDataUpdatedInCsv(HashMap<String,String> originalCsv,HashMap<String,String> updatedCsv){
		Boolean bool=impExpP.comparingIfDataUpdatedInCsv(originalCsv, updatedCsv);
		return bool;
	}
	
	
}
