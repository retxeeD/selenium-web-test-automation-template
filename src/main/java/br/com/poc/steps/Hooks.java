package br.com.poc.steps;

import br.com.poc.util.BaseTest;
import br.com.poc.util.communs.Web;
import br.com.poc.util.reports.FrameworkWordEvidence;
import br.com.poc.util.reports.PrintScreen;
import br.com.poc.util.reports.ScreenVideoRecord;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.ArrayList;
import java.util.List;

public class Hooks extends BaseTest {

    ScreenVideoRecord screenVideoRecord = new ScreenVideoRecord();
    PrintScreen printScreen = new PrintScreen();
    static List<Scenario> scenarios = new ArrayList<>();

    @Before()
    public void beforeScenario(Scenario scenario) {
        initializeWebApplication(Web.CHROME_WINDOWS);
        System.out.println("Teste execução " + scenario.getName());
        try {
            screenVideoRecord.startRecording(scenario.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After()
    public void afterScenario(Scenario scenario) throws Exception {
        screenVideoRecord.stopRecording();
        printScreen.takeScreenShoot(scenario.getName());
        scenarios.add(scenario);
        closeWeb();
    }

    @AfterAll()
    public static void afterAllCenarios(){
        try {
            FrameworkWordEvidence frameworkWordEvidence = new FrameworkWordEvidence();
            scenarios.forEach(scenario -> {
                try {
                    frameworkWordEvidence.generateWord(scenario);
                } catch (Exception e) {
                    throw new RuntimeException("docx report file creation error\n" + e.getMessage());
                }
            });
            frameworkWordEvidence.saveFileDocx();
        }catch (Exception e){
            throw new RuntimeException("docx report file save error\n" + e.getMessage());
        }
    }

}
