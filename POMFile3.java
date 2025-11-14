package com.saucedemo.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model for LoginPage.
 * Provides reusable methods and validations for the Swag Labs login page.
 * This class encapsulates all elements, interactions, and verifications required on the login page.
 * 
 * Author: Test Automation Architect
 * Created: 2024-06-08
 * Purpose: Automate and validate login functionality on Swag Labs site.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constants
    private static final String PAGE_TITLE = "Swag Labs";
    private static final Duration TIMEOUT = Duration.ofSeconds(15);
    private static final Duration POLLING = Duration.ofMillis(500);

    // Locators (all elements on the login page)
    // Locator for username input field
    private By userNameInput = By.id("user-name");

    // Locator for password input field
    private By passwordInput = By.id("password");

    // Locator for login button
    private By loginButton = By.id("login-button");

    // Locator for error message container (when login fails)
    private By errorMessageContainer = By.cssSelector("div.error-message-container");

    // Locator for the login logo text "Swag Labs"
    private By loginLogo = By.className("login_logo");

    // Locator for accepted usernames label and texts block
    private By acceptedUsernamesText = By.xpath("//div[contains(@class,'login_credentials_wrap-inner')]");

    // Locator for password info label "Password for all users:"
    private By passwordInfoText = By.xpath("//div[contains(@class,'login_password')]");

    // Locator for root container
    private By rootDiv = By.id("root");

    /**
     * Constructor initializes WebDriver and WebDriverWait.
     * @param driver WebDriver instance passed from test class.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    // ************* Username Input Methods *************

    /**
     * Enters text into the username input field after waiting for it to be visible and enabled.
     * @param username The username to enter.
     */
    public void enterUserName(String username) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
            element.clear();
            element.sendKeys(username);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter username: " + e.getMessage());
        }
    }

    /**
     * Clears the username input field after waiting for it to be visible.
     */
    public void clearUserName() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            element.clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear username field: " + e.getMessage());
        }
    }

    /**
     * Gets the current value of the username input field.
     * @return The text currently entered in the username field.
     */
    public String getUserNameValue() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
            return element.getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get username value: " + e.getMessage());
        }
    }

    /**
     * Checks whether the username input field is displayed.
     * @return true if displayed, false otherwise.
     */
    public boolean isUserNameDisplayed() {
        try {
            return driver.findElement(userNameInput).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks whether the username input field is enabled.
     * @return true if enabled, false otherwise.
     */
    public boolean isUserNameEnabled() {
        try {
            return driver.findElement(userNameInput).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates if the username input field is prepopulated with the expected value.
     * @param expectedValue Expected username value.
     * @return true if prepopulated as expected, false otherwise.
     */
    public boolean isUserNamePrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getUserNameValue());
    }

    /**
     * Checks if the username input field is marked as required.
     * @return true if required, false otherwise.
     */
    public boolean isUserNameRequired() {
        try {
            WebElement element = driver.findElement(userNameInput);
            String required = element.getAttribute("required");
            return required != null && (required.equals("true") || required.equals("required"));
        } catch (Exception e) {
            return false;
        }
    }

    // ************* Password Input Methods *************

    /**
     * Enters text into the password input field after waiting for it to be visible and enabled.
     * @param password The password to enter.
     */
    public void enterPassword(String password) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
            element.clear();
            element.sendKeys(password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter password: " + e.getMessage());
        }
    }

    /**
     * Clears the password input field after waiting for it to be visible.
     */
    public void clearPassword() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            element.clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear password field: " + e.getMessage());
        }
    }

    /**
     * Gets the current value of the password input field.
     * @return The text currently entered in the password field.
     */
    public String getPasswordValue() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            return element.getAttribute("value");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get password value: " + e.getMessage());
        }
    }

    /**
     * Checks whether the password input field is displayed.
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
     * Checks whether the password input field is enabled.
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
     * Validates if the password input field is prepopulated with the expected value.
     * @param expectedValue Expected password value.
     * @return true if prepopulated as expected, false otherwise.
     */
    public boolean isPasswordPrepopulatedWith(String expectedValue) {
        return expectedValue.equals(getPasswordValue());
    }

    /**
     * Checks if the password input field is marked as required.
     * @return true if required, false otherwise.
     */
    public boolean isPasswordRequired() {
        try {
            WebElement element = driver.findElement(passwordInput);
            String required = element.getAttribute("required");
            return required != null && (required.equals("true") || required.equals("required"));
        } catch (Exception e) {
            return false;
        }
    }

    // ************* Login Button Methods *************

    /**
     * Clicks the login button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            element.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click login button: " + e.getMessage());
        }
    }

    /**
     * Checks whether the login button is displayed.
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
     * Checks whether the login button is enabled.
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
     * Returns the visible text on the login button.
     * @return Text of the login button.
     */
    public String getLoginButtonText() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            return element.getText();
        } catch (Exception e) {
            return "";
        }
    }

    // ************* Error Message Container Methods *************

    /**
     * Checks whether the error message container is visible on the page.
     * @return true if visible, false otherwise.
     */
    public boolean isErrorMessageVisible() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContainer));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves the error message text displayed in the error message container.
     * @return Error message text.
     */
    public String getErrorMessageText() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContainer));
            return element.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Waits for the error message container to disappear (useful after error is handled).
     */
    public void waitForErrorMessageToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(errorMessageContainer));
        } catch (Exception e) {
            // Do nothing, error message did not disappear within timeout
        }
    }

    // ************* Static Text Elements Methods *************

    /**
     * Checks if the login logo text "Swag Labs" is displayed.
     * @return true if displayed, false otherwise.
     */
    public boolean isLoginLogoDisplayed() {
        try {
            return driver.findElement(loginLogo).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the text content of the login logo.
     * @return Login logo text.
     */
    public String getLoginLogoText() {
        try {
            WebElement element = driver.findElement(loginLogo);
            return element.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the accepted usernames informational text.
     * @return Complete block of accepted usernames text.
     */
    public String getAcceptedUsernamesText() {
        try {
            WebElement element = driver.findElement(acceptedUsernamesText);
            return element.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the password info text displayed on the page.
     * @return Password info text.
     */
    public String getPasswordInfoText() {
        try {
            WebElement element = driver.findElement(passwordInfoText);
            return element.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the root container text content generally including main login page text.
     * @return Root container text.
     */
    public String getRootDivText() {
        try {
            WebElement element = driver.findElement(rootDiv);
            return element.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    // ************* Page-level Utility Methods *************

    /**
     * Waits for the login page to load by ensuring key elements are visible and page title is correct.
     */
    public void waitForPageToLoad() {
        // Wait for username input, password input, login button and logo to be visible
        wait.until(ExpectedConditions.titleIs(PAGE_TITLE));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLogo));
    }

    /**
     * Verifies that the login page is currently displayed by checking title and visibility of key elements.
     * @return true if page is displaying correctly, false otherwise.
     */
    public boolean isPageDisplaying() {
        try {
            boolean titleMatches = driver.getTitle().equals(PAGE_TITLE);
            boolean userNameDisplayed = isUserNameDisplayed();
            boolean passwordDisplayed = isPasswordDisplayed();
            boolean loginBtnDisplayed = isLoginButtonDisplayed();
            boolean logoDisplayed = isLoginLogoDisplayed();
            return titleMatches && userNameDisplayed && passwordDisplayed && loginBtnDisplayed && logoDisplayed;
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
     * Asserts that the current page URL matches the expected URL.
     * Throws RuntimeException if URL does not match.
     * @param expectedURL The expected URL string.
     */
    public void assertPageURL(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        if (!currentURL.equals(expectedURL)) {
            throw new RuntimeException("Expected URL: " + expectedURL + " but found: " + currentURL);
        }
    }
}