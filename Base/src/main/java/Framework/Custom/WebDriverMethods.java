package Framework.Custom;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;

class WebDriverMethods {
	private WebDriver webDriver;
	private WebDriver webDriver_8080;
	
	private DesiredCapabilities capabilities;
	private String browser;
	private String platform;
	private Boolean headless;
	private String port;

	/**
	 * This method is used to set the platform for test execution.
	 *
	 */
	private void setPlatform() {
		if (Config.EXECUTION_ENVIRONMENT.equalsIgnoreCase("remote")) {
			switch (platform.toUpperCase()) {
			case "LINUX":
				capabilities.setPlatform(Platform.LINUX);
				break;
				case "WINDOWS":
				capabilities.setPlatform(Platform.WINDOWS);
				break;
			default:
				throw new RuntimeException("Invalid execution environment: " + platform);
			}
		}
	}

	/**
	 * This method returns the web driver instance after setting the Browser and
	 * DesiredCapabilities.
	 *
	 * @return WebDriver
	 *
	 */
	@SuppressWarnings("deprecation")
	public WebDriver getDriver(String portnumber) {
		if (portnumber.equals("0000")) {
			if (null == webDriver || ((RemoteWebDriver) webDriver).getSessionId() == null) {

				browser	= "CHROME";		
			//	browser = DriverManager.getBrowserName();
				platform = DriverManager.getPlatformName();
				headless = DriverManager.isHeadless();

				switch (browser.toUpperCase()) {
				
				case "CHROME":
					capabilities = DesiredCapabilities.chrome();
					setPlatform();
					capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
					HashMap<String, String> chromePreferences = new HashMap<String, String>();
					chromePreferences.put("profile.password_manager_enabled", "false");
					chromePreferences.put("profile.default_content_settings.popups", "0");
					chromePreferences.put("download.prompt_for_download", "false");
					chromePreferences.put("download.default_directory", Config.TEMP_DATA_PATH);
					capabilities.setCapability("chrome.prefs", chromePreferences);
					//String chromeProfile="/home/cedcoss/.config/google-chrome/Default";
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--test-type");
					options.addArguments("start-maximized");
					options.addArguments("--disable-web-security");
					options.addArguments("--allow-running-insecure-content");
					options.addArguments("chrome.switches", "--disable-extensions");
					//options.addArguments("user-data-dir=" + chromeProfile);
					options.setExperimentalOption("prefs", chromePreferences);
					if (headless)
						options.addArguments("headless");
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					
					LoggingPreferences logPrefs = new LoggingPreferences();
					logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
					capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

					if (!Config.EXECUTION_ENVIRONMENT.equalsIgnoreCase("remote")) {
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
//						ChromeDriverManager.getInstance().setup();
						webDriver = new ChromeDriver(capabilities);
						
						SessionId ses =  ((RemoteWebDriver)webDriver).getSessionId();
						System.out.println("Session Id is  : "+ses);
					}
					break;

				case "FIREFOX":
			        capabilities = DesiredCapabilities.firefox();
								setPlatform();
								ProfilesIni profiles=new ProfilesIni();
								FirefoxProfile profile = profiles.getProfile("default");
								FirefoxOptions option = new FirefoxOptions();
								if (headless)
									option.setHeadless(true);
							//	option.setCapability("marionette", false);
								profile.setAcceptUntrustedCertificates(true);
								profile.setPreference("browser.download.folderList", 2);
								profile.setPreference("browser.download.manager.showWhenStarting", false);
								profile.setPreference("browser.download.dir", Config.TEMP_DATA_PATH);
								profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
										"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;" + "application/pdf;"
												+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;"
												+ "text/plain;" + "text/csv" + "application/zip");
								capabilities.setAcceptInsecureCerts(true);
								capabilities.setCapability(FirefoxDriver.PROFILE, profile);
								capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, option);
								if (!Config.EXECUTION_ENVIRONMENT.equalsIgnoreCase("remote")) {
									System.setProperty("webdriver.gecko.driver", "/home/cedcoss/Documents/BigComAutomation/BigCom/geckodriver");
									System.out.println("Launching Firefox");
//									FirefoxDriverManager.getInstance().setup();
									webDriver = new FirefoxDriver(capabilities);
							//		SessionId ses =  ((RemoteWebDriver)webDriver).getSessionId();
								//	System.out.println("Session Id is  : "+ses);


								}
		
				break;
			
					default:
					throw new RuntimeException("Invalid browser: " + browser);
				}

			//
//				webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//				webDriver.manage().timeouts().setScriptTimeout(25, TimeUnit.SECONDS);
//				webDriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				if (!browser.equalsIgnoreCase("chrome")) {
					webDriver.manage().window().maximize();
				}
			}
		}
		
		return webDriver;
	}

	/**
	 * This method is used to quit the web driver instance.
	 *
	 */
	public void quitDriver() {
		if (null != webDriver) {
			webDriver.quit();
			webDriver = null;
		}
	}

	/**
	 * This method is used to get the current running instance of the web driver.
	 *
	 * @return WebDriver
	 */
	public WebDriver getWebDriver() {
		return webDriver;
	}

	/**
	 * This method is used to get the current Browser name.
	 *
	 * @return Browser name.
	 */
	public String getBrowser() {
		return browser;
	}

	public String getPort() {

		return port;
	}

	/**
	 * This method is used to get the current Platform name.
	 *
	 * @return Platform name.
	 */
	public String getPlatform() {
		return platform;
	}
}
