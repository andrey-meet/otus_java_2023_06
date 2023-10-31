package homework;

import homework.framework.After;
import homework.framework.Before;
import homework.framework.Test;
import lombok.SneakyThrows;

public class SecondTestClass {
  private int a;
  private int b;
  private int c;

  @Before
  public void firstBeforeMethod() {
    System.out.println("First before method started for second class");
    a = 1;
    b = 2;
  }

  @Before
  public void secondBeforeMethod(){
    System.out.println("Second before method started for second class");
    c = 0;
  }

  @After
  public void afterMethod(){
    System.out.println("After method started for second class");
  }

  @SneakyThrows
  @Test(description = "simple test for second class")
  public void sumMethod() {
    throw new NoSuchMethodException();
  }

  @SneakyThrows
  @Test(description = "simple test  for second class")
  public void methodWithException() {
    int sum = b/c + a;
    System.out.println("Second test method result for second class: " + sum);
  }
}
