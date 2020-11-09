package com.group2.tests.pom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement login = $("login");
    SelenideElement pass = $("pass");
    SelenideElement submit = $("submit");
    SelenideElement logoutButton = $("logout");

    public void login(String u, String p){
        login.setValue(u);
        pass.setValue(p);
        submit.click();
    }

    public boolean isLoginPerformedCorrectly(){
        return login.isDisplayed();
    }

    public void logout(String u, String p){
        login.setValue(u);
        pass.setValue(p);
        logoutButton.click();
    }
}
