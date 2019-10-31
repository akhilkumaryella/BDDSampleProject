package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = "src/test/resources/featurefiles/Search.feature",
		glue = {"stepdefinition"},
		tags={"@Regression"},
		plugin = {"pretty",
		          "html:target/cucumber-report",
		          "json:target/cucumber.json"}
)
public class RunCucumberTest {
	
private TestNGCucumberRunner testNgCucumberRunner;
	
 	@BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNgCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 	
 	@Test(groups = "cucumber",description = "Runs cucumber feature as a group", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeatureWrapper) {
        testNgCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }
 	
 	@DataProvider
    public Object[][] features() {
        return testNgCucumberRunner.provideFeatures();
    }
 	
 	@AfterClass(alwaysRun = true, description = "tear down")
    public void tearDownClass() {
        testNgCucumberRunner.finish();
    }

}
