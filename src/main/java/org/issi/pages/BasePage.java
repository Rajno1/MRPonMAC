package org.issi.pages;


import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.issi.factory.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class BasePage {

    public static void clickOn(By by, WaitStrategy waitstrategy, String elementName) {
       WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
       try {
           element.click();
       }catch (Exception e){
           JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
           js.executeScript("arguments[0].click();",element);
       }

        System.out.println(" Clicked on " +elementName );
    }
    // to work on org.openqa.selenium.ElementClickInterceptedException i am writing this another click method using actions
    public static void clickOnAction(By by,WaitStrategy waitStrategy,String elementName){
        Actions act = new Actions(DriverManager.getDriver());
        act.moveToElement(DriverManager.getDriver().findElement(by)).click().perform();
    }

    public static void enterText(By by, String value,WaitStrategy waitstrategy, String elementName) {
        WebElement element =ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        element.sendKeys(value);
        System.out.println("Entered  "+elementName+" as "+value);
    }

    public static void selectFromDrpDwn(By by,WaitStrategy waitStrategy,String value,String elementName){
        DriverManager.getDriver().findElement(by);
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.click();
        Select select = new Select(element);
        List<WebElement> allOptions = select.getOptions();
        for (int i=0;i<allOptions.size();i++){
            WebElement option = allOptions.get(i);
            String optionValue = option.getText();
            if (optionValue.equalsIgnoreCase(value)){
                select.selectByVisibleText(value);
            }
        }
        System.out.println("selected  "+elementName+" as "+value);
    }

    public static void selectDate(By by,WaitStrategy waitStrategy){
        DriverManager.getDriver().findElement(by);
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.click();

    }
    public static void scrollByElement(By by,WaitStrategy waitstrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        element = DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",element);
    }


    public static String switchToWindow(String previousWindowId){
        Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!previousWindowId.equals(windowHandle)) {
                DriverManager.getDriver().switchTo().window(windowHandle);
            }
        }
        return DriverManager.getDriver().getWindowHandle();

    }


    protected void menuItemDrpDwn(By by, String enterMenuItem){
        try {
            List<WebElement> menuList = DriverManager.getDriver().findElements(by);
            for (int i = 0; i < menuList.size(); i++) {
                String menuItem = menuList.get(i).getText();
                if (menuItem.equals(enterMenuItem)) {
                    menuList.get(i).click();
                    System.out.println("Selected "+enterMenuItem+" option from menu");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void mouseOver(By by,WaitStrategy waitstrategy,String elementName){
        WebElement element =ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        element = DriverManager.getDriver().findElement(by);
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(element).perform();
        System.out.println("Mouse overed on "+elementName+"");
    }


    public static void waitupto(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getPage_Title() {
        return DriverManager.getDriver().getTitle();
    }




}
