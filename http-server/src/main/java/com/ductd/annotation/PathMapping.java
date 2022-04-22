/*
 * @created 21/04/2022 - 15:29
 * @author Duc Nguyen
 *
 */

package com.ductd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PathMapping {
    String path();
    Protocol method() default Protocol.UNKNOWN;
}

