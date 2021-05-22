package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(


        features = "@target/failed-scenarios.txt", // path to the feature files folder
        glue = "stepDefs" // path to step definition classes (glue code, implementation code)

        ,stepNotifications = true  // will enable detailed step reports
        ,plugin = {"summary",  // generates  a detailed report after each run and also generates snippets for unimplemented steps
                   "pretty",  // adds more details to a console output
                    "html:target/html-report.html", // generates cucumber's built in html report in indicated path
                    "json:target/Cucumber.json"     // generate json report in target folder

                  }


)
public class FailedScenariosRunner {
}
