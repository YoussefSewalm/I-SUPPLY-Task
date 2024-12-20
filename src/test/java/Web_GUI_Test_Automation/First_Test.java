package Web_GUI_Test_Automation;

import static Pages.P1_HomePageGoogle.*;
import static Pages.P2_SearchResultsPage.*;
import static DataDrivenWithJSONFile.JSONFileModifier.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class First_Test extends TestBase{
	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//resources//testDataFiles//TestData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(0) }   } ;
	}
	@Test(dataProvider="getData")
	public void Test_1(HashMap<String,String> input)
	{
        driver.browser().navigateToURL(input.get("Url"));
        driver.verifyThat().browser().title().isEqualTo(input.get("Title")).perform();
		VerifyGoogle.VerifyTextContains(input.get("HomePageText"));
		SearchField.SendText(input.get("SearchText"));
        SearchField.PressKey();	
        SearchItemVerify.VerifyTextContains(input.get("SearchResult"));
	}
}
