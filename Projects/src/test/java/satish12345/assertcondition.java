package satish12345;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class assertcondition {
  @Test(priority = 0)
  public void welcome() {
	  AssertJUnit.assertEquals("test1", "test1");
	  System.out.println("this is first case");
  }
  @Test(priority = 1, dependsOnMethods = "welcome", alwaysRun = true) 
  //when u give always run = true it will run may be the condition is true or may be the condition is false
  public void welcome1() {
	  System.out.println("this is second case");
  }
  @Test(priority = 2, dependsOnMethods = "welcome") //it depends on the welcome method
  public void welcome2() {
	  System.out.println("this is third case");
  }
  @Test
  public void welcome3() {
	  System.out.println("this is fourth case");
  }
}
