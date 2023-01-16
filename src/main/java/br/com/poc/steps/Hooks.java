package br.com.poc.steps;

import br.com.poc.util.BaseTest;
import br.com.poc.util.communs.Web;
import br.com.poc.util.reports.GeradorWordSteps;
import br.com.poc.util.reports.Screenshot;
import br.com.poc.util.reports.VideoRecord;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends BaseTest {

    VideoRecord videoRecord = new VideoRecord();
    Screenshot screenshot = new Screenshot();

    @Before()
    public void beforeScenario(Scenario scenario) {
        initializeWebApplication(Web.CHROME_WINDOWS);
        System.out.println("Teste execução " + scenario.getName());
        try {
            videoRecord.startRecording(scenario.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After()
    public void afterScenario(Scenario scenario) throws Exception {
        GeradorWordSteps geradorWordSteps = new GeradorWordSteps();
        videoRecord.stopRecording();
        screenshot.takeScreenShoot();
        geradorWordSteps.generateWord(scenario);
        closeWeb();
    }

}
