package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthentactaionPopups {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
       // driver.get("https://the-internet.herokuapp.com/basic_auth");
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
    }


}
