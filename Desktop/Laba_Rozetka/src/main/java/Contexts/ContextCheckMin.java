package Contexts;

import PageObjects.MainPage;
import PageObjects.MainPage2;

import static org.junit.Assert.assertTrue;

public class ContextCheckMin {
    public ContextCheckMin() {
    }


    public static void checkMinTextField(MainPage mainPage , int price) {
        assertTrue(mainPage.checkMinimalPriceFilter(price));
}

    public static void CheckMinList(MainPage mainPage , int price) {
        assertTrue(mainPage.checkMinimalPriceList(price));
    }

    public static void checkMinTextFieldVersion2(MainPage2 mainPage , int price) {
        assertTrue(mainPage.checkMinimalPriceFilter(price));
    }

    public static void CheckMinListVersion2(MainPage2 mainPage , int price) {
        assertTrue(mainPage.checkMinimalPriceList(price));
    }
}
