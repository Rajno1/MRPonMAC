package org.issi.pages;

import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RepresentativeInformationPage extends BasePage{
    private RepresentativeInformationPage() {
    }

    //  Selecting add a personal Representative option
    private static final By optionYesRadBtn = By.xpath("//input[@id='rbtnRYes']");
    public static final By optionNoRadBtn = By.xpath("//input[@id='rbtnRNo']");

    public static void selectAddRepresentativeOption(String option){
        if (option.equalsIgnoreCase("Yes")){
            clickOn(optionYesRadBtn, WaitStrategy.CLICKABLE,"Adding Representative as "+option+"");
            waitupto(500);
        }
    }

    // clickOn Add new Represetative link
    private static final By addNewRepresentativeLink = By.xpath("//a[@id='addnewRole']");
    public static void clickOnAddNewRepresentative(){
        clickOn(addNewRepresentativeLink,WaitStrategy.CLICKABLE,"Add New Representative");
        waitupto(500);
    }

    // select prefix
    private static final By repPrefixDrpDwn = By.xpath("//select[@id='ddRIlTitle']");
    public static void selectRepPrefix(String prefixValue){
        selectFromDrpDwn(repPrefixDrpDwn,WaitStrategy.CLICKABLE,prefixValue,"Representative prefix");
        waitupto(500);
    }

    //Enter Rer First name
    private static final By repFirstNameText = By.xpath("//input[@id='txtRIFirstName']");
    public static void enterRepFirstName(String repfirstname){
        enterText(repFirstNameText,repfirstname,WaitStrategy.PRESENCE,"Representative FirstName");
        waitupto(500);
    }

    //Enter Rer Middle name
    private static final By repMiddleNameText = By.xpath("//input[@id='txtRIMiddleName']");
    public static void enterRepMiddleName(String repmiddlename){
        enterText(repMiddleNameText,repmiddlename,WaitStrategy.PRESENCE,"Representative MiddleName");
        waitupto(500);
    }

    //Enter Rer Last name
    private static final By repLastNameText = By.xpath("//input[@id='txtRILastName']");
    public static void enterRepLastName(String replasttname){
        enterText(repLastNameText,replasttname,WaitStrategy.PRESENCE,"Representative LastName");
        waitupto(500);
    }

    // select Rep prefix
    private static final By repSuffixDrpDwn = By.xpath("//select[@id='ddlRISuffix']");
    public static void selectRepSuffix(String suffixValue){
        selectFromDrpDwn(repSuffixDrpDwn,WaitStrategy.CLICKABLE,suffixValue,"Representative suffix");
        waitupto(500);
    }

    // enter Rep ssn
    private  static final  By repssnText = By.xpath("//input[@id='txtRISSN']");
    public static void enterRepSSN(String repssn){
        enterText(repssnText,repssn,WaitStrategy.PRESENCE,"Representative SSN");
        waitupto(500);
    }

    // select Rep relation with appicatn
    private static final By reprelationDrpDwn = By.xpath("//select[@id='ddlRIrelationshipapp']");
    public static void selectRepRelation(String realation){
        selectFromDrpDwn(reprelationDrpDwn,WaitStrategy.CLICKABLE,realation,"Representative relation with appicant");
        waitupto(500);
    }

    // select Rep relation with appicatn
    private static final By repcorrespondenceDrpDwn = By.xpath("//select[@id='ddlRIcorrespondence']");
    public static void selectRepCorrespondence(String correspon){
        selectFromDrpDwn(repcorrespondenceDrpDwn,WaitStrategy.CLICKABLE,correspon,"Representative correspondence");
        waitupto(500);
    }

    // selectingRepAuth purpose one
    private static final By repAuthPurposeOneChbx = By.xpath("//input[@id='rbtnRIPurpose_1']");
    public static void selectRepAuthPurposeOne(String option){
        if (option.equalsIgnoreCase("yes")){
            clickOn(repAuthPurposeOneChbx,WaitStrategy.CLICKABLE,"Auth To Persons Other Than Myself");
            waitupto(500);
        }
    }

    // selectingRepAuth purpose Two
    private static final By repAuthPurposeTwoChbx = By.xpath("//input[@id='rbtnRIPurpose_2']");
    public static void selectRepAuthPurposeTwo(String option){
        if (option.equalsIgnoreCase("yes")){
            clickOn(repAuthPurposeTwoChbx,WaitStrategy.CLICKABLE,"Auth To Report My Address");
            waitupto(500);
        }
    }

    // selectingRepAuth purpose Three
    private static final By repAuthPurposeThreeChbx = By.xpath("//input[@id='rbtnRIPurpose_3']");
    public static void selectRepAuthPurposeThree(String option){
        if (option.equalsIgnoreCase("yes")){
            clickOn(repAuthPurposeThreeChbx,WaitStrategy.CLICKABLE,"Auth To Review My Benefits");
            waitupto(500);
        }
    }

    // selectingRepAuth purpose four
    private static final By repAuthPurposefourChbx = By.xpath("//input[@id='rbtnRIPurpose_4']");
    public static void selectRepAuthPurposefour(String option){
        if (option.equalsIgnoreCase("yes")){
            clickOn(repAuthPurposefourChbx,WaitStrategy.CLICKABLE,"Auth To Discuss Paments And Premiums");
            waitupto(500);
        }
    }

    // enter Rep cell number
    private static final By repcellnumText = By.xpath("//input[@id='txtRIMobNum']");
    public static void enterRepCellNumber(String cellnum){
        enterText(repcellnumText,cellnum,WaitStrategy.PRESENCE,"Representative cell number");
        waitupto(500);
    }

    // enter Rep Work phone
    private static final By repworkphnumText = By.xpath("//input[@id='txtRIWorkNum']");
    public static void enterRepWorkPhNumber(String worknum){
        enterText(repworkphnumText,worknum,WaitStrategy.PRESENCE,"Representative work number");
        waitupto(500);
    }
    // enter Rep ph extension number
    private static final By repphextenText = By.xpath("//input[@id='txtRIExtNum']");
    public static void enterRepPhExtenNumber(String phextennum){
        enterText(repphextenText,phextennum,WaitStrategy.PRESENCE,"Representative Phone extension number");
        waitupto(500);
    }
    // enter Rep home number
    private static final By repHomePhnumText = By.xpath("//input[@id='txtRIHomeNum']");
    public static void enterRepHomePhNumber(String homenum){
        enterText(repHomePhnumText,homenum,WaitStrategy.PRESENCE,"Representative Home phone number");
        waitupto(500);
    }
    // enter Rep fax number
    private static final By repfaxnumText = By.xpath("//input[@id='txtRIFaxNum']");
    public static void enterRepFaxNumber(String faxnum){
        enterText(repfaxnumText,faxnum,WaitStrategy.PRESENCE,"Representative fax number");
        waitupto(500);
    }
    // enter Rep Email id
    private static final By repemailText = By.xpath("//input[@id='txtRIEmail']");
    public static void enterRepEmailid(String email){
        enterText(repemailText,email,WaitStrategy.PRESENCE,"Representative Email id");
        waitupto(500);
    }

    // upload Power of Attorney Form
    private static final By uploadBtn = By.xpath("//input[@id='RIfile']");
    public static void uploadPowerOfAttorney(){
        enterText(uploadBtn, FrameworkConstants.getPowerOfAttorneyFormPath(),WaitStrategy.CLICKABLE,"uploaded");
        waitupto(500);
    }

    // click on submit button
    private static final By submitbtn = By.xpath("//*[@id='RepresentativeInfo']/div[7]/button[1]");
    public static void clickOnSubmitBtn(){
        clickOn(submitbtn,WaitStrategy.CLICKABLE,"Representative submit button");
        waitupto(2000);
    }

    // click on Representative information next button
    private static final By repinfoNextBtn = By.xpath("//button[@id='nextRBtn']");
    public static void clickOnRepInfoNextBtn(){
        clickOn(repinfoNextBtn,WaitStrategy.CLICKABLE,"Representative Next Button");
        waitupto(1000);
    }
}
