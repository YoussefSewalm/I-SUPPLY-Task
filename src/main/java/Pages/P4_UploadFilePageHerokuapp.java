package Pages;
import CoreElements.*;
import static Locators.L4_UploadFilePageHerokuapp.*;

public class P4_UploadFilePageHerokuapp {
	
	//Button
	public static Buttons UploadFile = new Buttons(UploadFileButton);
	public static Buttons ChooseFile = new Buttons(ChooseFileButton);
	//Text
    public static Text VerifyUploadSuccessfull = new Text(VerifyUploadSuccessfullText);
    public static Text VerifyFileName = new Text(VerifyFileNameText);
}
