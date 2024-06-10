package com.prestashop;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage extends BasePage{
    //elements
    @FindBy(xpath = "//*//input[@id='field-email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//*//input[@id='field-password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*//input[@id='field-firstname']")
    private WebElement inputFirstNameField;

    @FindBy(xpath = "//*//input[@id='field-lastname']")
    private WebElement inputLastNameField;

    //buttons
    @FindBy(css = "#field-id_gender-1")
    private WebElement socialTitleCheckBoxGenderClick;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/div/div[8]/div[1]/span/label/input")
    private WebElement agreeToTermsCheckBox;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/div/div[10]/div[1]/span/label/input")
    private WebElement customerDataPrivacyCheckBox;

    @FindBy(xpath = "//form[@id='customer-form']//button[@type='submit']")
    private WebElement clickOnSaveButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    //input valid email methods
    public void inputValidEmailIntoInputField(){
        emailInputField.sendKeys("m20@gmail.com");
    } //Important note: since there's not randomizer the email address has to be set manually. Other input fields work with existing values

    public boolean isInputEmailFieldPresent(){
        try {
            driver.findElement(By.xpath("//*//input[@id='field-email']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String emailTextAsItIsDisplayed(){
        return emailInputField.getAttribute("value");
    }

    //input valid password methods

    public void inputValidPasswordIntoInputField(){
        passwordInputField.sendKeys("Kanker1125#");
    }

    public boolean isInputPasswordFieldPresent(){
        try {
            driver.findElement(By.xpath("//*//input[@id='field-password']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //input valid first name methods

    public void inputValidFirstNameIntoInputField(){
        inputFirstNameField.sendKeys("Matt");
    }

    public boolean isInputFirstNameFieldPresent(){
        try {
            driver.findElement(By.cssSelector("input#field-firstname"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String firstNameAsItIsDisplayed(){

        return inputFirstNameField.getText();
    }

    //input valid last name methods

    public void inputValidLastNameIntoInputField(){
        inputLastNameField.sendKeys("Maddison");
    }

    public boolean isInputLastNameFieldPresent(){
        try {
            driver.findElement(By.xpath("//*//input[@id='field-lastname']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String lastNameAsItIsDisplayed(){
        return inputLastNameField.getText();
    }

    //click on the social title checkbox methods

    public void clickOnSocialTitleGenderCheckBox(){
        socialTitleCheckBoxGenderClick.click();
    }

    public boolean isSocialTitleGenderCheckBoxPresent(){
        try {
            driver.findElement(By.cssSelector("#field-id_gender-1"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //click on the required checkboxes methods

    public void clickOnAgreeToTermsCheckBox(){
        agreeToTermsCheckBox.click();
    }

    public boolean isAgreeToTermsCheckBoxPresent(){
        try {
            driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[8]/div[1]/span/label/input"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnCustomerDataPrivacyCheckBox(){
        customerDataPrivacyCheckBox.click();
    }

    public boolean isCustomerDataPrivacyCheckBoxPresent(){
        try {
            driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[10]/div[1]/span/label/input"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //click on 'save' button methods
    public void clickOnSaveButtonForAccountCreation(){

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", clickOnSaveButton);


            js.executeScript("arguments[0].click();", clickOnSaveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSaveButtonPresent(){
        try {
            driver.findElement(By.cssSelector("#customer-form > footer > button"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
