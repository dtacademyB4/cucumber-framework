package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DBUtils;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    // Cucumber Hooks run before and after each SCENARIO

    @Before ("@db_ui")
    public void setupScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();


    }

    @Before ("@db")  // this before hook will run only before the scenarios that are tagged with @db
    public void setupDB(){
        DBUtils.createConnection();

    }

    @After ("@db")
    public void tearDownDb(){
        DBUtils.close();
    }


    @After ("@db_ui")
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_scenario");
        }

        Driver.quitDriver();
        DBUtils.close();
    }


}
