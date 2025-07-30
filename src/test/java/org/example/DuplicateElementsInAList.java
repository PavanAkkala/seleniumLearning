package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElementsInAList {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement ele = driver.findElement(By.xpath("//select[@id='colors']"));
        Select select = new Select(ele);

        List<WebElement> li = select.getOptions();

       // List<String> al = new ArrayList<>();
        Set<String> al = new HashSet<>();

        boolean flag = false;

        for (WebElement option : li) {

            String op = option.getText();

            if (!al.add(op)) {


                System.out.println("Duplcate elemt found " + op);

                flag = true;

            }


        }

        if (!flag) {

            System.out.println("No duplcates");
        }

    }
}
