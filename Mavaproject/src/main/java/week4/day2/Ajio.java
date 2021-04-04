package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.geometry.spherical.oned.ArcsSet.Split;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
				String parent = driver.getWindowHandle();
				//Maximize the browser
				driver.manage().window().maximize();
				//wait
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				driver.findElement(By.tagName("input")).sendKeys("Bags"+Keys.ENTER);
				driver.findElement(By.xpath("(//label[contains(@class,'facet-linkname facet-linkname-genderfilter')])[3]")).click();
				Thread.sleep(2000);
				driver.findElement(By.className("five-grid")).click();
				WebElement dropdown = driver.findElement(By.tagName("select"));
				Select dd1 = new Select(dropdown);
				dd1.selectByValue("newn");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='facet-head ']")).click();
				driver.findElement(By.id("minPrice")).sendKeys("2000");
				driver.findElement(By.id("maxPrice")).sendKeys("5000"+Keys.ENTER);
				driver.findElement(By.xpath("//div[@class='name']")).click();
				Set<String> Allwindows = driver.getWindowHandles();
				List<String>windows = new ArrayList<String>(Allwindows);
				driver.switchTo().window(windows.get(1));
				String Price = driver.findElement(By.className("prod-sp")).getText();
				int priceInt = Integer.parseInt(Price.replaceAll("\\D", ""));
				System.out.println("Price of the bag: "+priceInt);
				String discoutprice = driver.findElement(By.xpath("//div[@class='promo-discounted-price']//span[1]")).getText();
				int discoutpriceint = Integer.parseInt(discoutprice.replaceAll("\\D", ""));
				System.out.println("Discount Price of the bag: "+discoutpriceint);
				String code = driver.findElement(By.xpath("//div[@class='promo-title']")).getText();
				String[] text = code.split("Code");
				String couponcode = (text[text.length-1]).replaceAll("[^a-zA-Z]","");
				System.out.println("CouponCode: "+couponcode);
				driver.findElement(By.xpath("//span[contains(@class,'edd-pincode-msg-details edd-pincode-msg-details-pointer')]")).click();
				driver.findElement(By.name("pincode")).sendKeys("560043"+Keys.ENTER);
				Thread.sleep(2000);
				String expectdate = driver.findElement(By.xpath("//span[@class='edd-message-success-details-highlighted']")).getText();
				System.out.println("Expected delivery date:"+expectdate);
				driver.findElement(By.className("ic-angle-down")).click();
				String Customercareadd = driver.findElement(By.xpath("//div[@id='appContainer']/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/section[1]/h2[1]/ul[1]/li[18]/div[1]/div[3]")).getText();
				System.out.println("Customer care address: "+Customercareadd);
				Thread.sleep(2000);
				WebElement Addtobag = driver.findElement(By.className("btn-gold"));
				Actions builder =new Actions(driver);
				builder.moveToElement(Addtobag).click().perform();
				Thread.sleep(4000);
				driver.findElement(By.className("ic-pdp-add-cart")).click();
				//WebElement gotobag = driver.findElement(By.xpath("//span[text()='GO TO BAG']"));
				//builder.moveToElement(gotobag).click().perform();
				String outPrice = driver.findElement(By.xpath("//span[@class='price-value bold-font']")).getText();
				int outPriceint = Integer.parseInt(outPrice.replaceAll("\\D", ""));
				//System.out.println(outPriceint);
				driver.findElement(By.id("couponCodeInput")).sendKeys(couponcode);
				driver.findElement(By.xpath("//button[text()='Apply']")).click();
				Thread.sleep(2000);
				boolean voucherIsValid = driver.findElement(By.xpath("//p[@class='applied-voucher-message']")).isDisplayed();
				System.out.println(voucherIsValid);
				if (!voucherIsValid) {
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
				driver.findElement(By.className("delete-btn")).click();
				driver.findElement(By.xpath("//div[text()='DELETE']")).click();
				driver.quit();
				
				
				

	}

}
