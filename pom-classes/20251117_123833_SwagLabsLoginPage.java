package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

/**
 * Page Object Model for Swag Labs Login Page.
 * Provides reusable methods and validations for login functionality of Swag Labs.
 *
 * @author Test Automation Architect
 * @created 2024-06-15
 * @purpose Encapsulate login page behaviors and verifications for reliable test automation.
 */
public class SwagLabsLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Timeout duration for explicit waits (in seconds)
    private static final int TIMEOUT = 15;

    // ===========================
    // Locators for Web Elements
    // ===========================

    // Locator for username input field
    private By userNameInput = By.id("user-name");

    // Locator for password input field
    private By passwordInput = By.id("password");

    // Locator for login button input
    private By loginButton = By.id("login-button");

    // Locator for error message container div (visible on login failure)
    private By errorMessageContainer = By.className("error-message-container");

    // Locator for the entire login wrapper container for page presence detection
    private By loginWrapper = By.className("login_wrapper");

    // Locator for accepted usernames text header (H4 element)
    private By acceptedUsernamesHeader = By.xpath("//h4[text()='Accepted usernames are:']");

    // Locator for password info header (H4 element)
    private By passwordHeader = By.xpath("//h4[text()='Password for all users:']");

    // ===========================
    // Constructor
    // ===========================

    /**
     * Constructor to initialize WebDriver and WebDriverWait.
     *
     * @param driver WebDriver instance from test
     */
    public SwagLabsLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    // ===========================
    // Page-Level Methods
    // ===========================

    /**
     * Waits for the login page to load by waiting for key elements to be visible.
     */
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginWrapper));
    }

    /**
     * Checks whether the login page is displaying properly by verifying presence of unique elements.
     *
     * @return true if page is displaying, false otherwise
     */
    public boolean isPageDisplaying() {
        try {
            return driver.findElement(userNameInput).isDisplayed()
                    && driver.findElement(passwordInput).isDisplayed()
                    && driver.findElement(loginButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the current page title.
     *
     * @return Page title string
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Asserts the current page URL equals the expected URL.
     *
     * @param expectedURL Expected URL string
     */
    public void assertPageURL(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        assertEquals("Page URL does not match expected URL.", expectedURL, actualURL);
    }

    // ===========================
    // Username Input Field Methods
    // ===========================

    /**
     * Enters the specified username into the username input field.
     *
     * @param username Username string to enter
     */
    public void enterUserName(String username) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
            WebElement userInput = driver.findElement(userNameInput);
            userInput.clear();
            userInput.sendKeys(username);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter username: " + e.getMessage());
        }
    }

    /**
     * Clears the username input field.
     */
    public void clearUserName() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            driver.findElement(userNameInput).clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear username field: " + e.getMessage());
        }
    }

    /**
     * Returns the current value in the username input field.
     *
     * @return Username string from input
     */
    public String getUserNameValue() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            return driver.findElement(userNameInput).getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get username input value: " + e.getMessage());
        }
    }

    /**
     * Checks if the username input field is displayed.
     *
     * @return true if displayed, false otherwise
     */
    public boolean isUserNameDisplayed() {
        try {
            return driver.findElement(userNameInput).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the username input field is enabled.
     *
     * @return true if enabled, false otherwise
     */
    public boolean isUserNameEnabled() {
        try {
            return driver.findElement(userNameInput).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the username input is prepopulated with the expected value.
     *
     * @param expectedValue Expected username string
     * @return true if matches, false otherwise
     */
    public boolean isUserNamePrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getUserNameValue());
    }

    /**
     * Checks if the username input field is marked as required.
     *
     * @return true if required, false otherwise
     */
    public boolean isUserNameRequired() {
        try {
            String requiredAttr = driver.findElement(userNameInput).getAttribute("required");
            return requiredAttr != null;
        } catch (Exception e) {
            return false;
        }
    }

    // ===========================
    // Password Input Field Methods
    // ===========================

    /**
     * Enters the specified password into the password input field.
     *
     * @param password Password string to enter
     */
    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
            WebElement passwordElem = driver.findElement(passwordInput);
            passwordElem.clear();
            passwordElem.sendKeys(password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter password: " + e.getMessage());
        }
    }

    /**
     * Clears the password input field.
     */
    public void clearPassword() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            driver.findElement(passwordInput).clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear password field: " + e.getMessage());
        }
    }

    /**
     * Returns the current value in the password input field.
     *
     * @return Masked password string (usually empty or dots depending on implementation)
     */
    public String getPasswordValue() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            return driver.findElement(passwordInput).getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get password input value: " + e.getMessage());
        }
    }

    /**
     * Checks if the password input field is displayed.
     *
     * @return true if displayed, false otherwise
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
     *
     * @return true if enabled, false otherwise
     */
    public boolean isPasswordEnabled() {
        try {
            return driver.findElement(passwordInput).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the password input is prepopulated with the expected value.
     *
     * @param expectedValue Expected password string
     * @return true if matches, false otherwise
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getPasswordValue());
    }

    /**
     * Checks if the password input field is marked as required.
     *
     * @return true if required, false otherwise
     */
    public boolean isPasswordRequired() {
        try {
            String requiredAttr = driver.findElement(passwordInput).getAttribute("required");
            return requiredAttr != null;
        } catch (Exception e) {
            return false;
        }
    }

    // ===========================
    // Login Button Methods
    // ===========================

    /**
     * Clicks the login button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            driver.findElement(loginButton).click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click login button: " + e.getMessage());
        }
    }

    /**
     * Checks if the login button is displayed.
     *
     * @return true if displayed, false otherwise
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
     *
     * @return true if enabled, false otherwise
     */
    public boolean isLoginButtonEnabled() {
        try {
            return driver.findElement(loginButton).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the text value of the login button.
     *
     * @return Button display text
     */
    public String getLoginButtonText() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            return driver.findElement(loginButton).getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get login button text: " + e.getMessage());
        }
    }

    // ===========================
    // Error Message Methods
    // ===========================

    /**
     * Checks if the error message container is visible.
     *
     * @return true if visible, false otherwise
     */
    public boolean isErrorMessageVisible() {
        try {
            return driver.findElement(errorMessageContainer).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the text message displayed in the error message container.
     *
     * @return Error message string or empty if none
     */
    public String getErrorMessageText() {
        try {
            if (isErrorMessageVisible()) {
                return driver.findElement(errorMessageContainer).getText().trim();
            } else {
                return "";
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get error message text: " + e.getMessage());
        }
    }

    /**
     * Asserts that the error message container contains the expected text.
     *
     * @param expectedText Expected substring in error message
     */
    public void assertErrorMessageContains(String expectedText) {
        String actualText = getErrorMessageText();
        assertTrue("Error message does not contain expected text. Actual: '" + actualText + "'",
                actualText.contains(expectedText));
    }

    // ===========================
    // Informational Headers Methods
    // ===========================

    /**
     * Returns the text of the "Accepted usernames are:" header.
     *
     * @return Header text string
     */
    public String getAcceptedUsernamesHeaderText() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(acceptedUsernamesHeader));
            return driver.findElement(acceptedUsernamesHeader).getText().trim();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get accepted usernames header text: " + e.getMessage());
        }
    }

    /**
     * Returns the text of the "Password for all users:" header.
     *
     * @return Header text string
     */
    public String getPasswordHeaderText() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordHeader));
            return driver.findElement(passwordHeader).getText().trim();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get password header text: " + e.getMessage());
        }
    }

    /**
     * Asserts that the accepted usernames header contains the expected text.
     *
     * @param expectedText Expected substring
     */
    public void assertAcceptedUsernamesHeaderContains(String expectedText) {
        String actualText = getAcceptedUsernamesHeaderText();
        assertTrue("Accepted usernames header does not contain expected text. Actual: '" + actualText + "'",
                actualText.contains(expectedText));
    }

    /**
     * Asserts that the password header contains the expected text.
     *
     * @param expectedText Expected substring
     */
    public void assertPasswordHeaderContains(String expectedText) {
        String actualText = getPasswordHeaderText();
        assertTrue("Password header does not contain expected text. Actual: '" + actualText + "'",
                actualText.contains(expectedText));
    }

}