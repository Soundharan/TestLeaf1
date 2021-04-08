package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		//1. Launch URL: https://www.nykaa.com/
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(30));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");

		//2. Enter text as Perfumes in Search Bar and press Enter
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Perfumes", Keys.ENTER);

		//3. Get The Names Of all the Perfumes Displayed 

		List<WebElement> namesofperfumes = driver.findElements(By.xpath("//div[@class='m-content__product-list__title']/h2/span"));
		List<String> name = new LinkedList<String>();
		for(WebElement  names : namesofperfumes)
		{
			String nameofperfume = names.getText();
			name.add(nameofperfume);
		}
		System.out.println("The names of all the perfumes displayed is mentioned below : ");
		System.out.println(name);
		//4. Get The Price of all the Perfumes Displayed
		List<WebElement> priceofperfumes = driver.findElements(By.xpath("//span[@class='post-card__content-price-offer']"));
		List<Integer> number = new LinkedList<Integer>();
		for(WebElement price : priceofperfumes)
		{
			String num = price.getText().replaceAll("\\D", "");
			number.add(Integer.parseInt(num));

		}
		System.out.println("The price of all displayed perfumes is mentioned below : ");
		System.out.println(number);
		//5. Sort the lsit and find the high price perfume
		Collections.sort(number);
		System.out.println("---------------------------------------");
		System.out.println("After Sort");
		System.out.println(number);
		Integer integer = number.get(number.size()-1);
		String string = integer.toString();
		System.out.println("The Highest price of perfume present is : " +string);
		driver.findElement(By.xpath("//span[text()='"+string+"']")).click();

		//6. Click on Add To Bag
		Set<String> newsetwin = driver.getWindowHandles();
		List<String> newliswin = new ArrayList<String>(newsetwin);
		driver.switchTo().window(newliswin.get(1));
		driver.findElement(By.xpath("//div[@class='pull-left']/div/button")).click();

		//7. verify Message Product Added To the bag 
		Thread.sleep(2000);
		String msg=driver.findElement(By.xpath("//button[@class='in-bag-btn nk-btn']")).getText();
		if(msg.equals("ADDED TO BAG"))
		{
			System.out.println("Message product Added to bag is successfully verified");
		}

		//8. Click on bag Icon
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();

		//9. Get the Grand Total Value
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='table-row ']/div[2]"))));
		System.out.println("The grand total value is : " +driver.findElement(By.xpath("//div[@class='table-row ']/div[2]")).getText().replaceAll("\\D", ""));

		//10. Click on Proceed
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();

		//11. Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		//12. Fill all the Fields in Address 
		driver.findElement(By.name("name")).sendKeys("Soundhar");
		driver.findElement(By.name("email")).sendKeys("soundharan007@gmail.com");
		driver.findElement(By.name("phoneNumber")).sendKeys("8608061281");
		driver.findElement(By.name("pinCode")).sendKeys("600109");
		driver.findElement(By.xpath("(//legend[text()='Address']/following::textarea)[1]")).sendKeys("cholan nagar,annanur");
		driver.findElement(By.xpath("//button[text()='SHIP TO THIS ADDRESS']")).sendKeys("Cholan nagar, annanur");

		//13. Click on Paynow
		driver.findElement(By.xpath("//button[@class='btn fill full big proceed']")).click();

		//14. Get the Error Message displayed in Red Color
		List<WebElement> errormessage = driver.findElements(By.xpath("//span[@class='field-error']"));
		System.out.println("The error message displayed in red color will be shown below");
		for(WebElement message : errormessage)
		{
			System.out.println(message.getText());
		}

		//15. close the browser
		driver.close();
	}
}
