
Feature: Create new Incident in Servicenow application
 
  Scenario Outline: Create new incident and verify incident created or not
    Given Enter Username
    And Enter passowrd
    And Click Login button
    And Click All option
    And Click Incidents Link
    And Click new button
    And Note the auto generated incident number
    And Enter Short Description as <Description>
    When Click submit button
    Then Select number dropdown
    And Enter incident number in the search box
    And verify newly created Incident
  

    Examples: 
      | Description |
      | 'Test Incident1 for Automation' |
      #| 'Test Incident2 for Automation' |
