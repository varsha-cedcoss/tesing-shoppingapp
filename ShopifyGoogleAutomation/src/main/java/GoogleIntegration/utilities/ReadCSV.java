package GoogleIntegration.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import GoogleIntegration.automation.GlobalConfig;


public class ReadCSV{
	
	public static final String delimiter = ",";
	public static Boolean capture = false;
	public static String parameterToBeReturned="";
	

	public static String getParameter(String parameterName)
	{
		File file = new File(System.getProperty("user.dir") + GlobalConfig.INPUTDATA_CSVFILE_PATH);
		try(FileReader fr = new FileReader(file) ; BufferedReader br = new BufferedReader(fr);) 
		{	
			String line = "";
			String[] tempArr;		
						
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				for (String tempStr : tempArr) {
					if(capture) { 
						parameterToBeReturned = tempStr;
						capture = false;
						break;
					}
					if(tempStr.equalsIgnoreCase(parameterName)){
						capture = true;
					}
				}
			}
			br.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	
		
		
		System.out.println("Value found for key: " +parameterName+ " is: " +parameterToBeReturned);
		return parameterToBeReturned;
	}
}
  
