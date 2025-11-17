package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.junit.Assert;

import java.time.Duration;

/**
 * Page Object Model for Swag Labs Login Page.
 * Provides reusable methods and validations for interacting with the login page of Swag Labs.
 * Handles login inputs, buttons, error messages, and login credentials information section.
 * 
 * @author Test Automation Architect
 * @created 2024-06-01
 * @purpose Automate Login Page actions, validations, and ensure page loading correctness.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Timeout duration for explicit waits
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    // ============================
    // Locators for login form elements
    // ============================

    /**
     * Locator for username input field.
     */
    @FindBy(id = "user-name")
    private WebElement userNameInput;

    /**
     * Locator for password input field.
     */
    @FindBy(id = "password")
    private WebElement passwordInput;

    /**
     * Locator for login button.
     */
    @FindBy(id = "login-button")
    private WebElement loginButton;

    /**
     * Locator for error message container displayed on login failure.
     */
    @FindBy(css = "div.error-message-container.error")
    private WebElement errorMessageContainer;

    /**
     * Locator for login credentials section container.
     * Displays accepted usernames and password hints.
     */
    @FindBy(id = "login_credentials")
    private WebElement loginCredentialsSection;

    /**
     * Locator for text heading "Accepted usernames are:" in login credentials section.
     */
    @FindBy(xpath = "//h4[normalize-space()='Accepted usernames are:']")
    private WebElement acceptedUsernamesHeading;

    /**
     * Locator for text heading "Password for all users:" in login credentials section.
     */
    @FindBy(xpath = "//h4[normalize-space()='Password for all users:']")
    private WebElement passwordForAllUsersHeading;

    // ============================
    // Constructor
    // ============================

    /**
     * Constructor to initialize web elements and wait.
     * 
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    // ============================
    // Input Fields Interaction Methods: Username
    // ============================

    /**
     * Enters the provided username into the username input field after waiting for it to be visible and enabled.
     * 
     * @param username Username string to enter
     */
    public void enterUserName(String username) {
        try {
            wait.until(ExpectedConditions.visibilityOf(userNameInput));
            wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
            userNameInput.clear();
            userNameInput.sendKeys(username);
        } catch (TimeoutException e) {
            throw new RuntimeException("Username input field is not visible or enabled within timeout.", e);
        }
    }

    /**
     * Clears the username input field after waiting for it to be visible.
     */
    public void clearUserName() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userNameInput));
            userNameInput.clear();
        } catch (TimeoutException e) {
            throw new RuntimeException("Username input field is not visible within timeout.", e);
        }
    }

    /**
     * Retrieves the current value of the username input field.
     * 
     * @return Current username input value
     */
    public String getUserNameValue() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userNameInput));
            return userNameInput.getAttribute("value");
        } catch (TimeoutException e) {
            throw new RuntimeException("Username input field is not visible within timeout.", e);
        }
    }

    /**
     * Checks if the username input field is currently displayed.
     * 
     * @return true if displayed, false otherwise
     */
    public boolean isUserNameDisplayed() {
        try {
            return userNameInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the username input field is currently enabled (editable).
     * 
     * @return true if enabled, false otherwise
     */
    public boolean isUserNameEnabled() {
        try {
            return userNameInput.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Verifies that the username input field is prepopulated with the expected value.
     * 
     * @param expectedValue Expected username value
     * @return true if matches, false otherwise
     */
    public boolean isUserNamePrepopulatedWith(String expectedValue) {
        String currentValue = getUserNameValue();
        return expectedValue.equals(currentValue);
    }

    /**
     * Checks if the username input field is required by verifying the 'required' attribute.
     * 
     * @return true if field has required attribute, false otherwise
     */
    public boolean isUserNameRequired() {
        try {
            String required = userNameInput.getAttribute("required");
            return required != null && (required.equals("true") || required.equals("required"));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // ============================
    // Input Fields Interaction Methods: Password
    // ============================

    /**
     * Enters the provided password into the password input field after waiting for it to be visible and enabled.
     * 
     * @param password Password string to enter
     */
    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
            passwordInput.clear();
            passwordInput.sendKeys(password);
        } catch (TimeoutException e) {
            throw new RuntimeException("Password input field is not visible or enabled within timeout.", e);
        }
    }

    /**
     * Clears the password input field after waiting for it to be visible.
     */
    public void clearPassword() {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            passwordInput.clear();
        } catch (TimeoutException e) {
            throw new RuntimeException("Password input field is not visible within timeout.", e);
        }
    }

    /**
     * Retrieves the current value of the password input field.
     * 
     * @return Current password input value
     */
    public String getPasswordValue() {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            return passwordInput.getAttribute("value");
        } catch (TimeoutException e) {
            throw new RuntimeException("Password input field is not visible within timeout.", e);
        }
    }

    /**
     * Checks if the password input field is currently displayed.
     * 
     * @return true if displayed, false otherwise
     */
    public boolean isPasswordDisplayed() {
        try {
            return passwordInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the password input field is currently enabled (editable).
     * 
     * @return true if enabled, false otherwise
     */
    public boolean isPasswordEnabled() {
        try {
            return passwordInput.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Verifies that the password input field is prepopulated with the expected value.
     * 
     * @param expectedValue Expected password value
     * @return true if matches, false otherwise
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        String currentValue = getPasswordValue();
        return expectedValue.equals(currentValue);
    }

    /**
     * Checks if the password input field is required by verifying the 'required' attribute.
     * 
     * @return true if field has required attribute, false otherwise
     */
    public boolean isPasswordRequired() {
        try {
            String required = passwordInput.getAttribute("required");
            return required != null && (required.equals("true") || required.equals("required"));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // ============================
    // Button Interaction Methods: Login Button
    // ============================

    /**
     * Clicks the login button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Login button is not clickable within timeout.", e);
        }
    }

    /**
     * Checks if the login button is displayed.
     * 
     * @return true if displayed, false otherwise
     */
    public boolean isLoginButtonDisplayed() {
        try {
            return loginButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the login button is enabled (clickable).
     * 
     * @return true if enabled, false otherwise
     */
    public boolean isLoginButtonEnabled() {
        try {
            return loginButton.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Gets the visible text of the login button.
     * 
     * @return Login button text
     */
    public String getLoginButtonText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            return loginButton.getText();
        } catch (TimeoutException e) {
            throw new RuntimeException("Login button is not visible within timeout.", e);
        }
    }

    // ============================
    // Error Message Methods
    // ============================

    /**
     * Checks if the error message container is visible on the page.
     * 
     * @return true if visible, false otherwise
     */
    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessageContainer.isDisplayed();
        } catch (NoSuchElementException e) {
            // Element not found, treat as not displayed
            return false;
        }
    }

    /**
     * Retrieves the text message from the error message container.
     * 
     * @return Error message text if displayed, empty string if not displayed
     */
    public String getErrorMessageText() {
        if (isErrorMessageDisplayed()) {
            return errorMessageContainer.getText().trim();
        }
        return "";
    }

    /**
     * Asserts that the error message contains the expected text.
     * Throws AssertionError if not matched.
     * 
     * @param expectedText Expected substring in error message
     */
    public void assertErrorMessageContains(String expectedText) {
        Assert.assertTrue(
            "Expected error message to contain: '" + expectedText + "' but was: '" + getErrorMessageText() + "'",
            getErrorMessageText().contains(expectedText));
    }

    // ============================
    // Login Credentials Information Methods
    // ============================

    /**
     * Checks if the login credentials section (accepted usernames and passwords) is displayed.
     * 
     * @return true if displayed, false otherwise
     */
    public boolean isLoginCredentialsSectionDisplayed() {
        try {
            return loginCredentialsSection.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Gets the text content of the login credentials section.
     * 
     * @return Text content of the accepted usernames and passwords
     */
    public String getLoginCredentialsText() {
        if (isLoginCredentialsSectionDisplayed()) {
            return loginCredentialsSection.getText().trim();
        }
        return "";
    }

    /**
     * Retrieves the text of the "Accepted usernames are:" heading.
     * 
     * @return Heading text if displayed, empty string otherwise
     */
    public String getAcceptedUsernamesHeadingText() {
        try {
            if (acceptedUsernamesHeading.isDisplayed()) {
                return acceptedUsernamesHeading.getText().trim();
            }
        } catch (NoSuchElementException e) {
            // Ignore
        }
        return "";
    }

    /**
     * Retrieves the text of the "Password for all users:" heading.
     * 
     * @return Heading text if displayed, empty string otherwise
     */
    public String getPasswordForAllUsersHeadingText() {
        try {
            if (passwordForAllUsersHeading.isDisplayed()) {
                return passwordForAllUsersHeading.getText().trim();
            }
        } catch (NoSuchElementException e) {
            // Ignore
        }
        return "";
    }

    // ============================
    // Page-Level Methods
    // ============================

    /**
     * Waits for the login page to load by ensuring username input, password input, and login button are visible.
     */
    public void waitForPageToLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userNameInput));
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            wait.until(ExpectedConditions.visibilityOf(loginButton));
        } catch (TimeoutException e) {
            throw new RuntimeException("Login page did not load properly within timeout.", e);
        }
    }

    /**
     * Checks if the login page is currently displayed by validating the presence and visibility of critical elements.
     * 
     * @return true if the login page is displayed; otherwise false
     */
    public boolean isPageDisplaying() {
        try {
            return isUserNameDisplayed()
                && isPasswordDisplayed()
                && isLoginButtonDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Gets the current page title.
     * 
     * @return Page title string
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Asserts that the current URL matches the expected URL.
     * 
     * @param expectedURL Expected page URL string
     */
    public void assertPageURL(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("Expected URL: " + expectedURL + " but got: " + currentURL, expectedURL, currentURL);
    }

}