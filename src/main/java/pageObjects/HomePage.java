package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "q")
    private WebElement txtbx_Search;

    @FindBy(how = How.ID, using = "L2AGLb")
    private WebElement btn_IAgree;

    public void navigateTo_HomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void enter_SearchTerm(String searchTerm) {
        txtbx_Search.sendKeys(searchTerm);
    }

    public void click_googleSearch() {
        txtbx_Search.sendKeys(Keys.ENTER);
    }

    public void click_IAgree() {
        btn_IAgree.click();
    }
}
