package walmartIntegration.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.TextBox;
import walmartIntegration.automation.LocalConfig;
import walmartIntegration.utilities.ReadXML;

public class ImportExport_Page extends commonPage {
	
	private TextBox AdminUsername;
	private TextBox AdminPassword;
	private Link WalmartDropdown;
	private Link WalmartShopDetails;
	private TextBox ShopNameTextBox;
	private Link LoginAsButton;
	private Link ImportExport;
	private Link ImportExport_ProductUpdate;
	private Link ImportExport_RetireProduct;
	private Link ImportExport_UploadProduct;
	private Link ImportExport_AdvancedAttributes;
	private Link ImportExport_ShippingExceptions;
	private TextBox SelectProductStatusDropdown;
	private TextBox SelectColumnDropdown;
	private Link ExportButton;
	private Link DemoClick;
	
	
	
	

	
	public ImportExport_Page()  {
		super(ImportExport_Page.class.getSimpleName());
		this.pageURL= LocalConfig.WIA_URL;
		
		AdminUsername= new TextBox(ReadXML.getElementLocator("ManageProducts_Page", "AdminUsername"),
				"ManageProducts_Page", "AdminUsername");
		AdminPassword= new TextBox(ReadXML.getElementLocator("ManageProducts_Page", "AdminPassword"),
				"ManageProducts_Page", "AdminPassword");
		WalmartDropdown= new Link(ReadXML.getElementLocator("ManageProducts_Page", "WalmartDropdown"),
				"ManageProducts_Page", "WalmartDropdown");
		WalmartShopDetails= new Link(ReadXML.getElementLocator("ManageProducts_Page", "WalmartShopDetails"),
				"ManageProducts_Page", "WalmartShopDetails");
		ShopNameTextBox= new TextBox(ReadXML.getElementLocator("ManageProducts_Page", "ShopNameTextBox"),
				"ManageProducts_Page", "ShopNameTextBox");
		LoginAsButton= new Link(ReadXML.getElementLocator("ManageProducts_Page", "LoginAsButton"),
				"ManageProducts_Page", "LoginAsButton");
		ImportExport= new Link(ReadXML.getElementLocator("ImportExport_Page", "ImportExport"),
				"ImportExport_Page", "ImportExport");
		ImportExport_ProductUpdate= new Link(ReadXML.getElementLocator("ImportExport_Page", "ImportExport_ProductUpdate"),
				"ImportExport_Page", "ImportExport_ProductUpdate");
		ImportExport_RetireProduct= new Link(ReadXML.getElementLocator("ImportExport_Page", "ImportExport_RetireProduct"),
				"ImportExport_Page", "ImportExport_RetireProduct");
		ImportExport_UploadProduct= new Link(ReadXML.getElementLocator("ImportExport_Page", "ImportExport_UploadProduct"),
				"ImportExport_Page", "ImportExport_UploadProduct");
		ImportExport_AdvancedAttributes= new Link(ReadXML.getElementLocator("ImportExport_Page", "ImportExport_AdvancedAttributes"),
				"ImportExport_Page", "ImportExport_AdvancedAttributes");
		ImportExport_ShippingExceptions= new Link(ReadXML.getElementLocator("ImportExport_Page", "ImportExport_ShippingExceptions"),
				"ImportExport_Page", "ImportExport_ShippingExceptions");
		SelectProductStatusDropdown= new TextBox(ReadXML.getElementLocator("ImportExport_Page", "SelectProductStatusDropdown"),
				"ImportExport_Page", "SelectProductStatusDropdown");
		SelectColumnDropdown= new TextBox(ReadXML.getElementLocator("ImportExport_Page", "SelectColumnDropdown"),
				"ImportExport_Page", "SelectColumnDropdown");
		ExportButton= new Link(ReadXML.getElementLocator("ImportExport_Page", "ExportButton"),
				"ImportExport_Page", "ExportButton");
		DemoClick= new Link(ReadXML.getElementLocator("ImportExport_Page", "DemoClick"),
				"ImportExport_Page", "DemoClick");
		
		
		
		
		
		
				
	}
	public void LoggingInAccount() throws InterruptedException {

		AdminUsername.sendKeys("automated_script");
		AdminPassword.sendKeys("Z3E&=_4a;g%k");
		AdminPassword.sendKeys(Keys.ENTER);
		Thread.sleep(3000);		
		
	}
	
