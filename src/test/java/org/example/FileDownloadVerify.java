package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

public class FileDownloadVerify {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        String downloadPath = System.getProperty("user.dir");

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);

        options.setExperimentalOption("prefs",chromePrefs);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://testautomationpractice.blogspot.com/p/download-files_25.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()='Download PDF File']")).click();


        File folder = new File(downloadPath);
        File[] files = folder.listFiles();

       // folder.listFiles() returns an array of File objects.

      //  Each element in the array represents one file or subfolder inside that directory.

      //  For example, if your folder has abc.txt, demo.zip, xyz.doc, this array will contain 3 File objects representing each one
        boolean fileFound = false;

        for (File file : files) {
            if (file.getName().contains("DownloadDemo-master.zip")) { // expected file name
                fileFound = true;
                System.out.println(" File downloaded successfully: " + file.getName());
                break;
            }
        }

        if (!fileFound) {
            System.out.println(" File not found in download folder!");
        }
    }
}
