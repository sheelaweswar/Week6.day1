package Week6.day1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		WebElement pframe1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(pframe1);
		driver.findElement(By.xpath("//div[@id='incident_list']//tbody[@class='list2_body']//td[@class='vt']/a[@class='linked formlink']")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		WebElement priority = driver.findElement(By.xpath("(//select[@role='listbox']/option)[1]"));
		priority.click();
		System.out.println("priotity status:" +priority.getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		WebElement status =driver.findElement(By.xpath("(//select[@role='listbox']/option)[5]"));
		status.click();
		System.out.println("state:"+status.getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.close();
	}

}
