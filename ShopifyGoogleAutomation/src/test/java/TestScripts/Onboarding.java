package TestScripts;

import org.testng.annotations.Test;

import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import GoogleIntegration.module.Onboarding_Module;
import GoogleIntegration.module.WebHook_Module;

public class Onboarding extends commonTest{
	Onboarding_Module onboardM;
	WebHook_Module webM;
	
	@DataProviderParams({ "fileName=InputData1.csv", "tableName=Onboarding" })
	@Test( description = "Verifying new product is created in Google", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
	public void onboardingProcess(String email,  String password,String merchId,String country,String language,String currency) {
		webM=new WebHook_Module();
		onboardM=new Onboarding_Module();
		webM.LogginginShopify();
		webM.waitFor(5);
		onboardM.goToShopifyStore();
		webM.waitFor(5);
		webM.switchingtoTab(1);
		onboardM.searchAndInstallGoogleApp();
		webM.waitFor(15);
		//onboardM.goToGoogleApp();
		onboardM.connectToGoogleAccount(email, password);
		onboardM.selectMerchant(merchId);
		onboardM.buyingFreePlan();
		onboardM.completeingStepThree(country, language, currency);
	}
	
}
