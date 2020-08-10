package walmartIntegration.module;

import walmartIntegration.pages.ImportProducts_Page;

public class ImportProducts_Module {
	ImportProducts_Page impProdP;
	
	
	public ImportProducts_Module() {
		impProdP=new ImportProducts_Page();
	}
	
	public void gotoImportProductsTab() {
		impProdP.gotoImportProductsTab();
	}
	
	public void importingAllProducts() {
		impProdP.importingAllProducts();
	}
	
}
