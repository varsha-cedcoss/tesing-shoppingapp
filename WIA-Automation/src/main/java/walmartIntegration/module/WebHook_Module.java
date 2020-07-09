package walmartIntegration.module;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;

import Framework.Custom.DriverManager;
import walmartIntegration.pages.WebHook_Page;

public class WebHook_Module {
	WebHook_Page webP;

public WebHook_Module() {
	webP=new WebHook_Page();
}

public void LogginginShopify() throws InterruptedException{
	webP.LogginginShopify();
}


public void goToWalmartIntegrationApp() throws InterruptedException {
	webP.goToWalmartIntegrationApp();
}
public void switchingtoTab(int tabnum) {
	webP.switchingtoTab(tabnum);
}

public String fetchingfromJsonObject(String js,String obj, String objAttr) {
	String val=webP.fetchingfromJsonObject(js,obj, objAttr);
	return val;
}

public JsonArray fetchingJsonArray(String js, String obj, String objAttr) {
	JsonArray arr=webP.fetchingJsonArray(js, obj, objAttr);
	return arr;
}

public String fetchingfromJsonArray(String js, String obj, String objAttr, String AttrVal) {
	String val=webP.fetchingfromJsonArray(js, obj, objAttr, AttrVal);
	return val;
}
public void creatingNewProduct(String title,String description,String prodType,String vendor,String price,String costperitem,String inventory,String weight) {
	webP.creatingNewProduct(title,description,prodType,vendor,price,costperitem,inventory,weight);
}
public void updatingTitle(String product, String updateText) throws InterruptedException {
	webP.updatingTitle(product,updateText);
}

public void updatingDescription(String product, String updateText) throws InterruptedException {
	webP.updatingDescription(product,updateText);
}

public void updatingProductType(String product, String updateText) throws InterruptedException {
	webP.updatingProductType(product,updateText);
}

public void updatingVendor(String product, String updateText) throws InterruptedException {
	webP.updatingVendor(product,updateText);
}

public void updatingPrice(String product, String updateText) throws InterruptedException {
	webP.updatingPrice(product,updateText);
}

public void updatingInventory(String product, String updateText) throws InterruptedException {
	webP.updatingInventory(product,updateText);
}

public void updatingWeight(String product, String updateText) throws InterruptedException {
	webP.updatingWeight(product,updateText);
}

public void updatingSKU(String product, String updateText, String webElement ) throws InterruptedException  {
	webP.updatingSKU(product, updateText,webElement);
}

public void updatingBarcode(String product, String updateText) throws InterruptedException  {
	webP.updatingBarcode(product, updateText);
}

public void extractingUrlAddingDotJsonAndLaunching() {
	webP.extractingUrlAddingDotJsonAndLaunching();
}

public String extractingJsonDataAsStringfromPage() {
String json=webP.extractingJsonDataAsStringfromPage();
DriverManager.getDriver().navigate().back();
	return json;
}

public void launchWalmartUrlWithProdId(String prod_id){
	webP.launchWalmartUrlWithProdId(prod_id);
}

public Boolean verifyingUpdate(String updatedtextshop, String updatedtextwal) {
Boolean bool=webP.verifyingUpdate(updatedtextshop, updatedtextwal);
return bool;

}

public void selectingVariantProduct(String variantName) {
	webP.selectingVariantProduct(variantName);
}

public String fetchingfromJsonArrayofVariantsBasedonVariantId(String js, String obj, String objAttr,String variantId, String AttrVal) {
String val=webP.fetchingfromJsonArrayofVariantsBasedonVariantId(js, obj, objAttr, variantId, AttrVal);
return val;
}


public void productToBeUpdatedforVariants(String product) throws InterruptedException {
	webP.productToBeUpdatedforVariants(product);
}

public String extractingVariantIdfromUrl() {
String varid=webP.extractingVariantIdfromUrl();
	return varid;
}

public void variantsToBeUpdated(String variant, String updatedText) {
	webP.variantsToBeUpdated(variant,updatedText);
}

public void addingVariant(String product,String variantName, String variantValue ) throws InterruptedException {
	webP.addingVariant(product,variantName, variantValue);	
}

public void uncheckingTrackQuantityCheckbox() {
	webP.uncheckingTrackQuantityCheckbox();
}

public void disablingSyncInWalmart() throws InterruptedException {
	webP.disablingSyncInWalmart();
}

public void enablingSyncInWalmart() throws InterruptedException {
	webP.enablingSyncInWalmart();
}

public void verifyingNotUpdated(String updatedtextshop, String updatedtextwal) {
	webP.verifyingNotUpdated(updatedtextshop, updatedtextwal);
}

public void deletingVariant() {
	webP.deletingVariant();
}

public String deletingProduct(String product) throws InterruptedException {
String prod_id=webP.deletingProduct(product);
return prod_id;
}

public String convertingToPoundandRoundingOffto5DecPlace(String weightinKg) {
	String weightinPound=webP.convertingToPoundandRoundingOffto5DecPlace(weightinKg);
	return weightinPound;
}

public void closeAllOpenedTabs() {
	webP.closeAllOpenedTabs();
}

public void selectingImage(String product) throws InterruptedException {
	webP.selectingImage(product);
}

public void disablingAutoProductCreate() throws InterruptedException {
	webP.disablingAutoProductCreate();
}

public void enablingAutoProductCreate() throws InterruptedException {
	webP.enablingAutoProductCreate();
}
public void updatingInventoryForVariants(String updatedText) {
	webP.updatingInventoryForVariants(updatedText);
}

public void selectingForBulkUpdate() throws InterruptedException {
	webP.selectingForBulkUpdate();
}

//give field name as in shopify app
	public void selectingAParticularFieldforBulkEditing(String fieldName) throws InterruptedException {
		webP.selectingAParticularFieldforBulkEditing(fieldName);
	}
	
	//if in for loop, take num= i+1
	public void selectingAParticularTextBoxofInventory(String num) {
			webP.selectingAParticularTextBoxofInventory(num);
					}
		
		//if in for loop, take num= i
	public void updatingBulkInventory(String num,String updatedQty) {
			webP.updatingBulkInventory(num, updatedQty);
		}
	public void clickingSaveButtonforBulk() throws InterruptedException {
		webP.clickingSaveButtonforBulk();
	}
	public void selectingProduct(String product) throws InterruptedException{
		webP.selectingProduct(product);
	}
	
	public void deleteAllProducts() throws InterruptedException {
		webP.deleteAllProducts();
	}
	
	public void updatingTags(String updatedText) throws InterruptedException {
		webP.updatingTags(updatedText);
	}
	
	public void clickingCheckboxforParticularVariantInOrder(String varid) {
		webP.clickingCheckboxforParticularVariantInOrder(varid);
	}
	
	public void creatingOrder(String firstletterofProduct,String restOfLetterOfProduct,String varid) throws InterruptedException {
		webP.creatingOrder(firstletterofProduct,restOfLetterOfProduct, varid);
	}
	
	public void addingVariantforProductHavingVariant(String sizeVal,String colorVal,String quantity) throws InterruptedException {
		webP.addingVariantforProductHavingVariant(sizeVal, colorVal, quantity);
	}
	
	public ArrayList duplicatingSkuOfOneProductToAnother() {
		ArrayList<String> varProdId=webP.duplicatingSkuOfOneProductToAnother();
		return varProdId;
			}
	public void orderToBeRefunded(String OrderId) throws InterruptedException {
		webP.orderToBeRefunded(OrderId);
	}
	
	public String checkingIfImportLimitReached() throws InterruptedException{
		String s=webP.checkingIfImportLimitReached();
		return s;
	}
	
	
}
