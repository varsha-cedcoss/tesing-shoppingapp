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
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import Framework.Custom.DriverManager;
import Framework.DataReader.DataProviderParams;
import Framework.DataReader.DataReaderUtil;
import Framework.GUI.commons.test.commonTest;
import RetryLogic.Retrylogic;
import walmartIntegration.module.WebHook_Module;

public class WebHook extends commonTest {
	private WebHook_Module webM;


	@BeforeMethod
	public void BeforeMethod() throws InterruptedException, IOException {
		webM=new WebHook_Module();
		webM.LogginginShopify();

	}

	@DataProviderParams({ "fileName=InputData.csv", "tableName=CreatingNewProduct" })
	@Test( description = "Verifying new product is created in Walmart", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=1)
	public void verifyingNewProductCreatedInWalmart(String title,String description,String prodType,String vendor,String price,String costperitem,String inventory,String weight) throws InterruptedException {
		webM=new WebHook_Module();

		webM.creatingNewProduct(title, description, prodType, vendor, price, costperitem, inventory, weight);
		Thread.sleep(20000);
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();

		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				Thread.sleep(5000);
				try {
					webM.launchWalmartUrlWithProdId(prod_id);
					String jsonwal=webM.extractingJsonDataAsStringfromPage();
					JsonArray arr=webM.fetchingJsonArray(jsonwal, "product", "variants");
					Reporter.log("Variant Array  "+arr);

					if(arr.size()==0) {
						Reporter.log("No Product Created");
						continue label;
					}

					else {
						Reporter.log("Product Created with product Id:  "+prod_id);
						break label;
					}
				}
				catch(Exception e) {

					Reporter.log("Some Exception  "+e);
				}
			}
	}

	@DataProviderParams({ "fileName=InputData.csv", "tableName=UpdatingSimpleProductsAttributes" })
	@Test( description = "Verifying if updating  simple product's attributes in shopify,then it also gets updated in Walmart", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=2)
	public void updatingSimpleProductAttributesandVerifyingInWalmart(String product,String updateAttribute,String updatedText,String walmartJsonAttr) throws InterruptedException {
		webM=new WebHook_Module();
		Reporter.log("The parameter which we are updating is : "+updateAttribute);
		String updatedweight=null;
		String attribute=null;
		Boolean bool=null;
		webM.updatingSimpleProductsAttributes(product, updateAttribute, updatedText);
		if(updateAttribute.equalsIgnoreCase("weight")) {
			updatedweight= webM.convertingToPoundandRoundingOffto5DecPlace(updatedText);}
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				Thread.sleep(5000);
				webM.launchWalmartUrlWithProdId(prod_id);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();

				if(updateAttribute.equalsIgnoreCase("title") ||updateAttribute.equalsIgnoreCase("description") || updateAttribute.equalsIgnoreCase("product type") || updateAttribute.equalsIgnoreCase("vendor")) {
					attribute=webM.fetchingfromJsonObject(jsonwal, "product",walmartJsonAttr );
					bool=webM.verifyingUpdate(updatedText, attribute);
				}
				else if(updateAttribute.equalsIgnoreCase("price") ||updateAttribute.equalsIgnoreCase("inventory") ||updateAttribute.equalsIgnoreCase("sku") ||updateAttribute.equalsIgnoreCase("barcode") ){
					attribute=webM.fetchingfromJsonArray(jsonwal, "product", "variants", walmartJsonAttr);
					bool=webM.verifyingUpdate(updatedText, attribute);
				}

				else if(updateAttribute.equalsIgnoreCase("weight")) {
					attribute=webM.fetchingfromJsonArray(jsonwal, "product", "variants", walmartJsonAttr);
					bool=webM.verifyingUpdate(updatedweight, attribute);
				}

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
	@DataProviderParams({ "fileName=InputData.csv", "tableName=UpdatingVariantAttributes" })
	@Test( description = "clicking all options", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=3)
	public void updatingParametersForVariantsandVerifyingInWalmart(String product,String variant,String updateAttribute,String updatedText,String walmartJsonAtrribute) throws InterruptedException {
		webM=new WebHook_Module();
		Reporter.log("The parameter which we are updating is : "+updateAttribute);
		String updatedweight=null;
		Boolean bool=null;
		webM.productToBeUpdatedforVariants(product);
		webM.selectingVariantProduct(variant);
		String varid=webM.extractingVariantIdfromUrl();
		webM.variantsToBeUpdated(updateAttribute, updatedText);
		if(updateAttribute.equalsIgnoreCase("weight")) {
			updatedweight= webM.convertingToPoundandRoundingOffto5DecPlace(updatedText);
		}
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				Thread.sleep(5000);
				webM.launchWalmartUrlWithProdId(prod_id);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();
				String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, walmartJsonAtrribute);
				if(updateAttribute.equalsIgnoreCase("weight")) {
					bool=webM.verifyingUpdate(updatedweight, val);
				}
				else {
					bool=webM.verifyingUpdate(updatedText, val);
				}
				if(bool.equals(true)) {
					Reporter.log("Product Updated");
					break label;
				}
				else {
					continue label;
				}
			}
	}

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

	//option name of size and color is not present in json variant array
	@DataProviderParams({ "fileName=InputData.csv", "tableName=productAlreadyHavingVariant" })
	@Test( description = "Verifying variant is added for product already having variant", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=5)
	public void verifyingAddVariantForProductHavingVariants(String product,String size,String color,String inventory) throws InterruptedException {
		webM=new WebHook_Module();
		String val=null;
		webM.selectingProduct(product);
		webM.addingVariantforProductHavingVariant(size, color, inventory);
		String varid=webM.extractingVariantIdfromUrl();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				Thread.sleep(5000);

				webM.launchWalmartUrlWithProdId(prod_id);
				Thread.sleep(3000);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();
				val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "title");



				if(val==null) {
					Reporter.log("Added Variant for Product Already having Variant");
					continue label;
				}
				else {
					break label;
				}
			}
	}

	@DataProviderParams({ "fileName=InputData.csv", "tableName=DuplicateSku" })
	@Test( description = "Verifying sku is not duplicated", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=6)
	public void verifyingDuplicateSkuUpdate(String product,String variant,String variantToduplicateSku) throws InterruptedException {
		webM=new WebHook_Module();
		webM.productToBeUpdatedforVariants(product);
		webM.selectingVariantProduct(variant);
		ArrayList varProdId=webM.duplicatingSkuOfOneProductToAnother(variantToduplicateSku);
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				webM.launchWalmartUrlWithProdId((String) varProdId.get(0));
				Thread.sleep(3000);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();
				String val=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", (String) varProdId.get(1), "sku");
				String dupliSku="ced_";
				dupliSku=dupliSku.concat((String) varProdId.get(1));
				Reporter.log("MadeBy myself sku is:  "+dupliSku);
				if(val.equals(dupliSku)) {
					Reporter.log("Sku  duplicated");
					break label;
				}
				else {
					Reporter.log("Sku not duplicated. Try Again");
					continue label;
				}
			}
	}

	//improve this
	@Test(priority=7)
	public void verifyingInventoryPolicyandInventoryManagement() throws InterruptedException {
		webM=new WebHook_Module();

		webM.productToBeUpdatedforVariants("jeans");
		webM.selectingVariantProduct("33 / Black");
		webM.uncheckingTrackQuantityCheckbox();
		String varid=webM.extractingVariantIdfromUrl();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
		Thread.sleep(20000);
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				Thread.sleep(5000);
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

	@DataProviderParams({ "fileName=InputData.csv", "tableName=DeleteVariant" })
	@Test( description = "Verifying deleting a single variant", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=8)
	public void verifyingDeleteVariant(String product,String varianttobedeleted) throws InterruptedException {
		webM=new WebHook_Module();

		webM.productToBeUpdatedforVariants(product);
		webM.selectingVariantProduct(varianttobedeleted);
		String varid=webM.extractingVariantIdfromUrl();
		webM.deletingVariant();
		Thread.sleep(3000);
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		Thread.sleep(5000);
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

	}


	@Test( description = "Verifying deleting a single product", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=9)
	public void verifyingDeleteProduct() throws InterruptedException {
		webM=new WebHook_Module();

		//Give product name as it is, with uppercases and all
		String prod_id=webM.deletingProduct("shortss");
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
				webM.launchWalmartUrlWithProdId(prod_id);
			}
		}
		catch(Exception e) {
			Reporter.log("No Product Found with Product Id: "+prod_id);
			Reporter.log("Product Deleted Successfully");
		}
		Thread.sleep(5000);

	}




	//need improvement
	@DataProviderParams({ "fileName=InputData.csv", "tableName=VariantInventoryPolicyUpdate" })
	@Test( description = "Verifying variant Inventory policy and Inventory Management", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=11)
	public void verifyingInventoryPolicyandInventoryManagementForVariants(String product,String variant) throws InterruptedException {
		webM=new WebHook_Module();
		webM.productToBeUpdatedforVariants(product);
		webM.selectingVariantProduct(variant);
		String varid=webM.extractingVariantIdfromUrl();
		webM.uncheckingTrackQuantityCheckbox();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				webM.launchWalmartUrlWithProdId(prod_id);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();
				String inv_pol=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory_policy");
				String inv_mgmt=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory_management");
				Boolean bool1=webM.verifyingUpdate("null", inv_mgmt);
				Boolean bool2=webM.verifyingUpdate("deny", inv_pol);
				if(bool1.equals(true) && bool2.equals(true)) {
					Reporter.log("Product Updated");
					break label;
				}
				else {
					continue label;
				}
			}
	}

	//here updatingbulkinventory method, xpath is always changing
	@Test(priority=12)
	public void verifyingBulkInventoryUpdate() throws InterruptedException {
		webM=new WebHook_Module();
		HashMap<String,String> invtry=new HashMap<String,String>();
		String val=null;
		String id=null;
		HashMap<String,String> invtryWal=new HashMap<String,String>();
		String idWal=null;
		String Wal=null;
		webM.selectingForBulkUpdate();
		webM.selectingAParticularFieldforBulkEditing("Inventory quantity");
		String[] arr1= {"10","15"};
		for(int i=0;i<arr1.length;i++) {
			String s=String.valueOf(i+1);
			webM.selectingAParticularTextBoxofInventory(s);
			String s2=String.valueOf(i);
			webM.updatingBulkInventory(s2, arr1[i]);
			Thread.sleep(2000);
		}
		webM.clickingSaveButtonforBulk();
		Thread.sleep(7000);
		webM.selectingProduct("Jeans");
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		JsonArray arr=webM.fetchingJsonArray(json, "product", "variants");
		for(int i=0;i<arr.size();i++) {
			id = arr.get(i).getAsJsonObject().get("id").getAsString();
			val = arr.get(i).getAsJsonObject().get("inventory_quantity").getAsString();
			invtry.put(id, val);
		}
		Reporter.log(""+invtry);

		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				webM.launchWalmartUrlWithProdId(prod_id);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();
				JsonArray arr2=webM.fetchingJsonArray(jsonwal, "product", "variants");
				for(int j=0;j<arr2.size();j++) {
					idWal = arr2.get(j).getAsJsonObject().get("id").getAsString();
					Wal = arr2.get(j).getAsJsonObject().get("inventory").getAsString();
					invtryWal.put(idWal, Wal);
				}
				Reporter.log(""+invtryWal);
				if(invtry.equals(invtryWal)) {
					Reporter.log("Bulk Product Inventory Updated");
					break label;
				}
				else {
					continue label;
				}
			}
	}

	@DataProviderParams({ "fileName=InputData.csv", "tableName=ProductWithExistingProductType" })
	@Test( description = "Verifying variant Inventory policy and Inventory Management", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=13)
	public void verifyingCreateProductWithExistingProductType(String title,String description,String prodType,String vendor,String price,String costperitem,String inventory,String weight) throws InterruptedException {
		webM=new WebHook_Module();
		webM.creatingNewProduct(title, description, prodType, vendor, price, costperitem, inventory, weight);
		Thread.sleep(5000);
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				try {
					webM.launchWalmartUrlWithProdId(prod_id);
					String jsonwal=webM.extractingJsonDataAsStringfromPage();
					JsonArray arr=webM.fetchingJsonArray(jsonwal, "product", "variants");
					Reporter.log("Variant Array  "+arr);
					if(arr.size()==0) {
						Reporter.log("No Product Created with existing Product Type");
						continue label;
					}

					else {
						Reporter.log("Product Created with product Id:  "+prod_id);
						break label;
					}
				}
				catch(Exception e) {

					Reporter.log("Some Exception  "+e);
				}
			}

	}

	@DataProviderParams({ "fileName=InputData.csv", "tableName=TagsUpdate" })
	@Test( description = "Verifying tags update for simple products", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=14)
	public void verifyingTagsUpdateforSimpleProducts(String product,String tags) throws InterruptedException {
		webM=new WebHook_Module();
		webM.selectingProduct(product);
		webM.updatingTags(tags);
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				webM.launchWalmartUrlWithProdId(prod_id);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();
				String tag=webM.fetchingfromJsonObject(jsonwal, "product", "tags");
				Boolean bool=webM.verifyingUpdate(tags, tag);
				if(bool.equals(true)) {
					Reporter.log("Product Updated");
					break label;
				}
				else {
					continue label;
				}
			}
	}

	@DataProviderParams({ "fileName=InputData.csv", "tableName=CreatingOrderInventoryUpdate" })
	@Test( description = "Verifying Inventory is updated after creating order", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=15)
	public void VerifyingUpdateInventoryAfterCreatingOrder(String product,String variant,String firstletterofProduct,String restletterofProduct) throws InterruptedException {
		webM=new WebHook_Module();
		webM.productToBeUpdatedforVariants(product);
		webM.selectingVariantProduct(variant);
		String varid=webM.extractingVariantIdfromUrl();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
		String originalInventory=	webM.fetchingfromJsonObject(json, "variant", "inventory_quantity");	
		int oriInv = Integer.parseInt(originalInventory);
		oriInv=oriInv-1;
		Reporter.log("The original inventory  after subtracting 1 is :    "+oriInv);
		webM.creatingOrder(firstletterofProduct,restletterofProduct,varid);
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				webM.launchWalmartUrlWithProdId(prod_id);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();
				String inventoryAfterOrder=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory");
				int invAfOrder=Integer.parseInt(inventoryAfterOrder);
				if(invAfOrder==oriInv) {
					Reporter.log("The update is successfull in WIA");
					break label;
				}
				else {
					continue label;
				}
			}
	}

	//for this,first create order so that you have order id
	@DataProviderParams({ "fileName=InputData.csv", "tableName=AfterRefundInventory" })
	@Test( description = "Verifying after refund inventory is added back to the product", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=16)
	public void verifyingAfterRefundInventoryStockisAddedBack(String product,String variant,String ordertobeRefunded) throws InterruptedException {
		webM=new WebHook_Module();
		webM.productToBeUpdatedforVariants(product);
		webM.selectingVariantProduct(variant);
		String varid=webM.extractingVariantIdfromUrl();
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "variant", "product_id");
		String originalInventory=	webM.fetchingfromJsonObject(json, "variant", "inventory_quantity");	
		int oriInv = Integer.parseInt(originalInventory);
		oriInv=oriInv+1;
		Reporter.log("The Original inventory after adding 1 is  "+oriInv);
		webM.orderToBeRefunded(ordertobeRefunded);
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=150;i++) {
				webM.launchWalmartUrlWithProdId(prod_id);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();
				String inventoryAfterOrder=webM.fetchingfromJsonArrayofVariantsBasedonVariantId(jsonwal, "product", "variants", varid, "inventory");
				int afterInv = Integer.parseInt(inventoryAfterOrder);
				if(afterInv==oriInv) {
					Reporter.log("The Inventory Stock is added back.Update is successfull in WIA");
					break label;
				}
				else {
					continue label;
				}
			}
	}

	//Negative Cases

	@DataProviderParams({ "fileName=InputData.csv", "tableName=SyncDisableNotUpdating" })
	@Test( description = "Verifying if Sync is disabled,then attribute is not updating in walmart", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=17)
	public void verifyingIfSyncDisableThenNotUpdating(String product,String updateAttribute,String updatedText,String walmartJsonAtrribute) throws InterruptedException {
		webM=new WebHook_Module();
		String attribute=null;
		String updatedweight=null;
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		webM.disablingSyncInWalmart();
		DriverManager.getDriver().close();
		webM.switchingtoTab(0);
		webM.updatingSimpleProductsAttributes(product, updateAttribute, updatedText);
		if(updateAttribute.equalsIgnoreCase("weight")) {
			updatedweight= webM.convertingToPoundandRoundingOffto5DecPlace(updatedText);}
		webM.extractingUrlAddingDotJsonAndLaunching(); 
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");

		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		webM.launchWalmartUrlWithProdId(prod_id);
		String jsonwal=webM.extractingJsonDataAsStringfromPage();
		if(updateAttribute.equalsIgnoreCase("title") ||updateAttribute.equalsIgnoreCase("description") || updateAttribute.equalsIgnoreCase("product type") || updateAttribute.equalsIgnoreCase("vendor")) {
			attribute=webM.fetchingfromJsonObject(jsonwal, "product",walmartJsonAtrribute );
			webM.verifyingNotUpdated(updatedText, attribute);
		}
		else if(updateAttribute.equalsIgnoreCase("price") ||updateAttribute.equalsIgnoreCase("inventory") ||updateAttribute.equalsIgnoreCase("sku") ||updateAttribute.equalsIgnoreCase("barcode") ){
			attribute=webM.fetchingfromJsonArray(jsonwal, "product", "variants", walmartJsonAtrribute);
			webM.verifyingNotUpdated(updatedText, attribute);
		}

		else if(updateAttribute.equalsIgnoreCase("weight")) {
			attribute=webM.fetchingfromJsonArray(jsonwal, "product", "variants", walmartJsonAtrribute);
			webM.verifyingNotUpdated(updatedweight, attribute);
		}


		//Again Enabling Sync for next test case

		webM.enablingSyncInWalmart();
		Thread.sleep(5000);

	}
	
	//pending. after update from shivam sir

	 @DataProviderParams({ "fileName=InputData.csv", "tableName=SyncDisableNotUpdating" })
	 @Test( description = "Verifying if Sync is disabled,then attribute is not updating in walmart", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider")
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






/*
	@Test
	public void VerifyingImageUpdate() throws InterruptedException {
		webM=new WebHook_Module();
		webM.selectingImage("pants");
	}








	@Test
	public void deletingAllProducts() throws InterruptedException {
		webM=new WebHook_Module();
		webM.deleteAllProducts();
	}
	 */


	

	@DataProviderParams({ "fileName=InputData.csv", "tableName=CreatingNewProduct" })
    @Test( description = "Verifying no product is created on walmart when Auto Product Create is disabled", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=18)
public void verifyingNoProductCreatedWhenAutoProductCreateIsOff(String title,String description,String prodType,String vendor,String price,String costperitem,String inventory,String weight) throws InterruptedException {
	webM=new WebHook_Module();
	webM.goToWalmartIntegrationApp();
	webM.switchingtoTab(1);
	webM.disablingAutoProductCreate();
	webM.switchingtoTab(0);
	webM.creatingNewProduct(title, description, prodType, vendor, price, costperitem, inventory, weight);
	Thread.sleep(3000);
	webM.extractingUrlAddingDotJsonAndLaunching();
	String json=webM.extractingJsonDataAsStringfromPage();
	String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
	webM.switchingtoTab(1);
	Thread.sleep(10000);
	webM.launchWalmartUrlWithProdId(prod_id);
	String jsonwal=webM.extractingJsonDataAsStringfromPage();
	JsonArray arr=webM.fetchingJsonArray(jsonwal, "product", "variants");
		Reporter.log("Variant Array  "+arr);
		if(arr.size()==0) {
			Reporter.log("No Product Created");
									}
		else {
			Reporter.log("Product Created with product Id:  "+prod_id);
			Reporter.log("Error here as Auto Product is disabled, so Product should not have been created");
		}
		DriverManager.getDriver().navigate().back();
		webM.enablingAutoProductCreate();
}







	@DataProviderParams({ "fileName=InputData.csv", "tableName=ParticularAttributeSyncing" })
    @Test( description = "Verifying if Sync is disabled for a particular attribute of a particular product, then no update should happen", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=19)
	public void verifyingIfSyncDisabledForAParticularAttributeThenNotUpdating(String product,String attributeSync,String updatedText,String walmartJsonAttr) throws InterruptedException {
		webM=new WebHook_Module();
		Boolean bool=null;
		String attribute=null;
		String updatedweight=null;
		webM.selectingProduct(product);
		webM.extractingUrlAddingDotJsonAndLaunching();
		String json=webM.extractingJsonDataAsStringfromPage();
		String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		webM.gotoManageProducts();
		webM.clickingEditButtonForProductsBasedOnProdId(prod_id);
		webM.disablingOrEnablingSyncForAParticularAttribute(attributeSync);
		webM.switchingtoTab(0);
		webM.updatingSimpleProductsAttributes(product, attributeSync, updatedText);
		if(attributeSync.equalsIgnoreCase("weight")) {
			updatedweight= webM.convertingToPoundandRoundingOffto5DecPlace(updatedText);}
		webM.switchingtoTab(1);
		label:
			for(int i=1;i<=10;i++) {

				webM.launchWalmartUrlWithProdId(prod_id);
				String jsonwal=webM.extractingJsonDataAsStringfromPage();

				if(attributeSync.equalsIgnoreCase("title") ||attributeSync.equalsIgnoreCase("description") || attributeSync.equalsIgnoreCase("product type") || attributeSync.equalsIgnoreCase("vendor")) {
					 attribute=webM.fetchingfromJsonObject(jsonwal, "product",walmartJsonAttr );
					 bool=webM.verifyingUpdate(updatedText, attribute);
				}
				else if(attributeSync.equalsIgnoreCase("price") ||attributeSync.equalsIgnoreCase("inventory") ||attributeSync.equalsIgnoreCase("sku") ||attributeSync.equalsIgnoreCase("barcode") ){
					 attribute=webM.fetchingfromJsonArray(jsonwal, "product", "variants", walmartJsonAttr);
					 bool=webM.verifyingUpdate(updatedText, attribute);
				}

				else if(attributeSync.equalsIgnoreCase("weight")) {
					attribute=webM.fetchingfromJsonArray(jsonwal, "product", "variants", walmartJsonAttr);
					bool=webM.verifyingUpdate(updatedweight, attribute);
				}

			if(bool.equals(false)){
				if(i>=2) {
					continue label;
				}
				else {
					Reporter.log("Not updated because Sync is disabled for  "+attributeSync);
					webM.gotoManageProducts();
					webM.clickingEditButtonForProductsBasedOnProdId(prod_id);
					webM.disablingOrEnablingSyncForAParticularAttribute(attributeSync);
					webM.clickingSyncWithShopifyInProductSyncing();
					Reporter.log("Sync with Shopify clicked");
					continue label;
				}

			}
			else {
				Reporter.log("Update completed");
				break label;
			}

			}
	}

	@DataProviderParams({ "fileName=InputData.csv", "tableName=ImportLimitReached" })
	@Test( description = "Verifying if import limit reached, then delete 1 variant and add 2. then only one should get added", dataProviderClass = DataReaderUtil.class, dataProvider = "CsvDataProvider",priority=19)
	public void verifyingWhenImportLimitReachedDelete1VariantAdd2VariantThen1VariantShouldBeAdded(String product,String variantToDelete,String firstSize,String firstColor,String firstInventory,String secondSize,String secondColor,String secondInventory) throws InterruptedException {
		webM=new WebHook_Module();
		webM.goToWalmartIntegrationApp();
		webM.switchingtoTab(1);
		String s=	webM.checkingIfImportLimitReached();
		if(s.equals("LimitReached")) {
			webM.switchingtoTab(0);
			//deleting a variant 
			webM.productToBeUpdatedforVariants(product);
			webM.selectingVariantProduct(variantToDelete);
			webM.deletingVariant(); //variant deleted
			Thread.sleep(5000);
			webM.selectingProduct(product);

			// calculating size of variant array here
			webM.extractingUrlAddingDotJsonAndLaunching();
			String json=webM.extractingJsonDataAsStringfromPage();
			String prod_id=	webM.fetchingfromJsonObject(json, "product", "id");
			JsonArray arr=webM.fetchingJsonArray(json, "product", "variants");
			int arrSize=arr.size();
			arrSize=arrSize+1;

			//Adding two products here
			webM.addingVariantforProductHavingVariant(firstSize, firstColor, firstInventory);
			webM.selectingProduct("Jeans");
			webM.addingVariantforProductHavingVariant(secondSize, secondColor, secondInventory);
			webM.switchingtoTab(1);
			label:
				for(int i=1;i<=150;i++) {
					webM.launchWalmartUrlWithProdId(prod_id);
					String jsonwal=webM.extractingJsonDataAsStringfromPage();
					JsonArray arr1=webM.fetchingJsonArray(jsonwal, "product", "variants");
					int arr1Size=arr1.size();
					if(arrSize==arr1Size) {
						Reporter.log("Only 1 product has been added");
						break label;
					}
					else {
						continue label;
					}

				}
		}
		else {
			//do nothing
		}
	}






}
