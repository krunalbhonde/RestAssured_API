package ui.restAssured;

import io.restassured.RestAssured;


import static io.restassured.RestAssured.*;
public class Put_Method {

	public static void main(String[] args) {
		// PUT Method : update the details
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		
		
		String putBookingDetails = given().header("Content-Type","application/json").header("Cookie","token=4041df3daddd3fb")
		.body("{\r\n"
				+ "    \"firstname\" : \"Naredra\",\r\n"
				+ "    \"lastname\" : \"Modi\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2023-01-19\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").when().put("/booking/100").then().statusCode(200).extract().response().asPrettyString();
		System.out.println(putBookingDetails);
		
		
	}

	

}
