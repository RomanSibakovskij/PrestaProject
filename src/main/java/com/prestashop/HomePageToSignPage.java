package com.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageToSignPage extends BasePage{
    //elements
    @FindBy(xpath = "//div[@id='_desktop_user_info']//a[@title='Log in to your customer account']")
    private WebElement signInLink;
    @FindBy(xpath = "//ul[@id='footer_account_list']//a[@title='Create account']")
    private WebElement createAccountLink;
    public HomePageToSignPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnCreateAccountLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(createAccountLink));

        Actions scrollDown = new Actions(driver);
        scrollDown.moveToElement(createAccountLink);
        scrollDown.perform();

        createAccountLink.click();
    }

    public boolean isCreateAccountLinkPresent(){
        try {
            driver.findElement(By.xpath("//ul[@id='footer_account_list']//a[@title='Create account']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getCreateAccountLinkTextDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(createAccountLink));
        return createAccountLink.getText();
    }
}
