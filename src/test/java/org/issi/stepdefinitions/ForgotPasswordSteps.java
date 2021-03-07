package org.issi.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.issi.pages.ForgotPasswordPage.*;

public class ForgotPasswordSteps {
    @Then("forget password button should be display")
    public void forget_password_button_should_be_display() {
        Assert.assertTrue(isForgotPwdlinkExist());
    }

    @When("user clicks on forgot password button")
    public void user_clicks_on_forgot_password_button() {
        clickOnForgotPassword();
    }

    @When("user enters Register email id {string}")
    public void user_enters_register_email_id(String email_Id) {
        enterEmailIdToResetPwd(email_Id);
    }
    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {
      clickOnForgotPswSubmitBtn();
    }
}
