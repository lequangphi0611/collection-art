package com.collectionart.app.collectionart.common.transform.impl;

import com.collectionart.app.collectionart.common.transform.ParameterStringTransformer;
import com.collectionart.app.collectionart.utils.CollectionUtils;
import com.collectionart.app.collectionart.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class DefaultParameterStringTransformer implements ParameterStringTransformer {

    private static final String KEY_PATTERN = "{%s}";

    private final Map<Object, Object> parameters = new HashMap<>();

    @Override
    public ParameterStringTransformer setParameter(Object key, Object parameter) {
        this.parameters.put(key, parameter);
        return this;
    }

    @Override
    public String transform(String target) {
        return CollectionUtils.reduce(parameters.entrySet(),
                target,
                (transformed, entry)
                        -> transformed.replace(String.format(KEY_PATTERN, entry.getKey()), StringUtils.toString(entry.getValue())));
    }

}
