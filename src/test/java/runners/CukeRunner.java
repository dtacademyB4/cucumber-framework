package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        tags = "@temp",
        //"@temp and @smoke and @regression", run scenarios that have all 3 tags
        //"@temp or @smoke or @regression", run scenarios that have at least one of these tags
        features = "src/test/resources/features", // path to the feature files folder
        glue = "stepDefs" // path to step definition classes (glue code, implementation code)
//       , dryRun = true

)
public class CukeRunner {
}
