package rest.api.automation;
import java.util.HashMap;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class test_Autentication {

		
		@Test
		public void test_Get_method_Header()
		{
			String uri = "http://postman-echo.com/basic-auth";
			HashMap<String , String> header = new HashMap<String, String>();
			header.put("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==");
								
		    Response resp =		
		    given()
		    .accept(ContentType.JSON)
		    .headers(header)
		    .when()
			.get(uri)
			.thenReturn();
		    
		    System.out.println("Status Line :  " + resp.getStatusLine());
		    System.out.println("response Body  + " + resp.body().asString());
		    
	
				
		}
		

	}