	public void selectingAShop(String shopName) throws InterruptedException {
		WalmartDropdown.click();
		WalmartShopDetails.click();
		ShopNameTextBox.sendKeys(shopName);
		ShopNameTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		LoginAsButton.click();
		Thread.sleep(5000);
	}
	
	public void exportingProductCsvBasedOnAparticularAttribute(String attribute) {
		ImportExport.click();
		ImportExport_ProductUpdate.click();
		Reporter.log("Selecting the product status as Not Uploaded");
		SelectProductStatusDropdown.sendKeys("Not Uploaded");
		SelectProductStatusDropdown.sendKeys(Keys.ENTER);
		DemoClick.click();
		Reporter.log("Selecting column as   "+attribute);
		SelectColumnDropdown.sendKeys(attribute);
		SelectColumnDropdown.sendKeys(Keys.ENTER);
		DemoClick.click();
		ExportButton.click();
	}
	
	
	public  HashMap<String, String> readingCsv(String filePath) throws IOException {
		String line=null;
		
		HashMap<String,String> map=new HashMap<String,String>();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		br.readLine();
		while ((line = br.readLine()) != null) {
		    // use comma as separator
		  String[] cols = line.split(",");
		  String varid=cols[0].replace("\"", "");
		  String val=cols[3].replace("\"", "");
		if(val.contains("'")) {
			val= val.replace("'", "");
		}
		  
		  Reporter.log("The updated values for variants   "+varid+ "    are       "+val);  	
		  map.put(varid, val);
		    			    
		    
		    
		}
		
		Reporter.log("The key value pairs are:      "+map);
		return map;
		
	}
	
	private int getHeaderLocation(String[] headers, String columnName) {
		   return Arrays.asList(headers).indexOf(columnName);
		}
	
