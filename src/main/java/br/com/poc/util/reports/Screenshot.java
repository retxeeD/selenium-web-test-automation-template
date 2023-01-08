package br.com.poc.util.reports;

import br.com.poc.util.DateUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Screenshot {
/* Add exceptionHandler class to printer screen whjen the test failed*/
    public void takeScreenShoot() throws AWTException, IOException {

        Robot awt_robot = new Robot();
        BufferedImage Entire_Screen = awt_robot.createScreenCapture(
                new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(Entire_Screen, "PNG", new File("evidence/screenshot/"+ DateUtils.getDateAndTime() + ".png"));

    }
}
