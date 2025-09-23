package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShadowTwoClick {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = (WebElement) jse.executeScript("return document.querySelector(\"#shadow_host\").shadowRoot.querySelector(\"input[type=file]:nth-child(9)\")");
        String jsScroll = "arguments[0].scrollIntoView(true);";
        jse.executeScript(jsScroll, element);
        String js = "arguments[0].click()";
        jse.executeScript(js, element);

        Thread.sleep(5000);


        String filePath = "D:\\New folder (3)\\APKFiles\\resources\\General-Store.apk";
        element.sendKeys(filePath);

    }
}
