package rest.api.automation;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

//import org.testng.annotations.Test;



import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class testGetRequest {

	@Test
	public void testGet() throws URISyntaxException  
	
	
	// Given a URI 
	// When "get " action is performed
	// Then Status code should match  = Accepted Status 
	 
		{
	URI uri = new URI("http://services.groupkt.com/state/get/IND/all");
	//int code= RestAssured.given().when().get(uri).thenReturn().statusCode();
	
	Response response = RestAssured.given().when().get(uri);
	System.out.println(response.statusCode());
	System.out.println(response.statusLine());
	
	
	
	//System.out.println(response.body().asString());
	//Look for a search item 
	
Assert.assertTrue(response.body().asString().contains("andhra"));

	
	
	
	
	
	}
	
}
