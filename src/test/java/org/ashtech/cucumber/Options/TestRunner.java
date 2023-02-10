package org.ashtech.cucumber.Options;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/org/ashtech/feature/GetUserList.feature",
                glue = {"stepdefinitions"}
)
public class TestRunner {
}
