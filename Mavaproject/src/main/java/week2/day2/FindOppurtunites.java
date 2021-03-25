package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOppurtunites {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.linkText("Find Opportunities")).click();
		List<WebElement> Numberofrows = driver.findElements(By.xpath("//tr[@class=\"x-grid3-row-body-tr\"]"));
		System.out.println("The list of Oppurtunites are "+Numberofrows.size());
		System.out.println(driver.getTitle());


	}

}
