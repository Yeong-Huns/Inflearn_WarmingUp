package src.java.main.Annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CalCulator {
    String value() default "ADD";
}
