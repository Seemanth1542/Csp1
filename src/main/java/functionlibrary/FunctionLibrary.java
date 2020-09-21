package functionlibrary;



import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import propertyfileutil.Propertyfileutil;

public class FunctionLibrary {
	
	  //Method to Launch RCM App
    public static AppiumDriver launchApp(AppiumDriver driver) throws Throwable {

        /*String USERNAME = "FristNamw";
        String ACCESS_KEY = "399bfc05-a490-458e-8c5c-eba2c4151dd4";
        String neww = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub",USERNAME,ACCESS_KEY);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("name", "Demoww");
        caps.setCapability("appiumVersion", "");
        caps.setCapability("deviceName", "Samsung Galaxy S9 Plus HD GoogleAPI Emulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserName", "");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app","sauce-storage:demo2app.apk");
        caps.setCapability("build","DEmo11");

        //  caps.setCapability("Dependencies","Amazon Shopping 18.11.0.300");
        driver = new AppiumDriver(new URL(neww), caps);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
*/
/*
        DesiredCapabilities capabilities = new DesiredCapabilities();
       // capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformName", PropertyFileUtil.getValueForKey("platformName"));
        capabilities.setCapability("platformVersion", PropertyFileUtil.getValueForKey("platformVersion"));
        capabilities.setCapability("deviceName", PropertyFileUtil.getValueForKey("deviceName"));
        capabilities.setCapability("appPackage", PropertyFileUtil.getValueForKey("appPackage"));
        capabilities.setCapability("appActivity", PropertyFileUtil.getValueForKey("appActivity"));
//        capabilities.setCapability("unicodeKeyboard", true);
//        capabilities.setCapability("resetKeyboard", true);

        driver= new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);*/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("deviceName", "SM-N950F");
        capabilities.setCapability("appPackage", "com.deloitte.xamarin.client_search");
        capabilities.setCapability("appActivity", "md515373bdf711612166b2b91cc60b18f6d.MainActivity");
//
        capabilities.setCapability("clearSystemFiles", true);
        /*capabilities.setCapability("appPackage"," com.deloitte.dnmobile.cya.uat");
        capabilities.setCapability("appActivity","md50c013ef914caac18188e3844b44116df.SplashScreen");*/
        driver= new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;


    }

    public static void openApplication(AppiumDriver driver) throws Throwable {
        driver.manage().window().maximize();
        driver.get(Propertyfileutil.getValueForKey("URL"));
    }

    public static void closeApplication(AppiumDriver driver)
    {
        driver.close();
    }

    //Method to Uninstall RCM App
/*    public static void uninstallApp(AppiumDriver driver) {
        driver.removeApp("com.deloitte.dnmobile.rcm");
    }*/

    //Method to install app from Hockey
    public static void appInstall() throws Throwable {
        AppiumDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", Propertyfileutil.getValueForKey("platformName"));
        capabilities.setCapability("platformVersion", Propertyfileutil.getValueForKey("platformVersion"));
        capabilities.setCapability("deviceName", Propertyfileutil.getValueForKey("deviceName"));
        capabilities.setCapability("appPackage", "de.codenauts.hockeyapp");
        capabilities.setCapability("appActivity", "net.hockeyapp.client.navigation.HomeActivity");

        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        driver.findElement(By.id("loginBtn")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("download_button")).click();

        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        WebDriverWait wait = new WebDriverWait(driver,70);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.packageinstaller:id/ok_button")));
        driver.findElement(By.id("com.android.packageinstaller:id/ok_button")).click();
        Thread.sleep(15000);
        driver.findElement(By.id("com.android.packageinstaller:id/done_button")).click();
        driver.close();
    }

