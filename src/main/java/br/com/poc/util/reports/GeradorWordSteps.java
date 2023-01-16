package br.com.poc.util.reports;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.cucumber.java.Scenario;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import static br.com.poc.util.Consts.*;

public class GeradorWordSteps {
	/* improve the set information */
	 public void generateWord(Scenario scenario) throws Exception {
	        String path = "evidence/word/result/";
	        FrameworkWordEvidence evidence = new FrameworkWordEvidence();
	        WordprocessingMLPackage template = evidence.getTemplate("evidence/word/template/template_evidencias.docx");

			evidence.replacePlaceholder(template, enviroment, "<ambiente>");
		 	evidence.replacePlaceholder(template, scenario.getName(), "<id_nomeCT>");
		 	evidence.replacePlaceholder(template, scenario.getSourceTagNames().toString(), "<tags>");
		 	evidence.replacePlaceholder(template, scenario.getStatus().toString(), "<resultado_obtido>");
		 	evidence.replacePlaceholder(template, tester, "<executor>");
		 	evidence.replacePlaceholder(template, sprint, "<sp>");
		 	String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	        evidence.replacePlaceholder(template, timeStamp, "<data>");

	        evidence.createWordEvidence(template, path, scenario);
	    }

}
