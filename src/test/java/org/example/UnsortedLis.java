package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnsortedLis {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement li = driver.findElement(By.xpath("//select[@id='colors']"));
        Select dropDown = new Select(li);

        ArrayList<String> originalList = new ArrayList<>();
        ArrayList<String> tempList = new ArrayList<>();

        List<WebElement> options = dropDown.getOptions();

        for (WebElement option:options) {

            String text = option.getText();  // extract the visible text
            originalList.add(text);
            tempList.add(text);

        }

        System.out.println("Before sorting "+originalList);
        System.out.println("Before sorting "+tempList);

        Collections.sort(tempList);

        System.out.println(originalList);
        System.out.println(tempList);

    }
}
