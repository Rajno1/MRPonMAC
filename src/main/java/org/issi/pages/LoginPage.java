package org.issi.pages;

import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    //constructor
    public LoginPage() {
    }


    //By locators
    private static final By loginUsernameText = By.id("userName");
    private static final By loginPasswordText = By.id("password");
    private static final By loginBtn = By.id("submit");


    //page actions
    public String getLoginPageTitle(){
        return getPage_Title();
    }

    public void enterUserName(String usrnm){
        enterText(loginUsernameText,usrnm, WaitStrategy.PRESENCE,"Login username");
        waitupto(500);
    }
    public void enterPassword(String pwd){
       enterText(loginPasswordText,pwd,WaitStrategy.PRESENCE,"Login Password");
       waitupto(500);
    }
    public void clickOnLogin(){
        clickOn(loginBtn,WaitStrategy.CLICKABLE,"Login Button");
        waitupto(500);
        //DriverManager.getDriver().findElement(buttonLogin).click();
    }


    public static PersonalInfoPage doLogin(String un, String pwd){
      //  System.out.println("Login with : " + un + "and" + pwd);
        DriverManager.getDriver().findElement(loginUsernameText).sendKeys(un);
        DriverManager.getDriver().findElement(loginPasswordText).sendKeys(pwd);
        DriverManager.getDriver().findElement(loginBtn).click();
        return new PersonalInfoPage();
    }

}
