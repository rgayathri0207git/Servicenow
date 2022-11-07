package servicenow.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import servicenow.base.serviceNow_basicMethods;
import servicenow.pages.LoginPage;

public class CreateIncidents extends serviceNow_basicMethods {

	@BeforeSuite
	public void setData() {
		excelFileName="CreateIncident";
	}
	@Test(dataProvider="getData")
	public void runCreateIncidents(String des) throws InterruptedException {
		new LoginPage(driver).enter_username()
		.enter_password()
		.click_Login()
		.click_All()
		.click_IncidentsLink()
		.click_New()
		.get_IncidentNumber()
		.enter_decription(des)
		.click_submit()
		.select_numberDropdown()
		.enter_incNumber()
		.verify_incident();

	}

}
