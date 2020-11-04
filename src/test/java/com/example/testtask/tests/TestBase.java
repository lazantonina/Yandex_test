package com.example.testtask.tests;

import com.example.testtask.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeClass
    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m){
        logger.info("Start test " + m.getName());
    }

    @AfterMethod
    public void stopTest(Method m){
        logger.info("Stop test " + m.getName());
    }

    @AfterClass
    public void tearDown(){
        app.stop();
    }

}
