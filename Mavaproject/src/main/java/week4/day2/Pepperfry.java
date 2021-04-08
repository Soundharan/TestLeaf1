package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pepperfry {

	public static void main(String[] args) throws InterruptedException, IOException {
		//setup chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options  = new ChromeOptions();
		//options.addArguments("incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		//launch chrome browser
		ChromeDriver driver=new ChromeDriver(options);
		//load the url
		driver.get("https://www.pepperfry.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		//wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait to close popup window
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='reg_login_box']//a[@class='popup-close'])[1]")));
		driver.findElement(By.xpath("(//div[@id='reg_login_box']//a[@class='popup-close'])[1]")).click();
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		//action class to click Furniture
		Actions builder = new Actions(driver);
		WebElement Furniture = driver.findElement(By.xpath("//div[@id='menu_wrapper']//a"));
		builder.moveToElement(Furniture).perform();
		Thread.sleep(2000);
		//click offoce chair
		WebElement Officechair = driver.findElement(By.xpath("//div[@id='meta-furniture']/div[1]/div[3]/div[2]/div[12]/a[1]"));
		builder.moveToElement(Officechair).click().perform();
		driver.findElement(By.xpath("//h5[text()='Executive Chairs']")).click();
		//enter height to 50
		WebElement Height = driver.findElement(By.xpath("(//input[@class='clipFilterDimensionHeightValue'])[2]"));
		Height.clear();
		Height.sendKeys("50");
		//searching chair and click wishlist
		driver.findElement(By.id("search")).sendKeys("Galician High Back Executive Chair In Black Colour"+Keys.ENTER);
		WebElement wishlist = driver.findElement(By.xpath("//a[contains(@class,'clip-heart-icn pf-right')]"));
		builder.moveToElement(wishlist).click().perform();
		Thread.sleep(2000);
		//closing popup
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.xpath("//span[@class='wewidgeticon we_close icon-large']")).click();
		driver.switchTo().defaultContent();
		//moveto bedroom
		WebElement bedroom = driver.findElement(By.linkText("Bedroom"));
		builder.moveToElement(bedroom).perform();
		Thread.sleep(2000);
		//click studytable
		driver.findElement(By.linkText("Study Tables")).click();
		//builder.moveToElement(table).click().perform();
		//select spacewood brand
		driver.findElement(By.xpath("//label[text()='Spacewood']")).click();
		Thread.sleep(3000);
		//click prisesort
		WebElement pricesort= driver.findElement(By.xpath("//label[@for='price7000-8000']"));		
		builder.moveToElement(pricesort).click().perform();
		Thread.sleep(2000);
		//click wishlist
		WebElement Table = driver.findElement(By.xpath("//a[@data-productname='SOS Carter Study Table in Lorraine walnut & silver grey Finish']"));
		builder.moveToElement(Table).click().perform();
		//wishlist count
		WebElement totalItems=driver.findElement(By.xpath("(//span[@class='header-nav-cnt count_alert'])[1]"));
		Thread.sleep(3000);
		//print count
		System.out.println("Number of items present in the wishlist: " +totalItems.getText());
		WebElement navigateToWishlist=driver.findElement(By.xpath("//a[@class='wishlist_bar']"));
		Thread.sleep(3000);
		navigateToWishlist.click();
		Thread.sleep(3000);
		// add to cart
		driver.findElement(By.xpath("//a[@class='addtocart_icon']")).click();
		Thread.sleep(3000);

		//Click Proceed to Pay Securely
		driver.findElement(By.xpath("//a[text()='Proceed to pay securely ']")).click();

		//Enter Pincode as 600028 and click Go
		driver.findElement(By.xpath("//input[@placeholder='Pincode']")).sendKeys("600028");
		driver.findElement(By.xpath("//INPUT[@NAME='pin_check']")).click();

		//Click Place Order
		driver.findElement(By.xpath("(//a[text()='PLACE ORDER'])[1]")).click();

		//Capture a screenshot on Order Summary
		File source= driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("Pepperfry order amount.png");
		FileUtils.copyFile(source, destination);

		//Close the browser 
		driver.close();

	}

}
