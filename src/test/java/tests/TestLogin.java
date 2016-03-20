package tests;

import categories.Critical;
import categories.Major;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.Login;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

public class TestLogin {
    private WebDriver driver;
    private Login login;

    @Before
    public void SetUp() {
        driver = new FirefoxDriver();
        login = new Login(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Category({Critical.class})
    @Test
    public void succesfullLogin() {
        login.with("seleniummz@gmail.com","seleniummz12345");
        assertTrue("element is not found",
                login.verifyLoginPage());
        login.logout();
        assertTrue("Not Logged Out",
                login.verifyLoggedOut());
    }

    @Category({Major.class})
    @Test
    public void succesfullSendAndReceive() {
        login.with("seleniummz@gmail.com","seleniummz12345");
        assertTrue("element is not found",
                login.verifyLoginPage());
        login.composeEmail("seleniummz@gmail.com","succesfullSendAndReceive Test Case","Any Text");
        login.openEmail();
        assertEquals("No Subject", "succesfullSendAndReceive Test Case",
                driver.findElement(By.cssSelector("h2[class='hP']")).getText());
        assertEquals("No Body Text", "Any Text",
                driver.findElement(By.cssSelector("div[class='adn ads'] div[dir='ltr']")).getText());
        login.deleteEmail();
        login.logout();


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
