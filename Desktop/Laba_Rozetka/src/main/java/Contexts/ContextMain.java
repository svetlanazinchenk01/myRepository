package Contexts;

import PageObjects.MainPage;
import PageObjects.MainPage2;


public class ContextMain {
    private ContextMain(){}
    public static MainPage setFilterPrice(MainPage mainpage , int minimal)  {
        mainpage=mainpage.setMinimalPrice(minimal);
        return mainpage.submit();
    }

    public static MainPage2 setFilterPrice(MainPage2 mainpage , int minimal)  {
        mainpage=mainpage.setMinimalPrice(minimal);
        return mainpage.submit();
    }
}