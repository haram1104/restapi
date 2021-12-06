// JUnit 4를 사용하는 경우 사용하는 Test Description 어노테이션. JUnit5는 DisplayName 어노테이션을 사용하면 된다
package me.haram.demoinflearnrestapi.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface TestDescription {

    String value();
}
