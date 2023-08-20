package homework.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class TestHelper {

  public static void invokeMethods(List<Method> methodList, Object instance) {
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
          throw new Error(e);
        }
      }
    }
  }

  public static List<Method> sortMethodsByAnnotations(List<Method> methods, Class<? extends Annotation> annotation) {

   return methods.stream()
        .filter(testClassMethod -> testClassMethod.isAnnotationPresent(annotation))
        .toList();
  }

}
