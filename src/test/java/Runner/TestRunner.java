package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@CucumberOptions(
				features="src/test/java/Features",
				glue={"stepdefinitions"},
				plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json","junit:target/cucumber.xml"}
		)
@RunWith(Cucumber.class)
public class TestRunner {


}
