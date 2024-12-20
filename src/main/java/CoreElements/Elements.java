package CoreElements;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class Elements {
	
    static SHAFT.GUI.WebDriver driver;
    By elementLocator;
    
	public static void setDriver(SHAFT.GUI.WebDriver driver1) 
	{
      driver=driver1;		
	}

    public Elements(By locator)
    {
    	elementLocator=locator;
    }
    
    public void click() 
    {
    	driver.element().click(elementLocator);
    }


}
