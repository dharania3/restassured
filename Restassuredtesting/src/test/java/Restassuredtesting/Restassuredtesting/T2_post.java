package Restassuredtesting.Restassuredtesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T2_post {
	@Test
	void getPostreq() 
	{
		RestAssured.baseURI ="https://httpbin.org/post";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("FirstName", "Virender"); // Cast
		 requestParams.put("LastName", "Singh");
		 requestParams.put("UserName", "sdimpleuser2dd2011");
		 requestParams.put("Password", "password1");
		 requestParams.put("Email",  "sample2ee26d9@gmail.com");
		 request.body(requestParams.toJSONString());
		 Response response = request.request(Method.POST);
		 String r=response.jsonPath().get("data");
		 System.out.println(r);
		 int statusCode = response.getStatusCode();
			System.out.println(statusCode);
		 Assert.assertEquals(statusCode, 200);
		
	}

}
