package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        List<WebElement> element = driver.findElements(By.tagName("a"));
//        JavascriptExecutor js = ((JavascriptExecutor)driver);
//        js.executeScript("arguments[0].scrollIntoView();",element);
        System.out.println("elements is " + element.size());

        for (WebElement ele : element) {

            String hrefValue = ele.getAttribute("href");

            if (hrefValue == null || hrefValue.isEmpty()) {

                System.out.println("Href value is null or empty not possible to check");

                continue;
            }

            URL linkURL = new URL(hrefValue); //converted href value from string to url format
            HttpURLConnection conlinkURL = (HttpURLConnection) linkURL.openConnection(); // --> this method open connection to the server open connected it will return connection object
            conlinkURL.connect();

            if (conlinkURL.getResponseCode() >= 400) {

                System.out.println("Broken link");
            } else {

                System.out.println("Not Broken link");
            }
        }
    }
}

