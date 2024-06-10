package com.prestashop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageToCreateAccountPageTest extends BaseTest{

    //test methods code
    private void clickOnCreateAccountLink() {
        HomePageToSignPage homePageToSignPage = new HomePageToSignPage(driver);
        //assurance sign in link is present on the page
        assertTrue(homePageToSignPage.isCreateAccountLinkPresent(), "The create account link isn't present on the page.");
        //assurance that sign in link displays expected icon and text
        assertEquals("Create account", homePageToSignPage.getCreateAccountLinkTextDisplayed());
        homePageToSignPage.clickOnCreateAccountLink();

    }
    private void inputValidEmail() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        //assertion whether the email input field is present or not
        assertTrue(createAccountPage.isInputEmailFieldPresent(), "The email input field isn't present");

        createAccountPage.inputValidEmailIntoInputField();
        assertEquals("m20@gmail.com", createAccountPage.emailTextAsItIsDisplayed()); //Important note: since there's no randomizer in use here, the email address must be changed manually(both in page method and in assurance). The other input fields work fine with existing values
    }
    private void inputValidPassword(CreateAccountPage createAccountPage) {
        assertTrue(createAccountPage.isInputPasswordFieldPresent(), "The password input field isn't present");
        createAccountPage.inputValidPasswordIntoInputField();
    }
    private void inputValidFirstName(CreateAccountPage createAccountPage) {
        //assertion whether the first name input field is present
        assertTrue(createAccountPage.isInputFirstNameFieldPresent(), "The first name input field isn't present");
        createAccountPage.inputValidFirstNameIntoInputField();
    }
    private void inputValidLastName(CreateAccountPage createAccountPage) {
        //assertion whether the first name input field is present
        assertTrue(createAccountPage.isInputLastNameFieldPresent(), "The last name input field isn't present");

        createAccountPage.inputValidLastNameIntoInputField();

    }
    private void clickOnSocialTitleCheckbox(CreateAccountPage createAccountPage) {
        //assertion whether the social title checkbox is present
        assertTrue(createAccountPage.isSocialTitleGenderCheckBoxPresent(), "The social title checkbox isn't present");
        createAccountPage.clickOnSocialTitleGenderCheckBox();
    }

    private static void clickOnRequiredCheckBoxes(CreateAccountPage createAccountPage) {
        assertTrue(createAccountPage.isAgreeToTermsCheckBoxPresent(), "The 'agree to terms' checkbox isn't present");
        createAccountPage.clickOnAgreeToTermsCheckBox();

        assertTrue(createAccountPage.isCustomerDataPrivacyCheckBoxPresent(), "The 'customer data privacy' checkbox is present");
        createAccountPage.clickOnCustomerDataPrivacyCheckBox();
    }
    private void registerNewAccount(CreateAccountPage createAccountPage) {
        clickOnCreateAccountLink();
        inputValidEmail();
        inputValidPassword(createAccountPage);
        inputValidFirstName(createAccountPage);
        inputValidLastName(createAccountPage);
        clickOnSocialTitleCheckbox(createAccountPage);
        clickOnRequiredCheckBoxes(createAccountPage);

        assertTrue(createAccountPage.isSaveButtonPresent(), "The save button isn't present on the page");
        System.out.println("The 'save' button is present" + "\n");
        createAccountPage.clickOnSaveButtonForAccountCreation();
    }

    private void newAccountSignIn(NewUserAccountAssurancePage newUserAccountAssurancePage) {
        assertTrue(newUserAccountAssurancePage.isSignInLinkPresent(), "The sign-in link is present");
        newUserAccountAssurancePage.clickSignInLink();
        System.out.println("The 'sign in' link was clicked" + "\n");

        newUserAccountAssurancePage.inputEmailIntoEmailInputField();
        newUserAccountAssurancePage.inputPasswordintoPasswordInputField();
        newUserAccountAssurancePage.clickSignInButton();
        System.out.println("The 'sign in' button was clicked");
        //assertion the login is successful
        assertEquals("Matt Maddison", newUserAccountAssurancePage.checkIfTheNewAccountHasBeenRegistered());
    }

    // Test 1 -> Sign-in link test
    @Test
    void clickOnCreateAccountLinkTest(){
        HomePageToSignPage homePageToSignPage = new HomePageToSignPage(driver);
        clickOnCreateAccountLink();
        System.out.println("The 'Create account' link text is displayed as such: " + homePageToSignPage.getCreateAccountLinkTextDisplayed() + "\n");
        System.out.println("The create account link is clicked" + "\n");
    }

    // Test 2 -> Input valid email test
    @Test
    void inputValidEmailTest(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        clickOnCreateAccountLink();
        inputValidEmail();
        System.out.println("The valid email ws input into field" + "\n");
        System.out.println("The email displayed in the input field is: " + createAccountPage.emailTextAsItIsDisplayed() + "\n");
    }


    //Test 3 -> Input valid password into input field

    @Test
    void inputValidPasswordTest(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        clickOnCreateAccountLink();
        inputValidPassword(createAccountPage);
        System.out.println("The password was input into the input field" + "\n");
    }



    //Test 4 -> input valid first name into input field

    @Test
    void inputValidFirstNameTest(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        clickOnCreateAccountLink();
        inputValidFirstName(createAccountPage);
        System.out.println("The valid first name was input into input field." + "\n");
    }

    //Test 5 -> input valid last name into input field

    @Test
    void inputValidLastNameIntoInputField(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        clickOnCreateAccountLink();
        inputValidLastName(createAccountPage);
        System.out.println("The valid last name was input into input field" + "\n");
    }

    //Test 6 -> test the social title checkbox functionality by selecting a specific gender
    @Test
    void checkTheSocialTitleCheckboxTest(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        clickOnCreateAccountLink();
        clickOnSocialTitleCheckbox(createAccountPage);
        System.out.println("The social title checkbox was clicked" + "\n");

    }

    //Test 7 -> click on required checkboxes test
    @Test
    void clickOnRequiredTickCheckBoxesTest(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        clickOnCreateAccountLink();
        clickOnRequiredCheckBoxes(createAccountPage);
        System.out.println("The 'agree to terms' checkbox was clicked" + "\n");
        System.out.println("The 'customer data privacy' checkbox was clicked" + "\n");
    }

    //Test 8 -> Register the new account test
    @Test
    void registeredNewAccountTest(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        registerNewAccount(createAccountPage);
        NewUserAccountAssurancePage newUserAccountAssurancePage = new NewUserAccountAssurancePage(driver);
        newUserAccountAssurancePage.checkIfTheNewAccountHasBeenRegistered();
        System.out.println("The user name displayed is:" + newUserAccountAssurancePage.checkIfTheNewAccountHasBeenRegistered() + "\n");

        assertTrue(newUserAccountAssurancePage.isSignOutLinkPresent(), "The 'sign out link isn't present");
        newUserAccountAssurancePage.clickSignOutLink();
        System.out.println("The 'sign out' process was complete" + "\n");

    }
    //Test 9 New Account sign-in test
    @Test
    void newAccountSignInTest(){
        NewUserAccountAssurancePage newUserAccountAssurancePage = new NewUserAccountAssurancePage(driver);
        newAccountSignIn(newUserAccountAssurancePage);
    }



}
