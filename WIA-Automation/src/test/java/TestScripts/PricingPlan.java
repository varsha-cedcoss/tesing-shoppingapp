package TestScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.PricingPlan_Module;

public class PricingPlan extends commonTest {
	private PricingPlan_Module planM;
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException {
		planM=new PricingPlan_Module();
		planM.LogginginShopify();
	}
	
	@DataProviderParams({ "fileName=InputData.csv", "tableName=PricingPlan" })
    @Test( description = "Verifying pricing plan", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
	public void verifyingPricingPlanAnnuallyAndMonthly(String attribute,String indexforprice,String indexforurl) throws InterruptedException {
		planM=new PricingPlan_Module();
		String actualPrice=null;
		planM.goToWalmartIntegrationApp();
		planM.switchingtoTab(1);
		planM.gotoPricingPlan();
	String original=planM.gettingPriceOfSubscripion(attribute, indexforprice);
	original=original.replace("Billed at", "").trim();
	Reporter.log("The Original  price is  "+original);
	
	Boolean bool=planM.checkingUpgradeYourAccountWarning(indexforurl);
	if(bool=true) {
		actualPrice=planM.launchingdifferentUrlBasedOnAnnualAndMonthlyBilling(indexforurl);
		planM.clickingApproveSubscription();
		planM.verifyingPaymentDone();
	}
	Assert.assertEquals(actualPrice, original);
	Reporter.log("Verified that the price on the PricingPlan page and price on the PaymentPage is same");
	}
	
	
	
	
}
