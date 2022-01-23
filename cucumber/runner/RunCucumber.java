package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/IncidentManagement.feature"},
				 glue = {"steps","cucumber.runner"},
				 monochrome = true)
public class RunCucumber extends AbstractTestNGCucumberTests{

}
