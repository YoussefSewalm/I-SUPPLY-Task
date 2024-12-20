package Web_GUI_Test_Automation;

import static DataDrivenWithJSONFile.JSONFileModifier.getJsonData;
import static Pages.P3_HomePageHerokuapp.*;
import static Pages.P4_UploadFilePageHerokuapp.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Second_Test extends TestBase{
	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//resources//testDataFiles//TestData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(1) }   } ;
	}
	
	@Test(dataProvider="getData")
	public void Test_2(HashMap<String,String> input)
	{
        driver.browser().navigateToURL(input.get("Url"));
        driver.verifyThat().browser().title().isEqualTo(input.get("Title")).perform();
        VerifyHerokuapp.VerifyTextContains(input.get("HomePageText"));
        FileUpload.click();
        ChooseFile.Upload();
        UploadFile.click();
        VerifyUploadSuccessfull.VerifyTextContains(input.get("UploadSuccessText"));
        VerifyFileName.VerifyTextContains(input.get("FileName"));   
	}
}
