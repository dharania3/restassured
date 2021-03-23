package BaseTest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class commonforall {
	
	public static RequestSpecification req;
	public static Response res;
	public Logger log;
	
	@BeforeClass
	public void setup()
	{
		log = Logger.getLogger("emploeerestapi");
		PropertyConfigurator.configure("C:\\Users\\HP\\eclipse-workspace\\Restassuredtesting\\Log4j.properties");
		log.setLevel(Level.DEBUG);
	}

}
