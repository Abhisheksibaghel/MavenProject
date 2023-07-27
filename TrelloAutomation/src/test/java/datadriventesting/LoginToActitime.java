package datadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;
public class LoginToActitime {
public WebDriver driver;
@Test
public void LoginActitimeTest() throws Throwable {
	Properties pobj=new Properties();
	pobj.load(new FileInputStream("./src/test/resources/actitimedata.properties"));
	String browserName = pobj.getProperty("browser");
	if(browserName.equals("chrome")) {
		driver=new ChromeDriver();
	}
	else if(browserName.equals("edge")) {
		driver =new EdgeDriver();
	}
	else if(browserName.equals("firefox")) {
		driver =new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   
	driver.get(pobj.getProperty("url"));
	WebElement usernameTextField = driver.findElement(By.id("username"));
	usernameTextField.sendKeys(pobj.getProperty("username"));
	WebElement passwordTextField = driver.findElement(By.name("pwd"));
	passwordTextField.sendKeys(pobj.getProperty("password"));
	WebElement loginButton = driver.findElement(By.id("loginButton"));
	loginButton.click();
	Thread.sleep(5000);
	driver.manage().window().minimize();
	driver.quit();
}
}
