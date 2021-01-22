package CucumberJAVA;

import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import org.junit.Test;

import io.restassured.specification.RequestSpecification;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testNumberofpets() {
    	
    	//given
    	RequestSpecification request=given();
    	
    	//when
    	String response=given().spec(request)
        .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available").getBody().asString();
    	response="{"+response+"}";
    	System.out.println(response);
  	
    	
    	
    }
}
