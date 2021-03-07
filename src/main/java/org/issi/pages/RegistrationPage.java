package org.issi.pages;

import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    //Constructor
    public RegistrationPage() {
    }

    //Identifying the elements
    private static final By RegisterBtn = By.xpath("//a[contains(text(),' Register')]");
    private static final By usernameText = By.id("txtUserName");
    private static final By passwordText = By.id("txtPassword");
    private static final By confirmpasswordText = By.id("txtConfirmPassword");
    private static final By prefixDrpDwn = By.xpath("//select[@id='ddlPrefix']");
    private static final By firstnameText = By.id("txtFirstName");
    private static final By middlenameText = By.id("txtMiddleName");
    private static final By lastnameText = By.id("txtLastname");
    private static final By suffixDrpDwn = By.id("ddlSuffix");
    private static final By dobText = By.xpath("//input[@id='txtDateofBirth']");
    private static final By ssnText = By.id("txtSSNnum");
    private static final By emailText = By.id("txtEmail");
    private static final By mobileText = By.id("txtMobileNo");
    private static final By addressText = By.id("txtAddress");
    private static final By cityText =By.id("txtCity");
    private static final By stateText = By.xpath("//select[@id='ddlState']");
    private static final By countyText = By.xpath("//select[@id='ddlCounty']");
    private static final By zipText = By.xpath("//input[@id='txtZipcode']");
    private static final By quesionOne = By.xpath("//select[@id='ddlQuestionone']");
    private static final By answerOne = By.xpath("//input[@id='txtAnswerone']");
    private static final By quesionTwo = By.xpath("//select[@id='ddlQuestiontwo']");
    private static final By answerTwo = By.xpath("//input[@id='txtAnswertwo']");
    private static final By quesionThree = By.xpath("//select[@id='ddlQuestionthree']");
    private static final By answerThree = By.xpath("//input[@id='txtAnswerthree']");
    private static final By registersubBtn = By.xpath("//input[@class='btn btn-success']");







    //Action methods
    public static boolean isRegisterbtnExist(){ //assertion method
        return DriverManager.getDriver().findElement(RegisterBtn).isDisplayed();
    }
    public static void clickOnRegister(){ // Action method
        clickOn(RegisterBtn, WaitStrategy.CLICKABLE,"RegisterButton");
        waitupto(500);
    }
    public static void enterRegUserName(String username){
        enterText(usernameText,username,WaitStrategy.PRESENCE,"User Name");
        waitupto(500);
    }
    public static void enterRegPassword(String password){
        enterText(passwordText,password,WaitStrategy.PRESENCE,"Password");
        waitupto(500);
    }
    public static void enterRegConfirmPassword(String confirmPassword){
        enterText(confirmpasswordText,confirmPassword,WaitStrategy.PRESENCE,"Confirm Password");
        waitupto(500);
    }
    public static void selectPrefix(String prefixValue){
       selectFromDrpDwn(prefixDrpDwn,WaitStrategy.CLICKABLE,prefixValue,"Prefix value");
        waitupto(500);
    }
    public static void enterFirstName(String firstName){
       enterText(firstnameText,firstName,WaitStrategy.PRESENCE,"First Name");
        waitupto(500);
    }
    public static void enterMiddleName(String middleName){
        enterText(middlenameText,middleName,WaitStrategy.PRESENCE,"Middle Name");
        waitupto(500);
    }
    public static void enterLastName(String lastName){
        enterText(lastnameText,lastName,WaitStrategy.PRESENCE,"Last Name");
        waitupto(500);
    }
    public static void selectSuffix(String suffixValue){
       selectFromDrpDwn(suffixDrpDwn,WaitStrategy.CLICKABLE,suffixValue,"Suffix Value");
       waitupto(500);
    }
    public static void selectDOB(String dateofbirth){
        enterText(dobText,dateofbirth,WaitStrategy.PRESENCE,"Date pf Birth");
        waitupto(500);
    }
    public static void enterSSNnumber(String ssn){
        enterText(ssnText,ssn,WaitStrategy.PRESENCE,"Last 4 digits of SSN");
        waitupto(500);
    }
    public static void enterEmailId(String emailid){
        enterText(emailText,emailid,WaitStrategy.PRESENCE,"Email id");
        waitupto(500);
    }
    public static void enterMobileNumber(String mobilenum){
        enterText(mobileText,mobilenum,WaitStrategy.PRESENCE,"Mobile Number");
        waitupto(500);
    }
    public static void enterAddress(String address){
        enterText(addressText,address,WaitStrategy.PRESENCE,"Address");
        waitupto(500);
    }
    public static void enterCity(String city){
        enterText(cityText,city,WaitStrategy.PRESENCE,"City");
        waitupto(500);
    }
    public static void selectState(String state){
      selectFromDrpDwn(stateText,WaitStrategy.CLICKABLE,state,"State");
      waitupto(500);
    }
    public static void selectCounty(String county){
        selectFromDrpDwn(countyText,WaitStrategy.CLICKABLE,county,"County");
       // waitupto(500);
    }
    public static void selectZipcode(String zipcode){
       enterText(zipText,zipcode,WaitStrategy.PRESENCE,"Zip Code");

        waitupto(500);
    }

    public static void enterFirstQesAndAns(String QesOne,String AnsOne){
        enterText(quesionOne,QesOne,WaitStrategy.CLICKABLE,"Qestion One");
        waitupto(500);
        enterText(answerOne,AnsOne,WaitStrategy.PRESENCE,"Answer One");
        waitupto(500);
    }
    public static void enterSecondQesAndAns(String QesTwo,String AnsTwo){
        enterText(quesionTwo,QesTwo,WaitStrategy.CLICKABLE,"Qestion Two");
        waitupto(500);
        enterText(answerTwo,AnsTwo,WaitStrategy.PRESENCE,"Answer Two");
        waitupto(500);
    }
    public static void enterThreeQesAndAns(String QesThree,String AnsThree){
        enterText(quesionThree,QesThree,WaitStrategy.CLICKABLE,"Qestion Three");
        waitupto(500);
        enterText(answerThree,AnsThree,WaitStrategy.PRESENCE,"Answer Three");
        waitupto(500);
    }
    public static void clickOnRegBtn(){
        clickOn(registersubBtn,WaitStrategy.CLICKABLE,"Register");
        waitupto(10000);
    }
}
