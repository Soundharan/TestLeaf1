package week2.day2;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
WebElement Dropdown1 = driver.findElement(By.id("dropdown1"));
Select dd1 = new Select(Dropdown1);
dd1.selectByIndex(2);
WebElement Dropdown2 = driver.findElement(By.name("dropdown2"));
Select dd2 = new Select(Dropdown2);
dd2.selectByVisibleText("Selenium");
WebElement Dropdown3 = driver.findElement(By.id("dropdown3"));
Select dd3 = new Select(Dropdown3);
dd3.selectByValue("3");

WebElement Dropdown4 = driver.findElement(By.xpath("//select[@class=\"dropdown\"]"));
Select dd4 = new Select(Dropdown4);
List<WebElement> dd4optin = dd4.getOptions();
System.out.println("The number of option in DD4 are "+dd4optin.size());

driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[5]/select[1]")).sendKeys("UFT/QTP");
WebElement Dropdown5 = driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[6]/select[1]"));
Select dd5 = new Select(Dropdown5);
dd5.selectByValue("1");
dd5.selectByValue("2");
dd5.selectByValue("4");


	}

}
