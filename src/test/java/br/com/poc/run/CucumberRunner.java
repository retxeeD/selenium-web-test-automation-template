package br.com.poc.run;

import br.com.poc.util.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

/**
 * @author Pedro Lima
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "json:target/cucumber-report.json", "junit:target/junit-report.xml"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"features/"},
        glue = {"br.com.poc"},
        tags = "@RegisterUserFeature")


public class CucumberRunner {

    @AfterClass
    public static void teardown() {
        Report.newReport();
    }
}
