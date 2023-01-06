package br.com.frame.steps;

import br.com.frame.util.BaseTest;
import br.com.frame.util.communs.Web;
import br.com.frame.util.reports.GeradorWordSteps;
import br.com.frame.util.reports.ReportVariables;
import br.com.frame.util.reports.Screenshot;
import br.com.frame.util.reports.VideoRecord;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


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
        ReportVariables.setStatus(scenario.getStatus());
        GeradorWordSteps geradorWordSteps = new GeradorWordSteps();
        videoRecord.stopRecording();
        screenshot.takeScreenShoot();
        geradorWordSteps.generateWord();
        closeWeb();
    }

}
