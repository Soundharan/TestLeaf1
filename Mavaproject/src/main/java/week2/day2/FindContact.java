package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("(//div[@class=\"x-panel-header\"])[3]//a")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//following::li[3]/a")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		String name="Soundharan";
		driver.findElement(By.name("emailAddress")).sendKeys(name);;
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		String text = driver.findElement(By.id("viewContact_firstNameLocal_sp")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
WebElement MarketingCampaign = driver.findElement(By.id("addMarketingCampaignForm_marketingCampaignId"));
Select ddl = new Select(MarketingCampaign);
ddl.selectByValue("9000");
driver.findElement(By.xpath("//input[@value=\"Add\"]")).click();
WebElement Depart = driver.findElement(By.id("updateContactForm_departmentName"));
Depart.clear();
Depart.sendKeys("Selenium Automation Testing");
Thread.sleep(10000);
driver.findElement(By.xpath("//input[@value=\"Update\"]")).click();
String text2 = driver.findElement(By.xpath("//span[text()='Marketing Campaigns']//following::span")).getText();
System.out.println("The Vale of the Department is "+text2);
String text3="eCommerce Site Internal Campaign";
if (text2.equalsIgnoreCase(text3)) {
	System.out.println("The MarketingCampaign value are same" );
	
} else {
	System.out.println("The MarketingCampaign value are not same" );

}
System.out.println(driver.getTitle());


		


	}

}
