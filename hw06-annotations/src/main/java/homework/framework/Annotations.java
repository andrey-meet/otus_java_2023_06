package homework.framework;

import java.lang.annotation.Annotation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Annotations {
  BEFORE(Before.class),
  TEST(Test.class),
  AFTER(After.class);

  private final Class<? extends Annotation> annotationClass;
}
