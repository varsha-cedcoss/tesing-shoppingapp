package TestScripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.test.commonTest;
import GoogleIntegration.module.CustomProfile_Module;
import GoogleIntegration.module.Orders_Module;
import GoogleIntegration.module.WebHook_Module;

public class CustomProfile extends commonTest{
	WebHook_Module webM;
	CustomProfile_Module customM;
	Orders_Module orderM;
	
	@BeforeMethod
	public void loggingInAdminPanel() {
		orderM=new Orders_Module();
		orderM.loggingInAccount();
	}
	
	
	@Test
	public void customProfileForCondition() {
		customM=new CustomProfile_Module();
		webM=new WebHook_Module();
		orderM=new Orders_Module();
		orderM.waitFor(3);
		orderM.selectingShopBasedOnUserId("13323");
		orderM.switchingToTabs(1);
		orderM.waitFor(20);
		customM.goToCustomProfile();
		customM.createProfile("Google", "Australia", "English", "United States Dollar", "Price", "Greater Than","1000");
		orderM.waitFor(5);
//		customM.clickOnProfileCreated("Shantanu");
//		String profId=customM.getProfileId();
//		customM.launchProfileUrl(profId);
//		String json=webM.extractingJsonDataAsStringfromPage();
//		ArrayList<String> price=customM.getAttributesFromJsonData(json,"price","variants");
//		for(int i=0;i<price.size();i++) {
//			if(Integer.valueOf(price.get(i))>500) {
//				Reporter.log("The "+i+" element is "+price.get(i));
//				Reporter.log("price is greater than 500");
//			}
//			else {
//				Reporter.log("price is not greater than 500");
//				Assert.fail();
//				}
//		}
//		
	}
	
//	@Test
//	public void customProfileForCondition1() {
//		customM=new CustomProfile_Module();
//		webM=new WebHook_Module();
//		orderM=new Orders_Module();
//		orderM.waitFor(3);
//		orderM.selectingShopBasedOnUserId("13323");
//		orderM.switchingToTabs(1);
//		orderM.waitFor(15);
//		customM.goToCustomProfile();
//		customM.createProfile("Shan", "Australia", "English", "United States Dollar", "Title", "Does Not Contains","J");
//		orderM.waitFor(5);
//		customM.clickOnProfileCreated("Shan");
//		String profId=customM.getProfileId();
//		customM.launchProfileUrl(profId);
//		String json=webM.extractingJsonDataAsStringfromPage();
//		ArrayList<String> title=customM.getAttributesFromJsonData(json,"title","details");
//		for(int i=0;i<title.size();i++) {
//			if(!(title.get(i).toString().contains("J"))) {
//				Reporter.log("The "+i+" e1lement is "+title.get(i));
//				Reporter.log("The title contains the letter J");
//			}
//			else {
//				Reporter.log("The title doesnot contains the letter J");
//				Assert.fail();
//			}
//		}
//		
//	
//	}
	
}
