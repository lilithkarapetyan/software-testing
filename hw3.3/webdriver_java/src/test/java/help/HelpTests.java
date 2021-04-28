package help;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.Help;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HelpTests extends BaseTests {

    @Test
    public void checkSubNavText(){
        Help helpPage = homePage.clickHelp();
        assertEquals(helpPage.getNavElementText(), "Տեղեկանք");
    }

    @Test
    public void checkContent(){
        Help helpPage = homePage.clickHelp();
        assertTrue(helpPage.contentExists());
    }
}
