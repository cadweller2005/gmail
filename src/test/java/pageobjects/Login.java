package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class Login {

    WebDriver driver;

    By usernameLocator = By.id("Email");
    By nextButtonLoginFlow = By.id("next");
    By passwordLocator = By.id("Passwd");
    By signInButton = By.id("signIn");
    By verifyLoginPageLocator = By.id(":2m");
    //By clickOnAccountButton = By.cssSelector(".gb_1a.gbii");
    By clickOnAccountButton = By.xpath("//a [@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']");
    By clickOnSignOut = By.id("gb_71");
    By verifyLoggedOutLocator = By.cssSelector(".logo-strip");
    By clickOnCompose = By.cssSelector("div[role='button'][gh='cm']");
    By enterEmailAddress = By.className("vO");
    By enterSubject = By.name("subjectbox");
    By enterBody = By.cssSelector("div[aria-label='Message Body']");
    By clickOnSend = By.cssSelector("div[aria-label*='Send']");
    By clickOnInbox = By.xpath("//a [@href='https://mail.google.com/mail/#inbox']");
    //By clickOnInbox = By.partialLinkText("Inbox (1)");
    By clickOnNewlyReceivedEmail = By.cssSelector(".yX.xY");
    By deleteEmail = By.xpath("//*[@id=':5']/div[2]/div[1]/div/div[2]/div[3]");


    public Login (WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://gmail.com");
    }

    public void with (String username, String password) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(nextButtonLoginFlow).click();
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(signInButton).click();
            }

    public void logout () {
        driver.findElement(clickOnAccountButton).click();
        driver.findElement(clickOnSignOut).click();
    }

    public void composeEmail (String email, String subject, String body) {
        driver.findElement(clickOnCompose).click();
        driver.findElement(enterEmailAddress).sendKeys(email);
        driver.findElement(enterSubject).sendKeys(subject);
        driver.findElement(enterBody).sendKeys(body);
        driver.findElement(clickOnSend).click();
    }

    public void openEmail () {
        driver.findElement(clickOnInbox).click();
        driver.findElement(clickOnNewlyReceivedEmail).click();
            }

    public void deleteEmail () {
        driver.findElement(deleteEmail).click();
            }

    public Boolean verifyLoginPage () {
        return driver.findElement(verifyLoginPageLocator).isDisplayed();
    }

    public Boolean verifyLoggedOut () {
        return driver.findElement(verifyLoggedOutLocator).isDisplayed();
    }


}
