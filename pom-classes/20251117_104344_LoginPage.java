package com.saucelabs.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Object Model for LoginPage.
 * Provides reusable methods and validations for the Swag Labs login page.
 * This class includes all locators and methods to interact with username, password,
 * login button, error messages and credential info sections.
 * 
 * @author Test Automation Architect
 * @created 2024-06-06
 * @purpose Automate interactions and validations on the Swag Labs Login Page in a robust, maintainable manner.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Timeout constants
    private static final int TIMEOUT_SECONDS = 10;
    private static final int POLLING_MILLIS = 200;

    /*
     * Locators for all web elements on the Login page
     */

    // Locator for the username input field identified by id "user-name"
    private By usernameInput = By.id("user-name");

    // Locator for the password input field identified by id "password"
    private By passwordInput = By.id("password");

    // Locator for the login button identified by id "login-button"
    private By loginButton = By.id("login-button");

    // Locator for the error message container by class "error-message-container"
    private By errorMessageContainer = By.className("error-message-container");

    // Locator for the accepted usernames section by css containing text header "Accepted usernames are:"
    private By acceptedUsernamesHeader = By.xpath("//h4[contains(text(),'Accepted usernames are:')]");

    // Locator for the password information header "Password for all users:"
    private By passwordInfoHeader = By.xpath("//h4[contains(text(),'Password for all users:')]");

    // Locator for the entire login container div with class "login_container"
    private By loginContainerDiv = By.className("login_container");

    /*
     * Constructor initializes WebDriver and WebDriverWait
     * @param driver instance of WebDriver to use
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS), Duration.ofMillis(POLLING_MILLIS));
    }

    /**
     * Waits for the login page to fully load by waiting for the login container to be visible.
     */
    public void waitForPageToLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginContainerDiv));
        } catch (TimeoutException e) {
            throw new IllegalStateException("Login page did not load within timeout");
        }
    }

    /**
     * Verifies if the login page is currently displayed by checking the presence of the login button
     * and accepted usernames header.
     * 
     * @return true if login page is displaying, false otherwise
     */
    public boolean isPageDisplaying() {
        try {
            return driver.findElement(loginButton).isDisplayed() &&
                   driver.findElement(acceptedUsernamesHeader).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Enters text into the username input field after waiting for it to be visible and enabled.
     * 
     * @param username the username to enter
     */
    public void enterUsername(String username) {
        try {
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
            input.clear();
            input.sendKeys(username);
        } catch (TimeoutException e) {
            throw new IllegalStateException("Username input field not interactable");
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
            throw new IllegalStateException("Username input field not visible to clear");
        }
    }

    /**
     * Gets the current value of the username input field.
     * 
     * @return String value of username field
     */
    public String getUsernameValue() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            return input.getAttribute("value");
        } catch (TimeoutException e) {
            throw new IllegalStateException("Username input field not visible to get value");
        }
    }

    /**
     * Checks if the username input field is displayed.
     * 
     * @return true if displayed, false otherwise
     */
    public boolean isUsernameDisplayed() {
        try {
            return driver.findElement(usernameInput).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Checks if the username input field is enabled.
     * 
     * @return true if enabled, false otherwise
     */
    public boolean isUsernameEnabled() {
        try {
            return driver.findElement(usernameInput).isEnabled();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Checks whether the username field is prepopulated with the expected value.
     * 
     * @param expectedValue The expected username string
     * @return true if prepopulated with expectedValue, false otherwise
     */
    public boolean isUsernamePrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getUsernameValue());
    }

    /**
     * Checks if username input has required attribute (field is mandatory).
     * 
     * @return true if required, false otherwise
     */
    public boolean isUsernameRequired() {
        try {
            WebElement input = driver.findElement(usernameInput);
            String required = input.getAttribute("required");
            return required != null && (required.equals("true") || required.equals("required"));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Enters text into the password input field after waiting for it to be visible and enabled.
     * 
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        try {
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
            input.clear();
            input.sendKeys(password);
        } catch (TimeoutException e) {
            throw new IllegalStateException("Password input field not interactable");
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
            throw new IllegalStateException("Password input field not visible to clear");
        }
    }

    /**
     * Gets the current value of the password input field.
     * 
     * @return String value of password field
     */
    public String getPasswordValue() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            return input.getAttribute("value");
        } catch (TimeoutException e) {
            throw new IllegalStateException("Password input field not visible to get value");
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
        } catch (NoSuchElementException e){
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
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Checks whether the password field is prepopulated with the expected value.
     * 
     * @param expectedValue The expected password string
     * @return true if prepopulated with expectedValue, false otherwise
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getPasswordValue());
    }

    /**
     * Checks if password input has required attribute (field is mandatory).
     * 
     * @return true if required, false otherwise
     */
    public boolean isPasswordRequired() {
        try {
            WebElement input = driver.findElement(passwordInput);
            String required = input.getAttribute("required");
            return required != null && (required.equals("true") || required.equals("required"));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Clicks the login button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            button.click();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Login button not clickable");
        }
    }

    /**
     * Checks if the login button is displayed.
     * 
     * @return true if login button displayed, false otherwise
     */
    public boolean isLoginButtonDisplayed() {
        try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (NoSuchElementException e){
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
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Gets the text displayed on the login button.
     * 
     * @return String text on the login button
     */
    public String getLoginButtonText() {
        try {
            WebElement button = driver.findElement(loginButton);
            return button.getAttribute("value"); // input button's visible text typically in value attribute
        } catch (NoSuchElementException e){
            return "";
        }
    }

    /**
     * Checks if the error message container is visible on the page.
     * 
     * @return true if error message container visible, false otherwise
     */
    public boolean isErrorMessageVisible() {
        try {
            return driver.findElement(errorMessageContainer).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Gets the error message text if displayed.
     * 
     * @return String error message or empty if not present
     */
    public String getErrorMessageText() {
        try {
            WebElement errorDiv = driver.findElement(errorMessageContainer);
            if(errorDiv.isDisplayed()){
                return errorDiv.getText().trim();
            }
            return "";
        } catch (NoSuchElementException e){
            return "";
        }
    }

    /**
     * Closes the error message container if a close button or link is present.
     * This implementation assumes presence of a close button inside the container.
     */
    public void closeErrorMessage() {
        try {
            WebElement errorDiv = driver.findElement(errorMessageContainer);
            WebElement closeButton = errorDiv.findElement(By.className("error-button"));
            if (closeButton.isDisplayed() && closeButton.isEnabled()) {
                closeButton.click();
                wait.until(ExpectedConditions.invisibilityOf(errorDiv));
            }
        } catch (NoSuchElementException e) {
            // No close button found - no action required
        } catch (TimeoutException e) {
            throw new IllegalStateException("Failed to close error message in timely manner");
        }
    }

    /**
     * Gets the text content of the "Accepted usernames are:" header.
     * 
     * @return String header text
     */
    public String getAcceptedUsernamesHeaderText() {
        try {
            WebElement header = driver.findElement(acceptedUsernamesHeader);
            return header.getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Asserts that the accepted usernames header contains the given text.
     * 
     * @param expectedText expected text substring in the header
     */
    public void assertAcceptedUsernamesHeaderContains(String expectedText) {
        String actualText = getAcceptedUsernamesHeaderText();
        assertTrue(actualText.contains(expectedText), 
            "Accepted usernames header does not contain expected text. Expected to contain: " 
            + expectedText + " but was: " + actualText);
    }

    /**
     * Gets the text content of the "Password for all users:" header.
     * 
     * @return String header text
     */
    public String getPasswordInfoHeaderText() {
        try {
            WebElement header = driver.findElement(passwordInfoHeader);
            return header.getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Asserts that the password info header contains the given text.
     * 
     * @param expectedText Expected text substring in the header
     */
    public void assertPasswordInfoHeaderContains(String expectedText) {
        String actualText = getPasswordInfoHeaderText();
        assertTrue(actualText.contains(expectedText),
            "Password info header does not contain expected text. Expected to contain: "
            + expectedText + " but was: " + actualText);
    }

    /**
     * Gets the page title of the current page.
     * 
     * @return String page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Asserts that the current page URL matches the expected URL.
     * 
     * @param expectedURL the expected URL string
     */
    public void assertPageURL(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        assertEquals(expectedURL, currentURL,
            "Current page URL '" + currentURL + "' does not match expected URL '" + expectedURL + "'");
    }

}