package Steps;

import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.*;
import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Petstore_Steps {
	
	private static String request = "https://petstore.swagger.io/v2/pet";
	
	String pets;
	
	@Given("I set api with base URL")
	public void i_set_api_with_base_URL() {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println("Base URL created");
		
	}
	
	@When("I update the {string} of the existing pet")
	public void i_update_the_of_the_existing_pet(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	@Then("I check for the updated pet in the store by name and status")
	public void i_check_for_the_updated_pet_in_the_store_by_name_and_status() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	
	@SuppressWarnings("unchecked")
	@When("I post a new {string} with id-{string} in the store")
	public void i_post_a_new_pet_in_the_store(String status,String id) {
	    // Write code here that turns the phrase above into concrete actions
		 RequestSpecification req = RestAssured.given();
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("id", id); // Cast
		 requestParams.put("category", "{\r\n" + 
		 		"    \"id\": 0,\r\n" + 
		 		"    \"name\": \"string\"\r\n" + 
		 		"  }");
		 requestParams.put("name", "dog");
		 requestParams.put("photoUrls", "string");
		 requestParams.put("tags", "[\r\n" + 
		 		"    {\r\n" + 
		 		"      \"id\": 0,\r\n" + 
		 		"      \"name\": \"psd\"\r\n" + 
		 		"    }\r\n" + 
		 		"  ]");
		 requestParams.put("status", status);
		System.out.println("Request is --> "+StringEscapeUtils.unescapeJava(requestParams.toJSONString()));
			
		req.header("Content-Type", "application/json");
		req.header("accept", "application/json");
		
		req.body(requestParams);
		//ResponseBody response=given().contentType("application/json").accept("application/json").body(requestParams).when().request(request).getBody();
		
		Response resp=req.post(request);
		System.out.println("Status is --> "+resp.getStatusLine());
		System.out.println(resp.getStatusCode());
		
	}

	@Then("I assert the status of the pet")
	public void i_assert_the_new_pet_has_been_added() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("I GET all dogs with {string} status")
	public void i_GET_all_dogs_with_status(String status) {
	    // Write code here that turns the phrase above into concrete actions
		request=request+"/findByStatus?status="+status;
		System.out.println(request);
		
		pets=given().when().get(request).getBody().asString();
		System.out.println(pets);	
		
	}
	
	@When("I delete the pet with id {string} and api_key {string}")
	public void i_delete_the_pet_with_id_and_api_key(String id, String key) {
	    // Write code here that turns the phrase above into concrete actions
		request=request+"/"+id;
		RequestSpecification req = RestAssured.given();
		req.header("accept", "application/json");
		req.header("api_key",key);
		
		Response resp=req.delete(request);
		System.out.println("Status is --> "+resp.getStatusLine());
		System.out.println(resp.getStatusCode());
		
	}

	@Then("I assert the count of available pets in store")
	public void i_assert_the_count_of_available_pets_in_store() {
	    // Write code here that turns the phrase above into concrete actions
		given().when().get(request+"/findByStatus?status=available").then().assertThat().statusCode(200);
		String response=given().when().get(request+"/findByStatus?status=available").getBody().toString();
		System.out.println(response);
		
		given().when().get(request+"/findByStatus?status=available").then().assertThat().body("name", hasSize(547));
		
		System.out.println("Assered the pets with available status !!!");
		
	}
	
	@Given("Pet has been already added with id {string}")
	public void pet_has_been_already_added_with_id(String id) {
	    // Write code here that turns the phrase above into concrete actions
		request=request+"/"+id;
		System.out.println(request);
		
		String petByid=given().when().get(request).getBody().asString();
		System.out.println("FOUND THE NEW ADDED PET --> "+petByid);	
		
	}

	@SuppressWarnings("unchecked")
	@When("I update the status to {string} for pet")
	public void i_update_the_status_to_for_pet(String status) {
	    // Write code here that turns the phrase above into concrete actions
	    
		 RequestSpecification req = RestAssured.given();
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("id",7856897 ); // Cast
		 requestParams.put("category", "{\r\n" + 
		 		"    \"id\": 0,\r\n" + 
		 		"    \"name\": \"string\"\r\n" + 
		 		"  }");
		 requestParams.put("name", "newDog");
		 requestParams.put("photoUrls", "string");
		 requestParams.put("tags", "[\r\n" + 
		 		"    {\r\n" + 
		 		"      \"id\": 0,\r\n" + 
		 		"      \"name\": \"psd\"\r\n" + 
		 		"    }\r\n" + 
		 		"  ]");
		 requestParams.put("status", status);
		System.out.println("Request is --> "+StringEscapeUtils.unescapeJava(requestParams.toJSONString()));
			
		req.header("Content-Type", "application/json");
		req.header("accept", "application/json");
		
		req.body(requestParams);
		//ResponseBody response=given().contentType("application/json").accept("application/json").body(requestParams).when().request(request).getBody();
		
		Response resp=req.put(request);
		System.out.println("Status is --> "+resp.getStatusLine());
		System.out.println(resp.getStatusCode());
	}

	@Then("I assert the status of the pet with id {string}")
	public void i_assert_the_status_of_the_pet_with_id(String id) {
	    // Write code here that turns the phrase above into concrete actions
		request=request+"/"+id;
		System.out.println(request);
		
		String petByid=given().when().get(request).getBody().asString();
		given().when().get(request).then().assertThat().body("id", hasToString(id));
		System.out.println("Assertion done for newly added pet !!!");
		System.out.println("FOUND THE NEW ADDED PET --> "+petByid);	
	    
		request=null;
	}

}
