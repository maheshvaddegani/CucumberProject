package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.SearchTerm;

public class SearchPage {
    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@value='Google Search']")
    private WebElement btn_Search;

    @FindBy(how = How.XPATH, using = "//input[@class='gLFyf gsfi']")
    private WebElement txtbx_Search;

    public String get_SearchTerm(){
        return  txtbx_Search.getAttribute("value");
    }
}





