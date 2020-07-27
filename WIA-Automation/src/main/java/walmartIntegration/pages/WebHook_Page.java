package walmartIntegration.pages;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
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
		AddProductButton.click();
		TitleTextBox.sendKeys(title);
		workonDescription(description);
		ProductTypeTextBox.sendKeys(prodType);
		VendorTextBox.sendKeys(vendor);
		PriceTextBox.sendKeys(price);
		CostPerItemTextBox.sendKeys(costperitem);
		DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,inventory);
		DeletingfromTextBoxandEnteringAnotherText(WeightTextBox,weight);
		SaveButton.click();
		
		
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
	
	public void updatingSimpleProductsAttributes(String product,String updateAttribute,String updatedText) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		Thread.sleep(3000);
		if(updateAttribute.equalsIgnoreCase("title")) {
			DeletingfromTextBoxandEnteringAnotherText(TitleTextBox,updatedText);	
		}
		else if(updateAttribute.equalsIgnoreCase("description")) {
			DeletingfromTextBoxandEnteringAnotherText(DescriptionTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("product type")) {
			DeletingfromTextBoxandEnteringAnotherText(ProductTypeTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("vendor")) {
			DeletingfromTextBoxandEnteringAnotherText(VendorTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("price")) {
			DeletingfromTextBoxandEnteringAnotherText(PriceTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("inventory")) {
			DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("weight")) {
			DeletingfromTextBoxandEnteringAnotherText(WeightTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("sku")) {
			DeletingfromTextBoxandEnteringAnotherText(SKUTextBox,updatedText);
		}
		else if(updateAttribute.equalsIgnoreCase("barcode")) {
			DeletingfromTextBoxandEnteringAnotherText(BarCodeTextBox,updatedText);
		}
		SaveButton.click();
		Thread.sleep(3000);
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

	public Boolean verifyingUpdate(String updatedtextshop, String updatedtextwal) {
		try {
			Reporter.log("The updated text from shopify is :  "+updatedtextshop);
			Reporter.log("The updated text from walmart is :  "+updatedtextwal);
		Assert.assertEquals(updatedtextwal, updatedtextshop);
		return true;
		}
		catch(AssertionError e) {
			Reporter.log("The product is not updated. Try again");
			return false;
		}
		

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
		else if(variant.equalsIgnoreCase("inventory")) {
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
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,150)");
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
	
	public void selectingImage(String product) throws InterruptedException {
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
		AddFileButton.click();
			try{
		String filepath="";
		   Screen screen=new Screen();
	       Pattern  image1=new Pattern("Give image path here of filename textbox");
	       Pattern  image3=new Pattern("Give image path of submit button");

	    screen.wait(image1,10);
	    screen.type(image1,filepath);
	    screen.click(image3);
	       }
	       catch(Exception e){
	           System.out.println("There is no alert");
	       }
	}
	
	public void disablingAutoProductCreate() throws InterruptedException {
		Settings.click();
		ProductConfigWalmart.click();
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,280)");
		AutoProductCreateDropdown.click();
		AutoProductCreateDropdown_No.click();
		SaveButtonAutoProductCreate.click();
		Thread.sleep(3000);
	}
	
	public void enablingAutoProductCreate() throws InterruptedException {
		Settings.click();
		ProductConfigWalmart.click();
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,280)");
		AutoProductCreateDropdown.click();
		AutoProductCreateDropdown_Yes.click();
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,100)");
		SaveButtonAutoProductCreate.click();
		Thread.sleep(3000);
	}
	
	public void updatingInventoryForVariants(String updatedText) {
		DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,updatedText);
		SaveButton.click();
		
	}
	
	public void selectingForBulkUpdate() throws InterruptedException {
		Products_Shopify.click();
		Thread.sleep(3000);
		AllProductsCheckBox.click();
		Thread.sleep(3000);
		EditProductButton.click();
		Thread.sleep(3000);
		AddFieldsButton.click();
		Thread.sleep(3000);
		
	}
	
	//give field name as in shopify app
	public void selectingAParticularFieldforBulkEditing(String fieldName) throws InterruptedException {
		String field="//span[contains(@class,'next-token__label') and text()='";
		field=field.concat(fieldName);
		field=field.concat("']");
		DriverManager.getDriver().findElement(By.xpath(field)).click();
		Thread.sleep(5000);
	}
	
	
	//if in for loop, take num= i+1
	public void selectingAParticularTextBoxofInventory(String num) {
	String inventoryTextbox="(//input[@class='next-input next-input--number quantity-field no-spinbox'])[";
	inventoryTextbox=inventoryTextbox.concat(num);
	inventoryTextbox=inventoryTextbox.concat("]");
	DriverManager.getDriver().findElement(By.xpath(inventoryTextbox)).click();
	}
	
	//if in for loop, take num= i+2
	public void updatingBulkInventory(String num,String updatedQty) {
	//	(//input[@name='product[variants_attributes][3][inventory_quantity_adjustment]'])[1]
		String invUpdate="(//input[@name='product[variants_attributes][";
		invUpdate=invUpdate.concat(num);
		invUpdate=invUpdate.concat("][inventory_quantity_adjustment]'])[1]");
WebElement Inventory=	DriverManager.getDriver().findElement(By.xpath(invUpdate));
Inventory.click();
Inventory.sendKeys(Keys.END);
Inventory.sendKeys(Keys.LEFT_SHIFT,Keys.HOME,Keys.CLEAR);
Inventory.sendKeys(updatedQty);
Inventory.sendKeys(Keys.ESCAPE);

	
		
	}
	
	public void clickingSaveButtonforBulk() throws InterruptedException {
		SaveButton.click();
		Thread.sleep(3000);
			}
	
	public void selectingProduct(String product) throws InterruptedException{
		Products_Shopify.click();
		FilterProductsTextBox.sendKeys(product);
		Thread.sleep(3000);
		AfterFilterProduct.click();
	}
	
	public void deleteAllProducts() throws InterruptedException {
		Products_Shopify.click();
		Thread.sleep(3000);
		AllProductsCheckBox.click();
		Thread.sleep(3000);
		MoreActionsButton.click();
		Thread.sleep(3000);
		DeleteProductsOption.click();
		Thread.sleep(3000);
	//	DeleteAllProductsButtonOnPopup.click();
			}
	
	public void updatingTags(String updatedText) throws InterruptedException {
		DeletingfromTextBoxandEnteringAnotherText(TagsTextBox,updatedText);
		TagsTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		SaveButton.click();
	}
	
	public void clickingCheckboxforParticularVariantInOrder(String varid) {
		//DriverManager.getDriver().switchTo().defaultContent();
	String varCheck="//input[@id='variant_checkbox_";
	varCheck=varCheck.concat(varid);
	varCheck=varCheck.concat("']");
	DriverManager.getDriver().findElement(By.xpath(varCheck)).click();
	}
	
	public void creatingOrder(String firstletterofProduct,String restOfLetterOfProduct,String varid) throws InterruptedException {
		Orders_Shopify.click();
		Thread.sleep(3000);
		CreateOrderButton.click();
		Thread.sleep(3000);
		SearchProductsTextBoxInOrderPage.sendKeys(firstletterofProduct);
		Thread.sleep(3000);
		SearchProductsTextBoxInOrderPagePopup.sendKeys(restOfLetterOfProduct);
		Thread.sleep(3000);
		clickingCheckboxforParticularVariantInOrder(varid);
		Thread.sleep(3000);
		AddtoOrderButton.click();
		Thread.sleep(7000);
		MarkAsPaidButton.click();
		Thread.sleep(7000);
		CreateOrderButtonAfterPopup.click();
		Thread.sleep(7000);
	}
	
	public void addingVariantforProductHavingVariant(String sizeVal,String colorVal,String quantity) throws InterruptedException {
		AddVariantButtonforProductHavingVariant.click();
		Thread.sleep(3000);
		DeletingfromTextBoxandEnteringAnotherText(SizeTextBox,sizeVal);
		DeletingfromTextBoxandEnteringAnotherText(ColorTextBox,colorVal);
		DeletingfromTextBoxandEnteringAnotherText(QuantityAvailableTextBox,quantity);
		SaveButton.click();
		Thread.sleep(5000);
		
	}
	
	public ArrayList duplicatingSkuOfOneProductToAnother(String variantToduplicateSku) {
		ArrayList<String> varProdId=new ArrayList<String>();
	
	String varid=extractingVariantIdfromUrl();
	extractingUrlAddingDotJsonAndLaunching();
	String json=extractingJsonDataAsStringfromPage();
	String prod_id=	fetchingfromJsonObject(json, "variant", "product_id");
	String sku=fetchingfromJsonObject(json,"variant","sku");
	Reporter.log("Sku is "+sku);
	DriverManager.getDriver().navigate().back();
	selectingVariantProduct(variantToduplicateSku);
	DeletingfromTextBoxandEnteringAnotherText(SKUTextBox,sku);
	SaveButton.click();
	String varid2=extractingVariantIdfromUrl();
	extractingUrlAddingDotJsonAndLaunching();
	String json2=extractingJsonDataAsStringfromPage();
	DriverManager.getDriver().navigate().back();
	varProdId.add(0, prod_id);
	varProdId.add(1, varid2);
	Reporter.log("Product and Variant id are  "+varProdId);
		return varProdId;
	}
	
	public void orderToBeRefunded(String OrderId) throws InterruptedException {
		Orders_Shopify.click();
		Thread.sleep(3000);
		String orderId="//span[contains(text(),'";
		orderId=orderId.concat(OrderId);
		orderId=orderId.concat("')]");
		DriverManager.getDriver().findElement(By.xpath(orderId)).click();
		Thread.sleep(3000);
		RefundLink.click();
		Thread.sleep(3000);
		IncreasingProductCount.click();
		Thread.sleep(3000);
		RefundButton.click();
		Thread.sleep(3000);
	}
	
	public String checkingIfImportLimitReached() throws InterruptedException{
		String s=null;
		label:
			for(int i=0;i<=10;i++) {
		String val=ImportLimitValue.getText().replace("used", "");
	val=val.replace(" ", "");
	String[] limit=val.split("/");
	
	int actualLimit = Integer.valueOf(limit[1]);
	int usedofLimit = Integer.valueOf(limit[0]);
		Reporter.log("Import Limit Values are:     "+Arrays.toString(limit));
		Reporter.log("Actual Limit Value is:     "+actualLimit);
		Reporter.log("Used Limit is:     "+usedofLimit);
		
		 if(usedofLimit==actualLimit) {
			Reporter.log("Import Limit Reached. In This case you have to delete 1 product and add two product");
			 s="LimitReached";
			 break label;
			 		 
		}
		else {
			ImportProducts.click();
			ImportOptions_AllProducts.click();
			ConfirmImportButton.click();
			Dashboard.click();
			RefreshHereDashBoard.click();
			continue label;
		}
			}
		return s;
		}
	//todo
	public void checkingifParticularAttributeisSyncDisabled(String prodId) {
	String url="https://apps.cedcommerce.com/integration/walmart/walmartcustomwork/get-settings-data?id=";
	url=url.concat(prodId);
	DriverManager.getDriver().get(url);
	String json=extractingJsonDataAsStringfromPage();
	
	}
	
	public void gotoManageProducts() {
		Product_Module.click();
		Product_ManageProduct.click();
	}
	
	public void clickingEditButtonForProductsBasedOnProdId(String prodId) {
	String edit="//*[contains(@href,'/integration/walmart/product/editproduct') and @product_id='";
	edit=edit.concat(prodId);
	edit=edit.concat("']");
	DriverManager.getDriver().findElement(By.xpath(edit)).click();
	}
	
	public void disablingOrEnablingSyncForAParticularAttribute(String attribute) {
		ProductSyncing.click();
		switch(attribute) {
		case "title":
			Title_Sync.click();
			break;
		case "sku":
			Sku_Sync.click();
			break;
		case "image":
			Image_Sync.click();
			break;
		case "inventory":
			Inventory_Sync.click();
			break;
		case "weight":
			Weight_Sync.click();
			break;
		case "vendor":
			Vendor_Sync.click();
			break;
		case "barcode":
			Barcode_Sync.click();
			break;
		case "price":
			Price_Sync.click();
			break;
		case "product type":
			ProductType_Sync.click();
			break;
		case "desciption":
			Description_Sync.click();
			break;
		}
		SaveButton_ProductSyncing.click();
		}
	
	public void clickingSyncWithShopifyInProductSyncing() {
		
		SyncWithShopify_ProductSyncing.click();		
		SyncButton.click();
	}
	
	
	
	}
