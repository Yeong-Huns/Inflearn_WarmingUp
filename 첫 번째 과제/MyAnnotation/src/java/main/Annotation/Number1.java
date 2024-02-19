package src.java.main.Annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD) // 멤버 변수 선언시 사용
@Retention(RetentionPolicy.RUNTIME) //유지정책 : 런타임
public @interface Number1 {
}
