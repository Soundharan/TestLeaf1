package week2.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
ChromeDriver driver =new ChromeDriver();
driver.get("http://www.leafground.com/pages/table.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
List<WebElement> tablerows = driver.findElements(By.tagName("tr"));
System.out.println("No of rows in an table :"+tablerows.size());
List<WebElement> tablecoloum = driver.findElements(By.tagName("th"));
System.out.println("No of coloum in an table :"+tablecoloum.size());
WebElement progressvalue = driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']//following::td"));
System.out.println("the progressvale of Learn to interact with Elements is"+progressvalue.getText());
List<WebElement> values = driver.findElements(By.xpath("//td[2]"));
List<Integer> number =new ArrayList<Integer>();
for (WebElement webElement : values) {
	String progress = webElement.getText().replace("%","");
	number.add(Integer.parseInt(progress));		
}
System.out.println(number);
Integer min = Collections.min(number);
System.out.println(min);
String smallvalue =Integer.toString(min)+"%";
String Finalxpath ="//td[text()='"+smallvalue+"']/following::input";
System.out.println(Finalxpath);
WebElement checkbox = driver.findElement(By.xpath(Finalxpath));
checkbox.click();
System.out.println(checkbox.isSelected());



	}
	
}

