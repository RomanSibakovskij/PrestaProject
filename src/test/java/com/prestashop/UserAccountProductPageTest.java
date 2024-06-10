package com.prestashop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserAccountProductPageTest extends BaseTest{

    //test methods code
    private static void selectedTShirtTest(UserAccountProductPage userAccountProductPage) {
        // 5 -> select the product
        userAccountProductPage.clickTShirtProductLink();
        System.out.println("The link was clicked");
        //assertion the name is displayed
        assertEquals("HUMMINGBIRD PRINTED T-SHIRT", userAccountProductPage.selectedProductNameDisplayed());
        System.out.println("Product name displayed is: " + userAccountProductPage.selectedProductNameDisplayed() + "\n");

        userAccountProductPage.clickOnWishListButton();
        // 7 -> assertion the popup message is correct
        assertEquals("You need to be logged in to save products in your wishlist.", userAccountProductPage.displayPopUpMessageText());
        System.out.println("The popup message says: " + userAccountProductPage.displayPopUpMessageText() + "\n");
        // 8 -> press 'Cancel' button
        userAccountProductPage.clickCancelButton();
        System.out.println("The 'cancel' button was clicked" + "\n");
        // 9 -> select a size as requested in the file
        userAccountProductPage.clickOnSelectSizeSelector();
        System.out.println("The selector was clicked" + "\n");
        //click on set size
        userAccountProductPage.chooseASetSize();
        System.out.println("The set size was chosen" + "\n");
        //10 -> click on 'Add to cart' button.
        userAccountProductPage.clickOnAddToCartButton();
        System.out.println("The 'add to cart' button was clicked" + "\n");
        //11 -> assert the message displayed is valid
        assertEquals("\uE876Product successfully added to your shopping cart",  userAccountProductPage.addToCartSuccessMessageText());
        System.out.println("The add to cart message says: " + userAccountProductPage.addToCartSuccessMessageText() + "\n");
        //12 -> click on 'Proceed to checkout' button
        userAccountProductPage.clickOnProceedToCheckoutButton();
        System.out.println("The 'proceed to checkout button was clicked" + "\n");
        //13 -> assert that the valid product was added
        assertEquals("Hummingbird printed t-shirt", userAccountProductPage.displayedProductNameInShoppingCart());
        System.out.println("The product name in shopping cart is: " + userAccountProductPage.displayedProductNameInShoppingCart() + "\n");
        //14 -> assert that the chosen product size is correct
        assertEquals("XL", userAccountProductPage.displayedProductSizeInShoppingCart());
        System.out.println("The product size in shopping cart is: " + userAccountProductPage.displayedProductSizeInShoppingCart() + "\n");
        //15 -> assert that the discount price is being applied correctly
        assertEquals("$23.90", userAccountProductPage.displayProductPriceBeforeDiscount());
        System.out.println("The displayed price before discount is: " + userAccountProductPage.displayProductPriceBeforeDiscount() + "\n");
        //displayed price after discount
        assertEquals("$19.12", userAccountProductPage.displayProductPriceAfterDiscount());
        System.out.println("The displayed price after discount is: " + userAccountProductPage.displayProductPriceAfterDiscount() + "\n");
        //actual product price after 20% discount
        System.out.println("The actual product price after discount is: " + userAccountProductPage.actualTShirtValueAfterDiscount() + "\n");
    }

    private static void selectedSweaterTest(UserAccountProductPage userAccountProductPage) {
        userAccountProductPage.clickSweaterProductLink();
        System.out.println("The sweater link was clicked" + "\n");
        //assertion the name is displayed
        assertEquals("HUMMINGBIRD PRINTED SWEATER", userAccountProductPage.selectedProductNameDisplayed());
        System.out.println("Product name displayed is: " + userAccountProductPage.selectedProductNameDisplayed() + "\n");


        userAccountProductPage.clickOnWishListButton();
        // 7 -> assertion the popup message is correct
        assertEquals("You need to be logged in to save products in your wishlist.", userAccountProductPage.displayPopUpMessageText());
        System.out.println("The popup message says: " + userAccountProductPage.displayPopUpMessageText() + "\n");
        // 8 -> press 'Cancel' button
        userAccountProductPage.clickCancelButton();
        System.out.println("The 'cancel' button was clicked" + "\n");
        // 9 -> select a size as requested in the file
        userAccountProductPage.clickOnSelectSizeSelector();
        System.out.println("The selector was clicked" + "\n");
        //click on set size
        userAccountProductPage.selectSweaterSize();
        System.out.println("The set size was chosen" + "\n");
        //10 -> click on 'Add to cart' button.
        userAccountProductPage.clickOnAddToCartButton();
        System.out.println("The 'add to cart' button was clicked" + "\n");
        //11 -> assert the message displayed is valid
        assertEquals("\uE876Product successfully added to your shopping cart",  userAccountProductPage.addToCartSuccessMessageText());
        System.out.println("The add to cart message says: " + userAccountProductPage.addToCartSuccessMessageText() + "\n");
        //12 -> click on 'Proceed to checkout' button
        userAccountProductPage.clickOnProceedToCheckoutButton();
        System.out.println("The 'proceed to checkout button was clicked" + "\n");
        //13 -> assert that the valid product was added
        assertEquals("Hummingbird printed sweater", userAccountProductPage.displayedProductNameInShoppingCart());
        System.out.println("The product name in shopping cart is: " + userAccountProductPage.displayedProductNameInShoppingCart() + "\n");
        //14 -> assert that the chosen product size is correct
        assertEquals("M", userAccountProductPage.displayedProductSizeInShoppingCart());
        System.out.println("The product size in shopping cart is: " + userAccountProductPage.displayedProductSizeInShoppingCart() + "\n");
        //15 -> assert that the discount price is being applied correctly
        assertEquals("$35.90", userAccountProductPage.displayProductPriceBeforeDiscount());
        System.out.println("The displayed price before discount is: " + userAccountProductPage.displayProductPriceBeforeDiscount() + "\n");
        //displayed price after discount
        assertEquals("$28.72", userAccountProductPage.displayProductPriceAfterDiscount());
        System.out.println("The displayed price after discount is: " + userAccountProductPage.displayProductPriceAfterDiscount() + "\n");
        //actual product price after 20% discount
        System.out.println("The actual product price after discount is: " + userAccountProductPage.actualValueOfSweaterAfterDiscount() + "\n");
    }


    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/products.csv", numLinesToSkip = 1)
    void readItemsFromProvidedFileTest(String Products) {
        UserAccountProductPage userAccountProductPage = new UserAccountProductPage(driver);

        assertNotNull(Products, "Product name is: " + Products);
        System.out.println("Displayed products: " + Products);
         // 3 -> assertion whether or not products from the list are being displayed on the homepage
        boolean areProductsBeingDisplayed = userAccountProductPage.areProductsFromTheListBeingDisplayed();
        // 4 -> assertion that the product names are being matched
        assertTrue(areProductsBeingDisplayed, "Product isn't being displayed: " + Products);
        System.out.println(String.valueOf(areProductsBeingDisplayed) + "\n");

    }

    //Test with t-shirt
    @Test
    void selectTShirtFromTheProductsPageTest(){
    UserAccountProductPage userAccountProductPage = new UserAccountProductPage(driver);
        selectedTShirtTest(userAccountProductPage);


    }

    //same test but with sweater
    @Test
    void selectSweaterFromTheProductsPageTest(){
    UserAccountProductPage userAccountProductPage = new UserAccountProductPage(driver);
    // 5 -> select the product
        selectedSweaterTest(userAccountProductPage);


    }



}
