package com.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewUserAccountAssurancePage extends BasePage{
    //elements
    @FindBy(css = "#_desktop_user_info > div > a.account > span")
    private WebElement loggedUserName;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[1]")
    private WebElement logoutLink;

    @FindBy(css = ".user-info [title]")
    private WebElement signInLink;

    @FindBy(xpath = "//*//input[@id='field-email']")
    private WebElement inputEmailField;

    @FindBy(xpath = "//*//input[@id='field-password']")
    private WebElement inputPasswordField;

    @FindBy(css = "button#submit-login")
    private WebElement signInButton;
    public NewUserAccountAssurancePage(WebDriver driver) {
        super(driver);
    }
    //check whether the new account has been registered method
    public String checkIfTheNewAccountHasBeenRegistered(){
        return loggedUserName.getText();
    }
    //click 'sign out' link methods
    public void clickSignOutLink(){
        logoutLink.click();
    }

    public boolean isSignOutLinkPresent(){
        try {
            driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    //new account sign-in methods

    public void clickSignInLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(signInLink));
        signInLink.click();
    }
    public boolean isSignInLinkPresent(){
        try {
            driver.findElement(By.cssSelector(".user-info [title]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void inputEmailIntoEmailInputField(){
        inputEmailField.sendKeys("m14@gmail.com");
    }

    public void inputPasswordintoPasswordInputField(){
        inputPasswordField.sendKeys("Kanker1125#");
    }

    public void clickSignInButton(){
        signInButton.click();
    }



}
