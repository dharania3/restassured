package testcase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Getallemp extends commonforall{
	int eid= 2038;
	
	@BeforeClass
	void getallemp()
	{
		log.info("~~~~~~~~~~~~~~~~~~~~~Starting to get all employee info~~~~~~~~~~~~~~~~~~~");
		RestAssured.baseURI= "http://restapiexample.com/api/v1";
		req = RestAssured.given();
		String resourse = "/employees/" + String.valueOf(eid);
		res = req.request(Method.GET,resourse);
	}
	
	@Test
	void bodyexist()
	{
		String body = res.getBody().prettyPrint();
		//body.split("{");
		//System.out.println("+++++++++++\n\n"+body+"++++++++++++++++++++\n");
		log.info("RESPONSE BODY -> \n"+body);
		Assert.assertTrue(body.contains(String.valueOf(eid)));
		
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
		Assert.assertTrue(t<=2000);
		
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
log.info("~~~~~~~~~~~~~~~DONE~~~~~~~~~~~~~~~~~");
}
}