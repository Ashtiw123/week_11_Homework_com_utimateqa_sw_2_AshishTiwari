package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Locating Sign in field through elements and clicking
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //Cross-checking  and validating Welcome Back label
        String expectedMessage = "Welcome Back!";
        driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));

    }

    @Test
    public void verifyTheErrorMessage() {
        //Locating and clicking Sign in field
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //Locating and inputting invalid email in email field using elements
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("ashtiw@gmail.com");
        //loacting and inputting password in password field
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("hello123");
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        signInButton.click();
        //cross-checking label
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid email or password is not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

