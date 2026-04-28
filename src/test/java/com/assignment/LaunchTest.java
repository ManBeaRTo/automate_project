package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class LaunchTest 
{

    public void searchAndAddProduct(String productName) throws InterruptedException
    {

        WebDriver driver = new ChromeDriver();

        Thread.sleep(1500);
        System.out.println();

        driver.get("https://www.amazon.in");

        Thread.sleep(3000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName); // inserts the product name in search box
        driver.findElement(By.id("nav-search-submit-button")).click();

        Thread.sleep(3000);

        List<WebElement> products = driver.findElements // finds all the products in the search result
        (
                By.cssSelector("a.a-link-normal.s-line-clamp-2")
        );
        products.get(0).click();  //clicks on the first product

        Thread.sleep(4000);

        Set<String> windows = driver.getWindowHandles(); // gets all window handles
        for (String w : windows) 
            driver.switchTo().window(w); // switches to new window

        Thread.sleep(5000);

        WebElement priceElement = driver.findElement(By.id("apex-pricetopay-accessibility-label")); // finds the correct price element

        String price = priceElement.getAttribute("innerHTML").trim();
        System.out.println(productName + " Price: " + price);

        List<WebElement> cartButtons = driver.findElements(By.id("add-to-cart-button")); // finds all add to cart buttons

        for(WebElement btn : cartButtons) // iterates through the buttons to find correct one
        {
            if(btn.isDisplayed() && btn.isEnabled())
            {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
                Thread.sleep(3000);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
                break;
            }
        }

        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void searchIphone() throws InterruptedException
    {
        searchAndAddProduct("iphone");
    }

    @Test
    public void searchGalaxy() throws InterruptedException
    {
        searchAndAddProduct("galaxy");
    }
}