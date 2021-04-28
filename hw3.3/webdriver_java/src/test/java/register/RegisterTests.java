package register;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Register;

import static org.testng.Assert.assertEquals;

public class RegisterTests extends BaseTests {
    @Test
    public void checkTitle() {
        Register registerPage = homePage.clickLogin().goRegister();
        assertEquals(registerPage.getTitleText(), "Գրանցում");
    }
}
