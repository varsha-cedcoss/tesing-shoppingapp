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
	
	/*
	  @Test(priority=1)
	public void verifyingNewProductCreatedInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.creatingNewProduct();
		Thread.sleep(20000);
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
		 
			}*/
	  /*
	@Test(priority=2)
	public void updatingTitleandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 webM.updatingTitle("crabs","pants");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String title=webM.fetchingfromJsonObject(jsonwal, "product", "product_title");
Boolean bool=webM.verifyingUpdate("pants", title);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
 	}

	
	@Test(priority=3)
	public void updatingDescriptionandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.updatingDescription("pant","short for men");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String descr=webM.fetchingfromJsonObject(jsonwal, "product", "description");
Boolean bool=webM.verifyingUpdate("short for men", descr);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
 	}
	
	
	@Test(priority=4)
	public void updatingProductTypeandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.updatingProductType("pants","short for men");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String prodType=webM.fetchingfromJsonObject(jsonwal, "product", "product_type");
Boolean bool=webM.verifyingUpdate("short for men", prodType);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
 	}
	
	
	@Test(priority=5)
	public void updatingVendorandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.updatingVendor("pants","short for men");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String vendor=webM.fetchingfromJsonObject(jsonwal, "product", "vendor");
Boolean bool=webM.verifyingUpdate("short for men", vendor);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	} 
	}
	
	
	@Test(priority=6)
	public void updatingPriceandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.updatingPrice("pants","1700");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String price=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "price");
Boolean bool=webM.verifyingUpdate("1700", price);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
	}
	
	
	@Test(priority=7)
	public void updatingInventoryandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.updatingInventory("pants","21");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String quant=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "inventory");
Boolean bool=webM.verifyingUpdate("21", quant);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
	}
	
	
	@Test(priority=8)
	public void updatingWeightandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.updatingWeight("pants","2.9");
	String weightInPound=webM.convertingToPoundandRoundingOffto5DecPlace("2.9");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String weight=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "weight");
Boolean bool=webM.verifyingUpdate(weightInPound, weight);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
 
	}*/
	/*
	@Test(priority=9)
	public void updatingSKUandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.updatingSKU("pant","123455","SKUTextBox");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String sku=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "shopify_sku");
Boolean bool=webM.verifyingUpdate("123455", sku);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
 
	}
	
	@Test(priority=10)
	public void updatingBarcodeandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.updatingBarcode("pant","123450987645");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String barcode=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "barcode");
Boolean bool=webM.verifyingUpdate("123450987645", barcode);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
 
	}
	
	//For Variants
	@Test(priority=11)
	public void updatingParametersandVerifyingInWalmart() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.productToBeUpdatedforVariants("Jeans");
		webM.selectingVariantProduct("34 / Grey");
	String varid=webM.extractingVariantIdfromUrl();
	webM.variantsToBeUpdated("price", "1100");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
label:
	for(int i=1;i<=10;i++) {
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "price");
Boolean bool=webM.verifyingUpdate("1100", val);
if(bool.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
		}
	
	
	@Test(priority=12)
	public void verifyingVariantisAddedforProductWithoutVariant() throws InterruptedException {
		webM=new WebHook_Module();
		webM.addingVariant("pant","Material", "cotton");
		String varid=webM.extractingVariantIdfromUrl();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
	String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
	Thread.sleep(20000);
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	label:
		for(int i=1;i<=10;i++) {
	webM.launchWalmartUrlWithProdId(prod_id);
	String jsonwal=webM.extractingJsonDataAsStringfromPage();
	String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "title");
	String val2=webM.fetchingfromJsonArray(jsonwal, "product", "options", "option_name");
Boolean bool1=webM.verifyingUpdate("cotton", val);
Boolean bool2=webM.verifyingUpdate("Material", val2);
if(bool1.equals(true) && bool2.equals(true)) {
	Reporter.log("Product Updated");
	break label;
}
else {
	continue label;
}
	}
	 
	}*/
	
	/*
	@Test(priority=13)
	public void verifyingInventoryPolicyandInventoryManagement() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.productToBeUpdatedforVariants("jeans");
		webM.uncheckingTrackQuantityCheckbox();
		String varid=webM.extractingVariantIdfromUrl();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
	String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
	Thread.sleep(20000);
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	label:
		for(int i=1;i<=10;i++) {
	webM.launchWalmartUrlWithProdId(prod_id);
	String jsonwal=webM.extractingJsonDataAsStringfromPage();
	String invMgmt=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory_management");
	String invPol=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "inventory_policy");
Boolean bool1=webM.verifyingUpdate("null", invMgmt);
	Boolean bool2=webM.verifyingUpdate("deny", invPol);
	if(bool1.equals(true) && bool2.equals(true)) {
		Reporter.log("Product Updated");
		break label;
	}
	else {
		continue label;
	}
		}
	 
	}
	
	//Negative Cases
	
	@Test(priority=14)
	public void verifyingIfSyncDisableThenSKUNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
		 
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingSKU("pant","456789","SKUTextBox");
	webM.extractingUrlAddingDotJsonAndLaunching(); 
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String sku=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "shopify_sku");
	webM.verifyingNotUpdated("456789", sku);
	
	//Again Enabling Sync for next test case
	
	webM.enablingSyncInWalmart();
	Thread.sleep(5000);
	 
	}
	
	@Test(priority=15)
	public void verifyingIfSyncDisableThenTitleNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
		 
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingTitle("pants","crabs");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String title=webM.fetchingfromJsonObject(jsonwal, "product", "product_title");
webM.verifyingNotUpdated("crabs", title);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
Thread.sleep(5000);
 
	}
	
	@Test(priority=16)
	public void verifyingIfSyncDisableThenDescriptionNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
		 
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingDescription("pants","shortsy for men");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String descr=webM.fetchingfromJsonObject(jsonwal, "product", "description");
webM.verifyingNotUpdated("shortsy for men", descr);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
Thread.sleep(5000);
 
	}
	
	@Test(priority=17)
	public void verifyingIfSyncDisableThenProductTypeNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
		 
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingProductType("pants","shortsy for men");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String prodType=webM.fetchingfromJsonObject(jsonwal, "product", "product_type");
webM.verifyingNotUpdated("shortsy for men", prodType);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
Thread.sleep(5000);
 
	}
	
	
	@Test(priority=18)
	public void verifyingIfSyncDisableThenVendorNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
		 
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingVendor("pants","shortsy for men");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String vendor=webM.fetchingfromJsonObject(jsonwal, "product", "vendor");
webM.verifyingNotUpdated("shortsy for men", vendor);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
Thread.sleep(5000);
 
	}
	
	@Test(priority=19)
	public void verifyingIfSyncDisableThenPriceNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
		 
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingPrice("pants","2500");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String price=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "price");
webM.verifyingNotUpdated("2500", price);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
Thread.sleep(5000);
 
	}
	
	@Test(priority=20)
	public void verifyingIfSyncDisableThenInventoryNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
		 
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingInventory("pants","59");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String quant=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "inventory");
webM.verifyingNotUpdated("59", quant);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
Thread.sleep(5000);
 
	}
	
	
	@Test(priority=21)
	public void verifyingIfSyncDisableThenWeightNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
		 
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingWeight("pants","3.66");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String weight=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "weight");
webM.verifyingNotUpdated("3.66", weight);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
Thread.sleep(5000);
 
	}
	
	@Test(priority=22)
	public void verifyingIfSyncDisableThenBarcodeNotUpdating() throws InterruptedException {
		webM=new WebHook_Module();
		 
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingSyncInWalmart();
	DriverManager.getDriver().close();
	webM.switchingtoTab(0);
	webM.updatingBarcode("pant","654987365425");
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String barcode=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "barcode");
webM.verifyingNotUpdated("654987365425", barcode);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
Thread.sleep(5000);
 
	}
	
	
	*/
	
	
