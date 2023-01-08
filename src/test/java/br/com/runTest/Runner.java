package br.com.runTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * @author Pedro Lima
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber.html"
        },
        features = {"resources/Features"},
        glue = {"br.com.poc.steps"},
        tags = "@RegisterUserFeature")


public class Runner {

    @BeforeClass
    public static void setup() {
        System.out.println("Run the before");
    }

    @AfterClass
    public static void teardown() {
       // HtmlReport.main();
    }
}
