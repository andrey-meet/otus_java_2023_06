package homework.framework;

import homework.SecondTestClass;
import homework.TestClass;
import java.lang.reflect.InvocationTargetException;

public class MainClass {

  public static void main(String[] args) {
    TestRunner.run(TestClass.class);
    TestRunner.run(SecondTestClass.class);
  }
}
