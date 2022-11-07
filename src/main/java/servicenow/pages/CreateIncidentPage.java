package servicenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import servicenow.base.serviceNow_basicMethods;

public class CreateIncidentPage extends serviceNow_basicMethods {
	public CreateIncidentPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@id='incident.number']")
	WebElement incNumber_ele;
	@Given("Note the auto generated incident number")
	public CreateIncidentPage get_IncidentNumber() throws InterruptedException {
		incNumber = incNumber_ele.getAttribute("value");
		System.out.println("Inident Number: "+incNumber);
		return this;
	}
	@FindBy(how=How.ID,using="incident.short_description")
	WebElement descrition_ele;
	@Given("Enter Short Description as {string}")
	public CreateIncidentPage enter_decription(String des) throws InterruptedException {
		descrition_ele.sendKeys(des);
		return this;
	}
	@FindBy(how=How.XPATH,using="//button[text()='Submit']")
	WebElement submit_ele;
	@When("Click submit button")
	public IncidentsPage click_submit() throws InterruptedException {

		submit_ele.click();
		driver.switchTo().defaultContent();
		return new IncidentsPage(driver);
	}



}
