package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementtoAppears {

	public static void main(String[] args) {
		//setup chrome driver
				WebDriverManager.chromedriver().setup();
				//launch chrome browser
				ChromeDriver driver=new ChromeDriver();
				//load the url
				driver.get("http://www.leafground.com/pages/appear.html");
				//Maximize the browser
				driver.manage().window().maximize();
				//uncheck the Sort on Date check box
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div//button")));
				List<WebElement> Button = driver.findElements(By.xpath("//div//button"));
				int size = Button.size();
				System.out.println(size);
				if (size==5)
						{
					System.out.println("All Button appeared!");
					
				} else {
					System.out.println("All Button not appeared!");

				}

			}

		


	}


