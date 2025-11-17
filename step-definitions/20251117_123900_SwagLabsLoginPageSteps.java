package com.swaglabs.stepdefinitions;

import com.swaglabs.pages.SwagLabsLoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Step Definitions for Swag Labs Login Page features.
 * Implements interaction and validations of SwagLabsLoginPage POM methods.
 * Contains explicit waits, assertions, and error handling for robust automation.
 * 
 * This class is intended to be used with Cucumber-JVM scenarios for better BDD coverage.
 * 
 * @author Test Automation Architect
 * @created 2024-06-15
 */
public class SwagLabsLoginPageSteps {

    private final SwagLabsLoginPage loginPage;

    /**
     * Constructor initializes SwagLabsLoginPage using shared WebDriver instance.
     * Assumes WebDriver is managed and injected by dependency or hooks.
     *
     * @param driver WebDriver instance
     */
    public SwagLabsLoginPageSteps(WebDriver driver) {
        this.loginPage = new SwagLabsLoginPage(driver);
    }

    /**
     * Step to wait for login page to load completely.
     */
    @Given("Swag Labs login page is loaded")
    public void waitForLoginPageToLoad() {
        loginPage.waitForPageToLoad();
        Assert.assertTrue("Login page is not displaying properly after load.", loginPage.isPageDisplaying());
    }

    /**
     * Step to verify page title matches expected.
     *
     * @param expectedTitle expected page title string
     */
    @Then("page title should be {string}")
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals("Page title mismatch.", expectedTitle, actualTitle);
    }

    /**
     * Step to verify current URL matches expected URL.
     *
     * @param expectedUrl expected URL string
     */
    @Then("page URL should be {string}")
    public void verifyPageUrl(String expectedUrl) {
        loginPage.assertPageURL(expectedUrl);
    }

    /**
     * Step to enter username in username input field.
     *
     * @param username username string to enter
     */
    @When("user enters username {string}")
    public void enterUsername(String username) {
        loginPage.enterUserName(username);
        String enteredValue = loginPage.getUserNameValue();
        Assert.assertEquals("Username input field value does not match entered username.", username, enteredValue);
    }

    /**
     * Step to clear the username input field.
     */
    @And("user clears the username field")
    public void clearUsername() {
        loginPage.clearUserName();
        String value = loginPage.getUserNameValue();
        Assert.assertTrue("Username field was not cleared properly.", value.isEmpty());
    }

    /**
     * Step to verify username input field is displayed.
     */
    @Then("username input field should be displayed")
    public void usernameInputFieldDisplayed() {
        Assert.assertTrue("Username input field not displayed.", loginPage.isUserNameDisplayed());
    }

    /**
     * Step to verify username input field is enabled.
     */
    @Then("username input field should be enabled")
    public void usernameInputFieldEnabled() {
        Assert.assertTrue("Username input field is disabled.", loginPage.isUserNameEnabled());
    }

    /**
     * Step to verify username input field is prepopulated with expected value.
     *
     * @param expectedValue expected prepopulated username
     */
    @Then("username input field should be prepopulated with {string}")
    public void verifyUsernamePrepopulated(String expectedValue) {
        Assert.assertTrue("Username input field not prepopulated with expected value.",
                loginPage.isUserNamePrepopulatedWith(expectedValue));
    }

    /**
     * Step to verify username input field is required.
     */
    @Then("username input field should be required")
    public void usernameInputFieldRequired() {
        Assert.assertTrue("Username input field is not marked as required.", loginPage.isUserNameRequired());
    }

    /**
     * Step to enter password in password input field.
     *
     * @param password password string to enter
     */
    @When("user enters password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        String enteredValue = loginPage.getPasswordValue();
        Assert.assertEquals("Password input field value does not match entered password.", password, enteredValue);
    }

    /**
     * Step to clear the password input field.
     */
    @And("user clears the password field")
    public void clearPassword() {
        loginPage.clearPassword();
        String value = loginPage.getPasswordValue();
        Assert.assertTrue("Password field was not cleared properly.", value.isEmpty());
    }

    /**
     * Step to verify password input field is displayed.
     */
    @Then("password input field should be displayed")
    public void passwordInputFieldDisplayed() {
        Assert.assertTrue("Password input field not displayed.", loginPage.isPasswordDisplayed());
    }

    /**
     * Step to verify password input field is enabled.
     */
    @Then("password input field should be enabled")
    public void passwordInputFieldEnabled() {
        Assert.assertTrue("Password input field is disabled.", loginPage.isPasswordEnabled());
    }

    /**
     * Step to verify password input field is prepopulated with expected value.
     *
     * @param expectedValue expected prepopulated password
     */
    @Then("password input field should be prepopulated with {string}")
    public void verifyPasswordPrepopulated(String expectedValue) {
        Assert.assertTrue("Password input field not prepopulated with expected value.",
                loginPage.isPasswordPrepopulatedWith(expectedValue));
    }

    /**
     * Step to verify password input field is required.
     */
    @Then("password input field should be required")
    public void passwordInputFieldRequired() {
        Assert.assertTrue("Password input field is not marked as required.", loginPage.isPasswordRequired());
    }

    /**
     * Step to click the login button.
     */
    @When("user clicks the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    /**
     * Step to verify login button is displayed.
     */
    @Then("login button should be displayed")
    public void loginButtonDisplayed() {
        Assert.assertTrue("Login button is not displayed.", loginPage.isLoginButtonDisplayed());
    }

    /**
     * Step to verify login button is enabled.
     */
    @Then("login button should be enabled")
    public void loginButtonEnabled() {
        Assert.assertTrue("Login button is disabled.", loginPage.isLoginButtonEnabled());
    }

    /**
     * Step to verify login button text equals expected.
     *
     * @param expectedText expected button text
     */
    @Then("login button text should be {string}")
    public void verifyLoginButtonText(String expectedText) {
        String actualText = loginPage.getLoginButtonText();
        Assert.assertEquals("Login button text mismatch.", expectedText, actualText);
    }

    /**
     * Step to verify error message is displayed.
     */
    @Then("error message should be visible")
    public void errorMessageVisible() {
        Assert.assertTrue("Error message is not visible.", loginPage.isErrorMessageVisible());
    }

    /**
     * Step to verify error message contains expected text.
     *
     * @param expectedText expected substring in error message
     */
    @Then("error message should contain {string}")
    public void verifyErrorMessageContains(String expectedText) {
        loginPage.assertErrorMessageContains(expectedText);
    }

    /**
     * Step to verify the "Accepted usernames are:" header contains expected text.
     *
     * @param expectedText expected substring
     */
    @Then("accepted usernames header should contain {string}")
    public void acceptedUsernamesHeaderContains(String expectedText) {
        loginPage.assertAcceptedUsernamesHeaderContains(expectedText);
    }

    /**
     * Step to verify the "Password for all users:" header contains expected text.
     *
     * @param expectedText expected substring
     */
    @Then("password header should contain {string}")
    public void passwordHeaderContains(String expectedText) {
        loginPage.assertPasswordHeaderContains(expectedText);
    }
}