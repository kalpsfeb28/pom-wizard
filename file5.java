package com.saucelabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static org.testng.Assert.*;

/**
 * Page Object Model for the Login Page of Swag Labs.
 * Provides reusable methods and validations for login page interactions and assertions.
 * Handles user name, password input, login button and error message validations.
 * Utilizes explicit waits and assertions to ensure reliability.
 * Author: Test Automation Architect
 * Created: 2024-06-17
 * Purpose: Encapsulate all web elements and functionalities of the Swag Labs Login page.
 */
public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locator for username input field
    private final By userNameInput = By.id("user-name");

    // Locator for password input field
    private final By passwordInput = By.id("password");

    // Locator for login button
    private final By loginButton = By.id("login-button");

    // Locator for error message container
    private final By errorMessageContainer = By.cssSelector("div.error-message-container");

    // Locator for login logo text (for confirmation page display)
    private final By loginLogo = By.className("login_logo");

    // Locator for accepted usernames text container
    private final By acceptedUsernamesText = By.xpath("//div[contains(@class,'login_credentials')]");

    // Locator for password information text container
    private final By passwordInfoText = By.className("login_password");

    /**
     * Constructor initializing the WebDriver and WebDriverWait for this page.
     *
     * @param driver the WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Initialize wait with a 10 second timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Waits for the login page to load by waiting for the username input
     * and login button to be visible and enabled.
     */
    public void waitForPageToLoad() {
        try {
            // Wait for username input to be visible and enabled
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(userNameInput),
                    ExpectedConditions.elementToBeClickable(userNameInput)
            ));
            // Wait for login button to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        } catch (TimeoutException e) {
            throw new IllegalStateException("Login page did not load properly within timeout", e);
        }
    }

    /**
     * Verifies if the login page is currently displayed by checking key
     * elements visibility.
     *
     * @return true if username input and login button are displayed, false otherwise
     */
    public boolean isPageDisplaying() {
        try {
            return driver.findElement(userNameInput).isDisplayed()
                    && driver.findElement(passwordInput).isDisplayed()
                    && driver.findElement(loginButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Enters the specified username into the username input field.
     *
     * @param username the username to enter
     */
    public void enterUserName(String username) {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            input.clear();
            input.sendKeys(username);
        } catch (TimeoutException e) {
            throw new IllegalStateException("Username input field not found or not visible for entering value", e);
        }
    }

    /**
     * Clears the username input field.
     */
    public void clearUserName() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            input.clear();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Username input field not found or not visible to clear", e);
        }
    }

    /**
     * Retrieves the current value from the username input field.
     *
     * @return the username field's current text value
     */
    public String getUserNameValue() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            return input.getAttribute("value");
        } catch (TimeoutException e) {
            throw new IllegalStateException("Username input field not found or not visible for retrieving value", e);
        }
    }

    /**
     * Checks if the username input field is displayed on the page.
     *
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
     * Checks if the username input field is enabled for input.
     *
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
     *
     * @param expectedValue the expected username value
     * @return true if the field's value matches the expected value, false otherwise
     */
    public boolean isUserNamePrepopulatedWith(String expectedValue) {
        return getUserNameValue().equals(expectedValue);
    }

    /**
     * Checks if the username input field is marked as required.
     *
     * @return true if required attribute is present and set to true, false otherwise
     */
    public boolean isUserNameRequired() {
        try {
            WebElement input = driver.findElement(userNameInput);
            String requiredAttr = input.getAttribute("required");
            return requiredAttr != null && (requiredAttr.equals("true") || requiredAttr.equals("required"));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Enters the specified password into the password input field.
     *
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            input.clear();
            input.sendKeys(password);
        } catch (TimeoutException e) {
            throw new IllegalStateException("Password input field not found or not visible for entering value", e);
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
            throw new IllegalStateException("Password input field not found or not visible to clear", e);
        }
    }

    /**
     * Retrieves the current value from the password input field.
     *
     * @return the password field's current text value
     */
    public String getPasswordValue() {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            return input.getAttribute("value");
        } catch (TimeoutException e) {
            throw new IllegalStateException("Password input field not found or not visible for retrieving value", e);
        }
    }

    /**
     * Checks if the password input field is displayed on the page.
     *
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
     * Checks if the password input field is enabled for input.
     *
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
     *
     * @param expectedValue the expected password value
     * @return true if the field's value matches the expected value, false otherwise
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        return getPasswordValue().equals(expectedValue);
    }

    /**
     * Checks if the password input field is marked as required.
     *
     * @return true if required attribute is present and set to true, false otherwise
     */
    public boolean isPasswordRequired() {
        try {
            WebElement input = driver.findElement(passwordInput);
            String requiredAttr = input.getAttribute("required");
            return requiredAttr != null && (requiredAttr.equals("true") || requiredAttr.equals("required"));
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
            throw new IllegalStateException("Login button not clickable for clicking", e);
        }
    }

    /**
     * Checks if the login button is displayed on the page.
     *
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
     * Checks if the login button is enabled for interaction.
     *
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
     * Retrieves the visible text from the login button.
     *
     * @return the login button text
     */
    public String getLoginButtonText() {
        try {
            return driver.findElement(loginButton).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Gets the error message text displayed in the error message container.
     *
     * @return error message string if present; empty string otherwise
     */
    public String getErrorMessage() {
        try {
            WebElement errorContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContainer));
            return errorContainer.getText().trim();
        } catch (TimeoutException | NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Checks if an error message is currently visible.
     *
     * @return true if error message container is visible and contains text; false otherwise
     */
    public boolean isErrorMessageDisplayed() {
        try {
            WebElement errorContainer = driver.findElement(errorMessageContainer);
            return errorContainer.isDisplayed() && !errorContainer.getText().trim().isEmpty();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Asserts that the error message contains the specified expected text.
     *
     * @param expectedText the expected substring within the error message
     */
    public void assertErrorMessageContains(String expectedText) {
        String actualMessage = getErrorMessage();
        assertTrue(actualMessage.contains(expectedText),
                "Expected error message to contain '" + expectedText + "' but was '" + actualMessage + "'");
    }

    /**
     * Gets the page title string.
     *
     * @return the current page title
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
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL,
                "Expected page URL to be '" + expectedURL + "' but was '" + actualURL + "'");
    }

    /**
     * Retrieves the visible text listing accepted usernames on the login page.
     *
     * @return accepted usernames text content
     */
    public String getAcceptedUsernamesText() {
        try {
            WebElement element = driver.findElement(acceptedUsernamesText);
            return element.getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Retrieves the text showing password information for all users.
     *
     * @return password info text content
     */
    public String getPasswordInfoText() {
        try {
            WebElement element = driver.findElement(passwordInfoText);
            return element.getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

}