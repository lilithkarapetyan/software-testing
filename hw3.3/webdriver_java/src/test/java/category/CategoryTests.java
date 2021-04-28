package category;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.Category;

import static org.testng.Assert.*;

public class CategoryTests extends BaseTests {

    @Test
    public void checkSubNavText(){
        Category categoryPage = homePage.clickCategory();
        assertEquals(categoryPage.getNavElementText(), "Բոլոր բաժինները");
    }

    @Test
    public void checkSidebar(){
        Category categoryPage = homePage.clickCategory();
        assertTrue(categoryPage.sidebarExists());
    }

    @Test
    public void checkFilterOffers() {
        Category categoryPage = homePage.clickCategory();
        categoryPage.clickFilterOffer();
        assertFalse(categoryPage.priceFilterExists());
    }
}
