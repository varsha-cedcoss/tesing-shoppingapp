package GoogleIntegration.module;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;

import Framework.Custom.DriverManager;
import GoogleIntegration.pages.WebHook_Page;

	public class WebHook_Module {
		WebHook_Page webP;
	
	public WebHook_Module() {
		webP=new WebHook_Page();
	}
	
	public void waitFor(int seconds) {
		webP.waitFor(seconds);
	}
	
	public void LogginginShopify() {
		webP.LogginginShopify();
	}
	
	
	public void goToGoogleIntegrationApp(){
		webP.goToGoogleIntegrationApp();
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
	
	public void updatingSimpleProductsAttributes(String product,String updateAttribute,String updatedText)  {
		webP.updatingSimpleProductsAttributes(product, updateAttribute, updatedText);
	}
	
	public void extractingUrlAddingDotJsonAndLaunching() {
		webP.extractingUrlAddingDotJsonAndLaunching();
	}
	
	public String extractingJsonDataAsStringfromPage() {
	String json=webP.extractingJsonDataAsStringfromPage();
	DriverManager.getDriver().navigate().back();
		return json;
	}
	
	public void launchGoogleUrlWithProdId(String userId,String prod_id){
		webP.launchGoogleUrlWithProdId(userId,prod_id);
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
	
	
	public void productToBeUpdatedforVariants(String product)  {
		webP.productToBeUpdatedforVariants(product);
	}
	
	public String extractingVariantIdfromUrl() {
	String varid=webP.extractingVariantIdfromUrl();
		return varid;
	}
	
	public void variantsToBeUpdated(String variant, String updatedText) {
		webP.variantsToBeUpdated(variant,updatedText);
	}
	
	public void addingVariant(String product,String variantName, String variantValue )  {
		webP.addingVariant(product,variantName, variantValue);	
	}
	
	public void uncheckingTrackQuantityCheckbox() {
		webP.uncheckingTrackQuantityCheckbox();
	}
	
	public void verifyingNotUpdated(String updatedtextshop, String updatedtextwal) {
		webP.verifyingNotUpdated(updatedtextshop, updatedtextwal);
	}
	
	public void deletingVariant() {
		webP.deletingVariant();
	}
	
	public String deletingProduct(String product)  {
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
	
	
	public void updatingInventoryForVariants(String updatedText) {
		webP.updatingInventoryForVariants(updatedText);
	}
	
	public void selectingForBulkUpdate()  {
		webP.selectingForBulkUpdate();
	}

//give field name as in shopify app
	public void selectingAParticularFieldforBulkEditing(String fieldName)  {
		webP.selectingAParticularFieldforBulkEditing(fieldName);
	}
	
	//if in for loop, take num= i+1
	public void selectingAParticularTextBoxofInventory(String varCol,String varNum) {
			webP.selectingAParticularTextBoxofInventory(varCol, varNum);
					}
		
		//if in for loop, take num= i
	public void updatingBulkInventory(String varCol,String varNum,String updatedQty) {
			webP.updatingBulkInventory(varCol, varNum,updatedQty);
		}
	public void clickingSaveButtonforBulk()  {
		webP.clickingSaveButtonforBulk();
	}
	public void selectingProduct(String product) {
		webP.selectingProduct(product);
	}
	
	public void deleteAllProducts()  {
		webP.deleteAllProducts();
	}
	
	public void updatingTags(String updatedText)  {
		webP.updatingTags(updatedText);
	}
	
	public void clickingCheckboxforParticularVariantInOrder(String varid) {
		webP.clickingCheckboxforParticularVariantInOrder(varid);
	}
	
	public void creatingOrder(String firstletterofProduct,String restOfLetterOfProduct,String varid)  {
		webP.creatingOrder(firstletterofProduct,restOfLetterOfProduct, varid);
	}
	
	public void addingVariantforProductHavingVariant(String sizeVal,String colorVal,String quantity)  {
		webP.addingVariantforProductHavingVariant(sizeVal, colorVal, quantity);
	}
	
	public ArrayList<String> duplicatingSkuOfOneProductToAnother(String variantToduplicateSku) {
		ArrayList<String> varProdId=webP.duplicatingSkuOfOneProductToAnother(variantToduplicateSku);
		return varProdId;
			}
	
	public void orderToBeRefunded(String OrderId)  {
		webP.orderToBeRefunded(OrderId);
	}
	
	public void goToManageSectionInPaymentSettings() {
		webP.goToManageSectionInPaymentSettings();
	}
	
	public void selectingACurrency(String currency) {
		webP.selectingACurrency(currency);
	}
	
	public void launchShopUpdateUrl(String shopId) {
		webP.launchShopUpdateUrl(shopId);
	}
	
	
	
}
