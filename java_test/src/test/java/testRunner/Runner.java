package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/feature"},
        glue = {"StepDefinition"},
        tags = "@SP10",
        plugin = {"pretty",
                  "html:target/test-out/report.html"

        }
)

public class Runner {
    
    
}
