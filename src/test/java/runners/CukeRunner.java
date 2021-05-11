package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/resources/features", // path to the feature files folder
        glue = "stepDefs" // path to step definition classes


)
public class CukeRunner {
}
