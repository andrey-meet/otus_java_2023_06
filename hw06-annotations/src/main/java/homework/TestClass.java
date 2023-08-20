package homework;

import homework.framework.After;
import homework.framework.Before;
import homework.framework.Test;

public class TestClass {

  private int a;
  private int b;
  private int c;

  @Before
  public void firstBeforeMethod() {
    System.out.println("First before method started");
    a = 1;
    b = 2;
  }

  @Before
  public void secondBeforeMethod2(){
    System.out.println("Second before method started");
    c = 0;
  }

  @After
  public void afterMethod(){
    System.out.println("After method started");
  }

  @Test(description = "simple test")
  public void sumMethod() {
    int sum = a + b;
    System.out.println("First test method result: " + sum);
  }

  @Test(description = "simple test")
  public void methodWithException() throws ArithmeticException{
    int sum = b/c;
    System.out.println("Second test method result: " + sum);
  }
}
