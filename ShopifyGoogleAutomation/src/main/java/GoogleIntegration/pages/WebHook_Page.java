package GoogleIntegration.pages;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
import GoogleIntegration.automation.LocalConfig;
import GoogleIntegration.utilities.ReadXML;

public class WebHook_Page extends commonPage {
	private TextBox ShopifyUrlTextbox;
	private TextBox ShopifyLogin;
	private Link NextButton;
	private TextBox ShopifyPassword;
	private Link InstallAppButton;
	private Link AddAppButton;
	private Link AppsOptionInShopify;
	private Link GoogleIntegration;
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
	private Link TrackQuantityCheck;
	private Link ProductConfigGoogle;
	private Link SelectProductSync;
	private Link DisableProductSync;
	private Link EnableProductSync;
	private Link SaveButtonGoogleSync;
	private Link AddImageButton;
	private Link DeleteVariantButton;
	private Link DeleteVariantDialogButton;
	private Link DeleteProductButton;
	private Link DeleteProductDialogButton;
	private Link AddFileButton;
	private Link ImportLimitExceededLabel;
	private Link SelectImportOptions;
	private Link ImportOptions_AllProducts;
	private Link ImportOptions_PublishedProducts;
	private Link ImportOptions_FilterProducts;
	private Link ConfirmImportButton;
	private Link ImportLimitValue;
	private Link AutoProductCreateDropdown;
	private Link AutoProductCreateDropdown_No;
	private Link AutoProductCreateDropdown_Yes;
	private Link SaveButtonAutoProductCreate;
	private Link AllProductsCheckBox;
	private Link EditProductButton;
	private Link AddFieldsButton;
	private Link MoreActionsButton;
	private Link DeleteProductsOption;
	private Link DeleteAllProductsButtonOnPopup;
	private TextBox TagsTextBox;
	private Link Orders_Shopify;
	private Link CreateOrderButton;
	private TextBox SearchProductsTextBoxInOrderPage;
	private TextBox SearchProductsTextBoxInOrderPagePopup;
	private Link AddtoOrderButton;
	private Link MarkAsPaidButton;
	private Link CreateOrderButtonAfterPopup;
	private Link AddVariantButtonforProductHavingVariant;
	private Link RefundLink;
	private Link IncreasingProductCount;
	private Link RefundButton;
	private Link ImportProducts;
	private Link Title_Sync;
	private Link Sku_Sync;
	private Link Image_Sync;
	private Link Inventory_Sync;
	private Link Weight_Sync;
	private Link Price_Sync;
	private Link Barcode_Sync;
	private Link Vendor_Sync;
	private Link ProductType_Sync;
	private Link Description_Sync;
	private Link Product_Module;
	private Link Product_ManageProduct;
	private Link ProductSyncing;
	private Link SaveButton_ProductSyncing;
	private Link SyncWithShopify_ProductSyncing;
	private Link SyncButton;
	private Link Dashboard;
	private Link RefreshHereDashBoard;
	private Link Settings;
	private Link Payments;
	private Link Manage;
	private Link AddCurrency;
	private TextBox SearchCurrencies;
	private Link AddCurrenciesButton;
	private Link Save;
	
	
	
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
		GoogleIntegration= new Link(ReadXML.getElementLocator("WebHook_Page", "GoogleIntegration"),
				"WebHook_Page", "GoogleIntegration");
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
		TrackQuantityCheck= new Link(ReadXML.getElementLocator("WebHook_Page", "TrackQuantityCheck"),
				"WebHook_Page", "TrackQuantityCheck");
		ProductConfigGoogle= new Link(ReadXML.getElementLocator("WebHook_Page", "ProductConfigGoogle"),
				"WebHook_Page", "ProductConfigGoogle");
		SelectProductSync= new Link(ReadXML.getElementLocator("WebHook_Page", "SelectProductSync"),
				"WebHook_Page", "SelectProductSync");
		DisableProductSync= new Link(ReadXML.getElementLocator("WebHook_Page", "DisableProductSync"),
				"WebHook_Page", "DisableProductSync");
		SaveButtonGoogleSync= new Link(ReadXML.getElementLocator("WebHook_Page", "SaveButtonGoogleSync"),
				"WebHook_Page", "SaveButtonGoogleSync");
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
		AddFileButton= new Link(ReadXML.getElementLocator("WebHook_Page", "AddFileButton"),
				"WebHook_Page", "AddFileButton");
		ImportLimitExceededLabel= new Link(ReadXML.getElementLocator("WebHook_Page", "ImportLimitExceededLabel"),
				"WebHook_Page", "ImportLimitExceededLabel");
		SelectImportOptions= new Link(ReadXML.getElementLocator("WebHook_Page", "SelectImportOptions"),
				"WebHook_Page", "SelectImportOptions");
		ImportOptions_AllProducts= new Link(ReadXML.getElementLocator("WebHook_Page", "ImportOptions_AllProducts"),
				"WebHook_Page", "ImportOptions_AllProducts");
		ImportOptions_PublishedProducts= new Link(ReadXML.getElementLocator("WebHook_Page", "ImportOptions_PublishedProducts"),
				"WebHook_Page", "ImportOptions_PublishedProducts");
		ImportOptions_FilterProducts= new Link(ReadXML.getElementLocator("WebHook_Page", "ImportOptions_FilterProducts"),
				"WebHook_Page", "ImportOptions_FilterProducts");
		ConfirmImportButton= new Link(ReadXML.getElementLocator("WebHook_Page", "ConfirmImportButton"),
				"WebHook_Page", "ConfirmImportButton");
		ImportLimitValue= new Link(ReadXML.getElementLocator("WebHook_Page", "ImportLimitValue"),
				"WebHook_Page", "ImportLimitValue");
		AutoProductCreateDropdown= new Link(ReadXML.getElementLocator("WebHook_Page", "AutoProductCreateDropdown"),
				"WebHook_Page", "AutoProductCreateDropdown");
		AutoProductCreateDropdown_No= new Link(ReadXML.getElementLocator("WebHook_Page", "AutoProductCreateDropdown_No"),
				"WebHook_Page", "AutoProductCreateDropdown_No");
		AutoProductCreateDropdown_Yes= new Link(ReadXML.getElementLocator("WebHook_Page", "AutoProductCreateDropdown_Yes"),
				"WebHook_Page", "AutoProductCreateDropdown_Yes");
		SaveButtonAutoProductCreate= new Link(ReadXML.getElementLocator("WebHook_Page", "SaveButtonAutoProductCreate"),
				"WebHook_Page", "SaveButtonAutoProductCreate");
		AllProductsCheckBox= new Link(ReadXML.getElementLocator("WebHook_Page", "AllProductsCheckBox"),
				"WebHook_Page", "AllProductsCheckBox");
		EditProductButton= new Link(ReadXML.getElementLocator("WebHook_Page", "EditProductButton"),
				"WebHook_Page", "EditProductButton");
		AddFieldsButton= new Link(ReadXML.getElementLocator("WebHook_Page", "AddFieldsButton"),
				"WebHook_Page", "AddFieldsButton");
		MoreActionsButton= new Link(ReadXML.getElementLocator("WebHook_Page", "MoreActionsButton"),
				"WebHook_Page", "MoreActionsButton");
		DeleteProductsOption= new Link(ReadXML.getElementLocator("WebHook_Page", "DeleteProductsOption"),
				"WebHook_Page", "DeleteProductsOption");
		DeleteAllProductsButtonOnPopup= new Link(ReadXML.getElementLocator("WebHook_Page", "DeleteAllProductsButtonOnPopup"),
				"WebHook_Page", "DeleteAllProductsButtonOnPopup");
		TagsTextBox= new TextBox(ReadXML.getElementLocator("WebHook_Page", "TagsTextBox"),
				"WebHook_Page", "TagsTextBox");
		Orders_Shopify= new Link(ReadXML.getElementLocator("WebHook_Page", "Orders_Shopify"),
				"WebHook_Page", "Orders_Shopify");
		CreateOrderButton= new Link(ReadXML.getElementLocator("WebHook_Page", "CreateOrderButton"),
				"WebHook_Page", "CreateOrderButton");
		SearchProductsTextBoxInOrderPage= new TextBox(ReadXML.getElementLocator("WebHook_Page", "SearchProductsTextBoxInOrderPage"),
				"WebHook_Page", "SearchProductsTextBoxInOrderPage");
		AddtoOrderButton= new Link(ReadXML.getElementLocator("WebHook_Page", "AddtoOrderButton"),
				"WebHook_Page", "AddtoOrderButton");
		MarkAsPaidButton= new Link(ReadXML.getElementLocator("WebHook_Page", "MarkAsPaidButton"),
				"WebHook_Page", "MarkAsPaidButton");
		CreateOrderButtonAfterPopup= new Link(ReadXML.getElementLocator("WebHook_Page", "CreateOrderButtonAfterPopup"),
				"WebHook_Page", "CreateOrderButtonAfterPopup");
		SearchProductsTextBoxInOrderPagePopup= new TextBox(ReadXML.getElementLocator("WebHook_Page", "SearchProductsTextBoxInOrderPagePopup"),
				"WebHook_Page", "SearchProductsTextBoxInOrderPagePopup");
		AddVariantButtonforProductHavingVariant= new Link(ReadXML.getElementLocator("WebHook_Page", "AddVariantButtonforProductHavingVariant"),
				"WebHook_Page", "AddVariantButtonforProductHavingVariant");
		RefundLink= new Link(ReadXML.getElementLocator("WebHook_Page", "RefundLink"),
				"WebHook_Page", "RefundLink");
		IncreasingProductCount= new Link(ReadXML.getElementLocator("WebHook_Page", "IncreasingProductCount"),
				"WebHook_Page", "IncreasingProductCount");
		RefundButton= new Link(ReadXML.getElementLocator("WebHook_Page", "RefundButton"),
				"WebHook_Page", "RefundButton");
		ImportProducts= new Link(ReadXML.getElementLocator("WebHook_Page", "ImportProducts"),
				"WebHook_Page", "ImportProducts");
		Title_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "Title_Sync"),
				"WebHook_Page", "Title_Sync");
		Sku_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "Sku_Sync"),
				"WebHook_Page", "Sku_Sync");
		Image_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "Image_Sync"),
				"WebHook_Page", "Image_Sync");
		Inventory_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "Inventory_Sync"),
				"WebHook_Page", "Inventory_Sync");
		Weight_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "Weight_Sync"),
				"WebHook_Page", "Weight_Sync");
		Price_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "Price_Sync"),
				"WebHook_Page", "Price_Sync");
		Barcode_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "Barcode_Sync"),
				"WebHook_Page", "Barcode_Sync");
		Vendor_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "Vendor_Sync"),
				"WebHook_Page", "Vendor_Sync");
		ProductType_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "ProductType_Sync"),
				"WebHook_Page", "ProductType_Sync");
		Description_Sync= new Link(ReadXML.getElementLocator("WebHook_Page", "Description_Sync"),
				"WebHook_Page", "Description_Sync");
		Product_Module= new Link(ReadXML.getElementLocator("WebHook_Page", "Product_Module"),
				"WebHook_Page", "Product_Module");
		Product_ManageProduct= new Link(ReadXML.getElementLocator("WebHook_Page", "Product_ManageProduct"),
				"WebHook_Page", "Product_ManageProduct");
		ProductSyncing= new Link(ReadXML.getElementLocator("WebHook_Page", "ProductSyncing"),
				"WebHook_Page", "ProductSyncing");
		SaveButton_ProductSyncing= new Link(ReadXML.getElementLocator("WebHook_Page", "SaveButton_ProductSyncing"),
				"WebHook_Page", "SaveButton_ProductSyncing");
		SyncWithShopify_ProductSyncing= new Link(ReadXML.getElementLocator("WebHook_Page", "SyncWithShopify_ProductSyncing"),
				"WebHook_Page", "SyncWithShopify_ProductSyncing");
		SyncButton= new Link(ReadXML.getElementLocator("WebHook_Page", "SyncButton"),
				"WebHook_Page", "SyncButton");
		Dashboard= new Link(ReadXML.getElementLocator("WebHook_Page", "Dashboard"),
				"WebHook_Page", "Dashboard");
		RefreshHereDashBoard= new Link(ReadXML.getElementLocator("WebHook_Page", "RefreshHereDashBoard"),
				"WebHook_Page", "RefreshHereDashBoard");
		Settings= new Link(ReadXML.getElementLocator("WebHook_Page", "Settings"),
				"WebHook_Page", "Settings");
		Payments= new Link(ReadXML.getElementLocator("WebHook_Page", "Payments"),
				"WebHook_Page", "Payments");
		Manage= new Link(ReadXML.getElementLocator("WebHook_Page", "Manage"),
				"WebHook_Page", "Manage");
		AddCurrency= new Link(ReadXML.getElementLocator("WebHook_Page", "AddCurrency"),
				"WebHook_Page", "AddCurrency");
		SearchCurrencies= new TextBox(ReadXML.getElementLocator("WebHook_Page", "SearchCurrencies"),
				"WebHook_Page", "SearchCurrencies");
		AddCurrenciesButton= new Link(ReadXML.getElementLocator("WebHook_Page", "AddCurrenciesButton"),
				"WebHook_Page", "AddCurrenciesButton");
		Save= new Link(ReadXML.getElementLocator("WebHook_Page", "Save"),
				"WebHook_Page", "Save");
	
	
	
	}
	
	public void waitFor(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LogginginShopify(){
		DriverManager.getDriver().get("https://automationtesting.myshopify.com/admin");
		ShopifyLogin.sendKeys("shantanugupta@cedcommerce.com");
		waitFor(2);
		NextButton.click();
		ShopifyPassword.sendKeys("dracarys");
		waitFor(2);
		ShopifyPassword.sendKeys(Keys.ENTER);
		waitFor(3);
	}
	
	
	public void goToGoogleIntegrationApp(){
		AppsOptionInShopify.click();
		GoogleIntegration.click();
		waitFor(5);
	}
	public void extractingUrlAddingDotJsonAndLaunching() {
		String currUrl=DriverManager.getDriver().getCurrentUrl();
		Reporter.log(""+currUrl);
		currUrl=currUrl.concat(".json");
	DriverManager.getDriver().get(currUrl);	
	}
	
	public String extractingJsonDataAsStringfromPage() {
		String js=DriverManager.getDriver().findElement(By.xpath("//body")).getText();
		Reporter.log(""+js);
		return js;
	}
	
	public void workonDescription(String text) {
		DriverManager.getDriver().switchTo().frame("product-description_ifr");
		DescriptionTextBox.sendKeys(text);
		DriverManager.getDriver().switchTo().defaultContent();
	}
	public void creatingNewProduct(String title,String description,String prodType,String vendor,String price,String costperitem,String inventory,String weight) {
		Products_Shopify.click();
		waitFor(3);
		AddProductButton.click();
		waitFor(3);
		TitleTextBox.sendKeys(title);
		workonDescription(description);
		WebElement productStatus=DriverManager.getDriver().findElement(By.xpath("//h2[text()='Product status']/parent::div/following-sibling::div/descendant::select[contains(@class,'Polaris-Select')]"));
		Select select=new Select(productStatus);
		select.selectByVisibleText("Active");
		ProductTypeTextBox.sendKeys(prodType);
		VendorTextBox.sendKeys(vendor);
		PriceTextBox.sendKeys(price);
		CostPerItemTextBox.sendKeys(costperitem);
		DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,inventory);
		QuantityAvailableTextBox.scrollToView();
		DeletingfromTextBoxandEnteringAnotherText(WeightTextBox,weight);
		SaveButton.click();
		waitFor(3);
	}
	
	public String fetchingfromJsonObject(String js,String obj, String objAttr) {
		
		JsonObject jsonObject = new JsonParser().parse(js).getAsJsonObject();
		String objectAttr = jsonObject.getAsJsonObject(obj).get(objAttr).getAsString();
		Reporter.log("The  " +objAttr+ "  of the product is:   "+objectAttr);
				return objectAttr;
		}
	
	public JsonArray fetchingJsonArray(String js, String obj, String objAttr) {
		JsonObject jsonObject = new JsonParser().parse(js).getAsJsonObject();
		JsonArray arr = jsonObject.getAsJsonObject(obj).getAsJsonArray(objAttr);
		Reporter.log("From Fetching Json Array Function    "+arr);
		return arr;
	}
	
	public String fetchingfromJsonArray(String js, String obj, String objAttr, String AttrVal) {
		JsonObject jsonObject = new JsonParser().parse(js).getAsJsonObject();
		JsonArray arr = jsonObject.getAsJsonObject(obj).getAsJsonArray(objAttr);
		Reporter.log(""+arr);
		Reporter.log(""+arr.size());
		String val=null;
		for (int i = 0; i < arr.size(); i++) {
			val=arr.get(i).getAsJsonObject().get(AttrVal).toString();
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
	
	public void updatingSimpleProductsAttributes(String product,String updateAttribute,String updatedText){
		Products_Shopify.click();
		waitFor(3);
		FilterProductsTextBox.sendKeys(product);
		waitFor(3);
		AfterFilterProduct.click();
		waitFor(3);
		if(updateAttribute.equalsIgnoreCase("title")) {
			DeletingfromTextBoxandEnteringAnotherText(TitleTextBox,updatedText);	
		}
		else if(updateAttribute.equalsIgnoreCase("description")) {
			DeletingfromTextBoxandEnteringAnotherText(DescriptionTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("product type")) {
			//DescriptionTextBox.scrollToView();
			DeletingfromTextBoxandEnteringAnotherText(ProductTypeTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("vendor")) {
			//ProductTypeTextBox.scrollToView();
			DeletingfromTextBoxandEnteringAnotherText(VendorTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("price")) {
			//VendorTextBox.scrollToView();
			DeletingfromTextBoxandEnteringAnotherText(PriceTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("inventory")) {
			//PriceTextBox.scrollToView();
			DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("weight")) {
		//	QuantityAvailableTextBox.scrollToView();
			DeletingfromTextBoxandEnteringAnotherText(WeightTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("sku")) {
			//PriceTextBox.scrollToView();
			DeletingfromTextBoxandEnteringAnotherText(SKUTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("barcode")) {
			//PriceTextBox.scrollToView();
			DeletingfromTextBoxandEnteringAnotherText(BarCodeTextBox,updatedText);
		}
		SaveButton.click();
		waitFor(4);
	}
		
	public void launchGoogleUrlWithProdId(String userId,String prod_id){
		String url="https://express.sellernext.com/googleads/test/automation?userid=";
		url=url.concat(userId);
		url=url.concat("&product_id=");
		url=url.concat(prod_id);
		DriverManager.getDriver().get(url);
		
	}

	public Boolean verifyingUpdate(String updatedtextshop, String updatedtextwal) {
		try {
			Reporter.log("The updated text from shopify is :  "+updatedtextshop);
			Reporter.log("The updated text from Google is :  "+updatedtextwal);
		Assert.assertEquals(updatedtextwal, updatedtextshop);
		return true;
		}
		catch(AssertionError e) {
			Reporter.log("The product is not updated. Try again");
			return false;
		}
		

	}
	
	public void selectingVariantProduct(String variantName) {
		String xp="//div[contains(@class,'Polaris-Stack__Item_') and text()='";
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
			 Reporter.log("The updated value extracted from google is :  "+val);
			}
			  	}
		return val;
	}
	public void productToBeUpdatedforVariants(String product){
		Products_Shopify.click();
		waitFor(3);
		FilterProductsTextBox.sendKeys(product);
		waitFor(3);
		AfterFilterProduct.click();
		waitFor(5);
		EditButton.click();
		waitFor(3);
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
		else if(variant.equalsIgnoreCase("inventory")) {
			DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("weight")) {
			DeletingfromTextBoxandEnteringAnotherText(WeightTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("title")) {
			DeletingfromTextBoxandEnteringAnotherText(TitleTextBox,updatedText);
		}
		else if(variant.equalsIgnoreCase("description")) {
			DeletingfromTextBoxandEnteringAnotherText(DescriptionTextBox,updatedText);
		}
		SaveButton.click();
		
					}
	
	public void addingVariant(String product,String variantName, String variantValue ){
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		waitFor(3);
		AfterFilterProduct.click();
		waitFor(3);
		VariantsCheckbox.click();
		waitFor(2);
		DeletingfromTextBoxandEnteringAnotherText(FirstVariantTextBox,variantName);
		FirstVariantValueTextBox.sendKeys(variantValue);
		waitFor(10);
		SaveButton.click();
		waitFor(5);
		EditButton.click();
	}
	
	public void uncheckingTrackQuantityCheckbox() {
//		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",TrackQuantityCheckbox );
		if(TrackQuantityCheck.isSelected()) {
			TrackQuantityCheckbox.click();
			SaveButton.click();
		}
	}
	
	public void verifyingNotUpdated(String updatedtextshop, String updatedtextwal) {
		Reporter.log("The shopify text is:   "+updatedtextshop);
		Reporter.log("The Google text is:   "+updatedtextwal);
		Assert.assertNotSame(updatedtextwal, updatedtextshop);
		Reporter.log("Verified that not updating when Sync is disabled");
	}
	
	public void deletingVariant() {
		DeleteVariantButton.click();
		DeleteVariantDialogButton.click();
	}
	//span[ text()='shorts']/parent::a
	public String deletingProduct(String product){
		Products_Shopify.click();
		
		String delprod="//span[ text()='";
		delprod=delprod.concat(product);
		delprod=delprod.concat("']/parent::a");
		waitFor(3);
		FilterProductsTextBox.sendKeys(product);
		waitFor(3);
		DriverManager.getDriver().findElement(By.xpath(delprod)).click();
		waitFor(3);
		extractingUrlAddingDotJsonAndLaunching();
		String json=extractingJsonDataAsStringfromPage();
		String prod_id=fetchingfromJsonObject(json,"product","id");
		DriverManager.getDriver().navigate().back();
		waitFor(3);
		DeleteProductButton.click();
		waitFor(3);
		DeleteProductDialogButton.click();
		waitFor(3);
		return prod_id;
	}
	
	public void closeAllOpenedTabs() {
		for(String handle : DriverManager.getDriver().getWindowHandles()) {
			DriverManager.getDriver().switchTo().window(handle);
			DriverManager.getDriver().close();
	        }
	    }
	
	public String convertingToPoundandRoundingOffto5DecPlace(String weightinKg) {
		double weight=Double.parseDouble(weightinKg);
		double	weightinPound=weight*2.2046226218;
		DecimalFormat df = new DecimalFormat("#.#####");
	    df.setRoundingMode(RoundingMode.CEILING);
	    String WeightPound=df.format(weightinPound);
	    return WeightPound;
	}
	
	
	public void updatingInventoryForVariants(String updatedText) {
		DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,updatedText);
		SaveButton.click();
		
	}
	
	public void selectingForBulkUpdate(){
		Products_Shopify.click();
		waitFor(3);
		AllProductsCheckBox.click();
		waitFor(3);
		EditProductButton.click();
		waitFor(3);
		AddFieldsButton.click();
		waitFor(3);
		
	}
	
	//give field name as in shopify app
	//button[contains(@class,'ui-button') and text()='Inventory quantity']
	public void selectingAParticularFieldforBulkEditing(String fieldName){
		String field="//button[contains(@class,'ui-button') and text()='";
		field=field.concat(fieldName);
		field=field.concat("']");
		DriverManager.getDriver().findElement(By.xpath(field)).click();
		waitFor(5);
	}
	
	
	//if in for loop, take num= i+1
		public void selectingAParticularTextBoxofInventory(String varCol,String varNum) {
	//(//span[contains(@class,'variant-option-value option-2') and text()='Grey']/preceding-sibling::span[contains(text(),'40')]/parent::div/following-sibling::div)[4]"
		String inventoryTextbox="(//span[contains(@class,'variant-option-value option-2') and text()='";
		inventoryTextbox=inventoryTextbox.concat(varCol);
		inventoryTextbox=inventoryTextbox.concat("']/preceding-sibling::span[contains(text(),'");
		inventoryTextbox=inventoryTextbox.concat(varNum);
		inventoryTextbox=inventoryTextbox.concat("')]/parent::div/following-sibling::div)[4]");
		DriverManager.getDriver().findElement(By.xpath(inventoryTextbox)).click();
		}
		
		//if in for loop, take num= i+2
		public void updatingBulkInventory(String varCol,String varNum,String updatedQty) {
		//	(//span[contains(@class,'variant-option-value option-2') and text()='Grey']/preceding-sibling::span[contains(text(),'40')]/parent::div/following-sibling::div)[4]/descendant::div/child::input[contains(@id,'product_variants_attributes_')]
			String invUpdate="(//span[contains(@class,'variant-option-value option-2') and text()='";
			invUpdate=invUpdate.concat(varCol);
			invUpdate=invUpdate.concat("']/preceding-sibling::span[contains(text(),'");
			invUpdate=invUpdate.concat(varNum);
			invUpdate=invUpdate.concat("')]/parent::div/following-sibling::div)[4]/descendant::div/child::input[contains(@id,'product_variants_attributes_')]");
					
			
	WebElement Inventory=	DriverManager.getDriver().findElement(By.xpath(invUpdate));
	Inventory.click();
	Inventory.sendKeys(Keys.END);
	Inventory.sendKeys(Keys.LEFT_SHIFT,Keys.HOME,Keys.CLEAR);
	Inventory.sendKeys(updatedQty);
	Inventory.sendKeys(Keys.ESCAPE);

		
			
		}
	
	public void clickingSaveButtonforBulk(){
		SaveButton.click();
		waitFor(3);
			}
	
	public void selectingProduct(String product){
		Products_Shopify.click();
		waitFor(3);
		FilterProductsTextBox.sendKeys(product);
		waitFor(3);
		AfterFilterProduct.click();
		waitFor(3);
	}
	
	public void deleteAllProducts(){
		Products_Shopify.click();
		waitFor(3);
		AllProductsCheckBox.click();
		waitFor(3);
		MoreActionsButton.click();
		waitFor(3);
		DeleteProductsOption.click();
		waitFor(3);
	//	DeleteAllProductsButtonOnPopup.click();
			}
	
	public void updatingTags(String updatedText){
		DeletingfromTextBoxandEnteringAnotherText(TagsTextBox,updatedText);
		TagsTextBox.sendKeys(Keys.ENTER);
		waitFor(3);
		SaveButton.click();
	}
	
	public void clickingCheckboxforParticularVariantInOrder(String varid) {
		//DriverManager.getDriver().switchTo().defaultContent();
	String varCheck="//input[@id='variant_checkbox_";
	varCheck=varCheck.concat(varid);
	varCheck=varCheck.concat("']");
	DriverManager.getDriver().findElement(By.xpath(varCheck)).click();
	}
	
	public void creatingOrder(String firstletterofProduct,String restOfLetterOfProduct,String varid){
		Orders_Shopify.click();
		waitFor(3);
		CreateOrderButton.click();
		waitFor(3);
		SearchProductsTextBoxInOrderPage.sendKeys(firstletterofProduct);
		waitFor(3);
		SearchProductsTextBoxInOrderPagePopup.sendKeys(restOfLetterOfProduct);
		waitFor(3);
		clickingCheckboxforParticularVariantInOrder(varid);
		waitFor(3);
		AddtoOrderButton.click();
		waitFor(7);
		MarkAsPaidButton.click();
		waitFor(7);
		CreateOrderButtonAfterPopup.click();
		waitFor(7);
	}
	
	public void addingVariantforProductHavingVariant(String sizeVal,String colorVal,String quantity){
		DriverManager.getDriver().findElement(By.xpath("//button[@type='button' and @aria-label='Dismiss this message']")).click();
		AddVariantButtonforProductHavingVariant.click();
		waitFor(3);
		DeletingfromTextBoxandEnteringAnotherText(SizeTextBox,sizeVal);
		DeletingfromTextBoxandEnteringAnotherText(ColorTextBox,colorVal);
		DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,quantity);
		SaveButton.click();
		waitFor(5);
		
	}
	
	public ArrayList<String> duplicatingSkuOfOneProductToAnother(String variantToduplicateSku) {
		ArrayList<String> varProdId=new ArrayList<String>();
		extractingVariantIdfromUrl();
		extractingUrlAddingDotJsonAndLaunching();
		String json=extractingJsonDataAsStringfromPage();
		String prod_id=	fetchingfromJsonObject(json, "variant", "product_id");
		String sku=fetchingfromJsonObject(json,"variant","sku");
		Reporter.log("Sku is "+sku);
		DriverManager.getDriver().navigate().back();
		waitFor(3);
		selectingVariantProduct(variantToduplicateSku);
		waitFor(3);
		DeletingfromTextBoxandEnteringAnotherText(SKUTextBox,sku);
		SaveButton.click();
		waitFor(3);
		String varid2=extractingVariantIdfromUrl();
		extractingUrlAddingDotJsonAndLaunching();
		extractingJsonDataAsStringfromPage();
		DriverManager.getDriver().navigate().back();
		varProdId.add(0, prod_id);
		varProdId.add(1, varid2);
		Reporter.log("Product and Variant id are  "+varProdId);
		return varProdId;
	}
	
	public void orderToBeRefunded(String OrderId) {
		Orders_Shopify.click();
		waitFor(3);
		String orderId="//span[contains(text(),'";
		orderId=orderId.concat(OrderId);
		orderId=orderId.concat("')]");
		DriverManager.getDriver().findElement(By.xpath(orderId)).click();
		waitFor(3);
		RefundLink.click();
		waitFor(5);
		IncreasingProductCount.click();
		waitFor(3);
		RefundButton.click();
		waitFor(3);
	}
	
	public void goToManageSectionInPaymentSettings() {
		Settings.click();
		waitFor(2);
		Payments.click();
		waitFor(2);
		Manage.click();
		waitFor(2);
	}
	
	//span[text()='British Pound
	public void selectingACurrency(String currency) {
		AddCurrency.click();
		waitFor(3);
		SearchCurrencies.sendKeys(currency);
		String xpath="//span[text()='";
		xpath=xpath.concat(currency);
		xpath=xpath.concat("']/parent::div");
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
		AddCurrenciesButton.click();
		waitFor(3);
		Save.click();
		waitFor(3);
	}
	
	public void launchShopUpdateUrl(String shopId) {
		String url="https://express.sellernext.com/googleads/test/shopTest?userid=";
		url=url.concat(shopId);
		DriverManager.getDriver().get(url);
	}
	
	}
