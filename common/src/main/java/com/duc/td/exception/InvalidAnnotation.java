/*
 * @created 21/04/2022 - 15:44
 * @author Duc Nguyen
 *
 */

package com.duc.td.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidAnnotation extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(InvalidAnnotation.class);

    public <T, K> InvalidAnnotation(Class<T> annotationClass, Class<K> clazz) {
        super(String.format("Not found @%s annotation on class %s", annotationClass.getSimpleName(),
                clazz.getSimpleName()));
    }
}
