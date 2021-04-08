package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		//1. Launch URL: https://www.amazon.in/
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//2. Type "one plus 7 pro mobiles" in Search Box and Enter
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 7 pro mobiles", Keys.ENTER);
		//3. Print the price of the first resulting mobile
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of the first resulting mobile is : " +price);
		//4. Click on the Mobile (First resulting) image
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		//5. Switch to the new window
		Set<String> allwindow= driver.getWindowHandles();
		List<String> windows= new ArrayList<String>(allwindow);
		driver.switchTo().window(windows.get(1));
		//6. Print the number of customer ratings
		String Rating = driver.findElement(By.xpath("(//span[@id='acrCustomerReviewText'])[1]")).getText();
		System.out.println("The number of customer ratings is : " +Rating);
		//7. Click 'Add to Cart'
		driver.findElement(By.id("add-to-cart-button")).click();
		//8. Confirm "Added to Cart" text message appeared
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//h4[text()='Added to Cart'])[2]"))));
		boolean addcart = driver.findElement(By.xpath("(//h4[text()='Added to Cart'])[2]")).isDisplayed();
		if(addcart)
		{
			System.out.println("The Added to cart is successfully confirmed");
		}
		//9. Click on Proceed to checkout
		driver.findElement(By.xpath("(//div[@class='a-row a-spacing-top-small']/form/span/span/following::span/span/input[@class='a-button-input'])[1]")).click();
		//10. Confirm the title is "Amazon Sign In"
		if(driver.getTitle().equals("Amazon Sign In"))
		{
			System.out.println("The Title is successfully verified");
		}
		//11. Click Continue (without entering anything)
		driver.findElement(By.id("continue")).click();
		//12. Verify the error message
		boolean displayed = driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).isDisplayed();
		if (displayed) {
			System.out.println("The error message verified");
		}
		//13. Close both browsers
		driver.quit();

	}

}

