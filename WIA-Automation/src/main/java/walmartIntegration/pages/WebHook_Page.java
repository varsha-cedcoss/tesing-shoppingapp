package walmartIntegration.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.TextBox;
import walmartIntegration.automation.LocalConfig;
import walmartIntegration.utilities.ReadXML;

public class WebHook_Page extends commonPage {
	private TextBox ShopifyUrlTextbox;
	private TextBox ShopifyLogin;
	private Link NextButton;
	private TextBox ShopifyPassword;
	private Link InstallAppButton;
	private Link AddAppButton;
	private Link AppsOptionInShopify;
	private Link WalmartIntegration;
	private Link AddProductButton;
	private Link Products_Shopify;	
	private TextBox TitleTextBox;
	private TextBox DescriptionTextBox;
	private TextBox ProductTypeTextBox;
	private TextBox VendorTextBox;
	private TextBox PriceTextBox;
	private TextBox CostPerItemTextBox;
	private TextBox QuantityAvailableTextBox;
	private TextBox WeightTextBox;
	private Link SaveButton;
	private Link NotMappedProductsWIA;
	private TextBox FilterProductsTextBox;
	private Link AfterFilterProduct;
	private Link EditButton;
	private Link NumOfVariantsAfterClickEdit;
	private TextBox SizeTextBox;
	private TextBox ColorTextBox;
	private TextBox SKUTextBox;
	private TextBox BarCodeTextBox;
	private Link VariantsCheckbox;
	private TextBox FirstVariantTextBox;
	private TextBox FirstVariantValueTextBox;
	private Link AddAnotherOptionforVariant;
	private Link TrackQuantityCheckbox;
	private Link Settings;
	private Link ProductConfigWalmart;
	private Link SelectProductSync;
	private Link DisableProductSync;
	private Link EnableProductSync;
	private Link SaveButtonWalmartSync;
	private Link AddImageButton;
	private Link DeleteVariantButton;
	private Link DeleteVariantDialogButton;
	private Link DeleteProductButton;
	private Link DeleteProductDialogButton;
	
