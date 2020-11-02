package com.group2.tests;

//import com.codeborne.selenide.Condition;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

//import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class MyFirstTest {

    @Test
    public void LoginTest() {
        System.out.println("login to store");
        boolean loginResult = false;
        //Assert.assertTrue(loginResult, true, "Unable to login to store");
        Assert.assertEquals(loginResult, true, "Unable to login to store");
    }

    @Test
    public void user_can_search_everything_in_google() {
        open("http://google.com/ncr");
        $(By.name("q")).val("selenide").pressEnter();


        $$("#ires .g").shouldHave(size(10));

        //Condition visible;
        $("#ires .g").shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java"),
                text("selenide.org"));
    }

    @Test
    public void user_can_search_coffee() {
        open("https://e-dostavka.by/");
        $(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/nav/ul/li[9]/a")).click();
      //  $("body.direction_1.section_10.not_authorized:nth-child(2) div.main__wrap:nth-child(5) div.main:nth-child(4) div.main_menu:nth-child(2) div.main_menu__inner nav:nth-child(1) ul:nth-child(1) li:nth-child(9) > a:nth-child(1)").click();
        // $(By.id("main_menu__search")).click();
        $(By.name("searchtext")).val("кофе молотый dallmayr classic 250").pressEnter();

        String coffeeResult = $("body.direction_1.section_10.not_authorized.search_block__showed:nth-child(2) div.main__wrap div.main:nth-child(4) div.wrapper:nth-child(3) div.template_1_columns div.content:nth-child(4) div.products_catalog.filter_left div.products_block__wrapper.products_4_columns.vertical div.products_card.products_card_444796.trademark_7907 div.form_wrapper form:nth-child(1) div.title:nth-child(5) > a.fancy_ajax").getText();


        $(By.linkText("Кофе молотый «Dallmayr» classic, 250 г.")).click();
        sleep(100);

        String coffeeKgPrice = $("body.direction_1.section_10.not_authorized.search_block__showed:nth-child(2) div.mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.mfp-zoom-in.dialog.mfp-ready div.mfp-container.mfp-ajax-holder.mfp-s-ready div.mfp-content div.product_card div.products_card div.product_card__inner:nth-child(3) div.right:nth-child(5) ul.description > li:nth-child(5)").
                getText();


        System.out.println(coffeeResult);
        System.out.println(coffeeKgPrice);

        if(coffeeKgPrice == "Цена за 1 кг:54.2"){
            System.out.println(coffeeKgPrice);
        }else System.out.println("Цена изменилась");


        //    $(By.xpath("//body/div[@id='body']/div[1]/div[3]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/a[1]/img[1]"));
        //     $(By.xpath("//*[@id=\"body\"]/div/div[3]/div[3]/div/div[3]/div/div[2]/div/div/form/div[2]/a"));
        // $(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div[3]/div/div[2]/div/div")).click();
       // System.out.println(22);
        //  $(By.name("q")).val("selenide").pressEnter();


      /*  $$("#ires .g").shouldHave(size(10));

        //Condition visible;
        $("#ires .g").shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java"),
                text("selenide.org")); */
    }


}
