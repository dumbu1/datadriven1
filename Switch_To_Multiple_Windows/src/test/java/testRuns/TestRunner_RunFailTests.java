package testRuns;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"@target/failedRerun.txt"},
		glue = {"stepDefinations","hooks"},
		
		plugin = {"rerun:target/failedRerun.txt",
				"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		monochrome = true,
		dryRun = false
		
		)


public class TestRunner_RunFailTests {
	
	


}
