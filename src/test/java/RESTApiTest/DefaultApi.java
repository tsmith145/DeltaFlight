package RESTApiTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DefaultApi {
	
	
	@Test
	public void getUsers() {
		
		Response response =RestAssured.get("https://reqres.in/api/users?page=2"); 
		
		System.out.println(response.getStatusCode());
		
	}
	

}
