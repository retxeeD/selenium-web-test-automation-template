package br.com.poc.util;

import br.com.poc.properties.PropertiesLoader;
import br.com.poc.util.commons.Constant;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Report {

    public static void newReport(){

        PropertiesLoader pl = PropertiesLoader.getInstance();
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<String>();
        String reportJsonPath = "./target/report.json";
        jsonFiles.add(reportJsonPath);

        String projectName, commit, environment, sigla, namespace;

        projectName = pl.getValueEnvironment(Constant.PROJECT_NAME);
        environment = pl.getValueEnvironment(Constant.ENVIROMENT);

        if(environment.toLowerCase().contains("dev")){
            environment = "Desenvolvimento";
        } else if (environment.toLowerCase().contains("hom")){
            environment = "Homologação";
        } else if (environment.toLowerCase().contains("sdb")) {
            environment = "Sandbox";
        }

        commit = System.getenv("CI_COMMIT_SHORT_SHA");
        namespace = pl.getValueEnvironment("CI_PROJECT_NAMESPACE") == null? "RL7": pl.getValueEnvironment("CI_PROJECT_NAMESPACE");
        String[] projectNamespace = namespace.split("/");
        sigla = projectNamespace[0];

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);

        configuration.addClassifications("Sigla", sigla);
        configuration.addClassifications("Ambiente", environment);
        configuration.addClassifications("GithubCommit", commit);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();

    }

}