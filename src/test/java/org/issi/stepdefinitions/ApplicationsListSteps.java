package org.issi.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.WithAssertions;
import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;
import org.issi.enums.ConfigProperties;
import org.issi.enums.WaitStrategy;
import org.issi.utilities.ExcelReader;
import org.issi.utilities.PropertyUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.issi.pages.ApplicationQuestionsPage.*;
import static org.issi.pages.HouseholdIncomePage.*;
import static org.issi.pages.LoginPage.doLogin;
import static org.issi.pages.PersonalInfoPage.scrollByElement;
import static org.issi.pages.PersonalInfoPage.waitupto;
import static org.issi.pages.PersonalInfoPage.*;
import static org.issi.pages.RepresentativeInformationPage.*;
import static org.issi.pages.ApplicationAttachmentsPage.*;

public class ApplicationsListSteps {

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps(String.class, String.class);
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
        doLogin(username, password);
    }

    @When("user clicks on Applications menu")
    public void user_clicks_on_applications_menu() {
        clickOnApplicationsMenu();
    }

    @Given("user clicks on Add New Application link")
    public void user_clicks_on_add_new_application_link() {
        try {
            Thread.sleep(2000);
            clickOnAddNewApplication();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("user fills personal information from given sheet name {string} and {int}")
    public void user_fills_personal_information_from_given_sheet_name_and(String sheetname, Integer rownumber) {
        ExcelReader reader = new ExcelReader();
        // Integer rownumber = 0;
        try {
            List<Map<String, String>> testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            String applicantprefix = testdata.get(rownumber).get("Prefix");
            selectApplicantTitle(applicantprefix);

            String applicantlastname = testdata.get(rownumber).get("LastName");
            enterApplicantLastName(applicantlastname);

            String applicantfirstname = testdata.get(rownumber).get("FirstName");
            enterApplicantFirstName(applicantfirstname);

            String applicantmiddlename = testdata.get(rownumber).get("MiddleName");
            enterApplicantMiddleName(applicantmiddlename);

            String applicantsuffix = testdata.get(rownumber).get("Suffix");
            selectApplicantSuffix(applicantsuffix);

            String applicantgender = testdata.get(rownumber).get("Gender");
            selectApplicantGender(applicantgender);

            String applicantdob = testdata.get(rownumber).get("DateOfBirth");
            selectApplicantDOB(applicantdob);

            String applicantSSNno = testdata.get(rownumber).get("SSNno");
            enterApplicantSSNnumber(applicantSSNno);

            String applicantHICN_MBINo = testdata.get(rownumber).get("HICN/MBI No");
            enterHicn_MbiNum(applicantHICN_MBINo);

            String applicantMarital = testdata.get(rownumber).get("MaritalStatus");
            selectApplicantMartialStatus(applicantMarital);

            String applicantResidentAuth = testdata.get(rownumber).get("Are you resident of Maryland?");
            clickOnResidentofMaryland(applicantResidentAuth);

            String applicantMedicaidAuth = testdata.get(rownumber).get("Are you eligible for Medicaid?");
            clickOnEligibleforMedicaid(applicantMedicaidAuth);

            String applicantLIS_Auth = testdata.get(rownumber).get("Are you eligible for Federal Low Income Subsidy?");
            clickOnLowIncomeSubsidy(applicantLIS_Auth);

            String isapplyingforspouse = testdata.get(rownumber).get("If married, is your spouse also applying at this time? (Your spouse must submit a separate application)");
            clickOnIsYourSpouseApplying(isapplyingforspouse);

            String spouseprefix = testdata.get(rownumber).get("SpousePrefix");
            selectSpouseTitle(spouseprefix);

            String spouselastName = testdata.get(rownumber).get("SpouseLastName");
            enterSpouseLastName(spouselastName);

            String spousefirstName = testdata.get(rownumber).get("SpouseFirstName");
            enterSpouseFirstName(spousefirstName);

            String spousemiddleName = testdata.get(rownumber).get("SpouseMiddleName");
            enterSpouseMiddleName(spousemiddleName);

            String spousesuffix = testdata.get(rownumber).get("SpouseSuffix");
            selectSpouseSuffix(spousesuffix);

            String spousedob = testdata.get(rownumber).get("SpouseDateOfBirth");
            enterSpouseDob(spousedob);

            String spouseemail = testdata.get(rownumber).get("SpouseE-Mail");
            enterSpouseEmail(spouseemail);

            String spousehomeph = testdata.get(rownumber).get("SpouseHomePhone");
            enterSpouseHomePhone(spousehomeph);

            String spouseworkph = testdata.get(rownumber).get("SpouseWorkPhone");
            enterSpouseWorkPhone(spouseworkph);

            String spousecellphone = testdata.get(rownumber).get("spouseCellPhone");
            enterSpouseMobilePhone(spousecellphone);

            String homeaddress = testdata.get(rownumber).get("HomeAddress");
            enterAddress(homeaddress);

            String homecity = testdata.get(rownumber).get("HomeCity");
            enterCity(homecity);

            String homestate = testdata.get(rownumber).get("HomeState");
            selectState(homestate);

            String homecounty = testdata.get(rownumber).get("HomeCounty");
            selectCounty(homecounty);

            String homecountyzipcode = testdata.get(rownumber).get("HomeCountyZipCode");
            selectZipcode(homecountyzipcode);

            String maryLandRetireestatusvalue = testdata.get(rownumber).get("Please check one of the following boxes");
            selectMaryLandRetireeStatus(maryLandRetireestatusvalue);

            String mailingvalidation = testdata.get(rownumber).get("Is mailing address is same as Home address?");

            if (mailingvalidation.equalsIgnoreCase("Yes")) {
                selectMailingaddressOption(mailingvalidation);

                /**
                 * Mailing address and Home address both are same
                 * So now we should validate the text from mailing address
                 */
                waitupto(500);
                String homeAddressValue = DriverManager.getDriver().findElement(homeAddressText).getAttribute("value");
                String mailingAddressValue = DriverManager.getDriver().findElement(mailingAddressText).getAttribute("value");
                Assertions.assertThat(mailingAddressValue).isEqualTo(homeAddressValue);
                waitupto(200);

                String homeCityValue = DriverManager.getDriver().findElement(homeCityText).getAttribute("value");
                String mailingCityValue = DriverManager.getDriver().findElement(mailingCityText).getAttribute("value");
                Assertions.assertThat(mailingCityValue).isEqualTo(homeCityValue);
                waitupto(200);

                String homeStateValue = DriverManager.getDriver().findElement(homeStateDrpDwn).getAttribute("value");
                String mailingStateValue = DriverManager.getDriver().findElement(mailingStateDrpDwn).getAttribute("value");
                Assertions.assertThat(mailingStateValue).isEqualTo(homeStateValue);
                waitupto(200);

                String homeCountyValue = DriverManager.getDriver().findElement(homeCountryDrpDwn).getAttribute("value");
                String mailingCountyValue = DriverManager.getDriver().findElement(mailingCountryDrpDwn).getAttribute("value");
                Assertions.assertThat(mailingCountyValue).isEqualTo(homeCountyValue);
                waitupto(200);

                String homeZipcodeValue = DriverManager.getDriver().findElement(homeZipcodeText).getAttribute("value");
                String mailingZipcodeValue = DriverManager.getDriver().findElement(mailingZipCodeText).getAttribute("value");
                Assertions.assertThat(mailingZipcodeValue).isEqualTo(homeZipcodeValue);
                waitupto(200);

            } else if (mailingvalidation.equalsIgnoreCase("No")) {
                selectMailingaddressOption(mailingvalidation);
                /**
                 * since the mailing address is NOT same as Home Address
                 * we are passing Mailing address details
                 */
                //passing mailing address
                String mailingaddress = testdata.get(rownumber).get("MailingAddress");
                enterMailingAddress(mailingaddress);
                //passing mailing city
                String mailingcity = testdata.get(rownumber).get("MailingCity");
                enterMailingCity(mailingcity);
                //passing mailing state
                String mailingstate = testdata.get(rownumber).get("MailingState");
                selectMailingState(mailingstate);
                //passing mailing county
                String mailingcounty = testdata.get(rownumber).get("MailingCounty");
                selectMailingCounty(mailingcounty);
                //passing mailing zipcode
                String mailingzipcode = testdata.get(rownumber).get("MailingZip");
                enterMailingZipcode(mailingzipcode);
            }

            String contactemail = testdata.get(rownumber).get("ContactEmail");
            enterContactEmailId(contactemail);

            String contacthomephone = testdata.get(rownumber).get("ContactHomePhone");
            enterContactHomePhone(contacthomephone);

            String contactworkphone = testdata.get(rownumber).get("ContactWorkPhone");
            enterContactWorkPhone(contactworkphone);

            String contactcellphone = testdata.get(rownumber).get("ContactCellPhone");
            enterContactCellPhone(contactcellphone);

            String medicarecoverageinfo = testdata.get(rownumber).get("Are you Covered Medicare?");

            if (medicarecoverageinfo.equalsIgnoreCase("Yes")) {
                clickOnMedicareCoveredValidation(medicarecoverageinfo);

                String orgname = testdata.get(rownumber).get("OrganizationName");
                selectOrganizationValue(orgname);

                String planname = testdata.get(rownumber).get("PlanName");
                selectPlanName(planname);

                String medicareid = testdata.get(rownumber).get("MedicareID");
                enterMedicareID(medicareid);

                String partDeffectivedate = testdata.get(rownumber).get("Part D Effective Date");
                enterPartDEffectiveDate(partDeffectivedate);

                String partDterminationdate = testdata.get(rownumber).get("Part D Termination Date");
                enterPartDTerminationDate(partDterminationdate);
            } else if (medicarecoverageinfo.equalsIgnoreCase("No")) {
                waitupto(1000);
                clickOnMedicareCoveredValidation(medicarecoverageinfo);
            }

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("user clicks on Next button in Personal info field")
    public void user_clicks_on_next_button_in_personal_info_field() {
        waitupto(1000);
        clickOnPersonalInfoNext();
        waitupto(2000);
    }

    @When("user fills application questions from given sheet name {string} and {int}")
    public void user_fills_application_questions_from_given_sheet_name_and(String sheetname, Integer row_num) {
        ExcelReader reader = new ExcelReader();
        try {
            List<Map<String, String>> testdata = reader.getData(FrameworkConstants.getExcelFilePath(), sheetname);
            /**
             * Selecting House hold members information based on the value coming from excel
             */
            String householdmember = testdata.get(row_num).get("HouseHoldMembers");
            selectHouseHoldMemValue(householdmember);

            String spdapincomeelgibility = testdata.get(row_num).get("SPDAPIncomeEligibility");
            selectSPDAPIncomElgibility(spdapincomeelgibility);

            String federalincometaxreturns = testdata.get(row_num).get("PreviousYearFederalIncomeTaxReturns");
            selectFederalIncometaxReturns(federalincometaxreturns);

            String otherpprescriptioninfo = testdata.get(row_num).get("OtherPrescriptionDrugCoverage");
            String planinfo = testdata.get(row_num).get("OtherPlanInfo");
            selectOtherPrescriptonCoverageInfo(otherpprescriptioninfo,planinfo);

            String extrahelpstatus = testdata.get(row_num).get("ExtraHelpStatus");
            selectExtraHelpStatus(extrahelpstatus);

            String singleinvestmentworth = testdata.get(row_num).get("SingleSavingsWorthQue6");
            if (singleinvestmentworth.equalsIgnoreCase("YES")){
                selectSingleInvestmentWorthOption(singleinvestmentworth);
                waitupto(2000);
                scrollByElement(appQuesNextBtn, WaitStrategy.CLICKABLE);
                clickOnAppQesNextBtn();
                waitupto(1000);
            } else if (singleinvestmentworth.equalsIgnoreCase("NO")||singleinvestmentworth.equalsIgnoreCase("NOT SURE")){
                selectSingleInvestmentWorthOption(singleinvestmentworth);
                waitupto(500);
                String marriedinvestmentvalue = testdata.get(row_num).get("MarriedSavingsWorth");
                if (marriedinvestmentvalue.equalsIgnoreCase("YES")){
                    selectMarriedInvestmentWorthOption(marriedinvestmentvalue);
                    waitupto(2000);
                    scrollByElement(appQuesNextBtn, WaitStrategy.CLICKABLE);
                    clickOnAppQesNextBtn();
                    waitupto(1000);
                } else if (marriedinvestmentvalue.equalsIgnoreCase("NO")){
                    selectMarriedInvestmentWorthOption(marriedinvestmentvalue);
                    String bankinvestments = testdata.get(row_num).get("Bank_Ac_Investiments");
                    enterBankAcInvestmentvalue(bankinvestments);

                    String stockandotherinvestments = testdata.get(row_num).get("StockAndOtherAccountInvestments");
                    enterStockAndOtherInvestmentvalue(stockandotherinvestments);

                    String cashandotherinvestments = testdata.get(row_num).get("AnyOthreCashInvestiments");
                    enterOtherCashInvestmetnsValue(cashandotherinvestments);

                    String applicantmoneyusageforfuneral = testdata.get(row_num).get("ApplicantMoneyUsageExpectFroFuneral");
                    selectMoneyUsageOptionForFuneralOfApplicant(applicantmoneyusageforfuneral);

                    String spousemoneyusageforfuneral = testdata.get(row_num).get("SpouseMoneyUsageExpectFroFuneral");
                    selectMoneyUsageOptionForFuneralOfSpouse(spousemoneyusageforfuneral);

                    String applicantrealestateinfo = testdata.get(row_num).get("ApplicantRealEstateInformation");
                    selectRealEstateInfoOfApplicant(applicantrealestateinfo);

                    String spouserealesateinfo = testdata.get(row_num).get("SpouseRealEstateInformaiton");
                    selectRealEstateInfoOfSpouse(spouserealesateinfo);

                    String monthlyincomefrmSS = testdata.get(row_num).get("MonthlyIncomeFromSocialSecurity");
                    enterMonthlyIncomeFrmSocialSecurity(monthlyincomefrmSS);

                    String monthlyincomefrmRR = testdata.get(row_num).get("MonthlyIncomefromRailroadRetirement");
                    enterMonthlyIncomeFrmRailRoadRetire(monthlyincomefrmRR);

                    String monthlyincomefrmveterans = testdata.get(row_num).get("MonthlyIncomeFromVeterans");
                    enterMontlyIncomeFrmVeterans(monthlyincomefrmveterans);

                    String monthlyincomefrmother = testdata.get(row_num).get("MonthlyIncomesfromOtherPensions");
                    enterMontlyIncomeFrmOtherPension(monthlyincomefrmother);

                    String monthlyincomefrmnotlisted = testdata.get(row_num).get("otherMonthlyIncomesNotListed");
                    enterMonthlyIncomeFrmNotListed(monthlyincomefrmnotlisted);

                    String amountstausenterin10 = testdata.get(row_num).get("AmountInQes:10,decreasedStaus");
                    selectAmountDecreStatus(amountstausenterin10);

                    String applicantwrkexp = testdata.get(row_num).get("WorkExpOfApplicant");
                    selectApplicantLast2YearsExp(applicantwrkexp);

                    String spousewrkexp = testdata.get(row_num).get("WorkExpOfSpouse");
                    selectSpouseLast2YearsExp(spousewrkexp);

                    String spouseSSN = testdata.get(row_num).get("SpouseSSN");
                    enterSpouseSSN(spouseSSN);

                    String applicantwages = testdata.get(row_num).get("ApplicantWagesBeforeTaxesThisYear");
                    enterApplicantWages(applicantwages);

                    String spousewages = testdata.get(row_num).get("SpouseWagesBeforeTaxesThisYear");
                    enterSpouseWages(spousewages);

                    String applicantnetearnings = testdata.get(row_num).get("ApplicantNetEarnings");
                    enterApplicantNetEarning(applicantnetearnings);

                    String spousenetearnings = testdata.get(row_num).get("SpouseNetEarnings");
                    enterSpouseNetEarning(spousenetearnings);

                    String amountvarystatusvalue = testdata.get(row_num).get("AmountVaryStatus");
                    selectAmoutVaryStatus(amountvarystatusvalue);

                    String applicantlastwroking = testdata.get(row_num).get("ApplicantLastWorkingMonthAndYear");
                    enterApplicantLastWorkingMonthAndYear(applicantlastwroking);

                    String spouselastwroking = testdata.get(row_num).get("SpouseLastWorkingMonthAndYear");
                    enterSpouseLastWorkingMonthAndYear(spouselastwroking);

                    String applicantageincome = testdata.get(row_num).get("ApplicantAgeIncomelimit");
                    selectApplicantYoungerStatus(applicantageincome);

                    String spouseageincome = testdata.get(row_num).get("SpouseAgeIncomelimit");
                    selectSpouseYoungerStatus(spouseageincome);
                }


            }

        }  catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    @When("user clicks on Next button in application questions field")
    public void user_clicks_on_next_button_in_application_questions_field() {
        clickOnAppQesNextBtn();
        waitupto(1000);
    }

    @When("user fills Representative Information from given sheet name {string} and {int}")
    public void user_fills_representative_information_from_given_sheet_name_and(String sheetname, Integer rownum) {
        ExcelReader reader = new ExcelReader();
        try {
            List<Map<String,String>> testdata = reader.getData(FrameworkConstants.getExcelFilePath(),sheetname);
            String addpresonalRepresentative = testdata.get(rownum).get("AddPersonalRepresentative");
            if (addpresonalRepresentative.equalsIgnoreCase("Yes")){
                //selecting yes or no
                selectAddRepresentativeOption(addpresonalRepresentative);
                // clicking on 'Add New Representative'
                clickOnAddNewRepresentative();
                // Selecting Rep Prefix
                String repprefix = testdata.get(rownum).get("Prefix");
                selectRepPrefix(repprefix);
                // Entering Rep FirstName
                String repfirstname = testdata.get(rownum).get("FirstName");
                enterRepFirstName(repfirstname);
                // Entering Rep MiddleName
                String repmiddlename = testdata.get(rownum).get("MiddleName");
                enterRepMiddleName(repmiddlename);
                // Entering Rep LastName
                String replastname = testdata.get(rownum).get("LastName");
                enterRepLastName(replastname);
                // selecting Rep suffix
                String repsuffix = testdata.get(rownum).get("Suffix");
                selectRepSuffix(repsuffix);
                // entering Rep SSN
                String repssn = testdata.get(rownum).get("SocialSecurityNumber");
                enterRepSSN(repssn);
                // selecting Relationship of Rep with applicant
                String reprelation = testdata.get(rownum).get("RelationshipToApplicant");
                selectRepRelation(reprelation);

                // selecting correspondenc of Rep
                String repcorrespondence = testdata.get(rownum).get("Correspondence");
                selectRepCorrespondence(repcorrespondence);

                // selecting Rep aut for purpose one
                String repauthpurposeone = testdata.get(rownum).get("AuthToPersonsOtherThanMyself");
                selectRepAuthPurposeOne(repauthpurposeone);

                // selecting Rep aut for purpose Two
                String repauthpurposetwo = testdata.get(rownum).get("AuthToReportMyAddress");
                selectRepAuthPurposeTwo(repauthpurposetwo);

                // selecting Rep aut for purpose Three
                String repauthpurposethree = testdata.get(rownum).get("AuthToReviewMyBenefits");
                selectRepAuthPurposeThree(repauthpurposethree);

                // selecting Rep aut for purpose four
                String repauthpurposefour = testdata.get(rownum).get("AuthToDiscussPamentsAndPremiums");
                selectRepAuthPurposefour(repauthpurposefour);

                //  entering rep cellnumber
                String repcellnumber = testdata.get(rownum).get("CellPhone");
                enterRepCellNumber(repcellnumber);

                // entering  rep work phone number
                String repworknumber = testdata.get(rownum).get("WorkPhone");
                enterRepWorkPhNumber(repworknumber);

                // entering rep phone extension
                String repphexnumber = testdata.get(rownum).get("PhoneEx");
                enterRepPhExtenNumber(repphexnumber);

                // entering rep home phone number
                String rephomenumber = testdata.get(rownum).get("HomePhone");
                enterRepHomePhNumber(rephomenumber);

                // entering rep fax number
                String repfaxnumber = testdata.get(rownum).get("FaxNumber");
                enterRepFaxNumber(repfaxnumber);

                // entering rep email id
                String repemailid = testdata.get(rownum).get("EmailAddress");
                enterRepEmailid(repemailid);
                // uploading power of attorney
                uploadPowerOfAttorney();
                // clicking on submit button
                clickOnSubmitBtn();

            }else if (addpresonalRepresentative.equalsIgnoreCase("No")){
                String value = DriverManager.getDriver().findElement(optionNoRadBtn).getAttribute("checked");
                if (value.equalsIgnoreCase("checked")){
                    System.out.println("Option NO has selected");
                }
            }

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @When("user clicks on Next button in Representative Information field")
    public void user_clicks_on_next_button_in_representative_information_field() {
       waitupto(1000);
        clickOnRepInfoNextBtn();
    }

    @When("user fills Houserhold income Information from given sheet name {string} and {int}")
    public void user_fills_houserhold_income_information_from_given_sheet_name_and(String sheetname, Integer rownumber) {
             // click on Add new house hold income info
            waitupto(500);
            clickOnHouseHoldIncomeLink();

        ExcelReader reader = new ExcelReader();
        try {
            List<Map<String,String>> testdata = reader.getData(FrameworkConstants.getExcelFilePath(),sheetname);
            // selecting house hold income type
            String incometypevalue = testdata.get(rownumber).get("IncomeType");
            waitupto(500);
            selectIncomeType(incometypevalue);
            //entering Applicant income value
            String applicantincome = testdata.get(rownumber).get("ApplicantIncome");
            enterApplicantIncome(applicantincome);
            //entering spouse income value
            String spouseincome = testdata.get(rownumber).get("SpouseIncome");
            enterspouseIncome(spouseincome);
            //entering other memember income value
            String othermemberincome = testdata.get(rownumber).get("OtherMembersIncome");
            enterOtherMemIncome(othermemberincome);
            waitupto(500);
            // validating total value
            Assertions.assertThat(toalIncomeValue()).isEqualTo(getTotalTaxValue());
            waitupto(500);
            //selecting proof submission status
            String proofsubmissionstatus = testdata.get(rownumber).get("ProofSubmitted");
            if (proofsubmissionstatus.equalsIgnoreCase("Yes")){
                selectProofSubmissionValue(proofsubmissionstatus);
                uploadPoof();
                clickOnHouseHoldIncomeSubmit();
            }else if (proofsubmissionstatus.equalsIgnoreCase("No")){
                selectProofSubmissionValue(proofsubmissionstatus);
                clickOnHouseHoldIncomeSubmit();
            }

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("user clicks on Next button in Household income field")
    public void user_clicks_on_next_button_in_household_income_field() {
        clickOnHouseHoldNextBtn();
    }

    @When("user fills attachments Information from given sheet name {string} and {int}")
    public void user_fills_attachments_information_from_given_sheet_name_and(String sheetname, Integer rownum) {
            ExcelReader reader = new ExcelReader();
        try {
            List<Map<String,String>> testdata = reader.getData(FrameworkConstants.getExcelFilePath(),sheetname);
            clickOnAddNewDocuument();
            waitupto(500);
            String doctype = testdata.get(rownum).get("DocumentType");
            selectDocumentType(doctype);
            waitupto(500);
            String docname = testdata.get(rownum).get("DocumentName");
            enterDocumentName(docname);

            uploadDocument();

            String confi = testdata.get(rownum).get("Confidential");
            selectConfidentialOption(confi);

            String exibit = testdata.get(rownum).get("Exhibit");
            selectExibitProofOption(exibit);

            String descriptionvalue = testdata.get(rownum).get("Description");
            enterDescription(descriptionvalue);

            clickOnAddDocSaveBtn();

        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    @When("user clicks on Next button in attachment field")
    public void user_clicks_on_next_button_in_attachment_field() {
        clickOnAttachmentNextBtn();
        waitupto(1000);
    }


    @When("user user accepts the declaration")
    public void user_user_accepts_the_declaration() {
        waitupto(1000);
        clickOnDeclaration();
        waitupto(500);
    }

    @When("user click on submit button to confim the application")
    public void user_click_on_submit_button_to_confim_the_application() {
        clickOnFinalSubmit();
        waitupto(2000);
    }
}
