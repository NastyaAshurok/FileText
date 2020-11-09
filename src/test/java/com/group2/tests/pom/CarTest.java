package com.group2.tests.pom;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


public class CarTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void cartTest(){
        loginPage.login("valid", "valid");

        $("cart").click();
        //validate
    }
}

