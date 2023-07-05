package Kajal ;
import io.restassured.RestAssured ;
import static io.restassured.RestAssured.given ; 

public class get       {
public static void main(String[] args) { 
//Declare the base URL
RestAssured.baseURI="https://reqres.in/" ;

String responseBody=given().header ("Content-Type","application/json").body("").
when().get("api/users/2").then().extract().response().asString() ;
 
System.out.println(responseBody);
}}

