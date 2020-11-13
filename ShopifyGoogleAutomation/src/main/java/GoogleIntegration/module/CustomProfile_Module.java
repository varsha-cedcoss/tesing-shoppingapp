package GoogleIntegration.module;

import java.util.ArrayList;

import GoogleIntegration.pages.CustomProfile_Page;

public class CustomProfile_Module {
	CustomProfile_Page customP;
	
	public CustomProfile_Module() {
		customP=new CustomProfile_Page();
	}
	
	public ArrayList<String> getAttributesFromJsonData(String json,String attribute,String objAttribute) {
		ArrayList<String> price=customP.getAttributesFromJsonData(json,attribute,objAttribute);
		return price;
	}
	
	public void goToCustomProfile() {
		customP.goToCustomProfile();
	}
	
	public void createProfile(String profName,String tarCountry,String contentLanguage,String curr,String prodAttribute,String anyOperator,String value) {
		customP.createProfile(profName, tarCountry, contentLanguage, curr, prodAttribute, anyOperator,value);
	}
	
	public void clickOnProfileCreated(String profName) {
		customP.clickOnProfileCreated(profName);
	}
	
	public String getProfileId() {
		String profId=customP.getProfileId();
		return profId;
	}
	
	public void launchProfileUrl(String profId) {
		customP.launchProfileUrl(profId);
	}
	
}
