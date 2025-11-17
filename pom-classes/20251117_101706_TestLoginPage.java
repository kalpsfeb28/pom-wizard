package com.practicetestautomation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import java.time.Duration;

/**
 * Page Object Model for TestLoginPage.
 * <p>
 * Provides reusable methods and validations for the Test Login page of Practice Test Automation.
 * This page enables users to enter their username and password to log in.
 * </p>
 * 
 * @author Test Automation Architect
 * @created 2024-06-10
 * @purpose Encapsulate all elements and user interactions on the Test Login page
 */
public class TestLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Timeout constants
    private static final int DEFAULT_TIMEOUT_SECONDS = 10;

    /*
     * LOCATORS SECTION
     */

    // Locator for Username input field
    @FindBy(id = "username")
    @CacheLookup
    private WebElement usernameInput;

    // Locator for Password input field
    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordInput;

    // Locator for Submit button
    @FindBy(id = "submit")
    @CacheLookup
    private WebElement submitButton;

    // Locator for Error message div displayed on invalid login
    @FindBy(id = "error")
    private WebElement errorMessageDiv;

    // Locator for main container section (used for page verification)
    @FindBy(id = "main-container")
    private WebElement mainContainerSection;

    /**
     * Constructor initializes TestLoginPage with WebDriver instance.
     * Initializes WebDriverWait for smart waiting.
     * 
     * @param driver WebDriver instance to perform browser interactions
     */
    public TestLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        PageFactory.initElements(driver, this);
    }

    /*
     * PAGE UTILITY METHODS
     */

    /**
     * Waits for the login page to fully load by waiting for main container and username input
     * to be visible and enabled.
     */
    public void waitForPageToLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOf(mainContainerSection));
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
            wait.until(ExpectedConditions.visibilityOf(submitButton));
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        } catch (TimeoutException e) {
            throw new RuntimeException("TestLoginPage did not load correctly within timeout", e);
        }
    }

    /**
     * Verifies whether the Test Login page is displayed.
     * Checks presence and visibility of key elements on login page.
     * 
     * @return true if page elements are correctly displayed, false otherwise
     */
    public boolean isPageDisplaying() {
        try {
            return mainContainerSection.isDisplayed()
                    && usernameInput.isDisplayed()
                    && passwordInput.isDisplayed()
                    && submitButton.isDisplayed()
                    && submitButton.isEnabled();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
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
     * Asserts that the current page URL contains the expected URL substring.
     * 
     * @param expectedURLSubstring Substring expected in the page URL
     */
    public void assertPageURLContains(String expectedURLSubstring) {
        String currentURL = driver.getCurrentUrl();
        if (!currentURL.contains(expectedURLSubstring)) {
            throw new AssertionError(String.format("Current URL '%s' does not contain expected substring '%s'", currentURL, expectedURLSubstring));
        }
    }

    /*
     * USERNAME INPUT FIELD METHODS
     */

    /**
     * Enters the given username into the Username input field after waiting for it to be visible and enabled.
     * 
     * @param username Text to enter into the username field
     */
    public void enterUsername(String username) {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
            usernameInput.clear();
            usernameInput.sendKeys(username);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter username", e);
        }
    }

    /**
     * Clears the Username input field after waiting for it to be visible and enabled.
     */
    public void clearUsername() {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
            usernameInput.clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear username field", e);
        }
    }

    /**
     * Returns the current text value in the Username input field.
     * 
     * @return Current username field value
     */
    public String getUsernameValue() {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            return usernameInput.getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get username value", e);
        }
    }

    /**
     * Checks if the Username input field is currently displayed.
     * 
     * @return true if Username input is displayed, false otherwise
     */
    public boolean isUsernameDisplayed() {
        try {
            return usernameInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the Username input field is currently enabled.
     * 
     * @return true if Username input is enabled, false otherwise
     */
    public boolean isUsernameEnabled() {
        try {
            return usernameInput.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Validates if the Username input field is prepopulated with the expected value.
     * 
     * @param expectedValue Expected username value
     * @return true if field value matches expectedValue, false otherwise
     */
    public boolean isUsernamePrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getUsernameValue());
    }

    /**
     * Checks if the Username input field has the HTML "required" attribute.
     * 
     * @return true if Username is required, false otherwise
     */
    public boolean isUsernameRequired() {
        try {
            String required = usernameInput.getAttribute("required");
            return required != null;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * PASSWORD INPUT FIELD METHODS
     */

    /**
     * Enters the given password into the Password input field after waiting for it to be visible and enabled.
     * 
     * @param password Text to enter into the password field
     */
    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
            passwordInput.clear();
            passwordInput.sendKeys(password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter password", e);
        }
    }

    /**
     * Clears the Password input field after waiting for it to be visible and enabled.
     */
    public void clearPassword() {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
            passwordInput.clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear password field", e);
        }
    }

    /**
     * Returns the current text value in the Password input field.
     * 
     * @return Current password field value (may be empty, browsers obscure this for security)
     */
    public String getPasswordValue() {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            return passwordInput.getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get password value", e);
        }
    }

    /**
     * Checks if the Password input field is currently displayed.
     * 
     * @return true if Password input is displayed, false otherwise
     */
    public boolean isPasswordDisplayed() {
        try {
            return passwordInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the Password input field is currently enabled.
     * 
     * @return true if Password input is enabled, false otherwise
     */
    public boolean isPasswordEnabled() {
        try {
            return passwordInput.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Validates if the Password input field is prepopulated with the expected value.
     * 
     * @param expectedValue Expected password value
     * @return true if field value matches expectedValue, false otherwise
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getPasswordValue());
    }

    /**
     * Checks if the Password input field has the HTML "required" attribute.
     * 
     * @return true if Password is required, false otherwise
     */
    public boolean isPasswordRequired() {
        try {
            String required = passwordInput.getAttribute("required");
            return required != null;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * SUBMIT BUTTON METHODS
     */

    /**
     * Clicks the Submit button after waiting for it to be visible and clickable.
     */
    public void clickSubmitButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(submitButton));
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            submitButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click Submit button", e);
        }
    }

    /**
     * Checks if the Submit button is currently displayed.
     * 
     * @return true if Submit button is displayed, false otherwise
     */
    public boolean isSubmitButtonDisplayed() {
        try {
            return submitButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the Submit button is currently enabled.
     * 
     * @return true if Submit button is enabled, false otherwise
     */
    public boolean isSubmitButtonEnabled() {
        try {
            return submitButton.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Returns the visible text on the Submit button.
     * 
     * @return Submit button text
     */
    public String getSubmitButtonText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(submitButton));
            return submitButton.getText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get Submit button text", e);
        }
    }

    /*
     * ERROR MESSAGE METHODS
     */

    /**
     * Checks if the error message element is visible on the page.
     * 
     * @return true if error message is visible, false otherwise
     */
    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessageDiv.isDisplayed() && errorMessageDiv.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Returns the text content of the error message.
     * 
     * @return The error message string or empty if not visible
     */
    public String getErrorMessageText() {
        try {
            if (isErrorMessageDisplayed()) {
                return errorMessageDiv.getText().trim();
            } else {
                return "";
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get error message text", e);
        }
    }

    /**
     * Asserts that the error message contains the expected text.
     * Throws AssertionError with message if it does not match.
     * 
     * @param expectedText Expected substring of the error message text
     */
    public void assertErrorMessageContains(String expectedText) {
        String actualText = getErrorMessageText();
        if (!actualText.contains(expectedText)) {
            throw new AssertionError(String.format("Error message '%s' does not contain expected text '%s'", actualText, expectedText));
        }
    }
}