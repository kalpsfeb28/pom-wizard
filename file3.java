package com.dhl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

/**
 * Page Object Model for DHL Post & DHL App Page.
 * Provides reusable methods and validations for this page at:
 * https://www.dhl.de/en/privatkunden/kampagnenseiten/dhl-app.html#
 *
 * This page contains informational sections about the DHL Post & DHL App,
 * main navigation, secondary navigation (Private Customers, Business Customer),
 * various app download and feature links, FAQs accordion, and footer navigation.
 *
 * Author: Test Automation Architect
 * Created: 2025-11-11
 * Purpose: Automate interactions and validations for DHL Post & DHL App landing page.
 */
public class DhlPostDhlAppPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // TIMEOUTS
    private static final int TIMEOUT_SECONDS = 15;

    // Locators

    // === Navigations ===

    // Secondary navigation links
    private final By privateCustomersLink = By.cssSelector("nav.secondary-navigation a.secondary-navigation__link.secondary-navigation__link--active");
    private final By businessCustomerLink = By.cssSelector("nav.secondary-navigation a.secondary-navigation__link:not(.secondary-navigation__link--active)");

    // Primary navigation container with bonus-points init data attribute
    private final By primaryNavigation = By.cssSelector("nav.primary-navigation.bonus-points__init");

    // Link for "Login" or "Logout" text inside primary navigation
    private final By userMenuLoginLogoutLink = By.cssSelector("a.primary-navigation__link.user-menu__button");

    // Navigation links by text (Shipping parcels, Delivery services, Customer Service)
    private final By shippingParcelsNavLink = By.xpath("//div[contains(@class,'primary-navigation__link-hover') and contains(text(),'Shipping parcels')]");
    private final By deliveryServicesNavLink = By.xpath("//div[contains(@class,'primary-navigation__link-hover') and contains(text(),'Delivery services')]");
    private final By customerServiceNavLink = By.xpath("//a[@class='primary-navigation__link' and contains(text(),'Customer Service')]");

    // Search link in the primary navigation
    private final By startSearchNavLink = By.cssSelector("a.primary-navigation__link.searchslot__link[aria-label='Start search']");

    // Language selection current option English
    private final By languageSelectionCurrentEN = By.cssSelector("a.lang__option.lang__option--current[aria-label='Language selection English']");

    // === Main Stage Section ===

    // Stage main container
    private final By stageContainer = By.cssSelector("div.container.stage-area div.stage");

    // Stage item link with info about "Post & DHL app"
    private final By postDhlAppLink = By.cssSelector("a.stage-item__link");

    // Title H1 text "Post & DHL app"
    private final By postDhlAppTitle = By.cssSelector("h1.stage-item__title.text--inversive");

    // Subtitle text of stage item
    private final By postDhlAppSubtitle = By.cssSelector("div.stage-item__text.text--inversive");

    // Download now button in the stage item
    private final By downloadNowButton = By.cssSelector("div.stage-item__cta.btn.btn--primary.btn--large");

    // === Benefits Section ===

    // Header of benefits section
    private final By benefitsHeader = By.xpath("//h2[contains(text(),'Enjoy even more benefits')]");

    // Register Now primary button
    private final By registerNowButton = By.cssSelector("a.btn.btn--primary.btn--large");

    // === NEW: My stamps in the app Section ===

    // Header of "NEW: My stamps in the app"
    private final By myStampsHeader = By.xpath("//h2[contains(text(),'NEW: My stamps in the app')]");

    // "Here's how it works" link (secondary button style)
    private final By myStampsHowItWorksLink = By.cssSelector("a.rtf-btn--secondary");

    // === Download Section ===

    // Header text for download section
    private final By downloadAppHeader = By.xpath("//h2[contains(text(),'Download the Post & DHL app for free')]");

    // Link with id "downloads" (perhaps app download anchors container)
    private final By downloadsLink = By.id("downloads");

    // === FAQ Section ===

    // FAQ main header
    private final By faqHeader = By.xpath("//h2[text()='FAQs']");

    // Accordion container for FAQs by id
    private final By faqAccordion = By.id("accordion-88882e08-3b6f-4716-aefa-44844a2c1bab");

    // Accordion item headers by accordion item__header class
    private final By faqAccordionItemHeaders = By.cssSelector(".accordion-item__header");

    // === Footer Navigation ===

    private final By footerNavigation = By.cssSelector("nav.row.footer__row-navigation");
    private final By footerLinks = By.cssSelector("nav.row.footer__row-navigation a");

    /**
     * Constructor for DhlPostDhlAppPage.
     *
     * @param driver WebDriver instance to interact with browser.
     */
    public DhlPostDhlAppPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
    }

    // ===========================
    // Navigation Related Methods
    // ===========================

    /**
     * Clicks the Private Customers link in secondary navigation.
     */
    public void clickPrivateCustomersLink() {
        waitUntilVisible(privateCustomersLink);
        driver.findElement(privateCustomersLink).click();
    }

    /**
     * Checks if Private Customers link is displayed in secondary navigation.
     *
     * @return true if displayed, else false
     */
    public boolean isPrivateCustomersLinkDisplayed() {
        return isElementDisplayed(privateCustomersLink);
    }

    /**
     * Clicks the Business Customer link in secondary navigation.
     */
    public void clickBusinessCustomerLink() {
        waitUntilVisible(businessCustomerLink);
        driver.findElement(businessCustomerLink).click();
    }

    /**
     * Checks if Business Customer link is displayed in secondary navigation.
     *
     * @return true if displayed, else false
     */
    public boolean isBusinessCustomerLinkDisplayed() {
        return isElementDisplayed(businessCustomerLink);
    }

    /**
     * Clicks the Shipping Parcels link in primary navigation.
     */
    public void clickShippingParcelsNavLink() {
        waitUntilVisible(shippingParcelsNavLink);
        driver.findElement(shippingParcelsNavLink).click();
    }

    /**
     * Gets the text of the Shipping Parcels navigation link.
     *
     * @return Text of Shipping Parcels link.
     */
    public String getShippingParcelsNavText() {
        waitUntilVisible(shippingParcelsNavLink);
        return driver.findElement(shippingParcelsNavLink).getText().trim();
    }

    /**
     * Clicks the Delivery Services link in primary navigation.
     */
    public void clickDeliveryServicesNavLink() {
        waitUntilVisible(deliveryServicesNavLink);
        driver.findElement(deliveryServicesNavLink).click();
    }

    /**
     * Gets the text of the Delivery Services navigation link.
     *
     * @return Text of Delivery Services link.
     */
    public String getDeliveryServicesNavText() {
        waitUntilVisible(deliveryServicesNavLink);
        return driver.findElement(deliveryServicesNavLink).getText().trim();
    }

    /**
     * Clicks the Customer Service link in primary navigation.
     */
    public void clickCustomerServiceNavLink() {
        waitUntilVisible(customerServiceNavLink);
        driver.findElement(customerServiceNavLink).click();
    }

    /**
     * Gets the text of the Customer Service navigation link.
     *
     * @return Text of Customer Service link.
     */
    public String getCustomerServiceNavText() {
        waitUntilVisible(customerServiceNavLink);
        return driver.findElement(customerServiceNavLink).getText().trim();
    }

    /**
     * Clicks the Start Search link in primary navigation.
     */
    public void clickStartSearchLink() {
        waitUntilVisible(startSearchNavLink);
        driver.findElement(startSearchNavLink).click();
    }

    /**
     * Gets the text of Start Search navigation link.
     *
     * @return Text of Start Search link.
     */
    public String getStartSearchText() {
        waitUntilVisible(startSearchNavLink);
        return driver.findElement(startSearchNavLink).getText().trim();
    }

    /**
     * Clicks login/logout user menu button.
     */
    public void clickUserMenuLoginLogout() {
        waitUntilVisible(userMenuLoginLogoutLink);
        driver.findElement(userMenuLoginLogoutLink).click();
    }

    /**
     * Gets displayed user menu login/logout text.
     *
     * @return Text of user menu login/logout link.
     */
    public String getUserMenuLoginLogoutText() {
        waitUntilVisible(userMenuLoginLogoutLink);
        return driver.findElement(userMenuLoginLogoutLink).getText().trim();
    }

    /**
     * Checks if language selection current English option is displayed.
     *
     * @return true if displayed, else false
     */
    public boolean isLanguageSelectionCurrentENDisplayed() {
        return isElementDisplayed(languageSelectionCurrentEN);
    }

    // ===========================
    // Stage Section Methods
    // ===========================

    /**
     * Gets the text of the main Post & DHL app title (H1).
     *
     * @return Title text.
     */
    public String getPostDhlAppTitleText() {
        waitUntilVisible(postDhlAppTitle);
        return driver.findElement(postDhlAppTitle).getText().trim();
    }

    /**
     * Gets the subtitle text below the main title.
     *
     * @return Subtitle text.
     */
    public String getPostDhlAppSubtitleText() {
        waitUntilVisible(postDhlAppSubtitle);
        return driver.findElement(postDhlAppSubtitle).getText().trim();
    }

    /**
     * Clicks the "Download now" call-to-action button.
     */
    public void clickDownloadNowButton() {
        waitUntilClickable(downloadNowButton);
        driver.findElement(downloadNowButton).click();
    }

    /**
     * Checks if the Download Now button is displayed.
     *
     * @return true if displayed, else false
     */
    public boolean isDownloadNowButtonDisplayed() {
        return isElementDisplayed(downloadNowButton);
    }

    // ===========================
    // Benefits Section Methods
    // ===========================

    /**
     * Gets the header text "Enjoy even more benefits in the app with the free DHL customer account".
     *
     * @return Benefits header text.
     */
    public String getBenefitsHeaderText() {
        waitUntilVisible(benefitsHeader);
        return driver.findElement(benefitsHeader).getText().trim();
    }

    /**
     * Clicks the Register Now primary button.
     */
    public void clickRegisterNowButton() {
        waitUntilClickable(registerNowButton);
        driver.findElement(registerNowButton).click();
    }

    /**
     * Checks if the Register Now button is displayed.
     *
     * @return true if displayed, else false
     */
    public boolean isRegisterNowButtonDisplayed() {
        return isElementDisplayed(registerNowButton);
    }

    // ===========================
    // My Stamps Section Methods
    // ===========================

    /**
     * Gets the header text "NEW: My stamps in the app".
     *
     * @return My Stamps header text.
     */
    public String getMyStampsHeaderText() {
        waitUntilVisible(myStampsHeader);
        return driver.findElement(myStampsHeader).getText().trim();
    }

    /**
     * Clicks the "Here's how it works" link.
     */
    public void clickMyStampsHowItWorksLink() {
        waitUntilClickable(myStampsHowItWorksLink);
        driver.findElement(myStampsHowItWorksLink).click();
    }

    /**
     * Gets the text of the "Here's how it works" link.
     *
     * @return Text content of the link.
     */
    public String getMyStampsHowItWorksText() {
        waitUntilVisible(myStampsHowItWorksLink);
        return driver.findElement(myStampsHowItWorksLink).getText().trim();
    }

    // ===========================
    // Download Section Methods
    // ===========================

    /**
     * Gets the header text for download section.
     *
     * @return Download section header text.
     */
    public String getDownloadAppHeaderText() {
        waitUntilVisible(downloadAppHeader);
        return driver.findElement(downloadAppHeader).getText().trim();
    }

    /**
     * Clicks the downloads link if visible.
     */
    public void clickDownloadsLink() {
        if (isElementDisplayed(downloadsLink)) {
            driver.findElement(downloadsLink).click();
        }
    }

    // ===========================
    // FAQ Section Methods
    // ===========================

    /**
     * Gets the main FAQ header text.
     *
     * @return FAQ header text.
     */
    public String getFaqHeaderText() {
        waitUntilVisible(faqHeader);
        return driver.findElement(faqHeader).getText().trim();
    }

    /**
     * Expands a FAQ accordion item by its header text.
     *
     * @param headerText The exact header text of the FAQ to expand.
     */
    public void expandFaqItemByHeader(String headerText) {
        // Find all headers, expand the one that matches text provided
        waitUntilVisible(faqAccordion);
        var headers = driver.findElements(faqAccordionItemHeaders);
        boolean found = false;
        for (WebElement header : headers) {
            if (header.getText().trim().equalsIgnoreCase(headerText)) {
                if (header.getAttribute("class").contains("collapsed")) {
                    header.click();
                    wait.until(ExpectedConditions.attributeContains(header, "class", "show"));
                }
                found = true;
                break;
            }
        }
        assertTrue("FAQ header with text '" + headerText + "' not found", found);
    }

    /**
     * Checks if a FAQ item is expanded by its header text.
     *
     * @param headerText The header text of the FAQ item.
     * @return true if expanded, false otherwise.
     */
    public boolean isFaqItemExpanded(String headerText) {
        waitUntilVisible(faqAccordion);
        var headers = driver.findElements(faqAccordionItemHeaders);
        for (WebElement header : headers) {
            if (header.getText().trim().equalsIgnoreCase(headerText)) {
                return !header.getAttribute("class").contains("collapsed");
            }
        }
        return false;
    }

    // ===========================
    // Footer Navigation Methods
    // ===========================

    /**
     * Checks if footer navigation is displayed.
     *
     * @return true if displayed else false.
     */
    public boolean isFooterNavigationDisplayed() {
        return isElementDisplayed(footerNavigation);
    }

    /**
     * Clicks a footer navigation link by visible text.
     *
     * @param linkText Exact visible text of the footer link.
     */
    public void clickFooterLinkByText(String linkText) {
        waitUntilVisible(footerNavigation);
        var links = driver.findElements(footerLinks);
        boolean clicked = false;
        for (WebElement link : links) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                link.click();
                clicked = true;
                break;
            }
        }
        assertTrue("Footer link with text '" + linkText + "' not found.", clicked);
    }

    /**
     * Gets text of a footer link by visible text.
     *
     * @param linkText Exact visible text of the footer link.
     * @return The text of the found footer link.
     */
    public String getFooterLinkTextByText(String linkText) {
        waitUntilVisible(footerNavigation);
        var links = driver.findElements(footerLinks);
        for (WebElement link : links) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                return link.getText().trim();
            }
        }
        return null;
    }

    // ===========================
    // Page Level Utility Methods
    // ===========================

    /**
     * Waits for the main elements of the page to load.
     */
    public void waitForPageToLoad() {
        waitUntilVisible(postDhlAppTitle);
        waitUntilVisible(downloadNowButton);
        waitUntilVisible(privateCustomersLink);
        waitUntilVisible(businessCustomerLink);
    }

    /**
     * Checks if the page is displaying by validating presence of key elements.
     *
     * @return true if page is displayed, else false.
     */
    public boolean isPageDisplaying() {
        try {
            return isElementDisplayed(postDhlAppTitle)
                    && isElementDisplayed(downloadNowButton)
                    && isElementDisplayed(privateCustomersLink)
                    && isElementDisplayed(businessCustomerLink);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the page title as seen by WebDriver.
     *
     * @return Page title string.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Asserts that the current page URL matches the expected URL.
     *
     * @param expectedURL The expected URL to verify.
     */
    public void assertPageURL(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        assertTrue("Expected URL to contain '" + expectedURL + "' but was '" + actualURL + "'",
                actualURL.contains(expectedURL));
    }

    // ===========================
    // Private Helper Methods
    // ===========================

    /**
     * Waits until the given locator is visible on the page.
     *
     * @param locator The locator of the element to wait for.
     */
    private void waitUntilVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until the given locator is clickable.
     *
     * @param locator The locator of the element to wait to be clickable.
     */
    private void waitUntilClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Checks if element specified by locator is displayed on the page.
     *
     * @param locator Locator to find element.
     * @return true if displayed; false otherwise.
     */
    private boolean isElementDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}