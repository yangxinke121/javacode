package org.learn.shiro;

import java.lang.annotation.*;

/**
 * @author: yxk
 * @date: 2019-03-23 16:19
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Column {
    String value();
}