/*	//pending. after update from shivam sir
	
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
Thread.sleep(20000);
webM.goToWalmartIntegrationApp();
webM.switchingtoTab(1);
webM.launchWalmartUrlWithProdId(prod_id);
String jsonwal=webM.extractingJsonDataAsStringfromPage();
String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "option1");
webM.verifyingNotUpdated("36", val);
//Again Enabling Sync for next test case
webM.enablingSyncInWalmart();
}
	
	@Test(priority=23)
	public void verifyingDeleteVariant() throws InterruptedException {
		webM=new WebHook_Module();
		 
		webM.productToBeUpdatedforVariants("Jeans");
		webM.selectingVariantProduct("32 / Grey");
		String varid=webM.extractingVariantIdfromUrl();
		webM.deletingVariant();
		Thread.sleep(3000);
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		Thread.sleep(20000);
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		webM.launchWalmartUrlWithProdId(prod_id);
		String jsonwal=webM.extractingJsonDataAsStringfromPage();
		try {
		String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "weight");}
		catch(Exception e) {
			Reporter.log("No variant found for the variant id  "+varid);
		}
		Thread.sleep(5000);
		 
		}*/
	/*
	
	@Test(priority=24)
	public void verifyingDeleteProduct() throws InterruptedException {
		webM=new WebHook_Module();
		 
		//Give product name as it is, with uppercases and all
	String prod_id=webM.deletingProduct("dsg");
	Thread.sleep(20000);
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
			Thread.sleep(20000);
			webM.launchWalmartUrlWithProdId(prod_id);
		}
	}
	catch(Exception e) {
		Reporter.log("No Product Found with Product Id: "+prod_id);
		Reporter.log("Product Deleted Successfully");
	}
	Thread.sleep(5000);
	 
	}*/
	
	
	@Test
	public void VerifyingImageUpdate() throws InterruptedException {
		webM=new WebHook_Module();
		webM.selectingImage("pants");
	}
	
	
//	@AfterMethod
//	public void aftermethod() throws InterruptedException {
//		Thread.sleep(5000);
//		 DriverManager.getDriver().quit();
//	}
	
}
