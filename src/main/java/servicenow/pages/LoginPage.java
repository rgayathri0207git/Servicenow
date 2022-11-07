package servicenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import servicenow.base.serviceNow_basicMethods;

public class LoginPage extends serviceNow_basicMethods {
	
	public LoginPage(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.ID,using="user_name")
	WebElement username;
	@Given("Enter Username")
	public LoginPage enter_username() {
		username.sendKeys(config_prop.getProperty("username"));
		return this;
	}
	
	@FindBy(how=How.ID,using="user_password")
	WebElement password;
	@Given("Enter passowrd")
	public LoginPage enter_password() {
		password.sendKeys(config_prop.getProperty("password"));
		return this;
	}
	
	@FindBy(how=How.ID,using="sysverb_login")
	WebElement login;
	@Given("Click Login button")
	public HomePage click_Login() {
		login.click();	
		return new HomePage(driver);
	}
}
