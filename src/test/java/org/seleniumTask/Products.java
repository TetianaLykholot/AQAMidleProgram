package org.seleniumTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Products  extends NewEraBaseTest{

    WebDriver driver;
    private By sizeField = By.xpath("//label[@for='template--18880003145955__main-1-1']");
    private By addToBagButton = By.id("originalStickyButton");

    public void Product(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSize() {
        driver.findElement(sizeField).click();
    }

    public void clickLogin() {
        driver.findElement(addToBagButton).click();
    }

    public void addToBag(){
        clickOnSize();
        clickLogin();

    }
}
