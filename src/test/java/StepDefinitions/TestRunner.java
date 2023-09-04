package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/Feature", glue={"StepDefinitions"},
monochrome=true,
plugin= {"pretty","junit:target/JSONReports/reports.xml"})


public class TestRunner {

}
