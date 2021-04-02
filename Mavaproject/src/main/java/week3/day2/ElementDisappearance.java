package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisappearance {

	public static void main(String[] args) {
		//setup chrome driver
		WebDriverManager.chromedriver().setup();
		//launch chrome browser
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://www.leafground.com/pages/disapper.html");
		//Maximize the browser
		driver.manage().window().maximize();
		//uncheck the Sort on Date check box
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("//button[@id='btn']//b[1]")));
		if (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='disappear']//strong[1]"))))
				{
			System.out.println("Button is disappeared!");
			
		} else {
			System.out.println("Button is not disappeared!");

		}

	}

}
