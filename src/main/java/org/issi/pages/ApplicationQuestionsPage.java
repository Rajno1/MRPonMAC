package org.issi.pages;

import org.issi.enums.WaitStrategy;
import org.issi.utilities.DynamicXpathUtils;
import org.openqa.selenium.By;

public final class ApplicationQuestionsPage extends BasePage{

    private ApplicationQuestionsPage() {
    }


    // Selecting House Hold members
    private static String housHoldXpath ="//label[contains(text(),'%s')]"; //%s discribes that can be any string will come to this place

    public static void selectHouseHoldMemValue(String numOfHouseHolds){
        String newXpath = DynamicXpathUtils.getXpath(housHoldXpath,numOfHouseHolds);
       clickOn(By.xpath(newXpath), WaitStrategy.CLICKABLE,numOfHouseHolds);
       waitupto(500);
    }

    // Selecting SPDAP income eligibility level
   private static String spdapIncmElgXpath = "//label[contains(text(),'%s')]/input[@id='2']";
    public static void selectSPDAPIncomElgibility(String elgStatus){
        String newXpath = DynamicXpathUtils.getXpath(spdapIncmElgXpath,elgStatus);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,elgStatus);
        waitupto(500);
    }

    // Select Federal Incometax returns
    private static String federalIncometaxXpath = "//label[contains(text(),'%s')]/input[@id='3']";
    public static void selectFederalIncometaxReturns(String fisstatus){
        String newXpath = DynamicXpathUtils.getXpath(federalIncometaxXpath,fisstatus);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,fisstatus);
        waitupto(500);
    }

    // Select Other prescription drug coverage
    private static String otherPrescriptionXpath = "//label[contains(text(),'%s')]/input[@id='4']";
    private static final By otherplaninfo = By.xpath("//input[@id='5']");
    public static void selectOtherPrescriptonCoverageInfo(String otherPrescriptionStatus,String plan){
        String newXpath = DynamicXpathUtils.getXpath(otherPrescriptionXpath,otherPrescriptionStatus);
        if (otherPrescriptionStatus.equals("YES")){
            clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,otherPrescriptionStatus);
            waitupto(500);
            enterText(otherplaninfo,plan,WaitStrategy.PRESENCE,plan);
            waitupto(500);
        }else if (otherPrescriptionStatus.equals("NO")){
            clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,otherPrescriptionStatus);
            waitupto(500);
        }
    }

    // selecting Extra help application status
    private static String extrahelpXpath = "//label[contains(text(),'%s')]/input[@id='6']";
    public static void selectExtraHelpStatus(String extrahelpstatus){
        String newXpath = DynamicXpathUtils.getXpath(extrahelpXpath,extrahelpstatus);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,extrahelpstatus);
        waitupto(500);
    }

    // selecting single Investment worth option
    private static String singleinvestmentworthXpath = "//label[contains(text(),'%s')]/input[@id='7']";
    public static void selectSingleInvestmentWorthOption(String singleinvestmentworth){
        String newXpath = DynamicXpathUtils.getXpath(singleinvestmentworthXpath,singleinvestmentworth);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,singleinvestmentworth);
        waitupto(500);
    }

    // selecting Married Investment worth option
    private static String changableXpath = "//label[contains(text(),'%s')]/input[@id='8']";
    public static void selectMarriedInvestmentWorthOption(String value){
        String newXpath = DynamicXpathUtils.getXpath(changableXpath,value);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,value);
        waitupto(500);
    }

    // Enter dollar value in Bank Ac investments
    private static final By dollarValueOfBankAcText = By.xpath("//input[@id='10']");
    public static void enterBankAcInvestmentvalue(String dollarValue){
        enterText(dollarValueOfBankAcText,dollarValue,WaitStrategy.PRESENCE,"Bank Investments");
        waitupto(500);
    }

    // Enter dollar value in stock and other investments
    private static final By dollarValueOfStockAndOtherText = By.xpath("//input[@id='11']");
    public static void enterStockAndOtherInvestmentvalue(String dollarValue){
        enterText(dollarValueOfStockAndOtherText,dollarValue,WaitStrategy.PRESENCE,"Stock and other Investments");
        waitupto(500);
    }

    // Enter cash at home
    private static final By cashathomeText = By.xpath("//input[@id='12']");
    public static void enterOtherCashInvestmetnsValue(String dollarValue){
        enterText(cashathomeText,dollarValue,WaitStrategy.PRESENCE,"cash information");
        waitupto(500);
    }

    // select money usage option for funeral of Applicant
    private static String applicantmoneyUsageXpath = "//label[contains(text(),'%s')]/input[@id='14']";
    public static void selectMoneyUsageOptionForFuneralOfApplicant(String option){
        String newXpath = DynamicXpathUtils.getXpath(applicantmoneyUsageXpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    // select money usage option for funeral of Spouse
    private static String spousemoneyusageXpath = "//label[contains(text(),'%s')]/input[@id='15']";
    public static void selectMoneyUsageOptionForFuneralOfSpouse(String option){
        String newXpath = DynamicXpathUtils.getXpath(spousemoneyusageXpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    // Selecting Applicant real estate information
    private static String applicantrealestateXpath = "//label[contains(text(),'%s')]/input[@id='17']";
    public static void selectRealEstateInfoOfApplicant(String option){
        String newXpath = DynamicXpathUtils.getXpath(applicantrealestateXpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    // Selecting Spouse real estate information
    private static String spouserealestateXpath = "//label[contains(text(),'%s')]/input[@id='18']";
    public static void selectRealEstateInfoOfSpouse(String option){
        String newXpath = DynamicXpathUtils.getXpath(spouserealestateXpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    // Enter monthly income receiving from Social security
    private static final By monthlyincomefrmSSText = By.xpath("//input[@id='20']");
    public static void enterMonthlyIncomeFrmSocialSecurity(String incomfrmSS){
        enterText(monthlyincomefrmSSText,incomfrmSS,WaitStrategy.PRESENCE,"Monthly income from Social security");
        waitupto(500);
    }

    // Enter monthly income receiving from Railroad Retirement
    private static final By monthlyincomefrmRRText = By.xpath("//input[@id='21']");
    public static void enterMonthlyIncomeFrmRailRoadRetire(String incomfrmRR){
        enterText(monthlyincomefrmRRText,incomfrmRR,WaitStrategy.PRESENCE,"Monthly income from RailRoad Retirement");
        waitupto(500);
    }

    // Enter monthly income receiving from Veterans
    private static final By monthlyincomefrmVeteransText = By.xpath("//input[@id='22']");
    public static void enterMontlyIncomeFrmVeterans(String incomfrmVerterna){
        enterText(monthlyincomefrmVeteransText,incomfrmVerterna,WaitStrategy.PRESENCE,"Monthly income from Veterna");
        waitupto(500);
    }

    // Enter monthly income receiving from other pensions
    private static final By monthlyincomefrmOtherPensionText = By.xpath("//input[@id='23']");
    public static void enterMontlyIncomeFrmOtherPension(String incomfrmOther){
        enterText(monthlyincomefrmOtherPensionText,incomfrmOther,WaitStrategy.PRESENCE,"Monthly income from other pensions");
        waitupto(500);
    }

    // Enter other monthly income receiving from not listed
    private static final By monthlyincomefrmNotListedText = By.xpath("//input[@id='24']");
    public static void enterMonthlyIncomeFrmNotListed(String incomfrmNotlisted){
        enterText(monthlyincomefrmNotListedText,incomfrmNotlisted,WaitStrategy.PRESENCE,"Monthly income from not listed");
        waitupto(500);
    }

    // selecting is amount entered in ques 10 decrease from last 2 years or not
    private static String ques10amoutvariXpath = "//label[contains(text(),'%s')]/input[@id='25']";
    public static void selectAmountDecreStatus(String option){
        String newXpath = DynamicXpathUtils.getXpath(ques10amoutvariXpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    // selecting applicant work status of last two years
    private static String appliant2yearsXpath = "//label[contains(text(),'%s')]/input[@id='27']";
    public static void selectApplicantLast2YearsExp(String option){
        String newXpath = DynamicXpathUtils.getXpath(appliant2yearsXpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    // selecting spouse work status of last two years
    private static String spouse2yearsXpath = "//label[contains(text(),'%s')]/input[@id='28']";
    public static void selectSpouseLast2YearsExp(String option){
        String newXpath = DynamicXpathUtils.getXpath(spouse2yearsXpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    // if married enter spouse ssn
    private static final By spousessnText = By.xpath("//input[@id='29']");
    public static void enterSpouseSSN(String spousessn){
        enterText(spousessnText,spousessn,WaitStrategy.PRESENCE,"Spouse SSN");
        waitupto(500);
    }

    // Enter Applicant wages before taxes this year
    private static final By applicantWagesText = By.xpath("//input[@id='31']");
    public static void enterApplicantWages(String applicantwages){
        enterText(applicantWagesText,applicantwages,WaitStrategy.PRESENCE,"Applicant Wages");
        waitupto(500);
    }

    // Enter Spouse wages before taxes this year
    private static final By spouseWagesText = By.xpath("//input[@id='32']");
    public static void enterSpouseWages(String spousewages){
        enterText(spouseWagesText,spousewages,WaitStrategy.PRESENCE,"Spouse Wages");
        waitupto(500);
    }

    // Enter Applicant Net earning this year
    private static final By applicantNetEarnText = By.xpath("//input[@id='34']");
    public static void enterApplicantNetEarning(String applicantnetearn){
        enterText(applicantNetEarnText,applicantnetearn,WaitStrategy.PRESENCE,"Applicant net earning");
        waitupto(500);
    }

    // Enter Spouse Net earning this year
    private static final By spouseNetEarnText = By.xpath("//input[@id='35']");
    public static void enterSpouseNetEarning(String spousenetearn){
        enterText(spouseNetEarnText,spousenetearn,WaitStrategy.PRESENCE,"Spoouse net earning");
        waitupto(500);
    }

    // select decreased status of amount entered in Ques 14 & 15
    private static String amountVarfrmQes1415Xpath = "//label[contains(text(),'%s')]/input[@id='36']";
    public static void selectAmoutVaryStatus(String option){
        String newXpath = DynamicXpathUtils.getXpath(amountVarfrmQes1415Xpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    // enter applicant last working month and year
    private static final By applicantLastworkingText = By.xpath("//input[@id='38']");
    public static void enterApplicantLastWorkingMonthAndYear(String applicantWorking){
        enterText(applicantLastworkingText,applicantWorking,WaitStrategy.PRESENCE,"Applicant Last working month and year");
        waitupto(500);
    }

    // enter spouse last working month and year
    private static final By spouseLastworkingText = By.xpath("//input[@id='39']");
    public static void enterSpouseLastWorkingMonthAndYear(String spousetWorking){
        enterText(spouseLastworkingText,spousetWorking,WaitStrategy.PRESENCE,"Spouse Last working month and year");
        waitupto(500);
    }

    //selecting income limit of applicant if younger than 65
    private static String applicantYoungXpath = "//label[contains(text(),'%s')]/input[@id='41']";
    public static void selectApplicantYoungerStatus(String option){
        String newXpath = DynamicXpathUtils.getXpath(applicantYoungXpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    //selecting income limit of spouse if younger than 65
    private static String spouseYoungXpath = "//label[contains(text(),'%s')]/input[@id='42']";
    public static void selectSpouseYoungerStatus(String option){
        String newXpath = DynamicXpathUtils.getXpath(spouseYoungXpath,option);
        clickOn(By.xpath(newXpath),WaitStrategy.CLICKABLE,option);
        waitupto(500);
    }

    // Clicking on Next button in Application Questions tab
    public static final By appQuesNextBtn = By.xpath("//button[contains(text(),'Next')]");
    public static void clickOnAppQesNextBtn(){
        clickOn(appQuesNextBtn,WaitStrategy.CLICKABLE,"Next Button in Application Questions");
    }

}
