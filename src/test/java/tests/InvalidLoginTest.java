package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void testInvalidLogin() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("invalid_user@test.com", "wrong_password");
            String error = loginPage.getErrorMessage();
            Assert.assertTrue(error.contains("check your username and password"), "Error message not displayed or incorrect");
        } catch (Exception e) {
            Assert.fail("Invalid login test failed: " + e.getMessage());
        }
    }
}
