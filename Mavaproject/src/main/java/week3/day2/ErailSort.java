package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		//setup chrome driver
		WebDriverManager.chromedriver().setup();
		//launch chrome browser
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("https://erail.in/");
		//Maximize the browser
		driver.manage().window().maximize();
		//uncheck the Sort on Date check box
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id("chkSelectDateOnly")).click();
		//find the From text box,clear text and type place
		WebElement Source = driver.findElement(By.id("txtStationFrom"));
		Source.clear();
		//find the To text box,clear text and type place
		Source.sendKeys("Mgr Chennai Ctr"+Keys.ENTER);
		WebElement To = driver.findElement(By.id("txtStationTo"));
		To.clear();
		To.sendKeys("Madurai Jn"+Keys.ENTER);
		//Create new list
		List<String> train= new ArrayList<String>();
		//Wait until trainlist load
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[@style=';']/a")));
		//traversed trainlist using foreach loop
		List<WebElement> trainname = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//td[@style=';']/a");
		for (WebElement trainlist : trainname) {
			//add an trainlist to string using gettext()
			String trainlist1 = trainlist.getText();
			//adding string text to list
			train.add(trainlist1);	
		}
		//print train list
		System.out.println(train);
		//sorting the list using collection class
		Collections.sort(train);
		//print train list after sort
		System.out.println(train);
		//print the size of trainlist using size()
		System.out.println(train.size());
	}

}
