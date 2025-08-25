package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Allert {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
//        WebElement ele = driver.findElement(By.xpath("//button[text()='Simple Alert']"));
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("arguments[0].scrollIntoView();", ele);
//        ele.click();
//        Alert al = driver.switchTo().alert();
//        String alert = al.getText();
//        System.out.println(alert);
//        al.accept();

        //Alert with text
        WebElement ds = driver.findElement(By.xpath("//button[text()='Prompt Alert']"));
        ds.click();
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
        js1.executeScript("arguments[0].scrollIntoView();", ds);
       Alert  re =  driver.switchTo().alert();
       re.sendKeys("Don");
       re.accept();

       //comment

    }
}