	public String randomDoubleGenerator() {
		Random rand=new Random();
		double n=rand.nextDouble();
		String z=String.valueOf(n);
		return z;
	}
	
	
	public String randomgenerator() {
		Random rand =new Random();
		String s="Test";
		int n=rand.nextInt();
		String z=String.valueOf(n);
		s=s.concat(z);
		return s;
	}
	
	
	public String generateRandomForPrice() {
		Random rand=new Random();
		StringBuilder sb=new StringBuilder();
		sb.append(rand.nextInt(2000));
		return sb.toString();
		
	}
	public  String generateLongRandom() {
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();
	    // first not 0 digit
	    sb.append(random.nextInt(9) + 1);
	    // rest of 11 digits
	    for (int i = 0; i < 11; i++) {
	        sb.append(random.nextInt(10));
	    }
	    return sb.toString();
	}
	
	
	public void updatingCSV(String fileToUpdate,String attribute) throws IOException {
		 	
		CSVReader reader = new CSVReader(new FileReader(fileToUpdate), ',');
		String [] nextLine;
		int columnPosition;
		nextLine = reader.readNext();
		List<String[]> csvBody = reader.readAll();
		//isko print karao
//		for(int j=0;j<csvBody.size();j++) {
//			for(int z=0;z<csvBody.get(j).length;z++) {
//				Reporter.log(""+csvBody.get(j)[z]);
//			}
//			
//		
//		}
//		
		String replace=null;
		
					
		for(int i=0;i<csvBody.size();i++) {
			
				switch(attribute) {
				case "price":
					columnPosition = getHeaderLocation(nextLine, "price");
					 replace=generateRandomForPrice();
					Reporter.log("The updated text for  "+i+ "    column is   "+replace);
					csvBody.get(i)[columnPosition] = replace;
					break;
				case "product_title":
					columnPosition = getHeaderLocation(nextLine, "product_title");
					 replace=randomgenerator();
					 Reporter.log("The updated text for  "+i+ "    column is   "+replace);
					csvBody.get(i)[columnPosition] = replace;
					break;
				case "description":
					columnPosition = getHeaderLocation(nextLine, "description");
					replace=randomgenerator();
					Reporter.log("The updated text for  "+i+ "    column is   "+replace);
					csvBody.get(i)[columnPosition] = replace;
					break;
				case "compare_at_price":
					columnPosition = getHeaderLocation(nextLine, "compare_at_price");
					replace=generateRandomForPrice();
					Reporter.log("The updated text for  "+i+ "    column is   "+replace);
					csvBody.get(i)[columnPosition] = replace;
					break;
				case "inventory":
					columnPosition = getHeaderLocation(nextLine, "inventory");
					Random rand=new Random();
					int n=rand.nextInt(100);
					String s=String.valueOf(n);
					Reporter.log("The updated text for  "+i+ "    column is   "+s);
					csvBody.get(i)[columnPosition] = s;
					break;
				case "barcode":
					columnPosition = getHeaderLocation(nextLine, "barcode");
					replace=generateLongRandom();
					Reporter.log("The updated text for  "+i+ "    column is   "+replace);
					csvBody.get(i)[columnPosition] = replace;
					break;
				case "fulfillment_lag_time":
					columnPosition = getHeaderLocation(nextLine, "fulfillment_lag_time");
					Random rand1=new Random();
					int n1=rand1.nextInt(10);
					String s1=String.valueOf(n1);
					Reporter.log("The updated text for  "+i+ "    column is   "+s1);
					csvBody.get(i)[columnPosition] = s1;
					break;
				case "sku_override":
					columnPosition = getHeaderLocation(nextLine, "sku_override");
					String var=csvBody.get(i)[0].replace("'", "");
					Reporter.log(""+var);
					long num=Long.parseLong(var);
					
					if(num%2==0) {
						csvBody.get(i)[columnPosition] = "yes";
					}
					else {
						csvBody.get(i)[columnPosition] = "no";
					}
					break;
				case "product_id_override":
					columnPosition = getHeaderLocation(nextLine, "product_id_override");
					String var1=csvBody.get(i)[0].replace("'", "");
					Reporter.log(""+var1);
					long num1=Long.parseLong(var1);
					
					if(num1%2==0) {
						csvBody.get(i)[columnPosition] = "no";
					}
					else {
						csvBody.get(i)[columnPosition] = "yes";
					}
					break;
				case "tax_code":
					columnPosition = getHeaderLocation(nextLine, "tax_code");
					csvBody.get(i)[columnPosition] = randomgenerator();
					break;
				case "weight":
					columnPosition = getHeaderLocation(nextLine, "weight");
					replace=randomDoubleGenerator();
					Reporter.log("The updated text for  "+i+ "    column is   "+replace);
					csvBody.get(i)[columnPosition] = replace;
					break;
				}
									
		}
		
		reader.close();
		// Write to CSV file which is open
				CSVWriter writer = new CSVWriter(new FileWriter(fileToUpdate), ',');
				
//				
//int titleLoc=getHeaderLocation(nextLine, "product_title");
//int descLoc=getHeaderLocation(nextLine, "description");
//for(int i=0;i<csvBody.size();i++) {
//	for(int j=0;j<csvBody.get(i).length;j++) {
//		if(j!=titleLoc && j!=descLoc) {
//			
//		}
//	}
//}
		
	//	for(int i=0;i<csvBody.size();i++) {
			writer.writeNext(nextLine);
	//	}
		
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
	}
	
	public Boolean comparingIfDataUpdatedInCsv(HashMap<String,String> originalCsv,HashMap<String,String> updatedCsv){
		Boolean bool=null;
		if(originalCsv.equals(updatedCsv)) {
			bool=true;
			Reporter.log("The updated csv is equal to original csv");
		}
		else {
			bool=false;
			Reporter.log("The updated csv is not equal to original csv");
		}
		return bool;
	}
	
	
}
