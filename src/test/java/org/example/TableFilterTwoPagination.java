package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class TableFilterTwoPagination {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement ele = driver.findElement(By.xpath("//tr/th[1]"));
        ele.click();

        //Capture all the elements in the list

        List<String> price;
        do {
            List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
            price = elementList.stream().filter(s -> s.getText().contains("Carrot")).map(TableFilterTwoPagination::getPriceVeggie).collect(Collectors.toList());
            price.forEach(System.out::println);

            if (price.isEmpty()) {

                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        } while (price.isEmpty());

    }

    private static String getPriceVeggie(WebElement s) {

        String priceValue;
        priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;

    }
}
