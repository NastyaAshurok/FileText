package com.group2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MySecondTest {
    @Test
    public void LoginTest() {
        System.out.println("login to store");
        boolean loginResult = false;
        //Assert.assertTrue(loginResult, true, "Unable to login to store");
        Assert.assertEquals(loginResult, true, "Unable to login to store");
    }
}
