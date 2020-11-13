package GoogleIntegration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.TextBox;
import GoogleIntegration.utilities.ReadXML;

public class Onboarding_Page extends commonPage{
	private Link Apps;
	private Link ShopifyStore;
	private TextBox SearchApps;
	private Link GoogleApp;
	private Link AddApp;
	private Link InstallApp;
	private Link GoogleShopifyApp;
	private Link ConnectGoogleAccount;
	private Link AnotherAccount;
	private TextBox Email;
	private Link NextButton;
	private TextBox Password;
	private Link AllowButton;
	private Link YesButton;
	private Link FreePlan;
	private Link NextAfterBuy;
	private Link TargetCountry;
	private Link ContentLanguage;
	private Link Currency;
	private Link SaveAndComplete;
	
	public Onboarding_Page() {
		super(Onboarding_Page.class.getSimpleName());
		
		Apps= new Link(ReadXML.getElementLocator("Onboarding_Page", "Apps"),
				"Onboarding_Page", "Apps");
		ShopifyStore= new Link(ReadXML.getElementLocator("Onboarding_Page", "ShopifyStore"),
				"Onboarding_Page", "ShopifyStore");
		SearchApps= new TextBox(ReadXML.getElementLocator("Onboarding_Page", "SearchApps"),
				"Onboarding_Page", "SearchApps");
		GoogleApp= new Link(ReadXML.getElementLocator("Onboarding_Page", "GoogleApp"),
				"Onboarding_Page", "GoogleApp");
		AddApp= new Link(ReadXML.getElementLocator("Onboarding_Page", "AddApp"),
				"Onboarding_Page", "AddApp");
		InstallApp= new Link(ReadXML.getElementLocator("Onboarding_Page", "InstallApp"),
				"Onboarding_Page", "InstallApp");
		GoogleShopifyApp= new Link(ReadXML.getElementLocator("Onboarding_Page", "GoogleShopifyApp"),
				"Onboarding_Page", "GoogleShopifyApp");
		ConnectGoogleAccount= new Link(ReadXML.getElementLocator("Onboarding_Page", "ConnectGoogleAccount"),
				"Onboarding_Page", "ConnectGoogleAccount");
		AnotherAccount= new Link(ReadXML.getElementLocator("Onboarding_Page", "AnotherAccount"),
				"Onboarding_Page", "AnotherAccount");
		Email= new TextBox(ReadXML.getElementLocator("Onboarding_Page", "Email"),
				"Onboarding_Page", "Email");
		NextButton= new Link(ReadXML.getElementLocator("Onboarding_Page", "NextButton"),
				"Onboarding_Page", "NextButton");
		Password= new TextBox(ReadXML.getElementLocator("Onboarding_Page", "Password"),
				"Onboarding_Page", "Password");
		AllowButton= new Link(ReadXML.getElementLocator("Onboarding_Page", "AllowButton"),
				"Onboarding_Page", "AllowButton");
		YesButton= new Link(ReadXML.getElementLocator("Onboarding_Page", "YesButton"),
				"Onboarding_Page", "YesButton");
		FreePlan= new Link(ReadXML.getElementLocator("Onboarding_Page", "FreePlan"),
				"Onboarding_Page", "FreePlan");
		NextAfterBuy= new Link(ReadXML.getElementLocator("Onboarding_Page", "NextAfterBuy"),
				"Onboarding_Page", "NextAfterBuy");
		TargetCountry= new Link(ReadXML.getElementLocator("Onboarding_Page", "TargetCountry"),
				"Onboarding_Page", "TargetCountry");
		ContentLanguage= new Link(ReadXML.getElementLocator("Onboarding_Page", "ContentLanguage"),
				"Onboarding_Page", "ContentLanguage");
		Currency= new Link(ReadXML.getElementLocator("Onboarding_Page", "Currency"),
				"Onboarding_Page", "Currency");
		SaveAndComplete= new Link(ReadXML.getElementLocator("Onboarding_Page", "SaveAndComplete"),
				"Onboarding_Page", "SaveAndComplete");
		
	}
	
	public void waitFor(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void goToShopifyStore() {
		Apps.click();
		waitFor(3);
		ShopifyStore.click();
	}
	
	public void searchAndInstallGoogleApp() {
		
		DriverManager.getDriver().findElement(By.xpath("//div[@class='user-card__content']")).click();
		waitFor(5);
		SearchApps.sendKeys("Shopping Feed for Google");
		SearchApps.sendKeys(Keys.ENTER);
		waitFor(3);
		GoogleApp.click();
		waitFor(3);
		AddApp.click();
		waitFor(3);
		InstallApp.click();
	}
	
	public void goToGoogleApp() {
		GoogleShopifyApp.click();
		waitFor(25);
	}
	
	public void connectToGoogleAccount(String email,String password) {
		ConnectGoogleAccount.click();
		waitFor(5);
	//	AnotherAccount.click();
		waitFor(3);
		Email.sendKeys(email);
		NextButton.click();
		waitFor(3);
		Password.sendKeys(password);
		DriverManager.getDriver().findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		//NextButton.click();
		waitFor(3);
		AllowButton.click();
		waitFor(7);
	}
	
	
	//h2[text()='Merchant id - 143314266']/parent::div/following-sibling::div/descendant::span[text()='Connect account']/ancestor::button
	public void selectMerchant(String googleMerchantId) {
		String xpath="//h2[text()='Merchant id - ";
		xpath=xpath.concat(googleMerchantId);
		xpath=xpath.concat("']/parent::div/following-sibling::div/descendant::span[text()='Connect account']/ancestor::button");
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
		waitFor(3);
		YesButton.click();
		waitFor(16);
	}
	
	public void buyingFreePlan() {
		if(FreePlan.isDisplayed()) {
			FreePlan.click();
			waitFor(3);
			NextAfterBuy.click();
			waitFor(7);
		}
		
	}
	
	public void completeingStepThree(String country, String language,String currency) {
		Select targetCountry=new Select(TargetCountry);
		Select contentLanguage=new Select(ContentLanguage);
		Select defCurrency=new Select(Currency);
		targetCountry.selectByVisibleText(country);
		contentLanguage.selectByVisibleText(language);
		defCurrency.selectByVisibleText(currency);
		SaveAndComplete.click();
		waitFor(15);
	}
	
	
	
	

}
