package com.bestbuy.serenity.storeinfo;

import com.bestbuy.serenity.constants.EndPoints;
import com.bestbuy.serenity.model.StorePojo;
import com.bestbuy.serenity.testbase.TestBase;
import com.bestbuy.serenity.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.hasValue;

public class StoreCURDTest extends TestBase {
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

    // "name": "New Store",
    //      "type": "BigBox",
    //      "address": "123 Fake St",
    //      "address2": "",
    //      "city": "Springfield",
    //      "state": "MN",
    //      "zip": "55123",
    //      "lat": 44.969658,
    //      "lng": -93.449539,
    //      "hours": "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8"

    @Test
    public void getAllStoreInfo() {
        Response response = given()
                .when().get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Title("This is create a store")
    @Test
    public void createStore() {
        Map<String, Object> services = new HashMap<>();
        services.put("name", "");
        services.put("id", "01");
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        SerenityRest.given().contentType(ContentType.JSON)
                .when()
                .body(storePojo).post().then().log().all().statusCode(201);

    String s1 = "findAll{it.name == ' ";
        String s2 = " ' }.get(0)";
        HashMap<String,Object> store = SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_PRODUCT).then().extract().path(s1+name+s2);
        Assert.assertThat(store,hasValue(name));
        name = (String) store.get("name");



    }







    @Title("Update store information ")
    @Test
    public void UpdateDateData(){
        city = city + "_updated";
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        SerenityRest.given().contentType(ContentType.JSON)
                .when()
                .body(storePojo).post().then().log().all().statusCode(201);

    }

}
