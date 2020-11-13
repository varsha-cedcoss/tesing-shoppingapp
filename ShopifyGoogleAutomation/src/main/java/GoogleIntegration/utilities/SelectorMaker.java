package GoogleIntegration.utilities;
import java.lang.reflect.Field;
import Framework.GUI.commons.page.commonPage;
import Framework.GUI.element.Link;
import Framework.GUI.element.UIElement;

public class SelectorMaker<String> {

	private String page;
	private String elementType;
	
	public SelectorMaker(String pagename)
	{
		page = pagename;
	}
	public <T> void selectorMaker(String element ,String type, commonPage pageObject) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException
	{		
		
						System.out.println("Page name is : "+pageObject.getPageName());
						System.out.println("Length is : "+type.toString().length());
						System.out.println("Name : " + element + " , Type : " + type.toString());
						String[] arr = (String[]) type.toString().split("\\.");
						System.out.println("Arr length : "+arr.length);
						elementType=arr[5];
						System.out.println("Element type : "+elementType);
						Class<?> cls = Class.forName("walmartIntegration.pages." + pageObject.getPageName());
						Field field = cls.getDeclaredField(element.toString());
						field.setAccessible(true);

		switch (elementType.toString())
		{
		case "Link":
			System.out.println("Link Called");
			field.set(pageObject, (T) new Link(ReadXML.getElementLocator(page.toString(), element.toString()), page.toString() ,element.toString()));
			break;
		case "UIElement":
			field.set(pageObject, (T) new UIElement(ReadXML.getElementLocator(page.toString(), element.toString()), page.toString() ,element.toString()));
			break;
        default: 
            System.out.println("Invalid Selector"); 
		}
	}
	
}
