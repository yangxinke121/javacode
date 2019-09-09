package org.learn.shiro;

import java.lang.annotation.*;

/**
 * @author: yxk
 * @date: 2019-03-23 16:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface Table {
    String value() default "";
}
