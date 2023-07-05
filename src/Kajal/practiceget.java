package Kajal;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given ;

public class practiceget 
{
	public static void main(String[] args) 
	{
	RestAssured.baseURI = "https://reqres.in" ;
	String ResponseBody = given().header("Content-Type","application/json").when().get("/api/users/2").then().extract().response().asString();
	System.out.println(ResponseBody);
	}
	

}
