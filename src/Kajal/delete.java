package Kajal;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given ;
import java.time.LocalDateTime ;
import org.testng.Assert ;
import io.restassured.path.json.JsonPath ;

public class delete {
public static void main(String[] args) {

RestAssured.baseURI = "https://reqres.in/" ;

String ResponseBody = given().header("Accept-Encoding","gzip, deflate, br").body("").when().put("api/users/2").then().extract().response().asString();

System.out.println(ResponseBody) ;
	} }
