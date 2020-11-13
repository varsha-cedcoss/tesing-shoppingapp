package TestScripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
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
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import Framework.Custom.DriverManager;
import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import RetryLogic.Retrylogic;
import GoogleIntegration.module.WebHook_Module;

public class WebHook extends commonTest {
	private WebHook_Module webM;


	@BeforeMethod
	public void BeforeMethod() {
		webM=new WebHook_Module();
		webM.LogginginShopify();

	}

//	@DataProviderParams({ "fileName=InputData.csv", "tableName=CreatingNewProduct" })
//	@Test( description = "Verifying new product is created in Google", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
//	public void verifyingNewProductCreatedInGoogle(String title,String description,String prodType,String vendor,String price,String costperitem,String inventory,String weight){
//		webM=new WebHook_Module();
//		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		webM.creatingNewProduct(title, description, prodType, vendor, price, costperitem, inventory, weight);
//		webM.waitFor(3);
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
//		label:
//			for(int i=1;i<=150;i++) {
//				webM.waitFor(5);
//				try {
//					webM.launchGoogleUrlWithProdId("513",prod_id);
//					String jsonwal=webM.extractingJsonDataAsStringfromPage();
//					JsonArray arr=webM.fetchingJsonArray(jsonwal, "product", "variants");
//					Reporter.log("Variant Array  "+arr);
//					if(arr.size()==0) {
//						Reporter.log("No Product Created");
//						continue label;
//					}
//
//					else {
//						Reporter.log("Product Created with product Id:  "+prod_id);
//						break label;
//					}
//				}
//				catch(Exception e) {
//
//					Reporter.log("Some Exception  "+e);
//				}
//			}
//	}

