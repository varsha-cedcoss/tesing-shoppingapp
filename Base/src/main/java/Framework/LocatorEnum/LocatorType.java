package Framework.LocatorEnum;
import org.apache.commons.lang.StringUtils;
public  enum LocatorType {
	

    ID("id"), CLASSNAME("className"), LINKTEXT("linkText"), PARTIALLINKTEXT("partialLinkText"), CSSSELECTOR("cssSelector"), XPATH("xpath"),
    NAME("name"), TAGNAME("tagName");

    private String locatorType;
    
    private LocatorType(String locatorType) {
        this.locatorType = locatorType;
    }

    public String getLocatorType() {
        return locatorType;
    }

    public static LocatorType fromString(String element) {
        if (element != null) {
            for (LocatorType b : LocatorType.values()) {
                if (StringUtils.equalsIgnoreCase(element, b.locatorType)) {
                    return b;
                }
            }
        }
        throw new IllegalArgumentException("No such Locator exists.");
    }

}
