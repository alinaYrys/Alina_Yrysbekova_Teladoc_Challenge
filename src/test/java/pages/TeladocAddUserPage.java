package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TeladocAddUserPage {
    public TeladocAddUserPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement userName1;


    @FindBy(xpath = "//input[@name='Password']")
    public WebElement password1;

    @FindBy(xpath = "//input[@value='16']")
    public WebElement radioButton;

    @FindBy(xpath = "//select[@name='RoleId']")
    public WebElement dropDown;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@name='Mobilephone']")
    public WebElement cellPhone;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement saveButton;

    @FindBy(xpath = "//table/tbody/tr[3]")
    public List<WebElement> oneRowData;

    @FindBy(xpath = "//tbody/tr[3]/td[11]/button/i")
    public WebElement deleteButton;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public WebElement newUserName;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    public WebElement okButton;

    @FindBy(xpath = "/html/body/table/tbody")
    public List<WebElement> afterDeletingCustomerTable;


}
