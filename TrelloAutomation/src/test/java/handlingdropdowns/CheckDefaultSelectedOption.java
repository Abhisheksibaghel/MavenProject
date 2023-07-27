package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckDefaultSelectedOption {
public static void main(String[] args) {
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	driver.get("https://www.facebook.com/signup/");
   WebElement dayDropdown = driver.findElement(By.id("day"));
   Select dayselect=new Select(dayDropdown);
   String selectedoption = dayselect.getFirstSelectedOption().getText();
   System.out.println (selectedoption);
   String monthOption = new Select(driver.findElement(By.id("month"))).getFirstSelectedOption().getText();
	System.out.println(monthOption);
	String yearoption = new Select(driver.findElement(By.id("year"))).getFirstSelectedOption().getText();
	System.out.println(yearoption);
	driver.manage().window().minimize();
	driver.quit();
   
   	
}
}
