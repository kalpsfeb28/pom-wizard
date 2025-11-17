data package com.practicetestautomation.stepdefinitions;

import com.practicetestautomation.pages.TestLoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Step Definition class for TestLoginPage.
 * Contains Cucumber steps mapping the TestLoginPage methods to BDD scenarios.
 * Includes assertions and error handling to ensure robust test behaviors.
 * Author: Test Automation Architect
 * Created: 2024-06
 */
public class TestLoginPageSteps {

    private final WebDriver driver;
    private final TestLoginPage loginPage;

    /**
     * Constructor initializes WebDriver and TestLoginPage instance.
     * For production, WebDriver should ideally be injected via dependency injection or hooks.
     */
    public TestLoginPageSteps() {
        // Depending on project setup, WebDriver initialization may differ.
        // Here ChromeDriver is instantiated for demonstration purposes.
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        this.driver = new ChromeDriver();
        this.loginPage = new TestLoginPage(driver);
    }

    /**
     * Navigates to the login page URL and waits for it to load completely.
     *
     * @param url The full URL of the login page
     */
    @Given("the user navigates to the login page {string}")
    public void navigateToLoginPage(String url) {
        driver.get(url);
        loginPage.waitForPageToLoad();
        assertTrue(loginPage.isPageDisplaying(),
                "Login page is not displaying correctly after navigation");
    }

    /**
     * Enters username text into the username field.
     *
     * @param username the username to enter
     */
    @When("the user enters username {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        String actualUsername = loginPage.getUsernameValue();
        assertEquals(username, actualUsername, "Username input value mismatch after entering");
    }

    /**
     * Clears the username input field.
     */
    @And("the user clears the username field")
    public void clearUsername() {
        loginPage.clearUsername();
        String actualUsername = loginPage.getUsernameValue();
        assertTrue(actualUsername.isEmpty(), "Username field was not cleared properly");
    }

    /**
     * Validates that the username field is displayed.
     */
    @Then("the username field should be displayed")
    public void verifyUsernameDisplayed() {
        assertTrue(loginPage.isUsernameDisplayed(), "Username field is not displayed");
    }

    /**
     * Validates that the username field is enabled.
     */
    @And("the username field should be enabled")
    public void verifyUsernameEnabled() {
        assertTrue(loginPage.isUsernameEnabled(), "Username field is not enabled");
    }

    /**
     * Validates that the username field is required.
     */
    @And("the username field should be marked as required")
    public void verifyUsernameRequired() {
        assertTrue(loginPage.isUsernameRequired(), "Username field is not marked as required");
    }

    /**
     * Validates that the username field is prepopulated with expected value.
     *
     * @param expectedValue the expected prepopulated username value
     */
    @Then("the username field should be prepopulated with {string}")
    public void verifyUsernamePrepopulated(String expectedValue) {
        assertTrue(loginPage.isUsernamePrepopulatedWith(expectedValue),
                "Username field is not prepopulated with expected value");
    }

    /**
     * Enters password text into the password field.
     *
     * @param password the password to enter
     */
    @When("the user enters password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        String actualPassword = loginPage.getPasswordValue();
        assertEquals(password, actualPassword, "Password input value mismatch after entering");
    }

    /**
     * Clears the password input field.
     */
    @And("the user clears the password field")
    public void clearPassword() {
        loginPage.clearPassword();
        String actualPassword = loginPage.getPasswordValue();
        assertTrue(actualPassword.isEmpty(), "Password field was not cleared properly");
    }

    /**
     * Validates that the password field is displayed.
     */
    @Then("the password field should be displayed")
    public void verifyPasswordDisplayed() {
        assertTrue(loginPage.isPasswordDisplayed(), "Password field is not displayed");
    }

    /**
     * Validates that the password field is enabled.
     */
    @And("the password field should be enabled")
    public void verifyPasswordEnabled() {
        assertTrue(loginPage.isPasswordEnabled(), "Password field is not enabled");
    }

    /**
     * Validates that the password field is required.
     */
    @And("the password field should be marked as required")
    public void verifyPasswordRequired() {
        assertTrue(loginPage.isPasswordRequired(), "Password field is not marked as required");
    }

    /**
     * Validates that the password field is prepopulated with expected value.
     *
     * @param expectedValue the expected prepopulated password value
     */
    @Then("the password field should be prepopulated with {string}")
    public void verifyPasswordPrepopulated(String expectedValue) {
        assertTrue(loginPage.isPasswordPrepopulatedWith(expectedValue),
                "Password field is not prepopulated with expected value");
    }

    /**
     * Clicks the submit button to submit the login form.
     */
    @When("the user clicks the submit button")
    public void clickSubmitButton() {
        assertTrue(loginPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
        assertTrue(loginPage.isSubmitButtonEnabled(), "Submit button is not enabled");
        loginPage.clickSubmitButton();
    }

    /**
     * Validates that the submit button text matches expected value.
     *
     * @param expectedText expected submit button text
     */
    @Then("the submit button text should be {string}")
    public void verifySubmitButtonText(String expectedText) {
        String actualText = loginPage.getSubmitButtonText();
        assertEquals(expectedText, actualText, "Submit button text mismatch");
    }

    /**
     * Validates that an error message is visible on the page.
     */
    @Then("an error message should be displayed")
    public void verifyErrorMessageVisible() {
        assertTrue(loginPage.isErrorMessageVisible(), "Error message is not visible");
    }

    /**
     * Validates that the error message text matches the expected text.
     *
     * @param expectedText expected error message text
     */
    @And("the error message should be {string}")
    public void verifyErrorMessageText(String expectedText) {
        loginPage.assertErrorMessageTextEquals(expectedText);
    }

    /**
     * Validates that the current page URL contains expected substring.
     *
     * @param expectedUrlSubstring expected substring in URL
     */
    @Then("the page URL should contain {string}")
    public void verifyPageURLContains(String expectedUrlSubstring) {
        loginPage.assertPageURLContains(expectedUrlSubstring);
    }

    /**
     * Validates that the page title matches the expected title.
     *
     * @param expectedTitle expected page title string
     */
    @Then("the page title should be {string}")
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        assertEquals(expectedTitle, actualTitle, "Page title mismatch");
    }

    /**
     * Quits the browser instance after scenario completion.
     */
    @Then("the browser is closed")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}