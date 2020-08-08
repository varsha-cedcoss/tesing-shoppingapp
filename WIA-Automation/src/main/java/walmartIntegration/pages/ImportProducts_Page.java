package walmartIntegration.pages;

import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import walmartIntegration.utilities.ReadXML;

public class ImportProducts_Page extends commonPage {
	
	private Link ImportProducts;
	private Link ImportProductDropdown;
	private Link AllProducts;
	private Link PublishedProducts;
	private Link FilterProducts;
	private Link ConfirmButton;
	private Link Filter_ProductType;
	private Link Filter_ProductVendor;
	private Link Filter_SmartCollection;
	private Link Filter_Collection;
	private Link FetchProductShopifyLink;
	private Link SelectAllButton;
	private Link StartImportingButton;
	
	
	public ImportProducts_Page() {
		super(ImportProducts_Page.class.getSimpleName());
		
		ImportProducts= new Link(ReadXML.getElementLocator("ImportProducts_Page", "ImportProducts"),
				"ImportProducts_Page", "ImportProducts");
		ImportProductDropdown= new Link(ReadXML.getElementLocator("ImportProducts_Page", "ImportProductDropdown"),
				"ImportProducts_Page", "ImportProductDropdown");
		AllProducts= new Link(ReadXML.getElementLocator("ImportProducts_Page", "AllProducts"),
				"ImportProducts_Page", "AllProducts");
		PublishedProducts= new Link(ReadXML.getElementLocator("ImportProducts_Page", "PublishedProducts"),
				"ImportProducts_Page", "PublishedProducts");
		FilterProducts= new Link(ReadXML.getElementLocator("ImportProducts_Page", "FilterProducts"),
				"ImportProducts_Page", "FilterProducts");
		ConfirmButton= new Link(ReadXML.getElementLocator("ImportProducts_Page", "ConfirmButton"),
				"ImportProducts_Page", "ConfirmButton");
		Filter_ProductType= new Link(ReadXML.getElementLocator("ImportProducts_Page", "Filter_ProductType"),
				"ImportProducts_Page", "Filter_ProductType");
		Filter_ProductVendor= new Link(ReadXML.getElementLocator("ImportProducts_Page", "Filter_ProductVendor"),
				"ImportProducts_Page", "Filter_ProductVendor");
		Filter_SmartCollection= new Link(ReadXML.getElementLocator("ImportProducts_Page", "Filter_SmartCollection"),
				"ImportProducts_Page", "Filter_SmartCollection");
		Filter_Collection= new Link(ReadXML.getElementLocator("ImportProducts_Page", "Filter_Collection"),
				"ImportProducts_Page", "Filter_Collection");
		FetchProductShopifyLink= new Link(ReadXML.getElementLocator("ImportProducts_Page", "FetchProductShopifyLink"),
				"ImportProducts_Page", "FetchProductShopifyLink");
		SelectAllButton= new Link(ReadXML.getElementLocator("ImportProducts_Page", "SelectAllButton"),
				"ImportProducts_Page", "SelectAllButton");
		StartImportingButton= new Link(ReadXML.getElementLocator("ImportProducts_Page", "StartImportingButton"),
				"ImportProducts_Page", "StartImportingButton");
		
		
		
	}
	
	public void gotoImportProductsTab() {
		ImportProducts.click();
	}
	
	

}
