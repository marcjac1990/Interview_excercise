Feature: Rest API Tests

  Scenario: Rest GET Test
    Given Set URL to connect to API "http://dummy.restapiexample.com/api/v1/"
    When Get list of all employee
    Then Check if response code is 200

  Scenario: Rest POST Test
    Given Set URL to connect to API "http://dummy.restapiexample.com/api/v1/"
    When Create Employee with name "Marcin", Salary "3000" and Age "22"
    Then Check if response code is 200

