Feature: Testing OrangeHRM

Scenario: To test the login page of OrangeHRM

Given User should be in the login page

When enter the valid username "Admin"
And enter the valid password "admin123"
And click on the login button

Then I should get the title "OrangeHRM"