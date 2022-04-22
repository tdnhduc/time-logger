/*
 * @created 21/04/2022 - 15:40
 * @author Duc Nguyen
 *
 */

package com.ductd.processor;

import com.duc.td.exception.InvalidAnnotation;
import com.ductd.annotation.Handler;
import com.ductd.annotation.PathMapping;
import com.ductd.annotation.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RouteAnnotationProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RouteAnnotationProcessor.class);

    private RouteAnnotationProcessor() {}

    private static final RouteAnnotationProcessor router = new RouteAnnotationProcessor();

    public static RouteAnnotationProcessor getInstance() {
        return router;
    }

    public static <T> Map<String, Method> handleRouter(T objectHandler) {
        if (!objectHandler.getClass().isAnnotationPresent(Route.class)) {
            throw new InvalidAnnotation(Route.class, objectHandler.getClass());
        }
        Map<String, Handler> pathHandler = new HashMap<>();
        for (Method method : objectHandler.getClass().getMethods()) {
            if (method.isAnnotationPresent(PathMapping.class)) {
                PathMapping pathMapping = method.getAnnotation(PathMapping.class);
                pathHandler.putIfAbsent(pathMapping.path(), Handler.of(objectHandler, method, pathMapping.method()));
            }
        }
    }
}
