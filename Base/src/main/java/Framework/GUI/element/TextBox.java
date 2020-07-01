package Framework.GUI.element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import Framework.Custom.DriverManager;

public class TextBox extends UIElement {

    @Deprecated
    public TextBox(By by, String pageName) {
        super(by, pageName);
    }

    public TextBox(By by, String pageName, String elementName) {
        super(by, pageName, elementName);
    }

    public void clearAndType(CharSequence... keysToSend) {
        clear();
        type(keysToSend);
    }

    /*
    This method can be used when there is a popup with a mouse click on the text field.
    'Esc' will close the popup and will allow the set the text value.
     */
    public void clearEscAndType(CharSequence... keysToSend) {
        clear();
        getWrappedElement().sendKeys(Keys.ESCAPE);
        type(keysToSend);
    }

    public void type(CharSequence... keysToSend) {
        sendKeys(keysToSend);
    }
    
   

}
