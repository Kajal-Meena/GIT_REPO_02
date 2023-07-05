package Kajal;
import io.restassured.RestAssured ;
import static io.restassured.RestAssured.given ;
import java.time.LocalDateTime ;
import org.testng.Assert ;
import io.restassured.path.json.JsonPath ;
public class Put { 
	public static void main(String[] args) {
		//Declare the base URL
		RestAssured.baseURI="https://reqres.in/" ;
		//Declare the request body string variable
		String requestBody="{\r\n" + "    \"name\": \"morpheus\",\r\n"+ "    \"job\": \"zion resident\"\r\n"+ "}"	;
		JsonPath JspRequest = new JsonPath(requestBody) ;
		String Req_name = JspRequest.getString("name") ; 
		String Req_job = JspRequest.getString("job") ;
		LocalDateTime currentdate = LocalDateTime.now() ;
		System.out.println(currentdate);
		String expecteddate=currentdate.toString().substring(0, 11) ;
		//Declare the given , when and then method
		//String responseBody=given().header ("Content-Type","application/json").body(requestBody).
		//when().put("api/users").then().extract().response().asString();
		String responseBody=given().header ("Content-Type","application/json").body(requestBody).
		when().put("api/users/2").then().extract().response().asString() ; 
		//System.out.println(responseBody);
		//create an object of json path to parse the response body 
		JsonPath JspResponse = new JsonPath(responseBody) ;
		String Res_name = JspResponse.getString("name") ;
		String Res_job = JspResponse.getString("job") ;
		String Res_updatedAt = JspResponse.getString("updatedAt") ; 
		Res_updatedAt = Res_updatedAt.substring(0,11) ; 
		System.out.println(Res_name) ; 
		System.out.println(Res_job) ;
		System.out.println(Res_updatedAt) ; 
		Assert.assertEquals(Res_name,Req_name) ; 
	    Assert.assertEquals(Res_job,Req_job) ; 
		Assert.assertEquals(Res_updatedAt,expecteddate) ;
	}}	
	

