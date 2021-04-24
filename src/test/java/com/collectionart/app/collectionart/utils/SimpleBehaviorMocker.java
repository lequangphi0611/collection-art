package com.collectionart.app.collectionart.utils;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class SimpleBehaviorMocker implements BehaviorMocker {

    private Map<String, MethodMocker> methods;

    public SimpleBehaviorMocker() {
        this.methods = new HashMap<>();
    }

    public MethodMocker getOrCreateMethodMocker(String methodName) {
        MethodMocker method = this.methods.get(methodName);
        if(Objects.nonNull(method)) {
            return method;
        }

        MethodMocker newMethod = new SimpleMethodMocker();
        this.methods.put(methodName, newMethod);
        return newMethod;
    }

   private Optional<MethodMocker> getMethodMocker(String methodName) {
        return Optional.ofNullable(this.methods.get(methodName));
    }


    protected void call(String methodName, Object... args) {
        SimpleMethodMocker method = (SimpleMethodMocker) this.getOrCreateMethodMocker(methodName);
        method.call(args);
    }

    @Override
    public MethodMocker get(String methodName) {
        MethodMocker method = this.methods.get(methodName);

        if(Objects.isNull(method)) {
            throw new RuntimeException(methodName + " is not method mocker");
        }

        return method;
    }

    @Override
    public void resetAll() {
        this.methods.forEach((String methodName, MethodMocker methodMocker) -> {
            methodMocker.reset();
        });
    }

    @Override
    public void reset(String methodName) {
        this.getMethodMocker(methodName).ifPresent((mocker) -> mocker.reset());
    }
}
