data package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Step Definitions for LoginPage interactions and validations.
 * 
 * Each method here corresponds to a behavior or assertion related to Swag Labs LoginPage.
 * It uses the LoginPage POM methods and incorporates assertions and waits as needed.
 * 
 * Author: Test Automation Architect
 * Created: 2024-06
 */
public class LoginPageSteps {

    private final LoginPage loginPage;
    private final WebDriver driver;

    /**
     * Constructor for dependency injection.
     * 
     * @param driver WebDriver instance from test context
     */
    public LoginPageSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    // -----------------
    // Navigation & Page Load
    // -----------------

    /**
     * Waits for the LoginPage to be fully loaded.
     */
    @Given("the Login page is loaded")
    public void loginPageIsLoaded() {
        loginPage.waitForPageToLoad();
        Assertions.assertTrue(loginPage.isPageDisplaying(), "Login page should be displayed");
    }

    /**
     * Asserts the current page URL matches the expected login page URL.
     * 
     * @param expectedURL Expected URL string
     */
    @Then("the user is on the Login page with URL {string}")
    public void verifyLoginPageURL(String expectedURL) {
        loginPage.assertPageURL(expectedURL);
    }

    // -----------------
    // Username Input Field Steps
    // -----------------

    /**
     * Enters username into username input field.
     * 
     * @param username to enter
     */
    @When("the user enters username {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        // Assert field is prepopulated after entry
        Assertions.assertEquals(username, loginPage.getUsernameValue(), "Username input value must match entered text");
    }

    /**
     * Clears the username input field.
     */
    @And("the user clears the username field")
    public void clearUsernameField() {
        loginPage.clearUsername();
        Assertions.assertEquals("", loginPage.getUsernameValue(), "Username input field should be empty after clearing");
    }

    /**
     * Verifies if username field is displayed.
     */
    @Then("the username input field is displayed")
    public void usernameFieldDisplayed() {
        Assertions.assertTrue(loginPage.isUsernameDisplayed(), "Username input should be displayed");
    }

    /**
     * Verifies if username input field is enabled.
     */
    @Then("the username input field is enabled")
    public void usernameFieldEnabled() {
        Assertions.assertTrue(loginPage.isUsernameEnabled(), "Username input should be enabled");
    }

    /**
     * Verifies the username field is prepopulated with the expected value.
     * 
     * @param expectedUsername expected value in username input
     */
    @Then("the username input field is prepopulated with {string}")
    public void usernameFieldPrepopulated(String expectedUsername) {
        Assertions.assertTrue(loginPage.isUsernamePrepopulatedWith(expectedUsername),
                "Username input prepopulated value mismatch");
    }

    /**
     * Verifies if the username input is marked required.
     */
    @Then("the username input field is required")
    public void usernameFieldRequired() {
        Assertions.assertTrue(loginPage.isUsernameRequired(), "Username input field should be required");
    }

    // -----------------
    // Password Input Field Steps
    // -----------------

    /**
     * Enters password into password input field.
     * 
     * @param password to enter
     */
    @When("the user enters password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        Assertions.assertEquals(password, loginPage.getPasswordValue(), "Password input value must match entered text");
    }

    /**
     * Clears the password input field.
     */
    @And("the user clears the password field")
    public void clearPasswordField() {
        loginPage.clearPassword();
        Assertions.assertEquals("", loginPage.getPasswordValue(), "Password input field should be empty after clearing");
    }

    /**
     * Verifies password field is displayed.
     */
    @Then("the password input field is displayed")
    public void passwordFieldDisplayed() {
        Assertions.assertTrue(loginPage.isPasswordDisplayed(), "Password input should be displayed");
    }

    /**
     * Verifies password input field is enabled.
     */
    @Then("the password input field is enabled")
    public void passwordFieldEnabled() {
        Assertions.assertTrue(loginPage.isPasswordEnabled(), "Password input should be enabled");
    }

    /**
     * Verifies password input is prepopulated with the expected value.
     * 
     * @param expectedPassword expected value
     */
    @Then("the password input field is prepopulated with {string}")
    public void passwordFieldPrepopulated(String expectedPassword) {
        Assertions.assertTrue(loginPage.isPasswordPrepopulatedWith(expectedPassword),
                "Password input prepopulated value mismatch");
    }

    /**
     * Verifies password input is marked required.
     */
    @Then("the password input field is required")
    public void passwordFieldRequired() {
        Assertions.assertTrue(loginPage.isPasswordRequired(), "Password input field should be required");
    }

