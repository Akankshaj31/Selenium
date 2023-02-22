package Restassured01;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Trello {
	public String url ="https://trello.com";
	public String id;
	public String lists;
	
	@Test(enabled = false)
	  public void getboards() {
		Response response = given().queryParam("key", "d5739f142fcdb6e831c24f2235415a3f")
				.queryParam("token", "ATTAaec6d9087add679f26d9c276e47394d11d54e2b8d721e489bf36af6c6fa561779EE91781")
				.header("Content-Type","application/json")
				.when().get("https://trello.com/b/pHt4SG8O/moolya01").then().extract().response();
		System.out.println(response.getBody());
	  }
	@Test(enabled = false)
	  public void createboard() {
		baseURI = "https://trello.com/";
		Response response1 = given().queryParam("name", "moolya") .queryParam("key", "d5739f142fcdb6e831c24f2235415a3f")
				.queryParam("token", "ATTAaec6d9087add679f26d9c276e47394d11d54e2b8d721e489bf36af6c6fa561779EE91781")
				.header("Content-Type","application/json")
				.when().post("/1/boards/").then().extract().response();
		JsonPath jp = new JsonPath(response1.asString());
		id = jp.get("id");
		System.out.println(id);
		System.out.println(response1.getBody());
	  }
	@Test(enabled = false)
	  public void deleteboard() {
		baseURI = "https://trello.com/";
		Response response2 = given().queryParam("key", "d5739f142fcdb6e831c24f2235415a3f")
				.queryParam("token", "ATTAaec6d9087add679f26d9c276e47394d11d54e2b8d721e489bf36af6c6fa561779EE91781")
				.header("Content-Type","application/json")
				.when().delete("/1/boards/EX0GtPCb").then().extract().response();
		System.out.println(response2.getBody());
	  }
	@Test(enabled = false)
	  public void updateboard() {
		baseURI = "https://trello.com/";
		Response response3 = given().queryParam("name", "oct2022")
				.queryParam("key", "d5739f142fcdb6e831c24f2235415a3f")
				.queryParam("token", "ATTAaec6d9087add679f26d9c276e47394d11d54e2b8d721e489bf36af6c6fa561779EE91781")
				.header("Content-Type","application/json")
				.when().put("/1/boards/ddwSZmHj").then().extract().response();
		System.out.println(response3.getBody());
	  }
	@Test
	public void get_list_on_board() {
		baseURI = "https://trello.com/";
		Response response4 = given().queryParam("key", "d5739f142fcdb6e831c24f2235415a3f")
				.queryParam("token", "ATTAaec6d9087add679f26d9c276e47394d11d54e2b8d721e489bf36af6c6fa561779EE91781")
				.header("Content-Type","application/json").when()
				.get("/1/boards/cfRcHCGH/lists").then().extract().response();
		JsonPath jp = new JsonPath(response4.asString());
		lists = jp.get("lists");
		System.out.println(lists);
		System.out.println(response4.getBody());
	}
}
