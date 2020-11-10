package com.group2.tests.pom;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import org.testng.annotations.DataProvider;

import java.net.HttpCookie;
public class LoginTest {
LoginPage loginPage = new LoginPage();

    @DataProvider(name = "XMLFileLoader")
    public static Object[][] getDataFromXmlFile() {
        String fileName = "/path/to/file.xml";
        String encoding = "UTF-8";

        return loadDataFromXmlFile(fileName, encoding);
    }

    private static Object[][] loadDataFromXmlFile(final String fileName, final String encoding) {
        // implementation omitted for brevity
    }

@Test
    public void login1test(){
       loginPage.login("anastasiaashurok", "***");
       //Assert.assertTrue(loginPage.isLoginPerformedCorrectly());
       loginPage.sendEmail("anastasiaashurok@yandex.by", "Hello");
       loginPage.openEmail();
    }

    @Test(dataProvider = "jsonMessageParser", dataProviderClass = JsonMessageParser.class)
    public void login3test(){
        loginPage.login("anastasiaashurok2", "***");
        //Assert.assertTrue(loginPage.isLoginPerformedCorrectly());
        loginPage.sendEmail("anastasiaashurok@yandex.by", "Hello");
        loginPage.openEmail();
    }

    @Test
    public void login2test(){
        loginPage.login("invalid", "invalid");

    }
}
