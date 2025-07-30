package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AmazonParticularIphoneClick {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Amazon
        driver.get("https://www.amazon.in");

        // Search for iPhone
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone");
        searchBox.sendKeys(Keys.ENTER);

        // Target product name
        String targetProduct = "iPhone 16 256 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Black";
        boolean productFoundAndClicked = false;

        // Pagination loop
        while (true) {
            try {
                // Wait for results to load
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));

                // Get all <a> links
                List<WebElement> productLinks = driver.findElements(By.tagName("a"));

                // Try to find the specific product
                Optional<WebElement> desiredProduct = productLinks.stream()
                        .filter(el -> el.getText().toLowerCase().contains(targetProduct.toLowerCase()))
                        .findFirst();

                if (desiredProduct.isPresent()) {
                    WebElement productToClick = desiredProduct.get();
                    String productName = productToClick.getText(); // Capture text before click
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productToClick);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productToClick);
                    System.out.println("Clicked on: " + productName);
                    productFoundAndClicked = true;
                    break;
                }

                // If not found, go to next page
                WebElement nextBtn = driver.findElement(By.xpath("//a[contains(text(), 'Next')]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextBtn);

            } catch (NoSuchElementException | TimeoutException e) {
                break; // no more pages or button not found
            }
        }

        if (!productFoundAndClicked) {
            System.out.println("Product not found: " + targetProduct);
        }

        // Optional: Quit browser
        // driver.quit();
    }
    }
