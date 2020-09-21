package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import functionlibrary.FunctionLibrary;
import io.appium.java_client.AppiumDriver;

public class Screenshot {
	
	
	  public static String capture(AppiumDriver driver, String screenShotName) throws IOException
	    {
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        String dest = "C:\\Project-mobile\\Hybrid-mobile\\src\\Screenshots\\"+screenShotName+ "_" + FunctionLibrary.generateDate() + ".png";
	        FileUtils.copyFile(scrFile, new File(dest));
	        return dest;
	    }
	}
	
	
	
	
	
	
	
	
	
	


