package restApiTests;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin="pretty", features="classpath:features", glue="restApiTests")
public class testRunner { }
