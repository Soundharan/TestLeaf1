package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicitwait {

	public static void main(String[] args) {
		//setup chrome driver
				WebDriverManager.chromedriver().setup();
				//launch chrome browser
				ChromeDriver driver=new ChromeDriver();
				//load the url
				driver.get("http://leafground.com/pages/TextChange.html");
				//Maximize the browser
				driver.manage().window().maximize();
				//uncheck the Sort on Date check box
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement Button = driver.findElement(By.id("btn"));
				wait.until(ExpectedConditions.textToBePresentInElement(Button, "Click ME!"));
				driver.findElement(By.id("btn")).click();
				if(wait.until(ExpectedConditions.alertIsPresent())==null)
				    System.out.println("alert was not present");
				else
				    System.out.println("alert was present");

				
	}

}
