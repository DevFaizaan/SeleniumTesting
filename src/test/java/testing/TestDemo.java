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
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	void demoTest() {
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

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));
		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
		checkout.click();
		//driver.findElement(By.className("btn btn-default button button-medium")).click();
		WebElement proceed = driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium"));
		proceed.click();

		WebElement emailLogin = driver.findElement(By.id("email"));
		WebElement passLogin = driver.findElement(By.id("passwd"));
		String emaildetails = "testFaizaan@gmail.com";
		String password = "123456";
		//		WebElement createButton = driver.findElement(By.id("SubmitCreate"));
		//		createButton.click();
		emailLogin.sendKeys(emaildetails);
		passLogin.sendKeys(password);

		this.driver.findElement(By.id("SubmitLogin")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/form/p/button")))
		.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > p.checkbox > label"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > p > button > span"))).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart_navigation > button"))).click();

		assertEquals("Your order on My Store is complete.",
				this.driver.findElement(By.cssSelector("#center_column > div > p")).getText());
	}


	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}