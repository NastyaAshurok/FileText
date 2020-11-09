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



@Test
    public void login1test(){
       loginPage.login("anastasiaashurok", "***");
       $("sendMessage").click();
       Assert.assertTrue(loginPage.isLoginPerformedCorrectly());
       loginPage.sendMessage("Hello");
    }

    @Test
    public void login2test(){
        loginPage.login("invalid", "invalid");

    }
}
