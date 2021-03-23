package Restassuredtesting.Restassuredtesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T3test {

	@Test
	void gethearder() {
		
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city/Chennai";
		RequestSpecification httpreq=RestAssured.given();
		Response res = httpreq.request(Method.GET);
		Headers heads = res.headers();
		for (Header h : heads) {
			System.out.println(h.getName()+"  ---->  "+h.getValue());
		}
	}
	
	
}
