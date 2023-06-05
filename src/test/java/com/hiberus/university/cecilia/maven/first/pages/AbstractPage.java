package com.hiberus.university.cecilia.maven.first.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

@Slf4j
public abstract class AbstractPage {
    private final WebDriver driver;
    protected Wait<WebDriver> wait;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected  WebDriver getDriver(){
        return driver;
    }

    protected boolean isPageLoaded(WebElement element) {
        boolean isLoaded = false;
        try {
            isLoaded = element.isDisplayed();
        } catch (NoSuchElementException elementException) {
            elementException.printStackTrace();
        }
        return isLoaded;
    }


    public abstract WebElement getPageLoadedTestElement();
}
