package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseXpath {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.findElement(By.xpath("//label[text()='Username']/following::input"));
		//driver.findElement(By.xpath("//label[text()='Password']/following::input"));
		//driver.findElement(By.xpath("//input[@value='Login']"));
		//driver.findElement(By.xpath("//div[@id='label']//a[1]"));
		//driver.findElement(By.xpath("//a[text()='Leads']"));
		//driver.findElement(By.xpath("//a[text()='Merge Leads']"));
		//driver.findElement(By.xpath("//a[text()='Merge Leads']"));
		//driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]"));
		
		//driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]"));
		//driver.findElement(By.xpath("(//a[text()='Merge']"));
		//driver.findElement(By.xpath("//span[text()='Company Name']//following::span"))
		//driver.findElement(By.id("viewLead_companyName_sp"));
		
		
		
		
		
		
		

	}

}