    //Method to check if RCM app is installed and then install from App center
    public static AppiumDriver installAppfromAppcenter(AppiumDriver driver,String locatorValue,String locatorValue1) throws Throwable
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", Propertyfileutil.getValueForKey("platformName"));
        capabilities.setCapability("platformVersion", Propertyfileutil.getValueForKey("platformVersion"));
        capabilities.setCapability("deviceName", Propertyfileutil.getValueForKey("deviceName"));
        capabilities.setCapability("appPackage", "com.deloitte.appcentral");
        capabilities.setCapability("appActivity", "com.deloitteresources.appcentral.AppCenter");
        capabilities.setCapability("clearSystemFiles", true);
        driver= new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        Thread.sleep(5000);
        if(driver.isAppInstalled("com.deloitte.dnmobile.rcm"))
        {
            System.out.println("App is installed");
            driver.terminateApp("com.deloitte.appcentral");

        }
        else
        {
            System.out.println("App is not installed");
            driver.findElement(By.id("username")).sendKeys(locatorValue);
            driver.findElement(By.id("password")).sendKeys(locatorValue1);
            driver.navigate().back();
            driver.findElement(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.widget.Button")).click();
            Thread.sleep(14000);
            driver.findElement(By.xpath("//android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]")).click();
            String vae = driver.findElement(By.xpath("(//android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View)[1]")).getText();
            System.out.println(vae);
            Thread.sleep(5000);
            driver.findElement(By.xpath ("//android.view.View[@bounds='[45,102][780,222]']")).sendKeys("RCM\n");
            Thread.sleep(5000);
            String app=  driver.findElement(By.xpath("(//android.widget.ListView/android.view.View[3]/android.view.View)[4]")).getText();
            System.out.println(app);
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//android.widget.ListView/android.view.View[3]/android.view.View)[4]")).click();
            String version = driver.findElement(By.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.ListView/android.view.View[3]/android.view.View[2]")).getText();
            System.out.println(version);
            driver.findElement(By.id("downloadBtn")).click();

            WebDriverWait wait = new WebDriverWait(driver,70);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.TextView")));
            System.out.println("waiting for id");
            String Openwith =driver.findElement(By.id("sem_title_default")).getText();
            System.out.println(Openwith);
            if(driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.ScrollView/android.widget.GridView/android.widget.LinearLayout[2]/android.widget.TextView")).equals("Package installer"))
            {
                String Pacakge =driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.ScrollView/android.widget.GridView/android.widget.LinearLayout[2]/android.widget.TextView")).getText();
                System.out.println(Pacakge);
                WebElement clickpackage =driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.ScrollView/android.widget.GridView/android.widget.LinearLayout[2]/android.widget.TextView"));
                clickpackage.click();
                clickpackage.click();
            }
            else
            {
                String nextpackage =driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.ScrollView/android.widget.GridView/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
                System.out.println(nextpackage);
                WebElement nextpacka =driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.ScrollView/android.widget.GridView/android.widget.LinearLayout[1]/android.widget.TextView"));
                nextpacka.click();
                nextpacka.click();

            }

            driver.findElement(By.id("com.android.packageinstaller:id/ok_button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")));
            Thread.sleep(3000);
            String Installedapp =driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")).getText();
            System.out.println(Installedapp);
            Thread.sleep(6000);
            driver.findElement(By.id("com.android.packageinstaller:id/done_button")).click();
            driver.terminateApp("com.deloitte.appcentral");

        }

        return driver;
    }

    // Method to click one locatorvalue
    public static void clickAction(AppiumDriver driver, String locatorType, String locatorValue) {

        if (locatorType.equalsIgnoreCase("id")) {
            if (driver.findElement(By.id(locatorValue)).isEnabled()) {
                driver.findElement(By.id(locatorValue)).click();
            } else {
                driver.findElement(By.id(locatorValue)).getText();
            }
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            if (driver.findElement(By.xpath(locatorValue)).isEnabled()) {
                driver.findElement(By.xpath(locatorValue)).click();
            } else {
                driver.findElement(By.xpath(locatorValue)).getText();
            }
        }/* else if (locatorType.equalsIgnoreCase("accessibilityid")) {
            if (driver.findElementsByAccessibilityId(locatorValue).isEmpty()) {
                driver.findElement(By.id(locatorValue)).click();
            } else {
                driver.findElement(By.id(locatorValue)).getText();
            }*/
        //}
    }

    // Method to check if element is displayed or not
    public static void Ifdisplayed(AppiumDriver driver, String locatorType, String locatorValue) {

        if (locatorType.equalsIgnoreCase("id")) {
            if (driver.findElement(By.id(locatorValue)).isDisplayed()) {
                String x = driver.findElement(By.id(locatorValue)).getText();
                System.out.println(x);
                driver.findElement(By.id(locatorValue)).click();
            } else {
                System.out.println("no such element");
                // driver.findElement(By.id(locatorValue)).getText();
            }
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            if (driver.findElement(By.xpath(locatorValue)).isDisplayed()) {
                String x = driver.findElement(By.id(locatorValue)).getText();
                System.out.println(x);
                driver.findElement(By.xpath(locatorValue)).click();
            } else {
                driver.findElement(By.xpath(locatorValue)).getText();
            }
        } else {
            driver.findElement(By.xpath(locatorValue)).getText();
        }
    }

    // Method to check if element is displayed or not
    public static void Valuedisplayed(AppiumDriver driver, String locatorValue, String exp_data) {

            if (driver.findElement(By.id(locatorValue)).isDisplayed()) {
                String x = driver.findElement(By.id(locatorValue)).getText();
                System.out.println(x);
                if (x == exp_data) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

            } else {
                System.out.println("no such element");
                // driver.findElement(By.id(locatorValue)).getText();
            }

    }

    //Method to type data using Sendkeys
    public static void typeAction(AppiumDriver driver, String locatorType, String locatorValue, String data) {

        if (locatorType.equalsIgnoreCase("id")) {
            driver.findElement(By.id(locatorValue)).clear();
            driver.findElement(By.id(locatorValue)).sendKeys(data);
        } else if (locatorType.equalsIgnoreCase("name")) {
            driver.findElement(By.name(locatorValue)).clear();
            driver.findElement(By.name(locatorValue)).sendKeys(data);
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            driver.findElement(By.xpath(locatorValue)).clear();
            driver.findElement(By.xpath(locatorValue)).sendKeys(data);
        }

    }

    //Expected wait
    public static void waitForElement(AppiumDriver driver,String locatorType, String locatorValue)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        if(locatorType.equalsIgnoreCase("id"))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
            // System.out.println("waiting for id");
            driver.findElement(By.id(locatorValue)).click();
        }

