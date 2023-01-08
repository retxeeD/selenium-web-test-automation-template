package br.com.poc.steps;

import br.com.poc.util.BaseTest;
import br.com.poc.util.communs.Web;
import br.com.poc.util.reports.GeradorWordSteps;
import br.com.poc.util.reports.ReportVariables;
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
        ReportVariables.setNome_cT(scenario.getName());
        scenario.toString();
        System.out.println("Teste execução Hooks Web");
        try {
            videoRecord.startRecording();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After()
    public void afterScenario(Scenario scenario) throws Exception {
        ReportVariables.setStatus(scenario.getStatus().toString());
        GeradorWordSteps geradorWordSteps = new GeradorWordSteps();
        videoRecord.stopRecording();
        screenshot.takeScreenShoot();
        geradorWordSteps.generateWord();
        closeWeb();
    }

}
