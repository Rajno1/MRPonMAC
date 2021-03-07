package org.issi.pages;

import com.microsoft.schemas.office.office.STInsetMode;
import org.issi.driver.Driver;
import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PersonalInfoPage extends BasePage {

    public PersonalInfoPage() {
    }


    // clicking on Applicaitons menu item
    private static final By applicationsMenu = By.xpath("//a[contains(text(),'Applications')]");

    public static void clickOnApplicationsMenu() {
        clickOn(applicationsMenu, WaitStrategy.CLICKABLE, "Applications Menu");
    }

    // Clicking on add 'Add new Applications link'
    private static final By addNewApplicatonLink = By.xpath("//a[@id='addnewRole']");

    public static void clickOnAddNewApplication() {
        clickOn(addNewApplicatonLink, WaitStrategy.CLICKABLE, "Add New Application");
        waitupto(500);
    }

    /**
     * Enter Personal information
     */
    // selecting prefix from drop down
    private static final By prefixDrpDwn = By.xpath("//select[@id='ddlPersonaTitle']");

    public static void selectApplicantTitle(String title) {
        selectFromDrpDwn(prefixDrpDwn, WaitStrategy.CLICKABLE, title, "Prefix");
        waitupto(500);
    }

    // Enter Last Name
    private static final By lastNameText = By.xpath("//input[@id='txtLastName']");

    public static void enterApplicantLastName(String lastName) {
        enterText(lastNameText, lastName, WaitStrategy.PRESENCE, "Last Name");
        waitupto(500);
    }

    //Enter First Name
    private static final By firstNameText = By.xpath("//input[@id='txtFirstName']");

    public static void enterApplicantFirstName(String firstName) {
        enterText(firstNameText, firstName, WaitStrategy.PRESENCE, "First Name");
        waitupto(500);
    }

    //Enter Middle Name
    private static final By middleNameText = By.xpath("//input[@id='txtMiddleName']");

    public static void enterApplicantMiddleName(String middleName) {
        enterText(middleNameText, middleName, WaitStrategy.PRESENCE, "Middle Name");
        waitupto(500);
    }

    //Selecting Suffix value
    private static final By suffixDrpDwn = By.xpath("//select[@id='ddlPersonalSuffix']");

    public static void selectApplicantSuffix(String suffixValue) {
        selectFromDrpDwn(suffixDrpDwn, WaitStrategy.CLICKABLE, suffixValue, "Suffix Value");
        waitupto(500);
    }

    //Selecting Gender
    private static final By genderDrpDwn = By.xpath("//select[@id='ddlPersonalGender']");

    public static void selectApplicantGender(String genderValue) {
        selectFromDrpDwn(genderDrpDwn, WaitStrategy.CLICKABLE, genderValue, "Gender Value");
        waitupto(500);
    }

    //Enter Date Of Birth
    private static final By dobText = By.xpath("//input[@id='txtDatofBirth']");

    public static void selectApplicantDOB(String dateofbirth) {
        enterText(dobText, dateofbirth, WaitStrategy.PRESENCE, "Date pf Birth");
        waitupto(500);
    }

    //Enter Social Security Number
    private static final By ssnText = By.xpath("//input[@id='txtPerSSNO']");

    public static void enterApplicantSSNnumber(String ssn) {
        enterText(ssnText, ssn, WaitStrategy.PRESENCE, " Entered SSN number");
        waitupto(500);
    }

    //Enter HICN/MBI No
    private static final By hicn_mbiText = By.xpath("//input[@id='txtPerHICN']");

    public static void enterHicn_MbiNum(String hicn_mbiNum) {
        enterText(hicn_mbiText, hicn_mbiNum, WaitStrategy.PRESENCE, "HICN/MBI NO");
        waitupto(500);
    }

    //Selecting MartialStatus
    private static final By martialStatusDrpDwn = By.xpath("//select[@id='ddlPersonalMartialStatus']");

    public static void selectApplicantMartialStatus(String MartialStatusValue) {
        selectFromDrpDwn(martialStatusDrpDwn, WaitStrategy.CLICKABLE, MartialStatusValue, "Martial Status");
        waitupto(500);
    }

    //MaryLand Residence validation
    private static final By areYouResidentOfMaryland_RadioBtn_Yes = By.xpath("//label[text()='Are you resident of Maryland?']/../input[@id='rbtnMarylandYes']");
    private static final By areYouResidentOfMaryland_RadioBtn_No = By.xpath("//label[text()='Are you resident of Maryland?']/../input[@id='rbtnMarylandNo']");

    public static void clickOnResidentofMaryland(String radiobtn) {
        if (radiobtn.contentEquals("Yes")) {
            clickOn(areYouResidentOfMaryland_RadioBtn_Yes, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        } else if (radiobtn.contentEquals("No")) {
            clickOn(areYouResidentOfMaryland_RadioBtn_No, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        }
    }

    //Medicaid eligible validation
    private static final By areYoueLigibleForMedicaid_RadioBtn_Yes = By.xpath("//label[text()='Are you eligible for Medicaid?']/../input[@id='rbtnMedicaidYes']");
    private static final By areYoueLigibleForMedicaid_RadioBtn_No = By.xpath("//label[text()='Are you eligible for Medicaid?']/../input[@id='rbtnMedicaidNo']");
    private static final By areYoueLigibleForMedicaid_RadioBtn_DontKnow = By.xpath("//label[text()='Are you eligible for Medicaid?']/../input[@id='rbtnMedicaidDontKnow']");

    public static void clickOnEligibleforMedicaid(String radiobtn) {
        if (radiobtn.contentEquals("Yes")) {
            clickOn(areYoueLigibleForMedicaid_RadioBtn_Yes, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        } else if (radiobtn.contentEquals("No")) {
            clickOn(areYoueLigibleForMedicaid_RadioBtn_No, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        } else if (radiobtn.contentEquals("No")) {
            clickOn(areYoueLigibleForMedicaid_RadioBtn_DontKnow, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        }
    }

    //Low Income Subsidy validaiton
    private static final By lowIncomeSubsidy_RadioBtn_Yes = By.xpath("//input[@id='rbtnFLISYes']");
    private static final By lowIncomeSubsidy_RadioBtn_No = By.xpath("//input[@id='rbtnFLISNo']");
    private static final By lowIncomeSubsidy_RadioBtn_DontKnow = By.xpath("//input[@id='rbtnFLISDontKnow']");

    public static void clickOnLowIncomeSubsidy(String radiobtn) {
        if (radiobtn.contentEquals("Yes")) {
            clickOn(lowIncomeSubsidy_RadioBtn_Yes, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        } else if (radiobtn.contentEquals("No")) {
            clickOn(lowIncomeSubsidy_RadioBtn_No, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        } else if (radiobtn.contentEquals("Don't Know")) {
            clickOn(lowIncomeSubsidy_RadioBtn_DontKnow, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        }
    }

    // Is spouse also applying validation
    private static final By isYourSpouseAlsoApplying_RaidoBtn_Yes = By.xpath("//label[contains(text(),'If married, is your spouse')]/../input[@id='rbtnSpouseYes']");
    private static final By isYourSpouseAlsoApplying_RaidoBtn_No = By.xpath("//label[contains(text(),'If married, is your spouse')]/../input[@id='rbtnSpouseNo']");

    public static void clickOnIsYourSpouseApplying(String radiobtn) {
        if (radiobtn.contentEquals("Yes")) {
            clickOn(isYourSpouseAlsoApplying_RaidoBtn_Yes, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        } else if (radiobtn.contentEquals("No")) {
            clickOn(isYourSpouseAlsoApplying_RaidoBtn_No, WaitStrategy.CLICKABLE, radiobtn);
            waitupto(500);
        }
    }

    /**
     * Enter Spouse Information
     */

    // Selecing Prefix of spouse
    private static final By spousePrefixDrpDwn = By.xpath("//select[@id='ddlSpouseTitle']");

    public static void selectSpouseTitle(String spouseTitle) {
        enterText(spousePrefixDrpDwn, spouseTitle, WaitStrategy.CLICKABLE, "Spouse Prefix");
        waitupto(500);
    }

    // Enter Spouse Last Name
    private static final By spouseLastNameText = By.xpath("//input[@id='txtSLastName']");

    public static void enterSpouseLastName(String spouseLastName) {
        enterText(spouseLastNameText, spouseLastName, WaitStrategy.CLICKABLE, "Spouse LastName");
        waitupto(500);
    }

    // Enter Spouse First Name
    private static final By spouseFirstNameText = By.xpath("//input[@id='txtSFirstName']");

    public static void enterSpouseFirstName(String spouseFirstName) {
        enterText(spouseFirstNameText, spouseFirstName, WaitStrategy.CLICKABLE, "Spouse FirstName");
        waitupto(500);
    }

    // Enter Spouse Middle Name
    private static final By spouseMiddleNameText = By.xpath("//input[@id='txtSMiddleName']");

    public static void enterSpouseMiddleName(String spouseMiddleName) {
        enterText(spouseMiddleNameText, spouseMiddleName, WaitStrategy.CLICKABLE, "Spouse MiddleName");
        waitupto(500);
    }

    // Select Spouse suffix
    private static final By spouseSuffixDrpDwn = By.xpath("//select[@id='ddlSpouseSuffix']");

    public static void selectSpouseSuffix(String spouseSuffix) {
        selectFromDrpDwn(spouseSuffixDrpDwn, WaitStrategy.CLICKABLE, spouseSuffix, "Spouse Suffix");
        waitupto(500);
    }

    //Enter Spouse Data Of Birth
    private static final By spouseDOBText = By.xpath("//input[@id='txtSDatofBirth']");

    public static void enterSpouseDob(String spousedob) {
        enterText(spouseDOBText, spousedob, WaitStrategy.CLICKABLE, "Spouse DateOfBirth");
        waitupto(500);
    }

    // Enter Spouse Email Id
    private static final By spouseEmailText = By.xpath("//input[@id='txtSEmail']");

    public static void enterSpouseEmail(String spouseEmail) {
        enterText(spouseEmailText, spouseEmail, WaitStrategy.CLICKABLE, "Spouse Email");
        waitupto(500);
    }

    // Enter Spouse Home phone number
    private static final By spouseHomePhoneText = By.xpath("//input[@id='txtSHomePhone']");

    public static void enterSpouseHomePhone(String spouseHomePhone) {
        enterText(spouseHomePhoneText, spouseHomePhone, WaitStrategy.CLICKABLE, "Spouse HomePhone");
        waitupto(500);
    }

    // Enter Spouse Work phone number
    private static final By spouseWorkPhoneText = By.xpath("//input[@id='txtSWOrkPhone']");

    public static void enterSpouseWorkPhone(String spouseWorkPhone) {
        enterText(spouseWorkPhoneText, spouseWorkPhone, WaitStrategy.CLICKABLE, "Spouse WorkPhone");
        waitupto(500);
    }

    // Enter Spouse Cell phone number
    private static final By spouseCellPhoneText = By.xpath("//input[@id='txtSMobilePhone']");

    public static void enterSpouseMobilePhone(String spouseMobilePhone) {
        enterText(spouseCellPhoneText, spouseMobilePhone, WaitStrategy.CLICKABLE, "Spouse Cell Phone");
        waitupto(500);
    }

    /**
     * Enter Home Address details
     */
    // Enter Home address
    public static final By homeAddressText = By.xpath("//input[@id='txtHaddr' or @name='txtHaddr']");

    public static void enterAddress(String address) {
        enterText(homeAddressText, address, WaitStrategy.PRESENCE, "Address");
        waitupto(500);

    }

    // Enter City
    public static final By homeCityText = By.xpath("//input[@id='txtHcity' or @name='txtHcity']");

    public static void enterCity(String city) {
        enterText(homeCityText, city, WaitStrategy.PRESENCE, "City");
        waitupto(500);
    }

    // Select State
    public static final By homeStateDrpDwn = By.xpath("//select[@id='ddlHState']");

    public static void selectState(String state) {
        selectFromDrpDwn(homeStateDrpDwn, WaitStrategy.CLICKABLE, state, "State");
        waitupto(500);
    }

    //Select county
    public static final By homeCountryDrpDwn = By.xpath("//select[@id='ddlHCounty']");

    public static void selectCounty(String county) {
        selectFromDrpDwn(homeCountryDrpDwn, WaitStrategy.CLICKABLE, county, "County");
        waitupto(500);
    }

    // Enter ZipCode
    public static final By homeZipcodeText = By.xpath("//input[@id='txtHzipcode'or @name='txtHzipcode']");

    public static void selectZipcode(String zipcode) {
        enterText(homeZipcodeText, zipcode, WaitStrategy.PRESENCE, "Zip Code");
        waitupto(500);
    }

    // Select Mary Land retiree status
    private static final By stateOfMaryLandRetireeYesRadBtn = By.xpath("//input[@id='rbtnIsRetireeOwn']");
    private static final By spouseStateOfMaryLandRetireeYesRadBtn = By.xpath("//input[@id='rbtnIsRetireeSpouse']");
    private static final By NeitherStateOfMaryLandRetireeYesRadBtn = By.xpath("//input[@id='rbtnIsRetireeNeither']");

    public static void selectMaryLandRetireeStatus(String status) {
        if (status.contentEquals("State of Maryland retiree")) {
            clickOn(stateOfMaryLandRetireeYesRadBtn, WaitStrategy.CLICKABLE, "State of Maryland retiree");
            waitupto(500);
        } else if (status.contentEquals("Spouse of State of Maryland retiree")) {
            clickOn(spouseStateOfMaryLandRetireeYesRadBtn, WaitStrategy.CLICKABLE, "Spouse of State of Maryland retiree");
            waitupto(500);
        } else if (status.contentEquals("Neither")) {
            clickOn(NeitherStateOfMaryLandRetireeYesRadBtn, WaitStrategy.CLICKABLE, "Neither");
            waitupto(500);
        }
    }


    // confirming mailing address is same as Home
    private static final By isMailingaddressSameRadiBtn_Yes = By.xpath("//label[contains(text(),'Home address')]/../../div/input[@id='rbtnIsMailingYes']");
    private static final By isMailingaddressSameRadiBtn_No = By.xpath("//label[contains(text(),'Home address')]/../../div/input[@id='rbtnIsMailingNo']");

    public static void selectMailingaddressOption(String option) {
        if (option.contentEquals("Yes")) {
            clickOn(isMailingaddressSameRadiBtn_Yes, WaitStrategy.CLICKABLE, option);
            waitupto(500);
        } else if (option.contentEquals("No")) {
            clickOn(isMailingaddressSameRadiBtn_No, WaitStrategy.CLICKABLE, option);
            waitupto(500);

        }
    }


    /**
     * Enter Mailing Address
     */

    // Enter Mailing Address
    public static final By mailingAddressText = By.xpath("//input[@id='txtMaddr']");

    public static void enterMailingAddress(String mailingAddress) {
        enterText(mailingAddressText, mailingAddress, WaitStrategy.PRESENCE, "Mailing Address");
        waitupto(500);
    }

    // Enter mailing city
    public static final By mailingCityText = By.xpath("//input[@id='txtMcity']");

    public static void enterMailingCity(String mailingCity) {
        enterText(mailingCityText, mailingCity, WaitStrategy.PRESENCE, "City");
        waitupto(500);
    }

    //Select Mailing State
    public static final By mailingStateDrpDwn = By.xpath("//select[@id='ddlMState']");

    public static void selectMailingState(String MailingState) {
        selectFromDrpDwn(mailingStateDrpDwn, WaitStrategy.CLICKABLE, MailingState, "State");
        waitupto(500);
    }

    //Select mailing county
    public static final By mailingCountryDrpDwn = By.xpath("//select[@id='ddlMCounty']");

    public static void selectMailingCounty(String MailingCounty) {
        selectFromDrpDwn(mailingCountryDrpDwn, WaitStrategy.CLICKABLE, MailingCounty, "County");
        waitupto(500);
    }

    // Enter Mailing Zipcode
    public static final By mailingZipCodeText = By.xpath("//input[@id='txtMzipcode']");

    public static void enterMailingZipcode(String Mailingzipcode) {
        enterText(mailingZipCodeText, Mailingzipcode, WaitStrategy.PRESENCE, "Zip Code");
        waitupto(500);
    }

    /**
     * Filing contact Information
     */
    // Enter contact email id
    private static final By contactEmailText = By.xpath("//input[@id='txtEmail']");

    public static void enterContactEmailId(String emailid) {
        enterText(contactEmailText, emailid, WaitStrategy.PRESENCE, "Email id");
        waitupto(500);
    }

    // enter Home phone contact number
    private static final By contactHomePhoneText = By.xpath("//input[@id='txtHomePhone']");

    public static void enterContactHomePhone(String homePhoneNum) {
        enterText(contactHomePhoneText, homePhoneNum, WaitStrategy.PRESENCE, "Home Phone number");
        waitupto(500);
    }

    // Enter work phone number
    private static final By contactWorkPhoneText = By.xpath("//input[@id='txtWOrkPhone']");

    public static void enterContactWorkPhone(String workPhoneNum) {
        enterText(contactWorkPhoneText, workPhoneNum, WaitStrategy.PRESENCE, "Work phone number");
        waitupto(500);
    }

    // Enter cell phone number
    private static final By contactCellPhoneText = By.xpath("//input[@id='txtMobilePhone']");

    public static void enterContactCellPhone(String mobilePoneNum) {
        enterText(contactCellPhoneText, mobilePoneNum, WaitStrategy.PRESENCE, "Mobile phone number");
        waitupto(500);
    }

    /**
     * Filling Medicare information
     */
    // Clicking on medicare coverage option
    private static final By medicareCoveredRadioBtnYes = By.xpath("//input[@id='rbtnMCoveredYes']");
    private static final By medicareCoveredRadioBtnNo = By.xpath("//input[@id='rbtnMCoveredNo']");

    public static void clickOnMedicareCoveredValidation(String coverageVale) {
        if (coverageVale.contentEquals("Yes")) {
            clickOn(medicareCoveredRadioBtnYes, WaitStrategy.CLICKABLE, "Medicare coverage is Yes");
            waitupto(500);
        } else if (coverageVale.contentEquals("No")) {
            clickOn(medicareCoveredRadioBtnNo, WaitStrategy.CLICKABLE, "Medicare coverage is Yes");
            waitupto(500);
        }
    }

    // Selecting orgnization name
    private static final By organizationNameDrpDwn = By.xpath("//select[@id='ddlOrgnization']");

    public static void selectOrganizationValue(String orgName){
        selectFromDrpDwn(organizationNameDrpDwn,WaitStrategy.CLICKABLE,orgName,"Organization Name");
        waitupto(500);
    }

    // Select Plan name
    private static final By planNameDrpDwn = By.xpath("//select[@id='ddlPlanName']");

    public static void selectPlanName(String planName){
        selectFromDrpDwn(planNameDrpDwn,WaitStrategy.CLICKABLE,planName,"Plan Name");
        waitupto(500);
    }
    // Enter Medicare ID
    private static final By medicareIDText = By.xpath("//input[@id='txtMedicaidNo']");

    public static void enterMedicareID(String MedicareIDValue) {
        enterText(medicareIDText, MedicareIDValue, WaitStrategy.PRESENCE, "MedicareID Value");
        waitupto(500);
    }

    // Enter Part D effective date
    private static final By partDEffectiveDateText = By.xpath("//input[@id='txtPartDEffectiveDate']");

    public static void enterPartDEffectiveDate(String effectiveDateValue) {
        enterText(partDEffectiveDateText, effectiveDateValue, WaitStrategy.PRESENCE, "Medicare Effective Date");
        waitupto(500);
    }

    // Enter Part D termination Date
    private static final By partDTerminationDateText = By.xpath("//input[@id='txtPartDTerminationDate']");

    public static void enterPartDTerminationDate(String terminationDateValue) {
        enterText(partDTerminationDateText, terminationDateValue, WaitStrategy.PRESENCE, "Medicare Termination Date");
        waitupto(500);
    }

    // Clicking on Cancel button in personal info tab
    private static final By personalInfoCancleBtn = By.xpath("//button[@id='btnCancel']");

    public static void clickOnPersonalInfoCancel(){
        clickOn(personalInfoCancleBtn,WaitStrategy.CLICKABLE,"Cancel button in Personal info tab");
    }

    // Clicking on Next button in personal info tab
    private static final By personalInfoNextBtn = By.xpath("//button[@id='next']");
    public static void clickOnPersonalInfoNext() {
        clickOn(personalInfoNextBtn, WaitStrategy.CLICKABLE, "Next button in Personal info tab");
        waitupto(500);
    }










}
