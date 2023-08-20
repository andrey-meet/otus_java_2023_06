package homework.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TestRunner {

  public static void run(Class<?> testClass)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException,
      IllegalAccessException {
    Object newInstance = testClass.getConstructor().newInstance();
    List<Method> classMethods = List.of(testClass.getMethods());
    List<Method> beforeMethods = TestHelper.sortMethodsByAnnotations(classMethods, Before.class);
    List<Method> testMethods = TestHelper.sortMethodsByAnnotations(classMethods, Test.class);
    List<Method> afterMethods = TestHelper.sortMethodsByAnnotations(classMethods, After.class);
    int testsWithException = 0;
      try {
        TestHelper.invokeMethods(beforeMethods, newInstance);
        TestHelper.invokeMethods(testMethods, newInstance);
      } catch (Error e) {
        testsWithException++;
      }
    TestHelper.invokeMethods(afterMethods, newInstance);
    int successfulTests = testMethods.size() - testsWithException;
    System.out.println("Statistics:");
    System.out.println(String.format("TOTAL TESTS: %d, PASSED: %d, FAILED: %d",
                                     testMethods.size(),
                                     successfulTests,
                                     testsWithException));
  }

}
