package servicenow.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import servicenow.base.serviceNow_basicMethods;

@CucumberOptions(features="src/main/java/servicenow/features/CreateIncident.feature", 
					glue={"servicenow/pages","servicenow/base","servicenow_marathon/TestData"},
					monochrome=true,
					publish=true
					
					)

public class Runner extends serviceNow_basicMethods{	
}
