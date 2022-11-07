package servicenow.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import servicenow.utilities.ReadExcelData;


public class serviceNow_basicMethods extends AbstractTestNGCucumberTests {

	public WebDriver driver;
	public static Properties config_prop;
	public String excelFileName;
	public static Shadow shadow;
	public static String incNumber;
	public WebDriverWait wait;

	@BeforeMethod
	public void PreCondition() throws IOException, InterruptedException {
		config_prop=new Properties();
		FileInputStream configFile=new FileInputStream("src/main/resources/config.properties");
		config_prop.load(configFile);
		//1. Launch ServiceNow application
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(config_prop.getProperty("url")); 		
		shadow = new Shadow(driver);
		shadow.setImplicitWait(30);	
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}	
	
	

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@DataProvider(name="getData", indices=0)
	public String[][] getExcelData() throws IOException {
		return ReadExcelData.readExcel(excelFileName);
	}

}
