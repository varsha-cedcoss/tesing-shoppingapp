package walmartIntegration.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.TextBox;
import walmartIntegration.automation.LocalConfig;
import walmartIntegration.utilities.ReadXML;

public class PricingPlan_Page extends commonPage {

	private TextBox ShopifyUrlTextbox;
	private TextBox ShopifyLogin;
	private Link NextButton;
	private TextBox ShopifyPassword;
	private Link AppsOptionInShopify;
	private Link WalmartIntegration;
	private Link PricingPlan;
	private Link ApproveSubscriptionButton;
	private Link BilledMonthly;
	
	
	
	
	
	public PricingPlan_Page() {
		super(PricingPlan_Page.class.getSimpleName());
		this.pageURL= LocalConfig.WIA_URL;
		
		ShopifyUrlTextbox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "ShopifyUrlTextbox"),
				"WebHook_Page", "ShopifyUrlTextbox");
		ShopifyLogin= new TextBox(ReadXML.getElementLocator("WebHook_Page", "ShopifyLogin"),
				"WebHook_Page", "ShopifyLogin");
		NextButton= new Link(ReadXML.getElementLocator("WebHook_Page", "NextButton"),
				"WebHook_Page", "NextButton");
		ShopifyPassword= new TextBox(ReadXML.getElementLocator("WebHook_Page", "ShopifyPassword"),
				"WebHook_Page", "ShopifyPassword");
		AppsOptionInShopify= new Link(ReadXML.getElementLocator("PricingPlan_Page", "AppsOptionInShopify"),
				"PricingPlan_Page", "AppsOptionInShopify");
		WalmartIntegration= new Link(ReadXML.getElementLocator("WebHook_Page", "WalmartIntegration"),
				"WebHook_Page", "WalmartIntegration");
		PricingPlan= new Link(ReadXML.getElementLocator("PricingPlan_Page", "PricingPlan"),
				"PricingPlan_Page", "PricingPlan");
		ApproveSubscriptionButton= new Link(ReadXML.getElementLocator("PricingPlan_Page", "ApproveSubscriptionButton"),
				"PricingPlan_Page", "ApproveSubscriptionButton");
		BilledMonthly= new Link(ReadXML.getElementLocator("PricingPlan_Page", "BilledMonthly"),
				"PricingPlan_Page", "BilledMonthly");
	}
	
	
	public void LogginginShopify() throws InterruptedException {

		DriverManager.getDriver().get("https://webautomation.myshopify.com/admin/");
		ShopifyLogin.sendKeys("shantanugupta@cedcommerce.com");
		Thread.sleep(2000);
		NextButton.click();
		ShopifyPassword.sendKeys("dracarys");
		Thread.sleep(2000);
		ShopifyPassword.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	public void goToWalmartIntegrationApp() throws InterruptedException {
		AppsOptionInShopify.click();
		WalmartIntegration.click();
		Thread.sleep(5000);
	}
	
	public void switchingtoTab(int tabnum) {
		ArrayList<String> tabsArr=new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
		DriverManager.getDriver().switchTo().window(tabsArr.get(tabnum));
			}
	
	public void gotoPricingPlan() {
		PricingPlan.click();
	}
	
	//possible values of num=1,2,3,4,5,6
	public String gettingPriceOfSubscripion(String attr,String index) {
		String price=null;
		String url="(//h4[@class='Polaris-TextStyle--variationSubdued mt-10'])[";
		url=url.concat(index);
		url=url.concat("]");
	
	
		if(attr.equals("Annual Basic") || attr.equals("Annual Standard") || attr.equals("Annual Premium")) {
			WebElement element=DriverManager.getDriver().findElement(By.xpath(url));
			price=element.getText().replace("Billed at", "").trim();
			price=element.getText().replace("per year", "").trim();
			
		}
		else {
			BilledMonthly.click();
			WebElement element=DriverManager.getDriver().findElement(By.xpath(url));
			price=element.getText().replace("Billed at ", "");
			price=element.getText().replace(" per month", "");
			
		}
		return price;
	
	}
	
	//possible values of num=2,3,4,6,7,8
	public Boolean checkingUpgradeYourAccountWarning(String index) {
		Boolean bool=null;
		String url="https://apps.cedcommerce.com/integration/walmart/payment/index?plan=";
		url=url.concat(index);
		DriverManager.getDriver().get(url);
		WebElement warn=DriverManager.getDriver().findElement(By.xpath("//h1"));
		String message=warn.getText();
		if(message.contains("Upgrade your account")) {
			bool=true;
			Reporter.log("You have to Upgrade your account");
		}
		else {bool=false;}
		DriverManager.getDriver().navigate().back();
		return bool;
	}
	//possible values of index=2,3,4,6,7,8
	public String launchingdifferentUrlBasedOnAnnualAndMonthlyBilling(String index) {
		String url="https://apps.cedcommerce.com/integration/walmart/payment/index?plan=";
		url=url.concat(index);
		url=url.concat("&cedcommerce=cedcoss");
		DriverManager.getDriver().get(url);
		
		String ele="//div[@class='ui-stack-item tr fw-strong']";
		WebElement element=DriverManager.getDriver().findElement(By.xpath(ele));
		String[] price=element.getText().split(".00");
		Reporter.log("The price on the payment page is:  "+price[0]);
		return price[0];
	}
	
	public void clickingApproveSubscription() {
		ApproveSubscriptionButton.click();
	}
	
	public void verifyingPaymentDone() {
		WebElement pay=DriverManager.getDriver().findElement(By.xpath("//p[@class='Polaris-DisplayText Polaris-DisplayText--sizeMedium']"));
	String actual=pay.getText();
	String expected="Payment Successfully Done";
	Assert.assertEquals(actual, expected);
	Reporter.log("Payment has been successfully done");
	
	}
	
	
	
	
	
	
}
