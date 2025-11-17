package com.saucelabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

/**
 * Page Object Model for LoginPage.
 * Provides reusable methods and validations for the Swag Labs login page.
 * Includes comprehensive coverage for all web elements to support robust test automation.
 * 
 * @author Test Automation Architect
 * @created 2024-06-08
 * @purpose Encapsulate interactions and verifications of the Swag Labs login page.
 */
public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

    // Constants for expected page title and URL
    private static final String PAGE_TITLE = "Swag Labs";
    private static final String PAGE_URL_CONTAINS = "saucedemo.com";

    // Locators

    // Locator for username input field
    private final By userNameInput = By.id("user-name");

    // Locator for password input field
    private final By passwordInput = By.id("password");

    // Locator for login button
    private final By loginButton = By.id("login-button");

    // Locator for login logo text div
    private final By loginLogo = By.className("login_logo");

    // Locator for Accepted usernames label (h4)
    private final By acceptedUsernamesLabel = By.xpath("//h4[text()='Accepted usernames are:']");

    // Locator for Password for all users label (h4)
    private final By passwordForAllUsersLabel = By.xpath("//h4[text()='Password for all users:']");

    // Locator for error message container
    private final By errorMessageContainer = By.className("error-message-container");

    // Constructor
    /**
     * Initializes the LoginPage with WebDriver instance and sets up WebDriverWait.
     * @param driver WebDriver instance to interact with the browser
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }

    // ====================
    // Username Input Methods
    // ====================

    /**
     * Enters the specified username into the username input field after waiting for it to be visible.
     * @param username the username to enter
     */
    public void enterUserName(String username) {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            input.clear();
            input.sendKeys(username);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter username: " + e.getMessage(), e);
        }
    }

    /**
     * Clears the username input field.
     */
    public void clearUserName() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            input.clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear username input: " + e.getMessage(), e);
        }
    }

    /**
     * Gets the current value from the username input field.
     * @return String value of the username field
     */
    public String getUserNameValue() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get username input value: " + e.getMessage(), e);
        }
    }

    /**
     * Checks if the username input field is displayed on the page.
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
     * Checks if the username input field is enabled for interaction.
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
     * Verifies if the username input field is prepopulated with the expected value.
     * @param expectedValue Expected string value of the username field
     * @return true if matches, false otherwise
     */
    public boolean isUserNamePrepopulatedWith(String expectedValue) {
        String actualValue = getUserNameValue();
        return expectedValue.equals(actualValue);
    }

    /**
     * Checks if the username input field has the required attribute set.
     * @return true if required, false otherwise
     */
    public boolean isUserNameRequired() {
        try {
            WebElement input = driver.findElement(userNameInput);
            String required = input.getAttribute("required");
            return required != null && (required.equalsIgnoreCase("true") || required.equals("required"));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // =====================
    // Password Input Methods
    // =====================

    /**
     * Enters the specified password into the password input field after waiting for it to be visible.
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            input.clear();
            input.sendKeys(password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter password: " + e.getMessage(), e);
        }
    }

    /**
     * Clears the password input field.
     */
    public void clearPassword() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            input.clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear password input: " + e.getMessage(), e);
        }
    }

    /**
     * Gets the current value from the password input field.
     * @return String value of the password field
     */
    public String getPasswordValue() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get password input value: " + e.getMessage(), e);
        }
    }

    /**
     * Checks if the password input field is displayed on the page.
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
     * Checks if the password input field is enabled for interaction.
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
     * Verifies if the password input field is prepopulated with the expected value.
     * @param expectedValue Expected string value of the password field
     * @return true if matches, false otherwise
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        String actualValue = getPasswordValue();
        return expectedValue.equals(actualValue);
    }

    /**
     * Checks if the password input field has the required attribute set.
     * @return true if required, false otherwise
     */
    public boolean isPasswordRequired() {
        try {
            WebElement input = driver.findElement(passwordInput);
            String required = input.getAttribute("required");
            return required != null && (required.equalsIgnoreCase("true") || required.equals("required"));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // ===================
    // Login Button Methods
    // ===================

    /**
     * Clicks the login button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            button.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click login button: " + e.getMessage(), e);
        }
    }

    /**
     * Checks if the login button is displayed.
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
     * Checks if the login button is enabled.
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
     * Gets the text displayed on the login button.
     * @return Button text as String
     */
    public String getLoginButtonText() {
        try {
            WebElement button = driver.findElement(loginButton);
            return button.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    // ===================
    // Login Logo Methods
    // ===================

    /**
     * Checks if the Swag Labs login logo text is displayed.
     * @return true if displayed, false otherwise
     */
    public boolean isLoginLogoDisplayed() {
        try {
            return driver.findElement(loginLogo).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Gets the text of the login logo area.
     * @return login logo text
     */
    public String getLoginLogoText() {
        try {
            WebElement logo = driver.findElement(loginLogo);
            return logo.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    // ===========================
    // Accepted Usernames Label Methods
    // ===========================

    /**
     * Gets the "Accepted usernames are:" label text.
     * @return text content of the label
     */
    public String getAcceptedUsernamesLabelText() {
        try {
            WebElement label = driver.findElement(acceptedUsernamesLabel);
            return label.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Asserts that the accepted usernames label contains the specified text.
     * @param text the expected text to contain
     * @throws AssertionError if the text is not contained
     */
    public void assertAcceptedUsernamesLabelContains(String text) {
        String actualText = getAcceptedUsernamesLabelText();
        if (!actualText.contains(text)) {
            throw new AssertionError("Accepted usernames label does not contain expected text: '" + text + "'. Actual: '" + actualText + "'");
        }
    }

    /**
     * Checks if the accepted usernames label is displayed.
     * @return true if displayed, false otherwise
     */
    public boolean isAcceptedUsernamesLabelDisplayed() {
        try {
            return driver.findElement(acceptedUsernamesLabel).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // ===========================
    // Password For All Users Label Methods
    // ===========================

    /**
     * Gets the "Password for all users:" label text.
     * @return text content of the label
     */
    public String getPasswordForAllUsersLabelText() {
        try {
            WebElement label = driver.findElement(passwordForAllUsersLabel);
            return label.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Asserts that the password for all users label contains the specified text.
     * @param text the expected text to contain
     * @throws AssertionError if the text is not contained
     */
    public void assertPasswordForAllUsersLabelContains(String text) {
        String actualText = getPasswordForAllUsersLabelText();
        if (!actualText.contains(text)) {
            throw new AssertionError("Password for all users label does not contain expected text: '" + text + "'. Actual: '" + actualText + "'");
        }
    }

    /**
     * Checks if the password for all users label is displayed.
     * @return true if displayed, false otherwise
     */
    public boolean isPasswordForAllUsersLabelDisplayed() {
        try {
            return driver.findElement(passwordForAllUsersLabel).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // ========================
    // Error Message Container Methods
    // ========================

    /**
     * Checks if the error message container is visible.
     * @return true if visible, false otherwise
     */
    public boolean isErrorMessageContainerVisible() {
        try {
            WebElement errorContainer = driver.findElement(errorMessageContainer);
            return errorContainer.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Gets the error message text displayed in the container.
     * @return error message string or empty if not present
     */
    public String getErrorMessage() {
        try {
            WebElement errorContainer = driver.findElement(errorMessageContainer);
            return errorContainer.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Waits for the login page to load by waiting until the username input field is visible.
     */
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
    }

    /**
     * Verifies whether the login page is currently displayed by checking page title and presence of username input.
     * @return true if page is correctly displayed, false otherwise
     */
    public boolean isPageDisplaying() {
        try {
            String title = driver.getTitle();
            boolean titleMatches = PAGE_TITLE.equals(title);
            boolean userNameVisible = driver.findElement(userNameInput).isDisplayed();
            return titleMatches && userNameVisible;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Gets the current page title.
     * @return page title as string
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Asserts that the current page URL contains the expected substring.
     * @param expectedURLSubstring substring expected in the URL
     * @throws AssertionError if URL does not contain the expected substring
     */
    public void assertPageURLContains(String expectedURLSubstring) {
        String actualURL = driver.getCurrentUrl();
        if (!actualURL.contains(expectedURLSubstring)) {
            throw new AssertionError("Page URL does not contain expected substring: '" + expectedURLSubstring + "'. Actual URL: '" + actualURL + "'");
        }
    }

}