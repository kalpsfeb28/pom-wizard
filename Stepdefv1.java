data package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Step Definitions for LoginPage interactions and assertions.
 * This class wraps all public methods in LoginPage POM with Cucumber steps including meaningful assertions.
 * It includes error handling and explicit wait-related logic already inside the POM.
 * 
 * Usage:
 * Inject WebDriver instance via constructor (from hooks or dependency injection).
 * 
 * @author TestAutomationArchitect
 * @created 2024-06-18
 */
public class LoginPageSteps {

    private final LoginPage loginPage;
    private final WebDriver driver;

    /**
     * Constructor to initialize LoginPageSteps with WebDriver instance.
     * 
     * @param driver WebDriver instance to be shared across step definitions
     */
    public LoginPageSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    /**
     * Step to wait for the login page to completely load.
     */
    @Given("the login page is loaded completely")
    public void waitForLoginPageToLoad() {
        // Wait for main elements to be present and visible
        loginPage.waitForPageToLoad();
        // Assert page is displayed properly
        Assert.assertTrue(loginPage.isPageDisplaying(), "Login page is not displayed properly.");
    }

    /**
     * Step to verify current page title matches expected title.
     * 
     * @param expectedTitle expected page title string
     */
    @Then("the page title should be {string}")
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected.");
    }

    /**
     * Step to assert current page URL matches expected URL.
     * 
     * @param expectedURL expected URL string
     */
    @Then("the page URL should be {string}")
    public void verifyPageURL(String expectedURL) {
        loginPage.assertPageURL(expectedURL);
    }

    // === Username Input Field Steps ===

    /**
     * Step to enter username value into username input field.
     * 
     * @param username username to enter
     */
    @When("the user enters username {string}")
    public void enterUserName(String username) {
        loginPage.enterUserName(username);
        // Assert field value matches entered username
        String enteredValue = loginPage.getUserNameValue();
        Assert.assertEquals(enteredValue, username, "Username input value mismatch after entering.");
    }

    /**
     * Step to clear the username input field.
     */
    @And("the user clears the username field")
    public void clearUserNameField() {
        loginPage.clearUserName();
        Assert.assertEquals(loginPage.getUserNameValue(), "", "Username field is not cleared properly.");
    }

    /**
     * Step to verify the username input field is displayed and enabled.
     */
    @Then("the username input field should be visible and enabled")
    public void verifyUserNameFieldVisibilityAndEnabled() {
        Assert.assertTrue(loginPage.isUserNameDisplayed(), "Username input field is not displayed.");
        Assert.assertTrue(loginPage.isUserNameEnabled(), "Username input field is not enabled.");
    }

    /**
     * Step to verify username field is required.
     */
    @Then("the username input field is required")
    public void verifyUserNameFieldIsRequired() {
        Assert.assertTrue(loginPage.isUserNameRequired(), "Username input field is not marked as required.");
    }

    /**
     * Step to verify the username input field is prepopulated with expected value.
     * 
     * @param expectedValue expected prepopulated value
     */
    @Then("the username input field should be prepopulated with {string}")
    public void verifyUserNameFieldIsPrepopulated(String expectedValue) {
        boolean result = loginPage.isUserNamePrepopulatedWith(expectedValue);
        Assert.assertTrue(result, "Username input field is NOT prepopulated with expected value: " + expectedValue);
    }

    // === Password Input Field Steps ===

    /**
     * Step to enter password value into password input field.
     * 
     * @param password password to enter
     */
    @When("the user enters password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        String enteredValue = loginPage.getPasswordValue();
        Assert.assertEquals(enteredValue, password, "Password input value mismatch after entering.");
    }

    /**
     * Step to clear the password input field.
     */
    @And("the user clears the password field")
    public void clearPasswordField() {
        loginPage.clearPassword();
        Assert.assertEquals(loginPage.getPasswordValue(), "", "Password field is not cleared properly.");
    }

    /**
     * Step to verify the password input field is displayed and enabled.
     */
    @Then("the password input field should be visible and enabled")
    public void verifyPasswordFieldVisibilityAndEnabled() {
        Assert.assertTrue(loginPage.isPasswordDisplayed(), "Password input field is not displayed.");
        Assert.assertTrue(loginPage.isPasswordEnabled(), "Password input field is not enabled.");
    }

    /**
     * Step to verify password input field is required.
     */
    @Then("the password input field is required")
    public void verifyPasswordFieldIsRequired() {
        Assert.assertTrue(loginPage.isPasswordRequired(), "Password input field is not marked as required.");
    }

    /**
     * Step to verify the password input field is prepopulated with expected value.
     * 
     * @param expectedValue expected prepopulated password value
     */
    @Then("the password input field should be prepopulated with {string}")
    public void verifyPasswordFieldIsPrepopulated(String expectedValue) {
        boolean result = loginPage.isPasswordPrepopulatedWith(expectedValue);
        Assert.assertTrue(result, "Password input field is NOT prepopulated with expected value: " + expectedValue);
    }

    // === Login Button Steps ===

    /**
     * Step to click the login button.
     */
    @When("the user clicks the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
        // No direct assert here, further steps should validate the outcome
    }

    /**
     * Step to verify login button is displayed and enabled with expected text.
     * 
     * @param expectedButtonText expected visible button text
     */
    @Then("the login button should be visible, enabled and display text {string}")
    public void verifyLoginButton(String expectedButtonText) {
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button is not enabled.");
        String actualText = loginPage.getLoginButtonText();
        Assert.assertEquals(actualText, expectedButtonText, "Login button text mismatch.");
    }

    // === Error Message Container Steps ===

    /**
     * Step to verify error message container is visible with expected error message text.
     * 
     * @param expectedErrorMsg expected error message substring to verify inside container text
     */
    @Then("an error message containing {string} is displayed")
    public void verifyErrorMessageIsVisible(String expectedErrorMsg) {
        Assert.assertTrue(loginPage.isErrorMessageVisible(), "Error message container is not visible.");
        String actualErrorMsg = loginPage.getErrorMessageText();
        Assert.assertTrue(actualErrorMsg.contains(expectedErrorMsg),
            "Error message text does not contain expected text: " + expectedErrorMsg);
    }

    /**
     * Step to close/dismiss the error message container if close button exists.
     */
    @And("the user closes the error message")
    public void closeErrorMessage() {
        // Attempt to close error message. If close button missing, no action.
        loginPage.closeErrorMessage();
        Assert.assertFalse(loginPage.isErrorMessageVisible(), "Error message container still visible after close attempt.");
    }

    // === Login Logo Steps ===

    /**
     * Step to verify the login logo with text "Swag Labs" is displayed.
     */
    @Then("the login logo with text {string} is displayed")
    public void verifyLoginLogoText(String expectedLogoText) {
        Assert.assertTrue(loginPage.isLoginLogoDisplayed(), "Login logo is not displayed.");
        String actualLogoText = loginPage.getLoginLogoText();
        Assert.assertEquals(actualLogoText, expectedLogoText, "Login logo text does not match expected.");
    }

    // === Accepted Usernames Section Steps ===

    /**
     * Step to verify the accepted usernames block is displayed and contains expected text.
     * 
     * @param expectedUsernames expected usernames or text to verify
     */
    @Then("the accepted usernames section is displayed containing {string}")
    public void verifyAcceptedUsernamesSection(String expectedUsernames) {
        Assert.assertTrue(loginPage.isLoginCredentialsDisplayed(), "Accepted usernames section is not displayed.");
        loginPage.assertAcceptedUsernamesContain(expectedUsernames);
    }

    /**
     * Step to verify the heading "Accepted usernames are:" is displayed.
     */
    @Then("the heading {string} is displayed for accepted usernames")
    public void verifyAcceptedUsernamesHeading(String expectedHeadingText) {
        Assert.assertTrue(loginPage.isAcceptedUsernamesHeadingDisplayed(), "Accepted usernames heading is not displayed.");
        String actualText = loginPage.getAcceptedUsernamesHeadingText();
        Assert.assertEquals(actualText, expectedHeadingText, "Accepted usernames heading text mismatch.");
    }

    // === Password Info Section Steps ===

    /**
     * Step to verify the password info section is displayed containing expected text.
     * 
     * @param expectedPasswordInfo expected password info substring (e.g. secret_sauce)
     */
    @Then("the password info section is displayed containing {string}")
    public void verifyPasswordInfoSection(String expectedPasswordInfo) {
        Assert.assertTrue(loginPage.isLoginPasswordInfoDisplayed(), "Password info section is not displayed.");
        loginPage.assertLoginPasswordInfoContains(expectedPasswordInfo);
    }

    /**
     * Step to verify the heading "Password for all users:" is displayed.
     */
    @Then("the heading {string} is displayed for password info")
    public void verifyPasswordForAllUsersHeading(String expectedHeadingText) {
        Assert.assertTrue(loginPage.isPasswordForAllUsersHeadingDisplayed(), "Password for all users heading is not displayed.");
        String actualText = loginPage.getPasswordForAllUsersHeadingText();
        Assert.assertEquals(actualText, expectedHeadingText, "Password for all users heading text mismatch.");
    }
    
}