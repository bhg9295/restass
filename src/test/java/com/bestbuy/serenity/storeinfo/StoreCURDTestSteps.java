package com.bestbuy.serenity.storeinfo;

import com.bestbuy.serenity.testbase.TestBase;
import com.bestbuy.serenity.utils.TestUtils;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

public class StoreCURDTestSteps extends TestBase {
    static String name = "Prime" + TestUtils.getRandomValue();
    static String type = "BigBox" + TestUtils.getRandomValue();
    static String address = "123 Fake St" + TestUtils.getRandomValue();
    static String address2 = "" + TestUtils.getRandomValue();

    static String city = "Springfield" + TestUtils.getRandomValue();
    static String state = "MN" + TestUtils.getRandomValue();
    static String zip = "55123" + TestUtils.getRandomValue();
    static double lat = 44.969658;
    static double lng = -93.449539;
    static String hours = "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";

    @Title("This is store steps")
    @Test
    public void test001(){

    }

    public static class TagTest {
    }
}
