data package com.saucedemo.stepdefinitions;

import static org.junit.Assert.*;

import com.saucedemo.pages.LoginPage;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

/**
 * Step Definitions for LoginPage methods.
 * Implements BDD steps to interact with and verify the Login page functionality.
 * Includes assertions and waits to ensure robust, production-ready test steps.
 * 
 * Usage: Steps correspond to keywords @GIVEN, @WHEN, @THEN, @AND to map to feature files.
 * 
 * Author: Test Automation Architect
 * Created: 2024-06-08
 */
public class LoginPageSteps {

    private final LoginPage loginPage;
    private final WebDriver driver;

    /**
     * Constructor for Dependency Injection.
     * @param driver WebDriver instance from Hooks or test context.
     */
    public LoginPageSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    // ******************** Page Load and Navigation Steps ********************

    /**
     * Waits for the login page to fully load including key elements and correct title.
     */
    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        loginPage.waitForPageToLoad();
        assertTrue("Login page is not displaying as expected", loginPage.isPageDisplaying());
    }

    @Then("the page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        assertEquals("Page title mismatch", expectedTitle, actualTitle);
    }

    @Then("the current page URL should be {string}")
    public void current_page_url_should_be(String expectedURL) {
        loginPage.assertPageURL(expectedURL);
    }

    // ******************** Username Input Field Steps ********************

    @When("the user enters username {string}")
    public void enter_username(String username) {
        loginPage.enterUserName(username);
        // Verify the username field contains the entered username
        String currentValue = loginPage.getUserNameValue();
        assertEquals("Username input value mismatch after entering", username, currentValue);
    }

    @And("the username field is cleared")
    public void clear_username_field() {
        loginPage.clearUserName();
        assertEquals("Username field not cleared", "", loginPage.getUserNameValue());
    }

    @Then("the username field should be displayed")
    public void username_field_should_be_displayed() {
        assertTrue("Username field not displayed", loginPage.isUserNameDisplayed());
    }

    @Then("the username field should be enabled")
    public void username_field_should_be_enabled() {
        assertTrue("Username field not enabled", loginPage.isUserNameEnabled());
    }

    @Then("the username field should be prepopulated with {string}")
    public void username_field_should_be_prepopulated_with(String expectedValue) {
        assertTrue("Username field is not prepopulated with expected value",
                loginPage.isUserNamePrepopulatedWith(expectedValue));
    }

    @Then("the username field should be required")
    public void username_field_should_be_required() {
        assertTrue("Username field is not marked as required", loginPage.isUserNameRequired());
    }

    // ******************** Password Input Field Steps ********************

    @When("the user enters password {string}")
    public void enter_password(String password) {
        loginPage.enterPassword(password);
        String currentValue = loginPage.getPasswordValue();
        assertEquals("Password input value mismatch after entering", password, currentValue);
    }

    @And("the password field is cleared")
    public void clear_password_field() {
        loginPage.clearPassword();
        assertEquals("Password field not cleared", "", loginPage.getPasswordValue());
    }

    @Then("the password field should be displayed")
    public void password_field_should_be_displayed() {
        assertTrue("Password field not displayed", loginPage.isPasswordDisplayed());
    }

    @Then("the password field should be enabled")
    public void password_field_should_be_enabled() {
        assertTrue("Password field not enabled", loginPage.isPasswordEnabled());
    }

    @Then("the password field should be prepopulated with {string}")
    public void password_field_should_be_prepopulated_with(String expectedValue) {
        assertTrue("Password field is not prepopulated with expected value",
                loginPage.isPasswordPrepopulatedWith(expectedValue));
    }

    @Then("the password field should be required")
    public void password_field_should_be_required() {
        assertTrue("Password field is not marked as required", loginPage.isPasswordRequired());
    }

    // ******************** Login Button Steps ********************

    @When("the user clicks the login button")
    public void click_login_button() {
        assertTrue("Login button not enabled before click", loginPage.isLoginButtonEnabled());
        loginPage.clickLoginButton();
        // No immediate assert here as navigation or error message depends on app logic
    }

    @Then("the login button should be displayed")
    public void login_button_should_be_displayed() {
        assertTrue("Login button not displayed", loginPage.isLoginButtonDisplayed());
    }

    @Then("the login button should be enabled")
    public void login_button_should_be_enabled() {
        assertTrue("Login button not enabled", loginPage.isLoginButtonEnabled());
    }

    @Then("the login button text should be {string}")
    public void login_button_text_should_be(String expectedText) {
        assertEquals("Login button text mismatch", expectedText, loginPage.getLoginButtonText());
    }

    // ******************** Error Message Steps ********************

    @Then("an error message should be visible")
    public void error_message_should_be_visible() {
        assertTrue("Error message container not visible", loginPage.isErrorMessageVisible());
    }

    @Then("the error message text should be {string}")
    public void error_message_text_should_be(String expectedErrorMessage) {
        String actualMessage = loginPage.getErrorMessageText();
        assertEquals("Error message text mismatch", expectedErrorMessage, actualMessage);
    }

    @And("the error message disappears")
    public void error_message_disappears() {
        loginPage.waitForErrorMessageToDisappear();
        assertFalse("Error message is still visible", loginPage.isErrorMessageVisible());
    }

    // ******************** Static Text Verification Steps ********************

    @Then("the login logo should be displayed")
    public void login_logo_should_be_displayed() {
        assertTrue("Login logo not displayed", loginPage.isLoginLogoDisplayed());
    }

    @Then("the login logo text should be {string}")
    public void login_logo_text_should_be(String expectedLogoText) {
        assertEquals("Login logo text mismatch", expectedLogoText, loginPage.getLoginLogoText());
    }

    @Then("the accepted usernames text should contain {string}")
    public void accepted_usernames_text_should_contain(String expectedText) {
        String actualText = loginPage.getAcceptedUsernamesText();
        assertTrue("Accepted usernames text does not contain expected string",
                actualText.contains(expectedText));
    }

    @Then("the password info text should contain {string}")
    public void password_info_text_should_contain(String expectedText) {
        String actualText = loginPage.getPasswordInfoText();
        assertTrue("Password info text does not contain expected string", actualText.contains(expectedText));
    }

    @Then("the root container should contain text {string}")
    public void root_container_should_contain_text(String expectedText) {
        String actualText = loginPage.getRootDivText();
        assertTrue("Root container text does not contain expected string", actualText.contains(expectedText));
    }
}