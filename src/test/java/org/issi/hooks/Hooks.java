package org.issi.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.issi.driver.Driver;
import org.issi.driver.DriverManager;
import org.issi.enums.ConfigProperties;
import org.issi.utilities.PropertyUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class is used to define pre and post conditions
 */
public class Hooks {

    @Before(order = 1)
    public void launchBrowser() {
        Driver.initDriver(PropertyUtils.getValue(ConfigProperties.BROWSER));
    }

    @After(order = 0)
    public void quitBrowser() {
        Driver.quiteDriver();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }
}
