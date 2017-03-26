package rest.api.automation;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class testGetRequest_ResponseFormat {

	@Test

	public void validate_response_format() throws Exception
	{
		
		// Given a URI 
		// When "get " action is performed on the URI 
		// Then response format should  match the acceptable form eg: JSON, XML, HTML 
		
		URI uri = new URI("http://services.groupkt.com/state/get/IND/all");
		String s = RestAssured.given().when().get(uri).thenReturn().asString();
		
		JsonPath path = new JsonPath(s);
		
		ArrayList<String> list = (ArrayList) path.getList("RestResponse.result.country");
		
		for (int i=0;i<list.size();i++)
		{
		//System.out.println("Get the item value: "+ i + " ---" + list.get(i));
		Assert.assertTrue(list.get(i).equals ("IND"));
					
		}
		Response s1=		 (Response) RestAssured.given()
		.accept(ContentType.JSON)
		.when()
		.get(uri)
		.thenReturn();
		
		
		//System.out.println("Response Body " + s1.body().asString());
		
		//To capture the header information from the Response  
		System.out.println("Response Header " + s1.headers());	
		
		Assert.assertEquals((HttpStatus.SC_OK), s1.getStatusCode());
		
		Assert.assertEquals(HttpStatus.), actual);
		
				}
	
	
	
}
