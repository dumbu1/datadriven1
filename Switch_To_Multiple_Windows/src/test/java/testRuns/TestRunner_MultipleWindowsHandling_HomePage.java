package testRuns;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)



@CucumberOptions(
		

		features="src/test/resources/features/MultipleWindowsHandling_HomePage/feature1.feature",
		

		glue = {"stepDefinations","hooks"},

		plugin = {"pretty"},
		dryRun = false,
				monochrome = true
				)

public class TestRunner_MultipleWindowsHandling_HomePage {

}
