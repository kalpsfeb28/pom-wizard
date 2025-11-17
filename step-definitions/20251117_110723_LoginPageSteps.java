package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Step Definition class for LoginPage.
 * Implements steps for interacting with and validating the Swag Labs Login Page.
 * Each method maps to corresponding methods in LoginPage, enhanced with assertions and proper waits.
 * 
 * This class is ready to be integrated into a Cucumber test suite.
 * 
 * Author: Test Automation Architect
 * Created: 2024-06-01
 */
public class LoginPageSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    /**
     * Constructor initializes WebDriver and the LoginPage object.
     * In a real framework, WebDriver would be injected or managed by hooks.
     */
    public LoginPageSteps() {
        // Initialize WebDriver (assuming chromedriver is in system PATH)
        this.driver = new ChromeDriver();
        this.loginPage = new LoginPage(driver);
    }

    /**
     * Loads the login page url and waits for the page to be loaded.
     * @param url The login page URL to load.
     */
    @Given("the user is on the login page {string}")
    public void theUserIsOnTheLoginPage(String url) {
        driver.get(url);
        loginPage.waitForPageToLoad();
        Assert.assertTrue("Login page should be displayed after loading", loginPage.isPageDisplaying());
    }

    // ============================
    // Username input field steps
    // ============================

    /**
     * Enters the username into username input.
     * @param username Username to enter.
     */
    @When("the user enters username {string}")
    public void theUserEntersUsername(String username) {
        loginPage.enterUserName(username);
        // Verify input's value matches
        String actualUsername = loginPage.getUserNameValue();
        Assert.assertEquals("Username input value should match entered value", username, actualUsername);
    }

    /**
     * Clears the username input field.
     */
    @And("the user clears the username input")
    public void theUserClearsTheUsernameInput() {
        loginPage.clearUserName();
        String clearedValue = loginPage.getUserNameValue();
        Assert.assertEquals("Username input field should be cleared", "", clearedValue);
    }

    /**
     * Validates username field displayed.
     */
    @Then("the username input field should be displayed")
    public void theUsernameInputFieldShouldBeDisplayed() {
        Assert.assertTrue("Username input should be displayed", loginPage.isUserNameDisplayed());
    }

    /**
     * Validates username field enabled.
     */
    @And("the username input field should be enabled")
    public void theUsernameInputFieldShouldBeEnabled() {
        Assert.assertTrue("Username input should be enabled", loginPage.isUserNameEnabled());
    }

    /**
     * Validates username input field is required.
     */
    @Then("the username input field should be required")
    public void theUsernameInputFieldShouldBeRequired() {
        Assert.assertTrue("Username input field should be required", loginPage.isUserNameRequired());
    }

    /**
     * Validates username prepopulated with expected value.
     * @param expectedValue Expected username prepopulated value.
     */
    @Then("the username input field should be prepopulated with {string}")
    public void theUsernameInputFieldShouldBePrepopulatedWith(String expectedValue) {
        Assert.assertTrue(
                "Username input field should be prepopulated with: " + expectedValue,
                loginPage.isUserNamePrepopulatedWith(expectedValue));
    }

    // ============================
    // Password input field steps
    // ============================

    /**
     * Enters the password into password input.
     * @param password Password to enter.
     */
    @When("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        loginPage.enterPassword(password);
        String actualPassword = loginPage.getPasswordValue();
        Assert.assertEquals("Password input value should match entered value", password, actualPassword);
    }

    /**
     * Clears the password input field.
     */
    @And("the user clears the password input")
    public void theUserClearsThePasswordInput() {
        loginPage.clearPassword();
        String clearedValue = loginPage.getPasswordValue();
        Assert.assertEquals("Password input field should be cleared", "", clearedValue);
    }

    /**
     * Validates password input field displayed.
     */
    @Then("the password input field should be displayed")
    public void thePasswordInputFieldShouldBeDisplayed() {
        Assert.assertTrue("Password input should be displayed", loginPage.isPasswordDisplayed());
    }

    /**
     * Validates password input field enabled.
     */
    @And("the password input field should be enabled")
    public void thePasswordInputFieldShouldBeEnabled() {
        Assert.assertTrue("Password input should be enabled", loginPage.isPasswordEnabled());
    }

    /**
     * Validates password input field is required.
     */
    @Then("the password input field should be required")
    public void thePasswordInputFieldShouldBeRequired() {
        Assert.assertTrue("Password input field should be required", loginPage.isPasswordRequired());
    }

    /**
     * Validates password prepopulated with expected value.
     * @param expectedValue Expected password prepopulated value.
     */
    @Then("the password input field should be prepopulated with {string}")
    public void thePasswordInputFieldShouldBePrepopulatedWith(String expectedValue) {
        Assert.assertTrue(
                "Password input field should be prepopulated with: " + expectedValue,
                loginPage.isPasswordPrepopulatedWith(expectedValue));
    }

    // ============================
    // Login button steps
    // ============================

    /**
     * Clicks the login button.
     */
    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        Assert.assertTrue("Login button should be displayed before click", loginPage.isLoginButtonDisplayed());
        Assert.assertTrue("Login button should be enabled before click", loginPage.isLoginButtonEnabled());
        loginPage.clickLoginButton();
    }

    /**
     * Validates login button is displayed.
     */
    @Then("the login button should be displayed")
    public void theLoginButtonShouldBeDisplayed() {
        Assert.assertTrue("Login button should be displayed", loginPage.isLoginButtonDisplayed());
    }

    /**
     * Validates login button is enabled.
     */
    @And("the login button should be enabled")
    public void theLoginButtonShouldBeEnabled() {
        Assert.assertTrue("Login button should be enabled", loginPage.isLoginButtonEnabled());
    }

    /**
     * Validates login button text.
     * @param expectedText Expected text on login button.
     */
    @Then("the login button text should be {string}")
    public void theLoginButtonTextShouldBe(String expectedText) {
        String actualText = loginPage.getLoginButtonText();
        Assert.assertEquals("Login button text should match", expectedText, actualText);
    }

    // ============================
    // Error message steps
    // ============================

    /**
     * Validates error message is displayed.
     */
    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        Assert.assertTrue("Error message should be displayed", loginPage.isErrorMessageDisplayed());
    }

    /**
     * Validates error message contains expected text.
     * @param expectedErrorText Error message text expected.
     */
    @Then("the error message should contain {string}")
    public void theErrorMessageShouldContain(String expectedErrorText) {
        loginPage.assertErrorMessageContains(expectedErrorText);
    }

    // ============================
    // Login credentials section steps
    // ============================

    /**
     * Validates login credentials section is displayed.
     */
    @Then("the login credentials section should be displayed")
    public void theLoginCredentialsSectionShouldBeDisplayed() {
        Assert.assertTrue("Login credentials section should be displayed", loginPage.isLoginCredentialsSectionDisplayed());
    }

    /**
     * Validates the text content of the login credentials section contains expected substring.
     * @param expectedText Expected substring within login credentials section.
     */
    @And("the login credentials section should contain {string}")
    public void theLoginCredentialsSectionShouldContain(String expectedText) {
        String actualText = loginPage.getLoginCredentialsText();
        Assert.assertTrue(
                "Login credentials section text should contain: " + expectedText,
                actualText.contains(expectedText));
    }

    /**
     * Validates the heading "Accepted usernames are:" is displayed and correct.
     */
    @Then("the accepted usernames heading should be displayed")
    public void theAcceptedUsernamesHeadingShouldBeDisplayed() {
        String headingText = loginPage.getAcceptedUsernamesHeadingText();
        Assert.assertEquals("Accepted usernames heading text should match", "Accepted usernames are:", headingText);
    }

    /**
     * Validates the heading "Password for all users:" is displayed and correct.
     */
    @Then("the password for all users heading should be displayed")
    public void thePasswordForAllUsersHeadingShouldBeDisplayed() {
        String headingText = loginPage.getPasswordForAllUsersHeadingText();
        Assert.assertEquals("Password for all users heading text should match", "Password for all users:", headingText);
    }

    // ============================
    // Page-level validations
    // ============================

    /**
     * Validates the login page URL is as expected.
     * @param expectedURL Expected URL string.
     */
    @Then("the page URL should be {string}")
    public void thePageURLShouldBe(String expectedURL) {
        loginPage.assertPageURL(expectedURL);
    }

    /**
     * Validates the page title matches expected.
     * @param expectedTitle Expected title string.
     */
    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals("Page title should match", expectedTitle, actualTitle);
    }

    /**
     * Closes the WebDriver instance. Typically called at scenario teardown.
     */
    @And("the browser is closed")
    public void theBrowserIsClosed() {
        if (driver != null) {
            driver.quit();
        }
    }

}