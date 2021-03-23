package Restassuredtesting.Restassuredtesting;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T5authbas {
@Test
void auth() {
	RestAssured.baseURI="https://the-internet.herokuapp.com/basic_auth";
	
	PreemptiveBasicAuthScheme auths = new PreemptiveBasicAuthScheme();
	auths.setUserName("admin");
	auths.setPassword("admin");
	RestAssured.authentication=auths;
	RequestSpecification httpa=RestAssured.given();
	Response res = httpa.request(Method.GET);
	int s = res.getStatusCode();
	Assert.assertEquals(200,s);
	System.out.println(s);
}
}
