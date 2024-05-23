package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Divakar Verma
 * @created_at : 23/05/2024 - 2:26 pm
 * @mail_to: vermadivakar2022@gmail.com
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDef",
        plugin = {"json:target/cucumber-report.json", "pretty", "html:target/test-report.html"},
        publish = true,
        monochrome = true
)
public class TestRunner {
}
