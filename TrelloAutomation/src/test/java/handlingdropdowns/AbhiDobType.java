package handlingdropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AbhiDobType {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.get("https://www.facebook.com/signup/");
	List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
	int countOfDropDown = allDropDowns.size();
	System.out.println("countOfDropDown " + countOfDropDown);
	// iterate the dropdowns
	for (WebElement dropdown : allDropDowns) {
		// select the visible one.
		if (dropdown.isDisplayed()) {
			Select dropdownSelect = new Select(dropdown);
			if (dropdown.getAttribute("title").equals("Day")) {
				//selectByIndex(int optionCountIndexValue)
//				dropdownSelect.selectByIndex(32);
				//selectByVisibleText(String visibleText/OptiontagText)
				dropdownSelect.selectByVisibleText("31");
			} else if (dropdown.getAttribute("title").equals("Month")) {
//				dropdownSelect.selectByIndex(9);
				dropdownSelect.selectByVisibleText("Dec");
			} else if (dropdown.getAttribute("title").equals("Year")) {
				dropdownSelect.selectByVisibleText("1998");
				//selectByvalue(String valueAttValue)
//				dropdownSelect.selectByValue("1979");
			}
		}
	}
}
}
