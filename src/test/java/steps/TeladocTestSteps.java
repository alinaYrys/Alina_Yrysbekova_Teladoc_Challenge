package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TeladocAddUserPage;
import pages.TeladocHomePage;
import pages.TeladocSearchPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class TeladocTestSteps {
    WebDriver driver  = Driver.getDriver();
    TeladocHomePage teladocHomePage=new TeladocHomePage();
    TeladocAddUserPage teladocAddUserPage=new TeladocAddUserPage();
    TeladocSearchPage teladocSearchPage=new TeladocSearchPage();
    List<Map<String,Object>> data;
    int sizeOfRowsBefore;
    @Given("user navigates to WebTable App")
    public void user_navigates_to_WebTable_App() {
        driver.get(ConfigReader.getProperty("TeleDocAppURL1"));
    }

    @Given("user counts number of users in table")
    public void user_counts_number_of_users_in_table() {
        sizeOfRowsBefore=teladocHomePage.numberOfRows.size();
    }

    @Given("user clicks on Add User button")
    public void user_clicks_on_Add_User_button() {
        teladocHomePage.addButton.click();
    }

    @Given("user provides all data")
    public void user_provides_all_data(DataTable dataTable) {
        data=dataTable.asMaps(String.class,Object.class);
        teladocAddUserPage.firstName.sendKeys(data.get(0).get("firstName").toString());
        teladocAddUserPage.lastName.sendKeys(data.get(0).get("lastName").toString());
        teladocAddUserPage.userName1.sendKeys(data.get(0).get("userName").toString());
        teladocAddUserPage.password1.sendKeys(data.get(0).get("password").toString());
        teladocAddUserPage.radioButton.click();
        teladocAddUserPage.emailAddress.sendKeys(data.get(0).get("email").toString());
        BrowserUtils.selectByValue(teladocAddUserPage.dropDown,data.get(0).get("role").toString());
        teladocAddUserPage.cellPhone.sendKeys(data.get(0).get("cellPhone").toString());

    }

    @When("user fill the data and clicks save button")
    public void user_fill_the_data_and_clicks_save_button() {
        teladocAddUserPage.saveButton.click();

    }

    @Then("user validates data added in the List of Users")
    public void user_validates_data_added_in_the_List_of_Users() {
         /*
        1st Assertion is based on size before and after creating a user it increases to 1
         */
        int numberOfRowsAfterCreation=teladocHomePage.numberOfRows.size();
        Assert.assertEquals(numberOfRowsAfterCreation-sizeOfRowsBefore,1);
        /*
        2nd Assertion is after creating a user new user  appears in 1st row of the table
         */
        Assert.assertEquals(data.get(0).get("firstName").toString(),teladocHomePage.firstRowName.getText());
        /*
        3rd Assertion is based on search box after creation of user the user search for created data and validates that is appearing in search
         */
        teladocHomePage.searchBox.sendKeys(data.get(0).get("firstName").toString());
        Assert.assertEquals(data.get(0).get("firstName").toString(),teladocHomePage.firstRowName.getText());
        Assert.assertEquals(data.get(0).get("userName").toString(),teladocAddUserPage.newUserName.getText());


    }
    @Given("user clicks delete button and deletes username novak")
    public void user_clicks_delete_button_and_deletes_username_novak() {
        teladocAddUserPage.deleteButton.click();
        teladocAddUserPage.okButton.click();

    }

    @Then("user validates that  userName {string} and user  has been deleted")
    public void user_validates_that_userName_and_user_has_been_deleted(String useNameD) {
         /*
        1st Assertion is based on count of table before and after deleting user
         */
        int sizeAfterDelete=teladocAddUserPage.afterDeletingCustomerTable.size();
        Assert.assertEquals(sizeOfRowsBefore-sizeAfterDelete,-1);
        /*
        2nd based on search box when user deletes the data and searches for deleted user it will not appear on page
         */
        teladocHomePage.searchBox.sendKeys(useNameD);
        List<WebElement> deletedData=teladocSearchPage.userData;
        for (WebElement element: deletedData){
            String actualData=teladocSearchPage.currentPage.getText();
            Assert.assertFalse(actualData.contains(element.getText()));
        }

    }

}
