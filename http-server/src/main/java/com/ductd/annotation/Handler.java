/*
 * @created 21/04/2022 - 22:22
 * @author Duc Nguyen
 *
 */

package com.ductd.annotation;

import java.lang.reflect.Method;

public class Handler {
    private final Method method;
    private final Protocol protocol;
    private final Object objectHandler;

    private Handler(Object objectHandler, Method method, Protocol protocol) {
        this.objectHandler = objectHandler;
        this.method = method;
        this.protocol = protocol;
    }

    public static Handler of(Object objectHandler, Method method, Protocol protocol) {
        return new Handler(objectHandler, method, protocol);
    }

    public Method getMethod() {
        return method;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public Object getObjectHandler() {
        return objectHandler;
    }
}
