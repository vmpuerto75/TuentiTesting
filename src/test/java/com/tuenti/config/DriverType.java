package com.tuenti.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.HashMap;


public enum DriverType implements DriverSetup{

    FIREFOX {
        public WebDriver getWebDriverObject() {
            return new FirefoxDriver(DesiredCapabilities.firefox());
        }
    },
    CHROME {
        public WebDriver getWebDriverObject() {
            return new ChromeDriver(DesiredCapabilities.chrome());
        }
    },
    IE {
        public WebDriver getWebDriverObject() {
            return new InternetExplorerDriver(DesiredCapabilities.internetExplorer());
        }
    };
}