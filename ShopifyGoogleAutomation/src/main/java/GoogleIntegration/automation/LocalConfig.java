package GoogleIntegration.automation;

import Framework.Utils.PropertyUtil;

public class LocalConfig {

    public static final String WIA_URL;

    static {
        try {
        	PropertyUtil.getInstance().load("localconfig.properties");	
        	WIA_URL = PropertyUtil.getInstance().getValue("WIA_URL");
        }
        catch (Throwable e) {
        	e.printStackTrace();
            throw new RuntimeException("Something wrong !!! Check configurations.", e);
        }
    }
}