package Utils;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import org.openqa.selenium.json.Json;

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

    public Data findEmployee(String employeeToFind)
    {
        Gson gson = new Gson();
        String resp = response.getBody().asString();
        AllEmployeeResponsePattern model = gson.fromJson(resp, AllEmployeeResponsePattern.class);
        for (Data employee: model.data) {
            if (employee.employee_name.contains(employeeToFind))
            {
                return employee;
            }
        }
        return new Data();
    }

    public void deleteEmployee(Data employee)
    {
        Assert.assertNotNull("Cannot Find user", employee.employee_name);
        String deleteUrl = api + "delete/" + employee.id;
        response = SerenityRest.given().delete(deleteUrl);
    }
}
