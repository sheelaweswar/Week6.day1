package Week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Createincident {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev90481.service-now.com/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("admin");
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("AIc4O8Ihv$l=");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement Filter = driver.findElement(By.xpath("//input[@id='filter']"));
		Filter.sendKeys("incidents",Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		WebElement incNum = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String getIncidentNum = incNum.getAttribute("value");
		System.out.println("getIncidentNum :"+getIncidentNum);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Create Instance");
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		search.sendKeys(getIncidentNum,Keys.ENTER);

	}

}
