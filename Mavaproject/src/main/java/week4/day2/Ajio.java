package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		//setup chrome driver
		WebDriverManager.chromedriver().setup();
		//launch chrome browser
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("https://www.ajio.com/shop/sale");
		//Maximize the browser
		driver.manage().window().maximize();
		//wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//input in search bar
		driver.findElement(By.tagName("input")).sendKeys("Bags"+Keys.ENTER);
		//click on women filter
		driver.findElement(By.xpath("(//label[contains(@class,'facet-linkname facet-linkname-genderfilter')])[3]")).click();
		Thread.sleep(2000);
		//click grid
		driver.findElement(By.className("five-grid")).click();
		//selecting whats new dropdown
		WebElement dropdown = driver.findElement(By.tagName("select"));
		Select dd1 = new Select(dropdown);
		dd1.selectByValue("newn");
		Thread.sleep(2000);
		//clicking price
		driver.findElement(By.xpath("//div[@class='facet-head ']")).click();
		//entering min price
		driver.findElement(By.id("minPrice")).sendKeys("2000");
		//entering max price
		driver.findElement(By.id("maxPrice")).sendKeys("5000"+Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='name']")).click();
		//add next window in set using getwindowhandels
		Set<String> Allwindows = driver.getWindowHandles();
		//adding them to list
		List<String>windows = new ArrayList<String>(Allwindows);
		//switch to next window
		driver.switchTo().window(windows.get(1));
		//getting price of bag and convert to  int
		String Price = driver.findElement(By.className("prod-sp")).getText();
		int priceInt = Integer.parseInt(Price.replaceAll("\\D", ""));
		System.out.println("Price of the bag: "+priceInt);
		//getting Discount price of bag and convert to  int
		String discoutprice = driver.findElement(By.xpath("//div[@class='promo-discounted-price']//span[1]")).getText();
		int discoutpriceint = Integer.parseInt(discoutprice.replaceAll("\\D", ""));
		System.out.println("Discount Price of the bag: "+discoutpriceint);
		//getting Couponcode of bag and convert to  string
		String code = driver.findElement(By.xpath("//div[@class='promo-title']")).getText();
		String[] text = code.split("Code");
		String couponcode = (text[text.length-1]).replaceAll("[^a-zA-Z]","");
		System.out.println("CouponCode: "+couponcode);
		//clicking and entering pincode
		driver.findElement(By.xpath("//span[contains(@class,'edd-pincode-msg-details edd-pincode-msg-details-pointer')]")).click();
		driver.findElement(By.name("pincode")).sendKeys("560043"+Keys.ENTER);
		Thread.sleep(2000);
		//gettext of expected date
		String expectdate = driver.findElement(By.xpath("//span[@class='edd-message-success-details-highlighted']")).getText();
		System.out.println("Expected delivery date:"+expectdate);
		//clicking more info
		driver.findElement(By.className("other-info-toggle")).click();
		Thread.sleep(2000);
		//gettext of customercare address
		String Customercareadd = driver.findElement(By.xpath("//div[@id='appContainer']/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/section[1]/h2[1]/ul[1]/li[14]/div[1]/div[3]")).getText();
		System.out.println("Customer care address: "+Customercareadd);
		Thread.sleep(2000);
		//clicking addtobag
		WebElement Addtobag = driver.findElement(By.className("btn-gold"));
		Actions builder =new Actions(driver);
		builder.moveToElement(Addtobag).click().perform();
		Thread.sleep(6000);
		//clicking add to cart
		wait.until(ExpectedConditions.elementToBeClickable(By.className("ic-pdp-add-cart")));
		driver.findElement(By.className("ic-pdp-add-cart")).click();
		//print out price
		String outPrice = driver.findElement(By.xpath("//span[@class='price-value bold-font']")).getText();
		int outPriceint = Integer.parseInt(outPrice.replaceAll("\\D", ""));
		System.out.println("Out price: "+outPriceint);
		//entering couponcode
		driver.findElement(By.id("couponCodeInput")).sendKeys(couponcode);
		//Clicking apply
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(1000);
		//if condition to check the present of successful popup at top while applying coupon.
		//if condition ture then it break as invaild
		//else get the discount and checkup compare them if it is same.
		int size = driver.findElements(By.xpath("//span[@class='msg-content']")).size();
		if (size<=0) {
			System.out.println("the Coupon is Invaild");

		} else {

			String afterapplycode = driver.findElement(By.xpath("//span[@class='price-value bold-font']")).getText();
			String afterapplycodestr = afterapplycode.replaceAll("\\D", "");
			String substring = afterapplycodestr.substring(0, afterapplycodestr.length() - 2);
			int aftercodeInt = Integer.parseInt(substring);
			System.out.println("Ordered Price with coupon code: "+aftercodeInt);
			if (aftercodeInt==discoutpriceint) {
				System.out.println("the price are same");

			} else {
				System.out.println("the price are not same");
			}
		}
		//delete
		driver.findElement(By.className("delete-btn")).click();
		//delete in cart
		driver.findElement(By.xpath("//div[text()='DELETE']")).click();
		//quit driver
		driver.quit();




	}

}
