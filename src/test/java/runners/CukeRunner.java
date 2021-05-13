package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        tags = "@regression",
        //"@temp and @smoke and @regression", run scenarios that have all 3 tags
        //"@temp or @smoke or @regression", run scenarios that have at least one of these tags
        features = "src/test/resources/features", // path to the feature files folder
        glue = "stepDefs" // path to step definition classes (glue code, implementation code)
       , dryRun = true
        ,stepNotifications = true  // will enable detailed step reports
        ,plugin = {"summary",  // generates  a detailed report after each run and also generates snippets for unimplemented steps
        "pretty",  // adds more details to a console output
        "html:target/html-report.html", // generates cucumber's built in html report in indicated path

                  }

)
public class CukeRunner {
}
