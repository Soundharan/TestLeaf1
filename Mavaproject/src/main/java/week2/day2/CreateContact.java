package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		//setup chrome driver
		WebDriverManager.chromedriver().setup();
		//launch chrome browser
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Maximize the browser
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//div[@class=\"x-panel-header\"])[3]//a")).click();
		driver.findElement(By.xpath("//div[@class=\"frameSectionBody\"]//following::a[2]")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Soundharan");
		driver.findElement(By.id("lastNameField")).sendKeys("Dhamodharan");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Soundhar");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Dhamu");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createContactForm_description")).sendKeys("TestLeaf");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("Soundharan007@gmail.com");
		WebElement findElement = driver.findElement(By.id("createContactForm_generalCountryGeoId"));
		Select dropdown = new Select(findElement);
		dropdown.selectByVisibleText("India");
		WebElement findElement2 = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dropdown2 = new Select(findElement2);
		dropdown2.selectByVisibleText("TAMILNADU");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@value=\"Update\"]")).click();
String title2 = driver.getTitle();
System.out.println(title2);

	}
}
