package com.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAccountProductPage extends BasePage{

    //elements
    @FindBy(css = ".products.row > div:nth-of-type(1) > .js-product-miniature.product-miniature h3 > a")
    private WebElement productNameTShirt;

    @FindBy(css = ".products.row > div:nth-of-type(2) > .js-product-miniature.product-miniature h3 > a")
    private WebElement productNameSweater;

    @FindBy(xpath = "//*//section[@id='main']//h1[@class='h1']")
    private WebElement selectedProductName;

    @FindBy(css = ".modal-text")
    private WebElement popUpMessageText;

    @FindBy(css = "h4#myModalLabel")
    private WebElement addToCartSuccessMessage;

    @FindBy(css = "[data-id_customization]")
    private WebElement addedToCartProductName;

    @FindBy(css = ".size .value")
    private WebElement chosenProductSizeInShoppingCart;

    @FindBy(css = ".regular-price")
    private WebElement priceBeforeDiscount;

    @FindBy(css = ".current-price .price")
    private WebElement priceAfterDiscount;

    //buttons
    @FindBy(css = ".products.row > div:nth-of-type(1) > .js-product-miniature.product-miniature h3 > a")
    private WebElement selectTShirtLink;
    @FindBy(css = ".products.row > div:nth-of-type(2) > .js-product-miniature.product-miniature h3 > a")
    private WebElement selectSweaterLink;

    @FindBy(css = ".wishlist-button-add.wishlist-button-product")
    private WebElement wishlistButton;

    @FindBy(css = ".wishlist-login > div[role='dialog'] > div[role='document'] .btn.btn-secondary.modal-cancel")
    private WebElement cancelButtonInPopUp;

    @FindBy(css = ".add-to-cart.btn.btn-primary")
    private WebElement addToCartButton;

    @FindBy(xpath = "//section[@id='content']/section[1]/div/div[1]/article//button[@class='wishlist-button-add']")
    private WebElement wishlistButtonOnHomePage;

    @FindBy(xpath = "//*//form[@id='add-to-cart-or-refresh']//select[@name='group[1]']")
    private WebElement selectSize;

    @FindBy(css = "select[name='group[1]'] > option[title='XL']")
    private WebElement pickASetSize;

    @FindBy(css = "select[name='group[1]'] > option[title='M']")
    private WebElement pickSweaterSize;

    @FindBy(css = ".modal-body .btn.btn-primary")
    private WebElement proceedToCheckoutButton;




    public UserAccountProductPage(WebDriver driver) {
        super(driver);
    }

    //check whether product names from the list are being displayed
    public boolean areProductsFromTheListBeingDisplayed(){
        try {
            driver.findElement(By.cssSelector(".products.row > div:nth-of-type(1) > .js-product-miniature.product-miniature h3 > a"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //selecting a t-shirt methods
    public void clickTShirtProductLink(){
        selectTShirtLink.click();
    }

    public String selectedProductNameDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(selectedProductName));
        return selectedProductName.getText();
    }


    //adding a product to wishlist methods

    public void clickOnWishListButton(){
        wishlistButton.click();
    }

    public String displayPopUpMessageText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(popUpMessageText));
        return popUpMessageText.getText();
    }
    public void clickCancelButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(popUpMessageText));
        cancelButtonInPopUp.click();
    }

    //adding the set product to cart methods
    public void clickOnSelectSizeSelector(){
        selectSize.click();
    }
    public void chooseASetSize(){
        pickASetSize.click();
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    public String addToCartSuccessMessageText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(addToCartSuccessMessage));
        return addToCartSuccessMessage.getText();
    }

    public void clickOnProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }

    //the set product in shopping cart methods
    public String displayedProductNameInShoppingCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(addedToCartProductName));
        return addedToCartProductName.getText();
    }

    public String displayedProductSizeInShoppingCart(){
        return chosenProductSizeInShoppingCart.getText();
    }

    public String displayProductPriceBeforeDiscount(){
        return priceBeforeDiscount.getText();
    }

    public String displayProductPriceAfterDiscount(){
        return priceAfterDiscount.getText();
    }
    //actual product value assertion
    public double actualTShirtValueAfterDiscount(){
        double result = 23.90 - (23.90 * 0.2);
        return result;
    }

    //selecting a sweater methods

    public void clickSweaterProductLink(){
        selectSweaterLink.click();
    }

    public void selectSweaterSize(){
        pickSweaterSize.click();
    }

    public double actualValueOfSweaterAfterDiscount(){
        double result = 35.90 - (35.90 * 0.2);
        return result;
    }










}
