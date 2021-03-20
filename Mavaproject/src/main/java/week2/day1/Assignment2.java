package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a")).click();
		driver.findElement(By.id("email")).sendKeys("Soundharan007@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input")).sendKeys("Done");
		driver.findElement(By.name("username")).getAttribute("value");
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input")).clear();
		WebElement isenabled = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[5]/div/div/input"));
		System.out.println("the text is enabled:" +isenabled.isEnabled());
		
		driver.findElement(By.xpath("//*[@id=\"text-2\"]/a/img")).click();
		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[2]/a")).click();
		WebElement Positionbutton = driver.findElement(By.id("position"));
		System.out.println("The position of the button is"+Positionbutton.getLocation());
		WebElement Buttoncolor = driver.findElement(By.id("color"));
		System.out.println("The Color of the button is"+Buttoncolor.getCssValue("background-color"));
		WebElement Getsize = driver.findElement(By.id("size"));
		System.out.println("The Size of the button is:"+ Getsize.getSize());
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[3]/a")).click();
		WebElement Where = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/a"));
		System.out.println("Find where am supposed to go without clicking me?"+Where.getAttribute("href"));
		
		
		
		

	}

}
