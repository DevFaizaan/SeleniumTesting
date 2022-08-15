package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class stockTest {
	 private RemoteWebDriver driver;

	    @BeforeEach
	    void setup() {
	        this.driver = new EdgeDriver();
	        driver.manage().window().setSize(new Dimension(1366, 768));
	        // opens a new window
	    }

	    @Test
	    void demoTest() {
	        this.driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100"); // goes to the page
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement cookieClick = driver.findElement(By.id("acceptCookieButton"));
	        cookieClick.click();
	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
	        //driver.get("http://automationpractice.com/index.php");
	        WebElement riserClick = driver.findElement(By.xpath("//*[@id=\"content_div_40583\"]/ul/li[2]/a"));
	        
	        //String searchTerm = "Dress";
	       // searchBar.sendKeys(searchTerm);
	        riserClick.click();
	            String productName = driver.findElement(By.cssSelector("#ls-row-FLTR-L > td.name-col.align-left > a")).getText();
	           assertEquals("Flutter Entertainment", productName);
	    }
	    

	    @AfterEach
	    void tearDown() {
	        this.driver.close();
	    }
}
