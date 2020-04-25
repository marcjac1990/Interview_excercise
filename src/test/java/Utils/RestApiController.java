package Utils;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class RestApiController {
    Employee employee;
    private String api;
    private Response response;

    void RestApiController(){ }

    public void setUrl(String url)
    {
        api = url;
    }

    public void getAllUsers()
    {
        response = SerenityRest.get(api + "employees");
    }

    public void checkResponseCode(int respCode)
    {
        response.then().statusCode(respCode);
    }

    public String createRequestToAddNewEmployee(String name, String salary, String age)
    {
        employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setAge(age);
        return employee.parseToJson();
    }

    public void createEmployee(String request)
    {
        response = SerenityRest.given().body(request).post(api + "create");
    }
}
