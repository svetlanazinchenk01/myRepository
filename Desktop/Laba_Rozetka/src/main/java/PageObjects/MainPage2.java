package PageObjects;

import Elements.*;
import Utility.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage2 extends Page {

    @FindBy(xpath = "//a[@class='filter-active-i-link blacklink sprite-side']")
    public Link FilterPrice;

    @FindBy(id = "price[min]")
    public TextField MinimalPrice;

    @FindBy(id = "submitprice")
    public Button ok;

    @FindBy(className = "g-price-uah")
    public List<WebElement>  ListPrise;


    public MainPage2(){
        super();
    }

    public int getMinimalPrice(){
        return Integer.parseInt(MinimalPrice.getText());
    }

    public MainPage2 setMinimalPrice(int price){

        Waiter.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloader_type_element")));

        String priceString = Integer.toString(price);
        MinimalPrice.input(priceString,true);
        return this;
    }


    public boolean checkMinimalPriceFilter(int price){
        Waiter.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloader_type_element")));

        String text = FilterPrice.getText();
        text=text.replaceAll("до", "-");
        text=text.replaceAll("[^0-9-]","");
        String[] maxMin = text.split("[₴ -]+");

        return maxMin[0].equals(Integer.toString(price));
    }


    public boolean checkMinimalPriceList(int price){

        Waiter.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloader_type_element")));

        System.out.println(ListPrise.size());
        for(WebElement i : ListPrise) {
            String text = i.getText().replaceAll("[^0-9]","");
            if (Integer.parseInt(text)<price){
                return false;
            }
        }
        return true;

    }
    public MainPage2 submit(){

        ok.click();
        return this;
    }

}