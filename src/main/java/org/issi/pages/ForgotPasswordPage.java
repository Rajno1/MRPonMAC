package org.issi.pages;

import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends BasePage{
    private static final By forgotpwdBtn = By.xpath("//a[contains(text(),' Forgot Password')]");
    private static final By e_mail = By.xpath("//input[@id='txtemail']");
    private static final By forgotpswSubmitBtn = By.xpath("//input[@onclick='ForgotPasswordClick()']");

    public static boolean isForgotPwdlinkExist(){
        waitupto(500);
        return DriverManager.getDriver().findElement(forgotpwdBtn).isDisplayed();
    }
    public static void clickOnForgotPassword(){
        clickOn(forgotpwdBtn, WaitStrategy.CLICKABLE,"Forgot Password Button");
        waitupto(500);
    }
    public static void enterEmailIdToResetPwd(String regEmail){
        enterText(e_mail,regEmail,WaitStrategy.PRESENCE,"Email id");
        waitupto(500);
    }
    public static void clickOnForgotPswSubmitBtn(){
        clickOn(forgotpswSubmitBtn,WaitStrategy.CLICKABLE,"Submit button on forgot password page");
        waitupto(500);
    }
}
