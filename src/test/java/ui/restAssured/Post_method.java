package ui.restAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Post_method {

	public static void main(String[] args) {
		// POST method = create the data
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		// post
		String postBookingDetails = given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").when().post("/booking").then().statusCode(200).extract().response().asPrettyString(); 
		System.out.println(postBookingDetails);
		
		// json path only used  in post method to search the veriable
		JsonPath js = new JsonPath(postBookingDetails);
		String store = js.get("booking.firstname");
		System.out.println(store);

	}

}
