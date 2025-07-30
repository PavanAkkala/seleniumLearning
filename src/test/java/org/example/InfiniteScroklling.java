package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class InfiniteScroklling {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.booksbykilo.in/children-books?gad_source=1&gad_campaignid=19706481345&gbraid=0AAAAADAZuCbJcGFMRSLtnCHxVTcHy_S5u&gclid=Cj0KCQjwxdXBBhDEARIsAAUkP6jp86cXaRgmKFHYS5Mtke9HjQx8FahEm7s1NrnrgJfsT0xhReNjbO0aAgtuEALw_wcB");
        driver.manage().window().maximize();
        int previousCount = 0;
        int currentCount;

        while (true) {

            List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
            currentCount = books.size();

            if (currentCount == previousCount) {

                break;
            }

            previousCount = currentCount;
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            //actions.sendKeys(Keys.END).build().perform();
            try {
                Thread.sleep(3000); // Add wait time to let new content load
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(currentCount);

    }
}
