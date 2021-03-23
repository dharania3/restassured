package Restassuredtesting.Restassuredtesting;


import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T4_responcebody {
	
	@Test
	void resp()
	{
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city/Chennai";
		RequestSpecification httpreq=RestAssured.given();
		Response res = httpreq.request(Method.GET);
		String r = res.getBody().asString();
		System.out.println(r);
		
		Object o = res.jsonPath().get("City");
		System.out.println("_____________________________\n"+o.toString()+"\n_______________________");
		Assert.assertTrue(r.contains("Chennai"));
	}
}
