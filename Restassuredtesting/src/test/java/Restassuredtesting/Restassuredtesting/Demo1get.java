package Restassuredtesting.Restassuredtesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1get {
	@Test
	void getweather() {
		String c = "/Delhi";
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city"+c;
		RequestSpecification httpsreq = RestAssured.given();
		Response response = httpsreq.request(Method.GET);
		System.out.println("here:  "+response.asString());
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200);
		System.out.println("ststus line: \n" + response.getStatusLine().toString());
		String city = response.jsonPath().get("City");
		System.out.println("CITY : "+ city);
	}

}
