package walmartIntegration.module;

import walmartIntegration.pages.PricingPlan_Page;

public class PricingPlan_Module {
	PricingPlan_Page planP;
	
	public PricingPlan_Module() {
		planP=new PricingPlan_Page();
	}
	
	public void LogginginShopify() throws InterruptedException {
		planP.LogginginShopify();
	}
	
	public void goToWalmartIntegrationApp() throws InterruptedException {
		planP.goToWalmartIntegrationApp();
	}
	
	public void switchingtoTab(int tabnum) {
		planP.switchingtoTab(tabnum);
	}
	public void gotoPricingPlan() {
		planP.gotoPricingPlan();
	}
	
	//possible values of index=1,2,3,4,5,6
		public String gettingPriceOfSubscripion(String attr,String index) {
			String price=planP.gettingPriceOfSubscripion(attr, index);
			return price;
		}
		
		//possible values of num=2,3,4,6,7,8
		public Boolean checkingUpgradeYourAccountWarning(String index) {
			Boolean bool=planP.checkingUpgradeYourAccountWarning(index);
			return bool;
		}
		
		//possible values of index=2,3,4,6,7,8
		public String launchingdifferentUrlBasedOnAnnualAndMonthlyBilling(String index) {
		String price=planP.launchingdifferentUrlBasedOnAnnualAndMonthlyBilling(index);
		return price;
		}
	
		public void clickingApproveSubscription() {
			planP.clickingApproveSubscription();
		}
		public void verifyingPaymentDone() {
			planP.verifyingPaymentDone();
		}
}
