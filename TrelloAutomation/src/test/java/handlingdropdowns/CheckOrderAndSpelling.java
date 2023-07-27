package handlingdropdowns;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOrderAndSpelling {
	public static void main(String[] args) throws Throwable {
		List<String> actualDayList = new ArrayList<String>();
		List<String> actualMonthList = new ArrayList<String>();
		List<String> actualYearList = new ArrayList<String>();
		List<String> expectedDayList = new ArrayList<String>();
		List<String> expectedMonthList = new ArrayList<String>();
		List<String> expectedYearList = new ArrayList<String>();
		// Instantiate the browser specific class
		WebDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();
		// call the imp wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Create the WebDriverWait Objject
		// pass the URl OF the app
		driver.get("https://www.facebook.com/signup");
		// capture all the dropdowns in the Webpage
		List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
		// iterate one drop down at a time
		for (WebElement dropdown : allDropDowns) {
			// consider only dropdwon which are visible in UI
			if (dropdown.isDisplayed()) {
				// create the Select class object for the dropdown
				Select dropdownSelect = new Select(dropdown);
				// capture all the options of all the dropdown
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					// identify the dropdwon under current iteration
					if (dropdown.getAttribute("title").equals("Day")) {
						actualDayList.add(option.getText());
					} else if (dropdown.getAttribute("title").equals("Month")) {
						actualMonthList.add(option.getText());
					} else if (dropdown.getAttribute("title").equals("Year")) {
						actualYearList.add(option.getText());
					}
				}
			}
		}
		// create fileInputStream Obj
		FileInputStream fis = new FileInputStream("./src/test/resources/facebookdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("doblist");
		int firstRowIndex = sheet.getFirstRowNum();
		int lastRowIndex = sheet.getLastRowNum();
		for (int i = firstRowIndex; i <= lastRowIndex; i++) {
			int firstCellIndex = (int) sheet.getRow(i).getFirstCellNum();
			int lastIncrimentalIndex = (int) sheet.getRow(i).getLastCellNum();
			for (int j = firstCellIndex + 1; j < lastIncrimentalIndex; j++) {
				if (String.valueOf(sheet.getRow(i).getCell(j).getCellType()).equals("STRING")) {
					expectedMonthList.add(sheet.getRow(i).getCell(j).getStringCellValue());
				} else if (String.valueOf(sheet.getRow(i).getCell(j).getCellType()).equals("NUMERIC")) {
					if (lastIncrimentalIndex == 32) {
						expectedDayList.add(String.valueOf((long) sheet.getRow(i).getCell(j).getNumericCellValue()));
					} else if (lastIncrimentalIndex == 120) {
						expectedYearList.add(String.valueOf((long) sheet.getRow(i).getCell(j).getNumericCellValue()));
					}
				}
			}
		}
		System.out.println(actualDayList);
		System.out.println(expectedDayList);
		if (actualDayList.equals(expectedDayList)) {
			System.out.println(
					"Pass: The Day Dropwdown list box options order and Spelling is correct and it is verified.");
		} else {
			System.out.println(
					"Fail: The Day Dropwdown list box options order and Spelling is incorrect and it is verified.");
		}
		System.out.println(actualMonthList);
		System.out.println(expectedMonthList);
		if (actualMonthList.equals(expectedMonthList)) {
			System.out.println(
					"Pass: The Month Dropwdown list box options order and Spelling is correct and it is verified.");
		} else {
			System.out.println(
					"Fail: The Month Dropwdown list box options order and Spelling is incorrect and it is verified.");
		}
		System.out.println(actualYearList);
		System.out.println(expectedYearList);
		if (actualYearList.equals(expectedYearList)) {
			System.out.println(
					"Pass: The Year Dropwdown list box options order and Spelling is correct and it is verified.");
		} else {
			System.out.println(
					"Fail: The Year Dropwdown list box options order and Spelling is incorrect and it is verified.");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}








