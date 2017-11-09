package com.tuenti;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.tuenti.config.DriverType;

import static com.tuenti.config.DriverType.FIREFOX;
import static com.tuenti.config.DriverType.valueOf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverManager {

    private static WebDriver driver;
    private final DriverType defaultDriverType = FIREFOX;
    private DriverType actualDriverType;
    
    @BeforeSuite
    public void instantiateDriverObject() {
    	actualDriverType=determineEffectiveDriverType(System.getProperty("browser").toUpperCase());
    	driver=actualDriverType.getWebDriverObject();
    }

    private DriverType determineEffectiveDriverType(String browser) {
        DriverType driverType = defaultDriverType;
        try {
            driverType = valueOf(browser);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverType + "'...");
        }
        return driverType;
    }
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public DriverType getDriverType() {
        return actualDriverType;
    }
    @AfterMethod
    public void clearCookies() throws Exception {
        getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}