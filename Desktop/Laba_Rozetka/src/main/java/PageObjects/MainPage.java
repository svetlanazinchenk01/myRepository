package PageObjects;

import Elements.*;
import Utility.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends Page {

    @FindBy(xpath = "//html//body//app-root//div//div//rz-catalog//div//main//ivv-catalog//div//div//ivv-selected-filters//div//ul//li//a")
    public Link FilterPrice;

    @FindBy(xpath = "//body//ivv-filter-slider//input[1]")
    public TextField MinimalPrice;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    public Button ok;

    @FindBy(xpath = "//li//app-goods-tile[1]//app-goods-tile-default[1]//div[1]//div[2]//div[4]//div[2]//p")
    public List<WebElement> ListPrice;


    public MainPage(){
        super();
    }

    public int getMinimalPrice(){
        return Integer.parseInt(MinimalPrice.getText());
    }

    public MainPage setMinimalPrice(int price){

        MinimalPrice.clear();
        String priceString = Integer.toString(price);
        MinimalPrice.input(priceString,true);

        return this;
    }



    public boolean checkMinimalPriceFilter(int price){
        Waiter.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[name='goods_list'")));

        String text = FilterPrice.getText();
        String[] maxMin = text.split("[₴-]+");

        return maxMin[0].equals(Integer.toString(price));
    }


    public boolean checkMinimalPriceList(int price){
        Waiter.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[name='goods_list'")));

        for(WebElement i : ListPrice) {
            String text = i.getText().replaceAll("[^0-9]","");
            if (Integer.parseInt(text)<price){
                return false;
            }
        }
        return true;

    }

    public MainPage submit(){

        ok.click();
        return this;
    }

}