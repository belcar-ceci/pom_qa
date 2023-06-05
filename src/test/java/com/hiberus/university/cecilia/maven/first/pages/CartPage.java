package com.hiberus.university.cecilia.maven.first.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage {

    CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
