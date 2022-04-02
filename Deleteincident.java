package Week6.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Deleteincident {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev90481.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("admin");
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("AIc4O8Ihv$l=");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement Filter = driver.findElement(By.xpath("//input[@id='filter']"));
		Filter.sendKeys("incidents",Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		Thread.sleep(6000);
		WebElement pframe1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(pframe1);
		driver.findElement(By.xpath("//div[@id='incident_list']//tbody[@class='list2_body']//td[@class='vt']/a[@class='linked formlink']")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='form_action_button_container']//button[@class='form_action_button  action_context btn btn-default'][3]")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@class='btn btn-destructive']")).click();
		driver.close();
	}

}
