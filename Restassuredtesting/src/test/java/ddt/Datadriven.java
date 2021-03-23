package ddt;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Datadriven {

	@Test(dataProvider = "getdata")
	void reciver(String a,String b,String c) {
	if (!a.equals("EMPNAME")) {	
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	RequestSpecification req = RestAssured.given();
	JSONObject para = new JSONObject();
	para.put("name", a);
	para.put("salary", a);
	para.put("age", a);
	req.header("Content-Type","application/json");
	req.body(para.toJSONString());
	Response r = req.request(Method.POST,"/create");
	String s = r.jsonPath().get("data").toString();
	System.out.println(s+"\n\n\n\n");
	}
	else{System.out.println("dummy");}}
	
	
	@DataProvider
	String[][] getdata(){
		//String empdata[][]= {{"abc","10000","40"},{"fasabc","70000","40"},{"ddabc","40000","41"}};
		String xldata[][]=ddt.ReadXl.get("C:\\\\Users\\\\HP\\\\eclipse-workspace\\\\Restassuredtesting\\\\src\\\\test\\\\java\\\\ddt\\\\empdata.xls");
		return xldata;
	}
}
