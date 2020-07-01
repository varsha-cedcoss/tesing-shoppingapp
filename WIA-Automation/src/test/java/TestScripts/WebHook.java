package TestScripts;

import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.test.commonTest;
import walmartIntegration.module.WebHook_Module;

public class WebHook extends commonTest {
	private WebHook_Module webM;
	
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException, IOException {
		webM=new WebHook_Module();
		webM.LogginginShopify();
		
	}
	
	
	  @Test
	public void verifyingNewProductCreatedInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.creatingNewProduct();
		Thread.sleep(3000);
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		try {
			webM.launchWalmartUrlWithProdId(prod_id);
			String jsonwal=webM.extractingJsonDataAsStringfromPage();
			if(jsonwal.isEmpty()) {
				Reporter.log("No Product Created");
			}
			
			else {
				Reporter.log("Product Created with product Id:  "+prod_id);
			}
		}
		catch(Exception e) {
			Reporter.log("No Product created");
		}
			}
	  /*
	@Test
	public void updatingTitleandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.updatingTitle("pant","pantaloo");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String title=webM.fetchingfromJsonObject(jsonwal, "product", "product_title");
webM.verifyingUpdate("pantaloo", title);

	}
	
	@Test
	public void updatingDescriptionandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.updatingDescription("pants","short for men");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String descr=webM.fetchingfromJsonObject(jsonwal, "product", "description");
webM.verifyingUpdate("short for men", descr);

	}
	@Test
	public void updatingProductTypeandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.updatingProductType("pants","short for men");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String prodType=webM.fetchingfromJsonObject(jsonwal, "product", "product_type");
webM.verifyingUpdate("short for men", prodType);

	}
	@Test
	public void updatingVendorandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.updatingVendor("pants","short for men");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String vendor=webM.fetchingfromJsonObject(jsonwal, "product", "vendor");
webM.verifyingUpdate("short for men", vendor);

	}
	@Test
	public void updatingPriceandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.updatingPrice("pants","1400");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String price=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "price");
webM.verifyingUpdate("1400.00", price);

	}
	@Test
	public void updatingInventoryandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.updatingInventory("pants","21");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String quant=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "inventory");
webM.verifyingUpdate("21", quant);

	}
	@Test
	public void updatingWeightandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.updatingWeight("pants","2.9");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String weight=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "weight");
webM.verifyingUpdate("2.9", weight);

	}
	
	@Test
	public void updatingSKUandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.updatingSKU("pant","123455","SKUTextBox");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String sku=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "shopify_sku");
webM.verifyingUpdate("123455", sku);
	}
	
	@Test
	public void updatingBarcodeandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.updatingBarcode("pant","123450987653");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String barcode=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "barcode");
webM.verifyingUpdate("123450987653", barcode);
	}
	
	//For Variants
	@Test
	public void updatingParametersandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		webM.productToBeUpdatedforVariants("Jeans");
		webM.selectingVariantProduct("32 / Grey");
	String varid=webM.extractingVariantIdfromUrl();
	webM.variantsToBeUpdated("size", "36");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "option1");
webM.verifyingUpdate("36", val);
		}
	
	
	@Test
	public void verifyingVariantisAddedforProductWithoutVariant() throws InterruptedException {
		webM=new WebHook_Module();
		webM.addingVariant("pant","Size", "32");
		String varid=webM.extractingVariantIdfromUrl();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
	String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.launchWalmartUrlWithProdId(prod_id);
	String jsonwal=webM.extractingJsonDataAsStringfromPage();
	String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "option1");
	String val2=webM.fetchingfromJsonArray(jsonwal, "product", "options", "name");
	webM.verifyingUpdate("32", val);
	webM.verifyingUpdate("Size", val2);
	}
	
	
	@Test
	public void verifyingInventoryPolicyandInventoryManagement() throws InterruptedException {
		webM=new WebHook_Module();
		webM.productToBeUpdatedforVariants("pant");
		webM.uncheckingTrackQuantityCheckbox();
		String varid=webM.extractingVariantIdfromUrl();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
	String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.launchWalmartUrlWithProdId(prod_id);
	String jsonwal=webM.extractingJsonDataAsStringfromPage();
	String invMgmt=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory_management");
	String invPol=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "inventory_policy");
	webM.verifyingUpdate("shopify", invMgmt);
	webM.verifyingUpdate("deny", invPol);
	}
	
	//Negative Cases
	
	@Test
	public void verifyingIfSyncDisableThenSKUNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingSKU("pant","123450","SKUTextBox");
	webM.extractingUrlAddingDotJsonAndLaunching(); 
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String sku=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "shopify_sku");
	webM.verifyingNotUpdated("123450", sku);
	
	//Again Enabling Sync for next test case
	
	webM.enablingSyncInWalmart();
	
	}
	
	@Test
	public void verifyingIfSyncDisableThenTitleNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingTitle("pants","pantaloon");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String title=webM.fetchingfromJsonObject(jsonwal, "product", "product_title");
webM.verifyingNotUpdated("pantaloon", title);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
	
	}
	
	@Test
	public void verifyingIfSyncDisableThenDescriptionNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingDescription("pants","shorts for men");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String descr=webM.fetchingfromJsonObject(jsonwal, "product", "description");
webM.verifyingNotUpdated("shorts for men", descr);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
	}
	
	@Test
	public void verifyingIfSyncDisableThenProductTypeNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingProductType("pants","shorts for men");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String prodType=webM.fetchingfromJsonObject(jsonwal, "product", "product_type");
webM.verifyingNotUpdated("shorts for men", prodType);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
	}
	
	
	@Test
	public void verifyingIfSyncDisableThenVendorNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingVendor("pants","shorts for men");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String vendor=webM.fetchingfromJsonObject(jsonwal, "product", "vendor");
webM.verifyingNotUpdated("shorts for men", vendor);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
	}
	
	@Test
	public void verifyingIfSyncDisableThenPriceNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingPrice("pants","1700");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String price=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "price");
webM.verifyingNotUpdated("1700", price);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
	}
	
	@Test
	public void verifyingIfSyncDisableThenInventoryNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingInventory("pants","25");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String quant=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "inventory");
webM.verifyingNotUpdated("25", quant);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
	}
	
	
	@Test
	public void verifyingIfSyncDisableThenWeightNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingWeight("pants","2.55");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String weight=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "weight");
webM.verifyingNotUpdated("2.55", weight);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
	}
	
	@Test
	public void verifyingIfSyncDisableThenBarcodeNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingBarcode("pant","123450987656");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String barcode=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "barcode");
webM.verifyingNotUpdated("123450987656", barcode);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
	}
	
	
	
	
	
	
	//pending. after update from shivam sir
	
	@Test
	public void verifyingIfSyncDisableThenVariantNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.productToBeUpdatedforVariants("Jeans");
	webM.selectingVariantProduct("32 / Green");
String varid=webM.extractingVariantIdfromUrl();
webM.variantsToBeUpdated("size", "36");
webM.extractingUrlAddingDotJsonAndLaunching();
String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "option1");
webM.verifyingNotUpdated("36", val);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
}
	
	@Test
	public void verifyingDeleteVariant() throws InterruptedException {
		webM=new WebHook_Module();
		webM.productToBeUpdatedforVariants("Jeans");
		webM.selectingVariantProduct("32 / Green");
		String varid=webM.extractingVariantIdfromUrl();
		webM.deletingVariant();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		webM.launchWalmartUrlWithProdId(prod_id);
		String jsonwal=webM.extractingJsonDataAsStringfromPage();
		try {
		String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "weight");}
		catch(Exception e) {
			Reporter.log("No variant found for the variant id  "+varid);
		}
		}
		
	
	@Test
	public void verifyingDeleteProduct() throws InterruptedException {
		webM=new WebHook_Module();
		//Give product name as it is, with uppercases and all
	String prod_id=webM.deletingProduct("Shorts");
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	try {
		webM.launchWalmartUrlWithProdId(prod_id);
		String jsonwal=webM.extractingJsonDataAsStringfromPage();
		if(jsonwal.isEmpty()) {
			Reporter.log("Product Deleted successfully");
		}
		else {
			Reporter.log("Product not Deleted successfully");
			Thread.sleep(10000);
			webM.launchWalmartUrlWithProdId(prod_id);
		}
	}
	catch(Exception e) {
		Reporter.log("No Product Found with Product Id: "+prod_id);
		Reporter.log("Product Deleted Successfully");
	}
	
	}*/
	
	@AfterMethod
	public void aftermethod() {
		DriverManager.getDriver().quit();
	}
	
}
