@regression @smoke @MP-100
Feature: Validating DataTable functionality

  Scenario: Validating that new user been added in table
    Given user navigates to WebTable App
    And user counts number of users in table
    And user clicks on Add User button
    And user provides all data
      | firstName | lastName | userName | password | role | email            | cellPhone  |
      | John      | Smith    | johnyBoy | 123M$    | 1    | john11@gmail.com | 1256989787 |
    When user fill the data and clicks save button
    Then user validates data added in the List of Users

  Scenario: Validating of deleting the username novak in table of users
    Given user navigates to WebTable App
    And user clicks delete button and deletes username novak
    Then user validates that  userName "novak" and user  has been deleted
