package CoreElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Text extends Elements{

	public Text(By locator) {
		super(locator);
	}

	public String GetText()
	{
		Wait<WebDriver> wait=new FluentWait<>(driver.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(300))
				.ignoring(StaleElementReferenceException.class);
		
		wait.until(
				d -> {
				   driver.verifyThat().element(elementLocator).exists().perform();
				   return true;
		         	});
		return driver.element().getText(elementLocator);
	}
	public void VerifyTextExists()
	{
		Wait<WebDriver> wait=new FluentWait<>(driver.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(300))
				.ignoring(StaleElementReferenceException.class);
		
		wait.until(
				d -> {
				   driver.verifyThat().element(elementLocator).exists().perform();
				   return true;
		         	});
        driver.assertThat().element(elementLocator).exists().perform();
	}
	
    public void VerifyTextContains(String expectedtext)
    {
		Wait<WebDriver> wait=new FluentWait<>(driver.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(300))
				.ignoring(StaleElementReferenceException.class);
		
		wait.until(
				d -> {
				   driver.verifyThat().element(elementLocator).exists().perform();
				   return true;
		         	});
        driver.assertThat().element(elementLocator).text().contains(expectedtext).perform();
    }
}