        else if(locatorType.equalsIgnoreCase("name"))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
//            System.out.println("waiting for name");
            driver.findElement(By.name(locatorValue)).click();
        }

        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
//            System.out.println("waiting for XPATH");
            driver.findElement(By.xpath(locatorValue)).click();
        }

        else {
            driver.findElement(By.xpath(locatorValue)).getText();
        }

    }

    public static void ifExistsTaponElement(AppiumDriver driver,String locatorType, String locatorValue, String locatorValue1) throws InterruptedException {

        if (locatorType.equalsIgnoreCase("id")) {
            boolean find = true;

            if (find)
            {
                driver.findElement(By.id(locatorValue)).isDisplayed();
                String x= driver.findElement(By.id(locatorValue)).getText();
                System.out.println(x);
                driver.findElement(By.id(locatorValue)).click();
            } else{
                String x= driver.findElement(By.id(locatorValue1)).getText();
                System.out.println(x);
                driver.findElement(By.id(locatorValue1)).click();
                System.out.println("No element exists");
            }
        }

        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            boolean find = driver.findElement(By.xpath(locatorValue)).isDisplayed();

            if (find){
                String x= driver.findElement(By.xpath(locatorValue)).getText();
                System.out.println(x);
                driver.findElement(By.xpath(locatorValue)).click();
            } else{
                System.out.println("No element exists");
//                String x= driver.findElement(By.xpath(locatorValue1)).getText();
//                System.out.println(x);
//                driver.findElement(By.xpath(locatorValue1)).click();
            }
        }

        else
        {
            System.out.println("No slide button");
        }
    }

