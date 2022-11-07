package servicenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import servicenow.base.serviceNow_basicMethods;

public class IncidentsPage extends serviceNow_basicMethods {

	public IncidentsPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//button[text()='New']")
	WebElement new_ele;

	@Given("Click new button")
	public CreateIncidentPage click_New() throws InterruptedException {	
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		new_ele.click();
		return new CreateIncidentPage(driver);
	}

	@FindBy(how=How.XPATH,using="//select[@class='form-control default-focus-outline']")
	WebElement number_drop;
	@Then("Select number dropdown")
	public IncidentsPage select_numberDropdown() throws InterruptedException {
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);		
		Select numberDD=new Select(number_drop);
		numberDD.selectByVisibleText("Number");
		return this;
	}
	@FindBy(how=How.XPATH,using="//input[@class='form-control'])[1]")
	WebElement incNumber_input;
	@Then("Enter incident number in the search box")
	public IncidentsPage enter_incNumber() throws InterruptedException {
		incNumber_input.sendKeys(incNumber,Keys.ENTER);
		return this;
	}


	@Then("verify newly created Incident")
	public IncidentsPage verify_incident() throws InterruptedException {
		boolean isIncidentPresent = driver.findElement(By.linkText(incNumber)).isDisplayed();
		Assert.assertTrue(isIncidentPresent==true);
		return this;
	}


}
