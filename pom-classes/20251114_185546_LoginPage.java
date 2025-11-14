package com.saucedemo.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

/**
 * Page Object Model for LoginPage.
 * 
 * Provides reusable methods and validations for the Swag Labs Login page.
 * This page contains username and password inputs, login button, error messages,
 * and informational text about accepted usernames and passwords.
 * 
 * Author: Test Automation Architect
 * Created: 2024-06
 * Purpose: Encapsulate all interactions and validations on the Login page of Swag Labs.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    // --------------------------
    // Locators for Web Elements
    // --------------------------

    // Locator for username input field
    private By usernameInput = By.id("user-name");

    // Locator for password input field
    private By passwordInput = By.id("password");

    // Locator for login button
    private By loginButton = By.id("login-button");

    // Locator for error message container
    private By errorMessageContainer = By.cssSelector("div.error-message-container");

    // Locator for "Accepted usernames are:" heading
    private By acceptedUsernamesHeading = By.xpath("//h4[contains(text(),'Accepted usernames are:')]");

    // Locator for the list of accepted usernames text container
    private By acceptedUsernamesList = By.cssSelector("div.login_credentials");

    // Locator for "Password for all users:" heading
    private By passwordForAllUsersHeading = By.xpath("//h4[contains(text(),'Password for all users:')]");

    // Locator for password text container
    private By passwordForAllUsersText = By.cssSelector("div.login_password");

    /**
     * Constructor initializes the LoginPage with WebDriver and WebDriverWait.
     * 
     * @param driver WebDriver instance to interact with browser
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    // -----------------
    // Input Field Methods
    // -----------------

    /**
     * Enters the specified username into the username input field after waiting for visibility.
     * 
     * @param value Username to enter
     */
    public void enterUsername(String value) {
        try {
            WebElement usernameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            usernameElem.clear();
            usernameElem.sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter username: " + e.getMessage(), e);
        }
    }

    /**
     * Clears the username input field after waiting for visibility.
     */
    public void clearUsername() {
        try {
            WebElement usernameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            usernameElem.clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear username field: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves the current value from the username input field.
     * 
     * @return current username input value
     */
    public String getUsernameValue() {
        try {
            WebElement usernameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            return usernameElem.getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get username value: " + e.getMessage(), e);
        }
    }

    /**
     * Checks if the username input field is displayed on the page.
     * 
     * @return true if displayed, false otherwise
     */
    public boolean isUsernameDisplayed() {
        try {
            return driver.findElement(usernameInput).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the username input field is enabled and interactive.
     * 
     * @return true if enabled, false otherwise
     */
    public boolean isUsernameEnabled() {
        try {
            return driver.findElement(usernameInput).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Verifies if the username input field is prepopulated with the expected value.
     * 
     * @param expectedValue Expected username value
     * @return true if matches, false otherwise
     */
    public boolean isUsernamePrepopulatedWith(String expectedValue) {
        String actual = getUsernameValue();
        return expectedValue.equals(actual);
    }

    /**
     * Checks if the username input field is required based on the required attribute.
     * 
     * @return true if required, false otherwise
     */
    public boolean isUsernameRequired() {
        try {
            WebElement usernameElem = driver.findElement(usernameInput);
            String requiredAttr = usernameElem.getAttribute("required");
            return requiredAttr != null;
        } catch (Exception e) {
            return false;
        }
    }

    // -----------------
    // Password Field Methods
    // -----------------

    /**
     * Enters the specified password into the password input field after waiting for visibility.
     * 
     * @param value Password to enter
     */
    public void enterPassword(String value) {
        try {
            WebElement passwordElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            passwordElem.clear();
            passwordElem.sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter password: " + e.getMessage(), e);
        }
    }

    /**
     * Clears the password input field after waiting for visibility.
     */
    public void clearPassword() {
        try {
            WebElement passwordElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            passwordElem.clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear password field: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves the current value from the password input field.
     * 
     * @return current password input value
     */
    public String getPasswordValue() {
        try {
            WebElement passwordElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            return passwordElem.getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get password value: " + e.getMessage(), e);
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
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the password input field is enabled and interactive.
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
     * Verifies if the password input field is prepopulated with the expected value.
     * 
     * @param expectedValue Expected password value
     * @return true if matches, false otherwise
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        String actual = getPasswordValue();
        return expectedValue.equals(actual);
    }

    /**
     * Checks if the password input field is required based on the required attribute.
     * 
     * @return true if required, false otherwise
     */
    public boolean isPasswordRequired() {
        try {
            WebElement passwordElem = driver.findElement(passwordInput);
            String requiredAttr = passwordElem.getAttribute("required");
            return requiredAttr != null;
        } catch (Exception e) {
            return false;
        }
    }

    // -------------------
    // Button Methods
    // -------------------

    /**
     * Clicks the login button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        try {
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginBtn.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click login button: " + e.getMessage(), e);
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
     * Checks if the login button is enabled and clickable.
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
     * Gets the text displayed on the login button.
     * 
     * @return visible login button text
     */
    public String getLoginButtonText() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).getText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get login button text: " + e.getMessage(), e);
        }
    }

    // -------------------------
    // Error Message Methods
    // -------------------------

    /**
     * Checks if the error message container is displayed.
     * 
     * @return true if displayed, false otherwise
     */
    public boolean isErrorMessageDisplayed() {
        try {
            return driver.findElement(errorMessageContainer).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the error message text displayed to the user.
     * 
     * @return text of error message or empty string if none
     */
    public String getErrorMessageText() {
        try {
            WebElement errorElem = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContainer));
            return errorElem.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Asserts that the error message contains the expected text.
     * 
     * @param expectedText Expected substring in error message
     */
    public void assertErrorMessageContains(String expectedText) {
        String actualText = getErrorMessageText();
        Assertions.assertTrue(actualText.contains(expectedText),
                "Expected error message to contain: '" + expectedText + "' but was: '" + actualText + "'");
    }

    // -----------------------------------
    // Informational Text & Label Methods
    // -----------------------------------

    /**
     * Gets the heading text "Accepted usernames are:".
     * 
     * @return heading text
     */
    public String getAcceptedUsernamesHeadingText() {
        try {
            return driver.findElement(acceptedUsernamesHeading).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the full accepted usernames list text content.
     * 
     * @return accepted usernames text
     */
    public String getAcceptedUsernamesListText() {
        try {
            return driver.findElement(acceptedUsernamesList).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the heading text "Password for all users:".
     * 
     * @return heading text
     */
    public String getPasswordForAllUsersHeadingText() {
        try {
            return driver.findElement(passwordForAllUsersHeading).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the password information text for all users.
     * 
     * @return password info text
     */
    public String getPasswordForAllUsersText() {
        try {
            return driver.findElement(passwordForAllUsersText).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Asserts that a label or informational text contains the expected substring.
     * 
     * @param locator Locator of the element containing text
     * @param expectedText Expected substring
     */
    public void assertTextContains(By locator, String expectedText) {
        try {
            String actualText = driver.findElement(locator).getText();
            Assertions.assertTrue(actualText.contains(expectedText),
                    "Expected text to contain: '" + expectedText + "' but was: '" + actualText + "'");
        } catch (Exception e) {
            throw new RuntimeException("Failed to assert text contains for locator: " + locator.toString(), e);
        }
    }

    // -------------------
    // Page Utility Methods
    // -------------------

    /**
     * Waits for the LoginPage to fully load by waiting for username input visibility
     * and the login button to be clickable.
     */
    public void waitForPageToLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        } catch (Exception e) {
            throw new RuntimeException("LoginPage did not load correctly: " + e.getMessage(), e);
        }
    }

    /**
     * Verifies the LoginPage is currently displayed by asserting presence and visibility
     * of key elements: username input, password input, and login button.
     * 
     * @return true if this page is displayed, false otherwise
     */
    public boolean isPageDisplaying() {
        try {
            return isUsernameDisplayed() && isPasswordDisplayed() && isLoginButtonDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves the current page title.
     * 
     * @return title of the current web page
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Asserts the current page URL matches the expected URL.
     * 
     * @param expectedURL Expected URL string
     */
    public void assertPageURL(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, actualURL,
                "Expected URL to be '" + expectedURL + "' but was '" + actualURL + "'");
    }

}