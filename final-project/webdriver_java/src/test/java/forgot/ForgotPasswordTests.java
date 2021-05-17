package forgot;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPassword;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {
    @Test
    public void checkTitle() {
        ForgotPassword forgotPasswordPage = homePage.clickLogin().goForgotPassword();
        assertEquals(forgotPasswordPage.getTitleText(), "Մոռացել եք գաղտնաբառը?");
    }
}
