package GoogleIntegration.utilities;

import java.lang.reflect.Field;

import Framework.GUI.commons.page.commonPage;

public class SetVariables {
	
	public  SetVariables(commonPage page)
	{		
		System.out.println("Page name is : "+page.getPageName());
		// Using Reflections and Generics to get all variable in Page class and create their object
				SelectorMaker<String> sm = new SelectorMaker<String>(page.getPageName());
				try {
					Class<?> cls = Class.forName("walmartIntegration.pages." + page.getPageName());
					for (Field f : cls.getDeclaredFields()) {
						if (!(f.getType().getName().contains("page"))) {
							System.out.println("Field name : "+f.getName());
							sm.selectorMaker(f.getName(),f.getType().getName(),page);
						}
					}
				} catch (Exception e) {
					System.out.println("Exception");
					e.printStackTrace();
				}
	}

}
