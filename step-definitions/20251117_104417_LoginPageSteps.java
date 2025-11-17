package com.saucelabs.steps;

import com.saucelabs.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Step Definitions for LoginPage methods.
 * Includes waits, assertions and error handling to enable robust BDD testing with Cucumber.
 * 
 * This class maps each public method from LoginPage with relevant Cucumber annotations and 
 * verifies expected behaviors via assertions where applicable.
 * 
 * Author: Test Automation Architect
 * Created: 2024-06-06
 */
public class LoginPageSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    /**
     * Constructor - receives WebDriver instance from dependency injection or test context.
     *
     * @param driver the WebDriver instance used in tests
     */
    public LoginPageSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    /**
     * Waits until the login page is fully loaded.
     */
    @Given("the login page is loaded")
    public void waitForLoginPageToLoad() {
        loginPage.waitForPageToLoad();
        // Assertion: page container visible implies page loaded
        assertTrue(loginPage.isPageDisplaying(), "Login page is not displaying after load.");
    }

    /**
     * Verifies that the login page is displaying.
     */
    @Then("the login page should be displayed")
    public void assertLoginPageIsDisplayed() {
        assertTrue(loginPage.isPageDisplaying(), "Login page is not displayed.");
    }

    /**
     * Enters {string} into the username input field.
     * 
     * @param username the username text to enter
     */
    @When("I enter username {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        // Verify entered username is set
        assertEquals(username, loginPage.getUsernameValue(), "Username input value mismatch after entering username.");
    }

    /**
     * Clears the username input field.
     */
    @And("I clear the username field")
    public void clearUsernameField() {
        loginPage.clearUsername();
        assertEquals("", loginPage.getUsernameValue(), "Username field not cleared properly.");
    }

    /**
     * Asserts the username input field is displayed.
     */
    @Then("the username field should be displayed")
    public void assertUsernameFieldDisplayed() {
        assertTrue(loginPage.isUsernameDisplayed(), "Username input field is not displayed.");
    }

    /**
     * Asserts the username input field is enabled.
     */
    @And("the username field should be enabled")
    public void assertUsernameFieldEnabled() {
        assertTrue(loginPage.isUsernameEnabled(), "Username input field is not enabled.");
    }

    /**
     * Asserts the username field is prepopulated with the expected value.
     * 
     * @param expectedValue the expected prepopulated username
     */
    @Then("the username field should be prepopulated with {string}")
    public void assertUsernamePrepopulated(String expectedValue) {
        assertTrue(loginPage.isUsernamePrepopulatedWith(expectedValue), 
                   "Username field is not prepopulated with expected value '" + expectedValue + "'");
    }

    /**
     * Asserts username field is required.
     */
    @Then("the username field should be required")
    public void assertUsernameFieldRequired() {
        assertTrue(loginPage.isUsernameRequired(), "Username field is not marked as required.");
    }

    /**
     * Enters {string} into the password input field.
     * 
     * @param password the password text to enter
     */
    @When("I enter password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        // Verify entered password is set
        assertEquals(password, loginPage.getPasswordValue(), "Password input value mismatch after entering password.");
    }

    /**
     * Clears the password input field.
     */
    @And("I clear the password field")
    public void clearPasswordField() {
        loginPage.clearPassword();
        assertEquals("", loginPage.getPasswordValue(), "Password field not cleared properly.");
    }

    /**
     * Asserts the password input field is displayed.
     */
    @Then("the password field should be displayed")
    public void assertPasswordFieldDisplayed() {
        assertTrue(loginPage.isPasswordDisplayed(), "Password input field is not displayed.");
    }

    /**
     * Asserts the password input field is enabled.
     */
    @And("the password field should be enabled")
    public void assertPasswordFieldEnabled() {
        assertTrue(loginPage.isPasswordEnabled(), "Password input field is not enabled.");
    }

    /**
     * Asserts the password field is prepopulated with expected value.
     * 
     * @param expectedValue the expected prepopulated password
     */
    @Then("the password field should be prepopulated with {string}")
    public void assertPasswordPrepopulated(String expectedValue) {
        assertTrue(loginPage.isPasswordPrepopulatedWith(expectedValue), 
                   "Password field is not prepopulated with expected value '" + expectedValue + "'");
    }

    /**
     * Asserts the password field is required.
     */
    @Then("the password field should be required")
    public void assertPasswordFieldRequired() {
        assertTrue(loginPage.isPasswordRequired(), "Password field is not marked as required.");
    }

    /**
     * Clicks the login button.
     */
    @When("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    /**
     * Asserts the login button is displayed.
     */
    @Then("the login button should be displayed")
    public void assertLoginButtonDisplayed() {
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
    }

    /**
     * Asserts the login button is enabled.
     */
    @And("the login button should be enabled")
    public void assertLoginButtonEnabled() {
        assertTrue(loginPage.isLoginButtonEnabled(), "Login button is not enabled.");
    }

    /**
     * Asserts the login button displays text {string}.
     * 
     * @param expectedText the expected text on the login button
     */
    @Then("the login button text should be {string}")
    public void assertLoginButtonText(String expectedText) {
        String actualText = loginPage.getLoginButtonText();
        assertEquals(expectedText, actualText, "Login button text mismatch.");
    }

    /**
     * Asserts the error message container is visible.
     */
    @Then("an error message should be visible")
    public void assertErrorMessageVisible() {
        assertTrue(loginPage.isErrorMessageVisible(), "Error message container is not visible.");
    }

    /**
     * Asserts the error message text contains {string}.
     * 
     * @param expectedMessage expected substring in error message text
     */
    @Then("the error message should contain {string}")
    public void assertErrorMessageContains(String expectedMessage) {
        String errorMessage = loginPage.getErrorMessageText();
        assertTrue(errorMessage.contains(expectedMessage), 
                   "Error message text does not contain expected text. Expected to contain: '" 
                   + expectedMessage + "' but was: '" + errorMessage + "'");
    }

    /**
     * Closes the error message container if possible.
     */
    @When("I close the error message")
    public void closeErrorMessage() {
        loginPage.closeErrorMessage();
        // After closing error message, assert invisibility
        assertFalse(loginPage.isErrorMessageVisible(), "Error message container is still visible after closing.");
    }

    /**
     * Asserts the accepted usernames header contains {string}.
     * 
     * @param expectedText Expected substring in accepted usernames header
     */
    @Then("the accepted usernames header should contain {string}")
    public void assertAcceptedUsernamesHeaderContains(String expectedText) {
        loginPage.assertAcceptedUsernamesHeaderContains(expectedText);
    }

    /**
     * Asserts the password info header contains {string}.
     * 
     * @param expectedText Expected substring in password info header
     */
    @Then("the password info header should contain {string}")
    public void assertPasswordInfoHeaderContains(String expectedText) {
        loginPage.assertPasswordInfoHeaderContains(expectedText);
    }

    /**
     * Asserts the current page URL matches the expected URL {string}.
     * 
     * @param expectedURL expected URL string
     */
    @Then("the page URL should be {string}")
    public void assertPageUrl(String expectedURL) {
        loginPage.assertPageURL(expectedURL);
    }

    /**
     * Verifies the current page title equals {string}.
     * 
     * @param expectedTitle expected page title
     */
    @Then("the page title should be {string}")
    public void assertPageTitle(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        assertEquals(expectedTitle, actualTitle, "Page title mismatch.");
    }
}