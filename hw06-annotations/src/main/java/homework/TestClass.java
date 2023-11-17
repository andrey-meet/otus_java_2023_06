package homework;

import homework.framework.annotations.After;
import homework.framework.annotations.Before;
import homework.framework.annotations.Test;
import lombok.SneakyThrows;

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
  public void secondBeforeMethod(){
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

  @SneakyThrows
  @Test(description = "simple test")
  public void methodWithException() {
    int sum = b/c;
    System.out.println("Second test method result: " + sum);
  }
}
