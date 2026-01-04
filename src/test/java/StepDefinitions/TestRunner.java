package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/Feature/LoginPageNCS.feature", glue={"StepDefinitions"},
monochrome=true,
plugin= {"pretty","html:target/JSONReports/reports.html"})


public class TestRunner {

}
