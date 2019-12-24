

import Contexts.ContextCheckMin;
import Contexts.ContextMain;

import PageObjects.MainPage2;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import PageObjects.MainPage;
import Utility.Chrome;
import org.openqa.selenium.By;


import static java.util.concurrent.TimeUnit.SECONDS;


public class TestRozetka {
    private static String driverPath = "C:\\Users\\User\\Desktop\\Laba_Rozetka\\chromedriver.exe";



    @BeforeClass
    public static void setDriver(){
        Chrome.initialize(driverPath);
        Chrome.getDriver().manage().timeouts().implicitlyWait(20, SECONDS);
        Chrome.getDriver().manage().window().maximize();
        Chrome.getDriver().manage().timeouts().pageLoadTimeout(30, SECONDS);
    }

    @Test
    public void testCheckMinFilter() throws InterruptedException {

        Chrome.getDriver().navigate().to("https://rozetka.com.ua/3d_glasses/c131143/");

        if (Chrome.getDriver().findElements(By.name("splash-button-enable")).isEmpty()) {
            ContextCheckMin.checkMinTextField(ContextMain.setFilterPrice(new MainPage(), 600), 600);
        }
        else {
            ContextCheckMin.checkMinTextFieldVersion2(ContextMain.setFilterPrice(new MainPage2(), 600), 600);
        }
    }

    @Test
    public void testCheckMinPriceList() throws InterruptedException {
        Chrome.getDriver().navigate().to("https://rozetka.com.ua/3d_glasses/c131143/");
        if (Chrome.getDriver().findElements(By.name("splash-button-enable")).isEmpty()) {

            ContextCheckMin.CheckMinList(ContextMain.setFilterPrice(new MainPage(), 600), 600);
        }
        else {

            ContextCheckMin.CheckMinListVersion2(ContextMain.setFilterPrice(new MainPage2(), 600), 600);
        }
    }



        @AfterClass
        public static void quitDriver(){
            Chrome.getDriver().quit();
        }

}