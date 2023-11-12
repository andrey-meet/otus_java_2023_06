package homework.framework.util;

import homework.framework.annotations.After;
import homework.framework.annotations.Before;
import homework.framework.annotations.Test;
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
