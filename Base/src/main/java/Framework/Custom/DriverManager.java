package Framework.Custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
	private static WebDriver drived = null;
	private static List<WebDriverMethods> webDriverThreadPool =
			Collections.synchronizedList(new ArrayList<WebDriverMethods>());
	
	private static ThreadLocal<WebDriverMethods> driverThread = new ThreadLocal<WebDriverMethods>(){
		@Override
		protected WebDriverMethods initialValue(){
			WebDriverMethods webDriverThread = new WebDriverMethods();
			webDriverThreadPool.add(webDriverThread);
			return webDriverThread;
		}
	};
	
	private static final ThreadLocal<WebDriverWait> webDriverPageWait = new ThreadLocal<WebDriverWait>(){
		@Override
		protected WebDriverWait initialValue(){
			WebDriverWait wait = new WebDriverWait(getDriver(), Config.MAX_PAGE_LOAD_WAIT_TIME);
			return wait;
		}
	};

	private static ThreadLocal<Boolean> captureScreenShot = new ThreadLocal<Boolean>(){
		@Override
		protected Boolean initialValue(){
			return true;
		}
	};	private static ThreadLocal<String> platformName = new ThreadLocal<String>();
	private static ThreadLocal<String> browserName = new ThreadLocal<String>();
	private static ThreadLocal<Boolean> headless = new ThreadLocal<Boolean>();
	private static ThreadLocal<String> port = new ThreadLocal<String>();
	
	public static WebDriver getCurrentWebDriver(){
		return driverThread.get().getWebDriver();
	}

	public static WebDriver getDriver(){
		WebDriverMethods webDriverThread = driverThread.get();
		if (webDriverThread.getWebDriver() != null) {
			if (!webDriverThread.getBrowser().equalsIgnoreCase(DriverManager.getBrowserName()) ||
					!webDriverThread.getPlatform().equalsIgnoreCase(DriverManager.getPlatformName())) {

				if(!webDriverThread.getPort().equalsIgnoreCase(DriverManager.getPortNumber()))
				{
					webDriverThread.quitDriver();
				}
			}
		}
		String current_portnumber = getPortNumber();
		if(current_portnumber.equals("0000"))
		{
		  drived = driverThread.get().getDriver(current_portnumber);		
		}
	return drived;
	}
	
	/**
	 * This method is used to get the platform.
	 *
	 * @return platform.
	 */
	public static String getPlatformName() {
		return platformName.get();
	}

	/**
	 * This method is used to set the platform.
	 *
	 * @param platform.
	 */
	public static void setPlatformName(String platform) {
		platformName.set(platform);
	}

	/**
	 * This method is used to get the browser.
	 *
	 * @return browser.
	 */
	public static String getBrowserName() {
		return browserName.get();
	}

	/**
	 * This method is used to set the browser.
	 *
	 * @param browser.
	 */
	public static void setBrowserName(String browser) {
		browserName.set(browser);
	}

	public static void setPortNumber(String portnumber) {
		port.set(portnumber);
	}

	public static String getPortNumber() {
		return port.get();
	}

	/**
	 * This method is used to get if the browser is headless or not.
	 *
	 * @return boolean.
	 */
	public static Boolean isHeadless() {
		return headless.get();
	}
	/**
	 * This method is used to get if the capturescreenshot is on or not.
	 *
	 * @return boolean.
	 */
	public static Boolean getCaptureScreenShot(){
		return captureScreenShot.get();
	}

	/**
	 * This method is used to set the capturescreenshot as on or off.
	 *
	 * @param boolean.
	 */
	public static void setCaptureScreenShot(Boolean captureScreenShot){
		DriverManager.captureScreenShot.set(captureScreenShot);
	}

	/**
	 * This method is used to get the webdriver page wait.
	 *
	 * @return WebDriverWait.
	 */
	public static WebDriverWait getWebDriverPageWait(){
		return webDriverPageWait.get();
	}

	/**
	 * This method is used to set the webdriver page wait.
	 *
	 * @param WebDriverWait in seconds.
	 */
	public static void setWebDriverPageWait(int seconds){
		webDriverPageWait.set(new WebDriverWait(getDriver(), seconds));
	}
	public static void closeDriverObjects(){
		for(WebDriverMethods webDriverThread: webDriverThreadPool){
			webDriverThread.quitDriver();
		}
	}
	
	public static void setHeadless(String headlessValue) {
		if(headlessValue.equalsIgnoreCase("True")) {
			headless.set(true);
		}
		else {
			headless.set(false);
		}
	}

}
