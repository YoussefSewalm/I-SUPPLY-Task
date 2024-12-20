package Pages;

import java.time.Duration;

import com.shaft.driver.SHAFT;

import CoreElements.Elements;

public class DriverInitiator {

    public static SHAFT.GUI.WebDriver driver;

    public static void startDriverSession(){
        // Create new driver object
        driver = new SHAFT.GUI.WebDriver();
        // Go to the website
        Elements.setDriver(driver);
        driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Global Wait
    }

    public static void EndDriverSession(){
        // Quit the WebDriver instance
        driver.quit();
    }
}
