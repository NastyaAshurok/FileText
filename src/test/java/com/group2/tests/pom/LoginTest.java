package com.group2.tests.pom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

//import static com.codeborne.selenide.CollectionCondition.size;

@Data
public class LoginTest {
LoginPage loginPage = new LoginPage();

    private static final String filePath = "src/test/resources/message.json";

    @Data
    public  class EmailData{
        String login;
        String pass;
        List<Message> messages;
    }
    @Data
    public  class Message{
        String recipient;
        String title;
        String body;
    }

    ObjectMapper mapper = new ObjectMapper();
    private  EmailData getEmailData() throws IOException {

        EmailData emailData = mapper.readValue(Paths.get(filePath).toFile(), EmailData.class);
        return emailData;
    }

    @DataProvider
    public Object[][] sender() throws IOException {    //args: String login, String password

        EmailData emailData = getEmailData();

        Object[][] loginData = new Object[1][2];
        loginData[0][0] = emailData.getLogin();
        loginData[0][1] = emailData.getPass();

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

    @Test(dataProvider = "sender")
    public void loginFromProvider(String login, String password){
        loginPage.login(login, password);
        Assert.assertTrue(loginPage.isLoginPerformedCorrectly());

    }
/*    @BeforeTest
   public void login(String login, String password){
        loginPage.login("anastasiaashurok", "***");
        Assert.assertTrue(loginPage.isLoginPerformedCorrectly());
    } */

    @Test(dataProvider = "message")
    public void messageFromProvider(Message message){
        loginPage.login("anastasiaashurok", "***");
        loginPage.sendEmail(message.getRecipient(), message.getBody());
        loginPage.openEmail();
    }

    Faker faker = new Faker(new Locale("ru"));

    @Test
    public void sendRandomMessage(){
        String messageRandom = faker.bothify("????TestMessage");
        loginPage.login("anastasiaashurok", "***");
        Assert.assertTrue(loginPage.isLoginPerformedCorrectly());
        loginPage.sendEmail("anastasiaashurok@yandex.by", messageRandom);
        loginPage.openEmail();
    }


@Test
    public void messageWithoutProvider(){
       loginPage.login("anastasiaashurok", "***");
       Assert.assertTrue(loginPage.isLoginPerformedCorrectly());
       loginPage.sendEmail("anastasiaashurok@yandex.by", "Hello");
       loginPage.openEmail();
    }

}
