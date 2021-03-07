package org.issi.pages;

import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class ApplicationAttachmentsPage extends BasePage{
    public ApplicationAttachmentsPage() {
    }
    // clicking on Add new document link
    private static final By addNewDocumetnLink = By.xpath("//a[@id='0']");
    public static void clickOnAddNewDocuument(){
        waitupto(500);
        clickOn(addNewDocumetnLink, WaitStrategy.CLICKABLE,"Add new document");
        waitupto(1000);
    }

    // select document type value
    private static final By documentTypeDrpDwn =By.xpath("//select[@id='ddlDocumentType']");
    public static void selectDocumentType(String docType){
        selectFromDrpDwn(documentTypeDrpDwn,WaitStrategy.CLICKABLE,docType,"document type");
        waitupto(500);
    }

    // enter document name
    private static final By docnameText = By.xpath("//input[@id='txtDocumentName']");
    public static void enterDocumentName(String docuName){
        enterText(docnameText,docuName,WaitStrategy.PRESENCE,"Document Name");
        waitupto(500);
    }

    // uploading document
    private static final By uploadDocuBtn = By.xpath("//input[@id='fileuploadDocuments']");
    public static void uploadDocument(){
        enterText(uploadDocuBtn, FrameworkConstants.getPowerOfAttorneyFormPath(),WaitStrategy.CLICKABLE,"added attachment");
        waitupto(500);
    }

    // selecting confiditial opition
    private static final By confidentialYesRadBtn = By.xpath("//input[@id='rbtnConfidentialYes']");
    private static final By confidentialNoRadBtn = By.xpath("//input[@id='rbtnConfidentialNo']");
    public static void selectConfidentialOption(String confiValue){
        if (confiValue.equalsIgnoreCase("Yes")){
            clickOn(confidentialYesRadBtn,WaitStrategy.CLICKABLE,"Yes");
            waitupto(500);
        }else if (confiValue.equalsIgnoreCase("No")){
            clickOn(confidentialNoRadBtn,WaitStrategy.CLICKABLE,"NO");
            waitupto(500);
        }
    }

    // selecting Exibit proof opition
    private static final By exibitProofYesRadBtn = By.xpath("//input[@id='rbtnExproffsubmittedYes']");
    private static final By exibitProofNoRadBtn = By.xpath("//input[@id='rbtnExproffsubmittedNo']");
    public static void selectExibitProofOption(String exibiProfValue){
        if (exibiProfValue.equalsIgnoreCase("Yes")){
            clickOn(exibitProofYesRadBtn,WaitStrategy.CLICKABLE,"Yes");
            waitupto(500);
        }else if (exibiProfValue.equalsIgnoreCase("No")){
            clickOn(exibitProofNoRadBtn,WaitStrategy.CLICKABLE,"NO");
            waitupto(500);
        }
    }

    // Description
    private static final By descriptionTextArea = By.xpath("//textarea[@id='txtDescription']");
    public static void enterDescription(String description){
        enterText(descriptionTextArea,description,WaitStrategy.PRESENCE,"Description");
        waitupto(500);
    }

    // click on Add document save button
    private static final By addDocSaveBtn = By.xpath("//input[@onclick='Save();']");
    public static void clickOnAddDocSaveBtn(){
        clickOn(addDocSaveBtn,WaitStrategy.CLICKABLE,"Save");
        waitupto(1000);
    }

    // click on attachment Next button
    private static final By attachmentNext = By.xpath("//button[@id='nextDocumentsBtn']");
    public static void clickOnAttachmentNextBtn(){
        clickOn(attachmentNext,WaitStrategy.CLICKABLE,"Attachment Next Button");
        waitupto(1000);
    }

    // accept declaration
    private static final By declarationBtn = By.xpath("//input[@id='ckbConfirmation']");
    public static void clickOnDeclaration(){
        waitupto(500);
        scrollByElement(declarationBtn,WaitStrategy.CLICKABLE);
        clickOn(declarationBtn,WaitStrategy.CLICKABLE,"Declaration");
        waitupto(500);
    }

    // clicking on final submission
    private static final By finalsubBtn = By.xpath("//button[@id='btnSubmit']");
    public static void clickOnFinalSubmit(){
        waitupto(500);
        scrollByElement(finalsubBtn,WaitStrategy.CLICKABLE);
        clickOn(finalsubBtn,WaitStrategy.CLICKABLE,"Final sumbit");

    }
}
