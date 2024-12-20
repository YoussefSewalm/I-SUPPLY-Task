package Locators;

import org.openqa.selenium.By;

public class L6_Example2DynamicLoadingPage {
	
	//Text
	public static By VerifyExampleTwoText=By.xpath("//div[@class=\"example\"]/h4");
	public static By VerifyElementsLoadedText=By.cssSelector("div[id=\"finish\"]>h4");
	//Button
	public static By StartButton=By.cssSelector("div[id=\"start\"]>button");

}