	public WebHook_Page()  {
		super(WebHook_Page.class.getSimpleName());
		this.pageURL= LocalConfig.WIA_URL;

		ShopifyUrlTextbox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "ShopifyUrlTextbox"),
				"WebHook_Page", "ShopifyUrlTextbox");
		ShopifyLogin= new TextBox(ReadXML.getElementLocator("WebHook_Page", "ShopifyLogin"),
				"WebHook_Page", "ShopifyLogin");
		NextButton= new Link(ReadXML.getElementLocator("WebHook_Page", "NextButton"),
				"WebHook_Page", "NextButton");
		ShopifyPassword= new TextBox(ReadXML.getElementLocator("WebHook_Page", "ShopifyPassword"),
				"WebHook_Page", "ShopifyPassword");
		InstallAppButton= new Link(ReadXML.getElementLocator("WebHook_Page", "InstallAppButton"),
				"WebHook_Page", "InstallAppButton");
		AddAppButton= new Link(ReadXML.getElementLocator("WebHook_Page", "AddAppButton"),
				"WebHook_Page", "AddAppButton");
		AppsOptionInShopify= new Link(ReadXML.getElementLocator("WebHook_Page", "AppsOptionInShopify"),
				"WebHook_Page", "AppsOptionInShopify");
		WalmartIntegration= new Link(ReadXML.getElementLocator("WebHook_Page", "WalmartIntegration"),
				"WebHook_Page", "WalmartIntegration");
		Products_Shopify= new Link(ReadXML.getElementLocator("WebHook_Page", "Products_Shopify"),
				"WebHook_Page", "Products_Shopify");
		AddProductButton= new Link(ReadXML.getElementLocator("WebHook_Page", "AddProductButton"),
				"WebHook_Page", "AddProductButton");
		TitleTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "TitleTextBox"),
				"WebHook_Page", "TitleTextBox");
		DescriptionTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "DescriptionTextBox"),
				"WebHook_Page", "DescriptionTextBox");
		ProductTypeTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "ProductTypeTextBox"),
				"WebHook_Page", "ProductTypeTextBox");
		VendorTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "VendorTextBox"),
				"WebHook_Page", "VendorTextBox");
		PriceTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "PriceTextBox"),
				"WebHook_Page", "PriceTextBox");
		CostPerItemTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "CostPerItemTextBox"),
				"WebHook_Page", "CostPerItemTextBox");
		QuantityAvailableTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "QuantityAvailableTextBox"),
				"WebHook_Page", "QuantityAvailableTextBox");
		WeightTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "WeightTextBox"),
				"WebHook_Page", "WeightTextBox");
		SaveButton= new Link(ReadXML.getElementLocator("WebHook_Page", "SaveButton"),
				"WebHook_Page", "SaveButton");
		NotMappedProductsWIA= new Link(ReadXML.getElementLocator("WebHook_Page", "NotMappedProductsWIA"),
				"WebHook_Page", "NotMappedProductsWIA");
		FilterProductsTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "FilterProductsTextBox"),
				"WebHook_Page", "FilterProductsTextBox");
		AfterFilterProduct= new Link(ReadXML.getElementLocator("WebHook_Page", "AfterFilterProduct"),
				"WebHook_Page", "AfterFilterProduct");
		EditButton= new Link(ReadXML.getElementLocator("WebHook_Page", "EditButton"),
				"WebHook_Page", "EditButton");
		NumOfVariantsAfterClickEdit= new Link(ReadXML.getElementLocator("WebHook_Page", "NumOfVariantsAfterClickEdit"),
				"WebHook_Page", "NumOfVariantsAfterClickEdit");
		SizeTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "SizeTextBox"),
				"WebHook_Page", "SizeTextBox");
		ColorTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "ColorTextBox"),
				"WebHook_Page", "ColorTextBox");
		SKUTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "SKUTextBox"),
				"WebHook_Page", "SKUTextBox");
		BarCodeTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "BarCodeTextBox"),
				"WebHook_Page", "BarCodeTextBox");
		VariantsCheckbox= new Link(ReadXML.getElementLocator("WebHook_Page", "VariantsCheckbox"),
				"WebHook_Page", "VariantsCheckbox");
		FirstVariantTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "FirstVariantTextBox"),
				"WebHook_Page", "FirstVariantTextBox");
		FirstVariantValueTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "FirstVariantValueTextBox"),
				"WebHook_Page", "FirstVariantValueTextBox");
		AddAnotherOptionforVariant= new Link(ReadXML.getElementLocator("WebHook_Page", "AddAnotherOptionforVariant"),
				"WebHook_Page", "AddAnotherOptionforVariant");
		TrackQuantityCheckbox= new Link(ReadXML.getElementLocator("WebHook_Page", "TrackQuantityCheckbox"),
				"WebHook_Page", "TrackQuantityCheckbox");
		Settings= new Link(ReadXML.getElementLocator("WebHook_Page", "Settings"),
				"WebHook_Page", "Settings");
		ProductConfigWalmart= new Link(ReadXML.getElementLocator("WebHook_Page", "ProductConfigWalmart"),
				"WebHook_Page", "ProductConfigWalmart");
		SelectProductSync= new Link(ReadXML.getElementLocator("WebHook_Page", "SelectProductSync"),
				"WebHook_Page", "SelectProductSync");
		DisableProductSync= new Link(ReadXML.getElementLocator("WebHook_Page", "DisableProductSync"),
				"WebHook_Page", "DisableProductSync");
		SaveButtonWalmartSync= new Link(ReadXML.getElementLocator("WebHook_Page", "SaveButtonWalmartSync"),
				"WebHook_Page", "SaveButtonWalmartSync");
		EnableProductSync= new Link(ReadXML.getElementLocator("WebHook_Page", "EnableProductSync"),
				"WebHook_Page", "EnableProductSync");
		AddImageButton= new Link(ReadXML.getElementLocator("WebHook_Page", "AddImageButton"),
				"WebHook_Page", "AddImageButton");
		DeleteVariantButton= new Link(ReadXML.getElementLocator("WebHook_Page", "DeleteVariantButton"),
				"WebHook_Page", "DeleteVariantButton");
		DeleteVariantDialogButton= new Link(ReadXML.getElementLocator("WebHook_Page", "DeleteVariantDialogButton"),
				"WebHook_Page", "DeleteVariantDialogButton");
		DeleteProductButton= new Link(ReadXML.getElementLocator("WebHook_Page", "DeleteProductButton"),
				"WebHook_Page", "DeleteProductButton");
		DeleteProductDialogButton= new Link(ReadXML.getElementLocator("WebHook_Page", "DeleteProductDialogButton"),
				"WebHook_Page", "DeleteProductDialogButton");
		
		
		
		
	}
	
	public void LogginginShopify() throws InterruptedException {

		DriverManager.getDriver().get("https://automationtesting.myshopify.com/admin/");
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
	public void extractingUrlAddingDotJsonAndLaunching() {
		String currUrl=DriverManager.getDriver().getCurrentUrl();
		Reporter.log(""+currUrl);
		currUrl=currUrl.concat(".json");
	DriverManager.getDriver().get(currUrl);	
	}
	
	public String extractingJsonDataAsStringfromPage() {
		String js=DriverManager.getDriver().findElement(By.xpath("//body")).getText();
		return js;
	}
	
	public void workonDescription(String text) {
		DriverManager.getDriver().switchTo().frame("product-description_ifr");
		DescriptionTextBox.sendKeys(text);
		DriverManager.getDriver().switchTo().defaultContent();
	}
	public void creatingNewProduct() {
		Products_Shopify.click();
		AddProductButton.click();
		TitleTextBox.sendKeys("Shorts");
		workonDescription("Shorts for men");
		ProductTypeTextBox.sendKeys("Pants");
		VendorTextBox.sendKeys("automationtesting");
		PriceTextBox.sendKeys("1000");
		CostPerItemTextBox.sendKeys("1000");
		DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,"10");
		DeletingfromTextBoxandEnteringAnotherText(WeightTextBox,"0.1");
		SaveButton.click();
		
	}
	public String fetchingfromJsonObject(String js,String obj, String objAttr) {
		
		JsonObject jsonObject = new JsonParser().parse(js).getAsJsonObject();
		String objectAttr = jsonObject.getAsJsonObject(obj).get(objAttr).getAsString();
		Reporter.log("The  " +objAttr+ "  of the product is:   "+objectAttr);
				return objectAttr;
		}
	
	public String fetchingfromJsonArray(String js, String obj, String objAttr, String AttrVal) {
		JsonObject jsonObject = new JsonParser().parse(js).getAsJsonObject();
		JsonArray arr = jsonObject.getAsJsonObject(obj).getAsJsonArray(objAttr);
		Reporter.log(""+arr);
		Reporter.log(""+arr.size());
		String val=null;
		for (int i = 0; i < arr.size(); i++) {
			val = arr.get(i).getAsJsonObject().get(AttrVal).getAsString();
		     break;
		  	}
		Reporter.log("The  " +AttrVal+ "  of the product is:   "+val);
		return val;
					}
	
	
	public void switchingtoTab(int tabnum) {
	ArrayList<String> tabsArr=new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
	DriverManager.getDriver().switchTo().window(tabsArr.get(tabnum));
		}
	
	public void DeletingfromTextBoxandEnteringAnotherText(WebElement element, String text) {
	if(element.equals(DescriptionTextBox)) {
		DriverManager.getDriver().switchTo().frame("product-description_ifr");
		Reporter.log(""+element.getText());
		element.click();
		element.sendKeys(Keys.SHIFT,Keys.HOME,Keys.DELETE);
		element.sendKeys(text);
		Reporter.log(""+element.getText());
		DriverManager.getDriver().switchTo().defaultContent();
	}
	else {
	//	((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",element );
		element.click();
		element.sendKeys(Keys.END);
		element.sendKeys(Keys.SHIFT,Keys.HOME,Keys.DELETE);
		element.sendKeys(text);
				}
	}
		
	public void updatingTitle(String product,String updateText) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(TitleTextBox,updateText);
		SaveButton.click();
		Thread.sleep(3000);
	}
	
	public void updatingDescription(String product,String updateText) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(DescriptionTextBox,updateText);
		SaveButton.click();
		Thread.sleep(3000);
	}
	
	public void updatingProductType(String product,String updateText) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(ProductTypeTextBox,updateText);
		SaveButton.click();
		Thread.sleep(3000);
	}
	
	public void updatingVendor(String product,String updateText) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(VendorTextBox,updateText);
		SaveButton.click();
		Thread.sleep(3000);
	}
	
	public void updatingPrice(String product,String updateText) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(PriceTextBox,updateText);
		SaveButton.click();
		Thread.sleep(3000);
	}
	
	public void updatingInventory(String product,String updateText) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,updateText);
		SaveButton.click();
		Thread.sleep(3000);
	}
	
	public void updatingWeight(String product,String updateText) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(WeightTextBox,updateText);
		SaveButton.click();
		Thread.sleep(3000);
	}
	
	public void updatingSKU(String product, String updateText, String webElement) throws InterruptedException  {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(SKUTextBox,updateText);
		SaveButton.click();
		Thread.sleep(3000);
	}
	
	public void updatingBarcode(String product, String updateText) throws InterruptedException  {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(BarCodeTextBox,updateText);
		SaveButton.click();
		Thread.sleep(3000);
	}
	
	public void launchWalmartUrlWithProdId(String prod_id){
		String url="https://apps.cedcommerce.com/integration/walmart/walmartcustomwork/get-saved-product?id=";
		url=url.concat(prod_id);
		DriverManager.getDriver().get(url);
	}

	public void verifyingUpdate(String updatedtextshop, String updatedtextwal) {
		
		Reporter.log("The updated text from shopify is :  "+updatedtextshop);
		Reporter.log("The updated text from walmart is :  "+updatedtextwal);
	Assert.assertEquals(updatedtextwal, updatedtextshop);

	}
	
	public void selectingVariantProduct(String variantName) {
		String xp="//div[contains(@class,'_1fyLs KYKAN') and text()='";
		xp=xp.concat(variantName);
		xp=xp.concat("']");
		if(DriverManager.getDriver().findElement(By.xpath(xp)).isSelected()) {
			Reporter.log("Already selected");
		}else {
		DriverManager.getDriver().findElement(By.xpath(xp)).click();}
					}
	
	
	
	public String fetchingfromJsonArrayofVariantsBasedonVariantId(String js, String obj, String objAttr,String variantId, String AttrVal) {
		JsonObject jsonObject = new JsonParser().parse(js).getAsJsonObject();
		JsonArray arr = jsonObject.getAsJsonObject(obj).getAsJsonArray(objAttr);
		Reporter.log("The  size of array in json:   "+arr.size());
		String val=null;
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getAsJsonObject().get("id").getAsString().equals(variantId)) {
			 val=arr.get(i).getAsJsonObject().get(AttrVal).getAsString();
			 Reporter.log("The updated value extracted from walmart is :  "+val);
			}
			  	}
		return val;
	}
	public void productToBeUpdatedforVariants(String product) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		EditButton.click();
		Reporter.log("Clicked First edit button");
	}
	
	public String extractingVariantIdfromUrl() {
		String[] id=DriverManager.getDriver().getCurrentUrl().split("variants/");
		Reporter.log("The variant id is:   "+id[1]);
		return id[1];
	}
	public void variantsToBeUpdated(String variant, String updatedText) {
		if(variant.equalsIgnoreCase("size")) {
			DeletingfromTextBoxandEnteringAnotherText(SizeTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("color")) {
			DeletingfromTextBoxandEnteringAnotherText(ColorTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("price")) {
			DeletingfromTextBoxandEnteringAnotherText(PriceTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("costperitem")) {
			DeletingfromTextBoxandEnteringAnotherText(CostPerItemTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("sku")) {
			DeletingfromTextBoxandEnteringAnotherText(SKUTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("barcode")) {
			DeletingfromTextBoxandEnteringAnotherText(BarCodeTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("quantity")) {
			DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("weight")) {
			DeletingfromTextBoxandEnteringAnotherText(WeightTextBox,updatedText);
		}
		SaveButton.click();
		
					}
	
	public void addingVariant(String product,String variantName, String variantValue ) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		VariantsCheckbox.click();
		Thread.sleep(2000);
		DeletingfromTextBoxandEnteringAnotherText(FirstVariantTextBox,variantName);
		FirstVariantValueTextBox.sendKeys(variantValue);
		Thread.sleep(10000);
		SaveButton.click();
		Thread.sleep(5000);
		EditButton.click();
	}
	
	public void uncheckingTrackQuantityCheckbox() {
//		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",TrackQuantityCheckbox );
		TrackQuantityCheckbox.click();
		SaveButton.click();
	}
	
	public void disablingSyncInWalmart() throws InterruptedException {
		Settings.click();
		ProductConfigWalmart.click();
			SelectProductSync.click();
			DisableProductSync.click();
			SaveButtonWalmartSync.click();
			Thread.sleep(2000);
	}
	
	public void enablingSyncInWalmart() throws InterruptedException {
		Settings.click();
		ProductConfigWalmart.click();
			SelectProductSync.click();
			EnableProductSync.click();
			SaveButtonWalmartSync.click();
			Thread.sleep(2000);
	}
		
	public void verifyingNotUpdated(String updatedtextshop, String updatedtextwal) {
		Reporter.log("The shopify text is:   "+updatedtextshop);
		Reporter.log("The walmart text is:   "+updatedtextwal);
		Assert.assertNotSame(updatedtextwal, updatedtextshop);
		Reporter.log("Verified that not updating when Sync is disabled");
	}
	
	public void deletingVariant() {
		DeleteVariantButton.click();
		DeleteVariantDialogButton.click();
	}
	
	public String deletingProduct(String product) throws InterruptedException {
		Products_Shopify.click();
		String delprod="//span[contains(@class,'_3UFJd') and text()='";
		delprod=delprod.concat(product);
		delprod=delprod.concat("']");
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		DriverManager.getDriver().findElement(By.xpath(delprod)).click();
		Thread.sleep(3000);
		extractingUrlAddingDotJsonAndLaunching();
		String json=extractingJsonDataAsStringfromPage();
		String prod_id=fetchingfromJsonObject(json,"product","id");
		DriverManager.getDriver().navigate().back();
		Thread.sleep(3000);
		DeleteProductButton.click();
		Thread.sleep(3000);
		DeleteProductDialogButton.click();
		Thread.sleep(3000);
		return prod_id;
	}
	
	}
