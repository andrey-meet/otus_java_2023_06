package homework.framework;

import homework.framework.exceptions.TestInvokeException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestRunner {
  public static void run(Class<?> testClass) {
    int testsWithException = 0;
    List<Method> classMethods = List.of(testClass.getMethods());
    Map<Annotations, List<Method>> annotatedMethodsMap = getAnnotatedMethods(classMethods);
    try {
      testsWithException = startTests(testClass, annotatedMethodsMap, testsWithException);
    } catch (NoSuchMethodException |
             InvocationTargetException |
             InstantiationException |
             IllegalAccessException e ) {
      System.out.printf("Can't create instance for test class  %s", testClass.getName());
    }
    testStatistics(annotatedMethodsMap, testsWithException);
  }

  private static void testStatistics(Map<Annotations, List<Method>> annotationsEnumListMap,
                                     int testsWithException) {
    int totalTests = annotationsEnumListMap.get(Annotations.TEST).size();
    int successfulTests = totalTests - testsWithException;
    System.out.println("Statistics:");
    System.out.printf(
        "TOTAL TESTS: %d, PASSED: %d, FAILED: %d%n",
        totalTests,
        successfulTests,
        testsWithException
    );
  }

  private static int startTests(Class<?> testClass,
                                Map<Annotations, List<Method>> annotationsEnumListMap,
                                int testsWithException)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException,
      IllegalAccessException {
    for (Method testMethod : annotationsEnumListMap.get(Annotations.TEST)) {
      Object newInstance = testClass.getConstructor().newInstance();
      TestHelper.invokeSupportingMethods(annotationsEnumListMap.get(Annotations.BEFORE), newInstance);
      try {
        TestHelper.invokeMethod(testMethod, newInstance);
      } catch (TestInvokeException e) {
        testsWithException++;
      }
      TestHelper.invokeSupportingMethods(annotationsEnumListMap.get(Annotations.AFTER), newInstance);
    }
    return testsWithException;
  }

  private static Map<Annotations, List<Method>> getAnnotatedMethods(List<Method> classMethods) {
    List<Annotations> annotationsList = List.of(Annotations.values());
    Map<Annotations, List<Method>> methodMap = new LinkedHashMap<>();
    for (Annotations aClass : annotationsList) {
      methodMap.put(aClass, TestHelper.findAnnotatedMethods(classMethods, aClass));
    }
    return methodMap;
  }


}
