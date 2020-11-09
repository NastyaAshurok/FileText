package com.group2.tests;

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


public class MySecondTest {

    @BeforeMethod
    protected void beforeTestPrecondition() {
        System.out.println("Before message");
    }


    @Test
    public void user_can_search_coffee() {
        String coffeePriceExpected = "Цена за 1 кг:54.2";
        open("https://e-dostavka.by/");
        SoftAssert softAssert = new SoftAssert();
        String searchLocator = "//div[@class='main_menu__inner']//i[@class='fa fa-search']";
        $(By.xpath(searchLocator)).click();
        //  $(By.xpath("//input[@id='searchtext']")).setValue("Кофе молотый «Dallmayr» classic, 250 г.");
        $(By.name("searchtext")).val("кофе молотый dallmayr classic 250").pressEnter();
        // String coffeePriceActual = $(By.xpath("//div[@class='price']")).getText();
        String coffeeResult = $("body.direction_1.section_10.not_authorized.search_block__showed:nth-child(2) div.main__wrap div.main:nth-child(4) div.wrapper:nth-child(3) div.template_1_columns div.content:nth-child(4) div.products_catalog.filter_left div.products_block__wrapper.products_4_columns.vertical div.products_card.products_card_444796.trademark_7907 div.form_wrapper form:nth-child(1) div.title:nth-child(5) > a.fancy_ajax").getText();
        System.out.println(coffeeResult);

        $(By.linkText("Кофе молотый «Dallmayr» classic, 250 г.")).click();

        String coffeeKgPrice = $("body.direction_1.section_10.not_authorized.search_block__showed:nth-child(2) div.mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.mfp-zoom-in.dialog.mfp-ready div.mfp-container.mfp-ajax-holder.mfp-s-ready div.mfp-content div.product_card div.products_card div.product_card__inner:nth-child(3) div.right:nth-child(5) ul.description > li:nth-child(5)").
                getText();
        System.out.println(coffeeKgPrice);
        Assert.assertEquals(coffeeKgPrice, coffeePriceExpected, "Coffee price is different!");

    }

    @Test(dataProvider = "dataForInput")
    public void user_can_search_coffee_data(String value, String expectedPrice) {
        beforeTestPrecondition();

        System.out.println(value + "---" + expectedPrice);
  /*      HttpCookie input;
        input.setValue(value);
        String text = input.getText();
        Assert.assertEquals(text.equals(value),result); */

        //String coffeePriceExpected = "Цена за 1 кг:54.2";
        open("https://e-dostavka.by/");
        SoftAssert softAssert = new SoftAssert();
        String searchLocator = "//div[@class='main_menu__inner']//i[@class='fa fa-search']";
        $(By.xpath(searchLocator)).click();

        //  $(By.xpath("//input[@id='searchtext']")).setValue("Кофе молотый «Dallmayr» classic, 250 г.");
        $(By.name("searchtext")).val(value).pressEnter();
        // String coffeePriceActual = $(By.xpath("//div[@class='price']")).getText();
       // String result = $("body.direction_1.section_10.not_authorized.search_block__showed:nth-child(2) div.main__wrap div.main:nth-child(4) div.wrapper:nth-child(3) div.template_1_columns div.content:nth-child(4) div.products_catalog.filter_left div.products_block__wrapper.products_4_columns.vertical div.products_card.products_card_444796.trademark_7907 div.form_wrapper form:nth-child(1) div.title:nth-child(5) > a.fancy_ajax").getText();
       // System.out.println(result);
     //   String foundItem = "//img[@alt='" + selectedItem + "']";
String foundItem = "//div[@class='products_block__wrapper products_4_columns vertical']//i[@class='form_wrapper']";
$(By.xpath(foundItem)).click();
      //  $(By.linkText("Кофе молотый «Dallmayr» classic, 250 г.")).click();

     //   String coffeeKgPrice = $("//div[@class='products_block__wrapper products_4_columns vertical']//i[@class='form_wrapper']").
              //  getText()
        String coffeeKgPrice = $("body.direction_1.section_10.not_authorized.search_block__showed:nth-child(2) div.mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.mfp-zoom-in.dialog.mfp-ready div.mfp-container.mfp-ajax-holder.mfp-s-ready div.mfp-content div.product_card div.products_card div.product_card__inner:nth-child(3) div.right:nth-child(5) ul.description > li:nth-child(5)").
                getText();
        System.out.println(coffeeKgPrice);
        Assert.assertEquals(coffeeKgPrice, expectedPrice, "Coffee price is different!");

    }

    @DataProvider
    public Object[][] dataForInput(){
        Object[][] data = new Object [3][2];
        data[0][0] = "Кофе молотый «Dallmayr» classic, 250 г.";
        data[0][1] = "Цена за 1 кг:54.2";

        data[1][0] = "Кофе молотый «Dallmayr» classic, 250 г.";
        data[1][1] = "Цена за 1 кг:55.2";

        data[2][0] = "Шоколад горький «Коммунарка» с черной смородиной, 200 г.";
        data[2][1] = "Цена за 1 кг:15.25";

        //List<User> users = null ;

//        Object[][] result = users.stream()
//                            .map(item -> new Object[]{item})
//                            .toArray(Object[][]::new);

//        Object[][] result = new Object[users.size()][1];
//        for (int i = 0; i < users.size(); i++) {
//            result[i] = new Object[]{users.get(i)};
//        }

        return data;

    }


}
