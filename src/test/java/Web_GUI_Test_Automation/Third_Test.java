package Web_GUI_Test_Automation;

import static DataDrivenWithJSONFile.JSONFileModifier.getJsonData;
import static Pages.P3_HomePageHerokuapp.*;
import static Pages.P5_DynamicLoadingPageHerokuapp.*;
import static Pages.P6_Example2DynamicLoadingPage.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Third_Test extends TestBase{
	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//resources//testDataFiles//TestData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(2) }   } ;
	}
	
	@Test(dataProvider="getData")
	public void Test_3(HashMap<String,String> input)
	{
        driver.browser().navigateToURL(input.get("Url"));
        driver.verifyThat().browser().title().isEqualTo(input.get("Title")).perform();
        VerifyHerokuapp.VerifyTextContains(input.get("HomePageText"));
        DynamicLoading.click();
        VerifyDynamicLoadingPage.VerifyTextContains(input.get("DynamicPageText"));
        Example2.click();
        VerifyExampleTwo.VerifyTextContains(input.get("Example_2 Text"));
        Start.click();
        VerifyElementsLoaded.VerifyTextContains(input.get("ElementsLoadedSuccessText"));    
	}

}
