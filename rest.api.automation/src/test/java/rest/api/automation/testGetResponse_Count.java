package rest.api.automation;
import java.net.URI;
import java.util.ArrayList;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;

public class testGetResponse_Count {

			@Test

		public void validate_response_count() throws Exception
		{
			
			// Given a URI 
			// When "get " action is performed on the URI 
			// Then response record count should match with the expected count 
			 
			
			URI uri = new URI("http://services.groupkt.com/state/get/IND/all");
			String s = RestAssured.given().when().get(uri).thenReturn().asString();
			
			JsonPath path = new JsonPath(s);
			//System.out.println(s);
			
			ArrayList<String> resultlist = (ArrayList)path.getList("RestResponse.result");
			System.out.println("Total record count in response section "+ resultlist.size());
			
			ArrayList <String> messagelist = (ArrayList) path.getList("RestResponse.messages");
			System.out.println("Total record count in message section "+ messagelist.size());
			}

	}

