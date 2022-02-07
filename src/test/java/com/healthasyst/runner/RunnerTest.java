package com.healthasyst.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/feature"},
		glue = {"com.healtasyst.stepdefn", "com.healthasyst.base"},
		publish=true,
		monochrome=true,
//		dryRun=true,
		tags="@invalid",
		plugin = {"pretty","html:target/index.html","rerun:target/rerun.txt"}
		)

@RunWith(Cucumber.class)
public class RunnerTest {

}
