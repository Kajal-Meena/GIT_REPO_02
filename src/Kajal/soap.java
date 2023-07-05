package Kajal;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given ;
import java.time.LocalDateTime ;
import org.testng.Assert; 
import io.restassured.path.json.JsonPath ;
import io.restassured.path.xml.* ;

public class soap {

private static final String ResponseBody = null;
public static void main(String[] args) {
//Trigger base API	
RestAssured.baseURI = "https://www.dataaccess.com" ;
//Declare request body
String RequestBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
		+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
		+ "  <soap:Body>\r\n"
		+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
		+ "      <ubiNum>70</ubiNum>\r\n"
		+ "    </NumberToWords>\r\n"
		+ "  </soap:Body>\r\n"
		+ "</soap:Envelope>" ; 
//Extract response body
String ResponseBody = given().header ("Content-Type","text/xml; charset=utf-8").body(RequestBody).when().
post("/webservicesserver/NumberConversion.wso").then().extract().response().asString() ;

System.out.println(RequestBody) ;
System.out.println(ResponseBody) ;
 //Parse response body 
XmlPath XmlResponse = new XmlPath(ResponseBody);
String ResponseParameter = XmlResponse.getString("NumberToWordsResult") ;
System.out.println(ResponseParameter) ;

//Validate response body
Assert.assertEquals(ResponseParameter,"seventy") ;
} 
}