public static void appclose(AppiumDriver driver)
{

}
    public  static void touch(AppiumDriver driver, String locatorType, String locatorValue) {

//        if (locatorType.equalsIgnoreCase("id")) {
//            new TouchAction(driver).tap(tapOptions().withElement(driver.findElement(By.id(locatorValue)))).perform();
//        }
        if (locatorType.equalsIgnoreCase("id")) {
            AndroidTouchAction touch = new AndroidTouchAction(driver);
            touch.tap(tapOptions().withElement(element(driver.findElement(By.id(locatorValue))))).perform();
        }
        else if (locatorType.equalsIgnoreCase("xpath")) {
            AndroidTouchAction touch = new AndroidTouchAction(driver);
            touch.tap(tapOptions().withElement(element(driver.findElement(By.xpath(locatorValue))))).perform();
        } else {
            driver.findElement(By.id(locatorValue)).getText();
        }
    }

    // Method to gettext and validate
    public static void getText(AppiumDriver driver,String locatorType, String locatorValue,String exp_title)
    {
        //driver.findElement(By.xpath(locatorValue)).clear();
        String act_title =driver.findElement(By.xpath(locatorValue)).getText();
       System.out.println(act_title);
        //assertEquals(exp_title,act_title);
    }

    //Method for title validations
    public static void titleValidation(AppiumDriver driver,String exp_title)
    {
        String act_title = driver.getTitle();
//        System.out.println(act_title);
        assertEquals(exp_title,act_title);
//        Assert.hasText(exp_title,act_title);
    }

    public static void validations(AppiumDriver driver,String locatorType, String locatorValue, String exp_title)
    {

        if(locatorType.equalsIgnoreCase("id"))
        {
            //driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")).click();
            String Enve =driver.findElement(By.id(locatorValue)).getText();
            System.out.println(Enve);
            assertEquals(exp_title, Enve);
        }

        else if(locatorType.equalsIgnoreCase("name"))
        {
            String Enve =driver.findElement(By.name(locatorValue)).getText();
            System.out.println(Enve);
            assertEquals(exp_title, Enve);
        }

        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            String Enve =driver.findElement(By.xpath(locatorValue)).getText();
            System.out.println(Enve);
            assertEquals(exp_title, Enve);
        }

    }

    public static void mouseOveractions(AppiumDriver driver,String locatorType,String locatorValue)
    {
        Actions act = new Actions(driver);
        if(locatorType.equalsIgnoreCase("id"))
        {
            MobileElement click = (MobileElement) driver.findElement(By.id(locatorValue));
            act.moveToElement(click).click().build().perform();
        }

        else if(locatorType.equalsIgnoreCase("name"))
        {
            MobileElement click = (MobileElement) driver.findElement(By.name(locatorValue));
            act.moveToElement(click).click().build().perform();
        }
        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            MobileElement click = (MobileElement) driver.findElement(By.xpath(locatorValue));
            act.moveToElement(click).click().build().perform();
        }

    }

    public static void frameFunciton(AppiumDriver driver,String locatorType,String locatorValue)
    {

    }

    public static void termsandconditions(AppiumDriver driver,String locatorType,String locatorValue)
    {

        if(locatorType.equalsIgnoreCase("id")) {
            String Enve = driver.findElement(By.id(locatorValue)).getText();
            System.out.println(Enve);
            if (Enve.equalsIgnoreCase("Terms of use"))
            {
                driver.findElement(By.id("agreeButton")).click();
            } else
            {
                driver.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.LinearLayout")).click();
            }
        }
    }

    public static String generateDate()
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_dd_hh_mm_ss");
        return sdf.format(date);

    }

    public static void uploadFile(AppiumDriver driver,String locatorType,String locatorValue,String data)
    {
        if(locatorType.equalsIgnoreCase("name"))
        {
            WebElement fileInput = driver.findElement(By.name(locatorValue));
            fileInput.sendKeys(data);
        }
        else if(locatorType.equalsIgnoreCase("id"))
        {
            WebElement fileInput = driver.findElement(By.id(locatorValue));
            fileInput.sendKeys(data);
        }
        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            WebElement fileInput = driver.findElement(By.xpath(locatorValue));
            fileInput.sendKeys(data);
        }
    }


    public static void capturedata(AppiumDriver driver, String locatorType,String locatorValue) throws Throwable
    {
        String text ="";

        if(locatorType.equalsIgnoreCase("id"))
        {
            text = driver.findElement(By.id(locatorValue)).getAttribute("value");

        }

        else if(locatorType.equalsIgnoreCase("name"))
        {
            text= driver.findElement(By.name(locatorValue)).getAttribute("value");
        }
        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            text= driver.findElement(By.xpath(locatorValue)).getAttribute("value");
        }

        FileWriter re =  new FileWriter("");
        BufferedWriter dr = new BufferedWriter(re);
        dr.write(text);
        dr.flush();

    }

    public static  void webdriver_wait() throws Throwable
    {
        Thread.sleep(5000);
    }

    public static  void waitfewseconds() throws Throwable
    {
        Thread.sleep(3000);
    }

    public static void mobilebackButton(AppiumDriver driver)
    {
        driver.navigate().back();
    }

    public static void tablevalidation(AppiumDriver driver,String column) throws Throwable
    {
        FileReader fe = new FileReader("");
        BufferedReader fs = new BufferedReader(fe);
        String exp_data = fs.readLine();
        //Converting form interger to string
        int colnum1 = Integer.parseInt(column);

        WebElement webtable = driver.findElement(By.xpath(""));
        List<WebElement> rows = webtable.findElements(By.xpath(""));
        for(int i=1;i<=rows.size();i++)
        {
            String act = driver.findElement(By.xpath("")).getText();
            Assert.hasText(exp_data, act);
            break;

        }

    }

    public static void scrolldown(AppiumDriver driver)
    {
        Dimension dimensions = driver.manage().window().getSize();
        int x = (dimensions.width * 0) / 100;
        int ex = (dimensions.width * 35) / 100;
        int y = (dimensions.width * 0) / 100;
        int ey = (dimensions.width * 35) / 100;

        TouchAction ta = new TouchAction(driver);
        ta.press(new PointOption().withCoordinates(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(ex, ey)).release().perform();

    }

    public static void scrollup(AppiumDriver driver)
    {

        Dimension dimensions = driver.manage().window().getSize();
        int x = (dimensions.width * 0) / 100;
        int ex = (dimensions.width * 35) / 100;
        int y = (dimensions.width * 0) / 100;
        int ey = (dimensions.width * 35) / 100;

        TouchAction ta = new TouchAction(driver);
        ta.press(new PointOption().withCoordinates(ex, ey)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(x, y)).release().perform();

    }

    public static void scrollLeft(AppiumDriver driver, String locatorType,String locatorValue )
    {
        if(locatorType.equalsIgnoreCase("id"))
        {
            driver.findElement(By.id(locatorValue)).click();
            Dimension dimensions = driver.manage().window().getSize();
            int x = (dimensions.width * 0) / 100;
            int ex = (dimensions.width * 35) / 100;
            int y = (dimensions.width * 0) / 100;
            int ey = (dimensions.width * 35) / 100;

            TouchAction ta = new TouchAction(driver);
            ta.press(new PointOption().withCoordinates(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(ex, ey)).release().perform();
        }
        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            driver.findElement(By.id(locatorValue)).click();
            Dimension dimensions = driver.manage().window().getSize();
            int x = (dimensions.width * 0) / 100;
            int ex = (dimensions.width * 35) / 100;
            int y = (dimensions.width * 0) / 100;
            int ey = (dimensions.width * 35) / 100;

            TouchAction ta = new TouchAction(driver);
            ta.press(new PointOption().withCoordinates(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(ex, ey)).release().perform();
        }
    }
    public static void scrollRight(AppiumDriver driver, String locatorType,String locatorValue ) {
        if (locatorType.equalsIgnoreCase("id")) {
            driver.findElement(By.id(locatorValue)).click();

            Dimension dimensions = driver.manage().window().getSize();
            int ex = (dimensions.width * 35) / 100;
            int x = (dimensions.width * 0) / 100;
            int ey = (dimensions.width * 35) / 100;
            int y = (dimensions.width * 0) / 100;

            TouchAction ta = new TouchAction(driver);
            ta.press(new PointOption().withCoordinates(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(ex, ey)).release().perform();

        } else if (locatorType.equalsIgnoreCase("xpath")) {
            driver.findElement(By.id(locatorValue)).click();
            Dimension dimensions = driver.manage().window().getSize();
            int ex = (dimensions.width * 35) / 100;
            int x = (dimensions.width * 0) / 100;
            int ey = (dimensions.width * 35) / 100;
            int y = (dimensions.width * 0) / 100;

            TouchAction ta = new TouchAction(driver);
            ta.press(new PointOption().withCoordinates(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(ex, ey)).release().perform();
        }
    }

    public static void swipeLeft(AppiumDriver driver,String locatorType,String locatorValue)
    {
        if(locatorType.equalsIgnoreCase("id"))
        {
            WebElement banner = driver.findElement(By.id(locatorValue));
            Point bannerPoint = banner.getLocation();
            // Get size of device screen
            Dimension screenSize = driver.manage().window().getSize();
            // Get start and end coordinates for horizontal swipe
            int startX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
            System.out.println(startX);
            int endX = 0;

            TouchAction action = new TouchAction(driver);
            action
                    .press(PointOption.point(startX, bannerPoint.getY()))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(endX, bannerPoint.getY()))
                    .release();
            driver.performTouchAction(action);
        }

        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            WebElement banner = driver.findElement(By.xpath(locatorValue));
            Point bannerPoint = banner.getLocation();
            // Get size of device screen
            Dimension screenSize = driver.manage().window().getSize();
            // Get start and end coordinates for horizontal swipe
            int startX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
            System.out.println(startX);
            int endX = 0;

            TouchAction action = new TouchAction(driver);
            action
                    .press(PointOption.point(startX, bannerPoint.getY()))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(endX, bannerPoint.getY()))
                    .release();
            driver.performTouchAction(action);
        }
    }



    public static void swipeRight(AppiumDriver driver,String locatorType,String locatorValue)
    {
        if (locatorType.equalsIgnoreCase("id")) {
            WebElement banner = driver.findElement(By.id(locatorValue));
            Point bannerPoint = banner.getLocation();
            // Get size of device screen
            Dimension screenSize = driver.manage().window().getSize();
            // Get start and end coordinates for horizontal swipe
            int startX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
            System.out.println(startX);
            int endX = 0;

            TouchAction action = new TouchAction(driver);
            action
                    .press(PointOption.point(endX, bannerPoint.getY()))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(startX, bannerPoint.getY()))
                    .release();
            driver.performTouchAction(action);
        }
        else if (locatorType.equalsIgnoreCase("xpath")) {
            WebElement banner = driver.findElement(By.xpath(locatorValue));
            Point bannerPoint = banner.getLocation();
            // Get size of device screen
            Dimension screenSize = driver.manage().window().getSize();
            // Get start and end coordinates for horizontal swipe
            int startX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
            System.out.println(startX);
            int endX = 0;

            TouchAction action = new TouchAction(driver);
            action
                    .press(PointOption.point(endX, bannerPoint.getY()))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(startX, bannerPoint.getY()))
                    .release();
            driver.performTouchAction(action);
        }
    }
    public static void multiplesendkeys(AppiumDriver driver,String locatorType, String locatorValue ,String locatorValue1,String data,String data1) throws InterruptedException
    {
        if (locatorType.equalsIgnoreCase("id")) {
            driver.findElement(By.id(locatorValue)).clear();
            driver.findElement(By.id(locatorValue)).sendKeys(data);
            if (driver.findElement(By.id(locatorValue1)).isDisplayed()) {
                driver.findElement(By.id(locatorValue)).clear();
                driver.findElement(By.id(locatorValue)).sendKeys(data1);
                String x = driver.findElement(By.id(locatorValue)).getText();
                System.out.println(x);

            }
            else
            {
                driver.findElement(By.id(locatorValue)).sendKeys(data);
            }
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            driver.findElement(By.xpath(locatorValue)).clear();
            driver.findElement(By.xpath(locatorValue)).sendKeys(data);
            if (driver.findElement(By.xpath(locatorValue1)).isDisplayed()) {
                driver.findElement(By.xpath(locatorValue)).clear();
                driver.findElement(By.xpath(locatorValue)).sendKeys(data1);
            }
        }

    }

    public static void cellData(AppiumDriver driver,String locatorType,String locatorValue)
    {
        if(locatorType.equalsIgnoreCase("xpath"))
        {
            List<WebElement> cell = driver.findElements(By.xpath(locatorValue));
            int c = cell.size();
            System.out.println(c);
            for(int i=0;i<=c-1;c++)
            	
            {
	
	
	
	
	
	
            }
	
	
	
	
	
	
        }
	
	
    }
	

}
