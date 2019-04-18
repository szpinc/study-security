package org.szpinc.study.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author admin
 * @version 1.0.0
 * @ClassName Json.java
 * @Description TODO
 * @createTime 2019年04月17日 23:01:00
 */



@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Jsons.class)
public @interface Json {

    Class<?> type();

    String include() default "";

    String filter() default "";

}