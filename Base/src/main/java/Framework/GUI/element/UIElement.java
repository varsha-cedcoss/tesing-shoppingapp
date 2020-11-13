package Framework.GUI.element;


import org.fest.assertions.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import Framework.Custom.DriverManager;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class UIElement implements  WebElement, WrapsElement, Locatable {

    protected String elementName;
    protected String pageName;
    private By by;
    private WebElement webElement;
    private List<WebElement> webElementList;
    JavascriptExecutor js;
    WebDriver driver;

    @Deprecated
    public UIElement(By by, String pageName) {
        this.by = by;
        this.pageName = pageName;
        this.elementName = Thread.currentThread().getStackTrace()[3].getMethodName(); //returns the method name where the element is getting initialized;
        this.driver = DriverManager.getDriver();
        js = (JavascriptExecutor) driver;
    }

    public UIElement(By by, String pageName, String elementName) {
        this.by = by;
        this.pageName = pageName;
        this.elementName = elementName;
        this.driver = DriverManager.getDriver();
        js = (JavascriptExecutor) driver;
    }

    public String getPageName() {
        return this.pageName;
    }

    public String getElementName() {
        return this.elementName;
    }

    public By getBy() {
        return this.by;
    }

    public void alertAndUpload()
    {
    	
    }
    
    
    public void click() {
        Reporter.log("<br>Click [" + elementName + "] on [" + pageName + "]");

        try {
            getWrappedElement().click();
        } catch (WebDriverException e) {
            if (e.getMessage().contains("unknown error: Element is not clickable at point")) {
                Reporter.log("Retrying due to the error: Element is not clickable at point(X, Y)<br>");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();               
                }
                getWrappedElement().click();
            } else {
                throw e;
            }
        }
    }
    
    
    public void clickAndHold() {
        Reporter.log("<br>ClickAndhold [" + elementName + "] on [" + pageName + "]");
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.clickAndHold(getWrappedElement()).build().perform();
            action.moveToElement(getWrappedElement()).release();
        } catch (WebDriverException e) {
            if (e.getMessage().contains("unknown error: Element is not clickable at point")) {
                Reporter.log("Retrying due to the error: Element is not clickable at point(X, Y)<br>");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();               
                }
                getWrappedElement().click();
            } else {
                throw e;
            }
        }
    }

   
    public void sendKeys(CharSequence... keysToSend) {
        Reporter.log("<br>Enter text [" + Arrays.toString(keysToSend) + "] in [" + elementName + "] on [" + pageName + "]");
        getWrappedElement().sendKeys(keysToSend);
    }
    
    public boolean isThisElementPresent() {
        Reporter.log("<br>Checking Present or not");
        
        if(getWrappedElement().isDisplayed())
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    public Point getLocation() {
        return getWrappedElement().getLocation();
    }
    
    public boolean isPresent() 
    {
       	try {
       		getWrappedElement();
       		
       		System.out.println("Print : " + getWrappedElement().getText());
    } 
       	catch (NoSuchElementException e) 
       	{
       		return false;
       	}       	
       	return true;
       	}
  
    public List<WebElement> findElements(By by) {
        return getWrappedElement().findElements(by);
    }

    public String getText() {
        return getWrappedElement().getText();
    }

    public String getTagName() {
        return getWrappedElement().getTagName();
    }

    public boolean isSelected() {
        return getWrappedElement().isSelected();
    }

    public WebElement findElement(By by) {
        return getWrappedElement().findElement(by);
    }

    public boolean isEnabled() {
        return getWrappedElement().isEnabled();
    }

    public boolean isDisplayed() {
        WebElement element;
        try {
            element = getWrappedElement();
        } catch (NoSuchElementException e) {
            return false;
        }
        return element.isDisplayed();
    }

    public void clear() {
        Reporter.log("<br>Clear text in [" + elementName + "] on [" + pageName + "]");
        getWrappedElement().clear();
    }

    public WebElement getWrappedElement() {
        if (this.webElement == null) {
            this.webElement = DriverManager.getDriver().findElement(this.by);
        }
        return this.webElement;
    }
    
    public List<WebElement> getWrappedElements() {
//        if (this.webElementList == null) {
            this.webElementList = DriverManager.getDriver().findElements(this.by);
//        }
        return this.webElementList;
    }

         public UIElement and() {
        return this;
    }
     public static String getUrl()
    {
    	String url ;
    	url = DriverManager.getDriver().getCurrentUrl();
        return url;
    }
   

    public void scrollToView() {
        Reporter.log("<br>Scroll [" + elementName + "] to view on [" + pageName + "]");
        String script = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(script, getWrappedElement());
    }
    
    public void scrollToTop() {
    	((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollTo(0, 0)");
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    public void assertDisabled() {
        Reporter.log("<br>Assert [" + elementName + " is disabled on [" + pageName + "]");
        Assertions.assertThat(isEnabled()).isFalse();
    }

    public void assertEnabled() {
        Reporter.log("<br>Assert [" + elementName + " is enabled on [" + pageName + "]");
        Assertions.assertThat(isEnabled()).isTrue();
    }

	@Override
	public Coordinates getCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAttribute(String name) {
		
		return getWrappedElement().getAttribute(name);
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}
    

}
