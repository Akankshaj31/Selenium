package Restassured01;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class reqresIN {
	public String url = "https://reqres.in/api/users?page=2";
	JSONObject js;
  @Test(enabled = false)
  public void testcase1() {
	  Response rep = get(url);
	  int status_code = rep.statusCode();
	  Assert.assertEquals(status_code, 200);
	  System.out.println(rep.asString());
	  System.out.println(rep.getBody());
  }
  @Test(enabled = false)
  public void getresource() {
	  baseURI= "https://reqres.in/api/users/2";
	  Response rep = get(baseURI);
//	  given().get(baseURI).then().statusCode(200).body("data.email", hasItems("janet.weaver@reqres.in"));
	  System.out.println(rep.asString());
	  given().get(baseURI).then().statusCode(200).body("data.id", equalTo(2)).log().all();
  }
  @Test(enabled = true)
  public void createresource() {
	  js = new JSONObject();
	  js.put("name", "sathishkumar");
	  js.put("job", "TESTER");
	  given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	  System.out.println(js.toJSONString()); //to print the string as in JSON format
	  System.out.println(js.toString());  //to print the string as in normal format

  }
  @Test(enabled = false)
  public void updateresource() {
	  js = new JSONObject();
	  js.put("name", "navayugan");
	  js.put("job", "CEO");
	  given().body(js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
  }
@Test(enabled = false)
public void deleteresource() {
	  given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
}
}
