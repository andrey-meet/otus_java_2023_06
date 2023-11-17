package homework.framework.util;

import homework.framework.exceptions.TestInvokeException;
import java.lang.reflect.Method;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestHelper {

  public static void invokeSupportingMethods(List<Method> methodList, Object instance)
      throws TestInvokeException {
    if (!methodList.isEmpty()) {
      for (Method method : methodList) {
        try {
          method.invoke(instance);
        } catch (Exception e) {
          System.out.println("Method " +
                             method.getName() +
                             " threw exception: " +
                             e.getCause() +
                             ": " +
                             e.getMessage());
        }
      }
    }
  }

  public static void invokeMethod(Method method, Object instance)
      throws TestInvokeException {
    try {
      method.invoke(instance);
    } catch (Exception e) {
      System.out.println("Method " +
                         method.getName() +
                         " threw exception: " +
                         e.getCause() +
                         ": " +
                         e.getMessage());
      throw new TestInvokeException(e.getMessage());
    }
  }

  public static List<Method> findAnnotatedMethods(List<Method> methods, Annotations annotation) {
   return methods.stream()
        .filter(testClassMethod -> testClassMethod.isAnnotationPresent(annotation.getAnnotationClass()))
        .toList();
  }

}