	@DataProviderParams({ "fileName=InputData.csv", "tableName=UpdatingSimpleProductsAttributes" })
	@Test( description = "Verifying if updating  simple product's attributes in shopify,then it also gets updated in Google", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=2)
	public void updatingSimpleProductAttributesandVerifyingInGoogle(String product,String updateAttribute,String updatedText,String googleJsonAttr){
		webM=new WebHook_Module();
		Reporter.log("The parameter which we are updating is : "+updateAttribute);
		String attribute=null;
		Boolean bool=null;
	//	DriverManager.getDriver().findElement(By.xpath("//button[@type='button' and @aria-label='Dismiss this message']")).click();
		webM.updatingSimpleProductsAttributes(product, updateAttribute, updatedText);
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		label:
			for(int i=1;i<=150;i++) {
				webM.waitFor(5);
				webM.launchGoogleUrlWithProdId("13323",prod_id);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();
				if(updateAttribute.equalsIgnoreCase("title") ||updateAttribute.equalsIgnoreCase("description") || updateAttribute.equalsIgnoreCase("product type") || updateAttribute.equalsIgnoreCase("vendor")) {
					attribute=webM.fetchingfromJsonObject(jsonwal, "product",googleJsonAttr ).replace("\"", "");
					bool=webM.verifyingUpdate(updatedText, attribute);
				}
				else if(updateAttribute.equalsIgnoreCase("price") ||updateAttribute.equalsIgnoreCase("inventory") ||updateAttribute.equalsIgnoreCase("sku") ||updateAttribute.equalsIgnoreCase("barcode") || updateAttribute.equalsIgnoreCase("weight")){
					attribute=webM.fetchingfromJsonArray(jsonwal, "product", "variants", googleJsonAttr).replace("\"", "").replace(".00", "");
					bool=webM.verifyingUpdate(updatedText, attribute);
				}
				if(bool.equals(true)) {
					Reporter.log("Product Updated");
					break label;
				}
				else {
					continue label;
				}
			}
		if(bool.equals(true)) {
			Reporter.log("Product Updated");
			
		}
		else {
			Reporter.log("Product not Updated");
			Assert.fail();
		}
		
	}
//
//
//
//	//For Variants
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=UpdatingVariantAttributes" })
//	@Test( description = "Updating parameters for variants and verifying in google", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=3)
//	public void updatingParametersForVariantsandVerifyingInGoogle(String product,String variant,String updateAttribute,String updatedText,String googleJsonAtrribute){
//		webM=new WebHook_Module();
//		Reporter.log("The parameter which we are updating is : "+updateAttribute);
//		Boolean bool=null;
//		webM.productToBeUpdatedforVariants(product);
//		webM.waitFor(3);
//		webM.selectingVariantProduct(variant);
//		String varid=webM.extractingVariantIdfromUrl();
//		webM.variantsToBeUpdated(updateAttribute, updatedText);
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
//		label:
//			for(int i=1;i<=150;i++) {
//				webM.waitFor(5);
//				webM.launchGoogleUrlWithProdId("513",prod_id);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, googleJsonAtrribute).replace("\"", "").replace(".00", "");
//				bool=webM.verifyingUpdate(updatedText, val);
//				if(bool.equals(true)) {
//					Reporter.log("Product Updated");
//					break label;
//				}
//				else {
//					continue label;
//				}
//			}
//		if(bool.equals(true)) {
//			Reporter.log("Product Updated");
//		}
//		else {
//			Reporter.log("Product not Updated");
//			Assert.fail();
//		}
//		
//	}

/*
	@Test(priority=4)
	public void verifyingVariantisAddedforProductWithoutVariant() throws InterruptedException {
		webM=new WebHook_Module();
		webM.addingVariant("pants","Material", "cotton");
		String varid=webM.extractingVariantIdfromUrl();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
		Thread.sleep(20000);
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				webM.launchGoogleUrlWithProdId("513",prod_id);
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

	//option name of size and color is not present in json variant array
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=productAlreadyHavingVariant" })
//	@Test( description = "Verifying variant is added for product already having variant", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=5)
//	public void verifyingAddVariantForProductHavingVariants(String product,String size,String color,String inventory){
//		webM=new WebHook_Module();
//		String val=null;
//		webM.selectingProduct(product);
//		webM.addingVariantforProductHavingVariant(size, color, inventory);
//		String varid=webM.extractingVariantIdfromUrl();
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
//		label:
//			for(int i=1;i<=150;i++) {
//				webM.waitFor(5);
//				webM.launchGoogleUrlWithProdId("513",prod_id);
//				webM.waitFor(3);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "title");
//				if(val==null) {
//					Reporter.log("Added Variant for Product Already having Variant");
//					continue label;
//				}
//				else {
//					break label;
//				}
//			}
//	}
//  sku is duplicating
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=DuplicateSku" })
//	@Test( description = "Verifying sku is not duplicated", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=6)
//	public void verifyingDuplicateSkuUpdate(String product,String variant,String variantToduplicateSku) throws InterruptedException {
//		webM=new WebHook_Module();
//		webM.productToBeUpdatedforVariants(product);
//		webM.waitFor(3);
//		webM.selectingVariantProduct(variant);
//		ArrayList<String> varProdId=webM.duplicatingSkuOfOneProductToAnother(variantToduplicateSku);
//		label:
//			for(int i=1;i<=150;i++) {
//				webM.waitFor(5);
//				webM.launchGoogleUrlWithProdId("13323",varProdId.get(0));
//				webM.waitFor(3);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", (String) varProdId.get(1), "sku");
//				String dupliSku="ced_";
//				dupliSku=dupliSku.concat((String) varProdId.get(1));
//				Reporter.log("MadeBy myself sku is:  "+dupliSku);
//				if(val.equals(dupliSku)) {
//					Reporter.log("Sku  duplicated");
//					break label;
//				}
//				else {
//					Reporter.log("Sku not duplicated. Try Again");
//					continue label;
//				}
//			}
//	}
//
//	//improve this
//	@Test(priority=7)
//	public void verifyingInventoryPolicyandInventoryManagement(){
//		webM=new WebHook_Module();
//		webM.productToBeUpdatedforVariants("jeans");
//		webM.waitFor(2);
//		webM.selectingVariantProduct("33 / Black");
//		webM.waitFor(3);
//		webM.uncheckingTrackQuantityCheckbox();
//		String varid=webM.extractingVariantIdfromUrl();
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
//		webM.waitFor(2);
//		label:
//			for(int i=1;i<=150;i++) {
//				webM.waitFor(5);
//				Boolean bool2=false;
//				Boolean bool1=false;
//				
//				webM.launchGoogleUrlWithProdId("13323",prod_id);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				String invPol=webM.fetchingfromJsonArray(jsonwal, "product", "variants", "inventory_policy").replace("\"", "");
//				try {
//				String invMgmt=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory_management");
//				}
//				catch(Exception e) {
//					bool1=true;
//				}
//				bool2=webM.verifyingUpdate("deny", invPol);
//					if(bool2.equals(true)) {
//						Reporter.log("Product Updated");
//						break label;
//					}
//					else {
//						continue label;
//					}
//				
//				}
//		}
	
//
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=DeleteVariant" })
//	@Test( description = "Verifying deleting a single variant", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=8)
//	public void verifyingDeleteVariant(String product,String varianttobedeleted) throws InterruptedException {
//		webM=new WebHook_Module();
//		webM.productToBeUpdatedforVariants(product);
//		webM.selectingVariantProduct(varianttobedeleted);
//		String varid=webM.extractingVariantIdfromUrl();
//		webM.waitFor(3);
//		webM.deletingVariant();
//		webM.waitFor(3);
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
//		webM.waitFor(5);
//		label:
//			for(int i=0;i<10;i++) {
//				webM.launchGoogleUrlWithProdId("13323",prod_id);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				try {
//					String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "weight");
//				continue label;
//				}
//				catch(Exception e) {
//					Reporter.log("No variant found for the variant id  "+varid);
//					break label;
//				}
//			}
//	}
//
//
//	@Test
//	public void verifyingDeleteProduct(){
//		webM=new WebHook_Module();
//		//Give product name as it is, with uppercases and all
//		String prod_id=webM.deletingProduct("shorts");
//		try {
//			webM.launchGoogleUrlWithProdId("513",prod_id);
//			String jsonwal=webM.extractingJsonDataAsStringfromPage();
//			if(jsonwal.isEmpty()) {
//				Reporter.log("Product Deleted successfully");
//			}
//			else {
//				Reporter.log("Product not Deleted successfully");
//				webM.launchGoogleUrlWithProdId("513",prod_id);
//			}
//		}
//		catch(Exception e) {
//			Reporter.log("No Product Found with Product Id: "+prod_id);
//			Reporter.log("Product Deleted Successfully");
//		}
//
//	}
//
//
//
//
//	//need improvement
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=VariantInventoryPolicyUpdate" })
//	@Test( description = "Verifying variant Inventory policy and Inventory Management", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=11)
//	public void verifyingInventoryPolicyandInventoryManagementForVariants(String product,String variant) throws InterruptedException {
//		webM=new WebHook_Module();
//		webM.productToBeUpdatedforVariants(product);
//		webM.selectingVariantProduct(variant);
//		String varid=webM.extractingVariantIdfromUrl();
//		webM.waitFor(3);
//		webM.uncheckingTrackQuantityCheckbox();
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
//		label:
//			for(int i=1;i<=150;i++) {
//				Boolean bool1=false;
//				webM.launchGoogleUrlWithProdId("13323",prod_id);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				try {
//					String inv_mgmt=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory_management");
//				}
//				catch(Exception e) {
//					Reporter.log("Captured null");
//					bool1=true;
//				}
//				String inv_pol=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory_policy");
//				
//
//				Boolean bool2=webM.verifyingUpdate("deny", inv_pol);
//				if(bool1.equals(true) && bool2.equals(true)) {
//					Reporter.log("Product not Updated");
//					break label;
//				}
//				else {
//					Reporter.log("Product Updated");
//					continue label;
//				}
//			}
//	}
//
//	//here updatingbulkinventory method, xpath is always changing
//	@Test(priority=12)
//	public void verifyingBulkInventoryUpdate(){
//		webM=new WebHook_Module();
//		HashMap<String,String> invtry=new HashMap<String,String>();
//		String val=null;
//		String id=null;
//		HashMap<String,String> invtryWal=new HashMap<String,String>();
//		String idWal=null;
//		String Wal=null;
//		webM.selectingForBulkUpdate();
//		webM.selectingAParticularFieldforBulkEditing("Inventory quantity");
//		String[] arr2= {"Grey","40","Grey","36"};
//		String[] arr1= {"10","15"};
//		for(int i=0;i<arr1.length;i++) {
//			if(i==0) {
//				webM.selectingAParticularTextBoxofInventory(arr2[0],arr2[1]);
//				webM.updatingBulkInventory(arr2[0],arr2[1], arr1[i]);
//			}
//			else if(i==1){
//				webM.selectingAParticularTextBoxofInventory(arr2[2],arr2[3]);
//				webM.updatingBulkInventory(arr2[2],arr2[3], arr1[i]);
//			}
//			
//			webM.waitFor(5);
//		}
//		webM.clickingSaveButtonforBulk();
//		webM.waitFor(7);
//		webM.selectingProduct("Jeans");
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
//		JsonArray arr=webM.fetchingJsonArray(json, "product", "variants");
//		for(int i=0;i<arr.size();i++) {
//			id = arr.get(i).getAsJsonObject().get("id").getAsString();
//			val = arr.get(i).getAsJsonObject().get("inventory_quantity").getAsString();
//			invtry.put(id, val);
//		}
//		Reporter.log("From shopify   "+invtry);
//		label:
//			for(int i=1;i<=100;i++) {
//				webM.waitFor(5);
//				webM.launchGoogleUrlWithProdId("13323",prod_id);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				JsonArray arrJs=webM.fetchingJsonArray(jsonwal, "product", "variants");
//				for(int j=0;j<arrJs.size();j++) {
//					idWal = arrJs.get(j).getAsJsonObject().get("id").getAsString();
//					Wal = arrJs.get(j).getAsJsonObject().get("inventory_quantity").getAsString();
//					invtryWal.put(idWal, Wal);
//				}
//				Reporter.log("From Google  "+invtryWal);
//				if(invtry.equals(invtryWal)) {
//					Reporter.log("Bulk Product Inventory Updated");
//					break label;
//				}
//				else {
//					Reporter.log("Bulk Product Inventory Not Updated");
//					continue label;
//				}
//			}
//		if(invtry.equals(invtryWal)) {
//			Reporter.log("Bulk Product Inventory Updated");
//		}
//		else {
//			Reporter.log("Bulk Product Inventory Not Updated");
//			Assert.fail();
//		}
//	}
//
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=ProductWithExistingProductType" })
//	@Test( description = "Verifying variant Inventory policy and Inventory Management", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=13)
//	public void verifyingCreateProductWithExistingProductType(String title,String description,String prodType,String vendor,String price,String costperitem,String inventory,String weight){
//		webM=new WebHook_Module();
//		webM.creatingNewProduct(title, description, prodType, vendor, price, costperitem, inventory, weight);
//		webM.waitFor(5);
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
//		label:
//			for(int i=1;i<=150;i++) {
//				try {
//					webM.waitFor(5);
//					webM.launchGoogleUrlWithProdId("13323",prod_id);
//					String jsonwal=webM.extractingJsonDataAsStringfromPage();
//					JsonArray arr=webM.fetchingJsonArray(jsonwal, "product", "variants");
//					Reporter.log("Variant Array  "+arr);
//					if(arr.size()==0) {
//						Reporter.log("No Product Created with existing Product Type");
//						continue label;
//					}
//
//					else {
//						Reporter.log("Product Created with product Id:  "+prod_id);
//						break label;
//					}
//				}
//				catch(Exception e) {
//
//					Reporter.log("Some Exception  "+e);
//				}
//			}
//
//	}
//
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=TagsUpdate" })
//	@Test( description = "Verifying tags update for simple products", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=14)
//	public void verifyingTagsUpdateforSimpleProducts(String product,String tags){
//		webM=new WebHook_Module();
//		webM.selectingProduct(product);
//		webM.updatingTags(tags);
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
//		label:
//			for(int i=1;i<=150;i++) {
//				webM.launchGoogleUrlWithProdId("13323",prod_id);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				String tag=webM.fetchingfromJsonObject(jsonwal, "product", "tags");
//				Boolean bool=webM.verifyingUpdate(tags, tag);
//				if(bool.equals(true)) {
//					Reporter.log("Product Updated");
//					break label;
//				}
//				else {
//					continue label;
//				}
//			}
//	}
//
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=CreatingOrderInventoryUpdate" })
//	@Test( description = "Verifying Inventory is updated after creating order", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=15)
//	public void VerifyingUpdateInventoryAfterCreatingOrder(String product,String variant,String firstletterofProduct,String restletterofProduct){
//		webM=new WebHook_Module();
//		webM.productToBeUpdatedforVariants(product);
//		webM.waitFor(3);
//		webM.selectingVariantProduct(variant);
//		String varid=webM.extractingVariantIdfromUrl();
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
//		String originalInventory=	webM.fetchingfromJsonObject(json, "variant", "inventory_quantity");	
//		int oriInv = Integer.parseInt(originalInventory);
//		oriInv=oriInv-1;
//		Reporter.log("The original inventory  after subtracting 1 is :    "+oriInv);
//		webM.creatingOrder(firstletterofProduct,restletterofProduct,varid);
//		label:
//			for(int i=1;i<=150;i++) {
//				webM.waitFor(5);
//				webM.launchGoogleUrlWithProdId("13323",prod_id);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				String inventoryAfterOrder=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory_quantity");
//				int invAfOrder=Integer.parseInt(inventoryAfterOrder);
//				if(invAfOrder==oriInv) {
//					Reporter.log("The update is successfull in WIA");
//					break label;
//				}
//				else {
//					continue label;
//				}
//			}
//	}
//
//	//for this,first create order so that you have order id
//	@DataProviderParams({ "fileName=InputData.csv", "tableName=AfterRefundInventory" })
//	@Test( description = "Verifying after refund inventory is added back to the product", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=16)
//	public void verifyingAfterRefundInventoryStockisAddedBack(String product,String variant,String ordertobeRefunded) throws InterruptedException {
//		webM=new WebHook_Module();
//		webM.productToBeUpdatedforVariants(product);
//		webM.waitFor(3);
//		webM.selectingVariantProduct(variant);
//		String varid=webM.extractingVariantIdfromUrl();
//		webM.extractingUrlAddingDotJsonAndLaunching();
//		String json=webM.extractingJsonDataAsStringfromPage();
//		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
//		String originalInventory=	webM.fetchingfromJsonObject(json, "variant", "inventory_quantity");	
//		int oriInv = Integer.parseInt(originalInventory);
//		oriInv=oriInv+1;
//		Reporter.log("The Original inventory after adding 1 is  "+oriInv);
//		webM.orderToBeRefunded(ordertobeRefunded);
//		label:
//			for(int i=1;i<=150;i++) {
//				webM.launchGoogleUrlWithProdId("13323",prod_id);
//				String jsonwal=webM.extractingJsonDataAsStringfromPage();
//				String inventoryAfterOrder=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory_quantity");
//				int afterInv = Integer.parseInt(inventoryAfterOrder);
//				if(afterInv==oriInv) {
//					Reporter.log("The Inventory Stock is added back.Update is successfull in WIA");
//					break label;
//				}
//				else {
//					continue label;
//				}
//			}
//	}
//

	@Test
	public void shopUpdate() {
		webM=new WebHook_Module();
		webM.goToManageSectionInPaymentSettings();
		/*
		 In selectingACurrency, give the currency that you wanna add
		 */
		
		webM.selectingACurrency("US Dollar");
		webM.waitFor(5);
		label:
			for(int i=0;i<100;i++) {
				webM.launchShopUpdateUrl("13323");
				String json=webM.extractingJsonDataAsStringfromPage();
				JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
				String currencies = jsonObject.getAsJsonObject("shop").get("enabled_presentment_currencies").toString();
				Reporter.log("The currencies are:  "+currencies);
				/*
				 Give abbreviation of the currency in the contains condition below
				 */
				
				if(currencies.contains("USD")){
					Reporter.log("Shop updated");
					break label;
				}
				else {
					Reporter.log("Shop not updated.Try again");
					continue label;
				}
			
			}
		
	}





}
