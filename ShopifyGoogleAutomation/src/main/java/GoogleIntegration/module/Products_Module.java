package GoogleIntegration.module;

import GoogleIntegration.pages.Products_Page;

public class Products_Module {
	Products_Page proP;
	
	public Products_Module() {
		proP=new Products_Page();
	}
	
	public void goToProductsTab(){
		proP.goToProductsTab();
	}
	
	public void selectProduct(String variantId) {
		proP.selectProduct(variantId);
	}
	
	public void unpublishFromGoogle() {
		proP.unpublishFromGoogle();
	}
	
	public void syncWithShopify() {
		proP.syncWithShopify();
	}
	
}
