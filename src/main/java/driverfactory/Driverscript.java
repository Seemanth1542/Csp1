package driverfactory;

import com.relevantcodes.extentreports.ExtentReports;

import datadriven.Excelfileutil;
import functionlibrary.FunctionLibrary;

public class Driverscript {

	
	
	public void startTest() throws Throwable
    {
        Excelfileutil excel = new Excelfileutil();
        //Module sheets

        for(int i=1;i<=excel.rowcount("MasterTestCases");i++)
        {
            String Modulestatus="";
            if (excel.getData("MasterTestCases", i, 2).equalsIgnoreCase("Y"))
            {
                String TCModule = excel.getData("MasterTestCases",i, 1);
                //Generate Extent Reports

                report = new ExtentReports("C:\\Project-mobile\\Hybrid-mobile\\src\\Reports\\"+TCModule+".html"+"_"+ FunctionLibrary.generateDate());
                logger = report.startTest(TCModule);

                int row_count = excel.rowcount(TCModule);
                //Corresponding sheets

                for(int j=1;j<=row_count;j++)
                {
                    String Description = excel.getData(TCModule, j,0);
                    String Object_Type = excel.getData(TCModule, j,1);
                    String Locator_Type = excel.getData(TCModule,j,2);
                    String Locator_Value = excel.getData(TCModule,j,3);
                    String Locator_Value1 = excel.getData(TCModule,j,4);
                    String Locator_Value2 = excel.getData(TCModule,j,5);
                    String Test_Data = excel.getData(TCModule,j,6);
                    String Test_Data1 = excel.getData(TCModule,j,7);
                    try
                    {
                        if(Object_Type.equalsIgnoreCase("appInstall"))
                        {
                            FunctionLibrary.appInstall();
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("launchApp"))
                        {
                            driver = FunctionLibrary.launchApp(driver);
                            logger.log(LogStatus.INFO,Description);
                        }
                       /* if(Object_Type.equalsIgnoreCase("uninstallApp"))
                        {
                            FunctionLibrary.uninstallApp(driver);
                            logger.log(LogStatus.INFO,Description);
                        }*/
                        if(Object_Type.equalsIgnoreCase("openApplication"))
                        {
                            FunctionLibrary.openApplication(driver);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("waitForElement"))
                        {
                            FunctionLibrary.waitForElement(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("typeAction"))
                        {
                            FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("clickAction"))
                        {
                            FunctionLibrary.clickAction(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("closeApplication"))
                        {
                            FunctionLibrary.closeApplication(driver);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("getText"))
                        {
                            FunctionLibrary.getText(driver, Locator_Type, Locator_Value,Test_Data);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("mouseOveractions"))
                        {
                            FunctionLibrary.mouseOveractions(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("titleValidation"))
                        {
                            FunctionLibrary.titleValidation(driver, Test_Data);
                            logger.log(LogStatus.INFO,Description);
                        }
                       /* if(Object_Type.equalsIgnoreCase("touch"))
                        {
                            FunctionLibrary.touch(driver,  Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }*/
                        if(Object_Type.equalsIgnoreCase("Ifdisplayed"))
                        {
                            FunctionLibrary.Ifdisplayed(driver,  Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("validations"))
                        {
                            FunctionLibrary.validations(driver,  Locator_Type, Locator_Value,Test_Data);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("ifExistsTaponElement"))
                        {
                            FunctionLibrary.ifExistsTaponElement(driver,  Locator_Type, Locator_Value, Locator_Value1);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("frameFunction"))
                        {
                            FunctionLibrary.frameFunciton(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("generateDate"))
                        {
                            FunctionLibrary.generateDate();
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("mobilebackButton"))
                        {
                            FunctionLibrary.mobilebackButton(driver);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("webdriver_wait"))
                        {
                            FunctionLibrary.webdriver_wait();
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("termsandconditions"))
                        {
                            FunctionLibrary.termsandconditions(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("scrolldown"))
                        {
                            FunctionLibrary.scrolldown(driver);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("scrollup"))
                        {
                            FunctionLibrary.scrollup(driver);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("scrollLeft"))
                        {
                            FunctionLibrary.scrollLeft(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("scrollRight"))
                        {
                            FunctionLibrary.scrollRight(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("swipeLeft"))
                        {
                            FunctionLibrary.swipeLeft(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("swipeRight"))
                        {
                            FunctionLibrary.swipeRight(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("waitfewseconds"))
                        {
                            FunctionLibrary.waitfewseconds();
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("cellData"))
                        {
                            FunctionLibrary.cellData(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("backloopingbutton"))
                        {
                            FunctionLibrary.backloopingbutton(driver);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("tapelementmultipletimes"))
                        {
                            FunctionLibrary.tapelementmultipletimes(driver, Locator_Type, Locator_Value);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("multiplesendkeys"))
                        {
                            FunctionLibrary.multiplesendkeys(driver, Locator_Type, Locator_Value, Locator_Value1, Test_Data, Test_Data1);
                            logger.log(LogStatus.INFO,Description);
                        }
                        if(Object_Type.equalsIgnoreCase("taponthreedots"))
                        {
                            FunctionLibrary.taponthreedots(driver, Locator_Type, Locator_Value, Locator_Value1);
                            logger.log(LogStatus.INFO,Description);
                        }
                       /* if(Object_Type.equalsIgnoreCase("sukiliscreen"))
                        {
                            FunctionLibrary.sukiliscreen(Locator_Value,Test_Data);
                            logger.log(LogStatus.INFO,Description);
                        }*/
                        excel.setData(TCModule, j,8, "Pass");
                        Modulestatus ="true";
                        logger.log(LogStatus.PASS,Description+" Pass ");
                        String screenShotPath = GetScreenShot.capture(driver, MethodName);
                        logger.log(LogStatus.PASS, "Snapshot below: " + logger.addScreenCapture(screenShotPath));

                    }
                    catch(Exception e)
                    {
                        excel.setData(TCModule, j, 8, "Fail");
                        Modulestatus = "false";
                        logger.log(LogStatus.FAIL, Description + " Fail ");
                        //Generating Screenshots

                        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        FileHandler.copy(scrFile, new File("C:\\Project-mobile\\Hybrid-mobile\\src\\Screenshots\\" + Description + "_" + FunctionLibrary.generateDate() + ".jpg"));
                        String screenShotPath = GetScreenShot.capture(driver, MethodName);
                        logger.log(LogStatus.FAIL, "Snapshot below: " + logger.addScreenCapture(screenShotPath));
                        break;
                    }
                    catch(AssertionError e)
                    {
                        excel.setData(TCModule, j,8,"Fail");
                        Modulestatus ="false";

                        logger.log(LogStatus.FAIL,Description+" Fail ");
                        //Generating Screenshots

                        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                        FileHandler.copy(scrFile,new File("C:\\Project-mobile\\Hybrid-mobile\\src\\Screenshots"+Description+"_"+FunctionLibrary.generateDate()+".jpg"));
                        String screenShotPath = GetScreenShot.capture(driver, MethodName);
                        logger.log(LogStatus.FAIL, "Snapshot below: " + logger.addScreenCapture(screenShotPath));
                        break;
                    }

                }
                if(Modulestatus.equalsIgnoreCase("true"))
                {
                    excel.setData("MasterTestCases", i, 3, "Pass");
                }
                else if(Modulestatus.equalsIgnoreCase("false"))
                {
                    excel.setData("MasterTestCases", i, 3, "Fail");
                }
                else
                {
                    excel.setData("MasterTestCases", i, 3, "Skip");
                }

            }
            else
            {
                excel.setData("MasterTestCases", i, 3, "Not Executed");
            }

            report.endTest(logger);
            report.flush();

        }

    }

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
