package walmartIntegration.module;

import java.io.IOException;

import walmartIntegration.pages.ManageProducts_Page;

public class ManageProducts_Module {
	ManageProducts_Page manProd;
	
	
	public ManageProducts_Module() {
		manProd=new ManageProducts_Page();
	}
	
	public void LoggingInAccount() throws InterruptedException {
		manProd.LoggingInAccount();
	}
	
	public void selectingAShop(String shopName) throws InterruptedException {
		manProd.selectingAShop(shopName);
	}
	
	public void VerifyingSyncWithShopify() throws InterruptedException, IOException {
		manProd.VerifyingSyncWithShopify();
	}
	
	public void updatingprice() throws InterruptedException, IOException {
		manProd.updatingprice();
	}
	
	 public void updatingInventory() throws InterruptedException, IOException {
		 manProd.updatingInventory();
	 }

}
