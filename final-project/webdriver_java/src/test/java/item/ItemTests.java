package item;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.Item;

import static org.testng.Assert.*;

public class ItemTests extends BaseTests {
    @Test
    public void checkModal() {
        Item itemPage = homePage.clickCategory().clickItem();
        itemPage.clickImage();
        assertEquals(itemPage.modalExists(), true);
    }

    @Test
    public void checkArrows() {
        Item itemPage = homePage.clickCategory().clickItem();
        int imgCount = itemPage.imageCount();

        assertEquals(itemPage.arrowExists(), imgCount > 1);
    }
}
