package restApiTests.testSteps;

import Utils.Employee;
import Utils.RestApiController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;



public class restApiTestSteps {
    private RestApiController restApiController = new RestApiController();

    @Given("Set URL to connect to API \"([^\"]*)\"")
    public void setUrl(String url) { restApiController.setUrl(url);  }

    @When("Get list of all employee")
    public void getAllUsers() {
        restApiController.getAllUsers();
    }

    @Then("Check if response code is 200")
    public void checkResposneCode() { restApiController.checkResponseCode(200);}


    @When("^Create Employee with name \"([^\"]*)\", Salary \"([^\"]*)\" and Age \"([^\"]*)\"$")
    public void createEmployeeWithNameSalaryAndAge(String name, String salary, String age) { restApiController.createEmployee(restApiController.createRequestToAddNewEmployee(name, salary, age)); }

    @When("Remove Employee \"([^\"]*)\"")
    public void remoteEmployer(String employee) { restApiController.deleteEmployee(restApiController.findEmployee(employee)); }
}
