package GoogleIntegration.automation;
import Framework.Utils.PropertyUtil;

public class GlobalConfig {

    public static final String PLATFORM;
    public static final String BROWSER;
    public static final String HEADLESS;
    public static final String INPUTDATA_CSVFILE_PATH;

    static {
        try {        	
        	PropertyUtil.getInstance().load("globalconfig.properties");	
        	PLATFORM = System.getProperty("OperatingSystem");
            BROWSER = PropertyUtil.getInstance().getValue("BROWSER");
            HEADLESS = PropertyUtil.getInstance().getValue("HEADLESS");
            INPUTDATA_CSVFILE_PATH = PropertyUtil.getInstance().getValue("INPUTDATA_CSVFILE_PATH");

        } catch (Throwable e) {
        	
        	
            e.printStackTrace();
            throw new RuntimeException("Something wrong !!! Check configurations.", e);
        }
    }
}
