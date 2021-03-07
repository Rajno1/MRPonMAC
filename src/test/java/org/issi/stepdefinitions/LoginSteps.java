package org.issi.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.issi.driver.DriverManager;
import org.issi.enums.ConfigProperties;
import org.issi.pages.LoginPage;
import org.issi.utilities.PropertyUtils;
import org.junit.Assert;

public class LoginSteps {
    private static String title;
    private LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assertions.assertThat(title).isEqualTo(expectedTitleName);
    }


    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUserName(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();
    }

}
