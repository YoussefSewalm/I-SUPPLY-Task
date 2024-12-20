package Pages;

import CoreElements.*;
import static Locators.L1_HomePageGoogle.*; 

public class P1_HomePageGoogle {

	//Buttons
    public static Buttons Search=new Buttons(SearchButton);

	//FormField
	public static FormField SearchField=new FormField(SearchTextField);	
	
	//Text
	public static Text VerifyGoogle=new Text(VerifyGoogleText);
}
