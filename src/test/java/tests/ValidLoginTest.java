package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ValidLoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("valid_username@salesforce.com", "valid_password123");
            // Assuming successful login redirects to home page or similar
            Assert.assertTrue(driver.getCurrentUrl().contains("home"), "Login was not successful");
        } catch (Exception e) {
            Assert.fail("Valid login test failed: " + e.getMessage());
        }
    }
}
