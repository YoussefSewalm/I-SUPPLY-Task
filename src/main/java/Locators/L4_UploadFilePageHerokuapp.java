package Locators;

import org.openqa.selenium.By;

public class L4_UploadFilePageHerokuapp {

	//Button
	public static By ChooseFileButton=By.id("file-upload");
	public static By UploadFileButton=By.id("file-submit");
	//Text
	public static By VerifyUploadSuccessfullText=By.cssSelector("div[class=\"example\"]>h3");
	public static By VerifyFileNameText=By.id("uploaded-files");
	
}
