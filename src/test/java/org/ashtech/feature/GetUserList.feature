Feature: Get Https Request

  Scenario: Get All the user list using Get call
    Given I perform get operation
    Then i should see "200" response code

  Scenario: Create new User using post call
    Given I perform post operation
    Then i should see "201" response code