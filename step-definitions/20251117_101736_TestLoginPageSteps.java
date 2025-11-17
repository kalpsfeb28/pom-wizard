data package com.practicetestautomation.steps;

import com.practicetestautomation.pages.TestLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Step definitions for interactions and verifications on the TestLoginPage.
 * <p>
 * Implements Cucumber steps with assertions to ensure reliability of the Test Login page.
 * Includes waits, error handling, and informative messages for debugging.
 * </p>
 * 
 * Author: Test Automation Architect
 * Created: 2024-06-10
 */
public class TestLoginPageSteps {

    private final TestLoginPage loginPage;
    private final WebDriver driver;

    /**
     * Constructor injecting WebDriver and initializing the TestLoginPage.
     * 
     * @param driver WebDriver instance provided by dependency injection or test context
     */
    public TestLoginPageSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new TestLoginPage(driver);
    }

    /**
     * Waits for the Test Login page to be fully loaded with all interactive elements.
     */
    @Given("the Test Login page is loaded")
    public void waitForTestLoginPageToLoad() {
        loginPage.waitForPageToLoad();
        Assert.assertTrue("Test Login page is not displaying correctly after load",
                loginPage.isPageDisplaying());
    }

    /**
     * Asserts that the Test Login page is displayed correctly.
     */
    @Then("the Test Login page should be displayed")
    public void assertTestLoginPageIsDisplayed() {
        Assert.assertTrue("Test Login page is not displayed as expected",
                loginPage.isPageDisplaying());
    }

    /**
     * Asserts that the current page URL contains the expected substring.
     *
     * @param expectedSubstring Expected substring to be contained in URL
     */
    @Then("the URL should contain {string}")
    public void assertCurrentURLContains(String expectedSubstring) {
        loginPage.assertPageURLContains(expectedSubstring);
    }

    /**
     * Enters the provided username into the Username input field.
     * 
     * @param username String username to enter
     */
    @When("the user enters username {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        // Verify the entered value matches expected username
        String actualValue = loginPage.getUsernameValue();
        Assert.assertEquals("Username input value mismatch after entry", username, actualValue);
    }

    /**
     * Clears the Username input field.
     */
    @And("the user clears the username field")
    public void clearUsername() {
        loginPage.clearUsername();
        Assert.assertEquals("Username field should be empty after clearing", "", loginPage.getUsernameValue());
    }

    /**
     * Verifies the Username input field is displayed on the page.
     */
    @Then("the username field should be visible")
    public void verifyUsernameFieldIsVisible() {
        Assert.assertTrue("Username field is not displayed", loginPage.isUsernameDisplayed());
    }

    /**
     * Verifies the Username input field is enabled for interaction.
     */
    @Then("the username field should be enabled")
    public void verifyUsernameFieldIsEnabled() {
        Assert.assertTrue("Username field is not enabled", loginPage.isUsernameEnabled());
    }

    /**
     * Verifies the Username field is prepopulated with the expected value.
     * 
     * @param expectedValue Expected username prepopulated value
     */
    @Then("the username field should be prepopulated with {string}")
    public void verifyUsernameFieldPrepopulated(String expectedValue) {
        Assert.assertTrue(String.format("Username field is not prepopulated with '%s'", expectedValue),
                loginPage.isUsernamePrepopulatedWith(expectedValue));
    }

    /**
     * Verifies the Username input field has the HTML 'required' attribute.
     */
    @Then("the username field should be required")
    public void verifyUsernameFieldIsRequired() {
        Assert.assertTrue("Username field is not marked required", loginPage.isUsernameRequired());
    }

    /**
     * Enters the provided password into the Password input field.
     * 
     * @param password String password to enter
     */
    @When("the user enters password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        // Verify entered password value matches expected
        String actualValue = loginPage.getPasswordValue();
        Assert.assertEquals("Password input value mismatch after entry", password, actualValue);
    }

    /**
     * Clears the Password input field.
     */
    @And("the user clears the password field")
    public void clearPassword() {
        loginPage.clearPassword();
        Assert.assertEquals("Password field should be empty after clearing", "", loginPage.getPasswordValue());
    }

    /**
     * Verifies the Password input field is displayed on the page.
     */
    @Then("the password field should be visible")
    public void verifyPasswordFieldIsVisible() {
        Assert.assertTrue("Password field is not displayed", loginPage.isPasswordDisplayed());
    }

    /**
     * Verifies the Password input field is enabled for interaction.
     */
    @Then("the password field should be enabled")
    public void verifyPasswordFieldIsEnabled() {
        Assert.assertTrue("Password field is not enabled", loginPage.isPasswordEnabled());
    }

    /**
     * Verifies the Password field is prepopulated with the expected value.
     * 
     * @param expectedValue Expected password prepopulated value
     */
    @Then("the password field should be prepopulated with {string}")
    public void verifyPasswordFieldPrepopulated(String expectedValue) {
        Assert.assertTrue(String.format("Password field is not prepopulated with '%s'", expectedValue),
                loginPage.isPasswordPrepopulatedWith(expectedValue));
    }

    /**
     * Verifies the Password input field has the HTML 'required' attribute.
     */
    @Then("the password field should be required")
    public void verifyPasswordFieldIsRequired() {
        Assert.assertTrue("Password field is not marked required", loginPage.isPasswordRequired());
    }

    /**
     * Clicks the Submit button to attempt login.
     */
    @When("the user clicks the Submit button")
    public void clickSubmitButton() {
        loginPage.clickSubmitButton();
        Assert.assertTrue("Submit button should be enabled to click", loginPage.isSubmitButtonEnabled());
    }

    /**
     * Verifies the Submit button is displayed on the page.
     */
    @Then("the Submit button should be visible")
    public void verifySubmitButtonIsVisible() {
        Assert.assertTrue("Submit button is not displayed", loginPage.isSubmitButtonDisplayed());
    }

    /**
     * Verifies the Submit button is enabled for clicking.
     */
    @Then("the Submit button should be enabled")
    public void verifySubmitButtonIsEnabled() {
        Assert.assertTrue("Submit button is not enabled", loginPage.isSubmitButtonEnabled());
    }

    /**
     * Verifies the visible text on the Submit button matches expected.
     * 
     * @param expectedText Expected visible Submit button text
     */
    @Then("the Submit button text should be {string}")
    public void verifySubmitButtonText(String expectedText) {
        String actualText = loginPage.getSubmitButtonText();
        Assert.assertEquals("Submit button text mismatch", expectedText, actualText);
    }

    /**
     * Verifies if an error message is displayed on the page.
     */
    @Then("an error message should be displayed")
    public void verifyErrorMessageIsDisplayed() {
        Assert.assertTrue("Error message is not displayed when expected", loginPage.isErrorMessageDisplayed());
    }

    /**
     * Verifies the error message text contains the expected substring.
     * 
     * @param expectedText Expected substring inside error message
     */
    @Then("the error message should contain {string}")
    public void verifyErrorMessageContainsText(String expectedText) {
        loginPage.assertErrorMessageContains(expectedText);
    }

    /**
     * Verifies no error message is displayed.
     */
    @Then("no error message should be displayed")
    public void verifyNoErrorMessageIsDisplayed() {
        Assert.assertFalse("Error message is displayed but should not be", loginPage.isErrorMessageDisplayed());
    }
}