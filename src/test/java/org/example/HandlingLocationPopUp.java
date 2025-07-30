package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class HandlingLocationPopUp {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        // Create a map to store preferences
        Map<String, Object> prefs = new HashMap<>();

        // 1 = allow, 2 = block
        prefs.put("profile.default_content_setting_values.geolocation", 1); // Use 2 to block

        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[normalize-space()='Where am I?']"));

    }
}
