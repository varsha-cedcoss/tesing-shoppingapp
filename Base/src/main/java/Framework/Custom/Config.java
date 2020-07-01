package Framework.Custom;

import Framework.Utils.CommonUtils;

public class Config {
	   	public static final String PLATFORM;
	    public static final String BROWSER;
	    public static final String Port;
	    public static final String HEADLESS; 
	    public static final int MAX_PAGE_LOAD_WAIT_TIME;
	    public static final int MAX_ELEMENT_LOAD_WAIT_TIME;
	    public static final int TEST_CASE_RETRY_COUNT;
	    public static final String EXECUTION_ENVIRONMENT;
	    public static final String TEMP_DATA_PATH;
	    public static final String EXTENT_REPORT_PATH;
	    public static final String EXTENT_REPORT_NAME;
	    public static final String EXTENT_CONFIG_PATH;
	    public static final String FAILED_TESTCASE_SCREENSHOT_PATH;
	    
	    
	    static {
	        try {
	        	Port = "0000";
	            PLATFORM = System.getProperty("PLATFORM", "linux");
	            BROWSER = System.getProperty("BROWSER", "chrome");
	            HEADLESS = System.getProperty("HEADLESS", "false");            
	            MAX_PAGE_LOAD_WAIT_TIME = Integer.parseInt(System.getProperty("MAX_PAGE_LOAD_WAIT_TIME", "30"));
	            MAX_ELEMENT_LOAD_WAIT_TIME = Integer.parseInt(System.getProperty("MAX_ELEMENT_LOAD_WAIT_TIME", "30"));
	            TEST_CASE_RETRY_COUNT =Integer.parseInt( System.getProperty("TEST_CASE_RETRY_COUNT","2"));
	            EXECUTION_ENVIRONMENT = System.getProperty("EXECUTION_ENVIRONMENT", "local");
	            TEMP_DATA_PATH = CommonUtils.getPathWithValidSeperator(System.getProperty("TEMP_DATA_DIRECTORY", ""));
	            EXTENT_REPORT_PATH = System.getProperty("EXTENT_REPORT_PATH", "");
	            EXTENT_REPORT_NAME = System.getProperty("EXTENT_REPORT_NAME", "");
	            EXTENT_CONFIG_PATH = System.getProperty("EXTENT_CONFIG_PATH", "");
	            FAILED_TESTCASE_SCREENSHOT_PATH = System.getProperty("FAILED_TESTCASE_SCREENSHOT_PATH", "");
	            CommonUtils.createDirectory(TEMP_DATA_PATH);         
	        }catch (Throwable e) {
	            e.printStackTrace();
	            throw new RuntimeException("Something wrong !!! Check configurations.", e);
	        }
	    }
}
