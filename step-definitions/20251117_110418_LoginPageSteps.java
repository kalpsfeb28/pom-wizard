package com.saucelabs.steps;

import static org.junit.Assert.*;

import com.saucelabs.pages.LoginPage;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

/**
 * Step Definitions for LoginPage interactions and verifications.
 * This class provides BDD-style step definitions utilizing the LoginPage POM,
 * incorporating robust waits, error handling and assertions for enterprise-grade test automation.
 * 
 * Author: Test Automation Architect
 * Created: 2024-06-08
 * Purpose: Encapsulate step-level automation logic for the Swag Labs login page.
 */
public class LoginPageSteps {

    private final WebDriver driver;
    private final LoginPage loginPage;

    /**
     * Constructor to initialize WebDriver and LoginPage instance.
     * @param driver WebDriver instance injected from hooks or test context
     */
    public LoginPageSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    // ==============
    // GIVEN Steps
    // ==============

    /**
     * Verifies that the Swag Labs login page is displayed with correct title and username input presence.
     */
    @Given("the Swag Labs login page is displayed")
    public void theSwagLabsLoginPageIsDisplayed() {
        loginPage.waitForPageToLoad();
        boolean isDisplaying = loginPage.isPageDisplaying();
        assertTrue("Login page is not displaying correctly (title or username input missing)", isDisplaying);
    }

    /**
     * Verifies that the current page URL contains the specified substring.
     * @param expectedURLSubstring substring expected in the URL
     */
    @Given("the page URL contains {string}")
    public void thePageURLContains(String expectedURLSubstring) {
        loginPage.assertPageURLContains(expectedURLSubstring);
    }

    /**
     * Verifies that the login logo text is displayed and matches expected.
     * @param expectedLogoText expected login logo text
     */
    @Given("the login logo is visible with text {string}")
    public void theLoginLogoIsVisibleWithText(String expectedLogoText) {
        assertTrue("Login logo is not displayed", loginPage.isLoginLogoDisplayed());
        String actualLogoText = loginPage.getLoginLogoText();
        assertEquals("Login logo text mismatch", expectedLogoText, actualLogoText);
    }

    /**
     * Verifies the accepted usernames label is displayed and contains specified text.
     * @param expectedText text expected in accepted usernames label
     */
    @Given("the accepted usernames label contains {string}")
    public void theAcceptedUsernamesLabelContains(String expectedText) {
        assertTrue("Accepted usernames label is not displayed", loginPage.isAcceptedUsernamesLabelDisplayed());
        loginPage.assertAcceptedUsernamesLabelContains(expectedText);
    }

    /**
     * Verifies the password for all users label is displayed and contains specified text.
     * @param expectedText text expected in password for all users label
     */
    @Given("the password for all users label contains {string}")
    public void thePasswordForAllUsersLabelContains(String expectedText) {
        assertTrue("Password for all users label is not displayed", loginPage.isPasswordForAllUsersLabelDisplayed());
        loginPage.assertPasswordForAllUsersLabelContains(expectedText);
    }

    // ==============
    // WHEN Steps
    // ==============

    /**
     * Enters the username into the username input field.
     * @param username username string to enter
     */
    @When("the user enters username {string}")
    public void theUserEntersUsername(String username) {
        loginPage.enterUserName(username);
        // Assert that the entered value is correctly populated
        String actualValue = loginPage.getUserNameValue();
        assertEquals("Username input value mismatch after entry", username, actualValue);
    }

    /**
     * Clears the username input field.
     */
    @When("the user clears the username input")
    public void theUserClearsTheUsernameInput() {
        loginPage.clearUserName();
        String value = loginPage.getUserNameValue();
        assertTrue("Username input field is not empty after clear", value.isEmpty());
    }

    /**
     * Enters the password into the password input field.
     * @param password password string to enter
     */
    @When("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        loginPage.enterPassword(password);
        String actualValue = loginPage.getPasswordValue();
        assertEquals("Password input value mismatch after entry", password, actualValue);
    }

    /**
     * Clears the password input field.
     */
    @When("the user clears the password input")
    public void theUserClearsThePasswordInput() {
        loginPage.clearPassword();
        String value = loginPage.getPasswordValue();
        assertTrue("Password input field is not empty after clear", value.isEmpty());
    }

