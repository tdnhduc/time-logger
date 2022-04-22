/*
 * @created 21/04/2022 - 15:37
 * @author Duc Nguyen
 *
 */

package com.ductd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Route {
    String parentPath() default "";
}
