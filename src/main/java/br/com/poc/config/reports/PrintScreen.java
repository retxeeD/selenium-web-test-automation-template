package br.com.poc.config.reports;

import br.com.poc.config.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;

public class PrintScreen extends BaseTest {
    public void takeScreenShoot(String scenarioName) throws IOException {
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("evidence/screenshot/"+ scenarioName + ".png"));
    }
}
