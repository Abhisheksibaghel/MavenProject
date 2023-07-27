package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class makemytrip {

	public static void main(String[] args)throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/homestays/");
		driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chHomestays active']")).click();
		driver.findElement(By.xpath("//input[@id='guest']")).click();
		WebElement AdultDropdown= driver.findElement(By.xpath("//p[text()='Adults']/../..//span[@class='gstSlct__text']"));
		AdultDropdown.click();
		Select SelectAdult =new Select (AdultDropdown);
		SelectAdult.selectByIndex(7);
		
	}
}