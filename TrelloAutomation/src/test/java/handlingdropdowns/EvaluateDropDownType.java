package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EvaluateDropDownType {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.facebook.com/signup/");
		WebElement dayDropdown = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDropdown);
		if ( daySelect.isMultiple()) {
			System.out.println("Boolean True");
			System.out.println("day Dropdwon is Multi-Select DropDown");
		}else {
			System.out.println("Boolean False");
			System.out.println("day Dropdown is Single-Select Dropdown");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
