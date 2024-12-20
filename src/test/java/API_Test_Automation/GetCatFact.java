package API_Test_Automation;

import static DataDrivenWithJSONFile.JSONFileModifier.getJsonData;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shaft.api.RestActions;
import com.shaft.api.RestActions.RequestType;
import com.shaft.driver.DriverFactory;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetCatFact {
	
	
	public RestActions APIObject; 
	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//resources//testDataFiles//TestData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(3) }   } ;
	}
	
	@Test(dataProvider="getData")
	public void GettingCatFactAndVerifyingIt(HashMap<String,String> input) throws JSONException
	{
		
		APIObject=DriverFactory.getAPIDriver(input.get("Url"));
		Response GetAllCatFacts=APIObject.buildNewRequest("/facts", RequestType.GET)
			     .setContentType(ContentType.JSON)
			     .performRequest();
		//Get a Cat Fact from the response
		String CatFact=RestActions.getResponseJSONValue(GetAllCatFacts, "[1].text");
		String Fact_ID=RestActions.getResponseJSONValue(GetAllCatFacts, "[1]._id");
		Assert.assertEquals(CatFact,input.get("CatFact"));

		//Verifying Fact exists by Id
		Response GetaCatFact=APIObject.buildNewRequest("/facts/"+Fact_ID, RequestType.GET)
			     .setContentType(ContentType.JSON)
			     .performRequest();
		String ActualCatFact=RestActions.getResponseJSONValue(GetaCatFact, "text");
		Assert.assertEquals(ActualCatFact,input.get("CatFact"));
    }
}
