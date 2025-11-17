package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

/**
 * Page Object Model for LoginPage.
 * Provides reusable methods and validations for the Sauce Labs login page.
 * Handles user login functionality and validation of login fields and error messages.
 * 
 * Author: Test Automation Architect
 * Created: 2024-06-12
 * Purpose: Encapsulate the login page elements and user interactions to support robust automated tests.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Timeout for explicit waits in seconds
    private static final int TIMEOUT_SECONDS = 10;

    // Locators --------------------------------------------------------------

    // Locator for username input field
    private By usernameInput = By.id("user-name");

    // Locator for password input field
    private By passwordInput = By.id("password");

    // Locator for login button
    private By loginButton = By.id("login-button");

    // Locator for error message container (displayed upon login failure)
    private By errorMessageContainer = By.cssSelector("div.error-message-container.error");

    // Locator for the login logo text "Swag Labs"
    private By loginLogo = By.className("login_logo");

    // Locator for accepted usernames info heading "Accepted usernames are:"
    private By acceptedUsernamesHeading = By.xpath("//h4[contains(text(),'Accepted usernames are:')]");

    // Locator for the Password info heading "Password for all users:"
    private By passwordInfoHeading = By.xpath("//h4[contains(text(),'Password for all users:')]");

    // Constructor -----------------------------------------------------------

    /**
     * Constructor for LoginPage initializes the WebDriver and WebDriverWait.
     * @param driver WebDriver instance to be used for locating elements.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
    }

    // Page-Level Methods ---------------------------------------------------

    /**
     * Waits for the login page to load by verifying visibility of key elements.
     */
    public void waitForPageToLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginLogo));
        } catch (TimeoutException e) {
            throw new IllegalStateException("Login Page did not load correctly within timeout", e);
        }
    }

    /**
     * Checks whether the Login Page is currently displayed.
     * Verifies presence and visibility of username input, password input, and login button.
     * @return true if login page is displaying, false otherwise.
     */
    public boolean isPageDisplaying() {
        try {
            return driver.findElement(usernameInput).isDisplayed() &&
                   driver.findElement(passwordInput).isDisplayed() &&
                   driver.findElement(loginButton).isDisplayed() &&
                   driver.findElement(loginLogo).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Returns the page title.
     * @return Page title text.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Asserts the current page URL equals the expected URL.
     * @param expectedURL The expected page URL.
     */
    public void assertPageURL(String expectedURL) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL,
                "Page URL does not match expected URL.");
    }

    // Username Input Methods -----------------------------------------------

    /**
     * Enters the specified value into the username input field.
     * Waits for the field to be visible and enabled before interacting.
     * @param username The username to enter.
     */
    public void enterUsername(String username) {
        try {
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
            input.clear();
            input.sendKeys(username);
        } catch (TimeoutException e) {
            throw new IllegalStateException("Username input field not clickable", e);
        }
    }

    /**
     * Clears the username input field.
     */
    public void clearUsername() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            input.clear();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Username input field not visible", e);
        }
    }

    /**
     * Gets the current value of the username input field.
     * @return The username input field value.
     */
    public String getUsernameValue() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            return input.getAttribute("value");
        } catch (TimeoutException e) {
            throw new IllegalStateException("Username input field not visible", e);
        }
    }

    /**
     * Checks if the username input field is displayed.
     * @return true if displayed, false otherwise.
     */
    public boolean isUsernameDisplayed() {
        try {
            return driver.findElement(usernameInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the username input field is enabled.
     * @return true if enabled, false otherwise.
     */
    public boolean isUsernameEnabled() {
        try {
            return driver.findElement(usernameInput).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the username input field is prepopulated with the expected value.
     * @param expectedValue The expected username value.
     * @return true if prepopulated with expected value, false otherwise.
     */
    public boolean isUsernamePrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getUsernameValue());
    }

    /**
     * Checks if the username input field is required.
     * @return true if the field has the required attribute, false otherwise.
     */
    public boolean isUsernameRequired() {
        try {
            WebElement input = driver.findElement(usernameInput);
            String required = input.getAttribute("required");
            return required != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Password Input Methods -----------------------------------------------

    /**
     * Enters the specified value into the password input field.
     * Waits for the field to be visible and enabled before interacting.
     * @param password The password to enter.
     */
    public void enterPassword(String password) {
        try {
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
            input.clear();
            input.sendKeys(password);
        } catch (TimeoutException e) {
            throw new IllegalStateException("Password input field not clickable", e);
        }
    }

    /**
     * Clears the password input field.
     */
    public void clearPassword() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            input.clear();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Password input field not visible", e);
        }
    }

    /**
     * Gets the current value of the password input field.
     * @return The password input field value.
     */
    public String getPasswordValue() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            return input.getAttribute("value");
        } catch (TimeoutException e) {
            throw new IllegalStateException("Password input field not visible", e);
        }
    }

    /**
     * Checks if the password input field is displayed.
     * @return true if displayed, false otherwise.
     */
    public boolean isPasswordDisplayed() {
        try {
            return driver.findElement(passwordInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the password input field is enabled.
     * @return true if enabled, false otherwise.
     */
    public boolean isPasswordEnabled() {
        try {
            return driver.findElement(passwordInput).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the password input field is prepopulated with the expected value.
     * @param expectedValue The expected password value.
     * @return true if prepopulated with expected value, false otherwise.
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getPasswordValue());
    }

    /**
     * Checks if the password input field is required.
     * @return true if the field has the required attribute, false otherwise.
     */
    public boolean isPasswordRequired() {
        try {
            WebElement input = driver.findElement(passwordInput);
            String required = input.getAttribute("required");
            return required != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Login Button Methods -------------------------------------------------

    /**
     * Clicks the login button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            button.click();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Login button not clickable", e);
        }
    }

    /**
     * Checks if the login button is displayed.
     * @return true if displayed, false otherwise.
     */
    public boolean isLoginButtonDisplayed() {
        try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the login button is enabled.
     * @return true if enabled, false otherwise.
     */
    public boolean isLoginButtonEnabled() {
        try {
            return driver.findElement(loginButton).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Gets the text displayed on the login button.
     * @return Text of the login button.
     */
    public String getLoginButtonText() {
        try {
            WebElement button = driver.findElement(loginButton);
            return button.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    // Error Message Methods ------------------------------------------------

    /**
     * Checks if the error message container is visible (indicating login failure).
     * @return true if visible, false otherwise.
     */
    public boolean isErrorMessageVisible() {
        try {
            WebElement errorContainer = driver.findElement(errorMessageContainer);
            return errorContainer.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Gets the text contained in the error message container.
     * Waits until the error message is visible.
     * @return The error message text.
     */
    public String getErrorMessageText() {
        try {
            WebElement errorContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContainer));
            return errorContainer.getText().trim();
        } catch (TimeoutException e) {
            return "";
        }
    }

    /**
     * Asserts that the error message contains the expected text.
     * Fails the test with a clear message if not matched.
     * @param expectedText The expected string to be contained in the error message.
     */
    public void assertErrorMessageContains(String expectedText) {
        String actualText = getErrorMessageText();
        Assert.assertTrue(actualText.contains(expectedText),
                String.format("Expected error message to contain '%s' but was '%s'", expectedText, actualText));
    }

    /**
     * Clears the error message by refreshing the page (no explicit close button available).
     * This method can be implemented if needed for specific test flows.
     */
    public void clearErrorMessage() {
        // No close button on error message, best approach is to clear inputs or reload as needed
    }

    // Info Headings Methods -----------------------------------------------

    /**
     * Gets the text of the Accepted Usernames heading.
     * @return The text "Accepted usernames are:" or empty string if not found.
     */
    public String getAcceptedUsernamesHeadingText() {
        try {
            WebElement heading = driver.findElement(acceptedUsernamesHeading);
            return heading.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Gets the text of the Password Info heading.
     * @return The text "Password for all users:" or empty string if not found.
     */
    public String getPasswordInfoHeadingText() {
        try {
            WebElement heading = driver.findElement(passwordInfoHeading);
            return heading.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

}