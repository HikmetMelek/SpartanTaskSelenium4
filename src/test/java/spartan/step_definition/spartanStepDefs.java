package spartan.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import spartan.pages.HomePage;
import spartan.utilities.BrowserUtils;
import spartan.utilities.ConfigurationReader;
import spartan.utilities.DBUtils;
import spartan.utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class spartanStepDefs {

        HomePage homePage = new HomePage();
    int randomSpartan;

    @Given("user is on the Spartan Home Page")
    public void user_is_on_the_Spartan_Home_Page() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user clicks on any random Spartan and view the Data")
    public void user_clicks_on_any_random_Spartan_and_view_the_Data() {

        int sizeOfAllSpartans = homePage.allSpartans.size();

        Random random = new Random();

        randomSpartan = random.nextInt(sizeOfAllSpartans);

        homePage.getSpartan(randomSpartan).click();

        BrowserUtils.waitFor(3.0);

    }


    @Then("spartan info should be same with DB")
    public void spartanInfoShouldBeSameWithDB() {

        String query = "select * from spartans where SPARTAN_ID='"+randomSpartan+"'";

        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        System.out.println("rowMap = " + rowMap);

        

    }
}
