package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShadowThreeSendKeys {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = (WebElement) jse.executeScript("return document.querySelector(\"#shadow_host\").shadowRoot.querySelector(\"input[type=text]:nth-child(5)\")");
        String js1 = "arguments[0].scrollIntoView(true);";
        jse.executeScript(js1,element);
        String js = "arguments[0].setAttribute('value', 'Dum masla biryani yerra karam gunture')";
        jse.executeScript(js, element);

        String txt = element.getDomProperty("value"); // Here value is fixed for all the things uwe only value if you want to get the run time values
        System.out.println(txt);

    }


}
