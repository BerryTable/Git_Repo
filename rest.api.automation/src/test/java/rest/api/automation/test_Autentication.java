package rest.api.automation;

import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

//import static com.jayway.restassured.RestAssured.*;
//If this import statement does not contain static,then we have to create an instant of 
//Rest Assured

public class test_Autentication {

String uri = "http://postman-echo.com/basic-auth";

@Test 
public void test_Get_NoAuth()

{
	System.out.println("Executing - test_Get_NoAuth test");
	Response resp = given().accept(ContentType.JSON).when().get(uri).thenReturn();
	System.out.println("Status Line :  " + resp.getStatusLine());
    System.out.println("Response Body : " + resp.body().asString());
    
    System.out.println("Response Content Type/Format  "+ resp.contentType());
    //Above line not valid since no response is displayed
    //Hence no header Information. 
    //However , on execution...WARNING message is displayed as expected 
    Assert.assertEquals((HttpStatus.SC_UNAUTHORIZED),resp.getStatusCode());
    Assert.assertNotEquals(HttpStatus.SC_OK, resp.getStatusCode()); 
    
}
		
@Test 

public void test_Get_Authentication_Using_Header()

{
	System.out.println("Executing -- test_Get_Authentication_Using_Header");
		HashMap<String , String> header = new HashMap<String, String>();
		header.put("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==");
	    Response resp = given().accept(ContentType.JSON).headers(header).when().get(uri).thenReturn();
	    System.out.println("Status Line :  " + resp.getStatusLine());
		System.out.println("Response Body  : " + resp.body().asString());
		System.out.println("Response Time : " + resp.time());
		System.out.println("Response Content Type/Format  "+ resp.contentType());
		System.out.println("Respone Header Count : " + resp.headers().size());
		//Made the assertion false intentionally  to see the failure 
		Assert.assertTrue(resp.body().asString().contains("true"));
		Assert.assertTrue(resp.contentType().contains("json"));

	    }
		
@Test 
public void test_Get_Authentication_Basic_Auth()

{
	System.out.println("Executing- test_Get_Authentication_Basic_Auth"); 
	Response resp = given().accept(ContentType.JSON).auth().basic("postman", "password").when().get(uri).thenReturn();
	System.out.println("status Line --> " + resp.statusLine());
	Assert.assertEquals((HttpStatus.SC_OK), resp.getStatusCode());
	System.out.println("Response Body -->  " + resp.body().asString());
	System.out.println("Response Content Type/Format -->  "+ resp.contentType());
	System.out.println("Respone Header Count --> " + resp.headers().size());
	System.out.println("Header Details--> " + resp.getHeaders());
	Assert.assertTrue(resp.body().asString().contains("true"));
	
}
}