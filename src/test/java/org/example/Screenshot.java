package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        // Need to add common-io dependency for this
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//captures th screenshot as tempory file
        File target = new File(System.getProperty("user.dir") + "/screenshot/sc.png"); //defines the path

        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
