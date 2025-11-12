package com.saucelabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

/**
 * Page Object Model for LoginPage.
 * Provides reusable methods and validations for the Swag Labs login page.
 * This class uses Selenium WebDriver with explicit waits and assertions for reliability.
 * 
 * Purpose: To automate interaction and validation of all login page elements,
 * ensuring tests are maintainable and production-ready.
 * 
 * Author: Test Automation Architect
 * Created: 2024-06
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators - login inputs and buttons

    // Locator for username input field
    private By userNameInput = By.id("user-name");
    // Locator for password input field
    private By passwordInput = By.id("password");
    // Locator for login button
    private By loginButton = By.id("login-button");
    // Locator for error message container
    private By errorMessageContainer = By.cssSelector("div.error-message-container");

    // Locators for informational texts on the login page

    // Locator for Accepted usernames heading (h4)
    private By acceptedUsernamesHeading = By.xpath("//h4[text()='Accepted usernames are:']");
    // Locator for all accepted usernames listed on page (div#login_credentials)
    private By acceptedUsernamesList = By.id("login_credentials");
    // Locator for Password for all users heading (h4)
    private By passwordForAllUsersHeading = By.xpath("//h4[text()='Password for all users:']");
    // Locator for password info text (div.login_password)
    private By passwordInfoText = By.className("login_password");

    /**
     * Constructor initializes WebDriver and WebDriverWait.
     * @param driver WebDriver instance to be used by this page.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Explicit wait with 10 seconds timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Waits for the login page to be fully loaded by checking visibility of username input.
     */
    public void waitForPageToLoad() {
        try {
            // Wait until username input is visible indicating page load
            wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        } catch (TimeoutException e) {
            throw new AssertionError("Login page did not load within timeout", e);
        }
    }

    /**
     * Verifies if Login Page is currently displayed by confirming key elements are visible.
     * @return true if page is displayed, false otherwise
     */
    public boolean isPageDisplaying() {
        try {
            return driver.findElement(userNameInput).isDisplayed() &&
                   driver.findElement(passwordInput).isDisplayed() &&
                   driver.findElement(loginButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Enters text into the username input field after waiting for it to be visible and enabled.
     * @param username The username string to enter.
     */
    public void enterUserName(String username) {
        WebElement userInput = wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userInput.clear();
        userInput.sendKeys(username);
    }

    /**
     * Clears the username input field after waiting for visibility.
     */
    public void clearUserName() {
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        userInput.clear();
    }

    /**
     * Gets the current value entered in the username input field.
     * @return String value of username input
     */
    public String getUserNameValue() {
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        return userInput.getAttribute("value");
    }

    /**
     * Checks if the username input field is currently displayed.
     * @return true if displayed, false otherwise
     */
    public boolean isUserNameDisplayed() {
        try {
            return driver.findElement(userNameInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the username input field is currently enabled.
     * @return true if enabled, false otherwise
     */
    public boolean isUserNameEnabled() {
        try {
            return driver.findElement(userNameInput).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Verifies if username input field is prepopulated with the expected value.
     * @param expectedValue Expected string value for username input
     * @return true if matches, false otherwise
     */
    public boolean isUserNamePrepopulatedWith(String expectedValue) {
        return getUserNameValue().equals(expectedValue);
    }

    /**
     * Checks if username input field is marked as required in the DOM.
     * @return true if required attribute is present and true, false otherwise
     */
    public boolean isUserNameRequired() {
        WebElement userInput = driver.findElement(userNameInput);
        String required = userInput.getAttribute("required");
        return required != null && (required.equals("true") || required.equals("required"));
    }

    /**
     * Enters text into the password input field after waiting for it to be visible and enabled.
     * @param password The password string to enter.
     */
    public void enterPassword(String password) {
        WebElement passInput = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passInput.clear();
        passInput.sendKeys(password);
    }

    /**
     * Clears the password input field after waiting for visibility.
     */
    public void clearPassword() {
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passInput.clear();
    }

    /**
     * Gets the current value entered in the password input field.
     * @return String value of password input
     */
    public String getPasswordValue() {
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        return passInput.getAttribute("value");
    }

    /**
     * Checks if the password input field is currently displayed.
     * @return true if displayed, false otherwise
     */
    public boolean isPasswordDisplayed() {
        try {
            return driver.findElement(passwordInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the password input field is currently enabled.
     * @return true if enabled, false otherwise
     */
    public boolean isPasswordEnabled() {
        try {
            return driver.findElement(passwordInput).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Verifies if password input field is prepopulated with the expected value.
     * @param expectedValue Expected string value for password input
     * @return true if matches, false otherwise
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        return getPasswordValue().equals(expectedValue);
    }

    /**
     * Checks if password input field is marked as required in the DOM.
     * @return true if required attribute is present and true, false otherwise
     */
    public boolean isPasswordRequired() {
        WebElement passInput = driver.findElement(passwordInput);
        String required = passInput.getAttribute("required");
        return required != null && (required.equals("true") || required.equals("required"));
    }

    /**
     * Clicks the login button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        btn.click();
    }

    /**
     * Checks if the login button is currently displayed.
     * @return true if displayed, false otherwise
     */
    public boolean isLoginButtonDisplayed() {
        try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the login button is currently enabled.
     * @return true if enabled, false otherwise
     */
    public boolean isLoginButtonEnabled() {
        try {
            return driver.findElement(loginButton).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Gets the visible text on the login button.
     * @return String text of login button
     */
    public String getLoginButtonText() {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return btn.getText();
    }

    /**
     * Checks if error message container is visible on the page.
     * @return true if visible, false otherwise
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
     * Gets the error message text from error message container.
     * @return String error message text
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
     * Gets the heading text 'Accepted usernames are:' displayed on the login page.
     * @return String heading text
     */
    public String getAcceptedUsernamesHeadingText() {
        try {
            WebElement heading = driver.findElement(acceptedUsernamesHeading);
            return heading.getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Gets the full list text of accepted usernames displayed on the login page.
     * @return String of accepted usernames
     */
    public String getAcceptedUsernamesListText() {
        try {
            WebElement list = driver.findElement(acceptedUsernamesList);
            return list.getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Gets the heading text 'Password for all users:' displayed on the login page.
     * @return String heading text
     */
    public String getPasswordForAllUsersHeadingText() {
        try {
            WebElement heading = driver.findElement(passwordForAllUsersHeading);
            return heading.getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Gets the password information text displayed on the login page.
     * @return String password info text
     */
    public String getPasswordInfoText() {
        try {
            WebElement passInfo = driver.findElement(passwordInfoText);
            return passInfo.getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Asserts that the current URL matches the expected URL.
     * @param expectedURL The expected URL string
     * @throws AssertionError if URL does not match
     */
    public void assertPageURL(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        if (!currentURL.equals(expectedURL)) {
            throw new AssertionError("Expected URL: [" + expectedURL + "] but found: [" + currentURL + "]");
        }
    }

    /**
     * Gets the title of the current page.
     * @return String page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}