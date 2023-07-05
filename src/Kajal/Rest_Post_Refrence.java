package Kajal ;

import io.restassured.RestAssured ;
import static io.restassured.RestAssured.given ;
import java.time.LocalDateTime ; 
import org.testng.Assert ; 
import io.restassured.path.json.JsonPath ; 

public class Rest_Post_Refrence       { 

	public static void main(String[] args) { 
	
    //Declare the base URL 
    RestAssured.baseURI="https://reqres.in/" ; 

    //Declare the request body string variable
   String requestBody="{\r\n"	+ "    \"name\": \"morpheus\",\r\n"	+ "    \"job\": \"leader\"\r\n"+ "}" ;		
   
   //Parse request body
   JsonPath JspRequest = new JsonPath(requestBody) ;
   
   //extract request body
   String Req_name = JspRequest.getString("name") ;
   String Req_job = JspRequest.getString("job") ; 
   LocalDateTime currentdate = LocalDateTime.now() ; 
   String expecteddate=currentdate.toString().substring(0, 11) ;
   
   //Declare the given , when and then method
   String responseBody=given().header ("Content-Type","application/json").body(requestBody).
   when().post("api/users").then().extract().response().asString() ;

   //create an object of JsonPath to parse the response body 
   JsonPath JspResponse = new JsonPath(responseBody) ; 
   
   System.out.println(responseBody);
   
   String Res_name = JspResponse.getString("name") ;
   String Res_job = JspResponse.getString("job") ;
   String Res_createdAt = JspResponse.getString("createdAt") ; 
   Res_createdAt = Res_createdAt.substring(0,11) ; 
   
   System.out.println(Res_name) ; 
   System.out.println(Res_job) ;
   System.out.println(Res_createdAt);
   
   Assert.assertEquals(Res_name,Req_name) ; 
   Assert.assertEquals(Res_job,Req_job) ; 
   Assert.assertEquals(Res_createdAt,expecteddate) ;
   
	}
    }

