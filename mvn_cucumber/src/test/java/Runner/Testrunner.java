package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Login/Login.feature"}, glue = {"Definition"}, dryRun = false)

public class Testrunner extends AbstractTestNGCucumberTests {

}
