package restApiTests.testSteps;

import Utils.Employee;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;



public class restApiTestSteps {
    Employee employee;
    private String api;
    private Response resposne;

    @Step("Set URL to connect to API {0}")
    public void setUrl(String url) {
        api = url;
    }

    @Step("Get list of all employee")
    public void getAllUsers() {
        resposne = RestAssured.get(api + "employees");
    }

    @Step("Check if response code is 200")
    public void checkResposneCode() {
        resposne.then().statusCode(200);
    }

    @Step("Create Employee with name {0}, Salary {1} and Age {2}")
    public void createUser(String name, String salary, String age) {
        employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setAge(age);
        String request = employee.parseToJson();
        resposne = RestAssured.given().body(request).post(api + "create");
    }

    @Step("Check if user is created")
    public void createUserCreated() {
        resposne.then().statusCode(200);
    }

}
