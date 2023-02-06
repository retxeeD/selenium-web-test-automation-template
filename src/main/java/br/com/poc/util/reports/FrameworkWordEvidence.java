package br.com.poc.util.reports;

import io.cucumber.java.Scenario;
import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static br.com.poc.util.commons.Constant.*;

public class FrameworkWordEvidence {

    private static final String RESULT_SCREENSHOT_PATH = "evidence/screenshot/";
    private static final String RESULT_WORD_PATH = "evidence/word/result/automationsEvidence.docx";
    private static final String DOCX_TEMPLATE_PATH = "evidence/word/template/template_evidencias.docx";

    private WordprocessingMLPackage baseTemplate = WordprocessingMLPackage.load(new FileInputStream(new File(DOCX_TEMPLATE_PATH)));
    private WordprocessingMLPackage template = WordprocessingMLPackage.load(new FileInputStream(new File(DOCX_TEMPLATE_PATH)));


    public FrameworkWordEvidence() throws Exception {
    }

    public void generateWord(List<Scenario> scenarios) throws Exception {
        for (Scenario scenario : scenarios){
            replacePlaceholder(ENVIROMENT, "env");
            replacePlaceholder(scenario.getName(), "scenario_name");
            replacePlaceholder(scenario.getSourceTagNames().toString(), "tags");
            replacePlaceholder(scenario.getStatus().toString(), "scenario_status");
            replacePlaceholder(System.getProperty("user.name"), "executioner");
            replacePlaceholder(SPRINT, "sp");
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
            replacePlaceholder(timeStamp, "date");
            createWordEvidence(scenario);
            if (scenarios.indexOf(scenario) < (scenarios.size() - 1)){
                addElement();
            }
        }
    }

    public List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
        List<Object> result = new ArrayList<Object>();
        if (obj instanceof JAXBElement)
            obj = ((JAXBElement<?>) obj).getValue();
        if (obj.getClass().equals(toSearch))
            result.add(obj);
        else if (obj instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) obj).getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        }
        return result;
    }

    public void replacePlaceholder(String name, String placeholder) {
        List<Object> texts = getAllElementFromObject(this.template.getMainDocumentPart(), Text.class);
        for (Object text : texts) {
            Text textElement = (Text) text;
            if ((textElement.getValue() != null) && textElement.getValue().equals(placeholder)) {
                textElement.setValue(name);
            }
        }
    }

    public void saveFileDocx(){
        try {
            File f = new File(RESULT_WORD_PATH);
            if (!f.exists()){
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
            this.template.save(f);
        }catch (Exception e){
            throw new RuntimeException("Fail to save file\n" + e.getMessage());
        }
    }

    public void addImage(WordprocessingMLPackage template, String evidence) throws Exception {
        File file = new File(evidence);
        InputStream is = new FileInputStream(file);
        long length = file.length();
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            System.out.println("Could not completely read file " + file.getName());
        }
        is.close();
        org.docx4j.wml.P p = newImage(template, bytes);
        template.getMainDocumentPart().addObject(p);
    }

    private void addElement(){
        Br breakObj = new Br();
        breakObj.setType(STBrType.PAGE);
        P paragraph = new ObjectFactory().createP();
        paragraph.getContent().add(breakObj);
        this.template.getMainDocumentPart().addObject(paragraph);
        this.baseTemplate.getMainDocumentPart().getContent().forEach(
                content -> this.template.getMainDocumentPart().addObject(content));
    }

    public org.docx4j.wml.P newImage(WordprocessingMLPackage wordMLPackage, byte[] bytes) throws Exception {
        BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);
        Inline inline = imagePart.createImageInline(null, null, 0, 1, 10000L, false);
        org.docx4j.wml.ObjectFactory factory = Context.getWmlObjectFactory();
        org.docx4j.wml.P p = factory.createP();
        org.docx4j.wml.R run = factory.createR();
        p.getContent().add(run);
        org.docx4j.wml.Drawing drawing = factory.createDrawing();
        run.getContent().add(drawing);
        drawing.getAnchorOrInline().add(inline);
        return p;
    }

    public void addText(String text){
        String[] txtParagraphArray = text.split("\n");
        for (String txt : txtParagraphArray) {
            this.template.getMainDocumentPart().addParagraphOfText(txt);
        }
    }

    public void createWordEvidence(Scenario scenario)
            throws Exception {
        if (scenario.getStatus() != null) {
            addText("PrintScreen:");
        }
        addImageToDocx(scenario);
    }

    private void addImageToDocx(Scenario scenario) throws Exception {
        File folder = new File(RESULT_SCREENSHOT_PATH);
        File[] screenshots = folder.listFiles();
        for (File file : screenshots) {
            if (file.isFile() && file.getName().equals(scenario.getName()+".png")) {
                addImage(this.template,RESULT_SCREENSHOT_PATH+file.getName());
                file.delete();
            }
        }
    }

}
