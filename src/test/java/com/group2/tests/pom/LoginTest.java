package com.group2.tests.pom;

import com.codeborne.selenide.SelenideElement;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import lombok.Data;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.*;
import org.testng.asserts.SoftAssert;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.Data;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

import java.io.IOException;
import java.net.HttpCookie;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class LoginTest {
LoginPage loginPage = new LoginPage();

 /*   @DataProvider(name = "XMLFileLoader")
    public static Object[][] getDataFromXmlFile() {
        String fileName = "/path/to/file.xml";
        String encoding = "UTF-8";

        return loadDataFromXmlFile(fileName, encoding);
    }

    private static Object[][] loadDataFromXmlFile(final String fileName, final String encoding) {
        // implementation omitted for brevity
    } */

    private static final String filePath = "src/test/resources/message.json";

Faker faker = new Faker(new Locale("ru"));
String messageRandom = faker.bothify("????TestMessage");
    @Test
    public void sendRandomMessage(){
        loginPage.login("anastasiaashurok", "***");
        Assert.assertTrue(loginPage.isLoginPerformedCorrectly());
        loginPage.sendEmail("anastasiaashurok@yandex.by", messageRandom);
        loginPage.openEmail();
    }

    @Data
    public static class EmailData{
        String login;
        String pass;
        List<Message> messages;
    }
    @Data
    public static class Message{
        String recipient;
        String title;
        String body;
    }
   static ObjectMapper mapper = new ObjectMapper();
    private static EmailData getEmailData() throws IOException {
        EmailData emailData = mapper.readValue(Paths.get(filePath).toFile(), EmailData.class);
        return emailData;
    }

    @DataProvider
    public Object[][] sender() throws IOException {    //args: String login, String password

        EmailData emailData = getEmailData();

        Object[][] loginData = new Object[1][2];
        loginData[0][0] = emailData.getLogin();
        loginData[0][1] = emailData.getPassword();

        return loginData;

    }

    @DataProvider
    public Object[][] message() throws IOException { // message

        EmailData emailData = getEmailData();
        Object[][] messageData = new Object[emailData.getMessages().size()][1];
        for (int i = 0; i < emailData.getMessages().size(); i++) {
            Message m = emailData.getMessages().get(i);
            messageData[i][0] = m;
        }

        return messageData;
    }

    @DataProvider
    public Object[][] message2() throws IOException { // message

        EmailData emailData = getEmailData();
        Object[][] messageData = new Object[1][1];
        List<Message> mess = emailData.getMessages();
        messageData[0][0] = mess;
        return messageData;
    }

    @Test(dataProvider = "sender")
    public void login(String login, String password){
        System.out.println(login + " "+password);
    }

    @Test(dataProvider = "message")
    public void message(Message message){
        String rec = "$()";
        System.out.println("setting r" + message.getRecipient());
        System.out.println("setting t" + message.getTitle());
        System.out.println("setting b" + message.getBody());
    }

    @Test(dataProvider = "message2")
    public void message2(List<Message> list){
        System.out.println(list.size());


    }


  /*  public static void main(String[] args) throws IOException {
        System.out.println(new String(Files.readAllBytes(Path.of(filePath))));

    }*/

@Test
    public void login1test(){
       loginPage.login("anastasiaashurok", "***");
       Assert.assertTrue(loginPage.isLoginPerformedCorrectly());
       loginPage.sendEmail("anastasiaashurok@yandex.by", "Hello");
       loginPage.openEmail();
    }

    @Test(dataProvider = "jsonMessageParser", dataProviderClass = JsonMessageParser.class)
    public void login3test(){
        loginPage.login("anastasiaashurok2", "***");
        Assert.assertTrue(loginPage.isLoginPerformedCorrectly());
        loginPage.sendEmail("anastasiaashurok@yandex.by", "Hello");
        loginPage.openEmail();
    }


    @Test
    public void login2test(){
        loginPage.login("invalid", "invalid");

    }
}
