package Restassured01;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class class01 {
	public String url = "https://reqres.in/api/users?page=2";
  @Test(enabled = false)
  public void testcase1() {
	  Response rep = get(url);
	  int status_code = rep.statusCode();
	  Assert.assertEquals(status_code, 201);
	  System.out.println(rep.asString());
	  System.out.println(rep.getBody());
  }
  @Test(enabled = false)
  public void testcase2() {
//	  given().get(url).then().statusCode(200).body("data.first_name", hasItems("Byron"));
	  given().get(url).then().statusCode(200).body("data.id", equalTo(20)).log().all();
  }
  @Test(enabled = false)
  public void testcase3() {
	  JSONObject js = new JSONObject();
	  js.put("name", "sathishkumar");
	  js.put("job", "TESTER");
	  given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
//	  System.out.println(js.toJSONString());
//	  System.out.println(js.toString());

  }
  @Test(enabled = false)
  public void testcase4() {
	  JSONObject js = new JSONObject();
	  js.put("name", "sathishkumar");
	  js.put("job", "TESTER");
	  given().body(js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
  }
@Test
public void testcase5() {
	  given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
}
}
