package walmartIntegration.module;

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
public String fetchingfromJsonArray(String js, String obj, String objAttr, String AttrVal) {
	String val=webP.fetchingfromJsonArray(js, obj, objAttr, AttrVal);
	return val;
}
public void creatingNewProduct() {
	webP.creatingNewProduct();
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

}
