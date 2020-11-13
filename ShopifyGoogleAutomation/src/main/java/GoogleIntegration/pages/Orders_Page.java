package GoogleIntegration.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import Framework.Custom.DriverManager;
import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.TextBox;
import GoogleIntegration.utilities.ReadXML;

public class Orders_Page extends commonPage{
	private Link AWSOption;
	private TextBox Username;
	private TextBox Password;
	private Link SignInButton;
	private TextBox UserIdTextBox;
	private Link LoginButton;
	private Link Orders;
	private Link SyncOrders;
	
	public Orders_Page() {
		super(Orders_Page.class.getSimpleName());
		AWSOption= new Link(ReadXML.getElementLocator("Orders_Page", "AWSOption"),
				"Orders_Page", "AWSOption");
		Username= new TextBox(ReadXML.getElementLocator("Orders_Page", "Username"),
				"Orders_Page", "Username");
		Password= new TextBox(ReadXML.getElementLocator("Orders_Page", "Password"),
				"Orders_Page", "Password");
		SignInButton= new Link(ReadXML.getElementLocator("Orders_Page", "SignInButton"),
				"Orders_Page", "SignInButton");
		UserIdTextBox= new TextBox(ReadXML.getElementLocator("Orders_Page", "UserIdTextBox"),
				"Orders_Page", "UserIdTextBox");
		LoginButton= new Link(ReadXML.getElementLocator("Orders_Page", "LoginButton"),
				"Orders_Page", "LoginButton");
		Orders= new Link(ReadXML.getElementLocator("Orders_Page", "Orders"),
				"Orders_Page", "Orders");
		SyncOrders= new Link(ReadXML.getElementLocator("Orders_Page", "SyncOrders"),
				"Orders_Page", "SyncOrders");
		
	}
	
	public void loggingInAccount() {
		if(Username.isDisplayed()) {
			Select select=new Select(AWSOption);
			select.selectByVisibleText("AWS_GOOGLE");
			Username.sendKeys("admin");
			Password.sendKeys("#er9&l3C");
			SignInButton.click();
		}
	}
	
	public void selectingShopBasedOnUserId(String userId) {
		UserIdTextBox.sendKeys(userId);
		UserIdTextBox.sendKeys(Keys.ENTER);
		waitFor(3);
		LoginButton.click();
	}
	
	public void waitFor(int sec) {
		
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void switchingToTabs(int tabnum) {
		ArrayList<String> tabsArr=new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
		DriverManager.getDriver().switchTo().window(tabsArr.get(tabnum));
	}
	
	public void syncingOrders() {
		Orders.click();
		waitFor(3);
		SyncOrders.click();
		waitFor(3);
	}

}
