package GoogleIntegration.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.TextBox;
import GoogleIntegration.utilities.ReadXML;

public class CustomProfile_Page extends commonPage{
	private Link CustomProfile;
	private Link CreateProfileButton;
	private TextBox ProfileName;
	private Link SaveButton;
	private Link TargetCountry;
	private Link ContentLanguage;
	private Link Currency;
	private Link SelectAttribute;
	private Link SelectOperator;
	private TextBox FilterValue;
	private Link CreateProfile;
	
	
	
	
	public CustomProfile_Page() {
		super(CustomProfile_Page.class.getSimpleName());
		
		CustomProfile= new Link(ReadXML.getElementLocator("CustomProfile_Page", "CustomProfile"),
				"CustomProfile_Page", "CustomProfile");
		CreateProfileButton= new Link(ReadXML.getElementLocator("CustomProfile_Page", "CreateProfileButton"),
				"CustomProfile_Page", "CreateProfileButton");
		ProfileName= new TextBox(ReadXML.getElementLocator("CustomProfile_Page", "ProfileName"),
				"CustomProfile_Page", "ProfileName");
		SaveButton= new Link(ReadXML.getElementLocator("CustomProfile_Page", "SaveButton"),
				"CustomProfile_Page", "SaveButton");
		TargetCountry= new Link(ReadXML.getElementLocator("CustomProfile_Page", "TargetCountry"),
				"CustomProfile_Page", "TargetCountry");
		ContentLanguage= new Link(ReadXML.getElementLocator("CustomProfile_Page", "ContentLanguage"),
				"CustomProfile_Page", "ContentLanguage");
		Currency= new Link(ReadXML.getElementLocator("CustomProfile_Page", "Currency"),
				"CustomProfile_Page", "Currency");
		SelectAttribute= new Link(ReadXML.getElementLocator("CustomProfile_Page", "SelectAttribute"),
				"CustomProfile_Page", "SelectAttribute");
		SelectOperator= new Link(ReadXML.getElementLocator("CustomProfile_Page", "SelectOperator"),
				"CustomProfile_Page", "SelectOperator");
		FilterValue= new TextBox(ReadXML.getElementLocator("CustomProfile_Page", "FilterValue"),
				"CustomProfile_Page", "FilterValue");
		CreateProfile= new Link(ReadXML.getElementLocator("CustomProfile_Page", "CreateProfile"),
				"CustomProfile_Page", "CreateProfile");

	}
	
	public void waitFor(int sec) {
		
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void goToCustomProfile() {
		CustomProfile.click();
		waitFor(3);
	}
	
	public void createProfile(String profName,String tarCountry,String contentLanguage,String curr,String prodAttribute,String anyOperator,String value) {
		CreateProfileButton.click();
		waitFor(7);
		if(ProfileName.isDisplayed()) {
			//ProfileName.clear();
			ProfileName.sendKeys(Keys.chord(Keys.CONTROL+"a"));
			ProfileName.sendKeys(profName);
			SaveButton.click();
			waitFor(3);
		}
		Select country=new Select(TargetCountry);
		Select language=new Select(ContentLanguage);
		Select currency=new Select(Currency);
		Select attribute=new Select(SelectAttribute);
		Select operator=new Select(SelectOperator);
		country.selectByVisibleText(tarCountry);
		language.selectByVisibleText(contentLanguage);
		currency.selectByVisibleText(curr);
		attribute.selectByVisibleText(prodAttribute);
		operator.selectByVisibleText(anyOperator);
		FilterValue.sendKeys(value);
		waitFor(3);
		SaveButton.click();
		waitFor(5);
		CreateProfile.scrollToTop();
		CreateProfile.click();
		waitFor(3);
	}
	
	public void clickOnProfileCreated(String profName) {
		String xpath="//div[@title='";
		xpath=xpath.concat(profName);
		xpath=xpath.concat("']");
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public String getProfileId() {
		String url=DriverManager.getDriver().getCurrentUrl();
		String []  id=url.split("id=");
		return id[1];
	}
	
	public void launchProfileUrl(String profId) {
		String url="https://express.sellernext.com/googleads/test/customProfileTest?userid=13323&&profile_id=";
		url=url.concat(profId);
		DriverManager.getDriver().get(url);
	}
	
	
	public ArrayList<String> getAttributesFromJsonData(String json,String attribute,String objAttribute) {
		ArrayList<String> Price=new ArrayList<String>();
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		JsonArray arr = jsonObject.getAsJsonArray("products_data");
		Reporter.log(""+arr.size());
		for (int i = 0; i < arr.size(); i++) {
		JsonObject val=arr.get(i).getAsJsonObject().get(objAttribute).getAsJsonObject();
		String valprice=val.get(attribute).getAsString();
		Reporter.log("the value is "+valprice);
		     Price.add(valprice);
		  	}
		Reporter.log("the list elements are    "+Price);
		return Price;
	}
	
	
	
}
