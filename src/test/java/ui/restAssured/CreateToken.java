package ui.restAssured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CreateToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

         RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		//Create token
		String tokenValue =given().header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"username\" : \"admin\",\r\n"
						+ "    \"password\" : \"password123\"\r\n"
						+ "}").when().post("auth").then()
				.statusCode(200).extract().response().asPrettyString();
		System.out.println(tokenValue);
		
		JsonPath js = new JsonPath(tokenValue);
		String token = js.get("token");
		System.out.println(token);
	}

}
