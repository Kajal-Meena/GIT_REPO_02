package Kajal;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import java.time.LocalDateTime ;
import static io.restassured.RestAssured.given ;
import org.testng.Assert ;

public class practice 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI = "https://reqres.in" ;
		
		String RequestBody = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}\r\n"
				+ "" ;

		JsonPath jsprequest = new JsonPath(RequestBody) ;
		String req_name = jsprequest.getString("name");
		String req_job = jsprequest.getString("job") ;
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0,10);
		
		System.out.println("Request Body is --> " + RequestBody);
		
		
		String ResponseBody = given().header("Content-Type","application/json").when().patch("/api/users/2").then().
				              extract().response().asString();
		
		io.restassured.path.json.JsonPath jspresponse = new JsonPath(ResponseBody) ;
		String res_name = jspresponse.getString("name");
		String res_job = jspresponse.getString("job") ;
		String res_updatedAt = jspresponse.getString("updatedAt") ;
		res_updatedAt = res_updatedAt.substring(0,10) ;
		
		System.out.println("Respone Body is ---> " + ResponseBody);
		
		Assert.assertEquals(req_name, res_name);
		Assert.assertEquals(req_job,res_job);
		Assert.assertEquals(expecteddate, res_updatedAt);

	}

}
