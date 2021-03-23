package testcase;
import org.json.simple.JSONObject;
import org.testng.Assert;
import utilities.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class newemp extends commonforall{
	int n = Randmongenerator.getrannum();
	String name = "A"+String.valueOf(n);
	String salary = String.valueOf(n*100);
	String age = String.valueOf(n);
	@BeforeClass
	void createemp()
	{
		log.info("\n\n\n\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~~Starting to get all employee info~~~~~~~~~~~~~~~~~~~");
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		req = RestAssured.given();
		JSONObject para = new JSONObject();
		para.put("name",name);
		para.put("salary",salary);
		para.put("age",age);
		System.out.println("\n HERERERER"+ para.toString() +"\n");
		req.header("Content-Type","application/json");
		req.body(para.toJSONString());
		res = req.request(Method.POST,"/create");
	}
	
	@Test
	void bodyexist()
	{
		String body = res.getBody().prettyPrint();
		//body.split("{");
		//System.out.println("+++++++++++\n\n"+body+"++++++++++++++++++++\n");
		log.info("RESPONSE BODY ->\n"+body);
		Assert.assertTrue(body.contains(name));
		Assert.assertTrue(body.contains(salary));
		Assert.assertTrue(body.contains(age));
		
	}
	@Test
	void statuscode()
	{
		int sc = res.getStatusCode();
		log.info("STASTUS CODE -> \n"+sc);
		Assert.assertEquals(200,sc);
		
	}
	
	@Test
	void restime()
	{
		long t = res.getTime();
		log.info("RESPONSE TIME -> \n"+t);
		Assert.assertTrue(t<=10000);
		
	}
	
	@Test
	void conttype()
	{
		String ct = res.getHeader("Content-Type");
		log.info("CONTENT TYPE -> \n"+ct);
		Assert.assertTrue(ct.contains("application/json"));
		
	}
@AfterClass
void tdown() {
log.info("~~~~~~~~~~~~~~~DONE~~~~~~~~~~~~~~~~~\n\n\n\n\n\n\n\n\n\n\n");
}
}