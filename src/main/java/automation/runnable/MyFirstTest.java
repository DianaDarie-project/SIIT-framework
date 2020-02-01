package automation.runnable;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Diana
 *
 */

public class MyFirstTest {
	@Test // TestNG annotation
	public void myFirstTest() {

		// tell selenium where to find the chromedriver binary
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		// initialize a new driver object

		WebDriver driver = new ChromeDriver();
		// call method get() of driver object, to navigate to an address

		driver.get("http://www.google.com");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("koala", Keys.RETURN);

		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		 .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
		System.out.println(myDynamicElement.getText());

		List<WebElement> resultTitleElements = driver.findElements(By.cssSelector("div.r h3"));

		System.out.println(resultTitleElements.size());

		for (WebElement we : resultTitleElements) {
			System.out.println(we.getText());
		 WebElement resultTitle = we.findElement(By.xpath(".."));
		 String title = resultTitle.getAttribute("href");
		 System.out.println(title);
		}

		driver.quit();
	}
}
