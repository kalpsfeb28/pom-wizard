package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Page Object Model for Login Page of Swag Labs.
 * Provides reusable methods and validations for login functionality,
 * including user input fields, login button, error messages and credential information.
 * Handles waits and assertions to ensure robust automation.
 * Author: Test Automation Architect
 * Created: 2024-06-15
 * Purpose: Encapsulate interactions & validations for login page elements and flows.
 */
public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // ================================
    // Constants
    // ================================
    private static final String PAGE_URL = "https://www.saucedemo.com/";

    // ================================
    // Locators
    // ================================

    // Locator for username input field
    private final By usernameInput = By.id("user-name");

    // Locator for password input field
    private final By passwordInput = By.id("password");

    // Locator for login button input
    private final By loginButton = By.id("login-button");

    // Locator for error message container (visible on invalid login)
    private final By errorMessageContainer = By.cssSelector(".error-message-container");

    // Locator for accepted usernames label text (informational)
    private final By acceptedUsernamesLabel = By.xpath("//div[contains(@class,'login_credentials')]//h4[contains(text(),'Accepted usernames are:')]");

    // Locator for password info label text (informational)
    private final By passwordInfoLabel = By.xpath("//div[contains(@class,'login_password')]//h4[contains(text(),'Password for all users:')]");

    // Locator for all displayed accepted usernames text block
    private final By acceptedUsernamesText = By.cssSelector(".login_credentials");

    // Locator for password info text block
    private final By passwordInfoText = By.cssSelector(".login_password");

    // ================================
    // Constructor
    // ================================

    /**
     * Constructor to initialize the LoginPage with WebDriver and WebDriverWait.
     * @param driver WebDriver instance to interact with the browser.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebDriverWait with timeout of 10 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================================
    // Page Load & Verification Methods
    // ================================

    /**
     * Waits for the Login Page to be fully loaded by waiting for key elements to be visible.
     */
    public void waitForPageToLoad() {
        // Wait until username input, password input and login button are visible and enabled
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }

    /**
     * Verifies if the Login Page is currently displayed by checking visibility of main controls.
     * @return true if all critical elements are displayed, false otherwise.
     */
    public boolean isPageDisplaying() {
        try {
            WebElement usernameElem = driver.findElement(usernameInput);
            WebElement passwordElem = driver.findElement(passwordInput);
            WebElement loginBtnElem = driver.findElement(loginButton);
            return usernameElem.isDisplayed() && passwordElem.isDisplayed() && loginBtnElem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the current page title.
     * @return Page title string.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Asserts that the current URL matches the expected URL.
     * @param expectedURL Expected URL string.
     */
    public void assertPageURL(String expectedURL) {
        assertEquals(driver.getCurrentUrl(), expectedURL, "Page URL did not match expected URL.");
    }

    // ================================
    // Username Input Field Methods
    // ================================

    /**
     * Enters the username into the username input field after waiting for visibility.
     * @param username Username string to enter.
     */
    public void enterUsername(String username) {
        WebElement usernameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        usernameElem.clear();
        usernameElem.sendKeys(username);
    }

    /**
     * Clears the username input field.
     */
    public void clearUsername() {
        WebElement usernameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        usernameElem.clear();
    }

    /**
     * Gets the current value entered in the username input field.
     * @return The username input field's current text.
     */
    public String getUsernameValue() {
        WebElement usernameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        return usernameElem.getAttribute("value");
    }

    /**
     * Checks if the username input field is displayed.
     * @return true if displayed, false otherwise.
     */
    public boolean isUsernameDisplayed() {
        try {
            return driver.findElement(usernameInput).isDisplayed();
        } catch (Exception e) {
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
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the username input field is prepopulated with the expected value.
     * @param expectedValue The expected username value.
     * @return true if matches, false otherwise.
     */
    public boolean isUsernamePrepopulatedWith(String expectedValue) {
        String currentValue = getUsernameValue();
        return currentValue.equals(expectedValue);
    }

    /**
     * Checks if the username input field is marked as required by HTML attribute.
     * @return true if 'required' attribute present, false otherwise.
     */
    public boolean isUsernameRequired() {
        WebElement usernameElem = driver.findElement(usernameInput);
        String required = usernameElem.getAttribute("required");
        return required != null;
    }

    // ================================
    // Password Input Field Methods
    // ================================

    /**
     * Enters the password into the password input field after waiting for visibility.
     * @param password Password string to enter.
     */
    public void enterPassword(String password) {
        WebElement passwordElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordElem.clear();
        passwordElem.sendKeys(password);
    }

    /**
     * Clears the password input field.
     */
    public void clearPassword() {
        WebElement passwordElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordElem.clear();
    }

    /**
     * Gets the current value entered in the password input field.
     * Note: Usually password fields don't expose value for security, but we retrieve attribute regardless.
     * @return The password input field's current text.
     */
    public String getPasswordValue() {
        WebElement passwordElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        return passwordElem.getAttribute("value");
    }

    /**
     * Checks if the password input field is displayed.
     * @return true if displayed, false otherwise.
     */
    public boolean isPasswordDisplayed() {
        try {
            return driver.findElement(passwordInput).isDisplayed();
        } catch (Exception e) {
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
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the password input field is prepopulated with the expected value.
     * @param expectedValue The expected password value.
     * @return true if matches, false otherwise.
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        String currentValue = getPasswordValue();
        return currentValue.equals(expectedValue);
    }

    /**
     * Checks if the password input field is marked as required by HTML attribute.
     * @return true if 'required' attribute present, false otherwise.
     */
    public boolean isPasswordRequired() {
        WebElement passwordElem = driver.findElement(passwordInput);
        String required = passwordElem.getAttribute("required");
        return required != null;
    }

    // ================================
    // Login Button Methods
    // ================================

    /**
     * Clicks the login button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        WebElement loginBtnElem = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtnElem.click();
    }

    /**
     * Checks if the login button is displayed.
     * @return true if displayed, false otherwise.
     */
    public boolean isLoginButtonDisplayed() {
        try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (Exception e) {
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
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the text displayed on the login button.
     * @return Button text string.
     */
    public String getLoginButtonText() {
        WebElement loginBtnElem = driver.findElement(loginButton);
        return loginBtnElem.getAttribute("value");
    }

    // ================================
    // Error Message Methods
    // ================================

    /**
     * Checks if the error message container is visible on the page.
     * @return true if visible, false otherwise.
     */
    public boolean isErrorMessageVisible() {
        try {
            WebElement errorElem = driver.findElement(errorMessageContainer);
            return errorElem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the error message text displayed inside the error container.
     * @return Error message string, or empty if not present.
     */
    public String getErrorMessageText() {
        try {
            WebElement errorElem = driver.findElement(errorMessageContainer);
            return errorElem.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Clears the error message by waiting until it disappears (if applicable).
     */
    public void waitForErrorMessageToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(errorMessageContainer));
    }

    // ================================
    // Accepted Usernames & Password Info Methods
    // ================================

    /**
     * Gets the text of the "Accepted usernames are:" label.
     * @return Label text.
     */
    public String getAcceptedUsernamesLabelText() {
        try {
            WebElement labelElem = driver.findElement(acceptedUsernamesLabel);
            return labelElem.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the text block listing all accepted usernames.
     * @return Accepted usernames text block.
     */
    public String getAcceptedUsernamesText() {
        try {
            WebElement textElem = driver.findElement(acceptedUsernamesText);
            return textElem.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the text of the "Password for all users:" label.
     * @return Label text.
     */
    public String getPasswordInfoLabelText() {
        try {
            WebElement labelElem = driver.findElement(passwordInfoLabel);
            return labelElem.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the password information text block.
     * @return Password info text.
     */
    public String getPasswordInfoText() {
        try {
            WebElement textElem = driver.findElement(passwordInfoText);
            return textElem.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
}