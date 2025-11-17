package com.practicetestautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Object Model for Test Login Page.
 * Provides reusable methods and validations for this login page of Practice Test Automation.
 * Author: Test Automation Architect
 * Created: 2024-06
 * Purpose: Encapsulates login form interactions, error handling, and page validations for automated tests.
 */
public class TestLoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String PAGE_URL_SUBSTRING = "practicetestautomation.com"; // partial URL that indicates this page
    private static final Duration TIMEOUT_MEDIUM = Duration.ofSeconds(10);
    private static final Duration TIMEOUT_SHORT = Duration.ofSeconds(5);

    // Locators for web elements on the Test Login page

    // Locator for username input field
    private final By usernameInput = By.id("username");

    // Locator for password input field
    private final By passwordInput = By.id("password");

    // Locator for submit button (login button)
    private final By submitButton = By.id("submit");

    // Locator for error message container displayed on invalid login
    private final By errorMessageContainer = By.id("error");

    /**
     * Constructor to initialize the TestLoginPage object with WebDriver instance.
     * Initializes explicit wait with default timeout.
     *
     * @param driver WebDriver instance to interact with browser
     */
    public TestLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT_MEDIUM);
    }

    // region Username Input Methods

    /**
     * Enters the provided text into the Username input field after clearing any existing text.
     *
     * @param username Username to enter
     */
    public void enterUsername(String username) {
        try {
            WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            elem.clear();
            elem.sendKeys(username);
        } catch (TimeoutException e) {
            fail("Username input field was not visible within timeout");
        }
    }

    /**
     * Clears the Username input field.
     */
    public void clearUsername() {
        try {
            WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            elem.clear();
        } catch (TimeoutException e) {
            fail("Username input field was not visible to clear within timeout");
        }
    }

    /**
     * Retrieves the current value entered in the Username input field.
     *
     * @return Username field's value as String
     */
    public String getUsernameValue() {
        try {
            WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            return elem.getAttribute("value");
        } catch (TimeoutException e) {
            fail("Username input field was not visible to get value within timeout");
            return "";
        }
    }

    /**
     * Checks if the Username input field is currently displayed on the page.
     *
     * @return true if displayed, false otherwise
     */
    public boolean isUsernameDisplayed() {
        try {
            return driver.findElement(usernameInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the Username input field is enabled for interaction.
     *
     * @return true if enabled, false otherwise
     */
    public boolean isUsernameEnabled() {
        try {
            return driver.findElement(usernameInput).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the Username input field is prepopulated with the expected value.
     *
     * @param expectedValue Expected username value
     * @return true if prepopulated, false otherwise
     */
    public boolean isUsernamePrepopulatedWith(String expectedValue) {
        String actualValue = getUsernameValue();
        return expectedValue.equals(actualValue);
    }

    /**
     * Checks if the Username input field is marked as required.
     *
     * @return true if required, false otherwise
     */
    public boolean isUsernameRequired() {
        try {
            WebElement elem = driver.findElement(usernameInput);
            String requiredAttr = elem.getAttribute("required");
            return requiredAttr != null && (requiredAttr.equals("true") || requiredAttr.equals("required"));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // endregion Username Input Methods


    // region Password Input Methods

    /**
     * Enters the provided text into the Password input field after clearing any existing text.
     *
     * @param password Password to enter
     */
    public void enterPassword(String password) {
        try {
            WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            elem.clear();
            elem.sendKeys(password);
        } catch (TimeoutException e) {
            fail("Password input field was not visible within timeout");
        }
    }

    /**
     * Clears the Password input field.
     */
    public void clearPassword() {
        try {
            WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            elem.clear();
        } catch (TimeoutException e) {
            fail("Password input field was not visible to clear within timeout");
        }
    }

    /**
     * Retrieves the current value entered in the Password input field.
     *
     * @return Password field's value as String
     */
    public String getPasswordValue() {
        try {
            WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            return elem.getAttribute("value");
        } catch (TimeoutException e) {
            fail("Password input field was not visible to get value within timeout");
            return "";
        }
    }

    /**
     * Checks if the Password input field is currently displayed on the page.
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
     * Checks if the Password input field is enabled for interaction.
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
     * Checks if the Password input field is prepopulated with the expected value.
     *
     * @param expectedValue Expected password value
     * @return true if prepopulated, false otherwise
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        String actualValue = getPasswordValue();
        return expectedValue.equals(actualValue);
    }

    /**
     * Checks if the Password input field is marked as required.
     *
     * @return true if required, false otherwise
     */
    public boolean isPasswordRequired() {
        try {
            WebElement elem = driver.findElement(passwordInput);
            String requiredAttr = elem.getAttribute("required");
            return requiredAttr != null && (requiredAttr.equals("true") || requiredAttr.equals("required"));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // endregion Password Input Methods


    // region Submit Button Methods

    /**
     * Clicks the Submit button to trigger login after waiting for it to be clickable.
     */
    public void clickSubmitButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            button.click();
        } catch (TimeoutException e) {
            fail("Submit button was not clickable within timeout");
        }
    }

    /**
     * Checks if the Submit button is displayed on the page.
     *
     * @return true if displayed, false otherwise
     */
    public boolean isSubmitButtonDisplayed() {
        try {
            return driver.findElement(submitButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the Submit button is enabled for clicking.
     *
     * @return true if enabled, false otherwise
     */
    public boolean isSubmitButtonEnabled() {
        try {
            return driver.findElement(submitButton).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Retrieves the visible text displayed on the Submit button.
     *
     * @return Submit button text as String
     */
    public String getSubmitButtonText() {
        try {
            WebElement button = driver.findElement(submitButton);
            return button.getText();
        } catch (NoSuchElementException e) {
            fail("Submit button not found to get text");
            return "";
        }
    }

    // endregion Submit Button Methods


    // region Error Message Methods

    /**
     * Checks if the error message container is currently visible on the page.
     *
     * @return true if visible, false otherwise
     */
    public boolean isErrorMessageVisible() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContainer));
            return error.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Retrieves the error message text displayed for failed login attempts.
     *
     * @return Error message text as String
     */
    public String getErrorMessageText() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContainer));
            return error.getText().trim();
        } catch (TimeoutException | NoSuchElementException e) {
            fail("Error message was not visible within timeout");
            return "";
        }
    }

    /**
     * Asserts that the error message text matches the expected text.
     *
     * @param expectedText Expected error message text
     */
    public void assertErrorMessageTextEquals(String expectedText) {
        String actualText = getErrorMessageText();
        assertEquals(expectedText, actualText,
                "Expected error message '" + expectedText + "' but found '" + actualText + "'");
    }

    // endregion Error Message Methods


    // region Page-Level Methods

    /**
     * Waits for the Test Login page to be fully loaded by waiting for the username input field.
     */
    public void waitForPageToLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            // Optionally, wait until page URL contains expected substring
            wait.until(ExpectedConditions.urlContains(PAGE_URL_SUBSTRING));
        } catch (TimeoutException e) {
            fail("Test Login page did not load within timeout");
        }
    }

    /**
     * Verifies that the Test Login page is currently displaying.
     * Checks presence and visibility of key elements and that URL contains expected substring.
     *
     * @return true if page is correctly displaying, false otherwise
     */
    public boolean isPageDisplaying() {
        try {
            boolean urlCorrect = driver.getCurrentUrl().contains(PAGE_URL_SUBSTRING);
            boolean usernameVisible = driver.findElement(usernameInput).isDisplayed();
            boolean passwordVisible = driver.findElement(passwordInput).isDisplayed();
            boolean submitVisible = driver.findElement(submitButton).isDisplayed();
            return urlCorrect && usernameVisible && passwordVisible && submitVisible;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Retrieves the current page title.
     *
     * @return Page title as String
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Asserts that the current page URL contains the expected substring.
     *
     * @param expectedUrlSubstring Expected substring URL
     */
    public void assertPageURLContains(String expectedUrlSubstring) {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(expectedUrlSubstring),
                "Expected URL to contain '" + expectedUrlSubstring + "' but was '" + currentUrl + "'");
    }

    // endregion Page-Level Methods

}