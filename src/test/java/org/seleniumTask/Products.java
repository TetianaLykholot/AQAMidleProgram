package org.seleniumTask;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Products  extends NewEraBaseTest{

    public Products(WebDriver driver) {

        this.driver = driver;
    }

    private By sizeField = By.xpath("//label[@for='template--18880003145955__main-1-1']");
    private By addToBagButton = By.id("originalStickyButton");

    public void clickOnSize() {
        driver.findElement(sizeField).click();
    }

    public void clickLogin() {
        driver.findElement(addToBagButton).click();
    }

    @Step("Add to bag")
    public void addToBag(){
        clickOnSize();
        clickLogin();

    }
}
