package PageObjects;


import org.openqa.selenium.support.PageFactory;

import Utility.Chrome;
import Utility.Decorator;


public class Page {
    public Page(){
        PageFactory.initElements(new Decorator(Chrome.getDriver()),this);
    }

}
