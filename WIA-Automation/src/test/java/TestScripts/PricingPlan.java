package TestScripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.PricingPlan_Module;
import walmartIntegration.module.WebHook_Module;

public class PricingPlan extends commonTest {
	private PricingPlan_Module planM;
	WebHook_Module webM;
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException {
		planM=new PricingPlan_Module();
		planM.LogginginShopify();
	}
	
	@DataProviderParams({ "fileName=InputData.csv", "tableName=PricingPlan" })
    @Test( description = "Verifying pricing plan", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
	public void verifyingPricingPlanAnnuallyAndMonthly(String attribute,String indexforprice,String indexforurl) throws InterruptedException {
		planM=new PricingPlan_Module();
		webM=new WebHook_Module();
		String actualPrice=null;
		String chargeId=null;
		planM.goToWalmartIntegrationApp();
		planM.switchingtoTab(1);
		String days=planM.checkingRemainingDaysOfSubscription();
		int beforeSubs=Integer.valueOf(days);
		Reporter.log("The number of days remaining is:  "+days);
		planM.gotoPricingPlan();
	String original=planM.gettingPriceOfSubscripion(attribute, indexforprice);
	original=original.replace("Billed at", "").trim();
	Reporter.log("The Original  price is  "+original);
	Boolean bool=planM.checkingUpgradeYourAccountWarning(indexforurl);
	if(bool==true) {
		actualPrice=planM.launchingdifferentUrlBasedOnAnnualAndMonthlyBilling(indexforurl);
		chargeId=planM.getChargeID();
		planM.clickingApproveSubscription();
		planM.verifyingPaymentDone();
	}	
	String daysafterSubs=planM.checkingRemainingDaysOfSubscription();
	Reporter.log("The number of days remaining after Subscription is:  "+daysafterSubs);
	int afterSubs=Integer.valueOf(daysafterSubs);
	int result=afterSubs-beforeSubs;
	Reporter.log("The number of days for which payment is done is  :  "+result);
	planM.launchingUrlByChargeId(chargeId);
	String json=webM.extractingJsonDataAsStringfromPage();
	Reporter.log("The json data are as follows:         "
			+ json);
	Assert.assertEquals(actualPrice, original);
	Reporter.log("Verified that the price on the PricingPlan page and price on the PaymentPage is same");
	}
	
	
	
	
}
