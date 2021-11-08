package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TeladocHomePage {
    public TeladocHomePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@class='btn btn-link pull-right']")
    public WebElement addButton;

    @FindBy(xpath = "/html/body/table/tbody//tr")
    public List<WebElement> numberOfRows;

    @FindBy(xpath = "//html/body/table/tbody//tr[1]/td[1]")
    public WebElement firstRowName;

    @FindBy(xpath = "//input[@class='pull-right ng-pristine ng-valid']")
    public WebElement searchBox;

}
