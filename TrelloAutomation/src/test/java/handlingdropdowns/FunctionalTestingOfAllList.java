package handlingdropdowns;

	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class FunctionalTestingOfAllList {
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.facebook.com/signup");
			List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
			for (WebElement dropdown : allDropDowns) {
				if (dropdown.isDisplayed()) {
					Select dropdownSelect = new Select(dropdown);
					List<WebElement> allOptions = dropdownSelect.getOptions();
					for (WebElement options : allOptions) {
						if (dropdown.getAttribute("title").equals("Day")) {
							dropdownSelect.selectByVisibleText(options.getText());
							if (options.isSelected()) {
								System.out.println(options.getText() + " is Selected.");
							} else {
								System.out.println(options.getText() + " is not Selected.");
							}
						} else if (dropdown.getAttribute("title").equals("Month")) {
							dropdownSelect.selectByVisibleText(options.getText());
							if (options.isSelected()) {
								System.out.println(options.getText() + " is Selected.");
							} else {
								System.out.println(options.getText() + " is not Selected.");
							}
						} else if (dropdown.getAttribute("title").equals("Year")) {
							dropdownSelect.selectByVisibleText(options.getText());
							if (options.isSelected()) {
								System.out.println(options.getText() + " is Selected.");
							} else {
								System.out.println(options.getText() + " is not Selected.");
							}
						}
					}
				}
			}
			driver.manage().window().minimize();
			driver.quit();
		}
	}