    /**
     * Clicks the login button.
     */
    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        assertTrue("Login button is not displayed before clicking", loginPage.isLoginButtonDisplayed());
        assertTrue("Login button is not enabled before clicking", loginPage.isLoginButtonEnabled());
        loginPage.clickLoginButton();
    }

    // ==============
    // THEN Steps
    // ==============

    /**
     * Validates that the username input field is displayed.
     */
    @Then("the username input field is displayed")
    public void theUsernameInputFieldIsDisplayed() {
        assertTrue("Username input field is not displayed", loginPage.isUserNameDisplayed());
    }

    /**
     * Validates that the username input field is enabled.
     */
    @Then("the username input field is enabled")
    public void theUsernameInputFieldIsEnabled() {
        assertTrue("Username input field is not enabled", loginPage.isUserNameEnabled());
    }

    /**
     * Asserts the username input field is prepopulated with the given value.
     * @param expectedValue expected default username
     */
    @Then("the username input field is prepopulated with {string}")
    public void theUsernameInputFieldIsPrepopulatedWith(String expectedValue) {
        assertTrue("Username input field is not prepopulated correctly",
                loginPage.isUserNamePrepopulatedWith(expectedValue));
    }

    /**
     * Asserts the username input field has 'required' attribute set.
     */
    @Then("the username input field is required")
    public void theUsernameInputFieldIsRequired() {
        assertTrue("Username input field is not marked as required", loginPage.isUserNameRequired());
    }

    /**
     * Validates that the password input field is displayed.
     */
    @Then("the password input field is displayed")
    public void thePasswordInputFieldIsDisplayed() {
        assertTrue("Password input field is not displayed", loginPage.isPasswordDisplayed());
    }

    /**
     * Validates that the password input field is enabled.
     */
    @Then("the password input field is enabled")
    public void thePasswordInputFieldIsEnabled() {
        assertTrue("Password input field is not enabled", loginPage.isPasswordEnabled());
    }

    /**
     * Asserts the password input field is prepopulated with the given value.
     * @param expectedValue expected default password
     */
    @Then("the password input field is prepopulated with {string}")
    public void thePasswordInputFieldIsPrepopulatedWith(String expectedValue) {
        assertTrue("Password input field is not prepopulated correctly",
                loginPage.isPasswordPrepopulatedWith(expectedValue));
    }

    /**
     * Asserts the password input field has 'required' attribute set.
     */
    @Then("the password input field is required")
    public void thePasswordInputFieldIsRequired() {
        assertTrue("Password input field is not marked as required", loginPage.isPasswordRequired());
    }

    /**
     * Validates that the login button is displayed.
     */
    @Then("the login button is displayed")
    public void theLoginButtonIsDisplayed() {
        assertTrue("Login button is not displayed", loginPage.isLoginButtonDisplayed());
    }

    /**
     * Validates that the login button is enabled.
     */
    @Then("the login button is enabled")
    public void theLoginButtonIsEnabled() {
        assertTrue("Login button is not enabled", loginPage.isLoginButtonEnabled());
    }

    /**
     * Validates the login button displays the expected text.
     * @param expectedText expected login button text
     */
    @Then("the login button displays text {string}")
    public void theLoginButtonDisplaysText(String expectedText) {
        String actualText = loginPage.getLoginButtonText();
        assertEquals("Login button text mismatch", expectedText, actualText);
    }

    /**
     * Validates that the error message container is visible.
     */
    @Then("an error message container is visible")
    public void anErrorMessageContainerIsVisible() {
        assertTrue("Error message container is not visible when expected", loginPage.isErrorMessageContainerVisible());
    }

    /**
     * Validates that the displayed error message text contains given text.
     * @param expectedMessage expected error message substring
     */
    @Then("the error message contains {string}")
    public void theErrorMessageContains(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        assertTrue("Error message does not contain expected text. Actual: " + actualMessage,
                actualMessage.contains(expectedMessage));
    }

    /**
     * Validates that the accepted usernames label is displayed.
     */
    @Then("the accepted usernames label is displayed")
    public void theAcceptedUsernamesLabelIsDisplayed() {
        assertTrue("Accepted usernames label is not displayed", loginPage.isAcceptedUsernamesLabelDisplayed());
    }

    /**
     * Validates that the password for all users label is displayed.
     */
    @Then("the password for all users label is displayed")
    public void thePasswordForAllUsersLabelIsDisplayed() {
        assertTrue("Password for all users label is not displayed", loginPage.isPasswordForAllUsersLabelDisplayed());
    }

    /**
     * Validates the page title is exactly the expected title.
     * @param expectedTitle expected page title string
     */
    @Then("the page title is {string}")
    public void thePageTitleIs(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        assertEquals("Page title mismatch", expectedTitle, actualTitle);
    }
}