    // -----------------
    // Login Button Steps
    // -----------------

    /**
     * Clicks the login button.
     */
    @When("the user clicks the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    /**
     * Verifies login button is displayed.
     */
    @Then("the login button is displayed")
    public void loginButtonDisplayed() {
        Assertions.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be displayed");
    }

    /**
     * Verifies login button is enabled.
     */
    @Then("the login button is enabled")
    public void loginButtonEnabled() {
        Assertions.assertTrue(loginPage.isLoginButtonEnabled(), "Login button should be enabled");
    }

    /**
     * Verifies the login button text matches expected.
     * 
     * @param expectedText expected login button text
     */
    @Then("the login button displays text {string}")
    public void loginButtonTextIs(String expectedText) {
        String actualText = loginPage.getLoginButtonText();
        Assertions.assertEquals(expectedText, actualText, "Login button text mismatch");
    }

    // -----------------
    // Error Message Steps
    // -----------------

    /**
     * Verifies that an error message is displayed on the page.
     */
    @Then("an error message is displayed")
    public void errorMessageIsDisplayed() {
        Assertions.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message container should be displayed");
    }

    /**
     * Verifies the error message contains the expected text.
     * 
     * @param expectedMessage substring expected in error message
     */
    @Then("the error message contains {string}")
    public void errorMessageContains(String expectedMessage) {
        loginPage.assertErrorMessageContains(expectedMessage);
    }

    // -----------------
    // Informational Text & Labels
    // -----------------

    /**
     * Verifies the "Accepted usernames are:" heading text contains expected substring.
     * 
     * @param expectedText expected content substring
     */
    @Then("the Accepted usernames heading contains {string}")
    public void acceptedUsernamesHeadingContains(String expectedText) {
        String actualHeading = loginPage.getAcceptedUsernamesHeadingText();
        Assertions.assertTrue(actualHeading.contains(expectedText),
                "Accepted usernames heading mismatch: expected to contain '" + expectedText + "', but was '" + actualHeading + "'");
    }

    /**
     * Verifies the accepted usernames list text contains the expected usernames substring.
     * 
     * @param expectedUsernames expected usernames substring
     */
    @Then("the Accepted usernames list contains {string}")
    public void acceptedUsernamesListContains(String expectedUsernames) {
        String actualList = loginPage.getAcceptedUsernamesListText();
        Assertions.assertTrue(actualList.contains(expectedUsernames),
                "Accepted usernames list mismatch: expected to contain '" + expectedUsernames + "', but was '" + actualList + "'");
    }

    /**
     * Verifies the "Password for all users:" heading contains the expected substring.
     * 
     * @param expectedText expected substring in heading
     */
    @Then("the Password for all users heading contains {string}")
    public void passwordForAllUsersHeadingContains(String expectedText) {
        String actualHeading = loginPage.getPasswordForAllUsersHeadingText();
        Assertions.assertTrue(actualHeading.contains(expectedText),
                "Password for all users heading mismatch: expected to contain '" + expectedText + "', but was '" + actualHeading + "'");
    }

    /**
     * Verifies the password information text contains the expected substring.
     * 
     * @param expectedText expected substring in password info text
     */
    @Then("the Password for all users text contains {string}")
    public void passwordForAllUsersTextContains(String expectedText) {
        String actualText = loginPage.getPasswordForAllUsersText();
        Assertions.assertTrue(actualText.contains(expectedText),
                "Password for all users text mismatch: expected to contain '" + expectedText + "', but was '" + actualText + "'");
    }

    // -----------------
    // Generic Text Assertion Using Locator
    // -----------------

    /**
     * Asserts that an element identified by the locator contains the expected text.
     * 
     * @param locatorType  the type of locator: id, css, xpath
     * @param locatorValue the locator query string
     * @param expectedText the expected substring to be present
     */
    @Then("the element located by {string} with value {string} contains text {string}")
    public void elementContainsText(String locatorType, String locatorValue, String expectedText) {
        By locator;
        switch (locatorType.toLowerCase()) {
            case "id":
                locator = By.id(locatorValue);
                break;
            case "css":
                locator = By.cssSelector(locatorValue);
                break;
            case "xpath":
                locator = By.xpath(locatorValue);
                break;
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }
        loginPage.assertTextContains(locator, expectedText);
    }

}