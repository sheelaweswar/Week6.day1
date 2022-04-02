package Week6.day1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident {

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
		driver.findElement(By.xpath("//div[@class='col-xs-2 col-sm-3 col-lg-2 form-field-addons']/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//td[@class='vt']/a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("//div[@class='input-group ref-container']//button[@id='lookup.incident.assignment_group']//span[@class='icon icon-search']")).click();
		String parent = driver.getWindowHandle();
		Set<String> allwindowhandle = driver.getWindowHandles();
		for(String currenthandle : allwindowhandle) {
			if(!currenthandle.equalsIgnoreCase(parent)) {
				driver.switchTo().window(currenthandle);
			}
		}
		driver.findElement(By.xpath("//table[@id='sys_user_group_table']//button[@class='list_header_search_toggle icon-search btn btn-icon table-btn-lg']")).click();
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(parent);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Update Work notes");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='form_action_button_container']//button[@class='form_action_button  action_context btn btn-default'][1]")).click();
		driver.close();
	}

}
