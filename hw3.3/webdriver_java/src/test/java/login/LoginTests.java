package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.Login;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    @Test
    public void checkLogin(){
        Login loginPage = homePage.clickLogin();
        loginPage.setEmailField("aaa");
        loginPage.setPasswordField("bbb");
        loginPage.submit();
        assertTrue(loginPage.errorExists());
    }
}
