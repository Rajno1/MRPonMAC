package org.issi.factory;


import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;
import org.issi.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Explicit wait factory produces different waits before operating on webelement
 */
public final class ExplicitWaitFactory {

    /**
     * Private constructor to avoid external instantiation
     */
    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicitWait(By by, WaitStrategy waitstrategy) {

        WebElement element = null;
        if (waitstrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitstrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if(waitstrategy == WaitStrategy.VISIBLE){
            element =  new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if(waitstrategy == WaitStrategy.NONE){
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }
}
