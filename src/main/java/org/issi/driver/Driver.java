package org.issi.driver;

import org.issi.enums.ConfigProperties;
import org.issi.factory.DriverFactory;
import org.issi.utilities.PropertyUtils;

import java.net.MalformedURLException;
import java.util.Objects;


public final class Driver {
    /*
     *  private constructor to avoid external instantiation
     */
    private Driver() {
    }

    public static void initDriver(String browser) {
       // ExtentReport.createExtentTest("Driver initiate");
        if (Objects.isNull(DriverManager.getDriver())) {
            final String DRIVERLAUNCHMESSAGE = "" + browser + " driver was started successfully";
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser)); //  if it is local you can invoke the browser in this way
                System.out.println(DRIVERLAUNCHMESSAGE);
            } catch (MalformedURLException e) {
            throw new RuntimeException("Browser Invocation was failed");
            }
            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
          //  ExtentLogger.pass("Entered url as : " + PropertyUtils.getValue(ConfigProperties.URL));
        }

    }

    /**
     * Terminates the browser instance. Sets the threadlocal to default value, i.e null.
     *
     */
    public static void quiteDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            //ExtentLogger.pass(" " + PropertyUtils.getValue(ConfigProperties.BROWSER) + " driver was closed");
            DriverManager.unload();
        }

    }
}
