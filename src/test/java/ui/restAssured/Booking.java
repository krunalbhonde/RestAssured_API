package ui.restAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Booking {

	public static void main(String[] args) {
		// URI
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		// GET : fetching the details
		String getAllId = given().header("Content-Type", "application/json").when().get("/booking").then()
				.statusCode(200).extract().response().asString();
		System.out.println(getAllId);

		// GET : fetching perticuler Id details

		String getIdDetails = given().header("Content-Type", "application/json").when().get("/booking/100").then()
				.statusCode(200).extract().response().asPrettyString();
		// asString() = gives in string;
		// asprettyString() = gives in proper format of string;
		System.out.println(getIdDetails);

	}

}
