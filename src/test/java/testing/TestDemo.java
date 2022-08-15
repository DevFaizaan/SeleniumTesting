package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDemo {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		this.driver = new EdgeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		// opens a new window
	}

	@Test
	void demoTest() throws InterruptedException {
		this.driver.get("http://automationpractice.com/index.php"); // goes to the page
		//driver.get("http://automationpractice.com/index.php");
		WebElement searchBar = driver.findElement(By.id("search_query_top"));
		String searchTerm = "Dress";
		searchBar.sendKeys(searchTerm);
		searchBar.submit();
		// String productName = driver.findElement(By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line.hovered > div > div.right-block > h5 > a")).getText();
		// assertEquals("Printed Summer Dress", productName);

		WebElement dressClick =  driver.findElement(By.className("product_img_link"));
		dressClick.click();

		WebElement addToCart = driver.findElement(By.className("box-cart-bottom"));
		addToCart.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Thread.sleep(3000);
		WebElement checkout = driver.findElement(By.className("button-container"));
		checkout.click();
		//driver.findElement(By.className("btn btn-default button button-medium")).click();
		WebElement proceed = driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium"));
		proceed.click();
		
		WebElement signUp = driver.findElement(By.id("email_create"));
		signUp.sendKeys("test@gmail.com");
		signUp.submit();
	}


	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}