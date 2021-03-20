package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

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
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizant");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Soundharan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Dhamodharan");
		WebElement findElement = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropdown = new Select(findElement);
		dropdown.selectByVisibleText("Employee");
		
		WebElement findElement2 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dropdown2 = new Select(findElement2);
		dropdown2.selectByValue("CATRQ_AUTOMOBILE");
		
		driver.findElement(By.name("submitButton")).click();
		String titleofBrowser = driver.getTitle();
		System.out.println(titleofBrowser);
	}

}
