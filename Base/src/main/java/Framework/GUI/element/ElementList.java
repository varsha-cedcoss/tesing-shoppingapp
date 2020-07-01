package Framework.GUI.element;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Framework.Custom.Config;

public class ElementList extends UIElement{
	
	@Deprecated
	public ElementList(By by, String pageName) {
		super(by, pageName);
	}

	public ElementList(By by, String pageName, String elementName) {
	    super(by, pageName, elementName);
	}

	public List<WebElement> getElements() {
		 return getWrappedElements();
	}
	
	public List<String> getElementsTexts() {
		List<String> texts = new ArrayList<String>();
		for(WebElement element : getElements()) {
			 texts.add(element.getText());
		} 
		return texts;
	}
	    
	public WebElement getElement(int idx) {
		 return getElements().get(idx);
	}
	
	public WebElement getElement(String text) {
		 for(WebElement element : getElements()) {
			 if(element.getText().equals(text)) {
				 return element;
			 } 
		 }
		 throw new WebDriverException("No matching element found in the list");
	}

	public String getElementText(int idx) {
		 return getElement(idx).getText();
	}
	
	public int getCount() {
		return getElements().size();
	}
	
	public void clickElement(int idx) {
		Boolean found = false;
		String stackTrace = "Unable to click";
	    Reporter.log("<br>Click on element [" +idx+ "] in the list");
	    long oneMinuteTick = System.currentTimeMillis() + Config.MAX_ELEMENT_LOAD_WAIT_TIME*1000;
		while(System.currentTimeMillis() <= oneMinuteTick) { 
			try {		    	
			   	getElement(idx).click();
			   	found = true;
			   	break;
			} catch (WebDriverException e) {
				StringWriter sw = new StringWriter();
			    PrintWriter pw = new PrintWriter(sw);
			    e.printStackTrace(pw);
			    pw.flush();
			    stackTrace = sw.toString();
			  } 		  
		}
		if(!found) {
			Reporter.log("Element [" + idx + "] is not clickable");
			throw new WebDriverException(stackTrace);
		}		   
	}
	
	public void clickElement(String text) {
		Boolean found = false;
		String stackTrace = "Unable to click";
	    Reporter.log("<br>Click on element [" +text+ "] in the list");
	    long oneMinuteTick = System.currentTimeMillis() + Config.MAX_ELEMENT_LOAD_WAIT_TIME*1000;
		while(System.currentTimeMillis() <= oneMinuteTick) { 
			try {		    	
			   	getElement(text).click();
			   	found = true;
			   	break;
			} catch (WebDriverException e) {
				StringWriter sw = new StringWriter();
			    PrintWriter pw = new PrintWriter(sw);
			    e.printStackTrace(pw);
			    pw.flush();
			    stackTrace = sw.toString();
			  } 		  
		}
		if(!found) {
			Reporter.log("Element [" + text + "] is not clickable");
			throw new WebDriverException(stackTrace);
		}		   
	}
	
	
	public void assertListContainsText(String text) {
		Boolean found = false;
        Reporter.log("<br>Assert [" + text + "] is present in the List");
        for(WebElement element : getElements()) {
			 if(element.getText().equals(text)) {
				 found = true;
			 } 
		 }
        Assertions.assertThat(found);
    }
	
	public void assertListContainsText(Integer idx, String text) {
        Reporter.log("<br>Assert [" + text + "] is present in the List at index [" + idx + "]");
        Assertions.assertThat(getElementText(idx).equals(text));
    }
	
	public void assertListDoesNotContainText(String text) {
		Boolean found = true;
        Reporter.log("<br>Assert [" + text + "] is not present in the List");
        for(WebElement element : getElements()) {
			 if(element.getText().equals(text)) {
				 found = false;
			 } 
		 }
        Assertions.assertThat(!found);
    }
	
	public void assertListDoesNotContainText(Integer idx, String text) {
		Reporter.log("<br>Assert [" + text + "] is not present in the List at index [" + idx + "]");
        Assertions.assertThat(!getElementText(idx).equals(text));
    }
	
	public void assertCompleteListContainsPartialText(String text) {
        Reporter.log("<br>Assert partial text [" + text + "] is present at every location in the List");
        for(WebElement element : getElements()) {
			 if(element.getText().contains(text)) {
				 Assertions.assertThat(true);
			 } else {
				 Assertions.assertThat(false);
			 }
		 }
    }

}
