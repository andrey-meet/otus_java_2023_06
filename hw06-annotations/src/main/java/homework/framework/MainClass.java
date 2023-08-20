package homework.framework;

import homework.TestClass;
import java.lang.reflect.InvocationTargetException;

public class MainClass {

  public static void main(String[] args)
      throws InvocationTargetException, NoSuchMethodException, InstantiationException,
      IllegalAccessException {
    TestRunner.run(TestClass.class);
  }
}
