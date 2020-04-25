package restApiTests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import restApiTests.testSteps.restApiTestSteps;

@RunWith(SerenityRunner.class)
public class testRunner {

    @Steps
    restApiTestSteps apiTest;

    @Test
    public void getRestApiTest(){
        apiTest.setUrl("http://dummy.restapiexample.com/api/v1/");
        apiTest.getAllUsers();
        apiTest.checkResposneCode();
    }

    @Test
    public void postRestApiTest(){
        apiTest.setUrl("http://dummy.restapiexample.com/api/v1/");
        apiTest.createUser("Marcin", "3000", "22");
    }
}
