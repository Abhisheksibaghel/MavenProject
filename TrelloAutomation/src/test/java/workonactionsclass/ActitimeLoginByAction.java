package workonactionsclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActitimeLoginByAction {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	driver.get("https://demo.actitime.com/login.do");
	WebElement usernameTextField = driver.findElement(By.id("username"));
	WebElement passwordtextfield = driver.findElement(By.name("pwd"));
	WebElement LoginButton = driver.findElement(By.id("loginButton"));
	Actions actions = new Actions(driver);
	actions.sendKeys(usernameTextField,"admin").sendKeys(passwordtextfield,"manager").click(LoginButton).build().perform();
	
	
}
}
