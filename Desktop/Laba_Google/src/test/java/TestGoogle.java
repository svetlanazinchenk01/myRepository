
import Contexts.ContextMain;
import Contexts.ContextSearch;
import PageObjects.MainPage;
import Utility.Chrome;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TestGoogle {
    private static String driverPath = "C:\\Users\\User\\Desktop\\Laba_Google\\chromedriver.exe";
    public long timmme;

    @BeforeClass

    public static void setDriver(){

        Chrome.initialize(driverPath);
        Chrome.getDriver().manage().timeouts().implicitlyWait(800, MILLISECONDS);
        Chrome.getDriver().manage().window().maximize();
        Chrome.getDriver().manage().timeouts().pageLoadTimeout(15, SECONDS);

    }

    @Test
    public void TestSearchOnFirstPage() throws InterruptedException {
        timmme = System.currentTimeMillis();

            Chrome.getDriver().navigate().to("https://www.google.com");
            ContextSearch.ContextSearchLink(ContextMain.SearchGoogle(new MainPage() , "cats"), Boolean.FALSE, Boolean.TRUE,"Film","TestSearchOnFirstPage");
    }


    @Test
    public void TestSearchOnAnother() throws InterruptedException {

        Chrome.getDriver().navigate().to("https://www.google.com");
        ContextSearch.ContextSearchLink(ContextMain.SearchGoogle(new MainPage() , "cats"),Boolean.FALSE, Boolean.TRUE, "Cat & Kitten Food","TestSearchOnAnother");


    }

    @Test
    public void TestNotFound() throws InterruptedException {

        Chrome.getDriver().navigate().to("https://www.google.com");
        ContextSearch.ContextSearchLink(ContextMain.SearchGoogle(new MainPage() , "cats676"),Boolean.TRUE, Boolean.FALSE, "Cat & Kitten Food", "TestNotFound");

    }



    @AfterClass
    public static void quitDriver(){
        Chrome.getDriver().quit();
    }
}