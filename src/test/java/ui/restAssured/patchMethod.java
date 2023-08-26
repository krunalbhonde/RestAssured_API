package ui.restAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class patchMethod {

	public static void main(String[] args) {
		// PATCH method : to update details partially 
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		String patchDetails = given().header("Content-Type","application/json").header("Cookie","token=785e848430afc18")
				.body("{\r\n"
						+ "    \"firstname\" : \"Ravi\",\r\n"
						+ "    \"lastname\" : \"Bopara\"\r\n"
						+ "}").when().patch("/booking/1248").then().statusCode(200).extract()
				.response().asPrettyString();
		System.out.println(patchDetails);

	}

}
