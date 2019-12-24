package Contexts;

import PageObjects.SearchPage;

import java.io.IOException;

import static org.junit.Assert.assertTrue;


public class ContextSearch {
    private ContextSearch(){}
    public static void ContextSearchLink(SearchPage page, Boolean screenAllPage, Boolean foundOrNot, String contains , String testName)  {
        try {

            assertTrue(foundOrNot ? page.SearchLink(contains, screenAllPage, testName) : !page.SearchLink(contains, screenAllPage, testName));

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(page.PrintScreen(testName));
    }
}



