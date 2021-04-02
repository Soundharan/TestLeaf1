package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		//setup chrome driver
		WebDriverManager.chromedriver().setup();
		//launch chrome browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//load the url
		driver.get("https://www.myntra.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		//uncheck the Sort on Date check box
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//a[@class='desktop-main'])[2]"));

        //Mouse hover actions on an element using Actions Class:
        action.moveToElement(element).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Jackets & Coats")));


        WebElement element2 = driver.findElement(By.linkText("Jackets & Coats"));
        action.moveToElement(element2);
        //Mouse hover actions on a sub-element using Actions Class:
        action.click().build().perform();
        String items = driver.findElement(By.className("title-count")).getText();
        String itemsvalue = items.replaceAll("\\D", "");
        int itemsvalues = Integer.parseInt(itemsvalue);
        System.out.println("Total count"+itemsvalue);
        String jackets = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
        String jacketscount = jackets.replaceAll("\\D", "");
        int jacketscounts = Integer.parseInt(jacketscount);
        System.out.println("count of jackets: "+jacketscount);
        String coats = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
        String coatscount = coats.replaceAll("\\D", "");
        int coatscounts = Integer.parseInt(coatscount);
        System.out.println("count of coats: "+coatscounts);
        
        if (jacketscounts+coatscounts==itemsvalues) {
        	System.out.println("Counts are same: "+itemsvalues);
			
		}
        else {
        	System.out.println("Counts are not same");
        }
        	
        driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();
        driver.findElement(By.className("brand-more")).click();
        driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("MANGO");
        driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div[1]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
        Thread.sleep(2000);
        List<WebElement> brandmango = driver.findElements(By.xpath("(//h3[text()='MANGO'])"));
        int size = brandmango.size();
        System.out.println("the count of mangocoat:"+size);
        String mangocoat = driver.findElement(By.className("title-count")).getText();
        String mangocoatcount = mangocoat.replaceAll("\\D", "");
        int mangocoatcounts = Integer.parseInt(mangocoatcount);
        System.out.println("the count of Totalproduct:"+mangocoatcounts);
        
        if (size==mangocoatcounts) {
        	System.out.println("Counts are same: "+mangocoatcounts);
			
		} else {
			System.out.println("Counts are not same");

		}
        
        driver.findElement(By.className("sort-sortBy")).click();
        //WebElement Discount = driver.findElement(By.xpath("//label[text()='Better Discount']"));
        driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
        Thread.sleep(2000);
        String rs = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
        System.out.println("The price of first displayed item"+rs);
        
        WebElement Sizeofdress = driver.findElement(By.xpath("//div[@class='product-productMetaInfo']"));
       action.moveToElement(Sizeofdress).build().perform();
       WebElement Wishlist = driver.findElement(By.xpath("//span[@class='product-wishlistFlex product-actionsButton product-wishlist ']"));
       action.moveToElement(Wishlist);
       //Mouse hover actions on a sub-element using Actions Class:
       action.click().build().perform();
      System.out.println(driver.getTitle());
	}
	}
	
	
	
	


