data package com.saucelabs.stepdefinitions;

import com.saucelabs.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Step Definitions class for LoginPage features.
 * Contains step implementations for interacting with the login page and verifying its state.
 * Includes assertions and waits to ensure reliability and production readiness.
 *
 * Author: Test Automation Architect
 * Created: 2024-06
 */
public class LoginPageSteps {

    private final LoginPage loginPage;

    /**
     * Constructor injection of LoginPage.
     * @param driver WebDriver instance to initialize LoginPage.
     */
    public LoginPageSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    /**
     * Waits for the login page to fully load before proceeding.
     */
    @Given("the user is on the Swag Labs login page")
    public void the_user_is_on_the_login_page() {
        loginPage.waitForPageToLoad();
        Assert.assertTrue("Login page is not displayed after wait", loginPage.isPageDisplaying());
    }

    /**
     * Asserts current URL matches expected URL for the login page.
     * @param expectedURL Expected full URL as string.
     */
    @Then("the login page URL should be {string}")
    public void the_login_page_url_should_be(String expectedURL) {
        loginPage.assertPageURL(expectedURL);
    }

    /**
     * Checks that the login page title equals expected title.
     * @param expectedTitle Expected title.
     */
    @Then("the login page title should be {string}")
    public void the_login_page_title_should_be(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals("Page title mismatch", expectedTitle, actualTitle);
    }

    /**
     * Enter username into the username input field.
     * @param username The username to enter.
     */
    @When("the user enters username {string}")
    public void the_user_enters_username(String username) {
        loginPage.enterUserName(username);
        Assert.assertEquals("Username input does not contain expected text", username, loginPage.getUserNameValue());
    }

    /**
     * Clear existing text from username input field.
     */
    @When("the user clears the username field")
    public void the_user_clears_the_username_field() {
        loginPage.clearUserName();
        Assert.assertTrue("Username field is not empty after clearing", loginPage.getUserNameValue().isEmpty());
    }

    /**
     * Verify username input field is visible and enabled.
     */
    @Then("the username field should be visible and enabled")
    public void the_username_field_should_be_visible_and_enabled() {
        Assert.assertTrue("Username field is not visible", loginPage.isUserNameDisplayed());
        Assert.assertTrue("Username field is not enabled", loginPage.isUserNameEnabled());
    }

    /**
     * Verify username is prepopulated with a given value.
     * @param expectedValue Expected prepopulated value.
     */
    @Then("the username field should be prepopulated with {string}")
    public void the_username_field_should_be_prepopulated_with(String expectedValue) {
        Assert.assertTrue("Username prepopulation mismatch", loginPage.isUserNamePrepopulatedWith(expectedValue));
    }

    /**
     * Verify username input field is marked as required.
     */
    @Then("the username field should be marked as required")
    public void the_username_field_should_be_marked_as_required() {
        Assert.assertTrue("Username field is not marked as required", loginPage.isUserNameRequired());
    }

    /**
     * Enter password into the password input field.
     * @param password The password to enter.
     */
    @When("the user enters password {string}")
    public void the_user_enters_password(String password) {
        loginPage.enterPassword(password);
        Assert.assertEquals("Password input does not contain expected text", password, loginPage.getPasswordValue());
    }

    /**
     * Clear existing text from password input field.
     */
    @When("the user clears the password field")
    public void the_user_clears_the_password_field() {
        loginPage.clearPassword();
        Assert.assertTrue("Password field is not empty after clearing", loginPage.getPasswordValue().isEmpty());
    }

    /**
     * Verify password input field is visible and enabled.
     */
    @Then("the password field should be visible and enabled")
    public void the_password_field_should_be_visible_and_enabled() {
        Assert.assertTrue("Password field is not visible", loginPage.isPasswordDisplayed());
        Assert.assertTrue("Password field is not enabled", loginPage.isPasswordEnabled());
    }

    /**
     * Verify password is prepopulated with a given value.
     * @param expectedValue Expected prepopulated password.
     */
    @Then("the password field should be prepopulated with {string}")
    public void the_password_field_should_be_prepopulated_with(String expectedValue) {
        Assert.assertTrue("Password prepopulation mismatch", loginPage.isPasswordPrepopulatedWith(expectedValue));
    }

    /**
     * Verify password input field is marked as required.
     */
    @Then("the password field should be marked as required")
    public void the_password_field_should_be_marked_as_required() {
        Assert.assertTrue("Password field is not marked as required", loginPage.isPasswordRequired());
    }

    /**
     * Clicks the login button.
     */
    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        Assert.assertTrue("Login button is not enabled", loginPage.isLoginButtonEnabled());
        loginPage.clickLoginButton();
    }

    /**
     * Verifies login button is visible and enabled.
     */
    @Then("the login button should be visible and enabled")
    public void the_login_button_should_be_visible_and_enabled() {
        Assert.assertTrue("Login button is not visible", loginPage.isLoginButtonDisplayed());
        Assert.assertTrue("Login button is not enabled", loginPage.isLoginButtonEnabled());
    }

    /**
     * Verifies text displayed on the login button.
     * @param expectedText Expected button text.
     */
    @Then("the login button text should be {string}")
    public void the_login_button_text_should_be(String expectedText) {
        String actualText = loginPage.getLoginButtonText();
        Assert.assertEquals("Login button text mismatch", expectedText, actualText);
    }

    /**
     * Verify that the error message is visible on the page.
     */
    @Then("an error message should be visible")
    public void an_error_message_should_be_visible() {
        Assert.assertTrue("Error message is not visible", loginPage.isErrorMessageVisible());
    }

    /**
     * Verify the error message text matches expected text.
     * @param expectedMessage Expected error message string.
     */
    @Then("the error message should be {string}")
    public void the_error_message_should_be(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessageText();
        Assert.assertEquals("Error message text does not match", expectedMessage, actualMessage);
    }

    /**
     * Verify the page displays the accepted usernames heading with expected text.
     * @param expectedHeading Expected heading text.
     */
    @Then("the accepted usernames heading should be {string}")
    public void the_accepted_usernames_heading_should_be(String expectedHeading) {
        String actualHeading = loginPage.getAcceptedUsernamesHeadingText();
        Assert.assertEquals("Accepted usernames heading mismatch", expectedHeading, actualHeading);
    }

    /**
     * Verify the accepted usernames list on the page matches expected list text.
     * @param expectedList Expected usernames list text.
     */
    @Then("the accepted usernames list should be:")
    public void the_accepted_usernames_list_should_be(String expectedList) {
        String actualList = loginPage.getAcceptedUsernamesListText();
        Assert.assertEquals("Accepted usernames list mismatch", expectedList.trim(), actualList.trim());
    }

    /**
     * Verify the password for all users heading is present with expected text.
     * @param expectedHeading Expected password heading text.
     */
    @Then("the password for all users heading should be {string}")
    public void the_password_for_all_users_heading_should_be(String expectedHeading) {
        String actualHeading = loginPage.getPasswordForAllUsersHeadingText();
        Assert.assertEquals("Password for all users heading mismatch", expectedHeading, actualHeading);
    }

    /**
     * Verify the password info text displayed matches expected text.
     * @param expectedPasswordInfo Expected password info string.
     */
    @Then("the password info text should be {string}")
    public void the_password_info_text_should_be(String expectedPasswordInfo) {
        String actualInfo = loginPage.getPasswordInfoText();
        Assert.assertEquals("Password info text mismatch", expectedPasswordInfo, actualInfo);
    }
}