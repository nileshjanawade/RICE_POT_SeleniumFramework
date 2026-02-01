package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test(priority = 1)
    public void testInvalidCredentials() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("wrong_user@test.com", "wrong_pass");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for wrong credentials");
            Assert.assertTrue(loginPage.getErrorMessage().contains("check your username and password"));
        } catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testEmptyCredentials() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("", "");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for empty credentials");
        } catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testValidUserInvalidPassword() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("valid_user@salesforce.com", "wrong_pass");
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for wrong password");
        } catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
    }
}
