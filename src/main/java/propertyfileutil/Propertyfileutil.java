package propertyfileutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertyfileutil {

	  public static String getValueForKey(String Key) throws Throwable, IOException
	    {
	        Properties configProp = new Properties();
	        configProp.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\Environment.properties"));

	        return configProp.getProperty(Key);
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

