package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@CucumberOptions(
				features="src/test/resources/Features",
				glue={"stepdefinitions"},
				plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json","junit:target/cucumber.xml"}
		)
@RunWith(Cucumber.class)
public class TestRunner {


}
