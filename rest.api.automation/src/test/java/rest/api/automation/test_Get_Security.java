package rest.api.automation;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.response.Response;

public class test_Get_Security {

	@Test
	public void test_Get_Security_Basic_Auth()
	{
		
		String uri = "http://postman-echo.com/basic-auth";
		Response resp = 
				given()
				.auth()
				.basic("postman", "password")
				.when()
				.get(uri)
				.thenReturn();
System.out.println("Hi");
		
	}
}
