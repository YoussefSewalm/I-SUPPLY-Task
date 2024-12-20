package Web_GUI_Test_Automation;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.DriverInitiator;


public class TestBase extends DriverInitiator{


	@BeforeClass
	public static void navigate()
	{
		DriverInitiator.startDriverSession();
	}
	
	@AfterClass
	public static void CloseBrowser()
	{
		DriverInitiator.EndDriverSession();
    }
}
