package servicenow_marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import servicenow.base.serviceNow_basicMethods;

public class CreateNewIncident extends serviceNow_basicMethods{
	@BeforeSuite
	public void setData() {
		excelFileName="CreateIncident";
	}
	@Test(dataProvider="getData")
	public void runCreateNewIncident(String des) throws InterruptedException {			

		//5. Click on Create new option and fill the mandatory fields
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		System.out.println("Inident Number: "+text2);
		driver.findElement(By.id("incident.short_description")).sendKeys(des);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();

		//6. Verify the newly created incident by getting the incident number and put it in search field and 
		//   enter then verify the instance number created or not

		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		driver.switchTo().defaultContent();

		//// Confirm incident exists !
		driver.switchTo().frame(eleFrame2);
		String text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println(text); 
		driver.switchTo().defaultContent();

	}
}
