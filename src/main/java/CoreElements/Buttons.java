package CoreElements;

import org.openqa.selenium.By;

public class Buttons extends Elements {

	public Buttons(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	public void Upload()
	{
        driver.element().type(elementLocator, System.getProperty("user.dir") + "\\src\\test\\resources\\selenium.png");
	}
	

	
}
