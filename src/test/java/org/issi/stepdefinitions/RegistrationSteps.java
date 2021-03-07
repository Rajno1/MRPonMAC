package org.issi.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;
import org.issi.utilities.ExcelReader;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.issi.pages.RegistrationPage.*;

public class RegistrationSteps {

   // private RegistrationPage registrationPage = new RegistrationPage();

    @Then("Register button should be display")
    public void register_button_should_be_display() {
        Assert.assertTrue(isRegisterbtnExist());
    }

    @When("user clicks on Register button")
    public void user_clicks_on_register_button() {
        clickOnRegister();
    }

    @When("user fills the form from given sheet name {string} and row number {int}")
    public void user_fills_the_form_from_given_sheet_name_and_row_number(String sheetname, Integer rownumber) {
         ExcelReader reader = new ExcelReader();
        try {
            /*
                Here 'getData()' method's exception we are handling using try-catch
                and it returns  a list of Map so we store it in a list of map variable
             */
            List<Map<String,String>> testdata = reader.getData(FrameworkConstants.getExcelFilePath(),sheetname);
            String username = testdata.get(rownumber).get("UserName");
            String password = testdata.get(rownumber).get("Password");
            String confirmpassword = testdata.get(rownumber).get("ConfirmPassword");
            String prefix = testdata.get(rownumber).get("Prefix");
            String firstname = testdata.get(rownumber).get("FirstName");
            String middlename = testdata.get(rownumber).get("MiddleName");
            String lastname = testdata.get(rownumber).get("LastName");
            String suffix = testdata.get(rownumber).get("Suffix");
            String datofbirth = testdata.get(rownumber).get("DateOfBirth");
            String ssnNum = testdata.get(rownumber).get("SSNno");
            String emaiId = testdata.get(rownumber).get("Email");
            String mobilenum = testdata.get(rownumber).get("MobileNo");
            String address = testdata.get(rownumber).get("Address");
            String city = testdata.get(rownumber).get("City");
            String state = testdata.get(rownumber).get("State");
            String county = testdata.get(rownumber).get("County");
            String zipcode = testdata.get(rownumber).get("Zipcode");
            String questionOne = testdata.get(rownumber).get("Question1");
            String answerOne = testdata.get(rownumber).get("Answer1");
            String questionTwo = testdata.get(rownumber).get("Question2");
            String answerTwo = testdata.get(rownumber).get("Answer2");
            String questionThree = testdata.get(rownumber).get("Question3");
            String answerThree = testdata.get(rownumber).get("Answer3");


            enterRegUserName(username);
            enterRegPassword(password);
            enterRegConfirmPassword(confirmpassword);
            selectPrefix(prefix);
            enterFirstName(firstname);
            enterMiddleName(middlename);
            enterLastName(lastname);
            selectSuffix(suffix);
            selectDOB(datofbirth);
            enterSSNnumber(ssnNum);
            enterEmailId(emaiId);
            enterMobileNumber(mobilenum);
            enterAddress(address);
            enterCity(city);
            selectState(state);
            selectCounty(county);
            selectZipcode(zipcode);
            enterFirstQesAndAns(questionOne,answerOne);
            enterSecondQesAndAns(questionTwo,answerTwo);
            enterThreeQesAndAns(questionThree,answerThree);



        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @When("user clicks on Register button to submit the form")
    public void user_clicks_on_register_button_to_submit_the_form() {
            clickOnRegBtn();
    }

    @Then("it shows successfully message {string}")
    public void it_shows_successfully_message(String expectedMsg) {
        Alert alert = DriverManager.getDriver().switchTo().alert();
        waitupto(500);
        String actualMasg = alert.getText();
        Assert.assertTrue(actualMasg.contains(expectedMsg));
        alert.accept();
        waitupto(500);
    }
}
