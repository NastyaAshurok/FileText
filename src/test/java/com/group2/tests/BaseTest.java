package com.group2.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

//import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

import java.net.HttpCookie;

@Listeners({TestListener.class})

public class BaseTest {

    private static Logger log = LoggerFactory.getLogger(BaseTest.class);

    public static void main(String[] args) {


        //log.

        try{
            Integer.parseInt("dfsdgsg");
        }catch (NumberFormatException e){
            log.error("Port number paring failue.", e);
        }

        log.info("dfsdfsd");
        log.debug("Debug log message");
//        log.info("Info log message");
//        log.error("Error log message");
//        log.warn("AAAA");
    }

    @Test
    public void Login()
    {
        open("https://e-dostavka.by/");
        SoftAssert softAssert = new SoftAssert();
        String searchLocator = "//div[@class='main_menu__inner']//i[@class='fa fa-search']";
        $(By.xpath(searchLocator)).click();
    }

    @BeforeMethod
    public void globalBefore(){

    }
}