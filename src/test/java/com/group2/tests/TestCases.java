package com.group2.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.group2.tests.TestListener.class)

public class TestCases {
    WebDriver driver= new FirefoxDriver();

    // Test to pass as to verify listeners .
    @Test
    public void Login()
    {
        driver.get("https://mail.ru/");
        driver.findElement(By.name("uid")).sendKeys("mngr34926");
        driver.findElement(By.name("password")).sendKeys("amUpenu");
        driver.findElement(By.name("btnLogin")).click();
    }

    // Forcefully failed this test as to verify listener.
    @Test
    public void TestToFail()
    {
        System.out.println("This method to test fail");
        Assert.assertTrue(false);
    }
}
