package GoogleIntegration.module;

import GoogleIntegration.pages.Onboarding_Page;

public class Onboarding_Module {
	Onboarding_Page onboardP;
	
	public Onboarding_Module() {
		onboardP=new Onboarding_Page();
	}
	
	public void goToShopifyStore() {
		onboardP.goToShopifyStore();
	}
	
	public void searchAndInstallGoogleApp() {
		onboardP.searchAndInstallGoogleApp();
	}
	
	public void goToGoogleApp() {
		onboardP.goToGoogleApp();
	}
	
	public void connectToGoogleAccount(String email,String password) {
		onboardP.connectToGoogleAccount(email, password);
	}
	
	public void selectMerchant(String googleMerchantId) {
		onboardP.selectMerchant(googleMerchantId);
	}
	
	public void buyingFreePlan() {
		onboardP.buyingFreePlan();
	}
	
	public void completeingStepThree(String country, String language,String currency) {
		onboardP.completeingStepThree(country, language, currency);
	}
	
	
	
}
