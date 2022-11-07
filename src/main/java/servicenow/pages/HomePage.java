package servicenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import servicenow.base.serviceNow_basicMethods;

public class HomePage extends serviceNow_basicMethods {
	
	public HomePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@Given("Click All option")
	public HomePage click_All() throws InterruptedException {
		//Thread.sleep(1000);	
		
		WebElement All_ele=shadow.findElementByXPath("//div[@id='all']");
		//wait.until(ExpectedConditions.elementToBeClickable(All_ele));
		All_ele.click();	
		return this;
	}

	@Given("Click Incidents Link")
	public IncidentsPage click_IncidentsLink() throws InterruptedException {
		shadow.findElementByXPath("//a[@aria-label='Incidents']").click();
		return new IncidentsPage(driver);
	}

}
